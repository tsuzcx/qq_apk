import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.album.view.AlbumImageView;

class srs
  implements Animation.AnimationListener
{
  srs(srr paramsrr) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (srn.a(this.a.a) == 1)
    {
      this.a.a.b.setVisibility(8);
      srn.a(this.a.a).sendEmptyMessage(1);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srs
 * JD-Core Version:    0.7.0.1
 */