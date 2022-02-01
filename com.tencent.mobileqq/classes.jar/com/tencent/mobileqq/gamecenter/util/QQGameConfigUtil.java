package com.tencent.mobileqq.gamecenter.util;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.GameCenterEnterConfBean;
import com.tencent.mobileqq.config.business.GameCenterEnterConfProcessor;
import com.tencent.mobileqq.config.business.QQGameConfBean;
import com.tencent.mobileqq.config.business.QQGameConfProcessor;
import com.tencent.mobileqq.config.business.QQGamePreloadConfBean;
import com.tencent.mobileqq.config.business.QQGamePreloadConfProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import java.util.ArrayList;
import java.util.List;

public class QQGameConfigUtil
{
  public static int a;
  public static String a;
  public static List<String> a;
  public static int b;
  public static int c;
  
  static
  {
    jdField_a_of_type_Int = 3;
    b = 30000;
    c = 7000;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilList = new ArrayList(3);
  }
  
  public static int a()
  {
    return QQGamePreloadConfProcessor.a().d;
  }
  
  public static String a()
  {
    String str2 = QQGameConfProcessor.a().jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public static boolean a()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    if ((localQQGameConfBean != null) && (localQQGameConfBean.jdField_a_of_type_Int > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isPubAccountSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isPubAccountSwitch = false");
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList(3);
    }
    return (jdField_a_of_type_JavaUtilList.size() < 3) && (!jdField_a_of_type_JavaUtilList.contains(paramString));
  }
  
  public static int b()
  {
    return QQGamePreloadConfProcessor.a().jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    String str2 = QQGameConfProcessor.a().jdField_b_of_type_JavaLangString;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
    }
    do
    {
      do
      {
        return str1;
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        str1 = str2;
      } while (str2.startsWith("http://"));
      str1 = str2;
    } while (str2.startsWith("https://"));
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
  }
  
  public static boolean b()
  {
    boolean bool = d();
    int i = QQGameHelper.a(QQGameHelper.a());
    return (bool) || (i == 0);
  }
  
  public static int c()
  {
    return QQGamePreloadConfProcessor.a().b;
  }
  
  public static String c()
  {
    QQGamePreloadConfProcessor.a();
    String str = "";
    if (TextUtils.isEmpty("")) {
      str = "https://imgcache.qq.com/ogame/sgame-official-account/precache.html";
    }
    return str;
  }
  
  public static boolean c()
  {
    GameCenterEnterConfBean localGameCenterEnterConfBean = GameCenterEnterConfProcessor.a();
    if ((localGameCenterEnterConfBean != null) && (localGameCenterEnterConfBean.b > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isGcMsgRemindOptimizeSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isGcMsgRemindOptimizeSwitch = false");
    }
    return false;
  }
  
  public static int d()
  {
    int i = 0;
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    if (localQQGamePreloadConfBean != null) {
      i = localQQGamePreloadConfBean.f;
    }
    return i;
  }
  
  public static String d()
  {
    String str2 = "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/gamedatalist";
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    String str1 = str2;
    if (localQQGamePreloadConfBean != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(localQQGamePreloadConfBean.jdField_a_of_type_JavaLangString)) {
        str1 = localQQGamePreloadConfBean.jdField_a_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public static boolean d()
  {
    boolean bool2 = false;
    Object localObject = QQGameConfProcessor.a();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((QQGameConfBean)localObject).c > 0)
      {
        localObject = ((QQGameConfBean)localObject).jdField_a_of_type_JavaLangString;
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool1 = bool2;
          if (URLUtil.isValidUrl((String)localObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean e()
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    if ((localQQGamePreloadConfBean != null) && (localQQGamePreloadConfBean.c > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isPreloadSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isPreloadSwitch = false");
    }
    return false;
  }
  
  public static boolean f()
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = QQGamePreloadConfProcessor.a();
    return (localQQGamePreloadConfBean != null) && (localQQGamePreloadConfBean.e == 1);
  }
  
  public static boolean g()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    return (localQQGameConfBean != null) && (localQQGameConfBean.jdField_a_of_type_Boolean);
  }
  
  public static boolean h()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    return (localQQGameConfBean != null) && (localQQGameConfBean.jdField_b_of_type_Boolean);
  }
  
  public static boolean i()
  {
    QQGameConfBean localQQGameConfBean = QQGameConfProcessor.a();
    return (localQQGameConfBean != null) && (localQQGameConfBean.d == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil
 * JD-Core Version:    0.7.0.1
 */