import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl;
import java.lang.ref.WeakReference;

public class pgt
  implements ImageLoader.ImageLoadListener
{
  private WeakReference a;
  
  public pgt(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl)
  {
    this.a = new WeakReference(paramAsyncImageableImpl);
  }
  
  private AsyncImageable.AsyncImageableImpl a()
  {
    return (AsyncImageable.AsyncImageableImpl)this.a.get();
  }
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    paramOptions = a();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.a(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.b(paramOptions);
    AsyncImageable.AsyncImageableImpl.a(paramOptions);
    AsyncImageable.AsyncImageableImpl.c(paramOptions);
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    paramOptions = a();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.a(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.a(paramOptions, paramDrawable, true);
    AsyncImageable.AsyncImageableImpl.d(paramOptions);
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions)
  {
    paramOptions = a();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.a(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.a(paramOptions, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgt
 * JD-Core Version:    0.7.0.1
 */