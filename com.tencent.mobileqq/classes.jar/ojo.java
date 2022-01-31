import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.takevideo.EditVideoGuide;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class ojo
  implements Animation.AnimationListener
{
  public ojo(EditVideoGuide paramEditVideoGuide) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.h();
    this.a.a.a(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojo
 * JD-Core Version:    0.7.0.1
 */