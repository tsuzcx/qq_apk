package com.tencent.mobileqq.qqlive.trtc.utils;

import android.os.Handler;
import android.os.Looper;

public class TRTCThreadHelper
{
  public static void a(Handler paramHandler, Runnable paramRunnable)
  {
    if (paramHandler == null)
    {
      paramRunnable.run();
      return;
    }
    if (Looper.myLooper() != paramHandler.getLooper())
    {
      paramHandler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.utils.TRTCThreadHelper
 * JD-Core Version:    0.7.0.1
 */