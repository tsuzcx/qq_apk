import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class sby
  extends AnimatorListenerAdapter
{
  sby(sbt paramsbt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (sbt.a(this.a).y != null) {
      sbt.a(this.a).y.setTag(2131362701, null);
    }
    if (sbt.a(this.a) != null) {
      sbt.a(this.a).b(sbt.a(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (sbt.a(this.a) != null)
    {
      paramAnimator = sbt.a(this.a).a();
      sbt.a(this.a, sbt.a(this.a).h, paramAnimator, sbt.a(this.a), 18, -1);
    }
    if (sbt.a(this.a).y != null) {
      sbt.a(this.a).y.setTag(2131362701, null);
    }
    if (sbt.a(this.a) != null) {
      sbt.a(this.a).c(sbt.a(this.a));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (sbt.a(this.a) != null) {
      sbt.a(this.a).a(sbt.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sby
 * JD-Core Version:    0.7.0.1
 */