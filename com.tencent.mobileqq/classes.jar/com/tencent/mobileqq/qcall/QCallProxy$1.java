package com.tencent.mobileqq.qcall;

import com.tencent.qphone.base.util.QLog;

class QCallProxy$1
  implements Runnable
{
  QCallProxy$1(QCallProxy paramQCallProxy) {}
  
  public void run()
  {
    try
    {
      this.this$0.b();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QCallProxy", 2, localException.getMessage(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.1
 * JD-Core Version:    0.7.0.1
 */