import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class osi
  implements ValueAnimator.AnimatorUpdateListener
{
  osi(osg paramosg, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    osg.a(this.jdField_a_of_type_Osg, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    osg.a(this.jdField_a_of_type_Osg, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, osg.a(this.jdField_a_of_type_Osg));
    osg.a(this.jdField_a_of_type_Osg, osg.a(this.jdField_a_of_type_Osg), f, 0.2F, 1.7F, afur.a(34.0F, osg.a(this.jdField_a_of_type_Osg).getResources()));
    osg.a(this.jdField_a_of_type_Osg, osg.b(this.jdField_a_of_type_Osg), f, 0.2F, 2.0F, afur.a(34.0F, osg.a(this.jdField_a_of_type_Osg).getResources()));
    osg.a(this.jdField_a_of_type_Osg, osg.c(this.jdField_a_of_type_Osg), f, 0.2F, 2.0F, afur.a(34.0F, osg.a(this.jdField_a_of_type_Osg).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osi
 * JD-Core Version:    0.7.0.1
 */