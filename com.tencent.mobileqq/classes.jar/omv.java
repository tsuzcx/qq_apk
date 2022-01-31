import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo2.StoryMultiFragmentPart;

public class omv
  implements Animation.AnimationListener
{
  public omv(StoryMultiFragmentPart paramStoryMultiFragmentPart) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (StoryMultiFragmentPart.b(this.a) != null) {
      StoryMultiFragmentPart.b(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omv
 * JD-Core Version:    0.7.0.1
 */