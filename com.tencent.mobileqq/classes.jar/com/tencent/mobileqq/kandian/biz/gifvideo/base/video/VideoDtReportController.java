package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDtReportController;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "videoPlayController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "dtPgid", "getDtPgid", "setDtPgid", "playSessionId", "getPlaySessionId", "setPlaySessionId", "getVideoPlayController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "onStateChanged", "", "oldState", "", "newState", "reportDtVideoEnd", "reportDtVideoStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoDtReportController
  implements VideoPlayController.OnStateChangeListener
{
  @NotNull
  private String a;
  @Nullable
  private String b;
  @Nullable
  private String c;
  @Nullable
  private VideoPlayController d;
  
  public VideoDtReportController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.d = paramVideoPlayController;
    this.a = "VideoDtReportController";
    paramVideoPlayController = this.d;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  private final void c()
  {
    Object localObject1 = this.d;
    AbsBaseArticleInfo localAbsBaseArticleInfo = null;
    if (localObject1 != null) {
      localObject1 = ((VideoPlayController)localObject1).i();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.d;
    if (localObject2 != null) {
      localObject2 = ((VideoPlayController)localObject2).j();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.d;
    if (localObject3 != null)
    {
      localObject3 = ((VideoPlayController)localObject3).j();
      if (localObject3 != null)
      {
        localObject3 = ((IVideoView)localObject3).a();
        break label71;
      }
    }
    localObject3 = null;
    label71:
    VideoPlayController localVideoPlayController = this.d;
    if (localVideoPlayController != null) {
      localAbsBaseArticleInfo = localVideoPlayController.k();
    }
    KotlinUtilKt.a(localObject1, localObject2, localObject3, localAbsBaseArticleInfo, (Function4)new VideoDtReportController.reportDtVideoStart.1(this));
  }
  
  private final void d()
  {
    Object localObject1 = this.d;
    AbsBaseArticleInfo localAbsBaseArticleInfo = null;
    if (localObject1 != null) {
      localObject1 = ((VideoPlayController)localObject1).i();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.d;
    if (localObject2 != null) {
      localObject2 = ((VideoPlayController)localObject2).j();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.d;
    if (localObject3 != null)
    {
      localObject3 = ((VideoPlayController)localObject3).j();
      if (localObject3 != null)
      {
        localObject3 = ((IVideoView)localObject3).a();
        break label71;
      }
    }
    localObject3 = null;
    label71:
    VideoPlayController localVideoPlayController = this.d;
    if (localVideoPlayController != null) {
      localAbsBaseArticleInfo = localVideoPlayController.k();
    }
    KotlinUtilKt.a(localObject1, localObject2, localObject3, localAbsBaseArticleInfo, (Function4)new VideoDtReportController.reportDtVideoEnd.1(this));
  }
  
  @Nullable
  public final String a()
  {
    return this.b;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  @Nullable
  public final String b()
  {
    return this.c;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      if (paramInt2 != 4)
      {
        if ((paramInt2 == 9) || (paramInt2 == 11)) {}
      }
      else
      {
        c();
        return;
      }
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoDtReportController
 * JD-Core Version:    0.7.0.1
 */