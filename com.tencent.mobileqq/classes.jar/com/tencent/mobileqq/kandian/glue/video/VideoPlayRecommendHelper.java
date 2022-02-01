package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.studymode.StudyModeManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/video/VideoPlayRecommendHelper;", "", "()V", "getRecommendFlag", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayRecommendHelper
{
  public static final VideoPlayRecommendHelper a = new VideoPlayRecommendHelper();
  
  @JvmStatic
  public static final int a()
  {
    if (StudyModeManager.a()) {
      return 8193;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayRecommendHelper
 * JD-Core Version:    0.7.0.1
 */