package com.tencent.timi.game.room.impl.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.room.api.IRoomOperationService;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRecoverRsp;

final class YoloRoomUtil$4
  implements RequestListener<YoloRoomOuterClass.YoloRoomRecoverRsp>
{
  YoloRoomUtil$4(TimiGameBaseActivity paramTimiGameBaseActivity, long paramLong, int paramInt, boolean paramBoolean) {}
  
  public void a(YoloRoomOuterClass.YoloRoomRecoverRsp paramYoloRoomRecoverRsp, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.b();
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("recoverRoom success ");
    paramFromServiceMsg.append(this.b);
    paramFromServiceMsg.append(" - ");
    paramFromServiceMsg.append(this.c);
    paramFromServiceMsg.append(" - needJumpToRoomPage ");
    paramFromServiceMsg.append(this.d);
    Logger.a("YoloRoomUtil", paramFromServiceMsg.toString());
    if (paramYoloRoomRecoverRsp != null)
    {
      ((IRoomOperationService)ServiceCenter.a(IRoomOperationService.class)).a(this.b, paramYoloRoomRecoverRsp.rotate_messsage_list.get());
      YoloRoomList.a().a(2, paramYoloRoomRecoverRsp.room_info, paramYoloRoomRecoverRsp.room_speaking_pos_list.get(), paramYoloRoomRecoverRsp.speaking_pos_list_version.get(), paramYoloRoomRecoverRsp.cur_action_id.get(), paramYoloRoomRecoverRsp.room_conf, paramYoloRoomRecoverRsp.room_user_data);
      if ((!this.d) && (YoloRoomUtil.c()))
      {
        YoloRoomUtil.a(paramYoloRoomRecoverRsp.room_info);
        return;
      }
      YoloRoomUtil.a(Env.a(), paramYoloRoomRecoverRsp.room_info, 3);
      return;
    }
    paramYoloRoomRecoverRsp = new StringBuilder();
    paramYoloRoomRecoverRsp.append("handleLoginRsp - YoloRoomRecover rsp is null! roomId = ");
    paramYoloRoomRecoverRsp.append(this.b);
    Logger.c("YoloRoomUtil", paramYoloRoomRecoverRsp.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.YoloRoomRecoverRsp paramYoloRoomRecoverRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.b();
    }
    paramString2 = new StringBuilder();
    paramString2.append("handleLoginRsp - YoloRoomRecover onError roomId = ");
    paramString2.append(this.b);
    paramString2.append(" - ");
    paramString2.append(paramInt2);
    paramString2.append(" - ");
    paramString2.append(paramString1);
    Logger.c("YoloRoomUtil", paramString2.toString());
    paramYoloRoomRecoverRsp = "";
    paramInt1 = 1;
    if (paramInt2 == 920017)
    {
      paramString2 = "房间已被封禁";
    }
    else if (paramInt2 == 920009)
    {
      paramString2 = "你已不在房间";
    }
    else if (paramInt2 == 920003)
    {
      paramString2 = "房间已关闭";
    }
    else if (paramInt2 == 920010)
    {
      paramString2 = "状态异常";
    }
    else
    {
      paramString2 = "";
      paramInt1 = 0;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      CustomToastView.a(paramString2);
    }
    else if (paramInt2 != 9200200)
    {
      paramString2 = new StringBuilder();
      paramString2.append("恢复房间失败, ");
      paramString2.append(paramString1);
      paramString1 = paramYoloRoomRecoverRsp;
      if (Env.b())
      {
        paramString1 = new StringBuilder();
        paramString1.append("\nDebugOnly(");
        paramString1.append(paramInt2);
        paramString1.append(")");
        paramString1 = paramString1.toString();
      }
      paramString2.append(paramString1);
      CustomToastView.a(paramString2.toString());
    }
    if (paramInt1 != 0)
    {
      paramString1 = new StringBuilder();
      paramString1.append("handleLoginRsp - YoloRoomRecover needManualExitRoom roomId = ");
      paramString1.append(this.b);
      Logger.c("YoloRoomUtil", paramString1.toString());
      YoloRoomUtil.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.4
 * JD-Core Version:    0.7.0.1
 */