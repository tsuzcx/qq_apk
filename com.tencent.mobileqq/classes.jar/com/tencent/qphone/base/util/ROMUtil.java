package com.tencent.qphone.base.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;

public class ROMUtil
{
  public static final String KEY_BUILD_DESCRIPTION = "ro.build.description";
  private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
  private static final String KEY_VERSION_EUI = "ro.letv.release.version";
  private static final String KEY_VERSION_GIONEE_0 = "ro.gn.gnromvernumber";
  private static final String KEY_VERSION_GIONEE_1 = "ro.gn.sv.version";
  private static final String KEY_VERSION_H2OS = "ro.rom.version";
  private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
  private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
  private static final String KEY_VERSION_NUBIA = "ro.build.rom.internal.id";
  private static final String KEY_VERSION_OPPO_0 = "ro.build.version.opporom";
  private static final String KEY_VERSION_OPPO_1 = "ro.rom.different.version";
  private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
  private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
  private static final String KEY_VERSION_ZTE_0 = "ro.build.MiFavor_version";
  private static final String ROM_360 = "360";
  private static final String ROM_ASUS = "ASUS";
  private static final String ROM_BLACK_BERRY = "BLACKBERRY";
  private static final String ROM_COOLPAD = "COOLPAD";
  private static final String ROM_EMUI = "EMUI";
  private static final String ROM_ESSENTIAL_PRODUCTS = "ESSENTIAL PRODUCTS";
  private static final String ROM_EUI = "EUI";
  private static final String ROM_FLYME = "FLYME";
  private static final String ROM_GIONEE = "AMIJO OS";
  private static final String ROM_GOOGLE = "GOOGLE";
  private static final String ROM_H2OS = "H2OS/O2OS";
  private static final String ROM_HTC = "HTC";
  private static final String ROM_LENOVO = "LENOVO";
  private static final String ROM_LG = "LGE";
  private static final String ROM_LINEAGE = "LINEAGE";
  private static final String ROM_MEITU = "MEITU";
  private static final String ROM_MIUI = "MIUI";
  private static final String ROM_MOTOROLA = "MOTOROLA";
  private static final String ROM_NOKAI = "HMD";
  private static final String ROM_NUBIA = "NUBIAUI";
  private static final String ROM_OPPO = "ColorOS";
  private static final String ROM_SAMSUNG = "SAMSUNG";
  private static final String ROM_SMARTISAN = "SMARTISAN";
  private static final String ROM_SONY = "SONY";
  private static final String ROM_SUGAR = "SUGAR";
  private static final String ROM_VIVO = "FuntouchOS";
  private static final String ROM_ZTE = "MiFavorUI";
  private static final String ROM_ZTE_1 = "ZTE";
  private static final String ROM_ZUK = "ZUK";
  private static final String SEPARATOR = ";";
  private static final String TAG = "ROMUtil";
  private static String[] deviceInfo;
  private static String romDescription;
  private static String romDetailInfo;
  private static String romName;
  private static String romVersion;
  
