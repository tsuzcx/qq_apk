import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.seat.PkMemberItemView;

public class njy
  implements ValueAnimator.AnimatorUpdateListener
{
  public njy(PkMemberItemView paramPkMemberItemView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    paramValueAnimator = new ColorMatrixColorFilter(localColorMatrix);
    this.a.b.setColorFilter(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njy
 * JD-Core Version:    0.7.0.1
 */