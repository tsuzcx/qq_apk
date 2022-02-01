package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
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
    if (localIMessageFacade == null) {
      return;
    }
    paramString1 = localIMessageFacade.constructMessageForText(paramString1, paramString2, QQConstants.a, 9002);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("---doNotifaction---");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(this.mApp.getAccount());
      QLog.d("ReminderDataManagerNew", 2, localStringBuilder.toString());
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    localIMessageFacade.addMessage(paramString2, this.mApp.getAccount(), this.mApp.isBackgroundStop);
    localIMessageFacade.handleReceivedMessage(1, true, true);
    ((IAppBadgeService)this.mApp.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 2, "do report : QQnotice.list.show");
    }
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
      return;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (localReminderEntity.getAcsMsg().type == 0)
    {
      localObject = this.mSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(this.mApp.getAccount());
      if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 2, new Object[] { "msgId: ", paramString2, " have Reminded!" });
        }
        return;
      }
    }
    if (localReminderEntity.getAcsMsg().type == 0)
    {
      localObject = this.mSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(this.mApp.getAccount());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), true).apply();
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
    int i;
    if (j > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramAcsMsg != null) && (i != 0) && (containMsg(QQReminderUtil.a(paramAcsMsg)))) {
      updateCache(paramAcsMsg, 0);
    }
    return j > 0;
  }
  
  private List<ReminderEntity> getReminderListByTime(long paramLong)
  {
    long l = Calendar.getInstance().getTimeZone().getRawOffset();
    return queryReminderEntity("mReminderTime >= ? and mReminderTime < ?", new String[] { String.valueOf((paramLong - 86400000L) / 1000L), String.valueOf((paramLong - (l + paramLong) % 86400000L + 86400000L) / 1000L) }, "mReminderTime");
  }
  
  private void handleAlterDeleteFileOrException(AcsMsg paramAcsMsg)
  {
    if ((this.mApp != null) && (paramAcsMsg != null))
    {
      String str = QQReminderUtil.a(paramAcsMsg);
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "handleAlterDeleteFileOrException msgId: ", str });
      }
      if (this.mNotificationAlarmManager == null) {
        this.mNotificationAlarmManager = ((IQQReminderAlarmService)this.mApp.getRuntimeService(IQQReminderAlarmService.class, ""));
      }
      if (this.mNotificationAlarmManager != null)
      {
        localObject = this.mSharedPreferences.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(this.mApp.getAccount());
        ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).apply();
        this.mNotificationAlarmManager.cancelAlarmById(str.hashCode());
      }
      else
      {
        QQReminderUtil.b(paramAcsMsg);
      }
      Object localObject = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
      if (localObject != null)
      {
        ((IMessageFacade)localObject).removeMsgByUniseq(QQConstants.a, 9002, str.hashCode());
        paramAcsMsg = (IAppBadgeService)this.mApp.getRuntimeService(IAppBadgeService.class, "");
        if (paramAcsMsg != null) {
          paramAcsMsg.refreshAppBadge();
        }
      }
      else
      {
        QQReminderUtil.c(paramAcsMsg);
      }
    }
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
    int i = 0;
    Object localObject1;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = (IQQReminderAlarmService)this.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
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
        Object localObject3 = this.mSharedPreferences;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((AcsMsg)localObject2).msg_id);
        localStringBuilder.append(this.mApp.getAccount());
        boolean bool1;
        if ((!((SharedPreferences)localObject3).getBoolean(localStringBuilder.toString(), false)) && (((AcsMsg)localObject2).type != 1)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" has notifaction: ");
          ((StringBuilder)localObject3).append(bool1);
          ((StringBuilder)localObject3).append(" key: ");
          ((StringBuilder)localObject3).append(((AcsMsg)localObject2).msg_id);
          ((StringBuilder)localObject3).append(this.mApp.getAccount());
          QLog.d("ReminderDataManagerNew", 2, ((StringBuilder)localObject3).toString());
        }
        localObject3 = (IQQActivateFriendService)this.mApp.getRuntimeService(IQQActivateFriendService.class, "");
        boolean bool2;
        if (localObject3 == null) {
          bool2 = false;
        } else {
          bool2 = ((IQQActivateFriendService)localObject3).getSwitchValue(true);
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" isSettingOpen: ");
          ((StringBuilder)localObject3).append(bool2);
          QLog.d("ReminderDataManagerNew", 2, ((StringBuilder)localObject3).toString());
        }
        if ((!bool1) && (bool2))
        {
          doNotifaction(((AcsMsg)localObject2).title, QQReminderUtil.a((AcsMsg)localObject2));
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("the msg ");
          ((StringBuilder)localObject3).append(((AcsMsg)localObject2).title);
          ((StringBuilder)localObject3).append(" has notifaction!!!");
          QLog.d("ReminderDataManagerNew", 2, ((StringBuilder)localObject3).toString());
          continue;
          paramList = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
          if (paramList != null)
          {
            localObject1 = paramList.getMsgList(QQConstants.a, 9002);
            if (localObject1 != null) {
              i = ((List)localObject1).size();
            }
            int j = i;
            if (localObject1 != null)
            {
              j = i;
              if (!((List)localObject1).isEmpty())
              {
                localObject1 = ((List)localObject1).iterator();
                for (;;)
                {
                  j = i;
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject2 = (MessageRecord)((Iterator)localObject1).next();
                  if ((paramList.isMessageForText((MessageRecord)localObject2)) && (!containMsg(paramList.getMsgUinSeq((MessageRecord)localObject2))))
                  {
                    paramList.removeMsgByMessageRecord((MessageRecord)localObject2, true);
                    i -= 1;
                  }
                }
              }
            }
            updateTab(j);
          }
        }
      }
    }
  }
  
  private void pullTodayMsgList(boolean paramBoolean, QQReminderDataServiceImpl.AfterPull paramAfterPull)
  {
    try
    {
      localObject1 = QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("pullTodayMsgList currenDayTimeStapStr: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ReminderDataManagerNew", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = this.mSharedPreferences.getString("sp_key_new_fetch_reminder_list_time", "");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pullTodayMsgList cacheCurrenDayTimeStapStr: ");
        localStringBuilder.append((String)localObject2);
        QLog.i("ReminderDataManagerNew", 2, localStringBuilder.toString());
      }
    }
    catch (Throwable paramAfterPull)
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      long l2;
      long l1;
      label184:
      label186:
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkTodayReminder throw an exception: ");
      ((StringBuilder)localObject1).append(paramAfterPull);
      QLog.e("ReminderDataManagerNew", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    try
    {
      l2 = Long.parseLong(this.mApp.getAccount()) % 3600L * 1000L;
      l1 = l2;
      if (!QLog.isColorLevel()) {
        break label186;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pullTodayMsgList delay: ");
      localStringBuilder.append(l2);
      QLog.i("ReminderDataManagerNew", 2, localStringBuilder.toString());
      l1 = l2;
    }
    catch (Exception localException)
    {
      break label184;
    }
    l1 = 0L;
    l2 = NetConnInfoCenter.getServerTimeMillis();
    l1 = QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis()) + l1;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pullTodayMsgList currentDelayTs: ");
      localStringBuilder.append(QQReminderUtil.a(l1, "yyyy-MM-dd HH:mm:ss"));
      QLog.i("ReminderDataManagerNew", 2, localStringBuilder.toString());
    }
    if ((!paramBoolean) && ((((String)localObject1).equals(localObject2)) || (l2 < l1)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReminderDataManagerNew", 2, "already fetch today's data");
      }
    }
    else
    {
      getReminderListByday((String)localObject1, new QQReminderDataServiceImpl.10(this, (String)localObject1, paramAfterPull));
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
    Object localObject2 = new ArrayList();
    Object localObject1 = this.todayReminderCache.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      AcsMsg localAcsMsg = ((ReminderEntity)((Map.Entry)localObject3).getValue()).getAcsMsg();
      if (localAcsMsg.type == 0)
      {
        if (!QQReminderUtil.b(localAcsMsg.notice_time * 1000L)) {
          ((ArrayList)localObject2).add(((Map.Entry)localObject3).getKey());
        }
      }
      else if ((localAcsMsg.type == 1) && (l - localAcsMsg.notice_time > 86400L)) {
        ((ArrayList)localObject2).add(((Map.Entry)localObject3).getKey());
      }
    }
    Object localObject3 = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.todayReminderCache.remove(localObject2);
      if (localObject3 != null) {
        ((IMessageFacade)localObject3).removeMsgByUniseq(QQConstants.a, 9002, ((String)localObject2).hashCode());
      }
    }
    localObject1 = null;
    if (localObject3 != null) {
      localObject1 = ((IMessageFacade)localObject3).getMsgList(QQConstants.a, 9002);
    }
    if (localObject1 != null) {
      updateTab(((List)localObject1).size());
    }
    if (!str1.equals(str2))
    {
      this.mSharedPreferences.edit().putString("sp_key_cache_list_time", QQReminderUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd")).apply();
      this.initFlag.set(false);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        runAtOtherThread(new QQReminderDataServiceImpl.1(this));
        return;
      }
      deleteExpiredReminderMsg(NetConnInfoCenter.getServerTime() - 86400L);
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
    if (((paramAcsMsg.type == 0) && (!QQReminderUtil.b(paramAcsMsg.notice_time * 1000L))) || ((paramAcsMsg.type == 1) && (paramAcsMsg.notice_time - NetConnInfoCenter.getServerTime() > 86400L)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateCache msg notice time is not today: ", Long.valueOf(paramAcsMsg.notice_time) });
      }
      return;
    }
    Object localObject1 = QQReminderUtil.a(paramAcsMsg);
    if ((this.todayReminderCache != null) && (localObject1 != null))
    {
      if (paramInt != 0)
      {
        Object localObject2;
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return;
            }
            localObject1 = this.todayReminderCache.entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              if (((ReminderEntity)((Map.Entry)localObject2).getValue()).mReminderTime <= paramAcsMsg.notice_time) {
                this.todayReminderCache.remove(((Map.Entry)localObject2).getKey());
              }
            }
          }
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
          }
        }
        else if (this.todayReminderCache.containsKey(localObject1))
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
        }
      }
      else
      {
        if (this.todayReminderCache.containsKey(localObject1))
        {
          paramAcsMsg = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
          if (paramAcsMsg != null) {
            paramAcsMsg.removeMsgByUniseq(QQConstants.a, 9002, ((String)localObject1).hashCode());
          }
          this.todayReminderCache.remove(localObject1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, new Object[] { "CACHE_DELETE: cache do not contain key: ", localObject1 });
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateCache fail -> msgId: ", localObject1 });
    }
  }
  
  private void updateTab(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateTab size: ", Integer.valueOf(paramInt) });
      QLog.d("ReminderDataManagerNew", 1, "stack: ", new Throwable("updateTab"));
    }
    if (paramInt <= 0)
    {
      IMessageFacade localIMessageFacade = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
      if (localIMessageFacade != null)
      {
        Object localObject = localIMessageFacade.getMsgList(QQConstants.a, 9002);
        if (localObject == null) {
          return;
        }
        if (((List)localObject).size() <= 0)
        {
          localObject = (IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "");
          RecentUser localRecentUser = ((IRecentUserProxyService)localObject).getRecentUserCache().c(QQConstants.a, 9002);
          if (localRecentUser != null)
          {
            ((IRecentUserProxyService)localObject).getRecentUserCache().a(localRecentUser);
            localIMessageFacade.setChangeAndNotify(localRecentUser);
          }
        }
      }
    }
  }
  
  public void checkTodayReminder()
  {
    if (!((IQQActivateFriendService)this.mApp.getRuntimeService(IQQActivateFriendService.class, "")).getSwitchValue(true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "checkTodayReminder: setting is close");
      }
      return;
    }
    if (this.todayReminderCache != null) {
      resetCache();
    }
    List localList;
    if ((this.todayReminderCache != null) && (this.initFlag.get()))
    {
      localList = getTodayReminderMsgFromCache();
      processMsgList(localList);
    }
    else
    {
      localList = null;
    }
    if (localList == null) {
      getTodayReminderMsgFromDBAsync(new QQReminderDataServiceImpl.9(this));
    }
    pullTodayMsgList(false, null);
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
        Object localObject = (IQQActivateFriendService)this.mApp.getRuntimeService(IQQActivateFriendService.class, "");
        if (localObject == null) {
          bool = false;
        } else {
          bool = ((IQQActivateFriendService)localObject).getSwitchValue(true);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" isSettingOpen: ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("ReminderDataManagerNew", 2, ((StringBuilder)localObject).toString());
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("doNotifaction throw an exception: ");
        paramString2.append(paramString1);
        QLog.e("ReminderDataManagerNew", 1, paramString2.toString());
        return;
      }
      addToMsgTab(paramString1, paramString2);
      return;
    } while (bool);
  }
  
  public void doNotifyByPush(AcsMsg paramAcsMsg)
  {
    saveReminderMsg(paramAcsMsg);
    updateCache(paramAcsMsg, 1);
    Object localObject;
    if ((paramAcsMsg.type == 0) && (paramAcsMsg.notice_time > NetConnInfoCenter.getServerTime()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "has not arrive noticetime, set AlarmMangaer first!");
      }
      localObject = (IQQReminderAlarmService)this.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
      if (localObject != null) {
        ((IQQReminderAlarmService)localObject).setAlarmTimer(paramAcsMsg);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "has arrive noticetime, doNotifaction!");
      }
      if (paramAcsMsg.type == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 2, "[notify][push] multiple doNotifyByPush.");
        }
        localObject = this.mQQNotifyListener;
        if (localObject != null) {
          ((QQNotifyListener)localObject).a(paramAcsMsg);
        }
      }
      doNotifaction(paramAcsMsg.title, QQReminderUtil.a(paramAcsMsg));
    }
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
    AppRuntime localAppRuntime = this.mApp;
    return localAppRuntime.getEntityManagerFactory(localAppRuntime.getAccount()).createEntityManager();
  }
  
  public List<IReminderEntity> getReminderListById(String paramString)
  {
    return queryReminderEntity("mMsgId = ?", new String[] { paramString }, "mReminderTime");
  }
  
  public void getReminderListByday(String paramString, OnGetReminderListByDayListener paramOnGetReminderListByDayListener)
  {
    try
    {
      IQQReminderService localIQQReminderService = (IQQReminderService)this.mApp.getRuntimeService(IQQReminderService.class, "");
      if (localIQQReminderService != null)
      {
        localIQQReminderService.sendReminderListByDay(paramString, new QQReminderDataServiceImpl.8(this, paramOnGetReminderListByDayListener));
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("ReminderDataManagerNew", 1, paramString, new Object[0]);
    }
  }
  
  protected SharedPreferences getSharePref()
  {
    Context localContext = this.mApp.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_act_frd");
    localStringBuilder.append(this.mApp.getAccount());
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0);
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
    if ((this.todayReminderCache != null) && (this.initFlag.get()))
    {
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
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */