import android.view.animation.Animation;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class pdd
  extends AnimateUtils.AnimationAdapter
{
  public pdd(AbstractGalleryScene paramAbstractGalleryScene) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a().e();
    this.a.a.a().a();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     pdd
 * JD-Core Version:    0.7.0.1
 */