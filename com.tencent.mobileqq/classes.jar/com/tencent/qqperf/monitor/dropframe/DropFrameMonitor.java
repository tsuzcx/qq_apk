package com.tencent.qqperf.monitor.dropframe;

import android.annotation.TargetApi;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.monitor.base.IAPMDropFrame;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@TargetApi(16)
public class DropFrameMonitor
{
  private static long b;
  private static DropFrameMonitor c;
  DropFrameMonitor.DropFrameCallback a;
  
  public static void a()
  {
    b = SystemClock.uptimeMillis();
  }
  
  public static DropFrameMonitor b()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new DropFrameMonitor();
        }
      }
      finally {}
    }
    return c;
  }
  
  private static boolean c()
  {
    return 2 == MobileQQ.sProcessId;
  }
  
  @NotNull
  public HashMap<String, String> a(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((DropFrameMonitor.DropFrameCallback)localObject).a(paramString, paramLong1, paramLong2, paramArrayOfLong);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tag = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", dropCount = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfLong));
      ((StringBuilder)localObject).append(", totalMs = ");
      ((StringBuilder)localObject).append(paramLong1);
      Log.d("AutoMonitor.DropFrame", ((StringBuilder)localObject).toString());
    }
    c();
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("dropCount", String.valueOf(paramLong2));
    localHashMap.put("totalMs", String.valueOf(paramLong1));
    localHashMap.put("scene", paramString);
    localHashMap.put("dropTimes", Arrays.toString(paramArrayOfLong));
    localHashMap.put("oldSmoothRate", String.valueOf(paramDouble1));
    localHashMap.put("newSmoothRate", String.valueOf(paramDouble2));
    localHashMap.put("preciseSmoothRate", String.valueOf(paramDouble3));
    localHashMap.put("isFirstLaunch", String.valueOf(DeviceOptSwitch.r));
    if (b > 0L) {
      paramLong1 = SystemClock.uptimeMillis() - b;
    } else {
      paramLong1 = -1L;
    }
    localHashMap.put("intervalAfterSyncMsg", String.valueOf(paramLong1));
    localHashMap.put("hcState", String.valueOf(HardCoderManager.getInstance().getState()));
    if (DeviceOptSwitch.p)
    {
      paramLong1 = System.currentTimeMillis();
      paramLong2 = DeviceOptSwitch.q;
      String str2 = "-1";
      if (paramLong2 == -1L) {
        paramString = "-1";
      } else {
        paramString = String.valueOf(paramLong1 - DeviceOptSwitch.q);
      }
      if (DeviceOptSwitch.m != 0L) {
        paramArrayOfLong = String.valueOf(paramLong1 - DeviceOptSwitch.m);
      } else {
        paramArrayOfLong = "-1";
      }
      if (DeviceOptSwitch.l != 0L) {
        localObject = String.valueOf(paramLong1 - DeviceOptSwitch.l);
      } else {
        localObject = "-1";
      }
      String str1;
      if (DeviceOptSwitch.o != 0L) {
        str1 = String.valueOf(paramLong1 - DeviceOptSwitch.o);
      } else {
        str1 = "-1";
      }
      if (DeviceOptSwitch.n != 0L) {
        str2 = String.valueOf(paramLong1 - DeviceOptSwitch.n);
      }
      localHashMap.put("perfConfigReportValue", String.valueOf(DeviceOptSwitch.k));
      localHashMap.put("qZoneInterval", paramArrayOfLong);
      localHashMap.put("miniInterval", localObject);
      localHashMap.put("troopListInterval", str1);
      localHashMap.put("preDownloadInterval", str2);
      localHashMap.put("automatorFinishtime", paramString);
    }
    UnifiedMonitor.a().addEvent(9, null, 0, 0, localHashMap);
    return localHashMap;
  }
  
  public void a(String paramString)
  {
    MagnifierSDK.b().f().a(paramString);
    if (paramString.equals("qzone_homepage"))
    {
      HardCoderManager.getInstance().start(0, 1, 1, 0, 1500, 701, 32L, Process.myTid(), "qzoneList", false);
      return;
    }
    if (paramString.equals("list_photo")) {
      HardCoderManager.getInstance().start(0, 1, 1, 0, 1500, 702, 32L, Process.myTid(), "photoList", false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    MagnifierSDK.b().f().b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.dropframe.DropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */