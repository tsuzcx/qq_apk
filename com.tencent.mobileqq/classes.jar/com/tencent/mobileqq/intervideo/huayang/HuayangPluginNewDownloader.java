package com.tencent.mobileqq.intervideo.huayang;

import aecs;
import aect;
import aecu;
import aecv;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import com.tencent.hydevteam.pluginframework.pluginmanager.MultiTargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.TargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckException;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HuayangPluginNewDownloader
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aecv jdField_a_of_type_Aecv;
  private final Context jdField_a_of_type_AndroidContentContext;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aecs(this);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final UpgradeablePluginManager jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aecu(this);
  public String a;
  private volatile List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private final boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String d;
  
  private HuayangPluginNewDownloader(Context paramContext, File paramFile, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager = new UpgradeablePluginManager(paramFile, paramString);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Boolean = new File(Environment.getExternalStorageDirectory(), "versionchecker.test").exists();
  }
  
  private InstalledPlugin a(ProgressFuture paramProgressFuture, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 4, paramProgressFuture));
    }
    if ((paramBoolean) && (Monitor.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, 30, 0), 2000L);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, 70, 0), 6000L);
    }
    try
    {
      paramProgressFuture = (InstalledPlugin)paramProgressFuture.get();
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      }
      return paramProgressFuture;
    }
    catch (Exception paramProgressFuture)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      }
      throw paramProgressFuture;
    }
  }
  
  private InstalledPlugin a(boolean paramBoolean)
  {
    a("HuayangPluginNewDownloader", "getPluginFromServer: 开始从服务器中获取DownloadedPluginInfo开始...");
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.upgradeIfNeededThenInit(10L, TimeUnit.SECONDS);
    l = System.currentTimeMillis() - l;
    a("HuayangPluginNewDownloader", "upgradeIfNeededThenInit status:" + i + " time:" + l);
    VersionChecker localVersionChecker;
    Object localObject1;
    StringBuilder localStringBuilder;
    label144:
    String str;
    Object localObject2;
    if (i != -1)
    {
      a("downloadPluginManagerFinish", i, (int)l, "", "");
      if (i == 1) {
        Monitor.a("2653797");
      }
    }
    else
    {
      localVersionChecker = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.getVersionChecker();
      localObject1 = null;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "SOURCE_CGI";
      arrayOfString[1] = "SOURCE_BACKUP_STABLE";
      localStringBuilder = new StringBuilder();
      int j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label1064;
      }
      str = arrayOfString[i];
      localObject2 = localObject1;
    }
    for (;;)
    {
      try
      {
        TargetDownloadInfo localTargetDownloadInfo = localVersionChecker.check(str, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Boolean);
        localObject2 = localObject1;
        if (str.equals("SOURCE_CGI"))
        {
          localObject2 = localObject1;
          Monitor.a("2653754");
          localObject2 = localObject1;
          a("HuayangPluginNewDownloader", "成功获取 TargetDownloadInfo:" + localTargetDownloadInfo.url);
          if (localTargetDownloadInfo == null) {
            break label1067;
          }
          localObject2 = localObject1;
          l = localTargetDownloadInfo.size;
          localObject2 = localObject1;
          this.jdField_b_of_type_Long = l;
          localObject2 = localObject1;
          if (!(localTargetDownloadInfo instanceof MultiTargetDownloadInfo)) {
            continue;
          }
          localObject2 = localObject1;
          localObject3 = ((MultiTargetDownloadInfo)localTargetDownloadInfo).allSubTargets;
          if (localObject3 == null) {
            continue;
          }
          localObject2 = localObject1;
          localObject3 = ((Map)localObject3).entrySet().iterator();
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject2 = localObject1;
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          localObject2 = localObject1;
          if (!TextUtils.equals((CharSequence)localEntry.getKey(), this.jdField_b_of_type_JavaLangString)) {
            continue;
          }
          localObject2 = localObject1;
          this.jdField_b_of_type_Long = ((TargetDownloadInfo)localEntry.getValue()).size;
          continue;
        }
      }
      catch (Exception localException1)
      {
        localObject1 = localObject2;
        localObject2 = localException1;
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, "从" + str + "获取插件失败。", (Throwable)localObject2);
        }
        HuayangCrashReport.a((Throwable)localObject2);
        localStringBuilder.append(((Exception)localObject2).toString());
        localStringBuilder.append("。");
        if ((str.equals("SOURCE_CGI")) && (this.jdField_b_of_type_Boolean))
        {
          localObject2 = new StringBuilder().append("getPluginFromServer: 开始从服务器中获取InstalledPlugin结束：result == null ? ");
          if (localObject1 != null) {
            continue;
          }
          paramBoolean = true;
          a("HuayangPluginNewDownloader", paramBoolean);
          Monitor.a("2653760");
          if (this.jdField_b_of_type_Boolean) {
            Monitor.a("2528856");
          }
          throw new VersionCheckException("从服务器获取InstalledPlugin失败。" + localStringBuilder.toString());
          Monitor.a("2653798");
          break;
          localObject2 = localObject1;
          if (!str.equals("SOURCE_BACKUP_STABLE")) {
            continue;
          }
          localObject2 = localObject1;
          Monitor.a("2653758");
          continue;
        }
      }
      catch (VersionCheckException localVersionCheckException)
      {
        localObject2 = localObject1;
        if (str.equals("SOURCE_CGI"))
        {
          localObject2 = localObject1;
          Monitor.a("2653755");
          localObject2 = localObject1;
          throw localVersionCheckException;
        }
        localObject2 = localObject1;
        if (!str.equals("SOURCE_BACKUP_STABLE")) {
          continue;
        }
        localObject2 = localObject1;
        Monitor.a("2653759");
        continue;
        localObject2 = localObject1;
        Object localObject3 = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, Long.valueOf(this.jdField_b_of_type_Long));
        localObject2 = localObject1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
        localObject2 = localObject1;
        if ("checkVersion".equals(this.jdField_c_of_type_JavaLangString)) {
          return null;
        }
        if (paramBoolean)
        {
          localObject2 = localObject1;
          a(10);
        }
        localObject2 = localObject1;
        a("HuayangPluginNewDownloader", "updatePlugin start");
        localObject2 = localObject1;
        l = System.currentTimeMillis();
        localObject2 = localObject1;
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.updatePlugin(this.d, localVersionCheckException, this.jdField_b_of_type_JavaLangString);
        try
        {
          localObject2 = a((ProgressFuture)this.jdField_a_of_type_JavaUtilList.get(0), paramBoolean);
          try
          {
            a("HuayangPluginNewDownloader", "updatePlugin end 耗时:" + (System.currentTimeMillis() - l));
            if (str.equals("SOURCE_CGI"))
            {
              Monitor.a("2653761");
              try
              {
                localObject1 = new StringBuilder().append("getPluginFromServer: 开始从服务器中获取InstalledPlugin结束：result == null ? ");
                if (localObject2 != null) {
                  continue;
                }
                bool = true;
                a("HuayangPluginNewDownloader", bool);
                return localObject2;
              }
              catch (Exception localException2)
              {
                localObject1 = localObject2;
                localObject2 = localException2;
              }
              continue;
            }
            if (!str.equals("SOURCE_BACKUP_STABLE")) {
              continue;
            }
            Monitor.a("2653765");
            continue;
            localObject2 = localObject1;
          }
          catch (Exception localException3)
          {
            localObject1 = localObject2;
          }
        }
        catch (Exception localException4)
        {
          boolean bool;
          continue;
        }
        if (str.equals("SOURCE_CGI"))
        {
          localObject2 = localObject1;
          Monitor.a("2653762");
          localObject2 = localObject1;
          throw localException3;
        }
        localObject2 = localObject1;
        if (!str.equals("SOURCE_BACKUP_STABLE")) {
          continue;
        }
        localObject2 = localObject1;
        Monitor.a("2653766");
        continue;
        bool = false;
        continue;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ((ProgressFuture)((Iterator)localObject2).next()).cancel(true);
            continue;
          }
          this.jdField_a_of_type_JavaUtilList = null;
        }
        i += 1;
        break label144;
        paramBoolean = false;
        continue;
      }
      label1064:
      continue;
      label1067:
      l = 0L;
    }
  }
  
  public static HuayangPluginNewDownloader a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = paramString2 + paramString1;
      HuayangPluginNewDownloader localHuayangPluginNewDownloader = (HuayangPluginNewDownloader)jdField_a_of_type_JavaUtilHashMap.get(str);
      paramString1 = localHuayangPluginNewDownloader;
      if (localHuayangPluginNewDownloader == null)
      {
        paramString1 = new HuayangPluginNewDownloader(paramContext.getApplicationContext(), a(paramContext), paramString2);
        jdField_a_of_type_JavaUtilHashMap.put(str, paramString1);
      }
      return paramString1;
    }
    finally {}
  }
  
  public static File a(Context paramContext)
  {
    return paramContext.getFilesDir();
  }
  
  private void a(int paramInt)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(int paramInt, Object paramObject)
  {
    paramObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramInt, paramObject);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
  }
  
  private void a(InstalledPlugin paramInstalledPlugin)
  {
    String str2 = null;
    long l = System.currentTimeMillis();
    boolean bool = TextUtils.equals(this.d, "group_video");
    try
    {
      this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.preloadApk(this.jdField_a_of_type_AndroidContentContext, paramInstalledPlugin, bool).get();
      a("HuayangPluginNewDownloader", "预加载成功。");
      str1 = str2;
      if (!this.jdField_b_of_type_Boolean)
      {
        b(paramInstalledPlugin, true);
        str1 = str2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, "预加载过程中出错：", localException);
        }
        if (!this.jdField_b_of_type_Boolean) {
          a(6, localException.toString());
        }
        HuayangCrashReport.a(localException);
        continue;
        paramInstalledPlugin = "";
      }
    }
    i = (int)(System.currentTimeMillis() - l);
    str2 = paramInstalledPlugin.toString();
    if (str1 != null)
    {
      paramInstalledPlugin = str1.getMessage();
      a("preLoadFinish", 0, i, str2, paramInstalledPlugin);
      return;
    }
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, Exception paramException, int paramInt)
  {
    if (paramInstalledPlugin != null)
    {
      a("preDownloadFinish", 1, paramInt, paramInstalledPlugin.toString(), null);
      return;
    }
    if (paramException != null) {}
    for (paramInstalledPlugin = paramException.getMessage();; paramInstalledPlugin = "")
    {
      a("preDownloadFinish", 0, paramInt, paramInstalledPlugin, null);
      return;
    }
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("通知下载完成: installedPlugin == null ? ");
    boolean bool;
    if (paramInstalledPlugin == null)
    {
      bool = true;
      a("HuayangPluginNewDownloader", bool);
      a(this.jdField_b_of_type_Boolean);
      a(2, paramInstalledPlugin);
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (localObject = "fromCache";; localObject = "fromServer")
    {
      a(true, paramInstalledPlugin, (String)localObject, null);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      return;
      bool = false;
      break;
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (Monitor.jdField_a_of_type_Boolean) {}
    for (String str = "huayang";; str = "group_video")
    {
      StoryReportor.a(str, paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, this.d + "_" + this.jdField_b_of_type_JavaLangString, "7.6.8" });
      return;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent(HuayangJsPlugin.c(this.jdField_b_of_type_JavaLangString));
    int i;
    if (paramBoolean)
    {
      i = 1;
      localIntent.putExtra("key_isCache", i);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      if (!paramBoolean)
      {
        if (!HuayangJsPlugin.a(this.jdField_b_of_type_JavaLangString)) {
          break label64;
        }
        Monitor.a("2714209");
      }
    }
    label64:
    while (!HuayangJsPlugin.b(this.jdField_b_of_type_JavaLangString))
    {
      return;
      i = 0;
      break;
    }
    Monitor.a("2714208");
  }
  
  private void a(boolean paramBoolean, InstalledPlugin paramInstalledPlugin, String paramString1, String paramString2)
  {
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (paramInstalledPlugin != null) {
        break label45;
      }
    }
    label45:
    for (paramInstalledPlugin = null;; paramInstalledPlugin = paramInstalledPlugin.toString())
    {
      a("downloadFinish", i, j, paramInstalledPlugin, paramString2);
      return;
      i = 0;
      break;
    }
  }
  
  private void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.getCachedLatestPlugin(this.d);
    if ((localObject1 != null) && (((List)localObject1).size() == 1) && (((InstalledPlugin)((List)localObject1).get(0)).pluginFileType == 0))
    {
      localObject1 = (InstalledPlugin)((List)localObject1).get(0);
      this.jdField_b_of_type_Boolean = true;
      a((InstalledPlugin)localObject1, true);
      b((InstalledPlugin)localObject1, true);
      if (this.jdField_b_of_type_Boolean) {
        break label290;
      }
    }
    long l;
    label290:
    for (boolean bool1 = true;; bool1 = false)
    {
      l = 0L;
      if (!bool1) {
        l = System.currentTimeMillis();
      }
      if ((TextUtils.equals(this.jdField_c_of_type_JavaLangString, "slientDownload")) || (bool1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      }
      try
      {
        localObject2 = a(bool1);
        localObject1 = null;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HuayangPluginNewDownloader", 2, localException1, new Object[0]);
          }
          HuayangCrashReport.a(localException1);
          localObject2 = null;
        }
      }
      if (!"checkVersion".equals(this.jdField_c_of_type_JavaLangString)) {
        break label326;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (InstalledPlugin)((Iterator)localObject1).next();
          if (((InstalledPlugin)localObject2).pluginPackageName.equals(this.jdField_b_of_type_JavaLangString))
          {
            this.jdField_b_of_type_Boolean = true;
            a((InstalledPlugin)localObject2, true);
            b((InstalledPlugin)localObject2, true);
          }
          else
          {
            b((InstalledPlugin)localObject2, false);
          }
        }
        break;
      }
      if (MonitorConfig.jdField_a_of_type_JavaUtilMap.get(this.d) == null) {
        break;
      }
      Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.jdField_a_of_type_JavaUtilMap.get(this.d)).g));
      break;
    }
    label326:
    if (bool1) {
      if (localException1 == null)
      {
        a(100);
        a((InstalledPlugin)localObject2, false);
        label348:
        if ((localObject2 == null) || (PluginRunningPath.isPreOdexFileExists(this.jdField_a_of_type_AndroidContentContext, ((InstalledPlugin)localObject2).pluginPackageName, ((InstalledPlugin)localObject2).pluginVersionForPluginLoaderManage, ((InstalledPlugin)localObject2).pluginFile.getName()))) {
          break label607;
        }
        a("HuayangPluginNewDownloader", "下载下来的版本没有预加载，进行预加载...");
        a((InstalledPlugin)localObject2);
      }
    }
    for (;;)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_c_of_type_Boolean = false;
      if (localList == null) {
        break;
      }
      int i = 1;
      while (i < localList.size())
      {
        try
        {
          localObject2 = (InstalledPlugin)((ProgressFuture)localList.get(i)).get();
          if (localObject2 == null) {}
        }
        catch (Exception localException2)
        {
          label607:
          localObject2 = null;
        }
        try
        {
          if (!PluginRunningPath.isPreOdexFileExists(this.jdField_a_of_type_AndroidContentContext, ((InstalledPlugin)localObject2).pluginPackageName, ((InstalledPlugin)localObject2).pluginVersionForPluginLoaderManage, ((InstalledPlugin)localObject2).pluginFile.getName()))
          {
            boolean bool2 = TextUtils.equals(this.d, "group_video");
            this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.preloadApk(this.jdField_a_of_type_AndroidContentContext, (InstalledPlugin)localObject2, bool2).get();
          }
          if ((localObject2 != null) && (bool1) && ((IVPluginInfo)this.jdField_a_of_type_JavaUtilMap.get(((InstalledPlugin)localObject2).pluginPackageName) != null))
          {
            Monitor.a("2633399");
            b((InstalledPlugin)localObject2, false);
          }
          i += 1;
        }
        catch (Exception localException3)
        {
          break label634;
        }
      }
      a(3, localException1.toString());
      a(false, null, null, localException1.toString());
      break label348;
      a((InstalledPlugin)localObject2, localException1, (int)(System.currentTimeMillis() - l));
      break label348;
      if ((localObject2 != null) && (!this.jdField_b_of_type_Boolean)) {
        b((InstalledPlugin)localObject2, true);
      }
    }
    label634:
    Monitor.a("2633400");
    if (localObject2 == null) {}
    for (Object localObject2 = null;; localObject2 = ((InstalledPlugin)localObject2).toString())
    {
      a("loadSecondPlugin", 0, 0, (String)localObject2, localException2.toString());
      break;
    }
  }
  
  private void b(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    a("HuayangPluginNewDownloader", "通知预下载完成: installedPlugin  " + paramInstalledPlugin);
    paramInstalledPlugin = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, paramInstalledPlugin);
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      paramInstalledPlugin.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramInstalledPlugin);
      return;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Monitor.a("2597859");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ProgressFuture)localIterator.next()).cancel(true);
      }
    }
  }
  
  public void a(aecv paramaecv)
  {
    this.jdField_a_of_type_Aecv = paramaecv;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Map paramMap)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.d = paramString1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 40000L);
    ThreadManager.postDownLoadTask(new aect(this), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader
 * JD-Core Version:    0.7.0.1
 */