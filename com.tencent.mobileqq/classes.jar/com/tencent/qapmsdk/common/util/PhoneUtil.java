package com.tencent.qapmsdk.common.util;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/PhoneUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class PhoneUtil
{
  public static final PhoneUtil.Companion Companion = new PhoneUtil.Companion(null);
  private static final String ETH_MAC_ADDRESS = "/sys/class/net/eth1/address";
  private static final String WLAN_MAC_ADDRESS = "/sys/class/net/wlan0/address";
  private static String deviceId = "";
  private static int height = -1;
  private static int width = -1;
  
  @JvmStatic
  @NotNull
  public static final String generateDeviceId(@Nullable Application paramApplication)
  {
    return Companion.generateDeviceId(paramApplication);
  }
  
  @JvmStatic
  public static final int getDisplayHeight(@Nullable Context paramContext)
  {
    return Companion.getDisplayHeight(paramContext);
  }
  
  @JvmStatic
  @NotNull
  public static final String getDisplaySize(@Nullable Context paramContext)
  {
    return Companion.getDisplaySize(paramContext);
  }
  
  @JvmStatic
  public static final int getDisplayWidth(@Nullable Context paramContext)
  {
    return Companion.getDisplayWidth(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.PhoneUtil
 * JD-Core Version:    0.7.0.1
 */