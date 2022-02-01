package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class CommonImgThumbHelper
{
  private static final String TAG = "CommonImgThumbHelper";
  private static CommonImgThumbHelper mInstance;
  private static int sImageDynamicMax = 135;
  private static int sImageDynamicMin = 45;
  private static int sImageMaxSize = 135;
  private static int sImageMinSize = 45;
  private static boolean sSizeInited = false;
  private static int sThumbnailDynamicMax;
  private static int sThumbnailDynamicMin;
  private static int sThumbnailMax;
  private static int sThumbnailMin = sImageMinSize;
  
  static
  {
    sThumbnailMax = sImageMaxSize;
    sThumbnailDynamicMin = sImageDynamicMin;
    sThumbnailDynamicMax = sImageDynamicMax;
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
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new CommonImgThumbHelper();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public static ThumbWidthHeightDP getThumbWidthHeightDP(boolean paramBoolean)
  {
    int i = getImgThumbMinDp(paramBoolean);
    int j = getImgThumbMaxDp(paramBoolean);
    return new ThumbWidthHeightDP(i, i, j, j);
  }
  
  public static void initAioThumbSizeByDpc()
  {
    getInstance().initAioThumbSizeByDpcInner();
  }
  
  public void initAioThumbSizeByDpcInner()
  {
    try
    {
      boolean bool = sSizeInited;
      if (bool) {
        return;
      }
      String[] arrayOfString = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_pic_thumb_size.name(), "135|135").split("\\|");
      if (arrayOfString.length == 2)
      {
        int i = Integer.valueOf(arrayOfString[0]).intValue();
        if ((i >= 45) && (i <= 198)) {
          sImageMaxSize = i;
        }
        i = Integer.valueOf(arrayOfString[1]).intValue();
        if ((i >= 45) && (i <= 198)) {
          sImageDynamicMax = i;
        }
      }
      MobileQQ.getContext();
      float f2 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
      float f1 = f2;
      if (f2 <= 0.0F) {
        f1 = 1.0F;
      }
      sThumbnailMax = (int)(sImageMaxSize * f1);
      sThumbnailDynamicMax = (int)(sImageDynamicMax * f1);
      sThumbnailMin = (int)(sImageMinSize * f1);
      sThumbnailDynamicMin = (int)(sImageDynamicMin * f1);
      sSizeInited = true;
      if (QLog.isColorLevel()) {
        QLog.d("CommonImgThumbHelper", 2, new Object[] { "thumbMax:", Integer.valueOf(sThumbnailMax), ", thumbMin:", Integer.valueOf(sThumbnailDynamicMax) });
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.CommonImgThumbHelper
 * JD-Core Version:    0.7.0.1
 */