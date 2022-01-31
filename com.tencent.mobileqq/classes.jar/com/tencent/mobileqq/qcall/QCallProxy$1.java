package com.tencent.mobileqq.qcall;

import awwk;
import com.tencent.qphone.base.util.QLog;

public class QCallProxy$1
  implements Runnable
{
  public QCallProxy$1(awwk paramawwk) {}
  
  public void run()
  {
    try
    {
      this.this$0.d();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QCallProxy", 2, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.1
 * JD-Core Version:    0.7.0.1
 */