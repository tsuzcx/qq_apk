import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView;

public class qeh
  implements ValueAnimator.AnimatorUpdateListener
{
  public qeh(ProteusRecycleView paramProteusRecycleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setPadding(0, 0, (int)ProteusRecycleView.a(this.a).a(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qeh
 * JD-Core Version:    0.7.0.1
 */