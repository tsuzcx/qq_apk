import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;

class rvp
  implements Animation.AnimationListener
{
  rvp(rvo paramrvo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((ruw.a(this.a.c) == rvo.a(this.a)) && (ruw.a(this.a.c) != null)) {
      ruw.a(this.a.c).a(rvo.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((rvo.a(this.a).a != null) && (rvo.a(this.a).a.a != null))
    {
      boolean bool = rvo.a(this.a).a.a.r;
      if (rvo.a(this.a).o != null) {
        rvo.a(this.a).o.setImageDrawable(ruw.a(this.a.c, this.a.a(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvp
 * JD-Core Version:    0.7.0.1
 */