import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.List;

class rsp
  extends bfmg
{
  rsp(rsn paramrsn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (rsm.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(rsm.a(this.a.a));
      rsm.a(this.a.a).a(paramAnimation, rsm.a(this.a.a));
      bcpw.a(this.a.a.a, 2, 2131718450, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsp
 * JD-Core Version:    0.7.0.1
 */