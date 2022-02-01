package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.qphone.base.util.QLog;

class m$f
  implements Runnable
{
  private n b;
  
  public m$f(m paramm, n paramn)
  {
    this.b = paramn;
  }
  
  public void run()
  {
    n localn = this.b;
    if (localn != null) {
      try
      {
        localn.h();
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call loginConnectTimeOut error ");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m.f
 * JD-Core Version:    0.7.0.1
 */