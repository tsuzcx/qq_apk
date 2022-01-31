package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.TimerTask;

class ReflectController$2$1
  extends TimerTask
{
  ReflectController$2$1(ReflectController.2 param2) {}
  
  public void run()
  {
    YTLogger.i("mCountDownTimer", "change to main:" + (System.currentTimeMillis() - ReflectController.access$1300(this.this$1.this$0)));
    if (!ReflectController.access$1500(this.this$1.this$0)) {
      ReflectController.access$1400(this.this$1.this$0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController.2.1
 * JD-Core Version:    0.7.0.1
 */