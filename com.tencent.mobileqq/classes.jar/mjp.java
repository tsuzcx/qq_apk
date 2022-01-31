import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;

public class mjp
  implements Animation.AnimationListener
{
  public mjp(ReadinjoyTabFrame paramReadinjoyTabFrame, View paramView, Context paramContext) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(150L);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
    }
    paramAnimation.setAnimationListener(new mjq(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjp
 * JD-Core Version:    0.7.0.1
 */