package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.OnGetReminderFromDBFinishListener;
import com.tencent.mobileqq.reminder.OnGetReminderListByDayListener;
import com.tencent.mobileqq.reminder.QQNotifyListener;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.IReminderEntity;
import com.tencent.mobileqq.reminder.biz.entity.ReminderEntity;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class QQReminderDataServiceImpl
  implements IQQReminderDataService
{
  private static final int CACHE_ADD = 1;
  private static final int CACHE_CLEAR_TIME = 3;
  private static final int CACHE_DELETE = 0;
  private static final int CACHE_UPDATE = 2;
  private static final String SP_KEY_CACHE_LIST_TIME = "sp_key_cache_list_time";
  private static final String SP_KEY_FETCH_REMINDER_LIST_TIME = "sp_key_new_fetch_reminder_list_time";
  public static final String TAG = "ReminderDataManagerNew";
  private volatile AtomicBoolean initFlag = new AtomicBoolean(false);
  private AppRuntime mApp;
  private EntityManager mEntityManager;
  private IQQReminderAlarmService mNotificationAlarmManager;
  private QQNotifyListener mQQNotifyListener;
  private SharedPreferences mSharedPreferences;
  private volatile ConcurrentHashMap<String, ReminderEntity> todayReminderCache;
  
  private void addReminderMsg(AcsMsg paramAcsMsg)
  {
    ReminderEntity localReminderEntity = new ReminderEntity();
    localReminderEntity.setAcsMsg(paramAcsMsg);
    this.mEntityManager.persistOrReplace(localReminderEntity);
    if (!containMsg(QQReminderUtil.a(paramAcsMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "save Reminder Msg cache not contain, need save, msgId: ", paramAcsMsg.msg_id });
      }
      updateCache(paramAcsMsg, 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "save Reminder Msg cache contain, do not save, msgId: ", paramAcsMsg.msg_id });
    }
    updateCache(paramAcsMsg, 2);
  }
  
  private void addToMessageFacade(String paramString1, String paramString2)
  {
    IMessageFacade localIMessageFacade = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    if (localIMessageFacade == null) {}
    do
    {
      return;
      paramString1 = localIMessageFacade.constructMessageForText(paramString1, paramString2, QQConstants.a, 9002);
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "---doNotifaction---" + paramString2 + this.mApp.getAccount());
      }
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      localIMessageFacade.addMessage(paramString2, this.mApp.getAccount());
      localIMessageFacade.handleReceivedMessage(1, true, true);
      ((IAppBadgeService)this.mApp.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    } while (!QLog.isColorLevel());
    QLog.d("ReminderDataManagerNew", 2, "do report : QQnotice.list.show");
  }
  
  private void addToMsgTab(String paramString1, String paramString2)
  {
    ReminderEntity localReminderEntity = (ReminderEntity)this.todayReminderCache.get(paramString2);
    if (localReminderEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, "addToMsgTab, not found msgId");
      }
      addToMessageFacade(paramString1, paramString2);
    }
    do
    {
      return;
      if ((localReminderEntity.getAcsMsg().type != 0) || (!this.mSharedPreferences.getBoolean(paramString2 + this.mApp.getAccount(), false))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReminderDataManagerNew", 2, new Object[] { "msgId: ", paramString2, " have Reminded!" });
    return;
    if (localReminderEntity.getAcsMsg().type == 0) {
      this.mSharedPreferences.edit().putBoolean(paramString2 + this.mApp.getAccount(), true).apply();
    }
    addToMessageFacade(paramString1, QQReminderUtil.a(localReminderEntity.getAcsMsg()));
  }
  
  private boolean containMsg(long paramLong)
  {
    if (this.todayReminderCache != null)
    {
      Iterator localIterator = this.todayReminderCache.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).hashCode() == paramLong) {
          return true;
        }
      }
    }
    return false;
  }
  
  private int deleteExpiredReminderMsg(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "delete expired reminder msg -> time: ", Long.valueOf(paramLong) });
    }
    AcsMsg localAcsMsg = new AcsMsg();
    localAcsMsg.notice_time = (paramLong - 1L);
    updateCache(localAcsMsg, 3);
    return this.mEntityManager.delete(ReminderEntity.class.getSimpleName(), "mReminderTime < ?", new String[] { String.valueOf(paramLong) });
  }
  
  private boolean deleteReminderMsg(String paramString, @Nullable AcsMsg paramAcsMsg)
  {
    int j = this.mEntityManager.delete(ReminderEntity.class.getSimpleName(), "mMsgId = ?", new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderMsg msgId: ", paramString, " count: ", Integer.valueOf(j) });
    }
    if (j > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((paramAcsMsg != null) && (i != 0) && (containMsg(QQReminderUtil.a(paramAcsMsg)))) {
        updateCache(paramAcsMsg, 0);
      }
      if (j <= 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private List<ReminderEntity> getReminderListById(String paramString)
  {
    return queryReminderEntity("mMsgId = ?", new String[] { paramString }, "mReminderTime");
  }
  
  private List<ReminderEntity> getReminderListByTime(long paramLong)
  {
    long l = Calendar.getInstance().getTimeZone().getRawOffset();
    return queryReminderEntity("mReminderTime >= ? and mReminderTime < ?", new String[] { String.valueOf((paramLong - 86400000L) / 1000L), String.valueOf((paramLong - paramLong % 86400000L - l + 86400000L) / 1000L) }, "mReminderTime");
  }
  
  private void handleAlterDeleteFileOrException(AcsMsg paramAcsMsg)
  {
    String str;
    if ((this.mApp != null) && (paramAcsMsg != null))
    {
      str = QQReminderUtil.a(paramAcsMsg);
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "handleAlterDeleteFileOrException msgId: ", str });
      }
      if (this.mNotificationAlarmManager == null) {
        this.mNotificationAlarmManager = ((IQQReminderAlarmService)this.mApp.getRuntimeService(IQQReminderAlarmService.class, ""));
      }
      if (this.mNotificationAlarmManager == null) {
        break label193;
      }
      this.mSharedPreferences.edit().remove(str + this.mApp.getAccount()).apply();
      this.mNotificationAlarmManager.cancelAlarmById(str.hashCode());
    }
    for (;;)
    {
      IMessageFacade localIMessageFacade = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
      if (localIMessageFacade == null) {
        break;
      }
      localIMessageFacade.removeMsgByUniseq(QQConstants.a, 9002, str.hashCode());
      paramAcsMsg = (IAppBadgeService)this.mApp.getRuntimeService(IAppBadgeService.class, "");
      if (paramAcsMsg != null) {
        paramAcsMsg.refreshAppBadge();
      }
      return;
      label193:
      QQReminderUtil.a(paramAcsMsg);
    }
    QQReminderUtil.b(paramAcsMsg);
  }
  
  private void init(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mNotificationAlarmManager = ((IQQReminderAlarmService)this.mApp.getRuntimeService(IQQReminderAlarmService.class, ""));
    this.mEntityManager = getEntityManager();
    this.mSharedPreferences = getSharePref();
    initCache();
  }
  
  private void initCache()
  {
    if (this.todayReminderCache == null) {
      this.todayReminderCache = new ConcurrentHashMap(16);
    }
  }
  
  private void processMsgList(List<AcsMsg> paramList)
  {
    Object localObject1;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = (IQQReminderAlarmService)this.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
      paramList = paramList.iterator();
    }
    label139:
    label287:
    label300:
    int i;
    int j;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject2 = (AcsMsg)paramList.next();
        if (((AcsMsg)localObject2).notice_time > NetConnInfoCenter.getServerTime())
        {
          if (localObject1 != null) {
            ((IQQReminderAlarmService)localObject1).setAlarmTimer((AcsMsg)localObject2);
          }
        }
        else
        {
          boolean bool1;
          IQQActivateFriendService localIQQActivateFriendService;
          if ((this.mSharedPreferences.getBoolean(((AcsMsg)localObject2).msg_id + this.mApp.getAccount(), false)) || (((AcsMsg)localObject2).type == 1))
          {
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.d("ReminderDataManagerNew", 2, " has notifaction: " + bool1 + " key: " + ((AcsMsg)localObject2).msg_id + this.mApp.getAccount());
            }
            localIQQActivateFriendService = (IQQActivateFriendService)this.mApp.getRuntimeService(IQQActivateFriendService.class, "");
            if (localIQQActivateFriendService != null) {
              break label287;
            }
          }
          for (boolean bool2 = false;; bool2 = localIQQActivateFriendService.getSwitchValue(true))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReminderDataManagerNew", 2, " isSettingOpen: " + bool2);
            }
            if ((bool1) || (!bool2)) {
              break label300;
            }
            doNotifaction(((AcsMsg)localObject2).title, QQReminderUtil.a((AcsMsg)localObject2));
            break;
            bool1 = false;
            break label139;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ReminderDataManagerNew", 2, "the msg " + ((AcsMsg)localObject2).title + " has notifaction!!!");
            continue;
            paramList = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
            if (paramList != null)
            {
              localObject1 = paramList.getMsgList(QQConstants.a, 9002);
              if (localObject1 != null)
              {
                i = ((List)localObject1).size();
                j = i;
                if (localObject1 == null) {
                  break label490;
                }
                j = i;
                if (((List)localObject1).isEmpty()) {
                  break label490;
                }
                localObject1 = ((List)localObject1).iterator();
                label419:
                if (!((Iterator)localObject1).hasNext()) {
                  break label488;
                }
                localObject2 = (Entity)((Iterator)localObject1).next();
                if ((!paramList.isMessageForText((Entity)localObject2)) || (containMsg(paramList.getMsgUinSeq((Entity)localObject2)))) {
                  break label496;
                }
                paramList.removeMsgByMessageRecord((Entity)localObject2, true);
                i -= 1;
              }
            }
          }
        }
      }
    }
    label488:
    label490:
    label496:
    for (;;)
    {
      break label419;
      i = 0;
      break;
      j = i;
      updateTab(j);
      return;
    }
  }
  
  private void pullTodayMsgList(boolean paramBoolean, QQReminderDataServiceImpl.AfterPull paramAfterPull)
  {
    try
    {
      str1 = QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList currenDayTimeStapStr: " + str1);
      }
      str2 = this.mSharedPreferences.getString("sp_key_new_fetch_reminder_list_time", "");
      if (QLog.isColorLevel()) {
        QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList cacheCurrenDayTimeStapStr: " + str2);
      }
    }
    catch (Throwable paramAfterPull)
    {
      String str1;
      String str2;
      long l2;
      label151:
      QLog.e("ReminderDataManagerNew", 1, "checkTodayReminder throw an exception: " + paramAfterPull);
    }
    try
    {
      l2 = Long.parseLong(this.mApp.getAccount()) % 3600L * 1000L;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList delay: " + l2);
        l1 = l2;
      }
    }
    catch (Exception localException)
    {
      l1 = 0L;
      break label151;
    }
    l2 = NetConnInfoCenter.getServerTimeMillis();
    l1 += QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList currentDelayTs: " + QQReminderUtil.a(l1, "yyyy-MM-dd HH:mm:ss"));
    }
    if ((!paramBoolean) && ((str1.equals(str2)) || (l2 < l1)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReminderDataManagerNew", 2, "already fetch today's data");
      }
    }
    else
    {
      getReminderListByday(str1, new QQReminderDataServiceImpl.10(this, str1, paramAfterPull));
      return;
    }
  }
  
  private List queryReminderEntity(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return this.mEntityManager.query(ReminderEntity.class, ReminderEntity.class.getSimpleName(), false, paramString1, paramArrayOfString, null, null, paramString2, null);
  }
  
  private void resetCache()
  {
    String str1 = QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
    String str2 = this.mSharedPreferences.getString("sp_key_cache_list_time", "");
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "cur: ", str1, " cache: ", str2 });
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.todayReminderCache.entrySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      AcsMsg localAcsMsg = ((ReminderEntity)((Map.Entry)localObject3).getValue()).getAcsMsg();
      if (localAcsMsg.type == 0)
      {
        if (!QQReminderUtil.a(localAcsMsg.notice_time * 1000L)) {
          ((ArrayList)localObject1).add(((Map.Entry)localObject3).getKey());
        }
      }
      else if ((localAcsMsg.type == 1) && (l - localAcsMsg.notice_time > 86400L)) {
        ((ArrayList)localObject1).add(((Map.Entry)localObject3).getKey());
      }
    }
    localObject2 = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      this.todayReminderCache.remove(localObject3);
      if (localObject2 != null) {
        ((IMessageFacade)localObject2).removeMsgByUniseq(QQConstants.a, 9002, ((String)localObject3).hashCode());
      }
    }
    if (localObject2 != null) {}
    for (localObject1 = ((IMessageFacade)localObject2).getMsgList(QQConstants.a, 9002);; localObject1 = null)
    {
      if (localObject1 != null) {
        updateTab(((List)localObject1).size());
      }
      if (!str1.equals(str2))
      {
        this.mSharedPreferences.edit().putString("sp_key_cache_list_time", QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd")).apply();
        if (Looper.myLooper() == Looper.getMainLooper()) {
          runAtOtherThread(new QQReminderDataServiceImpl.1(this));
        }
      }
      else
      {
        return;
      }
      deleteExpiredReminderMsg(NetConnInfoCenter.getServerTime() - 86400L);
      return;
    }
  }
  
  private void runAtOtherThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManagerV2.excute(paramRunnable, 32, null, true);
      return;
    }
    paramRunnable.run();
  }
  
  private void updateCache(AcsMsg paramAcsMsg, int paramInt)
  {
    if (((paramAcsMsg.type == 0) && (!QQReminderUtil.a(paramAcsMsg.notice_time * 1000L))) || ((paramAcsMsg.type == 1) && (paramAcsMsg.notice_time - NetConnInfoCenter.getServerTime() > 86400L))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateCache msg notice time is not today: ", Long.valueOf(paramAcsMsg.notice_time) });
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = QQReminderUtil.a(paramAcsMsg);
      if ((this.todayReminderCache == null) || (localObject1 == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateCache fail -> msgId: ", localObject1 });
        }
      }
      else
      {
        Object localObject2;
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          if (this.todayReminderCache.containsKey(localObject1))
          {
            paramAcsMsg = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
            if (paramAcsMsg != null) {
              paramAcsMsg.removeMsgByUniseq(QQConstants.a, 9002, ((String)localObject1).hashCode());
            }
            this.todayReminderCache.remove(localObject1);
            return;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ReminderDataManagerNew", 1, new Object[] { "CACHE_DELETE: cache do not contain key: ", localObject1 });
            return;
          }
          break;
        case 1: 
          if (this.todayReminderCache.containsKey(localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReminderDataManagerNew", 1, new Object[] { "CACHE_ADD: cache contain key: ", localObject1 });
            }
          }
          else
          {
            localObject2 = new ReminderEntity();
            ((ReminderEntity)localObject2).setAcsMsg(paramAcsMsg);
            this.todayReminderCache.put(localObject1, localObject2);
            return;
          }
          break;
        case 2: 
          if (this.todayReminderCache.containsKey(localObject1))
          {
            localObject1 = (ReminderEntity)this.todayReminderCache.get(localObject1);
            if (localObject1 != null) {
              ((ReminderEntity)localObject1).setAcsMsg(paramAcsMsg);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("ReminderDataManagerNew", 1, new Object[] { "CACHE_UPDATE: cache do not contain key: ", localObject1 });
            return;
          }
          break;
        case 3: 
          localObject1 = this.todayReminderCache.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            if (((ReminderEntity)((Map.Entry)localObject2).getValue()).mReminderTime <= paramAcsMsg.notice_time) {
              this.todayReminderCache.remove(((Map.Entry)localObject2).getKey());
            }
          }
        }
      }
    }
  }
  
  private void updateTab(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateTab size: ", Integer.valueOf(paramInt) });
      QLog.d("ReminderDataManagerNew", 1, "stack: ", new Throwable("updateTab"));
    }
    IMessageFacade localIMessageFacade;
    Object localObject;
    if (paramInt <= 0)
    {
      localIMessageFacade = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
      if (localIMessageFacade != null)
      {
        localObject = localIMessageFacade.getMsgList(QQConstants.a, 9002);
        if (localObject != null) {
          break label89;
        }
      }
    }
    label89:
    RecentUser localRecentUser;
    do
    {
      do
      {
        return;
      } while (((List)localObject).size() > 0);
      localObject = (IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "");
      localRecentUser = ((IRecentUserProxyService)localObject).getRecentUserCache().b(QQConstants.a, 9002);
    } while (localRecentUser == null);
    ((IRecentUserProxyService)localObject).getRecentUserCache().a(localRecentUser);
    localIMessageFacade.setChangeAndNotify(localRecentUser);
  }
  
  public void checkTodayReminder()
  {
    if (this.todayReminderCache != null) {
      resetCache();
    }
    List localList;
    if ((this.todayReminderCache != null) && (this.initFlag.get()))
    {
      localList = getTodayReminderMsgFromCache();
      processMsgList(localList);
    }
    for (;;)
    {
      if (localList == null) {
        getTodayReminderMsgFromDBAsync(new QQReminderDataServiceImpl.9(this));
      }
      pullTodayMsgList(false, null);
      return;
      localList = null;
    }
  }
  
  public boolean containMsg(String paramString)
  {
    if (this.todayReminderCache != null) {
      return this.todayReminderCache.containsKey(paramString);
    }
    return false;
  }
  
  public void deleteAllReminder()
  {
    runAtOtherThread(new QQReminderDataServiceImpl.7(this));
  }
  
  public void deleteReminderByMsgId(String paramString, OnDeleteReminderFailListener paramOnDeleteReminderFailListener)
  {
    runAtOtherThread(new QQReminderDataServiceImpl.6(this, paramString, paramOnDeleteReminderFailListener));
  }
  
  public void doNotifaction(String paramString1, String paramString2)
  {
    boolean bool;
    do
    {
      try
      {
        IQQActivateFriendService localIQQActivateFriendService = (IQQActivateFriendService)this.mApp.getRuntimeService(IQQActivateFriendService.class, "");
        if (localIQQActivateFriendService == null) {
          bool = false;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ReminderDataManagerNew", 2, " isSettingOpen: " + bool);
          break;
          bool = localIQQActivateFriendService.getSwitchValue(true);
          continue;
          addToMsgTab(paramString1, paramString2);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("ReminderDataManagerNew", 1, "doNotifaction throw an exception: " + paramString1);
        return;
      }
    } while (bool);
  }
  
  public void doNotifyByPush(AcsMsg paramAcsMsg)
  {
    saveReminderMsg(paramAcsMsg);
    updateCache(paramAcsMsg, 1);
    if ((paramAcsMsg.type == 0) && (paramAcsMsg.notice_time > NetConnInfoCenter.getServerTime()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "has not arrive noticetime, set AlarmMangaer first!");
      }
      IQQReminderAlarmService localIQQReminderAlarmService = (IQQReminderAlarmService)this.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
      if (localIQQReminderAlarmService != null) {
        localIQQReminderAlarmService.setAlarmTimer(paramAcsMsg);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 2, "has arrive noticetime, doNotifaction!");
    }
    if (paramAcsMsg.type == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "[notify][push] multiple doNotifyByPush.");
      }
      if (this.mQQNotifyListener != null) {
        this.mQQNotifyListener.a(paramAcsMsg);
      }
    }
    doNotifaction(paramAcsMsg.title, QQReminderUtil.a(paramAcsMsg));
  }
  
  public List<String> getCacheKeyList()
  {
    return new ArrayList(this.todayReminderCache.keySet());
  }
  
  public IReminderEntity getEntityByKey(String paramString)
  {
    return (IReminderEntity)this.todayReminderCache.get(paramString);
  }
  
  protected EntityManager getEntityManager()
  {
    return this.mApp.getEntityManagerFactory(this.mApp.getAccount()).createEntityManager();
  }
  
  public void getReminderListByday(String paramString, OnGetReminderListByDayListener paramOnGetReminderListByDayListener)
  {
    try
    {
      IQQReminderService localIQQReminderService = (IQQReminderService)this.mApp.getRuntimeService(IQQReminderService.class, "");
      if (localIQQReminderService != null) {
        localIQQReminderService.sendReminderListByDay(paramString, new QQReminderDataServiceImpl.8(this, paramOnGetReminderListByDayListener));
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ReminderDataManagerNew", 1, paramString, new Object[0]);
    }
  }
  
  protected SharedPreferences getSharePref()
  {
    return this.mApp.getApplicationContext().getSharedPreferences("pref_act_frd" + this.mApp.getAccount(), 0);
  }
  
  public void getTodayReminderMsgAsync(OnGetReminderFromDBFinishListener paramOnGetReminderFromDBFinishListener, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, "getTodayReminderMsgAsync...");
    }
    runAtOtherThread(new QQReminderDataServiceImpl.5(this, paramBoolean, localArrayList, paramOnGetReminderFromDBFinishListener));
  }
  
  public List<AcsMsg> getTodayReminderMsgFromCache()
  {
    if (this.todayReminderCache != null) {
      resetCache();
    }
    if ((this.todayReminderCache == null) || (!this.initFlag.get())) {
      return null;
    }
    Object localObject = new ArrayList(this.todayReminderCache.values());
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((ReminderEntity)((Iterator)localObject).next()).getAcsMsg());
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "getTodayReminderMsgFromCache, msg count: ", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public void getTodayReminderMsgFromDBAsync(OnGetReminderFromDBFinishListener paramOnGetReminderFromDBFinishListener)
  {
    runAtOtherThread(new QQReminderDataServiceImpl.4(this, paramOnGetReminderFromDBFinishListener));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    init(paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void saveReminderMsg(AcsMsg paramAcsMsg)
  {
    runAtOtherThread(new QQReminderDataServiceImpl.2(this, paramAcsMsg));
  }
  
  public void saveReminderMsgList(List<AcsMsg> paramList)
  {
    runAtOtherThread(new QQReminderDataServiceImpl.3(this, paramList));
  }
  
  public void setQQNotifyListener(QQNotifyListener paramQQNotifyListener)
  {
    this.mQQNotifyListener = paramQQNotifyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */