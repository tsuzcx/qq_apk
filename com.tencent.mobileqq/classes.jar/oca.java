import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class oca
  implements ValueAnimator.AnimatorUpdateListener
{
  oca(oby paramoby, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    oby.a(this.jdField_a_of_type_Oby, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    oby.a(this.jdField_a_of_type_Oby, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, oby.a(this.jdField_a_of_type_Oby));
    oby.a(this.jdField_a_of_type_Oby, oby.a(this.jdField_a_of_type_Oby), f, 0.2F, 1.7F, actn.a(34.0F, oby.a(this.jdField_a_of_type_Oby).getResources()));
    oby.a(this.jdField_a_of_type_Oby, oby.b(this.jdField_a_of_type_Oby), f, 0.2F, 2.0F, actn.a(34.0F, oby.a(this.jdField_a_of_type_Oby).getResources()));
    oby.a(this.jdField_a_of_type_Oby, oby.c(this.jdField_a_of_type_Oby), f, 0.2F, 2.0F, actn.a(34.0F, oby.a(this.jdField_a_of_type_Oby).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oca
 * JD-Core Version:    0.7.0.1
 */