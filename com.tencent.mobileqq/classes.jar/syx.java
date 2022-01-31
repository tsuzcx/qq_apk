import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class syx
  implements Animation.AnimationListener
{
  public syx(LebaQZoneFacePlayHelper paramLebaQZoneFacePlayHelper) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((LebaQZoneFacePlayHelper.a(this.a) != null) && (LebaQZoneFacePlayHelper.a(this.a).size() >= 2)) {
      LebaQZoneFacePlayHelper.a(this.a).sendEmptyMessageDelayed(1688002, 1000L);
    }
    if (LebaQZoneFacePlayHelper.a(this.a) != null)
    {
      LebaQZoneFacePlayHelper.a(this.a).a();
      LebaQZoneFacePlayHelper.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syx
 * JD-Core Version:    0.7.0.1
 */