package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$IPublishArticleListener;", "", "onPauseByNet", "", "stage", "Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishStage;", "onPauseFailed", "onPauseSuccess", "onProgress", "progress", "", "publishId", "", "onStageFailed", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "onStageStart", "coverPath", "onStageSuccess", "serverPublishData", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface PublishManager$IPublishArticleListener
{
  public abstract void a(@NotNull PublishStage paramPublishStage);
  
  public abstract void a(@NotNull PublishStage paramPublishStage, int paramInt, @NotNull String paramString);
  
  public abstract void a(@NotNull PublishStage paramPublishStage, @NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo);
  
  public abstract void a(@NotNull PublishStage paramPublishStage, @NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull String paramString);
  
  public abstract void a(@NotNull PublishStage paramPublishStage, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void b(@NotNull PublishStage paramPublishStage);
  
  public abstract void c(@NotNull PublishStage paramPublishStage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.IPublishArticleListener
 * JD-Core Version:    0.7.0.1
 */