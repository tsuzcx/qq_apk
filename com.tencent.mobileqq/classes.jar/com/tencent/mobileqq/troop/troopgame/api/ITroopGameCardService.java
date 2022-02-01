package com.tencent.mobileqq.troop.troopgame.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopGameCardService
  extends IRuntimeService
{
  public abstract void getMemberGradeLevelInfoAsync(String paramString, ITroopGameCardService.CallbackInMainThread paramCallbackInMainThread);
  
  public abstract void saveMemberGradeLevelInfo(MemberGradeLevelInfo paramMemberGradeLevelInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService
 * JD-Core Version:    0.7.0.1
 */