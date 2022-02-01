package com.tencent.mobileqq.qrscan.earlydown;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class MiniScanDetectModelLoader
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
        QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/");
    localStringBuilder.append("qq.android.minidetect.model_v8.6.0");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLibDir ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    return paramString;
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
        break label232;
      }
      QLog.e("MiniRecog.MiniScanDetectModelLoader", 2, paramString, paramHashMap);
      label232:
      return false;
    }
    str = ((XmlPullParser)localObject).getName();
    if (str.equalsIgnoreCase("qr_anchor.bin")) {
      paramHashMap.put("qr_anchor.bin", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("qr_detection_model.txt")) {
      paramHashMap.put("qr_detection_model.txt", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("qr_detection_model.bin")) {
      paramHashMap.put("qr_detection_model.bin", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("match_detect_so_md5")) {
      b("match_detect_so_md5", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("match_detect_so_md5_64")) {
      b("match_detect_so_md5_64", ((XmlPullParser)localObject).nextText());
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
          QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static Object b()
  {
    return b;
  }
  
  public static String b(String paramString)
  {
    return paramString;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4).edit();
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(paramString2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qrscan_native_res_");
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "").apply();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qrscan_native_res_");
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString2).apply();
    }
    if (QLog.isColorLevel())
    {
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "null";
      }
      QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("saveMatchDetectSoMd5=%s tag=%s", new Object[] { localObject, paramString1 }));
    }
  }
  
  public static byte c(String paramString)
  {
    return d(2, paramString);
  }
  
  public static boolean c()
  {
    if ((d("qr_anchor.bin")) && (d("qr_detection_model.txt")) && (d("qr_detection_model.bin"))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "modules is not exist!");
    }
    return false;
  }
  
  public static String d()
  {
    Object localObject1 = MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("qrscan_native_res_");
    ((StringBuilder)localObject2).append("match_detect_so_md5");
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), null);
    if (QLog.isColorLevel())
    {
      if (localObject2 == null) {
        localObject1 = "null";
      } else {
        localObject1 = localObject2;
      }
      QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("getMatchDetectSoMd5=%s tag=%s", new Object[] { localObject1, "match_detect_so_md5" }));
    }
    return localObject2;
  }
  
  public static boolean d(String paramString)
  {
    return a(2, a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectModelLoader
 * JD-Core Version:    0.7.0.1
 */