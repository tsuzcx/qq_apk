package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class YoloRoomManager$30
  implements DoYoloRoomCmdResultListsner
{
  YoloRoomManager$30(YoloRoomManager paramYoloRoomManager, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      YoloRoomManager.f(this.b);
    }
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.30
 * JD-Core Version:    0.7.0.1
 */