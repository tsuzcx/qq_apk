package com.tencent.rmonitor.resource.collector;

import android.os.Process;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/resource/collector/ResourceConstant;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ResourceConstant
{
  public static final ResourceConstant.Companion a = new ResourceConstant.Companion(null);
  @NotNull
  private static final String b;
  private static final long c = "wlan0".hashCode();
  @NotNull
  private static final long[] d = { "dummy0".hashCode(), "lo".hashCode() };
  private static final long e = Process.myUid();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/proc/");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("/stat");
    b = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.ResourceConstant
 * JD-Core Version:    0.7.0.1
 */