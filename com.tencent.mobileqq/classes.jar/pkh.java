import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.widget.HorizontalListView;

public class pkh
  implements Animation.AnimationListener
{
  public pkh(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoySelfFragment.a(this.a).setVisibility(8);
    ReadInJoySelfFragment.b(this.a).setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pkh
 * JD-Core Version:    0.7.0.1
 */