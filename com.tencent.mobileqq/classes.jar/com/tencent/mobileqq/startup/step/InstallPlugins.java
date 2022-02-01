package com.tencent.mobileqq.startup.step;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginInfoUtil;
import cooperation.plugin.PluginInstaller;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class InstallPlugins
  extends Step
{
  public static final String[] a = { "qzone_plugin.apk", "qwallet_plugin.apk" };
  public static InstallPlugins.ReportInfo b;
  public static InstallPlugins.QzoneInstallResult c;
  
  public static void a()
  {
    try
    {
      if (c != null)
      {
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          localObject1 = ((AppRuntime)localObject1).getAccount();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject1, "qzonePrePluginInstall", c.a, c.b, 0L, null, null);
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("install qzone:");
          ((StringBuilder)localObject1).append(c.a);
          ((StringBuilder)localObject1).append(",cost:");
          ((StringBuilder)localObject1).append(c.b);
          QLog.i("plugin_tag.InstallPlugins", 1, ((StringBuilder)localObject1).toString());
        }
        c = null;
      }
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (b != null)
        {
          Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (localObject1 != null)
          {
            localObject1 = ((AppRuntime)localObject1).getAccount();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("param_FailCode", String.valueOf(b.a));
              localHashMap.put("from", String.valueOf(paramInt));
              StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getApplication());
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(b.c);
              ((StringBuilder)localObject3).append("ExtractInfo");
              localObject3 = ((StringBuilder)localObject3).toString();
              if (b.a != 0) {
                break label158;
              }
              bool = true;
              localStatisticCollector.collectPerformance((String)localObject1, (String)localObject3, bool, b.b, 0L, localHashMap, null);
            }
          }
          b = null;
        }
        else
        {
          return;
        }
      }
      finally {}
      label158:
      boolean bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(arrayOfString[i], paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    File localFile = new File(PluginUtils.getPluginInstallDir(localBaseApplicationImpl), paramString1);
    if ((localFile.exists()) && ("qwallet_plugin.apk".equals(paramString1)))
    {
      QLog.d("plugin_tag.InstallPlugins", 1, "installed");
      return true;
    }
    if (PluginStatic.getClassLoader(paramString1) != null)
    {
      QLog.d("plugin_tag.InstallPlugins", 1, "dexLoaded");
      return true;
    }
    b(paramString1);
    Object localObject1 = null;
    StringBuilder localStringBuilder;
    try
    {
      String str = PluginUtils.extractPluginAndGetMd5Code(localBaseApplicationImpl, paramString1, localFile);
      localObject1 = str;
    }
    catch (Exception localException)
    {
      float f = FileUtils.getAvailableInnernalMemorySize();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("extractPluginAndGetMd5Code failed installPath = ");
      localStringBuilder.append(localFile);
      localStringBuilder.append(", leftSpace = ");
      localStringBuilder.append(f);
      QLog.e("plugin_tag", 1, localStringBuilder.toString(), localException);
    }
    if (!TextUtils.isEmpty(localObject1)) {
      try
      {
        Object localObject2 = PluginUtils.getPluginLibPath(localBaseApplicationImpl, paramString1).getCanonicalPath();
        localObject2 = PluginUtils.extractLibs(localFile.getCanonicalPath(), (String)localObject2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("extract");
        localStringBuilder.append((String)localObject2);
        QLog.d("plugin_tag.InstallPlugins", 1, localStringBuilder.toString());
        if ((TextUtils.isEmpty((CharSequence)localObject2)) && (PluginInstaller.a(paramString1, localFile.getAbsolutePath())))
        {
          localObject2 = PluginStatic.getOrCreateClassLoaderAsModule(localBaseApplicationImpl, paramString1, false);
          try
          {
            localObject2 = ((ClassLoader)localObject2).loadClass(paramString2);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("cls ");
            localStringBuilder.append(paramString2);
            QLog.d("plugin_tag.InstallPlugins", 1, localStringBuilder.toString());
            if (localObject2 != null)
            {
              paramString2 = new PluginInfo();
              paramString2.mID = paramString1;
              paramString2.mMD5 = localObject1;
              paramString2.mUpdateType = 1;
              paramString2.mInstallType = 0;
              paramString2.mState = 4;
              paramString2.mLength = localFile.length();
              paramString2.mInstalledPath = localFile.getAbsolutePath();
              paramString2.mFingerPrint = PluginInstaller.c();
              PluginInfoUtil.a(paramString2, PluginUtils.getPluginInstallDir(localBaseApplicationImpl));
              QLog.d("plugin_tag.InstallPlugins", 1, "succ");
              return true;
            }
          }
          catch (Exception paramString2)
          {
            QLog.i("plugin_tag.InstallPlugins", 1, "", paramString2);
            PluginStatic.removeClassLoader(paramString1);
          }
        }
        b(paramString1);
      }
      catch (Exception paramString2)
      {
        QLog.e("plugin_tag.InstallPlugins", 1, "", paramString2);
      }
    }
    paramString2 = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_INSTALL_FAILED");
    paramString2.setPackage(MobileQQ.getContext().getPackageName());
    paramString2.putExtra("process", BaseApplicationImpl.processName);
    paramString2.putExtra("plugin", paramString1);
    localBaseApplicationImpl.sendBroadcast(paramString2);
    QLog.d("plugin_tag.InstallPlugins", 1, "failed");
    return false;
  }
  
  private static void b(String paramString)
  {
    try
    {
      File localFile1 = PluginUtils.getPluginInstallDir(BaseApplicationImpl.sApplication);
      File localFile2 = new File(localFile1, paramString);
      if (localFile2.exists()) {
        localFile2.delete();
      }
      PluginInfoUtil.a(paramString, localFile1);
    }
    catch (Exception paramString)
    {
      QLog.e("plugin_tag.InstallPlugins", 1, "", paramString);
    }
    QLog.d("plugin_tag.InstallPlugins", 1, "uninstallPlugin");
  }
  
  protected boolean doStep()
  {
    long l = System.currentTimeMillis();
    QLog.i("plugin_tag.InstallPlugins", 1, " install");
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getMobileQQ().peekAppRuntime();
    Object localObject3;
    if (localObject1 != null)
    {
      QLog.i("plugin_tag.InstallPlugins", 1, "preinstall by pluginmanger");
      localObject1 = (IPluginManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_PLUGIN);
      localObject3 = a;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        ((IPluginManager)localObject1).installPlugin(localObject3[i], null);
        i += 1;
      }
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    else
    {
      try
      {
        Object localObject2 = ((ActivityManager)BaseApplicationImpl.sApplication.getSystemService("activity")).getRunningAppProcesses();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
            if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith(":qzone"))
            {
              Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject3).pid);
              QLog.d("plugin_tag.InstallPlugins", 1, "kill qzone");
            }
            else if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith(":tool"))
            {
              Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject3).pid);
              QLog.d("plugin_tag.InstallPlugins", 1, "kill tool");
            }
          }
        }
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable)
      {
        QLog.d("plugin_tag.InstallPlugins", 1, "", localThrowable);
        QLog.i("plugin_tag.InstallPlugins", 1, "qzone");
        c = new InstallPlugins.QzoneInstallResult();
        c.a = a("qzone_plugin.apk", "com.qzone.Foo");
        c.b = (System.currentTimeMillis() - l);
        QLog.i("plugin_tag.InstallPlugins", 1, "qwallet");
        a("qwallet_plugin.apk", "com.qwallet.utils.Foo");
      }
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append(" install");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.d("plugin_tag.InstallPlugins", 1, localStringBuilder.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InstallPlugins
 * JD-Core Version:    0.7.0.1
 */