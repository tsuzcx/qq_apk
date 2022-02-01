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
  public static final VideoFeedsGuideProxy.Companion a;
  @Nullable
  private VideofeedsUserGuideController jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController;
  @Nullable
  private VideoColumnGuideManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnGuideManager;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy$Companion = new VideoFeedsGuideProxy.Companion(null);
  }
  
  private final float a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    long l;
    if (paramVideoPlayParam != null) {
      l = paramVideoPlayParam.b();
    } else {
      l = 0L;
    }
    return (float)paramLong * 100.0F / (float)l;
  }
  
  private final boolean a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    return (PlayerHelper.a.a()) && (!this.jdField_a_of_type_Boolean) && (a(paramLong, paramVideoPlayParam) >= 20) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.e());
  }
  
  public final void a()
  {
    VideofeedsUserGuideController localVideofeedsUserGuideController = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController;
    if (localVideofeedsUserGuideController != null) {
      localVideofeedsUserGuideController.a();
    }
  }
  
  public final void a(@Nullable VideofeedsUserGuideController paramVideofeedsUserGuideController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController = paramVideofeedsUserGuideController;
  }
  
  public final void a(@Nullable VideoColumnGuideManager paramVideoColumnGuideManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnGuideManager = paramVideoColumnGuideManager;
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoInfo.a == null)
    {
      VideofeedsUserGuideController localVideofeedsUserGuideController = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController;
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
      paramVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnGuideManager;
      boolean bool;
      if (paramVideoPlayParam != null) {
        bool = paramVideoPlayParam.a(paramView1, paramView2);
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController;
    if (localObject != null) {
      ((VideofeedsUserGuideController)localObject).a(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnGuideManager;
    if (localObject != null) {
      ((VideoColumnGuideManager)localObject).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController;
    if (localObject != null) {
      ((VideofeedsUserGuideController)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnGuideManager;
    if (localObject != null) {
      ((VideoColumnGuideManager)localObject).a();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    VideofeedsUserGuideController localVideofeedsUserGuideController = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController;
    if (localVideofeedsUserGuideController != null) {
      localVideofeedsUserGuideController.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGuideProxy
 * JD-Core Version:    0.7.0.1
 */