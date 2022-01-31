import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.widget.HorizontalListView;

public class lgr
  implements Animation.AnimationListener
{
  public lgr(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoySelfActivity.a(this.a).setVisibility(8);
    ReadInJoySelfActivity.a(this.a).setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgr
 * JD-Core Version:    0.7.0.1
 */