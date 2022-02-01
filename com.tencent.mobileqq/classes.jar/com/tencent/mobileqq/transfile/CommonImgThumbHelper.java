package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class CommonImgThumbHelper
{
  private static final String TAG = "CommonImgThumbHelper";
  private static CommonImgThumbHelper mInstance;
  private static int sImageDynamicMax;
  private static int sImageDynamicMin;
  private static int sImageMaxSize;
  private static int sImageMinSize = 45;
  private static boolean sSizeInited;
  private static int sThumbnailDynamicMax = sImageDynamicMax;
  private static int sThumbnailDynamicMin;
  private static int sThumbnailMax;
  private static int sThumbnailMin;
  
  static
  {
    sImageMaxSize = 135;
    sImageDynamicMin = 45;
    sImageDynamicMax = 135;
    sThumbnailMin = sImageMinSize;
    sThumbnailMax = sImageMaxSize;
    sThumbnailDynamicMin = sImageDynamicMin;
  }
  
  public static int getImgThumbMaxDp(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sImageDynamicMax;
    }
    return sImageMaxSize;
  }
  
  public static int getImgThumbMaxPx(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sThumbnailDynamicMax;
    }
    return sThumbnailMax;
  }
  
  public static int getImgThumbMinDp(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sImageDynamicMin;
    }
    return sImageMinSize;
  }
  
  public static int getImgThumbMinPx(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sThumbnailDynamicMin;
    }
    return sThumbnailMin;
  }
  
  public static CommonImgThumbHelper getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new CommonImgThumbHelper();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static void initAioThumbSizeByDpc()
  {
    getInstance().initAioThumbSizeByDpcInner();
  }
  
  public DeviceProfileManager getDeviceProfileManager()
  {
    return DeviceProfileManager.a();
  }
  
  public void initAioThumbSizeByDpcInner()
  {
    for (;;)
    {
      try
      {
        boolean bool = sSizeInited;
        if (bool) {
          return;
        }
        String[] arrayOfString = getDeviceProfileManager().a(DeviceProfileManager.DpcNames.aio_pic_thumb_size.name(), "135|135").split("\\|");
        if (arrayOfString.length == 2)
        {
          i = Integer.valueOf(arrayOfString[0]).intValue();
          if ((i >= 45) && (i <= 198)) {
            sImageMaxSize = i;
          }
          i = Integer.valueOf(arrayOfString[1]).intValue();
          if ((i >= 45) && (i <= 198)) {
            sImageDynamicMax = i;
          }
        }
        float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
        sThumbnailMax = (int)(sImageMaxSize * f);
        sThumbnailDynamicMax = (int)(sImageDynamicMax * f);
        sThumbnailMin = (int)(sImageMinSize * f);
        sThumbnailDynamicMin = (int)(f * sImageDynamicMin);
        if (sThumbnailMax == 0)
        {
          i = sImageMaxSize;
          sThumbnailMax = i;
          if (sThumbnailDynamicMax != 0) {
            break label272;
          }
          i = sImageDynamicMax;
          sThumbnailDynamicMax = i;
          if (sThumbnailMin != 0) {
            break label279;
          }
          i = sImageMinSize;
          sThumbnailMin = i;
          if (sThumbnailDynamicMin != 0) {
            break label286;
          }
          i = sImageDynamicMin;
          sThumbnailDynamicMin = i;
          sSizeInited = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CommonImgThumbHelper", 2, new Object[] { "thumbMax:", Integer.valueOf(sThumbnailMax), ", thumbMin:", Integer.valueOf(sThumbnailDynamicMax) });
          continue;
        }
        i = sThumbnailMax;
      }
      finally {}
      continue;
      label272:
      int i = sThumbnailDynamicMax;
      continue;
      label279:
      i = sThumbnailMin;
      continue;
      label286:
      i = sThumbnailDynamicMin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.CommonImgThumbHelper
 * JD-Core Version:    0.7.0.1
 */