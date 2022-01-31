package com.tencent.plato;

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
  public static final String BID_QUN_APP_SETTING = "3124";
  public static final String BID_V8_SO = "3152";
  public static final int JS_STATUS_NEED_UPDATE = 1;
  public static final int JS_STATUS_NO_UPDATE = 0;
  public static final int JS_STATUS_UN_KNOW = -1;
  public static final int LOAD_MODE_NEXT = 1;
  public static final int LOAD_MODE_TIMEOUT = 2;
  public static final int LOAD_MODE_WAIT = 0;
  public static final String PARAM_ACROSS_PROCESSES = "singledog";
  public static final String PARAM_LOADMODE = "loadmode";
  public static final String REPORT_TYPE = "plato_v1";
  public static final String SO_PLATO_LAYOUT_NAME = "libplato-layout.so";
  public static final String SO_PLATO_NATIVE_NAME = "libplatonative.so";
  public static final String SO_V8_NAME = "libv8rt.so";
  private static String TAG = "PlatoManager";
  public static final String V8_NATIVE_BIN_NAME = "natives_blob.bin";
  public static final String V8_SNAPSHOT_BIN_NAME = "snapshot_blob.bin";
  public static int jsLoad_status;
  public static HashMap mAppModule;
  public static boolean mIsInit;
  public static int mLoadMode = 1;
  public static HashMap mRunningAppModule;
  public static AtomicBoolean sV8LibLoaded = new AtomicBoolean(false);
  
  static
  {
    jsLoad_status = -1;
    mAppModule = new HashMap();
    mRunningAppModule = new HashMap();
  }
  
  private static void _copySoAndInit(Context paramContext, AppRuntime paramAppRuntime)
  {
    FileUtils.c(getAbsFilePath("3152", "libv8rt.so"), getSoPath(paramContext, "libv8rt.so"));
    FileUtils.c(getAbsFilePath("3152", "libplato-layout.so"), getSoPath(paramContext, "libplato-layout.so"));
    FileUtils.c(getAbsFilePath("3152", "libplatonative.so"), getSoPath(paramContext, "libplatonative.so"));
    FileUtils.c(getAbsFilePath("3152", "natives_blob.bin"), getSoPath(paramContext, "natives_blob.bin"));
    FileUtils.c(getAbsFilePath("3152", "snapshot_blob.bin"), getSoPath(paramContext, "snapshot_blob.bin"));
    init(paramContext, paramAppRuntime);
    paramContext = PlatoLoadEvent.createSoLoadEvent(0);
    Dispatchers.get().dispatch(paramContext);
  }
  
  public static void apiInit(AppRuntime paramAppRuntime)
  {
    ModuleManager.Arr.addModules(Arrays.asList(new IExportedModule[] { new NavigationModule(paramAppRuntime), new NetworkingModule() }));
  }
  
  public static String getAbsFilePath(String paramString1, String paramString2)
  {
    return OfflineEnvHelper.a(paramString1) + paramString1 + File.separator + paramString2;
  }
  
  public static PlatoAppJson getAppModule(String paramString)
  {
    if (mAppModule != null) {
      return (PlatoAppJson)mAppModule.get(paramString);
    }
    return null;
  }
  
  public static PlatoAppFragment getRunningAppModule(String paramString)
  {
    if (mRunningAppModule != null) {
      return (PlatoAppFragment)mRunningAppModule.get(paramString);
    }
    return null;
  }
  
  public static String getSoPath(Context paramContext, String paramString)
  {
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString;
  }
  
  public static void init(Context paramContext, AppRuntime paramAppRuntime)
  {
    long l = System.currentTimeMillis();
    if (loadV8So(paramContext))
    {
      Ev.init(paramContext, new PlatoAppManager.1());
      PlatoSDKManager.init(paramContext);
      apiInit(paramAppRuntime);
      DeviceInfo.init();
      mIsInit = true;
      TroopTechReportUtils.a("plato_v1", "sdk_init", String.valueOf(System.currentTimeMillis() - l), "", "", "");
      return;
    }
    preInitV8So(paramContext, paramAppRuntime);
  }
  
  public static void loadApp(Activity paramActivity, AppRuntime paramAppRuntime, String paramString, Intent paramIntent)
  {
    if (!mIsInit) {
      init(paramActivity.getApplicationContext(), paramAppRuntime);
    }
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    localIntent.putExtra("bid", paramString);
    localIntent.putExtra("loadmode", mLoadMode);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivityForTool.class, PlatoAppFragment.class);
    loadPlatoAppByBid(paramAppRuntime, paramString);
    jsLoad_status = -1;
  }
  
  public static void loadAppAcrossProcess(Activity paramActivity, String paramString, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    localIntent.putExtra("bid", paramString);
    localIntent.putExtra("singledog", true);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivityForTool.class, PlatoAppFragment.class);
    jsLoad_status = -1;
  }
  
  public static boolean loadBunderJSByBid(String paramString)
  {
    if ((HtmlOffline.c(paramString)) && (HtmlOffline.a(paramString, "http://bundler.js")))
    {
      String str = getAbsFilePath(paramString, "bundler.js");
      if (FileUtils.e(str))
      {
        ThreadManager.post(new PlatoAppManager.4(paramString, str), 8, null, true);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "success : path" + str);
      }
    }
    return false;
  }
  
  public static void loadPlatoAppByBid(AppRuntime paramAppRuntime, String paramString)
  {
    boolean bool2;
    if (mLoadMode == 1)
    {
      bool2 = loadBunderJSByBid(paramString);
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "LOAD_MODE_NEXT reuslt: " + bool2);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      long l = System.currentTimeMillis();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        HtmlOffline.a(paramString, paramAppRuntime, new PlatoAppManager.3(bool1, paramString, l), true, 0, true);
        return;
      }
    }
  }
  
  public static boolean loadV8So(Context paramContext)
  {
    if (!sV8LibLoaded.get())
    {
      String str1 = getSoPath(paramContext, "libv8rt.so");
      String str2 = getSoPath(paramContext, "libplatonative.so");
      paramContext = getSoPath(paramContext, "libplato-layout.so");
      if ((FileUtils.e(str1)) && (FileUtils.e(str2)) && (FileUtils.e(paramContext)))
      {
        System.load(str1);
        System.load(str2);
        System.load(paramContext);
        sV8LibLoaded.set(true);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "System.load file =" + str1);
        }
      }
    }
    return sV8LibLoaded.get();
  }
  
  public static void preInitV8So(Context paramContext, AppRuntime paramAppRuntime)
  {
    HtmlOffline.a("3152", paramAppRuntime, new PlatoAppManager.2(paramContext, paramAppRuntime, System.currentTimeMillis(), new long[1]), true, 0, true);
  }
  
  public static void setAppModule(String paramString, PlatoAppJson paramPlatoAppJson)
  {
    if (mAppModule != null) {
      mAppModule.put(paramString, paramPlatoAppJson);
    }
  }
  
  public static void setRunningAppModule(String paramString, PlatoAppFragment paramPlatoAppFragment)
  {
    if (mRunningAppModule != null) {
      mRunningAppModule.put(paramString, paramPlatoAppFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppManager
 * JD-Core Version:    0.7.0.1
 */