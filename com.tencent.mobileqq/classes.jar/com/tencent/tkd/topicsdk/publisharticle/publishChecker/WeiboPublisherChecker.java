package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/WeiboPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getValidCode", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class WeiboPublisherChecker
  extends BasePublisherChecker
{
  public WeiboPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    super(paramPublishArticleInfo, paramGlobalPublisherConfig);
  }
  
  public int a()
  {
    if (a().getOriginContentInfo() != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = super.a();
    if (i != 0)
    {
      if ((i == 2) && (bool1)) {
        return 0;
      }
      return i;
    }
    if (bool1) {
      return 0;
    }
    boolean bool2 = a().hasImage();
    boolean bool3 = a().hasVideo();
    boolean bool1 = true ^ a().hasText();
    if ((bool3) && (bool1)) {
      return 7;
    }
    if ((!bool1) && (!bool2) && (!bool3)) {
      return 8;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.WeiboPublisherChecker
 * JD-Core Version:    0.7.0.1
 */