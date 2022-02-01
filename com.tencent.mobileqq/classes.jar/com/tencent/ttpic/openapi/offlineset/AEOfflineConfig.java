package com.tencent.ttpic.openapi.offlineset;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import org.light.bean.PhoneType;
import org.light.device.OfflineConfig;
import org.light.device.OfflineConfig.CutOutVersion;

public class AEOfflineConfig
{
  public static final int DEVICE_PERF_LEVERL_HIGH = 5;
  public static final int DEVICE_PERF_LEVERL_LOW = 2;
  public static final int DEVICE_PERF_LEVERL_MIDDLE = 3;
  public static final int DEVICE_PERF_LEVERL_MIDDLE_HIGH = 4;
  public static final int DEVICE_PERF_LEVERL_VERYLOW = 1;
  private static final String TAG = "OfflineConfig";
  protected static float sGauLowMaxSize = 360.0F;
  protected static float sGauMidMaxSize = 480.0F;
  protected static int sGauMidderPhoneYear = 2015;
  protected static ScaleMode sGauScaleMode = ScaleMode.USE_MAX_SIZE;
  protected static float sGauSuperMaxSzie = 540.0F;
  protected static int sGauSuperPhoneYear = 2017;
  protected static int sGaussMaxSize = -1;
  protected static float sGaussScale = -1.0F;
  protected static boolean sIsGaussResize = true;
  private static boolean sIsHardDecodeEnable = false;
  private static boolean sIsHardEncodeEnable = false;
  protected static int sIsPagEncodeBgStaus = 0;
  protected static int sLowDevYearPag;
  protected static boolean sNeedSoftDecoder;
  protected static boolean sNotSupportRealTimePag;
  protected static int sPagNeedScaleStatus;
  protected static float sPagScaleVaue;
  protected static boolean sUpdateGaussSetting = false;
  public static int useCutoutVersion = OfflineConfig.CutOutVersion.NEW.value;
  
  static
  {
    sLowDevYearPag = 2015;
    sPagNeedScaleStatus = 0;
    sPagScaleVaue = 0.5F;
    sNeedSoftDecoder = false;
    sNotSupportRealTimePag = false;
  }
  
  public static int getGauMaxSize()
  {
    return OfflineConfig.getGauMaxSize();
  }
  
  public static PhoneType getGauPhoneType(int paramInt)
  {
    return OfflineConfig.getGauPhoneType(paramInt);
  }
  
  public static float getGauScaleFromPhoneYear(int paramInt)
  {
    return OfflineConfig.getGauScaleFromPhoneYear(paramInt);
  }
  
  public static ScaleMode getGauScaleMode()
  {
    return sGauScaleMode;
  }
  
  public static float getGauScaleValue()
  {
    return OfflineConfig.getGauScaleValue();
  }
  
  public static int getPagLowDeviceYear()
  {
    return OfflineConfig.getPagLowDeviceYear();
  }
  
  public static int getPagNeedScaleStatus()
  {
    return OfflineConfig.getPagNeedScaleStatus();
  }
  
  public static float getPagPlayScale()
  {
    return OfflineConfig.getPagPlayScale();
  }
  
  public static int getPhonePerfLevel()
  {
    return OfflineConfig.getPhonePerfLevel(AEModule.getContext());
  }
  
  public static int getPhoneType(int paramInt)
  {
    return OfflineConfig.getPhoneType(paramInt);
  }
  
  public static boolean isCouldHardDecode()
  {
    return sIsHardDecodeEnable;
  }
  
  public static boolean isCouldHardEncode()
  {
    return sIsHardEncodeEnable;
  }
  
  public static int isEncodeBackGround()
  {
    return OfflineConfig.isEncodeBackGround();
  }
  
  public static boolean isGausResize()
  {
    return sIsGaussResize;
  }
  
  public static boolean isGaussSettingUpdate()
  {
    return sUpdateGaussSetting;
  }
  
  public static boolean isNeedScale()
  {
    return OfflineConfig.isNeedScale();
  }
  
  public static boolean isNeedSkipRapidnet()
  {
    return OfflineConfig.isNeedSkipRapidnet(AEModule.getContext());
  }
  
  public static boolean isNeedSoftDecode()
  {
    return OfflineConfig.isNeedSoftDecode();
  }
  
  public static boolean isNotSuptPagRealTime()
  {
    return OfflineConfig.isNotSuptPagRealTime();
  }
  
  protected static void setHardDecodeEnable(boolean paramBoolean)
  {
    sIsHardDecodeEnable = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHardDecodeEnable:");
    localStringBuilder.append(paramBoolean);
    LogUtils.i("OfflineConfig", localStringBuilder.toString());
  }
  
  protected static void setHardEncodeEnable(boolean paramBoolean)
  {
    sIsHardEncodeEnable = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHardEncodeEnable:");
    localStringBuilder.append(paramBoolean);
    LogUtils.i("OfflineConfig", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.AEOfflineConfig
 * JD-Core Version:    0.7.0.1
 */