import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

final class qoo
  implements ValueAnimator.AnimatorUpdateListener
{
  qoo(int paramInt1, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt2, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(paramValueAnimator.getAnimatedFraction() * this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams.bottomMargin = (i + this.b);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qoo
 * JD-Core Version:    0.7.0.1
 */