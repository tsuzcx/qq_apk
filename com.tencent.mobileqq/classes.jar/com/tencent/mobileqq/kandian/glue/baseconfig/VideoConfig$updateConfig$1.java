package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.bandwidth.BandWidthConfig.PreloadStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/glue/baseconfig/VideoConfig$updateConfig$1", "Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;", "enable", "", "key", "", "getDecodeConfigsStr", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoConfig$updateConfig$1
  implements BandWidthConfig.PreloadStrategy
{
  @NotNull
  public String a(@Nullable String paramString)
  {
    paramString = Aladdin.getConfig(288).getString(paramString, "");
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Aladdin.getConfig(QQAlad…RANGE).getString(key, \"\")");
    return paramString;
  }
  
  public boolean a(@Nullable String paramString)
  {
    return Aladdin.getConfig(298).getIntegerFromString(paramString, 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.VideoConfig.updateConfig.1
 * JD-Core Version:    0.7.0.1
 */