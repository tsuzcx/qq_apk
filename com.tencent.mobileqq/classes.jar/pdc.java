import android.view.animation.Animation;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class pdc
  extends AnimateUtils.AnimationAdapter
{
  public pdc(AbstractGalleryScene paramAbstractGalleryScene) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a().b();
    this.a.a.a().a();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     pdc
 * JD-Core Version:    0.7.0.1
 */