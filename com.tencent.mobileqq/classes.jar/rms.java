import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class rms
  implements Animation.AnimationListener
{
  rms(rmr paramrmr, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (rmr.a(this.jdField_a_of_type_Rmr) != null) {
      rmr.a(this.jdField_a_of_type_Rmr).setImageDrawable(this.jdField_a_of_type_Rmr.a(rmr.a(this.jdField_a_of_type_Rmr, this.jdField_a_of_type_Boolean)));
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rms
 * JD-Core Version:    0.7.0.1
 */