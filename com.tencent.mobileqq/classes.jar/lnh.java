import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;

public class lnh
  implements Animator.AnimatorListener
{
  public lnh(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyAtlasFragment.a(this.a, false);
    if (ReadInJoyAtlasFragment.a(this.a) != null)
    {
      ReadInJoyAtlasFragment.b(this.a, true);
      ReadInJoyAtlasFragment.a(this.a).finish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyAtlasFragment.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnh
 * JD-Core Version:    0.7.0.1
 */