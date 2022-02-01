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
import com.qflutter.vistaplayer.VistaPlayerLog;
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
import com.tencent.mobileqq.flutter.vistaimage.VistaPlayerLogImpl;
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
  private static QFlutterLauncher a;
  private static String b = "";
  private int c = 0;
  private final Looper d = Looper.getMainLooper();
  private final Handler e = new Handler(this.d);
  private final Set<LaunchListener> f = new HashSet();
  private LaunchTrace g = new LaunchTrace();
  private QuickInstaller h = new QuickInstaller();
  private boolean i;
  
  public static QFlutterLauncher a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QFlutterLauncher();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("QFlutter.launcher", 1, String.format("notifyResult, errCode: %s, isFirstLaunch: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (Looper.myLooper() == this.d)
    {
      b(paramInt, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new QFlutterLauncher.4(this, paramInt, paramBoolean));
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    this.e.removeCallbacksAndMessages(null);
    if (paramInt == 0) {
      this.c = 2;
    } else {
      this.c = 0;
    }
    LaunchResult localLaunchResult = new LaunchResult(paramInt, paramBoolean, this.i);
    if (paramBoolean)
    {
      this.g.a(paramInt, this.i);
      localLaunchResult.a(this.g);
    }
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((LaunchListener)localIterator.next()).a(localLaunchResult);
    }
  }
  
  private void b(LaunchListener paramLaunchListener)
  {
    if (paramLaunchListener == null) {
      return;
    }
    synchronized (this.f)
    {
      this.f.add(paramLaunchListener);
      return;
    }
  }
  
  private void b(String paramString)
  {
    c();
    this.g.f();
    FlutterMain.setNativeLibDir(paramString);
    f();
    FlutterMain.startInitialization(BaseApplicationImpl.getContext());
    this.g.g();
    a(0, true);
  }
  
  private void c()
  {
    Looper.myLooper();
    Looper localLooper = this.d;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, "start install");
    }
    this.g.a();
    if (DebugInstaller.a())
    {
      this.i = true;
      DebugInstaller.b();
      return;
    }
    this.i = false;
    this.h.a(new QFlutterLauncher.1(this));
  }
  
  private void e()
  {
    FlutterSubQIPCModule.b();
    Bundle localBundle = new Bundle();
    if (2 == BaseApplicationImpl.sProcessId) {
      localBundle.putString("FlutterCallerIpcProcessName", "com.tencent.mobileqq:qzone");
    } else if (1 == BaseApplicationImpl.sProcessId) {
      localBundle.putString("FlutterCallerIpcProcessName", "com.tencent.mobileqq");
    }
    QIPCClientHelper.getInstance().getClient().callServer("FlutterMainQIPCModule", "ACTION_INSTALL_ENGINE", localBundle, new QFlutterLauncher.2(this));
  }
  
  private void f()
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
    SuperChannelLog.init(new SuperChannelLogImpl());
    VistaImageLog.init(new VistaImageLogImpl());
    VistaPlayerLog.init(new VistaPlayerLogImpl());
    g();
  }
  
  private void g() {}
  
  public void a(LaunchListener paramLaunchListener)
  {
    if (paramLaunchListener == null) {
      return;
    }
    synchronized (this.f)
    {
      this.f.remove(paramLaunchListener);
      return;
    }
  }
  
  public void a(LaunchListener paramLaunchListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    c();
    b(paramLaunchListener);
    int j = this.c;
    if (j == 2)
    {
      QLog.d("QFlutter.launcher", 1, "engine is running");
      a(0, false);
      return;
    }
    if (j == 1)
    {
      QLog.d("QFlutter.launcher", 1, "engine is launching");
      return;
    }
    this.c = 1;
    this.g.i();
    this.g.a(paramBoolean1, paramBoolean2);
    d();
  }
  
  public void a(QFlutterLauncher.InstallResult paramInstallResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, String.format("onInstallResult, isSuccess: %s, installDir: %s, isLocalEngineExist: %s, isLocalAppExist: %s, fromQuickInstall: %s", new Object[] { Boolean.valueOf(paramInstallResult.a), paramInstallResult.b, Boolean.valueOf(paramInstallResult.c), Boolean.valueOf(paramInstallResult.d), Boolean.valueOf(paramInstallResult.f) }));
    }
    QFlutterReporter.a(paramInstallResult.e);
    if ((paramInstallResult.a) && (FileUtil.d(paramInstallResult.b)))
    {
      this.g.a(paramInstallResult.c, paramInstallResult.d, paramInstallResult.f);
      a(paramInstallResult.b);
      return;
    }
    QLog.d("QFlutter.launcher", 1, String.format("onInstallResult, isSuccess: %s, installDir: %s, fileIsExist: %s", new Object[] { Boolean.valueOf(paramInstallResult.a), paramInstallResult.b, Boolean.valueOf(FileUtil.d(paramInstallResult.b)) }));
    a(3, true);
  }
  
  public void a(String paramString)
  {
    this.g.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("res.apk");
    localObject = ((StringBuilder)localObject).toString();
    if (FileUtil.d((String)localObject)) {
      try
      {
        AssetManager localAssetManager = BaseApplicationImpl.getContext().getAssets();
        Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localAssetManager, new Object[] { localObject });
        this.g.c();
        if (Looper.myLooper() == this.d)
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
  
  public void b()
  {
    this.g.d();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QFlutterInstaller.b());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("res.apk");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (FileUtil.d((String)localObject1)) {
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
    this.g.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QFlutterLauncher
 * JD-Core Version:    0.7.0.1
 */