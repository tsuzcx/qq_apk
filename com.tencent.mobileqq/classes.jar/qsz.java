import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

class qsz
  implements ValueAnimator.AnimatorUpdateListener
{
  qsz(qsx paramqsx, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.bottomMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!this.b) {
        break label63;
      }
      qsx.a(this.jdField_a_of_type_Qsx).v.setVisibility(0);
    }
    for (;;)
    {
      qsx.a(this.jdField_a_of_type_Qsx).t.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      return;
      label63:
      qsx.a(this.jdField_a_of_type_Qsx).u.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsz
 * JD-Core Version:    0.7.0.1
 */