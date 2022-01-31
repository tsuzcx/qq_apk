import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class mkc
  implements Animation.AnimationListener
{
  mkc(mkb parammkb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationEnd");
    }
    try
    {
      if (this.a.a != null) {
        this.a.a.b();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationEnd Exception :" + paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationStart");
    }
    try
    {
      if (this.a.a != null) {
        this.a.a.a();
      }
      return;
    }
    catch (Exception paramAnimation)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationStart Exception :" + paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mkc
 * JD-Core Version:    0.7.0.1
 */