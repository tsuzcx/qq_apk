package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.ITroopInfoCallback;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopInfoService
  extends IRuntimeService
{
  public static final boolean COMMONLY_USED_TROOP_SYNC_TO_RECENT_USER = true;
  
  public abstract boolean addCommonlyUsedTroop(String paramString, long paramLong);
  
  public abstract void addTroop(TroopInfo paramTroopInfo);
  
  public abstract void addTroops(List<TroopInfo> paramList);
  
  public abstract void asyncGetTroopInfo(String paramString, ITroopInfoCallback paramITroopInfoCallback);
  
  public abstract void buildTroopUI();
  
  public abstract boolean clearPassiveExitTroopInfo(String paramString);
  
  public abstract void deleteTroop(String paramString);
  
  public abstract boolean deleteTroop(String paramString, boolean paramBoolean);
  
  public abstract void deleteTroopList(List<String> paramList);
  
  public abstract void deleteTroopWithoutDB(String paramString);
  
  public abstract TroopInfo findTroopInfo(String paramString);
  
  public abstract TroopInfo findTroopInfo(String paramString, boolean paramBoolean);
  
  public abstract TroopInfo findTroopInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract TroopInfo findTroopInfoInUI(String paramString);
  
  public abstract List<TroopInfo> getAllTroopList();
  
  public abstract CommonlyUsedTroop getCommonlyUsedTroop(String paramString);
  
  public abstract ConcurrentHashMap<String, Entity> getCommonlyUsedTroopCache();
  
  public abstract List<CommonlyUsedTroop> getCommonlyUsedTroopList();
  
  public abstract EntityTransaction getEntityTransaction();
  
  public abstract long getInsertJoinTroopMsgTime(String paramString);
  
  public abstract String getTroopCodeByTroopUin(String paramString);
  
  public abstract void getTroopCodeByTroopUinAsync(String paramString, ITroopInfoService.GetTroopCodeCallback paramGetTroopCodeCallback);
  
  public abstract TroopInfo getTroopInfo(String paramString);
  
  public abstract TroopInfo getTroopInfoFromCache(String paramString);
  
  public abstract ArrayList<String> getTroopMemberForTroopHead(String paramString);
  
  public abstract String getTroopNameByID(String paramString);
  
  public abstract String getTroopUin(String paramString);
  
  public abstract String getTroopUinByTroopCode(String paramString);
  
  public abstract ArrayList<Entity> getUiTroopList();
  
  public abstract ArrayList<Entity> getUiTroopListWithoutBlockedTroop();
  
  public abstract List<Long> getUinList();
  
  public abstract boolean hasNoTroop();
  
  public abstract void initAndBuildTroopUI();
  
  public abstract boolean isCommonlyUsedTroop(String paramString);
  
  public abstract boolean isHomeworkTroop(String paramString);
  
  public abstract boolean isQidianPrivateTroop(String paramString);
  
  public abstract boolean isTroopCacheInited();
  
  public abstract void prePareCommonlyUsedTroop(Map<String, Long> paramMap);
  
  public abstract void preloadData(ArrayList<String> paramArrayList);
  
  public abstract void refreshCommonlyUsedTroop();
  
  public abstract boolean removeCommonlyUsedTroop(String paramString);
  
  public abstract void saveTroopInfo(TroopInfo paramTroopInfo);
  
  public abstract void saveTroopInfoOnlyCacheAndDB(TroopInfo paramTroopInfo);
  
  public abstract TroopInfo saveTroopName(String paramString1, String paramString2);
  
  public abstract void saveTroops(ArrayList<TroopInfo> paramArrayList);
  
  public abstract void saveTroops(ArrayList<TroopInfo> paramArrayList, long paramLong);
  
  public abstract void setInsertJoinTroopMsgTime(String paramString, long paramLong);
  
  public abstract void setTroopEliminated(List<String> paramList);
  
  public abstract boolean updateEntity(Entity paramEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopInfoService
 * JD-Core Version:    0.7.0.1
 */