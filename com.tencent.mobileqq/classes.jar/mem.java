import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import java.util.ArrayList;

class mem
  implements Animation.AnimationListener
{
  mem(mel parammel, ArrayList paramArrayList) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoShareHelper.a(this.jdField_a_of_type_Mel.a).post(new men(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mem
 * JD-Core Version:    0.7.0.1
 */