import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.album.view.AlbumImageView;

class srp
  implements Animation.AnimationListener
{
  srp(sro paramsro) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (srk.a(this.a.a) == 1)
    {
      this.a.a.b.setVisibility(8);
      srk.a(this.a.a).sendEmptyMessage(1);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srp
 * JD-Core Version:    0.7.0.1
 */