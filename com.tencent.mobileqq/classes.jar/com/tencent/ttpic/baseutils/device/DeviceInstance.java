package com.tencent.ttpic.baseutils.device;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class DeviceInstance
{
  public static final String BRAND_MEIZU = "MEIZU";
  public static final String BRAND_VIVO = "VIVO";
  public static final String BRAND_XIAOMI = "XIAOMI";
  public static final String MODEL_COOLPAD_8150 = "8150";
  public static final String MODEL_K_TOUCH_W619 = "K-Touch W619";
  public static final String MODEL_NEXUS_6 = "MOTOROLA_Nexus_6";
  public static final String MODEL_NEXUS_6P = "HUAWEI_Nexus_6P";
  public static final String MODEL_OPPO_X909 = "OPPO_X909";
  public static final String MODEL_VIVO_Y23L = "VIVO_vivo_Y23L";
  public static final String NUBIA_NX511J = "NUBIA_NX511J";
  private static String TAG = "DeviceInstance";
  private String mDeviceName = "";
  private ConcurrentHashMap<String, String> mModelMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> mSocMap = new ConcurrentHashMap();
  
  private DeviceInstance()
  {
    showDeviceInfo();
  }
  
  public static DeviceInstance getInstance()
  {
    return DeviceInstance.InstanceHolder.access$100();
  }
  
  private void initModels(Context paramContext)
  {
    paramContext = FileUtils.load(paramContext, "assets://brand_name.json");
    try
    {
      paramContext = (DeviceInstance.BrandNames)new Gson().fromJson(paramContext, DeviceInstance.BrandNames.class);
    }
    catch (NoSuchMethodError paramContext)
    {
      LogUtils.e(TAG, paramContext.toString());
      paramContext = null;
    }
    if ((paramContext != null) && (paramContext.BRAND_NAMES != null))
    {
      paramContext = paramContext.BRAND_NAMES.entrySet().iterator();
      if (paramContext == null) {
        return;
      }
      while (paramContext.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContext.next();
        this.mModelMap.put(((String)localEntry.getKey()).toUpperCase(), localEntry.getValue());
      }
    }
  }
  
  private void initSOCs(Context paramContext)
  {
    paramContext = FileUtils.load(paramContext, "assets://score_phone.json");
    paramContext = (DeviceInstance.SOCPhones)new Gson().fromJson(paramContext, DeviceInstance.SOCPhones.class);
    if ((paramContext != null) && (paramContext.SOC_SCORE != null)) {
      this.mSocMap.putAll(paramContext.SOC_SCORE);
    }
  }
  
  private void showDeviceInfo()
  {
    if (LogUtils.isEnabled())
    {
      LogUtils.d(TAG, "****** DeviceInfo  (+) *****");
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceName = ");
      localStringBuilder.append(getDeviceName());
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SubName = ");
      localStringBuilder.append(getDeviceName());
      localStringBuilder.append("_");
      localStringBuilder.append(Build.DISPLAY.replace(" ", "_").toUpperCase());
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL = ");
      localStringBuilder.append(Build.MODEL);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDK_INT = ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BRAND = ");
      localStringBuilder.append(Build.BRAND);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DEVICE = ");
      localStringBuilder.append(Build.DEVICE);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DISPLAY = ");
      localStringBuilder.append(Build.DISPLAY);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HARDWARE = ");
      localStringBuilder.append(Build.HARDWARE);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MANUFACTURER = ");
      localStringBuilder.append(Build.MANUFACTURER);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PRODUCT = ");
      localStringBuilder.append(Build.PRODUCT);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAGS = ");
      localStringBuilder.append(Build.TAGS);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("USER = ");
      localStringBuilder.append(Build.USER);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TYPE = ");
      localStringBuilder.append(Build.TYPE);
      LogUtils.d(str, localStringBuilder.toString());
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BOARD = ");
      localStringBuilder.append(Build.BOARD);
      LogUtils.d(str, localStringBuilder.toString());
      LogUtils.d(TAG, "****** DeviceInfo (-) *****");
    }
  }
  
  public String getDeviceName()
  {
    if (TextUtils.isEmpty(this.mDeviceName))
    {
      Object localObject1;
      if (Build.MODEL.equalsIgnoreCase("K-Touch W619"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)this.mModelMap.get("TIANYU"));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(Build.MODEL);
        this.mDeviceName = ((StringBuilder)localObject1).toString();
      }
      else if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD")))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)this.mModelMap.get("COOLPAD"));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(Build.MODEL);
        this.mDeviceName = ((StringBuilder)localObject1).toString();
      }
      else
      {
        Object localObject2 = (String)this.mModelMap.get(Build.MANUFACTURER.toUpperCase());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!"null".equalsIgnoreCase((String)localObject2)) {}
        }
        else
        {
          localObject1 = Build.MANUFACTURER.toUpperCase();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!"null".equalsIgnoreCase((String)localObject1)) {}
        }
        else
        {
          localObject2 = Build.BRAND.toUpperCase();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(Build.MODEL);
        this.mDeviceName = ((StringBuilder)localObject1).toString();
      }
      this.mDeviceName = this.mDeviceName.replace(" ", "_").replace("+", "").replace("(t)", "");
    }
    return this.mDeviceName;
  }
  
  public DeviceInstance.SOC_CLASS getDeviceSocClass(String paramString)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getDeviceSocClass] + BEGIN, socInfo = ");
    ((StringBuilder)localObject2).append(paramString);
    LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = this.mSocMap;
      if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).containsKey(paramString)))
      {
        localObject1 = (String)this.mSocMap.get(paramString);
        break label80;
      }
    }
    localObject1 = "";
    label80:
    paramString = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getDeviceSocClass] scoreValue = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    LogUtils.d(paramString, ((StringBuilder)localObject2).toString());
    localObject2 = DeviceInstance.SOC_CLASS.NULL;
    paramString = (String)localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      int i = Integer.parseInt((String)localObject1);
      if (i >= DeviceInstance.SOC_CLASS.V_HIGH.score)
      {
        paramString = DeviceInstance.SOC_CLASS.V_HIGH;
      }
      else if (i >= DeviceInstance.SOC_CLASS.HIGH.score)
      {
        paramString = DeviceInstance.SOC_CLASS.HIGH;
      }
      else if (i >= DeviceInstance.SOC_CLASS.NORMAL.score)
      {
        paramString = DeviceInstance.SOC_CLASS.NORMAL;
      }
      else if (i >= DeviceInstance.SOC_CLASS.LOW.score)
      {
        paramString = DeviceInstance.SOC_CLASS.LOW;
      }
      else
      {
        paramString = (String)localObject2;
        if (i > DeviceInstance.SOC_CLASS.V_LOW.score) {
          paramString = DeviceInstance.SOC_CLASS.V_LOW;
        }
      }
    }
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getDeviceSocClass] + END, socClass = ");
    ((StringBuilder)localObject2).append(paramString);
    LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
    return paramString;
  }
  
  public int getMaxMemorySizeInKB()
  {
    String str = getDeviceName().toLowerCase().trim();
    DeviceInstance.DEVICE_MEM[] arrayOfDEVICE_MEM = DeviceInstance.DEVICE_MEM.values();
    int j = arrayOfDEVICE_MEM.length;
    int i = 0;
    while (i < j)
    {
      DeviceInstance.DEVICE_MEM localDEVICE_MEM = arrayOfDEVICE_MEM[i];
      if (str.endsWith(DeviceInstance.DEVICE_MEM.access$200(localDEVICE_MEM).toLowerCase())) {
        return DeviceInstance.DEVICE_MEM.access$300(localDEVICE_MEM);
      }
      i += 1;
    }
    return 2147483647;
  }
  
  public void initSettings(Context paramContext)
  {
    if (this.mModelMap.size() == 0) {
      initModels(paramContext);
    }
    if (this.mSocMap.size() == 0) {
      initSOCs(paramContext);
    }
    showDeviceInfo();
  }
  
  public boolean isMeiZuDevice()
  {
    LogUtils.d(TAG, "[isMeiZuDevice] + BEGIN");
    String str = getDeviceName();
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (str.startsWith("MEIZU"))) {
      bool = true;
    } else {
      bool = false;
    }
    str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isMeiZuDevice] + END, isMeizu = ");
    localStringBuilder.append(bool);
    LogUtils.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public boolean isOppoX909Device()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.equals("OPPO_X909"));
  }
  
  public boolean isViVoDevice()
  {
    LogUtils.d(TAG, "[isViVoDevice] + BEGIN");
    String str = getDeviceName();
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (str.startsWith("VIVO"))) {
      bool = true;
    } else {
      bool = false;
    }
    str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isViVoDevice] + END, isViVo = ");
    localStringBuilder.append(bool);
    LogUtils.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public boolean isVivoY23LDevice()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.equals("VIVO_vivo_Y23L"));
  }
  
  public boolean isXiaoMiDevice()
  {
    LogUtils.d(TAG, "[isXiaoMiDevice] + BEGIN");
    String str = getDeviceName();
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (str.startsWith("XIAOMI"))) {
      bool = true;
    } else {
      bool = false;
    }
    str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isXiaoMiDevice] + END, isXiaomi = ");
    localStringBuilder.append(bool);
    LogUtils.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public boolean isXiaoMiMixDevice()
  {
    LogUtils.d(TAG, "[isXiaoMiMixDevice] + BEGIN");
    String str = getDeviceName();
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (str.equals("XIAOMI_MIX"))) {
      bool = true;
    } else {
      bool = false;
    }
    str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isXiaoMiMixDevice] + END, isXiaoMiMix = ");
    localStringBuilder.append(bool);
    LogUtils.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public boolean isXiaoMiRedmi6Device()
  {
    LogUtils.d(TAG, "[isXiaoMiRedmi6Device] + BEGIN");
    String str = getDeviceName();
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (str.contains("Redmi_6"))) {
      bool = true;
    } else {
      bool = false;
    }
    str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isXiaoMiRedmi6Device] + END, isRedmi6 = ");
    localStringBuilder.append(bool);
    LogUtils.d(str, localStringBuilder.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceInstance
 * JD-Core Version:    0.7.0.1
 */