package com.tencent.mobileqq.kandian.base.bandwidth;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;", "", "enable", "", "key", "", "getDecodeConfigsStr", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface BandWidthConfig$PreloadStrategy
{
  @NotNull
  public abstract String a(@Nullable String paramString);
  
  public abstract boolean a(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.BandWidthConfig.PreloadStrategy
 * JD-Core Version:    0.7.0.1
 */