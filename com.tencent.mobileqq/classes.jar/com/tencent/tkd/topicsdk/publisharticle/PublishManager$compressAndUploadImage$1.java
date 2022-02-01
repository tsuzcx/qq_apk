package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.imagecompress.OnCompressListener;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishManager$compressAndUploadImage$1", "Lcom/tencent/tkd/topicsdk/imagecompress/OnCompressListener;", "onError", "", "e", "", "onStart", "onSuccess", "file", "Ljava/io/File;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$compressAndUploadImage$1
  implements OnCompressListener
{
  PublishManager$compressAndUploadImage$1(ImageInfo paramImageInfo, GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo) {}
  
  public void a()
  {
    TLog.a("PublishManager", "图片开始压缩");
  }
  
  public void a(@Nullable File paramFile)
  {
    Object localObject = new StringBuilder().append("图片压缩成功, 压缩前 size:").append(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanImageInfo.getSize() / 1024).append("kb, ").append("压缩后 size:");
    long l;
    ImageInfo localImageInfo;
    if (paramFile != null)
    {
      l = paramFile.length();
      TLog.a("PublishManager", l / 1024 + "kb");
      localImageInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanImageInfo;
      if (paramFile == null) {
        break label159;
      }
      localObject = paramFile.getAbsolutePath();
      if (localObject == null) {
        break label159;
      }
      label93:
      localImageInfo.setFilePath((String)localObject);
      if (paramFile == null) {
        break label169;
      }
      l = paramFile.length();
      label109:
      localImageInfo.setSize(l);
      if (paramFile == null) {
        break label178;
      }
    }
    label159:
    label169:
    label178:
    for (boolean bool = true;; bool = false)
    {
      localImageInfo.setHasCompressed(bool);
      PublishManager.a.a();
      PublishManager.a(PublishManager.a, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanImageInfo);
      return;
      l = 0L;
      break;
      localObject = localImageInfo.getFilePath();
      break label93;
      l = localImageInfo.getSize();
      break label109;
    }
  }
  
  public void a(@Nullable Throwable paramThrowable)
  {
    TLog.d("PublishManager", "图片压缩失败");
    PublishManager.a.c(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.compressAndUploadImage.1
 * JD-Core Version:    0.7.0.1
 */