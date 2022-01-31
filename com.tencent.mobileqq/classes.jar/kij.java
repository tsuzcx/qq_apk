import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

class kij
  implements Runnable
{
  kij(kii paramkii) {}
  
  public void run()
  {
    Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localRotate3dAnimation.setDuration(500L);
    localRotate3dAnimation.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotate3dAnimation);
    localRotate3dAnimation.setAnimationListener(new kik(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kij
 * JD-Core Version:    0.7.0.1
 */