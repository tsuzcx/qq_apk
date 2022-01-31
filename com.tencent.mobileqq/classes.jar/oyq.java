import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class oyq
  implements Animation.AnimationListener
{
  oyq(oyp paramoyp, ImageView paramImageView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(oyp.a(this.jdField_a_of_type_Oyp, this.jdField_a_of_type_Boolean));
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyq
 * JD-Core Version:    0.7.0.1
 */