package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.VideoStatusListener;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskTimer;
import com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingPresenter;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskVideoTimer;", "Lcom/tencent/mobileqq/kandian/biz/reward/api/IRIJRewardTaskTimer;", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager$VideoStatusListener;", "Lcom/tencent/mobileqq/kandian/biz/video/api/OnPlayStateListener;", "()V", "curRowKey", "", "isResume", "", "presenter", "Lcom/tencent/mobileqq/kandian/biz/reward/mvp/RIJRewardTaskTimingPresenter;", "kotlin.jvm.PlatformType", "getPresenter", "()Lcom/tencent/mobileqq/kandian/biz/reward/mvp/RIJRewardTaskTimingPresenter;", "presenter$delegate", "Lkotlin/Lazy;", "afterVideoStart", "", "playParam", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "attach", "manager", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager;", "Lcom/tencent/mobileqq/kandian/glue/video/VideoPlayManager;", "beforeVideoStart", "enabled", "onCompletion", "onPause", "onResume", "onStateChange", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/VideoPlayParam;", "Lcom/tencent/mobileqq/kandian/biz/reward/VideoFeedsPlayParam;", "videoPlayerWrapper", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoPlayerWrapper;", "oldState", "", "newState", "extra", "", "onVideoBufferEnd", "isPlaying", "onVideoBufferStart", "onVideoError", "model", "what", "errorMsg", "onVideoInitiate", "onVideoPause", "onVideoReplayOnLoop", "times", "onVideoRestart", "onVideoStop", "isCompleted", "startTiming", "rowKey", "maxTaskTimeInMs", "stopTiming", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskVideoTimer
  implements VideoFeedsPlayManager.VideoStatusListener, IRIJRewardTaskTimer, OnPlayStateListener
{
  private String jdField_a_of_type_JavaLangString;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskVideoTimer.presenter.2.INSTANCE);
  private boolean jdField_a_of_type_Boolean;
  
  private final RIJRewardTaskTimingPresenter a()
  {
    return (RIJRewardTaskTimingPresenter)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final void h(com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramVideoPlayParam != null)
      {
        localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (localObject != null)
        {
          localObject = ((VideoInfo)localObject).g;
          break label35;
        }
      }
      localObject = null;
      label35:
      if ((Intrinsics.areEqual(localObject, this.jdField_a_of_type_JavaLangString) ^ true)) {
        stopTiming();
      }
    }
    if (paramVideoPlayParam != null)
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if ((localObject != null) && (((VideoInfo)localObject).r == true)) {}
    }
    else if (paramVideoPlayParam != null)
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).g;
        if (localObject != null)
        {
          paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
          long l;
          if (paramVideoPlayParam != null) {
            l = paramVideoPlayParam.b();
          } else {
            l = 0L;
          }
          startTiming((String)localObject, (int)l);
        }
      }
    }
  }
  
  private final void i(com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramVideoPlayParam != null)
      {
        paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (paramVideoPlayParam != null)
        {
          paramVideoPlayParam = paramVideoPlayParam.g;
          break label30;
        }
      }
      paramVideoPlayParam = null;
      label30:
      if (Intrinsics.areEqual(paramVideoPlayParam, this.jdField_a_of_type_JavaLangString)) {
        stopTiming();
      }
    }
  }
  
  public final void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(@NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoFeedsPlayManager, "manager");
    paramVideoFeedsPlayManager.a((VideoFeedsPlayManager.VideoStatusListener)this);
  }
  
  public void a(@Nullable com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam paramVideoPlayParam, @Nullable IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    if ((paramVideoPlayParam != null) && (!paramVideoPlayParam.b))
    {
      if (paramInt2 == 3)
      {
        if ((this.jdField_a_of_type_JavaLangString != null) && ((Intrinsics.areEqual(paramVideoPlayParam.j, this.jdField_a_of_type_JavaLangString) ^ true))) {
          stopTiming();
        }
        paramVideoPlayParam = paramVideoPlayParam.j;
        Intrinsics.checkExpressionValueIsNotNull(paramVideoPlayParam, "playParam.videoArticleID");
        long l;
        if (paramIVideoPlayerWrapper != null) {
          l = paramIVideoPlayerWrapper.b();
        } else {
          l = 0L;
        }
        startTiming(paramVideoPlayParam, (int)l);
        return;
      }
      if ((paramInt1 == 3) && (this.jdField_a_of_type_JavaLangString != null) && (Intrinsics.areEqual(paramVideoPlayParam.j, this.jdField_a_of_type_JavaLangString))) {
        stopTiming();
      }
      return;
    }
    stopTiming();
  }
  
  public void a(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam) {}
  
  public void a(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam, int paramInt) {}
  
  public void a(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, @Nullable String paramString)
  {
    i(paramVideoPlayParam);
  }
  
  public void a(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    i(paramVideoPlayParam);
  }
  
  public final void a(@NotNull VideoPlayManager paramVideoPlayManager)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayManager, "manager");
    paramVideoPlayManager.a((OnPlayStateListener)this);
  }
  
  public boolean a()
  {
    return ((RIJRewardTaskConfig.a()) || (RIJUserLevelTimeUtils.a())) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab());
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam) {}
  
  public void b(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    h(paramVideoPlayParam);
  }
  
  public void c(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam)
  {
    h(paramVideoPlayParam);
  }
  
  public void d(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam)
  {
    i(paramVideoPlayParam);
  }
  
  public void e(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam)
  {
    i(paramVideoPlayParam);
  }
  
  public void f(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam)
  {
    h(paramVideoPlayParam);
  }
  
  public void g(@Nullable com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam)
  {
    i(paramVideoPlayParam);
  }
  
  public void startTiming(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    if ((a()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      a().a(paramString, paramInt, 2);
    }
  }
  
  public void stopTiming()
  {
    this.jdField_a_of_type_JavaLangString = ((String)null);
    a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskVideoTimer
 * JD-Core Version:    0.7.0.1
 */