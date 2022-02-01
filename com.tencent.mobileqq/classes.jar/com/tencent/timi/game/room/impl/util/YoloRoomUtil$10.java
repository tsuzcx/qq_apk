package com.tencent.timi.game.room.impl.util;

import com.tencent.timi.game.room.api.RoomInterceptCheckCallback;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

final class YoloRoomUtil$10
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  YoloRoomUtil$10(RoomInterceptCheckCallback paramRoomInterceptCheckCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    RoomInterceptCheckCallback localRoomInterceptCheckCallback = this.a;
    if (localRoomInterceptCheckCallback != null) {
      localRoomInterceptCheckCallback.a(paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp)
  {
    paramYoloRoomLeaveRsp = this.a;
    if (paramYoloRoomLeaveRsp != null) {
      paramYoloRoomLeaveRsp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.10
 * JD-Core Version:    0.7.0.1
 */