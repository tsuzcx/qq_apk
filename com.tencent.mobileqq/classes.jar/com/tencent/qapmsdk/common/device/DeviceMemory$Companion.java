package com.tencent.qapmsdk.common.device;

import android.annotation.SuppressLint;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AndroidVersion.Companion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceMemory$Companion;", "", "()V", "TAG", "", "getScPageSize", "", "defaultPageSize", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceMemory$Companion
{
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public final long getScPageSize(long paramLong)
  {
    long l1;
    if (AndroidVersion.Companion.isL()) {
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
        Logger localLogger = Logger.INSTANCE;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localException);
        localStringBuilder.append(": get system page size failed.");
        localLogger.d(new String[] { "QAPM_common_DeviceMemory", localStringBuilder.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceMemory.Companion
 * JD-Core Version:    0.7.0.1
 */