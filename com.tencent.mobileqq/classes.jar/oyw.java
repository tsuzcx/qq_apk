import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.qphone.base.util.QLog;

public class oyw
  implements Animation.AnimationListener
{
  public oyw(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(this.a.a);
    QLog.d(ReadInJoyAtlasCommentFragment.a(), 1, "fragment show info");
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    QLog.d(ReadInJoyAtlasCommentFragment.a(), 1, "fragment Repeat animation");
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.d(ReadInJoyAtlasCommentFragment.a(), 1, "fragment start animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oyw
 * JD-Core Version:    0.7.0.1
 */