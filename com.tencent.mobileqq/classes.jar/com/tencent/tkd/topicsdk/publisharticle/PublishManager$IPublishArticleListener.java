package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$IPublishArticleListener;", "", "onFailed", "", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "onProgress", "publishId", "", "progress", "", "onStart", "coverPath", "onSuccess", "serverPublishData", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface PublishManager$IPublishArticleListener
{
  public abstract void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo);
  
  public abstract void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull String paramString);
  
  public abstract void a(@NotNull String paramString, int paramInt);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.IPublishArticleListener
 * JD-Core Version:    0.7.0.1
 */