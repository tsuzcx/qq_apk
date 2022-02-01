package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;

final class p
  extends Thread
{
  p(long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.a - MsfService.serviceInitStart);
    ((HashMap)localObject1).put("msfCoreCost", ((StringBuilder)localObject2).toString());
    if (MsfService.core.statReporter != null)
    {
      localObject2 = MsfService.core.statReporter;
      boolean bool;
      if (this.b > 2000L) {
        bool = false;
      } else {
        bool = true;
      }
      ((j)localObject2).a("msfInitCost", bool, this.b, 0L, (Map)localObject1, false, false);
    }
    com.tencent.mobileqq.msf.core.k.c();
    localObject1 = BaseApplication.getContext().getSharedPreferences("crashcontrol", 4);
    int j = ((SharedPreferences)localObject1).getInt("countRecvKillMsf", 0);
    int i;
    if (j > 0)
    {
      if (MsfService.core.statReporter != null)
      {
        i = 0;
        while (i < j)
        {
          MsfService.core.statReporter.a("countRecvKillMsf", true, 0L, 0L, null, false, false);
          i += 1;
        }
      }
      ((SharedPreferences)localObject1).edit().putInt("countRecvKillMsf", 0).commit();
    }
    j = ((SharedPreferences)localObject1).getInt("countMsfRealExit", 0);
    if (j > 0)
    {
      if (MsfService.core.statReporter != null)
      {
        i = 0;
        while (i < j)
        {
          MsfService.core.statReporter.a("countMsfRealExit", true, 0L, 0L, null, false, false);
          i += 1;
        }
      }
      ((SharedPreferences)localObject1).edit().putInt("countMsfRealExit", 0).commit();
    }
    try
    {
      Thread.sleep(5000L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    k.b();
    k.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.p
 * JD-Core Version:    0.7.0.1
 */