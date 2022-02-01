package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.IHotChatService;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

public class BizTroopInfoServiceImpl
  implements IBizTroopInfoService
{
  private static final String KEY_FOR_SHOW_TROOP_BIG_CLUB = "show_troop_big_club";
  private static final String TAG = "BizTroopInfoService";
  protected AppRuntime app;
  protected EntityManager em;
  protected boolean isConfessPanelOpen;
  protected boolean isTroopAIOOpen;
  private Map<String, Long> mActiveTroopMap;
  protected ConcurrentHashMap<String, Integer> mAssocitedTroopCountCache;
  protected String mCurrentOpenTroop;
  public boolean mIsShowTroopBigClub = true;
  protected Map<String, oidb_cmd0xb36.RspBody> mMapOfSurveyList = new ConcurrentHashMap();
  protected Map<String, Long> mPrepareShowExternalTroop;
  protected ConcurrentHashMap<String, Entity> mShowExternalTroopCache;
  private Runnable mSurveyListCheckRunnable = new BizTroopInfoServiceImpl.1(this);
  
  private String getTroopNameByID(String paramString)
  {
    String str = ((IHotChatService)this.app.getRuntimeService(IHotChatService.class, "")).getHotChatName(paramString);
    if (!TextUtils.isEmpty(str)) {}
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return str;
        localTroopInfo = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
        str = paramString;
      } while (localTroopInfo == null);
      str = paramString;
    } while (localTroopInfo.getTroopDisplayName() == null);
    return localTroopInfo.getTroopDisplayName();
  }
  
  private void scheduleFetchExpiredSurveyList()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.survey", 2, "[TroopManager]scheduleFetchExpiredSurveyList()");
    }
    int i = (int)NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.mMapOfSurveyList.values().iterator();
    long l1;
    for (long l2 = 2147483647L; localIterator.hasNext(); l2 = l1)
    {
      oidb_cmd0xb36.RspBody localRspBody = (oidb_cmd0xb36.RspBody)localIterator.next();
      l1 = l2;
      if (localRspBody.toast.has())
      {
        l1 = l2;
        if (localRspBody.toast.expired.has())
        {
          int j = localRspBody.toast.expired.get();
          l1 = l2;
          if (j > i)
          {
            l2 = Math.max(60L, Math.min(l2, j - i));
            l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d(".troop.survey", 2, new Object[] { "survey id=", Long.valueOf(localRspBody.toast.id.get()), " not expired, will schedule request in ", Long.valueOf(l2), " seconds" });
              l1 = l2;
            }
          }
        }
      }
    }
    if (l2 != 2147483647L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, new Object[] { "Will request survey toast info in ", Long.valueOf(l2), " seconds!" });
      }
      ThreadManager.getSubThreadHandler().removeCallbacks(this.mSurveyListCheckRunnable);
      ThreadManager.getSubThreadHandler().postDelayed(this.mSurveyListCheckRunnable, Math.min(l2 * 1000L, 2147483647L));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(".troop.survey", 2, String.valueOf(this.mMapOfSurveyList.size()) + " surveys, all of them expired");
  }
  
  private void updateActiveTroop(String paramString)
  {
    TroopInfo localTroopInfo = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    if ((localTroopInfo == null) || (localTroopInfo.eliminated != 1))
    {
      QLog.i("troop_ext", 1, "onTroopReceiveOrSendMsg troopInfo is null or not eliminated. troopUin: " + paramString);
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    if ((this.mActiveTroopMap != null) && (this.mActiveTroopMap.containsKey(paramString)))
    {
      if (l - ((Long)this.mActiveTroopMap.get(paramString)).longValue() < 60L) {
        QLog.i("troop_ext", 1, "onTroopReceiveOrSendMsg current time - time < 60s.");
      }
    }
    else
    {
      if (this.mActiveTroopMap == null) {
        this.mActiveTroopMap = new ConcurrentHashMap();
      }
      this.mActiveTroopMap.put(paramString, Long.valueOf(l));
    }
    ((ITroopHandlerService)this.app.getRuntimeService(ITroopHandlerService.class, "")).activeExtTroop(paramString);
  }
  
  public boolean addShowExternalTroop(String paramString, long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = getShowExternalTroopLazyCache();
    ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localConcurrentHashMap.get(paramString);
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "");
    if (localShowExternalTroop == null)
    {
      localShowExternalTroop = ShowExternalTroop.createShowExternalTroop(paramString, getTroopNameByID(paramString), paramLong);
      localConcurrentHashMap.put(paramString, localShowExternalTroop);
      localITroopInfoService.updateEntity(localShowExternalTroop);
      return true;
    }
    if (localShowExternalTroop.addedTimestamp != paramLong)
    {
      localShowExternalTroop.addedTimestamp = paramLong;
      localITroopInfoService.updateEntity(localShowExternalTroop);
      return true;
    }
    return false;
  }
  
  public int getAssociatedTroopCount(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.mAssocitedTroopCountCache == null) || (!this.mAssocitedTroopCountCache.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)this.mAssocitedTroopCountCache.get(paramString)).intValue();
  }
  
  public String getCurrentOpenTroop()
  {
    return this.mCurrentOpenTroop;
  }
  
  public ConcurrentHashMap<String, Entity> getShowExternalTroopLazyCache()
  {
    int j = 0;
    if (this.mShowExternalTroopCache == null)
    {
      ArrayList localArrayList = (ArrayList)this.em.query(ShowExternalTroop.class, false, null, null, null, null, null, null);
      if (localArrayList != null) {}
      for (int i = localArrayList.size();; i = 0)
      {
        this.mShowExternalTroopCache = new QQConcurrentHashMap(1015, i, 70);
        while (j < i)
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localArrayList.get(j);
          this.mShowExternalTroopCache.put(localShowExternalTroop.troopUin, localShowExternalTroop);
          j += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BizTroopInfoService", 2, "load mShowExternalTroopCache info: size = " + i);
      }
    }
    return this.mShowExternalTroopCache;
  }
  
  public List<ShowExternalTroop> getShowExternalTroopList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getShowExternalTroopLazyCache().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ShowExternalTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public oidb_cmd0xb36.ToastInfo getTroopSurveyList(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (oidb_cmd0xb36.RspBody)this.mMapOfSurveyList.get(paramString);
    if ((paramString != null) && (paramString.toast.has())) {
      return paramString.toast;
    }
    return null;
  }
  
  public boolean getmIsShowTroopBigClub()
  {
    return this.mIsShowTroopBigClub;
  }
  
  public boolean isCurrentOpenTroop(String paramString)
  {
    try
    {
      boolean bool = TextUtils.equals(paramString, this.mCurrentOpenTroop);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean isFansTroop(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    if ((paramString != null) && (paramString.isFansTroop())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isShowExternalTroop(String paramString)
  {
    return getShowExternalTroopLazyCache().get(paramString) != null;
  }
  
  public boolean isShowTroopBigClub()
  {
    return this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getBoolean("show_troop_big_club", true);
  }
  
  public boolean isTroopAIOOpen()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BizTroopInfoService", 2, "isTroopAIOOpen : " + this.isTroopAIOOpen);
      }
      boolean bool = this.isTroopAIOOpen;
      return bool;
    }
    finally {}
  }
  
  public boolean isTroopConfessPanelOpen()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BizTroopInfoService", 2, "isTroopConfessPanelOpen isConfessPanelOpen: " + this.isConfessPanelOpen);
      }
      boolean bool = this.isConfessPanelOpen;
      return bool;
    }
    finally {}
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.em = this.app.getEntityManagerFactory().createEntityManager();
    this.mIsShowTroopBigClub = isShowTroopBigClub();
  }
  
  public void onDestroy()
  {
    this.em.close();
    this.mMapOfSurveyList.clear();
    ThreadManager.getSubThreadHandler().removeCallbacks(this.mSurveyListCheckRunnable);
  }
  
  public void onTroopReceiveOrSendMsg(String paramString)
  {
    updateActiveTroop(paramString);
  }
  
  public void prePareShowExternalTroop(Map<String, Long> paramMap)
  {
    this.mPrepareShowExternalTroop = paramMap;
  }
  
  /* Error */
  public void refreshShowExternalTroop()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 276	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:getShowExternalTroopLazyCache	()Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 311	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +142 -> 160
    //   21: aload_1
    //   22: invokevirtual 436	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   25: aload_0
    //   26: getfield 311	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: ldc_w 279
    //   32: invokevirtual 440	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 441	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   40: aload_0
    //   41: getfield 423	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:mPrepareShowExternalTroop	Ljava/util/Map;
    //   44: ifnull +112 -> 156
    //   47: aload_0
    //   48: getfield 423	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:mPrepareShowExternalTroop	Ljava/util/Map;
    //   51: invokeinterface 445 1 0
    //   56: invokeinterface 448 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 132 1 0
    //   68: ifeq +88 -> 156
    //   71: aload_2
    //   72: invokeinterface 136 1 0
    //   77: checkcast 222	java/lang/String
    //   80: astore 4
    //   82: aload 4
    //   84: aload_0
    //   85: aload 4
    //   87: invokespecial 281	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:getTroopNameByID	(Ljava/lang/String;)Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 423	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:mPrepareShowExternalTroop	Ljava/util/Map;
    //   94: aload 4
    //   96: invokeinterface 256 2 0
    //   101: checkcast 181	java/lang/Long
    //   104: invokevirtual 259	java/lang/Long:longValue	()J
    //   107: invokestatic 285	com/tencent/mobileqq/troop/data/ShowExternalTroop:createShowExternalTroop	(Ljava/lang/String;Ljava/lang/String;J)Lcom/tencent/mobileqq/troop/data/ShowExternalTroop;
    //   110: astore 5
    //   112: aload_3
    //   113: aload 4
    //   115: aload 5
    //   117: invokevirtual 286	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload_0
    //   122: getfield 62	com/tencent/mobileqq/troop/api/impl/BizTroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   125: ldc 83
    //   127: ldc 66
    //   129: invokevirtual 72	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   132: checkcast 83	com/tencent/mobileqq/troop/api/ITroopInfoService
    //   135: aload 5
    //   137: invokeinterface 290 2 0
    //   142: pop
    //   143: goto -81 -> 62
    //   146: astore_2
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 451	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   155: return
    //   156: aload_1
    //   157: invokevirtual 454	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   160: aload_1
    //   161: ifnull -6 -> 155
    //   164: aload_1
    //   165: invokevirtual 451	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   168: return
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_3
    //   172: aload_1
    //   173: astore_2
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 451	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   182: aload_2
    //   183: athrow
    //   184: astore_2
    //   185: aload_1
    //   186: astore_3
    //   187: goto -13 -> 174
    //   190: astore_2
    //   191: goto -44 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	BizTroopInfoServiceImpl
    //   1	164	1	localObject1	Object
    //   169	17	1	localObject2	Object
    //   14	58	2	localObject3	Object
    //   146	1	2	localThrowable1	java.lang.Throwable
    //   173	10	2	localObject4	Object
    //   184	1	2	localObject5	Object
    //   190	1	2	localThrowable2	java.lang.Throwable
    //   6	181	3	localObject6	Object
    //   80	34	4	str	String
    //   110	26	5	localShowExternalTroop	ShowExternalTroop
    // Exception table:
    //   from	to	target	type
    //   21	62	146	java/lang/Throwable
    //   62	143	146	java/lang/Throwable
    //   156	160	146	java/lang/Throwable
    //   7	15	169	finally
    //   21	62	184	finally
    //   62	143	184	finally
    //   156	160	184	finally
    //   7	15	190	java/lang/Throwable
  }
  
  public boolean removeShowExternalTroop(String paramString)
  {
    paramString = (ShowExternalTroop)getShowExternalTroopLazyCache().remove(paramString);
    if (paramString != null)
    {
      this.em.remove(paramString);
      return true;
    }
    return false;
  }
  
  public void setAssociatedTroopCount(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mAssocitedTroopCountCache == null) {
      this.mAssocitedTroopCountCache = new ConcurrentHashMap();
    }
    this.mAssocitedTroopCountCache.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void setCurrentOpenTroop(String paramString)
  {
    try
    {
      this.mCurrentOpenTroop = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setShowTroopBigClub(boolean paramBoolean)
  {
    this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putBoolean("show_troop_big_club", paramBoolean).commit();
    this.mIsShowTroopBigClub = paramBoolean;
  }
  
  public void setTroopAIOOpen(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BizTroopInfoService", 2, "setTroopAIOOpen flag: " + paramBoolean);
      }
      this.isTroopAIOOpen = paramBoolean;
      return;
    }
    finally {}
  }
  
  public void setTroopConfessPanelOpen(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BizTroopInfoService", 2, "setTroopConfessPanelOpen flag: " + paramBoolean);
      }
      this.isConfessPanelOpen = paramBoolean;
      return;
    }
    finally {}
  }
  
  public void updateTroopSurveyList(oidb_cmd0xb36.RspBody paramRspBody)
  {
    if ((paramRspBody == null) || (!paramRspBody.group_id.has())) {
      if (paramRspBody == null) {
        QLog.e(".troop.survey", 1, "[TroopManager]updateTroopSurveyList() body is null!");
      }
    }
    for (;;)
    {
      scheduleFetchExpiredSurveyList();
      return;
      QLog.e(".troop.survey", 1, "[TroopManager]updateTroopSurveyList() IllegaleArgument!");
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, "[TroopManager]updateTroopSurveyList() body ready!");
      }
      this.mMapOfSurveyList.put(String.valueOf(paramRspBody.group_id.get()), paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */