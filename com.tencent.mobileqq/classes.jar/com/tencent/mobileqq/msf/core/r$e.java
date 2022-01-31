package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.qphone.base.util.QLog;

class r$e
  implements Runnable
{
  private n b;
  
  public r$e(r paramr, n paramn)
  {
    this.b = paramn;
  }
  
  public void run()
  {
    if (this.b != null) {}
    try
    {
      this.b.h();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "call loginConnectTimeOut error " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.r.e
 * JD-Core Version:    0.7.0.1
 */