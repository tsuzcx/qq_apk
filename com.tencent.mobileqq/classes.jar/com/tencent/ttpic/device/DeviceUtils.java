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
  private static final String TAG = "DeviceUtils";
  public static final long VERY_LOW_END_CPU_COUNT = 2L;
  public static final long VERY_LOW_END_MEMORY_SIZE = 64L;
  public static final long VERY_LOW_END_SCREEN_SIZE = 388800L;
  public static Handler handler;
  private static DeviceInstance.SOC_CLASS socClassCache;
  
  public static String getDeviceLevelClass(Context paramContext)
  {
    return getDeviceSocClass(paramContext).desc;
  }
  
  public static DeviceInstance.SOC_CLASS getDeviceSocClass(Context paramContext)
  {
    DeviceInstance.SOC_CLASS localSOC_CLASS = socClassCache;
    if (localSOC_CLASS != null) {
      return localSOC_CLASS;
    }
    if (isVeryHighEndDevice(paramContext)) {
      paramContext = DeviceInstance.SOC_CLASS.V_HIGH;
    } else if (isHighEndDevice(paramContext)) {
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
    socClassCache = paramContext;
    return paramContext;
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
    LogUtils.i(TAG, "[isHighEndDevice] + BEGIN");
    Object localObject1 = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isHighEndDevice] socClass = ");
    localStringBuilder.append(localObject1);
    LogUtils.i((String)localObject2, localStringBuilder.toString());
    localObject2 = DeviceInstance.SOC_CLASS.NULL;
    boolean bool4 = true;
    if (localObject1 != localObject2) {
      if (localObject1 == DeviceInstance.SOC_CLASS.HIGH)
      {
        bool1 = bool4;
        break label363;
      }
    }
    boolean bool2;
    boolean bool3;
    do
    {
      bool1 = false;
      break;
      int i = LightDeviceUtils.getScreenWidth(paramContext);
      int j = LightDeviceUtils.getScreenHeight(paramContext);
      if (i * j >= 1900800L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[isHighEndDevice] isHighDisplay = ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", widthPixels = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", heightPixels = ");
      ((StringBuilder)localObject2).append(j);
      LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
      long l = LightDeviceUtils.getHeapMaxSizeInMb(paramContext);
      if (l >= 256L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramContext = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[isHighEndDevice] isHighMemory = ");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append(", deviceHeapSize(Mb) = ");
      ((StringBuilder)localObject1).append(l);
      LogUtils.d(paramContext, ((StringBuilder)localObject1).toString());
      i = LightDeviceUtils.getNumCores();
      if (i >= 8L) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      paramContext = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[isHighEndDevice] isHighCpuCount = ");
      ((StringBuilder)localObject1).append(bool3);
      ((StringBuilder)localObject1).append(", cpuCount = ");
      ((StringBuilder)localObject1).append(i);
      LogUtils.d(paramContext, ((StringBuilder)localObject1).toString());
    } while ((!bool1) || (!bool2) || (!bool3));
    boolean bool1 = bool4;
    label363:
    paramContext = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[isHighEndDevice] + END, isHighEndDevice = ");
    ((StringBuilder)localObject1).append(bool1);
    LogUtils.i(paramContext, ((StringBuilder)localObject1).toString());
    return bool1;
  }
  
  private static boolean isLowEndDevice(Context paramContext)
  {
    LogUtils.i(TAG, "[isLowEndDevice] + BEGIN");
    paramContext = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isLowEndDevice] socClass = ");
    localStringBuilder.append(paramContext);
    LogUtils.i((String)localObject, localStringBuilder.toString());
    boolean bool;
    if ((paramContext != DeviceInstance.SOC_CLASS.NULL) && (paramContext == DeviceInstance.SOC_CLASS.LOW)) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isLowEndDevice] + END, isLowEndDevice = ");
    ((StringBuilder)localObject).append(bool);
    LogUtils.i(paramContext, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private static boolean isMiddleEndDevice(Context paramContext)
  {
    LogUtils.i(TAG, "[isMiddleEndDevice] + BEGIN");
    Object localObject1 = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isMiddleEndDevice] socClass = ");
    localStringBuilder.append(localObject1);
    LogUtils.i((String)localObject2, localStringBuilder.toString());
    localObject2 = DeviceInstance.SOC_CLASS.NULL;
    boolean bool = true;
    if (localObject1 != localObject2)
    {
      if (localObject1 == DeviceInstance.SOC_CLASS.NORMAL) {}
    }
    else {
      while ((isVeryHighEndDevice(paramContext)) || (isHighEndDevice(paramContext)) || (isLowEndDevice(paramContext)) || (isVeryLowEndDevice(paramContext)))
      {
        bool = false;
        break;
      }
    }
    paramContext = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[isMiddleEndDevice] + END, isMiddleEndDevice = ");
    ((StringBuilder)localObject1).append(bool);
    LogUtils.i(paramContext, ((StringBuilder)localObject1).toString());
    return bool;
  }
  
  private static boolean isVeryHighEndDevice(Context paramContext)
  {
    LogUtils.i(TAG, "[isVeryHighDevice] + BEGIN");
    paramContext = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isVeryHighDevice] socClass = ");
    localStringBuilder.append(paramContext);
    LogUtils.i((String)localObject, localStringBuilder.toString());
    localObject = DeviceInstance.SOC_CLASS.NULL;
    boolean bool2 = true;
    if (paramContext != localObject) {
      if (paramContext == DeviceInstance.SOC_CLASS.V_HIGH)
      {
        bool1 = bool2;
        break label163;
      }
    }
    do
    {
      bool1 = false;
      break;
      paramContext = LightDeviceUtils.getCpuNameOnce();
      bool1 = bool2;
      if (Build.HARDWARE.contains("kirin970")) {
        break;
      }
      if (Build.HARDWARE.contains("kirin980"))
      {
        bool1 = bool2;
        break;
      }
      bool1 = bool2;
      if (paramContext.contains("MSM8998")) {
        break;
      }
      bool1 = bool2;
      if (paramContext.contains("SDM845")) {
        break;
      }
      bool1 = bool2;
      if (paramContext.contains("SDM850")) {
        break;
      }
    } while (!paramContext.contains("SDM855"));
    boolean bool1 = bool2;
    label163:
    paramContext = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isVeryHighDevice] + END, iVeryHighDevice = ");
    ((StringBuilder)localObject).append(bool1);
    LogUtils.i(paramContext, ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  private static boolean isVeryLowEndDevice(Context paramContext)
  {
    LogUtils.i(TAG, "[isVeryLowEndDevice] + BEGIN");
    Object localObject1 = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isVeryLowEndDevice] socClass = ");
    localStringBuilder.append(localObject1);
    LogUtils.i((String)localObject2, localStringBuilder.toString());
    localObject2 = DeviceInstance.SOC_CLASS.NULL;
    boolean bool5 = true;
    if (localObject1 != localObject2) {
      if (localObject1 == DeviceInstance.SOC_CLASS.V_LOW)
      {
        bool4 = bool5;
        break label374;
      }
    }
    boolean bool3;
    do
    {
      bool4 = false;
      break;
      int i = LightDeviceUtils.getScreenWidth(paramContext);
      int j = LightDeviceUtils.getScreenHeight(paramContext);
      boolean bool1;
      if (i * j <= 388800L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[isLowEndDevice] isLowEndDisplay = ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", widthPixels = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", heightPixels = ");
      ((StringBuilder)localObject2).append(j);
      LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
      long l = LightDeviceUtils.getHeapMaxSizeInMb(paramContext);
      boolean bool2;
      if (l <= 64L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramContext = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[isLowEndDevice] isLowMemory = ");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append(", deviceHeapSize(Mb) = ");
      ((StringBuilder)localObject1).append(l);
      LogUtils.d(paramContext, ((StringBuilder)localObject1).toString());
      i = LightDeviceUtils.getNumCores();
      if (i <= 2L) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      paramContext = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[isLowEndDevice] isLowCpuCount = ");
      ((StringBuilder)localObject1).append(bool3);
      ((StringBuilder)localObject1).append(", cpuCount = ");
      ((StringBuilder)localObject1).append(i);
      LogUtils.d(paramContext, ((StringBuilder)localObject1).toString());
      bool4 = bool5;
      if (bool1) {
        break;
      }
      bool4 = bool5;
      if (bool2) {
        break;
      }
    } while (!bool3);
    boolean bool4 = bool5;
    label374:
    paramContext = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[isVeryLowEndDevice] + END, isVeryLowDevice = ");
    ((StringBuilder)localObject1).append(bool4);
    LogUtils.i(paramContext, ((StringBuilder)localObject1).toString());
    return bool4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */