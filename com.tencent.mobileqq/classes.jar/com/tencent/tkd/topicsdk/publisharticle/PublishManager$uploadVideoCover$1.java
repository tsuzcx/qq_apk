package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.Uploader;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishManager$uploadVideoCover$1", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "onCancel", "", "onFailed", "errMsg", "", "onPause", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "url", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$uploadVideoCover$1
  implements IUploadListener
{
  PublishManager$uploadVideoCover$1(VideoInfo paramVideoInfo, PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setCoverProgress((int)(100 * paramLong1 / paramLong2));
    PublishManager.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getPublishId(), (int)this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.getProgress());
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setCoverProgress(100);
    TLog.d("PublishManager", "封面上传成功,url = " + paramString);
    PublishManager.PublishTask localPublishTask = PublishManager.a(PublishManager.a, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getPublishId());
    if (localPublishTask != null) {
      localPublishTask.a((Uploader)null);
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setCoverUrl(paramString);
    PublishManager.a(PublishManager.a, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo);
    PublishManager.a.a();
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    TLog.d("PublishManager", "封面上传失败");
    PublishManager.a.c(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.uploadVideoCover.1
 * JD-Core Version:    0.7.0.1
 */