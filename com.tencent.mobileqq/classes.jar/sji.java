import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class sji
  extends AnimatorListenerAdapter
{
  sji(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sji
 * JD-Core Version:    0.7.0.1
 */