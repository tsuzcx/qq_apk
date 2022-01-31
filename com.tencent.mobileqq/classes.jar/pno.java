import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView;

public class pno
  implements ValueAnimator.AnimatorUpdateListener
{
  public pno(ProteusRecycleView paramProteusRecycleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setPadding(0, 0, (int)ProteusRecycleView.a(this.a).a(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pno
 * JD-Core Version:    0.7.0.1
 */