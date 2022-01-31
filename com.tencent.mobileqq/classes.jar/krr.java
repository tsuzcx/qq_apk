import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.FullScreenTopContainerHolder;

public class krr
  implements Animation.AnimationListener
{
  public krr(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AccountDetailBaseAdapter.a(this.a, this.a.a.c, this.a.a.d, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     krr
 * JD-Core Version:    0.7.0.1
 */