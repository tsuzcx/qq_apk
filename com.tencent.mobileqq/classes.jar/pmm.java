import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener;
import com.tencent.component.media.utils.ImageManagerLog;

public class pmm
  implements ImageLoader.ImageLoadListener
{
  private pmm(AutoGifDrawable paramAutoGifDrawable) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions)
  {
    if (this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener != null) {
      this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener.onImageCanceled(paramString, paramOptions);
    }
  }
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    if (this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener != null) {
      this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener.onImageFailed(paramString, paramOptions);
    }
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramDrawable != null) && ((paramDrawable instanceof NewGifDrawable))) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable = ((NewGifDrawable)paramDrawable);
      this.a.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setCallback(AutoGifDrawable.a(this.a));
      if (this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener != null) {
        this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener.onImageLoaded(paramString, this.a.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable, paramOptions);
      }
      return;
    }
    catch (NullPointerException paramString)
    {
      ImageManagerLog.e(AutoGifDrawable.a(), "catch an exception:" + Log.getStackTraceString(paramString));
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions)
  {
    if (this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener != null) {
      this.a.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener.onImageProgress(paramString, paramFloat, paramOptions);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmm
 * JD-Core Version:    0.7.0.1
 */