import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class qgy
  extends AnimatorListenerAdapter
{
  qgy(qgw paramqgw) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (qgw.a(this.a).u != null) {
      qgw.a(this.a).u.setTag(2131297012, null);
    }
    if (qgw.a(this.a) != null) {
      qgw.a(this.a).b(qgw.a(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (qgw.a(this.a) != null)
    {
      paramAnimator = qgw.a(this.a).a();
      qgw.a(this.a, qgw.a(this.a), paramAnimator, qgw.a(this.a), 18);
    }
    if (qgw.a(this.a).u != null) {
      qgw.a(this.a).u.setTag(2131297012, null);
    }
    if (qgw.a(this.a) != null) {
      qgw.a(this.a).c(qgw.a(this.a));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (qgw.a(this.a) != null) {
      qgw.a(this.a).a(qgw.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgy
 * JD-Core Version:    0.7.0.1
 */