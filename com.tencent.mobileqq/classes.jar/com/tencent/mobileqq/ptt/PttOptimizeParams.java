package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PttOptimizeParams
{
  private static int jdField_a_of_type_Int = 1;
  private static long jdField_a_of_type_Long = 1L;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int = 1;
  private static long jdField_b_of_type_Long = 2L;
  private static int jdField_c_of_type_Int = 1;
  private static long jdField_c_of_type_Long = 4L;
  private static int jdField_d_of_type_Int = 1;
  private static long jdField_d_of_type_Long = 8L;
  private static int jdField_e_of_type_Int = 480000;
  private static long jdField_e_of_type_Long = 16L;
  private static int f = 9;
  private static int g = 3;
  private static int h = 1;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    return jdField_e_of_type_Int;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, false);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    long l2 = 0L;
    if (a(paramQQAppInterface)) {
      l2 = 0L | jdField_a_of_type_Long;
    }
    long l1 = l2;
    if (b(paramQQAppInterface)) {
      l1 = l2 | jdField_b_of_type_Long;
    }
    l2 = l1;
    if (c(paramQQAppInterface)) {
      l2 = l1 | jdField_c_of_type_Long;
    }
    l1 = l2;
    if (d(paramQQAppInterface)) {
      l1 = l2 | jdField_d_of_type_Long;
    }
    l2 = l1;
    if (paramBoolean) {
      l2 = l1 | jdField_e_of_type_Long;
    }
    return l2;
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("ptt_optimize_cfg_v2", null);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "getSavedPttOptimizeCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putString("ptt_optimize_cfg_v2", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "savePttOptimizeCfg: " + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if ((bool) && (!paramBoolean)) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        try
        {
          Object localObject = a(paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initPttOptimizeCfgStr: " + (String)localObject);
          }
          if (localObject != null)
          {
            localObject = ((String)localObject).split("\\|");
            jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
            jdField_b_of_type_Int = Integer.valueOf(localObject[1]).intValue();
            jdField_e_of_type_Int = Integer.valueOf(localObject[2]).intValue();
            f = Integer.valueOf(localObject[3]).intValue();
            g = Integer.valueOf(localObject[4]).intValue();
            jdField_c_of_type_Int = Integer.valueOf(localObject[5]).intValue();
            jdField_d_of_type_Int = Integer.valueOf(localObject[6]).intValue();
            h = Integer.valueOf(localObject[7]).intValue();
          }
          localObject = paramQQAppInterface.getCurrentAccountUin();
          if (jdField_a_of_type_Int == 0)
          {
            if (!((String)localObject).endsWith("1")) {
              break label514;
            }
            jdField_a_of_type_Int = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initDirectDownloadCfgStr: " + jdField_a_of_type_Int);
          }
          if (jdField_b_of_type_Int == 0)
          {
            if (!((String)localObject).endsWith("2")) {
              break label521;
            }
            jdField_b_of_type_Int = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initSSCMCfgStr: " + jdField_b_of_type_Int);
          }
          if (jdField_c_of_type_Int == 0)
          {
            if (!((String)localObject).endsWith("3")) {
              break label528;
            }
            jdField_c_of_type_Int = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initActivateNet: " + jdField_c_of_type_Int);
          }
          if (jdField_d_of_type_Int == 0)
          {
            if (!paramQQAppInterface.getCurrentAccountUin().endsWith("5")) {
              break label535;
            }
            jdField_d_of_type_Int = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initHttpSideWay: " + jdField_d_of_type_Int);
          }
          if (h == 0)
          {
            if (!((String)localObject).endsWith("4")) {
              break label542;
            }
            h = 2;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PttOptimizeParams", 2, "sPreSendSwitch: " + h);
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initOptimizeCfg exception: " + paramQQAppInterface);
          }
          jdField_a_of_type_Int = 1;
          jdField_b_of_type_Int = 1;
          jdField_e_of_type_Int = 480000;
          f = 9;
          g = 3;
          jdField_c_of_type_Int = 1;
          jdField_d_of_type_Int = 1;
          h = 1;
        }
        continue;
        jdField_a_of_type_Int = 1;
      }
      finally {}
      label514:
      continue;
      label521:
      jdField_b_of_type_Int = 1;
      continue;
      label528:
      jdField_c_of_type_Int = 1;
      continue;
      label535:
      jdField_d_of_type_Int = 1;
      continue;
      label542:
      h = 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportDirectDownload:" + jdField_a_of_type_Int);
    }
    return jdField_a_of_type_Int == 1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    return f;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportSSCM:" + jdField_b_of_type_Int);
    }
    return jdField_b_of_type_Int == 1;
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    return g;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportActivateNet:" + jdField_c_of_type_Int);
    }
    return jdField_c_of_type_Int == 1;
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    return h;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportHttpSideWay:" + jdField_d_of_type_Int);
    }
    return jdField_d_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttOptimizeParams
 * JD-Core Version:    0.7.0.1
 */