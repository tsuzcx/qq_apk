package org.light.device;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import org.light.bean.DeviceModelListJsonBean;
import org.light.bean.PhoneType;
import org.light.utils.GsonUtils;
import org.light.utils.LightLogUtil;

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
  public static int sDevicePerfLevel = -1;
  protected static float sGauLowMaxSize;
  protected static int sGauLowPhoneYear;
  protected static float sGauMidMaxSize;
  protected static int sGauMidderPhoneYear;
  protected static float sGauSuperMaxSzie;
  protected static int sGauSuperPhoneYear;
  protected static int sGaussMaxSize;
  protected static float sGaussScale;
  protected static boolean sIsGaussResize;
  protected static int sIsPagEncodeBgStaus;
  protected static int sLowDevYearPag;
  protected static int sLowDevYearRapidnet;
  protected static boolean sNeedSoftDecoder;
  protected static boolean sNotSupportRealTimePag;
  protected static int sPagNeedScaleStatus;
  protected static float sPagScaleVaue;
  protected static int sPhonePerfLevel = -1;
  protected static int sRapidnetSkipMode;
  protected static boolean sUpdateGaussSetting;
  private static long sVLowRAM;
  private static int sVLowYear = 2013;
  private static long sVeryLowFrequency;
  public static int useCutoutVersion;
  
  static
  {
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
  }
  
  private static List<String> getBenchMarkDeviceList(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = Build.BRAND.toLowerCase();
    if ("honor".equals(Build.BRAND.toLowerCase())) {
      localObject = "huawei";
    }
    String str = FileOfflineUtil.readStringFromAssets(paramContext, paramString + (String)localObject + ".json");
    localObject = str;
    if (str == null)
    {
      paramContext = FileOfflineUtil.readStringFromAssets(paramContext, paramString + "misc.json");
      localObject = paramContext;
      if (paramContext == null) {
        return null;
      }
    }
    paramContext = (DeviceModelListJsonBean)GsonUtils.json2Obj((String)localObject, new OfflineConfig.1().getType());
    if ((paramContext != null) && (paramContext.modelList != null)) {}
    try
    {
      localArrayList.addAll(paramContext.modelList);
      return localArrayList;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LightLogUtil.e("OfflineConfig", "getBenchMarkDeviceList:" + paramContext.getMessage());
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
    switch (OfflineConfig.2.$SwitchMap$org$light$bean$PhoneType[getGauPhoneType(paramInt).ordinal()])
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
  
  public static int getPhonePerfLevel(Context paramContext)
  {
    int i = 2;
    if (sPhonePerfLevel != -1) {
      return sPhonePerfLevel;
    }
    if (isVeryLowDeviceByBenchmark(paramContext)) {
      i = 1;
    }
    for (;;)
    {
      sPhonePerfLevel = i;
      return sPhonePerfLevel;
      if (!isMatchPerfLever(paramContext, 2)) {
        if (isMatchPerfLever(paramContext, 3)) {
          i = 3;
        } else if (isMatchPerfLever(paramContext, 4)) {
          i = 4;
        } else if (isMatchPerfLever(paramContext, 5)) {
          i = 5;
        } else {
          i = getPhoneType(YearClass.get(paramContext));
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
  
  private static boolean isMatchPerfLever(Context paramContext, int paramInt)
  {
    bool1 = true;
    if (sDevicePerfLevel >= 0) {
      return sDevicePerfLevel == paramInt;
    }
    for (;;)
    {
      try
      {
        paramContext = getBenchMarkDeviceList(paramContext, getDeviceTAG(paramInt));
        if (paramContext == null) {
          continue;
        }
        boolean bool2 = paramContext.contains(Build.MODEL.toLowerCase());
        if (!bool2) {
          continue;
        }
        try
        {
          LightLogUtil.i("OfflineConfig", "DeviceByBenchmark:model:" + paramInt + Build.MODEL.toLowerCase() + " isInList:" + bool1);
          if (!bool1) {
            continue;
          }
          sDevicePerfLevel = paramInt;
          return bool1;
        }
        catch (Exception paramContext) {}
      }
      catch (Exception paramContext)
      {
        bool1 = false;
        continue;
      }
      LightLogUtil.e("OfflineConfig", "isMatchPerfLever:" + paramContext.getMessage());
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
  
  public static boolean isNeedSkipRapidnet(Context paramContext)
  {
    return ((sRapidnetSkipMode == 0) && (YearClass.get(paramContext) <= sLowDevYearRapidnet)) || (sRapidnetSkipMode == 1);
  }
  
  public static boolean isNeedSoftDecode()
  {
    return sNeedSoftDecoder;
  }
  
  public static boolean isNotSuptPagRealTime()
  {
    return sNotSupportRealTimePag;
  }
  
  public static boolean isVeryLowDeviceByBenchmark(Context paramContext)
  {
    boolean bool2 = false;
    int i = 1;
    if (sDevicePerfLevel >= 0) {
      return sDevicePerfLevel == 1;
    }
    boolean bool1 = isMatchPerfLever(paramContext, 1);
    LightLogUtil.i("OfflineConfig", "isVeryLowDeviceByBenchmark:model:" + Build.MODEL.toLowerCase() + " isInList:" + bool1);
    if (bool1)
    {
      sDevicePerfLevel = 1;
      return true;
    }
    int j = YearClass.get(paramContext);
    long l1 = LightDeviceUtils.getTotalRamMemory(paramContext);
    long l2 = LightDeviceUtils.getMaxCpuFreq();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.device.OfflineConfig
 * JD-Core Version:    0.7.0.1
 */