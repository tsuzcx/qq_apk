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
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.xmlpull.v1.XmlPullParserException;

public class AppUtil
{
  protected static Map<String, String> a = new HashMap();
  
  public static int a()
  {
    Object localObject1 = new String[5];
    localObject1[0] = "/system/xbin/";
    localObject1[1] = "/system/bin/";
    localObject1[2] = "/system/sbin/";
    localObject1[3] = "/sbin/";
    localObject1[4] = "/vendor/bin/";
    int i = 0;
    try
    {
      while (i < localObject1.length)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localObject1[i]);
        ((StringBuilder)localObject2).append("su");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (new File((String)localObject2).exists())
        {
          localObject1 = a(new String[] { "ls", "-l", localObject2 });
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = ((String)localObject1).indexOf("root");
            int j = ((String)localObject1).lastIndexOf("root");
            if (i == j) {
              return 0;
            }
            return 1;
          }
          return 0;
        }
        i += 1;
      }
      return 2;
    }
    catch (Exception localException) {}
    return 2;
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
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label18:
      break label18;
    }
    return "";
  }
  
  /* Error */
  public static String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc 182
    //   2: astore_3
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 5
    //   11: astore 4
    //   13: aload_3
    //   14: astore_1
    //   15: aload 6
    //   17: astore_2
    //   18: new 184	java/lang/ProcessBuilder
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 187	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload 5
    //   29: astore 4
    //   31: aload_3
    //   32: astore_1
    //   33: aload 6
    //   35: astore_2
    //   36: aload_0
    //   37: iconst_0
    //   38: invokevirtual 191	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   41: pop
    //   42: aload 5
    //   44: astore 4
    //   46: aload_3
    //   47: astore_1
    //   48: aload 6
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 195	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   55: astore_0
    //   56: aload_0
    //   57: astore 4
    //   59: aload_3
    //   60: astore_1
    //   61: aload_0
    //   62: astore_2
    //   63: new 197	java/io/DataOutputStream
    //   66: dup
    //   67: aload_0
    //   68: invokevirtual 203	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   71: invokespecial 206	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore 5
    //   76: aload_0
    //   77: astore 4
    //   79: aload_3
    //   80: astore_1
    //   81: aload_0
    //   82: astore_2
    //   83: new 208	java/io/DataInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokevirtual 212	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   91: invokespecial 215	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: invokevirtual 218	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   97: astore_3
    //   98: aload_0
    //   99: astore 4
    //   101: aload_3
    //   102: astore_1
    //   103: aload_0
    //   104: astore_2
    //   105: aload 5
    //   107: ldc 220
    //   109: invokevirtual 223	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   112: aload_0
    //   113: astore 4
    //   115: aload_3
    //   116: astore_1
    //   117: aload_0
    //   118: astore_2
    //   119: aload 5
    //   121: invokevirtual 226	java/io/DataOutputStream:flush	()V
    //   124: aload_0
    //   125: astore 4
    //   127: aload_3
    //   128: astore_1
    //   129: aload_0
    //   130: astore_2
    //   131: aload_0
    //   132: invokevirtual 229	java/lang/Process:waitFor	()I
    //   135: pop
    //   136: aload_3
    //   137: astore 4
    //   139: aload_0
    //   140: ifnull +36 -> 176
    //   143: aload_3
    //   144: astore_1
    //   145: aload_0
    //   146: invokevirtual 232	java/lang/Process:destroy	()V
    //   149: aload_1
    //   150: areturn
    //   151: astore_0
    //   152: aload 4
    //   154: ifnull +8 -> 162
    //   157: aload 4
    //   159: invokevirtual 232	java/lang/Process:destroy	()V
    //   162: aload_0
    //   163: athrow
    //   164: aload_1
    //   165: astore 4
    //   167: aload_2
    //   168: ifnull +8 -> 176
    //   171: aload_2
    //   172: astore_0
    //   173: goto -28 -> 145
    //   176: aload 4
    //   178: areturn
    //   179: astore_0
    //   180: goto -16 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramArrayOfString	String[]
    //   14	151	1	str1	String
    //   17	155	2	localObject1	Object
    //   2	142	3	str2	String
    //   11	166	4	localObject2	Object
    //   7	113	5	localDataOutputStream	DataOutputStream
    //   4	45	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	27	151	finally
    //   36	42	151	finally
    //   51	56	151	finally
    //   63	76	151	finally
    //   83	98	151	finally
    //   105	112	151	finally
    //   119	124	151	finally
    //   131	136	151	finally
    //   18	27	179	java/lang/Exception
    //   36	42	179	java/lang/Exception
    //   51	56	179	java/lang/Exception
    //   63	76	179	java/lang/Exception
    //   83	98	179	java/lang/Exception
    //   105	112	179	java/lang/Exception
    //   119	124	179	java/lang/Exception
    //   131	136	179	java/lang/Exception
  }
  
  public static void a(QZipFile paramQZipFile, ZipEntry paramZipEntry, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[4096];
    try
    {
      paramQZipFile = paramQZipFile.getInputStream(paramZipEntry);
      if ((!paramBoolean) || (paramQZipFile != null)) {
        paramQZipFile.close();
      }
    }
    finally
    {
      try
      {
        while (-1 != paramQZipFile.read(arrayOfByte))
        {
          continue;
          paramQZipFile.read(arrayOfByte);
        }
        if (paramQZipFile != null) {
          paramQZipFile.close();
        }
        return;
      }
      finally
      {
        break label46;
      }
      paramZipEntry = finally;
      paramQZipFile = null;
    }
    for (;;)
    {
      label46:
      throw paramZipEntry;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent2 = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      localIntent1 = new Intent(paramString);
      localIntent1.addCategory("android.intent.category.DEFAULT");
    }
    label128:
    try
    {
      localIntent1.addFlags(paramInt);
      localIntent1.putExtras(paramBundle);
    }
    catch (Exception paramString)
    {
      label80:
      label104:
      break label128;
    }
    try
    {
      ((StartAppCheckHandler)((BaseActivity)paramContext).app.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER)).b(paramString.trim(), paramContext, localIntent1);
    }
    catch (Exception paramBundle)
    {
      break label80;
    }
    try
    {
      new StartAppCheckHandler((QQAppInterface)null).a(paramString.trim(), paramContext, localIntent1);
    }
    catch (Exception paramString)
    {
      break label104;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler Failed!");
    }
    paramContext.startActivity(localIntent1);
    return true;
    Toast.makeText(paramContext, HardCodeUtil.a(2131898879), 0).show();
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, "");
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return a(paramContext, paramString1, paramString2, paramString3, "0");
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      if (!new File(paramString1).exists()) {
        return false;
      }
      TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).hookAM4Install();
      paramString1 = FileProvider7Helper.openApkIntent(paramContext, paramString1);
      if (GlobalUtil.isVivo()) {
        paramString1.putExtra("installDir", true);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("installApp>>> put source ");
        localStringBuilder.append(paramString2);
        LogUtility.b("AppUtil", localStringBuilder.toString());
        paramString1.putExtra("big_brother_source_key", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString2 = new StringBuilder();
        paramString2.append("installApp>>> put ref id ");
        paramString2.append(paramString3);
        LogUtility.b("AppUtil", paramString2.toString());
        paramString1.putExtra("big_brother_ref_source_key", paramString3);
      }
      if ((!TextUtils.isEmpty(paramString4)) && ("1".equals(paramString4))) {
        paramString1.putExtra("android.intent.extra.RETURN_RESULT", true);
      }
      paramContext.startActivity(paramString1);
      return true;
    }
    catch (Exception paramContext)
    {
      LogUtility.c("AppUtil", "installApp>>>", paramContext);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return PackageUtil.a(CommonDataAdapter.a().b(), paramString);
  }
  
  public static Bitmap b(String paramString)
  {
    try
    {
      PackageManager localPackageManager = CommonDataAdapter.a().b().getPackageManager();
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if ((paramString != null) && (paramString.applicationInfo != null))
      {
        paramString = paramString.applicationInfo.loadIcon(localPackageManager);
        if (paramString != null)
        {
          paramString = ImageUtil.c(paramString);
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
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString1);
      localIntent.putExtra("platformId", "qzone_m");
      LogUtility.c("add", ">>has add platformid=qzone_m");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    new Intent();
    paramString1 = a(paramContext, paramString1);
    if (paramString1 != null)
    {
      paramString1.setAction("android.intent.action.MAIN");
      paramString1.putExtra("platformId", "qzone_m");
      paramString1.putExtra("big_brother_source_key", paramString2);
      LogUtility.c("add", ">>has add platformid=qzone_m");
      try
      {
        paramContext.startActivity(paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        Toast.makeText(paramContext, HardCodeUtil.a(2131898876), 0).show();
        return;
      }
    }
    Toast.makeText(paramContext, HardCodeUtil.a(2131898877), 0).show();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
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
      paramString2 = new StringBuilder();
      paramString2.append(">>has add appCustom=");
      paramString2.append(paramString3);
      LogUtility.c("add", paramString2.toString());
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
      label123:
      break label123;
    }
    Toast.makeText(paramContext, HardCodeUtil.a(2131898878), 0).show();
  }
  
  public static boolean b()
  {
    try
    {
      Object localObject = new ProcessBuilder(new String[] { "su" });
      ((ProcessBuilder)localObject).redirectErrorStream(false);
      localObject = ((ProcessBuilder)localObject).start();
      DataOutputStream localDataOutputStream = new DataOutputStream(((java.lang.Process)localObject).getOutputStream());
      DataInputStream localDataInputStream = new DataInputStream(((java.lang.Process)localObject).getInputStream());
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
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "");
  }
  
  public static java.lang.Process c()
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
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = CommonDataAdapter.a().b().getPackageManager().getPackageArchiveInfo(paramString, 1);
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
    return null;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    b(paramContext, paramString, "");
  }
  
  public static boolean c(Context paramContext)
  {
    if (paramContext == null)
    {
      LogUtility.e("AppUtil", "isPackageScanAllowed context is null");
      return true;
    }
    try
    {
      boolean bool = CommonDataAdapter.a().b().getSharedPreferences("package_scan", 0).getBoolean("qqsetting_package_scan_flag", true);
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  public static int d(String paramString)
  {
    PackageManager localPackageManager = CommonDataAdapter.a().b().getPackageManager();
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
  
  public static List<PackageInfo> d(Context paramContext)
  {
    return null;
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("package:");
      localStringBuilder.append(paramString);
      paramContext.startActivity(new Intent("android.intent.action.DELETE", Uri.parse(localStringBuilder.toString())));
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static int e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      paramString = CommonDataAdapter.a().b().getPackageManager().getPackageArchiveInfo(paramString, 1);
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
    return 0;
  }
  
  public static int f(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getAppVersionCode: ");
    ((StringBuilder)localObject1).append(paramString);
    LogUtility.b("AppUtil", ((StringBuilder)localObject1).toString());
    Object localObject2;
    try
    {
      g(paramString);
      localObject1 = (AssetManager)AssetManager.class.newInstance();
      localObject3 = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      ((Method)localObject3).setAccessible(true);
      ((Method)localObject3).invoke(localObject1, new Object[] { paramString });
      localObject1 = ((AssetManager)localObject1).openXmlResourceParser("AndroidManifest.xml");
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("openManifest failed: ");
      ((StringBuilder)localObject3).append(localException.getMessage());
      LogUtility.e("AppUtil", ((StringBuilder)localObject3).toString());
      localObject2 = null;
    }
    if (localObject2 == null) {
      return 0;
    }
    int i;
    try
    {
      i = localObject2.getEventType();
    }
    catch (Exception paramString)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("error: ");
      ((StringBuilder)localObject3).append(paramString.getMessage());
      LogUtility.e("AppUtil", ((StringBuilder)localObject3).toString());
      break label396;
    }
    catch (IOException paramString)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("error: ");
      ((StringBuilder)localObject3).append(paramString.getMessage());
      LogUtility.e("AppUtil", ((StringBuilder)localObject3).toString());
      break label396;
    }
    catch (XmlPullParserException paramString)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("error: ");
      ((StringBuilder)localObject3).append(paramString.getMessage());
      LogUtility.e("AppUtil", ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = localObject2.getName();
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals("manifest"))) {
      i = 0;
    }
    for (;;)
    {
      if (i < localObject2.getAttributeCount())
      {
        if (localObject2.getAttributeName(i).equals("versionCode"))
        {
          localObject3 = localObject2.getAttributeValue(i);
          localObject2.close();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("apkPath:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",versionCode:");
          localStringBuilder.append((String)localObject3);
          LogUtility.b("AppUtil", localStringBuilder.toString());
          return Integer.parseInt((String)localObject3);
        }
      }
      else {
        for (;;)
        {
          i = localObject2.nextToken();
          label396:
          while (i == 1)
          {
            localObject2.close();
            return 0;
          }
          if (i == 2) {
            break;
          }
        }
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void g(String paramString)
  {
    // Byte code:
    //   0: new 48	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 620	java/io/File:length	()J
    //   11: lstore 5
    //   13: new 235	com/tencent/commonsdk/zip/QZipFile
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 621	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 625	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   26: astore 11
    //   28: iconst_0
    //   29: istore_2
    //   30: iconst_0
    //   31: istore_1
    //   32: aload 11
    //   34: invokeinterface 630 1 0
    //   39: ifeq +219 -> 258
    //   42: aload 11
    //   44: invokeinterface 633 1 0
    //   49: checkcast 635	java/util/zip/ZipEntry
    //   52: astore 12
    //   54: aload 12
    //   56: invokevirtual 638	java/util/zip/ZipEntry:isDirectory	()Z
    //   59: ifeq +6 -> 65
    //   62: goto -30 -> 32
    //   65: aload 12
    //   67: invokevirtual 641	java/util/zip/ZipEntry:getCompressedSize	()J
    //   70: lstore 7
    //   72: aload 12
    //   74: invokevirtual 644	java/util/zip/ZipEntry:getSize	()J
    //   77: lstore 9
    //   79: lload 7
    //   81: ldc2_w 645
    //   84: lcmp
    //   85: iflt +162 -> 247
    //   88: lload 7
    //   90: lload 5
    //   92: lcmp
    //   93: ifgt +154 -> 247
    //   96: lload 9
    //   98: ldc2_w 645
    //   101: lcmp
    //   102: iflt +145 -> 247
    //   105: lload 9
    //   107: ldc2_w 647
    //   110: lload 7
    //   112: lmul
    //   113: lcmp
    //   114: ifgt +133 -> 247
    //   117: aload 12
    //   119: invokevirtual 649	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   122: ifnull +57 -> 179
    //   125: aload 12
    //   127: invokevirtual 649	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   130: ldc_w 570
    //   133: invokevirtual 484	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   136: ifeq +43 -> 179
    //   139: lload 7
    //   141: lconst_0
    //   142: lcmp
    //   143: ifeq +25 -> 168
    //   146: lload 9
    //   148: lconst_0
    //   149: lcmp
    //   150: ifeq +18 -> 168
    //   153: aload_0
    //   154: aload 12
    //   156: iconst_0
    //   157: invokestatic 651	com/tencent/open/business/base/AppUtil:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;Z)V
    //   160: iconst_1
    //   161: istore 4
    //   163: iload_2
    //   164: istore_3
    //   165: goto +58 -> 223
    //   168: new 653	java/lang/RuntimeException
    //   171: dup
    //   172: ldc_w 655
    //   175: invokespecial 656	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   178: athrow
    //   179: iload_2
    //   180: istore_3
    //   181: iload_1
    //   182: istore 4
    //   184: aload 12
    //   186: invokevirtual 649	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   189: ifnull +34 -> 223
    //   192: iload_2
    //   193: istore_3
    //   194: iload_1
    //   195: istore 4
    //   197: aload 12
    //   199: invokevirtual 649	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   202: ldc_w 658
    //   205: invokevirtual 484	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   208: ifeq +15 -> 223
    //   211: aload_0
    //   212: aload 12
    //   214: iconst_0
    //   215: invokestatic 651	com/tencent/open/business/base/AppUtil:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;Z)V
    //   218: iconst_1
    //   219: istore_3
    //   220: iload_1
    //   221: istore 4
    //   223: iload_3
    //   224: istore_2
    //   225: iload 4
    //   227: istore_1
    //   228: iload_3
    //   229: ifeq -197 -> 32
    //   232: iload_3
    //   233: istore_2
    //   234: iload 4
    //   236: istore_1
    //   237: iload 4
    //   239: ifeq -207 -> 32
    //   242: aload_0
    //   243: invokevirtual 659	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   246: return
    //   247: new 653	java/lang/RuntimeException
    //   250: dup
    //   251: ldc_w 661
    //   254: invokespecial 656	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   257: athrow
    //   258: aload_0
    //   259: invokevirtual 659	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   262: return
    //   263: astore 11
    //   265: goto +7 -> 272
    //   268: astore 11
    //   270: aconst_null
    //   271: astore_0
    //   272: aload_0
    //   273: ifnull +7 -> 280
    //   276: aload_0
    //   277: invokevirtual 659	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   280: goto +6 -> 286
    //   283: aload 11
    //   285: athrow
    //   286: goto -3 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramString	String
    //   31	206	1	i	int
    //   29	205	2	j	int
    //   164	69	3	k	int
    //   161	77	4	m	int
    //   11	80	5	l1	long
    //   70	70	7	l2	long
    //   77	70	9	l3	long
    //   26	17	11	localEnumeration	java.util.Enumeration
    //   263	1	11	localObject1	Object
    //   268	16	11	localObject2	Object
    //   52	161	12	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   22	28	263	finally
    //   32	62	263	finally
    //   65	79	263	finally
    //   117	139	263	finally
    //   153	160	263	finally
    //   168	179	263	finally
    //   184	192	263	finally
    //   197	218	263	finally
    //   247	258	263	finally
    //   0	22	268	finally
  }
  
  /* Error */
  public static boolean h(String paramString)
  {
    // Byte code:
    //   0: invokestatic 664	com/tencent/open/business/base/AppUtil:c	()Ljava/lang/Process;
    //   3: astore 7
    //   5: iconst_0
    //   6: istore 4
    //   8: iconst_0
    //   9: istore 5
    //   11: iconst_0
    //   12: istore_3
    //   13: aload 7
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 197	java/io/DataOutputStream
    //   23: dup
    //   24: aload 7
    //   26: invokevirtual 203	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   29: invokespecial 206	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 9
    //   34: new 666	java/io/BufferedReader
    //   37: dup
    //   38: new 668	java/io/InputStreamReader
    //   41: dup
    //   42: aload 7
    //   44: invokevirtual 212	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   47: ldc_w 670
    //   50: invokespecial 673	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   53: invokespecial 676	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   56: astore 8
    //   58: new 48	java/io/File
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 13
    //   68: aload 13
    //   70: invokevirtual 679	java/io/File:getParent	()Ljava/lang/String;
    //   73: astore 12
    //   75: new 48	java/io/File
    //   78: dup
    //   79: aload 12
    //   81: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 679	java/io/File:getParent	()Ljava/lang/String;
    //   87: astore 11
    //   89: new 48	java/io/File
    //   92: dup
    //   93: aload 11
    //   95: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 679	java/io/File:getParent	()Ljava/lang/String;
    //   101: astore 10
    //   103: new 35	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   110: astore 14
    //   112: aload 14
    //   114: ldc_w 681
    //   117: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 14
    //   123: aload 13
    //   125: invokevirtual 684	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 14
    //   134: ldc_w 686
    //   137: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 9
    //   143: aload 14
    //   145: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 690	java/lang/String:getBytes	()[B
    //   151: invokevirtual 694	java/io/DataOutputStream:write	([B)V
    //   154: aload 9
    //   156: invokevirtual 226	java/io/DataOutputStream:flush	()V
    //   159: new 35	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   166: astore 13
    //   168: aload 13
    //   170: ldc_w 681
    //   173: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 13
    //   179: aload 12
    //   181: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 13
    //   187: ldc_w 686
    //   190: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 9
    //   196: aload 13
    //   198: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokevirtual 223	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   204: aload 9
    //   206: invokevirtual 226	java/io/DataOutputStream:flush	()V
    //   209: new 35	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   216: astore 12
    //   218: aload 12
    //   220: ldc_w 681
    //   223: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 12
    //   229: aload 11
    //   231: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 12
    //   237: ldc_w 686
    //   240: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 9
    //   246: aload 12
    //   248: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokevirtual 223	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   254: aload 9
    //   256: invokevirtual 226	java/io/DataOutputStream:flush	()V
    //   259: new 35	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   266: astore 11
    //   268: aload 11
    //   270: ldc_w 681
    //   273: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 11
    //   279: aload 10
    //   281: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 11
    //   287: ldc_w 686
    //   290: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 9
    //   296: aload 11
    //   298: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 223	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   304: aload 9
    //   306: invokevirtual 226	java/io/DataOutputStream:flush	()V
    //   309: new 35	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   316: astore 10
    //   318: aload 10
    //   320: ldc_w 696
    //   323: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 10
    //   329: aload_0
    //   330: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 10
    //   336: ldc_w 686
    //   339: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 9
    //   345: aload 10
    //   347: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokevirtual 690	java/lang/String:getBytes	()[B
    //   353: invokevirtual 694	java/io/DataOutputStream:write	([B)V
    //   356: aload 9
    //   358: invokevirtual 226	java/io/DataOutputStream:flush	()V
    //   361: aload 9
    //   363: invokevirtual 697	java/io/DataOutputStream:close	()V
    //   366: sipush 1024
    //   369: newarray char
    //   371: astore_0
    //   372: aload 8
    //   374: aload_0
    //   375: invokevirtual 700	java/io/BufferedReader:read	([C)I
    //   378: istore_1
    //   379: new 35	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   386: astore 8
    //   388: iload_1
    //   389: iconst_m1
    //   390: if_icmpeq +21 -> 411
    //   393: aload 8
    //   395: aload_0
    //   396: iconst_0
    //   397: iload_1
    //   398: invokevirtual 703	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 8
    //   404: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: astore_0
    //   408: goto +28 -> 436
    //   411: sipush 1024
    //   414: newarray byte
    //   416: astore_0
    //   417: new 23	java/lang/String
    //   420: dup
    //   421: aload_0
    //   422: iconst_0
    //   423: aload 7
    //   425: invokevirtual 706	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   428: aload_0
    //   429: invokevirtual 244	java/io/InputStream:read	([B)I
    //   432: invokespecial 709	java/lang/String:<init>	([BII)V
    //   435: astore_0
    //   436: iload_3
    //   437: istore_2
    //   438: aload_0
    //   439: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   442: ifne +24 -> 466
    //   445: aload_0
    //   446: invokevirtual 712	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   449: ldc_w 714
    //   452: invokevirtual 484	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   455: istore 6
    //   457: iload_3
    //   458: istore_2
    //   459: iload 6
    //   461: ifeq +5 -> 466
    //   464: iconst_1
    //   465: istore_2
    //   466: iload_2
    //   467: istore_3
    //   468: aload 7
    //   470: ifnull +33 -> 503
    //   473: aload 7
    //   475: invokevirtual 232	java/lang/Process:destroy	()V
    //   478: iload_2
    //   479: ireturn
    //   480: astore_0
    //   481: goto +24 -> 505
    //   484: astore_0
    //   485: aload_0
    //   486: invokevirtual 466	java/lang/Exception:printStackTrace	()V
    //   489: iload 5
    //   491: istore_3
    //   492: aload 7
    //   494: ifnull +9 -> 503
    //   497: iload 4
    //   499: istore_2
    //   500: goto -27 -> 473
    //   503: iload_3
    //   504: ireturn
    //   505: aload 7
    //   507: ifnull +8 -> 515
    //   510: aload 7
    //   512: invokevirtual 232	java/lang/Process:destroy	()V
    //   515: goto +5 -> 520
    //   518: aload_0
    //   519: athrow
    //   520: goto -2 -> 518
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramString	String
    //   378	20	1	i	int
    //   437	63	2	bool1	boolean
    //   12	492	3	bool2	boolean
    //   6	492	4	bool3	boolean
    //   9	481	5	bool4	boolean
    //   455	5	6	bool5	boolean
    //   3	508	7	localProcess	java.lang.Process
    //   56	347	8	localObject1	Object
    //   32	330	9	localDataOutputStream	DataOutputStream
    //   101	245	10	localObject2	Object
    //   87	210	11	localObject3	Object
    //   73	174	12	localObject4	Object
    //   66	131	13	localObject5	Object
    //   110	34	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	388	480	finally
    //   393	408	480	finally
    //   411	436	480	finally
    //   438	457	480	finally
    //   485	489	480	finally
    //   20	388	484	java/lang/Exception
    //   393	408	484	java/lang/Exception
    //   411	436	484	java/lang/Exception
    //   438	457	484	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.base.AppUtil
 * JD-Core Version:    0.7.0.1
 */