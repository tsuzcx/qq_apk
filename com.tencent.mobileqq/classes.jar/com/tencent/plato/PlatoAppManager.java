package com.tencent.plato;

import aljx;
import aljy;
import aljz;
import alka;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.utils.Ev;
import com.tencent.plato.mqq.module.NavigationModule;
import com.tencent.plato.mqq.module.NetworkingModule;
import com.tencent.plato.sdk.PlatoSDKManager;
import com.tencent.plato.sdk.utils.DeviceInfo;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class PlatoAppManager
{
  public static int a;
  private static String a;
  public static HashMap a;
  public static AtomicBoolean a;
  public static boolean a;
  public static int b;
  public static HashMap b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PlatoManager";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Int = 1;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return OfflineEnvHelper.a(paramString1) + paramString1 + File.separator + paramString2;
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    localIntent.putExtra("bid", paramString);
    localIntent.putExtra("singledog", true);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivityForTool.class, PlatoAppFragment.class);
    jdField_a_of_type_Int = -1;
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    long l = System.currentTimeMillis();
    if (a(paramContext))
    {
      Ev.init(paramContext, new aljx());
      PlatoSDKManager.init(paramContext);
      a(paramAppRuntime);
      DeviceInfo.init();
      jdField_a_of_type_Boolean = true;
      TroopTechReportUtils.a("plato_v1", "sdk_init", String.valueOf(System.currentTimeMillis() - l), "", "", "");
      return;
    }
    b(paramContext, paramAppRuntime);
  }
  
  public static void a(String paramString, PlatoAppFragment paramPlatoAppFragment)
  {
    if (jdField_b_of_type_JavaUtilHashMap != null) {
      jdField_b_of_type_JavaUtilHashMap.put(paramString, paramPlatoAppFragment);
    }
  }
  
  public static void a(String paramString, PlatoAppJson paramPlatoAppJson)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramPlatoAppJson);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    ModuleManager.Arr.addModules(Arrays.asList(new IExportedModule[] { new NavigationModule(paramAppRuntime), new NetworkingModule() }));
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    boolean bool2;
    if (jdField_b_of_type_Int == 1)
    {
      bool2 = a(paramString);
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "LOAD_MODE_NEXT reuslt: " + bool2);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      long l = System.currentTimeMillis();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        HtmlOffline.a(paramString, paramAppRuntime, new aljz(bool1, paramString, l), true, 0, true);
        return;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      String str1 = a(paramContext, "libv8rt.so");
      String str2 = a(paramContext, "libplatonative.so");
      paramContext = a(paramContext, "libplato-layout.so");
      if ((FileUtils.e(str1)) && (FileUtils.e(str2)) && (FileUtils.e(paramContext)))
      {
        System.load(str1);
        System.load(str2);
        System.load(paramContext);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "System.load file =" + str1);
        }
      }
    }
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static boolean a(String paramString)
  {
    if ((HtmlOffline.c(paramString)) && (HtmlOffline.a(paramString, "http://bundler.js")))
    {
      String str = a(paramString, "bundler.js");
      if (FileUtils.e(str))
      {
        ThreadManager.post(new alka(paramString, str), 8, null, true);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "success : path" + str);
      }
    }
    return false;
  }
  
  public static void b(Context paramContext, AppRuntime paramAppRuntime)
  {
    HtmlOffline.a("3152", paramAppRuntime, new aljy(paramContext, paramAppRuntime, System.currentTimeMillis(), new long[1]), true, 0, true);
  }
  
  private static void d(Context paramContext, AppRuntime paramAppRuntime)
  {
    FileUtils.c(a("3152", "libv8rt.so"), a(paramContext, "libv8rt.so"));
    FileUtils.c(a("3152", "libplato-layout.so"), a(paramContext, "libplato-layout.so"));
    FileUtils.c(a("3152", "libplatonative.so"), a(paramContext, "libplatonative.so"));
    FileUtils.c(a("3152", "natives_blob.bin"), a(paramContext, "natives_blob.bin"));
    FileUtils.c(a("3152", "snapshot_blob.bin"), a(paramContext, "snapshot_blob.bin"));
    a(paramContext, paramAppRuntime);
    paramContext = PlatoLoadEvent.a(0);
    Dispatchers.get().dispatch(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppManager
 * JD-Core Version:    0.7.0.1
 */