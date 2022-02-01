package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

class YoloRoomManager$8
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  YoloRoomManager$8(YoloRoomManager paramYoloRoomManager, boolean paramBoolean1, IResultListener paramIResultListener, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(int paramInt, String paramString)
  {
    if (!this.a)
    {
      YoloRoomManager.b(this.e, false);
      if (this.c)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("退出房间失败, ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(")");
        CustomToastView.a(((StringBuilder)localObject).toString());
      }
      YoloRoomManager.c(this.e, this.d);
      Object localObject = this.b;
      if (localObject != null) {
        ((IResultListener)localObject).a(paramInt, paramString);
      }
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp)
  {
    if (!this.a)
    {
      YoloRoomManager.b(this.e);
      IResultListener localIResultListener = this.b;
      if (localIResultListener != null) {
        localIResultListener.a(paramYoloRoomLeaveRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.8
 * JD-Core Version:    0.7.0.1
 */