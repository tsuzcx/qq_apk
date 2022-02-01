package com.tencent.mobileqq.troop.memberlevel.api;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;

@QAPI(process={"all"})
public abstract interface ITroopMemberLevelUtilsApi
  extends QRouteApi
{
  public abstract int convertOldLevelToNewLevel(int paramInt);
  
  public abstract int convertRealLevelToMapLevel(int paramInt);
  
  public abstract String getNewGroupMemberLevelJumpUrl();
  
  public abstract int[] getOnlyLevelColor();
  
  public abstract int[] getRankGradientColorByRankId(int paramInt);
  
  public abstract String getRankTitleByLevelInConfig(int paramInt);
  
  public abstract TroopMemberRankItem getTroopMemberRankItem(TroopInfo paramTroopInfo, String paramString1, int paramInt1, int paramInt2, String paramString2, byte paramByte);
  
  public abstract TroopMemberRankItem getTroopMemberRankItem_Unique(TroopInfo paramTroopInfo, String paramString1, String paramString2, byte paramByte);
  
  public abstract boolean hasNewGroupMemberLevelJumpUrl();
  
  public abstract boolean isNewRealLevelGrayTroop(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
 * JD-Core Version:    0.7.0.1
 */