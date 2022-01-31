import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.ui.CustomAnimationAdapter;

public class ozr
  implements ValueAnimator.AnimatorUpdateListener
{
  public ozr(CustomAnimationAdapter paramCustomAnimationAdapter, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      ((LinearLayout.LayoutParams)localLayoutParams).topMargin = paramValueAnimator.intValue();
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozr
 * JD-Core Version:    0.7.0.1
 */