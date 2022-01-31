package com.tencent.mobileqq.highway.netprobe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class WeakNetLearner$ProbeHandler
  extends Handler
{
  public static final int START = 1;
  
  public WeakNetLearner$ProbeHandler(WeakNetLearner paramWeakNetLearner, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ((ProbeTask)paramMessage.obj).startProbe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.WeakNetLearner.ProbeHandler
 * JD-Core Version:    0.7.0.1
 */