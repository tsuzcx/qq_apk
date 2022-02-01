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
  public static final VideoReportController.Companion a = new VideoReportController.Companion(null);
  @NotNull
  private static CopyOnWriteArrayList<String> f = new CopyOnWriteArrayList();
  @NotNull
  private String b;
  private long c;
  private long d;
  @Nullable
  private VideoPlayController e;
  
  public VideoReportController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.e = paramVideoPlayController;
    this.b = "VideoReportController";
    paramVideoPlayController = this.e;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  public final long a()
  {
    return this.d;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final void b()
  {
    this.c = 0L;
    this.d = 0L;
  }
  
  public final void c()
  {
    this.c = System.currentTimeMillis();
  }
  
  public final void d()
  {
    this.d += System.currentTimeMillis() - this.c;
  }
  
  public final void e()
  {
    VideoPlayController localVideoPlayController = this.e;
    if (localVideoPlayController != null) {
      localVideoPlayController.g((Function0)new VideoReportController.reportPlayDuration.1(this));
    }
  }
  
  public final void f()
  {
    VideoPlayController localVideoPlayController = this.e;
    if (localVideoPlayController != null) {
      localVideoPlayController.g((Function0)new VideoReportController.reportExposureVideo.1(this));
    }
  }
  
  @Nullable
  public final VideoPlayController g()
  {
    return this.e;
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 7) {
      d();
    }
    if (paramInt2 != 0) {
      if (paramInt2 != 4)
      {
        if (paramInt2 != 7)
        {
          if ((paramInt2 == 9) || (paramInt2 == 11)) {}
        }
        else {
          c();
        }
      }
      else
      {
        b();
        return;
      }
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoReportController
 * JD-Core Version:    0.7.0.1
 */