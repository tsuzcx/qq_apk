package com.tencent.timi.game.teamlist.service;

import java.util.List;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

public abstract interface TeamInfoAutoUpdateService$AutoUpdateServiceListener
{
  public abstract List<Long> a();
  
  public abstract void a(String paramString, List<MessageOuterClass.ShareYoloRoomMsg> paramList, List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList1, List<Long> paramList2);
  
  public abstract List<Long> b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.AutoUpdateServiceListener
 * JD-Core Version:    0.7.0.1
 */