import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class szt
  implements Animation.AnimationListener
{
  public szt(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginInfoActivity.a(this.a).setVisibility(4);
    LoginInfoActivity.a(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szt
 * JD-Core Version:    0.7.0.1
 */