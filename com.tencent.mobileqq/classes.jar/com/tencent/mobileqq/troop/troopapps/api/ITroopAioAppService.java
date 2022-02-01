package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.FullListGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopAioAppService
  extends IRuntimeService
{
  public abstract void afterUserLogin();
  
  public abstract void clearRedDotInCacheAndDb(int paramInt);
  
  public abstract FullListGroupAppsDbHelper fullListGroupAppsDbHelper();
  
  public abstract List<TroopAIOAppInfo> getAllAppsFromCache();
  
  public abstract List<TroopAIOAppInfo> getAppsFromCache(long paramLong);
  
  public abstract void getAppsInObserver(long paramLong);
  
  public abstract String getFullAppListHash();
  
  public abstract List<TroopAIOAppInfo> getFullAppsListInfos();
  
  public abstract ConcurrentHashMap<Long, GrayGroupAppEntity> getGrayAppInfoMap();
  
  public abstract String getGrayAppsHash(long paramLong);
  
  public abstract long getRequestIntervalSecond(long paramLong);
  
  public abstract GrayGroupAppsDbHelper grayGroupAppsDbHelper();
  
  public abstract void requestClearRedDot(int paramInt);
  
  public abstract void saveFullAppListHashInSp();
  
  public abstract void setFullAppListHash(String paramString);
  
  public abstract void setFullAppsListInfos(List<TroopAIOAppInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
 * JD-Core Version:    0.7.0.1
 */