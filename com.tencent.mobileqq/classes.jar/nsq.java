import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

class nsq
  implements ValueAnimator.AnimatorUpdateListener
{
  nsq(nsp paramnsp) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    nsp.a(this.a).setTranslationY(i - nsp.a(this.a));
    paramValueAnimator = nsp.a(this.a).getLayoutParams();
    paramValueAnimator.height = i;
    QLog.d("IconTabController", 1, "showWithAnimation: " + paramValueAnimator.height);
    nsp.a(this.a).setLayoutParams(paramValueAnimator);
    nsp.a(this.a).setAlpha(paramValueAnimator.height / nsp.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsq
 * JD-Core Version:    0.7.0.1
 */