package com.tencent.rmonitor.device.device;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/device/DeviceStore$Companion;", "", "()V", "TAG", "", "getBlockSize", "", "path", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceStore$Companion
{
  @JvmStatic
  @TargetApi(18)
  public final long a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    try
    {
      long l = new StatFs(paramString).getBlockSizeLong();
      return l;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      localLogger = Logger.b;
      paramString = localNoSuchMethodError.getMessage();
      if (paramString == null) {
        paramString = "NoSuchMethodError";
      }
      localLogger.d(new String[] { "RMonitor_common_DeviceStore", paramString, ": StatFs not method blockSizeLong" });
    }
    try
    {
      paramString = Environment.getExternalStorageDirectory();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Environment.getExternalStorageDirectory()");
      int i = new StatFs(paramString.getPath()).getBlockSize();
      return i;
    }
    catch (NoSuchMethodError paramString)
    {
      label94:
      break label94;
    }
    Logger localLogger = Logger.b;
    paramString = localNoSuchMethodError.getMessage();
    if (paramString == null) {
      paramString = "NoSuchMethodError";
    }
    localLogger.d(new String[] { "RMonitor_common_DeviceStore", paramString, ": StatFs not method blockSize" });
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.device.DeviceStore.Companion
 * JD-Core Version:    0.7.0.1
 */