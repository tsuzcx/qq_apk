import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;

class rbp
  implements Animation.AnimationListener
{
  rbp(rbo paramrbo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((raw.a(this.a.c) == rbo.a(this.a)) && (raw.a(this.a.c) != null)) {
      raw.a(this.a.c).a(rbo.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((rbo.a(this.a).a != null) && (rbo.a(this.a).a.a != null))
    {
      boolean bool = rbo.a(this.a).a.a.p;
      if (rbo.a(this.a).l != null) {
        rbo.a(this.a).l.setImageDrawable(raw.a(this.a.c, this.a.a(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbp
 * JD-Core Version:    0.7.0.1
 */