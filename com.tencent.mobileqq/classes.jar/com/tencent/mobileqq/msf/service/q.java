package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class q
  extends Thread
{
  public void run()
  {
    try
    {
      Thread.sleep(3000L);
      localHashMap = new HashMap();
      localObject1 = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses();
      int k = Process.myPid();
      int j = 2147483647;
      localObject1 = ((List)localObject1).iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("process info: ");
          localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject2).processName);
          localStringBuilder.append(" ");
          localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
          localStringBuilder.append(" ");
          localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject2).uid);
          QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString());
        }
      } while (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals("com.tencent.mobileqq"));
      int i = ((ActivityManager.RunningAppProcessInfo)localObject2).pid;
      localHashMap.clear();
      localHashMap.put("DEVICE", Build.DEVICE);
      localHashMap.put("PRODUCT", Build.PRODUCT);
      localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
      localHashMap.put("MODEL", Build.MODEL);
      localHashMap.put("RELEASE", Build.VERSION.RELEASE);
      localHashMap.put("FROM", MsfService.access$000());
      if (k < i) {
        localHashMap.put("WAY", "Daemon");
      } else {
        localHashMap.put("WAY", "QQ");
      }
      if (MsfService.core.statReporter == null) {
        break label318;
      }
      localObject1 = MsfService.core.statReporter;
      if (k >= i) {
        break label466;
      }
      bool = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HashMap localHashMap;
        Object localObject1;
        Object localObject2;
        StringBuilder localStringBuilder;
        label318:
        label332:
        continue;
        label466:
        boolean bool = false;
      }
    }
    ((j)localObject1).a("msfstartway", bool, 0L, 0L, localHashMap, false, false);
    break label332;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.MsfService", 1, "upload start way fail: RDM NULL!");
    }
    if (QLog.isColorLevel())
    {
      localObject1 = localHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload map: ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(":");
        localStringBuilder.append((String)localHashMap.get(localObject2));
        QLog.d("MSF.S.MsfService", 1, localStringBuilder.toString());
      }
    }
    k.a(MsfService.core.statReporter, false);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.MsfService", 1, "upload start way fail : InterruptedException!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.q
 * JD-Core Version:    0.7.0.1
 */