  public static String getProperty(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { paramString, "" });
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ROMUtil", 2, "getProperty fail, key=" + paramString + " , error message:" + localException.getMessage());
      }
    }
    return "";
  }
  
  public static String getRomDescription()
  {
    if (romDescription == null)
    {
      deviceInfo = getRomNameAndVersion();
      romDescription = deviceInfo[2];
    }
    return romDescription;
  }
  
  public static String getRomDetailInfo()
  {
    if (romDetailInfo == null)
    {
      deviceInfo = getRomNameAndVersion();
      romDetailInfo = deviceInfo[3];
    }
    return romDetailInfo;
  }
  
  public static String getRomName()
  {
    if (romName == null)
    {
      deviceInfo = getRomNameAndVersion();
      romName = deviceInfo[0];
    }
    return romName;
  }
  
  public static String[] getRomNameAndVersion()
  {
    if (deviceInfo != null) {
      return deviceInfo;
    }
    String str2 = getProperty("ro.build.description");
    Object localObject = getProperty("ro.miui.ui.version.name");
    String str1;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      str1 = "MIUI";
      str3 = ((String)localObject).replaceAll(str2, "").replaceAll(Build.DISPLAY + ";", "").replaceAll(Build.DISPLAY, "");
      if (!TextUtils.isEmpty(str3)) {
        break label720;
      }
    }
    label720:
    for (String str3 = str2;; str3 = str3 + ";" + Build.DISPLAY + ";" + str2)
    {
      str3 = str3.replaceAll("\\|", "\\");
      deviceInfo = new String[4];
      deviceInfo[0] = str1;
      deviceInfo[1] = localObject;
      deviceInfo[2] = str2;
      deviceInfo[3] = str3;
      return deviceInfo;
      localObject = getProperty("ro.build.version.emui");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "EMUI";
        break;
      }
      str1 = getProperty("ro.rom.different.version");
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = getProperty("ro.build.version.opporom");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      else
      {
        str1 = "ColorOS";
        break;
      }
      localObject = getProperty("ro.vivo.os.version");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "FuntouchOS";
        break;
      }
      localObject = getProperty("ro.smartisan.version");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "SMARTISAN";
        break;
      }
      localObject = getProperty("ro.lenovo.lvp.version");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "LENOVO";
        break;
      }
      str1 = getProperty("ro.gn.gnromvernumber");
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = getProperty("ro.gn.gnromvernumber");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      else
      {
        str1 = "AMIJO OS";
        break;
      }
      localObject = getProperty("ro.rom.version");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "H2OS/O2OS";
        break;
      }
      localObject = getProperty("ro.letv.release.version");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "EUI";
        break;
      }
      localObject = getProperty("ro.build.MiFavor_version");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "MiFavorUI";
        break;
      }
      localObject = getProperty("ro.build.rom.internal.id");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "NUBIAUI";
        break;
      }
      localObject = Build.DISPLAY;
      if (((String)localObject).toUpperCase().contains("FLYME"))
      {
        str1 = "FLYME";
        break;
      }
      if (str2.toUpperCase().contains("LINEAGE"))
      {
        str1 = "LINEAGE";
        localObject = str2;
        break;
      }
      str1 = Build.MANUFACTURER.toUpperCase();
      if (str1.contains("360"))
      {
        str1 = "360";
        localObject = Build.DISPLAY;
        break;
      }
      if ((str1.compareTo("ZTE") == 0) || (str1.compareTo("BLACKBERRY") == 0) || (str1.compareTo("COOLPAD") == 0))
      {
        localObject = Build.DISPLAY;
        break;
      }
      if ((str1.compareTo("MOTOROLA") == 0) || (str1.compareTo("LENOVO") == 0) || (str1.compareTo("LGE") == 0) || (str1.compareTo("ASUS") == 0) || (str1.compareTo("SUGAR") == 0) || (str1.compareTo("ESSENTIAL PRODUCTS") == 0) || (str1.compareTo("GOOGLE") == 0) || (str1.compareTo("ZUK") == 0) || (str1.compareTo("SAMSUNG") == 0))
      {
        localObject = str2;
        break;
      }
      if ((str1.compareTo("HTC") == 0) || (str1.compareTo("SONY") == 0) || (str1.compareTo("MEITU") == 0))
      {
        localObject = Build.DISPLAY + "/" + str2;
        break;
      }
      if (str1.contains("HMD"))
      {
        localObject = str2;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ROMUtil", 2, "Build.MANUFACTURER：" + Build.MANUFACTURER + "Build.DISPLAY：" + Build.DISPLAY + "DESCRIPTION：" + str2);
      }
      str1 = "[u]" + Build.MANUFACTURER;
      localObject = "?" + Build.DISPLAY + ";" + str2;
      break;
    }
  }
  
  public static String getRomVersion()
  {
    if (romVersion == null)
    {
      deviceInfo = getRomNameAndVersion();
      romVersion = deviceInfo[1];
    }
    return romVersion;
  }
  
  public static String getRomVersion(int paramInt)
  {
    if (paramInt <= 0) {
      return "";
    }
    if (romVersion == null)
    {
      deviceInfo = getRomNameAndVersion();
      romVersion = deviceInfo[1];
    }
    if (romVersion.length() > paramInt) {
      return romVersion.substring(0, paramInt);
    }
    return romVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.ROMUtil
 * JD-Core Version:    0.7.0.1
 */