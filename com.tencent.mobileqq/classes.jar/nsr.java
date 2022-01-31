import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

class nsr
  implements ValueAnimator.AnimatorUpdateListener
{
  nsr(nsp paramnsp) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    nsp.a(this.a).setTranslationY(-i);
    paramValueAnimator = nsp.a(this.a).getLayoutParams();
    paramValueAnimator.height = (nsp.a(this.a) - i);
    QLog.d("IconTabController", 1, "hideWithAnimation: " + paramValueAnimator.height);
    if (paramValueAnimator.height < 0)
    {
      actj.a("IconTabController", "", new IllegalStateException("hideWithAnimation" + paramValueAnimator.height));
      paramValueAnimator.height = 0;
    }
    nsp.a(this.a).setLayoutParams(paramValueAnimator);
    nsp.a(this.a).setAlpha(paramValueAnimator.height / nsp.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsr
 * JD-Core Version:    0.7.0.1
 */