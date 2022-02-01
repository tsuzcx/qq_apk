package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public final class TripleGraySwitchUtil
{
  private static ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "KEY_DELAY_LOAD_PROXY", "KEY_ENABLE_MEMORY_LEAK", "KEY_DISABLE_NAVIGATION_BAR", "KEY_DISABLE_SAVE_PLUGIN_INFO" };
  
  public static void a(Context paramContext, boolean paramBoolean, @Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getSharedPreferences("BootOptimize", 0).edit();
      Object localObject;
      if (paramBoolean)
      {
        paramContext.putLong("_last_crash_time_", System.currentTimeMillis());
        paramString = jdField_a_of_type_ArrayOfJavaLangString;
        int j = paramString.length;
        while (i < j)
        {
          paramThrowable = paramString[i];
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("8.7.0");
          ((StringBuilder)localObject).append(paramThrowable);
          paramContext.putBoolean(((StringBuilder)localObject).toString(), true);
          i += 1;
        }
      }
      if (TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("8.7.0");
        ((StringBuilder)localObject).append(paramString);
        paramContext.putBoolean(((StringBuilder)localObject).toString(), true);
        if (paramThrowable != null)
        {
          while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
          }
          localObject = new StringWriter();
          paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
          paramThrowable = new StringBuilder();
          paramThrowable.append("8.7.0_crash_because_");
          paramThrowable.append(paramString);
          paramContext.putString(paramThrowable.toString(), ((StringWriter)localObject).getBuffer().toString());
        }
      }
      paramContext.apply();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, false);
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (paramContext != null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("TripleGraySwitchUtil", 2, new Object[] { "call setSwitch, Context=", Boolean.valueOf(bool), " ,key=", paramString, " ,value=", Boolean.valueOf(paramBoolean) });
    }
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramContext.getSharedPreferences("BootOptimize", 0).edit().putBoolean(paramString, paramBoolean).apply();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(paramBoolean));
      return true;
    }
    return false;
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return true;
    }
    paramContext = paramContext.getSharedPreferences("BootOptimize", 0);
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("8.7.0");
      localStringBuilder.append(paramString);
      if (paramContext.getBoolean(localStringBuilder.toString(), false)) {
        return false;
      }
    }
    long l = paramContext.getLong("_last_crash_time_", 0L);
    return System.currentTimeMillis() - l > 1800000L;
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (paramContext != null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("TripleGraySwitchUtil", 2, new Object[] { "call getSwitch, Context=", Boolean.valueOf(bool), " ,key=", paramString, " judgeSafeMode=", Boolean.valueOf(paramBoolean) });
    }
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((Boolean)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).booleanValue();
      }
      if ((paramBoolean) && (!b(paramContext, paramString))) {
        return false;
      }
      paramBoolean = paramContext.getSharedPreferences("BootOptimize", 0).getBoolean(paramString, false);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(paramBoolean));
      if (QLog.isColorLevel()) {
        QLog.d("TripleGraySwitchUtil", 2, new Object[] { "key=", paramString, " value=", Boolean.valueOf(paramBoolean) });
      }
      return paramBoolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TripleGraySwitchUtil
 * JD-Core Version:    0.7.0.1
 */