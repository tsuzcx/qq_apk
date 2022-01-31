import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class rdz
  extends AnimatorListenerAdapter
{
  rdz(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdz
 * JD-Core Version:    0.7.0.1
 */