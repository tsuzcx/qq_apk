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
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLImageView;

public class qmo
  extends qmp
{
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
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
  View jdField_e_of_type_AndroidViewView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  public ViewGroup i;
  ViewGroup j;
  
  public qmo(View paramView)
  {
    super(paramView, 2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131368178));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup = ((VideoFeedsTopicViewGroup)paramView.findViewById(2131379044));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367440));
    this.jdField_b_of_type_AndroidViewView = VideoFeedsAccessibilityHelper.a(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363002));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379038));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369580));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367436));
    this.c = ((KandianUrlImageView)paramView.findViewById(2131367453));
    this.e = paramView.findViewById(2131367454);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378983);
    int k;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView != null)
    {
      k = (int)(Aladdin.getConfig(263).getFloatFromString("bottom_mask_alpha", 0.7F) * 255.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setMaskAlpha(k);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      k = (int)(Aladdin.getConfig(263).getFloatFromString("tiktok_bar_mask_alpha", 0.4F) * 255.0F);
      this.jdField_a_of_type_AndroidViewView.setAlpha(k);
    }
  }
  
  public static qmo a(View paramView)
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
      localViewStub1 = (ViewStub)paramView.findViewById(2131378995);
      localViewStub2 = (ViewStub)paramView.findViewById(2131378988);
      ((ViewStub)paramView.findViewById(2131378993)).inflate();
      localViewStub1.inflate();
      localViewStub2.inflate();
    }
    for (;;)
    {
      paramView = new qmo(paramView);
      paramView.jdField_a_of_type_Boolean = bool;
      return paramView;
      bool = false;
      break;
      label86:
      localViewStub1 = (ViewStub)paramView.findViewById(2131378991);
      localViewStub2 = (ViewStub)paramView.findViewById(2131378989);
      ((ViewStub)paramView.findViewById(2131378992)).inflate();
      localViewStub1.inflate();
      localViewStub2.inflate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmo
 * JD-Core Version:    0.7.0.1
 */