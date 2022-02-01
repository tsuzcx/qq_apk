package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import apuy;
import apuz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AIOImgThumbHelper
{
  private static final String TAG = "AIOImgThumbHelper";
  private static AIOImgThumbHelper mInstance;
  private static int sAioImageDynamicMax;
  private static int sAioImageDynamicMin;
  private static int sAioImageMaxSize;
  private static int sAioImageMinSize = 45;
  private static int sAioThumbnailDynamicMax = sAioImageDynamicMax;
  private static int sAioThumbnailDynamicMin;
  private static int sAioThumbnailMax;
  private static int sAioThumbnailMin;
  private static boolean sSizeInited;
  public float abTestMaxRatio;
  public float abTestMinRatio;
  public boolean useABTest;
  
  static
  {
    sAioImageMaxSize = 135;
    sAioImageDynamicMin = 45;
    sAioImageDynamicMax = 135;
    sAioThumbnailMin = sAioImageMinSize;
    sAioThumbnailMax = sAioImageMaxSize;
    sAioThumbnailDynamicMin = sAioImageDynamicMin;
  }
  
  public static int getAioThumbMaxDp(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      initAioThumbSize();
      if (paramBoolean1) {
        return sAioImageDynamicMax;
      }
      return sAioImageMaxSize;
    }
    return CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean1);
  }
  
  public static int getAioThumbMaxPx(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      initAioThumbSize();
      if (paramBoolean1) {
        return sAioThumbnailDynamicMax;
      }
      return sAioThumbnailMax;
    }
    return CommonImgThumbHelper.getImgThumbMaxPx(paramBoolean1);
  }
  
  public static int getAioThumbMinDp(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      initAioThumbSize();
      if (paramBoolean1) {
        return sAioImageDynamicMin;
      }
      return sAioImageMinSize;
    }
    return CommonImgThumbHelper.getImgThumbMinDp(paramBoolean1);
  }
  
  public static int getAioThumbMinPx(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      initAioThumbSize();
      if (paramBoolean1) {
        return sAioThumbnailDynamicMin;
      }
      return sAioThumbnailMin;
    }
    return CommonImgThumbHelper.getImgThumbMinPx(paramBoolean1);
  }
  
  public static AIOImgThumbHelper getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new AIOImgThumbHelper();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static void initAioThumbSize()
  {
    getInstance().initAioThumbSizeInner();
  }
  
  public void initAioThumbSizeInner()
  {
    for (;;)
    {
      try
      {
        boolean bool = sSizeInited;
        if (bool) {
          return;
        }
        float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
        if (!this.useABTest)
        {
          apuz localapuz = apuy.a();
          if ((localapuz == null) || (!localapuz.jdField_a_of_type_Boolean)) {
            break label283;
          }
          sAioImageMinSize = localapuz.c;
          sAioImageMaxSize = localapuz.jdField_b_of_type_Int;
          sAioImageDynamicMin = localapuz.e;
          sAioImageDynamicMax = localapuz.d;
          if (f > 0.0F)
          {
            i = (int)(sAioImageMinSize * f);
            sAioThumbnailMin = i;
            if (f <= 0.0F) {
              break label262;
            }
            i = (int)(sAioImageMaxSize * f);
            sAioThumbnailMax = i;
            if (f <= 0.0F) {
              break label269;
            }
            i = (int)(sAioImageDynamicMin * f);
            sAioThumbnailDynamicMin = i;
            if (f <= 0.0F) {
              break label276;
            }
            i = (int)(sAioImageDynamicMax * f);
            sAioThumbnailDynamicMax = i;
            QLog.d("AIOImgThumbHelper", 1, new Object[] { "maxRatio:", Double.valueOf(localapuz.jdField_a_of_type_Double), ", minRatio:", Double.valueOf(localapuz.jdField_b_of_type_Double) });
          }
        }
        else
        {
          sSizeInited = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOImgThumbHelper", 2, new Object[] { "thumbMax:", Integer.valueOf(sAioThumbnailMax), ", thumbMin:", Integer.valueOf(sAioThumbnailDynamicMax) });
          continue;
        }
        i = sAioImageMinSize;
      }
      finally {}
      continue;
      label262:
      int i = sAioImageMaxSize;
      continue;
      label269:
      i = sAioImageDynamicMin;
      continue;
      label276:
      i = sAioImageDynamicMax;
      continue;
      label283:
      sAioImageMinSize = CommonImgThumbHelper.getImgThumbMinDp(false);
      sAioImageMaxSize = CommonImgThumbHelper.getImgThumbMaxDp(false);
      sAioImageDynamicMin = CommonImgThumbHelper.getImgThumbMinDp(true);
      sAioImageDynamicMax = CommonImgThumbHelper.getImgThumbMaxDp(true);
      sAioThumbnailMin = CommonImgThumbHelper.getImgThumbMinPx(false);
      sAioThumbnailMax = CommonImgThumbHelper.getImgThumbMaxPx(false);
      sAioThumbnailDynamicMin = CommonImgThumbHelper.getImgThumbMinPx(true);
      sAioThumbnailDynamicMax = CommonImgThumbHelper.getImgThumbMaxPx(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AIOImgThumbHelper
 * JD-Core Version:    0.7.0.1
 */