package com.tencent.ttpic.openapi.offlineset;

import android.content.Context;
import android.os.Build;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.YearClass;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.offlineset.beans.DeviceModelListJsonBean;
import com.tencent.ttpic.offlineset.enumclass.PhoneType;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.List;

public class OfflineConfig
{
  public static final int DEVICE_PERF_LEVERL_HIGH = 5;
  public static final int DEVICE_PERF_LEVERL_LOW = 2;
  public static final int DEVICE_PERF_LEVERL_MIDDLE = 3;
  public static final int DEVICE_PERF_LEVERL_MIDDLE_HIGH = 4;
  public static final int DEVICE_PERF_LEVERL_VERYLOW = 1;
  private static final String TAG = "OfflineConfig";
  private static final String TAG_DEVICE_PERF_LEVERL_HIGH = "benchmark/high/";
  private static final String TAG_DEVICE_PERF_LEVERL_LOW = "benchmark/low/";
  private static final String TAG_DEVICE_PERF_LEVERL_MIDDLE = "benchmark/middle/";
  private static final String TAG_DEVICE_PERF_LEVERL_MIDDLE_HIGH = "benchmark/mhigh/";
  private static final String TAG_DEVICE_PERF_LEVERL_VERYLOW = "benchmark/vlow/";
  public static String sAIBeautyParamFilePath;
  public static AIBeautyParamsJsonBean sAIBeautyParamJsonBean;
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
  protected static int sPhonePerfLevel = -1;
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
    sVLowRAM = 4294967296L;
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
    ArrayList localArrayList = new ArrayList();
    Object localObject = Build.BRAND.toLowerCase();
    if ("honor".equals(Build.BRAND.toLowerCase())) {
      localObject = "huawei";
    }
    String str = FileOfflineUtil.readStringFromAssets(paramString + (String)localObject + ".json");
    localObject = str;
    if (str == null)
    {
      paramString = FileOfflineUtil.readStringFromAssets(paramString + "misc.json");
      localObject = paramString;
      if (paramString == null) {
        return null;
      }
    }
    paramString = (DeviceModelListJsonBean)GsonUtils.json2Obj((String)localObject, new OfflineConfig.1().getType());
    if ((paramString != null) && (paramString.modelList != null)) {}
    try
    {
      localArrayList.addAll(paramString.modelList);
      return localArrayList;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LogUtils.e("OfflineConfig", "getBenchMarkDeviceList:" + paramString.getMessage());
      }
    }
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
    case 4: 
      return "benchmark/mhigh/";
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
    if (sPhonePerfLevel != -1) {
      return sPhonePerfLevel;
    }
    if (isVeryLowDeviceByBenchmark()) {
      i = 1;
    }
    for (;;)
    {
      sPhonePerfLevel = i;
      return sPhonePerfLevel;
      if (!isMatchPerfLever(2)) {
        if (isMatchPerfLever(3)) {
          i = 3;
        } else if (isMatchPerfLever(4)) {
          i = 4;
        } else if (isMatchPerfLever(5)) {
          i = 5;
        } else {
          i = getPhoneType(YearClass.get(AEModule.getContext()));
        }
      }
    }
  }
  
  public static int getPhoneType(int paramInt)
  {
    if (paramInt >= sGauSuperPhoneYear) {
      return 5;
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
    bool1 = true;
    if (sDevicePerfLevel >= 0) {
      return sDevicePerfLevel == paramInt;
    }
    for (;;)
    {
      try
      {
        List localList = getBenchMarkDeviceList(getDeviceTAG(paramInt));
        if (localList == null) {
          continue;
        }
        boolean bool2 = localList.contains(Build.MODEL.toLowerCase());
        if (!bool2) {
          continue;
        }
        try
        {
          LogUtils.i("OfflineConfig", "DeviceByBenchmark:model:" + paramInt + Build.MODEL.toLowerCase() + " isInList:" + bool1);
          if (!bool1) {
            continue;
          }
          sDevicePerfLevel = paramInt;
          return bool1;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        bool1 = false;
        continue;
      }
      LogUtils.e("OfflineConfig", "isMatchPerfLever:" + localException1.getMessage());
      return bool1;
      bool1 = false;
      continue;
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
    boolean bool1 = isMatchPerfLever(1);
    LogUtils.i("OfflineConfig", "isVeryLowDeviceByBenchmark:model:" + Build.MODEL.toLowerCase() + " isInList:" + bool1);
    if (bool1)
    {
      sDevicePerfLevel = 1;
      return true;
    }
    Context localContext = AEModule.getContext();
    int j = YearClass.get(localContext);
    long l1 = DeviceUtils.getTotalRamMemory(localContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.OfflineConfig
 * JD-Core Version:    0.7.0.1
 */