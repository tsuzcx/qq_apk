package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$createAndStartUploadVideoTask$1", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "onCancel", "", "onFailed", "errMsg", "", "onPauseFailed", "onPauseSuccess", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "url", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$createAndStartUploadVideoTask$1
  implements IUploadListener
{
  PublishManager$createAndStartUploadVideoTask$1(PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo, PublishManager.PublishTask paramPublishTask, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b.setVideoProgress(paramLong1 * 100 / paramLong2);
    PublishManager.a(PublishManager.a, PublishStage.PUBLISH_STAGE_UPLOAD_VIDEO, this.a.getPublishId(), (int)this.b.getProgress());
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    TLog.a("PublishManager", "视频开始上传");
    this.a.setVideoUploadKey(paramString);
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("视频上传成功, url=");
    ((StringBuilder)localObject).append(paramString);
    TLog.a("PublishManager", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((PublishManager.PublishTask)localObject).a(null);
    }
    this.b.setUrl(paramString);
    PublishManager.b(PublishManager.a, this.d, this.a);
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    TLog.a("PublishManager", "视频上传失败");
    TopicSDKHelperKt.a("视频上传失败");
    PublishManager.a(PublishManager.a, PublishStage.PUBLISH_STAGE_UPLOAD_VIDEO, this.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.createAndStartUploadVideoTask.1
 * JD-Core Version:    0.7.0.1
 */