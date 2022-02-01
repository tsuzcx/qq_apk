import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl;

public class nmd
  implements ValueAnimator.AnimatorUpdateListener
{
  public nmd(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((AVGameControlUIImpl.a(this.a)) && (this.a.a != null)) {
      this.a.a.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmd
 * JD-Core Version:    0.7.0.1
 */