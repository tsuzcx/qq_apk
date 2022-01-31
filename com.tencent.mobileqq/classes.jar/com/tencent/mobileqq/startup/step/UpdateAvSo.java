package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class UpdateAvSo
  extends Step
{
  public static long a()
  {
    long l = SystemClock.uptimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 0);
    if (localSharedPreferences.getLong("first_av_lauch_355371", 0L) != 0L) {
      return 0L;
    }
    localSharedPreferences.edit().putLong("first_av_lauch_355371", l).commit();
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
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    b(localBaseApplicationImpl, "SDKCommon", true);
    b(localBaseApplicationImpl, "VideoCtrl", true);
    b(localBaseApplicationImpl, "traeimp-armeabi-v7a", true);
    b(localBaseApplicationImpl, "qav_graphics", true);
    b(localBaseApplicationImpl, "qav_gaudio_engine", true);
    b(localBaseApplicationImpl, "qav_utils", true);
    b(localBaseApplicationImpl, "qav_media_engine", true);
  }
  
  public static boolean a(Context paramContext)
  {
    if (VcSystemInfo.f() <= 2) {
      if ((!a(paramContext, "traeimp-armeabi")) || (!a(paramContext, "TcVpxDec-armeabi")) || (!a(paramContext, "TcVpxEnc-armeabi"))) {}
    }
    while ((a(paramContext, "TcHevcDec")) && (a(paramContext, "TcHevcEnc")) && (a(paramContext, "traeopus-armeabi-v7a")))
    {
      return true;
      return false;
    }
    return false;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/";; paramContext = paramContext.getApplicationInfo().dataDir + "/lib/")
    {
      paramContext = new File(paramContext + a(paramString));
      File localFile = new File(a() + a(paramString));
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
    QLog.d("AVModuleExtract", 1, "start LoadExtractedSo: " + paramString);
    try
    {
      System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
      paramBoolean = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        label97:
        localFile = new File(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
        if (localFile.exists()) {
          localFile.delete();
        }
        b(paramContext, paramString, paramBoolean);
        try
        {
          System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
          paramBoolean = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          paramBoolean = false;
        }
      }
    }
    if (!paramBoolean)
    {
      QLog.d("AVModuleExtract", 1, "LoadExtractedSo finally try to use system way to load so: " + paramString);
      try
      {
        System.loadLibrary(paramString);
        paramBoolean = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
      {
        HashMap localHashMap;
        File localFile;
        break label97;
      }
      if (!paramBoolean)
      {
        QLog.e("AVModuleExtract", 1, "LoadExtractedSo failed: " + paramString);
        localHashMap = new HashMap();
        localHashMap.put("soname", paramString);
        StatisticCollector.a(paramContext).a("", "AV_LOAD_SO_FAILED", false, 0L, 0L, localHashMap, "");
      }
      QLog.d("AVModuleExtract", 1, "LoadExtractedSo = " + paramString + ",result = " + paramBoolean);
      return paramBoolean;
    }
  }
  
  private static long b()
  {
    long l2 = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 0).getLong("first_qq_lauch_355371", 0L);
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
  
  private static void b()
  {
    Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AVModuleExtract", 2, "setQQFirstLauchTime:" + BaseApplicationImpl.appStartTime);
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (BaseApplicationImpl.appStartTime > 0L) {}
    for (long l = BaseApplicationImpl.appStartTime;; l = SystemClock.uptimeMillis())
    {
      ((SharedPreferences.Editor)localObject).putLong("first_qq_lauch_355371", l).commit();
      return;
    }
  }
  
  /* Error */
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 7
    //   9: aload_0
    //   10: ldc 24
    //   12: iconst_0
    //   13: invokevirtual 30	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   16: astore 25
    //   18: ldc 247
    //   20: invokestatic 253	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   23: invokevirtual 256	java/lang/Integer:intValue	()I
    //   26: istore_3
    //   27: new 77	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 258
    //   37: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 26
    //   49: aload 25
    //   51: aload 26
    //   53: iconst_m1
    //   54: invokeinterface 262 3 0
    //   59: istore 4
    //   61: ldc 67
    //   63: iconst_1
    //   64: new 77	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 264
    //   74: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 266
    //   84: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload 4
    //   89: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc_w 271
    //   95: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_3
    //   99: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: invokestatic 164	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   111: astore 28
    //   113: aload 28
    //   115: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: istore 5
    //   120: iload 5
    //   122: ifeq +19 -> 141
    //   125: iconst_0
    //   126: istore 5
    //   128: ldc 2
    //   130: monitorexit
    //   131: iload 5
    //   133: ireturn
    //   134: astore 14
    //   136: iconst_0
    //   137: istore_3
    //   138: goto -111 -> 27
    //   141: new 80	java/io/File
    //   144: dup
    //   145: new 77	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   152: aload 28
    //   154: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore 27
    //   172: iload 4
    //   174: iload_3
    //   175: if_icmpne +17 -> 192
    //   178: aload 27
    //   180: invokevirtual 167	java/io/File:exists	()Z
    //   183: ifeq +9 -> 192
    //   186: iconst_1
    //   187: istore 5
    //   189: goto -61 -> 128
    //   192: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   195: lstore 12
    //   197: aload 27
    //   199: invokevirtual 226	java/io/File:delete	()Z
    //   202: pop
    //   203: iload 7
    //   205: istore 5
    //   207: aload 27
    //   209: invokevirtual 167	java/io/File:exists	()Z
    //   212: ifne +96 -> 308
    //   215: iload_2
    //   216: ifeq +198 -> 414
    //   219: aload_0
    //   220: aload 28
    //   222: ldc_w 279
    //   225: aload_1
    //   226: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   229: invokestatic 284	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   232: istore 4
    //   234: iload 7
    //   236: istore 5
    //   238: aload 27
    //   240: invokevirtual 167	java/io/File:exists	()Z
    //   243: ifeq +65 -> 308
    //   246: iload 4
    //   248: ifeq +114 -> 362
    //   251: aload 27
    //   253: invokevirtual 226	java/io/File:delete	()Z
    //   256: pop
    //   257: new 77	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   264: ldc 75
    //   266: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 286
    //   272: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore_0
    //   279: iconst_0
    //   280: istore 5
    //   282: ldc 67
    //   284: iconst_1
    //   285: new 77	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 288
    //   295: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_0
    //   299: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: invokestatic 16	android/os/SystemClock:uptimeMillis	()J
    //   311: lstore 8
    //   313: ldc 67
    //   315: iconst_1
    //   316: new 77	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 290
    //   326: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_1
    //   330: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 292
    //   336: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: lload 8
    //   341: lload 12
    //   343: lsub
    //   344: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: goto -225 -> 128
    //   356: astore_0
    //   357: ldc 2
    //   359: monitorexit
    //   360: aload_0
    //   361: athrow
    //   362: iload_3
    //   363: ifne +27 -> 390
    //   366: aload 25
    //   368: invokeinterface 42 1 0
    //   373: aload 26
    //   375: iconst_m1
    //   376: invokeinterface 296 3 0
    //   381: invokeinterface 52 1 0
    //   386: pop
    //   387: goto +1032 -> 1419
    //   390: aload 25
    //   392: invokeinterface 42 1 0
    //   397: aload 26
    //   399: iload_3
    //   400: invokeinterface 296 3 0
    //   405: invokeinterface 52 1 0
    //   410: pop
    //   411: goto +1008 -> 1419
    //   414: aconst_null
    //   415: astore 21
    //   417: aconst_null
    //   418: astore 22
    //   420: aconst_null
    //   421: astore 23
    //   423: aconst_null
    //   424: astore 15
    //   426: aconst_null
    //   427: astore 20
    //   429: aconst_null
    //   430: astore 17
    //   432: aconst_null
    //   433: astore 24
    //   435: aconst_null
    //   436: astore 14
    //   438: aload 24
    //   440: astore 18
    //   442: aload 15
    //   444: astore 16
    //   446: aload 22
    //   448: astore 19
    //   450: new 80	java/io/File
    //   453: dup
    //   454: aload 28
    //   456: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   459: astore 29
    //   461: aload 24
    //   463: astore 18
    //   465: aload 15
    //   467: astore 16
    //   469: aload 22
    //   471: astore 19
    //   473: aload 29
    //   475: invokevirtual 167	java/io/File:exists	()Z
    //   478: ifne +30 -> 508
    //   481: aload 24
    //   483: astore 18
    //   485: aload 15
    //   487: astore 16
    //   489: aload 22
    //   491: astore 19
    //   493: aload 29
    //   495: invokevirtual 299	java/io/File:mkdir	()Z
    //   498: istore 5
    //   500: iload 6
    //   502: istore_2
    //   503: iload 5
    //   505: ifeq +533 -> 1038
    //   508: aload 24
    //   510: astore 18
    //   512: aload 15
    //   514: astore 16
    //   516: aload 22
    //   518: astore 19
    //   520: aload_0
    //   521: invokevirtual 303	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   524: new 77	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   531: invokestatic 305	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   534: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_1
    //   538: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   541: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokevirtual 311	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   550: astore 15
    //   552: aload 23
    //   554: astore_0
    //   555: aload 15
    //   557: ifnull +46 -> 603
    //   560: aload 14
    //   562: astore 18
    //   564: aload 15
    //   566: astore 16
    //   568: aload 22
    //   570: astore 19
    //   572: new 313	java/io/FileOutputStream
    //   575: dup
    //   576: new 77	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   583: aload 28
    //   585: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   592: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: iconst_1
    //   599: invokespecial 316	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   602: astore_0
    //   603: lconst_0
    //   604: lstore 8
    //   606: aload 14
    //   608: astore 18
    //   610: aload 15
    //   612: astore 16
    //   614: aload_0
    //   615: astore 19
    //   617: sipush 8192
    //   620: newarray byte
    //   622: astore 17
    //   624: lload 8
    //   626: lstore 10
    //   628: aload 15
    //   630: ifnull +185 -> 815
    //   633: aload 14
    //   635: astore 18
    //   637: aload 15
    //   639: astore 16
    //   641: aload_0
    //   642: astore 19
    //   644: aload 15
    //   646: aload 17
    //   648: iconst_0
    //   649: aload 17
    //   651: arraylength
    //   652: invokevirtual 322	java/io/InputStream:read	([BII)I
    //   655: istore 4
    //   657: lload 8
    //   659: lstore 10
    //   661: iload 4
    //   663: iconst_m1
    //   664: if_icmpeq +151 -> 815
    //   667: aload 14
    //   669: astore 18
    //   671: aload 15
    //   673: astore 16
    //   675: aload_0
    //   676: astore 19
    //   678: aload_0
    //   679: aload 17
    //   681: iconst_0
    //   682: iload 4
    //   684: invokevirtual 328	java/io/OutputStream:write	([BII)V
    //   687: lload 8
    //   689: iload 4
    //   691: i2l
    //   692: ladd
    //   693: lstore 8
    //   695: goto -71 -> 624
    //   698: astore 15
    //   700: aconst_null
    //   701: astore 16
    //   703: aload 24
    //   705: astore 18
    //   707: aload 22
    //   709: astore 19
    //   711: aload_0
    //   712: invokevirtual 303	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   715: new 77	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   722: invokestatic 305	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   725: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload_1
    //   729: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   732: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: ldc_w 330
    //   738: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokevirtual 311	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   747: astore 17
    //   749: aload 17
    //   751: astore 15
    //   753: aload 17
    //   755: ifnull -203 -> 552
    //   758: aload 24
    //   760: astore 18
    //   762: aload 17
    //   764: astore 16
    //   766: aload 22
    //   768: astore 19
    //   770: aload_0
    //   771: invokevirtual 303	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   774: new 77	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   781: invokestatic 305	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   784: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload_1
    //   788: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   791: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: ldc_w 332
    //   797: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokevirtual 311	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   806: astore 14
    //   808: aload 17
    //   810: astore 15
    //   812: goto -260 -> 552
    //   815: aload 14
    //   817: ifnull +64 -> 881
    //   820: aload 14
    //   822: astore 18
    //   824: aload 15
    //   826: astore 16
    //   828: aload_0
    //   829: astore 19
    //   831: aload 14
    //   833: aload 17
    //   835: iconst_0
    //   836: aload 17
    //   838: arraylength
    //   839: invokevirtual 322	java/io/InputStream:read	([BII)I
    //   842: istore 4
    //   844: iload 4
    //   846: iconst_m1
    //   847: if_icmpeq +34 -> 881
    //   850: aload 14
    //   852: astore 18
    //   854: aload 15
    //   856: astore 16
    //   858: aload_0
    //   859: astore 19
    //   861: aload_0
    //   862: aload 17
    //   864: iconst_0
    //   865: iload 4
    //   867: invokevirtual 328	java/io/OutputStream:write	([BII)V
    //   870: lload 10
    //   872: iload 4
    //   874: i2l
    //   875: ladd
    //   876: lstore 10
    //   878: goto -63 -> 815
    //   881: iload 6
    //   883: istore_2
    //   884: aload 14
    //   886: astore 17
    //   888: aload 15
    //   890: astore 20
    //   892: aload_0
    //   893: astore 21
    //   895: aload 14
    //   897: astore 18
    //   899: aload 15
    //   901: astore 16
    //   903: aload_0
    //   904: astore 19
    //   906: aload 27
    //   908: invokevirtual 167	java/io/File:exists	()Z
    //   911: ifeq +127 -> 1038
    //   914: aload 14
    //   916: astore 18
    //   918: aload 15
    //   920: astore 16
    //   922: aload_0
    //   923: astore 19
    //   925: lload 10
    //   927: aload 27
    //   929: invokevirtual 335	java/io/File:length	()J
    //   932: lcmp
    //   933: ifeq +151 -> 1084
    //   936: aload 14
    //   938: astore 18
    //   940: aload 15
    //   942: astore 16
    //   944: aload_0
    //   945: astore 19
    //   947: aload 27
    //   949: invokevirtual 226	java/io/File:delete	()Z
    //   952: pop
    //   953: aload 14
    //   955: astore 18
    //   957: aload 15
    //   959: astore 16
    //   961: aload_0
    //   962: astore 19
    //   964: new 77	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   971: ldc 75
    //   973: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: ldc_w 286
    //   979: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: astore 20
    //   987: aload 14
    //   989: astore 18
    //   991: aload 15
    //   993: astore 16
    //   995: aload_0
    //   996: astore 19
    //   998: ldc 67
    //   1000: iconst_1
    //   1001: new 77	java/lang/StringBuilder
    //   1004: dup
    //   1005: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1008: ldc_w 337
    //   1011: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: aload 20
    //   1016: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1022: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: iconst_0
    //   1026: istore_2
    //   1027: aload_0
    //   1028: astore 21
    //   1030: aload 15
    //   1032: astore 20
    //   1034: aload 14
    //   1036: astore 17
    //   1038: aload 21
    //   1040: ifnull +8 -> 1048
    //   1043: aload 21
    //   1045: invokevirtual 340	java/io/OutputStream:close	()V
    //   1048: aload 20
    //   1050: ifnull +8 -> 1058
    //   1053: aload 20
    //   1055: invokevirtual 341	java/io/InputStream:close	()V
    //   1058: iload_2
    //   1059: istore 5
    //   1061: aload 17
    //   1063: ifnull -755 -> 308
    //   1066: aload 17
    //   1068: invokevirtual 341	java/io/InputStream:close	()V
    //   1071: iload_2
    //   1072: istore 5
    //   1074: goto -766 -> 308
    //   1077: astore_0
    //   1078: iload_2
    //   1079: istore 5
    //   1081: goto -773 -> 308
    //   1084: iload_3
    //   1085: ifne +38 -> 1123
    //   1088: aload 14
    //   1090: astore 18
    //   1092: aload 15
    //   1094: astore 16
    //   1096: aload_0
    //   1097: astore 19
    //   1099: aload 25
    //   1101: invokeinterface 42 1 0
    //   1106: aload 26
    //   1108: iconst_m1
    //   1109: invokeinterface 296 3 0
    //   1114: invokeinterface 52 1 0
    //   1119: pop
    //   1120: goto +305 -> 1425
    //   1123: aload 14
    //   1125: astore 18
    //   1127: aload 15
    //   1129: astore 16
    //   1131: aload_0
    //   1132: astore 19
    //   1134: aload 25
    //   1136: invokeinterface 42 1 0
    //   1141: aload 26
    //   1143: iload_3
    //   1144: invokeinterface 296 3 0
    //   1149: invokeinterface 52 1 0
    //   1154: pop
    //   1155: goto +270 -> 1425
    //   1158: astore 18
    //   1160: aload 14
    //   1162: astore 16
    //   1164: aload 15
    //   1166: astore 14
    //   1168: ldc 75
    //   1170: astore 17
    //   1172: aload_0
    //   1173: astore 15
    //   1175: aload 16
    //   1177: astore_0
    //   1178: aload 18
    //   1180: astore 16
    //   1182: ldc 67
    //   1184: iconst_1
    //   1185: new 77	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1192: ldc_w 343
    //   1195: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload 17
    //   1200: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: aload 16
    //   1208: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1211: aload 15
    //   1213: ifnull +8 -> 1221
    //   1216: aload 15
    //   1218: invokevirtual 340	java/io/OutputStream:close	()V
    //   1221: aload 14
    //   1223: ifnull +8 -> 1231
    //   1226: aload 14
    //   1228: invokevirtual 341	java/io/InputStream:close	()V
    //   1231: aload_0
    //   1232: ifnull +181 -> 1413
    //   1235: aload_0
    //   1236: invokevirtual 341	java/io/InputStream:close	()V
    //   1239: iconst_0
    //   1240: istore 5
    //   1242: goto -934 -> 308
    //   1245: astore_0
    //   1246: iconst_0
    //   1247: istore 5
    //   1249: goto -941 -> 308
    //   1252: astore_0
    //   1253: aload 19
    //   1255: astore 15
    //   1257: aload 15
    //   1259: ifnull +8 -> 1267
    //   1262: aload 15
    //   1264: invokevirtual 340	java/io/OutputStream:close	()V
    //   1267: aload 16
    //   1269: ifnull +8 -> 1277
    //   1272: aload 16
    //   1274: invokevirtual 341	java/io/InputStream:close	()V
    //   1277: aload 18
    //   1279: ifnull +8 -> 1287
    //   1282: aload 18
    //   1284: invokevirtual 341	java/io/InputStream:close	()V
    //   1287: aload_0
    //   1288: athrow
    //   1289: astore_0
    //   1290: goto -242 -> 1048
    //   1293: astore_0
    //   1294: goto -236 -> 1058
    //   1297: astore 15
    //   1299: goto -78 -> 1221
    //   1302: astore 14
    //   1304: goto -73 -> 1231
    //   1307: astore_1
    //   1308: goto -41 -> 1267
    //   1311: astore_1
    //   1312: goto -35 -> 1277
    //   1315: astore_1
    //   1316: goto -29 -> 1287
    //   1319: astore_1
    //   1320: aload_0
    //   1321: astore 18
    //   1323: aload_1
    //   1324: astore_0
    //   1325: aload 14
    //   1327: astore 16
    //   1329: goto -72 -> 1257
    //   1332: astore 16
    //   1334: aconst_null
    //   1335: astore_0
    //   1336: aconst_null
    //   1337: astore 14
    //   1339: aconst_null
    //   1340: astore 15
    //   1342: ldc 75
    //   1344: astore 17
    //   1346: goto -164 -> 1182
    //   1349: astore 16
    //   1351: aconst_null
    //   1352: astore_0
    //   1353: aload 17
    //   1355: astore 14
    //   1357: aconst_null
    //   1358: astore 15
    //   1360: ldc 75
    //   1362: astore 17
    //   1364: goto -182 -> 1182
    //   1367: astore 16
    //   1369: aload 14
    //   1371: astore_0
    //   1372: aload 15
    //   1374: astore 14
    //   1376: aconst_null
    //   1377: astore 15
    //   1379: ldc 75
    //   1381: astore 17
    //   1383: goto -201 -> 1182
    //   1386: astore 16
    //   1388: aload_0
    //   1389: astore 17
    //   1391: aload 20
    //   1393: astore 18
    //   1395: aload 14
    //   1397: astore_0
    //   1398: aload 15
    //   1400: astore 14
    //   1402: aload 17
    //   1404: astore 15
    //   1406: aload 18
    //   1408: astore 17
    //   1410: goto -228 -> 1182
    //   1413: iconst_0
    //   1414: istore 5
    //   1416: goto -1108 -> 308
    //   1419: iconst_1
    //   1420: istore 5
    //   1422: goto -1114 -> 308
    //   1425: iconst_1
    //   1426: istore_2
    //   1427: aload 14
    //   1429: astore 17
    //   1431: aload 15
    //   1433: astore 20
    //   1435: aload_0
    //   1436: astore 21
    //   1438: goto -400 -> 1038
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1441	0	paramContext	Context
    //   0	1441	1	paramString	String
    //   0	1441	2	paramBoolean	boolean
    //   26	1118	3	i	int
    //   59	814	4	j	int
    //   118	1303	5	bool1	boolean
    //   4	878	6	bool2	boolean
    //   7	228	7	bool3	boolean
    //   311	383	8	l1	long
    //   626	300	10	l2	long
    //   195	147	12	l3	long
    //   134	1	14	localNumberFormatException	java.lang.NumberFormatException
    //   436	791	14	localObject1	Object
    //   1302	24	14	localIOException1	java.io.IOException
    //   1337	91	14	localObject2	Object
    //   424	248	15	localInputStream	java.io.InputStream
    //   698	1	15	localFileNotFoundException	java.io.FileNotFoundException
    //   751	512	15	localObject3	Object
    //   1297	1	15	localIOException2	java.io.IOException
    //   1340	92	15	localObject4	Object
    //   444	884	16	localObject5	Object
    //   1332	1	16	localIOException3	java.io.IOException
    //   1349	1	16	localIOException4	java.io.IOException
    //   1367	1	16	localIOException5	java.io.IOException
    //   1386	1	16	localIOException6	java.io.IOException
    //   430	1000	17	localObject6	Object
    //   440	686	18	localObject7	Object
    //   1158	125	18	localIOException7	java.io.IOException
    //   1321	86	18	localObject8	Object
    //   448	806	19	localObject9	Object
    //   427	1007	20	localObject10	Object
    //   415	1022	21	localContext	Context
    //   418	349	22	localObject11	Object
    //   421	132	23	localObject12	Object
    //   433	326	24	localObject13	Object
    //   16	1119	25	localSharedPreferences	SharedPreferences
    //   47	1095	26	str1	String
    //   170	778	27	localFile1	File
    //   111	473	28	str2	String
    //   459	35	29	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   18	27	134	java/lang/NumberFormatException
    //   9	18	356	finally
    //   18	27	356	finally
    //   27	120	356	finally
    //   141	172	356	finally
    //   178	186	356	finally
    //   192	203	356	finally
    //   207	215	356	finally
    //   219	234	356	finally
    //   238	246	356	finally
    //   251	279	356	finally
    //   282	308	356	finally
    //   308	353	356	finally
    //   366	387	356	finally
    //   390	411	356	finally
    //   1043	1048	356	finally
    //   1053	1058	356	finally
    //   1066	1071	356	finally
    //   1216	1221	356	finally
    //   1226	1231	356	finally
    //   1235	1239	356	finally
    //   1262	1267	356	finally
    //   1272	1277	356	finally
    //   1282	1287	356	finally
    //   1287	1289	356	finally
    //   520	552	698	java/io/FileNotFoundException
    //   1066	1071	1077	java/io/IOException
    //   617	624	1158	java/io/IOException
    //   644	657	1158	java/io/IOException
    //   678	687	1158	java/io/IOException
    //   831	844	1158	java/io/IOException
    //   861	870	1158	java/io/IOException
    //   906	914	1158	java/io/IOException
    //   925	936	1158	java/io/IOException
    //   947	953	1158	java/io/IOException
    //   964	987	1158	java/io/IOException
    //   1099	1120	1158	java/io/IOException
    //   1134	1155	1158	java/io/IOException
    //   1235	1239	1245	java/io/IOException
    //   450	461	1252	finally
    //   473	481	1252	finally
    //   493	500	1252	finally
    //   520	552	1252	finally
    //   572	603	1252	finally
    //   617	624	1252	finally
    //   644	657	1252	finally
    //   678	687	1252	finally
    //   711	749	1252	finally
    //   770	808	1252	finally
    //   831	844	1252	finally
    //   861	870	1252	finally
    //   906	914	1252	finally
    //   925	936	1252	finally
    //   947	953	1252	finally
    //   964	987	1252	finally
    //   998	1025	1252	finally
    //   1099	1120	1252	finally
    //   1134	1155	1252	finally
    //   1043	1048	1289	java/io/IOException
    //   1053	1058	1293	java/io/IOException
    //   1216	1221	1297	java/io/IOException
    //   1226	1231	1302	java/io/IOException
    //   1262	1267	1307	java/io/IOException
    //   1272	1277	1311	java/io/IOException
    //   1282	1287	1315	java/io/IOException
    //   1182	1211	1319	finally
    //   450	461	1332	java/io/IOException
    //   473	481	1332	java/io/IOException
    //   493	500	1332	java/io/IOException
    //   520	552	1332	java/io/IOException
    //   711	749	1332	java/io/IOException
    //   770	808	1349	java/io/IOException
    //   572	603	1367	java/io/IOException
    //   998	1025	1386	java/io/IOException
  }
  
  protected boolean a()
  {
    a();
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateAvSo
 * JD-Core Version:    0.7.0.1
 */