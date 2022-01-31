import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class qxd
  implements Animation.AnimationListener
{
  qxd(qxc paramqxc, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (qxc.a(this.jdField_a_of_type_Qxc) != null) {
      qxc.a(this.jdField_a_of_type_Qxc).setImageDrawable(this.jdField_a_of_type_Qxc.a(qxc.a(this.jdField_a_of_type_Qxc, this.jdField_a_of_type_Boolean)));
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxd
 * JD-Core Version:    0.7.0.1
 */