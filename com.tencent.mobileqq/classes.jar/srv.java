import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class srv
  implements Animation.AnimationListener
{
  public srv(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.f = false;
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srv
 * JD-Core Version:    0.7.0.1
 */