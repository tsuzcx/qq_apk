package com.tencent.mobileqq.troop.troopgag.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopgag.data.MemberGagInfo;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopGagService
  extends IRuntimeService
{
  public abstract SelfGagInfo getSelfGagInfo(String paramString, boolean paramBoolean);
  
  public abstract MemberGagInfo getTroopMemberGagInfo(String paramString1, String paramString2);
  
  public abstract ArrayList<MemberGagInfo> getTroopMemberGagList(String paramString);
  
  public abstract void saveAndUpdateTroopMemberGagStatus(String paramString1, String paramString2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.ITroopGagService
 * JD-Core Version:    0.7.0.1
 */