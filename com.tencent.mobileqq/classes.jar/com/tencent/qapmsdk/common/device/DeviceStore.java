package com.tencent.qapmsdk.common.device;

import android.annotation.TargetApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceStore;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceStore
{
  public static final DeviceStore.Companion Companion = new DeviceStore.Companion(null);
  private static final String TAG = "QAPM_common_DeviceStore";
  
  @JvmStatic
  @TargetApi(18)
  public static final long getBlockSize(@NotNull String paramString)
  {
    return Companion.getBlockSize(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceStore
 * JD-Core Version:    0.7.0.1
 */