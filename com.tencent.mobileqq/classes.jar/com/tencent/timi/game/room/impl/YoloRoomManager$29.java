package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSetOptionRsp;

class YoloRoomManager$29
  implements IResultListener<YoloRoomOuterClass.YoloRoomSetOptionRsp>
{
  public void a(int paramInt, String paramString)
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomSetOptionRsp paramYoloRoomSetOptionRsp)
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null)
    {
      if (paramYoloRoomSetOptionRsp != null) {
        paramYoloRoomSetOptionRsp = paramYoloRoomSetOptionRsp.push_switch;
      } else {
        paramYoloRoomSetOptionRsp = null;
      }
      localIResultListener.a(paramYoloRoomSetOptionRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.29
 * JD-Core Version:    0.7.0.1
 */