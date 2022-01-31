package com.tencent.mobileqq.startup.step;

import amyo;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import awrn;
import azxi;
import bcdt;
import bcdu;
import bech;
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
import lbk;
import mjg;

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
      String str1 = bech.a(localFile);
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
    if (lbk.f() <= 2) {}
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
        ((ArrayList)localObject2).addAll(Arrays.asList(new String[] { "libSDKCommon.so", "libVideoCtrl.so", "libtraeimp-armeabi-v7a.so", "libqav_graphics.so", "libqav_gaudio_engine.so", "libqav_utils.so", "libqav_media_engine.so" }));
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
    b(paramLong, localBaseApplicationImpl, "traeimp-armeabi-v7a", true);
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
        localObject6 = bcdt.a(localFile);
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
      ((HashMap)localObject6).put("qq_ver", String.valueOf(mjg.b()));
      awrn.a(paramContext).a("", "AV_LOAD_SO_FAILED", false, 0L, 0L, (HashMap)localObject6, "");
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo end , result[" + paramBoolean + "], libName[" + paramString + "], seq[" + paramLong + "]");
      return paramBoolean;
    }
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    if (lbk.f() <= 2) {
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
      } while ((a(paramContext, "traeopus-armeabi-v7a")) && (a(true)));
      return false;
    } while ((a(paramContext, "TcHevcDec2")) && (a(paramContext, "TcHevcEnc")) && (a(paramContext, "traeopus-armeabi-v7a")) && (b(true)));
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
    str = bcdu.a(str);
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
    QavSoData localQavSoData = (QavSoData)amyo.a(QavSoData.class);
    if (!a("libTcHevcEnc.so", localQavSoData.m_TcHevcEnc, paramBoolean)) {
      return false;
    }
    if (!a("libTcHevcDec.so", localQavSoData.m_TcHevcDec, paramBoolean)) {
      return false;
    }
    return a("libTcHevcDec2.so", localQavSoData.m_TcHevcDec2, paramBoolean);
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
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libtraeopus-armeabi.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libtraeopus-armeabi-v7a.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libtraeimp-armeabi-v7a.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_graphics.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_gaudio_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_utils.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libqav_media_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libSDKCommon.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libVideoCtrl.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libxplatform.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libstlport_shared.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + a(new StringBuilder().append(str).append("libc++_shared.so").toString()));
    str = azxi.a(BaseApplicationImpl.sApplication);
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
    //   18: invokestatic 45	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   21: astore 34
    //   23: new 32	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 518
    //   33: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 35
    //   45: aload 33
    //   47: aload 35
    //   49: ldc_w 520
    //   52: invokeinterface 524 3 0
    //   57: astore 15
    //   59: invokestatic 136	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   62: astore 36
    //   64: aload 36
    //   66: invokestatic 432	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: istore 14
    //   71: new 92	java/io/File
    //   74: dup
    //   75: new 32	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   82: aload 36
    //   84: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 32
    //   102: ldc 82
    //   104: iconst_1
    //   105: new 32	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 526
    //   115: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_3
    //   119: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 528
    //   125: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 15
    //   130: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc_w 530
    //   136: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 34
    //   141: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 532
    //   147: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload 4
    //   152: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   155: ldc_w 534
    //   158: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload 14
    //   163: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   166: ldc_w 536
    //   169: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 32
    //   174: invokevirtual 115	java/io/File:exists	()Z
    //   177: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: ldc 230
    //   182: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: lload_0
    //   186: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   189: ldc 122
    //   191: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: iload 14
    //   202: ifeq +12 -> 214
    //   205: iconst_0
    //   206: istore 4
    //   208: ldc 2
    //   210: monitorexit
    //   211: iload 4
    //   213: ireturn
    //   214: aload 15
    //   216: aload 34
    //   218: invokestatic 540	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   221: ifeq +17 -> 238
    //   224: aload 32
    //   226: invokevirtual 115	java/io/File:exists	()Z
    //   229: ifeq +9 -> 238
    //   232: iconst_1
    //   233: istore 4
    //   235: goto -27 -> 208
    //   238: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   241: lstore 10
    //   243: aload 32
    //   245: invokevirtual 187	java/io/File:delete	()Z
    //   248: pop
    //   249: aload 32
    //   251: invokevirtual 115	java/io/File:exists	()Z
    //   254: ifne +1609 -> 1863
    //   257: iload 4
    //   259: ifeq +344 -> 603
    //   262: aload_2
    //   263: aload 36
    //   265: ldc_w 542
    //   268: aload_3
    //   269: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   272: invokestatic 547	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   275: istore 5
    //   277: aload 32
    //   279: invokevirtual 115	java/io/File:exists	()Z
    //   282: ifeq +264 -> 546
    //   285: iload 5
    //   287: ifeq +134 -> 421
    //   290: aload 32
    //   292: invokevirtual 187	java/io/File:delete	()Z
    //   295: pop
    //   296: iconst_0
    //   297: istore 4
    //   299: ldc 82
    //   301: iconst_1
    //   302: new 32	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 549
    //   312: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: iload 5
    //   317: invokevirtual 552	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc 230
    //   322: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: lload_0
    //   326: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   329: ldc 122
    //   331: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   343: lstore 6
    //   345: ldc 82
    //   347: iconst_1
    //   348: new 32	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   355: ldc_w 554
    //   358: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_3
    //   362: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 556
    //   368: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: lload 6
    //   373: lload 10
    //   375: lsub
    //   376: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: ldc 112
    //   381: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 32
    //   386: invokevirtual 115	java/io/File:exists	()Z
    //   389: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: ldc 230
    //   394: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: lload_0
    //   398: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   401: ldc 122
    //   403: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: goto -204 -> 208
    //   415: astore_2
    //   416: ldc 2
    //   418: monitorexit
    //   419: aload_2
    //   420: athrow
    //   421: aload 34
    //   423: invokestatic 432	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   426: ifne +14 -> 440
    //   429: aload 34
    //   431: ldc_w 558
    //   434: invokestatic 540	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   437: ifeq +84 -> 521
    //   440: aload 33
    //   442: invokeinterface 58 1 0
    //   447: aload 35
    //   449: ldc_w 520
    //   452: invokeinterface 562 3 0
    //   457: invokeinterface 68 1 0
    //   462: pop
    //   463: ldc 82
    //   465: iconst_1
    //   466: new 32	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 564
    //   476: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload 35
    //   481: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc_w 566
    //   487: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 34
    //   492: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc 230
    //   497: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: lload_0
    //   501: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   504: ldc 122
    //   506: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iconst_1
    //   516: istore 4
    //   518: goto -178 -> 340
    //   521: aload 33
    //   523: invokeinterface 58 1 0
    //   528: aload 35
    //   530: aload 34
    //   532: invokeinterface 562 3 0
    //   537: invokeinterface 68 1 0
    //   542: pop
    //   543: goto -80 -> 463
    //   546: ldc 82
    //   548: iconst_1
    //   549: new 32	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 568
    //   559: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 5
    //   564: invokevirtual 552	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: ldc 112
    //   569: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: iconst_0
    //   573: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   576: ldc 230
    //   578: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: lload_0
    //   582: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   585: ldc 122
    //   587: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: iload 12
    //   598: istore 4
    //   600: goto -260 -> 340
    //   603: aconst_null
    //   604: astore 31
    //   606: aconst_null
    //   607: astore 24
    //   609: aconst_null
    //   610: astore 25
    //   612: aconst_null
    //   613: astore 26
    //   615: aconst_null
    //   616: astore 23
    //   618: aconst_null
    //   619: astore 30
    //   621: aconst_null
    //   622: astore 15
    //   624: aconst_null
    //   625: astore 16
    //   627: aconst_null
    //   628: astore 28
    //   630: aconst_null
    //   631: astore 29
    //   633: aconst_null
    //   634: astore 27
    //   636: aload 28
    //   638: astore 20
    //   640: aload 23
    //   642: astore 18
    //   644: aload 24
    //   646: astore 22
    //   648: aload 29
    //   650: astore 19
    //   652: aload 30
    //   654: astore 17
    //   656: aload 25
    //   658: astore 21
    //   660: new 92	java/io/File
    //   663: dup
    //   664: aload 36
    //   666: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   669: astore 37
    //   671: aload 28
    //   673: astore 20
    //   675: aload 23
    //   677: astore 18
    //   679: aload 24
    //   681: astore 22
    //   683: aload 29
    //   685: astore 19
    //   687: aload 30
    //   689: astore 17
    //   691: aload 25
    //   693: astore 21
    //   695: aload 37
    //   697: invokevirtual 115	java/io/File:exists	()Z
    //   700: ifne +47 -> 747
    //   703: aload 28
    //   705: astore 20
    //   707: aload 23
    //   709: astore 18
    //   711: aload 24
    //   713: astore 22
    //   715: aload 29
    //   717: astore 19
    //   719: aload 30
    //   721: astore 17
    //   723: aload 25
    //   725: astore 21
    //   727: aload 37
    //   729: invokevirtual 571	java/io/File:mkdir	()Z
    //   732: istore 4
    //   734: iload 13
    //   736: istore 12
    //   738: aload 31
    //   740: astore 17
    //   742: iload 4
    //   744: ifeq +625 -> 1369
    //   747: aload 28
    //   749: astore 20
    //   751: aload 23
    //   753: astore 18
    //   755: aload 24
    //   757: astore 22
    //   759: aload 29
    //   761: astore 19
    //   763: aload 30
    //   765: astore 17
    //   767: aload 25
    //   769: astore 21
    //   771: aload_2
    //   772: invokevirtual 575	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   775: new 32	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   782: invokestatic 577	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   785: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload_3
    //   789: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   792: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokevirtual 583	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   801: astore 15
    //   803: aload 27
    //   805: astore 16
    //   807: aload 26
    //   809: astore_2
    //   810: aload 15
    //   812: ifnull +58 -> 870
    //   815: aload 16
    //   817: astore 20
    //   819: aload 15
    //   821: astore 18
    //   823: aload 24
    //   825: astore 22
    //   827: aload 16
    //   829: astore 19
    //   831: aload 15
    //   833: astore 17
    //   835: aload 25
    //   837: astore 21
    //   839: new 585	java/io/FileOutputStream
    //   842: dup
    //   843: new 32	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   850: aload 36
    //   852: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload_3
    //   856: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   859: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: iconst_1
    //   866: invokespecial 588	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   869: astore_2
    //   870: lconst_0
    //   871: lstore 6
    //   873: aload 16
    //   875: astore 20
    //   877: aload 15
    //   879: astore 18
    //   881: aload_2
    //   882: astore 22
    //   884: aload 16
    //   886: astore 19
    //   888: aload 15
    //   890: astore 17
    //   892: aload_2
    //   893: astore 21
    //   895: sipush 8192
    //   898: newarray byte
    //   900: astore 23
    //   902: lload 6
    //   904: lstore 8
    //   906: aload 15
    //   908: ifnull +234 -> 1142
    //   911: aload 16
    //   913: astore 20
    //   915: aload 15
    //   917: astore 18
    //   919: aload_2
    //   920: astore 22
    //   922: aload 16
    //   924: astore 19
    //   926: aload 15
    //   928: astore 17
    //   930: aload_2
    //   931: astore 21
    //   933: aload 15
    //   935: aload 23
    //   937: iconst_0
    //   938: aload 23
    //   940: arraylength
    //   941: invokevirtual 594	java/io/InputStream:read	([BII)I
    //   944: istore 5
    //   946: lload 6
    //   948: lstore 8
    //   950: iload 5
    //   952: iconst_m1
    //   953: if_icmpeq +189 -> 1142
    //   956: aload 16
    //   958: astore 20
    //   960: aload 15
    //   962: astore 18
    //   964: aload_2
    //   965: astore 22
    //   967: aload 16
    //   969: astore 19
    //   971: aload 15
    //   973: astore 17
    //   975: aload_2
    //   976: astore 21
    //   978: aload_2
    //   979: aload 23
    //   981: iconst_0
    //   982: iload 5
    //   984: invokevirtual 600	java/io/OutputStream:write	([BII)V
    //   987: lload 6
    //   989: iload 5
    //   991: i2l
    //   992: ladd
    //   993: lstore 6
    //   995: goto -93 -> 902
    //   998: astore 15
    //   1000: aconst_null
    //   1001: astore 17
    //   1003: aconst_null
    //   1004: astore 18
    //   1006: aload 28
    //   1008: astore 20
    //   1010: aload 24
    //   1012: astore 22
    //   1014: aload 29
    //   1016: astore 19
    //   1018: aload 25
    //   1020: astore 21
    //   1022: aload_2
    //   1023: invokevirtual 575	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1026: new 32	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1033: invokestatic 577	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   1036: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_3
    //   1040: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1043: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: ldc_w 602
    //   1049: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1055: invokevirtual 583	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1058: astore 23
    //   1060: aload 27
    //   1062: astore 16
    //   1064: aload 23
    //   1066: astore 15
    //   1068: aload 23
    //   1070: ifnull -263 -> 807
    //   1073: aload 28
    //   1075: astore 20
    //   1077: aload 23
    //   1079: astore 18
    //   1081: aload 24
    //   1083: astore 22
    //   1085: aload 29
    //   1087: astore 19
    //   1089: aload 23
    //   1091: astore 17
    //   1093: aload 25
    //   1095: astore 21
    //   1097: aload_2
    //   1098: invokevirtual 575	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1101: new 32	java/lang/StringBuilder
    //   1104: dup
    //   1105: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1108: invokestatic 577	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   1111: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: aload_3
    //   1115: invokestatic 239	com/tencent/mobileqq/startup/step/UpdateAvSo:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1118: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: ldc_w 604
    //   1124: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1130: invokevirtual 583	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1133: astore 16
    //   1135: aload 23
    //   1137: astore 15
    //   1139: goto -332 -> 807
    //   1142: aload 16
    //   1144: ifnull +86 -> 1230
    //   1147: aload 16
    //   1149: astore 20
    //   1151: aload 15
    //   1153: astore 18
    //   1155: aload_2
    //   1156: astore 22
    //   1158: aload 16
    //   1160: astore 19
    //   1162: aload 15
    //   1164: astore 17
    //   1166: aload_2
    //   1167: astore 21
    //   1169: aload 16
    //   1171: aload 23
    //   1173: iconst_0
    //   1174: aload 23
    //   1176: arraylength
    //   1177: invokevirtual 594	java/io/InputStream:read	([BII)I
    //   1180: istore 5
    //   1182: iload 5
    //   1184: iconst_m1
    //   1185: if_icmpeq +45 -> 1230
    //   1188: aload 16
    //   1190: astore 20
    //   1192: aload 15
    //   1194: astore 18
    //   1196: aload_2
    //   1197: astore 22
    //   1199: aload 16
    //   1201: astore 19
    //   1203: aload 15
    //   1205: astore 17
    //   1207: aload_2
    //   1208: astore 21
    //   1210: aload_2
    //   1211: aload 23
    //   1213: iconst_0
    //   1214: iload 5
    //   1216: invokevirtual 600	java/io/OutputStream:write	([BII)V
    //   1219: lload 8
    //   1221: iload 5
    //   1223: i2l
    //   1224: ladd
    //   1225: lstore 8
    //   1227: goto -85 -> 1142
    //   1230: aload 16
    //   1232: astore 20
    //   1234: aload 15
    //   1236: astore 18
    //   1238: aload_2
    //   1239: astore 22
    //   1241: aload 16
    //   1243: astore 19
    //   1245: aload 15
    //   1247: astore 17
    //   1249: aload_2
    //   1250: astore 21
    //   1252: aload 32
    //   1254: invokevirtual 115	java/io/File:exists	()Z
    //   1257: ifeq +510 -> 1767
    //   1260: aload 16
    //   1262: astore 20
    //   1264: aload 15
    //   1266: astore 18
    //   1268: aload_2
    //   1269: astore 22
    //   1271: aload 16
    //   1273: astore 19
    //   1275: aload 15
    //   1277: astore 17
    //   1279: aload_2
    //   1280: astore 21
    //   1282: lload 8
    //   1284: aload 32
    //   1286: invokevirtual 262	java/io/File:length	()J
    //   1289: lcmp
    //   1290: ifeq +128 -> 1418
    //   1293: aload 16
    //   1295: astore 20
    //   1297: aload 15
    //   1299: astore 18
    //   1301: aload_2
    //   1302: astore 22
    //   1304: aload 16
    //   1306: astore 19
    //   1308: aload 15
    //   1310: astore 17
    //   1312: aload_2
    //   1313: astore 21
    //   1315: aload 32
    //   1317: invokevirtual 187	java/io/File:delete	()Z
    //   1320: pop
    //   1321: aload 16
    //   1323: astore 19
    //   1325: aload 15
    //   1327: astore 17
    //   1329: aload_2
    //   1330: astore 21
    //   1332: ldc 82
    //   1334: iconst_1
    //   1335: new 32	java/lang/StringBuilder
    //   1338: dup
    //   1339: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1342: ldc_w 606
    //   1345: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: lload_0
    //   1349: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1352: ldc 122
    //   1354: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1360: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1363: iconst_0
    //   1364: istore 12
    //   1366: aload_2
    //   1367: astore 17
    //   1369: aload 17
    //   1371: ifnull +8 -> 1379
    //   1374: aload 17
    //   1376: invokevirtual 609	java/io/OutputStream:close	()V
    //   1379: aload 15
    //   1381: ifnull +8 -> 1389
    //   1384: aload 15
    //   1386: invokevirtual 610	java/io/InputStream:close	()V
    //   1389: iload 12
    //   1391: istore 4
    //   1393: aload 16
    //   1395: ifnull -1055 -> 340
    //   1398: aload 16
    //   1400: invokevirtual 610	java/io/InputStream:close	()V
    //   1403: iload 12
    //   1405: istore 4
    //   1407: goto -1067 -> 340
    //   1410: astore_2
    //   1411: iload 12
    //   1413: istore 4
    //   1415: goto -1075 -> 340
    //   1418: aload 16
    //   1420: astore 20
    //   1422: aload 15
    //   1424: astore 18
    //   1426: aload_2
    //   1427: astore 22
    //   1429: aload 16
    //   1431: astore 19
    //   1433: aload 15
    //   1435: astore 17
    //   1437: aload_2
    //   1438: astore 21
    //   1440: aload 34
    //   1442: invokestatic 432	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1445: ifne +36 -> 1481
    //   1448: aload 16
    //   1450: astore 20
    //   1452: aload 15
    //   1454: astore 18
    //   1456: aload_2
    //   1457: astore 22
    //   1459: aload 16
    //   1461: astore 19
    //   1463: aload 15
    //   1465: astore 17
    //   1467: aload_2
    //   1468: astore 21
    //   1470: aload 34
    //   1472: ldc_w 558
    //   1475: invokestatic 540	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1478: ifeq +131 -> 1609
    //   1481: aload 16
    //   1483: astore 20
    //   1485: aload 15
    //   1487: astore 18
    //   1489: aload_2
    //   1490: astore 22
    //   1492: aload 16
    //   1494: astore 19
    //   1496: aload 15
    //   1498: astore 17
    //   1500: aload_2
    //   1501: astore 21
    //   1503: aload 33
    //   1505: invokeinterface 58 1 0
    //   1510: aload 35
    //   1512: ldc_w 520
    //   1515: invokeinterface 562 3 0
    //   1520: invokeinterface 68 1 0
    //   1525: pop
    //   1526: aload 16
    //   1528: astore 20
    //   1530: aload 15
    //   1532: astore 18
    //   1534: aload_2
    //   1535: astore 22
    //   1537: aload 16
    //   1539: astore 19
    //   1541: aload 15
    //   1543: astore 17
    //   1545: aload_2
    //   1546: astore 21
    //   1548: ldc 82
    //   1550: iconst_1
    //   1551: new 32	java/lang/StringBuilder
    //   1554: dup
    //   1555: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1558: ldc_w 612
    //   1561: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: aload 35
    //   1566: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: ldc_w 566
    //   1572: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: aload 34
    //   1577: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: ldc 230
    //   1582: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: lload_0
    //   1586: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1589: ldc 122
    //   1591: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1597: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1600: iconst_1
    //   1601: istore 12
    //   1603: aload_2
    //   1604: astore 17
    //   1606: goto -237 -> 1369
    //   1609: aload 16
    //   1611: astore 20
    //   1613: aload 15
    //   1615: astore 18
    //   1617: aload_2
    //   1618: astore 22
    //   1620: aload 16
    //   1622: astore 19
    //   1624: aload 15
    //   1626: astore 17
    //   1628: aload_2
    //   1629: astore 21
    //   1631: aload 33
    //   1633: invokeinterface 58 1 0
    //   1638: aload 35
    //   1640: aload 34
    //   1642: invokeinterface 562 3 0
    //   1647: invokeinterface 68 1 0
    //   1652: pop
    //   1653: goto -127 -> 1526
    //   1656: astore 17
    //   1658: aload 22
    //   1660: astore_2
    //   1661: aload 18
    //   1663: astore 15
    //   1665: aload 20
    //   1667: astore 16
    //   1669: aload 17
    //   1671: astore 18
    //   1673: iconst_0
    //   1674: istore 12
    //   1676: aload 16
    //   1678: astore 19
    //   1680: aload 15
    //   1682: astore 17
    //   1684: aload_2
    //   1685: astore 21
    //   1687: ldc 82
    //   1689: iconst_1
    //   1690: new 32	java/lang/StringBuilder
    //   1693: dup
    //   1694: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1697: ldc_w 614
    //   1700: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: lload_0
    //   1704: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1707: ldc 122
    //   1709: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1715: aload 18
    //   1717: invokestatic 359	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1720: aload_2
    //   1721: ifnull +7 -> 1728
    //   1724: aload_2
    //   1725: invokevirtual 609	java/io/OutputStream:close	()V
    //   1728: aload 15
    //   1730: ifnull +8 -> 1738
    //   1733: aload 15
    //   1735: invokevirtual 610	java/io/InputStream:close	()V
    //   1738: iload 12
    //   1740: istore 4
    //   1742: aload 16
    //   1744: ifnull -1404 -> 340
    //   1747: aload 16
    //   1749: invokevirtual 610	java/io/InputStream:close	()V
    //   1752: iload 12
    //   1754: istore 4
    //   1756: goto -1416 -> 340
    //   1759: astore_2
    //   1760: iload 12
    //   1762: istore 4
    //   1764: goto -1424 -> 340
    //   1767: aload 16
    //   1769: astore 20
    //   1771: aload 15
    //   1773: astore 18
    //   1775: aload_2
    //   1776: astore 22
    //   1778: aload 16
    //   1780: astore 19
    //   1782: aload 15
    //   1784: astore 17
    //   1786: aload_2
    //   1787: astore 21
    //   1789: ldc 82
    //   1791: iconst_1
    //   1792: new 32	java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1799: ldc_w 616
    //   1802: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: lload_0
    //   1806: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1809: ldc 122
    //   1811: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1817: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1820: iload 13
    //   1822: istore 12
    //   1824: aload_2
    //   1825: astore 17
    //   1827: goto -458 -> 1369
    //   1830: astore_2
    //   1831: aload 21
    //   1833: ifnull +8 -> 1841
    //   1836: aload 21
    //   1838: invokevirtual 609	java/io/OutputStream:close	()V
    //   1841: aload 17
    //   1843: ifnull +8 -> 1851
    //   1846: aload 17
    //   1848: invokevirtual 610	java/io/InputStream:close	()V
    //   1851: aload 19
    //   1853: ifnull +8 -> 1861
    //   1856: aload 19
    //   1858: invokevirtual 610	java/io/InputStream:close	()V
    //   1861: aload_2
    //   1862: athrow
    //   1863: ldc 82
    //   1865: iconst_1
    //   1866: new 32	java/lang/StringBuilder
    //   1869: dup
    //   1870: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1873: ldc_w 618
    //   1876: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: lload_0
    //   1880: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1883: ldc 122
    //   1885: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1891: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1894: iload 12
    //   1896: istore 4
    //   1898: goto -1558 -> 340
    //   1901: astore_2
    //   1902: goto -523 -> 1379
    //   1905: astore_2
    //   1906: goto -517 -> 1389
    //   1909: astore_2
    //   1910: goto -182 -> 1728
    //   1913: astore_2
    //   1914: goto -176 -> 1738
    //   1917: astore_3
    //   1918: goto -77 -> 1841
    //   1921: astore_3
    //   1922: goto -71 -> 1851
    //   1925: astore_3
    //   1926: goto -65 -> 1861
    //   1929: astore 18
    //   1931: goto -258 -> 1673
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1934	0	paramLong	long
    //   0	1934	2	paramContext	Context
    //   0	1934	3	paramString	String
    //   0	1934	4	paramBoolean	boolean
    //   275	947	5	i	int
    //   343	651	6	l1	long
    //   904	379	8	l2	long
    //   241	133	10	l3	long
    //   7	1888	12	bool1	boolean
    //   4	1817	13	bool2	boolean
    //   69	132	14	bool3	boolean
    //   57	915	15	localObject1	Object
    //   998	1	15	localFileNotFoundException	java.io.FileNotFoundException
    //   1066	717	15	localObject2	Object
    //   625	1154	16	localObject3	Object
    //   654	973	17	localObject4	Object
    //   1656	14	17	localIOException1	java.io.IOException
    //   1682	165	17	localObject5	Object
    //   642	1132	18	localObject6	Object
    //   1929	1	18	localIOException2	java.io.IOException
    //   650	1207	19	localObject7	Object
    //   638	1132	20	localObject8	Object
    //   658	1179	21	localObject9	Object
    //   646	1131	22	localObject10	Object
    //   616	596	23	localObject11	Object
    //   607	475	24	localObject12	Object
    //   610	484	25	localObject13	Object
    //   613	195	26	localObject14	Object
    //   634	427	27	localObject15	Object
    //   628	446	28	localObject16	Object
    //   631	455	29	localObject17	Object
    //   619	145	30	localObject18	Object
    //   604	135	31	localObject19	Object
    //   100	1216	32	localFile1	File
    //   16	1616	33	localSharedPreferences	SharedPreferences
    //   21	1620	34	str1	String
    //   43	1596	35	str2	String
    //   62	789	36	str3	String
    //   669	59	37	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   9	200	415	finally
    //   214	232	415	finally
    //   238	257	415	finally
    //   262	285	415	finally
    //   290	296	415	finally
    //   299	340	415	finally
    //   340	412	415	finally
    //   421	440	415	finally
    //   440	463	415	finally
    //   463	515	415	finally
    //   521	543	415	finally
    //   546	596	415	finally
    //   1374	1379	415	finally
    //   1384	1389	415	finally
    //   1398	1403	415	finally
    //   1724	1728	415	finally
    //   1733	1738	415	finally
    //   1747	1752	415	finally
    //   1836	1841	415	finally
    //   1846	1851	415	finally
    //   1856	1861	415	finally
    //   1861	1863	415	finally
    //   1863	1894	415	finally
    //   771	803	998	java/io/FileNotFoundException
    //   1398	1403	1410	java/io/IOException
    //   660	671	1656	java/io/IOException
    //   695	703	1656	java/io/IOException
    //   727	734	1656	java/io/IOException
    //   771	803	1656	java/io/IOException
    //   839	870	1656	java/io/IOException
    //   895	902	1656	java/io/IOException
    //   933	946	1656	java/io/IOException
    //   978	987	1656	java/io/IOException
    //   1022	1060	1656	java/io/IOException
    //   1097	1135	1656	java/io/IOException
    //   1169	1182	1656	java/io/IOException
    //   1210	1219	1656	java/io/IOException
    //   1252	1260	1656	java/io/IOException
    //   1282	1293	1656	java/io/IOException
    //   1315	1321	1656	java/io/IOException
    //   1440	1448	1656	java/io/IOException
    //   1470	1481	1656	java/io/IOException
    //   1503	1526	1656	java/io/IOException
    //   1548	1600	1656	java/io/IOException
    //   1631	1653	1656	java/io/IOException
    //   1789	1820	1656	java/io/IOException
    //   1747	1752	1759	java/io/IOException
    //   660	671	1830	finally
    //   695	703	1830	finally
    //   727	734	1830	finally
    //   771	803	1830	finally
    //   839	870	1830	finally
    //   895	902	1830	finally
    //   933	946	1830	finally
    //   978	987	1830	finally
    //   1022	1060	1830	finally
    //   1097	1135	1830	finally
    //   1169	1182	1830	finally
    //   1210	1219	1830	finally
    //   1252	1260	1830	finally
    //   1282	1293	1830	finally
    //   1315	1321	1830	finally
    //   1332	1363	1830	finally
    //   1440	1448	1830	finally
    //   1470	1481	1830	finally
    //   1503	1526	1830	finally
    //   1548	1600	1830	finally
    //   1631	1653	1830	finally
    //   1687	1720	1830	finally
    //   1789	1820	1830	finally
    //   1374	1379	1901	java/io/IOException
    //   1384	1389	1905	java/io/IOException
    //   1724	1728	1909	java/io/IOException
    //   1733	1738	1913	java/io/IOException
    //   1836	1841	1917	java/io/IOException
    //   1846	1851	1921	java/io/IOException
    //   1856	1861	1925	java/io/IOException
    //   1332	1363	1929	java/io/IOException
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
    if (!localFile.exists()) {
      QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. libTcHevcEnc.so is not exist.");
    }
    do
    {
      do
      {
        return false;
        l = localSharedPreferences.getLong("SP_QAV_HEVC_ENC_SO_FILE_SIZE", 0L);
        if (localFile.length() == l) {
          break;
        }
        QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. hevcEncSoFile size is not same. savedFileSize = " + l + ", realFileSize = " + localFile.length());
      } while (!paramBoolean);
      localFile.delete();
      return false;
      localFile = new File(a() + "/libTcHevcDec2.so");
      if (!localFile.exists())
      {
        QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. libTcHevcDec2.so is not exist.");
        return false;
      }
      long l = localSharedPreferences.getLong("SP_QAV_HEVC_DEC2_SO_FILE_SIZE", 0L);
      localFile.length();
      if (localFile.length() == l) {
        break;
      }
      QLog.e("AVModuleExtract", 1, "checkHevcSoSize failed. hevcDec2SoFile size is not same. savedFileSize = " + l + ", realFileSize = " + localFile.length());
    } while (!paramBoolean);
    localFile.delete();
    return false;
    return true;
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