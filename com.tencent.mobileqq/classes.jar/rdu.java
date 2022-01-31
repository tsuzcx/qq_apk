import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

final class rdu
  implements ValueAnimator.AnimatorUpdateListener
{
  rdu(ViewGroup paramViewGroup, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.width = (this.jdField_a_of_type_Int + paramValueAnimator.x);
    int i = this.b;
    localLayoutParams.height = (paramValueAnimator.y + i);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdu
 * JD-Core Version:    0.7.0.1
 */