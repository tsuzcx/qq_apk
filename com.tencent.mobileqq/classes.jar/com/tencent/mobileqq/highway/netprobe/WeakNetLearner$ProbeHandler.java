package com.tencent.mobileqq.highway.netprobe;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class WeakNetLearner$ProbeHandler
  extends Handler
{
  public static final int QUIT = 2;
  public static final int START = 1;
  
  public WeakNetLearner$ProbeHandler(WeakNetLearner paramWeakNetLearner, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      WeakNetLearner.access$002(this.this$0, null);
      WeakNetLearner.access$100(this.this$0).quit();
      return;
    }
    ((ProbeTask)paramMessage.obj).startProbe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.WeakNetLearner.ProbeHandler
 * JD-Core Version:    0.7.0.1
 */