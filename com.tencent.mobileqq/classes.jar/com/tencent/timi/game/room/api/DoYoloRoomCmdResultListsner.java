package com.tencent.timi.game.room.api;

import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

public abstract interface DoYoloRoomCmdResultListsner
{
  public abstract void a(int paramInt, String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner
 * JD-Core Version:    0.7.0.1
 */