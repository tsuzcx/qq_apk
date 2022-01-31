import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;

public class otu
  implements Animation.AnimationListener
{
  public otu(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.getView().setVisibility(8);
    this.a.getActivity().setResult(-1);
    this.a.getActivity().finish();
    this.a.getActivity().overridePendingTransition(0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otu
 * JD-Core Version:    0.7.0.1
 */