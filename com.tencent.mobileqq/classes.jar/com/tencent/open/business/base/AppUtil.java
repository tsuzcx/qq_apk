package com.tencent.open.business.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xmlpull.v1.XmlPullParserException;

public class AppUtil
{
  protected static Map a = new HashMap();
  
  public static int a()
  {
    int j = 1;
    Object localObject = new String[5];
    localObject[0] = "/system/xbin/";
    localObject[1] = "/system/bin/";
    localObject[2] = "/system/sbin/";
    localObject[3] = "/sbin/";
    localObject[4] = "/vendor/bin/";
    int i = 0;
    try
    {
      while (i < localObject.length)
      {
        String str = localObject[i] + "su";
        File localFile = new File(str);
        if ((localFile != null) && (localFile.exists()))
        {
          localObject = a(new String[] { "ls", "-l", str });
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            int k = ((String)localObject).indexOf("root");
            int m = ((String)localObject).lastIndexOf("root");
            i = j;
            if (k != m) {}
          }
          else
          {
            i = 0;
          }
          return i;
        }
        i += 1;
      }
      return 2;
    }
    catch (Exception localException) {}
  }
  
  public static int a(String paramString)
  {
    PackageManager localPackageManager = CommonDataAdapter.a().a().getPackageManager();
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if (paramString != null)
      {
        int i = paramString.versionCode;
        return i;
      }
    }
    catch (Exception paramString)
    {
      LogUtility.b("AppUtil", "getApkVersonCode>>>", paramString);
    }
    return 0;
  }
  
  public static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(1073741824);
    if (!a.containsKey(paramString))
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0).iterator();
      while (paramContext.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramContext.next();
        if (!a.containsKey(localResolveInfo.activityInfo.applicationInfo.packageName)) {
          a.put(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name);
        }
      }
    }
    paramContext = (String)a.get(paramString);
    if (paramContext != null)
    {
      localIntent.setComponent(new ComponentName(paramString, paramContext));
      return localIntent;
    }
    return null;
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      PackageManager localPackageManager = CommonDataAdapter.a().a().getPackageManager();
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if ((paramString != null) && (paramString.applicationInfo != null))
      {
        paramString = paramString.applicationInfo.loadIcon(localPackageManager);
        if (paramString != null)
        {
          paramString = ImageUtil.b(paramString);
          return paramString;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static java.lang.Process a()
  {
    Object localObject = new ProcessBuilder(new String[] { "su" });
    ((ProcessBuilder)localObject).redirectErrorStream(false);
    try
    {
      localObject = ((ProcessBuilder)localObject).start();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if (paramContext != null)
      {
        paramContext = paramContext.signatures;
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramContext = MD5Utils.d(paramContext[(paramContext.length - 1)].toCharsString());
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = CommonDataAdapter.a().a().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (paramString != null)
        {
          paramString = paramString.applicationInfo.packageName;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("AppUtil", "getApkName>>>", paramString);
      }
    }
    return null;
  }
  
  /* Error */
  public static String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 213	java/lang/ProcessBuilder
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 216	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iconst_0
    //   11: invokevirtual 220	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 223	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   19: astore_1
    //   20: new 259	java/io/DataOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokevirtual 265	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 268	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: new 270	java/io/DataInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 274	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 277	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +88 -> 133
    //   48: aload_2
    //   49: ifnull +84 -> 133
    //   52: aload_0
    //   53: invokevirtual 280	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 282
    //   61: invokevirtual 285	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   64: aload_2
    //   65: invokevirtual 288	java/io/DataOutputStream:flush	()V
    //   68: aload_1
    //   69: invokevirtual 291	java/lang/Process:waitFor	()I
    //   72: pop
    //   73: aload_0
    //   74: astore_2
    //   75: aload_1
    //   76: ifnull +9 -> 85
    //   79: aload_1
    //   80: invokevirtual 294	java/lang/Process:destroy	()V
    //   83: aload_0
    //   84: astore_2
    //   85: aload_2
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: ldc 233
    //   92: astore_0
    //   93: aload_0
    //   94: astore_2
    //   95: aload_1
    //   96: ifnull -11 -> 85
    //   99: aload_1
    //   100: invokevirtual 294	java/lang/Process:destroy	()V
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 294	java/lang/Process:destroy	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_0
    //   119: goto -11 -> 108
    //   122: astore_0
    //   123: ldc 233
    //   125: astore_0
    //   126: goto -33 -> 93
    //   129: astore_2
    //   130: goto -37 -> 93
    //   133: ldc 233
    //   135: astore_0
    //   136: goto -79 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayOfString	String[]
    //   19	94	1	localProcess	java.lang.Process
    //   31	64	2	localObject	Object
    //   129	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	20	87	java/lang/Exception
    //   0	20	105	finally
    //   20	44	118	finally
    //   52	57	118	finally
    //   57	73	118	finally
    //   20	44	122	java/lang/Exception
    //   52	57	122	java/lang/Exception
    //   57	73	129	java/lang/Exception
  }
  
  public static List a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        LogUtility.b("AppUtil", "getInstalledPackages switch is open, will scan local packages");
        return paramContext.getInstalledPackages(0);
      }
    }
    LogUtility.b("AppUtil", "getInstalledPackages switch is closed, will not scan local packages");
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
      localIntent.putExtra("platformId", "qzone_m");
      LogUtility.c("add", ">>has add platformid=qzone_m");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      new Intent();
      paramString = a(paramContext, paramString);
      if (paramString != null)
      {
        paramString.setAction("android.intent.action.MAIN");
        paramString.putExtra("platformId", "qzone_m");
        LogUtility.c("add", ">>has add platformid=qzone_m");
        try
        {
          paramContext.startActivity(paramString);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          Toast.makeText(paramContext, "无法启动该应用", 0).show();
          return;
        }
      }
      Toast.makeText(paramContext, "无法启动该应用", 0).show();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString2);
    paramString1 = localIntent;
    if (localIntent == null)
    {
      paramString1 = new Intent(paramString2);
      paramString1.addCategory("android.intent.category.DEFAULT");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1.putExtra("appCustom", paramString3);
      LogUtility.c("add", ">>has add appCustom=" + paramString3);
    }
    paramString1.putExtra("platformId", "qzone_m");
    LogUtility.c("add", ">>has add platformid=qzone_m");
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramString1.addFlags(268435456);
      }
      paramContext.startActivity(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      Toast.makeText(paramContext, "启动失败", 0).show();
    }
  }
  
  public static void a(String paramString)
  {
    i = 0;
    try
    {
      long l1 = new File(paramString).length();
      localZipFile = new ZipFile(paramString);
      try
      {
        paramString = localZipFile.entries();
        j = 0;
        do
        {
          if (!paramString.hasMoreElements()) {
            break;
          }
          localZipEntry = (ZipEntry)paramString.nextElement();
        } while (localZipEntry.isDirectory());
        l2 = localZipEntry.getCompressedSize();
        l3 = localZipEntry.getSize();
        if ((l2 >= -1L) && (l2 <= l1) && (l3 >= -1L) && (l3 <= 1500L * l2)) {
          break label137;
        }
        throw new RuntimeException("Invalid entry size!");
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        ZipEntry localZipEntry;
        long l2;
        long l3;
        ZipFile localZipFile = null;
        continue;
        int k = i;
        i = j;
        int j = k;
      }
    }
    if (localZipFile != null) {
      localZipFile.close();
    }
    throw paramString;
    label137:
    if ((localZipEntry.getName() != null) && (localZipEntry.getName().contains("AndroidManifest.xml")))
    {
      if ((l2 == 0L) || (l3 == 0L)) {
        throw new RuntimeException("Invalid AndroidManifest!");
      }
      a(localZipFile, localZipEntry, false);
      k = 1;
      i = j;
      j = k;
      label198:
      if ((i == 0) || (j == 0)) {
        break label256;
      }
      if (localZipFile != null) {
        localZipFile.close();
      }
    }
    label256:
    do
    {
      return;
      if ((localZipEntry.getName() == null) || (!localZipEntry.getName().contains("classes.dex"))) {
        break label283;
      }
      a(localZipFile, localZipEntry, false);
      k = 1;
      j = i;
      i = k;
      break label198;
      k = j;
      j = i;
      i = k;
      break;
    } while (localZipFile == null);
    localZipFile.close();
  }
  
  /* Error */
  public static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray byte
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 417	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   15: astore_0
    //   16: iload_2
    //   17: ifeq +27 -> 44
    //   20: aload_0
    //   21: astore 4
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 423	java/io/InputStream:read	([B)I
    //   29: istore_3
    //   30: iconst_m1
    //   31: iload_3
    //   32: if_icmpne -12 -> 20
    //   35: aload_0
    //   36: ifnull +7 -> 43
    //   39: aload_0
    //   40: invokevirtual 424	java/io/InputStream:close	()V
    //   43: return
    //   44: aload_0
    //   45: astore 4
    //   47: aload_0
    //   48: aload 5
    //   50: invokevirtual 423	java/io/InputStream:read	([B)I
    //   53: pop
    //   54: goto -19 -> 35
    //   57: astore_0
    //   58: aload 4
    //   60: ifnull +8 -> 68
    //   63: aload 4
    //   65: invokevirtual 424	java/io/InputStream:close	()V
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramZipFile	ZipFile
    //   0	70	1	paramZipEntry	ZipEntry
    //   0	70	2	paramBoolean	boolean
    //   29	4	3	i	int
    //   8	56	4	localZipFile	ZipFile
    //   5	44	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	16	57	finally
    //   23	30	57	finally
    //   47	54	57	finally
  }
  
  public static boolean a()
  {
    try
    {
      Object localObject = new ProcessBuilder(new String[] { "su" });
      ((ProcessBuilder)localObject).redirectErrorStream(false);
      localObject = ((ProcessBuilder)localObject).start();
      DataOutputStream localDataOutputStream = new DataOutputStream(((java.lang.Process)localObject).getOutputStream());
      DataInputStream localDataInputStream = new DataInputStream(((java.lang.Process)localObject).getInputStream());
      if ((localDataInputStream != null) && (localDataOutputStream != null))
      {
        localDataOutputStream.flush();
        localDataOutputStream.writeBytes("id\n");
        localDataOutputStream.flush();
        localDataOutputStream.writeBytes("exit\n");
        localDataOutputStream.flush();
        ((java.lang.Process)localObject).waitFor();
        localObject = localDataInputStream.readLine();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool = ((String)localObject).contains("uid=0");
          if (bool) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      LogUtility.e("AppUtil", "isPackageScanAllowed context is null");
      return true;
    }
    try
    {
      boolean bool = CommonDataAdapter.a().a().getSharedPreferences("package_scan", 0).getBoolean("qqsetting_package_scan_flag", true);
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (new File(paramString).exists())
      {
        TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).hookAM4Install();
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setFlags(268435456);
        localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
        paramContext.startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      LogUtility.c("AppUtil", "installApp>>>", paramContext);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (localIntent == null)
    {
      localIntent = new Intent(paramString);
      localIntent.addCategory("android.intent.category.DEFAULT");
      try
      {
        for (;;)
        {
          localIntent.addFlags(paramInt);
          localIntent.putExtras(paramBundle);
          try
          {
            ((StartAppCheckHandler)((BaseActivity)paramContext).app.a(23)).b(paramString.trim(), paramContext, localIntent);
            return true;
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              try
              {
                new StartAppCheckHandler((QQAppInterface)null).a(paramString.trim(), paramContext, localIntent);
              }
              catch (Exception paramString)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler Failed!");
                }
                paramContext.startActivity(localIntent);
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        Toast.makeText(paramContext, "无法启动该应用", 0).show();
        return false;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    PackageManager localPackageManager = CommonDataAdapter.a().a().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      try
      {
        paramString = CommonDataAdapter.a().a().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (paramString != null)
        {
          int i = paramString.versionCode;
          return i;
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("AppUtil", "getApkVersonCodeFromApkFile>>>", paramString);
      }
    }
    return 0;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      int i = android.os.Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      LogUtility.b("AppUtil", "getCurProcessName err", paramContext);
    }
    return null;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + paramString)));
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    java.lang.Process localProcess = a();
    if (localProcess == null) {}
    for (;;)
    {
      return bool2;
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream(localProcess.getOutputStream());
        Object localObject = new BufferedReader(new InputStreamReader(localProcess.getInputStream(), "UTF-8"));
        boolean bool1 = bool3;
        int i;
        if (localObject != null)
        {
          bool1 = bool3;
          if (localDataOutputStream != null)
          {
            File localFile = new File(paramString);
            String str1 = localFile.getParent();
            String str2 = new File(str1).getParent();
            String str3 = new File(str2).getParent();
            localDataOutputStream.write(("chmod 777 " + localFile.getAbsolutePath() + "\n").getBytes());
            localDataOutputStream.flush();
            localDataOutputStream.writeBytes("chmod 777 " + str1 + "\n");
            localDataOutputStream.flush();
            localDataOutputStream.writeBytes("chmod 777 " + str2 + "\n");
            localDataOutputStream.flush();
            localDataOutputStream.writeBytes("chmod 777 " + str3 + "\n");
            localDataOutputStream.flush();
            localDataOutputStream.write(("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r " + paramString + "\n").getBytes());
            localDataOutputStream.flush();
            localDataOutputStream.close();
            paramString = new char[1024];
            i = ((BufferedReader)localObject).read(paramString);
            localObject = new StringBuilder();
            if (i == -1) {
              break label399;
            }
          }
        }
        for (paramString = ((StringBuilder)localObject).append(paramString, 0, i).toString();; paramString = new String(paramString, 0, localProcess.getErrorStream().read(paramString)))
        {
          bool1 = bool3;
          if (!TextUtils.isEmpty(paramString))
          {
            boolean bool4 = paramString.toLowerCase().contains("success");
            bool1 = bool3;
            if (bool4) {
              bool1 = true;
            }
          }
          bool2 = bool1;
          return bool1;
          label399:
          paramString = new byte[1024];
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
      }
      finally
      {
        if (localProcess != null) {
          localProcess.destroy();
        }
      }
    }
  }
  
  public static int c(String paramString)
  {
    LogUtility.b("AppUtil", "getAppVersionCode: " + paramString);
    localObject1 = null;
    try
    {
      a(paramString);
      Object localObject2 = (AssetManager)AssetManager.class.newInstance();
      Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localObject2, new Object[] { paramString });
      localObject2 = ((AssetManager)localObject2).openXmlResourceParser("AndroidManifest.xml");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.e("AppUtil", "openManifest failed: " + localException.getMessage());
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    for (;;)
    {
      try
      {
        i = localObject1.getEventType();
      }
      catch (XmlPullParserException paramString)
      {
        String str;
        LogUtility.e("AppUtil", "error: " + paramString.getMessage());
        localObject1.close();
        return 0;
      }
      catch (IOException paramString)
      {
        LogUtility.e("AppUtil", "error: " + paramString.getMessage());
        continue;
      }
      catch (Exception paramString)
      {
        int i;
        LogUtility.e("AppUtil", "error: " + paramString.getMessage());
        continue;
        if (i == 1) {
          continue;
        }
        switch (i)
        {
        }
        continue;
      }
      i = localObject1.nextToken();
      continue;
      str = localObject1.getName();
      if ((!TextUtils.isEmpty(str)) && (str.equals("manifest")))
      {
        i = 0;
        if (i < localObject1.getAttributeCount())
        {
          if (localObject1.getAttributeName(i).equals("versionCode"))
          {
            str = localObject1.getAttributeValue(i);
            localObject1.close();
            LogUtility.b("AppUtil", "apkPath:" + paramString + ",versionCode:" + str);
            i = Integer.parseInt(str);
            return i;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.business.base.AppUtil
 * JD-Core Version:    0.7.0.1
 */