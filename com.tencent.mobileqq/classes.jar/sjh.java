import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

public class sjh
  extends AnimatorListenerAdapter
{
  public sjh(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a, false);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a, true);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sjh
 * JD-Core Version:    0.7.0.1
 */