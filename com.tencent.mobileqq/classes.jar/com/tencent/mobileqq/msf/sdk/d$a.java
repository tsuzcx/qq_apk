package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.a.a.d;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class d$a
  extends a.d
{
  private d$a(d paramd) {}
  
  public void b()
  {
    d.a(this.a).set(true);
    if (QLog.isColorLevel()) {
      QLog.d(d.l(), 2, "startRefresh ");
    }
  }
  
  public void c()
  {
    d.a(this.a).set(false);
    if (QLog.isColorLevel()) {
      QLog.d(d.l(), 2, "refreshFinished ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */