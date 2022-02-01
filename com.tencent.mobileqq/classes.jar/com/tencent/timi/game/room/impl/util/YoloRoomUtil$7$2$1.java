package com.tencent.timi.game.room.impl.util;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRecoverRsp;

class YoloRoomUtil$7$2$1
  implements RequestListener<YoloRoomOuterClass.YoloRoomRecoverRsp>
{
  YoloRoomUtil$7$2$1(YoloRoomUtil.7.2 param2, long paramLong, int paramInt) {}
  
  public void a(YoloRoomOuterClass.YoloRoomRecoverRsp paramYoloRoomRecoverRsp, FromServiceMsg paramFromServiceMsg)
  {
    if (paramYoloRoomRecoverRsp != null)
    {
      YoloRoomList.a().a(0, paramYoloRoomRecoverRsp.room_info, paramYoloRoomRecoverRsp.room_speaking_pos_list.get(), paramYoloRoomRecoverRsp.speaking_pos_list_version.get(), paramYoloRoomRecoverRsp.cur_action_id.get(), paramYoloRoomRecoverRsp.room_conf, paramYoloRoomRecoverRsp.room_user_data);
    }
    else
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("createYoloRoom - YoloRoomRecover rsp is null! roomId = ");
      paramFromServiceMsg.append(this.a);
      Logger.c("YoloRoomUtil", paramFromServiceMsg.toString());
    }
    if (this.c.c.c == this.b)
    {
      paramFromServiceMsg = this.c.c.a;
      YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = null;
      if (paramFromServiceMsg != null)
      {
        localObject = this.c.c.a;
        if (paramYoloRoomRecoverRsp != null) {
          paramFromServiceMsg = paramYoloRoomRecoverRsp.room_info;
        } else {
          paramFromServiceMsg = null;
        }
        ((IResultListener)localObject).a(paramFromServiceMsg);
      }
      if ((!this.c.c.b) && (YoloRoomUtil.c()))
      {
        YoloRoomUtil.a(paramYoloRoomRecoverRsp.room_info);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createYoloRoom, autoJumpMainPage ");
      if (paramYoloRoomRecoverRsp != null) {
        paramFromServiceMsg = paramYoloRoomRecoverRsp.room_info.room_id;
      } else {
        paramFromServiceMsg = "null";
      }
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
      paramFromServiceMsg = TimiGameActivityManager.a();
      if (paramFromServiceMsg == null) {
        paramFromServiceMsg = Env.a();
      }
      if (paramYoloRoomRecoverRsp != null) {
        localYoloRoomInfo = paramYoloRoomRecoverRsp.room_info;
      }
      YoloRoomUtil.a(paramFromServiceMsg, localYoloRoomInfo, 1);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.YoloRoomRecoverRsp paramYoloRoomRecoverRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString1 = new StringBuilder();
    paramString1.append("createYoloRoom - YoloRoomRecover rsp is null! roomId = ");
    paramString1.append(this.a);
    Logger.c("YoloRoomUtil", paramString1.toString());
    if ((this.c.c.c == this.b) && (this.c.c.a != null)) {
      this.c.c.a.a(this.c.a, this.c.b);
    }
    YoloRoomUtil.a(this.a, true, this.b, new YoloRoomUtil.7.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.7.2.1
 * JD-Core Version:    0.7.0.1
 */