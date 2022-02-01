import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;

public class qbn
  implements Animator.AnimatorListener
{
  public qbn(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    pvm.a().a(null, 110, true, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    pvm.a().a(null, 110, true, null);
    if (ReadInjoyIMAXAdFragment.a(this.a) != null)
    {
      ReadInjoyIMAXAdFragment.a(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.b(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.c(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.b(this.a).setVisibility(0);
      if (ReadInjoyIMAXAdFragment.e(this.a) != 1001) {
        break label90;
      }
      ReadInjoyIMAXAdFragment.c(this.a).setVisibility(0);
    }
    label90:
    while (ReadInjoyIMAXAdFragment.e(this.a) != 1002) {
      return;
    }
    ReadInjoyIMAXAdFragment.c(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    pvm.a().a(null, 110, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbn
 * JD-Core Version:    0.7.0.1
 */