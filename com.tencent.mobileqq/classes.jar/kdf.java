import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.VoiceChangeChooseDialog;

public class kdf
  implements Animation.AnimationListener
{
  public kdf(VoiceChangeChooseDialog paramVoiceChangeChooseDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdf
 * JD-Core Version:    0.7.0.1
 */