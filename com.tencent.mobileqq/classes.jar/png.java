import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageLoader.StreamDownloadListener;
import com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl;
import java.lang.ref.WeakReference;

public class png
  implements ImageLoader.StreamDownloadListener
{
  private WeakReference a;
  
  public png(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl)
  {
    this.a = new WeakReference(paramAsyncImageableImpl);
  }
  
  private AsyncImageable.AsyncImageableImpl a()
  {
    return (AsyncImageable.AsyncImageableImpl)this.a.get();
  }
  
  public void onApplyToImage(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    paramOptions = a();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.a(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.a(paramOptions, paramDrawable, true);
  }
  
  public void onDownloadCanceled(String paramString1, String paramString2, String paramString3) {}
  
  public void onDownloadFailed(String paramString1, String paramString2, String paramString3) {}
  
  public void onDownloadProgress(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt) {}
  
  public void onDownloadSucceed(String paramString1, String paramString2, String paramString3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     png
 * JD-Core Version:    0.7.0.1
 */