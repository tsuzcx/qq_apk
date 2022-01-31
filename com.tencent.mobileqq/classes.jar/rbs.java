import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLImageView;

public class rbs
  extends rbt
{
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RIJRedPacketPopupView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  VideoFeedsAioGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView;
  VideoFeedsGradientMaskView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView;
  public VideoFeedsTopicViewGroup a;
  CircleCountdownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  boolean jdField_a_of_type_Boolean;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  URLImageView jdField_d_of_type_ComTencentImageURLImageView;
  View jdField_e_of_type_AndroidViewView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  TextView g;
  TextView h;
  public ViewGroup i;
  ViewGroup j;
  ViewGroup k;
  
  public rbs(View paramView)
  {
    super(paramView, 2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131368335));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup = ((VideoFeedsTopicViewGroup)paramView.findViewById(2131379777));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367578));
    this.jdField_b_of_type_AndroidViewView = VideoFeedsAccessibilityHelper.a(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363038));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379771));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369862));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367574));
    this.c = ((KandianUrlImageView)paramView.findViewById(2131367591));
    this.e = paramView.findViewById(2131367592);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379702);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView = ((RIJRedPacketPopupView)paramView.findViewById(2131379699));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.b(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.a(false);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView != null)
    {
      int m = (int)(Aladdin.getConfig(263).getFloatFromString("bottom_mask_alpha", 0.7F) * 255.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setMaskAlpha(m);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      float f1 = Aladdin.getConfig(263).getFloatFromString("tiktok_bar_mask_alpha", 0.4F);
      this.jdField_a_of_type_AndroidViewView.setAlpha(f1);
    }
    if (this.m != null) {
      rdm.a(this.m);
    }
  }
  
  public static rbs a(View paramView)
  {
    boolean bool;
    ViewStub localViewStub1;
    ViewStub localViewStub2;
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1)
    {
      bool = true;
      if (!bool) {
        break label86;
      }
      localViewStub1 = (ViewStub)paramView.findViewById(2131379717);
      localViewStub2 = (ViewStub)paramView.findViewById(2131379709);
      ((ViewStub)paramView.findViewById(2131379715)).inflate();
      localViewStub1.inflate();
      localViewStub2.inflate();
    }
    for (;;)
    {
      paramView = new rbs(paramView);
      paramView.jdField_a_of_type_Boolean = bool;
      return paramView;
      bool = false;
      break;
      label86:
      localViewStub1 = (ViewStub)paramView.findViewById(2131379713);
      localViewStub2 = (ViewStub)paramView.findViewById(2131379711);
      ((ViewStub)paramView.findViewById(2131379714)).inflate();
      localViewStub1.inflate();
      localViewStub2.inflate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbs
 * JD-Core Version:    0.7.0.1
 */