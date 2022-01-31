import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class onb
  implements Animation.AnimationListener
{
  onb(ona paramona, ImageView paramImageView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(ona.a(this.jdField_a_of_type_Ona, this.jdField_a_of_type_Boolean));
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onb
 * JD-Core Version:    0.7.0.1
 */