package com.tencent.timi.game.team.impl;

import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamActivity$10
  extends SimpleYoloRoomCommonListener
{
  TeamActivity$10(TeamActivity paramTeamActivity) {}
  
  public void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamActivity.a(this.a, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.10
 * JD-Core Version:    0.7.0.1
 */