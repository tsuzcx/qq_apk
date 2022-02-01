import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "adGuideContent", "adGuideGotoBtn", "Landroid/widget/TextView;", "adGuideIcon", "Landroid/widget/ImageView;", "adGuideMask", "adGuideName", "adGuideProgress", "Lcom/tencent/biz/pubaccount/readinjoy/view/CircleCountdownView;", "adGuideReplayBtn", "aioGuideView", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAioGuideView;", "getAioGuideView", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAioGuideView;", "setAioGuideView", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAioGuideView;)V", "backgroundImageview", "Lcom/tencent/image/URLImageView;", "getBackgroundImageview", "()Lcom/tencent/image/URLImageView;", "setBackgroundImageview", "(Lcom/tencent/image/URLImageView;)V", "columnBanner", "Landroid/view/ViewGroup;", "getColumnBanner", "()Landroid/view/ViewGroup;", "setColumnBanner", "(Landroid/view/ViewGroup;)V", "columnBannerArrow", "getColumnBannerArrow", "()Landroid/widget/ImageView;", "setColumnBannerArrow", "(Landroid/widget/ImageView;)V", "columnBannerBlackArrow", "getColumnBannerBlackArrow", "setColumnBannerBlackArrow", "columnBannerHighLightText", "getColumnBannerHighLightText", "()Landroid/widget/TextView;", "setColumnBannerHighLightText", "(Landroid/widget/TextView;)V", "columnBannerIcon", "getColumnBannerIcon", "setColumnBannerIcon", "columnBannerLightLine", "Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;", "getColumnBannerLightLine", "()Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;", "setColumnBannerLightLine", "(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;)V", "columnBannerLogo", "getColumnBannerLogo", "setColumnBannerLogo", "columnBannerName", "getColumnBannerName", "setColumnBannerName", "columnBannerNormalText", "getColumnBannerNormalText", "setColumnBannerNormalText", "columnBannerPrefix", "getColumnBannerPrefix", "setColumnBannerPrefix", "columnBannerSubscribeBtn", "getColumnBannerSubscribeBtn", "setColumnBannerSubscribeBtn", "columnBannerViewStub", "Landroid/view/ViewStub;", "getColumnBannerViewStub", "()Landroid/view/ViewStub;", "setColumnBannerViewStub", "(Landroid/view/ViewStub;)V", "columnExpandBannerBg", "getColumnExpandBannerBg", "()Landroid/view/View;", "setColumnExpandBannerBg", "columnSmallBanner", "getColumnSmallBanner", "setColumnSmallBanner", "headerAccountIconViewGroup", "Landroid/widget/FrameLayout;", "getHeaderAccountIconViewGroup", "()Landroid/widget/FrameLayout;", "setHeaderAccountIconViewGroup", "(Landroid/widget/FrameLayout;)V", "headerAccountLiveLogo", "headerAccountViconImageView", "getHeaderAccountViconImageView", "setHeaderAccountViconImageView", "innerFooterViewGroupBG", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGradientMaskView;", "getInnerFooterViewGroupBG", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGradientMaskView;", "setInnerFooterViewGroupBG", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGradientMaskView;)V", "innerVideoArea", "getInnerVideoArea", "setInnerVideoArea", "locationContent", "getLocationContent", "setLocationContent", "locationIcon", "getLocationIcon", "setLocationIcon", "locationViewGroup", "getLocationViewGroup", "setLocationViewGroup", "logoImageView", "playCountTextView", "getPlayCountTextView", "setPlayCountTextView", "rewardCoinBtn", "getRewardCoinBtn", "setRewardCoinBtn", "rewardCoinCountText", "getRewardCoinCountText", "setRewardCoinCountText", "rewardCoinIcon", "getRewardCoinIcon", "setRewardCoinIcon", "subscriptText", "switchVideoForAccessibility", "yourFollowText", "getYourFollowText", "setYourFollowText", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class swr
  extends swu
{
  @Nullable
  private ViewGroup A;
  @NotNull
  private ViewGroup B;
  @Nullable
  private ViewGroup C;
  @JvmField
  @Nullable
  public View a;
  @JvmField
  @NotNull
  public ImageView a;
  @JvmField
  @Nullable
  public TextView a;
  @Nullable
  private VideoFeedsAioGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView;
  @NotNull
  private VideoFeedsGradientMaskView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView;
  @JvmField
  @Nullable
  public CircleCountdownView a;
  @NotNull
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  @JvmField
  @Nullable
  public View b;
  @NotNull
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  @JvmField
  @Nullable
  public ImageView b;
  @JvmField
  @Nullable
  public TextView b;
  @Nullable
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  @Nullable
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  @JvmField
  @Nullable
  public View c;
  @NotNull
  private ViewStub c;
  @JvmField
  @NotNull
  public ImageView c;
  @JvmField
  @Nullable
  public TextView c;
  @Nullable
  private View jdField_d_of_type_AndroidViewView;
  @NotNull
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  @JvmField
  @Nullable
  public TextView d;
  @Nullable
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  @Nullable
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  @Nullable
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  @Nullable
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  @Nullable
  private TextView g;
  @Nullable
  private TextView h;
  @Nullable
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  @Nullable
  private URLImageView jdField_i_of_type_ComTencentImageURLImageView;
  @Nullable
  private TextView j;
  @Nullable
  private TextView k;
  @Nullable
  private TextView l;
  @Nullable
  private TextView m;
  @NotNull
  private ImageView o;
  @Nullable
  private ImageView p;
  @NotNull
  private ViewGroup y;
  @Nullable
  private ViewGroup z;
  
  public swr(@NotNull View paramView)
  {
    super(paramView, 2);
    View localView = paramView.findViewById(2131368900);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_footer_view_group_bg)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)localView);
    localView = paramView.findViewById(2131368130);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.h…_account_vicon_imageview)");
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView);
    this.jdField_a_of_type_AndroidViewView = VideoFeedsAccessibilityHelper.a(paramView);
    localView = paramView.findViewById(2131363343);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.background_imageview)");
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380982));
    localView = paramView.findViewById(2131370555);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.logo_imageview)");
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131368125);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_layout)");
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView);
    localView = paramView.findViewById(2131380886);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…eeds_fl_inner_video_area)");
    this.y = ((ViewGroup)localView);
    localView = paramView.findViewById(2131380920);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…o_feeds_vs_column_banner)");
    this.jdField_c_of_type_AndroidViewViewStub = ((ViewStub)localView);
    localView = paramView.findViewById(2131368126);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_living)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131367171);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_layout)");
    this.B = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367170);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_icon)");
    this.o = ((ImageView)localView);
    this.l = ((TextView)paramView.findViewById(2131367172));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380915));
    this.C = ((ViewGroup)paramView.findViewById(2131380891));
    this.p = ((ImageView)paramView.findViewById(2131380890));
    this.m = ((TextView)paramView.findViewById(2131380889));
    if (Aladdin.getConfig(327).getIntegerFromString("is_show_your_follow", 0) == 1) {
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380916));
    }
    int n = (int)(Aladdin.getConfig(263).getFloatFromString("bottom_mask_alpha", 0.7F) * 'ÿ');
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setMaskAlpha(n);
    if (this.jdField_k_of_type_AndroidViewViewGroup != null) {
      six.a(this.jdField_k_of_type_AndroidViewViewGroup);
    }
  }
  
  @Nullable
  public final View a()
  {
    return this.jdField_d_of_type_AndroidViewView;
  }
  
  @NotNull
  public final ViewGroup a()
  {
    return this.y;
  }
  
  @NotNull
  public final ViewStub a()
  {
    return this.jdField_c_of_type_AndroidViewViewStub;
  }
  
  @NotNull
  public final FrameLayout a()
  {
    return this.jdField_b_of_type_AndroidWidgetFrameLayout;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView a()
  {
    return this.jdField_e_of_type_AndroidWidgetTextView;
  }
  
  @Nullable
  public final VideoFeedsAioGuideView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView;
  }
  
  @NotNull
  public final VideoFeedsGradientMaskView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView;
  }
  
  @Nullable
  public final KandianUrlImageView a()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  }
  
  @NotNull
  public final URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  public final void a(@Nullable View paramView)
  {
    this.jdField_d_of_type_AndroidViewView = paramView;
  }
  
  public final void a(@Nullable ViewGroup paramViewGroup)
  {
    this.z = paramViewGroup;
  }
  
  public final void a(@Nullable ImageView paramImageView)
  {
    this.jdField_e_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void a(@Nullable TextView paramTextView)
  {
    this.jdField_f_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public final void a(@Nullable VideoFeedsAioGuideView paramVideoFeedsAioGuideView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = paramVideoFeedsAioGuideView;
  }
  
  public final void a(@Nullable KandianUrlImageView paramKandianUrlImageView)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = paramKandianUrlImageView;
  }
  
  public final void a(@Nullable URLImageView paramURLImageView)
  {
    this.jdField_b_of_type_ComTencentImageURLImageView = paramURLImageView;
  }
  
  @Nullable
  public final ViewGroup b()
  {
    return this.z;
  }
  
  @Nullable
  public final ImageView b()
  {
    return this.jdField_e_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView b()
  {
    return this.jdField_f_of_type_AndroidWidgetTextView;
  }
  
  @Nullable
  public final URLImageView b()
  {
    return this.jdField_b_of_type_ComTencentImageURLImageView;
  }
  
  public final void b(@Nullable ViewGroup paramViewGroup)
  {
    this.A = paramViewGroup;
  }
  
  public final void b(@Nullable ImageView paramImageView)
  {
    this.jdField_f_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void b(@Nullable TextView paramTextView)
  {
    this.g = paramTextView;
  }
  
  public final void b(@Nullable URLImageView paramURLImageView)
  {
    this.jdField_i_of_type_ComTencentImageURLImageView = paramURLImageView;
  }
  
  @NotNull
  public final ViewGroup c()
  {
    return this.B;
  }
  
  @Nullable
  public final ImageView c()
  {
    return this.jdField_f_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView c()
  {
    return this.g;
  }
  
  @Nullable
  public final URLImageView c()
  {
    return this.jdField_i_of_type_ComTencentImageURLImageView;
  }
  
  public final void c(@Nullable TextView paramTextView)
  {
    this.h = paramTextView;
  }
  
  @Nullable
  public final ViewGroup d()
  {
    return this.C;
  }
  
  @NotNull
  public final ImageView d()
  {
    return this.o;
  }
  
  @Nullable
  public final TextView d()
  {
    return this.h;
  }
  
  public final void d(@Nullable TextView paramTextView)
  {
    this.jdField_i_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  @Nullable
  public final ImageView e()
  {
    return this.p;
  }
  
  @Nullable
  public final TextView e()
  {
    return this.jdField_i_of_type_AndroidWidgetTextView;
  }
  
  public final void e(@Nullable TextView paramTextView)
  {
    this.j = paramTextView;
  }
  
  @Nullable
  public final TextView f()
  {
    return this.j;
  }
  
  @Nullable
  public final TextView g()
  {
    return this.jdField_k_of_type_AndroidWidgetTextView;
  }
  
  @Nullable
  public final TextView h()
  {
    return this.l;
  }
  
  @Nullable
  public final TextView i()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swr
 * JD-Core Version:    0.7.0.1
 */