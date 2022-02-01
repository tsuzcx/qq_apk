package com.tencent.mobileqq.widget;

class QQToast$ProtectedToast$InternalRunnable
  implements Runnable
{
  private final Runnable a;
  
  QQToast$ProtectedToast$InternalRunnable(QQToast.ProtectedToast paramProtectedToast, Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ProtectedToast.InternalRunnable
 * JD-Core Version:    0.7.0.1
 */