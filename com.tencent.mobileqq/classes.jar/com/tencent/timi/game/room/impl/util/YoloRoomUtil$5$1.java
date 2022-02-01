package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.room.api.IRoomOperationService;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommonConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class YoloRoomUtil$5$1
  implements RequestListener<YoloRoomOuterClass.YoloRoomEnterRsp>
{
  YoloRoomUtil$5$1(YoloRoomUtil.5 param5) {}
  
  public void a(YoloRoomOuterClass.YoloRoomEnterRsp paramYoloRoomEnterRsp, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("enterYoloRoom SUCCESS ");
    paramFromServiceMsg.append(this.a.a);
    paramFromServiceMsg.append(", autoJumpMainPage= ");
    paramFromServiceMsg.append(this.a.i);
    Logger.a("YoloRoomUtil", paramFromServiceMsg.toString());
    if (paramYoloRoomEnterRsp != null)
    {
      ((IRoomOperationService)ServiceCenter.a(IRoomOperationService.class)).a(this.a.a, paramYoloRoomEnterRsp.rotate_messsage_list.get());
      YoloRoomList.a().a(1, paramYoloRoomEnterRsp.room_info, paramYoloRoomEnterRsp.room_speaking_pos_list.get(), paramYoloRoomEnterRsp.speaking_pos_list_version.get(), paramYoloRoomEnterRsp.cur_action_id.get(), paramYoloRoomEnterRsp.room_conf, paramYoloRoomEnterRsp.room_user_data);
    }
    if ((paramYoloRoomEnterRsp != null) && (paramYoloRoomEnterRsp.room_conf.has()) && (paramYoloRoomEnterRsp.room_conf.yolo_room_common_conf.has()))
    {
      paramFromServiceMsg = YoloRoomList.a().b(this.a.a);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(paramYoloRoomEnterRsp.room_info.room_id.get(), paramYoloRoomEnterRsp.room_conf.yolo_room_common_conf.forbidden_speech_conf_list.get());
      }
    }
    if ((this.a.b != null) && ((this.a.b instanceof TimiGameBaseActivity)) && (!this.a.b.isFinishing())) {
      ((TimiGameBaseActivity)this.a.b).b();
    }
    paramFromServiceMsg = this.a.j;
    Object localObject1 = null;
    if (paramFromServiceMsg != null)
    {
      localObject2 = this.a.j;
      if (paramYoloRoomEnterRsp != null) {
        paramFromServiceMsg = paramYoloRoomEnterRsp.room_info;
      } else {
        paramFromServiceMsg = null;
      }
      ((IResultListener)localObject2).a(paramFromServiceMsg);
    }
    if ((!this.a.i) && (YoloRoomUtil.c()))
    {
      YoloRoomUtil.a(paramYoloRoomEnterRsp.room_info);
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("enterYoloRoom, autoJumpMainPage ");
    paramFromServiceMsg.append(this.a.a);
    Logger.a("YoloRoomUtil", paramFromServiceMsg.toString());
    Object localObject2 = this.a.b;
    paramFromServiceMsg = localObject1;
    if (paramYoloRoomEnterRsp != null) {
      paramFromServiceMsg = paramYoloRoomEnterRsp.room_info;
    }
    YoloRoomUtil.a((Context)localObject2, paramFromServiceMsg, 2);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.YoloRoomEnterRsp paramYoloRoomEnterRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString1 = new StringBuilder();
    paramString1.append("enterYoloRoom ERROR ");
    paramString1.append(this.a.a);
    paramString1.append(", errorCode=");
    paramString1.append(paramInt2);
    paramString1.append(", errorMessage=");
    paramString1.append(paramString2);
    Logger.c("YoloRoomUtil", paramString1.toString());
    if ((this.a.b != null) && ((this.a.b instanceof TimiGameBaseActivity)) && (!this.a.b.isFinishing())) {
      ((TimiGameBaseActivity)this.a.b).b();
    }
    if (!paramBoolean) {
      paramString2 = "网络不给力";
    }
    if (!YoloRoomUtil.a(this.a.d, paramInt2, paramString2)) {
      if (!TextUtils.isEmpty(paramString2)) {
        CustomToastView.a(paramString2);
      } else {
        CustomToastView.a("加入失败，请稍后重试");
      }
    }
    if (this.a.j != null) {
      this.a.j.a(paramInt2, paramString2);
    }
    paramString1 = this.a;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("err_");
      paramString2.append(paramInt2);
      paramString2 = paramString2.toString();
    }
    YoloRoomUtil.5.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.5.1
 * JD-Core Version:    0.7.0.1
 */