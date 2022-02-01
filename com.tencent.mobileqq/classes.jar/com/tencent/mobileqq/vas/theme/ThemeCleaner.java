package com.tencent.mobileqq.vas.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.util.VasTextUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
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
    b(paramContext.getDir("theme_810", 0));
    b(paramContext.getDir("mobileqq_theme", 0));
    ThemeSwitcher.a(ThemeUtil.getCurrentThemeId(), "210", null);
  }
  
  public static void a(String paramString)
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 == null)
    {
      QLog.e("ThemeCleaner", 1, "addThemeToClean null appRuntime");
      return;
    }
    if (!a((AppRuntime)localObject1, paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" should not clean");
      QLog.e("ThemeCleaner", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("addThemeToClean: ");
    ((StringBuilder)???).append(paramString);
    QLog.e("ThemeCleaner", 1, ((StringBuilder)???).toString());
    synchronized (jdField_b_of_type_JavaUtilHashSet)
    {
      a((AppRuntime)localObject1);
      jdField_b_of_type_JavaUtilHashSet.add(paramString);
      b((AppRuntime)localObject1);
      return;
    }
  }
  
  private static void a(AppRuntime paramAppRuntime)
  {
    Object localObject = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    int i = 0;
    if (((AtomicBoolean)localObject).compareAndSet(false, true))
    {
      paramAppRuntime = ThemeUtil.getUinThemePreferences(paramAppRuntime);
      localObject = paramAppRuntime.getString("cleanList", "[]");
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
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new ThemeCleaner.1(paramString, paramAppRuntime));
  }
  
  private static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (VasTextUtil.a(paramString)) && (!"1000".equals(paramString))) {
      if (jdField_a_of_type_JavaUtilHashSet.contains(paramString)) {
        return false;
      }
    }
    label150:
    for (paramAppRuntime = ThemeUtil.getUinThemePreferences(paramAppRuntime);; paramAppRuntime = null)
    {
      try
      {
        Object localObject = paramAppRuntime.getString("themeArray", null);
        if ((!TextUtils.isEmpty(paramAppRuntime.getString("seriesID", null))) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localObject = new JSONArray((String)localObject);
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            paramAppRuntime = ((JSONArray)localObject).getJSONObject(i);
            if (paramAppRuntime == null) {
              break label150;
            }
            paramAppRuntime = paramAppRuntime.getString("id");
            boolean bool = paramString.equals(paramAppRuntime);
            if (bool) {
              return false;
            }
            i += 1;
          }
        }
        return true;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ThemeCleaner", 1, "shouldClean: ", paramAppRuntime);
      }
      return false;
    }
  }
  
  private static void b(File paramFile)
  {
    VasUpdateUtil.a(paramFile, "theme_move_");
    int i = ThemeUtil.getFileNumInFile(paramFile);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clean ");
    localStringBuilder.append(paramFile.getName());
    localStringBuilder.append(", remain ");
    localStringBuilder.append(i);
    QLog.e("ThemeCleaner", 1, localStringBuilder.toString());
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
  
  private static void b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (VasTextUtil.a(paramString)))
    {
      if (paramString.equals(ThemeUtil.getCurrentThemeId()))
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(" is current, should not clean");
        QLog.e("ThemeCleaner", 1, paramAppRuntime.toString());
        return;
      }
      b(new File(new ThemeLocator().a(paramString).a(paramAppRuntime.getApplication())));
      return;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("cleanTheme error id: ");
    paramAppRuntime.append(paramString);
    QLog.e("ThemeCleaner", 1, paramAppRuntime.toString());
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
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null) {
      QLog.e("ThemeCleaner", 1, "cleanList null appRuntime");
    }
    synchronized (jdField_b_of_type_JavaUtilHashSet)
    {
      a(localAppRuntime);
      Object localObject4 = new ArrayList(jdField_b_of_type_JavaUtilHashSet);
      if (((ArrayList)localObject4).isEmpty())
      {
        QLog.e("ThemeCleaner", 1, "empty list");
      }
      else
      {
        ??? = ((ArrayList)localObject4).iterator();
        while (((Iterator)???).hasNext()) {
          b(localAppRuntime, (String)((Iterator)???).next());
        }
      }
      synchronized (jdField_b_of_type_JavaUtilHashSet)
      {
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          String str = (String)((Iterator)localObject4).next();
          jdField_b_of_type_JavaUtilHashSet.remove(str);
        }
        b(localAppRuntime);
        jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeCleaner
 * JD-Core Version:    0.7.0.1
 */