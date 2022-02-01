package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soload.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.GifSoLoader;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class AVSoUtils
  extends Step
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  
  public static LoadExtResult a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    LoadExtResult localLoadExtResult = SoLoadManager.a().a(paramString);
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder().append("loadAndDownloadSo. soName = ").append(paramString).append(", result = ").append(localLoadExtResult).append(", time len = ").append(l2 - l1).append(", so path = ");
    if (localLoadExtResult != null) {}
    for (paramString = localLoadExtResult.getSoLoadPath(paramString);; paramString = "null")
    {
      QLog.i("AVModuleExtract", 1, paramString);
      return localLoadExtResult;
    }
  }
  
  public static String a()
  {
    return "lib/armeabi/";
  }
  
  public static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  static void a()
  {
    if (!BaseApplicationImpl.isCurrentVersionFirstLaunch) {
      return;
    }
    if (VcSystemInfo.getCpuArchitecture() <= 2) {}
    for (int i = 1;; i = 0)
    {
      String str = b();
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
        ((ArrayList)localObject2).addAll(Arrays.asList(new String[] { "libSDKCommon.so", "libVideoCtrl.so", "libtraeimp-qq.so", "libqav_graphics.so", "libqav_gaudio_engine.so", "libqav_utils.so", "libqav_media_engine.so", "libhwcodec.so", "libTcVpxEnc.so", "libTcVpxDec.so" }));
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          a(str + (String)localObject2);
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
  
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: ldc 196
    //   23: iconst_4
    //   24: invokevirtual 202	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   27: astore_0
    //   28: aload_1
    //   29: invokestatic 205	com/tencent/mobileqq/startup/step/AVSoUtils:d	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_3
    //   33: invokestatic 207	com/tencent/mobileqq/startup/step/AVSoUtils:c	()Ljava/lang/String;
    //   36: astore 4
    //   38: invokestatic 209	com/tencent/mobileqq/startup/step/AVSoUtils:d	()Ljava/lang/String;
    //   41: astore 5
    //   43: aload_0
    //   44: aload_3
    //   45: aload 5
    //   47: invokeinterface 215 3 0
    //   52: astore 6
    //   54: aload 4
    //   56: aload 6
    //   58: invokestatic 219	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   61: ifeq +30 -> 91
    //   64: aload 4
    //   66: invokestatic 222	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Ljava/lang/String;)Z
    //   69: ifne +22 -> 91
    //   72: aload_0
    //   73: invokeinterface 226 1 0
    //   78: aload_3
    //   79: aload 5
    //   81: invokeinterface 232 3 0
    //   86: invokeinterface 235 1 0
    //   91: ldc 65
    //   93: iconst_1
    //   94: new 38	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   101: ldc 237
    //   103: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 239
    //   112: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 6
    //   117: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 241
    //   122: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 4
    //   127: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 243
    //   132: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 5
    //   137: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 245
    //   142: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: goto -135 -> 16
    //   154: astore_0
    //   155: ldc 2
    //   157: monitorexit
    //   158: aload_0
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramContext	Context
    //   0	160	1	paramString	String
    //   11	2	2	bool	boolean
    //   32	47	3	str1	String
    //   36	90	4	str2	String
    //   41	95	5	str3	String
    //   52	64	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   7	12	154	finally
    //   20	91	154	finally
    //   91	151	154	finally
  }
  
  private static void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    if (a(paramString1))
    {
      paramSharedPreferences.edit().putString(paramString2, d()).commit();
      return;
    }
    paramSharedPreferences.edit().putString(paramString2, paramString1).commit();
  }
  
  static void a(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      boolean bool2 = localFile.exists();
      boolean bool1 = false;
      if (bool2) {
        bool1 = localFile.delete();
      }
      QLog.w("AVModuleExtract", 1, "delSoFromCache, soPath[" + paramString + "], exist[" + bool2 + "], ret[" + bool1 + "]");
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean a()
  {
    LoadExtResult localLoadExtResult = a("TcHevcDec");
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
      str1 = paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString);
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
        label207:
        label254:
        String str3 = QLog.getStackTraceString(localException1);
        label345:
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
        break label926;
      }
      bool1 = ((File)localObject2).delete();
      if (!QLog.isDevelopLevel()) {
        break label851;
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
      break label207;
      Object localObject4 = "";
      break label254;
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
        localObject6 = MD5.a(localFile);
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
        break label345;
      }
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo,  failed. seq[" + paramLong + "], msg1[" + str3 + "], msg2[" + str1 + "], msg3[" + (String)localObject1 + "], msg4[" + str2 + "]");
      localObject6 = new HashMap();
      ((HashMap)localObject6).put("soname", paramString);
      ((HashMap)localObject6).put("existFirst", String.valueOf(bool2));
      ((HashMap)localObject6).put("existLast", String.valueOf(bool1));
      ((HashMap)localObject6).put("md5", localObject5);
      ((HashMap)localObject6).put("fileLength", String.valueOf(l1));
      ((HashMap)localObject6).put("msg1", c(str3));
      ((HashMap)localObject6).put("msg2", c(str1));
      ((HashMap)localObject6).put("msg3", c((String)localObject1));
      ((HashMap)localObject6).put("msg4", c(str2));
      ((HashMap)localObject6).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject6).put("man", c(Build.MANUFACTURER));
      ((HashMap)localObject6).put("mod", c(Build.MODEL));
      ((HashMap)localObject6).put("qq_ver", String.valueOf(UITools.getQQVersion()));
      StatisticCollector.getInstance(paramContext).collectPerformance("", "AV_LOAD_SO_FAILED", false, 0L, 0L, (HashMap)localObject6, "");
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo end , result[" + paramBoolean + "], libName[" + paramString + "], seq[" + paramLong + "]");
      return paramBoolean;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(0L, paramContext, paramString, paramBoolean);
  }
  
  public static boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (TextUtils.equals(paramString, "0" + SoLoadUtil.a()));
  }
  
  public static String b()
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
  
  public static String b(String paramString)
  {
    File localFile = new File(paramString);
    try
    {
      String str1 = MD5FileUtil.a(localFile);
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
  
  public static void b()
  {
    String str = b();
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("DecodeSo").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libTcHevcDec.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libTcHevcDec2.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libtraeimp-qq.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libqav_graphics.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libqav_gaudio_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libqav_utils.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libqav_media_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libSDKCommon.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libVideoCtrl.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libxplatform.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libc++_shared.so").toString()));
    str = GifSoLoader.a(BaseApplicationImpl.sApplication);
    QLog.w("AVModuleExtract", 1, "printSO, " + b(new StringBuilder().append(str).append("libc++_shared.so").toString()));
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
    //   10: ldc 196
    //   12: iconst_4
    //   13: invokevirtual 202	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   16: astore 33
    //   18: invokestatic 207	com/tencent/mobileqq/startup/step/AVSoUtils:c	()Ljava/lang/String;
    //   21: astore 34
    //   23: aload_3
    //   24: invokestatic 205	com/tencent/mobileqq/startup/step/AVSoUtils:d	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 35
    //   29: aload 33
    //   31: aload 35
    //   33: invokestatic 209	com/tencent/mobileqq/startup/step/AVSoUtils:d	()Ljava/lang/String;
    //   36: invokeinterface 215 3 0
    //   41: astore 15
    //   43: invokestatic 97	com/tencent/mobileqq/startup/step/AVSoUtils:b	()Ljava/lang/String;
    //   46: astore 36
    //   48: aload 36
    //   50: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: istore 14
    //   55: new 253	java/io/File
    //   58: dup
    //   59: new 38	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   66: aload 36
    //   68: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_3
    //   72: invokestatic 298	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 255	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 32
    //   86: ldc 65
    //   88: iconst_1
    //   89: new 38	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 479
    //   99: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_3
    //   103: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 481
    //   109: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 15
    //   114: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 483
    //   120: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 34
    //   125: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 485
    //   131: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload 4
    //   136: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   139: ldc_w 487
    //   142: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload 14
    //   147: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   150: ldc_w 489
    //   153: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 32
    //   158: invokevirtual 258	java/io/File:exists	()Z
    //   161: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: ldc_w 285
    //   167: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: lload_0
    //   171: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   174: ldc 245
    //   176: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: iload 14
    //   187: ifeq +12 -> 199
    //   190: iconst_0
    //   191: istore 4
    //   193: ldc 2
    //   195: monitorexit
    //   196: iload 4
    //   198: ireturn
    //   199: aload 15
    //   201: aload 34
    //   203: invokestatic 219	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   206: ifeq +17 -> 223
    //   209: aload 32
    //   211: invokevirtual 258	java/io/File:exists	()Z
    //   214: ifeq +9 -> 223
    //   217: iconst_1
    //   218: istore 4
    //   220: goto -27 -> 193
    //   223: invokestatic 494	android/os/SystemClock:uptimeMillis	()J
    //   226: lstore 10
    //   228: aload 32
    //   230: invokevirtual 261	java/io/File:delete	()Z
    //   233: pop
    //   234: aload 32
    //   236: invokevirtual 258	java/io/File:exists	()Z
    //   239: ifne +1434 -> 1673
    //   242: iload 4
    //   244: ifeq +292 -> 536
    //   247: aload_2
    //   248: aload 36
    //   250: ldc_w 496
    //   253: aload_3
    //   254: invokestatic 298	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   257: invokestatic 499	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   260: istore 5
    //   262: aload 32
    //   264: invokevirtual 258	java/io/File:exists	()Z
    //   267: ifeq +210 -> 477
    //   270: iload 5
    //   272: ifeq +137 -> 409
    //   275: aload 32
    //   277: invokevirtual 261	java/io/File:delete	()Z
    //   280: pop
    //   281: iconst_0
    //   282: istore 4
    //   284: ldc 65
    //   286: iconst_1
    //   287: new 38	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 501
    //   297: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iload 5
    //   302: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: ldc_w 285
    //   308: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload_0
    //   312: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: ldc 245
    //   317: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: invokestatic 494	android/os/SystemClock:uptimeMillis	()J
    //   329: lstore 6
    //   331: ldc 65
    //   333: iconst_1
    //   334: new 38	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 506
    //   344: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_3
    //   348: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc_w 508
    //   354: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: lload 6
    //   359: lload 10
    //   361: lsub
    //   362: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   365: ldc_w 307
    //   368: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 32
    //   373: invokevirtual 258	java/io/File:exists	()Z
    //   376: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   379: ldc_w 285
    //   382: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: lload_0
    //   386: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: ldc 245
    //   391: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: goto -207 -> 193
    //   403: astore_2
    //   404: ldc 2
    //   406: monitorexit
    //   407: aload_2
    //   408: athrow
    //   409: aload 33
    //   411: aload 34
    //   413: aload 35
    //   415: invokestatic 510	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   418: ldc 65
    //   420: iconst_1
    //   421: new 38	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 512
    //   431: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 35
    //   436: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 514
    //   442: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 34
    //   447: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc_w 285
    //   453: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: lload_0
    //   457: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   460: ldc 245
    //   462: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: iconst_1
    //   472: istore 4
    //   474: goto -148 -> 326
    //   477: ldc 65
    //   479: iconst_1
    //   480: new 38	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 516
    //   490: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: iload 5
    //   495: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: ldc_w 307
    //   501: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: iconst_0
    //   505: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   508: ldc_w 285
    //   511: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: lload_0
    //   515: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   518: ldc 245
    //   520: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: iload 12
    //   531: istore 4
    //   533: goto -207 -> 326
    //   536: aconst_null
    //   537: astore 31
    //   539: aconst_null
    //   540: astore 24
    //   542: aconst_null
    //   543: astore 25
    //   545: aconst_null
    //   546: astore 26
    //   548: aconst_null
    //   549: astore 23
    //   551: aconst_null
    //   552: astore 30
    //   554: aconst_null
    //   555: astore 15
    //   557: aconst_null
    //   558: astore 16
    //   560: aconst_null
    //   561: astore 28
    //   563: aconst_null
    //   564: astore 29
    //   566: aconst_null
    //   567: astore 27
    //   569: aload 28
    //   571: astore 20
    //   573: aload 23
    //   575: astore 18
    //   577: aload 24
    //   579: astore 22
    //   581: aload 29
    //   583: astore 19
    //   585: aload 30
    //   587: astore 17
    //   589: aload 25
    //   591: astore 21
    //   593: new 253	java/io/File
    //   596: dup
    //   597: aload 36
    //   599: invokespecial 255	java/io/File:<init>	(Ljava/lang/String;)V
    //   602: astore 37
    //   604: aload 28
    //   606: astore 20
    //   608: aload 23
    //   610: astore 18
    //   612: aload 24
    //   614: astore 22
    //   616: aload 29
    //   618: astore 19
    //   620: aload 30
    //   622: astore 17
    //   624: aload 25
    //   626: astore 21
    //   628: aload 37
    //   630: invokevirtual 258	java/io/File:exists	()Z
    //   633: ifne +47 -> 680
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
    //   660: aload 37
    //   662: invokevirtual 519	java/io/File:mkdir	()Z
    //   665: istore 4
    //   667: iload 13
    //   669: istore 12
    //   671: aload 31
    //   673: astore 17
    //   675: iload 4
    //   677: ifeq +625 -> 1302
    //   680: aload 28
    //   682: astore 20
    //   684: aload 23
    //   686: astore 18
    //   688: aload 24
    //   690: astore 22
    //   692: aload 29
    //   694: astore 19
    //   696: aload 30
    //   698: astore 17
    //   700: aload 25
    //   702: astore 21
    //   704: aload_2
    //   705: invokevirtual 523	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   708: new 38	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   715: invokestatic 524	com/tencent/mobileqq/startup/step/AVSoUtils:a	()Ljava/lang/String;
    //   718: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload_3
    //   722: invokestatic 298	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   725: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokevirtual 530	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   734: astore 15
    //   736: aload 27
    //   738: astore 16
    //   740: aload 26
    //   742: astore_2
    //   743: aload 15
    //   745: ifnull +58 -> 803
    //   748: aload 16
    //   750: astore 20
    //   752: aload 15
    //   754: astore 18
    //   756: aload 24
    //   758: astore 22
    //   760: aload 16
    //   762: astore 19
    //   764: aload 15
    //   766: astore 17
    //   768: aload 25
    //   770: astore 21
    //   772: new 532	java/io/FileOutputStream
    //   775: dup
    //   776: new 38	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   783: aload 36
    //   785: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload_3
    //   789: invokestatic 298	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   792: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: iconst_1
    //   799: invokespecial 535	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   802: astore_2
    //   803: lconst_0
    //   804: lstore 6
    //   806: aload 16
    //   808: astore 20
    //   810: aload 15
    //   812: astore 18
    //   814: aload_2
    //   815: astore 22
    //   817: aload 16
    //   819: astore 19
    //   821: aload 15
    //   823: astore 17
    //   825: aload_2
    //   826: astore 21
    //   828: sipush 8192
    //   831: newarray byte
    //   833: astore 23
    //   835: lload 6
    //   837: lstore 8
    //   839: aload 15
    //   841: ifnull +234 -> 1075
    //   844: aload 16
    //   846: astore 20
    //   848: aload 15
    //   850: astore 18
    //   852: aload_2
    //   853: astore 22
    //   855: aload 16
    //   857: astore 19
    //   859: aload 15
    //   861: astore 17
    //   863: aload_2
    //   864: astore 21
    //   866: aload 15
    //   868: aload 23
    //   870: iconst_0
    //   871: aload 23
    //   873: arraylength
    //   874: invokevirtual 541	java/io/InputStream:read	([BII)I
    //   877: istore 5
    //   879: lload 6
    //   881: lstore 8
    //   883: iload 5
    //   885: iconst_m1
    //   886: if_icmpeq +189 -> 1075
    //   889: aload 16
    //   891: astore 20
    //   893: aload 15
    //   895: astore 18
    //   897: aload_2
    //   898: astore 22
    //   900: aload 16
    //   902: astore 19
    //   904: aload 15
    //   906: astore 17
    //   908: aload_2
    //   909: astore 21
    //   911: aload_2
    //   912: aload 23
    //   914: iconst_0
    //   915: iload 5
    //   917: invokevirtual 547	java/io/OutputStream:write	([BII)V
    //   920: lload 6
    //   922: iload 5
    //   924: i2l
    //   925: ladd
    //   926: lstore 6
    //   928: goto -93 -> 835
    //   931: astore 15
    //   933: aconst_null
    //   934: astore 17
    //   936: aconst_null
    //   937: astore 18
    //   939: aload 28
    //   941: astore 20
    //   943: aload 24
    //   945: astore 22
    //   947: aload 29
    //   949: astore 19
    //   951: aload 25
    //   953: astore 21
    //   955: aload_2
    //   956: invokevirtual 523	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   959: new 38	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   966: invokestatic 524	com/tencent/mobileqq/startup/step/AVSoUtils:a	()Ljava/lang/String;
    //   969: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: aload_3
    //   973: invokestatic 298	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   976: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: ldc_w 549
    //   982: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokevirtual 530	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   991: astore 23
    //   993: aload 27
    //   995: astore 16
    //   997: aload 23
    //   999: astore 15
    //   1001: aload 23
    //   1003: ifnull -263 -> 740
    //   1006: aload 28
    //   1008: astore 20
    //   1010: aload 23
    //   1012: astore 18
    //   1014: aload 24
    //   1016: astore 22
    //   1018: aload 29
    //   1020: astore 19
    //   1022: aload 23
    //   1024: astore 17
    //   1026: aload 25
    //   1028: astore 21
    //   1030: aload_2
    //   1031: invokevirtual 523	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1034: new 38	java/lang/StringBuilder
    //   1037: dup
    //   1038: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   1041: invokestatic 524	com/tencent/mobileqq/startup/step/AVSoUtils:a	()Ljava/lang/String;
    //   1044: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: aload_3
    //   1048: invokestatic 298	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1051: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc_w 551
    //   1057: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokevirtual 530	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1066: astore 16
    //   1068: aload 23
    //   1070: astore 15
    //   1072: goto -332 -> 740
    //   1075: aload 16
    //   1077: ifnull +86 -> 1163
    //   1080: aload 16
    //   1082: astore 20
    //   1084: aload 15
    //   1086: astore 18
    //   1088: aload_2
    //   1089: astore 22
    //   1091: aload 16
    //   1093: astore 19
    //   1095: aload 15
    //   1097: astore 17
    //   1099: aload_2
    //   1100: astore 21
    //   1102: aload 16
    //   1104: aload 23
    //   1106: iconst_0
    //   1107: aload 23
    //   1109: arraylength
    //   1110: invokevirtual 541	java/io/InputStream:read	([BII)I
    //   1113: istore 5
    //   1115: iload 5
    //   1117: iconst_m1
    //   1118: if_icmpeq +45 -> 1163
    //   1121: aload 16
    //   1123: astore 20
    //   1125: aload 15
    //   1127: astore 18
    //   1129: aload_2
    //   1130: astore 22
    //   1132: aload 16
    //   1134: astore 19
    //   1136: aload 15
    //   1138: astore 17
    //   1140: aload_2
    //   1141: astore 21
    //   1143: aload_2
    //   1144: aload 23
    //   1146: iconst_0
    //   1147: iload 5
    //   1149: invokevirtual 547	java/io/OutputStream:write	([BII)V
    //   1152: lload 8
    //   1154: iload 5
    //   1156: i2l
    //   1157: ladd
    //   1158: lstore 8
    //   1160: goto -85 -> 1075
    //   1163: aload 16
    //   1165: astore 20
    //   1167: aload 15
    //   1169: astore 18
    //   1171: aload_2
    //   1172: astore 22
    //   1174: aload 16
    //   1176: astore 19
    //   1178: aload 15
    //   1180: astore 17
    //   1182: aload_2
    //   1183: astore 21
    //   1185: aload 32
    //   1187: invokevirtual 258	java/io/File:exists	()Z
    //   1190: ifeq +276 -> 1466
    //   1193: aload 16
    //   1195: astore 20
    //   1197: aload 15
    //   1199: astore 18
    //   1201: aload_2
    //   1202: astore 22
    //   1204: aload 16
    //   1206: astore 19
    //   1208: aload 15
    //   1210: astore 17
    //   1212: aload_2
    //   1213: astore 21
    //   1215: lload 8
    //   1217: aload 32
    //   1219: invokevirtual 323	java/io/File:length	()J
    //   1222: lcmp
    //   1223: ifeq +128 -> 1351
    //   1226: aload 16
    //   1228: astore 20
    //   1230: aload 15
    //   1232: astore 18
    //   1234: aload_2
    //   1235: astore 22
    //   1237: aload 16
    //   1239: astore 19
    //   1241: aload 15
    //   1243: astore 17
    //   1245: aload_2
    //   1246: astore 21
    //   1248: aload 32
    //   1250: invokevirtual 261	java/io/File:delete	()Z
    //   1253: pop
    //   1254: aload 16
    //   1256: astore 19
    //   1258: aload 15
    //   1260: astore 17
    //   1262: aload_2
    //   1263: astore 21
    //   1265: ldc 65
    //   1267: iconst_1
    //   1268: new 38	java/lang/StringBuilder
    //   1271: dup
    //   1272: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   1275: ldc_w 553
    //   1278: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: lload_0
    //   1282: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1285: ldc 245
    //   1287: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1293: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1296: iconst_0
    //   1297: istore 12
    //   1299: aload_2
    //   1300: astore 17
    //   1302: aload 17
    //   1304: ifnull +8 -> 1312
    //   1307: aload 17
    //   1309: invokevirtual 556	java/io/OutputStream:close	()V
    //   1312: aload 15
    //   1314: ifnull +8 -> 1322
    //   1317: aload 15
    //   1319: invokevirtual 557	java/io/InputStream:close	()V
    //   1322: iload 12
    //   1324: istore 4
    //   1326: aload 16
    //   1328: ifnull -1002 -> 326
    //   1331: aload 16
    //   1333: invokevirtual 557	java/io/InputStream:close	()V
    //   1336: iload 12
    //   1338: istore 4
    //   1340: goto -1014 -> 326
    //   1343: astore_2
    //   1344: iload 12
    //   1346: istore 4
    //   1348: goto -1022 -> 326
    //   1351: aload 16
    //   1353: astore 20
    //   1355: aload 15
    //   1357: astore 18
    //   1359: aload_2
    //   1360: astore 22
    //   1362: aload 16
    //   1364: astore 19
    //   1366: aload 15
    //   1368: astore 17
    //   1370: aload_2
    //   1371: astore 21
    //   1373: aload 33
    //   1375: aload 34
    //   1377: aload 35
    //   1379: invokestatic 510	com/tencent/mobileqq/startup/step/AVSoUtils:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   1382: aload 16
    //   1384: astore 20
    //   1386: aload 15
    //   1388: astore 18
    //   1390: aload_2
    //   1391: astore 22
    //   1393: aload 16
    //   1395: astore 19
    //   1397: aload 15
    //   1399: astore 17
    //   1401: aload_2
    //   1402: astore 21
    //   1404: ldc 65
    //   1406: iconst_1
    //   1407: new 38	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   1414: ldc_w 559
    //   1417: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: aload 35
    //   1422: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: ldc_w 514
    //   1428: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload 34
    //   1433: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: ldc_w 285
    //   1439: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: lload_0
    //   1443: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1446: ldc 245
    //   1448: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1454: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1457: iconst_1
    //   1458: istore 12
    //   1460: aload_2
    //   1461: astore 17
    //   1463: goto -161 -> 1302
    //   1466: aload 16
    //   1468: astore 20
    //   1470: aload 15
    //   1472: astore 18
    //   1474: aload_2
    //   1475: astore 22
    //   1477: aload 16
    //   1479: astore 19
    //   1481: aload 15
    //   1483: astore 17
    //   1485: aload_2
    //   1486: astore 21
    //   1488: ldc 65
    //   1490: iconst_1
    //   1491: new 38	java/lang/StringBuilder
    //   1494: dup
    //   1495: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   1498: ldc_w 561
    //   1501: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: lload_0
    //   1505: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1508: ldc 245
    //   1510: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1519: iload 13
    //   1521: istore 12
    //   1523: aload_2
    //   1524: astore 17
    //   1526: goto -224 -> 1302
    //   1529: astore 17
    //   1531: aload 22
    //   1533: astore_2
    //   1534: aload 18
    //   1536: astore 15
    //   1538: aload 20
    //   1540: astore 16
    //   1542: aload 17
    //   1544: astore 18
    //   1546: iconst_0
    //   1547: istore 12
    //   1549: aload 16
    //   1551: astore 19
    //   1553: aload 15
    //   1555: astore 17
    //   1557: aload_2
    //   1558: astore 21
    //   1560: ldc 65
    //   1562: iconst_1
    //   1563: new 38	java/lang/StringBuilder
    //   1566: dup
    //   1567: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   1570: ldc_w 563
    //   1573: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: lload_0
    //   1577: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1580: ldc 245
    //   1582: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: aload 18
    //   1590: invokestatic 422	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1593: aload_2
    //   1594: ifnull +7 -> 1601
    //   1597: aload_2
    //   1598: invokevirtual 556	java/io/OutputStream:close	()V
    //   1601: aload 15
    //   1603: ifnull +8 -> 1611
    //   1606: aload 15
    //   1608: invokevirtual 557	java/io/InputStream:close	()V
    //   1611: iload 12
    //   1613: istore 4
    //   1615: aload 16
    //   1617: ifnull -1291 -> 326
    //   1620: aload 16
    //   1622: invokevirtual 557	java/io/InputStream:close	()V
    //   1625: iload 12
    //   1627: istore 4
    //   1629: goto -1303 -> 326
    //   1632: astore_2
    //   1633: iload 12
    //   1635: istore 4
    //   1637: goto -1311 -> 326
    //   1640: astore_2
    //   1641: aload 21
    //   1643: ifnull +8 -> 1651
    //   1646: aload 21
    //   1648: invokevirtual 556	java/io/OutputStream:close	()V
    //   1651: aload 17
    //   1653: ifnull +8 -> 1661
    //   1656: aload 17
    //   1658: invokevirtual 557	java/io/InputStream:close	()V
    //   1661: aload 19
    //   1663: ifnull +8 -> 1671
    //   1666: aload 19
    //   1668: invokevirtual 557	java/io/InputStream:close	()V
    //   1671: aload_2
    //   1672: athrow
    //   1673: ldc 65
    //   1675: iconst_1
    //   1676: new 38	java/lang/StringBuilder
    //   1679: dup
    //   1680: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   1683: ldc_w 565
    //   1686: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1689: lload_0
    //   1690: invokevirtual 55	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1693: ldc 245
    //   1695: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1701: invokestatic 273	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1704: iload 12
    //   1706: istore 4
    //   1708: goto -1382 -> 326
    //   1711: astore_2
    //   1712: goto -400 -> 1312
    //   1715: astore_2
    //   1716: goto -394 -> 1322
    //   1719: astore_2
    //   1720: goto -119 -> 1601
    //   1723: astore_2
    //   1724: goto -113 -> 1611
    //   1727: astore_3
    //   1728: goto -77 -> 1651
    //   1731: astore_3
    //   1732: goto -71 -> 1661
    //   1735: astore_3
    //   1736: goto -65 -> 1671
    //   1739: astore 18
    //   1741: goto -195 -> 1546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1744	0	paramLong	long
    //   0	1744	2	paramContext	Context
    //   0	1744	3	paramString	String
    //   0	1744	4	paramBoolean	boolean
    //   260	895	5	i	int
    //   329	598	6	l1	long
    //   837	379	8	l2	long
    //   226	134	10	l3	long
    //   7	1698	12	bool1	boolean
    //   4	1516	13	bool2	boolean
    //   53	133	14	bool3	boolean
    //   41	864	15	localObject1	Object
    //   931	1	15	localFileNotFoundException	java.io.FileNotFoundException
    //   999	608	15	localObject2	Object
    //   558	1063	16	localObject3	Object
    //   587	938	17	localObject4	Object
    //   1529	14	17	localIOException1	java.io.IOException
    //   1555	102	17	localObject5	Object
    //   575	1014	18	localObject6	Object
    //   1739	1	18	localIOException2	java.io.IOException
    //   583	1084	19	localObject7	Object
    //   571	968	20	localObject8	Object
    //   591	1056	21	localObject9	Object
    //   579	953	22	localObject10	Object
    //   549	596	23	localObject11	Object
    //   540	475	24	localObject12	Object
    //   543	484	25	localObject13	Object
    //   546	195	26	localObject14	Object
    //   567	427	27	localObject15	Object
    //   561	446	28	localObject16	Object
    //   564	455	29	localObject17	Object
    //   552	145	30	localObject18	Object
    //   537	135	31	localObject19	Object
    //   84	1165	32	localFile1	File
    //   16	1358	33	localSharedPreferences	SharedPreferences
    //   21	1411	34	str1	String
    //   27	1394	35	str2	String
    //   46	738	36	str3	String
    //   602	59	37	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   9	185	403	finally
    //   199	217	403	finally
    //   223	242	403	finally
    //   247	270	403	finally
    //   275	281	403	finally
    //   284	326	403	finally
    //   326	400	403	finally
    //   409	471	403	finally
    //   477	529	403	finally
    //   1307	1312	403	finally
    //   1317	1322	403	finally
    //   1331	1336	403	finally
    //   1597	1601	403	finally
    //   1606	1611	403	finally
    //   1620	1625	403	finally
    //   1646	1651	403	finally
    //   1656	1661	403	finally
    //   1666	1671	403	finally
    //   1671	1673	403	finally
    //   1673	1704	403	finally
    //   704	736	931	java/io/FileNotFoundException
    //   1331	1336	1343	java/io/IOException
    //   593	604	1529	java/io/IOException
    //   628	636	1529	java/io/IOException
    //   660	667	1529	java/io/IOException
    //   704	736	1529	java/io/IOException
    //   772	803	1529	java/io/IOException
    //   828	835	1529	java/io/IOException
    //   866	879	1529	java/io/IOException
    //   911	920	1529	java/io/IOException
    //   955	993	1529	java/io/IOException
    //   1030	1068	1529	java/io/IOException
    //   1102	1115	1529	java/io/IOException
    //   1143	1152	1529	java/io/IOException
    //   1185	1193	1529	java/io/IOException
    //   1215	1226	1529	java/io/IOException
    //   1248	1254	1529	java/io/IOException
    //   1373	1382	1529	java/io/IOException
    //   1404	1457	1529	java/io/IOException
    //   1488	1519	1529	java/io/IOException
    //   1620	1625	1632	java/io/IOException
    //   593	604	1640	finally
    //   628	636	1640	finally
    //   660	667	1640	finally
    //   704	736	1640	finally
    //   772	803	1640	finally
    //   828	835	1640	finally
    //   866	879	1640	finally
    //   911	920	1640	finally
    //   955	993	1640	finally
    //   1030	1068	1640	finally
    //   1102	1115	1640	finally
    //   1143	1152	1640	finally
    //   1185	1193	1640	finally
    //   1215	1226	1640	finally
    //   1248	1254	1640	finally
    //   1265	1296	1640	finally
    //   1373	1382	1640	finally
    //   1404	1457	1640	finally
    //   1488	1519	1640	finally
    //   1560	1593	1640	finally
    //   1307	1312	1711	java/io/IOException
    //   1317	1322	1715	java/io/IOException
    //   1597	1601	1719	java/io/IOException
    //   1606	1611	1723	java/io/IOException
    //   1646	1651	1727	java/io/IOException
    //   1656	1661	1731	java/io/IOException
    //   1666	1671	1735	java/io/IOException
    //   1265	1296	1739	java/io/IOException
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
  
  public static String c()
  {
    return AppSetting.g() + SoLoadUtil.a();
  }
  
  public static String c(String paramString)
  {
    return paramString.replace("=", "@1").replace("&", "@2").replace("|", "@3").replace("\"", "@6");
  }
  
  public static void c()
  {
    if ((TextUtils.isEmpty(e())) || (TextUtils.isEmpty(f())))
    {
      d();
      e();
      return;
    }
    ThreadManager.excute(new AVSoUtils.1(), 16, null, false);
  }
  
  public static String d()
  {
    return "-1" + SoLoadUtil.a();
  }
  
  public static String d(String paramString)
  {
    return "key_so_version_" + paramString;
  }
  
  private static void d()
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
  
  private static boolean d()
  {
    Object localObject = a("TcHevcEnc");
    if ((localObject != null) && (((LoadExtResult)localObject).isSucc())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject = ((LoadExtResult)localObject).getSoLoadPath("TcHevcEnc");
        String str = a;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          a = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(File.separator));
        }
        QLog.i("AVModuleExtract", 1, "loadAndDownloadSo. new HevcEncSoDir = " + a + ", old HevcEncSoDir = " + str);
      }
      return bool;
    }
  }
  
  public static String e()
  {
    return a;
  }
  
  private static boolean e()
  {
    Object localObject = a("TcHevcDec2");
    if ((localObject != null) && (((LoadExtResult)localObject).isSucc())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject = ((LoadExtResult)localObject).getSoLoadPath("TcHevcDec2");
        String str = b;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          b = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(File.separator));
        }
        QLog.i("AVModuleExtract", 1, "loadAndDownloadSo. new HevcDecSoDir = " + b + ", old HevcDecSoDir = " + str);
      }
      return bool;
    }
  }
  
  public static String f()
  {
    return b;
  }
  
  public static String g()
  {
    return c;
  }
  
  protected boolean doStep()
  {
    a();
    a(-1046L);
    d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.AVSoUtils
 * JD-Core Version:    0.7.0.1
 */