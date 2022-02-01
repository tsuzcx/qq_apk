import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class sdz
  extends AnimatorListenerAdapter
{
  sdz(sdu paramsdu) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (sdu.a(this.a).y != null) {
      sdu.a(this.a).y.setTag(2131362680, null);
    }
    if (sdu.a(this.a) != null) {
      sdu.a(this.a).b(sdu.a(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (sdu.a(this.a) != null)
    {
      paramAnimator = sdu.a(this.a).a();
      sdu.a(this.a, sdu.a(this.a).h, paramAnimator, sdu.a(this.a), 18, -1);
    }
    if (sdu.a(this.a).y != null) {
      sdu.a(this.a).y.setTag(2131362680, null);
    }
    if (sdu.a(this.a) != null) {
      sdu.a(this.a).c(sdu.a(this.a));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (sdu.a(this.a) != null) {
      sdu.a(this.a).a(sdu.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdz
 * JD-Core Version:    0.7.0.1
 */