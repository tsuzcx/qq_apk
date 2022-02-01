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
  private static long jdField_a_of_type_Long;
  private static DropFrameMonitor jdField_a_of_type_ComTencentQqperfMonitorDropframeDropFrameMonitor;
  DropFrameMonitor.DropFrameCallback jdField_a_of_type_ComTencentQqperfMonitorDropframeDropFrameMonitor$DropFrameCallback;
  
  public static DropFrameMonitor a()
  {
    if (jdField_a_of_type_ComTencentQqperfMonitorDropframeDropFrameMonitor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfMonitorDropframeDropFrameMonitor == null) {
          jdField_a_of_type_ComTencentQqperfMonitorDropframeDropFrameMonitor = new DropFrameMonitor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfMonitorDropframeDropFrameMonitor;
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  private static boolean a()
  {
    return 2 == MobileQQ.sProcessId;
  }
  
  @NotNull
  public HashMap<String, String> a(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqperfMonitorDropframeDropFrameMonitor$DropFrameCallback;
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
    a();
    double d1 = paramArrayOfLong[4];
    Double.isNaN(d1);
    double d2 = paramArrayOfLong[5];
    Double.isNaN(d2);
    double d3 = paramArrayOfLong[0];
    Double.isNaN(d3);
    double d4 = paramArrayOfLong[1];
    Double.isNaN(d4);
    double d5 = paramArrayOfLong[2];
    Double.isNaN(d5);
    double d6 = paramArrayOfLong[3];
    Double.isNaN(d6);
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("dropCount", String.valueOf(paramLong2));
    localHashMap.put("totalMs", String.valueOf(paramLong1));
    localHashMap.put("scene", paramString);
    localHashMap.put("dropTimes", Arrays.toString(paramArrayOfLong));
    localHashMap.put("isFirstLaunch", String.valueOf(DeviceOptSwitch.k));
    if (jdField_a_of_type_Long > 0L) {
      paramLong1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
    } else {
      paramLong1 = -1L;
    }
    localHashMap.put("intervalAfterSyncMsg", String.valueOf(paramLong1));
    localHashMap.put("hcState", String.valueOf(HardCoderManager.a().a()));
    localHashMap.put("dropFenzi", String.valueOf(d1 * 200.04000000000002D + d2 * 266.72000000000003D));
    localHashMap.put("dropFenzi2", String.valueOf(d3 * 16.699999999999999D + d4 * 25.049999999999997D + d5 * 50.099999999999994D + d6 * 100.19999999999999D));
    if (DeviceOptSwitch.j)
    {
      paramLong1 = System.currentTimeMillis();
      paramLong2 = DeviceOptSwitch.e;
      String str2 = "-1";
      if (paramLong2 == -1L) {
        paramString = "-1";
      } else {
        paramString = String.valueOf(paramLong1 - DeviceOptSwitch.e);
      }
      if (DeviceOptSwitch.b != 0L) {
        paramArrayOfLong = String.valueOf(paramLong1 - DeviceOptSwitch.b);
      } else {
        paramArrayOfLong = "-1";
      }
      if (DeviceOptSwitch.jdField_a_of_type_Long != 0L) {
        localObject = String.valueOf(paramLong1 - DeviceOptSwitch.jdField_a_of_type_Long);
      } else {
        localObject = "-1";
      }
      String str1;
      if (DeviceOptSwitch.d != 0L) {
        str1 = String.valueOf(paramLong1 - DeviceOptSwitch.d);
      } else {
        str1 = "-1";
      }
      if (DeviceOptSwitch.c != 0L) {
        str2 = String.valueOf(paramLong1 - DeviceOptSwitch.c);
      }
      localHashMap.put("perfConfigReportValue", String.valueOf(String.valueOf(DeviceOptSwitch.jdField_a_of_type_Int)));
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
    MagnifierSDK.a().a().a(paramString);
    if (paramString.equals("qzone_homepage"))
    {
      HardCoderManager.a().a(0, 1, 1, 0, 1500, 701, 32L, Process.myTid(), "qzoneList", false);
      return;
    }
    if (paramString.equals("list_photo")) {
      HardCoderManager.a().a(0, 1, 1, 0, 1500, 702, 32L, Process.myTid(), "photoList", false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    MagnifierSDK.a().a().b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.dropframe.DropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */