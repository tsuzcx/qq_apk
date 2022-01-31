import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView;

public class ptt
  implements ValueAnimator.AnimatorUpdateListener
{
  public ptt(ProteusRecycleView paramProteusRecycleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setPadding(0, 0, (int)ProteusRecycleView.a(this.a).a(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ptt
 * JD-Core Version:    0.7.0.1
 */