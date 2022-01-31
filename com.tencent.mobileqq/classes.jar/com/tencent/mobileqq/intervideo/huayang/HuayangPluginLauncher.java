package com.tencent.mobileqq.intervideo.huayang;

import aecp;
import aecq;
import aecr;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.PluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.RunningPlugin;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HuayangPluginLauncher
{
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Context jdField_a_of_type_AndroidContentContext;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aecp(this);
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  private final InstalledPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin;
  private final PluginLoader jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginloaderPluginLoader = new DynamicPluginLoader();
  private RunningPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginloaderRunningPlugin;
  private IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  private String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList = new LinkedList();
  public volatile boolean a;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  private HuayangPluginLauncher(Context paramContext, InstalledPlugin paramInstalledPlugin)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin = paramInstalledPlugin;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  @NonNull
  private Intent a()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_JavaLangString != null) {
      localIntent.setData(Uri.parse(this.jdField_a_of_type_JavaLangString));
    }
    localIntent.putExtras(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.a);
    if (this.d) {}
    for (int i = 1;; i = 2)
    {
      localIntent.putExtra("PluginStartMode", i);
      localIntent.putExtra("isNeedTransparent", true);
      localIntent.putExtra("qqVersion", "7.6.8");
      return localIntent;
    }
  }
  
  private RunningPlugin a()
  {
    long l = System.currentTimeMillis();
    a("HuayangPluginLauncher", "开始加载插件...");
    try
    {
      ProgressFuture localProgressFuture = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginloaderPluginLoader.loadPlugin(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin);
      if (localProgressFuture == null)
      {
        a("HuayangPluginLauncher", "加载插件完成，耗时(ms)：" + (System.currentTimeMillis() - l));
        a(false, new Exception("loadFuture == null"));
        return null;
      }
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, "在加载插件并调用其Application的OnCreate方法过程中出错", localException1);
      }
      a(false, localException1);
      return null;
    }
    aecr localaecr = new aecr(this);
    this.jdField_a_of_type_AndroidOsHandler.post(localaecr);
    RunningPlugin localRunningPlugin;
    try
    {
      localRunningPlugin = (RunningPlugin)localException1.get(100L, TimeUnit.SECONDS);
      localThrowable = null;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Throwable localThrowable;
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginLauncher", 2, localException2, new Object[0]);
        }
        localRunningPlugin = null;
      }
      a(80);
      a("HuayangPluginLauncher", "加载插件" + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile + "完成，耗时(ms)：" + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localaecr);
    if (localThrowable != null)
    {
      a(false, localThrowable);
      return null;
    }
    return localRunningPlugin;
  }
  
  public static HuayangPluginLauncher a(Context paramContext, InstalledPlugin paramInstalledPlugin)
  {
    try
    {
      HuayangPluginLauncher localHuayangPluginLauncher2 = (HuayangPluginLauncher)jdField_a_of_type_JavaUtilMap.get(paramInstalledPlugin.pluginFile.getName());
      HuayangPluginLauncher localHuayangPluginLauncher1 = localHuayangPluginLauncher2;
      if (localHuayangPluginLauncher2 == null)
      {
        localHuayangPluginLauncher1 = new HuayangPluginLauncher(paramContext, paramInstalledPlugin);
        jdField_a_of_type_JavaUtilMap.put(paramInstalledPlugin.pluginFile.getName(), localHuayangPluginLauncher1);
      }
      return localHuayangPluginLauncher1;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_Int) {
      return;
    }
    a("HuayangPluginLauncher", "更新进度：" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(RunningPlugin paramRunningPlugin)
  {
    long l = System.currentTimeMillis();
    a("HuayangPluginLauncher", "开始启动插件..." + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile);
    paramRunningPlugin = paramRunningPlugin.startLauncherActivity(a());
    a(90);
    for (;;)
    {
      try
      {
        paramRunningPlugin.get();
        a(true, null);
        if (!HuayangJsPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_c_of_type_JavaLangString)) {
          continue;
        }
        Monitor.a("2691707");
        paramRunningPlugin = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit();
        paramRunningPlugin.putBoolean("huayang_plugin_start_flag" + this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_c_of_type_JavaLangString, true);
        paramRunningPlugin.commit();
        Monitor.a("2585917");
      }
      catch (Throwable paramRunningPlugin)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("HuayangPluginLauncher", 2, paramRunningPlugin, new Object[0]);
        a(false, paramRunningPlugin);
        continue;
      }
      a("HuayangPluginLauncher", "启动插件" + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile + "完成，耗时(ms)：" + (System.currentTimeMillis() - l));
      return;
      if (HuayangJsPlugin.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_c_of_type_JavaLangString)) {
        Monitor.a("2597725");
      }
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    if (Monitor.jdField_a_of_type_Boolean) {}
    for (String str = "huayang";; str = "group_video")
    {
      StoryReportor.a(str, paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, "7.6.8" });
      return;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!this.jdField_c_of_type_Boolean) {
        break label81;
      }
    }
    label81:
    for (String str = "1";; str = "0")
    {
      a("launchFinish", i, j, paramString, str, this.jdField_c_of_type_JavaLangString + "_" + this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_c_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, Throwable paramThrowable)
  {
    a(100);
    if ((!paramBoolean) && (!(paramThrowable instanceof TimeoutException)) && (!(paramThrowable instanceof InterruptedException)))
    {
      this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginloaderPluginLoader.setPluginDisabled(this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin);
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, "设置插件启动失败标志失败");
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    int i;
    if (paramBoolean)
    {
      i = 0;
      localObject = Message.obtain((Handler)localObject, 3, i, 0, paramThrowable);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if (!paramBoolean) {
        break label107;
      }
      a(paramBoolean, null);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      i = 1;
      break;
      label107:
      a(paramBoolean, paramThrowable.toString());
      HuayangCrashReport.a(paramThrowable);
    }
  }
  
  private void b(RunningPlugin paramRunningPlugin)
  {
    long l = System.currentTimeMillis();
    a("HuayangPluginLauncher", "初始化插件..." + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile);
    Intent localIntent = a();
    try
    {
      paramRunningPlugin.startInitActivity(localIntent).get();
      a("HuayangPluginLauncher", "初始化插件" + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile + "完成，耗时(ms)：" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Throwable paramRunningPlugin)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginLauncher", 2, paramRunningPlugin, new Object[0]);
        }
        HuayangCrashReport.a(paramRunningPlugin);
      }
    }
  }
  
  public void a(HuayangPluginLauncher.HuayangPluginLauncherListener paramHuayangPluginLauncherListener)
  {
    if (paramHuayangPluginLauncherListener != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramHuayangPluginLauncherListener);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, IVPluginInfo paramIVPluginInfo, String paramString2, String paramString3)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = paramIVPluginInfo;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = paramString1;
    ThreadManager.executeOnSubThread(new aecq(this, paramBoolean2));
  }
  
  public void b(HuayangPluginLauncher.HuayangPluginLauncherListener paramHuayangPluginLauncherListener)
  {
    if (paramHuayangPluginLauncherListener != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramHuayangPluginLauncherListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher
 * JD-Core Version:    0.7.0.1
 */