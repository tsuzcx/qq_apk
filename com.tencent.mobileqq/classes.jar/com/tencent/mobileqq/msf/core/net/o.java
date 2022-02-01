package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class o
  implements Runnable
{
  o(n paramn, int paramInt, CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, ArrayList paramArrayList) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asyncSelectAndConnect threadId: ");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append(", threadName");
    localStringBuilder.append(Thread.currentThread().getName());
    localStringBuilder.append(", connID");
    localStringBuilder.append(this.a);
    QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
    if (!n.a(this.e, this.b, this.c, this.d, this.a)) {
      this.e.i.a(-1, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.o
 * JD-Core Version:    0.7.0.1
 */