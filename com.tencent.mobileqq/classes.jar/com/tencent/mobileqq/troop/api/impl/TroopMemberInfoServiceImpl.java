package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.TroopMemberUpdateObserver;
import com.tencent.mobileqq.troop.api.config.TroopCommonConfig;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.utils.TroopMemberThreadManager;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class TroopMemberInfoServiceImpl
  implements ITroopMemberInfoService
{
  static final int MAX_RUNNING_TASK_NUM = 3;
  public static final String TAG = "TroopMemberInfoService";
  protected static final int TROOP_MEMBER_INFO_MAX_SIZE_PER_TROOP = 48;
  protected static final int TROOP_UIN_QUEUE_MAX_SIZE = 12;
  protected AppRuntime app;
  protected EntityManager em;
  private TroopMemberInfoServiceImpl.SaveTroopMemberTask mCurrentSaveTask;
  private TroopObserver mGetTroopMemberListObserver = new TroopMemberInfoServiceImpl.2(this);
  protected ArrayList<TroopInfo> mGetTroopMemberListTroops = null;
  protected int mRetryGetTroopMemberListCount = 0;
  private ConcurrentLinkedQueue<TroopMemberInfoServiceImpl.SaveTroopMemberTask> mRunningTask = new ConcurrentLinkedQueue();
  private ConcurrentLinkedQueue<TroopMemberInfoServiceImpl.SaveTroopMemberTask> mSaveTroopMemberTasks = new ConcurrentLinkedQueue();
  protected Map<String, List<WeakReference<ITroopMemberInfoService.ITroopMemberInfoCallBack>>> mTmiCallBackRefMap = new HashMap(5);
  protected ArrayList<ITroopMemberInfoService.TroopMemberUpdateObserver> mTroopMemberUpdateObserverList = new ArrayList();
  private TroopMngObserver mTroopMngObserver = new TroopMemberInfoServiceImpl.1(this);
  protected LruCache<String, LruCache<String, TroopMemberInfo>> troopMembers1 = new LruCache(12);
  
  private boolean assignBigClub(int paramInt1, int paramInt2, int paramInt3, int paramInt4, TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramInt1 != -100) && (paramInt1 != paramTroopMemberInfo.mBigClubVipType))
    {
      paramTroopMemberInfo.mBigClubVipType = paramInt1;
      bool2 = true;
    }
    else
    {
      bool2 = false;
    }
    boolean bool1 = bool2;
    if (paramInt2 != -100)
    {
      bool1 = bool2;
      if (paramInt2 != paramTroopMemberInfo.mBigClubVipLevel)
      {
        paramTroopMemberInfo.mBigClubVipLevel = paramInt2;
        bool1 = true;
      }
    }
    boolean bool2 = bool1;
    if (paramInt3 != -100)
    {
      bool2 = bool1;
      if (paramInt3 != paramTroopMemberInfo.mBigClubTemplateId)
      {
        paramTroopMemberInfo.mBigClubTemplateId = paramInt3;
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (paramInt4 != -100)
    {
      bool1 = bool2;
      if (paramInt4 != paramTroopMemberInfo.mIsHideBigClub)
      {
        paramTroopMemberInfo.mIsHideBigClub = paramInt4;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean assignMemberInfo1(String paramString1, String paramString2, int paramInt, long paramLong, byte paramByte, double paramDouble, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool3 = false;
    if ((paramInt > 0) && (paramInt != paramTroopMemberInfo.level))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveTroopMemberEx: troopUin=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", memberUin=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", newTitleId=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", oldTitleId=");
        localStringBuilder.append(paramTroopMemberInfo.level);
        QLog.d("TroopMemberInfoService", 2, localStringBuilder.toString());
      }
      paramTroopMemberInfo.level = paramInt;
      bool2 = true;
    }
    else
    {
      bool2 = false;
    }
    boolean bool1 = bool2;
    if (paramLong != -100L)
    {
      bool1 = bool2;
      if (paramLong != paramTroopMemberInfo.gagTimeStamp)
      {
        paramTroopMemberInfo.gagTimeStamp = paramLong;
        bool1 = true;
      }
    }
    if (paramByte == 1) {
      bool3 = true;
    }
    boolean bool2 = bool1;
    if (paramByte != -100)
    {
      bool2 = bool1;
      if (paramTroopMemberInfo.isTroopFollowed != bool3)
      {
        paramTroopMemberInfo.isTroopFollowed = bool3;
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (paramDouble != -100.0D)
    {
      bool1 = bool2;
      if (paramDouble != paramTroopMemberInfo.distanceToSelf)
      {
        paramTroopMemberInfo.distanceToSelf = paramDouble;
        paramTroopMemberInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean assignMemberInfo2(String paramString, int paramInt, long paramLong1, long paramLong2, TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramString != null) && (!paramString.equals(paramTroopMemberInfo.mUniqueTitle)))
    {
      paramTroopMemberInfo.mUniqueTitle = paramString;
      bool2 = true;
    }
    else
    {
      bool2 = false;
    }
    boolean bool1 = bool2;
    if (paramInt != -100)
    {
      bool1 = bool2;
      if (paramInt != paramTroopMemberInfo.realLevel)
      {
        paramTroopMemberInfo.realLevel = paramInt;
        bool1 = true;
      }
    }
    boolean bool2 = bool1;
    if (paramLong1 != -100L)
    {
      bool2 = bool1;
      if (paramLong1 != paramTroopMemberInfo.join_time)
      {
        paramTroopMemberInfo.join_time = paramLong1;
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (paramLong2 != -100L)
    {
      bool1 = bool2;
      if (paramLong2 != paramTroopMemberInfo.last_active_time)
      {
        paramTroopMemberInfo.last_active_time = paramLong2;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean assignMemberInfo3(long paramLong, int paramInt1, int paramInt2, int paramInt3, TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramLong != -100L) {
      paramTroopMemberInfo.msgseq = paramLong;
    }
    boolean bool1;
    if ((paramInt1 != -100) && (paramInt1 != paramTroopMemberInfo.age))
    {
      paramTroopMemberInfo.age = ((byte)paramInt1);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (paramInt2 != -100)
    {
      bool2 = bool1;
      if (paramInt2 != paramTroopMemberInfo.sex)
      {
        paramTroopMemberInfo.sex = ((byte)paramInt2);
        bool2 = true;
      }
    }
    if ((paramInt3 != -100) && (paramInt3 != paramTroopMemberInfo.distance))
    {
      paramTroopMemberInfo.distance = paramInt3;
      return true;
    }
    return bool2;
  }
  
  private boolean assignNick(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    String str;
    if (paramString1 == null) {
      str = null;
    } else {
      str = removeColorNickChar(paramString1);
    }
    if ((paramString1 != null) && (!paramString1.equals(paramTroopMemberInfo.troopColorNick)))
    {
      paramTroopMemberInfo.troopColorNick = paramString1;
      bool2 = true;
    }
    else
    {
      bool2 = false;
    }
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(paramTroopMemberInfo.troopnick))
      {
        paramTroopMemberInfo.troopnick = str;
        bool1 = true;
      }
    }
    boolean bool2 = bool1;
    if (paramString2 != null)
    {
      bool2 = bool1;
      if (!paramString2.equals(paramTroopMemberInfo.friendnick))
      {
        paramTroopMemberInfo.friendnick = paramString2;
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean assignNickNameId(int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    if ((-100 != paramInt) && (paramInt != paramTroopMemberInfo.troopColorNickId))
    {
      paramTroopMemberInfo.troopColorNickId = paramInt;
      return true;
    }
    return false;
  }
  
  private boolean assignVip(int paramInt1, int paramInt2, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool1;
    if ((paramInt1 != -100) && (paramInt1 != paramTroopMemberInfo.mVipType))
    {
      paramTroopMemberInfo.mVipType = paramInt1;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (paramInt2 != -100)
    {
      bool2 = bool1;
      if (paramInt2 != paramTroopMemberInfo.mVipLevel)
      {
        paramTroopMemberInfo.mVipLevel = paramInt2;
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private void deleteTroopMemberInLruCache(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = (LruCache)this.troopMembers1.get(paramString1);
      if (paramString1 != null) {
        paramString1.remove(paramString2);
      }
    }
  }
  
  private void deleteTroopMembersInLruCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.troopMembers1.remove(paramString);
  }
  
  private void handleOnTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (paramInt1 != 2)
    {
      if (paramInt1 != 3)
      {
        if ((paramInt1 != 4) && (paramInt1 != 6))
        {
          if (paramInt1 == 9) {
            break label200;
          }
          return;
        }
        localObject = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
        if ((localObject == null) || (!TroopCommonConfig.a(this.app, (TroopInfo)localObject, true))) {
          return;
        }
        TroopMemberListHandler localTroopMemberListHandler = (TroopMemberListHandler)((AppInterface)this.app).getBusinessHandler(TroopMemberListHandler.class.getName());
        if (localTroopMemberListHandler == null) {
          return;
        }
        try
        {
          if (this.mGetTroopMemberListTroops == null)
          {
            this.mGetTroopMemberListTroops = new ArrayList();
            this.mGetTroopMemberListTroops.add(localObject);
            localTroopMemberListHandler.a(true, paramString, ((TroopInfo)localObject).troopcode, 9);
          }
          else
          {
            this.mGetTroopMemberListTroops.add(localObject);
          }
          return;
        }
        finally {}
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate((ArrayList)localObject);
      return;
    }
    label200:
    ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).notifyQuitTroop(paramString);
    try
    {
      if (this.mGetTroopMemberListTroops != null)
      {
        localObject = this.mGetTroopMemberListTroops.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((TroopInfo)((Iterator)localObject).next()).troopuin.equals(paramString)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      return;
    }
    finally
    {
      for (;;)
      {
        throw paramString;
      }
    }
  }
  
  private void handleOnUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onUpdateTroopGetMemberList(memberLimit), troopUin:");
      paramList.append(paramString);
      paramList.append(", mGetTroopMemberListTroops == null:");
      boolean bool;
      if (this.mGetTroopMemberListTroops == null) {
        bool = true;
      } else {
        bool = false;
      }
      paramList.append(bool);
      QLog.i("TroopMemberInfoService", 2, paramList.toString());
    }
    paramList = new ArrayList();
    paramList.add(paramString);
    Object localObject = this.mGetTroopMemberListTroops;
    if (localObject == null)
    {
      ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate(paramList);
      return;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = (TroopInfo)this.mGetTroopMemberListTroops.get(0);
      if (!((TroopInfo)localObject).troopuin.equals(paramString)) {
        return;
      }
      TroopMemberListHandler localTroopMemberListHandler = (TroopMemberListHandler)((AppInterface)this.app).getBusinessHandler(TroopMemberListHandler.class.getName());
      if (!paramBoolean)
      {
        paramInt1 = this.mRetryGetTroopMemberListCount;
        this.mRetryGetTroopMemberListCount = (paramInt1 + 1);
        if ((paramInt1 < 3) && (localTroopMemberListHandler != null))
        {
          localTroopMemberListHandler.a(true, ((TroopInfo)localObject).troopuin, ((TroopInfo)localObject).troopcode, 4);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("getTroopsMemberList(memberLimit), failed, retry mRetryGetTroopMemberListCount:");
            paramString.append(this.mRetryGetTroopMemberListCount);
            paramString.append(", troopUin");
            paramString.append(((TroopInfo)localObject).troopuin);
            QLog.w("TroopMemberInfoService", 2, paramString.toString());
          }
          return;
        }
        ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).notifyGetTroopMembersFailed(paramString);
      }
      else
      {
        ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate(paramList);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("notifyTroopMembersUpdate, troopUin:");
        paramList.append(paramString);
        QLog.i("TroopMemberInfoService", 2, paramList.toString());
      }
      handlerUpdateNext();
    }
  }
  
  private void handlerUpdateNext()
  {
    try
    {
      this.mGetTroopMemberListTroops.remove(0);
      if (this.mGetTroopMemberListTroops.size() > 0)
      {
        TroopInfo localTroopInfo = (TroopInfo)this.mGetTroopMemberListTroops.get(0);
        this.mRetryGetTroopMemberListCount = 0;
        TroopMemberListHandler localTroopMemberListHandler = (TroopMemberListHandler)((AppInterface)this.app).getBusinessHandler(TroopMemberListHandler.class.getName());
        if (localTroopMemberListHandler != null) {
          localTroopMemberListHandler.a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 4);
        }
      }
      else
      {
        try
        {
          this.mGetTroopMemberListTroops = null;
          return;
        }
        finally {}
      }
      return;
    }
    finally {}
  }
  
  private static String removeColorNickChar(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '<')
      {
        int j = paramString.indexOf('>', i);
        if (j > 0) {
          i = j;
        }
      }
      else
      {
        localStringBuilder.append(paramString.charAt(i));
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, long paramLong3, long paramLong4)
  {
    return saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100, -100, -100, paramLong3, paramLong4);
  }
  
  private boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong3, long paramLong4, int paramInt12)
  {
    paramString5 = getTroopMember(paramString1, paramString2);
    boolean bool;
    if (paramString5 == null)
    {
      paramString5 = new TroopMemberInfo();
      paramString5.troopuin = paramString1;
      paramString5.memberuin = paramString2;
      paramString5.isTroopFollowed = false;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (assignNick(paramString3, paramString4, paramString5)) {
      bool = true;
    }
    if (assignNickNameId(paramInt12, paramString5)) {
      bool = true;
    }
    if (assignVip(paramInt6, paramInt7, paramString5)) {
      bool = true;
    }
    if (assignBigClub(paramInt8, paramInt9, paramInt10, paramInt11, paramString5)) {
      bool = true;
    }
    int i;
    if (assignMemberInfo1(paramString1, paramString2, paramInt1, paramLong2, paramByte, paramDouble, paramString5)) {
      i = 1;
    } else {
      i = bool;
    }
    if (assignMemberInfo2(paramString6, paramInt5, paramLong3, paramLong4, paramString5)) {
      i = 1;
    }
    if (((paramLong1 == -100L) || (paramLong1 >= paramString5.msgseq)) && (assignMemberInfo3(paramLong1, paramInt2, paramInt3, paramInt4, paramString5))) {
      i = 1;
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("saveTroopMemberEx ,");
      paramString3.append(paramString5.toString());
      QLog.d("TroopMemberInfoService", 2, paramString3.toString());
    }
    if (i != 0)
    {
      if (paramString5.getStatus() == 1000) {
        saveTroopMemberInfoInLruCache(paramString1, paramString2, paramString5);
      }
      addSaveTask(new TroopMemberInfoServiceImpl.SaveTroopMemberTask(this, paramString5, bool));
      return true;
    }
    return false;
  }
  
  private boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, long paramLong3, long paramLong4)
  {
    return saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100, -100, -100, -100, -100, -100, -100, paramLong3, paramLong4, -100);
  }
  
  public void addSaveTask(TroopMemberInfoServiceImpl.SaveTroopMemberTask paramSaveTroopMemberTask)
  {
    this.mSaveTroopMemberTasks.add(paramSaveTroopMemberTask);
    runNextSaveTask();
  }
  
  public void addTroopMemberUpdateObserver(ITroopMemberInfoService.TroopMemberUpdateObserver paramTroopMemberUpdateObserver)
  {
    try
    {
      this.mTroopMemberUpdateObserverList.add(paramTroopMemberUpdateObserver);
      return;
    }
    finally
    {
      paramTroopMemberUpdateObserver = finally;
      throw paramTroopMemberUpdateObserver;
    }
  }
  
  public boolean deleteTroopMember(String paramString1, String paramString2)
  {
    return deleteTroopMember(paramString1, paramString2, true);
  }
  
  public boolean deleteTroopMember(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteTroopMember, troopUin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",memberUin=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",updateHeadAndName=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopMemberInfoService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
    if (localObject == null) {
      return false;
    }
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(paramString1);
    if (localTroopInfo == null) {
      return false;
    }
    TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((EntityManager)localObject).find(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { paramString1, paramString2 });
    if (localTroopMemberInfo != null)
    {
      ((EntityManager)localObject).remove(localTroopMemberInfo);
      if (localTroopInfo.wMemberNum > 0) {
        localTroopInfo.wMemberNum -= 1;
      }
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(paramString2))) {
        localTroopInfo.Administrator = localTroopInfo.Administrator.replace(paramString2, "");
      }
    }
    localITroopInfoService.saveTroopInfo(localTroopInfo);
    ((EntityManager)localObject).close();
    deleteTroopMemberInLruCache(paramString1, paramString2);
    notifyKickoutMember(paramString1, paramString2);
    if (paramBoolean)
    {
      localObject = (ITroopHandlerService)this.app.getRuntimeService(ITroopHandlerService.class, "");
      if (localObject != null) {
        ((ITroopHandlerService)localObject).handleMemberExit(paramString1, paramString2);
      }
    }
    return true;
  }
  
  /* Error */
  public boolean deleteTroopMembers(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 251	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 262	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   13: invokevirtual 452	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   16: invokevirtual 458	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore_2
    //   26: aload 5
    //   28: invokevirtual 507	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   31: astore_3
    //   32: aload_3
    //   33: invokevirtual 512	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   36: aload 5
    //   38: ldc 106
    //   40: iconst_0
    //   41: ldc_w 514
    //   44: iconst_1
    //   45: anewarray 187	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 518	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +64 -> 125
    //   64: aload_2
    //   65: invokeinterface 522 1 0
    //   70: ifeq +6 -> 76
    //   73: goto +52 -> 125
    //   76: aload_2
    //   77: invokeinterface 523 1 0
    //   82: astore_2
    //   83: aload_2
    //   84: invokeinterface 322 1 0
    //   89: ifeq +21 -> 110
    //   92: aload 5
    //   94: aload_2
    //   95: invokeinterface 326 1 0
    //   100: checkcast 106	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   103: invokevirtual 469	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   106: pop
    //   107: goto -24 -> 83
    //   110: aload_3
    //   111: invokevirtual 526	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   114: aload_3
    //   115: ifnull +63 -> 178
    //   118: aload_3
    //   119: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   122: goto +56 -> 178
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   133: iconst_0
    //   134: ireturn
    //   135: astore_1
    //   136: goto +54 -> 190
    //   139: astore 4
    //   141: goto +16 -> 157
    //   144: astore_1
    //   145: aload_2
    //   146: astore_3
    //   147: goto +43 -> 190
    //   150: astore_2
    //   151: aload 4
    //   153: astore_3
    //   154: aload_2
    //   155: astore 4
    //   157: aload_3
    //   158: astore_2
    //   159: ldc 13
    //   161: iconst_2
    //   162: ldc_w 531
    //   165: aload 4
    //   167: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   178: aload 5
    //   180: invokevirtual 489	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   183: aload_0
    //   184: aload_1
    //   185: invokespecial 537	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:deleteTroopMembersInLruCache	(Ljava/lang/String;)V
    //   188: iconst_1
    //   189: ireturn
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   198: goto +5 -> 203
    //   201: aload_1
    //   202: athrow
    //   203: goto -2 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	TroopMemberInfoServiceImpl
    //   0	206	1	paramString	String
    //   25	121	2	localObject1	Object
    //   150	5	2	localException1	java.lang.Exception
    //   158	1	2	localObject2	Object
    //   31	164	3	localObject3	Object
    //   22	1	4	localObject4	Object
    //   139	13	4	localException2	java.lang.Exception
    //   155	11	4	localObject5	Object
    //   19	160	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   32	60	135	finally
    //   64	73	135	finally
    //   76	83	135	finally
    //   83	107	135	finally
    //   110	114	135	finally
    //   32	60	139	java/lang/Exception
    //   64	73	139	java/lang/Exception
    //   76	83	139	java/lang/Exception
    //   83	107	139	java/lang/Exception
    //   110	114	139	java/lang/Exception
    //   26	32	144	finally
    //   159	170	144	finally
    //   26	32	150	java/lang/Exception
  }
  
  public List<TroopMemberInfo> enhanceTroopMemberList(String paramString, List<TroopMemberInfo> paramList)
  {
    boolean bool = QLog.isColorLevel();
    int k = 0;
    Object localObject1;
    int i;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("enhanceTroopMemberList before troopUin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("  memberList.size:");
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("TroopMemberInfoService", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (paramList != null)
    {
      localObject2 = paramList;
      if (paramList.size() >= 6) {}
    }
    else
    {
      ArrayList localArrayList = getTroopMembersInLruCache(paramString);
      localObject2 = paramList;
      if (!localArrayList.isEmpty())
      {
        localObject1 = paramList;
        if (paramList == null) {
          localObject1 = new ArrayList();
        }
        i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= localArrayList.size()) {
            break;
          }
          localObject2 = localObject1;
          if (i >= 6) {
            break;
          }
          paramList = (TroopMemberInfo)localArrayList.get(i);
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject2).next();
            if ((localTroopMemberInfo != null) && (paramList != null) && (TextUtils.equals(localTroopMemberInfo.memberuin, paramList.memberuin)))
            {
              j = 1;
              break label238;
            }
          }
          int j = 0;
          label238:
          if (j == 0) {
            ((List)localObject1).add(paramList);
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("enhanceTroopMemberList after troopUin = ");
      paramList.append(paramString);
      paramList.append("  memberList.size:");
      i = k;
      if (localObject2 != null) {
        i = ((List)localObject2).size();
      }
      paramList.append(i);
      QLog.d("TroopMemberInfoService", 2, paramList.toString());
    }
    return localObject2;
  }
  
  public List<TroopMemberInfo> getAllTroopMembers(String paramString)
  {
    return this.em.query(TroopMemberInfo.class, false, "troopuin=?", new String[] { paramString }, null, null, null, null);
  }
  
  public TroopMemberInfo getTroopMember(String paramString1, String paramString2)
  {
    TroopMemberInfo localTroopMemberInfo2 = getTroopMemberInLruCache(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null) {
      localTroopMemberInfo1 = getTroopMemberInfoFromDb(paramString1, paramString2);
    }
    return localTroopMemberInfo1;
  }
  
  public TroopMemberInfo getTroopMemberInLruCache(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    TroopMemberInfo localTroopMemberInfo = null;
    if (!bool)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString1 = (LruCache)this.troopMembers1.get(paramString1);
      if (paramString1 == null) {
        return null;
      }
      localTroopMemberInfo = (TroopMemberInfo)paramString1.get(paramString2);
    }
    return localTroopMemberInfo;
  }
  
  public void getTroopMemberInfo(String paramString1, String paramString2, ITroopMemberInfoService.ITroopMemberInfoCallBack paramITroopMemberInfoCallBack)
  {
    Object localObject1;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      if (paramITroopMemberInfoCallBack != null)
      {
        localObject1 = getTroopMemberInLruCache(paramString1, paramString2);
        if (localObject1 != null)
        {
          paramITroopMemberInfoCallBack.a((TroopMemberInfo)localObject1);
          return;
        }
        paramITroopMemberInfoCallBack.a(getTroopMemberInfoFromDb(paramString1, paramString2));
      }
    }
    else
    {
      localObject1 = this.mTmiCallBackRefMap;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramString2);
      localObject2 = (List)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = getTroopMemberInLruCache(paramString1, paramString2);
        if (localObject1 != null)
        {
          if (paramITroopMemberInfoCallBack != null) {
            paramITroopMemberInfoCallBack.a((TroopMemberInfo)localObject1);
          }
          return;
        }
        localObject1 = new ArrayList();
        localObject2 = this.mTmiCallBackRefMap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        ((Map)localObject2).put(localStringBuilder.toString(), localObject1);
      }
      if (!((List)localObject1).isEmpty()) {
        break label240;
      }
      ((List)localObject1).add(new WeakReference(paramITroopMemberInfoCallBack));
      TroopMemberThreadManager.a(new TroopMemberInfoServiceImpl.4(this, paramString1, paramString2));
    }
    return;
    label240:
    ((List)localObject1).add(new WeakReference(paramITroopMemberInfoCallBack));
  }
  
  public TroopMemberInfo getTroopMemberInfoFromDb(String paramString1, String paramString2)
  {
    long l;
    if (StatisticCollector.getSqliteSwitchBySample(12)) {
      l = SystemClock.uptimeMillis();
    } else {
      l = 0L;
    }
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
    List localList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? AND memberuin=?", new String[] { paramString1, paramString2 }, null, null, null, null);
    ((EntityManager)localObject).close();
    if (l != 0L)
    {
      l = SystemClock.uptimeMillis() - l;
      HashMap localHashMap = new HashMap(10);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("param_IsMainThread", localObject);
      localHashMap.put("param_OptType", "query");
      localHashMap.put("param_bustag", "Troop");
      localHashMap.put("param_intrans", "0");
      localHashMap.put("param_OptTotalCost", String.valueOf(l));
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(this.app.getApplicationContext()).collectPerformance(null, "actFriendSqliteOpt", true, l, 0L, localHashMap, null, false);
    }
    if ((localList != null) && (localList.size() > 0))
    {
      localObject = (TroopMemberInfo)localList.get(0);
      saveTroopMemberInfoInLruCache(paramString1, paramString2, (TroopMemberInfo)localObject);
      return localObject;
    }
    return null;
  }
  
  public ArrayList<TroopMemberInfo> getTroopMembersInLruCache(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = (LruCache)this.troopMembers1.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.snapshot();
      if (paramString != null)
      {
        paramString = paramString.values().iterator();
        while (paramString.hasNext())
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramString.next();
          if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.memberuin))) {
            localArrayList.add(localTroopMemberInfo);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void getTroopsMemberList()
  {
    if (this.mGetTroopMemberListTroops != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopMemberInfoService", 2, "getTroopsMemberList(memberLimit), last getTroopsMemberList(int memberLimit) is not finished.");
      }
      return;
    }
    Object localObject2 = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopMemberInfoService", 2, "getTroopsMemberList(memberLimit), troopList is null");
      }
      return;
    }
    this.mGetTroopMemberListTroops = new ArrayList();
    TroopMemberListHandler localTroopMemberListHandler = (TroopMemberListHandler)((AppInterface)this.app).getBusinessHandler(TroopMemberListHandler.class.getName());
    int j;
    int i;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      int k = 0;
      j = 0;
      int n;
      for (i = 0; k < ((ArrayList)localObject2).size(); i = n)
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(k);
        int m = j;
        n = i;
        if (TroopCommonConfig.a(this.app, localTroopInfo, false)) {
          try
          {
            this.mGetTroopMemberListTroops.add(localTroopInfo);
            m = j + 1;
            n = i + localTroopInfo.wMemberNum;
          }
          finally {}
        }
        k += 1;
        j = m;
      }
      if ((this.mGetTroopMemberListTroops.size() > 0) && (localObject1 != null))
      {
        localObject2 = (TroopInfo)this.mGetTroopMemberListTroops.get(0);
        localObject1.a(true, ((TroopInfo)localObject2).troopuin, ((TroopInfo)localObject2).troopcode, 4);
      }
      else
      {
        this.mGetTroopMemberListTroops = null;
      }
    }
    else
    {
      this.mGetTroopMemberListTroops = null;
      j = 0;
      i = 0;
    }
    if (j > 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("reqUin", this.app.getCurrentUin());
      localHashMap.put("tpNum", String.valueOf(j));
      localHashMap.put("tpMemNum", String.valueOf(i));
      localHashMap.put("isFirst", String.valueOf(this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0)));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "tMSearchUpdateReq", false, 0L, 0L, localHashMap, "");
    }
  }
  
  public boolean isMemberInCache(String paramString1, String paramString2)
  {
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = (LruCache)this.troopMembers1.get(paramString1);
      bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (paramString1.get(paramString2) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void notifyChangeMember(String paramString1, String paramString2)
  {
    int i = 0;
    while (i < this.mTroopMemberUpdateObserverList.size())
    {
      ((ITroopMemberInfoService.TroopMemberUpdateObserver)this.mTroopMemberUpdateObserverList.get(i)).a(paramString1, paramString2);
      i += 1;
    }
  }
  
  public void notifyGetTroopMembersFailed(String paramString)
  {
    int i = 0;
    while (i < this.mTroopMemberUpdateObserverList.size())
    {
      ((ITroopMemberInfoService.TroopMemberUpdateObserver)this.mTroopMemberUpdateObserverList.get(i)).b(paramString);
      i += 1;
    }
  }
  
  public void notifyKickoutMember(String paramString1, String paramString2)
  {
    int i = 0;
    while (i < this.mTroopMemberUpdateObserverList.size())
    {
      ((ITroopMemberInfoService.TroopMemberUpdateObserver)this.mTroopMemberUpdateObserverList.get(i)).b(paramString1, paramString2);
      i += 1;
    }
  }
  
  public void notifyQuitTroop(String paramString)
  {
    int i = 0;
    while (i < this.mTroopMemberUpdateObserverList.size())
    {
      ((ITroopMemberInfoService.TroopMemberUpdateObserver)this.mTroopMemberUpdateObserverList.get(i)).a(paramString);
      i += 1;
    }
  }
  
  public void notifyTroopMembersUpdate(ArrayList<String> paramArrayList)
  {
    int i = 0;
    while (i < this.mTroopMemberUpdateObserverList.size())
    {
      ((ITroopMemberInfoService.TroopMemberUpdateObserver)this.mTroopMemberUpdateObserverList.get(i)).a(paramArrayList);
      i += 1;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.em = this.app.getEntityManagerFactory().createEntityManager();
    ((AppInterface)this.app).addObserver(this.mGetTroopMemberListObserver, true);
    ((AppInterface)this.app).addObserver(this.mTroopMngObserver, true);
  }
  
  public void onDestroy()
  {
    AppRuntime localAppRuntime = this.app;
    if (localAppRuntime != null)
    {
      ((AppInterface)localAppRuntime).removeObserver(this.mGetTroopMemberListObserver);
      ((AppInterface)this.app).removeObserver(this.mTroopMngObserver);
    }
  }
  
  public void removeTroopMemberUpdateObserver(ITroopMemberInfoService.TroopMemberUpdateObserver paramTroopMemberUpdateObserver)
  {
    try
    {
      this.mTroopMemberUpdateObserverList.remove(paramTroopMemberUpdateObserver);
      return;
    }
    finally
    {
      paramTroopMemberUpdateObserver = finally;
      throw paramTroopMemberUpdateObserver;
    }
  }
  
  public void runNextSaveTask()
  {
    if (this.mRunningTask.size() >= 3) {
      return;
    }
    if (!this.mSaveTroopMemberTasks.isEmpty())
    {
      TroopMemberInfoServiceImpl.SaveTroopMemberTask localSaveTroopMemberTask = (TroopMemberInfoServiceImpl.SaveTroopMemberTask)this.mSaveTroopMemberTasks.poll();
      if (localSaveTroopMemberTask != null)
      {
        this.mCurrentSaveTask = localSaveTroopMemberTask;
        this.mRunningTask.add(localSaveTroopMemberTask);
        ThreadManager.excute(localSaveTroopMemberTask, 32, null, false);
      }
    }
  }
  
  public void saveTroopMember(TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    if (paramTroopMemberInfo.getStatus() == 1000) {
      saveTroopMemberInfoInLruCache(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin, paramTroopMemberInfo);
    }
    addSaveTask(new TroopMemberInfoServiceImpl.SaveTroopMemberTask(this, paramTroopMemberInfo, paramBoolean));
  }
  
  public boolean saveTroopMember(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    return saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, (byte)-100, paramLong2, -100.0D, -100L, -100L);
  }
  
  public void saveTroopMemberCmduinFlagEx3(String paramString1, String paramString2, long paramLong)
  {
    Object localObject2 = getTroopMember(paramString1, paramString2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TroopMemberInfo();
      ((TroopMemberInfo)localObject1).memberuin = paramString2;
      ((TroopMemberInfo)localObject1).troopuin = paramString1;
    }
    ((TroopMemberInfo)localObject1).cmduinFlagEx3Grocery = paramLong;
    localObject2 = this.app.getEntityManagerFactory().createEntityManager();
    if (((TroopMemberInfo)localObject1).getStatus() == 1000)
    {
      saveTroopMemberInfoInLruCache(paramString1, paramString2, (TroopMemberInfo)localObject1);
      ((EntityManager)localObject2).persistOrReplace((Entity)localObject1);
    }
    else
    {
      ((EntityManager)localObject2).update((Entity)localObject1);
    }
    ((EntityManager)localObject2).close();
  }
  
  public boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble)
  {
    return saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100, -100, -100, -100L, -100L);
  }
  
  public boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    return saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, paramString6, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, -100L, -100L, paramInt12);
  }
  
  public boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5)
  {
    return saveTroopMemberEx(paramString1, paramString2, paramString3, -100, paramString4, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D, null, -100, -100, -100, -100, -100, -100, -100, paramInt5);
  }
  
  public void saveTroopMemberInfoInLruCache(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      LruCache localLruCache2 = (LruCache)this.troopMembers1.get(paramString1);
      LruCache localLruCache1 = localLruCache2;
      if (localLruCache2 == null) {
        localLruCache1 = new LruCache(48);
      }
      localLruCache1.put(paramString2, paramTroopMemberInfo);
      this.troopMembers1.put(paramString1, localLruCache1);
    }
  }
  
  public void saveTroopMemberInfoToDB(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null) {
      return;
    }
    ThreadManager.post(new TroopMemberInfoServiceImpl.3(this, paramTroopMemberInfo, new Handler(Looper.getMainLooper()), paramString1, paramString2), 8, null, false);
  }
  
  /* Error */
  public boolean saveTroopMembers(List<TroopMemberInfo> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: ifnull +444 -> 450
    //   9: aload_1
    //   10: invokeinterface 522 1 0
    //   15: ifeq +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 819	java/util/HashSet
    //   23: dup
    //   24: invokespecial 820	java/util/HashSet:<init>	()V
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 6
    //   35: iload 4
    //   37: istore_2
    //   38: aload_0
    //   39: getfield 560	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: invokevirtual 507	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   45: astore 7
    //   47: aload 7
    //   49: astore 6
    //   51: iload 4
    //   53: istore_2
    //   54: aload 7
    //   56: astore 5
    //   58: aload 7
    //   60: invokevirtual 512	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   63: aload 7
    //   65: astore 6
    //   67: iload 4
    //   69: istore_2
    //   70: aload 7
    //   72: astore 5
    //   74: aload_1
    //   75: invokeinterface 523 1 0
    //   80: astore_1
    //   81: aload 7
    //   83: astore 6
    //   85: iload_3
    //   86: istore_2
    //   87: aload 7
    //   89: astore 5
    //   91: aload_1
    //   92: invokeinterface 322 1 0
    //   97: ifeq +262 -> 359
    //   100: aload 7
    //   102: astore 6
    //   104: iload_3
    //   105: istore_2
    //   106: aload 7
    //   108: astore 5
    //   110: aload_1
    //   111: invokeinterface 326 1 0
    //   116: checkcast 106	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   119: astore 9
    //   121: aload 7
    //   123: astore 6
    //   125: iload_3
    //   126: istore_2
    //   127: aload 7
    //   129: astore 5
    //   131: new 131	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   138: astore 10
    //   140: aload 7
    //   142: astore 6
    //   144: iload_3
    //   145: istore_2
    //   146: aload 7
    //   148: astore 5
    //   150: aload 10
    //   152: aload 9
    //   154: getfield 393	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   157: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 7
    //   163: astore 6
    //   165: iload_3
    //   166: istore_2
    //   167: aload 7
    //   169: astore 5
    //   171: aload 10
    //   173: ldc_w 587
    //   176: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 7
    //   182: astore 6
    //   184: iload_3
    //   185: istore_2
    //   186: aload 7
    //   188: astore 5
    //   190: aload 10
    //   192: aload 9
    //   194: getfield 396	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   197: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 7
    //   203: astore 6
    //   205: iload_3
    //   206: istore_2
    //   207: aload 7
    //   209: astore 5
    //   211: aload 10
    //   213: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore 10
    //   218: aload 7
    //   220: astore 6
    //   222: iload_3
    //   223: istore_2
    //   224: aload 7
    //   226: astore 5
    //   228: aload 9
    //   230: getfield 396	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   233: ldc_w 822
    //   236: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifeq +6 -> 245
    //   242: goto -161 -> 81
    //   245: aload 7
    //   247: astore 6
    //   249: iload_3
    //   250: istore_2
    //   251: aload 7
    //   253: astore 5
    //   255: iload_3
    //   256: istore 4
    //   258: aload 8
    //   260: aload 10
    //   262: invokevirtual 824	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   265: ifne +187 -> 452
    //   268: aload 7
    //   270: astore 6
    //   272: iload_3
    //   273: istore_2
    //   274: aload 7
    //   276: astore 5
    //   278: iload_3
    //   279: aload_0
    //   280: aload 9
    //   282: getfield 393	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   285: aload 9
    //   287: getfield 396	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   290: aload 9
    //   292: getfield 224	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   295: aload 9
    //   297: getfield 123	com/tencent/mobileqq/data/troop/TroopMemberInfo:level	I
    //   300: aload 9
    //   302: getfield 230	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   305: aconst_null
    //   306: aload 9
    //   308: getfield 209	com/tencent/mobileqq/data/troop/TroopMemberInfo:age	B
    //   311: aload 9
    //   313: getfield 212	com/tencent/mobileqq/data/troop/TroopMemberInfo:sex	B
    //   316: aload 9
    //   318: getfield 215	com/tencent/mobileqq/data/troop/TroopMemberInfo:distance	I
    //   321: aload 9
    //   323: getfield 205	com/tencent/mobileqq/data/troop/TroopMemberInfo:msgseq	J
    //   326: aload 9
    //   328: getfield 161	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   331: invokevirtual 826	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:saveTroopMember	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   334: ior
    //   335: istore 4
    //   337: aload 7
    //   339: astore 6
    //   341: iload 4
    //   343: istore_2
    //   344: aload 7
    //   346: astore 5
    //   348: aload 8
    //   350: aload 10
    //   352: invokevirtual 827	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   355: pop
    //   356: goto +96 -> 452
    //   359: aload 7
    //   361: astore 6
    //   363: iload_3
    //   364: istore_2
    //   365: aload 7
    //   367: astore 5
    //   369: aload 7
    //   371: invokevirtual 526	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   374: iload_3
    //   375: istore 4
    //   377: aload 7
    //   379: ifnull +56 -> 435
    //   382: aload 7
    //   384: astore 5
    //   386: iload_3
    //   387: istore_2
    //   388: aload 5
    //   390: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   393: iload_2
    //   394: ireturn
    //   395: astore_1
    //   396: goto +42 -> 438
    //   399: astore_1
    //   400: aload 5
    //   402: astore 6
    //   404: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +17 -> 424
    //   410: aload 5
    //   412: astore 6
    //   414: ldc 13
    //   416: iconst_2
    //   417: aload_1
    //   418: invokestatic 831	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   421: invokestatic 833	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: iload_2
    //   425: istore 4
    //   427: aload 5
    //   429: ifnull +6 -> 435
    //   432: goto -44 -> 388
    //   435: iload 4
    //   437: ireturn
    //   438: aload 6
    //   440: ifnull +8 -> 448
    //   443: aload 6
    //   445: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   448: aload_1
    //   449: athrow
    //   450: iconst_0
    //   451: ireturn
    //   452: iload 4
    //   454: istore_3
    //   455: goto -374 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	TroopMemberInfoServiceImpl
    //   0	458	1	paramList	List<TroopMemberInfo>
    //   37	388	2	bool1	boolean
    //   4	451	3	bool2	boolean
    //   1	452	4	bool3	boolean
    //   30	398	5	localObject1	Object
    //   33	411	6	localObject2	Object
    //   45	338	7	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   27	322	8	localHashSet	java.util.HashSet
    //   119	208	9	localTroopMemberInfo	TroopMemberInfo
    //   138	213	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   38	47	395	finally
    //   58	63	395	finally
    //   74	81	395	finally
    //   91	100	395	finally
    //   110	121	395	finally
    //   131	140	395	finally
    //   150	161	395	finally
    //   171	180	395	finally
    //   190	201	395	finally
    //   211	218	395	finally
    //   228	242	395	finally
    //   258	268	395	finally
    //   278	337	395	finally
    //   348	356	395	finally
    //   369	374	395	finally
    //   404	410	395	finally
    //   414	424	395	finally
    //   38	47	399	java/lang/Throwable
    //   58	63	399	java/lang/Throwable
    //   74	81	399	java/lang/Throwable
    //   91	100	399	java/lang/Throwable
    //   110	121	399	java/lang/Throwable
    //   131	140	399	java/lang/Throwable
    //   150	161	399	java/lang/Throwable
    //   171	180	399	java/lang/Throwable
    //   190	201	399	java/lang/Throwable
    //   211	218	399	java/lang/Throwable
    //   228	242	399	java/lang/Throwable
    //   258	268	399	java/lang/Throwable
    //   278	337	399	java/lang/Throwable
    //   348	356	399	java/lang/Throwable
    //   369	374	399	java/lang/Throwable
  }
  
  public void updateTroopMemberCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = (LruCache)this.troopMembers1.get(paramString);
    if (paramString != null) {
      paramString.evictAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */