package com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAioGuideView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGradientMaskView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsReporter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsResourceLoader;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter.DefaultImpls;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.CommonVideoItemDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LocationInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.SubscriptInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemDelegate;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/delegate/CommonVideoItemDelegate;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/View$OnTouchListener;", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemHolder;", "presenter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemHolder;Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter;Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;)V", "showBiuBtn", "", "getReporter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsReporter;", "getRewardCoinIconRes", "", "info", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "hideAutoSeekBarTimer", "", "innerAdjustLogoUI", "logoImageView", "Landroid/widget/ImageView;", "videoInfo", "isFullScreen", "innerAdjustSeekbarLayout", "isAlignBottom", "innerConfigLocationLayout", "innerConfigPlayCountTextView", "textView", "Landroid/widget/TextView;", "innerSetLogoImageView", "onAutoSeekBarTouch", "onCommentComponentVisiblityChanged", "visibility", "onMenuDataChanged", "onProgressChanged", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "onScreenOrientationChanged", "onStartTrackingTouch", "onStopTrackingTouch", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onVideoClick", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "refreshAvatorAndNickName", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "resetVideoAreaLayoutParams", "isCommentShowing", "setAccountVIcon", "setControllerVisibility", "showAutoSeekBarTimer", "updateFollowStateAndUI", "needAnim", "updateSubscript", "yourFollowTextHasShowed", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public class ShortVideoItemDelegate
  extends CommonVideoItemDelegate
  implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener
{
  public static final ShortVideoItemDelegate.Companion a;
  private final ShortVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
  private final boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemDelegate$Companion = new ShortVideoItemDelegate.Companion(null);
  }
  
  public ShortVideoItemDelegate(@NotNull ShortVideoItemHolder paramShortVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super((VideoItemHolder)paramShortVideoItemHolder, (IVideoFeedsRecommendPresenter)paramVideoFeedsRecommendPresenter, (IVideoFeedsAdapter)paramVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder = paramShortVideoItemHolder;
    this.jdField_a_of_type_Boolean = RIJSocialBottomViewAladdinConfig.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.l != null) && (VideoFeedsHelper.a(paramVideoFeedsRecommendPresenter.a())))
    {
      paramShortVideoItemHolder = Aladdin.getConfig(324);
      int j = 0;
      if (paramShortVideoItemHolder.getIntegerFromString("videodetail_videogravity_style", 0) == 1)
      {
        paramShortVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
        paramVideoFeedsRecommendPresenter = paramShortVideoItemHolder.l;
        int i = j;
        if (paramVideoFeedsRecommendPresenter != null)
        {
          paramVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter.getLayoutParams();
          i = j;
          if (paramVideoFeedsRecommendPresenter != null) {
            i = paramVideoFeedsRecommendPresenter.height;
          }
        }
        paramShortVideoItemHolder.jdField_d_of_type_Int = i;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b.setOnTouchListener((View.OnTouchListener)this);
  }
  
  private final VideoFeedsReporter a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
    if (localObject != null) {
      return (VideoFeedsReporter)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsReporter");
  }
  
  private final void a(ImageView paramImageView, VideoInfo paramVideoInfo)
  {
    if (paramImageView != null)
    {
      if (paramVideoInfo == null) {
        return;
      }
      if ((VideoFeedsHelper.e()) && (!TextUtils.isEmpty((CharSequence)paramVideoInfo.u)))
      {
        Object localObject1 = paramVideoInfo.u;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoLogoUrl");
        Object localObject2 = null;
        if (StringsKt.endsWith$default((String)localObject1, "zip", false, 2, null))
        {
          ReadInJoyLottieDrawable localReadInJoyLottieDrawable = ReadInJoyLottieDrawable.a(paramVideoInfo.u);
          Intrinsics.checkExpressionValueIsNotNull(localReadInJoyLottieDrawable, "mLottieDrawable");
          localReadInJoyLottieDrawable.setRepeatCount(0);
          paramImageView.setImageDrawable((Drawable)localReadInJoyLottieDrawable);
          if ((paramImageView.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a().d()))
          {
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b();
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject3 = ((BaseVideoItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((VideoPlayParam)localObject3).a;
              }
            }
            if (localObject1 == paramVideoInfo) {
              localReadInJoyLottieDrawable.playAnimation();
            }
          }
        }
        else
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          paramImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(paramVideoInfo.u, (URLDrawable.URLDrawableOptions)localObject1));
        }
        paramImageView.setVisibility(0);
        return;
      }
      paramImageView.setVisibility(8);
    }
  }
  
  private final void a(ImageView paramImageView, VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramImageView != null) && (paramImageView.getVisibility() == 0))
    {
      Object localObject1 = paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), paramBoolean, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_Int);
      if (localObject1[0] >= 0)
      {
        if (localObject1[1] < 0) {
          return;
        }
        Object localObject2 = paramImageView.getLayoutParams();
        if (localObject2 != null)
        {
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localObject2;
          localLayoutParams.topMargin = localObject1[0];
          localLayoutParams.rightMargin = localObject1[1];
          localObject2 = null;
          localObject1 = null;
          if ((!paramBoolean) && (!paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())))
          {
            paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
            if (paramVideoInfo != null) {
              paramVideoInfo = paramVideoInfo.getResources();
            } else {
              paramVideoInfo = null;
            }
            localLayoutParams.width = AIOUtils.b(78.0F, paramVideoInfo);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
            paramVideoInfo = (VideoInfo)localObject1;
            if (localObject2 != null) {
              paramVideoInfo = ((Activity)localObject2).getResources();
            }
            localLayoutParams.height = AIOUtils.b(24.0F, paramVideoInfo);
          }
          else
          {
            paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
            if (paramVideoInfo != null) {
              paramVideoInfo = paramVideoInfo.getResources();
            } else {
              paramVideoInfo = null;
            }
            localLayoutParams.width = AIOUtils.b(91.0F, paramVideoInfo);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
            paramVideoInfo = (VideoInfo)localObject2;
            if (localObject1 != null) {
              paramVideoInfo = ((Activity)localObject1).getResources();
            }
            localLayoutParams.height = AIOUtils.b(28.0F, paramVideoInfo);
          }
          paramImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.jdField_q_of_type_Int > 0))
    {
      paramTextView.setText((CharSequence)VideoFeedsHelper.a(paramVideoInfo.jdField_q_of_type_Int));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private final void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e;
    if (localTextView != null)
    {
      int i = 1;
      if (((paramBoolean1) || (paramVideoInfo.p)) && ((!paramBoolean1) || (paramBoolean2))) {
        i = 0;
      }
      if ((i != 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo != null))
      {
        localTextView.setVisibility(0);
        localTextView.setText((CharSequence)paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo.jdField_a_of_type_JavaLangString);
        localTextView.setTextColor(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo.jdField_a_of_type_Int);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo.b);
        localGradientDrawable.setCornerRadius(ViewUtils.a(4.0F));
        localTextView.setBackgroundDrawable((Drawable)localGradientDrawable);
        return;
      }
      localTextView.setVisibility(8);
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setPadding(0, 0, 0, 0);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_Int > 0) && (paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_Int) == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setPadding(0, 0, 0, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setPadding(0, 0, 0, 0);
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)null;
    Object localObject = localReadInJoyUserInfo;
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j)) {
      try
      {
        paramVideoInfo = paramVideoInfo.j;
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.accountUin");
        localObject = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo), null);
      }
      catch (Exception paramVideoInfo)
      {
        localObject = localReadInJoyUserInfo;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setAccountVIcon: e=");
          ((StringBuilder)localObject).append(paramVideoInfo);
          QLog.e("ShortVideoItemDelegate", 2, ((StringBuilder)localObject).toString());
          localObject = localReadInJoyUserInfo;
        }
      }
    }
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)((ReadInJoyUserInfo)localObject).smallIconUrl)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setVisibility(0);
      paramVideoInfo = URLDrawable.URLDrawableOptions.obtain();
      paramVideoInfo.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().getHeight();
      paramVideoInfo.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().getWidth();
      paramVideoInfo = URLDrawable.getDrawable(((ReadInJoyUserInfo)localObject).smallIconUrl, paramVideoInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setImageDrawable((Drawable)paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setVisibility(8);
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView;
    if (localObject != null) {
      ((IReadInJoyHeadImageView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView;
    if (localObject != null)
    {
      localObject = ((AbsReadInJoyNickNameTextView)localObject).getPaint();
      if (localObject != null) {
        ((TextPaint)localObject).setFakeBoldText(true);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView;
    if (localObject != null) {
      ((AbsReadInJoyNickNameTextView)localObject).setNickNameByUin(paramVideoInfo.j);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView;
    if (localObject != null) {
      ((IReadInJoyHeadImageView)localObject).setHeadImgByUin(paramVideoInfo.j);
    }
    VideoFeedsAccessibilityHelper.a.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView, paramVideoInfo.k);
    VideoFeedsAccessibilityHelper localVideoFeedsAccessibilityHelper = VideoFeedsAccessibilityHelper.a;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView;
    if (localObject != null) {
      localObject = ((IReadInJoyHeadImageView)localObject).a();
    } else {
      localObject = null;
    }
    localVideoFeedsAccessibilityHelper.c((View)localObject, paramVideoInfo.k);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.d()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setForeground((Drawable)null);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setVisibility(0);
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j))
    {
      if ((paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.jdField_a_of_type_Int == 1))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
          a().a(paramVideoInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private final void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d();
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.h();
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString);
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_Boolean)
      {
        paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e();
        if (paramVideoInfo != null) {
          paramVideoInfo.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(2130841857));
        }
        paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setBackgroundResource(2130841855);
        }
      }
      else
      {
        paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e();
        if (paramVideoInfo != null) {
          paramVideoInfo.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(2130841856));
        }
        paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setBackgroundResource(0);
        }
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d();
      if (paramVideoInfo != null) {
        paramVideoInfo.setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder);
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d();
      if (paramVideoInfo != null) {
        paramVideoInfo.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      }
    }
    else
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d();
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
  
  private final void g()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e();
    if ((localViewGroup != null) && (localViewGroup.getVisibility() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemDelegate", 2, "onAutoSeekBarTouch: ");
    }
    c();
  }
  
  private final void l(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (paramBoolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.g.getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
        if (localObject3 != null) {
          localObject1 = ((Activity)localObject3).getResources();
        }
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = AIOUtils.b(0.0F, (Resources)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.g.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.g.getLayoutParams();
    if (localObject1 != null)
    {
      localObject3 = (ViewGroup.MarginLayoutParams)localObject1;
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
      localObject1 = localObject2;
      if (localActivity != null) {
        localObject1 = localActivity.getResources();
      }
      ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = (AIOUtils.b(15.0F, (Resources)localObject1) - 20);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.g.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
  
  protected int a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.n) {
      return 2130843247;
    }
    return 2130843249;
  }
  
  public void a()
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      bool = true;
    } else {
      bool = false;
    }
    b(bool);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(paramInt1, paramInt2);
    if (paramBoolean) {
      f();
    }
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b() == this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.c())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    c(paramVideoInfo, paramBoolean);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.v;
    if (localObject1 != null)
    {
      localObject1 = ((TextView)localObject1).getPaint();
      if (localObject1 != null) {
        ((TextPaint)localObject1).setFakeBoldText(false);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup;
    Drawable localDrawable = null;
    ((ViewGroup)localObject1).setBackgroundDrawable(null);
    if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setVisibility(8);
    }
    l(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.c()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(false);
      d(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_Int == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a() == null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a(new VideoFeedsAioGuideView(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), RIJQQAppInterfaceUtil.b(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a()));
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
      if (localObject1 != null) {
        ((VideoFeedsAioGuideView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a() != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
      if (localObject1 != null) {
        ((VideoFeedsAioGuideView)localObject1).c();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a((VideoFeedsAioGuideView)null);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 != null)
      {
        localObject1 = ((Intent)localObject1).getStringExtra("video_feeds_back_color");
        break label340;
      }
    }
    localObject1 = null;
    label340:
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      URLImageView localURLImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
      localObject1 = localDrawable;
      if (localObject2 != null)
      {
        localObject2 = ((Activity)localObject2).getIntent();
        localObject1 = localDrawable;
        if (localObject2 != null) {
          localObject1 = ((Intent)localObject2).getStringExtra("video_feeds_back_color");
        }
      }
      localURLImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor((String)localObject1)));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
      if (localObject1 != null)
      {
        localObject1 = ((Activity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("video_feeds_back_color");
        }
      }
    }
    else if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setImageDrawable(null);
    }
    else if (paramVideoInfo.a() != null)
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localDrawable = (Drawable)new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
      localObject1 = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.v);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "urlDrawable");
      ((URLDrawable)localObject1).setAlpha(35);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setImageDrawable((Drawable)localObject1);
    }
    a(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(paramVideoInfo, (VideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a().setVisibility(0);
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e();
    if (paramVideoInfo != null) {
      paramVideoInfo.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b.setThumb(VideoFeedsResourceLoader.a((Context)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), 2131167333));
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b.setThumb(VideoFeedsResourceLoader.a((Context)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), 2131167333));
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e(), 8);
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a(), 0);
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    e(true);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.j;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      e(paramVideoInfo);
      d(paramVideoInfo);
      b(paramVideoInfo, false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.j;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.j;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).a();
        if (localObject != null) {
          ((View)localObject).setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).a();
        if (localObject != null) {
          ((View)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
        }
      }
    }
    f(true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.l;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      a((VideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder, paramVideoInfo);
      if (RIJRewardTaskConfig.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.c().setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.c().setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.c().setVisibility(0);
      }
    }
    if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.h.setVisibility(8);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.h.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b() == this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()))
    {
      e(false);
      f(false);
    }
    if (paramVideoInfo.h())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.m;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(a(paramVideoInfo.jdField_q_of_type_Boolean)));
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_n_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_n_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.q;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_n_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    VideoFeedsAccessibilityHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder, (View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b());
    f(paramVideoInfo);
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton == null) {
      return;
    }
    boolean bool2 = paramVideoInfo.p;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
    boolean bool1;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((!TextUtils.isEmpty((CharSequence)paramVideoInfo.j)) && (!Intrinsics.areEqual("16888", paramVideoInfo.j)) && (!paramVideoInfo.r) && (!VideoFeedsHelper.a(paramVideoInfo, (BaseQQAppInterface)RIJQQAppInterfaceUtil.b())))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
      if (localObject != null) {
        ((IVideoFeedsFollowButton)localObject).a(paramVideoInfo, paramVideoInfo.p);
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()) && (bool2))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).a();
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
            if (localObject != null)
            {
              long l = ((IVideoFeedsFollowButton)localObject).a();
              IVideoFeedsAdapter.DefaultImpls.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter, 7, l, false, 4, null);
            }
            VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 0);
            break label405;
          }
        }
      }
      if (bool2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).a();
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 0, 0);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).a();
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 8, 0);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).a();
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 8, 0);
    }
    label405:
    a(paramVideoInfo, paramBoolean, bool1);
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.p;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.p, 8, 200);
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.p;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).translationY(20.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).a();
        }
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.p;
        if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 8))
        {
          VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.p, 0, 200);
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.p;
          if (localObject != null)
          {
            localObject = ((ViewGroup)localObject).animate();
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
                if (localObject != null) {
                  ((ViewPropertyAnimator)localObject).start();
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.g.animate().translationY(0.0F).setDuration(200L).start();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).b();
        }
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.b.setThumb(VideoFeedsResourceLoader.a((Context)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), 2130841840));
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a(), 8);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.i() == null)
    {
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
      Object localObject1 = ((ShortVideoItemHolder)localObject4).b();
      Object localObject3 = null;
      if (localObject1 != null) {
        localObject1 = ((ViewStub)localObject1).inflate();
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      ((ShortVideoItemHolder)localObject4).c((ViewGroup)localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
      localObject1 = ((ShortVideoItemHolder)localObject2).p;
      if (localObject1 != null) {
        localObject1 = (TextView)((ViewGroup)localObject1).findViewById(2131380621);
      } else {
        localObject1 = null;
      }
      ((ShortVideoItemHolder)localObject2).f((TextView)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
      localObject4 = ((ShortVideoItemHolder)localObject2).p;
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = (TextView)((ViewGroup)localObject4).findViewById(2131380622);
      }
      ((ShortVideoItemHolder)localObject2).g((TextView)localObject1);
    }
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.e(), 0);
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.i(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a().a());
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.j(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a().d());
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    super.c(paramVideoInfo);
    e(paramVideoInfo);
    d(paramVideoInfo);
    VideoFeedsHelper.a(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.v);
    VideoFeedsHelper.a(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.u);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a((VideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder, paramVideoInfo);
    b(paramVideoInfo, true);
    a(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b(paramVideoInfo, (VideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder);
    if (RIJRewardTaskConfig.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.d().setImageResource(a(paramVideoInfo));
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.g();
      int i = paramVideoInfo.o;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
      if (localObject != null) {
        localObject = ((Activity)localObject).getString(2131718308);
      } else {
        localObject = null;
      }
      VideoFeedsHelper.b(localTextView, i, (String)localObject);
    }
    f(paramVideoInfo);
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).a;
      if (localObject != null)
      {
        boolean bool;
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b() == this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.c())) {
          bool = true;
        } else {
          bool = false;
        }
        c((VideoInfo)localObject, bool);
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b());
      l(true);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).b();
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.c()) {
        l(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        if (localObject != null)
        {
          localObject = ((VideoPlayParam)localObject).a;
          if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.a();
            if (localObject != null) {
              ((VideoFeedsAioGuideView)localObject).a();
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).a;
        if (localObject != null) {
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, (VideoInfo)localObject, paramBoolean);
        }
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.clearAnimation();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).a;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()) == true)) {}
      }
      else
      {
        l(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.h.setVisibility(8);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).a;
      if ((localObject != null) && (((VideoInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()) == true))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.h.setVisibility(8);
        return;
      }
    }
    l(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.h.setVisibility(0);
  }
  
  public void onProgressChanged(@Nullable SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a().d();
    if (l > 0L)
    {
      double d1 = paramInt;
      Double.isNaN(d1);
      d1 /= 100.0D;
      double d2 = l;
      Double.isNaN(d2);
      paramInt = (int)(d1 * d2);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.i(), paramInt);
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.j(), l);
    if (paramBoolean) {
      a().b();
    }
  }
  
  public void onStartTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    IVideoFeedsVideoUIDelegate localIVideoFeedsVideoUIDelegate = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.onStartTrackingTouch(paramSeekBar);
    }
    a().c();
  }
  
  public void onStopTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    IVideoFeedsVideoUIDelegate localIVideoFeedsVideoUIDelegate = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.onStopTrackingTouch(paramSeekBar);
    }
    IVideoFeedsAdapter.DefaultImpls.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter, 8, 2000, false, 4, null);
    a().d();
  }
  
  public boolean onTouch(@Nullable View paramView, @Nullable MotionEvent paramMotionEvent)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131368861)) {
      g();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */