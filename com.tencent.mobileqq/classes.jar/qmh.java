import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;

class qmh
  implements Animation.AnimationListener
{
  qmh(qmg paramqmg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((qlp.a(this.a.c) == qmg.a(this.a)) && (qlp.a(this.a.c) != null)) {
      qlp.a(this.a.c).a(qmg.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((qmg.a(this.a).a != null) && (qmg.a(this.a).a.a != null))
    {
      boolean bool = qmg.a(this.a).a.a.l;
      if (qmg.a(this.a).l != null) {
        qmg.a(this.a).l.setImageDrawable(qlp.a(this.a.c, this.a.a(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmh
 * JD-Core Version:    0.7.0.1
 */