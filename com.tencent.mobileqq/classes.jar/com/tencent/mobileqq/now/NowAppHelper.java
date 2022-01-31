package com.tencent.mobileqq.now;

import afzy;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.NowHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NowAppHelper
{
  public static String a;
  public static String[] a;
  public static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "NowTag";
    b = "";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NowChannelSvc" };
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    NowManager localNowManager = (NowManager)paramQQAppInterface.getManager(197);
    NowHandler localNowHandler = (NowHandler)paramQQAppInterface.a(102);
    Object localObject = paramQQAppInterface.getApp().getSharedPreferences("key_now_conf", 0);
    long l1;
    long l2;
    if (!((SharedPreferences)localObject).getBoolean("key_is_mf_channel", true))
    {
      l1 = ((SharedPreferences)localObject).getLong("key_updateInternal", 0L);
      l2 = ((SharedPreferences)localObject).getLong("key_lastTime", 0L);
      if (System.currentTimeMillis() / 1000L - l2 < l1) {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "request limit, last query time = " + l2 + ", interval = " + l1);
        }
      }
    }
    int i;
    do
    {
      return;
      l2 = ((SharedPreferences)localObject).getLong("key_first_time", 0L);
      l1 = l2;
      if (l2 < 1L)
      {
        l1 = System.currentTimeMillis() / 1000L;
        ((SharedPreferences)localObject).edit().putLong("key_first_time", l1).commit();
      }
      bool = ((SharedPreferences)localObject).getBoolean("key_now_create_flag", false);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doNowPreload, isCreate=" + bool);
      }
      if (!bool) {
        break;
      }
      i = 1;
      localNowHandler.a("beginNowLogic", String.valueOf(l1), "", "", "", i);
    } while (bool);
    b = ((SharedPreferences)localObject).getString("key_now_channel", "");
    localObject = localNowManager.a();
    boolean bool = localNowManager.a((ChannelResponse)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doNowPreload, nowId=" + b + ", bUpdate=" + bool + ", resp=" + localObject);
    }
    if (bool)
    {
      if (localObject != null)
      {
        paramQQAppInterface = String.valueOf(((ChannelResponse)localObject).client_action);
        label358:
        if (localObject != null) {
          break label401;
        }
      }
      label401:
      for (i = 0;; i = 1)
      {
        localNowHandler.a("getConf", "", "", "", paramQQAppInterface, i);
        localNowHandler.a(l1, b);
        return;
        i = 0;
        break;
        paramQQAppInterface = "0";
        break label358;
      }
    }
    a(paramQQAppInterface, (ChannelResponse)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChannelResponse paramChannelResponse)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("key_now_conf", 0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doShortCutAction begin, resp=" + paramChannelResponse);
    }
    NowHandler localNowHandler = (NowHandler)paramQQAppInterface.a(102);
    if (QQUtils.a(paramQQAppInterface.getApp(), new String[] { "NOW" }))
    {
      localSharedPreferences.edit().putBoolean("key_now_create_flag", true).commit();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doShortCutAction...end, hasShortCut");
      }
    }
    long l;
    do
    {
      do
      {
        return;
        if (!PackageUtil.a(paramQQAppInterface.getApp(), "com.tencent.now")) {
          break;
        }
        localSharedPreferences.edit().putBoolean("key_now_create_flag", true).commit();
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doShortCutAction...end, hasApk");
      return;
      l = System.currentTimeMillis() / 1000L;
    } while ((paramChannelResponse == null) || (paramChannelResponse.isDownload != 1) || (paramChannelResponse.downloadTime > l));
    ThreadManager.post(new afzy(paramQQAppInterface, localNowHandler, paramChannelResponse, localSharedPreferences), 2, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowAppHelper
 * JD-Core Version:    0.7.0.1
 */