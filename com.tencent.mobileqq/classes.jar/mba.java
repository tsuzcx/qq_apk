import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class mba
  extends AnimatorListenerAdapter
{
  public mba(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mba
 * JD-Core Version:    0.7.0.1
 */