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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$createAndStartUploadCoverTask$1", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "onCancel", "", "onFailed", "errMsg", "", "onPauseFailed", "onPauseSuccess", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "url", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$createAndStartUploadCoverTask$1
  implements IUploadListener
{
  PublishManager$createAndStartUploadCoverTask$1(VideoInfo paramVideoInfo, PublishStage paramPublishStage, PublishArticleInfo paramPublishArticleInfo, PublishManager.PublishTask paramPublishTask, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.setCoverProgress((int)(paramLong1 * 100 / paramLong2));
    PublishManager.a(PublishManager.a, this.b, this.c.getPublishId(), (int)this.a.getProgress());
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    this.a.setCoverProgress(100);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("封面上传成功,url = ");
    ((StringBuilder)localObject).append(paramString);
    TLog.d("PublishManager", ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null) {
      ((PublishManager.PublishTask)localObject).a(null);
    }
    this.a.setCoverUrl(paramString);
    PublishManager.a(PublishManager.a, this.e, this.c, this.a);
    PublishManager.a.a();
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    TLog.d("PublishManager", "封面上传失败");
    TopicSDKHelperKt.a("视频封面上传失败");
    PublishManager.a(PublishManager.a, this.b, this.e, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.createAndStartUploadCoverTask.1
 * JD-Core Version:    0.7.0.1
 */