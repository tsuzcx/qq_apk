package cooperation.comic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicProxyActivity;
import cooperation.comic.VipProxyPreLoadComicProcess;
import cooperation.comic.jsp.QQComicDownloadObserverProxy;
import cooperation.comic.jsp.QQComicJsCallback;
import cooperation.comic.jsp.QQComicJsPluginBuilder;
import cooperation.comic.jsp.QQComicJsPluginProxy;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Observer;
import mqq.app.AppRuntime;

public class QQComicPluginBridge
{
  public static QQComicDownloadObserverProxy a;
  public static QQComicJsPluginBuilder a;
  public static FirstInObservable a;
  public static RuntimeCreateObservable a;
  private static final Object a;
  public static volatile boolean a;
  public static boolean b = false;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_CooperationComicJspQQComicJsPluginBuilder = null;
    jdField_a_of_type_CooperationComicJspQQComicDownloadObserverProxy = null;
    jdField_a_of_type_CooperationComicUtilsFirstInObservable = null;
    jdField_a_of_type_CooperationComicUtilsRuntimeCreateObservable = null;
  }
  
  public static QQComicJsPluginProxy a(WebViewPlugin.PluginRuntime paramPluginRuntime, QQComicJsCallback paramQQComicJsCallback)
  {
    if (jdField_a_of_type_CooperationComicJspQQComicJsPluginBuilder == null) {
      return null;
    }
    return jdField_a_of_type_CooperationComicJspQQComicJsPluginBuilder.a(paramPluginRuntime, paramQQComicJsCallback);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin start");
    }
    if (!QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk")) {
      VasWebviewUtil.reportVasStatus("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Intent localIntent = new Intent(paramContext, VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    PreloadSuccessRateReporter.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    a(localIntent);
    if ((IndividuationUrlHelper.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)IndividuationUrlHelper.a());
    }
    if (paramBundle != null) {
      localIntent.putExtra("extraBundle", paramBundle);
    }
    paramBundle = new IPluginManager.PluginParams(0);
    paramBundle.b = "comic_plugin.apk";
    paramBundle.e = "comic_plugin";
    paramBundle.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramBundle.f = "com.qqcomic.app.VipPreloadComicProcess";
    paramBundle.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.b(paramContext, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin end");
    }
  }
  
  public static void a(Intent paramIntent)
  {
    boolean bool7 = false;
    int i = 0;
    if (paramIntent == null) {
      return;
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.comic_plugin_profile.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d("QQComicPluginBridge", 2, "parseDPC config = " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        arrayOfInteger = new Integer[7];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        arrayOfInteger[2] = Integer.valueOf(1);
        if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, arrayOfInteger) >= arrayOfInteger.length)
        {
          i = arrayOfInteger[0].intValue();
          if (i == 1) {
            bool1 = true;
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          boolean bool6;
          try
          {
            i = arrayOfInteger[1].intValue();
            if (i == 1) {
              bool2 = true;
            }
          }
          catch (Exception localException2)
          {
            Integer[] arrayOfInteger;
            int j;
            bool2 = true;
            bool3 = bool1;
            bool4 = false;
            bool1 = false;
            i = 0;
            continue;
          }
          try
          {
            i = arrayOfInteger[2].intValue();
            if (i == 1) {
              bool3 = true;
            }
          }
          catch (Exception localException3)
          {
            bool5 = true;
            bool3 = bool1;
            bool4 = bool2;
            bool1 = false;
            i = 0;
            bool2 = bool5;
            continue;
          }
          try
          {
            i = arrayOfInteger[3].intValue();
            if (i == 1) {
              bool4 = true;
            }
          }
          catch (Exception localException4)
          {
            bool6 = false;
            bool4 = bool1;
            bool5 = bool2;
            i = 0;
            bool1 = bool6;
            bool2 = bool3;
            bool3 = bool4;
            bool4 = bool5;
            continue;
          }
          try
          {
            i = arrayOfInteger[5].intValue();
          }
          catch (Exception localException5)
          {
            bool5 = bool1;
            bool6 = bool2;
            i = 0;
            bool1 = bool4;
            bool2 = bool3;
            bool3 = bool5;
            bool4 = bool6;
            continue;
          }
          try
          {
            j = arrayOfInteger[6].intValue();
            if (j == 1)
            {
              bool5 = true;
              bool6 = bool4;
              bool7 = bool3;
              bool4 = bool2;
              bool3 = bool1;
              bool2 = bool7;
              bool1 = bool6;
              paramIntent.putExtra("isSetHardWareLayerForWebview", bool4);
              paramIntent.putExtra("isHandleNavigationBar", bool2);
              paramIntent.putExtra("isCloseHardAcc", bool1);
              paramIntent.putExtra("bitDepthFlag", i);
              paramIntent.putExtra("skipBitmapReuse", bool5);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QQComicDebug", 2, "parseDPC isPreloadInMiddlePage = " + bool3 + " , isSetHardWareLayerForWebview = " + bool4 + " , isHandleNavigationBar = " + bool2 + " , isCloseHardAcc = " + bool1 + " , bitDepthFlag = " + i + " , skipBitmapReuse = " + bool5);
              return;
              bool1 = false;
              continue;
              bool2 = false;
              continue;
              bool3 = false;
              continue;
              bool4 = false;
              continue;
            }
            bool5 = false;
            continue;
            localException1 = localException1;
            bool2 = true;
            bool3 = false;
            bool4 = false;
            bool1 = false;
            i = 0;
          }
          catch (Exception localException6)
          {
            bool5 = bool4;
            bool4 = bool1;
            bool6 = bool2;
            bool1 = bool5;
            bool2 = bool3;
            bool3 = bool4;
            bool4 = bool6;
          }
        }
        localException1.printStackTrace();
        bool5 = bool7;
        continue;
        bool5 = false;
        bool2 = true;
        bool3 = false;
        bool4 = false;
        bool1 = false;
        continue;
      }
      i = 0;
      boolean bool2 = true;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool1 = false;
      boolean bool5 = bool7;
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      long l = System.currentTimeMillis();
      Class localClass = PluginStatic.getOrCreateClassLoader(BaseApplicationImpl.getContext(), "comic_plugin.apk").loadClass("com.qqcomic.utils.ComicPluginVersionInfo");
      localClass.getDeclaredMethod("printVersionInfo", new Class[] { String.class }).invoke(localClass, new Object[] { paramString });
      QLog.i("QQComicPluginBridge", 2, "ComicPlugin.checkBoodoPluginVersion, msg=" + paramString + ", call_time=" + (System.currentTimeMillis() - l));
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
      return;
    }
    catch (InstantiationException paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
    }
  }
  
  public static void a(Observer paramObserver)
  {
    if (jdField_a_of_type_CooperationComicUtilsFirstInObservable == null) {
      jdField_a_of_type_CooperationComicUtilsFirstInObservable = new FirstInObservable();
    }
    for (;;)
    {
      jdField_a_of_type_CooperationComicUtilsFirstInObservable.addObserver(paramObserver);
      return;
      jdField_a_of_type_CooperationComicUtilsFirstInObservable.deleteObservers();
    }
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    if ((!jdField_a_of_type_Boolean) || (paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramIntent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
    if ((paramActivity instanceof BasePluginActivity))
    {
      paramActivity.startActivity(paramIntent);
      return true;
    }
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("params_remote_connect_at_launch", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "comic_plugin.apk";
    localPluginParams.e = "comic_plugin";
    localPluginParams.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localPluginParams.f = paramString;
    localPluginParams.jdField_a_of_type_JavaLangClass = VipComicProxyActivity.a(paramString);
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.d = 10000;
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = paramPreloadProcHitPluginSession;
    IPluginManager.a(paramActivity, localPluginParams);
    return true;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    boolean bool = false;
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!(paramAppRuntime instanceof QQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "Not in main process, QQComic is NOT installed");
          }
          return jdField_a_of_type_Boolean;
        }
        paramAppRuntime = (IPluginManager)paramAppRuntime.getManager(QQManagerFactory.MGR_PLUGIN);
        if (paramAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      return false;
      paramAppRuntime = paramAppRuntime.a("comic_plugin.apk");
      if (paramAppRuntime != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQComicPluginBridge", 2, "QQComic is NOT found");
    return false;
    if (paramAppRuntime.mState == 4) {}
    for (bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return jdField_a_of_type_Boolean;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, QQComicPluginBridge.PluginInstallObserver arg2)
  {
    boolean bool = false;
    if (a(paramAppRuntime))
    {
      jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        paramAppRuntime = (IPluginManager)paramAppRuntime.getManager(QQManagerFactory.MGR_PLUGIN);
        if (paramAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      return false;
      ThreadManager.executeOnNetWorkThread(new QQComicPluginBridge.1(paramAppRuntime, ???));
    } while (!paramBoolean);
    Object localObject = paramAppRuntime.a("comic_plugin.apk");
    if ((localObject != null) && (((PluginBaseInfo)localObject).mState != 4)) {}
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicPluginBridge", 2, "QQComic is waiting for installation");
        }
        try
        {
          jdField_a_of_type_JavaLangObject.wait();
          if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "QQComic installation is finished");
          }
          ??? = paramAppRuntime.a("comic_plugin.apk");
          if ((??? != null) && (???.mState == 4))
          {
            paramBoolean = true;
            jdField_a_of_type_Boolean = paramBoolean;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("QQComic is ");
              if (!jdField_a_of_type_Boolean) {
                break label272;
              }
              paramAppRuntime = "installed";
              localObject = ((StringBuilder)localObject).append(paramAppRuntime).append(", ComicPlugin.pluginInfo.version=");
              if (??? != null) {
                break label279;
              }
              paramAppRuntime = "info null";
              QLog.d("QQComicPluginBridge", 2, paramAppRuntime);
            }
            if (jdField_a_of_type_Boolean) {
              a("plugin_ready");
            }
            return jdField_a_of_type_Boolean;
          }
        }
        catch (InterruptedException localInterruptedException) {}
      }
      paramBoolean = false;
      continue;
      label272:
      paramAppRuntime = "NOT installed";
      continue;
      label279:
      paramAppRuntime = ???.mVersion;
    }
  }
  
  public static void b(Observer paramObserver)
  {
    if (jdField_a_of_type_CooperationComicUtilsRuntimeCreateObservable == null) {
      jdField_a_of_type_CooperationComicUtilsRuntimeCreateObservable = new RuntimeCreateObservable();
    }
    for (;;)
    {
      jdField_a_of_type_CooperationComicUtilsRuntimeCreateObservable.addObserver(paramObserver);
      return;
      jdField_a_of_type_CooperationComicUtilsRuntimeCreateObservable.deleteObservers();
    }
  }
  
  public static void c(Observer paramObserver)
  {
    if ((jdField_a_of_type_CooperationComicUtilsRuntimeCreateObservable != null) && (paramObserver != null)) {
      jdField_a_of_type_CooperationComicUtilsRuntimeCreateObservable.deleteObserver(paramObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.QQComicPluginBridge
 * JD-Core Version:    0.7.0.1
 */