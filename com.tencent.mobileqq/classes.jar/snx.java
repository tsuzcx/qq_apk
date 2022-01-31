import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class snx
  implements ValueAnimator.AnimatorUpdateListener
{
  snx(snw paramsnw, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("txtAlpha")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("redAlpha")).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(f1);
    this.b.setAlpha(f2);
    this.c.setAlpha(f2);
    this.d.setAlpha(1.0F);
    this.e.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snx
 * JD-Core Version:    0.7.0.1
 */