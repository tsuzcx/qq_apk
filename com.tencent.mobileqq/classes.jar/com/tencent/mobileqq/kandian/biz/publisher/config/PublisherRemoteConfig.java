package com.tencent.mobileqq.kandian.biz.publisher.config;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.publisher.api.IPublisherRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/config/PublisherRemoteConfig;", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "()V", "selectCoverEnabled", "", "toString", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublisherRemoteConfig
  implements IPublisherRemoteConfig
{
  public boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(421);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("switch_select_cover_on", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  @NotNull
  public String toString()
  {
    String str = Aladdin.getConfig(421).toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…IC_SDK_SWITCH).toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.config.PublisherRemoteConfig
 * JD-Core Version:    0.7.0.1
 */