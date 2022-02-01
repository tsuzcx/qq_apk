import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class pyx
  extends pyt
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HeadImageWithRing jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  TextView e;
  
  pyx(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131378702);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new bivw(Color.parseColor("#D9D9D8"), 0));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365257));
    this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372085);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372083));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372069));
    this.e = ((TextView)paramView.findViewById(2131372089));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131371966));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing = ((HeadImageWithRing)paramView.findViewById(2131369099));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setAttrs(AIOUtils.dp2px(0.5F, paramReadInJoyPicWaterFallFragment.getResources()), Color.parseColor("#0c000000"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setDrawRing(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setCorner(AIOUtils.dp2px(12.0F, paramReadInJoyPicWaterFallFragment.getResources()) / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370090));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380073));
    this.d = ((TextView)paramView.findViewById(2131379285));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379273);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new bivw(Color.parseColor("#D9D9D8"), 0));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379268));
    paramView.setOnClickListener(new pyy(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new pyz(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new pza(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyx
 * JD-Core Version:    0.7.0.1
 */