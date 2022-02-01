package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$createAndStartUploadImageTask$1", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "onCancel", "", "onFailed", "errMsg", "", "onPauseFailed", "onPauseSuccess", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "url", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$createAndStartUploadImageTask$1
  implements IUploadListener
{
  PublishManager$createAndStartUploadImageTask$1(PublishArticleInfo paramPublishArticleInfo, PublishStage paramPublishStage, PublishManager.PublishTask paramPublishTask, ImageInfo paramImageInfo, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    paramLong2 = this.a.getHasUploadFileSize();
    PublishManager.a(PublishManager.a, this.b, this.a.getPublishId(), (int)((paramLong2 + paramLong1) * 100 / this.a.getTotalFileSize()));
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    TLog.a("PublishManager", "图片开始上传");
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("图片上传成功,url=");
    ((StringBuilder)localObject).append(paramString);
    TLog.a("PublishManager", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((PublishManager.PublishTask)localObject).a(null);
    }
    this.d.setUrl(paramString);
    paramString = this.a;
    paramString.setHasUploadFileSize(paramString.getHasUploadFileSize() + this.d.getSize());
    if (!PublishManager.a.a(this.a))
    {
      PublishManager.a.a();
      PublishManager.a(PublishManager.a, this.e, this.a);
      return;
    }
    TLog.a("PublishManager", "uploadMedia success");
    PublishManager.b(PublishManager.a, this.e, this.a);
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    TopicSDKHelperKt.a("图片上传失败");
    PublishManager.a(PublishManager.a, this.b, this.e, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.createAndStartUploadImageTask.1
 * JD-Core Version:    0.7.0.1
 */