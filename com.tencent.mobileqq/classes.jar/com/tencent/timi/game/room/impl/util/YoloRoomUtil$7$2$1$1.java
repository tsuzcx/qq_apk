package com.tencent.timi.game.room.impl.util;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

class YoloRoomUtil$7$2$1$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  YoloRoomUtil$7$2$1$1(YoloRoomUtil.7.2.1 param1) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createYoloRoom - YoloRoomRecover YoloRoomLeave ERROR roomId = ");
    localStringBuilder.append(this.a.a);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    Logger.c("YoloRoomUtil", localStringBuilder.toString());
  }
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp)
  {
    paramYoloRoomLeaveRsp = new StringBuilder();
    paramYoloRoomLeaveRsp.append("createYoloRoom - YoloRoomRecover YoloRoomLeave SUCCESS roomId = ");
    paramYoloRoomLeaveRsp.append(this.a.a);
    Logger.c("YoloRoomUtil", paramYoloRoomLeaveRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.7.2.1.1
 * JD-Core Version:    0.7.0.1
 */