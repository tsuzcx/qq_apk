import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class pyr
  extends pyt
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  pyr(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.b = ((URLImageView)paramView.findViewById(2131365257));
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362681));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
    AIOUtils.dp2px(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362005));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
    paramView.setOnClickListener(new pys(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyr
 * JD-Core Version:    0.7.0.1
 */