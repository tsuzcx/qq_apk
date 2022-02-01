package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$compressVideo$1$1$onCompressFinished$1$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$compressVideo$1$1$onCompressFinished$1$1(PublishManager.compressVideo.1.1.onCompressFinished.1 param1, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str;
    if (this.this$0.$succeed)
    {
      TLog.a("PublishManager", "压缩成功");
      VideoInfo localVideoInfo = this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo;
      str = this.this$0.$outPath;
      if (str != null)
      {
        localVideoInfo.setCompressPath(str);
        label48:
        this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setFileMd5(this.$md5);
        if (((CharSequence)this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.getCompressPath()).length() <= 0) {
          break label205;
        }
      }
    }
    label205:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setFileSize(new File(this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.getCompressPath()).length());
      }
      PublishManager.b(PublishManager.a, this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo, this.this$0.this$0.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo);
      return;
      str = "";
      break;
      TLog.a("PublishManager", "压缩失败");
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.compressVideo.1.1.onCompressFinished.1.1
 * JD-Core Version:    0.7.0.1
 */