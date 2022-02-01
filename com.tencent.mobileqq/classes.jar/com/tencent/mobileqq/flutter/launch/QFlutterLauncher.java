package com.tencent.mobileqq.flutter.launch;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.peterlmeng.animate_image.AnimateImgInitManager;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.qflutter.qflutter_network_image.QFlutterNetworkImage;
import com.qflutter.qqface.loader.QQFaceLoader;
import com.qflutter.resource_loader.QFlutterResourceLoader;
import com.qflutter.superchannel.SuperChannelLog;
import com.qflutter.vistaimage.VistaImageLog;
import com.qflutter.vistaimage.VistaImagePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.flutter.ipc.FlutterSubQIPCModule;
import com.tencent.mobileqq.flutter.plugin.QFlutterLog;
import com.tencent.mobileqq.flutter.plugin.QFlutterNetworkImageImpl;
import com.tencent.mobileqq.flutter.plugin.QFlutterResourceLoaderNativeImp;
import com.tencent.mobileqq.flutter.plugin.animateimage.AnimateImgInit;
import com.tencent.mobileqq.flutter.qqface.QFlutterFace;
import com.tencent.mobileqq.flutter.report.QFlutterReporter;
import com.tencent.mobileqq.flutter.vistaimage.SuperChannelLogImpl;
import com.tencent.mobileqq.flutter.vistaimage.VistaImageLogImpl;
import com.tencent.mobileqq.flutter.vistaimage.VistaImageProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import io.flutter.view.FlutterMain;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class QFlutterLauncher
{
  private static QFlutterLauncher jdField_a_of_type_ComTencentMobileqqFlutterLaunchQFlutterLauncher;
  private static String jdField_a_of_type_JavaLangString = "";
  private int jdField_a_of_type_Int = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsLooper);
  private final Looper jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
  private LaunchTrace jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace = new LaunchTrace();
  private QuickInstaller jdField_a_of_type_ComTencentMobileqqFlutterLaunchQuickInstaller = new QuickInstaller();
  private final Set<LaunchListener> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  public static QFlutterLauncher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFlutterLaunchQFlutterLauncher == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqFlutterLaunchQFlutterLauncher == null) {
          jdField_a_of_type_ComTencentMobileqqFlutterLaunchQFlutterLauncher = new QFlutterLauncher();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqFlutterLaunchQFlutterLauncher;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("QFlutter.launcher", 1, String.format("notifyResult, errCode: %s, isFirstLaunch: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsLooper)
    {
      b(paramInt, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new QFlutterLauncher.4(this, paramInt, paramBoolean));
  }
  
  private void b()
  {
    Looper.myLooper();
    Looper localLooper = this.jdField_a_of_type_AndroidOsLooper;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (paramInt == 0) {
      this.jdField_a_of_type_Int = 2;
    } else {
      this.jdField_a_of_type_Int = 0;
    }
    LaunchResult localLaunchResult = new LaunchResult(paramInt, paramBoolean, this.jdField_a_of_type_Boolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.a(paramInt, this.jdField_a_of_type_Boolean);
      localLaunchResult.a(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((LaunchListener)localIterator.next()).a(localLaunchResult);
    }
  }
  
  private void b(LaunchListener paramLaunchListener)
  {
    if (paramLaunchListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramLaunchListener);
      return;
    }
  }
  
  private void b(String paramString)
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.f();
    FlutterMain.setNativeLibDir(paramString);
    e();
    FlutterMain.startInitialization(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.g();
    a(0, true);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, "start install");
    }
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.a();
    if (DebugInstaller.a())
    {
      this.jdField_a_of_type_Boolean = true;
      DebugInstaller.a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchQuickInstaller.a(new QFlutterLauncher.1(this));
  }
  
  private void d()
  {
    FlutterSubQIPCModule.a();
    Bundle localBundle = new Bundle();
    if (2 == BaseApplicationImpl.sProcessId) {
      localBundle.putString("FlutterCallerIpcProcessName", "com.tencent.mobileqq:qzone");
    } else if (1 == BaseApplicationImpl.sProcessId) {
      localBundle.putString("FlutterCallerIpcProcessName", "com.tencent.mobileqq");
    }
    QIPCClientHelper.getInstance().getClient().callServer("FlutterMainQIPCModule", "ACTION_INSTALL_ENGINE", localBundle, new QFlutterLauncher.2(this));
  }
  
  private void e()
  {
    QflutterLogPlugin.setLog(new QFlutterLog(QFlutterInstaller.a("libQFlutterLog.so")));
    QFlutterResourceLoader.get().init(BaseApplicationImpl.getContext(), new QFlutterResourceLoaderNativeImp(BaseApplicationImpl.getContext()));
    QQFaceLoader.instance().init(new QFlutterFace());
    QFlutterNetworkImageImpl.a(QFlutterInstaller.a("libqflutter-resource-loader.so"));
    QFlutterNetworkImage.g().init(new QFlutterNetworkImageImpl());
    AnimateImgInitManager localAnimateImgInitManager = AnimateImgInitManager.getsInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ExpandResourceUtil.b());
    localStringBuilder.append("/");
    localStringBuilder.append("liblibpag.so");
    localAnimateImgInitManager.init(new AnimateImgInit(localStringBuilder.toString()));
    VistaImagePlugin.init(VistaImageProxy.a());
    SuperChannelLog.init(new SuperChannelLogImpl());
    VistaImageLog.init(new VistaImageLogImpl());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.d();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QFlutterInstaller.b());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("res.apk");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (FileUtil.b((String)localObject1)) {
      try
      {
        Object localObject2 = FlutterMain.findAppBundlePath();
        AssetManager localAssetManager = BaseApplicationImpl.getContext().getAssets();
        localObject2 = localAssetManager.list((String)localObject2);
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break label161;
        }
        QLog.e("QFlutter.launcher", 2, "AssetRes should reload !");
        localObject2 = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        ((Method)localObject2).setAccessible(true);
        ((Method)localObject2).invoke(localAssetManager, new Object[] { localObject1 });
      }
      catch (Exception localException)
      {
        QLog.e("QFlutter.launcher", 1, "reloadAssetResIfNeed", localException);
      }
    } else {
      QLog.e("QFlutter.launcher", 1, String.format("assetsPath: %s not exist when reload asset", new Object[] { localException }));
    }
    label161:
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.e();
  }
  
  public void a(LaunchListener paramLaunchListener)
  {
    if (paramLaunchListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(paramLaunchListener);
      return;
    }
  }
  
  public void a(LaunchListener paramLaunchListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    b();
    b(paramLaunchListener);
    int i = this.jdField_a_of_type_Int;
    if (i == 2)
    {
      QLog.d("QFlutter.launcher", 1, "engine is running");
      a(0, false);
      return;
    }
    if (i == 1)
    {
      QLog.d("QFlutter.launcher", 1, "engine is launching");
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.h();
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.a(paramBoolean1, paramBoolean2);
    c();
  }
  
  public void a(QFlutterLauncher.InstallResult paramInstallResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, String.format("onInstallResult, isSuccess: %s, installDir: %s, isLocalEngineExist: %s, isLocalAppExist: %s, fromQuickInstall: %s", new Object[] { Boolean.valueOf(paramInstallResult.jdField_a_of_type_Boolean), paramInstallResult.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramInstallResult.jdField_b_of_type_Boolean), Boolean.valueOf(paramInstallResult.c), Boolean.valueOf(paramInstallResult.d) }));
    }
    QFlutterReporter.a(paramInstallResult.jdField_b_of_type_JavaLangString);
    if ((paramInstallResult.jdField_a_of_type_Boolean) && (FileUtil.b(paramInstallResult.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.a(paramInstallResult.jdField_b_of_type_Boolean, paramInstallResult.c, paramInstallResult.d);
      a(paramInstallResult.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.d("QFlutter.launcher", 1, String.format("onInstallResult, isSuccess: %s, installDir: %s, fileIsExist: %s", new Object[] { Boolean.valueOf(paramInstallResult.jdField_a_of_type_Boolean), paramInstallResult.jdField_a_of_type_JavaLangString, Boolean.valueOf(FileUtil.b(paramInstallResult.jdField_a_of_type_JavaLangString)) }));
    a(3, true);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("res.apk");
    localObject = ((StringBuilder)localObject).toString();
    if (FileUtil.b((String)localObject)) {
      try
      {
        AssetManager localAssetManager = BaseApplicationImpl.getContext().getAssets();
        Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localAssetManager, new Object[] { localObject });
        this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace.c();
        if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsLooper)
        {
          b(paramString);
          return;
        }
        ThreadManager.getUIHandler().postAtFrontOfQueue(new QFlutterLauncher.3(this, paramString));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QFlutter.launcher", 1, "loadAsset", paramString);
        a(5, true);
        return;
      }
    }
    QLog.e("QFlutter.launcher", 1, String.format("assetsPath: %s not exist", new Object[] { localObject }));
    a(4, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QFlutterLauncher
 * JD-Core Version:    0.7.0.1
 */