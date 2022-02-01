package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class YoloRoomManager$11
  implements DoYoloRoomCmdResultListsner
{
  YoloRoomManager$11(YoloRoomManager paramYoloRoomManager, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("下麦失败, ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(")");
    CustomToastView.a(((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      YoloRoomManager.f(this.b);
    }
    if (YoloRoomManager.d(this.b) != null) {
      YoloRoomManager.d(this.b).a(false);
    }
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.11
 * JD-Core Version:    0.7.0.1
 */