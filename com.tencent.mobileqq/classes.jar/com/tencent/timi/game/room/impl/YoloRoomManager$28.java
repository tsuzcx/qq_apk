package com.tencent.timi.game.room.impl;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomPushSwitch;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSetOptionReq;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSetOptionRsp;

class YoloRoomManager$28
  implements RequestListener<YoloRoomOuterClass.YoloRoomSetOptionRsp>
{
  public void a(YoloRoomOuterClass.YoloRoomSetOptionRsp paramYoloRoomSetOptionRsp, FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("YoloRoomManager", "setUserOptionsReq - onSuccess");
    if ((this.a.push_switch.has()) && (paramYoloRoomSetOptionRsp != null) && (paramYoloRoomSetOptionRsp.push_switch.has())) {
      this.c.a(paramYoloRoomSetOptionRsp.push_switch);
    }
    paramFromServiceMsg = this.b;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(paramYoloRoomSetOptionRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.YoloRoomSetOptionRsp paramYoloRoomSetOptionRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString1 = new StringBuilder();
    paramString1.append("setUserOptionsReq - onError");
    paramString1.append(paramInt2);
    paramString1.append(" ");
    paramString1.append(paramString2);
    Logger.c("YoloRoomManager", paramString1.toString());
    paramString1 = this.b;
    if (paramString1 != null) {
      paramString1.a(paramInt2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.28
 * JD-Core Version:    0.7.0.1
 */