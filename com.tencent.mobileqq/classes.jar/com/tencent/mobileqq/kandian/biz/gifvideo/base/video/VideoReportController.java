package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoReportController;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "videoPlayController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "lastPlayTime", "", "getLastPlayTime", "()J", "setLastPlayTime", "(J)V", "getVideoPlayController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "watchPlayTime", "getWatchPlayTime", "setWatchPlayTime", "initPlayTime", "", "onStateChanged", "oldState", "", "newState", "recordEndPlayTime", "recordStartPlayTime", "reportExposureVideo", "reportPlayDuration", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoReportController
  implements VideoPlayController.OnStateChangeListener
{
  public static final VideoReportController.Companion a;
  @NotNull
  private static CopyOnWriteArrayList<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private long jdField_a_of_type_Long;
  @Nullable
  private VideoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoReportController$Companion = new VideoReportController.Companion(null);
  }
  
  public VideoReportController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController = paramVideoPlayController;
    this.jdField_a_of_type_JavaLangString = "VideoReportController";
    paramVideoPlayController = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  public final long a()
  {
    return this.b;
  }
  
  @Nullable
  public final VideoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public final void c()
  {
    this.b += System.currentTimeMillis() - this.jdField_a_of_type_Long;
  }
  
  public final void d()
  {
    VideoPlayController localVideoPlayController = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
    if (localVideoPlayController != null) {
      localVideoPlayController.g((Function0)new VideoReportController.reportPlayDuration.1(this));
    }
  }
  
  public final void e()
  {
    VideoPlayController localVideoPlayController = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController;
    if (localVideoPlayController != null) {
      localVideoPlayController.g((Function0)new VideoReportController.reportExposureVideo.1(this));
    }
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 7) {
      c();
    }
    if (paramInt2 != 0) {
      if (paramInt2 != 4)
      {
        if (paramInt2 != 7)
        {
          if ((paramInt2 == 9) || (paramInt2 == 11)) {}
        }
        else {
          b();
        }
      }
      else
      {
        a();
        return;
      }
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoReportController
 * JD-Core Version:    0.7.0.1
 */