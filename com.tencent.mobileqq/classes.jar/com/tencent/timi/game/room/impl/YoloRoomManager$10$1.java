package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class YoloRoomManager$10$1
  implements DoYoloRoomCmdResultListsner
{
  YoloRoomManager$10$1(YoloRoomManager.10 param10, YoloRoomMediaLogic paramYoloRoomMediaLogic) {}
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("上麦失败, ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    CustomToastView.a(localStringBuilder.toString());
    if (this.b.d != null) {
      this.b.d.a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      YoloRoomManager.f(this.b.e);
    }
    YoloRoomMediaLogic localYoloRoomMediaLogic = this.a;
    if (localYoloRoomMediaLogic != null)
    {
      localYoloRoomMediaLogic.a(true);
      this.a.b(this.b.a);
    }
    if (this.b.d != null) {
      this.b.d.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.10.1
 * JD-Core Version:    0.7.0.1
 */