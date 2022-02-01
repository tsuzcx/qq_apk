package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import bgft;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class VasApngUtil
{
  public static final int CAN_PLAY_TAG_AIO = 0;
  public static final int CAN_PLAY_TAG_C2C_SETTING = 27;
  public static final int CAN_PLAY_TAG_CALL = 6;
  public static final int CAN_PLAY_TAG_CARD = 9;
  public static final int CAN_PLAY_TAG_COMIC_TABBAR = 12;
  public static final int CAN_PLAY_TAG_CONTACTS = 3;
  public static final int CAN_PLAY_TAG_CONVERSATION = 2;
  public static final int CAN_PLAY_TAG_DYNAMIC = 13;
  public static final int CAN_PLAY_TAG_LEBA = 4;
  public static final int CAN_PLAY_TAG_LEBA_ANIM_ICON = 39;
  public static final int CAN_PLAY_TAG_LIGHT_RECOGNITION_GUIDE = 25;
  public static final int CAN_PLAY_TAG_LOGIN = 11;
  public static final int CAN_PLAY_TAG_MINIAPP = 32;
  public static final int CAN_PLAY_TAG_NEARBY_CARD = 15;
  public static final int CAN_PLAY_TAG_NOW = 5;
  public static final int CAN_PLAY_TAG_OPT_1 = 28;
  public static final int CAN_PLAY_TAG_OPT_2 = 29;
  public static final int CAN_PLAY_TAG_OPT_3 = 30;
  public static final int CAN_PLAY_TAG_OPT_4 = 31;
  public static final int CAN_PLAY_TAG_PENDANT = 10;
  public static final int CAN_PLAY_TAG_QCIRCLE = 33;
  public static final int CAN_PLAY_TAG_QCIRCLE_PERSONAL_TIP = 34;
  public static final int CAN_PLAY_TAG_QR = 35;
  public static final int CAN_PLAY_TAG_QZONE_BIRTH_GIFT = 20000;
  public static final int CAN_PLAY_TAG_QZONE_MOOD_SHORTCUT_LIST = 24;
  public static final int CAN_PLAY_TAG_QZONE_MSG_CONTENT_BOX = 10000;
  public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_FIRST = 18;
  public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_FORTH = 21;
  public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_SECOND = 19;
  public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_SIXTH = 23;
  public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_TFIFTH = 22;
  public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_THIRD = 20;
  public static final int CAN_PLAY_TAG_RED_PACK = 26;
  public static final int CAN_PLAY_TAG_SEARCH_FRIEND_LIST = 36;
  public static final int CAN_PLAY_TAG_SEARCH_FRIEND_MIXT = 37;
  public static final int CAN_PLAY_TAG_SEARCH_NET = 38;
  public static final int CAN_PLAY_TAG_SEE = 8;
  public static final int CAN_PLAY_TAG_SETTING = 1;
  public static final int CAN_PLAY_TAG_SHORTVIDEO_TRANSITION = 16;
  public static final int CAN_PLAY_TAG_SIGNATURE_EDIT = 17;
  public static final int CAN_PLAY_TAG_VISITORS = 14;
  public static final int CAN_PLAY_TAG_WZRY_CARD_LOGO = 7;
  public static final String KEY_PLAY_APNG = "key_play_apng";
  public static final String KEY_USE_CACHE = "key_use_cache";
  public static final String SO_FILE_NAME = "libAPNG_release_845.so";
  public static final String SO_ZIP_NAME = "apng.zip";
  private static final String TAG = "VasApngUtil";
  public static final int[] VIP_APNG_TAGS = { 1, 0, 2, 3, 9, 27 };
  public static int[] converstionTag = { 2, 3, 4, 5, 6, 8 };
  
  public static bgft factory()
  {
    return bgft.a;
  }
  
  @Deprecated
  public static URLDrawable getApngDrawable(String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    return getApngDrawable(null, paramString1, paramString2, paramDrawable, paramArrayOfInt, paramString3, paramBundle);
  }
  
  @Deprecated
  public static URLDrawable getApngDrawable(@Nullable AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    try
    {
      paramAppRuntime = new Bundle();
      boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
      int i = paramAppRuntime.getInt("key_loop");
      paramBundle = new URL("vasapngdownloader", paramString1, paramString2);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = bool;
      localURLDrawableOptions.mUseMemoryCache = paramAppRuntime.getBoolean("key_use_cache", true);
      localURLDrawableOptions.mMemoryCacheKeySuffix = (bool + "," + i);
      i = paramAppRuntime.getInt("key_width", 0);
      int j = paramAppRuntime.getInt("key_height", 0);
      if ((i > 0) && (j > 0))
      {
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
      }
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
      paramAppRuntime.putString("key_name", paramString3);
      paramAppRuntime.putBoolean("key_double_bitmap", true);
      localURLDrawableOptions.mExtraInfo = paramAppRuntime;
      if ("-Dynamic-".equals(paramString2)) {
        localURLDrawableOptions.mUseAutoScaleParams = false;
      }
      if (!paramAppRuntime.getBoolean("key_use_auto_scale_params", true)) {
        localURLDrawableOptions.mUseAutoScaleParams = false;
      }
      paramAppRuntime = URLDrawable.getDrawable(paramBundle, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("VasApngUtil", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
      }
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("VasApngUtil", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
    }
    return null;
  }
  
  private static URLDrawable getApngDrawableFromUrl(String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    return getApngDrawableFromUrl(paramString1, paramString2, paramDrawable, paramArrayOfInt, paramString3, true, paramBundle);
  }
  
  private static URLDrawable getApngDrawableFromUrl(String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    try
    {
      localBundle = new Bundle();
      boolean bool = localBundle.getBoolean("key_play_apng", true);
      int i = localBundle.getInt("key_loop");
      paramString2 = new URL("vasapngdownloader", paramString1, paramString2);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mUseApngImage = bool;
      paramBundle.mUseMemoryCache = localBundle.getBoolean("key_use_cache", true);
      paramBundle.mMemoryCacheKeySuffix = (bool + "," + i);
      paramBundle.mUseUnFinishCache = paramBoolean;
      i = localBundle.getInt("key_width", 0);
      int j = localBundle.getInt("key_height", 0);
      if ((i > 0) && (j > 0))
      {
        paramBundle.mRequestWidth = i;
        paramBundle.mRequestHeight = j;
      }
      paramBundle.mLoadingDrawable = paramDrawable;
      paramBundle.mFailedDrawable = paramDrawable;
      localBundle.putIntArray("key_tagId_arr", paramArrayOfInt);
      localBundle.putString("key_name", paramString3);
      localBundle.putBoolean("key_double_bitmap", true);
      paramBundle.mExtraInfo = localBundle;
      paramBundle.mUseAutoScaleParams = false;
      paramString2 = URLDrawable.getDrawable(paramString2, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("VasApngUtil", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
      }
      return paramString2;
    }
    catch (Exception paramString2)
    {
      QLog.e("VasApngUtil", 1, "getApngDrawable ApngImage err:" + paramString2.toString() + ", path:" + paramString1 + ", name=" + paramString3);
    }
    return null;
  }
  
  public static URLDrawable getApngURLDrawable(String paramString, int[] paramArrayOfInt, Drawable paramDrawable)
  {
    return getApngURLDrawable(paramString, paramArrayOfInt, paramDrawable, null, new VasApngUtil.2(paramArrayOfInt));
  }
  
  @Deprecated
  public static URLDrawable getApngURLDrawable(String paramString, int[] paramArrayOfInt, Drawable paramDrawable, Bundle paramBundle, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    String str = new File(paramString).getName();
    paramString = getApngDrawableFromUrl(getCacheFilePath(paramString), paramString, paramDrawable, paramArrayOfInt, str, paramBundle);
    if (paramString != null)
    {
      int i = paramString.getStatus();
      if (i != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ddddd", 2, "urlDrawable is not  SUCCESSED :" + i);
        }
        paramString.setURLDrawableListener(paramURLDrawableListener);
        if (i == 2)
        {
          paramString.restartDownload();
          return paramString;
        }
        paramString.startDownload();
        return paramString;
      }
      ThreadManagerV2.getUIHandlerV2().post(new VasApngUtil.3(paramString, paramArrayOfInt));
      return paramString;
    }
    return null;
  }
  
  public static String getCacheFilePath(String paramString)
  {
    return VFSAssistantUtils.getSDKPrivatePath(new StringBuilder().append(AppConstants.SDCARD_PATH).append(".vipicon/").toString()) + paramString.hashCode() + ".png";
  }
  
  @Deprecated
  public static Drawable getOptimizedApngDrawable(String paramString1, Drawable paramDrawable, int[] paramArrayOfInt, String paramString2)
  {
    return getApngDrawableFromUrl(paramString1, "", paramDrawable, paramArrayOfInt, paramString2, false, null);
  }
  
  public static Drawable getOptimizedApngDrawable(String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    return getApngDrawable(paramString1, paramString2, paramDrawable, paramArrayOfInt, paramString3, paramBundle);
  }
  
  public static URLDrawable getRegionUrlDrawable(String paramString, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setURLDrawableListener(new VasApngUtil.1(paramInt));
    return paramString;
  }
  
  public static void loadApngUrlInImageView(ImageView paramImageView, String paramString, int[] paramArrayOfInt, Drawable paramDrawable)
  {
    paramString = getApngURLDrawable(paramString, paramArrayOfInt, paramDrawable);
    if (paramString != null) {
      paramImageView.setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngUtil
 * JD-Core Version:    0.7.0.1
 */