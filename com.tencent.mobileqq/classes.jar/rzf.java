import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class rzf
  extends AnimatorListenerAdapter
{
  rzf(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzf
 * JD-Core Version:    0.7.0.1
 */