package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.script.ScriptContextType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "", "loadResult", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;", "scriptContextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "scriptName", "", "scriptPath", "readTimeMs", "", "readCodeCacheTimeMs", "compileTimeMs", "executeTimeMs", "exception", "(Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;Lcom/tencent/mobileqq/triton/script/ScriptContextType;Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/String;)V", "getCompileTimeMs", "()J", "getException", "()Ljava/lang/String;", "getExecuteTimeMs", "getLoadResult", "()Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;", "getReadCodeCacheTimeMs", "getReadTimeMs", "getScriptContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getScriptName", "getScriptPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class ScriptLoadStatistic
{
  private final long compileTimeMs;
  @NotNull
  private final String exception;
  private final long executeTimeMs;
  @NotNull
  private final ScriptLoadResult loadResult;
  private final long readCodeCacheTimeMs;
  private final long readTimeMs;
  @NotNull
  private final ScriptContextType scriptContextType;
  @NotNull
  private final String scriptName;
  @NotNull
  private final String scriptPath;
  
  public ScriptLoadStatistic(@NotNull ScriptLoadResult paramScriptLoadResult, @NotNull ScriptContextType paramScriptContextType, @NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, @NotNull String paramString3)
  {
    this.loadResult = paramScriptLoadResult;
    this.scriptContextType = paramScriptContextType;
    this.scriptName = paramString1;
    this.scriptPath = paramString2;
    this.readTimeMs = paramLong1;
    this.readCodeCacheTimeMs = paramLong2;
    this.compileTimeMs = paramLong3;
    this.executeTimeMs = paramLong4;
    this.exception = paramString3;
  }
  
  @NotNull
  public final ScriptLoadResult component1()
  {
    return this.loadResult;
  }
  
  @NotNull
  public final ScriptContextType component2()
  {
    return this.scriptContextType;
  }
  
  @NotNull
  public final String component3()
  {
    return this.scriptName;
  }
  
  @NotNull
  public final String component4()
  {
    return this.scriptPath;
  }
  
  public final long component5()
  {
    return this.readTimeMs;
  }
  
  public final long component6()
  {
    return this.readCodeCacheTimeMs;
  }
  
  public final long component7()
  {
    return this.compileTimeMs;
  }
  
  public final long component8()
  {
    return this.executeTimeMs;
  }
  
  @NotNull
  public final String component9()
  {
    return this.exception;
  }
  
  @NotNull
  public final ScriptLoadStatistic copy(@NotNull ScriptLoadResult paramScriptLoadResult, @NotNull ScriptContextType paramScriptContextType, @NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptLoadResult, "loadResult");
    Intrinsics.checkParameterIsNotNull(paramScriptContextType, "scriptContextType");
    Intrinsics.checkParameterIsNotNull(paramString1, "scriptName");
    Intrinsics.checkParameterIsNotNull(paramString2, "scriptPath");
    Intrinsics.checkParameterIsNotNull(paramString3, "exception");
    return new ScriptLoadStatistic(paramScriptLoadResult, paramScriptContextType, paramString1, paramString2, paramLong1, paramLong2, paramLong3, paramLong4, paramString3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ScriptLoadStatistic))
      {
        paramObject = (ScriptLoadStatistic)paramObject;
        if ((Intrinsics.areEqual(this.loadResult, paramObject.loadResult)) && (Intrinsics.areEqual(this.scriptContextType, paramObject.scriptContextType)) && (Intrinsics.areEqual(this.scriptName, paramObject.scriptName)) && (Intrinsics.areEqual(this.scriptPath, paramObject.scriptPath)) && (this.readTimeMs == paramObject.readTimeMs) && (this.readCodeCacheTimeMs == paramObject.readCodeCacheTimeMs) && (this.compileTimeMs == paramObject.compileTimeMs) && (this.executeTimeMs == paramObject.executeTimeMs) && (Intrinsics.areEqual(this.exception, paramObject.exception))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getCompileTimeMs()
  {
    return this.compileTimeMs;
  }
  
  @NotNull
  public final String getException()
  {
    return this.exception;
  }
  
  public final long getExecuteTimeMs()
  {
    return this.executeTimeMs;
  }
  
  @NotNull
  public final ScriptLoadResult getLoadResult()
  {
    return this.loadResult;
  }
  
  public final long getReadCodeCacheTimeMs()
  {
    return this.readCodeCacheTimeMs;
  }
  
  public final long getReadTimeMs()
  {
    return this.readTimeMs;
  }
  
  @NotNull
  public final ScriptContextType getScriptContextType()
  {
    return this.scriptContextType;
  }
  
  @NotNull
  public final String getScriptName()
  {
    return this.scriptName;
  }
  
  @NotNull
  public final String getScriptPath()
  {
    return this.scriptPath;
  }
  
  public int hashCode()
  {
    Object localObject = this.loadResult;
    int n = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.scriptContextType;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.scriptName;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.scriptPath;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    long l = this.readTimeMs;
    int i1 = (int)(l ^ l >>> 32);
    l = this.readCodeCacheTimeMs;
    int i2 = (int)(l ^ l >>> 32);
    l = this.compileTimeMs;
    int i3 = (int)(l ^ l >>> 32);
    l = this.executeTimeMs;
    int i4 = (int)(l ^ l >>> 32);
    localObject = this.exception;
    if (localObject != null) {
      n = localObject.hashCode();
    }
    return (((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScriptLoadStatistic(loadResult=");
    localStringBuilder.append(this.loadResult);
    localStringBuilder.append(", scriptContextType=");
    localStringBuilder.append(this.scriptContextType);
    localStringBuilder.append(", scriptName=");
    localStringBuilder.append(this.scriptName);
    localStringBuilder.append(", scriptPath=");
    localStringBuilder.append(this.scriptPath);
    localStringBuilder.append(", readTimeMs=");
    localStringBuilder.append(this.readTimeMs);
    localStringBuilder.append(", readCodeCacheTimeMs=");
    localStringBuilder.append(this.readCodeCacheTimeMs);
    localStringBuilder.append(", compileTimeMs=");
    localStringBuilder.append(this.compileTimeMs);
    localStringBuilder.append(", executeTimeMs=");
    localStringBuilder.append(this.executeTimeMs);
    localStringBuilder.append(", exception=");
    localStringBuilder.append(this.exception);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic
 * JD-Core Version:    0.7.0.1
 */