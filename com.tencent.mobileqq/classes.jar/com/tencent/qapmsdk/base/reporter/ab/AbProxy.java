package com.tencent.qapmsdk.base.reporter.ab;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/ab/AbProxy;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AbProxy
{
  public static final AbProxy.Companion Companion = new AbProxy.Companion(null);
  public static final int PERF_TYPE_CPU = 1;
  public static final int PERF_TYPE_MEMORY = 4;
  public static final int PERF_TYPE_SMOOTH = 2;
  private static final String TAG = "QAPM_base_AbProxy";
  
  @JvmStatic
  @Nullable
  public static final String getAbFactorByQapmPlugin(int paramInt)
  {
    return Companion.getAbFactorByQapmPlugin(paramInt);
  }
  
  @JvmStatic
  public static final void setAbCallback(@NotNull IAbCallback paramIAbCallback)
  {
    Companion.setAbCallback(paramIAbCallback);
  }
  
  @JvmStatic
  public static final void setAbFactor(@NotNull String paramString1, @NotNull String paramString2, @NotNull Class<? extends AbType> paramClass)
  {
    Companion.setAbFactor(paramString1, paramString2, paramClass);
  }
  
  @JvmStatic
  public static final void setAbTypes(@NotNull Class<? extends AbType>[] paramArrayOfClass)
  {
    Companion.setAbTypes(paramArrayOfClass);
  }
  
  @JvmStatic
  public static final void unSetAbFactor(@NotNull Class<? extends AbType> paramClass)
  {
    Companion.unSetAbFactor(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.AbProxy
 * JD-Core Version:    0.7.0.1
 */