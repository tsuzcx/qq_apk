package org.light.device;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.light.utils.FileUtils;
import org.light.utils.LightLogUtil;

public final class DeviceInstance
{
  public static final String BRAND_HUAWEI = "HUAWEI";
  public static final String BRAND_MEIZU = "MEIZU";
  public static final String BRAND_OPPO = "OPPO";
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
  private String mDeviceVersion = "";
  private ConcurrentHashMap<String, String> mModelMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> mSocMap = new ConcurrentHashMap();
  
  private DeviceInstance()
  {
    showDeviceInfo();
  }
  
  private String getHuaweiEMUIVersion()
  {
    return getOSVersion("ro.build.version.emui");
  }
  
  public static DeviceInstance getInstance()
  {
    return DeviceInstance.InstanceHolder.access$100();
  }
  
  private String getOSVersion(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getDeclaredMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      label39:
      break label39;
    }
    return "";
  }
  
  private String getOppoColorOSVersion()
  {
    return getOSVersion("ro.build.version.opporom");
  }
  
  private String getVivoOSVersion()
  {
    return getOSVersion("ro.vivo.os.version");
  }
  
  private String getXiaomiMIUIVersion()
  {
    return getOSVersion("ro.miui.ui.version.name");
  }
  
  private void initModels(Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(paramString));
    ((StringBuilder)localObject).append("brand_name.json");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (!FileUtils.isFileExist((String)localObject))
    {
      localObject = FileUtils.load(paramContext, "assets://brand_name.json");
      paramString = (String)localObject;
      if (!FileUtils.isFileExist((String)localObject)) {
        return;
      }
    }
    paramContext = FileUtils.load(paramContext, paramString);
    try
    {
      paramContext = (DeviceInstance.BrandNames)new Gson().fromJson(paramContext, DeviceInstance.BrandNames.class);
    }
    catch (NoSuchMethodError paramContext)
    {
      LightLogUtil.e(TAG, paramContext.toString());
      paramContext = null;
    }
    if ((paramContext != null) && (paramContext.BRAND_NAMES != null))
    {
      paramContext = paramContext.BRAND_NAMES.entrySet().iterator();
      if (paramContext == null) {
        return;
      }
      this.mModelMap.clear();
      while (paramContext.hasNext())
      {
        paramString = (Map.Entry)paramContext.next();
        this.mModelMap.put(((String)paramString.getKey()).toUpperCase(), paramString.getValue());
      }
    }
  }
  
  private void initSOCs(Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(paramString));
    ((StringBuilder)localObject).append("score_phone.json");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (!FileUtils.isFileExist((String)localObject))
    {
      localObject = FileUtils.load(paramContext, "assets://score_phone.json");
      paramString = (String)localObject;
      if (!FileUtils.isFileExist((String)localObject)) {
        return;
      }
    }
    paramContext = FileUtils.load(paramContext, paramString);
    paramContext = (DeviceInstance.SOCPhones)new Gson().fromJson(paramContext, DeviceInstance.SOCPhones.class);
    this.mSocMap.clear();
    if ((paramContext != null) && (paramContext.SOC_SCORE != null)) {
      this.mSocMap.putAll(paramContext.SOC_SCORE);
    }
  }
  
  private void showDeviceInfo()
  {
    LightLogUtil.d(TAG, "****** DeviceInfo  (+) *****");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceName = ");
    localStringBuilder.append(getDeviceName());
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubName = ");
    localStringBuilder.append(getDeviceName());
    localStringBuilder.append("_");
    localStringBuilder.append(Build.DISPLAY.replace(" ", "_").toUpperCase());
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODEL = ");
    localStringBuilder.append(Build.MODEL);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK_INT = ");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("BRAND = ");
    localStringBuilder.append(Build.BRAND);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DEVICE = ");
    localStringBuilder.append(Build.DEVICE);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DISPLAY = ");
    localStringBuilder.append(Build.DISPLAY);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("HARDWARE = ");
    localStringBuilder.append(Build.HARDWARE);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MANUFACTURER = ");
    localStringBuilder.append(Build.MANUFACTURER);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRODUCT = ");
    localStringBuilder.append(Build.PRODUCT);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAGS = ");
    localStringBuilder.append(Build.TAGS);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("USER = ");
    localStringBuilder.append(Build.USER);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TYPE = ");
    localStringBuilder.append(Build.TYPE);
    LightLogUtil.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("BOARD = ");
    localStringBuilder.append(Build.BOARD);
    LightLogUtil.d(str, localStringBuilder.toString());
    LightLogUtil.d(TAG, "****** DeviceInfo (-) *****");
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
    LightLogUtil.d((String)localObject1, ((StringBuilder)localObject2).toString());
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
    LightLogUtil.d(paramString, ((StringBuilder)localObject2).toString());
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
    LightLogUtil.d((String)localObject1, ((StringBuilder)localObject2).toString());
    return paramString;
  }
  
  public String getDeviceVersion()
  {
    if (TextUtils.isEmpty(this.mDeviceVersion)) {
      if (isHuaweiDevice())
      {
        this.mDeviceVersion = getHuaweiEMUIVersion();
      }
      else
      {
        StringBuilder localStringBuilder;
        if (isOppoDevice())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ColorOS_");
          localStringBuilder.append(getOppoColorOSVersion());
          this.mDeviceVersion = localStringBuilder.toString();
        }
        else if (isXiaoMiDevice())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("MIUI_");
          localStringBuilder.append(getXiaomiMIUIVersion());
          this.mDeviceVersion = localStringBuilder.toString();
        }
        else if (isViVoDevice())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("VivoOS_");
          localStringBuilder.append(getVivoOSVersion());
          this.mDeviceVersion = localStringBuilder.toString();
        }
      }
    }
    return this.mDeviceVersion;
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
  
  public void initSettings(Context paramContext, String paramString)
  {
    initModels(paramContext, paramString);
    initSOCs(paramContext, paramString);
  }
  
  public boolean isHuaweiDevice()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.startsWith("HUAWEI"));
  }
  
  public boolean isMeiZuDevice()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.startsWith("MEIZU"));
  }
  
  public boolean isOppoDevice()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.startsWith("OPPO"));
  }
  
  public boolean isViVoDevice()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.startsWith("VIVO"));
  }
  
  public boolean isXiaoMiDevice()
  {
    String str = getDeviceName();
    return (!TextUtils.isEmpty(str)) && (str.startsWith("XIAOMI"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.DeviceInstance
 * JD-Core Version:    0.7.0.1
 */