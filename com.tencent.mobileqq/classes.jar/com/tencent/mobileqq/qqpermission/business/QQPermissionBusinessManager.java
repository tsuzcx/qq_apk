package com.tencent.mobileqq.qqpermission.business;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import java.util.Map;

public class QQPermissionBusinessManager
{
  private static String jdField_a_of_type_JavaLangString;
  private static Map<String, QQPermissionBusinessManager.BusinessData> jdField_a_of_type_JavaUtilMap = new ArrayMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap.put("id_test", new QQPermissionBusinessManager.BusinessData(2131699099, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_SMS", "qq.permission.notification" }));
    jdField_a_of_type_JavaUtilMap.put("biz_src_weather", new QQPermissionBusinessManager.BusinessData(2131699101, new String[] { "android.permission.ACCESS_FINE_LOCATION" }));
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return "";
    }
    int i = ((QQPermissionBusinessManager.BusinessData)jdField_a_of_type_JavaUtilMap.get(paramString)).jdField_a_of_type_Int;
    if (i <= 0) {
      return "";
    }
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = paramContext.getString(2131699100);
    }
    return String.format(jdField_a_of_type_JavaLangString, new Object[] { paramContext.getString(i) });
  }
  
  public static boolean a(QQPermissionConfig paramQQPermissionConfig, String[] paramArrayOfString)
  {
    if (!jdField_a_of_type_JavaUtilMap.containsKey(paramQQPermissionConfig.id()))
    {
      QPLog.b("QQPermissionBusinessManager", new Object[] { "check: business id not exist!" });
      return false;
    }
    paramQQPermissionConfig = ((QQPermissionBusinessManager.BusinessData)jdField_a_of_type_JavaUtilMap.get(paramQQPermissionConfig.id())).jdField_a_of_type_ArrayOfJavaLangString;
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString[i];
      int m = paramQQPermissionConfig.length;
      int j = 0;
      while (j < m)
      {
        if (paramQQPermissionConfig[j].equals(str))
        {
          j = 1;
          break label108;
        }
        j += 1;
      }
      j = 0;
      label108:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager
 * JD-Core Version:    0.7.0.1
 */