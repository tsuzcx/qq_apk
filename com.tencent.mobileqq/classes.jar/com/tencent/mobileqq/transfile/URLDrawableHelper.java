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
import aydh;
import aydk;
import aydl;
import aydz;
import ayeb;
import bcdo;
import bfpx;
import bfvh;
import bfvo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
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
    AIO_IMAGE_MIN_SIZE = 45;
    AIO_IMAGE_MAX_SIZE = 135;
    sAioVideoMaxSize = -1;
    TRANSPARENT = new ColorDrawable(0);
    TRANSLUCENT = new ColorDrawable(1073741824);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication != null)
    {
      AIO_IMAGE_MIN_SIZE = (int)bfvh.a(localBaseApplication, 45.0F);
      AIO_IMAGE_MAX_SIZE = (int)bfvh.a(localBaseApplication, 135.0F);
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
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bfpx.a(BaseApplicationImpl.getContext().getResources(), 2130839444);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static URLDrawable getDrawable(aydz paramaydz, int paramInt)
  {
    return getDrawable(paramaydz, paramInt, null, null);
  }
  
  public static URLDrawable getDrawable(aydz paramaydz, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    boolean bool2 = true;
    if (paramaydz == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(getURL(paramaydz, paramInt, paramString), paramURLDrawableOptions);
    paramString.setTag(paramaydz);
    if (paramaydz.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!aydk.a) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694557), "qqsetting_auto_receive_pic_key", true);
    boolean bool1 = bool2;
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {
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
    return bfvo.b(paramString);
  }
  
  public static Drawable getFailedDrawable()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonFailedDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bfpx.a(BaseApplicationImpl.getContext().getResources(), 2130838098);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonFailedDrawable", localBitmap1);
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
  
  private static String getHost(aydh paramaydh)
  {
    if (paramaydh == null) {
      return null;
    }
    switch (paramaydh.jdField_b_of_type_Int)
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
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonLoadingDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bfpx.a(BaseApplicationImpl.getContext().getResources(), 2130838095);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonLoadingDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static URLDrawable getNestDrawable(aydz paramaydz, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(getURL(paramaydz, 65537));
    localURLDrawable.setTargetDensity(mTargetDensity);
    int i;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      i = 1;
      localURL = getURL(paramaydz, paramInt);
      if (i == 0) {
        break label69;
      }
    }
    label69:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(mTargetDensity);
      localURLDrawable.setTag(paramaydz);
      return localURLDrawable;
      i = 0;
      break;
    }
  }
  
  private static String getProtocol(aydh paramaydh, int paramInt)
  {
    if (paramInt == 65537) {}
    String str = null;
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      switch (paramaydh.jdField_b_of_type_Int)
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
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get(String.valueOf(paramInt));
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bfpx.a(BaseApplicationImpl.getContext().getResources(), paramInt);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put(String.valueOf(paramInt), localBitmap1);
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
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://CommonFailedDrawable_sticker");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bfpx.a(BaseApplicationImpl.getContext().getResources(), 2130844429);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("static://CommonFailedDrawable_sticker", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static URL getURL(aydl paramaydl, int paramInt, String paramString)
  {
    if (paramaydl == null) {
      return null;
    }
    String str1 = paramaydl.f;
    label48:
    String str2;
    if ((str1 != null) && (!"null".equals(str1)) && (!"".equals(str1)))
    {
      if (paramaydl.jdField_b_of_type_Boolean) {
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
          QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramaydl.toString());
          str2 = str1;
        }
        if (paramString == null) {
          break label206;
        }
        paramaydl = new URL(paramString, null, str2);
        return paramaydl;
      }
      catch (MalformedURLException paramaydl)
      {
        label184:
        QLog.e("URLDrawableHelper", 1, "getURL error ", paramaydl);
        return null;
      }
      if ((paramaydl.jdField_b_of_type_Int == 8000) && (paramInt == 65537))
      {
        if (bcdo.a())
        {
          str1 = paramaydl.k;
          break;
        }
        str1 = paramaydl.h;
        break;
      }
      str1 = paramaydl.g;
      break;
      paramString = getProtocol(paramaydl, paramInt);
      break label48;
      label206:
      paramaydl = null;
    }
  }
  
  public static URL getURL(aydz paramaydz, int paramInt)
  {
    return getURL(paramaydz, paramInt, null);
  }
  
  public static URL getURL(aydz paramaydz, int paramInt, String paramString)
  {
    if (paramaydz == null) {
      return null;
    }
    if (paramaydz.isSendFromLocal()) {
      return getURL(paramaydz.getPicUploadInfo(), paramInt, paramString);
    }
    return getURL(paramaydz.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL getURL(ayeb paramayeb, int paramInt, String paramString)
  {
    if (paramayeb == null) {
      return null;
    }
    if (paramayeb.d < 4) {}
    for (String str2 = getHost(paramayeb);; str2 = null)
    {
      String str3 = getProtocol(paramayeb, paramInt);
      if ((paramayeb.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {}
      for (String str1 = paramayeb.h;; str1 = "") {
        for (;;)
        {
          if (str1 != null) {}
          try
          {
            if (("".equals(str1)) && (QLog.isColorLevel())) {
              QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramayeb.toString());
            }
            if (paramString != null)
            {
              paramayeb = new URL(paramString, str2, str1);
              return paramayeb;
              if ((paramayeb.f != null) && (!"".equals(paramayeb.f)))
              {
                str1 = paramayeb.f;
                continue;
              }
              if ((paramayeb.a != null) && (!"".equals(paramayeb.a)))
              {
                str1 = paramayeb.a;
                continue;
              }
              if ((paramayeb.g != null) && (!"".equals(paramayeb.g))) {
                str1 = paramayeb.g;
              }
            }
            else
            {
              if (str3 == null) {
                break;
              }
              paramayeb = new URL(str3, str2, str1);
              return paramayeb;
            }
          }
          catch (MalformedURLException paramayeb)
          {
            paramayeb.printStackTrace();
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
  
  public static boolean hasDiskCache(Context paramContext, aydz paramaydz, int paramInt)
  {
    return AbsDownloader.getFile(getURL(paramaydz, paramInt).toString()) != null;
  }
  
  /* Error */
  public static void initVideoAIOSizeByDpc()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 484	com/tencent/mobileqq/transfile/URLDrawableHelper:sVideoSizeInited	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 489	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   18: getstatic 495	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:aio_config	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   21: invokevirtual 498	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   24: ldc_w 500
    //   27: invokevirtual 503	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: ldc_w 505
    //   33: invokevirtual 509	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: arraylength
    //   39: istore_0
    //   40: iload_0
    //   41: ifle +15 -> 56
    //   44: aload_2
    //   45: iconst_0
    //   46: aaload
    //   47: invokestatic 514	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   50: invokevirtual 517	java/lang/Integer:intValue	()I
    //   53: putstatic 58	com/tencent/mobileqq/transfile/URLDrawableHelper:sAioVideoMaxSize	I
    //   56: iconst_1
    //   57: putstatic 484	com/tencent/mobileqq/transfile/URLDrawableHelper:sVideoSizeInited	Z
    //   60: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq -52 -> 11
    //   66: ldc 22
    //   68: iconst_2
    //   69: new 142	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 519
    //   79: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: getstatic 58	com/tencent/mobileqq/transfile/URLDrawableHelper:sAioVideoMaxSize	I
    //   85: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: goto -83 -> 11
    //   97: astore_2
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_2
    //   102: athrow
    //   103: astore_2
    //   104: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +12 -> 119
    //   110: ldc 22
    //   112: iconst_2
    //   113: ldc_w 524
    //   116: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: iconst_m1
    //   120: putstatic 58	com/tencent/mobileqq/transfile/URLDrawableHelper:sAioVideoMaxSize	I
    //   123: goto -67 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	2	0	i	int
    //   6	2	1	bool	boolean
    //   36	9	2	arrayOfString	String[]
    //   97	5	2	localObject	Object
    //   103	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	7	97	finally
    //   15	40	97	finally
    //   44	56	97	finally
    //   56	94	97	finally
    //   104	119	97	finally
    //   119	123	97	finally
    //   44	56	103	java/lang/Exception
  }
  
  public static boolean isAutoDownAt2G3GAbled(Context paramContext)
  {
    return SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694557), "qqsetting_auto_receive_pic_key", true);
  }
  
  public static boolean isMobileNet()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean isMobileNetAndAutodownDisabled(Context paramContext)
  {
    boolean bool1 = AppNetConnInfo.isMobileConn();
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694557), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */