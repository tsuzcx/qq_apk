import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class qou
  extends AnimatorListenerAdapter
{
  qou(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
    this.a.setVisibility(8);
    this.a.setTranslationY(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qou
 * JD-Core Version:    0.7.0.1
 */