package com.tencent.timi.game.room.impl.util;

import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

final class YoloRoomUtil$2
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  YoloRoomUtil$2(long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("退出房间失败, ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    CustomToastView.a(localStringBuilder.toString());
  }
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp)
  {
    YoloRoomList.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.2
 * JD-Core Version:    0.7.0.1
 */