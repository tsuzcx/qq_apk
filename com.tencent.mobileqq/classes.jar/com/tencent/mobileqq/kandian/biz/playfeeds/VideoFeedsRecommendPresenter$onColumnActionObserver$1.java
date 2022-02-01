package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter$onColumnActionObserver$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onViolaPageFailed", "", "violaPageName", "", "fromType", "", "onViolaTopicVideoAnimStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter$onColumnActionObserver$1
  extends ReadInJoyObserver
{
  public void b(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "violaPageName");
    if ((paramInt == 1) || (paramInt == 2))
    {
      paramString = this.a.a();
      if (paramString != null) {
        paramString = paramString.a;
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        paramString = this.a.a();
        if (paramString != null)
        {
          paramString = paramString.a;
          if (paramString != null) {
            paramString.o();
          }
        }
      }
      else
      {
        QLog.e("VideoFeedsRecommendPresenter", 2, "onViolaPageFailed callback, attachVideoPlayer videoPlayer is null");
      }
    }
  }
  
  public void i()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onViolaTopicVideoAnimStart mVideoFromType：");
      ((StringBuilder)localObject).append(this.a.c());
      QLog.d("VideoFeedsRecommendPresenter", 2, ((StringBuilder)localObject).toString());
    }
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this);
    if (ReadInJoyHelper.d(this.a.c()))
    {
      localObject = this.a.a();
      if (localObject != null) {
        ((Activity)localObject).finish();
      }
    }
    else
    {
      VideoFeedsRecommendPresenter.a(this.a, true);
      if (this.a.a() != null)
      {
        localObject = this.a.a();
        if (localObject != null) {
          ((VideoPlayParam)localObject).a = ((IVideoPlayerWrapper)null);
        }
        this.a.a().a(ReportConstants.VideoEndType.EXIT_SCENE);
        this.a.a().b(this.a.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter.onColumnActionObserver.1
 * JD-Core Version:    0.7.0.1
 */