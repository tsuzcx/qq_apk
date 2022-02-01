package com.tencent.mobileqq.vas.updatesystem;

import bhuj;
import bhuk;
import bhul;
import com.tencent.qphone.base.util.QLog;

public class VasUpdateEngineProxy$1
  implements Runnable
{
  public VasUpdateEngineProxy$1(bhul parambhul) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (bhuk.a())
    {
      bhul.a(this.this$0);
      bhul.a(this.this$0).startUpdateAllItem();
    }
    for (;;)
    {
      QLog.e("VasUpdateEngineProxy", 1, "VasUpdate startUpdateAllItem current consume = " + (System.currentTimeMillis() - l));
      return;
      bhul.a(this.this$0).startUpdateAllItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateEngineProxy.1
 * JD-Core Version:    0.7.0.1
 */