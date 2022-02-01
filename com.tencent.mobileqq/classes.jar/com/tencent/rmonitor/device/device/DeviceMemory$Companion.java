package com.tencent.rmonitor.device.device;

import android.annotation.SuppressLint;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.AndroidVersion.Companion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/device/DeviceMemory$Companion;", "", "()V", "TAG", "", "getScPageSize", "", "defaultPageSize", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceMemory$Companion
{
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public final long a(long paramLong)
  {
    long l1;
    if (AndroidVersion.a.d()) {
      try
      {
        long l2 = Os.sysconf(OsConstants._SC_PAGESIZE);
        l1 = l2;
        if (l2 > 0L) {
          break label98;
        }
        l1 = Os.sysconf(OsConstants._SC_PAGE_SIZE);
      }
      catch (Exception localException)
      {
        Logger localLogger = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localException);
        localStringBuilder.append(": get system page size failed.");
        localLogger.d(new String[] { "RMonitor_common_DeviceMemory", localStringBuilder.toString() });
        l1 = 0L;
      }
    } else {
      l1 = paramLong;
    }
    label98:
    if (l1 > 0L) {
      paramLong = l1;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.device.DeviceMemory.Companion
 * JD-Core Version:    0.7.0.1
 */