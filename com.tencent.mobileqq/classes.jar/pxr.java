import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.qphone.base.util.QLog;

public class pxr
  implements Animation.AnimationListener
{
  public pxr(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxr
 * JD-Core Version:    0.7.0.1
 */