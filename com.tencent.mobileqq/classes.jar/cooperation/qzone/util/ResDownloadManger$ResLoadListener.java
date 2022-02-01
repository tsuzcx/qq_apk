package cooperation.qzone.util;

import android.graphics.Bitmap;

public abstract interface ResDownloadManger$ResLoadListener
{
  public abstract void onDownloaded(int paramInt, String paramString, Bitmap paramBitmap);
  
  public abstract void onFailed(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.ResDownloadManger.ResLoadListener
 * JD-Core Version:    0.7.0.1
 */