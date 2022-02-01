package com.tencent.timi.game.room.impl.test;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class TimiRoomTestFragment$2$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomInfo>
{
  TimiRoomTestFragment$2$1(TimiRoomTestFragment.2 param2) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    CustomToastView.a("DebugToast\n加入房间成功，跳转房间页");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("testRoom JOIN SUCCESS - ");
    localStringBuilder.append(paramYoloRoomInfo);
    Logger.a("TimiRoomTestFragment", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.2.1
 * JD-Core Version:    0.7.0.1
 */