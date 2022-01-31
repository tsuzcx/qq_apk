import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.av.widget.stageview.StageMemberView;

public class kix
  implements Animation.AnimationListener
{
  public kix(StageEffectView paramStageEffectView, boolean paramBoolean, StageMemberView paramStageMemberView, Drawable paramDrawable, ImageView paramImageView, float paramFloat1, float paramFloat2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageMemberView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.post(new kiy(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kix
 * JD-Core Version:    0.7.0.1
 */