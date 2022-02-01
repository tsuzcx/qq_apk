package com.tencent.timi.game.room.impl.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import com.yolo.esports.room.api.IRoomOperationService;
import trpc.yes.common.YoloRoomOuterClass.SafeCheckResult;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCreateRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

final class YoloRoomUtil$7
  implements RequestListener<YoloRoomOuterClass.YoloRoomCreateRsp>
{
  YoloRoomUtil$7(IResultListener paramIResultListener, boolean paramBoolean, int paramInt) {}
  
  public void a(YoloRoomOuterClass.YoloRoomCreateRsp paramYoloRoomCreateRsp, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("createYoloRoom SUCCESS ");
    paramFromServiceMsg.append(paramYoloRoomCreateRsp);
    Logger.a("YoloRoomUtil", paramFromServiceMsg.toString());
    if (paramYoloRoomCreateRsp != null)
    {
      ((IRoomOperationService)ServiceCenter.a(IRoomOperationService.class)).a(paramYoloRoomCreateRsp.room_info.room_id.get(), paramYoloRoomCreateRsp.rotate_messsage_list.get());
      YoloRoomList.a().a(0, paramYoloRoomCreateRsp.room_info, paramYoloRoomCreateRsp.room_speaking_pos_list.get(), paramYoloRoomCreateRsp.speaking_pos_list_version.get(), 0L, paramYoloRoomCreateRsp.room_conf, paramYoloRoomCreateRsp.room_user_data);
    }
    Object localObject = this.a;
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = null;
    if (localObject != null)
    {
      if (paramYoloRoomCreateRsp != null) {
        paramFromServiceMsg = paramYoloRoomCreateRsp.room_info;
      } else {
        paramFromServiceMsg = null;
      }
      ((IResultListener)localObject).a(paramFromServiceMsg);
    }
    if ((!this.b) && (YoloRoomUtil.c()))
    {
      YoloRoomUtil.a(paramYoloRoomCreateRsp.room_info);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createYoloRoom, autoJumpMainPage ");
      if (paramYoloRoomCreateRsp != null) {
        paramFromServiceMsg = paramYoloRoomCreateRsp.room_info.room_id;
      } else {
        paramFromServiceMsg = "null";
      }
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
      paramFromServiceMsg = TimiGameActivityManager.a();
      if (paramFromServiceMsg == null) {
        paramFromServiceMsg = Env.a();
      }
      if (paramYoloRoomCreateRsp != null) {
        localYoloRoomInfo = paramYoloRoomCreateRsp.room_info;
      }
      YoloRoomUtil.a(paramFromServiceMsg, localYoloRoomInfo, 1);
    }
    if ((paramYoloRoomCreateRsp != null) && (paramYoloRoomCreateRsp.safe_check_result != null) && (paramYoloRoomCreateRsp.safe_check_result.has()))
    {
      paramYoloRoomCreateRsp = paramYoloRoomCreateRsp.safe_check_result;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("createYoloRoom, safeCheckResult = ");
      paramFromServiceMsg.append(paramYoloRoomCreateRsp.code.get());
      paramFromServiceMsg.append(" - ");
      paramFromServiceMsg.append(paramYoloRoomCreateRsp.check_msg.get());
      Logger.c("YoloRoomUtil", paramFromServiceMsg.toString());
      if ((paramYoloRoomCreateRsp.code.get() != 0) && (!TextUtils.isEmpty(paramYoloRoomCreateRsp.check_msg.get()))) {
        ThreadPool.a(new YoloRoomUtil.7.1(this, paramYoloRoomCreateRsp));
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.YoloRoomCreateRsp paramYoloRoomCreateRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if (paramBoolean) {
      paramInt1 = paramInt2;
    }
    if (!paramBoolean) {
      paramString2 = "网络不给力";
    }
    paramString1 = new StringBuilder();
    paramString1.append("createYoloRoom ERROR ");
    paramString1.append(paramInt1);
    paramString1.append(", errorMessage=");
    paramString1.append(paramString2);
    Logger.c("YoloRoomUtil", paramString1.toString());
    if (paramInt2 == 120)
    {
      YoloRoomUtil.a(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(), new YoloRoomUtil.7.2(this, paramInt1, paramString2));
      return;
    }
    paramString1 = this.a;
    if (paramString1 != null) {
      paramString1.a(paramInt1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.7
 * JD-Core Version:    0.7.0.1
 */