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
import anow;
import axrl;
import baym;
import bdhu;
import bdhv;
import bfjx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import lmb;
import muf;

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
      String str1 = bfjx.a(localFile);
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
    if (lmb.f() <= 2) {}
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
        label201:
        label247:
        String str3 = QLog.getStackTraceString(localException1);
        label338:
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
        break label916;
      }
      bool1 = ((File)localObject2).delete();
      if (!QLog.isDevelopLevel()) {
        break label842;
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
      break label201;
      Object localObject4 = "";
      break label247;
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
        localObject6 = bdhu.a(localFile);
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
        break label338;
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
      ((HashMap)localObject6).put("qq_ver", String.valueOf(muf.b()));
      axrl.a(paramContext).a("", "AV_LOAD_SO_FAILED", false, 0L, 0L, (HashMap)localObject6, "");
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo end , result[" + paramBoolean + "], libName[" + paramString + "], seq[" + paramLong + "]");
      return paramBoolean;
    }
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    if (lmb.f() <= 2) {
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
    str = bdhv.a(str);
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
    QavSoData localQavSoData = (QavSoData)anow.a(QavSoData.class);
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
    str = baym.a(BaseApplicationImpl.sApplication);
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
    //   31: invokestatic 511	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 34
    //   42: new 32	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 513
    //   52: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 35
    //   64: new 32	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 515
    //   74: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokestatic 511	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   80: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore 36
    //   88: aload 33
    //   90: aload 35
    //   92: aload 36
    //   94: invokeinterface 519 3 0
    //   99: astore 15
    //   101: invokestatic 136	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   104: astore 37
    //   106: aload 37
    //   108: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: istore 14
    //   113: new 92	java/io/File
    //   116: dup
    //   117: new 32	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   124: aload 37
    //   126: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 32
    //   144: ldc 82
    //   146: iconst_1
    //   147: new 32	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 521
    //   157: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_3
    //   161: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 523
    //   167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 15
    //   172: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 525
    //   178: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 34
    //   183: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 527
    //   189: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload 4
    //   194: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: ldc_w 529
    //   200: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload 14
    //   205: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   208: ldc_w 531
    //   211: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 32
    //   216: invokevirtual 115	java/io/File:exists	()Z
    //   219: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   222: ldc 230
    //   224: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: lload_0
    //   228: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: ldc 122
    //   233: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: iload 14
    //   244: ifeq +12 -> 256
    //   247: iconst_0
    //   248: istore 4
    //   250: ldc 2
    //   252: monitorexit
    //   253: iload 4
    //   255: ireturn
    //   256: aload 15
    //   258: aload 34
    //   260: invokestatic 535	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   263: ifeq +17 -> 280
    //   266: aload 32
    //   268: invokevirtual 115	java/io/File:exists	()Z
    //   271: ifeq +9 -> 280
    //   274: iconst_1
    //   275: istore 4
    //   277: goto -27 -> 250
    //   280: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   283: lstore 10
    //   285: aload 32
    //   287: invokevirtual 187	java/io/File:delete	()Z
    //   290: pop
    //   291: aload 32
    //   293: invokevirtual 115	java/io/File:exists	()Z
    //   296: ifne +1626 -> 1922
    //   299: iload 4
    //   301: ifeq +362 -> 663
    //   304: aload_2
    //   305: aload 37
    //   307: ldc_w 537
    //   310: aload_3
    //   311: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   314: invokestatic 540	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   317: istore 5
    //   319: aload 32
    //   321: invokevirtual 115	java/io/File:exists	()Z
    //   324: ifeq +282 -> 606
    //   327: iload 5
    //   329: ifeq +134 -> 463
    //   332: aload 32
    //   334: invokevirtual 187	java/io/File:delete	()Z
    //   337: pop
    //   338: iconst_0
    //   339: istore 4
    //   341: ldc 82
    //   343: iconst_1
    //   344: new 32	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 542
    //   354: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload 5
    //   359: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 230
    //   364: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: lload_0
    //   368: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   371: ldc 122
    //   373: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   385: lstore 6
    //   387: ldc 82
    //   389: iconst_1
    //   390: new 32	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 547
    //   400: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_3
    //   404: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 549
    //   410: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: lload 6
    //   415: lload 10
    //   417: lsub
    //   418: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   421: ldc 112
    //   423: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 32
    //   428: invokevirtual 115	java/io/File:exists	()Z
    //   431: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   434: ldc 230
    //   436: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: lload_0
    //   440: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   443: ldc 122
    //   445: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: goto -204 -> 250
    //   457: astore_2
    //   458: ldc 2
    //   460: monitorexit
    //   461: aload_2
    //   462: athrow
    //   463: aload 34
    //   465: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   468: ifne +33 -> 501
    //   471: aload 34
    //   473: new 32	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 551
    //   483: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokestatic 511	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   489: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 535	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   498: ifeq +83 -> 581
    //   501: aload 33
    //   503: invokeinterface 58 1 0
    //   508: aload 35
    //   510: aload 36
    //   512: invokeinterface 555 3 0
    //   517: invokeinterface 68 1 0
    //   522: pop
    //   523: ldc 82
    //   525: iconst_1
    //   526: new 32	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 557
    //   536: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 35
    //   541: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 559
    //   547: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 34
    //   552: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc 230
    //   557: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: lload_0
    //   561: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   564: ldc 122
    //   566: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   575: iconst_1
    //   576: istore 4
    //   578: goto -196 -> 382
    //   581: aload 33
    //   583: invokeinterface 58 1 0
    //   588: aload 35
    //   590: aload 34
    //   592: invokeinterface 555 3 0
    //   597: invokeinterface 68 1 0
    //   602: pop
    //   603: goto -80 -> 523
    //   606: ldc 82
    //   608: iconst_1
    //   609: new 32	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   616: ldc_w 561
    //   619: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: iload 5
    //   624: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   627: ldc 112
    //   629: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: iconst_0
    //   633: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   636: ldc 230
    //   638: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: lload_0
    //   642: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   645: ldc 122
    //   647: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: iload 12
    //   658: istore 4
    //   660: goto -278 -> 382
    //   663: aconst_null
    //   664: astore 31
    //   666: aconst_null
    //   667: astore 24
    //   669: aconst_null
    //   670: astore 25
    //   672: aconst_null
    //   673: astore 26
    //   675: aconst_null
    //   676: astore 23
    //   678: aconst_null
    //   679: astore 30
    //   681: aconst_null
    //   682: astore 15
    //   684: aconst_null
    //   685: astore 16
    //   687: aconst_null
    //   688: astore 28
    //   690: aconst_null
    //   691: astore 29
    //   693: aconst_null
    //   694: astore 27
    //   696: aload 28
    //   698: astore 20
    //   700: aload 23
    //   702: astore 18
    //   704: aload 24
    //   706: astore 22
    //   708: aload 29
    //   710: astore 19
    //   712: aload 30
    //   714: astore 17
    //   716: aload 25
    //   718: astore 21
    //   720: new 92	java/io/File
    //   723: dup
    //   724: aload 37
    //   726: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   729: astore 38
    //   731: aload 28
    //   733: astore 20
    //   735: aload 23
    //   737: astore 18
    //   739: aload 24
    //   741: astore 22
    //   743: aload 29
    //   745: astore 19
    //   747: aload 30
    //   749: astore 17
    //   751: aload 25
    //   753: astore 21
    //   755: aload 38
    //   757: invokevirtual 115	java/io/File:exists	()Z
    //   760: ifne +47 -> 807
    //   763: aload 28
    //   765: astore 20
    //   767: aload 23
    //   769: astore 18
    //   771: aload 24
    //   773: astore 22
    //   775: aload 29
    //   777: astore 19
    //   779: aload 30
    //   781: astore 17
    //   783: aload 25
    //   785: astore 21
    //   787: aload 38
    //   789: invokevirtual 564	java/io/File:mkdir	()Z
    //   792: istore 4
    //   794: iload 13
    //   796: istore 12
    //   798: aload 31
    //   800: astore 17
    //   802: iload 4
    //   804: ifeq +625 -> 1429
    //   807: aload 28
    //   809: astore 20
    //   811: aload 23
    //   813: astore 18
    //   815: aload 24
    //   817: astore 22
    //   819: aload 29
    //   821: astore 19
    //   823: aload 30
    //   825: astore 17
    //   827: aload 25
    //   829: astore 21
    //   831: aload_2
    //   832: invokevirtual 568	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   835: new 32	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   842: invokestatic 570	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   845: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_3
    //   849: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   852: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokevirtual 576	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   861: astore 15
    //   863: aload 27
    //   865: astore 16
    //   867: aload 26
    //   869: astore_2
    //   870: aload 15
    //   872: ifnull +58 -> 930
    //   875: aload 16
    //   877: astore 20
    //   879: aload 15
    //   881: astore 18
    //   883: aload 24
    //   885: astore 22
    //   887: aload 16
    //   889: astore 19
    //   891: aload 15
    //   893: astore 17
    //   895: aload 25
    //   897: astore 21
    //   899: new 578	java/io/FileOutputStream
    //   902: dup
    //   903: new 32	java/lang/StringBuilder
    //   906: dup
    //   907: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   910: aload 37
    //   912: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload_3
    //   916: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   919: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: iconst_1
    //   926: invokespecial 581	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   929: astore_2
    //   930: lconst_0
    //   931: lstore 6
    //   933: aload 16
    //   935: astore 20
    //   937: aload 15
    //   939: astore 18
    //   941: aload_2
    //   942: astore 22
    //   944: aload 16
    //   946: astore 19
    //   948: aload 15
    //   950: astore 17
    //   952: aload_2
    //   953: astore 21
    //   955: sipush 8192
    //   958: newarray byte
    //   960: astore 23
    //   962: lload 6
    //   964: lstore 8
    //   966: aload 15
    //   968: ifnull +234 -> 1202
    //   971: aload 16
    //   973: astore 20
    //   975: aload 15
    //   977: astore 18
    //   979: aload_2
    //   980: astore 22
    //   982: aload 16
    //   984: astore 19
    //   986: aload 15
    //   988: astore 17
    //   990: aload_2
    //   991: astore 21
    //   993: aload 15
    //   995: aload 23
    //   997: iconst_0
    //   998: aload 23
    //   1000: arraylength
    //   1001: invokevirtual 587	java/io/InputStream:read	([BII)I
    //   1004: istore 5
    //   1006: lload 6
    //   1008: lstore 8
    //   1010: iload 5
    //   1012: iconst_m1
    //   1013: if_icmpeq +189 -> 1202
    //   1016: aload 16
    //   1018: astore 20
    //   1020: aload 15
    //   1022: astore 18
    //   1024: aload_2
    //   1025: astore 22
    //   1027: aload 16
    //   1029: astore 19
    //   1031: aload 15
    //   1033: astore 17
    //   1035: aload_2
    //   1036: astore 21
    //   1038: aload_2
    //   1039: aload 23
    //   1041: iconst_0
    //   1042: iload 5
    //   1044: invokevirtual 593	java/io/OutputStream:write	([BII)V
    //   1047: lload 6
    //   1049: iload 5
    //   1051: i2l
    //   1052: ladd
    //   1053: lstore 6
    //   1055: goto -93 -> 962
    //   1058: astore 15
    //   1060: aconst_null
    //   1061: astore 17
    //   1063: aconst_null
    //   1064: astore 18
    //   1066: aload 28
    //   1068: astore 20
    //   1070: aload 24
    //   1072: astore 22
    //   1074: aload 29
    //   1076: astore 19
    //   1078: aload 25
    //   1080: astore 21
    //   1082: aload_2
    //   1083: invokevirtual 568	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1086: new 32	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1093: invokestatic 570	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   1096: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload_3
    //   1100: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1103: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: ldc_w 595
    //   1109: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokevirtual 576	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1118: astore 23
    //   1120: aload 27
    //   1122: astore 16
    //   1124: aload 23
    //   1126: astore 15
    //   1128: aload 23
    //   1130: ifnull -263 -> 867
    //   1133: aload 28
    //   1135: astore 20
    //   1137: aload 23
    //   1139: astore 18
    //   1141: aload 24
    //   1143: astore 22
    //   1145: aload 29
    //   1147: astore 19
    //   1149: aload 23
    //   1151: astore 17
    //   1153: aload 25
    //   1155: astore 21
    //   1157: aload_2
    //   1158: invokevirtual 568	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1161: new 32	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1168: invokestatic 570	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   1171: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: aload_3
    //   1175: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1178: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: ldc_w 597
    //   1184: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: invokevirtual 576	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1193: astore 16
    //   1195: aload 23
    //   1197: astore 15
    //   1199: goto -332 -> 867
    //   1202: aload 16
    //   1204: ifnull +86 -> 1290
    //   1207: aload 16
    //   1209: astore 20
    //   1211: aload 15
    //   1213: astore 18
    //   1215: aload_2
    //   1216: astore 22
    //   1218: aload 16
    //   1220: astore 19
    //   1222: aload 15
    //   1224: astore 17
    //   1226: aload_2
    //   1227: astore 21
    //   1229: aload 16
    //   1231: aload 23
    //   1233: iconst_0
    //   1234: aload 23
    //   1236: arraylength
    //   1237: invokevirtual 587	java/io/InputStream:read	([BII)I
    //   1240: istore 5
    //   1242: iload 5
    //   1244: iconst_m1
    //   1245: if_icmpeq +45 -> 1290
    //   1248: aload 16
    //   1250: astore 20
    //   1252: aload 15
    //   1254: astore 18
    //   1256: aload_2
    //   1257: astore 22
    //   1259: aload 16
    //   1261: astore 19
    //   1263: aload 15
    //   1265: astore 17
    //   1267: aload_2
    //   1268: astore 21
    //   1270: aload_2
    //   1271: aload 23
    //   1273: iconst_0
    //   1274: iload 5
    //   1276: invokevirtual 593	java/io/OutputStream:write	([BII)V
    //   1279: lload 8
    //   1281: iload 5
    //   1283: i2l
    //   1284: ladd
    //   1285: lstore 8
    //   1287: goto -85 -> 1202
    //   1290: aload 16
    //   1292: astore 20
    //   1294: aload 15
    //   1296: astore 18
    //   1298: aload_2
    //   1299: astore 22
    //   1301: aload 16
    //   1303: astore 19
    //   1305: aload 15
    //   1307: astore 17
    //   1309: aload_2
    //   1310: astore 21
    //   1312: aload 32
    //   1314: invokevirtual 115	java/io/File:exists	()Z
    //   1317: ifeq +509 -> 1826
    //   1320: aload 16
    //   1322: astore 20
    //   1324: aload 15
    //   1326: astore 18
    //   1328: aload_2
    //   1329: astore 22
    //   1331: aload 16
    //   1333: astore 19
    //   1335: aload 15
    //   1337: astore 17
    //   1339: aload_2
    //   1340: astore 21
    //   1342: lload 8
    //   1344: aload 32
    //   1346: invokevirtual 262	java/io/File:length	()J
    //   1349: lcmp
    //   1350: ifeq +128 -> 1478
    //   1353: aload 16
    //   1355: astore 20
    //   1357: aload 15
    //   1359: astore 18
    //   1361: aload_2
    //   1362: astore 22
    //   1364: aload 16
    //   1366: astore 19
    //   1368: aload 15
    //   1370: astore 17
    //   1372: aload_2
    //   1373: astore 21
    //   1375: aload 32
    //   1377: invokevirtual 187	java/io/File:delete	()Z
    //   1380: pop
    //   1381: aload 16
    //   1383: astore 19
    //   1385: aload 15
    //   1387: astore 17
    //   1389: aload_2
    //   1390: astore 21
    //   1392: ldc 82
    //   1394: iconst_1
    //   1395: new 32	java/lang/StringBuilder
    //   1398: dup
    //   1399: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1402: ldc_w 599
    //   1405: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: lload_0
    //   1409: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1412: ldc 122
    //   1414: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1423: iconst_0
    //   1424: istore 12
    //   1426: aload_2
    //   1427: astore 17
    //   1429: aload 17
    //   1431: ifnull +8 -> 1439
    //   1434: aload 17
    //   1436: invokevirtual 602	java/io/OutputStream:close	()V
    //   1439: aload 15
    //   1441: ifnull +8 -> 1449
    //   1444: aload 15
    //   1446: invokevirtual 603	java/io/InputStream:close	()V
    //   1449: iload 12
    //   1451: istore 4
    //   1453: aload 16
    //   1455: ifnull -1073 -> 382
    //   1458: aload 16
    //   1460: invokevirtual 603	java/io/InputStream:close	()V
    //   1463: iload 12
    //   1465: istore 4
    //   1467: goto -1085 -> 382
    //   1470: astore_2
    //   1471: iload 12
    //   1473: istore 4
    //   1475: goto -1093 -> 382
    //   1478: aload 16
    //   1480: astore 20
    //   1482: aload 15
    //   1484: astore 18
    //   1486: aload_2
    //   1487: astore 22
    //   1489: aload 16
    //   1491: astore 19
    //   1493: aload 15
    //   1495: astore 17
    //   1497: aload_2
    //   1498: astore 21
    //   1500: aload 34
    //   1502: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1505: ifne +36 -> 1541
    //   1508: aload 16
    //   1510: astore 20
    //   1512: aload 15
    //   1514: astore 18
    //   1516: aload_2
    //   1517: astore 22
    //   1519: aload 16
    //   1521: astore 19
    //   1523: aload 15
    //   1525: astore 17
    //   1527: aload_2
    //   1528: astore 21
    //   1530: aload 34
    //   1532: ldc_w 551
    //   1535: invokestatic 535	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1538: ifeq +130 -> 1668
    //   1541: aload 16
    //   1543: astore 20
    //   1545: aload 15
    //   1547: astore 18
    //   1549: aload_2
    //   1550: astore 22
    //   1552: aload 16
    //   1554: astore 19
    //   1556: aload 15
    //   1558: astore 17
    //   1560: aload_2
    //   1561: astore 21
    //   1563: aload 33
    //   1565: invokeinterface 58 1 0
    //   1570: aload 35
    //   1572: aload 36
    //   1574: invokeinterface 555 3 0
    //   1579: invokeinterface 68 1 0
    //   1584: pop
    //   1585: aload 16
    //   1587: astore 20
    //   1589: aload 15
    //   1591: astore 18
    //   1593: aload_2
    //   1594: astore 22
    //   1596: aload 16
    //   1598: astore 19
    //   1600: aload 15
    //   1602: astore 17
    //   1604: aload_2
    //   1605: astore 21
    //   1607: ldc 82
    //   1609: iconst_1
    //   1610: new 32	java/lang/StringBuilder
    //   1613: dup
    //   1614: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1617: ldc_w 605
    //   1620: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: aload 35
    //   1625: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: ldc_w 559
    //   1631: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: aload 34
    //   1636: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: ldc 230
    //   1641: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: lload_0
    //   1645: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1648: ldc 122
    //   1650: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1653: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1656: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1659: iconst_1
    //   1660: istore 12
    //   1662: aload_2
    //   1663: astore 17
    //   1665: goto -236 -> 1429
    //   1668: aload 16
    //   1670: astore 20
    //   1672: aload 15
    //   1674: astore 18
    //   1676: aload_2
    //   1677: astore 22
    //   1679: aload 16
    //   1681: astore 19
    //   1683: aload 15
    //   1685: astore 17
    //   1687: aload_2
    //   1688: astore 21
    //   1690: aload 33
    //   1692: invokeinterface 58 1 0
    //   1697: aload 35
    //   1699: aload 34
    //   1701: invokeinterface 555 3 0
    //   1706: invokeinterface 68 1 0
    //   1711: pop
    //   1712: goto -127 -> 1585
    //   1715: astore 17
    //   1717: aload 22
    //   1719: astore_2
    //   1720: aload 18
    //   1722: astore 15
    //   1724: aload 20
    //   1726: astore 16
    //   1728: aload 17
    //   1730: astore 18
    //   1732: iconst_0
    //   1733: istore 12
    //   1735: aload 16
    //   1737: astore 19
    //   1739: aload 15
    //   1741: astore 17
    //   1743: aload_2
    //   1744: astore 21
    //   1746: ldc 82
    //   1748: iconst_1
    //   1749: new 32	java/lang/StringBuilder
    //   1752: dup
    //   1753: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1756: ldc_w 607
    //   1759: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: lload_0
    //   1763: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1766: ldc 122
    //   1768: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: aload 18
    //   1776: invokestatic 359	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1779: aload_2
    //   1780: ifnull +7 -> 1787
    //   1783: aload_2
    //   1784: invokevirtual 602	java/io/OutputStream:close	()V
    //   1787: aload 15
    //   1789: ifnull +8 -> 1797
    //   1792: aload 15
    //   1794: invokevirtual 603	java/io/InputStream:close	()V
    //   1797: iload 12
    //   1799: istore 4
    //   1801: aload 16
    //   1803: ifnull -1421 -> 382
    //   1806: aload 16
    //   1808: invokevirtual 603	java/io/InputStream:close	()V
    //   1811: iload 12
    //   1813: istore 4
    //   1815: goto -1433 -> 382
    //   1818: astore_2
    //   1819: iload 12
    //   1821: istore 4
    //   1823: goto -1441 -> 382
    //   1826: aload 16
    //   1828: astore 20
    //   1830: aload 15
    //   1832: astore 18
    //   1834: aload_2
    //   1835: astore 22
    //   1837: aload 16
    //   1839: astore 19
    //   1841: aload 15
    //   1843: astore 17
    //   1845: aload_2
    //   1846: astore 21
    //   1848: ldc 82
    //   1850: iconst_1
    //   1851: new 32	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1858: ldc_w 609
    //   1861: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: lload_0
    //   1865: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1868: ldc 122
    //   1870: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1873: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1876: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1879: iload 13
    //   1881: istore 12
    //   1883: aload_2
    //   1884: astore 17
    //   1886: goto -457 -> 1429
    //   1889: astore_2
    //   1890: aload 21
    //   1892: ifnull +8 -> 1900
    //   1895: aload 21
    //   1897: invokevirtual 602	java/io/OutputStream:close	()V
    //   1900: aload 17
    //   1902: ifnull +8 -> 1910
    //   1905: aload 17
    //   1907: invokevirtual 603	java/io/InputStream:close	()V
    //   1910: aload 19
    //   1912: ifnull +8 -> 1920
    //   1915: aload 19
    //   1917: invokevirtual 603	java/io/InputStream:close	()V
    //   1920: aload_2
    //   1921: athrow
    //   1922: ldc 82
    //   1924: iconst_1
    //   1925: new 32	java/lang/StringBuilder
    //   1928: dup
    //   1929: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1932: ldc_w 611
    //   1935: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: lload_0
    //   1939: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1942: ldc 122
    //   1944: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1950: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1953: iload 12
    //   1955: istore 4
    //   1957: goto -1575 -> 382
    //   1960: astore_2
    //   1961: goto -522 -> 1439
    //   1964: astore_2
    //   1965: goto -516 -> 1449
    //   1968: astore_2
    //   1969: goto -182 -> 1787
    //   1972: astore_2
    //   1973: goto -176 -> 1797
    //   1976: astore_3
    //   1977: goto -77 -> 1900
    //   1980: astore_3
    //   1981: goto -71 -> 1910
    //   1984: astore_3
    //   1985: goto -65 -> 1920
    //   1988: astore 18
    //   1990: goto -258 -> 1732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1993	0	paramLong	long
    //   0	1993	2	paramContext	Context
    //   0	1993	3	paramString	String
    //   0	1993	4	paramBoolean	boolean
    //   317	965	5	i	int
    //   385	669	6	l1	long
    //   964	379	8	l2	long
    //   283	133	10	l3	long
    //   7	1947	12	bool1	boolean
    //   4	1876	13	bool2	boolean
    //   111	132	14	bool3	boolean
    //   99	933	15	localObject1	Object
    //   1058	1	15	localFileNotFoundException	java.io.FileNotFoundException
    //   1126	716	15	localObject2	Object
    //   685	1153	16	localObject3	Object
    //   714	972	17	localObject4	Object
    //   1715	14	17	localIOException1	java.io.IOException
    //   1741	165	17	localObject5	Object
    //   702	1131	18	localObject6	Object
    //   1988	1	18	localIOException2	java.io.IOException
    //   710	1206	19	localObject7	Object
    //   698	1131	20	localObject8	Object
    //   718	1178	21	localObject9	Object
    //   706	1130	22	localObject10	Object
    //   676	596	23	localObject11	Object
    //   667	475	24	localObject12	Object
    //   670	484	25	localObject13	Object
    //   673	195	26	localObject14	Object
    //   694	427	27	localObject15	Object
    //   688	446	28	localObject16	Object
    //   691	455	29	localObject17	Object
    //   679	145	30	localObject18	Object
    //   664	135	31	localObject19	Object
    //   142	1234	32	localFile1	File
    //   16	1675	33	localSharedPreferences	SharedPreferences
    //   40	1660	34	str1	String
    //   62	1636	35	str2	String
    //   86	1487	36	str3	String
    //   104	807	37	str4	String
    //   729	59	38	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   9	242	457	finally
    //   256	274	457	finally
    //   280	299	457	finally
    //   304	327	457	finally
    //   332	338	457	finally
    //   341	382	457	finally
    //   382	454	457	finally
    //   463	501	457	finally
    //   501	523	457	finally
    //   523	575	457	finally
    //   581	603	457	finally
    //   606	656	457	finally
    //   1434	1439	457	finally
    //   1444	1449	457	finally
    //   1458	1463	457	finally
    //   1783	1787	457	finally
    //   1792	1797	457	finally
    //   1806	1811	457	finally
    //   1895	1900	457	finally
    //   1905	1910	457	finally
    //   1915	1920	457	finally
    //   1920	1922	457	finally
    //   1922	1953	457	finally
    //   831	863	1058	java/io/FileNotFoundException
    //   1458	1463	1470	java/io/IOException
    //   720	731	1715	java/io/IOException
    //   755	763	1715	java/io/IOException
    //   787	794	1715	java/io/IOException
    //   831	863	1715	java/io/IOException
    //   899	930	1715	java/io/IOException
    //   955	962	1715	java/io/IOException
    //   993	1006	1715	java/io/IOException
    //   1038	1047	1715	java/io/IOException
    //   1082	1120	1715	java/io/IOException
    //   1157	1195	1715	java/io/IOException
    //   1229	1242	1715	java/io/IOException
    //   1270	1279	1715	java/io/IOException
    //   1312	1320	1715	java/io/IOException
    //   1342	1353	1715	java/io/IOException
    //   1375	1381	1715	java/io/IOException
    //   1500	1508	1715	java/io/IOException
    //   1530	1541	1715	java/io/IOException
    //   1563	1585	1715	java/io/IOException
    //   1607	1659	1715	java/io/IOException
    //   1690	1712	1715	java/io/IOException
    //   1848	1879	1715	java/io/IOException
    //   1806	1811	1818	java/io/IOException
    //   720	731	1889	finally
    //   755	763	1889	finally
    //   787	794	1889	finally
    //   831	863	1889	finally
    //   899	930	1889	finally
    //   955	962	1889	finally
    //   993	1006	1889	finally
    //   1038	1047	1889	finally
    //   1082	1120	1889	finally
    //   1157	1195	1889	finally
    //   1229	1242	1889	finally
    //   1270	1279	1889	finally
    //   1312	1320	1889	finally
    //   1342	1353	1889	finally
    //   1375	1381	1889	finally
    //   1392	1423	1889	finally
    //   1500	1508	1889	finally
    //   1530	1541	1889	finally
    //   1563	1585	1889	finally
    //   1607	1659	1889	finally
    //   1690	1712	1889	finally
    //   1746	1779	1889	finally
    //   1848	1879	1889	finally
    //   1434	1439	1960	java/io/IOException
    //   1444	1449	1964	java/io/IOException
    //   1783	1787	1968	java/io/IOException
    //   1792	1797	1972	java/io/IOException
    //   1895	1900	1976	java/io/IOException
    //   1905	1910	1980	java/io/IOException
    //   1915	1920	1984	java/io/IOException
    //   1392	1423	1988	java/io/IOException
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