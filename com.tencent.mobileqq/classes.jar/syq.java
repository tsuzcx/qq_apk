import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

public class syq
  implements ValueAnimator.AnimatorUpdateListener
{
  public syq(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syq
 * JD-Core Version:    0.7.0.1
 */