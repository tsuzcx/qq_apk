package cooperation.qzone.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.open.component.cache.util.LocalConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

final class AnimatedWebpLoaderUtil$1
  implements ModuleDownloadListener
{
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i(AnimatedWebpLoaderUtil.TAG, "download webp so fail");
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("animatedWebp.so")) {
      return;
    }
    LocalConfig.a().edit().putString("PREFERENCE_SO_MD5_KEY", AnimatedWebpLoaderUtil.WEBP_SO_MD5).commit();
    QZLog.i(AnimatedWebpLoaderUtil.TAG, "download webp so succ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.AnimatedWebpLoaderUtil.1
 * JD-Core Version:    0.7.0.1
 */