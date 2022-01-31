package com.tencent.ttpic.openapi.offlineset;

import android.content.Context;
import android.os.Build;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.YearClass;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.offlineset.beans.VLowDeviceModelListJsonBean;
import com.tencent.ttpic.offlineset.enumclass.PhoneType;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.List;

public class OfflineConfig
{
  private static final int DEVICE_PERF_LEVERL_HIGH = 4;
  public static final int DEVICE_PERF_LEVERL_LOW = 2;
  private static final int DEVICE_PERF_LEVERL_MIDDLE = 3;
  private static final int DEVICE_PERF_LEVERL_VERYLOW = 1;
  private static final String TAG = "OfflineConfig";
  private static final String TAG_DEVICE_PERF_LEVERL_HIGH = "benchmark/high/";
  private static final String TAG_DEVICE_PERF_LEVERL_LOW = "benchmark/low/";
  private static final String TAG_DEVICE_PERF_LEVERL_MIDDLE = "benchmark/middle/";
  private static final String TAG_DEVICE_PERF_LEVERL_VERYLOW = "benchmark/vlow/";
  public static String sAIBeautyParamFilePath;
  public static AIBeautyParamsJsonBean sAIBeautyParamJsonBean;
  private static List<String> sDeviceListFromAsserts;
  public static int sDevicePerfLevel = -1;
  protected static float sGauLowMaxSize;
  protected static int sGauLowPhoneYear;
  protected static float sGauMidMaxSize;
  protected static int sGauMidderPhoneYear;
  protected static ScaleMode sGauScaleMode;
  protected static float sGauSuperMaxSzie;
  protected static int sGauSuperPhoneYear;
  protected static int sGaussMaxSize;
  protected static float sGaussScale;
  protected static boolean sIsGaussResize;
  private static boolean sIsHardDecodeEnable;
  private static boolean sIsHardEncodeEnable = false;
  protected static int sIsPagEncodeBgStaus;
  protected static int sLowDevYearPag;
  protected static int sLowDevYearRapidnet;
  public static boolean sNeedShieldDefaultFilterChain;
  protected static boolean sNeedSoftDecoder;
  protected static boolean sNotSupportRealTimePag;
  protected static int sPagNeedScaleStatus;
  protected static float sPagScaleVaue;
  protected static int sRapidnetSkipMode;
  protected static boolean sUpdateGaussSetting;
  private static long sVLowRAM;
  private static int sVLowYear;
  private static long sVeryLowFrequency;
  public static int useCutoutVersion;
  
  static
  {
    sIsHardDecodeEnable = false;
    sVLowYear = 2013;
    sVLowRAM = 0L;
    sVeryLowFrequency = 1500000L;
    sGauSuperPhoneYear = 2017;
    sGauMidderPhoneYear = 2015;
    sGauLowPhoneYear = 2014;
    sGauSuperMaxSzie = 540.0F;
    sGauMidMaxSize = 480.0F;
    sGauLowMaxSize = 360.0F;
    sIsGaussResize = true;
    sGaussMaxSize = -1;
    sGaussScale = -1.0F;
    sGauScaleMode = ScaleMode.USE_MAX_SIZE;
    sUpdateGaussSetting = false;
    sLowDevYearRapidnet = 2015;
    sRapidnetSkipMode = 0;
    sLowDevYearPag = 2015;
    sPagNeedScaleStatus = 0;
    sPagScaleVaue = 0.5F;
    sNeedSoftDecoder = false;
    sNotSupportRealTimePag = false;
    sIsPagEncodeBgStaus = 0;
    useCutoutVersion = OfflineConfig.CutOutVersion.NEW.value;
    sAIBeautyParamJsonBean = PtuOfflineParser.getInstance().getDefaultAIBeautyParam();
    sNeedShieldDefaultFilterChain = false;
  }
  
  private static List<String> getBenchMarkDeviceList(String paramString)
  {
    sDeviceListFromAsserts = new ArrayList();
    paramString = paramString + Build.BRAND.toLowerCase() + ".json";
    if (paramString == null) {}
    do
    {
      return null;
      paramString = FileOfflineUtil.readStringFromAssets(paramString);
    } while (paramString == null);
    paramString = (VLowDeviceModelListJsonBean)GsonUtils.json2Obj(paramString, new OfflineConfig.1().getType());
    if ((paramString != null) && (paramString.modelList != null)) {
      sDeviceListFromAsserts.addAll(paramString.modelList);
    }
    return sDeviceListFromAsserts;
  }
  
