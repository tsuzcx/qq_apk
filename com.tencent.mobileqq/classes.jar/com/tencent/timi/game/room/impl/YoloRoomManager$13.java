package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class YoloRoomManager$13
  implements DoYoloRoomCmdResultListsner
{
  YoloRoomManager$13(YoloRoomManager paramYoloRoomManager, IResultListener paramIResultListener, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.b) {
      localObject = "打开麦位";
    } else {
      localObject = "关闭麦位";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("失败, ");
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
      YoloRoomManager.f(this.c);
    }
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.13
 * JD-Core Version:    0.7.0.1
 */