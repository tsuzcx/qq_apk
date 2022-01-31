import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.qphone.base.util.QLog;

public class kvl
  implements ValueAnimator.AnimatorUpdateListener
{
  public kvl(AdControlView paramAdControlView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    QLog.d("Ron", 2, "alpha:" + f);
    this.a.a.setAlpha(f);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvl
 * JD-Core Version:    0.7.0.1
 */