package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.Uploader;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishManager$uploadVideo$1", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "onCancel", "", "onFailed", "errMsg", "", "onPause", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "url", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$uploadVideo$1
  implements IUploadListener
{
  PublishManager$uploadVideo$1(PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setVideoProgress(paramLong1 * 100 / paramLong2);
    PublishManager.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getPublishId(), (int)this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.getProgress());
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    TLog.a("PublishManager", "视频开始上传");
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.setVideoUploadKey(paramString);
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("视频上传成功, url=");
    ((StringBuilder)localObject).append(paramString);
    TLog.a("PublishManager", ((StringBuilder)localObject).toString());
    localObject = PublishManager.a(PublishManager.a, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getPublishId());
    if (localObject != null) {
      ((PublishManager.PublishTask)localObject).a((Uploader)null);
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setUrl(paramString);
    PublishManager.a(PublishManager.a, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo);
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    TLog.a("PublishManager", "视频上传失败");
    TopicSDKHelperKt.a("视频上传失败");
    PublishManager.a.c(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.uploadVideo.1
 * JD-Core Version:    0.7.0.1
 */