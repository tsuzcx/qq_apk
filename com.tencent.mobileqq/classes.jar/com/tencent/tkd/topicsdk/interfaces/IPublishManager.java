package com.tencent.tkd.topicsdk.interfaces;

import android.content.Context;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PreUploadVideoInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "", "addPublishListener", "", "listener", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishListener;", "pauseUploadVideo", "publishId", "", "preUploadVideo", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "preUploadVideoInfo", "Lcom/tencent/tkd/topicsdk/bean/PreUploadVideoInfo;", "isStart", "", "publishStatusListener", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishStatusListener;", "removePublishListener", "removePublishStatusListener", "resumeUploadVideo", "showMobileNetworkDialog", "context", "Landroid/content/Context;", "fileSize", "", "callback", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$ICheckResultCallBack;", "startPublish", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "ICheckResultCallBack", "IPublishListener", "IPublishStatusListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublishManager
{
  public abstract void a(@NotNull Context paramContext, long paramLong, @NotNull IPublishManager.ICheckResultCallBack paramICheckResultCallBack);
  
  public abstract void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PreUploadVideoInfo paramPreUploadVideoInfo, boolean paramBoolean, @NotNull IPublishManager.IPublishStatusListener paramIPublishStatusListener);
  
  public abstract void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo);
  
  public abstract void a(@NotNull IPublishManager.IPublishStatusListener paramIPublishStatusListener);
  
  public abstract void a(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IPublishManager
 * JD-Core Version:    0.7.0.1
 */