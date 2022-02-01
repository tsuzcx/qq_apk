package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.VideoInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$compressVideo$1$2$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$compressVideo$1$2$1(PublishManager.compressVideo.1.2 param2, String paramString1, String paramString2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.this$0.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setFileMd5(this.$md5);
    this.this$0.this$0.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setFileSha1(this.$sha1);
    this.this$0.this$0.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setFileSize(new File(this.this$0.this$0.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.getFilePath()).length());
    PublishManager.b(PublishManager.a, this.this$0.this$0.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.this$0.this$0.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo, this.this$0.this$0.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.compressVideo.1.2.1
 * JD-Core Version:    0.7.0.1
 */