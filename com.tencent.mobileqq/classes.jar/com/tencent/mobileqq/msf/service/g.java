package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.p;
import java.util.HashMap;

final class g
  extends Thread
{
  g(long paramLong1, long paramLong2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msfCoreCost", "" + (this.a - MsfService.serviceInitStart));
    j localj;
    if (MsfService.core.statReporter != null)
    {
      localj = MsfService.core.statReporter;
      if (this.b <= 2000L) {
        break label89;
      }
    }
    label89:
    for (boolean bool = false;; bool = true)
    {
      localj.a("msfInitCost", bool, this.b, 0L, localHashMap, false, false);
      p.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.g
 * JD-Core Version:    0.7.0.1
 */