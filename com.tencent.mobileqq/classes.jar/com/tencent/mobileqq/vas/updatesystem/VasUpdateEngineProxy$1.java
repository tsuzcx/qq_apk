package com.tencent.mobileqq.vas.updatesystem;

import bidp;
import bidq;
import bidr;
import com.tencent.qphone.base.util.QLog;

public class VasUpdateEngineProxy$1
  implements Runnable
{
  public VasUpdateEngineProxy$1(bidr parambidr) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (bidq.a())
    {
      bidr.a(this.this$0);
      bidr.a(this.this$0).startUpdateAllItem();
    }
    for (;;)
    {
      QLog.e("VasUpdateEngineProxy", 1, "VasUpdate startUpdateAllItem current consume = " + (System.currentTimeMillis() - l));
      return;
      bidr.a(this.this$0).startUpdateAllItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateEngineProxy.1
 * JD-Core Version:    0.7.0.1
 */