package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;

final class p
  extends Thread
{
  p(long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("msfCoreCost", "" + (this.a - MsfService.serviceInitStart));
    com.tencent.mobileqq.msf.core.c.k localk;
    if (MsfService.core.statReporter != null)
    {
      localk = MsfService.core.statReporter;
      if (this.b <= 2000L) {
        break label159;
      }
    }
    int i;
    label159:
    for (boolean bool = false;; bool = true)
    {
      localk.a("msfInitCost", bool, this.b, 0L, (Map)localObject, false, false);
      s.c();
      localObject = BaseApplication.getContext().getSharedPreferences("crashcontrol", 4);
      j = ((SharedPreferences)localObject).getInt("countRecvKillMsf", 0);
      if (j <= 0) {
        break label185;
      }
      if (MsfService.core.statReporter == null) {
        break;
      }
      i = 0;
      while (i < j)
      {
        MsfService.core.statReporter.a("countRecvKillMsf", true, 0L, 0L, null, false, false);
        i += 1;
      }
    }
    ((SharedPreferences)localObject).edit().putInt("countRecvKillMsf", 0).commit();
    label185:
    int j = ((SharedPreferences)localObject).getInt("countMsfRealExit", 0);
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
      ((SharedPreferences)localObject).edit().putInt("countMsfRealExit", 0).commit();
    }
    try
    {
      Thread.sleep(5000L);
      k.b();
      k.a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.p
 * JD-Core Version:    0.7.0.1
 */