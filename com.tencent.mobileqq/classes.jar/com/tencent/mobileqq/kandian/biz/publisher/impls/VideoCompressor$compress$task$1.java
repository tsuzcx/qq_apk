package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask.VideoCompressTaskListener;
import com.tencent.mobileqq.kandian.base.video.compress.VideoMediaInfo;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.VideoCompressListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/VideoCompressor$compress$task$1", "Lcom/tencent/mobileqq/kandian/base/video/compress/VideoCompressTask$VideoCompressTaskListener;", "onCompressFinished", "", "retCode", "", "outPath", "", "outMediaInfo", "Lcom/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo;", "onCompressProgress", "progress", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCompressor$compress$task$1
  implements VideoCompressTask.VideoCompressTaskListener
{
  VideoCompressor$compress$task$1(IVideoCompressor.VideoCompressListener paramVideoCompressListener) {}
  
  public void a(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void a(int paramInt, @Nullable String paramString, @Nullable VideoMediaInfo paramVideoMediaInfo)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.a.a(bool1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.VideoCompressor.compress.task.1
 * JD-Core Version:    0.7.0.1
 */