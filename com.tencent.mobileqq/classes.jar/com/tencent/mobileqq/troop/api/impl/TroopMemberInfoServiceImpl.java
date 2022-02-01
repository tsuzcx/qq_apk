package com.tencent.mobileqq.troop.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.TroopMemberUpdateObserver;
import com.tencent.mobileqq.troop.api.utils.TroopMemberThreadManager;
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
  private ConcurrentLinkedQueue<TroopMemberInfoServiceImpl.SaveTroopMemberTask> mRunningTask = new ConcurrentLinkedQueue();
  private ConcurrentLinkedQueue<TroopMemberInfoServiceImpl.SaveTroopMemberTask> mSaveTroopMemberTasks = new ConcurrentLinkedQueue();
  protected Map<String, List<WeakReference<ITroopMemberInfoService.ITroopMemberInfoCallBack>>> mTmiCallBackRefMap = new HashMap(5);
  protected ArrayList<ITroopMemberInfoService.TroopMemberUpdateObserver> mTroopMemberUpdateObserverList = new ArrayList();
  protected LruCache<String, LruCache<String, TroopMemberInfo>> troopMembers1 = new LruCache(12);
  
  private boolean assignBigClub(int paramInt1, int paramInt2, int paramInt3, int paramInt4, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != -100)
    {
      bool1 = bool2;
      if (paramInt1 != paramTroopMemberInfo.mBigClubVipType)
      {
        paramTroopMemberInfo.mBigClubVipType = paramInt1;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramInt2 != -100)
    {
      bool2 = bool1;
      if (paramInt2 != paramTroopMemberInfo.mBigClubVipLevel)
      {
        paramTroopMemberInfo.mBigClubVipLevel = paramInt2;
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (paramInt3 != -100)
    {
      bool1 = bool2;
      if (paramInt3 != paramTroopMemberInfo.mBigClubTemplateId)
      {
        paramTroopMemberInfo.mBigClubTemplateId = paramInt3;
        bool1 = true;
      }
    }
    if ((paramInt4 != -100) && (paramInt4 != paramTroopMemberInfo.mIsHideBigClub))
    {
      paramTroopMemberInfo.mIsHideBigClub = paramInt4;
      return true;
    }
    return bool1;
  }
  
  private boolean assignMemberInfo1(String paramString1, String paramString2, int paramInt, long paramLong, byte paramByte, double paramDouble, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool3 = false;
    if ((paramInt > 0) && (paramInt != paramTroopMemberInfo.level))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberInfoService", 2, "saveTroopMemberEx: troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", newTitleId=" + paramInt + ", oldTitleId=" + paramTroopMemberInfo.level);
      }
      paramTroopMemberInfo.level = paramInt;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
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
      bool2 = bool3;
      if (paramByte == 1) {
        bool2 = true;
      }
      bool3 = bool1;
      if (paramByte != -100)
      {
        bool3 = bool1;
        if (paramTroopMemberInfo.isTroopFollowed != bool2)
        {
          paramTroopMemberInfo.isTroopFollowed = bool2;
          bool3 = true;
        }
      }
      if ((paramDouble != -100.0D) && (paramDouble != paramTroopMemberInfo.distanceToSelf))
      {
        paramTroopMemberInfo.distanceToSelf = paramDouble;
        paramTroopMemberInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
        return true;
      }
      return bool3;
    }
  }
  
  private boolean assignMemberInfo2(String paramString, int paramInt, long paramLong1, long paramLong2, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.equals(paramTroopMemberInfo.mUniqueTitle))
      {
        paramTroopMemberInfo.mUniqueTitle = paramString;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramInt != -100)
    {
      bool2 = bool1;
      if (paramInt != paramTroopMemberInfo.realLevel)
      {
        paramTroopMemberInfo.realLevel = paramInt;
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (paramLong1 != -100L)
    {
      bool1 = bool2;
      if (paramLong1 != paramTroopMemberInfo.join_time)
      {
        paramTroopMemberInfo.join_time = paramLong1;
        bool1 = true;
      }
    }
    if ((paramLong2 != -100L) && (paramLong2 != paramTroopMemberInfo.last_active_time))
    {
      paramTroopMemberInfo.last_active_time = paramLong2;
      return true;
    }
    return bool1;
  }
  
  private boolean assignMemberInfo3(long paramLong, int paramInt1, int paramInt2, int paramInt3, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    if (paramLong != -100L) {
      paramTroopMemberInfo.msgseq = paramLong;
    }
    boolean bool1 = bool2;
    if (paramInt1 != -100)
    {
      bool1 = bool2;
      if (paramInt1 != paramTroopMemberInfo.age)
      {
        paramTroopMemberInfo.age = ((byte)paramInt1);
        bool1 = true;
      }
    }
    bool2 = bool1;
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
    boolean bool2 = false;
    if (paramString1 == null) {}
    for (String str = null;; str = removeColorNickChar(paramString1))
    {
      boolean bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (!paramString1.equals(paramTroopMemberInfo.troopColorNick))
        {
          paramTroopMemberInfo.troopColorNick = paramString1;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (str != null)
      {
        bool2 = bool1;
        if (!str.equals(paramTroopMemberInfo.troopnick))
        {
          paramTroopMemberInfo.troopnick = str;
          bool2 = true;
        }
      }
      if ((paramString2 == null) || (paramString2.equals(paramTroopMemberInfo.friendnick))) {
        break;
      }
      paramTroopMemberInfo.friendnick = paramString2;
      return true;
    }
    return bool2;
  }
  
  private boolean assignNickNameId(int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (-100 != paramInt)
    {
      bool1 = bool2;
      if (paramInt != paramTroopMemberInfo.troopColorNickId)
      {
        paramTroopMemberInfo.troopColorNickId = paramInt;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean assignVip(int paramInt1, int paramInt2, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != -100)
    {
      bool1 = bool2;
      if (paramInt1 != paramTroopMemberInfo.mVipType)
      {
        paramTroopMemberInfo.mVipType = paramInt1;
        bool1 = true;
      }
    }
    if ((paramInt2 != -100) && (paramInt2 != paramTroopMemberInfo.mVipLevel))
    {
      paramTroopMemberInfo.mVipLevel = paramInt2;
      return true;
    }
    return bool1;
  }
  
  private void deleteTroopMemberInLruCache(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = (LruCache)this.troopMembers1.get(paramString1);
    } while (paramString1 == null);
    paramString1.remove(paramString2);
  }
  
  private void deleteTroopMembersInLruCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.troopMembers1.remove(paramString);
  }
  
  private static String removeColorNickChar(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if (paramString.charAt(i) == '<')
      {
        int j = paramString.indexOf('>', i);
        if (j > 0) {
          i = j;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  private boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, long paramLong3, long paramLong4)
  {
    return saveTroopMemberEx(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100, -100, -100, paramLong3, paramLong4);
  }
  
  private boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong3, long paramLong4, int paramInt12)
  {
    TroopMemberInfo localTroopMemberInfo = getTroopMember(paramString1, paramString2);
    boolean bool = false;
    paramString5 = localTroopMemberInfo;
    if (localTroopMemberInfo == null)
    {
      paramString5 = new TroopMemberInfo();
      paramString5.troopuin = paramString1;
      paramString5.memberuin = paramString2;
      paramString5.isTroopFollowed = false;
      bool = true;
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
    for (;;)
    {
      if (assignBigClub(paramInt8, paramInt9, paramInt10, paramInt11, paramString5)) {
        bool = true;
      }
      for (;;)
      {
        if (assignMemberInfo1(paramString1, paramString2, paramInt1, paramLong2, paramByte, paramDouble, paramString5)) {}
        for (int i = 1;; i = bool)
        {
          if (assignMemberInfo2(paramString6, paramInt5, paramLong3, paramLong4, paramString5)) {
            i = 1;
          }
          if ((paramLong1 != -100L) && (paramLong1 < paramString5.msgseq)) {}
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberInfoService", 2, "saveTroopMemberEx ," + paramString5.toString());
            }
            if (i == 0) {
              break;
            }
            if (paramString5.getStatus() == 1000) {
              saveTroopMemberInfoInLruCache(paramString1, paramString2, paramString5);
            }
            addSaveTask(new TroopMemberInfoServiceImpl.SaveTroopMemberTask(this, paramString5, bool));
            return true;
            if (assignMemberInfo3(paramLong1, paramInt2, paramInt3, paramInt4, paramString5)) {
              i = 1;
            }
          }
          return false;
        }
      }
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberInfoService", 2, "deleteTroopMember, troopUin=" + paramString1 + ",memberUin=" + paramString2 + ",updateHeadAndName=" + paramBoolean);
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
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: getfield 319	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   15: invokevirtual 325	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   18: invokevirtual 331	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: astore 5
    //   23: aload 5
    //   25: invokevirtual 392	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   28: astore 4
    //   30: aload 4
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   37: aload 5
    //   39: ldc 71
    //   41: iconst_0
    //   42: ldc_w 399
    //   45: iconst_1
    //   46: anewarray 152	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: invokevirtual 403	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +15 -> 79
    //   67: aload 4
    //   69: invokeinterface 407 1 0
    //   74: istore_2
    //   75: iload_2
    //   76: ifeq +13 -> 89
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: aload 4
    //   91: invokeinterface 414 1 0
    //   96: astore 4
    //   98: aload 4
    //   100: invokeinterface 419 1 0
    //   105: ifeq +55 -> 160
    //   108: aload 5
    //   110: aload 4
    //   112: invokeinterface 423 1 0
    //   117: checkcast 71	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   120: invokevirtual 352	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   123: pop
    //   124: goto -26 -> 98
    //   127: astore 4
    //   129: ldc 13
    //   131: iconst_2
    //   132: ldc_w 425
    //   135: aload 4
    //   137: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   148: aload 5
    //   150: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   153: aload_0
    //   154: aload_1
    //   155: invokespecial 431	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:deleteTroopMembersInLruCache	(Ljava/lang/String;)V
    //   158: iconst_1
    //   159: ireturn
    //   160: aload_3
    //   161: invokevirtual 434	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   164: aload_3
    //   165: ifnull -17 -> 148
    //   168: aload_3
    //   169: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   172: goto -24 -> 148
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_3
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   186: aload_1
    //   187: athrow
    //   188: astore_1
    //   189: goto -11 -> 178
    //   192: astore_1
    //   193: goto -15 -> 178
    //   196: astore 4
    //   198: goto -69 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	TroopMemberInfoServiceImpl
    //   0	201	1	paramString	String
    //   74	2	2	bool	boolean
    //   1	182	3	localObject1	Object
    //   28	83	4	localObject2	Object
    //   127	9	4	localException1	java.lang.Exception
    //   196	1	4	localException2	java.lang.Exception
    //   21	128	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   33	62	127	java/lang/Exception
    //   67	75	127	java/lang/Exception
    //   89	98	127	java/lang/Exception
    //   98	124	127	java/lang/Exception
    //   160	164	127	java/lang/Exception
    //   23	30	175	finally
    //   33	62	188	finally
    //   67	75	188	finally
    //   89	98	188	finally
    //   98	124	188	finally
    //   160	164	188	finally
    //   129	140	192	finally
    //   23	30	196	java/lang/Exception
  }
  
  public List<TroopMemberInfo> enhanceTroopMemberList(String paramString, List<TroopMemberInfo> paramList)
  {
    int k = 0;
    Object localObject1;
    int i;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("enhanceTroopMemberList before troopUin = ").append(paramString).append("  memberList.size:");
      if (paramList != null)
      {
        i = paramList.size();
        QLog.d("TroopMemberInfoService", 2, i);
      }
    }
    else
    {
      if (paramList != null)
      {
        localObject2 = paramList;
        if (paramList.size() >= 6) {
          break label237;
        }
      }
      ArrayList localArrayList = getTroopMembersInLruCache(paramString);
      localObject2 = paramList;
      if (localArrayList.isEmpty()) {
        break label237;
      }
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      i = 0;
      label116:
      localObject2 = localObject1;
      if (i >= localArrayList.size()) {
        break label237;
      }
      localObject2 = localObject1;
      if (i >= 6) {
        break label237;
      }
      paramList = (TroopMemberInfo)localArrayList.get(i);
      localObject2 = ((List)localObject1).iterator();
      TroopMemberInfo localTroopMemberInfo;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject2).next();
      } while ((localTroopMemberInfo == null) || (paramList == null) || (!TextUtils.equals(localTroopMemberInfo.memberuin, paramList.memberuin)));
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((List)localObject1).add(paramList);
      }
      i += 1;
      break label116;
      i = 0;
      break;
      label237:
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("enhanceTroopMemberList after troopUin = ").append(paramString).append("  memberList.size:");
        i = k;
        if (localObject2 != null) {
          i = ((List)localObject2).size();
        }
        QLog.d("TroopMemberInfoService", 2, i);
      }
      return localObject2;
    }
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = (LruCache)this.troopMembers1.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    return (TroopMemberInfo)paramString1.get(paramString2);
  }
  
  public void getTroopMemberInfo(String paramString1, String paramString2, ITroopMemberInfoService.ITroopMemberInfoCallBack paramITroopMemberInfoCallBack)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      if (paramITroopMemberInfoCallBack != null)
      {
        localObject = getTroopMemberInLruCache(paramString1, paramString2);
        if (localObject == null) {
          break label35;
        }
        paramITroopMemberInfoCallBack.a((TroopMemberInfo)localObject);
      }
    }
    label35:
    do
    {
      return;
      paramITroopMemberInfoCallBack.a(getTroopMemberInfoFromDb(paramString1, paramString2));
      return;
      List localList = (List)this.mTmiCallBackRefMap.get(paramString1 + "_" + paramString2);
      localObject = localList;
      if (localList != null) {
        break label166;
      }
      localObject = getTroopMemberInLruCache(paramString1, paramString2);
      if (localObject == null) {
        break;
      }
    } while (paramITroopMemberInfoCallBack == null);
    paramITroopMemberInfoCallBack.a((TroopMemberInfo)localObject);
    return;
    Object localObject = new ArrayList();
    this.mTmiCallBackRefMap.put(paramString1 + "_" + paramString2, localObject);
    label166:
    if (((List)localObject).isEmpty())
    {
      ((List)localObject).add(new WeakReference(paramITroopMemberInfoCallBack));
      TroopMemberThreadManager.a(new TroopMemberInfoServiceImpl.2(this, paramString1, paramString2));
      return;
    }
    ((List)localObject).add(new WeakReference(paramITroopMemberInfoCallBack));
  }
  
  public TroopMemberInfo getTroopMemberInfoFromDb(String paramString1, String paramString2)
  {
    if (StatisticCollector.getSqliteSwitchBySample(12)) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      Object localObject = this.app.getEntityManagerFactory().createEntityManager();
      List localList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? AND memberuin=?", new String[] { paramString1, paramString2 }, null, null, null, null);
      ((EntityManager)localObject).close();
      HashMap localHashMap;
      if (l != 0L)
      {
        l = SystemClock.uptimeMillis() - l;
        localHashMap = new HashMap(10);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label233;
        }
      }
      label233:
      for (localObject = "1";; localObject = "0")
      {
        localHashMap.put("param_IsMainThread", localObject);
        localHashMap.put("param_OptType", "query");
        localHashMap.put("param_bustag", "Troop");
        localHashMap.put("param_intrans", "0");
        localHashMap.put("param_OptTotalCost", String.valueOf(l));
        localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        StatisticCollector.getInstance(this.app.getApplicationContext()).collectPerformance(null, "actFriendSqliteOpt", true, l, 0L, localHashMap, null, false);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        localObject = (TroopMemberInfo)localList.get(0);
        saveTroopMemberInfoInLruCache(paramString1, paramString2, (TroopMemberInfo)localObject);
        return localObject;
      }
      return null;
    }
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
  
  public boolean isMemberInCache(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = (LruCache)this.troopMembers1.get(paramString1);
    } while (paramString1 == null);
    if (paramString1.get(paramString2) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
  }
  
  public void onDestroy() {}
  
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
    if (this.mRunningTask.size() >= 3) {}
    TroopMemberInfoServiceImpl.SaveTroopMemberTask localSaveTroopMemberTask;
    do
    {
      do
      {
        return;
      } while (this.mSaveTroopMemberTasks.isEmpty());
      localSaveTroopMemberTask = (TroopMemberInfoServiceImpl.SaveTroopMemberTask)this.mSaveTroopMemberTasks.poll();
    } while (localSaveTroopMemberTask == null);
    this.mCurrentSaveTask = localSaveTroopMemberTask;
    this.mRunningTask.add(localSaveTroopMemberTask);
    ThreadManager.excute(localSaveTroopMemberTask, 32, null, false);
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
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
  
  public void saveTroopMemberInfoToDB(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null) {
      return;
    }
    ThreadManager.post(new TroopMemberInfoServiceImpl.1(this, paramTroopMemberInfo, new Handler(Looper.getMainLooper()), paramString1, paramString2), 8, null, false);
  }
  
  /* Error */
  public boolean saveTroopMembers(List<TroopMemberInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 407 1 0
    //   10: ifeq +7 -> 17
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ireturn
    //   17: new 655	java/util/HashSet
    //   20: dup
    //   21: invokespecial 656	java/util/HashSet:<init>	()V
    //   24: astore 7
    //   26: iconst_0
    //   27: istore_3
    //   28: iconst_0
    //   29: istore 4
    //   31: iconst_0
    //   32: istore_2
    //   33: aconst_null
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 462	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: invokevirtual 392	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   43: astore 6
    //   45: aload 6
    //   47: astore 5
    //   49: iload 4
    //   51: istore_3
    //   52: aload 5
    //   54: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   57: iload 4
    //   59: istore_3
    //   60: aload_1
    //   61: invokeinterface 414 1 0
    //   66: astore_1
    //   67: iload_2
    //   68: istore_3
    //   69: aload_1
    //   70: invokeinterface 419 1 0
    //   75: ifeq +155 -> 230
    //   78: iload_2
    //   79: istore_3
    //   80: aload_1
    //   81: invokeinterface 423 1 0
    //   86: checkcast 71	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   89: astore 6
    //   91: iload_2
    //   92: istore_3
    //   93: new 96	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   100: aload 6
    //   102: getfield 256	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   105: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 490
    //   111: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 6
    //   116: getfield 259	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   119: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 8
    //   127: iload_2
    //   128: istore_3
    //   129: aload 6
    //   131: getfield 259	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   134: ldc_w 658
    //   137: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifne -73 -> 67
    //   143: iload_2
    //   144: istore_3
    //   145: aload 7
    //   147: aload 8
    //   149: invokevirtual 660	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   152: ifne +198 -> 350
    //   155: iload_2
    //   156: istore_3
    //   157: aload_0
    //   158: aload 6
    //   160: getfield 256	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   163: aload 6
    //   165: getfield 259	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   168: aload 6
    //   170: getfield 185	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   173: aload 6
    //   175: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:level	I
    //   178: aload 6
    //   180: getfield 191	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   183: aconst_null
    //   184: aload 6
    //   186: getfield 174	com/tencent/mobileqq/data/troop/TroopMemberInfo:age	B
    //   189: aload 6
    //   191: getfield 177	com/tencent/mobileqq/data/troop/TroopMemberInfo:sex	B
    //   194: aload 6
    //   196: getfield 180	com/tencent/mobileqq/data/troop/TroopMemberInfo:distance	I
    //   199: aload 6
    //   201: getfield 170	com/tencent/mobileqq/data/troop/TroopMemberInfo:msgseq	J
    //   204: aload 6
    //   206: getfield 126	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   209: invokevirtual 662	com/tencent/mobileqq/troop/api/impl/TroopMemberInfoServiceImpl:saveTroopMember	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   212: istore 4
    //   214: iload 4
    //   216: iload_2
    //   217: ior
    //   218: istore_2
    //   219: aload 7
    //   221: aload 8
    //   223: invokevirtual 663	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -160 -> 67
    //   230: iload_2
    //   231: istore_3
    //   232: aload 5
    //   234: invokevirtual 434	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   237: iload_2
    //   238: istore_3
    //   239: aload 5
    //   241: ifnull -226 -> 15
    //   244: aload 5
    //   246: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   249: iload_2
    //   250: ireturn
    //   251: astore 6
    //   253: iload_3
    //   254: istore_2
    //   255: aload 5
    //   257: astore_1
    //   258: aload 6
    //   260: astore 5
    //   262: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +14 -> 279
    //   268: ldc 13
    //   270: iconst_2
    //   271: aload 5
    //   273: invokestatic 667	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   276: invokestatic 669	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: iload_2
    //   280: istore_3
    //   281: aload_1
    //   282: ifnull -267 -> 15
    //   285: aload_1
    //   286: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   289: iload_2
    //   290: ireturn
    //   291: astore_1
    //   292: aconst_null
    //   293: astore 5
    //   295: aload 5
    //   297: ifnull +8 -> 305
    //   300: aload 5
    //   302: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   305: aload_1
    //   306: athrow
    //   307: astore_1
    //   308: goto -13 -> 295
    //   311: astore 6
    //   313: aload_1
    //   314: astore 5
    //   316: aload 6
    //   318: astore_1
    //   319: goto -24 -> 295
    //   322: astore 6
    //   324: aload 5
    //   326: astore_1
    //   327: aload 6
    //   329: astore 5
    //   331: iload_3
    //   332: istore_2
    //   333: goto -71 -> 262
    //   336: astore_1
    //   337: aload 5
    //   339: astore 6
    //   341: aload_1
    //   342: astore 5
    //   344: aload 6
    //   346: astore_1
    //   347: goto -85 -> 262
    //   350: goto -123 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	TroopMemberInfoServiceImpl
    //   0	353	1	paramList	List<TroopMemberInfo>
    //   32	301	2	bool1	boolean
    //   14	318	3	bool2	boolean
    //   29	189	4	bool3	boolean
    //   34	309	5	localObject1	Object
    //   43	162	6	localObject2	Object
    //   251	8	6	localThrowable1	java.lang.Throwable
    //   311	6	6	localObject3	Object
    //   322	6	6	localThrowable2	java.lang.Throwable
    //   339	6	6	localObject4	Object
    //   24	196	7	localHashSet	java.util.HashSet
    //   125	97	8	str	String
    // Exception table:
    //   from	to	target	type
    //   36	45	251	java/lang/Throwable
    //   36	45	291	finally
    //   52	57	307	finally
    //   60	67	307	finally
    //   69	78	307	finally
    //   80	91	307	finally
    //   93	127	307	finally
    //   129	143	307	finally
    //   145	155	307	finally
    //   157	214	307	finally
    //   219	227	307	finally
    //   232	237	307	finally
    //   262	279	311	finally
    //   52	57	322	java/lang/Throwable
    //   60	67	322	java/lang/Throwable
    //   69	78	322	java/lang/Throwable
    //   80	91	322	java/lang/Throwable
    //   93	127	322	java/lang/Throwable
    //   129	143	322	java/lang/Throwable
    //   145	155	322	java/lang/Throwable
    //   157	214	322	java/lang/Throwable
    //   232	237	322	java/lang/Throwable
    //   219	227	336	java/lang/Throwable
  }
  
  public void updateTroopMemberCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (LruCache)this.troopMembers1.get(paramString);
    } while (paramString == null);
    paramString.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */