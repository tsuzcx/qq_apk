package com.tencent.mobileqq.qrscan.earlydown;

import android.content.Context;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class QBarModelLoader
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
        QLog.i("MiniRecog.QBarModelLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/");
    localStringBuilder.append("qq.android.qbarnative.model_v8.6.0");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLibDir ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("MiniRecog.QBarModelLoader", 2, localStringBuilder.toString());
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
        break label210;
      }
      QLog.e("MiniRecog.QBarModelLoader", 2, paramString, paramHashMap);
      label210:
      return false;
    }
    str = ((XmlPullParser)localObject).getName();
    if (str.equalsIgnoreCase("detect_model.bin")) {
      paramHashMap.put("detect_model.bin", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("detect_model.param")) {
      paramHashMap.put("detect_model.param", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("srnet.bin")) {
      paramHashMap.put("srnet.bin", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("srnet.param")) {
      paramHashMap.put("srnet.param", ((XmlPullParser)localObject).nextText());
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
          QLog.d("MiniRecog.QBarModelLoader", 2, ((StringBuilder)localObject).toString());
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
  
  public static byte c(String paramString)
  {
    return d(3, paramString);
  }
  
  public static boolean c()
  {
    if ((d("detect_model.bin")) && (d("detect_model.param")) && (d("srnet.bin")) && (d("srnet.param"))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.QBarModelLoader", 2, "model res is not exist!");
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    return a(3, a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.QBarModelLoader
 * JD-Core Version:    0.7.0.1
 */