package com.tencent.timi.game.team.impl.operate;

import java.util.List;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

public abstract interface ITeamActionBtn
{
  public abstract void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList, long paramLong, int paramInt, YoloBattleSmobaOuterClass.YoloSmobaOneSchema paramYoloSmobaOneSchema, YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.ITeamActionBtn
 * JD-Core Version:    0.7.0.1
 */