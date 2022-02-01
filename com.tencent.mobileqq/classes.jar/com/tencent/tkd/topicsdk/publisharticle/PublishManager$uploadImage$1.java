package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.Uploader;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishManager$uploadImage$1", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "onCancel", "", "onFailed", "errMsg", "", "onPause", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "url", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$uploadImage$1
  implements IUploadListener
{
  PublishManager$uploadImage$1(PublishArticleInfo paramPublishArticleInfo, ImageInfo paramImageInfo, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    paramLong2 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getHasUploadFileSize();
    PublishManager.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getPublishId(), (int)((paramLong2 + paramLong1) * 100 / this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getTotalFileSize()));
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    TLog.a("PublishManager", "图片开始上传");
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    TLog.a("PublishManager", "图片上传成功,url=" + paramString);
    PublishManager.PublishTask localPublishTask = PublishManager.a(PublishManager.a, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getPublishId());
    if (localPublishTask != null) {
      localPublishTask.a((Uploader)null);
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanImageInfo.setUrl(paramString);
    paramString = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
    paramString.setHasUploadFileSize(paramString.getHasUploadFileSize() + this.jdField_a_of_type_ComTencentTkdTopicsdkBeanImageInfo.getSize());
    if (!PublishManager.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo))
    {
      PublishManager.a.a();
      PublishManager.a.b(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo);
      return;
    }
    TLog.a("PublishManager", "uploadMedia success");
    PublishManager.a(PublishManager.a, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo);
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    PublishManager.a.c(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.uploadImage.1
 * JD-Core Version:    0.7.0.1
 */