import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageTaskTracer;
import com.tencent.component.media.utils.ImageManagerLog;

public class peo
  implements Comparable, Runnable
{
  private ImageKey jdField_a_of_type_ComTencentComponentMediaImageImageKey = null;
  
  public peo(DecodeImageTask paramDecodeImageTask, ImageKey paramImageKey)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey = paramImageKey;
  }
  
  public int a(peo parampeo)
  {
    if ((this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey != null) && (this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey.options != null) && (this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey.options.priority)) {
      return 1;
    }
    return 0;
  }
  
  public void run()
  {
    System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey != null)
    {
      ImageTaskTracer.removeImageDecodeThreadPendingRecord(this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey.hashCodeEx());
      ImageTaskTracer.addImageDecodeThreadDecodingRecord(this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey.hashCodeEx());
    }
    for (;;)
    {
      try
      {
        Drawable localDrawable = ImageManager.getInstance().a(this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey);
        if (localDrawable == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.setResult(11, new Object[] { localDrawable });
      }
      catch (Throwable localThrowable)
      {
        ImageManagerLog.e(DecodeImageTask.a(), Log.getStackTraceString(localThrowable));
        if (this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey.options == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey.options.errCode = ImageManager.getErrorString(this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.mImageKey, 101);
        this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.setResult(9, new Object[0]);
        if (this.jdField_a_of_type_ComTencentComponentMediaImageImageKey == null) {
          continue;
        }
        ImageTaskTracer.addImageDecodeFailedRecord(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.hashCodeEx());
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.hashCodeEx());
        continue;
      }
      System.currentTimeMillis();
      ImageManager.getInstance().nocachedDeleteLocalFile(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey);
      this.jdField_a_of_type_ComTencentComponentMediaImageImageKey = null;
      return;
      DecodeImageTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     peo
 * JD-Core Version:    0.7.0.1
 */