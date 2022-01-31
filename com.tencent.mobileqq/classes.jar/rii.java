import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

class rii
  implements ValueAnimator.AnimatorUpdateListener
{
  rii(rig paramrig, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.bottomMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!this.b) {
        break label63;
      }
      rig.a(this.jdField_a_of_type_Rig).w.setVisibility(0);
    }
    for (;;)
    {
      rig.a(this.jdField_a_of_type_Rig).u.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      return;
      label63:
      rig.a(this.jdField_a_of_type_Rig).v.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rii
 * JD-Core Version:    0.7.0.1
 */