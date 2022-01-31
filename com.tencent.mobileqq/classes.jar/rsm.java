import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.List;

class rsm
  extends bfmx
{
  rsm(rsk paramrsk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (rsj.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(rsj.a(this.a.a));
      rsj.a(this.a.a).a(paramAnimation, rsj.a(this.a.a));
      bcql.a(this.a.a.a, 2, 2131718461, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsm
 * JD-Core Version:    0.7.0.1
 */