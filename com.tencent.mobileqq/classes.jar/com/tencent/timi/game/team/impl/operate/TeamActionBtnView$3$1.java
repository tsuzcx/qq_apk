package com.tencent.timi.game.team.impl.operate;

import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomStartGameCmdRsp;

class TeamActionBtnView$3$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomStartGameCmdRsp>
{
  TeamActionBtnView$3$1(TeamActionBtnView.3 param3) {}
  
  public void a(int paramInt, String paramString)
  {
    TeamActionBtnView.a(this.a.e, paramInt, paramString, "host startGame");
  }
  
  public void a(YoloRoomOuterClass.YoloRoomStartGameCmdRsp paramYoloRoomStartGameCmdRsp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.3.1
 * JD-Core Version:    0.7.0.1
 */