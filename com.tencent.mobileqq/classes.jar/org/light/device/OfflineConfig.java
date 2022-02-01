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
  protected static float sGauLowMaxSize = 360.0F;
  protected static int sGauLowPhoneYear = 2014;
  protected static float sGauMidMaxSize = 480.0F;
  protected static int sGauMidderPhoneYear = 2015;
  protected static float sGauSuperMaxSzie = 540.0F;
  protected static int sGauSuperPhoneYear = 2017;
  protected static int sGaussMaxSize = -1;
  protected static float sGaussScale = -1.0F;
  protected static boolean sIsGaussResize = true;
  protected static int sIsPagEncodeBgStaus = 0;
  protected static int sLowDevYearPag = 2015;
  protected static int sLowDevYearRapidnet = 2015;
  protected static boolean sNeedSoftDecoder = false;
  protected static boolean sNotSupportRealTimePag = false;
  protected static int sPagNeedScaleStatus = 0;
  protected static float sPagScaleVaue = 0.5F;
  protected static int sPhonePerfLevel = -1;
  protected static int sRapidnetSkipMode = 0;
  protected static boolean sUpdateGaussSetting = false;
  private static long sVLowRAM = 4294967296L;
  private static int sVLowYear = 2013;
  private static long sVeryLowFrequency = 1500000L;
  public static int useCutoutVersion = OfflineConfig.CutOutVersion.NEW.value;
  
  private static List<String> getBenchMarkDeviceList(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = Build.BRAND.toLowerCase();
    if ("honor".equals(Build.BRAND.toLowerCase())) {
      localObject1 = "huawei";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".json");
    localObject2 = FileOfflineUtil.readStringFromAssets(paramContext, ((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("misc.json");
      paramContext = FileOfflineUtil.readStringFromAssets(paramContext, ((StringBuilder)localObject1).toString());
      localObject1 = paramContext;
      if (paramContext == null) {
        return null;
      }
    }
    paramContext = (DeviceModelListJsonBean)GsonUtils.json2Obj((String)localObject1, new OfflineConfig.1().getType());
    if ((paramContext != null) && (paramContext.modelList != null)) {
      try
      {
        localArrayList.addAll(paramContext.modelList);
        return localArrayList;
      }
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("getBenchMarkDeviceList:");
        paramString.append(paramContext.getMessage());
        LightLogUtil.e("OfflineConfig", paramString.toString());
      }
    }
    return localArrayList;
  }
  
  private static String getDeviceTAG(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "";
            }
            return "benchmark/high/";
          }
          return "benchmark/mhigh/";
        }
        return "benchmark/middle/";
      }
      return "benchmark/low/";
    }
    return "benchmark/vlow/";
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
    paramInt = OfflineConfig.2.$SwitchMap$org$light$bean$PhoneType[getGauPhoneType(paramInt).ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return -1.0F;
        }
        return sGauLowMaxSize;
      }
      return sGauMidMaxSize;
    }
    return sGauSuperMaxSzie;
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
    if ((sPhonePerfLevel == -1) && (paramContext != null))
    {
      boolean bool = isVeryLowDeviceByBenchmark(paramContext);
      int i = 5;
      if (bool) {
        i = 1;
      } else if (isMatchPerfLever(paramContext, 2)) {
        i = 2;
      } else if (isMatchPerfLever(paramContext, 3)) {
        i = 3;
      } else if (isMatchPerfLever(paramContext, 4)) {
        i = 4;
      } else if (!isMatchPerfLever(paramContext, 5)) {
        i = getPhoneType(YearClass.get(paramContext));
      }
      sPhonePerfLevel = i;
      return sPhonePerfLevel;
    }
    return sPhonePerfLevel;
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
    int i = sDevicePerfLevel;
    boolean bool1 = true;
    if (i >= 0) {
      return i == paramInt;
    }
    for (;;)
    {
      try
      {
        paramContext = getBenchMarkDeviceList(paramContext, getDeviceTAG(paramInt));
        if (paramContext != null)
        {
          boolean bool2 = paramContext.contains(Build.MODEL.toLowerCase());
          if (bool2) {}
        }
        else
        {
          bool1 = false;
        }
        try
        {
          paramContext = new StringBuilder();
          paramContext.append("DeviceByBenchmark:model:");
          paramContext.append(paramInt);
          paramContext.append(Build.MODEL.toLowerCase());
          paramContext.append(" isInList:");
          paramContext.append(bool1);
          LightLogUtil.i("OfflineConfig", paramContext.toString());
          if (!bool1) {
            break label176;
          }
          sDevicePerfLevel = paramInt;
          return bool1;
        }
        catch (Exception paramContext) {}
        localStringBuilder = new StringBuilder();
      }
      catch (Exception paramContext)
      {
        bool1 = false;
      }
      StringBuilder localStringBuilder;
      localStringBuilder.append("isMatchPerfLever:");
      localStringBuilder.append(paramContext.getMessage());
      LightLogUtil.e("OfflineConfig", localStringBuilder.toString());
      sDevicePerfLevel = 0;
      return bool1;
      label176:
      paramInt = 0;
    }
  }
  
  public static boolean isNeedScale()
  {
    int i = sPagNeedScaleStatus;
    boolean bool = true;
    if ((i != 0) || (YearClass.get(null) > sLowDevYearPag))
    {
      if (sPagNeedScaleStatus == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean isNeedSkipRapidnet(Context paramContext)
  {
    int i = sRapidnetSkipMode;
    boolean bool = true;
    if ((i != 0) || (YearClass.get(paramContext) > sLowDevYearRapidnet))
    {
      if (sRapidnetSkipMode == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
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
    int j = sDevicePerfLevel;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 1;
    if (j >= 0)
    {
      if (j == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = isMatchPerfLever(paramContext, 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isVeryLowDeviceByBenchmark:model:");
    localStringBuilder.append(Build.MODEL.toLowerCase());
    localStringBuilder.append(" isInList:");
    localStringBuilder.append(bool1);
    LightLogUtil.i("OfflineConfig", localStringBuilder.toString());
    if (bool1)
    {
      sDevicePerfLevel = 1;
      return true;
    }
    j = YearClass.get(paramContext);
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
    if (!bool1) {
      i = -1;
    }
    sDevicePerfLevel = i;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.OfflineConfig
 * JD-Core Version:    0.7.0.1
 */