package com.tencent.timi.game.room.impl.util;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoRsp;

final class YoloRoomUtil$11
  implements RequestListener<UserProxyCmdOuterClass.GetUserRouteInfoRsp>
{
  YoloRoomUtil$11(long paramLong, IResultListener paramIResultListener) {}
  
  public void a(UserProxyCmdOuterClass.GetUserRouteInfoRsp paramGetUserRouteInfoRsp, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("getUserOnlineRouteInfoList_");
    paramFromServiceMsg.append(this.a);
    paramFromServiceMsg.append(" - onSuccess");
    Logger.a("YoloRoomUtil", paramFromServiceMsg.toString());
    paramFromServiceMsg = this.b;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(paramGetUserRouteInfoRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable UserProxyCmdOuterClass.GetUserRouteInfoRsp paramGetUserRouteInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString1 = new StringBuilder();
    paramString1.append("getUserOnlineRouteInfoList_");
    paramString1.append(this.a);
    paramString1.append(" - onError - ");
    paramString1.append(paramInt2);
    paramString1.append(" ");
    paramString1.append(paramString2);
    Logger.c("YoloRoomUtil", paramString1.toString());
    paramString1 = this.b;
    if (paramString1 != null) {
      paramString1.a(paramInt2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.11
 * JD-Core Version:    0.7.0.1
 */