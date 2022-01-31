package com.tencent.viola.commons;

import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaLogUtils;

class ViolaThread$SafeRunnable
  implements Runnable
{
  static final String TAG = "SafeRunnable";
  final Runnable mTask;
  
  ViolaThread$SafeRunnable(Runnable paramRunnable)
  {
    this.mTask = paramRunnable;
  }
  
  public void run()
  {
    try
    {
      if (this.mTask != null) {
        this.mTask.run();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!ViolaEnvironment.isDebugable()) {}
      ViolaLogUtils.e("SafeRunnable", "SafeRunnable run throw expection:" + localThrowable.getMessage());
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.commons.ViolaThread.SafeRunnable
 * JD-Core Version:    0.7.0.1
 */