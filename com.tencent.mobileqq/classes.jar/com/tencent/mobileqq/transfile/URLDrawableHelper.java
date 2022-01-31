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
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class URLDrawableHelper
{
  public static int a;
  public static Bitmap.Config a;
  public static final Drawable a;
  public static File a;
  private static boolean a;
  public static int b;
  public static Bitmap.Config b;
  public static final Drawable b;
  private static boolean b;
  public static int c;
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private static int k;
  private static int l;
  private static int m;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    jdField_b_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.RGB_565;
    jdField_a_of_type_Int = 921600;
    e = 45;
    f = 135;
    g = 45;
    h = 135;
    i = e;
    j = f;
    k = g;
    l = h;
    jdField_b_of_type_Int = 45;
    c = 135;
    m = -1;
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1073741824);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_b_of_type_Int = (int)DisplayUtils.a(localBaseApplication, 45.0F);
    c = (int)DisplayUtils.a(localBaseApplication, 135.0F);
    d = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
  }
  
  public static int a()
  {
    b();
    return m;
  }
  
  public static int a(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int n = 65537;
    if ("chatthumb".equals(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatImageDownloader", 2, "getFileSizeType protocol:" + paramString + ",output_type:" + n);
      }
      return n;
      if ("chatimg".equals(paramString))
      {
        if (paramBoolean) {
          n = 1;
        } else {
          n = 131075;
        }
      }
      else if ("chatraw".equals(paramString)) {
        n = 131075;
      }
    }
  }
  
  public static int a(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return l;
    }
    return j;
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838595);
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
  
  public static Drawable a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonFailedDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130837619);
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
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null, null);
  }
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    boolean bool2 = true;
    if (paramPicUiInterface == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(a(paramPicUiInterface, paramInt, paramString), paramURLDrawableOptions);
    paramString.setTag(paramPicUiInterface);
    if (paramPicUiInterface.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!PicContants.jdField_b_of_type_Boolean) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131433572), "qqsetting_auto_receive_pic_key", true);
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
  
  public static URLDrawable a(String paramString)
  {
    return a(paramString, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramString, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    try
    {
      paramDrawable1 = a(new URL(paramString), paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, paramFloat);
      return paramDrawable1;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public static URLDrawable a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramString, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL)
  {
    return a(paramURL, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2)
  {
    return a(paramURL, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return a(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
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
  
  public static URLDrawable a(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramURL, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo)
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
      return "C2C";
    case 1: 
      return "Troup";
    }
    return "Disscussion";
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo, int paramInt)
  {
    int n;
    String str;
    if (paramInt == 65537)
    {
      n = 1;
      str = null;
      if (paramInt != 65537) {
        break label63;
      }
      str = "chatthumb";
      label19:
      switch (paramPicBaseInfo.jdField_b_of_type_Int)
      {
      }
    }
    label63:
    do
    {
      return str;
      n = 0;
      break;
      if (paramInt == 1)
      {
        str = "chatimg";
        break label19;
      }
      if (paramInt != 131075) {
        break label19;
      }
      str = "chatraw";
      break label19;
      return "favimage";
    } while (paramPicBaseInfo.d >= 3);
    if (n != 0) {
      return "lbsthumb";
    }
    return "lbsimg";
  }
  
  public static URL a(PicDownloadInfo paramPicDownloadInfo, int paramInt, String paramString)
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
          break label200;
        }
        paramPicDownloadInfo = new URL(paramString, null, str2);
        return paramPicDownloadInfo;
      }
      catch (MalformedURLException paramPicDownloadInfo)
      {
        label184:
        paramPicDownloadInfo.printStackTrace();
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
      paramString = a(paramPicDownloadInfo, paramInt);
      break label48;
      label200:
      paramPicDownloadInfo = null;
    }
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null);
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    if (paramPicUiInterface == null) {
      return null;
    }
    if (paramPicUiInterface.isSendFromLocal()) {
      return a(paramPicUiInterface.getPicUploadInfo(), paramInt, paramString);
    }
    return a(paramPicUiInterface.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL a(PicUploadInfo paramPicUploadInfo, int paramInt, String paramString)
  {
    if (paramPicUploadInfo == null) {
      return null;
    }
    if (paramPicUploadInfo.d < 4) {}
    for (String str2 = a(paramPicUploadInfo);; str2 = null)
    {
      String str3 = a(paramPicUploadInfo, paramInt);
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
  
  public static URL a(String paramString, int paramInt)
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
  
  public static void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        String[] arrayOfString = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_pic_thumb_size.name(), "135|135").split("\\|");
        if (arrayOfString.length == 2)
        {
          n = Integer.valueOf(arrayOfString[0]).intValue();
          if ((n >= 45) && (n <= 198)) {
            f = n;
          }
          n = Integer.valueOf(arrayOfString[1]).intValue();
          if ((n >= 45) && (n <= 198)) {
            h = n;
          }
        }
        float f1 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
        j = (int)(f * f1);
        l = (int)(h * f1);
        i = (int)(e * f1);
        k = (int)(f1 * g);
        if (j == 0)
        {
          n = f;
          j = n;
          if (l != 0) {
            break label267;
          }
          n = h;
          l = n;
          if (i != 0) {
            break label274;
          }
          n = e;
          i = n;
          if (k != 0) {
            break label281;
          }
          n = g;
          k = n;
          jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("URLDrawableHelper", 2, j + "|" + l);
          continue;
        }
        n = j;
      }
      finally {}
      continue;
      label267:
      int n = l;
      continue;
      label274:
      n = i;
      continue;
      label281:
      n = k;
    }
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (AbsDownloader.a(str))) {}
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
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = AppNetConnInfo.isMobileConn();
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131433572), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
  
  public static boolean a(Context paramContext, PicUiInterface paramPicUiInterface, int paramInt)
  {
    return AbsDownloader.a(a(paramPicUiInterface, paramInt).toString()) != null;
  }
  
  public static int b(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return k;
    }
    return i;
  }
  
  public static Drawable b()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonLoadingDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130837617);
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
  
  public static URLDrawable b(PicUiInterface paramPicUiInterface, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(a(paramPicUiInterface, 65537));
    localURLDrawable.setTargetDensity(d);
    int n;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      n = 1;
      localURL = a(paramPicUiInterface, paramInt);
      if (n == 0) {
        break label68;
      }
    }
    label68:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(d);
      localURLDrawable.setTag(paramPicUiInterface);
      return localURLDrawable;
      n = 0;
      break;
    }
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 500	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_b_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 402	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   18: getstatic 503	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:aio_config	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   21: invokevirtual 411	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   24: ldc_w 505
    //   27: invokevirtual 416	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: ldc_w 418
    //   33: invokevirtual 422	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: arraylength
    //   39: istore_0
    //   40: iload_0
    //   41: ifle +15 -> 56
    //   44: aload_2
    //   45: iconst_0
    //   46: aaload
    //   47: invokestatic 428	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   50: invokevirtual 431	java/lang/Integer:intValue	()I
    //   53: putstatic 61	com/tencent/mobileqq/transfile/URLDrawableHelper:m	I
    //   56: iconst_1
    //   57: putstatic 500	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_b_of_type_Boolean	Z
    //   60: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq -52 -> 11
    //   66: ldc_w 344
    //   69: iconst_2
    //   70: new 136	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 507
    //   80: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: getstatic 61	com/tencent/mobileqq/transfile/URLDrawableHelper:m	I
    //   86: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -84 -> 11
    //   98: astore_2
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +13 -> 121
    //   111: ldc_w 344
    //   114: iconst_2
    //   115: ldc_w 509
    //   118: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iconst_m1
    //   122: putstatic 61	com/tencent/mobileqq/transfile/URLDrawableHelper:m	I
    //   125: goto -69 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	2	0	n	int
    //   6	2	1	bool	boolean
    //   36	9	2	arrayOfString	String[]
    //   98	5	2	localObject	Object
    //   104	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	7	98	finally
    //   15	40	98	finally
    //   44	56	98	finally
    //   56	95	98	finally
    //   105	121	98	finally
    //   121	125	98	finally
    //   44	56	104	java/lang/Exception
  }
  
  public static boolean b(Context paramContext)
  {
    return SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131433572), "qqsetting_auto_receive_pic_key", true);
  }
  
  public static int c(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return h;
    }
    return f;
  }
  
  public static Drawable c()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://CommonFailedDrawable_sticker");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130841825);
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
  
  public static int d(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return g;
    }
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */