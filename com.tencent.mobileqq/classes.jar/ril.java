import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class ril
  extends AnimatorListenerAdapter
{
  ril(rig paramrig) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (rig.a(this.a).u != null) {
      rig.a(this.a).u.setTag(2131362578, null);
    }
    if (rig.a(this.a) != null) {
      rig.a(this.a).b(rig.a(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (rig.a(this.a) != null)
    {
      paramAnimator = rig.a(this.a).a();
      rig.a(this.a, rig.a(this.a).h, paramAnimator, rig.a(this.a), 18, -1);
    }
    if (rig.a(this.a).u != null) {
      rig.a(this.a).u.setTag(2131362578, null);
    }
    if (rig.a(this.a) != null) {
      rig.a(this.a).c(rig.a(this.a));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (rig.a(this.a) != null) {
      rig.a(this.a).a(rig.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ril
 * JD-Core Version:    0.7.0.1
 */