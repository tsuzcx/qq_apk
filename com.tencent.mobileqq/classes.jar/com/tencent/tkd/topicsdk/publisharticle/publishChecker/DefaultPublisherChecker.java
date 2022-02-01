package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/DefaultPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getValidCode", "", "isCommunityValidPublish", "isTopicValidPublish", "publishArticleInfo", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DefaultPublisherChecker
  extends BasePublisherChecker
{
  public DefaultPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    super(paramPublishArticleInfo, paramGlobalPublisherConfig);
  }
  
  private final int a(PublishArticleInfo paramPublishArticleInfo)
  {
    int i = ((CharSequence)paramPublishArticleInfo.getContent()).length();
    int j = 1;
    int k = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramPublishArticleInfo.getVideoInfo() != null) {
      j = 0;
    }
    if (i != 0) {
      return 5;
    }
    i = k;
    if (j != 0) {
      i = 6;
    }
    return i;
  }
  
  private final int b()
  {
    return 0;
  }
  
  public int a()
  {
    int i = super.a();
    if (i != 0) {
      return i;
    }
    long l = a().getTopicId();
    int j = 1;
    if (l != 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (((CharSequence)a().getCommunityId()).length() <= 0) {
      j = 0;
    }
    if ((i == 0) && (j == 0)) {
      return 4;
    }
    if ((i != 0) && (j == 0)) {
      return a(a());
    }
    if ((i == 0) && (j != 0)) {
      return b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.DefaultPublisherChecker
 * JD-Core Version:    0.7.0.1
 */