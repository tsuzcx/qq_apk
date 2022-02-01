package com.tencent.mobileqq.bubble;

import com.tencent.qphone.base.util.QLog;

class QQAnimationDrawable$SerialExecutor$1
  implements Runnable
{
  QQAnimationDrawable$SerialExecutor$1(QQAnimationDrawable.SerialExecutor paramSerialExecutor, Runnable paramRunnable) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable.SerialExecutor.1
 * JD-Core Version:    0.7.0.1
 */