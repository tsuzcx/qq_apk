package com.tencent.timi.game.room.impl.util;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.room.api.IRoomOperationService;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

final class YoloRoomUtil$3
  implements RequestListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  YoloRoomUtil$3(long paramLong, IResultListener paramIResultListener) {}
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("sendExitRoomNetReq ");
    paramFromServiceMsg.append(this.a);
    paramFromServiceMsg.append(" - SUCCESS");
    Logger.a("YoloRoomUtil", paramFromServiceMsg.toString());
    paramFromServiceMsg = this.b;
    if (paramFromServiceMsg != null)
    {
      paramFromServiceMsg.a(paramYoloRoomLeaveRsp);
      ((IRoomOperationService)ServiceCenter.a(IRoomOperationService.class)).a(this.a);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString2 = new StringBuilder();
    paramString2.append("sendExitRoomNetReq ");
    paramString2.append(this.a);
    paramString2.append(" - ERROR ");
    paramString2.append(paramInt2);
    paramString2.append(" - ");
    paramString2.append(paramString1);
    Logger.c("YoloRoomUtil", paramString2.toString());
    paramString2 = this.b;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.3
 * JD-Core Version:    0.7.0.1
 */