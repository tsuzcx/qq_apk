import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;

class qmk
  implements Animation.AnimationListener
{
  qmk(qmj paramqmj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((qls.a(this.a.c) == qmj.a(this.a)) && (qls.a(this.a.c) != null)) {
      qls.a(this.a.c).a(qmj.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((qmj.a(this.a).a != null) && (qmj.a(this.a).a.a != null))
    {
      boolean bool = qmj.a(this.a).a.a.l;
      if (qmj.a(this.a).l != null) {
        qmj.a(this.a).l.setImageDrawable(qls.a(this.a.c, this.a.a(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmk
 * JD-Core Version:    0.7.0.1
 */