import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.component.media.image.view.ExtendImageView;

public class piu
  implements Animation.AnimationListener
{
  public piu(ExtendImageView paramExtendImageView, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     piu
 * JD-Core Version:    0.7.0.1
 */