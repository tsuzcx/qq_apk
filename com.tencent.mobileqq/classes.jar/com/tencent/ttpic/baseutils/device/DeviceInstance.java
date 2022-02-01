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
  private static String TAG = DeviceInstance.class.getSimpleName();
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
    for (;;)
    {
      try
      {
        paramContext = (DeviceInstance.BrandNames)new Gson().fromJson(paramContext, DeviceInstance.BrandNames.class);
        if ((paramContext != null) && (paramContext.BRAND_NAMES != null))
        {
          paramContext = paramContext.BRAND_NAMES.entrySet().iterator();
          if (paramContext != null) {}
        }
        else
        {
          return;
        }
      }
      catch (NoSuchMethodError paramContext)
      {
        LogUtils.e(TAG, paramContext.toString());
        paramContext = null;
        continue;
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
      LogUtils.d(TAG, "DeviceName = " + getDeviceName());
      LogUtils.d(TAG, "SubName = " + getDeviceName() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase());
      LogUtils.d(TAG, "MODEL = " + Build.MODEL);
      LogUtils.d(TAG, "SDK_INT = " + Build.VERSION.SDK_INT);
      LogUtils.d(TAG, "BRAND = " + Build.BRAND);
      LogUtils.d(TAG, "DEVICE = " + Build.DEVICE);
      LogUtils.d(TAG, "DISPLAY = " + Build.DISPLAY);
      LogUtils.d(TAG, "HARDWARE = " + Build.HARDWARE);
      LogUtils.d(TAG, "MANUFACTURER = " + Build.MANUFACTURER);
      LogUtils.d(TAG, "PRODUCT = " + Build.PRODUCT);
      LogUtils.d(TAG, "TAGS = " + Build.TAGS);
      LogUtils.d(TAG, "USER = " + Build.USER);
      LogUtils.d(TAG, "TYPE = " + Build.TYPE);
      LogUtils.d(TAG, "BOARD = " + Build.BOARD);
      LogUtils.d(TAG, "****** DeviceInfo (-) *****");
    }
  }
  
  public String getDeviceName()
  {
    if (TextUtils.isEmpty(this.mDeviceName))
    {
      if (!Build.MODEL.equalsIgnoreCase("K-Touch W619")) {
        break label98;
      }
      this.mDeviceName = ((String)this.mModelMap.get("TIANYU") + " " + Build.MODEL);
    }
    for (;;)
    {
      this.mDeviceName = this.mDeviceName.replace(" ", "_").replace("+", "").replace("(t)", "");
      return this.mDeviceName;
      label98:
      if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD")))
      {
        this.mDeviceName = ((String)this.mModelMap.get("COOLPAD") + " " + Build.MODEL);
      }
      else
      {
        Object localObject2 = (String)this.mModelMap.get(Build.MANUFACTURER.toUpperCase());
        Object localObject1;
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
        this.mDeviceName = ((String)localObject2 + " " + Build.MODEL);
      }
    }
  }
  
  public DeviceInstance.SOC_CLASS getDeviceSocClass(String paramString)
  {
    LogUtils.d(TAG, "[getDeviceSocClass] + BEGIN, socInfo = " + paramString);
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = str2;
      if (this.mSocMap != null)
      {
        str1 = str2;
        if (this.mSocMap.containsKey(paramString)) {
          str1 = (String)this.mSocMap.get(paramString);
        }
      }
    }
    LogUtils.d(TAG, "[getDeviceSocClass] scoreValue = " + str1);
    paramString = DeviceInstance.SOC_CLASS.NULL;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      i = Integer.parseInt(str1);
      if (i >= DeviceInstance.SOC_CLASS.V_HIGH.score) {
        paramString = DeviceInstance.SOC_CLASS.V_HIGH;
      }
    }
    for (;;)
    {
      LogUtils.d(TAG, "[getDeviceSocClass] + END, socClass = " + paramString);
      return paramString;
      if (i >= DeviceInstance.SOC_CLASS.HIGH.score) {
        paramString = DeviceInstance.SOC_CLASS.HIGH;
      } else if (i >= DeviceInstance.SOC_CLASS.NORMAL.score) {
        paramString = DeviceInstance.SOC_CLASS.NORMAL;
      } else if (i >= DeviceInstance.SOC_CLASS.LOW.score) {
        paramString = DeviceInstance.SOC_CLASS.LOW;
      } else if (i > DeviceInstance.SOC_CLASS.V_LOW.score) {
        paramString = DeviceInstance.SOC_CLASS.V_LOW;
      }
    }
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
    boolean bool2 = false;
    String str = getDeviceName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.startsWith("MEIZU")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isMeiZuDevice] + END, isMeizu = " + bool1);
    return bool1;
  }
  
  public boolean isOppoX909Device()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.equals("OPPO_X909"));
  }
  
  public boolean isViVoDevice()
  {
    LogUtils.d(TAG, "[isViVoDevice] + BEGIN");
    boolean bool2 = false;
    String str = getDeviceName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.startsWith("VIVO")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isViVoDevice] + END, isViVo = " + bool1);
    return bool1;
  }
  
  public boolean isVivoY23LDevice()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.equals("VIVO_vivo_Y23L"));
  }
  
  public boolean isXiaoMiDevice()
  {
    LogUtils.d(TAG, "[isXiaoMiDevice] + BEGIN");
    boolean bool2 = false;
    String str = getDeviceName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.startsWith("XIAOMI")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isXiaoMiDevice] + END, isXiaomi = " + bool1);
    return bool1;
  }
  
  public boolean isXiaoMiMixDevice()
  {
    LogUtils.d(TAG, "[isXiaoMiMixDevice] + BEGIN");
    String str = getDeviceName();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.equals("XIAOMI_MIX")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isXiaoMiMixDevice] + END, isXiaoMiMix = " + bool1);
    return bool1;
  }
  
  public boolean isXiaoMiRedmi6Device()
  {
    LogUtils.d(TAG, "[isXiaoMiRedmi6Device] + BEGIN");
    boolean bool2 = false;
    String str = getDeviceName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.contains("Redmi_6")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isXiaoMiRedmi6Device] + END, isRedmi6 = " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceInstance
 * JD-Core Version:    0.7.0.1
 */