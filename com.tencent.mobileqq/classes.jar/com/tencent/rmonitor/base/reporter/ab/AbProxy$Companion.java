package com.tencent.rmonitor.base.reporter.ab;

import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/ab/AbProxy$Companion;", "", "()V", "PERF_TYPE_CPU", "", "PERF_TYPE_MEMORY", "PERF_TYPE_SMOOTH", "TAG", "", "getAbFactorByQapmPlugin", "qapmPlugin", "setAbCallback", "", "abCallback", "Lcom/tencent/rmonitor/base/reporter/ab/IAbCallback;", "setAbFactor", "valueDescription", "value", "abTypeClazz", "Ljava/lang/Class;", "Lcom/tencent/rmonitor/base/reporter/ab/AbType;", "setAbTypes", "abTypeClazzs", "", "([Ljava/lang/Class;)V", "unSetAbFactor", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AbProxy$Companion
{
  @JvmStatic
  @Nullable
  public final String a(int paramInt)
  {
    return AbProviderSingleton.a.a(paramInt);
  }
  
  @JvmStatic
  public final void a(@NotNull IAbCallback paramIAbCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIAbCallback, "abCallback");
    AbProviderSingleton.a.a(paramIAbCallback);
  }
  
  @JvmStatic
  public final void a(@NotNull Class<? extends AbType> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "abTypeClazz");
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unSetABFactor:");
    localStringBuilder.append(paramClass);
    localLogger.i(new String[] { "RMonitor_base_AbProxy", localStringBuilder.toString() });
    paramClass = AbProviderSingleton.a.a(paramClass);
    if (paramClass != null)
    {
      paramClass.unActive();
      return;
    }
    Logger.b.e(new String[] { "RMonitor_base_AbProxy", "unSetAbFactor not found" });
  }
  
  @JvmStatic
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull Class<? extends AbType> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "valueDescription");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    Intrinsics.checkParameterIsNotNull(paramClass, "abTypeClazz");
    paramString1 = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setABFactor:");
    localStringBuilder.append(paramClass);
    localStringBuilder.append(" val ");
    localStringBuilder.append(paramString2);
    paramString1.i(new String[] { "RMonitor_base_AbProxy", localStringBuilder.toString() });
    paramString1 = AbProviderSingleton.a.a(paramClass);
    if (paramString1 != null)
    {
      paramString1.initValue(paramString2);
      paramString1.active();
      return;
    }
    Logger.b.e(new String[] { "RMonitor_base_AbProxy", "setABFactor not found" });
  }
  
  @JvmStatic
  public final void a(@NotNull Class<? extends AbType>[] paramArrayOfClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClass, "abTypeClazzs");
    AbProviderSingleton.a.a(paramArrayOfClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.ab.AbProxy.Companion
 * JD-Core Version:    0.7.0.1
 */