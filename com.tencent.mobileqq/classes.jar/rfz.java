import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.List;

class rfz
  extends beem
{
  rfz(rfx paramrfx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (rfw.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(rfw.a(this.a.a));
      rfw.a(this.a.a).a(paramAnimation, rfw.a(this.a.a));
      bbmy.a(this.a.a.a, 2, 2131652631, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfz
 * JD-Core Version:    0.7.0.1
 */