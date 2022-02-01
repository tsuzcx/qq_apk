import android.view.animation.Animation;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

class tck
  extends bjmc
{
  tck(tci paramtci) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (tch.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(tch.a(this.a.a));
      tch.a(this.a.a).a(paramAnimation, tch.a(this.a.a));
      QQToast.a(this.a.a.a, 2, 2131717383, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tck
 * JD-Core Version:    0.7.0.1
 */