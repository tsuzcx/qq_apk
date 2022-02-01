package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.exception.TritonException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "", "success", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "launchTimesMs", "", "gameScriptLoadStatics", "", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "engineInitStatistic", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "(ZLcom/tencent/mobileqq/triton/exception/TritonException;JLjava/util/List;Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;)V", "getEngineInitStatistic", "()Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "getException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "getGameScriptLoadStatics", "()Ljava/util/List;", "getLaunchTimesMs", "()J", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GameLaunchStatistic
{
  @NotNull
  private final EngineInitStatistic engineInitStatistic;
  @Nullable
  private final TritonException exception;
  @NotNull
  private final List<ScriptLoadStatistic> gameScriptLoadStatics;
  private final long launchTimesMs;
  private final boolean success;
  
  public GameLaunchStatistic(boolean paramBoolean, @Nullable TritonException paramTritonException, long paramLong, @NotNull List<ScriptLoadStatistic> paramList, @NotNull EngineInitStatistic paramEngineInitStatistic)
  {
    this.success = paramBoolean;
    this.exception = paramTritonException;
    this.launchTimesMs = paramLong;
    this.gameScriptLoadStatics = paramList;
    this.engineInitStatistic = paramEngineInitStatistic;
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
    return this.launchTimesMs;
  }
  
  @NotNull
  public final List<ScriptLoadStatistic> component4()
  {
    return this.gameScriptLoadStatics;
  }
  
  @NotNull
  public final EngineInitStatistic component5()
  {
    return this.engineInitStatistic;
  }
  
  @NotNull
  public final GameLaunchStatistic copy(boolean paramBoolean, @Nullable TritonException paramTritonException, long paramLong, @NotNull List<ScriptLoadStatistic> paramList, @NotNull EngineInitStatistic paramEngineInitStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "gameScriptLoadStatics");
    Intrinsics.checkParameterIsNotNull(paramEngineInitStatistic, "engineInitStatistic");
    return new GameLaunchStatistic(paramBoolean, paramTritonException, paramLong, paramList, paramEngineInitStatistic);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GameLaunchStatistic))
      {
        paramObject = (GameLaunchStatistic)paramObject;
        if ((this.success == paramObject.success) && (Intrinsics.areEqual(this.exception, paramObject.exception)) && (this.launchTimesMs == paramObject.launchTimesMs) && (Intrinsics.areEqual(this.gameScriptLoadStatics, paramObject.gameScriptLoadStatics)) && (Intrinsics.areEqual(this.engineInitStatistic, paramObject.engineInitStatistic))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final EngineInitStatistic getEngineInitStatistic()
  {
    return this.engineInitStatistic;
  }
  
  @Nullable
  public final TritonException getException()
  {
    return this.exception;
  }
  
  @NotNull
  public final List<ScriptLoadStatistic> getGameScriptLoadStatics()
  {
    return this.gameScriptLoadStatics;
  }
  
  public final long getLaunchTimesMs()
  {
    return this.launchTimesMs;
  }
  
  public final boolean getSuccess()
  {
    return this.success;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameLaunchStatistic(success=");
    localStringBuilder.append(this.success);
    localStringBuilder.append(", exception=");
    localStringBuilder.append(this.exception);
    localStringBuilder.append(", launchTimesMs=");
    localStringBuilder.append(this.launchTimesMs);
    localStringBuilder.append(", gameScriptLoadStatics=");
    localStringBuilder.append(this.gameScriptLoadStatics);
    localStringBuilder.append(", engineInitStatistic=");
    localStringBuilder.append(this.engineInitStatistic);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.GameLaunchStatistic
 * JD-Core Version:    0.7.0.1
 */