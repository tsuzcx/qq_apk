import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;

class rxs
  implements Animation.AnimationListener
{
  rxs(rxr paramrxr) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((rwy.a(this.a.c) == rxr.a(this.a)) && (rwy.a(this.a.c) != null)) {
      rwy.a(this.a.c).a(rxr.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((rxr.a(this.a).a != null) && (rxr.a(this.a).a.a != null))
    {
      boolean bool = rxr.a(this.a).a.a.r;
      if (rxr.a(this.a).o != null) {
        rxr.a(this.a).o.setImageDrawable(rwy.a(this.a.c, this.a.a(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxs
 * JD-Core Version:    0.7.0.1
 */