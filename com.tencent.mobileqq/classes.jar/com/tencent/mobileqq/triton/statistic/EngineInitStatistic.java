package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.exception.TritonException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "", "success", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "loadNativeLibraryTimeMs", "", "loadEngineScriptTimeMs", "createEGLContextTimeMs", "totalInitTimesMs", "engineScriptLoadStatics", "", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "nativeLibraryLoadStatistics", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "(ZLcom/tencent/mobileqq/triton/exception/TritonException;JJJJLjava/util/List;Ljava/util/List;)V", "getCreateEGLContextTimeMs", "()J", "getEngineScriptLoadStatics", "()Ljava/util/List;", "getException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "getLoadEngineScriptTimeMs", "getLoadNativeLibraryTimeMs", "getNativeLibraryLoadStatistics", "getSuccess", "()Z", "getTotalInitTimesMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class EngineInitStatistic
{
  private final long createEGLContextTimeMs;
  @NotNull
  private final List<ScriptLoadStatistic> engineScriptLoadStatics;
  @Nullable
  private final TritonException exception;
  private final long loadEngineScriptTimeMs;
  private final long loadNativeLibraryTimeMs;
  @NotNull
  private final List<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics;
  private final boolean success;
  private final long totalInitTimesMs;
  
  public EngineInitStatistic(boolean paramBoolean, @Nullable TritonException paramTritonException, long paramLong1, long paramLong2, long paramLong3, long paramLong4, @NotNull List<ScriptLoadStatistic> paramList, @NotNull List<NativeLibraryLoadStatistic> paramList1)
  {
    this.success = paramBoolean;
    this.exception = paramTritonException;
    this.loadNativeLibraryTimeMs = paramLong1;
    this.loadEngineScriptTimeMs = paramLong2;
    this.createEGLContextTimeMs = paramLong3;
    this.totalInitTimesMs = paramLong4;
    this.engineScriptLoadStatics = paramList;
    this.nativeLibraryLoadStatistics = paramList1;
  }
  
  public final boolean component1()
  {
    return this.success;
  }
  
  @Nullable
  public final TritonException component2()
  {
    return this.exception;
  }
  
  public final long component3()
  {
    return this.loadNativeLibraryTimeMs;
  }
  
  public final long component4()
  {
    return this.loadEngineScriptTimeMs;
  }
  
  public final long component5()
  {
    return this.createEGLContextTimeMs;
  }
  
  public final long component6()
  {
    return this.totalInitTimesMs;
  }
  
  @NotNull
  public final List<ScriptLoadStatistic> component7()
  {
    return this.engineScriptLoadStatics;
  }
  
  @NotNull
  public final List<NativeLibraryLoadStatistic> component8()
  {
    return this.nativeLibraryLoadStatistics;
  }
  
  @NotNull
  public final EngineInitStatistic copy(boolean paramBoolean, @Nullable TritonException paramTritonException, long paramLong1, long paramLong2, long paramLong3, long paramLong4, @NotNull List<ScriptLoadStatistic> paramList, @NotNull List<NativeLibraryLoadStatistic> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "engineScriptLoadStatics");
    Intrinsics.checkParameterIsNotNull(paramList1, "nativeLibraryLoadStatistics");
    return new EngineInitStatistic(paramBoolean, paramTritonException, paramLong1, paramLong2, paramLong3, paramLong4, paramList, paramList1);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof EngineInitStatistic))
      {
        paramObject = (EngineInitStatistic)paramObject;
        if ((this.success != paramObject.success) || (!Intrinsics.areEqual(this.exception, paramObject.exception)) || (this.loadNativeLibraryTimeMs != paramObject.loadNativeLibraryTimeMs) || (this.loadEngineScriptTimeMs != paramObject.loadEngineScriptTimeMs) || (this.createEGLContextTimeMs != paramObject.createEGLContextTimeMs) || (this.totalInitTimesMs != paramObject.totalInitTimesMs) || (!Intrinsics.areEqual(this.engineScriptLoadStatics, paramObject.engineScriptLoadStatics)) || (!Intrinsics.areEqual(this.nativeLibraryLoadStatistics, paramObject.nativeLibraryLoadStatistics))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final long getCreateEGLContextTimeMs()
  {
    return this.createEGLContextTimeMs;
  }
  
  @NotNull
  public final List<ScriptLoadStatistic> getEngineScriptLoadStatics()
  {
    return this.engineScriptLoadStatics;
  }
  
  @Nullable
  public final TritonException getException()
  {
    return this.exception;
  }
  
  public final long getLoadEngineScriptTimeMs()
  {
    return this.loadEngineScriptTimeMs;
  }
  
  public final long getLoadNativeLibraryTimeMs()
  {
    return this.loadNativeLibraryTimeMs;
  }
  
  @NotNull
  public final List<NativeLibraryLoadStatistic> getNativeLibraryLoadStatistics()
  {
    return this.nativeLibraryLoadStatistics;
  }
  
  public final boolean getSuccess()
  {
    return this.success;
  }
  
  public final long getTotalInitTimesMs()
  {
    return this.totalInitTimesMs;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "EngineInitStatistic(success=" + this.success + ", exception=" + this.exception + ", loadNativeLibraryTimeMs=" + this.loadNativeLibraryTimeMs + ", loadEngineScriptTimeMs=" + this.loadEngineScriptTimeMs + ", createEGLContextTimeMs=" + this.createEGLContextTimeMs + ", totalInitTimesMs=" + this.totalInitTimesMs + ", engineScriptLoadStatics=" + this.engineScriptLoadStatics + ", nativeLibraryLoadStatistics=" + this.nativeLibraryLoadStatistics + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.EngineInitStatistic
 * JD-Core Version:    0.7.0.1
 */