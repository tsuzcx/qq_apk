import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;

public class pmz
  extends pnd
  implements pmw
{
  public Handler a;
  public View a;
  public ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public KandianUrlImageView a;
  public ReadInJoyHeadImageView a;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyVideoInfoViewGroup a;
  public VideoViewGroup a;
  public RoundAngleFrameLayout a;
  public rwc a;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public LinearLayout b;
  public TextView b;
  public KandianUrlImageView b;
  public View c;
  public ImageView c;
  public TextView c;
  public View d;
  public ImageView d;
  public TextView d;
  public View e;
  public ImageView e;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public pmz(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public pmz(Context paramContext, pms parampms)
  {
    super(paramContext, parampms);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560354, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131366574));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131380948));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378936));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368320));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131380865));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131361876));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131368212));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131376154));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365785));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373145));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368445));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368444));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369147));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131380876));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372762));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380872));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131376534);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131380865);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376116);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131369611));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372119));
    this.f = ((TextView)paramViewGroup.findViewById(2131372120));
    this.g = ((TextView)paramViewGroup.findViewById(2131369574));
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131378993);
    this.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131379020);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131369790));
    this.h = ((TextView)paramViewGroup.findViewById(2131362112));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131369641));
    this.i = ((TextView)paramViewGroup.findViewById(2131362034));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362033));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366592));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public rwc a()
  {
    return this.jdField_a_of_type_Rwc;
  }
  
  public void a(rwc paramrwc, int paramInt1, int paramInt2) {}
  
  public boolean a(View paramView)
  {
    if (!rpt.a(pms.a(this.jdField_a_of_type_Pms, paramView))) {}
    while (ozc.a(paramView) < 80.0F) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmz
 * JD-Core Version:    0.7.0.1
 */