import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

class mgk
  implements Animator.AnimatorListener
{
  mgk(mgi parammgi, int paramInt, long paramLong) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 4;
    if (this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      i = this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
      if (this.jdField_a_of_type_Mgi.jdField_a_of_type_Boolean) {
        break label173;
      }
      this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
      this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout.setTranslationY(0.0F);
      QLog.w(this.jdField_a_of_type_Mgi.jdField_a_of_type_JavaLangString, 1, "ShowMenuView, onAnimationEnd, isShow[" + this.jdField_a_of_type_Mgi.jdField_a_of_type_Boolean + "], visibility[" + i + "], seq[" + this.jdField_a_of_type_Long + "], \nlastObjectAnimator[" + this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidAnimationObjectAnimator + "], \nanimation[" + paramAnimator + "]");
      if (this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidAnimationObjectAnimator == paramAnimator) {
        this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
      }
      return;
      label173:
      this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_Mgi.jdField_a_of_type_Mgl != null) {
        this.jdField_a_of_type_Mgi.jdField_a_of_type_Mgl.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i = 4;
    if (this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      i = this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
      this.jdField_a_of_type_Mgi.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    QLog.w(this.jdField_a_of_type_Mgi.jdField_a_of_type_JavaLangString, 1, "ShowMenuView, onAnimationStart, height[" + this.jdField_a_of_type_Int + "], isShow[" + this.jdField_a_of_type_Mgi.jdField_a_of_type_Boolean + "], visibility[" + i + "], seq[" + this.jdField_a_of_type_Long + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgk
 * JD-Core Version:    0.7.0.1
 */