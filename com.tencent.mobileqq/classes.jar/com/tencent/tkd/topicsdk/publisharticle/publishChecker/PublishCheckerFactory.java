package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/PublishCheckerFactory;", "", "()V", "getChecker", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "scene", "", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishCheckerFactory
{
  public static final PublishCheckerFactory a = new PublishCheckerFactory();
  
  @NotNull
  public final BasePublisherChecker a(@NotNull String paramString, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "info");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return (BasePublisherChecker)new DefaultPublisherChecker(paramPublishArticleInfo);
          } while (!paramString.equals("weibo"));
          return (BasePublisherChecker)new WeiboPublisherChecker(paramPublishArticleInfo);
        } while (!paramString.equals("KOL"));
        return (BasePublisherChecker)new KOLPublisherChecker(paramPublishArticleInfo);
      } while (!paramString.equals("fireworks"));
      return (BasePublisherChecker)new FireworkPublisherChecker(paramPublishArticleInfo);
    } while (!paramString.equals("rijugc"));
    return (BasePublisherChecker)new RIJUGCPublisherChecker(paramPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.PublishCheckerFactory
 * JD-Core Version:    0.7.0.1
 */