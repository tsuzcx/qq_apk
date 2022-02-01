package com.tencent.mobileqq.vas.updatesystem;

import bhdf;
import bhdg;
import bhdh;
import com.tencent.qphone.base.util.QLog;

public class VasUpdateEngineProxy$1
  implements Runnable
{
  public VasUpdateEngineProxy$1(bhdh parambhdh) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (bhdg.a())
    {
      bhdh.a(this.this$0);
      bhdh.a(this.this$0).startUpdateAllItem();
    }
    for (;;)
    {
      QLog.e("VasUpdateEngineProxy", 1, "VasUpdate startUpdateAllItem current consume = " + (System.currentTimeMillis() - l));
      return;
      bhdh.a(this.this$0).startUpdateAllItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateEngineProxy.1
 * JD-Core Version:    0.7.0.1
 */