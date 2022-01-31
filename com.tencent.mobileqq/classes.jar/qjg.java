import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

class qjg
  extends AnimatorListenerAdapter
{
  qjg(qjf paramqjf) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((qjf.a(this.a) != null) && (qjf.a(this.a).h != null))
    {
      qjf.a(this.a).h.setVisibility(0);
      paramAnimator = new AnimatorSet();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(qjf.a(this.a).h, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(200L);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(qjf.a(this.a).h, "translationY", new float[] { actj.a(15.0F, qjf.a(this.a).h.getResources()), 0.0F });
      localObjectAnimator2.setDuration(200L);
      localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
      paramAnimator.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      paramAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjg
 * JD-Core Version:    0.7.0.1
 */