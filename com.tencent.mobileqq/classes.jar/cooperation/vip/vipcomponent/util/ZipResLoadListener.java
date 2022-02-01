package cooperation.vip.vipcomponent.util;

import android.graphics.drawable.Drawable;

public abstract class ZipResLoadListener
{
  public volatile int mCount = 0;
  
  public abstract void onDownloaded(String paramString1, int paramInt, String paramString2, Drawable paramDrawable);
  
  public abstract void onFailed(String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResLoadListener
 * JD-Core Version:    0.7.0.1
 */