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

public class rvs
  extends rvv
{
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  VideoFeedsAioGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView;
  VideoFeedsGradientMaskView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView;
  CircleCountdownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  URLImageView jdField_d_of_type_ComTencentImageURLImageView;
  View jdField_e_of_type_AndroidViewView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  public ImageView g;
  TextView g;
  TextView h;
  ViewGroup jdField_i_of_type_AndroidViewViewGroup;
  TextView jdField_i_of_type_AndroidWidgetTextView;
  ViewGroup jdField_j_of_type_AndroidViewViewGroup;
  TextView jdField_j_of_type_AndroidWidgetTextView;
  ViewGroup k;
  public TextView k;
  public ViewGroup l;
  
  public rvs(View paramView)
  {
    super(paramView, 2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131368741));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367994));
    this.jdField_b_of_type_AndroidViewView = VideoFeedsAccessibilityHelper.a(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380634));
    this.d = ((ImageView)paramView.findViewById(2131370372));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367989));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380565);
    this.i = ((ViewGroup)paramView.findViewById(2131380545));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380575));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367990));
    this.l = ((ViewGroup)paramView.findViewById(2131367052));
    this.g = ((ImageView)paramView.findViewById(2131367051));
    this.k = ((TextView)paramView.findViewById(2131367053));
    if (Aladdin.getConfig(327).getIntegerFromString("is_show_your_follow", 0) == 1) {
      this.j = ((TextView)paramView.findViewById(2131380571));
    }
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
    if (this.o != null) {
      rwv.a(this.o);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvs
 * JD-Core Version:    0.7.0.1
 */