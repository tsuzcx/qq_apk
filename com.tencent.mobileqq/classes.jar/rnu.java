import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class rnu
  extends bhnr
{
  rnu(rnr paramrnr, AlphaAnimation paramAlphaAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoEndSoon appearAnim onAnimationEnd: ");
    }
    this.jdField_a_of_type_Rnr.a.a.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rnu
 * JD-Core Version:    0.7.0.1
 */