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
    HttpDownloadUtil.download(ReadInJoyUtils.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.components.VideoAnimationView.setupVideo.1
 * JD-Core Version:    0.7.0.1
 */