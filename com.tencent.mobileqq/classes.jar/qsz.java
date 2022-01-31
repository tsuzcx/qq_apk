import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class qsz
  extends AnimatorListenerAdapter
{
  qsz(qsu paramqsu) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (qsu.a(this.a).t != null) {
      qsu.a(this.a).t.setTag(2131362550, null);
    }
    if (qsu.a(this.a) != null) {
      qsu.a(this.a).b(qsu.a(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (qsu.a(this.a) != null)
    {
      paramAnimator = qsu.a(this.a).a();
      qsu.a(this.a, qsu.a(this.a).g, paramAnimator, qsu.a(this.a), 18, -1);
    }
    if (qsu.a(this.a).t != null) {
      qsu.a(this.a).t.setTag(2131362550, null);
    }
    if (qsu.a(this.a) != null) {
      qsu.a(this.a).c(qsu.a(this.a));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (qsu.a(this.a) != null) {
      qsu.a(this.a).a(qsu.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsz
 * JD-Core Version:    0.7.0.1
 */