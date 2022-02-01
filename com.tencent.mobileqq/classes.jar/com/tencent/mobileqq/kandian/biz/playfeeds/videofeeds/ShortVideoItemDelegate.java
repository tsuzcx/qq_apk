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
  public static final ShortVideoItemDelegate.Companion a = new ShortVideoItemDelegate.Companion(null);
  private final boolean e;
  private final ShortVideoItemHolder f;
  
  public ShortVideoItemDelegate(@NotNull ShortVideoItemHolder paramShortVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super((VideoItemHolder)paramShortVideoItemHolder, (IVideoFeedsRecommendPresenter)paramVideoFeedsRecommendPresenter, (IVideoFeedsAdapter)paramVideoFeedsAdapter);
    this.f = paramShortVideoItemHolder;
    this.e = RIJSocialBottomViewAladdinConfig.b();
    if ((this.f.aN != null) && (VideoFeedsHelper.a(paramVideoFeedsRecommendPresenter.v())))
    {
      paramShortVideoItemHolder = Aladdin.getConfig(324);
      int j = 0;
      if (paramShortVideoItemHolder.getIntegerFromString("videodetail_videogravity_style", 0) == 1)
      {
        paramShortVideoItemHolder = this.f;
        paramVideoFeedsRecommendPresenter = paramShortVideoItemHolder.aN;
        int i = j;
        if (paramVideoFeedsRecommendPresenter != null)
        {
          paramVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter.getLayoutParams();
          i = j;
          if (paramVideoFeedsRecommendPresenter != null) {
            i = paramVideoFeedsRecommendPresenter.height;
          }
        }
        paramShortVideoItemHolder.aD = i;
      }
    }
    this.f.aj.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);
    this.f.aj.setOnTouchListener((View.OnTouchListener)this);
  }
  
  private final void a(ImageView paramImageView, VideoInfo paramVideoInfo)
  {
    if (paramImageView != null)
    {
      if (paramVideoInfo == null) {
        return;
      }
      if ((VideoFeedsHelper.h()) && (!TextUtils.isEmpty((CharSequence)paramVideoInfo.X)))
      {
        Object localObject1 = paramVideoInfo.X;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoLogoUrl");
        Object localObject2 = null;
        if (StringsKt.endsWith$default((String)localObject1, "zip", false, 2, null))
        {
          ReadInJoyLottieDrawable localReadInJoyLottieDrawable = ReadInJoyLottieDrawable.a(paramVideoInfo.X);
          Intrinsics.checkExpressionValueIsNotNull(localReadInJoyLottieDrawable, "mLottieDrawable");
          localReadInJoyLottieDrawable.setRepeatCount(0);
          paramImageView.setImageDrawable((Drawable)localReadInJoyLottieDrawable);
          if ((paramImageView.getVisibility() == 8) && (this.b.x().k()))
          {
            Object localObject3 = this.b.u();
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject3 = ((BaseVideoItemHolder)localObject3).az;
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((VideoPlayParam)localObject3).c;
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
          paramImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(paramVideoInfo.X, (URLDrawable.URLDrawableOptions)localObject1));
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
      Object localObject1 = paramVideoInfo.a(this.b.v(), paramBoolean, this.f.aD);
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
          if ((!paramBoolean) && (!paramVideoInfo.a(this.b.v())))
          {
            paramVideoInfo = this.b.v();
            if (paramVideoInfo != null) {
              paramVideoInfo = paramVideoInfo.getResources();
            } else {
              paramVideoInfo = null;
            }
            localLayoutParams.width = AIOUtils.b(78.0F, paramVideoInfo);
            localObject2 = this.b.v();
            paramVideoInfo = (VideoInfo)localObject1;
            if (localObject2 != null) {
              paramVideoInfo = ((Activity)localObject2).getResources();
            }
            localLayoutParams.height = AIOUtils.b(24.0F, paramVideoInfo);
          }
          else
          {
            paramVideoInfo = this.b.v();
            if (paramVideoInfo != null) {
              paramVideoInfo = paramVideoInfo.getResources();
            } else {
              paramVideoInfo = null;
            }
            localLayoutParams.width = AIOUtils.b(91.0F, paramVideoInfo);
            localObject1 = this.b.v();
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
    if ((paramVideoInfo.a != 0) && (paramVideoInfo.a != 5) && (paramVideoInfo.aj > 0))
    {
      paramTextView.setText((CharSequence)VideoFeedsHelper.a(paramVideoInfo.aj));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private final void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView = this.f.l;
    if (localTextView != null)
    {
      int i = 1;
      if (((paramBoolean1) || (paramVideoInfo.al)) && ((!paramBoolean1) || (paramBoolean2))) {
        i = 0;
      }
      if ((i != 0) && (paramVideoInfo.aM != null))
      {
        localTextView.setVisibility(0);
        localTextView.setText((CharSequence)paramVideoInfo.aM.a);
        localTextView.setTextColor(paramVideoInfo.aM.b);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(paramVideoInfo.aM.c);
        localGradientDrawable.setCornerRadius(ViewUtils.dip2px(4.0F));
        localTextView.setBackgroundDrawable((Drawable)localGradientDrawable);
        return;
      }
      localTextView.setVisibility(8);
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramVideoInfo.a(this.b.v())))
    {
      this.f.aa.setPadding(0, 0, 0, VideoFeedsHelper.f(this.b.v()));
      this.f.a().setPadding(0, 0, 0, 0);
      return;
    }
    if ((this.f.aD > 0) && (paramVideoInfo.a(this.b.v(), this.f.aD) == 2))
    {
      this.f.aa.setPadding(0, 0, 0, 0);
      this.f.a().setPadding(0, 0, 0, this.f.aD);
      return;
    }
    this.f.aa.setPadding(0, 0, 0, 0);
    this.f.a().setPadding(0, 0, 0, 0);
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)null;
    Object localObject = localReadInJoyUserInfo;
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.q)) {
      try
      {
        paramVideoInfo = paramVideoInfo.q;
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
      this.f.c().setVisibility(0);
      paramVideoInfo = URLDrawable.URLDrawableOptions.obtain();
      paramVideoInfo.mRequestHeight = this.f.c().getHeight();
      paramVideoInfo.mRequestWidth = this.f.c().getWidth();
      paramVideoInfo = URLDrawable.getDrawable(((ReadInJoyUserInfo)localObject).smallIconUrl, paramVideoInfo);
      this.f.c().setImageDrawable((Drawable)paramVideoInfo);
      return;
    }
    this.f.c().setVisibility(8);
  }
  
  private final void f(VideoInfo paramVideoInfo)
  {
    Object localObject = this.f.aK;
    if (localObject != null) {
      ((IReadInJoyHeadImageView)localObject).a(this.c.n());
    }
    localObject = this.f.aJ;
    if (localObject != null)
    {
      localObject = ((AbsReadInJoyNickNameTextView)localObject).getPaint();
      if (localObject != null) {
        ((TextPaint)localObject).setFakeBoldText(true);
      }
    }
    localObject = this.f.aJ;
    if (localObject != null) {
      ((AbsReadInJoyNickNameTextView)localObject).setNickNameByUin(paramVideoInfo.q);
    }
    localObject = this.f.aK;
    if (localObject != null) {
      ((IReadInJoyHeadImageView)localObject).setHeadImgByUin(paramVideoInfo.q);
    }
    VideoFeedsAccessibilityHelper.a.b((View)this.f.aJ, paramVideoInfo.r);
    VideoFeedsAccessibilityHelper localVideoFeedsAccessibilityHelper = VideoFeedsAccessibilityHelper.a;
    localObject = this.f.aK;
    if (localObject != null) {
      localObject = ((IReadInJoyHeadImageView)localObject).getView();
    } else {
      localObject = null;
    }
    localVideoFeedsAccessibilityHelper.c((View)localObject, paramVideoInfo.r);
    if (this.c.t()) {
      this.f.h().setForeground((Drawable)null);
    }
    this.f.h().setVisibility(0);
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.q))
    {
      if ((paramVideoInfo.aO != null) && (paramVideoInfo.aO.a == 1))
      {
        if ((this.f == this.b.u()) && (this.f.a.getVisibility() == 8)) {
          g().a(paramVideoInfo);
        }
        this.f.a.setVisibility(0);
        return;
      }
      this.f.a.setVisibility(8);
      return;
    }
    this.f.a.setVisibility(8);
  }
  
  private final VideoFeedsReporter g()
  {
    Object localObject = this.b.s();
    if (localObject != null) {
      return (VideoFeedsReporter)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsReporter");
  }
  
  private final void g(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.aN != null)
    {
      Object localObject = this.f.y();
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = this.f.z();
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramVideoInfo.aN.b);
      }
      if (paramVideoInfo.aN.a)
      {
        paramVideoInfo = this.f.A();
        if (paramVideoInfo != null) {
          paramVideoInfo.setImageDrawable(this.c.e(2130842774));
        }
        paramVideoInfo = this.f.y();
        if (paramVideoInfo != null) {
          paramVideoInfo.setBackgroundResource(2130842772);
        }
      }
      else
      {
        paramVideoInfo = this.f.A();
        if (paramVideoInfo != null) {
          paramVideoInfo.setImageDrawable(this.c.e(2130842773));
        }
        paramVideoInfo = this.f.y();
        if (paramVideoInfo != null) {
          paramVideoInfo.setBackgroundResource(0);
        }
      }
      paramVideoInfo = this.f.y();
      if (paramVideoInfo != null) {
        paramVideoInfo.setTag(this.f);
      }
      paramVideoInfo = this.f.y();
      if (paramVideoInfo != null) {
        paramVideoInfo.setOnClickListener((View.OnClickListener)this.c);
      }
    }
    else
    {
      paramVideoInfo = this.f.y();
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
  
  private final void h()
  {
    ViewGroup localViewGroup = this.f.C();
    if ((localViewGroup != null) && (localViewGroup.getVisibility() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemDelegate", 2, "onAutoSeekBarTouch: ");
    }
    c();
  }
  
  private final void m(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (paramBoolean)
    {
      localObject2 = this.f.ap.getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        localObject3 = this.b.v();
        if (localObject3 != null) {
          localObject1 = ((Activity)localObject3).getResources();
        }
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = AIOUtils.b(0.0F, (Resources)localObject1);
        this.f.ap.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject1 = this.f.ap.getLayoutParams();
    if (localObject1 != null)
    {
      localObject3 = (ViewGroup.MarginLayoutParams)localObject1;
      Activity localActivity = this.b.v();
      localObject1 = localObject2;
      if (localActivity != null) {
        localObject1 = localActivity.getResources();
      }
      ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = (AIOUtils.b(15.0F, (Resources)localObject1) - 20);
      this.f.ap.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
  
  public void a()
  {
    boolean bool;
    if (this.f.af.getVisibility() == 8) {
      bool = true;
    } else {
      bool = false;
    }
    c(bool);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.c.a(paramInt1, paramInt2);
    if (paramBoolean) {
      f();
    }
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    if ((this.b.u() == this.f) && (this.c.s())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    c(paramVideoInfo, paramBoolean);
    Object localObject1 = this.f.aG;
    if (localObject1 != null)
    {
      localObject1 = ((TextView)localObject1).getPaint();
      if (localObject1 != null) {
        ((TextPaint)localObject1).setFakeBoldText(false);
      }
    }
    localObject1 = this.f.af;
    Drawable localDrawable = null;
    ((ViewGroup)localObject1).setBackgroundDrawable(null);
    if (paramVideoInfo.a(this.b.v())) {
      this.f.d().setVisibility(0);
    } else {
      this.f.d().setVisibility(8);
    }
    m(false);
    if ((this.c.s()) && (this.c.r()))
    {
      this.c.a(false);
      e(true);
    }
    if ((this.f.Z == 0) && (paramVideoInfo.a == 0))
    {
      if (this.f.e() == null) {
        this.f.a(new VideoFeedsAioGuideView(this.b.v(), RIJQQAppInterfaceUtil.b(), this.c.q()));
      }
      localObject1 = this.f.e();
      if (localObject1 != null) {
        ((VideoFeedsAioGuideView)localObject1).a(this.f);
      }
    }
    else if (this.f.e() != null)
    {
      localObject1 = this.f.e();
      if (localObject1 != null) {
        ((VideoFeedsAioGuideView)localObject1).c();
      }
      this.f.a((VideoFeedsAioGuideView)null);
    }
    localObject1 = this.b.v();
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
      URLImageView localURLImageView = this.f.f();
      Object localObject2 = this.b.v();
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
      localObject1 = this.b.v();
      if (localObject1 != null)
      {
        localObject1 = ((Activity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("video_feeds_back_color");
        }
      }
    }
    else if (paramVideoInfo.a(this.b.v()))
    {
      this.f.f().setImageDrawable(null);
    }
    else if (paramVideoInfo.t() != null)
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localDrawable = (Drawable)new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
      localObject1 = URLDrawable.getDrawable(paramVideoInfo.t(), (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.w);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "urlDrawable");
      ((URLDrawable)localObject1).setAlpha(35);
      this.f.f().setImageDrawable((Drawable)localObject1);
    }
    a(paramVideoInfo, this.f.g());
    this.c.a(paramVideoInfo, (VideoItemHolder)this.f);
    this.f.b().setVisibility(0);
    paramVideoInfo = this.f.C();
    if (paramVideoInfo != null) {
      paramVideoInfo.setVisibility(8);
    }
    this.f.aj.setThumb(VideoFeedsResourceLoader.a((Context)this.b.v(), 2131168376));
  }
  
  public void b()
  {
    this.f.aj.setThumb(VideoFeedsResourceLoader.a((Context)this.b.v(), 2131168376));
    VideoFeedsHelper.b((View)this.f.C(), 8);
    VideoFeedsHelper.b(this.f.b(), 0);
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    f(true);
    Object localObject = this.f.aH;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      f(paramVideoInfo);
      e(paramVideoInfo);
      b(paramVideoInfo, false);
      localObject = this.f.aH;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(this.f);
      }
      localObject = this.f.aH;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.c);
      }
      localObject = this.f.aL;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).getView();
        if (localObject != null) {
          ((View)localObject).setTag(this.f);
        }
      }
      localObject = this.f.aL;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).getView();
        if (localObject != null) {
          ((View)localObject).setOnClickListener((View.OnClickListener)this.c);
        }
      }
    }
    g(true);
    localObject = this.f.aN;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      a((VideoItemHolder)this.f, paramVideoInfo);
      if (RIJRewardTaskConfig.a())
      {
        this.f.v().setTag(this.f);
        this.f.v().setOnClickListener((View.OnClickListener)this.c);
        this.f.v().setVisibility(0);
      }
    }
    if (paramVideoInfo.a(this.b.v())) {
      this.f.at.setVisibility(8);
    } else {
      this.f.at.setVisibility(0);
    }
    if ((this.b.u() == this.f) && (this.b.e()))
    {
      f(false);
      g(false);
    }
    if (paramVideoInfo.o())
    {
      localObject = this.f.aS;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(this.c.e(a(paramVideoInfo.am)));
      }
    }
    if (this.e)
    {
      localObject = this.f.aV;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = this.f.aW;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.f.aV;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      localObject = this.f.aW;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
    }
    localObject = this.f.aX;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.f.aY;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    VideoFeedsAccessibilityHelper.a.a(this.f, (View.OnClickListener)this.c);
    a(this.f.j, paramVideoInfo);
    a(this.f.j, paramVideoInfo, this.b.e());
    g(paramVideoInfo);
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (this.f.aL == null) {
      return;
    }
    boolean bool2 = paramVideoInfo.al;
    Object localObject = this.f.k;
    boolean bool1;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((!TextUtils.isEmpty((CharSequence)paramVideoInfo.q)) && (!Intrinsics.areEqual("16888", paramVideoInfo.q)) && (!paramVideoInfo.aq) && (!VideoFeedsHelper.a(paramVideoInfo, (BaseQQAppInterface)RIJQQAppInterfaceUtil.b())))
    {
      localObject = this.f.aL;
      if (localObject != null) {
        ((IVideoFeedsFollowButton)localObject).a(paramVideoInfo, paramVideoInfo.al);
      }
      if ((paramBoolean) && (this.f == this.b.u()) && (bool2))
      {
        localObject = this.f.aL;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).getView();
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = this.f.aL;
            if (localObject != null)
            {
              long l = ((IVideoFeedsFollowButton)localObject).getAnimDelayDuration();
              IVideoFeedsAdapter.DefaultImpls.a(this.c, 7, l, false, 4, null);
            }
            VideoFeedsHelper.b((View)this.f.k, 0);
            break label405;
          }
        }
      }
      if (bool2)
      {
        localObject = this.f.aL;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).getView();
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        VideoFeedsHelper.b((View)this.f.k, 0, 0);
      }
      else
      {
        localObject = this.f.aL;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).getView();
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
        VideoFeedsHelper.b((View)this.f.k, 8, 0);
      }
    }
    else
    {
      localObject = this.f.aL;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).getView();
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      VideoFeedsHelper.b((View)this.f.k, 8, 0);
    }
    label405:
    a(paramVideoInfo, paramBoolean, bool1);
  }
  
  public void c()
  {
    this.f.aj.setThumb(VideoFeedsResourceLoader.a((Context)this.b.v(), 2130842757));
    VideoFeedsHelper.b(this.f.b(), 8);
    if (this.f.D() == null)
    {
      Object localObject4 = this.f;
      Object localObject1 = ((ShortVideoItemHolder)localObject4).B();
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
      localObject2 = this.f;
      localObject1 = ((ShortVideoItemHolder)localObject2).aZ;
      if (localObject1 != null) {
        localObject1 = (TextView)((ViewGroup)localObject1).findViewById(2131449579);
      } else {
        localObject1 = null;
      }
      ((ShortVideoItemHolder)localObject2).f((TextView)localObject1);
      localObject2 = this.f;
      localObject4 = ((ShortVideoItemHolder)localObject2).aZ;
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = (TextView)((ViewGroup)localObject4).findViewById(2131449580);
      }
      ((ShortVideoItemHolder)localObject2).g((TextView)localObject1);
    }
    VideoFeedsHelper.b((View)this.f.C(), 0);
    VideoFeedsHelper.a(this.f.D(), this.b.x().b());
    VideoFeedsHelper.a(this.f.E(), this.b.x().t());
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    super.c(paramVideoInfo);
    f(paramVideoInfo);
    e(paramVideoInfo);
    VideoFeedsHelper.a(paramVideoInfo, this.f.aG);
    VideoFeedsHelper.a(paramVideoInfo, this.f.av);
    this.c.a((VideoItemHolder)this.f, paramVideoInfo);
    b(paramVideoInfo, true);
    a(paramVideoInfo, this.f.g());
    if (this.f.j.getVisibility() == 8)
    {
      a(this.f.j, paramVideoInfo);
      a(this.f.j, paramVideoInfo, this.b.e());
    }
    this.c.b(paramVideoInfo, (VideoItemHolder)this.f);
    if (RIJRewardTaskConfig.a())
    {
      this.f.w().setImageResource(d(paramVideoInfo));
      TextView localTextView = this.f.x();
      int i = paramVideoInfo.ae;
      Object localObject = this.b.v();
      if (localObject != null) {
        localObject = ((Activity)localObject).getString(2131915800);
      } else {
        localObject = null;
      }
      VideoFeedsHelper.b(localTextView, i, (String)localObject);
    }
    g(paramVideoInfo);
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.f.aZ;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        VideoFeedsHelper.a((View)this.f.aZ, 8, 200);
        localObject = this.f.aZ;
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
        this.f.ap.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.f.e() != null) && (!this.b.e()))
      {
        localObject = this.f.e();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).a();
        }
      }
    }
    else if (this.f.M())
    {
      if (!this.b.e())
      {
        localObject = this.f.aZ;
        if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 8))
        {
          VideoFeedsHelper.a((View)this.f.aZ, 0, 200);
          localObject = this.f.aZ;
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
          this.f.ap.animate().translationY(0.0F).setDuration(200L).start();
        }
      }
      if (this.f.e() != null)
      {
        localObject = this.f.e();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).b();
        }
      }
    }
  }
  
  protected int d(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.af) {
      return 2130844201;
    }
    return 2130844203;
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    Object localObject = this.f.az;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if (localObject != null)
      {
        boolean bool;
        if ((this.b.u() == this.f) && (this.c.s())) {
          bool = true;
        } else {
          bool = false;
        }
        c((VideoInfo)localObject, bool);
      }
    }
    if (paramBoolean)
    {
      this.f.af.setBackgroundDrawable(this.c.u());
      m(true);
      if (this.f.e() != null)
      {
        localObject = this.f.e();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).b();
        }
      }
    }
    else
    {
      this.f.af.setBackgroundDrawable(null);
      if (!this.c.s()) {
        m(false);
      }
      if ((this.f.e() != null) && (this.f.Z == 0) && (this.f.az != null))
      {
        localObject = this.f.az;
        if (localObject != null)
        {
          localObject = ((VideoPlayParam)localObject).c;
          if ((localObject != null) && (((VideoInfo)localObject).a == 0))
          {
            localObject = this.f.e();
            if (localObject != null) {
              ((VideoFeedsAioGuideView)localObject).a();
            }
          }
        }
      }
    }
    if (this.f.az != null)
    {
      localObject = this.f.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if (localObject != null) {
          a(this.f.j, (VideoInfo)localObject, paramBoolean);
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.f.ao.clearAnimation();
    Object localObject = this.f.az;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      localObject = this.f.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if ((localObject != null) && (((VideoInfo)localObject).a(this.b.v()) == true)) {}
      }
      else
      {
        m(true);
      }
      if (this.f.af.getVisibility() == 0) {
        this.f.af.setVisibility(8);
      }
      this.f.at.setVisibility(8);
      return;
    }
    localObject = this.f.az;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if ((localObject != null) && (((VideoInfo)localObject).a(this.b.v()) == true))
      {
        this.f.at.setVisibility(8);
        return;
      }
    }
    m(false);
    this.f.at.setVisibility(0);
  }
  
  public void onProgressChanged(@Nullable SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    long l = this.b.x().t();
    if (l > 0L)
    {
      double d1 = paramInt;
      Double.isNaN(d1);
      d1 /= 100.0D;
      double d2 = l;
      Double.isNaN(d2);
      paramInt = (int)(d1 * d2);
      VideoFeedsHelper.a(this.f.D(), paramInt);
    }
    VideoFeedsHelper.a(this.f.E(), l);
    if (paramBoolean) {
      g().b();
    }
  }
  
  public void onStartTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    IVideoFeedsVideoUIDelegate localIVideoFeedsVideoUIDelegate = this.f.aB;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.onStartTrackingTouch(paramSeekBar);
    }
    g().c();
  }
  
  public void onStopTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    IVideoFeedsVideoUIDelegate localIVideoFeedsVideoUIDelegate = this.f.aB;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.onStopTrackingTouch(paramSeekBar);
    }
    IVideoFeedsAdapter.DefaultImpls.a(this.c, 8, 2000, false, 4, null);
    g().d();
  }
  
  public boolean onTouch(@Nullable View paramView, @Nullable MotionEvent paramMotionEvent)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131435795)) {
      h();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */