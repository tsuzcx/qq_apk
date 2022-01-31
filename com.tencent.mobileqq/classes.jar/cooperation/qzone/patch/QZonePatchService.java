package cooperation.qzone.patch;

import amwt;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QZonePatchService
{
  private static int jdField_a_of_type_Int;
  private static QZonePatchService jdField_a_of_type_CooperationQzonePatchQZonePatchService;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static int a(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramString == null) {
      i = paramInt + jdField_a_of_type_Int * 10000;
    }
    return i;
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0;
        paramString = Uri.parse(paramString).getLastPathSegment();
      } while (TextUtils.isEmpty(paramString));
      paramString = Pattern.compile("_r(\\d+)").matcher(paramString);
    } while (!paramString.find());
    paramString = paramString.group(1);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private static long a()
  {
    return LocalMultiProcConfig.getLong(QUA.a() + "p_len", 0L);
  }
  
  private static long a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.length();
    }
    return 0L;
  }
  
  public static QZonePatchService a()
  {
    if (jdField_a_of_type_CooperationQzonePatchQZonePatchService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzonePatchQZonePatchService == null) {
        jdField_a_of_type_CooperationQzonePatchQZonePatchService = new QZonePatchService();
      }
      return jdField_a_of_type_CooperationQzonePatchQZonePatchService;
    }
  }
  
  private static DexClassLoader a(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramContext = new DexClassLoader(paramString, paramContext.getDir("dex", 0).getAbsolutePath(), paramString, paramClassLoader);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      b("preCompileMergePatch failed :" + paramContext.getMessage() + "  stacktrace: " + Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  private static String a()
  {
    File localFile = PluginUtils.getInstalledPluginPath(BaseApplicationImpl.sApplication, "qzone_plugin.apk");
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt("V 7.6.3.3560p_ver", paramInt);
  }
  
  private static void a(long paramLong)
  {
    LocalMultiProcConfig.putLong(QUA.a() + "p_qzone_len", paramLong);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      b("start to merge...");
      if ((a() == 0L) || (b() == 0L)) {
        e();
      }
      if (c() == 0L) {
        d();
      }
      String str2 = a();
      String str1;
      if (str2 != null)
      {
        if ((a() != 0L) && (a() != a(paramString1)))
        {
          e();
          a(a(paramString1));
        }
        str1 = b(paramString2);
        if ((b() != 0L) && (b() == a(str1))) {
          break label263;
        }
        e();
        b("---> merge :" + str1);
        if (!PatchMergeUtils.a(str2, paramString1, str1)) {
          break label259;
        }
        b(a(str1));
        paramString1 = c(paramString2);
        if ((c() != 0L) && (c() == a(paramString1))) {
          break label302;
        }
        d();
        b("---> compile :" + paramString1);
        if (a(paramContext, str1, paramContext.getClassLoader()) != null)
        {
          c(a(paramString1));
          b("---> succeed to merge and compile, merge len:" + a(str1) + "   odex len:" + a(paramString1));
        }
      }
      for (;;)
      {
        b("end to merge...");
        return;
        label259:
        e();
        return;
        label263:
        b("---> merge : not merge share_pref len:" + b() + "  file len:" + a(str1));
        break;
        label302:
        b("---> merge : not compile share_pref len:" + c() + " file len:" + a(paramString1));
      }
    }
    b("not need to merge...");
  }
  
  public static void a(String paramString)
  {
    int i = a(paramString);
    jdField_a_of_type_Int = i;
    a(i);
  }
  
  private static long b()
  {
    return LocalMultiProcConfig.getLong(QUA.a() + "p_merge_len", 0L);
  }
  
  private static String b(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void b()
  {
    b("开始验证补丁包");
    jdField_a_of_type_JavaLangString = null;
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
    long l;
    int i;
    Object localObject3;
    if (((File)localObject1).exists())
    {
      Object localObject2 = QUA.a() + "p_len";
      l = LocalMultiProcConfig.getLong((String)localObject2, 0L);
      b((String)localObject2 + " = " + l);
      b("补丁包的文件长度期待的是：" + l);
      localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int j = localObject2.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (localObject3 != null) {}
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (!localObject3.isDirectory()) {
        if (l != localObject3.length()) {
          localObject3.delete();
        } else {
          try
          {
            localObject1 = PluginStatic.encodeFile(localObject3.getAbsolutePath()).toLowerCase();
            String str2 = localObject3.getName();
            str3 = str2.substring(0, str2.length() - ".jar".length());
            if (((String)localObject1 + ".jar").endsWith(str2.toLowerCase()))
            {
              jdField_a_of_type_JavaLangString = str3;
              if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
                break label403;
              }
              b("本地没有补丁包,当前md5是空的");
              return;
            }
          }
          catch (Exception localException)
          {
            String str3;
            String str1;
            for (;;)
            {
              QLog.w("qz_patch", 1, QLog.getStackTraceString(localException));
              str1 = null;
            }
            localObject3.delete();
            e();
            QZoneHelper.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 12, "patch verify failed: file md5: " + str1 + " but expected md5: " + str3, 1, System.currentTimeMillis());
            QLog.d("qz_patch", 2, "report [qz_patch] patch verify failed: file md5: " + str1 + " but expected md5: " + str3);
            jdField_a_of_type_JavaLangString = null;
          }
        }
      }
    }
    label403:
    b("当前补丁包的md5是" + jdField_a_of_type_JavaLangString);
  }
  
  private static void b(long paramLong)
  {
    LocalMultiProcConfig.putLong(QUA.a() + "p_merge_len", paramLong);
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qz_patch", 2, paramString);
    }
  }
  
  private static long c()
  {
    return LocalMultiProcConfig.getLong(QUA.a() + "p_merge_odex_len", 0L);
  }
  
  private static String c(String paramString)
  {
    paramString = paramString + ".dex";
    File localFile = BaseApplicationImpl.getContext().getDir("dex", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void c()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    b(0L);
  }
  
  private static void c(long paramLong)
  {
    LocalMultiProcConfig.putLong(QUA.a() + "p_merge_odex_len", paramLong);
  }
  
  private static void c(String paramString1, String paramString2)
  {
    b("开始更新补丁包");
    if (TextUtils.isEmpty(paramString1)) {
      b("md5是空的，什么都不做");
    }
    while (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    if (jdField_a_of_type_JavaLangString == null)
    {
      b("本地没有补丁包");
      if (!"del".equals(paramString1)) {}
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = false;
      return;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        d(paramString1, paramString2);
        jdField_a_of_type_JavaLangString = paramString1;
        continue;
        b("本地有补丁包");
        if (!jdField_a_of_type_JavaLangString.equals(paramString1)) {
          break;
        }
        b("md5相同，什么都不做");
        a(BaseApplicationImpl.getContext(), a(paramString1), paramString1);
      }
    }
    if ((paramString1.equals("del")) || (paramString1.equals("delete"))) {
      b("md5是del，直接删除旧的Patch");
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
        if (paramString1.exists())
        {
          paramString1 = paramString1.listFiles();
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            paramString2 = paramString1[i];
            if (paramString2.isDirectory()) {
              break label356;
            }
            paramString2.delete();
          }
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("qz_patch", 1, QLog.getStackTraceString(paramString1));
        }
      }
      for (;;)
      {
        QZoneHelper.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 11, "clear patch:" + jdField_a_of_type_JavaLangString, 1, System.currentTimeMillis());
        QLog.d("qz_patch", 2, "report [qz_patch] clear patch:" + jdField_a_of_type_JavaLangString);
        break;
        LocalMultiProcConfig.putLong(QUA.a() + "p_len", 0L);
        jdField_a_of_type_JavaLangString = null;
        e();
      }
      b("本地补丁包和网络补丁包不一样");
      e();
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break;
      }
      d(paramString1, paramString2);
      jdField_a_of_type_JavaLangString = paramString1;
      break;
      label356:
      i += 1;
    }
  }
  
  private static void d()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("dex", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    c(0L);
  }
  
  /* Error */
  private static void d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 377	cooperation/qzone/patch/QZonePatchService:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 7
    //   6: invokestatic 317	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 321	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   12: checkcast 392	com/tencent/common/app/AppInterface
    //   15: aload_1
    //   16: new 93	java/io/File
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokestatic 397	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   28: ifeq +393 -> 421
    //   31: new 70	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 399
    //   41: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 7
    //   46: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 139	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   55: invokestatic 160	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   58: ldc 162
    //   60: iconst_0
    //   61: invokevirtual 165	com/tencent/qphone/base/util/BaseApplication:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   64: astore 7
    //   66: aload 7
    //   68: invokevirtual 99	java/io/File:exists	()Z
    //   71: ifeq +350 -> 421
    //   74: aload 7
    //   76: invokevirtual 272	java/io/File:listFiles	()[Ljava/io/File;
    //   79: astore 9
    //   81: aload 9
    //   83: arraylength
    //   84: istore_3
    //   85: iconst_0
    //   86: istore_2
    //   87: iload_2
    //   88: iload_3
    //   89: if_icmpge +332 -> 421
    //   92: aload 9
    //   94: iload_2
    //   95: aaload
    //   96: astore 10
    //   98: aload 10
    //   100: invokevirtual 275	java/io/File:isDirectory	()Z
    //   103: ifeq +6 -> 109
    //   106: goto +415 -> 521
    //   109: new 70	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   116: aload_0
    //   117: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 156
    //   122: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aload 10
    //   130: invokevirtual 291	java/io/File:getName	()Ljava/lang/String;
    //   133: invokevirtual 302	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   136: istore 4
    //   138: iload 4
    //   140: ifeq +367 -> 507
    //   143: aload 10
    //   145: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   148: invokestatic 283	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore 7
    //   153: new 70	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 401
    //   163: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 7
    //   168: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 139	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: aload 7
    //   180: invokevirtual 404	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   183: ifeq +259 -> 442
    //   186: ldc_w 406
    //   189: invokestatic 139	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   192: new 70	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   199: invokestatic 75	cooperation/qzone/QUA:a	()Ljava/lang/String;
    //   202: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 81
    //   207: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore 7
    //   215: aload 10
    //   217: invokevirtual 102	java/io/File:length	()J
    //   220: lstore 5
    //   222: new 70	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   229: aload 7
    //   231: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 266
    //   237: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: lload 5
    //   242: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   245: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 139	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   251: aload 7
    //   253: lload 5
    //   255: invokestatic 184	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   258: invokestatic 346	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +41 -> 302
    //   264: ldc_w 306
    //   267: iconst_2
    //   268: new 70	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 408
    //   278: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 410
    //   288: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: lload 5
    //   293: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 341	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_1
    //   303: invokestatic 412	cooperation/qzone/patch/QZonePatchService:a	(Ljava/lang/String;)V
    //   306: invokestatic 317	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   309: invokevirtual 321	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   312: checkcast 323	com/tencent/mobileqq/app/QQAppInterface
    //   315: ldc_w 306
    //   318: bipush 10
    //   320: aconst_null
    //   321: invokestatic 414	cooperation/qzone/patch/QZonePatchService:a	(ILjava/lang/String;)I
    //   324: new 70	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 416
    //   334: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_0
    //   338: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 410
    //   344: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: lload 5
    //   349: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: iconst_1
    //   356: invokestatic 332	java/lang/System:currentTimeMillis	()J
    //   359: invokestatic 337	cooperation/qzone/QZoneHelper:a	(Lmqq/app/AppRuntime;Ljava/lang/String;ILjava/lang/String;IJ)V
    //   362: ldc_w 306
    //   365: iconst_2
    //   366: new 70	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 418
    //   376: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: bipush 10
    //   381: aconst_null
    //   382: invokestatic 414	cooperation/qzone/patch/QZonePatchService:a	(ILjava/lang/String;)I
    //   385: invokevirtual 421	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 341	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: invokestatic 160	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   397: aload 10
    //   399: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   402: aload_0
    //   403: invokestatic 379	cooperation/qzone/patch/QZonePatchService:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   406: goto +115 -> 521
    //   409: astore_0
    //   410: ldc_w 306
    //   413: iconst_1
    //   414: aload_0
    //   415: invokestatic 309	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   418: invokestatic 313	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: return
    //   422: astore 8
    //   424: aconst_null
    //   425: astore 7
    //   427: ldc_w 306
    //   430: iconst_1
    //   431: aload 8
    //   433: invokestatic 309	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   436: invokestatic 313	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: goto -262 -> 177
    //   442: ldc_w 423
    //   445: invokestatic 139	cooperation/qzone/patch/QZonePatchService:b	(Ljava/lang/String;)V
    //   448: invokestatic 346	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +47 -> 498
    //   454: ldc_w 306
    //   457: iconst_2
    //   458: new 70	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   465: ldc_w 425
    //   468: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload 7
    //   473: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 427
    //   479: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_0
    //   483: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 429
    //   489: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 341	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload 10
    //   500: invokevirtual 278	java/io/File:delete	()Z
    //   503: pop
    //   504: goto +17 -> 521
    //   507: aload 10
    //   509: invokevirtual 278	java/io/File:delete	()Z
    //   512: pop
    //   513: goto +8 -> 521
    //   516: astore 8
    //   518: goto -91 -> 427
    //   521: iload_2
    //   522: iconst_1
    //   523: iadd
    //   524: istore_2
    //   525: goto -438 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	paramString1	String
    //   0	528	1	paramString2	String
    //   86	439	2	i	int
    //   84	6	3	j	int
    //   136	3	4	bool	boolean
    //   220	128	5	l	long
    //   4	468	7	localObject	Object
    //   422	10	8	localException1	Exception
    //   516	1	8	localException2	Exception
    //   79	14	9	arrayOfFile	File[]
    //   96	412	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   31	85	409	java/lang/Error
    //   98	106	409	java/lang/Error
    //   109	138	409	java/lang/Error
    //   143	153	409	java/lang/Error
    //   153	177	409	java/lang/Error
    //   177	302	409	java/lang/Error
    //   302	406	409	java/lang/Error
    //   427	439	409	java/lang/Error
    //   442	498	409	java/lang/Error
    //   498	504	409	java/lang/Error
    //   507	513	409	java/lang/Error
    //   143	153	422	java/lang/Exception
    //   153	177	516	java/lang/Exception
  }
  
  private static void e()
  {
    c();
    d();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "isPatchEnable", 1) == 0) {
      return;
    }
    ThreadManager.postDownLoadTask(new amwt(this, paramString1, paramString2), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.patch.QZonePatchService
 * JD-Core Version:    0.7.0.1
 */