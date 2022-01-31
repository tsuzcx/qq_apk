import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.FullScreenTopContainerHolder;

public class kpk
  implements Animation.AnimationListener
{
  public kpk(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AccountDetailBaseAdapter.a(this.a, this.a.a.c, this.a.a.d, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpk
 * JD-Core Version:    0.7.0.1
 */