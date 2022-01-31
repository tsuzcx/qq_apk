import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class miq
  extends AnimateUtils.AnimationAdapter
{
  public miq(ReadinjoyTabFrame paramReadinjoyTabFrame, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(1.05F, 0.72F, 1.05F, 0.72F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(170L);
    paramAnimation.setAnimationListener(new mir(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     miq
 * JD-Core Version:    0.7.0.1
 */