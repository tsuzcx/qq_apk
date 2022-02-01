package com.tencent.timi.game.team.impl;

import com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamActivity$11
  implements IResultListener<IUserInfo>
{
  TeamActivity$11(TeamActivity paramTeamActivity, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(IUserInfo paramIUserInfo)
  {
    TeamActivity.a(this.b).a(paramIUserInfo.e(this.a.user_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.11
 * JD-Core Version:    0.7.0.1
 */