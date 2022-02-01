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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getProperty fail, key=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" , error message:");
        localStringBuilder.append(localException.getMessage());
        QLog.d("ROMUtil", 2, localStringBuilder.toString());
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
    Object localObject1 = deviceInfo;
    if (localObject1 != null) {
      return localObject1;
    }
    String str2 = getProperty("ro.build.description");
    localObject1 = getProperty("ro.miui.ui.version.name");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    String str3 = "360";
    String str1;
    if (!bool)
    {
      str1 = "MIUI";
    }
    else
    {
      localObject1 = getProperty("ro.build.version.emui");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        str1 = "EMUI";
      }
      else
      {
        str1 = getProperty("ro.rom.different.version");
        localObject1 = str1;
        if (TextUtils.isEmpty(str1))
        {
          localObject1 = getProperty("ro.build.version.opporom");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = getProperty("ro.vivo.os.version");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              str1 = "FuntouchOS";
              break label678;
            }
            localObject1 = getProperty("ro.smartisan.version");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              str1 = "SMARTISAN";
              break label678;
            }
            localObject1 = getProperty("ro.lenovo.lvp.version");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              str1 = "LENOVO";
              break label678;
            }
            localObject1 = getProperty("ro.gn.gnromvernumber");
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = getProperty("ro.gn.gnromvernumber");
              if (TextUtils.isEmpty((CharSequence)localObject1))
              {
                localObject1 = getProperty("ro.rom.version");
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  str1 = "H2OS/O2OS";
                  break label678;
                }
                localObject1 = getProperty("ro.letv.release.version");
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  str1 = "EUI";
                  break label678;
                }
                localObject1 = getProperty("ro.build.MiFavor_version");
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  str1 = "MiFavorUI";
                  break label678;
                }
                localObject1 = getProperty("ro.build.rom.internal.id");
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  str1 = "NUBIAUI";
                  break label678;
                }
                localObject1 = Build.DISPLAY;
                if (((String)localObject1).toUpperCase().contains("FLYME"))
                {
                  str1 = "FLYME";
                  break label678;
                }
                if (str2.toUpperCase().contains("LINEAGE"))
                {
                  localObject1 = str2;
                  str1 = "LINEAGE";
                  break label678;
                }
                str1 = Build.MANUFACTURER.toUpperCase();
                if (str1.contains("360"))
                {
                  localObject1 = Build.DISPLAY;
                  str1 = str3;
                  break label678;
                }
                if ((str1.compareTo("ZTE") != 0) && (str1.compareTo("BLACKBERRY") != 0) && (str1.compareTo("COOLPAD") != 0))
                {
                  if ((str1.compareTo("MOTOROLA") != 0) && (str1.compareTo("LENOVO") != 0) && (str1.compareTo("LGE") != 0) && (str1.compareTo("ASUS") != 0) && (str1.compareTo("SUGAR") != 0) && (str1.compareTo("ESSENTIAL PRODUCTS") != 0) && (str1.compareTo("GOOGLE") != 0) && (str1.compareTo("ZUK") != 0) && (str1.compareTo("SAMSUNG") != 0)) {
                    if ((str1.compareTo("HTC") != 0) && (str1.compareTo("SONY") != 0) && (str1.compareTo("MEITU") != 0))
                    {
                      if (!str1.contains("HMD"))
                      {
                        if (QLog.isColorLevel())
                        {
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append("Build.MANUFACTURER：");
                          ((StringBuilder)localObject1).append(Build.MANUFACTURER);
                          ((StringBuilder)localObject1).append("Build.DISPLAY：");
                          ((StringBuilder)localObject1).append(Build.DISPLAY);
                          ((StringBuilder)localObject1).append("DESCRIPTION：");
                          ((StringBuilder)localObject1).append(str2);
                          QLog.d("ROMUtil", 2, ((StringBuilder)localObject1).toString());
                        }
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append("[u]");
                        ((StringBuilder)localObject1).append(Build.MANUFACTURER);
                        str1 = ((StringBuilder)localObject1).toString();
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append("?");
                        ((StringBuilder)localObject1).append(Build.DISPLAY);
                        ((StringBuilder)localObject1).append(";");
                        ((StringBuilder)localObject1).append(str2);
                        localObject1 = ((StringBuilder)localObject1).toString();
                        break label678;
                      }
                    }
                    else
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(Build.DISPLAY);
                      ((StringBuilder)localObject1).append("/");
                      ((StringBuilder)localObject1).append(str2);
                      localObject1 = ((StringBuilder)localObject1).toString();
                      break label666;
                    }
                  }
                  localObject1 = str2;
                  break label678;
                }
                else
                {
                  localObject1 = Build.DISPLAY;
                }
                label666:
                break label678;
              }
            }
            str1 = "AMIJO OS";
            break label678;
          }
        }
        str1 = "ColorOS";
      }
    }
    label678:
    str3 = ((String)localObject1).replaceAll(str2, "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.DISPLAY);
    ((StringBuilder)localObject2).append(";");
    str3 = str3.replaceAll(((StringBuilder)localObject2).toString(), "").replaceAll(Build.DISPLAY, "");
    if (TextUtils.isEmpty(str3))
    {
      str3 = str2;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(";");
      ((StringBuilder)localObject2).append(Build.DISPLAY);
      ((StringBuilder)localObject2).append(";");
      ((StringBuilder)localObject2).append(str2);
      str3 = ((StringBuilder)localObject2).toString();
    }
    str3 = str3.replaceAll("\\|", "\\");
    deviceInfo = new String[4];
    localObject2 = deviceInfo;
    localObject2[0] = str1;
    localObject2[1] = localObject1;
    localObject2[2] = str2;
    localObject2[3] = str3;
    return localObject2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.ROMUtil
 * JD-Core Version:    0.7.0.1
 */