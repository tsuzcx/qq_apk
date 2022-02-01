package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/PublishCheckerFactory;", "", "()V", "getChecker", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishCheckerFactory
{
  public static final PublishCheckerFactory a = new PublishCheckerFactory();
  
  @NotNull
  public final BasePublisherChecker a(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "info");
    String str = paramPublishArticleInfo.getPublishScene();
    switch (str.hashCode())
    {
    default: 
      break;
    case 113011944: 
      if (str.equals("weibo")) {
        return (BasePublisherChecker)new WeiboPublisherChecker(paramPublishArticleInfo, paramGlobalPublisherConfig);
      }
      break;
    case 74600: 
      if (str.equals("KOL")) {
        return (BasePublisherChecker)new KOLPublisherChecker(paramPublishArticleInfo, paramGlobalPublisherConfig);
      }
      break;
    case -264202484: 
      if (str.equals("fireworks")) {
        return (BasePublisherChecker)new FireworkPublisherChecker(paramPublishArticleInfo, paramGlobalPublisherConfig);
      }
      break;
    case -931000802: 
      if (str.equals("rijugc")) {
        return (BasePublisherChecker)new RIJUGCPublisherChecker(paramPublishArticleInfo, paramGlobalPublisherConfig);
      }
      break;
    }
    return (BasePublisherChecker)new DefaultPublisherChecker(paramPublishArticleInfo, paramGlobalPublisherConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.PublishCheckerFactory
 * JD-Core Version:    0.7.0.1
 */