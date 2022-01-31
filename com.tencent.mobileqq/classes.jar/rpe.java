import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;

class rpe
  implements ValueAnimator.AnimatorUpdateListener
{
  rpe(rpd paramrpd, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setX(f);
    CaptureOperateTouchLayout.a(this.jdField_a_of_type_Rpd.a).setX(f + this.jdField_a_of_type_AndroidViewView.getWidth() * 0.32F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rpe
 * JD-Core Version:    0.7.0.1
 */