import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

final class rdv
  implements ValueAnimator.AnimatorUpdateListener
{
  rdv(WindowManager paramWindowManager, ViewGroup paramViewGroup, WindowManager.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((this.jdField_a_of_type_AndroidViewWindowManager == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {
      return;
    }
    paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramValueAnimator.y;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramValueAnimator.x;
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdv
 * JD-Core Version:    0.7.0.1
 */