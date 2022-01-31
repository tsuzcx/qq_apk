import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.image.URLImageView;

public class ojj
  extends ojl
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  ojj(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.b = ((URLImageView)paramView.findViewById(2131299221));
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296985));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
    aciy.a(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296410));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311534));
    paramView.setOnClickListener(new ojk(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojj
 * JD-Core Version:    0.7.0.1
 */