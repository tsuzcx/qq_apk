import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class nqr
  implements ValueAnimator.AnimatorUpdateListener
{
  nqr(nqp paramnqp, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    nqp.a(this.jdField_a_of_type_Nqp, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    nqp.a(this.jdField_a_of_type_Nqp, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, nqp.a(this.jdField_a_of_type_Nqp));
    nqp.a(this.jdField_a_of_type_Nqp, nqp.a(this.jdField_a_of_type_Nqp), f, 0.2F, 1.7F, aciy.a(34.0F, nqp.a(this.jdField_a_of_type_Nqp).getResources()));
    nqp.a(this.jdField_a_of_type_Nqp, nqp.b(this.jdField_a_of_type_Nqp), f, 0.2F, 2.0F, aciy.a(34.0F, nqp.a(this.jdField_a_of_type_Nqp).getResources()));
    nqp.a(this.jdField_a_of_type_Nqp, nqp.c(this.jdField_a_of_type_Nqp), f, 0.2F, 2.0F, aciy.a(34.0F, nqp.a(this.jdField_a_of_type_Nqp).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqr
 * JD-Core Version:    0.7.0.1
 */