package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class YoloRoomManager$33
  implements DoYoloRoomCmdResultListsner
{
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("操作失败, ");
    localStringBuilder.append(paramString);
    if (Env.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    CustomToastView.a(localStringBuilder.toString());
    Object localObject = this.a;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      YoloRoomManager.f(this.b);
    }
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null)
    {
      if (paramYoloRoomCmdRsp != null) {
        paramYoloRoomCmdRsp = paramYoloRoomCmdRsp.yolo_start_battle_ob_cmd_rsp;
      } else {
        paramYoloRoomCmdRsp = null;
      }
      localIResultListener.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.33
 * JD-Core Version:    0.7.0.1
 */