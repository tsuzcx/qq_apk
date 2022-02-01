package com.tencent.ttpic.device;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.DeviceInstance.SOC_CLASS;
import com.tencent.ttpic.baseutils.log.LogUtils;
import org.light.device.LightDeviceUtils;

public class DeviceUtils
{
  public static final long HIGH_END_CPU_COUNT = 8L;
  public static final long HIGH_END_MEMORY_SIZE = 256L;
  public static final long HIGH_END_SCREEN_SIZE = 1900800L;
  public static final int MIN_STORAGE_SIZE = 52428800;
  private static final String TAG = DeviceUtils.class.getSimpleName();
  public static final long VERY_LOW_END_CPU_COUNT = 2L;
  public static final long VERY_LOW_END_MEMORY_SIZE = 64L;
  public static final long VERY_LOW_END_SCREEN_SIZE = 388800L;
  public static Handler handler = null;
  private static DeviceInstance.SOC_CLASS socClassCache;
  
  public static String getDeviceLevelClass(Context paramContext)
  {
    return getDeviceSocClass(paramContext).desc;
  }
  
  public static DeviceInstance.SOC_CLASS getDeviceSocClass(Context paramContext)
  {
    if (socClassCache != null) {
      return socClassCache;
    }
    if (isVeryHighEndDevice(paramContext)) {
      paramContext = DeviceInstance.SOC_CLASS.V_HIGH;
    }
    for (;;)
    {
      socClassCache = paramContext;
      return paramContext;
      if (isHighEndDevice(paramContext)) {
        paramContext = DeviceInstance.SOC_CLASS.HIGH;
      } else if (isMiddleEndDevice(paramContext)) {
        paramContext = DeviceInstance.SOC_CLASS.NORMAL;
      } else if (isLowEndDevice(paramContext)) {
        paramContext = DeviceInstance.SOC_CLASS.LOW;
      } else if (isVeryLowEndDevice(paramContext)) {
        paramContext = DeviceInstance.SOC_CLASS.V_LOW;
      } else {
        paramContext = DeviceInstance.SOC_CLASS.NULL;
      }
    }
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return LightDeviceUtils.getScreenHeight(paramContext);
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return LightDeviceUtils.getScreenWidth(paramContext);
  }
  
  public static long getTotalRamMemory(Context paramContext)
  {
    return LightDeviceUtils.getTotalRamMemory(paramContext);
  }
  
  public static boolean hasDeviceHigh(Context paramContext)
  {
    return getDeviceSocClass(paramContext).score >= DeviceInstance.SOC_CLASS.HIGH.score;
  }
  
  public static boolean hasDeviceLow(Context paramContext)
  {
    return getDeviceSocClass(paramContext).score >= DeviceInstance.SOC_CLASS.LOW.score;
  }
  
  public static boolean hasDeviceNormal(Context paramContext)
  {
    return getDeviceSocClass(paramContext).score >= DeviceInstance.SOC_CLASS.NORMAL.score;
  }
  
  public static boolean hasDeviceVHigh(Context paramContext)
  {
    return getDeviceSocClass(paramContext).score >= DeviceInstance.SOC_CLASS.V_HIGH.score;
  }
  
