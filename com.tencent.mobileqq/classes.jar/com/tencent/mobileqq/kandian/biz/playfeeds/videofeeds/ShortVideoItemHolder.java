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
  private ViewGroup A;
  @Nullable
  private ViewGroup B;
  @NotNull
  private ViewGroup C;
  @Nullable
  private ViewGroup D;
  @Nullable
  private ViewGroup E;
  @Nullable
  private TextView P;
  @JvmField
  @Nullable
  public View a;
  @JvmField
  @NotNull
  public ImageView a;
  @JvmField
  @Nullable
  public TextView a;
  @NotNull
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  @JvmField
  @Nullable
  public CircleCountdownView a;
  @Nullable
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  @Nullable
  private VideoFeedsAioGuideView jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAioGuideView;
  @NotNull
  private VideoFeedsGradientMaskView jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGradientMaskView;
  @JvmField
  @Nullable
  public View b;
  @NotNull
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  @JvmField
  @Nullable
  public ImageView b;
  @JvmField
  @Nullable
  public TextView b;
  @Nullable
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  @JvmField
  @Nullable
  public View c;
  @Nullable
  private ViewStub c;
  @JvmField
  @NotNull
  public ImageView c;
  @JvmField
  @Nullable
  public TextView c;
  @NotNull
  private View jdField_d_of_type_AndroidViewView;
  @NotNull
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  @JvmField
  @Nullable
  public TextView d;
  @Nullable
  private View jdField_e_of_type_AndroidViewView;
  @NotNull
  private FrameLayout jdField_e_of_type_AndroidWidgetFrameLayout;
  @Nullable
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  @JvmField
  @Nullable
  public TextView e;
  @Nullable
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  @Nullable
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  @Nullable
  private TextView g;
  @Nullable
  private TextView h;
  @Nullable
  private TextView i;
  @Nullable
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  @Nullable
  private URLImageView jdField_j_of_type_ComTencentImageURLImageView;
  @Nullable
  private TextView k;
  @Nullable
  private TextView l;
  @Nullable
  private TextView m;
  @Nullable
  private TextView n;
  @NotNull
  private ImageView p;
  @Nullable
  private ImageView q;
  @NotNull
  private ViewGroup z;
  
  public ShortVideoItemHolder(@NotNull View paramView)
  {
    super(paramView, 2);
    View localView = paramView.findViewById(2131368865);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_footer_view_group_bg)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)localView);
    localView = paramView.findViewById(2131368102);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.h…_account_vicon_imageview)");
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView);
    this.jdField_a_of_type_AndroidViewView = VideoFeedsAccessibilityHelper.a.a(paramView);
    localView = paramView.findViewById(2131363353);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.background_imageview)");
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380694));
    localView = paramView.findViewById(2131370470);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.logo_imageview)");
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131368097);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_layout)");
    this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView);
    localView = paramView.findViewById(2131380592);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…eeds_fl_inner_video_area)");
    this.z = ((ViewGroup)localView);
    localView = paramView.findViewById(2131380635);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…o_feeds_vs_column_banner)");
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)localView);
    localView = paramView.findViewById(2131368098);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_living)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131367143);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_layout)");
    this.C = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367142);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_icon)");
    this.p = ((ImageView)localView);
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367144));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380628));
    this.D = ((ViewGroup)paramView.findViewById(2131380597));
    this.q = ((ImageView)paramView.findViewById(2131380596));
    this.m = ((TextView)paramView.findViewById(2131380595));
    this.jdField_c_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380634));
    localView = paramView.findViewById(2131380612);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…ove_auto_seekbar_content)");
    this.jdField_d_of_type_AndroidViewView = localView;
    if (Aladdin.getConfig(327).getIntegerFromString("is_show_your_follow", 0) == 1) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380629));
    }
    int i1 = (int)(Aladdin.getConfig(263).getFloatFromString("bottom_mask_alpha", 0.7F) * 'ÿ');
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGradientMaskView.setMaskAlpha(i1);
    if (this.jdField_l_of_type_AndroidViewViewGroup != null) {
      VideoFeedsHelper.a(this.jdField_l_of_type_AndroidViewViewGroup);
    }
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_d_of_type_AndroidViewView;
  }
  
  @NotNull
  public final ViewGroup a()
  {
    return this.z;
  }
  
  @NotNull
  public final ViewStub a()
  {
    return this.jdField_b_of_type_AndroidViewViewStub;
  }
  
  @NotNull
  public final FrameLayout a()
  {
    return this.jdField_e_of_type_AndroidWidgetFrameLayout;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView a()
  {
    return this.jdField_f_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  @Nullable
  public final KandianUrlImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  }
  
  @Nullable
  public final VideoFeedsAioGuideView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAioGuideView;
  }
  
  @NotNull
  public final VideoFeedsGradientMaskView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGradientMaskView;
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<set-?>");
    this.jdField_d_of_type_AndroidViewView = paramView;
  }
  
  public final void a(@Nullable ViewGroup paramViewGroup)
  {
    this.A = paramViewGroup;
  }
  
  public final void a(@Nullable ImageView paramImageView)
  {
    this.jdField_e_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void a(@Nullable TextView paramTextView)
  {
    this.g = paramTextView;
  }
  
  public final void a(@Nullable URLImageView paramURLImageView)
  {
    this.jdField_b_of_type_ComTencentImageURLImageView = paramURLImageView;
  }
  
  public final void a(@Nullable KandianUrlImageView paramKandianUrlImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = paramKandianUrlImageView;
  }
  
  public final void a(@Nullable VideoFeedsAioGuideView paramVideoFeedsAioGuideView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAioGuideView = paramVideoFeedsAioGuideView;
  }
  
  @Nullable
  public final View b()
  {
    return this.jdField_e_of_type_AndroidViewView;
  }
  
  @Nullable
  public final ViewGroup b()
  {
    return this.A;
  }
  
  @Nullable
  public final ViewStub b()
  {
    return this.jdField_c_of_type_AndroidViewViewStub;
  }
  
  @Nullable
  public final ImageView b()
  {
    return this.jdField_e_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView b()
  {
    return this.g;
  }
  
  @Nullable
  public final URLImageView b()
  {
    return this.jdField_b_of_type_ComTencentImageURLImageView;
  }
  
  public final void b(@Nullable View paramView)
  {
    this.jdField_e_of_type_AndroidViewView = paramView;
  }
  
  public final void b(@Nullable ViewGroup paramViewGroup)
  {
    this.B = paramViewGroup;
  }
  
  public final void b(@Nullable ImageView paramImageView)
  {
    this.jdField_f_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void b(@Nullable TextView paramTextView)
  {
    this.h = paramTextView;
  }
  
  public final void b(@Nullable URLImageView paramURLImageView)
  {
    this.jdField_j_of_type_ComTencentImageURLImageView = paramURLImageView;
  }
  
  @NotNull
  public final ViewGroup c()
  {
    return this.C;
  }
  
  @Nullable
  public final ImageView c()
  {
    return this.jdField_f_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView c()
  {
    return this.h;
  }
  
  @Nullable
  public final URLImageView c()
  {
    return this.jdField_j_of_type_ComTencentImageURLImageView;
  }
  
  public final void c(@Nullable ViewGroup paramViewGroup)
  {
    this.E = paramViewGroup;
  }
  
  public final void c(@Nullable TextView paramTextView)
  {
    this.i = paramTextView;
  }
  
  @Nullable
  public final ViewGroup d()
  {
    return this.D;
  }
  
  @NotNull
  public final ImageView d()
  {
    return this.p;
  }
  
  @Nullable
  public final TextView d()
  {
    return this.i;
  }
  
  public final void d(@Nullable TextView paramTextView)
  {
    this.jdField_j_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  @Nullable
  public final ViewGroup e()
  {
    return this.E;
  }
  
  @Nullable
  public final ImageView e()
  {
    return this.q;
  }
  
  @Nullable
  public final TextView e()
  {
    return this.jdField_j_of_type_AndroidWidgetTextView;
  }
  
  public final void e(@Nullable TextView paramTextView)
  {
    this.k = paramTextView;
  }
  
  @Nullable
  public final TextView f()
  {
    return this.k;
  }
  
  public final void f(@Nullable TextView paramTextView)
  {
    this.n = paramTextView;
  }
  
  @Nullable
  public final TextView g()
  {
    return this.jdField_l_of_type_AndroidWidgetTextView;
  }
  
  public final void g(@Nullable TextView paramTextView)
  {
    this.P = paramTextView;
  }
  
  @Nullable
  public final TextView h()
  {
    return this.m;
  }
  
  @Nullable
  public final TextView i()
  {
    return this.n;
  }
  
  @Nullable
  public final TextView j()
  {
    return this.P;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */