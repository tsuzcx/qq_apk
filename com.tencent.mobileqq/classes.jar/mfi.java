import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.TabHolder;
import com.tencent.qphone.base.util.QLog;

public class mfi
  implements Animator.AnimatorListener
{
  public mfi(BaseTabbar.TabHolder paramTabHolder) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.d("TabBarView", 4, "onAnimationEnd");
    BaseTabbar.TabHolder.b(this.a);
    this.a.b.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfi
 * JD-Core Version:    0.7.0.1
 */