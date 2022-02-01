package com.tencent.mobileqq.leba.core;

import android.content.SharedPreferences;
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
  private static String a = "LebaWebPreloadHelper";
  protected static HashMap<String, String> a;
  protected static boolean a = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "updateBuffer");
      return;
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    Object localObject = MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_web_plugin_list");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = SharedPreferencesHandler.a((SharedPreferences)localObject, localStringBuilder.toString(), null);
    if ((paramAppRuntime != null) && (!paramAppRuntime.isEmpty()))
    {
      paramAppRuntime = paramAppRuntime.iterator();
      while (paramAppRuntime.hasNext())
      {
        localObject = (String)paramAppRuntime.next();
        jdField_a_of_type_JavaUtilHashMap.put(localObject, localObject);
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
    if (paramAppRuntime == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "notifyRefreshWebProcess");
      return;
    }
    paramAppRuntime = (IWebProcessManagerService)paramAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
    if ((jdField_a_of_type_Boolean) && (paramAppRuntime.isNeedPreloadWebProcess())) {
      paramAppRuntime.startWebProcess(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaWebPreloadHelper
 * JD-Core Version:    0.7.0.1
 */