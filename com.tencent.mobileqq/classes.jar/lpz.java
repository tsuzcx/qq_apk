import android.view.View;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;

public class lpz
  implements ValueAnimator.AnimatorUpdateListener
{
  public lpz(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setScaleX(f);
    this.jdField_a_of_type_AndroidViewView.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpz
 * JD-Core Version:    0.7.0.1
 */