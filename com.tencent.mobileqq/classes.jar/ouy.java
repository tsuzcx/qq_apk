import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLImageView;

public class ouy
  extends ouu
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
  
  ouy(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131377074);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new bctm(Color.parseColor("#D9D9D8"), 0));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364783));
    this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370927);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370925));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370911));
    this.e = ((TextView)paramView.findViewById(2131370931));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131370816));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing = ((HeadImageWithRing)paramView.findViewById(2131368334));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setAttrs(actj.a(0.5F, paramReadInJoyPicWaterFallFragment.getResources()), Color.parseColor("#0c000000"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setDrawRing(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setCorner(actj.a(12.0F, paramReadInJoyPicWaterFallFragment.getResources()) / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369184));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378283));
    this.d = ((TextView)paramView.findViewById(2131377610));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377602);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new bctm(Color.parseColor("#D9D9D8"), 0));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377598));
    paramView.setOnClickListener(new ouz(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ova(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ovb(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouy
 * JD-Core Version:    0.7.0.1
 */