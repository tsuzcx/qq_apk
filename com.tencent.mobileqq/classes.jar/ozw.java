import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.image.URLImageView;

public class ozw
  extends ozy
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  ozw(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.b = ((URLImageView)paramView.findViewById(2131364866));
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362551));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
    aepi.a(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361947));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377938));
    paramView.setOnClickListener(new ozx(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ozw
 * JD-Core Version:    0.7.0.1
 */