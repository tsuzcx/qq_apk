package com.tencent.timi.game.team.impl.main;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

final class TeamConfigPageHelper$4
  implements IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{
  TeamConfigPageHelper$4(TeamConfigDialog paramTeamConfigDialog) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("modify room setting failed: errorCode == ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",errorMessage == ");
    localStringBuilder.append(paramString);
    Logger.c("TeamConfigPageHelper", localStringBuilder.toString());
    this.a.r();
    this.a.dismiss();
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp)
  {
    Logger.a("TeamConfigPageHelper", "modify room setting success");
    this.a.r();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigPageHelper.4
 * JD-Core Version:    0.7.0.1
 */