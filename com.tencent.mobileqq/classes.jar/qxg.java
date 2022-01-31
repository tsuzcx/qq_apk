import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class qxg
  implements Animation.AnimationListener
{
  qxg(qxf paramqxf, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (qxf.a(this.jdField_a_of_type_Qxf) != null) {
      qxf.a(this.jdField_a_of_type_Qxf).setImageDrawable(this.jdField_a_of_type_Qxf.a(qxf.a(this.jdField_a_of_type_Qxf, this.jdField_a_of_type_Boolean)));
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxg
 * JD-Core Version:    0.7.0.1
 */