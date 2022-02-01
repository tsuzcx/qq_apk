package com.tencent.mobileqq.qrscan.earlydown;

import android.content.Context;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class MiniScanDecodeSoLoader
  extends BaseQRScanResLoader
{
  public static boolean a = false;
  private static final Object b = new Object();
  
  public static String a()
  {
    Object localObject = MobileQQ.getContext().getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/");
    localStringBuilder.append("qq.android.minidecode.so_v8.8.5");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLibDir ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  protected static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = Xml.newPullParser();
    paramHashMap.clear();
    int i;
    try
    {
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject).getEventType();
    }
    catch (Exception paramHashMap)
    {
      String str;
      if (!QLog.isColorLevel()) {
        break label155;
      }
      QLog.e("MiniRecog.MiniScanDecodeSoLoader", 2, paramString, paramHashMap);
      label155:
      return false;
    }
    str = ((XmlPullParser)localObject).getName();
    if (str.equalsIgnoreCase("minicode")) {
      paramHashMap.put("minicode", ((XmlPullParser)localObject).nextText());
    }
    if (str.equalsIgnoreCase("minicode_64")) {
      paramHashMap.put("minicode_64", ((XmlPullParser)localObject).nextText());
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject).next();
      while (i == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseConfig success|config=");
          ((StringBuilder)localObject).append(paramHashMap);
          QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  public static boolean b()
  {
    if (!a(0, a, "minicode"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, "native so is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static Object c()
  {
    return b;
  }
  
  public static String c(String paramString)
  {
    return a(0, paramString);
  }
  
  public static byte d(String paramString)
  {
    return d(0, paramString);
  }
  
  public static byte e(String paramString)
  {
    return b(0, a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoLoader
 * JD-Core Version:    0.7.0.1
 */