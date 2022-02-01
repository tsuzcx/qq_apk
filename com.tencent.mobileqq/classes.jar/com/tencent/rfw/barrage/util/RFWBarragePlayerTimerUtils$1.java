package com.tencent.rfw.barrage.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class RFWBarragePlayerTimerUtils$1
  extends Handler
{
  RFWBarragePlayerTimerUtils$1(RFWBarragePlayerTimerUtils paramRFWBarragePlayerTimerUtils, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    RFWBarragePlayerTimerUtils.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarragePlayerTimerUtils.1
 * JD-Core Version:    0.7.0.1
 */