import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

class nst
  implements ValueAnimator.AnimatorUpdateListener
{
  nst(nss paramnss) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    nss.a(this.a).setTranslationY(i - nss.a(this.a));
    paramValueAnimator = nss.a(this.a).getLayoutParams();
    paramValueAnimator.height = i;
    QLog.d("IconTabController", 1, "showWithAnimation: " + paramValueAnimator.height);
    nss.a(this.a).setLayoutParams(paramValueAnimator);
    nss.a(this.a).setAlpha(paramValueAnimator.height / nss.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nst
 * JD-Core Version:    0.7.0.1
 */