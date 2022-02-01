package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopMemberInfoService
  extends IRuntimeService
{
  public static final int INVALID_UIN = -100;
  public static final String IS_FIRST_UPGRADE_TO_500 = "is_first_upgrade_to_500";
  public static final int VALUE_INVALID = -100;
  
  public abstract void addTroopMemberUpdateObserver(ITroopMemberInfoService.TroopMemberUpdateObserver paramTroopMemberUpdateObserver);
  
  public abstract boolean deleteTroopMember(String paramString1, String paramString2);
  
  public abstract boolean deleteTroopMember(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract boolean deleteTroopMembers(String paramString);
  
  public abstract List<TroopMemberInfo> enhanceTroopMemberList(String paramString, List<TroopMemberInfo> paramList);
  
  public abstract List<TroopMemberInfo> getAllTroopMembers(String paramString);
  
  public abstract TroopMemberInfo getTroopMember(String paramString1, String paramString2);
  
  public abstract TroopMemberInfo getTroopMemberInLruCache(String paramString1, String paramString2);
  
  public abstract void getTroopMemberInfo(String paramString1, String paramString2, ITroopMemberInfoService.ITroopMemberInfoCallBack paramITroopMemberInfoCallBack);
  
  public abstract TroopMemberInfo getTroopMemberInfoFromDb(String paramString1, String paramString2);
  
  public abstract ArrayList<TroopMemberInfo> getTroopMembersInLruCache(String paramString);
  
  public abstract void getTroopsMemberList();
  
  public abstract boolean isMemberInCache(String paramString1, String paramString2);
  
  public abstract void notifyChangeMember(String paramString1, String paramString2);
  
  public abstract void notifyGetTroopMembersFailed(String paramString);
  
  public abstract void notifyKickoutMember(String paramString1, String paramString2);
  
  public abstract void notifyQuitTroop(String paramString);
  
  public abstract void notifyTroopMembersUpdate(ArrayList<String> paramArrayList);
  
  public abstract void removeTroopMemberUpdateObserver(ITroopMemberInfoService.TroopMemberUpdateObserver paramTroopMemberUpdateObserver);
  
  public abstract void saveTroopMember(TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean);
  
  public abstract boolean saveTroopMember(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
  
  public abstract void saveTroopMemberCmduinFlagEx3(String paramString1, String paramString2, long paramLong);
  
  public abstract boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble);
  
  public abstract boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12);
  
  public abstract boolean saveTroopMemberEx(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5);
  
  public abstract void saveTroopMemberInfoInLruCache(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo);
  
  public abstract void saveTroopMemberInfoToDB(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo);
  
  public abstract boolean saveTroopMembers(List<TroopMemberInfo> paramList);
  
  public abstract void updateTroopMemberCache(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopMemberInfoService
 * JD-Core Version:    0.7.0.1
 */