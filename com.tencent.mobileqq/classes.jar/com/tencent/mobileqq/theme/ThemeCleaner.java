package com.tencent.mobileqq.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import anqu;
import aymh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeCleaner
  extends BroadcastReceiver
  implements Runnable
{
  private static final HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static final HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private static final AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("1103");
    localHashSet.add("2971");
    localHashSet.add("2921");
    localHashSet.add("3064");
    localHashSet.add("3063");
    localHashSet.add("3066");
    localHashSet.add("3065");
    localHashSet.add("3067");
    localHashSet.add("2920");
    jdField_a_of_type_JavaUtilHashSet = localHashSet;
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext.getDir("theme_810", 0));
    a(paramContext.getDir("mobileqq_theme", 0));
    ThemeSwitcher.a(ThemeUtil.getCurrentThemeId(), "210", null);
  }
  
  private static void a(File paramFile)
  {
    VasQuickUpdateEngine.safeDeleteFile(paramFile, "theme_move_");
    int i = ThemeUtil.getFileNumInFile(paramFile);
    QLog.e("ThemeCleaner", 1, "clean " + paramFile.getName() + ", remain " + i);
  }
  
  public static void a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("ThemeCleaner", 1, "addThemeToClean null appRuntime");
      return;
    }
    if (!a(localAppRuntime, paramString))
    {
      QLog.e("ThemeCleaner", 1, paramString + " should not clean");
      return;
    }
    QLog.e("ThemeCleaner", 1, "addThemeToClean: " + paramString);
    synchronized (jdField_b_of_type_JavaUtilHashSet)
    {
      a(localAppRuntime);
      jdField_b_of_type_JavaUtilHashSet.add(paramString);
      b(localAppRuntime);
      return;
    }
  }
  
  private static void a(AppRuntime paramAppRuntime)
  {
    int i = 0;
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      paramAppRuntime = ThemeUtil.getUinThemePreferences(paramAppRuntime);
      Object localObject = paramAppRuntime.getString("cleanList", "[]");
      try
      {
        localObject = new JSONArray((String)localObject);
        while (i < ((JSONArray)localObject).length())
        {
          jdField_b_of_type_JavaUtilHashSet.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ThemeCleaner", 1, "load: ", localJSONException);
        paramAppRuntime.edit().putString("cleanList", "[]").commit();
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!anqu.a(paramString)))
    {
      QLog.e("ThemeCleaner", 1, "cleanTheme error id: " + paramString);
      return;
    }
    if (paramString.equals(ThemeUtil.getCurrentThemeId()))
    {
      QLog.e("ThemeCleaner", 1, paramString + " is current, should not clean");
      return;
    }
    a(new File(new aymh().a(paramString).a(paramAppRuntime.getApplication())));
  }
  
  private static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!anqu.a(paramString)) || ("1000".equals(paramString)) || (jdField_a_of_type_JavaUtilHashSet.contains(paramString))) {}
    for (;;)
    {
      return false;
      paramAppRuntime = ThemeUtil.getUinThemePreferences(paramAppRuntime);
      try
      {
        Object localObject = paramAppRuntime.getString("themeArray", null);
        if ((!TextUtils.isEmpty(paramAppRuntime.getString("seriesID", null))) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localObject = new JSONArray((String)localObject);
          int i = 0;
          label87:
          if (i < ((JSONArray)localObject).length())
          {
            paramAppRuntime = ((JSONArray)localObject).getJSONObject(i);
            if (paramAppRuntime != null) {}
            for (paramAppRuntime = paramAppRuntime.getString("id");; paramAppRuntime = null)
            {
              boolean bool = paramString.equals(paramAppRuntime);
              if (bool) {
                break;
              }
              i += 1;
              break label87;
            }
          }
        }
        return true;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ThemeCleaner", 1, "shouldClean: ", paramAppRuntime);
        return false;
      }
    }
  }
  
  private static void b(AppRuntime paramAppRuntime)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = jdField_b_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    ThemeUtil.getUinThemePreferences(paramAppRuntime).edit().putString("cleanList", localJSONArray.toString()).commit();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
      return;
    }
    ThreadManagerV2.excute(this, 64, null, false);
  }
  
  public void run()
  {
    if (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      QLog.e("ThemeCleaner", 1, "another thread is cleaning");
      return;
    }
    AppRuntime localAppRuntime1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime1 == null) {
      QLog.e("ThemeCleaner", 1, "cleanList null appRuntime");
    }
    for (;;)
    {
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      Object localObject2;
      synchronized (jdField_b_of_type_JavaUtilHashSet)
      {
        a(localAppRuntime1);
        localObject2 = new ArrayList(jdField_b_of_type_JavaUtilHashSet);
        if (((ArrayList)localObject2).isEmpty()) {
          QLog.e("ThemeCleaner", 1, "empty list");
        }
      }
      ??? = ((ArrayList)localObject2).iterator();
      while (((Iterator)???).hasNext()) {
        a(localAppRuntime2, (String)((Iterator)???).next());
      }
      synchronized (jdField_b_of_type_JavaUtilHashSet)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          jdField_b_of_type_JavaUtilHashSet.remove(str);
        }
      }
      b(localAppRuntime3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeCleaner
 * JD-Core Version:    0.7.0.1
 */