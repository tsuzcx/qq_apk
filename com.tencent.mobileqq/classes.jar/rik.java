import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLImageView;

class rik
  implements ValueAnimator.AnimatorUpdateListener
{
  rik(rig paramrig, LinearLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ViewGroup.LayoutParams paramLayoutParams1, int paramInt5, int paramInt6, int paramInt7, ViewGroup.LayoutParams paramLayoutParams2, int paramInt8, int paramInt9) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.width = (this.jdField_a_of_type_Int + (int)(paramValueAnimator.getAnimatedFraction() * this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.height = (this.c + (int)(paramValueAnimator.getAnimatedFraction() * this.d));
    rig.a(this.jdField_a_of_type_Rig).u.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = (this.e + (int)(paramValueAnimator.getAnimatedFraction() * this.f));
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = (this.g + (int)(paramValueAnimator.getAnimatedFraction() * this.f));
    rig.a(this.jdField_a_of_type_Rig).h.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams.width = (this.h + (int)(paramValueAnimator.getAnimatedFraction() * this.i));
    rig.a(this.jdField_a_of_type_Rig).v.setLayoutParams(this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rik
 * JD-Core Version:    0.7.0.1
 */