import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;

public class oqh
  implements Animation.AnimationListener
{
  public oqh(StoryNewGuideDialog paramStoryNewGuideDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqh
 * JD-Core Version:    0.7.0.1
 */