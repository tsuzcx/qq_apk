package com.tencent.timi.game.room.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.DoYoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.SafeCheckResult;

class YoloRoomManager$44
  implements RequestListener<YoloRoomOuterClass.DoYoloRoomCmdRsp>
{
  YoloRoomManager$44(YoloRoomManager paramYoloRoomManager, long paramLong, int paramInt, DoYoloRoomCmdResultListsner paramDoYoloRoomCmdResultListsner) {}
  
  public void a(YoloRoomOuterClass.DoYoloRoomCmdRsp paramDoYoloRoomCmdRsp, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = YoloRoomManager.b(this.d, this.a);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("doYoloRoomCmd - ");
    paramFromServiceMsg.append(this.b);
    paramFromServiceMsg.append("， Success,  hasClientTidHandled = ");
    paramFromServiceMsg.append(bool);
    Logger.a("YoloRoomManager", paramFromServiceMsg.toString());
    String str = "";
    if (paramDoYoloRoomCmdRsp != null)
    {
      paramFromServiceMsg = paramDoYoloRoomCmdRsp.yolo_room_cmd_rsp;
      DoYoloRoomCmdResultListsner localDoYoloRoomCmdResultListsner = this.c;
      if (localDoYoloRoomCmdResultListsner != null) {
        localDoYoloRoomCmdResultListsner.a(paramFromServiceMsg, this.a, bool);
      }
      paramFromServiceMsg = str;
      if (paramDoYoloRoomCmdRsp.safe_check_result != null)
      {
        paramFromServiceMsg = str;
        if (paramDoYoloRoomCmdRsp.safe_check_result.has())
        {
          paramDoYoloRoomCmdRsp = paramDoYoloRoomCmdRsp.safe_check_result;
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("doYoloRoomCmd - ");
          paramFromServiceMsg.append(this.b);
          paramFromServiceMsg.append(", safeCheckResult = ");
          paramFromServiceMsg.append(paramDoYoloRoomCmdRsp.code.get());
          paramFromServiceMsg.append(" - ");
          paramFromServiceMsg.append(paramDoYoloRoomCmdRsp.check_msg.get());
          Logger.c("YoloRoomManager", paramFromServiceMsg.toString());
          paramFromServiceMsg = str;
          if (paramDoYoloRoomCmdRsp.code.get() != 0)
          {
            paramFromServiceMsg = str;
            if (!TextUtils.isEmpty(paramDoYoloRoomCmdRsp.check_msg.get())) {
              paramFromServiceMsg = paramDoYoloRoomCmdRsp.check_msg.get();
            }
          }
        }
      }
    }
    else
    {
      paramDoYoloRoomCmdRsp = this.c;
      paramFromServiceMsg = str;
      if (paramDoYoloRoomCmdRsp != null)
      {
        paramDoYoloRoomCmdRsp.a(null, this.a, bool);
        paramFromServiceMsg = str;
      }
    }
    if (!TextUtils.isEmpty(paramFromServiceMsg))
    {
      CustomToastView.a(true, paramFromServiceMsg);
      return;
    }
    if (this.b == 14) {
      CustomToastView.a("修改设置成功");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.DoYoloRoomCmdRsp paramDoYoloRoomCmdRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramBoolean = YoloRoomManager.b(this.d, this.a);
    paramString1 = new StringBuilder();
    paramString1.append("doYoloRoomCmd - ");
    paramString1.append(this.b);
    paramString1.append("， onError,  hasClientTidHandled = ");
    paramString1.append(paramBoolean);
    paramString1.append(", errorCode = ");
    paramString1.append(paramInt2);
    paramString1.append(", errorMessage = ");
    paramString1.append(paramString2);
    Logger.c("YoloRoomManager", paramString1.toString());
    YoloRoomUtil.a(paramInt2);
    if (paramInt2 == 920017)
    {
      YoloRoomManager.m(this.d).a(paramInt2, paramString2);
      YoloRoomManager.a(this.d, paramInt2, paramString2);
    }
    if ((paramInt2 == 920009) || (paramInt2 == 920003)) {
      YoloRoomManager.p(this.d);
    }
    paramString1 = this.c;
    if (paramString1 != null) {
      paramString1.a(paramInt2, paramString2, this.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.44
 * JD-Core Version:    0.7.0.1
 */