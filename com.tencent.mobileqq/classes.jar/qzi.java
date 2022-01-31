import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class qzi
  implements Animator.AnimatorListener
{
  qzi(qzg paramqzg) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.d("TabBarView", 4, "onAnimationEnd");
    qzg.b(this.a);
    this.a.b.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzi
 * JD-Core Version:    0.7.0.1
 */