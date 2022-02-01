package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsGuideProxy;", "", "()V", "columnGuideManager", "Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager;", "getColumnGuideManager", "()Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager;", "setColumnGuideManager", "(Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager;)V", "hasShowVideoColumnGuide", "", "userGuideController", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideofeedsUserGuideController;", "getUserGuideController", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideofeedsUserGuideController;", "setUserGuideController", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideofeedsUserGuideController;)V", "dismissGuideAnim", "", "getPlayPercent", "", "currentTs", "", "playParam", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "hideUserGuide", "needShowVideoColumnGuide", "onVideoProgressChange", "rootView", "Landroid/view/View;", "videoRootView", "setFullScreen", "fullScreen", "setNeedUserGuide", "needGuide", "showUserGuide", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsGuideProxy
{
  public static final VideoFeedsGuideProxy.Companion a = new VideoFeedsGuideProxy.Companion(null);
  @Nullable
  private VideofeedsUserGuideController b;
  @Nullable
  private VideoColumnGuideManager c;
  private boolean d;
  
  private final boolean a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    return (PlayerHelper.a.a()) && (!this.d) && (b(paramLong, paramVideoPlayParam) >= 20) && (paramVideoPlayParam.c.h());
  }
  
  private final float b(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam = paramVideoPlayParam.h;
    long l;
    if (paramVideoPlayParam != null) {
      l = paramVideoPlayParam.I();
    } else {
      l = 0L;
    }
    return (float)paramLong * 100.0F / (float)l;
  }
  
  public final void a()
  {
    VideofeedsUserGuideController localVideofeedsUserGuideController = this.b;
    if (localVideofeedsUserGuideController != null) {
      localVideofeedsUserGuideController.a();
    }
  }
  
  public final void a(@Nullable VideofeedsUserGuideController paramVideofeedsUserGuideController)
  {
    this.b = paramVideofeedsUserGuideController;
  }
  
  public final void a(@Nullable VideoColumnGuideManager paramVideoColumnGuideManager)
  {
    this.c = paramVideoColumnGuideManager;
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoInfo.ay == null)
    {
      VideofeedsUserGuideController localVideofeedsUserGuideController = this.b;
      if (localVideofeedsUserGuideController != null) {
        localVideofeedsUserGuideController.a(paramVideoInfo);
      }
    }
  }
  
  public final void a(@NotNull VideoPlayParam paramVideoPlayParam, long paramLong, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (a(paramLong, paramVideoPlayParam))
    {
      paramVideoPlayParam = this.c;
      boolean bool;
      if (paramVideoPlayParam != null) {
        bool = paramVideoPlayParam.a(paramView1, paramView2);
      } else {
        bool = false;
      }
      this.d = bool;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((VideofeedsUserGuideController)localObject).a(paramBoolean);
    }
    localObject = this.c;
    if (localObject != null) {
      ((VideoColumnGuideManager)localObject).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((VideofeedsUserGuideController)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      ((VideoColumnGuideManager)localObject).a();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    VideofeedsUserGuideController localVideofeedsUserGuideController = this.b;
    if (localVideofeedsUserGuideController != null) {
      localVideofeedsUserGuideController.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGuideProxy
 * JD-Core Version:    0.7.0.1
 */