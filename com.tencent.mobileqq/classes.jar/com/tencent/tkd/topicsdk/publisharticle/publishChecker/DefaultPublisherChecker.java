package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/DefaultPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "getValidCode", "", "isCommunityValidPublish", "isTopicValidPublish", "publishArticleInfo", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DefaultPublisherChecker
  extends BasePublisherChecker
{
  public DefaultPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    super(paramPublishArticleInfo);
  }
  
  private final int a(PublishArticleInfo paramPublishArticleInfo)
  {
    int j = 1;
    int k = 0;
    int i;
    if (((CharSequence)paramPublishArticleInfo.getContent()).length() == 0)
    {
      i = 1;
      if (paramPublishArticleInfo.getVideoInfo() != null) {
        break label42;
      }
      label29:
      if (i == 0) {
        break label47;
      }
      i = 5;
    }
    label42:
    label47:
    do
    {
      return i;
      i = 0;
      break;
      j = 0;
      break label29;
      i = k;
    } while (j == 0);
    return 6;
  }
  
  private final int b()
  {
    return 0;
  }
  
  public int a()
  {
    int k = 1;
    int m = 0;
    int j = super.a();
    if (j != 0) {}
    label63:
    label68:
    do
    {
      int i;
      do
      {
        return j;
        if (a().getTopicId() != 0L)
        {
          i = 1;
          if (((CharSequence)a().getCommunityId()).length() <= 0) {
            break label63;
          }
        }
        for (;;)
        {
          if ((i != 0) || (k != 0)) {
            break label68;
          }
          return 4;
          i = 0;
          break;
          k = 0;
        }
        if ((i != 0) && (k == 0)) {
          return a(a());
        }
        j = m;
      } while (i != 0);
      j = m;
    } while (k == 0);
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.DefaultPublisherChecker
 * JD-Core Version:    0.7.0.1
 */