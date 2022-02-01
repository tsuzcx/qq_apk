import android.view.animation.Animation;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

class syj
  extends blgm
{
  syj(syi paramsyi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (syh.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(syh.a(this.a.a));
      syh.a(this.a.a).a(paramAnimation, syh.a(this.a.a));
      QQToast.a(this.a.a.a, 2, 2131717140, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syj
 * JD-Core Version:    0.7.0.1
 */