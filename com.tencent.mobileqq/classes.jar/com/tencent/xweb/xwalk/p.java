package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.a;
import com.tencent.xweb.ad;
import com.tencent.xweb.internal.b;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import com.tencent.xweb.v;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.e;
import com.tencent.xweb.xwalk.updater.g;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.FileListMD5Checker;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public class p
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  static p b;
  XWalkInitializer c;
  XWalkUpdater d;
  protected Context e;
  
  public p(Context paramContext)
  {
    this.e = paramContext;
    this.c = new XWalkInitializer(this, paramContext);
    this.d = new XWalkUpdater(this, paramContext);
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    int i1 = -1;
    if ((paramContext != null) && (paramContext.getApplicationInfo() != null) && (paramContext.getApplicationInfo().dataDir != null))
    {
      paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
      if (paramContext == null)
      {
        XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed files is null");
        return -1;
      }
      int i4 = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
      int i5 = paramContext.length;
      int i2 = 0;
      int k = 0;
      int i = -1;
      int n;
      for (int j = 0; k < i5; j = n)
      {
        int i3 = a(paramContext[k]);
        int m;
        if (i3 < 0)
        {
          m = i;
          n = j;
        }
        else
        {
          if (i3 == paramInt) {
            j = 1;
          }
          m = i;
          n = j;
          if (i3 <= paramInt)
          {
            m = i;
            n = j;
            if (i3 >= 49) {
              if (i3 == i4)
              {
                m = i;
                n = j;
              }
              else
              {
                m = i;
                n = j;
                if (i3 > i)
                {
                  m = i3;
                  n = j;
                }
              }
            }
          }
        }
        k += 1;
        i = m;
      }
      k = i2;
      if (i > 0) {
        k = 1;
      }
      if (j != 0)
      {
        if (b(paramInt))
        {
          XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
          i = paramInt;
        }
        else if (!b(i))
        {
          XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
          i = i1;
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("revertToApkVer did not find target version:");
        paramContext.append(paramInt);
        XWalkEnvironment.addXWalkInitializeLog(paramContext.toString());
        if (!b(i))
        {
          XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
          i = i1;
        }
      }
      if (i == paramInt) {
        h.a(89L, 1);
      } else if (i > 0) {
        h.a(90L, 1);
      } else if (k != 0) {
        h.a(92L, 1);
      } else {
        h.a(91L, 1);
      }
      paramContext = new StringBuilder();
      paramContext.append("revert from:");
      paramContext.append(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
      paramContext.append(" to:");
      paramContext.append(i);
      XWalkEnvironment.addXWalkInitializeLog(paramContext.toString());
      paramContext = new StringBuilder();
      paramContext.append("revert from:");
      paramContext.append(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
      paramContext.append(" to:");
      paramContext.append(i);
      XWalkEnvironment.setAvailableVersion(i, paramContext.toString(), XWalkEnvironment.getRuntimeAbi());
      return i;
    }
    XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed: bad context");
    return -1;
  }
  
  static int a(File paramFile)
  {
    if (paramFile == null) {
      return -1;
    }
    Object localObject = paramFile.getName();
    if ((localObject != null) && (((String)localObject).startsWith("app_xwalk_")) && (paramFile.isDirectory())) {
      paramFile = ((String)localObject).substring(10);
    }
    try
    {
      int i = Integer.parseInt(paramFile);
      return i;
    }
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get apk version strApkVer  is ");
    ((StringBuilder)localObject).append(paramFile);
    Log.e("XWalkUpdaterImp", ((StringBuilder)localObject).toString());
    return -1;
  }
  
  public static void a()
  {
    if (!com.tencent.xweb.internal.c.a("should_try_generate_jar", 172800000L)) {
      return;
    }
    XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), false);
  }
  
  public static void a(Context paramContext)
  {
    Log.i("XWalkUpdaterImp", "try clear test setings");
    if (com.tencent.xweb.internal.c.a("clear_test_settings", 2592000000L))
    {
      Log.i("XWalkUpdaterImp", "do start clear test setings");
      try
      {
        v.a().a("tools", WebView.c.a);
        v.a().a("appbrand", WebView.c.a);
        v.a().a("support", WebView.c.a);
        v.a().a("mm", WebView.c.a);
        v.a().a("toolsmp", WebView.c.a);
        v.a().b("tools", WebView.c.a);
        v.a().b("appbrand", WebView.c.a);
        v.a().b("support", WebView.c.a);
        v.a().b("mm", WebView.c.a);
        v.a().b("toolsmp", WebView.c.a);
        XWalkEnvironment.setTestDownLoadUrl(paramContext, null);
        XWalkEnvironment.setPluginTestConfigUrl("");
        return;
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("do start clear test setings got exp = ");
        localStringBuilder.append(paramContext.getMessage());
        Log.e("XWalkUpdaterImp", localStringBuilder.toString());
      }
    }
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (b == null) {
      b = new p(paramContext);
    }
    h.d();
    String str = null;
    if (paramHashMap != null) {
      str = (String)paramHashMap.get("UpdaterCheckType");
    }
    if ("4".equals(str))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "check emebedinstall only");
      XWalkUpdater.tryInstallFromEmebed();
      return;
    }
    XWalkUpdater.tryInstallFromEmebed();
    b.a(paramHashMap);
    e.a(paramContext);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null) {
      return;
    }
    long l1 = localSharedPreferences.getLong("LAST_TRY_CLEAR_APK_TIME", 0L);
    long l2 = System.currentTimeMillis();
    if ((paramBoolean) || (l2 < l1) || (l2 - l1 > 259200000L))
    {
      try
      {
        b(paramContext);
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryClearOldXWebCore failed ");
        localStringBuilder.append(paramContext.getMessage());
        Log.e("XWalkUpdaterImp", localStringBuilder.toString());
      }
      localSharedPreferences.edit().putLong("LAST_TRY_CLEAR_APK_TIME", l2).commit();
    }
  }
  
  static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.isDirectory()) {
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramString[i];
      if (localFile != null)
      {
        StringBuilder localStringBuilder;
        if ("oat".equalsIgnoreCase(localFile.getName()))
        {
          com.tencent.xweb.util.c.a(localFile);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeOptDexRecursively remove oat dir ");
          localStringBuilder.append(localFile.getAbsolutePath());
          Log.i("XWalkUpdaterImp", localStringBuilder.toString());
        }
        else if (localFile.getName().endsWith(".odex"))
        {
          com.tencent.xweb.util.c.a(localFile);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeOptDexRecursively remove odex file ");
          localStringBuilder.append(localFile.getAbsolutePath());
          Log.i("XWalkUpdaterImp", localStringBuilder.toString());
        }
        else if (localFile.getName().endsWith(".vdex"))
        {
          com.tencent.xweb.util.c.a(localFile);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeOptDexRecursively remove vdex file ");
          localStringBuilder.append(localFile.getAbsolutePath());
          Log.i("XWalkUpdaterImp", localStringBuilder.toString());
        }
        else if (localFile.isDirectory())
        {
          a(localFile.getAbsolutePath());
        }
      }
      i += 1;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.xweb.update");
    localIntent.putExtra("stage", paramString);
    localIntent.putExtra("extra_data", paramInt);
    XWalkEnvironment.getApplicationContext().sendBroadcast(localIntent);
  }
  
  static void a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryAbandonThisVersion scene  is ");
    localStringBuilder.append(paramString);
    Log.i("XWalkUpdaterImp", localStringBuilder.toString());
    long l1 = b.a(paramString, WebView.c.b).c();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("enable_reinstall_for_crash_at_");
    localStringBuilder.append(paramString);
    if (!"true".equalsIgnoreCase(a.a(localStringBuilder.toString(), "tools"))) {
      return;
    }
    if (l1 >= 15L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("LAST_");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_ABANDON_COUNT");
      paramString = localStringBuilder.toString();
      long l2 = XWalkEnvironment.getSharedPreferencesForXWEBUpdater().getLong(paramString, 100000L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryAbandonThisVersion try count = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(",  last abandon count = ");
      localStringBuilder.append(l2);
      Log.i("XWalkUpdaterImp", localStringBuilder.toString());
      if (l1 < l2)
      {
        Log.i("XWalkUpdaterImp", "tryAbandonThisVersion should abandon this version ");
        try
        {
          a(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
          XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
          XWalkEnvironment.getSharedPreferencesForXWEBUpdater().edit().putLong(paramString, l1).commit();
          h.a(paramInt1, 1);
          return;
        }
        catch (Exception paramString)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("clear version failed , errmsg:");
          localStringBuilder.append(paramString.getMessage());
          Log.e("XWalkUpdaterImp", localStringBuilder.toString());
          return;
        }
      }
      if (l1 - 2L > l2)
      {
        Log.i("XWalkUpdaterImp", "tryAbandonThisVersion cant not fix ");
        h.a(paramInt2, 1);
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    int i = XWalkEnvironment.getAvailableVersion();
    if (i <= 0) {
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null) {
      return;
    }
    if ((!paramBoolean) && (!com.tencent.xweb.internal.c.a("CHECK_FILES_MD5_TIME_KEY", 7200000L))) {
      return;
    }
    Log.i("XWalkUpdaterImp", "checkFiles start check resfiles");
    String str = XWalkEnvironment.getExtractedCoreDir(i);
    boolean bool = XWalkUpdater.checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(i), str, i);
    int j;
    if (!bool)
    {
      j = localSharedPreferences.getInt("LAST_CHECK_RES_VERSION", -1);
      localSharedPreferences.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
      if (j != i)
      {
        h.a(77L, 1);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted at first time");
      }
      else
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted");
      }
      h.a(76L, 1);
    }
    Log.i("XWalkUpdaterImp", "checkFiles start check installed files");
    paramBoolean = c(i);
    if (!paramBoolean)
    {
      j = localSharedPreferences.getInt("LAST_CHECK_VERSION", -1);
      localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", -1).commit();
      if (j != i)
      {
        h.a(64L, 1);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted at first time");
      }
      else
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted");
      }
      h.a(63L, 1);
    }
    if (!"true".equalsIgnoreCase(a.a("disable_res_check", "tools"))) {
      paramBoolean &= bool;
    } else {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "ignore res files check");
    }
    if (!paramBoolean)
    {
      XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
      return;
    }
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", i).commit();
    Log.i("XWalkUpdaterImp", "checkfiles parse");
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearVersion start , nVersion = ");
    ((StringBuilder)localObject).append(paramInt);
    Log.i("XWalkUpdaterImp", ((StringBuilder)localObject).toString());
    if (paramInt <= 0)
    {
      Log.e("XWalkUpdaterImp", "clearVersion failed , nVersion is not valid ");
      return false;
    }
    localObject = XWalkEnvironment.getApplicationContext();
    if ((localObject != null) && (((Context)localObject).getApplicationInfo() != null) && (((Context)localObject).getApplicationInfo().dataDir != null))
    {
      localObject = new File(((Context)localObject).getApplicationInfo().dataDir).listFiles();
      if (localObject == null)
      {
        Log.e("XWalkUpdaterImp", "clearVersion failed , null == files ");
        return false;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        File localFile = localObject[i];
        int k = a(localFile);
        if ((k > 0) && (k == paramInt) && (com.tencent.xweb.util.c.b(localFile.getAbsolutePath())))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cleared version = ");
          ((StringBuilder)localObject).append(k);
          XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", ((StringBuilder)localObject).toString());
          return true;
        }
        i += 1;
      }
      return false;
    }
    Log.e("XWalkUpdaterImp", "clearVersion failed , context = null");
    return false;
  }
  
  static void b()
  {
    a("LOAD_CORE", 243, 244);
    a("CREATE_WEBVIEW", 245, 246);
  }
  
  private static void b(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationInfo() != null) && (paramContext.getApplicationInfo().dataDir != null))
    {
      paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
      if (paramContext == null)
      {
        Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , null == files ");
        return;
      }
      Object localObject2 = a.a("KEEP_XWEB_CORE_LIST", "tools");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dump KEEP_XWEB_CORE_LIST: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      Log.i("XWalkUpdaterImp", ((StringBuilder)localObject1).toString());
      localObject1 = new HashSet();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      int i2 = 0;
      Object localObject3;
      if (!bool)
      {
        localObject2 = ((String)localObject2).split(";");
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            localObject3 = localObject2[i];
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(((String)localObject3).trim()))) {
              ((HashSet)localObject1).add(((String)localObject3).trim());
            }
            i += 1;
          }
        }
      }
      int i3 = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
      int i4 = paramContext.length;
      int m = 0;
      int i = 0;
      int i1;
      for (int k = 0; m < i4; k = j)
      {
        i1 = a(paramContext[m]);
        if (i1 < 0)
        {
          n = i;
          j = k;
        }
        else if (i1 == i3)
        {
          n = i;
          j = k;
        }
        else if (i1 >= i)
        {
          n = i1;
          j = i;
        }
        else
        {
          n = i;
          j = k;
          if (i1 >= k)
          {
            j = i1;
            n = i;
          }
        }
        m += 1;
        i = n;
      }
      int j = XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a");
      m = XWalkEnvironment.getInstalledNewstVersion("arm64-v8a");
      int n = paramContext.length;
      i = i2;
      while (i < n)
      {
        localObject2 = paramContext[i];
        i1 = a((File)localObject2);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(i1);
        if ((!((HashSet)localObject1).contains(((StringBuilder)localObject3).toString())) && (i1 > 0) && (i1 < k) && (i1 != XWalkEnvironment.getAvailableVersion()) && (i1 != j) && (i1 != m)) {
          try
          {
            com.tencent.xweb.util.c.b(((File)localObject2).getAbsolutePath());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("cleared version = ");
            ((StringBuilder)localObject2).append(i1);
            XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", ((StringBuilder)localObject2).toString());
            h.a(577L, 65L, 1L);
          }
          catch (Exception localException)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(" FileUtils.deleteAll failed ");
            ((StringBuilder)localObject3).append(localException.getMessage());
            XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", ((StringBuilder)localObject3).toString());
            h.a(577L, 66L, 1L);
          }
        }
        i += 1;
      }
      return;
    }
    Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , context");
  }
  
  static boolean b(int paramInt)
  {
    File localFile = d(paramInt);
    if (localFile == null)
    {
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      return false;
    }
    return XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramInt, localFile);
  }
  
  static boolean c()
  {
    int i;
    if (b.a("LOAD_CORE", WebView.c.b).c() >= 6L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      h.a(252L, 1);
      if ("true".equalsIgnoreCase(a.a("enable_check_dex", "tools"))) {
        return true;
      }
    }
    if (b.a("CREATE_WEBVIEW", WebView.c.b).c() >= 6L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      h.a(247L, 1);
      if ("true".equalsIgnoreCase(a.a("enable_check_dex_new_web", "tools"))) {
        return true;
      }
    }
    return false;
  }
  
  static boolean c(int paramInt)
  {
    File localFile = d(paramInt);
    if (localFile == null)
    {
      if (XWalkEnvironment.isTestVersion(paramInt)) {
        return true;
      }
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      h.a(78L, 1);
      if ("true".equalsIgnoreCase(a.a("dis_config_file_check", "tools")))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "dis_config_file_check ");
        return true;
      }
      return false;
    }
    return XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramInt, localFile);
  }
  
  static File d(int paramInt)
  {
    try
    {
      File localFile = new File(XWalkEnvironment.getPatchFileListConfig(paramInt));
      if (localFile.exists()) {
        return localFile;
      }
      localFile = new File(XWalkEnvironment.getDownloadZipFileListConfig(paramInt));
      boolean bool = localFile.exists();
      if (bool) {
        return localFile;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void d()
  {
    if (!c()) {
      return;
    }
    if (!com.tencent.xweb.internal.c.a("check_need_fix_dex", 43200000L)) {
      return;
    }
    b();
    if (!f())
    {
      h.a(248L, 1);
      a(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
      XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
    }
  }
  
  public static boolean e()
  {
    XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), true);
    if (!a.a().a("DIS_REMOVE_ODEX_IN_DEX_CRRUPTION", "tools", false)) {
      a(XWalkEnvironment.getVesionDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
    }
    if (com.tencent.xweb.util.c.b(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi())))
    {
      XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
      return true;
    }
    XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
    return false;
  }
  
  public static boolean f()
  {
    int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    boolean bool = false;
    if (i <= 0)
    {
      Log.i("XWalkUpdaterImp", "doFixDex stopped , because no xweb currently");
      return false;
    }
    Log.i("XWalkUpdaterImp", "doFixDex start");
    Object localObject1 = d(i);
    if (localObject1 == null)
    {
      Log.e("XWalkUpdaterImp", "doFixDex checkfiles no config file");
      return false;
    }
    if (!XWalkUpdater.FileListMD5Checker.checkFileListMd5(i, (File)localObject1))
    {
      Log.e("XWalkUpdaterImp", "doFixDex checkFileListMd5 failed");
      return false;
    }
    Object localObject2 = XWalkEnvironment.getExtractedCoreDir(i);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(XWalkEnvironment.getExtractedCoreDir(i));
    ((StringBuilder)localObject1).append("_bk");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new File((String)localObject1);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdirs();
    }
    if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(i), (String)localObject1, XWalkUpdater.getResFileList(i))) {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex extract faield");
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("classes.dex");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("classes.dex");
    String str = ((StringBuilder)localObject2).toString();
    localObject2 = d.a((String)localObject3);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    if ((((String)localObject1).equalsIgnoreCase(d.a(str)) ^ true))
    {
      h.a(253L, 1);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
      if (com.tencent.xweb.util.c.b((String)localObject3))
      {
        if (com.tencent.xweb.util.c.a(str, (String)localObject3))
        {
          XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
          bool = true;
        }
        else
        {
          h.a(249L, 1);
          XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
        }
      }
      else
      {
        h.a(250L, 1);
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
      }
      e();
      return bool;
    }
    if (e())
    {
      h.a(254L, 1);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
    h.a(255L, 1);
    return false;
  }
  
  public boolean a(HashMap<String, String> paramHashMap)
  {
    new g(this.d, paramHashMap).execute(new String[0]);
    return false;
  }
  
  public void onXWalkInitCancelled() {}
  
  public void onXWalkInitCompleted() {}
  
  public void onXWalkInitFailed() {}
  
  public void onXWalkInitStarted() {}
  
  public void onXWalkUpdateCancelled()
  {
    a("finished", -2);
    g.c();
    c localc = ad.a();
    if (localc != null) {
      localc.b(1);
    }
  }
  
  public void onXWalkUpdateCompleted(Scheduler paramScheduler)
  {
    a("finished", 0);
    g.a(paramScheduler);
    paramScheduler = ad.a();
    if (paramScheduler != null) {
      paramScheduler.d();
    }
  }
  
  public void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler)
  {
    a("finished", -1);
    g.a(paramInt, paramScheduler);
    paramScheduler = ad.a();
    if (paramScheduler != null) {
      paramScheduler.b(3);
    }
  }
  
  public void onXWalkUpdateProgress(int paramInt)
  {
    a("updating", paramInt);
    c localc = ad.a();
    if (localc != null) {
      localc.a(paramInt);
    }
  }
  
  public void onXWalkUpdateStarted()
  {
    a("start", 0);
    g.b();
    c localc = ad.a();
    if (localc != null) {
      localc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.p
 * JD-Core Version:    0.7.0.1
 */