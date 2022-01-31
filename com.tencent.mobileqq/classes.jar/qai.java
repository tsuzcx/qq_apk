import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;

class qai
  implements Animation.AnimationListener
{
  qai(qah paramqah) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((pzs.a(this.a.c) == qah.a(this.a)) && (pzs.a(this.a.c) != null)) {
      pzs.a(this.a.c).a(qah.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((qah.a(this.a).a != null) && (qah.a(this.a).a.a != null))
    {
      boolean bool = qah.a(this.a).a.a.l;
      if (qah.a(this.a).i != null) {
        qah.a(this.a).i.setImageDrawable(pzs.a(this.a.c, this.a.a(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qai
 * JD-Core Version:    0.7.0.1
 */