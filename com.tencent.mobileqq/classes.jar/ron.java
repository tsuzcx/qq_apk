import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;

class ron
  implements Animation.AnimationListener
{
  ron(rom paramrom) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((rnu.a(this.a.c) == rom.a(this.a)) && (rnu.a(this.a.c) != null)) {
      rnu.a(this.a.c).a(rom.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((rom.a(this.a).a != null) && (rom.a(this.a).a.a != null))
    {
      boolean bool = rom.a(this.a).a.a.o;
      if (rom.a(this.a).o != null) {
        rom.a(this.a).o.setImageDrawable(rnu.a(this.a.c, this.a.a(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ron
 * JD-Core Version:    0.7.0.1
 */