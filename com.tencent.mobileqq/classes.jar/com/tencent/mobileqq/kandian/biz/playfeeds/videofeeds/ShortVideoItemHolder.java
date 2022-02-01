package com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.base.view.widget.CircleCountdownView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAioGuideView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGradientMaskView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "aboveAutoSeekBarContent", "getAboveAutoSeekBarContent", "()Landroid/view/View;", "setAboveAutoSeekBarContent", "adGuideContent", "adGuideGotoBtn", "Landroid/widget/TextView;", "adGuideIcon", "Landroid/widget/ImageView;", "adGuideMask", "adGuideName", "adGuideProgress", "Lcom/tencent/mobileqq/kandian/base/view/widget/CircleCountdownView;", "adGuideReplayBtn", "aioGuideView", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAioGuideView;", "getAioGuideView", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAioGuideView;", "setAioGuideView", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAioGuideView;)V", "autoSeekBarCurrentTime", "getAutoSeekBarCurrentTime", "()Landroid/widget/TextView;", "setAutoSeekBarCurrentTime", "(Landroid/widget/TextView;)V", "autoSeekBarTimer", "Landroid/view/ViewGroup;", "getAutoSeekBarTimer", "()Landroid/view/ViewGroup;", "setAutoSeekBarTimer", "(Landroid/view/ViewGroup;)V", "autoSeekBarTimerViewStub", "Landroid/view/ViewStub;", "getAutoSeekBarTimerViewStub", "()Landroid/view/ViewStub;", "setAutoSeekBarTimerViewStub", "(Landroid/view/ViewStub;)V", "autoSeekBarTotalTime", "getAutoSeekBarTotalTime", "setAutoSeekBarTotalTime", "backgroundImageview", "Lcom/tencent/image/URLImageView;", "getBackgroundImageview", "()Lcom/tencent/image/URLImageView;", "setBackgroundImageview", "(Lcom/tencent/image/URLImageView;)V", "columnBanner", "getColumnBanner", "setColumnBanner", "columnBannerArrow", "getColumnBannerArrow", "()Landroid/widget/ImageView;", "setColumnBannerArrow", "(Landroid/widget/ImageView;)V", "columnBannerBlackArrow", "getColumnBannerBlackArrow", "setColumnBannerBlackArrow", "columnBannerHighLightText", "getColumnBannerHighLightText", "setColumnBannerHighLightText", "columnBannerIcon", "getColumnBannerIcon", "setColumnBannerIcon", "columnBannerLightLine", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "getColumnBannerLightLine", "()Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "setColumnBannerLightLine", "(Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;)V", "columnBannerLogo", "getColumnBannerLogo", "setColumnBannerLogo", "columnBannerName", "getColumnBannerName", "setColumnBannerName", "columnBannerNormalText", "getColumnBannerNormalText", "setColumnBannerNormalText", "columnBannerPrefix", "getColumnBannerPrefix", "setColumnBannerPrefix", "columnBannerSubscribeBtn", "getColumnBannerSubscribeBtn", "setColumnBannerSubscribeBtn", "columnBannerViewStub", "getColumnBannerViewStub", "setColumnBannerViewStub", "columnExpandBannerBg", "getColumnExpandBannerBg", "setColumnExpandBannerBg", "columnSmallBanner", "getColumnSmallBanner", "setColumnSmallBanner", "headerAccountIconViewGroup", "Landroid/widget/FrameLayout;", "getHeaderAccountIconViewGroup", "()Landroid/widget/FrameLayout;", "setHeaderAccountIconViewGroup", "(Landroid/widget/FrameLayout;)V", "headerAccountLiveLogo", "headerAccountViconImageView", "getHeaderAccountViconImageView", "setHeaderAccountViconImageView", "innerFooterViewGroupBG", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsGradientMaskView;", "getInnerFooterViewGroupBG", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsGradientMaskView;", "setInnerFooterViewGroupBG", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsGradientMaskView;)V", "innerVideoArea", "getInnerVideoArea", "setInnerVideoArea", "locationContent", "getLocationContent", "setLocationContent", "locationIcon", "getLocationIcon", "setLocationIcon", "locationViewGroup", "getLocationViewGroup", "setLocationViewGroup", "logoImageView", "playCountTextView", "getPlayCountTextView", "setPlayCountTextView", "rewardCoinBtn", "getRewardCoinBtn", "setRewardCoinBtn", "rewardCoinCountText", "getRewardCoinCountText", "setRewardCoinCountText", "rewardCoinIcon", "getRewardCoinIcon", "setRewardCoinIcon", "subscriptText", "switchVideoForAccessibility", "yourFollowText", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public class ShortVideoItemHolder
  extends VideoItemHolder
{
  @Nullable
  private TextView A;
  @Nullable
  private TextView B;
  @Nullable
  private ImageView C;
  @Nullable
  private TextView D;
  @Nullable
  private TextView E;
  @Nullable
  private TextView F;
  @Nullable
  private KandianUrlImageView G;
  @Nullable
  private ImageView H;
  @NotNull
  private ViewGroup I;
  @NotNull
  private ImageView J;
  @Nullable
  private TextView K;
  @Nullable
  private ViewGroup L;
  @Nullable
  private TextView M;
  @Nullable
  private ImageView N;
  @Nullable
  private ViewStub O;
  @Nullable
  private ViewGroup P;
  @Nullable
  private TextView Q;
  @Nullable
  private TextView R;
  @JvmField
  @NotNull
  public ImageView a;
  @JvmField
  @Nullable
  public View b;
  @JvmField
  @Nullable
  public View c;
  @JvmField
  @Nullable
  public View d;
  @JvmField
  @Nullable
  public ImageView e;
  @JvmField
  @Nullable
  public TextView f;
  @JvmField
  @Nullable
  public TextView g;
  @JvmField
  @Nullable
  public TextView h;
  @JvmField
  @Nullable
  public CircleCountdownView i;
  @JvmField
  @NotNull
  public ImageView j;
  @JvmField
  @Nullable
  public TextView k;
  @JvmField
  @Nullable
  public TextView l;
  @NotNull
  private ViewGroup m;
  @NotNull
  private View n;
  @NotNull
  private ImageView o;
  @NotNull
  private VideoFeedsGradientMaskView p;
  @Nullable
  private VideoFeedsAioGuideView q;
  @NotNull
  private URLImageView r;
  @Nullable
  private TextView s;
  @NotNull
  private FrameLayout t;
  @NotNull
  private ViewStub u;
  @Nullable
  private View v;
  @Nullable
  private ViewGroup w;
  @Nullable
  private ViewGroup x;
  @Nullable
  private URLImageView y;
  @Nullable
  private URLImageView z;
  
  public ShortVideoItemHolder(@NotNull View paramView)
  {
    super(paramView, 2);
    View localView = paramView.findViewById(2131435799);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_footer_view_group_bg)");
    this.p = ((VideoFeedsGradientMaskView)localView);
    localView = paramView.findViewById(2131434956);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.h…_account_vicon_imageview)");
    this.o = ((ImageView)localView);
    this.b = VideoFeedsAccessibilityHelper.a.a(paramView);
    localView = paramView.findViewById(2131429242);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.background_imageview)");
    this.r = ((URLImageView)localView);
    this.s = ((TextView)paramView.findViewById(2131449654));
    localView = paramView.findViewById(2131437742);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.logo_imageview)");
    this.j = ((ImageView)localView);
    localView = paramView.findViewById(2131434951);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_layout)");
    this.t = ((FrameLayout)localView);
    localView = paramView.findViewById(2131449550);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…eeds_fl_inner_video_area)");
    this.m = ((ViewGroup)localView);
    localView = paramView.findViewById(2131449593);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…o_feeds_vs_column_banner)");
    this.u = ((ViewStub)localView);
    localView = paramView.findViewById(2131434952);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_living)");
    this.a = ((ImageView)localView);
    localView = paramView.findViewById(2131433597);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_layout)");
    this.I = ((ViewGroup)localView);
    localView = paramView.findViewById(2131433596);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_icon)");
    this.J = ((ImageView)localView);
    this.K = ((TextView)paramView.findViewById(2131433598));
    this.l = ((TextView)paramView.findViewById(2131449586));
    this.L = ((ViewGroup)paramView.findViewById(2131449555));
    this.N = ((ImageView)paramView.findViewById(2131449554));
    this.M = ((TextView)paramView.findViewById(2131449553));
    this.O = ((ViewStub)paramView.findViewById(2131449592));
    localView = paramView.findViewById(2131449570);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…ove_auto_seekbar_content)");
    this.n = localView;
    if (Aladdin.getConfig(327).getIntegerFromString("is_show_your_follow", 0) == 1) {
      this.k = ((TextView)paramView.findViewById(2131449587));
    }
    int i1 = (int)(Aladdin.getConfig(263).getFloatFromString("bottom_mask_alpha", 0.7F) * 'ÿ');
    this.p.setMaskAlpha(i1);
    if (this.aN != null) {
      VideoFeedsHelper.a(this.aN);
    }
  }
  
  @Nullable
  public final ImageView A()
  {
    return this.N;
  }
  
  @Nullable
  public final ViewStub B()
  {
    return this.O;
  }
  
  @Nullable
  public final ViewGroup C()
  {
    return this.P;
  }
  
  @Nullable
  public final TextView D()
  {
    return this.Q;
  }
  
  @Nullable
  public final TextView E()
  {
    return this.R;
  }
  
  @NotNull
  public final ViewGroup a()
  {
    return this.m;
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<set-?>");
    this.n = paramView;
  }
  
  public final void a(@Nullable ViewGroup paramViewGroup)
  {
    this.w = paramViewGroup;
  }
  
  public final void a(@Nullable ImageView paramImageView)
  {
    this.C = paramImageView;
  }
  
  public final void a(@Nullable TextView paramTextView)
  {
    this.A = paramTextView;
  }
  
  public final void a(@Nullable URLImageView paramURLImageView)
  {
    this.y = paramURLImageView;
  }
  
  public final void a(@Nullable KandianUrlImageView paramKandianUrlImageView)
  {
    this.G = paramKandianUrlImageView;
  }
  
  public final void a(@Nullable VideoFeedsAioGuideView paramVideoFeedsAioGuideView)
  {
    this.q = paramVideoFeedsAioGuideView;
  }
  
  @NotNull
  public final View b()
  {
    return this.n;
  }
  
  public final void b(@Nullable View paramView)
  {
    this.v = paramView;
  }
  
  public final void b(@Nullable ViewGroup paramViewGroup)
  {
    this.x = paramViewGroup;
  }
  
  public final void b(@Nullable ImageView paramImageView)
  {
    this.H = paramImageView;
  }
  
  public final void b(@Nullable TextView paramTextView)
  {
    this.B = paramTextView;
  }
  
  public final void b(@Nullable URLImageView paramURLImageView)
  {
    this.z = paramURLImageView;
  }
  
  @NotNull
  public final ImageView c()
  {
    return this.o;
  }
  
  public final void c(@Nullable ViewGroup paramViewGroup)
  {
    this.P = paramViewGroup;
  }
  
  public final void c(@Nullable TextView paramTextView)
  {
    this.D = paramTextView;
  }
  
  @NotNull
  public final VideoFeedsGradientMaskView d()
  {
    return this.p;
  }
  
  public final void d(@Nullable TextView paramTextView)
  {
    this.E = paramTextView;
  }
  
  @Nullable
  public final VideoFeedsAioGuideView e()
  {
    return this.q;
  }
  
  public final void e(@Nullable TextView paramTextView)
  {
    this.F = paramTextView;
  }
  
  @NotNull
  public final URLImageView f()
  {
    return this.r;
  }
  
  public final void f(@Nullable TextView paramTextView)
  {
    this.Q = paramTextView;
  }
  
  @Nullable
  public final TextView g()
  {
    return this.s;
  }
  
  public final void g(@Nullable TextView paramTextView)
  {
    this.R = paramTextView;
  }
  
  @NotNull
  public final FrameLayout h()
  {
    return this.t;
  }
  
  @NotNull
  public final ViewStub i()
  {
    return this.u;
  }
  
  @Nullable
  public final View j()
  {
    return this.v;
  }
  
  @Nullable
  public final ViewGroup k()
  {
    return this.w;
  }
  
  @Nullable
  public final URLImageView l()
  {
    return this.y;
  }
  
  @Nullable
  public final URLImageView m()
  {
    return this.z;
  }
  
  @Nullable
  public final TextView n()
  {
    return this.A;
  }
  
  @Nullable
  public final TextView o()
  {
    return this.B;
  }
  
  @Nullable
  public final ImageView p()
  {
    return this.C;
  }
  
  @Nullable
  public final TextView q()
  {
    return this.D;
  }
  
  @Nullable
  public final TextView r()
  {
    return this.E;
  }
  
  @Nullable
  public final TextView s()
  {
    return this.F;
  }
  
  @Nullable
  public final KandianUrlImageView t()
  {
    return this.G;
  }
  
  @Nullable
  public final ImageView u()
  {
    return this.H;
  }
  
  @NotNull
  public final ViewGroup v()
  {
    return this.I;
  }
  
  @NotNull
  public final ImageView w()
  {
    return this.J;
  }
  
  @Nullable
  public final TextView x()
  {
    return this.K;
  }
  
  @Nullable
  public final ViewGroup y()
  {
    return this.L;
  }
  
  @Nullable
  public final TextView z()
  {
    return this.M;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */