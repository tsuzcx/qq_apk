import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class rea
  extends AnimatorListenerAdapter
{
  rea(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setAlpha(1.0F);
    this.a.setLayerType(0, null);
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rea
 * JD-Core Version:    0.7.0.1
 */