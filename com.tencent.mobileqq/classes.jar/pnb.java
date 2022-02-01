import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class pnb
  implements Animation.AnimationListener
{
  pnb(pna parampna, ImageView paramImageView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(pna.a(this.jdField_a_of_type_Pna, this.jdField_a_of_type_Boolean));
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnb
 * JD-Core Version:    0.7.0.1
 */