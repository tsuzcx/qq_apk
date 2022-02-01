package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.Callback;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.VideoCompressListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "needCompress", "", "call"}, k=3, mv={1, 1, 16})
final class PublishManager$compressVideo$1
  implements IVideoCompressor.Callback
{
  PublishManager$compressVideo$1(VideoInfo paramVideoInfo, IVideoCompressor paramIVideoCompressor, PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setNeedCompress(paramBoolean);
    TLog.a("PublishManager", "compressVideo, needCompress=" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIVideoCompressor.a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.getFilePath(), (IVideoCompressor.VideoCompressListener)new PublishManager.compressVideo.1.1(this));
      return;
    }
    ThreadManagerKt.c((Function0)new PublishManager.compressVideo.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.compressVideo.1
 * JD-Core Version:    0.7.0.1
 */