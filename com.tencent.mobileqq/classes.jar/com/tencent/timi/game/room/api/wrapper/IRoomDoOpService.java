package com.tencent.timi.game.room.api.wrapper;

import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomJoinGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoCmd;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomStartGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloUserGameData;

public abstract interface IRoomDoOpService
{
  public abstract void a(int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(long paramLong, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(long paramLong, boolean paramBoolean, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(YoloRoomOuterClass.YoloRoomModifyInfoCmd paramYoloRoomModifyInfoCmd, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(boolean paramBoolean, int paramInt, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(boolean paramBoolean, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void a(boolean paramBoolean, YoloRoomOuterClass.YoloUserGameData paramYoloUserGameData, IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
  
  public abstract void b(IResultListener<YoloRoomOuterClass.YoloRoomStartGameCmdRsp> paramIResultListener);
  
  public abstract void c(IResultListener<YoloRoomOuterClass.YoloRoomJoinGameCmdRsp> paramIResultListener);
  
  public abstract void d(IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp> paramIResultListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.wrapper.IRoomDoOpService
 * JD-Core Version:    0.7.0.1
 */