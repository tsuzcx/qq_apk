package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.Callback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "needCompress", "", "call"}, k=3, mv={1, 1, 16})
final class PublishManager$compressVideo$1
  implements IVideoCompressor.Callback
{
  PublishManager$compressVideo$1(VideoInfo paramVideoInfo, IVideoCompressor paramIVideoCompressor, PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public final void a(boolean paramBoolean)
  {
    this.a.setNeedCompress(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compressVideo, needCompress=");
    localStringBuilder.append(paramBoolean);
    TLog.a("PublishManager", localStringBuilder.toString());
    if (paramBoolean)
    {
      PublishManager.a(PublishManager.a, this.b, this.a, this.c, this.d);
      return;
    }
    ThreadManagerKt.c((Function0)new PublishManager.compressVideo.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.compressVideo.1
 * JD-Core Version:    0.7.0.1
 */