package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import aqyb;
import aqyc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AIOImgThumbHelper
{
  private static final String TAG = "AIOImgThumbHelper";
  private static float density = -1.0F;
  private static AIOImgThumbHelper mInstance;
  private static int sAioImageDynamicMax;
  private static int sAioImageDynamicMin;
  private static int sAioImageMaxSize;
  private static int sAioImageMaxSizeUnderLimit;
  private static int sAioImageMinSize;
  private static int sAioImageMinSizeUnderLimit;
  private static int sPicSizeLimit = 650;
  private static boolean sSizeInited;
  
  public static int getAioThumbMaxDp(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean2)
    {
      initAioThumbSize();
      if (paramBoolean1) {
        return sAioImageDynamicMax;
      }
      if (paramInt > sPicSizeLimit) {
        return sAioImageMaxSize;
      }
      return sAioImageMaxSizeUnderLimit;
    }
    return CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean1);
  }
  
  public static int getAioThumbMaxPx(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return (int)(getAioThumbMaxDp(paramBoolean1, paramBoolean2, paramInt) * getDensity());
  }
  
  public static int getAioThumbMinDp(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean2)
    {
      initAioThumbSize();
      if (paramBoolean1) {
        return sAioImageDynamicMin;
      }
      if (paramInt > sPicSizeLimit) {
        return sAioImageMinSize;
      }
      return sAioImageMinSizeUnderLimit;
    }
    return CommonImgThumbHelper.getImgThumbMinDp(paramBoolean1);
  }
  
  public static int getAioThumbMinPx(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return (int)(getAioThumbMinDp(paramBoolean1, paramBoolean2, paramInt) * getDensity());
  }
  
  public static float getDensity()
  {
    if (density == -1.0F)
    {
      density = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if (density <= 0.0F) {
        density = 1.0F;
      }
    }
    return density;
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
        aqyc localaqyc = aqyb.a();
        if ((localaqyc != null) && (localaqyc.jdField_a_of_type_Boolean))
        {
          sAioImageMinSize = localaqyc.d;
          sAioImageMaxSize = localaqyc.c;
          sAioImageDynamicMin = localaqyc.h;
          sAioImageDynamicMax = localaqyc.g;
          sAioImageMinSizeUnderLimit = localaqyc.f;
          sAioImageMaxSizeUnderLimit = localaqyc.e;
          sPicSizeLimit = localaqyc.jdField_b_of_type_Int;
          QLog.d("AIOImgThumbHelper", 1, new Object[] { "maxRatio:", Double.valueOf(localaqyc.jdField_a_of_type_Double), ", minRatio:", Double.valueOf(localaqyc.jdField_b_of_type_Double), ", picSizeLimit:", Integer.valueOf(sPicSizeLimit) });
          sSizeInited = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOImgThumbHelper", 2, new Object[] { "thumbMax:", Integer.valueOf(sAioImageMaxSize), ", thumbMin:", Integer.valueOf(sAioImageMinSize) });
          continue;
        }
        sAioImageMinSize = CommonImgThumbHelper.getImgThumbMinDp(false);
      }
      finally {}
      sAioImageMaxSize = CommonImgThumbHelper.getImgThumbMaxDp(false);
      sAioImageDynamicMin = CommonImgThumbHelper.getImgThumbMinDp(true);
      sAioImageDynamicMax = CommonImgThumbHelper.getImgThumbMaxDp(true);
      sAioImageMinSizeUnderLimit = sAioImageMinSize;
      sAioImageMaxSizeUnderLimit = sAioImageMaxSize;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AIOImgThumbHelper
 * JD-Core Version:    0.7.0.1
 */