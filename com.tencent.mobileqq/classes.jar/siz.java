import android.view.animation.Animation;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

class siz
  extends bhry
{
  siz(six paramsix) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (siw.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(siw.a(this.a.a));
      siw.a(this.a.a).a(paramAnimation, siw.a(this.a.a));
      QQToast.a(this.a.a.a, 2, 2131718902, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     siz
 * JD-Core Version:    0.7.0.1
 */