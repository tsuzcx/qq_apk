package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData.BucketKeyFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/glue/baseconfig/ReadInJoyVideoReportDataConfig$initConfig$1", "Lcom/tencent/mobileqq/kandian/base/video/player/data/ReadInJoyVideoReportData$BucketKeyFetcher;", "getBucketConfigVer", "", "getBucketKeyFromAladdin", "", "index", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyVideoReportDataConfig$initConfig$1
  implements ReadInJoyVideoReportData.BucketKeyFetcher
{
  ReadInJoyVideoReportDataConfig$initConfig$1(AladdinConfig paramAladdinConfig) {}
  
  public int a()
  {
    return this.a.getIntegerFromString("config_ver", 0);
  }
  
  @NotNull
  public String a(int paramInt)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bucekt_key");
    localStringBuilder.append(paramInt + 1);
    localObject = ((AladdinConfig)localObject).getString(localStringBuilder.toString(), "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "experimentConfig.getStri…t_key\" + (index + 1), \"\")");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.ReadInJoyVideoReportDataConfig.initConfig.1
 * JD-Core Version:    0.7.0.1
 */