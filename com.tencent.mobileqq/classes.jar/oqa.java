import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.utils.StackBlur;

final class oqa
  extends bgxc
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    paramDownloadParams = paramBitmap.copy(paramBitmap.getConfig(), true);
    StackBlur.fastblur(paramDownloadParams, 40);
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqa
 * JD-Core Version:    0.7.0.1
 */