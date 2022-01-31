import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class obx
  implements ValueAnimator.AnimatorUpdateListener
{
  obx(obv paramobv, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    obv.a(this.jdField_a_of_type_Obv, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    obv.a(this.jdField_a_of_type_Obv, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, obv.a(this.jdField_a_of_type_Obv));
    obv.a(this.jdField_a_of_type_Obv, obv.a(this.jdField_a_of_type_Obv), f, 0.2F, 1.7F, actj.a(34.0F, obv.a(this.jdField_a_of_type_Obv).getResources()));
    obv.a(this.jdField_a_of_type_Obv, obv.b(this.jdField_a_of_type_Obv), f, 0.2F, 2.0F, actj.a(34.0F, obv.a(this.jdField_a_of_type_Obv).getResources()));
    obv.a(this.jdField_a_of_type_Obv, obv.c(this.jdField_a_of_type_Obv), f, 0.2F, 2.0F, actj.a(34.0F, obv.a(this.jdField_a_of_type_Obv).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obx
 * JD-Core Version:    0.7.0.1
 */