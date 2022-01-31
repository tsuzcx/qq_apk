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
    if (AndroidVersion.Companion.isL()) {}
    for (;;)
    {
      try
      {
        long l2 = Os.sysconf(OsConstants._SC_PAGESIZE);
        l1 = l2;
        if (l2 <= 0L) {
          l1 = Os.sysconf(OsConstants._SC_PAGE_SIZE);
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.d(new String[] { "QAPM_common_DeviceMemory", localException + ": get system page size failed." });
        l1 = 0L;
        continue;
      }
      if (l1 > 0L) {
        paramLong = l1;
      }
      return paramLong;
      long l1 = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceMemory.Companion
 * JD-Core Version:    0.7.0.1
 */