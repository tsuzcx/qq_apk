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
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class URLDrawableHelper
  extends BaseURLDrawableHelper
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
    TRANSPARENT = new ColorDrawable(0);
    sVideoSizeInited = false;
    AIO_IMAGE_MIN_SIZE = 45;
    AIO_IMAGE_MAX_SIZE = Gallery.AIO_IMAGE_MAX_SIZE;
    sAioVideoMaxSize = -1;
    TRANSLUCENT = new ColorDrawable(1073741824);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication != null)
    {
      AIO_IMAGE_MIN_SIZE = (int)DisplayUtils.a(localBaseApplication, 45.0F);
      mTargetDensity = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
    }
  }
  
  public static void decodeLocalImage(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    Object localObject = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (AbsDownloader.hasFile((String)localObject))) {}
    try
    {
      paramURLDrawable.downloadImediatly();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label28:
      break label28;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadImediatly decode OOM,currentAccountUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",d.getURL=");
      ((StringBuilder)localObject).append(paramURLDrawable.getURL());
      QLog.w("URLDrawableHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static Bitmap getCommonProgressBitmap()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("static://CommonProgress");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130839400);
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
    return ((IPicHelper)QRoute.api(IPicHelper.class)).getDrawable(paramPicUiInterface, paramInt, null, null);
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
      label23:
      break label23;
    }
    paramDrawable1 = new StringBuilder();
    paramDrawable1.append("illegal url format: ");
    paramDrawable1.append(paramString);
    throw new IllegalArgumentException(paramDrawable1.toString());
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
  
  public static Drawable getLoadingDrawable()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("static://CommonLoadingDrawable");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838022);
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
    if (localURLDrawable.getStatus() == 1) {
      i = 1;
    } else {
      i = 0;
    }
    URL localURL = getURL(paramPicUiInterface, paramInt);
    if (i != 0) {
      localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);
    } else {
      localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true);
    }
    localURLDrawable.setTargetDensity(mTargetDensity);
    localURLDrawable.setTag(paramPicUiInterface);
    return localURLDrawable;
  }
  
  public static Drawable getStickerFailedDrawable()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("static://CommonFailedDrawable_sticker");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130844572);
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
  
  public static URL getURL(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return getURL(paramPicUiInterface, paramInt, null);
  }
  
  public static URL getURL(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    return ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramPicUiInterface, paramInt, paramString);
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
  
  public static void initVideoAIOSizeByDpc()
  {
    Object localObject1;
    label67:
    try
    {
      boolean bool = sVideoSizeInited;
      if (bool) {
        return;
      }
      localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1").split("\\|");
      int i = localObject1.length;
      if (i <= 0) {}
    }
    finally {}
    try
    {
      sAioVideoMaxSize = Integer.valueOf(localObject1[0]).intValue();
    }
    catch (Exception localException)
    {
      break label67;
    }
    if (QLog.isColorLevel()) {
      QLog.i("URLDrawableHelper", 2, "initVideoThumbSizeByDpc exception");
    }
    sAioVideoMaxSize = -1;
    sVideoSizeInited = true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initVideoThumbSizeByDpc");
      ((StringBuilder)localObject1).append(sAioVideoMaxSize);
      QLog.i("URLDrawableHelper", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static boolean isAutoDownAt2G3GAbled(Context paramContext)
  {
    return SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694986), "qqsetting_auto_receive_pic_key", true);
  }
  
  public static boolean isMobileNet()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean isMobileNetAndAutodownDisabled(Context paramContext)
  {
    boolean bool1 = AppNetConnInfo.isMobileConn();
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694986), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */