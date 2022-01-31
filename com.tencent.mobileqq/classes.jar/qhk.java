import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;

public class qhk
  implements ValueAnimator.AnimatorUpdateListener
{
  public qhk(RIJRedPacketProgressView paramRIJRedPacketProgressView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setScaleX(f);
    this.jdField_a_of_type_AndroidViewView.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qhk
 * JD-Core Version:    0.7.0.1
 */