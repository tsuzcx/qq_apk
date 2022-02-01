package com.tencent.timi.game.room.impl.util;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.ui.widget.CustomToastView;
import trpc.yes.common.YoloRoomOuterClass.SafeCheckResult;

class YoloRoomUtil$7$1
  implements Runnable
{
  YoloRoomUtil$7$1(YoloRoomUtil.7 param7, YoloRoomOuterClass.SafeCheckResult paramSafeCheckResult) {}
  
  public void run()
  {
    CustomToastView.a(this.a.check_msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.7.1
 * JD-Core Version:    0.7.0.1
 */