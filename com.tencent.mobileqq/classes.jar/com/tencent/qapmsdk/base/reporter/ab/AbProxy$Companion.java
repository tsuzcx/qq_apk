package com.tencent.qapmsdk.base.reporter.ab;

import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/ab/AbProxy$Companion;", "", "()V", "PERF_TYPE_CPU", "", "PERF_TYPE_MEMORY", "PERF_TYPE_SMOOTH", "TAG", "", "getAbFactorByQapmPlugin", "qapmPlugin", "setAbCallback", "", "abCallback", "Lcom/tencent/qapmsdk/base/reporter/ab/IAbCallback;", "setAbFactor", "valueDescription", "value", "abTypeClazz", "Ljava/lang/Class;", "Lcom/tencent/qapmsdk/base/reporter/ab/AbType;", "setAbTypes", "abTypeClazzs", "", "([Ljava/lang/Class;)V", "unSetAbFactor", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AbProxy$Companion
{
  @JvmStatic
  @Nullable
  public final String getAbFactorByQapmPlugin(int paramInt)
  {
    return AbProviderSingleton.INSTANCE.getAbFactors(paramInt);
  }
  
  @JvmStatic
  public final void setAbCallback(@NotNull IAbCallback paramIAbCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIAbCallback, "abCallback");
    AbProviderSingleton.INSTANCE.setCallback(paramIAbCallback);
  }
  
  @JvmStatic
  public final void setAbFactor(@NotNull String paramString1, @NotNull String paramString2, @NotNull Class<? extends AbType> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "valueDescription");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    Intrinsics.checkParameterIsNotNull(paramClass, "abTypeClazz");
    Logger.INSTANCE.i(new String[] { "QAPM_base_AbProxy", "setABFactor:" + paramClass + " val " + paramString2 });
    paramString1 = AbProviderSingleton.INSTANCE.getAbType(paramClass);
    if (paramString1 != null)
    {
      paramString1.initValue(paramString2);
      paramString1.active();
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_base_AbProxy", "setABFactor not found" });
  }
  
  @JvmStatic
  public final void setAbTypes(@NotNull Class<? extends AbType>[] paramArrayOfClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClass, "abTypeClazzs");
    AbProviderSingleton.INSTANCE.setAbTypeArr(paramArrayOfClass);
  }
  
  @JvmStatic
  public final void unSetAbFactor(@NotNull Class<? extends AbType> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "abTypeClazz");
    Logger.INSTANCE.i(new String[] { "QAPM_base_AbProxy", "unSetABFactor:" + paramClass });
    paramClass = AbProviderSingleton.INSTANCE.getAbType(paramClass);
    if (paramClass != null)
    {
      paramClass.unActive();
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_base_AbProxy", "unSetAbFactor not found" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.AbProxy.Companion
 * JD-Core Version:    0.7.0.1
 */