package com.tencent.mobileqq.mini.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig$ItemConfig;", "", "appId", "", "limitTimes", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getLimitTimes", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class AppDetainFreqConfig$ItemConfig
{
  @NotNull
  private final String appId;
  private final int limitTimes;
  
  public AppDetainFreqConfig$ItemConfig(@NotNull String paramString, int paramInt)
  {
    this.appId = paramString;
    this.limitTimes = paramInt;
  }
  
  @NotNull
  public final String component1()
  {
    return this.appId;
  }
  
  public final int component2()
  {
    return this.limitTimes;
  }
  
  @NotNull
  public final ItemConfig copy(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    return new ItemConfig(paramString, paramInt);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ItemConfig))
      {
        paramObject = (ItemConfig)paramObject;
        if ((Intrinsics.areEqual(this.appId, paramObject.appId)) && (this.limitTimes == paramObject.limitTimes)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getAppId()
  {
    return this.appId;
  }
  
  public final int getLimitTimes()
  {
    return this.limitTimes;
  }
  
  public int hashCode()
  {
    String str = this.appId;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.limitTimes;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ItemConfig(appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", limitTimes=");
    localStringBuilder.append(this.limitTimes);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.config.AppDetainFreqConfig.ItemConfig
 * JD-Core Version:    0.7.0.1
 */