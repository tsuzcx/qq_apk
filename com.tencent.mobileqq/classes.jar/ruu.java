import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class ruu
  extends AnimatorListenerAdapter
{
  ruu(rup paramrup) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (rup.a(this.a).x != null) {
      rup.a(this.a).x.setTag(2131362696, null);
    }
    if (rup.a(this.a) != null) {
      rup.a(this.a).b(rup.a(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (rup.a(this.a) != null)
    {
      paramAnimator = rup.a(this.a).a();
      rup.a(this.a, rup.a(this.a).h, paramAnimator, rup.a(this.a), 18, -1);
    }
    if (rup.a(this.a).x != null) {
      rup.a(this.a).x.setTag(2131362696, null);
    }
    if (rup.a(this.a) != null) {
      rup.a(this.a).c(rup.a(this.a));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (rup.a(this.a) != null) {
      rup.a(this.a).a(rup.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruu
 * JD-Core Version:    0.7.0.1
 */