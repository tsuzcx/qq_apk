package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.FullListGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.GroupAppsServlet;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;

public class TroopAioAppServiceImpl
  implements StudyModeChangeListener, ITroopAioAppService
{
  private static final String SP_KEY_FULL_APP_LIST_HASH = "SP_KEY_FULL_APP_LIST_HASH";
  private static final String TAG = "TroopAioAppServiceImpl";
  String fullAppListHash = "";
  List<TroopAIOAppInfo> fullAppsListInfos;
  private ConcurrentHashMap<Long, GrayGroupAppEntity> grayAppInfoMap;
  private AppRuntime mApp;
  private FullListGroupAppsDbHelper mFullListGroupAppsDbHelper;
  private GrayGroupAppsDbHelper mGrayGroupAppsDbHelper;
  private TroopAppHandler mTroopAppHander;
  
  private void clearAll()
  {
    this.grayAppInfoMap.clear();
    this.fullAppsListInfos.clear();
    this.fullAppListHash = "";
    saveFullAppListHashInSp();
    grayGroupAppsDbHelper().c();
    fullListGroupAppsDbHelper().b();
  }
  
  private List<TroopAIOAppInfo> getAppsInGrayList(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ArrayList localArrayList = new ArrayList(20);
    Object localObject = paramGrayGroupAppEntity.troopAIOAppInfos;
    paramGrayGroupAppEntity = new HashSet(20);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramGrayGroupAppEntity.add(Integer.valueOf(((TroopAIOAppInfo)((Iterator)localObject).next()).appid));
    }
    localObject = this.fullAppsListInfos.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      } else if (paramGrayGroupAppEntity.contains(Integer.valueOf(localTroopAIOAppInfo.appid))) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  private List<TroopAIOAppInfo> getAppsOnlyInFullList()
  {
    ArrayList localArrayList = new ArrayList(20);
    Iterator localIterator = this.fullAppsListInfos.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  private void readFullAppListHashFromSp()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.mApp.getCurrentUin());
    localObject = ((StringBuilder)localObject).toString();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_KEY_FULL_APP_LIST_HASH");
    localStringBuilder.append((String)localObject);
    this.fullAppListHash = localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public void afterUserLogin()
  {
    GroupUtil.a(new TroopAioAppServiceImpl.1(this), 1000L);
  }
  
  public void clearRedDotInCacheAndDb(int paramInt)
  {
    Object localObject = new ArrayList(this.fullAppsListInfos);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (paramInt == localTroopAIOAppInfo.appid) {
        localTroopAIOAppInfo.redPoint = false;
      }
    }
    this.fullAppsListInfos = ((List)localObject);
    localObject = new FullListGroupAppEntity();
    ((FullListGroupAppEntity)localObject).troopAIOAppInfos = this.fullAppsListInfos;
    fullListGroupAppsDbHelper().a((FullListGroupAppEntity)localObject);
  }
  
  public FullListGroupAppsDbHelper fullListGroupAppsDbHelper()
  {
    return this.mFullListGroupAppsDbHelper;
  }
  
  public List<TroopAIOAppInfo> getAllAppsFromCache()
  {
    List localList = getAppsOnlyInFullList();
    Iterator localIterator = this.grayAppInfoMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localList.addAll(getAppsInGrayList((GrayGroupAppEntity)((Map.Entry)localIterator.next()).getValue()));
    }
    return localList;
  }
  
  public List<TroopAIOAppInfo> getAppsFromCache(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.grayAppInfoMap.get(Long.valueOf(paramLong));
    if (localGrayGroupAppEntity == null) {
      return getAppsOnlyInFullList();
    }
    return getAppsInGrayList(localGrayGroupAppEntity);
  }
  
  public void getAppsInObserver(long paramLong)
  {
    boolean bool = GroupAppsServlet.a(this.mApp, paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAppsInObserver: invoked.  needRequest: ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("TroopAioAppServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(paramLong));
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = (int)((TroopInfo)localObject).dwGroupClassExt;
      }
      GroupAppsServlet.a(this.mApp, paramLong, i);
      return;
    }
    if (!GroupUtil.a(getAppsFromCache(paramLong)))
    {
      GroupAppsServlet.b(this.mApp, paramLong);
      return;
    }
    GroupUtil.a(new TroopAioAppServiceImpl.2(this, paramLong));
  }
  
  public String getFullAppListHash()
  {
    return this.fullAppListHash;
  }
  
  public List<TroopAIOAppInfo> getFullAppsListInfos()
  {
    return this.fullAppsListInfos;
  }
  
  public ConcurrentHashMap<Long, GrayGroupAppEntity> getGrayAppInfoMap()
  {
    return this.grayAppInfoMap;
  }
  
  public String getGrayAppsHash(long paramLong)
  {
    Object localObject = getAppsFromCache(paramLong);
    if (GroupUtil.a((Collection)localObject)) {
      return "";
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localTroopAIOAppInfo.hashVal)) {
        return localTroopAIOAppInfo.hashVal;
      }
    }
    return "";
  }
  
  public long getRequestIntervalSecond(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.grayAppInfoMap.get(Long.valueOf(paramLong));
    paramLong = TimeUnit.DAYS.toSeconds(1L);
    if (localGrayGroupAppEntity == null) {
      return paramLong;
    }
    if (localGrayGroupAppEntity.requestIntervalSecond <= 0) {
      return paramLong;
    }
    return localGrayGroupAppEntity.requestIntervalSecond;
  }
  
  public GrayGroupAppsDbHelper grayGroupAppsDbHelper()
  {
    return this.mGrayGroupAppsDbHelper;
  }
  
  public void onChange(boolean paramBoolean)
  {
    clearAll();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mGrayGroupAppsDbHelper = new GrayGroupAppsDbHelper(this.mApp);
    this.mFullListGroupAppsDbHelper = new FullListGroupAppsDbHelper(this.mApp);
    this.grayAppInfoMap = new ConcurrentHashMap(20);
    this.mTroopAppHander = ((TroopAppHandler)((AppInterface)this.mApp).getBusinessHandler(TroopAppHandler.class.getName()));
    this.fullAppsListInfos = new ArrayList(20);
    ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(this);
  }
  
  public void onDestroy()
  {
    ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).unregisterStudyModeChangeListener(this);
    this.grayAppInfoMap.clear();
  }
  
  public void requestClearRedDot(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt));
    this.mTroopAppHander.a(localArrayList, 0);
  }
  
  public void saveFullAppListHashInSp()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.mApp.getCurrentUin());
    localObject = ((StringBuilder)localObject).toString();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_KEY_FULL_APP_LIST_HASH");
    localStringBuilder.append((String)localObject);
    localEditor.putString(localStringBuilder.toString(), this.fullAppListHash);
    localEditor.apply();
  }
  
  public void setFullAppListHash(String paramString)
  {
    this.fullAppListHash = paramString;
  }
  
  public void setFullAppsListInfos(List<TroopAIOAppInfo> paramList)
  {
    this.fullAppsListInfos = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAioAppServiceImpl
 * JD-Core Version:    0.7.0.1
 */