import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.widget.HorizontalListView;

public class pba
  implements Animation.AnimationListener
{
  public pba(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoySelfFragment.a(this.a).setVisibility(8);
    ReadInJoySelfFragment.b(this.a).setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pba
 * JD-Core Version:    0.7.0.1
 */