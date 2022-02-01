package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.IHotChatService;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    TroopInfo localTroopInfo = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    str = paramString;
    if (localTroopInfo != null)
    {
      str = paramString;
      if (localTroopInfo.getTroopDisplayName() != null) {
        str = localTroopInfo.getTroopDisplayName();
      }
    }
    return str;
  }
  
  private void scheduleFetchExpiredSurveyList()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.survey", 2, "[TroopManager]scheduleFetchExpiredSurveyList()");
    }
    int i = (int)NetConnInfoCenter.getServerTime();
    Object localObject = this.mMapOfSurveyList.values().iterator();
    long l = 2147483647L;
    while (((Iterator)localObject).hasNext())
    {
      oidb_cmd0xb36.RspBody localRspBody = (oidb_cmd0xb36.RspBody)((Iterator)localObject).next();
      if ((localRspBody.toast.has()) && (localRspBody.toast.expired.has()))
      {
        int j = localRspBody.toast.expired.get();
        if (j > i)
        {
          l = Math.max(60L, Math.min(l, j - i));
          if (QLog.isColorLevel()) {
            QLog.d(".troop.survey", 2, new Object[] { "survey id=", Long.valueOf(localRspBody.toast.id.get()), " not expired, will schedule request in ", Long.valueOf(l), " seconds" });
          }
        }
      }
    }
    if (l != 2147483647L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, new Object[] { "Will request survey toast info in ", Long.valueOf(l), " seconds!" });
      }
      ThreadManager.getSubThreadHandler().removeCallbacks(this.mSurveyListCheckRunnable);
      ThreadManager.getSubThreadHandler().postDelayed(this.mSurveyListCheckRunnable, Math.min(l * 1000L, 2147483647L));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(this.mMapOfSurveyList.size()));
      ((StringBuilder)localObject).append(" surveys, all of them expired");
      QLog.d(".troop.survey", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void updateActiveTroop(String paramString)
  {
    Object localObject = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    if ((localObject != null) && (((TroopInfo)localObject).eliminated == 1))
    {
      long l = NetConnInfoCenter.getServerTime();
      localObject = this.mActiveTroopMap;
      if ((localObject != null) && (((Map)localObject).containsKey(paramString)))
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
      localObject = this.app;
      if ((localObject instanceof AppInterface)) {
        ((ITroopManagerBizHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopManagerBizHandlerName())).c(paramString);
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTroopReceiveOrSendMsg troopInfo is null or not eliminated. troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("troop_ext", 1, ((StringBuilder)localObject).toString());
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
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    ConcurrentHashMap localConcurrentHashMap = this.mAssocitedTroopCountCache;
    if (localConcurrentHashMap != null)
    {
      if (!localConcurrentHashMap.containsKey(paramString)) {
        return 0;
      }
      return ((Integer)this.mAssocitedTroopCountCache.get(paramString)).intValue();
    }
    return 0;
  }
  
  public String getCurrentOpenTroop()
  {
    return this.mCurrentOpenTroop;
  }
  
  public ConcurrentHashMap<String, Entity> getShowExternalTroopLazyCache()
  {
    if (this.mShowExternalTroopCache == null)
    {
      Object localObject = (ArrayList)this.em.query(ShowExternalTroop.class, false, null, null, null, null, null, null);
      int j = 0;
      int i;
      if (localObject != null) {
        i = ((ArrayList)localObject).size();
      } else {
        i = 0;
      }
      this.mShowExternalTroopCache = new QQConcurrentHashMap(1015, i, 70);
      while (j < i)
      {
        ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)((ArrayList)localObject).get(j);
        this.mShowExternalTroopCache.put(localShowExternalTroop.troopUin, localShowExternalTroop);
        j += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load mShowExternalTroopCache info: size = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("BizTroopInfoService", 2, ((StringBuilder)localObject).toString());
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
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.isFansTroop()) {
        bool1 = true;
      }
    }
    return bool1;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isTroopAIOOpen : ");
        localStringBuilder.append(this.isTroopAIOOpen);
        QLog.d("BizTroopInfoService", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isTroopConfessPanelOpen isConfessPanelOpen: ");
        localStringBuilder.append(this.isConfessPanelOpen);
        QLog.d("BizTroopInfoService", 2, localStringBuilder.toString());
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
  
  public void refreshShowExternalTroop()
  {
    ConcurrentHashMap localConcurrentHashMap = getShowExternalTroopLazyCache();
    Object localObject1 = null;
    Object localObject3 = null;
    try
    {
      try
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        if (localEntityTransaction != null)
        {
          localObject3 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          localEntityTransaction.begin();
          localObject3 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          this.em.drop(ShowExternalTroop.class);
          localObject3 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          localConcurrentHashMap.clear();
          localObject3 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          if (this.mPrepareShowExternalTroop != null)
          {
            localObject3 = localEntityTransaction;
            localObject1 = localEntityTransaction;
            Iterator localIterator = this.mPrepareShowExternalTroop.keySet().iterator();
            for (;;)
            {
              localObject3 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              String str = (String)localIterator.next();
              localObject3 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              ShowExternalTroop localShowExternalTroop = ShowExternalTroop.createShowExternalTroop(str, getTroopNameByID(str), ((Long)this.mPrepareShowExternalTroop.get(str)).longValue());
              localObject3 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              localConcurrentHashMap.put(str, localShowExternalTroop);
              localObject3 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).updateEntity(localShowExternalTroop);
            }
          }
          localObject3 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          localEntityTransaction.commit();
        }
        if (localEntityTransaction == null) {
          break label228;
        }
        localObject1 = localEntityTransaction;
      }
      finally
      {
        if (localObject3 != null) {
          localObject3.end();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label220:
      break label220;
    }
    if (localObject2 != null) {
      localObject2.end();
    }
    label228:
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTroopAIOOpen flag: ");
        localStringBuilder.append(paramBoolean);
        QLog.d("BizTroopInfoService", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTroopConfessPanelOpen flag: ");
        localStringBuilder.append(paramBoolean);
        QLog.d("BizTroopInfoService", 2, localStringBuilder.toString());
      }
      this.isConfessPanelOpen = paramBoolean;
      return;
    }
    finally {}
  }
  
  public void updateTroopSurveyList(oidb_cmd0xb36.RspBody paramRspBody)
  {
    if ((paramRspBody != null) && (paramRspBody.group_id.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, "[TroopManager]updateTroopSurveyList() body ready!");
      }
      this.mMapOfSurveyList.put(String.valueOf(paramRspBody.group_id.get()), paramRspBody);
    }
    else if (paramRspBody == null)
    {
      QLog.e(".troop.survey", 1, "[TroopManager]updateTroopSurveyList() body is null!");
    }
    else
    {
      QLog.e(".troop.survey", 1, "[TroopManager]updateTroopSurveyList() IllegaleArgument!");
    }
    scheduleFetchExpiredSurveyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */