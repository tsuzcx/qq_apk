package com.vivo.push.util;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
{
  public static final boolean a = z.b("ro.vivo.product.overseas", "no").equals("yes");
  public static final String b;
  public static final boolean c = "RU".equals(b);
  public static final boolean d = "IN".equals(b);
  public static final boolean e = b("rom_1.0");
  public static final boolean f = b("rom_2.0");
  public static final boolean g = b("rom_2.5");
  public static final boolean h = b("rom_3.0");
  private static Method i;
  private static String j = null;
  private static String k = null;
  private static String l = "";
  private static String m = "";
  
  static
  {
    String str;
    if (Build.VERSION.SDK_INT >= 26) {
      str = z.b("ro.product.country.region", "N");
    } else {
      str = z.b("ro.product.customize.bbk", "N");
    }
    b = str;
  }
  
  public static String a()
  {
    label108:
    try
    {
      if (j == null)
      {
        localObject1 = k;
        if (localObject1 != null) {}
      }
    }
    finally {}
    try
    {
      localObject1 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class, String.class });
      i = (Method)localObject1;
      ((Method)localObject1).setAccessible(true);
      j = (String)i.invoke(null, new Object[] { "ro.vivo.rom", "@><@" });
      k = (String)i.invoke(null, new Object[] { "ro.vivo.rom.version", "@><@" });
    }
    catch (Exception localException)
    {
      break label108;
    }
    o.b("Device", "getRomCode error");
    Object localObject1 = new StringBuilder("sRomProperty1 : ");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(" ; sRomProperty2 : ");
    ((StringBuilder)localObject1).append(k);
    o.d("Device", ((StringBuilder)localObject1).toString());
    localObject1 = a(j);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    if (!bool) {
      return localObject1;
    }
    localObject1 = a(k);
    bool = TextUtils.isEmpty((CharSequence)localObject1);
    if (!bool) {
      return localObject1;
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(paramString);
    if (paramString.find())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.group(1));
      if (TextUtils.isEmpty(paramString.group(2))) {
        paramString = "0";
      } else {
        paramString = paramString.group(2).substring(0, 1);
      }
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString1 });
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = paramString2;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = paramString2;
    }
    return str;
  }
  
  public static boolean b()
  {
    if (TextUtils.isEmpty(Build.MANUFACTURER))
    {
      o.d("Device", "Build.MANUFACTURER is null");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("Build.MANUFACTURER is ");
    localStringBuilder.append(Build.MANUFACTURER);
    o.d("Device", localStringBuilder.toString());
    return (Build.MANUFACTURER.toLowerCase().contains("bbk")) || (Build.MANUFACTURER.toLowerCase().startsWith("vivo"));
  }
  
  private static boolean b(String paramString)
  {
    String str1 = z.b("ro.vivo.rom", "");
    String str2 = z.b("ro.vivo.rom.version", "");
    StringBuilder localStringBuilder = new StringBuilder("ro.vivo.rom = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" ; ro.vivo.rom.version = ");
    localStringBuilder.append(str2);
    o.d("Device", localStringBuilder.toString());
    return ((str1 != null) && (str1.contains(paramString))) || ((str2 != null) && (str2.contains(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.j
 * JD-Core Version:    0.7.0.1
 */