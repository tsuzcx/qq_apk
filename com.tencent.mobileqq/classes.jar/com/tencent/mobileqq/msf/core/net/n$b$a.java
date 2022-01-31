package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.QLog;

class n$b$a
  implements Runnable
{
  private int b;
  
  public n$b$a(n.b paramb, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    QLog.d("DualConnContext", 1, "checkDualConnPing: wait timeout: " + this.b);
    this.a.a(-1, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n.b.a
 * JD-Core Version:    0.7.0.1
 */