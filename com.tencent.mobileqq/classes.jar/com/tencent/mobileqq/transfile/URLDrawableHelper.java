package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBaseInfo;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class URLDrawableHelper
{
  public static final float AIO_FILEPIC_ROUND_CORNER = 8.0F;
  public static final int AIO_IMAGE_DEFAULT_BG_COLOR = -921103;
  public static final int AIO_IMAGE_DEFAULT_HEIGHT = 99;
  public static final int AIO_IMAGE_DEFAULT_WIDTH = 99;
  public static int AIO_IMAGE_MAX_SIZE = 0;
  public static int AIO_IMAGE_MIN_SIZE = 0;
  public static final float AIO_IMAGE_ROUND_CORNER = 12.0F;
  public static final String TAG = "URLDrawableHelper";
  public static final Drawable TRANSLUCENT;
  public static final Drawable TRANSPARENT;
  public static File diskCachePath;
  public static Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  private static int mTargetDensity;
  public static Bitmap.Config mThumbConfig = Bitmap.Config.RGB_565;
  private static int sAioVideoMaxSize;
  private static boolean sVideoSizeInited;
  public static int smallSize = 921600;
  
  static
  {
    sVideoSizeInited = false;
    AIO_IMAGE_MIN_SIZE = 45;
    AIO_IMAGE_MAX_SIZE = 135;
    sAioVideoMaxSize = -1;
    TRANSPARENT = new ColorDrawable(0);
    TRANSLUCENT = new ColorDrawable(1073741824);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication != null)
    {
      AIO_IMAGE_MIN_SIZE = (int)DisplayUtils.a(localBaseApplication, 45.0F);
      AIO_IMAGE_MAX_SIZE = (int)DisplayUtils.a(localBaseApplication, 135.0F);
      mTargetDensity = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
    }
  }
  
  public static void decodeLocalImage(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (AbsDownloader.hasFile(str))) {}
    try
    {
      paramURLDrawable.downloadImediatly();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("URLDrawableHelper", 2, "downloadImediatly decode OOM,currentAccountUin=" + paramString + ",d.getURL=" + paramURLDrawable.getURL());
    }
  }
  
  public static Bitmap getCommonProgressBitmap()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("static://CommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130839544);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("static://CommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static URLDrawable getDrawable(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return getDrawable(paramPicUiInterface, paramInt, null, null);
  }
  
  public static URLDrawable getDrawable(PicUiInterface paramPicUiInterface, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    boolean bool2 = true;
    if (paramPicUiInterface == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(getURL(paramPicUiInterface, paramInt, paramString), paramURLDrawableOptions);
    paramString.setTag(paramPicUiInterface);
    if (paramPicUiInterface.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!PicContants.a) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694996), "qqsetting_auto_receive_pic_key", true);
    boolean bool1 = bool2;
    if (NetworkUtil.b(BaseApplication.getContext()) != 1) {
      if (!bool3) {
        break label102;
      }
    }
    label102:
    for (bool1 = bool2;; bool1 = false)
    {
      paramString.setAutoDownload(bool1);
      break;
    }
  }
  
  public static URLDrawable getDrawable(String paramString)
  {
    return getDrawable(paramString, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2)
  {
    return getDrawable(paramString, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramString, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    try
    {
      paramDrawable1 = getDrawable(new URL(paramString), paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, paramFloat);
      return paramDrawable1;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return getDrawable(paramString, paramInt1, paramInt2, null, null, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramString, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramString, 0, 0, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, boolean paramBoolean)
  {
    return getDrawable(paramString, 0, 0, null, null, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL)
  {
    return getDrawable(paramURL, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    return URLDrawable.getDrawable(paramURL, localURLDrawableOptions);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, null, null, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramURL, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramURL, 0, 0, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, boolean paramBoolean)
  {
    return getDrawable(paramURL, 0, 0, null, null, paramBoolean, 0.0F);
  }
  
  public static int getExifRotation(String paramString)
  {
    return ImageUtil.c(paramString);
  }
  
  public static Drawable getFailedDrawable()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("static://CommonFailedDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838184);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("static://CommonFailedDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static int getFileSizeType(String paramString, boolean paramBoolean)
  {
    int i = 65537;
    if ("chatthumb".equals(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatImageDownloader", 2, "getFileSizeType protocol:" + paramString + ",output_type:" + i);
      }
      return i;
      if ("chatimg".equals(paramString))
      {
        if (paramBoolean) {
          i = 1;
        } else {
          i = 131075;
        }
      }
      else if ("chatraw".equals(paramString)) {
        i = 131075;
      }
    }
  }
  
  private static String getHost(PicBaseInfo paramPicBaseInfo)
  {
    if (paramPicBaseInfo == null) {
      return null;
    }
    switch (paramPicBaseInfo.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1020: 
    case 1023: 
    case 1024: 
    case 10002: 
    case 10004: 
    case 10008: 
      return "C2C";
    case 1: 
      return "Troup";
    }
    return "Disscussion";
  }
  
  public static Drawable getLoadingDrawable()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("static://CommonLoadingDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838181);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("static://CommonLoadingDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static URLDrawable getNestDrawable(PicUiInterface paramPicUiInterface, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(getURL(paramPicUiInterface, 65537));
    localURLDrawable.setTargetDensity(mTargetDensity);
    int i;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      i = 1;
      localURL = getURL(paramPicUiInterface, paramInt);
      if (i == 0) {
        break label69;
      }
    }
    label69:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(mTargetDensity);
      localURLDrawable.setTag(paramPicUiInterface);
      return localURLDrawable;
      i = 0;
      break;
    }
  }
  
  private static String getProtocol(PicBaseInfo paramPicBaseInfo, int paramInt)
  {
    if (paramInt == 65537) {}
    String str = null;
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      switch (paramPicBaseInfo.jdField_b_of_type_Int)
      {
      default: 
        return str;
        if (paramInt == 1) {
          str = "chatimg";
        } else if (paramInt == 131075) {
          str = "chatraw";
        }
        break;
      }
    }
    return "favimage";
  }
  
  public static Drawable getResourceDrawable(int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramInt));
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), paramInt);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(paramInt), localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static Drawable getStickerFailedDrawable()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://CommonFailedDrawable_sticker");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130844681);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
        {
          GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("static://CommonFailedDrawable_sticker", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static URL getURL(PicDownloadInfo paramPicDownloadInfo, int paramInt, String paramString)
  {
    if (paramPicDownloadInfo == null) {
      return null;
    }
    String str1 = paramPicDownloadInfo.f;
    label48:
    String str2;
    if ((str1 != null) && (!"null".equals(str1)) && (!"".equals(str1)))
    {
      if (paramPicDownloadInfo.jdField_b_of_type_Boolean) {
        paramInt = 1;
      }
      if (paramString == null) {
        break label184;
      }
      str2 = str1;
      if (str1 != null) {}
    }
    for (;;)
    {
      try
      {
        str1 = "holyshit_" + System.currentTimeMillis();
        str2 = str1;
        if (QLog.isColorLevel())
        {
          QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicDownloadInfo.toString());
          str2 = str1;
        }
        if (paramString == null) {
          break label206;
        }
        paramPicDownloadInfo = new URL(paramString, null, str2);
        return paramPicDownloadInfo;
      }
      catch (MalformedURLException paramPicDownloadInfo)
      {
        label184:
        QLog.e("URLDrawableHelper", 1, "getURL error ", paramPicDownloadInfo);
        return null;
      }
      if ((paramPicDownloadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537))
      {
        if (GeneralConfigUtils.a())
        {
          str1 = paramPicDownloadInfo.k;
          break;
        }
        str1 = paramPicDownloadInfo.h;
        break;
      }
      str1 = paramPicDownloadInfo.g;
      break;
      paramString = getProtocol(paramPicDownloadInfo, paramInt);
      break label48;
      label206:
      paramPicDownloadInfo = null;
    }
  }
  
  public static URL getURL(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return getURL(paramPicUiInterface, paramInt, null);
  }
  
  public static URL getURL(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    if (paramPicUiInterface == null) {
      return null;
    }
    if (paramPicUiInterface.isSendFromLocal()) {
      return getURL(paramPicUiInterface.getPicUploadInfo(), paramInt, paramString);
    }
    return getURL(paramPicUiInterface.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL getURL(PicUploadInfo paramPicUploadInfo, int paramInt, String paramString)
  {
    if (paramPicUploadInfo == null) {
      return null;
    }
    if (paramPicUploadInfo.d < 4) {}
    for (String str2 = getHost(paramPicUploadInfo);; str2 = null)
    {
      String str3 = getProtocol(paramPicUploadInfo, paramInt);
      if ((paramPicUploadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {}
      for (String str1 = paramPicUploadInfo.h;; str1 = "") {
        for (;;)
        {
          if (str1 != null) {}
          try
          {
            if (("".equals(str1)) && (QLog.isColorLevel())) {
              QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicUploadInfo.toString());
            }
            if (paramString != null)
            {
              paramPicUploadInfo = new URL(paramString, str2, str1);
              return paramPicUploadInfo;
              if ((paramPicUploadInfo.f != null) && (!"".equals(paramPicUploadInfo.f)))
              {
                str1 = paramPicUploadInfo.f;
                continue;
              }
              if ((paramPicUploadInfo.a != null) && (!"".equals(paramPicUploadInfo.a)))
              {
                str1 = paramPicUploadInfo.a;
                continue;
              }
              if ((paramPicUploadInfo.g != null) && (!"".equals(paramPicUploadInfo.g))) {
                str1 = paramPicUploadInfo.g;
              }
            }
            else
            {
              if (str3 == null) {
                break;
              }
              paramPicUploadInfo = new URL(str3, str2, str1);
              return paramPicUploadInfo;
            }
          }
          catch (MalformedURLException paramPicUploadInfo)
          {
            paramPicUploadInfo.printStackTrace();
            return null;
          }
        }
      }
    }
  }
  
  public static URL getURL(String paramString, int paramInt)
  {
    String str = "chatimg";
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      try
      {
        paramString = new URL(str, null, paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 1) {
        str = "chatimg";
      } else if (paramInt == 131075) {
        str = "chatraw";
      }
    }
    return null;
  }
  
  public static int getVideoThumbMaxDp()
  {
    initVideoAIOSizeByDpc();
    return sAioVideoMaxSize;
  }
  
  public static boolean hasDiskCache(Context paramContext, PicUiInterface paramPicUiInterface, int paramInt)
  {
    return AbsDownloader.getFile(getURL(paramPicUiInterface, paramInt).toString()) != null;
  }
  
  /* Error */
  public static void initVideoAIOSizeByDpc()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 54	com/tencent/mobileqq/transfile/URLDrawableHelper:sVideoSizeInited	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: ldc_w 486
    //   18: invokestatic 492	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   21: checkcast 486	com/tencent/mobileqq/dpc/api/IDPCApi
    //   24: getstatic 498	com/tencent/mobileqq/dpc/enumname/DPCNames:aio_config	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   27: invokevirtual 501	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   30: ldc_w 503
    //   33: invokeinterface 507 3 0
    //   38: ldc_w 509
    //   41: invokevirtual 513	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: arraylength
    //   47: istore_0
    //   48: iload_0
    //   49: ifle +15 -> 64
    //   52: aload_2
    //   53: iconst_0
    //   54: aaload
    //   55: invokestatic 518	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   58: invokevirtual 521	java/lang/Integer:intValue	()I
    //   61: putstatic 60	com/tencent/mobileqq/transfile/URLDrawableHelper:sAioVideoMaxSize	I
    //   64: iconst_1
    //   65: putstatic 54	com/tencent/mobileqq/transfile/URLDrawableHelper:sVideoSizeInited	Z
    //   68: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -60 -> 11
    //   74: ldc 22
    //   76: iconst_2
    //   77: new 144	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 523
    //   87: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: getstatic 60	com/tencent/mobileqq/transfile/URLDrawableHelper:sAioVideoMaxSize	I
    //   93: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 526	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: goto -91 -> 11
    //   105: astore_2
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    //   111: astore_2
    //   112: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 22
    //   120: iconst_2
    //   121: ldc_w 528
    //   124: invokestatic 526	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: iconst_m1
    //   128: putstatic 60	com/tencent/mobileqq/transfile/URLDrawableHelper:sAioVideoMaxSize	I
    //   131: goto -67 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	2	0	i	int
    //   6	2	1	bool	boolean
    //   44	9	2	arrayOfString	String[]
    //   105	5	2	localObject	Object
    //   111	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	7	105	finally
    //   15	48	105	finally
    //   52	64	105	finally
    //   64	102	105	finally
    //   112	127	105	finally
    //   127	131	105	finally
    //   52	64	111	java/lang/Exception
  }
  
  public static boolean isAutoDownAt2G3GAbled(Context paramContext)
  {
    return SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694996), "qqsetting_auto_receive_pic_key", true);
  }
  
  public static boolean isMobileNet()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean isMobileNetAndAutodownDisabled(Context paramContext)
  {
    boolean bool1 = AppNetConnInfo.isMobileConn();
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694996), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */