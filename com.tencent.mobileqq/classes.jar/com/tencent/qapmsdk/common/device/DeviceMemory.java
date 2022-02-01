package com.tencent.qapmsdk.common.device;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceMemory;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceMemory
{
  public static final DeviceMemory.Companion Companion = new DeviceMemory.Companion(null);
  private static final String TAG = "QAPM_common_DeviceMemory";
  
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public static final long getScPageSize(long paramLong)
  {
    return Companion.getScPageSize(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceMemory
 * JD-Core Version:    0.7.0.1
 */