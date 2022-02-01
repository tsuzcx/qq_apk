package com.tencent.qapmsdk.common.device;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceCpu;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceCpu
{
  public static final DeviceCpu.Companion Companion = new DeviceCpu.Companion(null);
  private static final String TAG = "QAPM_common_DeviceCpu";
  private static int cores;
  
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public static final long getScClkTck(long paramLong)
  {
    return Companion.getScClkTck(paramLong);
  }
  
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public static final long getScNProcessorsConf(long paramLong)
  {
    return Companion.getScNProcessorsConf(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceCpu
 * JD-Core Version:    0.7.0.1
 */