package com.tencent.mobileqq.triton.sdk.statics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.triton.sdk.bridge.ScriptContextType;

public class ScriptLoadStatics
{
  public final long compileTimeMs;
  @Nullable
  public final String exception;
  public final long executeTimeMs;
  @NonNull
  public final ScriptLoadResult loadResult;
  public final long readCodeCacheTimeMs;
  public final long readTimeMs;
  @NonNull
  public final ScriptContextType scriptContextType;
  @NonNull
  public final String scriptName;
  @NonNull
  public final String scriptPath;
  
  public ScriptLoadStatics(@NonNull ScriptLoadResult paramScriptLoadResult, @NonNull ScriptContextType paramScriptContextType, @NonNull String paramString1, @NonNull String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, @Nullable String paramString3)
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
  
  public String toString()
  {
    return "ScriptLoadStatics{loadResult=" + this.loadResult + ", scriptContextType=" + this.scriptContextType + ", scriptName='" + this.scriptName + '\'' + ", scriptPath='" + this.scriptPath + '\'' + ", readTimeMs=" + this.readTimeMs + ", readCodeCacheTimeMs=" + this.readCodeCacheTimeMs + ", compileTimeMs=" + this.compileTimeMs + ", executeTimeMs=" + this.executeTimeMs + ", exception='" + this.exception + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.statics.ScriptLoadStatics
 * JD-Core Version:    0.7.0.1
 */