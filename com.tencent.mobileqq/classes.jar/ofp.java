import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class ofp
  implements ValueAnimator.AnimatorUpdateListener
{
  ofp(ofn paramofn, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    ofn.a(this.jdField_a_of_type_Ofn, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    ofn.a(this.jdField_a_of_type_Ofn, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, ofn.a(this.jdField_a_of_type_Ofn));
    ofn.a(this.jdField_a_of_type_Ofn, ofn.a(this.jdField_a_of_type_Ofn), f, 0.2F, 1.7F, aepi.a(34.0F, ofn.a(this.jdField_a_of_type_Ofn).getResources()));
    ofn.a(this.jdField_a_of_type_Ofn, ofn.b(this.jdField_a_of_type_Ofn), f, 0.2F, 2.0F, aepi.a(34.0F, ofn.a(this.jdField_a_of_type_Ofn).getResources()));
    ofn.a(this.jdField_a_of_type_Ofn, ofn.c(this.jdField_a_of_type_Ofn), f, 0.2F, 2.0F, aepi.a(34.0F, ofn.a(this.jdField_a_of_type_Ofn).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofp
 * JD-Core Version:    0.7.0.1
 */