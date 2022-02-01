package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/FireworkPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getValidCode", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FireworkPublisherChecker
  extends BasePublisherChecker
{
  public FireworkPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    super(paramPublishArticleInfo, paramGlobalPublisherConfig);
  }
  
  public int a()
  {
    int i = super.a();
    if (i != 0) {
      return i;
    }
    VideoInfo localVideoInfo = a().getVideoInfo();
    int j = 1;
    if (localVideoInfo != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (((CharSequence)a().getContent()).length() != 0) {
      j = 0;
    }
    if ((i != 0) && (j != 0)) {
      return 7;
    }
    if ((i == 0) && (j == 0)) {
      return 8;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.FireworkPublisherChecker
 * JD-Core Version:    0.7.0.1
 */