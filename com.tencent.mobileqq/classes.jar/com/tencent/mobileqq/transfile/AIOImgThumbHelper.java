package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.guild.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AIOImgThumbHelper
{
  private static final String TAG = "AIOImgThumbHelper";
  private static float density = -1.0F;
  private static AIOImgThumbHelper mInstance;
  private static int sAioImageDynamicMax = 0;
  private static int sAioImageDynamicMin = 0;
  private static int sAioImageMaxSize = 0;
  private static int sAioImageMaxSizeUnderLimit = 0;
  private static int sAioImageMinSize = 0;
  private static int sAioImageMinSizeUnderLimit = 0;
  private static int sPicSizeLimit = 650;
  private static boolean sSizeInited = false;
  
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
      density = MobileQQ.getContext().getResources().getDisplayMetrics().density;
      if (density <= 0.0F) {
        density = 1.0F;
      }
    }
    return density;
  }
  
  public static AIOImgThumbHelper getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new AIOImgThumbHelper();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public static ThumbWidthHeightDP getThumbWidthHeightDP(MessageForPic paramMessageForPic, boolean paramBoolean)
  {
    if (paramMessageForPic.thumbWidthHeightDP == null)
    {
      boolean bool = ((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramMessageForPic);
      int i = (int)Math.max(paramMessageForPic.width, paramMessageForPic.height);
      if ((paramMessageForPic.istroop == 10014) && (!((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramMessageForPic))) {
        paramMessageForPic.thumbWidthHeightDP = ((IGuildPicAIO)QRoute.api(IGuildPicAIO.class)).getThumbWidthHeightDPForGuildPicMsg();
      } else {
        paramMessageForPic.thumbWidthHeightDP = getThumbWidthHeightDPForPicMsg(paramBoolean, bool ^ true, i);
      }
    }
    return paramMessageForPic.thumbWidthHeightDP;
  }
  
  public static ThumbWidthHeightDP getThumbWidthHeightDPForPicMsg(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!paramBoolean2) {
      return CommonImgThumbHelper.getThumbWidthHeightDP(paramBoolean1);
    }
    int i = getAioThumbMinDp(paramBoolean1, paramBoolean2, paramInt);
    paramInt = getAioThumbMaxDp(paramBoolean1, paramBoolean2, paramInt);
    return new ThumbWidthHeightDP(i, i, paramInt, paramInt);
  }
  
  public static void initAioThumbSize()
  {
    getInstance().initAioThumbSizeInner();
  }
  
  public void initAioThumbSizeInner()
  {
    try
    {
      boolean bool = sSizeInited;
      if (bool) {
        return;
      }
      AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig = AIOPicThumbSizeProcessor.a();
      if ((localAIOPicThumbSizeConfig != null) && (localAIOPicThumbSizeConfig.a))
      {
        sAioImageMinSize = localAIOPicThumbSizeConfig.g;
        sAioImageMaxSize = localAIOPicThumbSizeConfig.f;
        sAioImageDynamicMin = localAIOPicThumbSizeConfig.k;
        sAioImageDynamicMax = localAIOPicThumbSizeConfig.j;
        sAioImageMinSizeUnderLimit = localAIOPicThumbSizeConfig.i;
        sAioImageMaxSizeUnderLimit = localAIOPicThumbSizeConfig.h;
        sPicSizeLimit = localAIOPicThumbSizeConfig.e;
        QLog.d("AIOImgThumbHelper", 1, new Object[] { "maxRatio:", Double.valueOf(localAIOPicThumbSizeConfig.b), ", minRatio:", Double.valueOf(localAIOPicThumbSizeConfig.c), ", picSizeLimit:", Integer.valueOf(sPicSizeLimit) });
      }
      else
      {
        sAioImageMinSize = CommonImgThumbHelper.getImgThumbMinDp(false);
        sAioImageMaxSize = CommonImgThumbHelper.getImgThumbMaxDp(false);
        sAioImageDynamicMin = CommonImgThumbHelper.getImgThumbMinDp(true);
        sAioImageDynamicMax = CommonImgThumbHelper.getImgThumbMaxDp(true);
        sAioImageMinSizeUnderLimit = sAioImageMinSize;
        sAioImageMaxSizeUnderLimit = sAioImageMaxSize;
      }
      sSizeInited = true;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImgThumbHelper", 2, new Object[] { "thumbMax:", Integer.valueOf(sAioImageMaxSize), ", thumbMin:", Integer.valueOf(sAioImageMinSize) });
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AIOImgThumbHelper
 * JD-Core Version:    0.7.0.1
 */