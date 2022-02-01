import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl;

public class nee
  implements ValueAnimator.AnimatorUpdateListener
{
  public nee(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((AVGameControlUIImpl.a(this.a)) && (this.a.a != null)) {
      this.a.a.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nee
 * JD-Core Version:    0.7.0.1
 */