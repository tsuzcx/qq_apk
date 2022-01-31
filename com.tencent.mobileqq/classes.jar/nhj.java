import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

class nhj
  implements ValueAnimator.AnimatorUpdateListener
{
  nhj(nhi paramnhi) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    nhi.a(this.a).setTranslationY(i - nhi.a(this.a));
    paramValueAnimator = nhi.a(this.a).getLayoutParams();
    paramValueAnimator.height = i;
    QLog.d("IconTabController", 1, "showWithAnimation: " + paramValueAnimator.height);
    nhi.a(this.a).setLayoutParams(paramValueAnimator);
    nhi.a(this.a).setAlpha(paramValueAnimator.height / nhi.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhj
 * JD-Core Version:    0.7.0.1
 */