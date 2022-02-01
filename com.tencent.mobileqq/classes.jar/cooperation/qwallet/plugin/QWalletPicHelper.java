package cooperation.qwallet.plugin;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class QWalletPicHelper
{
  public static final String KEY_QWALLET_MD5 = "qwallet_config_md5";
  public static final String PROTOCOL_QWALLET_DOWNLOAD = "qwallet_downloader";
  private static final String TAG = "QWalletPicHelper";
  
  public static Drawable getDrawableForAIO(String paramString, Drawable paramDrawable)
  {
    return getDrawableInner(paramString, paramString, paramDrawable, paramDrawable, new int[] { 0 }, null);
  }
  
  public static URLDrawable getDrawableInner(String paramString1, String paramString2, Drawable paramDrawable1, Drawable paramDrawable2, int[] paramArrayOfInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    try
    {
      localBundle = new Bundle();
      localBundle.putIntArray("key_tagId_arr", paramArrayOfInt);
      localBundle.putString("key_name", paramString2);
      int i = localBundle.getInt("key_loop");
      localBundle.putBoolean("key_double_bitmap", localBundle.getBoolean("key_double_bitmap", true));
      boolean bool = localBundle.getBoolean("key_play_apng", true);
      paramArrayOfInt = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramArrayOfInt = PreloadStaticApi.b(paramString2);
      }
      paramString1 = new URL("qwallet_downloader", paramArrayOfInt, paramString2);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mUseApngImage = bool;
      paramBundle.mUseMemoryCache = localBundle.getBoolean("key_use_cache", true);
      if (i > 0) {
        paramBundle.mUseMemoryCache = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(bool);
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      paramBundle.mMemoryCacheKeySuffix = localStringBuilder.toString();
      paramBundle.mLoadingDrawable = paramDrawable1;
      paramBundle.mFailedDrawable = paramDrawable2;
      paramBundle.mExtraInfo = localBundle;
      paramString1 = URLDrawable.getDrawable(paramString1, paramBundle);
      if (QLog.isColorLevel())
      {
        paramDrawable1 = new StringBuilder();
        paramDrawable1.append("getApngDrawable ApngImage ok path:");
        paramDrawable1.append(paramArrayOfInt);
        paramDrawable1.append(", urlStr=");
        paramDrawable1.append(paramString2);
        QLog.d("QWalletPicHelper", 2, paramDrawable1.toString());
      }
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      label256:
      break label256;
    }
    return null;
  }
  
  public static Drawable getNetDrawableForAIO(String paramString, Drawable paramDrawable)
  {
    String str = PreloadStaticApi.b(paramString);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_use_file_loop", true);
    return getDrawableInner(str, paramString, paramDrawable, paramDrawable, new int[] { 0 }, localBundle);
  }
  
  public static URLDrawable getNetDrawableForQWallet(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getNetDrawableForQWallet(paramString, paramDrawable1, paramDrawable2, (String)null);
  }
  
  public static URLDrawable getNetDrawableForQWallet(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, Bundle paramBundle)
  {
    paramString = getDrawableInner(PreloadStaticApi.b(paramString), paramString, paramDrawable1, paramDrawable2, new int[] { 26 }, paramBundle);
    ApngImage.playByTag(26);
    return paramString;
  }
  
  public static URLDrawable getNetDrawableForQWallet(String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    String str = PreloadStaticApi.b(paramString1);
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("qwallet_config_md5", paramString2);
    }
    paramString1 = getDrawableInner(str, paramString1, paramDrawable1, paramDrawable2, new int[] { 26 }, localBundle);
    ApngImage.playByTag(26);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPicHelper
 * JD-Core Version:    0.7.0.1
 */