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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkDualConnPing: wait timeout: ");
    localStringBuilder.append(this.b);
    QLog.d("DualConnContext", 1, localStringBuilder.toString());
    this.a.a(-1, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n.b.a
 * JD-Core Version:    0.7.0.1
 */