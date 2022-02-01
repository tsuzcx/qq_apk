package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/KOLPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getValidCode", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class KOLPublisherChecker
  extends BasePublisherChecker
{
  public KOLPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    super(paramPublishArticleInfo, paramGlobalPublisherConfig);
  }
  
  public int b()
  {
    int i = super.b();
    if (i != 0) {
      return i;
    }
    if (d().getVideoInfo() != null) {
      return 3;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.KOLPublisherChecker
 * JD-Core Version:    0.7.0.1
 */