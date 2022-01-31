import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo2.StoryMultiFragmentPart;

class ork
  implements Animator.AnimatorListener
{
  ork(ori paramori) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((StoryMultiFragmentPart.a(this.a.a) != null) && (StoryMultiFragmentPart.b(this.a.a) != null) && (StoryMultiFragmentPart.a(this.a.a) != null))
    {
      StoryMultiFragmentPart.a(this.a.a).setVisibility(8);
      StoryMultiFragmentPart.b(this.a.a).setImageBitmap(this.a.b);
      StoryMultiFragmentPart.b(this.a.a).setVisibility(0);
      StoryMultiFragmentPart.a(this.a.a).setText(StoryMultiFragmentPart.a(this.a.a) + "");
      StoryMultiFragmentPart.a(this.a.a).setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ork
 * JD-Core Version:    0.7.0.1
 */