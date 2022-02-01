package com.tencent.qqperf.tools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qqperf.opt.suspendthread.LowEndPerfBean;
import com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceInfoUtils
{
  private static final int LEVEL_HIGH = 1;
  private static final int LEVEL_LOW = 3;
  private static final int LEVEL_MEDIUM = 2;
  private static final int LEVEL_UNKNOWN = 0;
  private static final long REQUEST_INTERVAL = -1702967296L;
  public static final String TAG = "DeviceInfoUtils";
  private static long sLastRequestTime = 0L;
  private static int sPerfLevelLocal;
  private static int sPerfLevelRemote;
  private static AtomicBoolean sRequestPost = new AtomicBoolean(false);
  
  public static int getPerfLevel()
  {
    int i = getPerfLevelRemote();
    if (i != 0) {
      return i;
    }
    if (sPerfLevelLocal == 0) {
      sPerfLevelLocal = getPerfLevelLocal();
    }
    return sPerfLevelLocal;
  }
  
  private static int getPerfLevelLocal()
  {
    int j = DeviceOptSwitch.a().getInt("localLevel", 0);
    int i = j;
    if (j == 0)
    {
      i = DeviceInfoUtil.h();
      long l1 = DeviceInfoUtil.l();
      long l2 = DeviceInfoUtil.a();
      if ((i >= 8) && (l1 >= 2000000L) && (l2 >= 5368709120L)) {
        i = 1;
      } else if ((i > 6) && (l2 > 3221225472L)) {
        i = 2;
      } else {
        i = 3;
      }
    }
    DeviceOptSwitch.a().edit().putInt("localLevel", i).apply();
    return i;
  }
  
  private static int getPerfLevelRemote()
  {
    int i = sPerfLevelRemote;
    if (i != 0) {
      return i;
    }
    if (LowEndPerfProcessor.a().a())
    {
      if (sPerfLevelRemote != 0)
      {
        sPerfLevelRemote = 0;
        DeviceOptSwitch.a().edit().putInt("device_perf_level", 0).apply();
      }
      return 0;
    }
    SharedPreferences localSharedPreferences = DeviceOptSwitch.a();
    sPerfLevelRemote = localSharedPreferences.getInt("device_perf_level", 0);
    i = sPerfLevelRemote;
    if (i != 0) {
      return i;
    }
    if (sLastRequestTime == 0L) {
      sLastRequestTime = localSharedPreferences.getLong("device_perf_level_timestamps", 0L);
    }
    if (Math.abs(sLastRequestTime - System.currentTimeMillis()) < -1702967296L) {
      return sPerfLevelRemote;
    }
    if (!sRequestPost.compareAndSet(false, true)) {
      return sPerfLevelRemote;
    }
    ThreadManagerV2.excute(new DeviceInfoUtils.1(localSharedPreferences), 128, null, true);
    return sPerfLevelRemote;
  }
  
  public static boolean isHighPerfDevice()
  {
    return getPerfLevel() == 1;
  }
  
  public static boolean isLowPerfDevice()
  {
    return getPerfLevel() == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.DeviceInfoUtils
 * JD-Core Version:    0.7.0.1
 */