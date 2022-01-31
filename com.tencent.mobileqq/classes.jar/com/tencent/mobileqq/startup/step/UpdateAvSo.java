package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import apkr;
import azmy;
import azri;
import bdcd;
import bflq;
import bflr;
import bhpp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import lnz;
import mww;

public class UpdateAvSo
  extends Step
{
  public static long a()
  {
    long l = SystemClock.uptimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 0);
    String str = "first_av_lauch_" + AppSetting.g();
    if (localSharedPreferences.getLong(str, 0L) != 0L) {
      return 0L;
    }
    localSharedPreferences.edit().putLong(str, l).commit();
    return l - b();
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVModuleExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/txlib/";
  }
  
  public static String a(String paramString)
  {
    File localFile = new File(paramString);
    try
    {
      String str1 = bhpp.a(localFile);
      paramString = "[" + paramString + "], exists[" + localFile.exists();
      return paramString + "], md5[" + str1 + "]";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "Exception";
      }
    }
  }
  
  static void a()
  {
    if (!BaseApplicationImpl.isCurrentVersionFirstLaunch) {
      return;
    }
    if (lnz.f() <= 2) {}
    for (int i = 1;; i = 0)
    {
      String str = a();
      Object localObject1;
      if (i != 0)
      {
        localObject1 = new String[3];
        localObject1[0] = "libTcVpxDec-armeabi.so";
        localObject1[1] = "libTcVpxEnc-armeabi.so";
        localObject1[2] = "libtraeimp-armeabi.so";
      }
      for (;;)
      {
        Object localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(Arrays.asList((Object[])localObject1));
        ((ArrayList)localObject2).addAll(Arrays.asList(new String[] { "libSDKCommon.so", "libVideoCtrl.so", "libtraeimp-qq.so", "libqav_graphics.so", "libqav_gaudio_engine.so", "libqav_utils.so", "libqav_media_engine.so" }));
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = str + (String)localObject2;
          try
          {
            File localFile = new File((String)localObject2);
            boolean bool1 = localFile.exists();
            boolean bool2 = localFile.delete();
            QLog.w("AVModuleExtract", 1, "delSoFromCache, soPath[" + (String)localObject2 + "], exist[" + bool1 + "], ret[" + bool2 + "]");
          }
          catch (Exception localException) {}
        }
        break;
        localObject1 = new String[5];
        localObject1[0] = "libTcHevcDec.so";
        localObject1[1] = "libTcHevcDec2.so";
        localObject1[2] = "libTcHevcEnc.so";
        localObject1[3] = "libtraeopus-armeabi.so";
        localObject1[4] = "libtraeopus-armeabi-v7a.so";
      }
    }
  }
  
  public static void a(long paramLong)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    b(paramLong, localBaseApplicationImpl, "SDKCommon", true);
    b(paramLong, localBaseApplicationImpl, "VideoCtrl", true);
    b(paramLong, localBaseApplicationImpl, "traeimp-qq", true);
    b(paramLong, localBaseApplicationImpl, "qav_graphics", true);
    b(paramLong, localBaseApplicationImpl, "qav_gaudio_engine", true);
    b(paramLong, localBaseApplicationImpl, "qav_utils", true);
    b(paramLong, localBaseApplicationImpl, "qav_media_engine", true);
  }
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    LoadExtResult localLoadExtResult = azmy.a().a("TcHevcDec");
    long l2 = System.currentTimeMillis();
    QLog.w("AVModuleExtract", 1, "LoadCommonSharpSo costs: " + (l2 - l1) + ", loadSync result: " + localLoadExtResult);
    return (localLoadExtResult != null) && (localLoadExtResult.isSucc());
  }
  
  public static boolean a(long paramLong, Context paramContext, String paramString, boolean paramBoolean)
  {
    QLog.d("AVModuleExtract", 1, "LoadExtractedSo begin, libName[" + paramString + "], seq[" + paramLong + "]");
    localObject1 = null;
    bool2 = false;
    bool1 = bool2;
    try
    {
      str1 = paramContext.getFilesDir().getParent() + "/txlib/" + c(paramString);
      bool1 = bool2;
      localObject1 = str1;
      bool2 = new File(str1).exists();
      bool1 = bool2;
      localObject1 = str1;
      if (AudioHelper.e())
      {
        bool1 = bool2;
        localObject1 = str1;
        QLog.w("AVModuleExtract", 1, "LoadExtractedSo, strLibPath[" + str1 + "], exists[" + bool2 + "], seq[" + paramLong + "]");
      }
      str3 = "";
      localObject6 = str1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str1;
        label205:
        label252:
        String str3 = QLog.getStackTraceString(localException1);
        label343:
        QLog.w("AVModuleExtract", 1, "LoadExtractedSo Exception, seq[" + paramLong + "]", localException1);
        bool2 = bool1;
        localObject6 = localObject1;
      }
    }
    try
    {
      System.load((String)localObject6);
      paramBoolean = true;
      str1 = "";
      localObject1 = "";
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      localObject1 = QLog.getStackTraceString(localUnsatisfiedLinkError2);
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo, Exception, seq[" + paramLong + "]", localUnsatisfiedLinkError2);
      localObject2 = new File((String)localObject6);
      if (!((File)localObject2).exists()) {
        break label924;
      }
      bool1 = ((File)localObject2).delete();
      if (!QLog.isDevelopLevel()) {
        break label849;
      }
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo, del file ret[" + bool1 + "], seq[" + paramLong + "]");
      for (;;)
      {
        for (;;)
        {
          paramBoolean = b(paramLong, paramContext, paramString, paramBoolean);
          QLog.w("AVModuleExtract", 1, "LoadExtractedSo, re extractLibraryFromAssert, bret[" + paramBoolean + "], seq[" + paramLong + "]");
          try
          {
            System.load((String)localObject6);
            localObject4 = "";
            localObject2 = localObject1;
            paramBoolean = true;
            localObject1 = localObject4;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
          {
            localObject3 = QLog.getStackTraceString(localUnsatisfiedLinkError1);
            QLog.w("AVModuleExtract", 1, "LoadExtractedSo Exception, seq[" + paramLong + "]", (Throwable)localObject4);
            localObject4 = localObject1;
            paramBoolean = false;
            localObject1 = localObject3;
            localObject3 = localObject4;
          }
        }
        QLog.w("AVModuleExtract", 1, "LoadExtractedSo file not exists, seq[" + paramLong + "]");
      }
      break label205;
      Object localObject4 = "";
      break label252;
    }
    if (!paramBoolean)
    {
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo,  system way. seq[" + paramLong + "]");
      try
      {
        System.loadLibrary(paramString);
        str2 = "";
        paramBoolean = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
      {
        for (;;)
        {
          String str2;
          boolean bool3;
          String str4;
          long l1;
          Object localObject5;
          localObject4 = QLog.getStackTraceString(localUnsatisfiedLinkError3);
          QLog.w("AVModuleExtract", 1, "LoadExtractedSo Exception, seq[" + paramLong + "]", localUnsatisfiedLinkError3);
        }
      }
      if (!paramBoolean)
      {
        bool3 = false;
        str4 = "";
        l1 = 0L;
        localObject5 = str4;
        bool1 = bool3;
      }
      try
      {
        File localFile = new File((String)localObject6);
        localObject5 = str4;
        bool1 = bool3;
        bool3 = localFile.exists();
        localObject5 = str4;
        bool1 = bool3;
        localObject6 = bflq.a(localFile);
        localObject5 = localObject6;
        bool1 = bool3;
        long l2 = localFile.length();
        l1 = l2;
        bool1 = bool3;
        localObject5 = localObject6;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        Object localObject3;
        break label343;
      }
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo,  failed. seq[" + paramLong + "], msg1[" + str3 + "], msg2[" + str1 + "], msg3[" + (String)localObject1 + "], msg4[" + str2 + "]");
      localObject6 = new HashMap();
      ((HashMap)localObject6).put("soname", paramString);
      ((HashMap)localObject6).put("existFirst", String.valueOf(bool2));
      ((HashMap)localObject6).put("existLast", String.valueOf(bool1));
      ((HashMap)localObject6).put("md5", localObject5);
      ((HashMap)localObject6).put("fileLength", String.valueOf(l1));
      ((HashMap)localObject6).put("msg1", b(str3));
      ((HashMap)localObject6).put("msg2", b(str1));
      ((HashMap)localObject6).put("msg3", b((String)localObject1));
      ((HashMap)localObject6).put("msg4", b(str2));
      ((HashMap)localObject6).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject6).put("man", b(Build.MANUFACTURER));
      ((HashMap)localObject6).put("mod", b(Build.MODEL));
      ((HashMap)localObject6).put("qq_ver", String.valueOf(mww.b()));
      azri.a(paramContext).a("", "AV_LOAD_SO_FAILED", false, 0L, 0L, (HashMap)localObject6, "");
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo end , result[" + paramBoolean + "], libName[" + paramString + "], seq[" + paramLong + "]");
      return paramBoolean;
    }
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    if (lnz.f() <= 2) {
      if ((!a(paramContext, "traeimp-armeabi")) || (!a(paramContext, "TcVpxDec-armeabi")) || (!a(paramContext, "TcVpxEnc-armeabi"))) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!paramBoolean.booleanValue()) {
          break;
        }
      } while (a(true));
      return false;
    } while (b(true));
    return false;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/";; paramContext = paramContext.getApplicationInfo().dataDir + "/lib/")
    {
      paramContext = new File(paramContext + c(paramString));
      File localFile = new File(a() + c(paramString));
      if ((!paramContext.exists()) && (!localFile.exists())) {
        break;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVModuleExtract", 2, "fail to find so:" + paramString);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(0L, paramContext, paramString, paramBoolean);
  }
  
  private static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = a() + "/" + paramString1;
    File localFile = new File(str);
    if (!localFile.exists())
    {
      QLog.e("AVModuleExtract", 1, "soFile is not exist.");
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("AVModuleExtract", 1, paramString1 + " with empty md5. need check predownload config again!!");
      return false;
    }
    str = bflr.a(str);
    if (QLog.isColorLevel()) {
      QLog.d("AVModuleExtract", 2, "check video so md5: " + paramString1 + " md5Str:" + str + ", xmlMd5: " + paramString2);
    }
    if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2))) {
      return true;
    }
    if (paramBoolean) {
      localFile.delete();
    }
    QLog.e("AVModuleExtract", 4, paramString1 + " is incomplete!!");
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    QavSoData localQavSoData = (QavSoData)apkr.a(QavSoData.class);
    boolean bool = true;
    if (!a("libTcHevcEnc.so", localQavSoData.m_TcHevcEnc, paramBoolean)) {
      bool = false;
    }
    if (!a("libTcHevcDec.so", localQavSoData.m_TcHevcDec, paramBoolean)) {
      bool = false;
    }
    if (!a("libTcHevcDec2.so", localQavSoData.m_TcHevcDec2, paramBoolean)) {
      return false;
    }
    return bool;
  }
  
  private static long b()
  {
    long l2 = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 0).getLong("first_qq_lauch_" + AppSetting.g(), 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = BaseApplicationImpl.appStartTime;
    }
    return l1;
  }
  
  private static String b()
  {
    return "lib/armeabi/";
  }
  
  public static String b(String paramString)
  {
    return paramString.replace("=", "@1").replace("&", "@2").replace("|", "@3").replace("\"", "@6");
  }
  
  public static void b()
  {
    String str = a();
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("DecodeSo").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libTcHevcDec.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libTcHevcDec2.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libtraeimp-qq.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_graphics.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_gaudio_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_utils.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_media_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libSDKCommon.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libVideoCtrl.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libxplatform.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libc++_shared.so").toString()));
    str = bdcd.a(BaseApplicationImpl.sApplication);
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libc++_shared.so").toString()));
  }
  
  /* Error */
  public static boolean b(long paramLong, Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 13
    //   6: iconst_0
    //   7: istore 12
    //   9: aload_2
    //   10: ldc 24
    //   12: iconst_4
    //   13: invokevirtual 30	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   16: astore 33
    //   18: new 32	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   25: invokestatic 45	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   28: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokestatic 536	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 34
    //   42: new 32	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 538
    //   52: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 35
    //   64: new 32	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 540
    //   74: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokestatic 536	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   80: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore 36
    //   88: aload 33
    //   90: aload 35
    //   92: aload 36
    //   94: invokeinterface 544 3 0
    //   99: astore 15
    //   101: invokestatic 136	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   104: astore 37
    //   106: aload 37
    //   108: invokestatic 451	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: istore 14
    //   113: new 92	java/io/File
    //   116: dup
    //   117: new 32	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   124: aload 37
    //   126: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 32
    //   144: ldc 82
    //   146: iconst_1
    //   147: new 32	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 546
    //   157: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_3
    //   161: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 548
    //   167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 15
    //   172: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 550
    //   178: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 34
    //   183: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 552
    //   189: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload 4
    //   194: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: ldc_w 554
    //   200: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload 14
    //   205: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   208: ldc_w 556
    //   211: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 32
    //   216: invokevirtual 115	java/io/File:exists	()Z
    //   219: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   222: ldc_w 260
    //   225: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: lload_0
    //   229: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   232: ldc 122
    //   234: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iload 14
    //   245: ifeq +12 -> 257
    //   248: iconst_0
    //   249: istore 4
    //   251: ldc 2
    //   253: monitorexit
    //   254: iload 4
    //   256: ireturn
    //   257: aload 15
    //   259: aload 34
    //   261: invokestatic 560	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   264: ifeq +17 -> 281
    //   267: aload 32
    //   269: invokevirtual 115	java/io/File:exists	()Z
    //   272: ifeq +9 -> 281
    //   275: iconst_1
    //   276: istore 4
    //   278: goto -27 -> 251
    //   281: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   284: lstore 10
    //   286: aload 32
    //   288: invokevirtual 187	java/io/File:delete	()Z
    //   291: pop
    //   292: aload 32
    //   294: invokevirtual 115	java/io/File:exists	()Z
    //   297: ifne +1631 -> 1928
    //   300: iload 4
    //   302: ifeq +366 -> 668
    //   305: aload_2
    //   306: aload 37
    //   308: ldc_w 562
    //   311: aload_3
    //   312: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokestatic 565	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   318: istore 5
    //   320: aload 32
    //   322: invokevirtual 115	java/io/File:exists	()Z
    //   325: ifeq +285 -> 610
    //   328: iload 5
    //   330: ifeq +136 -> 466
    //   333: aload 32
    //   335: invokevirtual 187	java/io/File:delete	()Z
    //   338: pop
    //   339: iconst_0
    //   340: istore 4
    //   342: ldc 82
    //   344: iconst_1
    //   345: new 32	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 567
    //   355: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload 5
    //   360: invokevirtual 570	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: ldc_w 260
    //   366: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: lload_0
    //   370: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: ldc 122
    //   375: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   387: lstore 6
    //   389: ldc 82
    //   391: iconst_1
    //   392: new 32	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 572
    //   402: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_3
    //   406: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 574
    //   412: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: lload 6
    //   417: lload 10
    //   419: lsub
    //   420: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   423: ldc 112
    //   425: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload 32
    //   430: invokevirtual 115	java/io/File:exists	()Z
    //   433: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   436: ldc_w 260
    //   439: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: lload_0
    //   443: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   446: ldc 122
    //   448: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: goto -206 -> 251
    //   460: astore_2
    //   461: ldc 2
    //   463: monitorexit
    //   464: aload_2
    //   465: athrow
    //   466: aload 34
    //   468: invokestatic 451	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   471: ifne +33 -> 504
    //   474: aload 34
    //   476: new 32	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 576
    //   486: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokestatic 536	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   492: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 560	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   501: ifeq +84 -> 585
    //   504: aload 33
    //   506: invokeinterface 58 1 0
    //   511: aload 35
    //   513: aload 36
    //   515: invokeinterface 580 3 0
    //   520: invokeinterface 68 1 0
    //   525: pop
    //   526: ldc 82
    //   528: iconst_1
    //   529: new 32	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 582
    //   539: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 35
    //   544: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc_w 584
    //   550: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 34
    //   555: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 260
    //   561: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: lload_0
    //   565: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   568: ldc 122
    //   570: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: iconst_1
    //   580: istore 4
    //   582: goto -198 -> 384
    //   585: aload 33
    //   587: invokeinterface 58 1 0
    //   592: aload 35
    //   594: aload 34
    //   596: invokeinterface 580 3 0
    //   601: invokeinterface 68 1 0
    //   606: pop
    //   607: goto -81 -> 526
    //   610: ldc 82
    //   612: iconst_1
    //   613: new 32	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   620: ldc_w 586
    //   623: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: iload 5
    //   628: invokevirtual 570	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc 112
    //   633: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iconst_0
    //   637: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: ldc_w 260
    //   643: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: lload_0
    //   647: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   650: ldc 122
    //   652: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: iload 12
    //   663: istore 4
    //   665: goto -281 -> 384
    //   668: aconst_null
    //   669: astore 31
    //   671: aconst_null
    //   672: astore 24
    //   674: aconst_null
    //   675: astore 25
    //   677: aconst_null
    //   678: astore 26
    //   680: aconst_null
    //   681: astore 23
    //   683: aconst_null
    //   684: astore 30
    //   686: aconst_null
    //   687: astore 15
    //   689: aconst_null
    //   690: astore 16
    //   692: aconst_null
    //   693: astore 28
    //   695: aconst_null
    //   696: astore 29
    //   698: aconst_null
    //   699: astore 27
    //   701: aload 28
    //   703: astore 20
    //   705: aload 23
    //   707: astore 18
    //   709: aload 24
    //   711: astore 22
    //   713: aload 29
    //   715: astore 19
    //   717: aload 30
    //   719: astore 17
    //   721: aload 25
    //   723: astore 21
    //   725: new 92	java/io/File
    //   728: dup
    //   729: aload 37
    //   731: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   734: astore 38
    //   736: aload 28
    //   738: astore 20
    //   740: aload 23
    //   742: astore 18
    //   744: aload 24
    //   746: astore 22
    //   748: aload 29
    //   750: astore 19
    //   752: aload 30
    //   754: astore 17
    //   756: aload 25
    //   758: astore 21
    //   760: aload 38
    //   762: invokevirtual 115	java/io/File:exists	()Z
    //   765: ifne +47 -> 812
    //   768: aload 28
    //   770: astore 20
    //   772: aload 23
    //   774: astore 18
    //   776: aload 24
    //   778: astore 22
    //   780: aload 29
    //   782: astore 19
    //   784: aload 30
    //   786: astore 17
    //   788: aload 25
    //   790: astore 21
    //   792: aload 38
    //   794: invokevirtual 589	java/io/File:mkdir	()Z
    //   797: istore 4
    //   799: iload 13
    //   801: istore 12
    //   803: aload 31
    //   805: astore 17
    //   807: iload 4
    //   809: ifeq +625 -> 1434
    //   812: aload 28
    //   814: astore 20
    //   816: aload 23
    //   818: astore 18
    //   820: aload 24
    //   822: astore 22
    //   824: aload 29
    //   826: astore 19
    //   828: aload 30
    //   830: astore 17
    //   832: aload 25
    //   834: astore 21
    //   836: aload_2
    //   837: invokevirtual 593	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   840: new 32	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   847: invokestatic 595	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   850: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload_3
    //   854: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   857: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokevirtual 601	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   866: astore 15
    //   868: aload 27
    //   870: astore 16
    //   872: aload 26
    //   874: astore_2
    //   875: aload 15
    //   877: ifnull +58 -> 935
    //   880: aload 16
    //   882: astore 20
    //   884: aload 15
    //   886: astore 18
    //   888: aload 24
    //   890: astore 22
    //   892: aload 16
    //   894: astore 19
    //   896: aload 15
    //   898: astore 17
    //   900: aload 25
    //   902: astore 21
    //   904: new 603	java/io/FileOutputStream
    //   907: dup
    //   908: new 32	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   915: aload 37
    //   917: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload_3
    //   921: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   924: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: iconst_1
    //   931: invokespecial 606	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   934: astore_2
    //   935: lconst_0
    //   936: lstore 6
    //   938: aload 16
    //   940: astore 20
    //   942: aload 15
    //   944: astore 18
    //   946: aload_2
    //   947: astore 22
    //   949: aload 16
    //   951: astore 19
    //   953: aload 15
    //   955: astore 17
    //   957: aload_2
    //   958: astore 21
    //   960: sipush 8192
    //   963: newarray byte
    //   965: astore 23
    //   967: lload 6
    //   969: lstore 8
    //   971: aload 15
    //   973: ifnull +234 -> 1207
    //   976: aload 16
    //   978: astore 20
    //   980: aload 15
    //   982: astore 18
    //   984: aload_2
    //   985: astore 22
    //   987: aload 16
    //   989: astore 19
    //   991: aload 15
    //   993: astore 17
    //   995: aload_2
    //   996: astore 21
    //   998: aload 15
    //   1000: aload 23
    //   1002: iconst_0
    //   1003: aload 23
    //   1005: arraylength
    //   1006: invokevirtual 612	java/io/InputStream:read	([BII)I
    //   1009: istore 5
    //   1011: lload 6
    //   1013: lstore 8
    //   1015: iload 5
    //   1017: iconst_m1
    //   1018: if_icmpeq +189 -> 1207
    //   1021: aload 16
    //   1023: astore 20
    //   1025: aload 15
    //   1027: astore 18
    //   1029: aload_2
    //   1030: astore 22
    //   1032: aload 16
    //   1034: astore 19
    //   1036: aload 15
    //   1038: astore 17
    //   1040: aload_2
    //   1041: astore 21
    //   1043: aload_2
    //   1044: aload 23
    //   1046: iconst_0
    //   1047: iload 5
    //   1049: invokevirtual 618	java/io/OutputStream:write	([BII)V
    //   1052: lload 6
    //   1054: iload 5
    //   1056: i2l
    //   1057: ladd
    //   1058: lstore 6
    //   1060: goto -93 -> 967
    //   1063: astore 15
    //   1065: aconst_null
    //   1066: astore 17
    //   1068: aconst_null
    //   1069: astore 18
    //   1071: aload 28
    //   1073: astore 20
    //   1075: aload 24
    //   1077: astore 22
    //   1079: aload 29
    //   1081: astore 19
    //   1083: aload 25
    //   1085: astore 21
    //   1087: aload_2
    //   1088: invokevirtual 593	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1091: new 32	java/lang/StringBuilder
    //   1094: dup
    //   1095: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1098: invokestatic 595	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   1101: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: aload_3
    //   1105: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1108: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: ldc_w 620
    //   1114: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokevirtual 601	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1123: astore 23
    //   1125: aload 27
    //   1127: astore 16
    //   1129: aload 23
    //   1131: astore 15
    //   1133: aload 23
    //   1135: ifnull -263 -> 872
    //   1138: aload 28
    //   1140: astore 20
    //   1142: aload 23
    //   1144: astore 18
    //   1146: aload 24
    //   1148: astore 22
    //   1150: aload 29
    //   1152: astore 19
    //   1154: aload 23
    //   1156: astore 17
    //   1158: aload 25
    //   1160: astore 21
    //   1162: aload_2
    //   1163: invokevirtual 593	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1166: new 32	java/lang/StringBuilder
    //   1169: dup
    //   1170: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1173: invokestatic 595	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   1176: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: aload_3
    //   1180: invokestatic 266	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1183: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: ldc_w 622
    //   1189: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1195: invokevirtual 601	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1198: astore 16
    //   1200: aload 23
    //   1202: astore 15
    //   1204: goto -332 -> 872
    //   1207: aload 16
    //   1209: ifnull +86 -> 1295
    //   1212: aload 16
    //   1214: astore 20
    //   1216: aload 15
    //   1218: astore 18
    //   1220: aload_2
    //   1221: astore 22
    //   1223: aload 16
    //   1225: astore 19
    //   1227: aload 15
    //   1229: astore 17
    //   1231: aload_2
    //   1232: astore 21
    //   1234: aload 16
    //   1236: aload 23
    //   1238: iconst_0
    //   1239: aload 23
    //   1241: arraylength
    //   1242: invokevirtual 612	java/io/InputStream:read	([BII)I
    //   1245: istore 5
    //   1247: iload 5
    //   1249: iconst_m1
    //   1250: if_icmpeq +45 -> 1295
    //   1253: aload 16
    //   1255: astore 20
    //   1257: aload 15
    //   1259: astore 18
    //   1261: aload_2
    //   1262: astore 22
    //   1264: aload 16
    //   1266: astore 19
    //   1268: aload 15
    //   1270: astore 17
    //   1272: aload_2
    //   1273: astore 21
    //   1275: aload_2
    //   1276: aload 23
    //   1278: iconst_0
    //   1279: iload 5
    //   1281: invokevirtual 618	java/io/OutputStream:write	([BII)V
    //   1284: lload 8
    //   1286: iload 5
    //   1288: i2l
    //   1289: ladd
    //   1290: lstore 8
    //   1292: goto -85 -> 1207
    //   1295: aload 16
    //   1297: astore 20
    //   1299: aload 15
    //   1301: astore 18
    //   1303: aload_2
    //   1304: astore 22
    //   1306: aload 16
    //   1308: astore 19
    //   1310: aload 15
    //   1312: astore 17
    //   1314: aload_2
    //   1315: astore 21
    //   1317: aload 32
    //   1319: invokevirtual 115	java/io/File:exists	()Z
    //   1322: ifeq +510 -> 1832
    //   1325: aload 16
    //   1327: astore 20
    //   1329: aload 15
    //   1331: astore 18
    //   1333: aload_2
    //   1334: astore 22
    //   1336: aload 16
    //   1338: astore 19
    //   1340: aload 15
    //   1342: astore 17
    //   1344: aload_2
    //   1345: astore 21
    //   1347: lload 8
    //   1349: aload 32
    //   1351: invokevirtual 287	java/io/File:length	()J
    //   1354: lcmp
    //   1355: ifeq +128 -> 1483
    //   1358: aload 16
    //   1360: astore 20
    //   1362: aload 15
    //   1364: astore 18
    //   1366: aload_2
    //   1367: astore 22
    //   1369: aload 16
    //   1371: astore 19
    //   1373: aload 15
    //   1375: astore 17
    //   1377: aload_2
    //   1378: astore 21
    //   1380: aload 32
    //   1382: invokevirtual 187	java/io/File:delete	()Z
    //   1385: pop
    //   1386: aload 16
    //   1388: astore 19
    //   1390: aload 15
    //   1392: astore 17
    //   1394: aload_2
    //   1395: astore 21
    //   1397: ldc 82
    //   1399: iconst_1
    //   1400: new 32	java/lang/StringBuilder
    //   1403: dup
    //   1404: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1407: ldc_w 624
    //   1410: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: lload_0
    //   1414: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1417: ldc 122
    //   1419: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1425: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1428: iconst_0
    //   1429: istore 12
    //   1431: aload_2
    //   1432: astore 17
    //   1434: aload 17
    //   1436: ifnull +8 -> 1444
    //   1439: aload 17
    //   1441: invokevirtual 627	java/io/OutputStream:close	()V
    //   1444: aload 15
    //   1446: ifnull +8 -> 1454
    //   1449: aload 15
    //   1451: invokevirtual 628	java/io/InputStream:close	()V
    //   1454: iload 12
    //   1456: istore 4
    //   1458: aload 16
    //   1460: ifnull -1076 -> 384
    //   1463: aload 16
    //   1465: invokevirtual 628	java/io/InputStream:close	()V
    //   1468: iload 12
    //   1470: istore 4
    //   1472: goto -1088 -> 384
    //   1475: astore_2
    //   1476: iload 12
    //   1478: istore 4
    //   1480: goto -1096 -> 384
    //   1483: aload 16
    //   1485: astore 20
    //   1487: aload 15
    //   1489: astore 18
    //   1491: aload_2
    //   1492: astore 22
    //   1494: aload 16
    //   1496: astore 19
    //   1498: aload 15
    //   1500: astore 17
    //   1502: aload_2
    //   1503: astore 21
    //   1505: aload 34
    //   1507: invokestatic 451	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1510: ifne +36 -> 1546
    //   1513: aload 16
    //   1515: astore 20
    //   1517: aload 15
    //   1519: astore 18
    //   1521: aload_2
    //   1522: astore 22
    //   1524: aload 16
    //   1526: astore 19
    //   1528: aload 15
    //   1530: astore 17
    //   1532: aload_2
    //   1533: astore 21
    //   1535: aload 34
    //   1537: ldc_w 576
    //   1540: invokestatic 560	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1543: ifeq +131 -> 1674
    //   1546: aload 16
    //   1548: astore 20
    //   1550: aload 15
    //   1552: astore 18
    //   1554: aload_2
    //   1555: astore 22
    //   1557: aload 16
    //   1559: astore 19
    //   1561: aload 15
    //   1563: astore 17
    //   1565: aload_2
    //   1566: astore 21
    //   1568: aload 33
    //   1570: invokeinterface 58 1 0
    //   1575: aload 35
    //   1577: aload 36
    //   1579: invokeinterface 580 3 0
    //   1584: invokeinterface 68 1 0
    //   1589: pop
    //   1590: aload 16
    //   1592: astore 20
    //   1594: aload 15
    //   1596: astore 18
    //   1598: aload_2
    //   1599: astore 22
    //   1601: aload 16
    //   1603: astore 19
    //   1605: aload 15
    //   1607: astore 17
    //   1609: aload_2
    //   1610: astore 21
    //   1612: ldc 82
    //   1614: iconst_1
    //   1615: new 32	java/lang/StringBuilder
    //   1618: dup
    //   1619: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1622: ldc_w 630
    //   1625: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: aload 35
    //   1630: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: ldc_w 584
    //   1636: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: aload 34
    //   1641: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: ldc_w 260
    //   1647: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: lload_0
    //   1651: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1654: ldc 122
    //   1656: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1662: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1665: iconst_1
    //   1666: istore 12
    //   1668: aload_2
    //   1669: astore 17
    //   1671: goto -237 -> 1434
    //   1674: aload 16
    //   1676: astore 20
    //   1678: aload 15
    //   1680: astore 18
    //   1682: aload_2
    //   1683: astore 22
    //   1685: aload 16
    //   1687: astore 19
    //   1689: aload 15
    //   1691: astore 17
    //   1693: aload_2
    //   1694: astore 21
    //   1696: aload 33
    //   1698: invokeinterface 58 1 0
    //   1703: aload 35
    //   1705: aload 34
    //   1707: invokeinterface 580 3 0
    //   1712: invokeinterface 68 1 0
    //   1717: pop
    //   1718: goto -128 -> 1590
    //   1721: astore 17
    //   1723: aload 22
    //   1725: astore_2
    //   1726: aload 18
    //   1728: astore 15
    //   1730: aload 20
    //   1732: astore 16
    //   1734: aload 17
    //   1736: astore 18
    //   1738: iconst_0
    //   1739: istore 12
    //   1741: aload 16
    //   1743: astore 19
    //   1745: aload 15
    //   1747: astore 17
    //   1749: aload_2
    //   1750: astore 21
    //   1752: ldc 82
    //   1754: iconst_1
    //   1755: new 32	java/lang/StringBuilder
    //   1758: dup
    //   1759: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1762: ldc_w 632
    //   1765: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: lload_0
    //   1769: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1772: ldc 122
    //   1774: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1780: aload 18
    //   1782: invokestatic 384	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1785: aload_2
    //   1786: ifnull +7 -> 1793
    //   1789: aload_2
    //   1790: invokevirtual 627	java/io/OutputStream:close	()V
    //   1793: aload 15
    //   1795: ifnull +8 -> 1803
    //   1798: aload 15
    //   1800: invokevirtual 628	java/io/InputStream:close	()V
    //   1803: iload 12
    //   1805: istore 4
    //   1807: aload 16
    //   1809: ifnull -1425 -> 384
    //   1812: aload 16
    //   1814: invokevirtual 628	java/io/InputStream:close	()V
    //   1817: iload 12
    //   1819: istore 4
    //   1821: goto -1437 -> 384
    //   1824: astore_2
    //   1825: iload 12
    //   1827: istore 4
    //   1829: goto -1445 -> 384
    //   1832: aload 16
    //   1834: astore 20
    //   1836: aload 15
    //   1838: astore 18
    //   1840: aload_2
    //   1841: astore 22
    //   1843: aload 16
    //   1845: astore 19
    //   1847: aload 15
    //   1849: astore 17
    //   1851: aload_2
    //   1852: astore 21
    //   1854: ldc 82
    //   1856: iconst_1
    //   1857: new 32	java/lang/StringBuilder
    //   1860: dup
    //   1861: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1864: ldc_w 634
    //   1867: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: lload_0
    //   1871: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1874: ldc 122
    //   1876: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1885: iload 13
    //   1887: istore 12
    //   1889: aload_2
    //   1890: astore 17
    //   1892: goto -458 -> 1434
    //   1895: astore_2
    //   1896: aload 21
    //   1898: ifnull +8 -> 1906
    //   1901: aload 21
    //   1903: invokevirtual 627	java/io/OutputStream:close	()V
    //   1906: aload 17
    //   1908: ifnull +8 -> 1916
    //   1911: aload 17
    //   1913: invokevirtual 628	java/io/InputStream:close	()V
    //   1916: aload 19
    //   1918: ifnull +8 -> 1926
    //   1921: aload 19
    //   1923: invokevirtual 628	java/io/InputStream:close	()V
    //   1926: aload_2
    //   1927: athrow
    //   1928: ldc 82
    //   1930: iconst_1
    //   1931: new 32	java/lang/StringBuilder
    //   1934: dup
    //   1935: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1938: ldc_w 636
    //   1941: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: lload_0
    //   1945: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1948: ldc 122
    //   1950: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1956: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1959: iload 12
    //   1961: istore 4
    //   1963: goto -1579 -> 384
    //   1966: astore_2
    //   1967: goto -523 -> 1444
    //   1970: astore_2
    //   1971: goto -517 -> 1454
    //   1974: astore_2
    //   1975: goto -182 -> 1793
    //   1978: astore_2
    //   1979: goto -176 -> 1803
    //   1982: astore_3
    //   1983: goto -77 -> 1906
    //   1986: astore_3
    //   1987: goto -71 -> 1916
    //   1990: astore_3
    //   1991: goto -65 -> 1926
    //   1994: astore 18
    //   1996: goto -258 -> 1738
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1999	0	paramLong	long
    //   0	1999	2	paramContext	Context
    //   0	1999	3	paramString	String
    //   0	1999	4	paramBoolean	boolean
    //   318	969	5	i	int
    //   387	672	6	l1	long
    //   969	379	8	l2	long
    //   284	134	10	l3	long
    //   7	1953	12	bool1	boolean
    //   4	1882	13	bool2	boolean
    //   111	133	14	bool3	boolean
    //   99	938	15	localObject1	Object
    //   1063	1	15	localFileNotFoundException	java.io.FileNotFoundException
    //   1131	717	15	localObject2	Object
    //   690	1154	16	localObject3	Object
    //   719	973	17	localObject4	Object
    //   1721	14	17	localIOException1	java.io.IOException
    //   1747	165	17	localObject5	Object
    //   707	1132	18	localObject6	Object
    //   1994	1	18	localIOException2	java.io.IOException
    //   715	1207	19	localObject7	Object
    //   703	1132	20	localObject8	Object
    //   723	1179	21	localObject9	Object
    //   711	1131	22	localObject10	Object
    //   681	596	23	localObject11	Object
    //   672	475	24	localObject12	Object
    //   675	484	25	localObject13	Object
    //   678	195	26	localObject14	Object
    //   699	427	27	localObject15	Object
    //   693	446	28	localObject16	Object
    //   696	455	29	localObject17	Object
    //   684	145	30	localObject18	Object
    //   669	135	31	localObject19	Object
    //   142	1239	32	localFile1	File
    //   16	1681	33	localSharedPreferences	SharedPreferences
    //   40	1666	34	str1	String
    //   62	1642	35	str2	String
    //   86	1492	36	str3	String
    //   104	812	37	str4	String
    //   734	59	38	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   9	243	460	finally
    //   257	275	460	finally
    //   281	300	460	finally
    //   305	328	460	finally
    //   333	339	460	finally
    //   342	384	460	finally
    //   384	457	460	finally
    //   466	504	460	finally
    //   504	526	460	finally
    //   526	579	460	finally
    //   585	607	460	finally
    //   610	661	460	finally
    //   1439	1444	460	finally
    //   1449	1454	460	finally
    //   1463	1468	460	finally
    //   1789	1793	460	finally
    //   1798	1803	460	finally
    //   1812	1817	460	finally
    //   1901	1906	460	finally
    //   1911	1916	460	finally
    //   1921	1926	460	finally
    //   1926	1928	460	finally
    //   1928	1959	460	finally
    //   836	868	1063	java/io/FileNotFoundException
    //   1463	1468	1475	java/io/IOException
    //   725	736	1721	java/io/IOException
    //   760	768	1721	java/io/IOException
    //   792	799	1721	java/io/IOException
    //   836	868	1721	java/io/IOException
    //   904	935	1721	java/io/IOException
    //   960	967	1721	java/io/IOException
    //   998	1011	1721	java/io/IOException
    //   1043	1052	1721	java/io/IOException
    //   1087	1125	1721	java/io/IOException
    //   1162	1200	1721	java/io/IOException
    //   1234	1247	1721	java/io/IOException
    //   1275	1284	1721	java/io/IOException
    //   1317	1325	1721	java/io/IOException
    //   1347	1358	1721	java/io/IOException
    //   1380	1386	1721	java/io/IOException
    //   1505	1513	1721	java/io/IOException
    //   1535	1546	1721	java/io/IOException
    //   1568	1590	1721	java/io/IOException
    //   1612	1665	1721	java/io/IOException
    //   1696	1718	1721	java/io/IOException
    //   1854	1885	1721	java/io/IOException
    //   1812	1817	1824	java/io/IOException
    //   725	736	1895	finally
    //   760	768	1895	finally
    //   792	799	1895	finally
    //   836	868	1895	finally
    //   904	935	1895	finally
    //   960	967	1895	finally
    //   998	1011	1895	finally
    //   1043	1052	1895	finally
    //   1087	1125	1895	finally
    //   1162	1200	1895	finally
    //   1234	1247	1895	finally
    //   1275	1284	1895	finally
    //   1317	1325	1895	finally
    //   1347	1358	1895	finally
    //   1380	1386	1895	finally
    //   1397	1428	1895	finally
    //   1505	1513	1895	finally
    //   1535	1546	1895	finally
    //   1568	1590	1895	finally
    //   1612	1665	1895	finally
    //   1696	1718	1895	finally
    //   1752	1785	1895	finally
    //   1854	1885	1895	finally
    //   1439	1444	1966	java/io/IOException
    //   1449	1454	1970	java/io/IOException
    //   1789	1793	1974	java/io/IOException
    //   1798	1803	1978	java/io/IOException
    //   1901	1906	1982	java/io/IOException
    //   1911	1916	1986	java/io/IOException
    //   1921	1926	1990	java/io/IOException
    //   1397	1428	1994	java/io/IOException
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = b(0L, paramContext, paramString, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static boolean b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    File localFile = new File(a() + "/libTcHevcEnc.so");
    boolean bool;
    if (!localFile.exists())
    {
      QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. libTcHevcEnc.so is not exist.");
      bool = false;
    }
    for (;;)
    {
      localFile = new File(a() + "/libTcHevcDec2.so");
      if (!localFile.exists()) {
        QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. libTcHevcDec2.so is not exist.");
      }
      do
      {
        return false;
        long l = localSharedPreferences.getLong("SP_QAV_HEVC_ENC_SO_FILE_SIZE", 0L);
        if (localFile.length() == l) {
          break label271;
        }
        QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. hevcEncSoFile size is not same. savedFileSize = " + l + ", realFileSize = " + localFile.length());
        if (paramBoolean) {
          localFile.delete();
        }
        bool = false;
        break;
        l = localSharedPreferences.getLong("SP_QAV_HEVC_DEC2_SO_FILE_SIZE", 0L);
        localFile.length();
        if (localFile.length() == l) {
          break label269;
        }
        QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. hevcDec2SoFile size is not same. savedFileSize = " + l + ", realFileSize = " + localFile.length());
      } while (!paramBoolean);
      localFile.delete();
      return false;
      label269:
      return bool;
      label271:
      bool = true;
    }
  }
  
  private static String c(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static void c()
  {
    Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AVModuleExtract", 2, "setQQFirstLauchTime:" + BaseApplicationImpl.appStartTime);
    }
    String str = "first_qq_lauch_" + AppSetting.g();
    localObject = ((SharedPreferences)localObject).edit();
    if (BaseApplicationImpl.appStartTime > 0L) {}
    for (long l = BaseApplicationImpl.appStartTime;; l = SystemClock.uptimeMillis())
    {
      ((SharedPreferences.Editor)localObject).putLong(str, l).commit();
      return;
    }
  }
  
  protected boolean doStep()
  {
    a();
    a(-1046L);
    c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateAvSo
 * JD-Core Version:    0.7.0.1
 */