  private static boolean isHighEndDevice(Context paramContext)
  {
    boolean bool4 = true;
    LogUtils.i(TAG, "[isHighEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isHighEndDevice] socClass = " + localSOC_CLASS);
    boolean bool1;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.HIGH) {}
      for (bool1 = bool4;; bool1 = false)
      {
        LogUtils.i(TAG, "[isHighEndDevice] + END, isHighEndDevice = " + bool1);
        return bool1;
      }
    }
    int i = LightDeviceUtils.getScreenWidth(paramContext);
    int j = LightDeviceUtils.getScreenHeight(paramContext);
    label125:
    boolean bool2;
    if (i * j >= 1900800L)
    {
      bool1 = true;
      LogUtils.d(TAG, "[isHighEndDevice] isHighDisplay = " + bool1 + ", widthPixels = " + i + ", heightPixels = " + j);
      long l = LightDeviceUtils.getHeapMaxSizeInMb(paramContext);
      if (l < 256L) {
        break label300;
      }
      bool2 = true;
      label186:
      LogUtils.d(TAG, "[isHighEndDevice] isHighMemory = " + bool2 + ", deviceHeapSize(Mb) = " + l);
      i = LightDeviceUtils.getNumCores();
      if (i < 8L) {
        break label306;
      }
    }
    label300:
    label306:
    for (boolean bool3 = true;; bool3 = false)
    {
      LogUtils.d(TAG, "[isHighEndDevice] isHighCpuCount = " + bool3 + ", cpuCount = " + i);
      if ((bool1) && (bool2))
      {
        bool1 = bool4;
        if (bool3) {
          break;
        }
      }
      bool1 = false;
      break;
      bool1 = false;
      break label125;
      bool2 = false;
      break label186;
    }
  }
  
  private static boolean isLowEndDevice(Context paramContext)
  {
    LogUtils.i(TAG, "[isLowEndDevice] + BEGIN");
    boolean bool2 = false;
    paramContext = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isLowEndDevice] socClass = " + paramContext);
    boolean bool1 = bool2;
    if (paramContext != DeviceInstance.SOC_CLASS.NULL)
    {
      bool1 = bool2;
      if (paramContext == DeviceInstance.SOC_CLASS.LOW) {
        bool1 = true;
      }
    }
    LogUtils.i(TAG, "[isLowEndDevice] + END, isLowEndDevice = " + bool1);
    return bool1;
  }
  
  private static boolean isMiddleEndDevice(Context paramContext)
  {
    boolean bool = true;
    LogUtils.i(TAG, "[isMiddleEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isMiddleEndDevice] socClass = " + localSOC_CLASS);
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL) {
      if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NORMAL) {}
    }
    for (;;)
    {
      LogUtils.i(TAG, "[isMiddleEndDevice] + END, isMiddleEndDevice = " + bool);
      return bool;
      bool = false;
      continue;
      if ((isVeryHighEndDevice(paramContext)) || (isHighEndDevice(paramContext)) || (isLowEndDevice(paramContext)) || (isVeryLowEndDevice(paramContext))) {
        bool = false;
      }
    }
  }
  
  private static boolean isVeryHighEndDevice(Context paramContext)
  {
    boolean bool2 = true;
    LogUtils.i(TAG, "[isVeryHighDevice] + BEGIN");
    paramContext = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isVeryHighDevice] socClass = " + paramContext);
    boolean bool1;
    if (paramContext != DeviceInstance.SOC_CLASS.NULL) {
      if (paramContext == DeviceInstance.SOC_CLASS.V_HIGH) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      LogUtils.i(TAG, "[isVeryHighDevice] + END, iVeryHighDevice = " + bool1);
      return bool1;
      bool1 = false;
      continue;
      paramContext = LightDeviceUtils.getCpuNameOnce();
      bool1 = bool2;
      if (!Build.HARDWARE.contains("kirin970"))
      {
        bool1 = bool2;
        if (!Build.HARDWARE.contains("kirin980"))
        {
          bool1 = bool2;
          if (!paramContext.contains("MSM8998"))
          {
            bool1 = bool2;
            if (!paramContext.contains("SDM845"))
            {
              bool1 = bool2;
              if (!paramContext.contains("SDM850"))
              {
                bool1 = bool2;
                if (!paramContext.contains("SDM855")) {
                  bool1 = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean isVeryLowEndDevice(Context paramContext)
  {
    boolean bool4 = false;
    LogUtils.i(TAG, "[isVeryLowEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isVeryLowEndDevice] socClass = " + localSOC_CLASS);
    boolean bool1;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      bool1 = bool4;
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.V_LOW) {
        bool1 = true;
      }
      LogUtils.i(TAG, "[isVeryLowEndDevice] + END, isVeryLowDevice = " + bool1);
      return bool1;
    }
    int i = LightDeviceUtils.getScreenWidth(paramContext);
    int j = LightDeviceUtils.getScreenHeight(paramContext);
    label122:
    boolean bool2;
    if (i * j <= 388800L)
    {
      bool1 = true;
      LogUtils.d(TAG, "[isLowEndDevice] isLowEndDisplay = " + bool1 + ", widthPixels = " + i + ", heightPixels = " + j);
      long l = LightDeviceUtils.getHeapMaxSizeInMb(paramContext);
      if (l > 64L) {
        break label297;
      }
      bool2 = true;
      label183:
      LogUtils.d(TAG, "[isLowEndDevice] isLowMemory = " + bool2 + ", deviceHeapSize(Mb) = " + l);
      i = LightDeviceUtils.getNumCores();
      if (i > 2L) {
        break label303;
      }
    }
    label297:
    label303:
    for (boolean bool3 = true;; bool3 = false)
    {
      LogUtils.d(TAG, "[isLowEndDevice] isLowCpuCount = " + bool3 + ", cpuCount = " + i);
      if ((!bool1) && (!bool2))
      {
        bool1 = bool4;
        if (!bool3) {
          break;
        }
      }
      bool1 = true;
      break;
      bool1 = false;
      break label122;
      bool2 = false;
      break label183;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */