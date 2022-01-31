package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class p
  extends Thread
{
  public void run()
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        Thread.sleep(3000L);
        HashMap localHashMap = new HashMap();
        Object localObject1 = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses();
        int j = Process.myPid();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label417;
        }
        Object localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.MsfService", 1, "process info: " + ((ActivityManager.RunningAppProcessInfo)localObject2).processName + " " + ((ActivityManager.RunningAppProcessInfo)localObject2).pid + " " + ((ActivityManager.RunningAppProcessInfo)localObject2).uid);
        }
        if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals("com.tencent.mobileqq")) {
          continue;
        }
        i = ((ActivityManager.RunningAppProcessInfo)localObject2).pid;
        localHashMap.clear();
        localHashMap.put("DEVICE", Build.DEVICE);
        localHashMap.put("PRODUCT", Build.PRODUCT);
        localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
        localHashMap.put("MODEL", Build.MODEL);
        localHashMap.put("RELEASE", Build.VERSION.RELEASE);
        localHashMap.put("FROM", MsfService.access$000());
        if (j < i)
        {
          localHashMap.put("WAY", "Daemon");
          if (MsfService.core.statReporter == null) {
            break label389;
          }
          localObject1 = MsfService.core.statReporter;
          if (j < i) {
            bool = true;
          }
          ((k)localObject1).a("msfstartway", bool, 0L, 0L, localHashMap, false, false);
          if (!QLog.isColorLevel()) {
            break label406;
          }
          localObject1 = localHashMap.keySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label406;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          QLog.d("MSF.S.MsfService", 1, "upload map: " + (String)localObject2 + ":" + (String)localHashMap.get(localObject2));
          continue;
        }
        localThrowable.put("WAY", "QQ");
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.MsfService", 1, "upload start way fail : InterruptedException!");
        }
        return;
      }
      continue;
      label389:
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.S.MsfService", 1, "upload start way fail: RDM NULL!");
        continue;
        label406:
        j.a(MsfService.core.statReporter, false);
        return;
        label417:
        i = 2147483647;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.p
 * JD-Core Version:    0.7.0.1
 */