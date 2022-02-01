package com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGradientMaskView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowLayout;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowLayout.OnFollowActionListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.StressState;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/TiktokVideoItemDelegate;", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemDelegate;", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout$OnFollowActionListener;", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/TiktokVideoItemHolder;", "presenter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/TiktokVideoItemHolder;Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter;Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;)V", "getDianZanDrawable", "", "isDianZan", "", "getRewardCoinIconRes", "info", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "hideAutoSeekBarTimer", "", "onFollowClick", "videoInfo", "onMenuDataChanged", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "setFooterVisibility", "visible", "setHeaderVisibility", "showAutoSeekBarTimer", "updateCommentUI", "updateFollowStateAndUI", "needAnim", "updateStressFollowLayoutUi", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TiktokVideoItemDelegate
  extends ShortVideoItemDelegate
  implements VideoFeedsStressFollowLayout.OnFollowActionListener
{
  private final TiktokVideoItemHolder e;
  
  public TiktokVideoItemDelegate(@NotNull TiktokVideoItemHolder paramTiktokVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super((ShortVideoItemHolder)paramTiktokVideoItemHolder, paramVideoFeedsRecommendPresenter, paramVideoFeedsAdapter);
    this.e = paramTiktokVideoItemHolder;
    paramTiktokVideoItemHolder = VideoFeedsHelper.c(paramVideoFeedsRecommendPresenter.v());
    float f = paramTiktokVideoItemHolder[1];
    int j = 0;
    if (f / paramTiktokVideoItemHolder[0] >= 1.97D)
    {
      paramTiktokVideoItemHolder = this.e;
      paramVideoFeedsRecommendPresenter = paramTiktokVideoItemHolder.aM;
      int i = j;
      if (paramVideoFeedsRecommendPresenter != null)
      {
        paramVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter.getLayoutParams();
        i = j;
        if (paramVideoFeedsRecommendPresenter != null) {
          i = paramVideoFeedsRecommendPresenter.height;
        }
      }
      paramTiktokVideoItemHolder.aD = i;
      paramTiktokVideoItemHolder = this.e.aM;
      if (paramTiktokVideoItemHolder != null) {
        paramTiktokVideoItemHolder.setBackgroundDrawable(null);
      }
    }
    this.e.H().a((VideoFeedsStressFollowLayout.OnFollowActionListener)this);
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.al) {
      paramVideoInfo.aP = StressState.Shrink;
    }
    this.e.H().setVideoInfo(paramVideoInfo);
    VideoFeedsStressFollowHelper localVideoFeedsStressFollowHelper = this.e.m;
    paramVideoInfo = paramVideoInfo.aP;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.stressState");
    localVideoFeedsStressFollowHelper.a(paramVideoInfo);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130844213;
    }
    return 2130844216;
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      this.c.b(paramVideoInfo);
      VideoPlayParam localVideoPlayParam = this.e.az;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localVideoPlayParam != null)
      {
        localVideoPlayParam = this.e.az;
        localObject1 = localObject2;
        if (localVideoPlayParam != null) {
          localObject1 = localVideoPlayParam.h;
        }
      }
      paramVideoInfo = new VideoR5.Builder(paramVideoInfo);
      long l2 = -1L;
      if (localObject1 != null) {
        l1 = ((IVideoPlayerWrapper)localObject1).C();
      } else {
        l1 = -1L;
      }
      paramVideoInfo = paramVideoInfo.a(l1);
      long l1 = l2;
      if (localObject1 != null) {
        l1 = ((IVideoPlayerWrapper)localObject1).I();
      }
      PublicAccountReportUtils.a(null, "", "0X80078FD", "0X80078FD", 0, 0, "3", "", "", paramVideoInfo.c(l1).ag(1).M(0).b().a(), false);
    }
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    if (RIJQQAppInterfaceUtil.b() != null)
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
      if (localQQAppInterface != null)
      {
        long l = localQQAppInterface.getLongAccountUin();
        this.e.F().setHeadImgByUin(l);
      }
    }
    if (paramVideoInfo.a(this.b.v()))
    {
      this.e.I().setVisibility(0);
      return;
    }
    this.e.d().setVisibility(8);
    this.e.I().setVisibility(8);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    VideoFeedsHelper.b(this.e.aQ, paramVideoInfo.p, "评论");
    paramVideoInfo = this.e.aP;
    if (paramVideoInfo != null) {
      paramVideoInfo.setImageResource(2130844212);
    }
  }
  
  public void b()
  {
    super.b();
    VideoFeedsHelper.b((View)this.e.bf, 0);
    VideoFeedsHelper.b((View)this.e.aN, 0);
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.b(paramVideoInfo);
    e(paramVideoInfo);
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    e(paramVideoInfo);
    if (paramVideoInfo.aP == StressState.Stretched)
    {
      if (this.e.aL == null) {
        return;
      }
      paramVideoInfo = this.e.aL;
      if (paramVideoInfo != null)
      {
        paramVideoInfo = paramVideoInfo.getView();
        if (paramVideoInfo != null) {
          paramVideoInfo.setVisibility(8);
        }
      }
    }
    else
    {
      super.b(paramVideoInfo, paramBoolean);
    }
  }
  
  public void c()
  {
    super.c();
    VideoFeedsHelper.b((View)this.e.bf, 8);
    VideoFeedsHelper.b((View)this.e.aN, 8);
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    super.c(paramVideoInfo);
    View localView = this.e.aX;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      VideoFeedsHelper.b(this.e.K(), paramVideoInfo.aw, "分享");
    }
  }
  
  protected int d(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.af) {
      return 2130844215;
    }
    return 2130844217;
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.e.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if ((localObject != null) && (((VideoInfo)localObject).al == true))
        {
          localObject = this.e.k;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
      }
      this.e.G().setVisibility(0);
      return;
    }
    Object localObject = this.e.k;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.e.G().setVisibility(8);
  }
  
  public void g(boolean paramBoolean)
  {
    super.g(paramBoolean);
    Object localObject = this.e.J().getLayoutParams();
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      int i;
      if (paramBoolean) {
        i = DisplayUtil.a((Context)this.b.v(), 86.0F);
      } else {
        i = DisplayUtil.a((Context)this.b.v(), 5.0F);
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, ((ViewGroup.MarginLayoutParams)localObject).topMargin, i, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      this.e.J().setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */