import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class qtc
  extends AnimatorListenerAdapter
{
  qtc(qsx paramqsx) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (qsx.a(this.a).t != null) {
      qsx.a(this.a).t.setTag(2131362551, null);
    }
    if (qsx.a(this.a) != null) {
      qsx.a(this.a).b(qsx.a(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (qsx.a(this.a) != null)
    {
      paramAnimator = qsx.a(this.a).a();
      qsx.a(this.a, qsx.a(this.a).g, paramAnimator, qsx.a(this.a), 18, -1);
    }
    if (qsx.a(this.a).t != null) {
      qsx.a(this.a).t.setTag(2131362551, null);
    }
    if (qsx.a(this.a) != null) {
      qsx.a(this.a).c(qsx.a(this.a));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (qsx.a(this.a) != null) {
      qsx.a(this.a).a(qsx.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtc
 * JD-Core Version:    0.7.0.1
 */