import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLImageView;

public class pin
  extends pij
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
  
  pin(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378936));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131378647);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new bjfa(Color.parseColor("#D9D9D8"), 0));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365145));
    this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371928);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371926));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371912));
    this.e = ((TextView)paramView.findViewById(2131371932));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131371813));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing = ((HeadImageWithRing)paramView.findViewById(2131368912));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setAttrs(agej.a(0.5F, paramReadInJoyPicWaterFallFragment.getResources()), Color.parseColor("#0c000000"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setDrawRing(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setCorner(agej.a(12.0F, paramReadInJoyPicWaterFallFragment.getResources()) / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369926));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379990));
    this.d = ((TextView)paramView.findViewById(2131379222));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379210);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new bjfa(Color.parseColor("#D9D9D8"), 0));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379205));
    paramView.setOnClickListener(new pio(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new pip(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new piq(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pin
 * JD-Core Version:    0.7.0.1
 */