package com.tencent.mobileqq.kandian.glue.viola.components;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoAnimationView$setupVideo$1
  implements Runnable
{
  VideoAnimationView$setupVideo$1(String paramString, File paramFile) {}
  
  public final void run()
  {
    HttpDownloadUtil.download(ReadInJoyUtils.b(), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.components.VideoAnimationView.setupVideo.1
 * JD-Core Version:    0.7.0.1
 */