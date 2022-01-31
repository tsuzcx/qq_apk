import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.view.widget.StoryAddDescribeGuideDialog;

public class ovy
  implements Animation.AnimationListener
{
  public ovy(StoryAddDescribeGuideDialog paramStoryAddDescribeGuideDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovy
 * JD-Core Version:    0.7.0.1
 */