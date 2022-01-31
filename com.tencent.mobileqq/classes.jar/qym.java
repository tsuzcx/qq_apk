import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class qym
  extends bfmg
{
  qym(qyj paramqyj, AlphaAnimation paramAlphaAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoEndSoon appearAnim onAnimationEnd: ");
    }
    this.jdField_a_of_type_Qyj.a.a.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qym
 * JD-Core Version:    0.7.0.1
 */