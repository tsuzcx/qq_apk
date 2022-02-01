package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.VideoCompressListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishManager$compressVideo$1$1", "Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor$VideoCompressListener;", "onCompressFinished", "", "succeed", "", "outPath", "", "onCompressProgress", "progress", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$compressVideo$1$1
  implements IVideoCompressor.VideoCompressListener
{
  public void a(float paramFloat)
  {
    if (!this.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.isPublishing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setCompressProgress((int)paramFloat);
    TLog.b("PublishManager", "onCompressProgress, progress=" + paramFloat);
    PublishManager.a.a(this.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getPublishId(), (int)this.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.getProgress());
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString)
  {
    if (!this.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.isPublishing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentTkdTopicsdkBeanVideoInfo.setCompressProgress(100);
    ThreadManagerKt.c((Function0)new PublishManager.compressVideo.1.1.onCompressFinished.1(this, paramString, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.compressVideo.1.1
 * JD-Core Version:    0.7.0.1
 */