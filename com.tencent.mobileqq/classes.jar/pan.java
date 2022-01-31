import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.biz.webviewplugin.PubAccountUIPlugin;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class pan
  implements Animation.AnimationListener
{
  public pan(PubAccountUIPlugin paramPubAccountUIPlugin, URLImageView paramURLImageView, URLDrawable paramURLDrawable, ScaleAnimation paramScaleAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pan
 * JD-Core Version:    0.7.0.1
 */