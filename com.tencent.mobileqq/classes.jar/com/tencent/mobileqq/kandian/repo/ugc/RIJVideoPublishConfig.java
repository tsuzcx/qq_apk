package com.tencent.mobileqq.kandian.repo.ugc;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/ugc/RIJVideoPublishConfig;", "", "()V", "UGC_VIDEO_PUBLISH_ENABLE_ADD_ADDRESS", "", "UGC_VIDEO_PUBLISH_ENABLE_AT_PERSON", "UGC_VIDEO_PUBLISH_ENABLE_COMMUNITY", "UGC_VIDEO_PUBLISH_ENABLE_TOPIC_IN_TITLE", "UGC_VIDEO_PUBLISH_REPRODUCE_DEFAULT", "UGC_VIDEO_PUBLISH_SHOW_DELIVER_TYPE_SELECT", "UGC_VIDEO_PUBLISH_SHOW_REPRODUCE", "enablePublishVideoWithAddAddress", "", "enablePublishVideoWithAtPerson", "enablePublishVideoWithCommunity", "enablePublishVideoWithTopicInTitle", "getPublishVideoConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "getPublishVideoReproduceDefault", "shouldShowPublishVideoReproduceBtn", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoPublishConfig
{
  public static final RIJVideoPublishConfig a = new RIJVideoPublishConfig();
  
  @JvmStatic
  public static final boolean a()
  {
    AladdinConfig localAladdinConfig = a.f();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("ugc_video_publish_show_deliver_type_select", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  @JvmStatic
  public static final boolean b()
  {
    AladdinConfig localAladdinConfig = a.f();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("ugc_video_publish_show_topic", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  @JvmStatic
  public static final boolean c()
  {
    return a.f().getIntegerFromString("ugc_video_publish_show_at", 1) != 0;
  }
  
  @JvmStatic
  public static final boolean d()
  {
    return a.f().getIntegerFromString("ugc_video_publish_show_location", 1) != 0;
  }
  
  private final AladdinConfig f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(281);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…CONFIG_UGC_PUBLISH_VIDEO)");
    return localAladdinConfig;
  }
  
  public final boolean e()
  {
    AladdinConfig localAladdinConfig = f();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("ugc_video_publish_show_community", 0) != 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.RIJVideoPublishConfig
 * JD-Core Version:    0.7.0.1
 */