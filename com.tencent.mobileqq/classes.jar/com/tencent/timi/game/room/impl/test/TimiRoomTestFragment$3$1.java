package com.tencent.timi.game.room.impl.test;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

class TimiRoomTestFragment$3$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  TimiRoomTestFragment$3$1(TimiRoomTestFragment.3 param3) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp)
  {
    CustomToastView.a("退房成功");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.3.1
 * JD-Core Version:    0.7.0.1
 */