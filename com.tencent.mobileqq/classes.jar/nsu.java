import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

class nsu
  implements ValueAnimator.AnimatorUpdateListener
{
  nsu(nss paramnss) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    nss.a(this.a).setTranslationY(-i);
    paramValueAnimator = nss.a(this.a).getLayoutParams();
    paramValueAnimator.height = (nss.a(this.a) - i);
    QLog.d("IconTabController", 1, "hideWithAnimation: " + paramValueAnimator.height);
    if (paramValueAnimator.height < 0)
    {
      actn.a("IconTabController", "", new IllegalStateException("hideWithAnimation" + paramValueAnimator.height));
      paramValueAnimator.height = 0;
    }
    nss.a(this.a).setLayoutParams(paramValueAnimator);
    nss.a(this.a).setAlpha(paramValueAnimator.height / nss.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsu
 * JD-Core Version:    0.7.0.1
 */