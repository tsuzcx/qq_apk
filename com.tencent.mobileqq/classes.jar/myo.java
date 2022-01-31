import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.qphone.base.util.QLog;

public class myo
  implements ValueAnimator.AnimatorUpdateListener
{
  public myo(AdControlView paramAdControlView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    QLog.d("Ron", 2, "alpha:" + f);
    AdControlView.a(this.a).setAlpha(f);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     myo
 * JD-Core Version:    0.7.0.1
 */