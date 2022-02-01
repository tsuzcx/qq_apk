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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
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
  private final TiktokVideoItemHolder a;
  
  public TiktokVideoItemDelegate(@NotNull TiktokVideoItemHolder paramTiktokVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super((ShortVideoItemHolder)paramTiktokVideoItemHolder, paramVideoFeedsRecommendPresenter, paramVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder = paramTiktokVideoItemHolder;
    paramTiktokVideoItemHolder = VideoFeedsHelper.b(paramVideoFeedsRecommendPresenter.a());
    float f = paramTiktokVideoItemHolder[1];
    int j = 0;
    if (f / paramTiktokVideoItemHolder[0] >= 1.97D)
    {
      paramTiktokVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder;
      paramVideoFeedsRecommendPresenter = paramTiktokVideoItemHolder.p;
      int i = j;
      if (paramVideoFeedsRecommendPresenter != null)
      {
        paramVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter.getLayoutParams();
        i = j;
        if (paramVideoFeedsRecommendPresenter != null) {
          i = paramVideoFeedsRecommendPresenter.height;
        }
      }
      paramTiktokVideoItemHolder.jdField_d_of_type_Int = i;
      paramTiktokVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.p;
      if (paramTiktokVideoItemHolder != null) {
        paramTiktokVideoItemHolder.setBackgroundDrawable(null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.a().a((VideoFeedsStressFollowLayout.OnFollowActionListener)this);
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.p) {
      paramVideoInfo.a = StressState.Shrink;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.a().setVideoInfo(paramVideoInfo);
    VideoFeedsStressFollowHelper localVideoFeedsStressFollowHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowHelper;
    paramVideoInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.stressState");
    localVideoFeedsStressFollowHelper.a(paramVideoInfo);
  }
  
  protected int a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.n) {
      return 2130843261;
    }
    return 2130843263;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843259;
    }
    return 2130843262;
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b(paramVideoInfo);
      VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localVideoPlayParam != null)
      {
        localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        localObject1 = localObject2;
        if (localVideoPlayParam != null) {
          localObject1 = localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
        }
      }
      paramVideoInfo = new VideoR5.Builder(paramVideoInfo);
      long l2 = -1L;
      if (localObject1 != null) {
        l1 = ((IVideoPlayerWrapper)localObject1).a();
      } else {
        l1 = -1L;
      }
      paramVideoInfo = paramVideoInfo.a(l1);
      long l1 = l2;
      if (localObject1 != null) {
        l1 = ((IVideoPlayerWrapper)localObject1).b();
      }
      paramVideoInfo = paramVideoInfo.c(l1).af(1).M(0).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80078FD", "0X80078FD", 0, 0, "3", "", "", paramVideoInfo.a(), false);
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
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.a().setHeadImgByUin(l);
      }
    }
    if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.c().setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.a().setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.c().setVisibility(8);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.w, paramVideoInfo.e, "评论");
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.k;
    if (paramVideoInfo != null) {
      paramVideoInfo.setImageResource(2130843258);
    }
  }
  
  public void b()
  {
    super.b();
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.s, 0);
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.l, 0);
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.b(paramVideoInfo);
    d(paramVideoInfo);
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    d(paramVideoInfo);
    if (paramVideoInfo.a == StressState.Stretched)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton == null) {
        return;
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
      if (paramVideoInfo != null)
      {
        paramVideoInfo = paramVideoInfo.a();
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
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.s, 8);
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.l, 8);
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    super.c(paramVideoInfo);
    View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.q;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.k(), paramVideoInfo.v, "分享");
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if ((localObject != null) && (((VideoInfo)localObject).p == true))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.f().setVisibility(0);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.f().setVisibility(8);
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.d().getLayoutParams();
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      int i;
      if (paramBoolean) {
        i = DisplayUtil.a((Context)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), 86.0F);
      } else {
        i = DisplayUtil.a((Context)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), 5.0F);
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, ((ViewGroup.MarginLayoutParams)localObject).topMargin, i, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsTiktokVideoItemHolder.d().setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */