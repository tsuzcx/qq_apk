import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;

public class qxk
  implements ValueAnimator.AnimatorUpdateListener
{
  public qxk(ProteusAnimationItemData paramProteusAnimationItemData) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ProteusAnimationItemData.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if (ProteusAnimationItemData.a(this.a).getLayoutParams() != null) {
      ProteusAnimationItemData.a(this.a).getLayoutParams().height = ProteusAnimationItemData.a(this.a);
    }
    ProteusAnimationItemData.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxk
 * JD-Core Version:    0.7.0.1
 */