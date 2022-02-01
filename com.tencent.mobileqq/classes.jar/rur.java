import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

class rur
  implements ValueAnimator.AnimatorUpdateListener
{
  rur(rup paramrup, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.bottomMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!this.b) {
        break label63;
      }
      rup.a(this.jdField_a_of_type_Rup).z.setVisibility(0);
    }
    for (;;)
    {
      rup.a(this.jdField_a_of_type_Rup).x.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      return;
      label63:
      rup.a(this.jdField_a_of_type_Rup).y.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rur
 * JD-Core Version:    0.7.0.1
 */