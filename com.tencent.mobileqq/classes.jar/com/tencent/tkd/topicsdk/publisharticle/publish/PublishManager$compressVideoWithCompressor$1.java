package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.VideoCompressListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$compressVideoWithCompressor$1", "Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor$VideoCompressListener;", "cancel", "", "onCompressFinished", "succeed", "", "outPath", "", "onCompressProgress", "progress", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$compressVideoWithCompressor$1
  implements IVideoCompressor.VideoCompressListener
{
  PublishManager$compressVideoWithCompressor$1(PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo, GlobalPublisherConfig paramGlobalPublisherConfig) {}
  
  public void a(float paramFloat)
  {
    if (!this.a.isPublishing()) {
      return;
    }
    this.b.setCompressProgress((int)paramFloat);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompressProgress, progress=");
    localStringBuilder.append(paramFloat);
    TLog.b("PublishManager", localStringBuilder.toString());
    PublishManager.a(PublishManager.a, PublishStage.PUBLISH_STAGE_COMPRESS_VIDEO, this.a.getPublishId(), (int)this.b.getProgress());
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString)
  {
    if (!this.a.isPublishing()) {
      return;
    }
    this.b.setCompressProgress(100);
    ThreadManagerKt.c((Function0)new PublishManager.compressVideoWithCompressor.1.onCompressFinished.1(this, paramString, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.compressVideoWithCompressor.1
 * JD-Core Version:    0.7.0.1
 */