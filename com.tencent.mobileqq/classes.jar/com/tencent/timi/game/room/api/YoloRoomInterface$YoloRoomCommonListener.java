package com.tencent.timi.game.room.api;

import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

public abstract interface YoloRoomInterface$YoloRoomCommonListener
  extends YoloRoomInterface.IYoloRoomListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(long paramLong, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void a(String paramString, int paramInt, YoloRoomOuterClass.YoloBattleOBStatusChangeAction paramYoloBattleOBStatusChangeAction);
  
  public abstract void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void a(YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt, YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo);
  
  public abstract void b(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void b(long paramLong);
  
  public abstract void b(long paramLong, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void b(List<YoloRoomOuterClass.YoloRoomModifyInfoActionContent> paramList);
  
  public abstract void c(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void c(long paramLong);
  
  public abstract void d(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList);
  
  public abstract void d(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener
 * JD-Core Version:    0.7.0.1
 */