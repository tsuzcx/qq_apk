import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.widget.HorizontalListView;

public class pas
  extends AnimatorListenerAdapter
{
  public pas(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoySelfFragment.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pas
 * JD-Core Version:    0.7.0.1
 */