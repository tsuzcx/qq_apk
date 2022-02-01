package com.tencent.qapmsdk.common.resource;

import android.os.Process;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/ResourceConstant;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ResourceConstant
{
  public static final ResourceConstant.Companion Companion = new ResourceConstant.Companion(null);
  @NotNull
  private static final long[] LOCAL_IFACE_HASHES = { "dummy0".hashCode(), "lo".hashCode() };
  @NotNull
  private static final String PID_STATS_PATH = "/proc/" + Process.myPid() + "/stat";
  @NotNull
  public static final String STATS_PATH = "/proc/net/xt_qtaguid/stats";
  @NotNull
  public static final String SYS_STATS_PATH = "/proc/stat";
  private static final long UID = Process.myUid();
  private static final long WLAN0_HASH = "wlan0".hashCode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.ResourceConstant
 * JD-Core Version:    0.7.0.1
 */