import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

class nhk
  implements ValueAnimator.AnimatorUpdateListener
{
  nhk(nhi paramnhi) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    nhi.a(this.a).setTranslationY(-i);
    paramValueAnimator = nhi.a(this.a).getLayoutParams();
    paramValueAnimator.height = (nhi.a(this.a) - i);
    QLog.d("IconTabController", 1, "hideWithAnimation: " + paramValueAnimator.height);
    if (paramValueAnimator.height < 0)
    {
      aciy.a("IconTabController", "", new IllegalStateException("hideWithAnimation" + paramValueAnimator.height));
      paramValueAnimator.height = 0;
    }
    nhi.a(this.a).setLayoutParams(paramValueAnimator);
    nhi.a(this.a).setAlpha(paramValueAnimator.height / nhi.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhk
 * JD-Core Version:    0.7.0.1
 */