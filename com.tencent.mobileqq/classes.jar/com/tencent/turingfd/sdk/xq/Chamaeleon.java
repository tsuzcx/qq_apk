package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;

public final class Chamaeleon
  implements GalacticCore
{
  public void a(String paramString, MotionEvent paramMotionEvent)
  {
    paramString = Cygnus.obtain();
    paramString.action = paramMotionEvent.getAction();
    paramString.wh = paramMotionEvent.getDeviceId();
    paramString.toolType = paramMotionEvent.getToolType(0);
    paramString.xh = paramMotionEvent.getRawX();
    paramString.yh = paramMotionEvent.getRawY();
    paramString.pressure = paramMotionEvent.getPressure();
    paramString.size = paramMotionEvent.getSize();
    Crux.kh.obtainMessage(1, paramString).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Chamaeleon
 * JD-Core Version:    0.7.0.1
 */