import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView$OnSetNickNameListener;", "rootView", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "adHeaderdownloadView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInjoyHeaderAdDownloadView;", "biuLayout", "Landroid/view/ViewGroup;", "contentLayout", "followBtn", "Lcom/tencent/biz/pubaccount/readinjoy/video/IVideoFeedsFollowButton;", "footerBiuCountTextView", "Landroid/widget/TextView;", "footerBuiBtn", "Landroid/widget/ImageView;", "footerCommentBtn", "footerCommentBtnBg", "footerCommentBtnText", "footerDiversion", "footerLikeBtn", "footerLikeCountTextView", "footerViewGroup", "footerWriteCommentBar", "gameBarBtn", "gameBarContainer", "gameBarContent", "gameBarDownloadView", "gameBarThumbnail", "Lcom/tencent/image/URLImageView;", "gameBarTitle", "headerAccountIconImageView", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;", "headerAccountLayout", "headerAccountNameTextView", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;", "headerAdBarTitleLayout", "headerAdContainer", "headerAdMore", "headerAdThumbnail", "headerAdTips", "headerAdTitle", "headerDiversion", "headerSmallGameAdContainer", "headerSoftAdContainer", "headerViewGroup", "hearAdBarIvDownload", "mAdBarClose", "mAdBarDescBig", "mAdBarExpandLayoutBig", "mAdBarThumbnailDesc", "mAdBarThumbnailGoodsExpandBig", "mAdBarTipsBig", "mAdBarTipsPromotion", "mAdBarTitleBig", "mAdHeadDivier", "mHeadAdBarThumbnailGoodsBig", "mSoftAdDownloadView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "mVideoFeedsHeaderTopAdContainer", "Landroid/widget/LinearLayout;", "mVideoFeedsHeaderTopAdContainerBig", "scrollToNextContainer", "scrollToNextImage", "Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;", "scrollToNextText", "scrollToNextViewStub", "Landroid/view/ViewStub;", "shuntBarCloseBtn", "shuntBarContainer", "shuntBarThumbnail", "shuntBarTitle", "smallGameBtnText", "smallGameDivider", "softAdThumbnailCloseBtn", "Landroid/widget/FrameLayout;", "strongShuntBarCloseBtn", "strongShuntBarContainer", "strongShuntBarJumpBtn", "strongShuntBarSubTitle", "strongShuntBarThumbnail", "strongShuntBarTitle", "strongShuntBarViewStub", "titleTextView", "ugViewShoot", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsUGView;", "ugViewTop", "onSetNickName", "", "nickName", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class swu
  extends swm
  implements taw
{
  @JvmField
  @Nullable
  public TextView A;
  @JvmField
  @Nullable
  public TextView B;
  @JvmField
  @Nullable
  public TextView C;
  @JvmField
  @Nullable
  public TextView D;
  @JvmField
  @Nullable
  public TextView E;
  @JvmField
  @Nullable
  public TextView F;
  @JvmField
  @Nullable
  public TextView G;
  @JvmField
  @Nullable
  public TextView H;
  @JvmField
  @Nullable
  public TextView I;
  @JvmField
  @Nullable
  public TextView J;
  @JvmField
  @Nullable
  public TextView K;
  @JvmField
  @Nullable
  public TextView L;
  @JvmField
  @Nullable
  public TextView M;
  @JvmField
  @Nullable
  public TextView N;
  @JvmField
  @Nullable
  public ViewStub a;
  @JvmField
  @Nullable
  public FrameLayout a;
  @JvmField
  @Nullable
  public VideoFeedsUGView a;
  @JvmField
  @Nullable
  public KandianUrlImageView a;
  @JvmField
  @Nullable
  public ReadInJoyNickNameTextView a;
  @JvmField
  @Nullable
  public ReadInjoyHeaderAdDownloadView a;
  @JvmField
  @Nullable
  public sfb a;
  @JvmField
  @Nullable
  public ViewStub b;
  @JvmField
  @Nullable
  public VideoFeedsUGView b;
  @JvmField
  @Nullable
  public ReadInJoyHeadImageView b;
  @JvmField
  @Nullable
  public RIJDownloadView c;
  @JvmField
  @Nullable
  public URLImageView d;
  @JvmField
  @Nullable
  public LinearLayout e;
  @JvmField
  @Nullable
  public URLImageView e;
  @JvmField
  @Nullable
  public URLImageView f;
  @JvmField
  @Nullable
  public URLImageView g;
  @JvmField
  @Nullable
  public URLImageView h;
  @JvmField
  @Nullable
  public ViewGroup i;
  @JvmField
  @Nullable
  public ViewGroup j;
  @JvmField
  @Nullable
  public ViewGroup k;
  @JvmField
  @Nullable
  public ImageView k;
  @JvmField
  @Nullable
  public ViewGroup l;
  @JvmField
  @Nullable
  public ImageView l;
  @JvmField
  @Nullable
  public ViewGroup m;
  @JvmField
  @Nullable
  public ImageView m;
  @JvmField
  @Nullable
  public ViewGroup n;
  @JvmField
  @Nullable
  public ImageView n;
  @JvmField
  @Nullable
  public ViewGroup o;
  @JvmField
  @Nullable
  public View p;
  @JvmField
  @Nullable
  public ViewGroup p;
  @JvmField
  @Nullable
  public View q;
  @JvmField
  @Nullable
  public ViewGroup q;
  @JvmField
  @Nullable
  public View r;
  @JvmField
  @Nullable
  public ViewGroup r;
  @JvmField
  @Nullable
  public View s;
  @JvmField
  @Nullable
  public ViewGroup s;
  @JvmField
  @Nullable
  public View t;
  @JvmField
  @Nullable
  public ViewGroup t;
  @JvmField
  @Nullable
  public View u;
  @JvmField
  @Nullable
  public ViewGroup u;
  @JvmField
  @Nullable
  public View v;
  @JvmField
  @Nullable
  public ViewGroup v;
  @JvmField
  @Nullable
  public TextView v;
  @JvmField
  @NotNull
  public View w;
  @JvmField
  @Nullable
  public ViewGroup w;
  @JvmField
  @Nullable
  public TextView w;
  @JvmField
  @Nullable
  public ViewGroup x;
  @JvmField
  @Nullable
  public TextView x;
  @JvmField
  @Nullable
  public TextView y;
  @JvmField
  @Nullable
  public TextView z;
  
  public swu(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    this.jdField_w_of_type_AndroidViewView = paramView;
    this.v = ((TextView)this.jdField_w_of_type_AndroidViewView.findViewById(2131379095));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView = ((VideoFeedsUGView)this.jdField_w_of_type_AndroidViewView.findViewById(2131380405));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView = ((VideoFeedsUGView)this.jdField_w_of_type_AndroidViewView.findViewById(2131380403));
    this.i = ((ViewGroup)this.jdField_w_of_type_AndroidViewView.findViewById(2131368150));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_w_of_type_AndroidViewView.findViewById(2131368128));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, (taw)this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_w_of_type_AndroidViewView.findViewById(2131368124));
    View localView = this.jdField_w_of_type_AndroidViewView.findViewById(2131368118);
    paramView = localView;
    if (!(localView instanceof sfb)) {
      paramView = null;
    }
    this.jdField_a_of_type_Sfb = ((sfb)paramView);
    this.jdField_k_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_w_of_type_AndroidViewView.findViewById(2131367166));
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_w_of_type_AndroidViewView.findViewById(2131367152));
    this.jdField_m_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_w_of_type_AndroidViewView.findViewById(2131372208));
    this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_w_of_type_AndroidViewView.findViewById(2131367160));
    this.jdField_l_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_w_of_type_AndroidViewView.findViewById(2131367179));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_w_of_type_AndroidViewView.findViewById(2131367154));
    this.jdField_w_of_type_AndroidWidgetTextView = ((TextView)this.jdField_w_of_type_AndroidViewView.findViewById(2131367156));
    this.jdField_p_of_type_AndroidViewView = this.jdField_w_of_type_AndroidViewView.findViewById(2131367178);
    this.x = ((TextView)this.jdField_w_of_type_AndroidViewView.findViewById(2131367163));
    this.y = ((TextView)this.jdField_w_of_type_AndroidViewView.findViewById(2131367150));
    this.jdField_p_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_w_of_type_AndroidViewView.findViewById(2131380906));
    this.q = ((ViewGroup)this.jdField_w_of_type_AndroidViewView.findViewById(2131380904));
    this.n = ((ViewGroup)this.jdField_w_of_type_AndroidViewView.findViewById(2131380884));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_w_of_type_AndroidViewView.findViewById(2131373871));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_w_of_type_AndroidViewView.findViewById(2131373868));
    VideoReport.setElementId(this.i, "puin_button");
    VideoReport.setElementId(this.jdField_a_of_type_Sfb, "follow_button");
    VideoReport.setElementId(this.jdField_p_of_type_AndroidViewView, "write_comment_button");
    VideoReport.setElementId(this.jdField_l_of_type_AndroidViewViewGroup, "comment_button");
    VideoReport.setElementId(this.jdField_m_of_type_AndroidWidgetImageView, "like_button");
    VideoReport.setElementId(this.jdField_l_of_type_AndroidWidgetImageView, "biu_button");
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, "card");
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, ReportPolicy.REPORT_POLICY_NONE);
    VideoReport.setElementId(this.g, "card");
    VideoReport.setElementId(this.j, "card");
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "nickName");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
    {
      VideoFeedsAccessibilityHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramString);
      VideoFeedsAccessibilityHelper.c((View)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swu
 * JD-Core Version:    0.7.0.1
 */