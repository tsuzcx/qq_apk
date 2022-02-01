package com.tencent.rmonitor.base.reporter.ab;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/ab/AbProxy;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AbProxy
{
  public static final AbProxy.Companion Companion = new AbProxy.Companion(null);
  public static final int PERF_TYPE_CPU = 1;
  public static final int PERF_TYPE_MEMORY = 4;
  public static final int PERF_TYPE_SMOOTH = 2;
  private static final String TAG = "RMonitor_base_AbProxy";
  
  @JvmStatic
  @Nullable
  public static final String getAbFactorByQapmPlugin(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  @JvmStatic
  public static final void setAbCallback(@NotNull IAbCallback paramIAbCallback)
  {
    Companion.a(paramIAbCallback);
  }
  
  @JvmStatic
  public static final void setAbFactor(@NotNull String paramString1, @NotNull String paramString2, @NotNull Class<? extends AbType> paramClass)
  {
    Companion.a(paramString1, paramString2, paramClass);
  }
  
  @JvmStatic
  public static final void setAbTypes(@NotNull Class<? extends AbType>[] paramArrayOfClass)
  {
    Companion.a(paramArrayOfClass);
  }
  
  @JvmStatic
  public static final void unSetAbFactor(@NotNull Class<? extends AbType> paramClass)
  {
    Companion.a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.ab.AbProxy
 * JD-Core Version:    0.7.0.1
 */