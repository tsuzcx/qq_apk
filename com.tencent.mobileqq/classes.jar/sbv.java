import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

class sbv
  implements ValueAnimator.AnimatorUpdateListener
{
  sbv(sbt paramsbt, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.bottomMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!this.b) {
        break label63;
      }
      sbt.a(this.jdField_a_of_type_Sbt).A.setVisibility(0);
    }
    for (;;)
    {
      sbt.a(this.jdField_a_of_type_Sbt).y.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      return;
      label63:
      sbt.a(this.jdField_a_of_type_Sbt).z.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbv
 * JD-Core Version:    0.7.0.1
 */