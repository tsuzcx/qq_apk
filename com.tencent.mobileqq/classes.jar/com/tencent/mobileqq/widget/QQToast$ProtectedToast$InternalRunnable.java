package com.tencent.mobileqq.widget;

class QQToast$ProtectedToast$InternalRunnable
  implements Runnable
{
  private final Runnable mRunnable;
  
  QQToast$ProtectedToast$InternalRunnable(QQToast.ProtectedToast paramProtectedToast, Runnable paramRunnable)
  {
    this.mRunnable = paramRunnable;
  }
  
  public void run()
  {
    try
    {
      this.mRunnable.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ProtectedToast.InternalRunnable
 * JD-Core Version:    0.7.0.1
 */