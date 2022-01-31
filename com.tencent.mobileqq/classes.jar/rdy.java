import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class rdy
  extends AnimatorListenerAdapter
{
  rdy(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
    this.a.setVisibility(8);
    this.a.setTranslationY(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdy
 * JD-Core Version:    0.7.0.1
 */