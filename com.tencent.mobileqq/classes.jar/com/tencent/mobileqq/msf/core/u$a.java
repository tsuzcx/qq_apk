package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class u$a
  implements Runnable
{
  private int b = 0;
  
  public u$a(u paramu, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    ArrayList localArrayList = (ArrayList)this.a.a.sender.e.remove(Integer.valueOf(this.b));
    if (localArrayList != null) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "remove merged ssoseq list: " + localArrayList.toString() + " from SSO LoginMerge " + this.b);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MSF.C.NetConnTag", 2, "SSO LoginMerge's ssoseq " + this.b + "list has been removed by error code.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.u.a
 * JD-Core Version:    0.7.0.1
 */