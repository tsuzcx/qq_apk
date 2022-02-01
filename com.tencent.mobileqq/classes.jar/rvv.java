import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;

public class rvv
  extends rvn
  implements snl
{
  public ViewGroup A;
  TextView A;
  TextView B;
  TextView C;
  TextView D;
  public TextView E;
  public TextView F;
  public TextView G;
  public TextView H;
  TextView I;
  TextView J;
  TextView K;
  TextView L;
  public TextView M;
  public TextView N;
  public TextView O;
  public TextView P;
  public TextView Q;
  public TextView R;
  public TextView S;
  public TextView T;
  public Button a;
  VideoFeedsUGView a;
  public ReadInJoyNickNameTextView a;
  public ReadInjoyHeaderAdDownloadView a;
  public rsm a;
  ViewStub jdField_b_of_type_AndroidViewViewStub;
  public FrameLayout b;
  VideoFeedsUGView jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView;
  KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  public ReadInJoyHeadImageView b;
  public ReadInjoyHeaderAdDownloadView b;
  ViewStub c;
  public LinearLayout e;
  URLImageView e;
  public URLImageView f;
  URLImageView g;
  public URLImageView h;
  public URLImageView i;
  public URLImageView j;
  public ViewGroup m;
  ImageView m;
  public ViewGroup n;
  ImageView n;
  public ViewGroup o;
  ImageView o;
  ViewGroup p;
  public ImageView p;
  ViewGroup q;
  View r;
  public ViewGroup r;
  public View s;
  ViewGroup s;
  View jdField_t_of_type_AndroidViewView;
  ViewGroup jdField_t_of_type_AndroidViewViewGroup;
  View jdField_u_of_type_AndroidViewView;
  ViewGroup jdField_u_of_type_AndroidViewViewGroup;
  public View v;
  public ViewGroup v;
  public View w;
  ViewGroup w;
  public View x;
  ViewGroup x;
  public View y;
  public ViewGroup y;
  public View z;
  public ViewGroup z;
  public TextView z;
  
  public rvv(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    this.jdField_r_of_type_AndroidViewView = paramView;
    this.z = ((TextView)paramView.findViewById(2131378802));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView = ((VideoFeedsUGView)paramView.findViewById(2131380070));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView = ((VideoFeedsUGView)paramView.findViewById(2131380068));
    this.jdField_m_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368015));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131367992));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367988));
    this.jdField_a_of_type_Rsm = ((rsm)paramView.findViewById(2131367982));
    this.jdField_o_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367047));
    this.n = ((ImageView)paramView.findViewById(2131367034));
    if ((paramInt == 2) || (paramInt == 4) || (paramInt == 5) || (paramInt == 7)) {
      this.q = ((ViewGroup)paramView.findViewById(2131372016));
    }
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367041));
    this.p = ((ViewGroup)paramView.findViewById(2131367060));
    this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367035));
    this.A = ((TextView)paramView.findViewById(2131367037));
    this.s = paramView.findViewById(2131367059);
    this.B = ((TextView)paramView.findViewById(2131367044));
    this.C = ((TextView)paramView.findViewById(2131367032));
    this.t = ((ViewGroup)paramView.findViewById(2131380562));
    this.u = ((ViewGroup)paramView.findViewById(2131380560));
    this.jdField_r_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131380543));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373654));
    this.c = ((ViewStub)paramView.findViewById(2131373651));
    VideoReport.setElementId(this.jdField_m_of_type_AndroidViewViewGroup, "puin_button");
    VideoReport.setElementId(this.jdField_a_of_type_Rsm, "follow_button");
    VideoReport.setElementId(this.s, "write_comment_button");
    VideoReport.setElementId(this.p, "comment_button");
    VideoReport.setElementId(this.jdField_o_of_type_AndroidWidgetImageView, "like_button");
    VideoReport.setElementId(this.n, "biu_button");
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, "card");
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, ReportPolicy.REPORT_POLICY_NONE);
    VideoReport.setElementId(this.i, "card");
    VideoReport.setElementId(this.l, "card");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
    {
      VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramString);
      VideoFeedsAccessibilityHelper.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvv
 * JD-Core Version:    0.7.0.1
 */