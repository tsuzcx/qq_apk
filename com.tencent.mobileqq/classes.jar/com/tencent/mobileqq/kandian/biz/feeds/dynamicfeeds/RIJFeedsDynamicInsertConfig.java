package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertConfig;", "", "()V", "getDynamicInsertWatchInfoDelay", "", "reqSource", "isDynamicInsertConfigOpen", "", "isDynamicInsertEnable", "channelId", "(Ljava/lang/Integer;)Z", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertConfig
{
  public static final RIJFeedsDynamicInsertConfig a = new RIJFeedsDynamicInsertConfig();
  
  public final int a(int paramInt)
  {
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6) {
          str = "";
        } else {
          str = "video_page_preload_time";
        }
      }
      else {
        str = "article_page_preload_time";
      }
    }
    else {
      str = "main_tl_preload_time";
    }
    return Aladdin.getConfig(439).getIntegerFromString(str, 3000);
  }
  
  public final boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(439);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("enable_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean a(@Nullable Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger.intValue() != 0)) {
      return false;
    }
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertConfig
 * JD-Core Version:    0.7.0.1
 */