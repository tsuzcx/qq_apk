package com.tencent.mobileqq.bubble;

import antw;
import com.tencent.qphone.base.util.QLog;

public class QQAnimationDrawable$SerialExecutor$1
  implements Runnable
{
  public QQAnimationDrawable$SerialExecutor$1(antw paramantw, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      QLog.d("QQAnimationDrawable", 2, "SerialExecutor run");
      this.a.run();
      return;
    }
    finally
    {
      QLog.d("QQAnimationDrawable", 2, "SerialExecutor scheduleNext");
      this.this$0.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable.SerialExecutor.1
 * JD-Core Version:    0.7.0.1
 */