  private static String getDeviceTAG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "benchmark/vlow/";
    case 2: 
      return "benchmark/low/";
    case 3: 
      return "benchmark/middle/";
    }
    return "benchmark/high/";
  }
  
  public static int getGauMaxSize()
  {
    return sGaussMaxSize;
  }
  
  public static PhoneType getGauPhoneType(int paramInt)
  {
    if (paramInt >= sGauSuperPhoneYear) {
      return PhoneType.SUPER_PHONE;
    }
    if (paramInt >= sGauMidderPhoneYear) {
      return PhoneType.MIDDER_PHONE;
    }
    return PhoneType.LOW_PHONE;
  }
  
  public static float getGauScaleFromPhoneYear(int paramInt)
  {
    switch (OfflineConfig.2.$SwitchMap$com$tencent$ttpic$offlineset$enumclass$PhoneType[getGauPhoneType(paramInt).ordinal()])
    {
    default: 
      return -1.0F;
    case 1: 
      return sGauSuperMaxSzie;
    case 2: 
      return sGauMidMaxSize;
    }
    return sGauLowMaxSize;
  }
  
  public static ScaleMode getGauScaleMode()
  {
    return sGauScaleMode;
  }
  
  public static float getGauScaleValue()
  {
    return sGaussScale;
  }
  
  public static int getPagLowDeviceYear()
  {
    return sLowDevYearPag;
  }
  
  public static int getPagNeedScaleStatus()
  {
    return sPagNeedScaleStatus;
  }
  
  public static float getPagPlayScale()
  {
    return sPagScaleVaue;
  }
  
  public static int getPhonePerfLevel()
  {
    int i = 2;
    if (isVeryLowDeviceByBenchmark()) {
      i = 1;
    }
    while (isMatchPerfLever(2)) {
      return i;
    }
    if (isMatchPerfLever(3)) {
      return 3;
    }
    if (isMatchPerfLever(4)) {
      return 4;
    }
    return getPhoneType(YearClass.get(AEModule.getContext()));
  }
  
  public static int getPhoneType(int paramInt)
  {
    if (paramInt >= sGauSuperPhoneYear) {
      return 4;
    }
    if (paramInt >= sGauMidderPhoneYear) {
      return 3;
    }
    if (paramInt >= sGauLowPhoneYear) {
      return 2;
    }
    return 1;
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
    return sIsPagEncodeBgStaus;
  }
  
  public static boolean isGausResize()
  {
    return sIsGaussResize;
  }
  
  public static boolean isGaussSettingUpdate()
  {
    return sUpdateGaussSetting;
  }
  
  private static boolean isMatchPerfLever(int paramInt)
  {
    boolean bool = true;
    if (sDevicePerfLevel >= 0) {
      return sDevicePerfLevel == paramInt;
    }
    List localList = getBenchMarkDeviceList(getDeviceTAG(paramInt));
    if ((localList != null) && (localList.contains(Build.MODEL.toLowerCase())))
    {
      LogUtils.i("OfflineConfig", "DeviceByBenchmark:model:" + paramInt + Build.MODEL.toLowerCase() + " isInList:" + bool);
      if (!bool) {
        break label105;
      }
    }
    for (;;)
    {
      sDevicePerfLevel = paramInt;
      return bool;
      bool = false;
      break;
      label105:
      paramInt = -1;
    }
  }
  
  public static boolean isNeedScale()
  {
    return ((sPagNeedScaleStatus == 0) && (YearClass.get(null) <= sLowDevYearPag)) || (sPagNeedScaleStatus == 1);
  }
  
  public static boolean isNeedSkipRapidnet()
  {
    return ((sRapidnetSkipMode == 0) && (YearClass.get(AEModule.getContext()) <= sLowDevYearRapidnet)) || (sRapidnetSkipMode == 1);
  }
  
  public static boolean isNeedSoftDecode()
  {
    return sNeedSoftDecoder;
  }
  
  public static boolean isNotSuptPagRealTime()
  {
    return sNotSupportRealTimePag;
  }
  
  public static boolean isVeryLowDeviceByBenchmark()
  {
    boolean bool2 = false;
    int i = 1;
    if (sDevicePerfLevel >= 0) {
      return sDevicePerfLevel == 1;
    }
    Object localObject = getBenchMarkDeviceList("benchmark/vlow/");
    if ((localObject != null) && (((List)localObject).contains(Build.MODEL.toLowerCase()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      LogUtils.i("OfflineConfig", "isVeryLowDeviceByBenchmark:model:" + Build.MODEL.toLowerCase() + " isInList:" + bool1);
      if (!bool1) {
        break;
      }
      sDevicePerfLevel = 1;
      return true;
    }
    localObject = AEModule.getContext();
    int j = YearClass.get((Context)localObject);
    long l1 = DeviceUtils.getTotalRamMemory((Context)localObject);
    long l2 = DeviceUtils.getMaxCpuFreq();
    if (j > sVLowYear)
    {
      bool1 = bool2;
      if (l1 <= sVLowRAM)
      {
        bool1 = bool2;
        if (l2 >= sVeryLowFrequency) {}
      }
    }
    else
    {
      bool1 = true;
    }
    if (bool1) {}
    for (;;)
    {
      sDevicePerfLevel = i;
      return bool1;
      i = -1;
    }
  }
  
  protected static void setHardDecodeEnable(boolean paramBoolean)
  {
    sIsHardDecodeEnable = paramBoolean;
    LogUtils.i("OfflineConfig", "setHardDecodeEnable:" + paramBoolean);
  }
  
  protected static void setHardEncodeEnable(boolean paramBoolean)
  {
    sIsHardEncodeEnable = paramBoolean;
    LogUtils.i("OfflineConfig", "setHardEncodeEnable:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.OfflineConfig
 * JD-Core Version:    0.7.0.1
 */