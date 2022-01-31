import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class szv
  implements Animation.AnimationListener
{
  public szv(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginInfoActivity.b(this.a).setVisibility(4);
    LoginInfoActivity.b(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szv
 * JD-Core Version:    0.7.0.1
 */