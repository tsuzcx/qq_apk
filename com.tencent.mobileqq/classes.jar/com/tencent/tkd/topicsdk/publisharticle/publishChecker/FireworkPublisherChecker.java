package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/FireworkPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "getValidCode", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FireworkPublisherChecker
  extends BasePublisherChecker
{
  public FireworkPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    super(paramPublishArticleInfo);
  }
  
  public int a()
  {
    int k = 1;
    int m = 0;
    int j = super.a();
    if (j != 0) {}
    label62:
    label67:
    do
    {
      int i;
      do
      {
        return j;
        if (a().getVideoInfo() != null)
        {
          i = 1;
          if (((CharSequence)a().getContent()).length() != 0) {
            break label62;
          }
        }
        for (;;)
        {
          if ((i == 0) || (k == 0)) {
            break label67;
          }
          return 7;
          i = 0;
          break;
          k = 0;
        }
        j = m;
      } while (i != 0);
      j = m;
    } while (k != 0);
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.FireworkPublisherChecker
 * JD-Core Version:    0.7.0.1
 */