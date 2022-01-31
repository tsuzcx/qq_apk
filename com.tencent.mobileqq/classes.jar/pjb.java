import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.photogif.QzoneAnimationDrawable;

public class pjb
  implements ImageLoader.ImageLoadListener
{
  private pjb(QzoneAnimationDrawable paramQzoneAnimationDrawable) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions)
  {
    QzoneAnimationDrawable.a(this.a);
  }
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    QzoneAnimationDrawable.a(this.a);
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    QzoneAnimationDrawable.a(this.a, paramDrawable);
    if (QzoneAnimationDrawable.a(this.a))
    {
      QzoneAnimationDrawable.a(this.a, false);
      QzoneAnimationDrawable.b(this.a);
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjb
 * JD-Core Version:    0.7.0.1
 */