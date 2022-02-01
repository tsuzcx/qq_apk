package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LebaWebPreloadHelper
{
  private static String a;
  protected static HashMap<String, String> a;
  protected static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LebaWebPreloadHelper";
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "updateBuffer");
    }
    for (;;)
    {
      return;
      jdField_a_of_type_JavaUtilHashMap.clear();
      paramAppRuntime = SharedPreferencesHandler.a(MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4), "key_web_plugin_list" + paramAppRuntime.getCurrentAccountUin(), null);
      if ((paramAppRuntime != null) && (!paramAppRuntime.isEmpty()))
      {
        paramAppRuntime = paramAppRuntime.iterator();
        while (paramAppRuntime.hasNext())
        {
          String str = (String)paramAppRuntime.next();
          jdField_a_of_type_JavaUtilHashMap.put(str, str);
        }
      }
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      a(paramAppRuntime);
    }
    return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "notifyRefreshWebProcess");
    }
    do
    {
      return;
      paramAppRuntime = (IWebProcessManagerService)paramAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
    } while ((!jdField_a_of_type_Boolean) || (!paramAppRuntime.isNeedPreloadWebProcess()));
    paramAppRuntime.startWebProcess(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaWebPreloadHelper
 * JD-Core Version:    0.7.0.1
 */