package com.tencent.mobileqq.qqpermission.business;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import java.util.Map;

public class QQPermissionBusinessManager
{
  private static Map<String, QQPermissionBusinessManager.BusinessData> a = new ArrayMap();
  private static String b;
  
  static
  {
    a.put("id_test", new QQPermissionBusinessManager.BusinessData(2131897111, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_SMS", "qq.permission.notification" }));
    a.put("biz_src_weather", new QQPermissionBusinessManager.BusinessData(2131897117, new String[] { "android.permission.ACCESS_FINE_LOCATION" }));
    a.put("biz_src_qqsports", new QQPermissionBusinessManager.BusinessData(2131897116, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.CAMERA" }));
    a.put("biz_src_kandian_publisher", new QQPermissionBusinessManager.BusinessData(2131897114, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" }));
    a.put("biz_src_qqlive_camera_record_android", new QQPermissionBusinessManager.BusinessData(2131897115, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO" }));
    a.put("biz_src_qqchannel_audio", new QQPermissionBusinessManager.BusinessData(2131897113, new String[] { "android.permission.RECORD_AUDIO" }));
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (!a.containsKey(paramString)) {
      return "";
    }
    int i = ((QQPermissionBusinessManager.BusinessData)a.get(paramString)).a;
    if (i <= 0) {
      return "";
    }
    if (b == null) {
      b = paramContext.getString(2131897112);
    }
    return String.format(b, new Object[] { paramContext.getString(i) });
  }
  
  public static boolean a(BusinessConfig paramBusinessConfig, String[] paramArrayOfString)
  {
    if (!a.containsKey(paramBusinessConfig.a()))
    {
      QPLog.b("QQPermissionBusinessManager", new Object[] { "check: business id not exist!" });
      return false;
    }
    paramBusinessConfig = ((QQPermissionBusinessManager.BusinessData)a.get(paramBusinessConfig.a())).b;
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString[i];
      int m = paramBusinessConfig.length;
      int j = 0;
      while (j < m)
      {
        if (paramBusinessConfig[j].equals(str))
        {
          j = 1;
          break label104;
        }
        j += 1;
      }
      j = 0;
      label104:
      if (j == 0)
      {
        QPLog.b("QQPermissionBusinessManager", new Object[] { "check: permission not register!" });
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager
 * JD-Core Version:    0.7.0.1
 */