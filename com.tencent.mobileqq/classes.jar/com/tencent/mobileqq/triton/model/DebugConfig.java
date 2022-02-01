package com.tencent.mobileqq.triton.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/model/DebugConfig;", "", "debugEnabled", "", "presentDetectIntervalMillis", "", "noPresentDurationToCheckLimitMillis", "frameNoChangeToCheckLimit", "", "noPresentTouchLimit", "(ZJJII)V", "getDebugEnabled", "()Z", "getFrameNoChangeToCheckLimit", "()I", "getNoPresentDurationToCheckLimitMillis", "()J", "getNoPresentTouchLimit", "getPresentDetectIntervalMillis", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class DebugConfig
{
  private final boolean debugEnabled;
  private final int frameNoChangeToCheckLimit;
  private final long noPresentDurationToCheckLimitMillis;
  private final int noPresentTouchLimit;
  private final long presentDetectIntervalMillis;
  
  public DebugConfig()
  {
    this(false, 0L, 0L, 0, 0, 31, null);
  }
  
  public DebugConfig(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.debugEnabled = paramBoolean;
    this.presentDetectIntervalMillis = paramLong1;
    this.noPresentDurationToCheckLimitMillis = paramLong2;
    this.frameNoChangeToCheckLimit = paramInt1;
    this.noPresentTouchLimit = paramInt2;
  }
  
  public final boolean component1()
  {
    return this.debugEnabled;
  }
  
  public final long component2()
  {
    return this.presentDetectIntervalMillis;
  }
  
  public final long component3()
  {
    return this.noPresentDurationToCheckLimitMillis;
  }
  
  public final int component4()
  {
    return this.frameNoChangeToCheckLimit;
  }
  
  public final int component5()
  {
    return this.noPresentTouchLimit;
  }
  
  @NotNull
  public final DebugConfig copy(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return new DebugConfig(paramBoolean, paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DebugConfig))
      {
        paramObject = (DebugConfig)paramObject;
        if ((this.debugEnabled == paramObject.debugEnabled) && (this.presentDetectIntervalMillis == paramObject.presentDetectIntervalMillis) && (this.noPresentDurationToCheckLimitMillis == paramObject.noPresentDurationToCheckLimitMillis) && (this.frameNoChangeToCheckLimit == paramObject.frameNoChangeToCheckLimit) && (this.noPresentTouchLimit == paramObject.noPresentTouchLimit)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getDebugEnabled()
  {
    return this.debugEnabled;
  }
  
  public final int getFrameNoChangeToCheckLimit()
  {
    return this.frameNoChangeToCheckLimit;
  }
  
  public final long getNoPresentDurationToCheckLimitMillis()
  {
    return this.noPresentDurationToCheckLimitMillis;
  }
  
  public final int getNoPresentTouchLimit()
  {
    return this.noPresentTouchLimit;
  }
  
  public final long getPresentDetectIntervalMillis()
  {
    return this.presentDetectIntervalMillis;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DebugConfig(debugEnabled=");
    localStringBuilder.append(this.debugEnabled);
    localStringBuilder.append(", presentDetectIntervalMillis=");
    localStringBuilder.append(this.presentDetectIntervalMillis);
    localStringBuilder.append(", noPresentDurationToCheckLimitMillis=");
    localStringBuilder.append(this.noPresentDurationToCheckLimitMillis);
    localStringBuilder.append(", frameNoChangeToCheckLimit=");
    localStringBuilder.append(this.frameNoChangeToCheckLimit);
    localStringBuilder.append(", noPresentTouchLimit=");
    localStringBuilder.append(this.noPresentTouchLimit);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.model.DebugConfig
 * JD-Core Version:    0.7.0.1
 */