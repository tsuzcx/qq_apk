import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class qlb
  implements Animation.AnimationListener
{
  qlb(qla paramqla, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (qla.a(this.jdField_a_of_type_Qla) != null) {
      qla.a(this.jdField_a_of_type_Qla).setImageDrawable(this.jdField_a_of_type_Qla.a(qla.a(this.jdField_a_of_type_Qla, this.jdField_a_of_type_Boolean)));
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlb
 * JD-Core Version:    0.7.0.1
 */