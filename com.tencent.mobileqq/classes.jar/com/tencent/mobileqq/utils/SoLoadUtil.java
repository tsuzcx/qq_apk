package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class SoLoadUtil
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add("libamrnb.so");
    jdField_a_of_type_JavaUtilSet.add("libcodecsilk.so");
    jdField_a_of_type_JavaUtilSet.add("libSync_mq.so");
  }
  
  private static native int Decode(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    Object localObject = paramContext;
    if (paramContext == null) {}
    for (;;)
    {
      String str;
      try
      {
        localObject = BaseApplicationImpl.getContext();
        paramContext = new File(paramString1);
        if (!paramContext.exists()) {
          paramContext.mkdir();
        }
        str = paramString1 + "tmp_" + BaseApplicationImpl.sProcessId + "_" + Thread.currentThread() + "/";
        paramContext = new File(str);
        paramContext.mkdirs();
        AssetManager localAssetManager = ((Context)localObject).getAssets();
        try
        {
          a((Context)localObject, "DecodeSo", 0, false, false);
          int j = 0;
          if (j <= 1)
          {
            i = Decode(localAssetManager, paramString2, str, "armeabi", paramString3);
            if (i != 0) {}
          }
          else
          {
            if (i == 0) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SoLoadUtil", 2, "decode so fail error: " + i);
            }
            paramContext.delete();
            return i;
          }
          j += 1;
          continue;
          QLog.d("SoLoadUtil", 2, "Unsatisfied Link error: " + paramString2.toString() + "abi:" + a());
        }
        catch (UnsatisfiedLinkError paramString2)
        {
          if (!QLog.isColorLevel()) {
            break label335;
          }
        }
      }
      finally {}
      paramString2 = new File(str + paramString3);
      paramString1 = new File(paramString1 + paramString3);
      if (!paramString1.exists())
      {
        if (!paramString2.renameTo(paramString1)) {
          i = 256;
        }
      }
      else
      {
        paramContext.delete();
        continue;
        label335:
        i = 2;
      }
    }
  }
  
  /* Error */
  private static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 146	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc 148
    //   14: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc 148
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: ldc 156
    //   35: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +9 -> 47
    //   41: ldc 158
    //   43: astore_0
    //   44: goto -21 -> 23
    //   47: invokestatic 160	com/tencent/mobileqq/utils/SoLoadUtil:a	()Z
    //   50: ifeq +9 -> 59
    //   53: ldc 148
    //   55: astore_0
    //   56: goto -33 -> 23
    //   59: ldc 110
    //   61: astore_0
    //   62: goto -39 -> 23
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	56	0	str	String
    //   65	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	65	finally
    //   11	20	65	finally
    //   32	41	65	finally
    //   47	53	65	finally
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "lib/armeabi/";
    }
    return "lib/" + a() + "/";
  }
  
  private static final HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    return localHashMap;
  }
  
  private static final void a(HashMap paramHashMap)
  {
    StatisticCollector.a(BaseApplication.getContext()).a("", "loadSo", false, 0L, 0L, paramHashMap, "");
  }
  
  private static final void a(HashMap paramHashMap, int paramInt, String paramString, long paramLong)
  {
    paramHashMap.put("message", paramString);
    paramHashMap.put("costTime", paramLong + "");
    StatisticCollector.a(paramHashMap, paramInt);
    a(paramHashMap);
  }
  
  public static boolean a()
  {
    String str = System.getProperty("os.arch");
    return (Build.BRAND.equals("asus")) && ((Build.CPU_ABI2.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("i386")) || (str.toLowerCase(Locale.US).contains("i686")) || (str.toLowerCase(Locale.US).contains("i586")) || (str.toLowerCase(Locale.US).contains("i486")));
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramContext, paramString, paramInt, paramBoolean, true);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 119
    //   11: iconst_2
    //   12: new 63	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 289
    //   22: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore 12
    //   40: aload_1
    //   41: invokestatic 296	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   44: astore 23
    //   46: iconst_0
    //   47: istore 7
    //   49: aload_0
    //   50: astore 18
    //   52: aload_0
    //   53: ifnonnull +8 -> 61
    //   56: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   59: astore 18
    //   61: new 63	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   68: aload 18
    //   70: invokevirtual 300	android/content/Context:getFilesDir	()Ljava/io/File;
    //   73: invokevirtual 303	java/io/File:getParent	()Ljava/lang/String;
    //   76: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 305
    //   82: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 27
    //   90: new 63	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   97: aload 18
    //   99: invokevirtual 300	android/content/Context:getFilesDir	()Ljava/io/File;
    //   102: invokevirtual 303	java/io/File:getParent	()Ljava/lang/String;
    //   105: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 307
    //   111: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore_0
    //   118: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +12 -> 133
    //   124: ldc 119
    //   126: iconst_2
    //   127: ldc_w 309
    //   130: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: iload_3
    //   134: ifeq +1697 -> 1831
    //   137: new 53	java/io/File
    //   140: dup
    //   141: new 63	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   148: aload_0
    //   149: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokestatic 311	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 58	java/io/File:exists	()Z
    //   170: istore_3
    //   171: iload_3
    //   172: ifeq +612 -> 784
    //   175: aload_0
    //   176: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: invokestatic 317	java/lang/System:load	(Ljava/lang/String;)V
    //   182: iconst_1
    //   183: istore_3
    //   184: aload 23
    //   186: iconst_0
    //   187: ldc 181
    //   189: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   192: lload 12
    //   194: lsub
    //   195: invokestatic 319	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   198: iload_3
    //   199: istore 4
    //   201: ldc 2
    //   203: monitorexit
    //   204: iload 4
    //   206: ireturn
    //   207: astore_0
    //   208: iload 7
    //   210: istore_3
    //   211: new 63	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   218: ldc 181
    //   220: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 321
    //   226: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokestatic 325	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   233: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore 14
    //   241: iconst_0
    //   242: iconst_2
    //   243: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   246: istore_2
    //   247: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +1592 -> 1842
    //   253: ldc 119
    //   255: iconst_2
    //   256: aload 14
    //   258: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto +1581 -> 1842
    //   264: new 53	java/io/File
    //   267: dup
    //   268: new 63	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   275: aload 27
    //   277: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_1
    //   281: invokestatic 311	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   293: astore 24
    //   295: ldc_w 329
    //   298: invokestatic 335	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   301: invokevirtual 339	java/lang/Integer:intValue	()I
    //   304: istore 5
    //   306: new 63	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 341
    //   316: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_1
    //   320: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: astore_0
    //   327: new 63	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 343
    //   337: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_1
    //   341: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: astore 25
    //   349: aload 18
    //   351: ldc_w 345
    //   354: iconst_0
    //   355: invokevirtual 349	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   358: astore 26
    //   360: aload 26
    //   362: aload_0
    //   363: iconst_m1
    //   364: invokeinterface 355 3 0
    //   369: istore 6
    //   371: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +51 -> 425
    //   377: ldc 119
    //   379: iconst_2
    //   380: new 63	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 357
    //   390: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 359
    //   400: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: iload 6
    //   405: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: ldc_w 361
    //   411: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: iload 5
    //   416: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: iload 6
    //   427: iload 5
    //   429: if_icmpeq +42 -> 471
    //   432: aload 24
    //   434: invokevirtual 58	java/io/File:exists	()Z
    //   437: ifeq +9 -> 446
    //   440: aload 24
    //   442: invokevirtual 129	java/io/File:delete	()Z
    //   445: pop
    //   446: iload 5
    //   448: ifne +382 -> 830
    //   451: aload 26
    //   453: invokeinterface 365 1 0
    //   458: aload_0
    //   459: iconst_m1
    //   460: invokeinterface 371 3 0
    //   465: invokeinterface 374 1 0
    //   470: pop
    //   471: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +30 -> 504
    //   477: ldc 119
    //   479: iconst_2
    //   480: new 63	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 376
    //   490: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: iload 4
    //   495: invokevirtual 379	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   498: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: iload_2
    //   505: istore 5
    //   507: aload 14
    //   509: astore_0
    //   510: aload 24
    //   512: invokevirtual 58	java/io/File:exists	()Z
    //   515: ifne +1348 -> 1863
    //   518: iload 4
    //   520: ifeq +366 -> 886
    //   523: aload 18
    //   525: aload 27
    //   527: ldc_w 381
    //   530: aload_1
    //   531: invokestatic 311	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokestatic 383	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   537: istore 5
    //   539: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq +30 -> 572
    //   545: ldc 119
    //   547: iconst_2
    //   548: new 63	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 385
    //   558: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload 5
    //   563: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: iload 5
    //   574: ifeq +280 -> 854
    //   577: aload 24
    //   579: invokevirtual 129	java/io/File:delete	()Z
    //   582: pop
    //   583: new 63	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   590: aload 14
    //   592: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: ldc_w 387
    //   598: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: astore_0
    //   605: iload_2
    //   606: bipush 8
    //   608: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   611: istore 5
    //   613: iload 5
    //   615: istore_2
    //   616: aload_0
    //   617: astore 14
    //   619: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq +1223 -> 1845
    //   625: ldc 119
    //   627: iconst_2
    //   628: aload_0
    //   629: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: iload 5
    //   634: istore_2
    //   635: aload_0
    //   636: astore 14
    //   638: goto +1207 -> 1845
    //   641: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +12 -> 656
    //   647: ldc 119
    //   649: iconst_2
    //   650: ldc_w 389
    //   653: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: aload 24
    //   658: invokevirtual 58	java/io/File:exists	()Z
    //   661: istore 4
    //   663: iload 4
    //   665: ifeq +1138 -> 1803
    //   668: aload 24
    //   670: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   673: invokestatic 317	java/lang/System:load	(Ljava/lang/String;)V
    //   676: iconst_1
    //   677: istore_3
    //   678: iload_2
    //   679: istore 5
    //   681: aload_0
    //   682: astore 14
    //   684: iload_3
    //   685: ifne +1056 -> 1741
    //   688: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq +12 -> 703
    //   694: ldc 119
    //   696: iconst_2
    //   697: ldc_w 391
    //   700: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_1
    //   704: invokestatic 394	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   707: iconst_1
    //   708: istore_3
    //   709: invokestatic 294	android/os/SystemClock:uptimeMillis	()J
    //   712: lload 12
    //   714: lsub
    //   715: lstore 8
    //   717: aload 23
    //   719: iload_2
    //   720: aload_0
    //   721: lload 8
    //   723: invokestatic 319	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   726: iload_3
    //   727: istore 4
    //   729: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   732: ifeq -531 -> 201
    //   735: ldc 119
    //   737: iconst_2
    //   738: new 63	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   745: ldc_w 396
    //   748: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload_1
    //   752: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: ldc_w 398
    //   758: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: lload 8
    //   763: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   766: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: iload_3
    //   773: istore 4
    //   775: goto -574 -> 201
    //   778: astore_0
    //   779: ldc 2
    //   781: monitorexit
    //   782: aload_0
    //   783: athrow
    //   784: new 63	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   791: ldc 181
    //   793: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: ldc_w 400
    //   799: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: astore 14
    //   807: iconst_0
    //   808: iconst_4
    //   809: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   812: istore_2
    //   813: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   816: ifeq +1035 -> 1851
    //   819: ldc 119
    //   821: iconst_2
    //   822: aload 14
    //   824: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   827: goto +1024 -> 1851
    //   830: aload 26
    //   832: invokeinterface 365 1 0
    //   837: aload_0
    //   838: iload 5
    //   840: invokeinterface 371 3 0
    //   845: invokeinterface 374 1 0
    //   850: pop
    //   851: goto -380 -> 471
    //   854: aload 24
    //   856: invokestatic 406	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   859: lstore 8
    //   861: aload 26
    //   863: invokeinterface 365 1 0
    //   868: aload 25
    //   870: lload 8
    //   872: invokeinterface 410 4 0
    //   877: invokeinterface 374 1 0
    //   882: pop
    //   883: goto +962 -> 1845
    //   886: aconst_null
    //   887: astore 20
    //   889: aconst_null
    //   890: astore 19
    //   892: aconst_null
    //   893: astore 21
    //   895: aconst_null
    //   896: astore_0
    //   897: aload_0
    //   898: astore 17
    //   900: aload 21
    //   902: astore 15
    //   904: aload 20
    //   906: astore 16
    //   908: new 53	java/io/File
    //   911: dup
    //   912: aload 27
    //   914: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   917: astore 22
    //   919: aload_0
    //   920: astore 17
    //   922: aload 21
    //   924: astore 15
    //   926: aload 20
    //   928: astore 16
    //   930: aload 22
    //   932: invokevirtual 58	java/io/File:exists	()Z
    //   935: ifne +26 -> 961
    //   938: aload_0
    //   939: astore 17
    //   941: aload 21
    //   943: astore 15
    //   945: aload 20
    //   947: astore 16
    //   949: aload 22
    //   951: invokevirtual 61	java/io/File:mkdir	()Z
    //   954: istore 4
    //   956: iload 4
    //   958: ifeq +860 -> 1818
    //   961: aload_0
    //   962: astore 17
    //   964: aload 21
    //   966: astore 15
    //   968: aload 20
    //   970: astore 16
    //   972: aload 18
    //   974: invokevirtual 103	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   977: new 63	java/lang/StringBuilder
    //   980: dup
    //   981: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   984: iconst_0
    //   985: invokestatic 412	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   988: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload_1
    //   992: invokestatic 311	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   995: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: invokevirtual 418	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1004: astore 22
    //   1006: aload 22
    //   1008: astore_0
    //   1009: aload_0
    //   1010: astore 17
    //   1012: aload_0
    //   1013: astore 15
    //   1015: aload 20
    //   1017: astore 16
    //   1019: new 420	java/io/FileOutputStream
    //   1022: dup
    //   1023: new 63	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1030: aload 27
    //   1032: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: aload_1
    //   1036: invokestatic 311	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokespecial 421	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1048: astore 18
    //   1050: aload_0
    //   1051: aload 18
    //   1053: invokestatic 427	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   1056: lstore 10
    //   1058: aload 18
    //   1060: ifnull +8 -> 1068
    //   1063: aload 18
    //   1065: invokevirtual 432	java/io/OutputStream:close	()V
    //   1068: iload_2
    //   1069: istore 6
    //   1071: aload 14
    //   1073: astore 15
    //   1075: lload 10
    //   1077: lstore 8
    //   1079: aload_0
    //   1080: ifnull +18 -> 1098
    //   1083: aload_0
    //   1084: invokevirtual 435	java/io/InputStream:close	()V
    //   1087: lload 10
    //   1089: lstore 8
    //   1091: aload 14
    //   1093: astore 15
    //   1095: iload_2
    //   1096: istore 6
    //   1098: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1101: ifeq +12 -> 1113
    //   1104: ldc 119
    //   1106: iconst_2
    //   1107: ldc_w 437
    //   1110: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1113: iload 6
    //   1115: istore 5
    //   1117: aload 15
    //   1119: astore_0
    //   1120: aload 24
    //   1122: invokevirtual 58	java/io/File:exists	()Z
    //   1125: ifeq +738 -> 1863
    //   1128: lload 8
    //   1130: aload 24
    //   1132: invokevirtual 440	java/io/File:length	()J
    //   1135: lcmp
    //   1136: ifeq +276 -> 1412
    //   1139: aload 24
    //   1141: invokevirtual 129	java/io/File:delete	()Z
    //   1144: pop
    //   1145: new 63	java/lang/StringBuilder
    //   1148: dup
    //   1149: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1152: aload 15
    //   1154: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: ldc_w 387
    //   1160: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: astore 14
    //   1168: iload 6
    //   1170: bipush 8
    //   1172: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1175: istore_2
    //   1176: iload_2
    //   1177: istore 5
    //   1179: aload 14
    //   1181: astore_0
    //   1182: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1185: ifeq +678 -> 1863
    //   1188: ldc 119
    //   1190: iconst_2
    //   1191: aload 14
    //   1193: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1196: aload 14
    //   1198: astore_0
    //   1199: goto -558 -> 641
    //   1202: astore 15
    //   1204: aload_0
    //   1205: astore 17
    //   1207: aload 21
    //   1209: astore 15
    //   1211: aload 20
    //   1213: astore 16
    //   1215: aload 18
    //   1217: invokevirtual 103	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1220: new 63	java/lang/StringBuilder
    //   1223: dup
    //   1224: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1227: iconst_1
    //   1228: invokestatic 412	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1231: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: aload_1
    //   1235: invokestatic 311	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1238: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1244: invokevirtual 418	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1247: astore_0
    //   1248: goto -239 -> 1009
    //   1251: astore 15
    //   1253: aload 19
    //   1255: astore 18
    //   1257: aload 17
    //   1259: astore_0
    //   1260: aload 15
    //   1262: astore 17
    //   1264: aload_0
    //   1265: astore 15
    //   1267: aload 18
    //   1269: astore 16
    //   1271: new 63	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1278: aload 14
    //   1280: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: ldc_w 442
    //   1286: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload 17
    //   1291: invokestatic 325	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1294: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1300: astore 14
    //   1302: aload_0
    //   1303: astore 15
    //   1305: aload 18
    //   1307: astore 16
    //   1309: iload_2
    //   1310: bipush 16
    //   1312: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1315: istore 6
    //   1317: aload_0
    //   1318: astore 15
    //   1320: aload 18
    //   1322: astore 16
    //   1324: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1327: ifeq +18 -> 1345
    //   1330: aload_0
    //   1331: astore 15
    //   1333: aload 18
    //   1335: astore 16
    //   1337: ldc 119
    //   1339: iconst_2
    //   1340: aload 14
    //   1342: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1345: aload 18
    //   1347: ifnull +8 -> 1355
    //   1350: aload 18
    //   1352: invokevirtual 432	java/io/OutputStream:close	()V
    //   1355: aload_0
    //   1356: ifnull +450 -> 1806
    //   1359: aload_0
    //   1360: invokevirtual 435	java/io/InputStream:close	()V
    //   1363: ldc2_w 443
    //   1366: lstore 8
    //   1368: aload 14
    //   1370: astore 15
    //   1372: goto -274 -> 1098
    //   1375: astore_0
    //   1376: ldc2_w 443
    //   1379: lstore 8
    //   1381: aload 14
    //   1383: astore 15
    //   1385: goto -287 -> 1098
    //   1388: astore_1
    //   1389: aload 15
    //   1391: astore_0
    //   1392: aload 16
    //   1394: ifnull +8 -> 1402
    //   1397: aload 16
    //   1399: invokevirtual 432	java/io/OutputStream:close	()V
    //   1402: aload_0
    //   1403: ifnull +7 -> 1410
    //   1406: aload_0
    //   1407: invokevirtual 435	java/io/InputStream:close	()V
    //   1410: aload_1
    //   1411: athrow
    //   1412: aload 24
    //   1414: invokestatic 406	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1417: lstore 8
    //   1419: aload 26
    //   1421: invokeinterface 365 1 0
    //   1426: aload 25
    //   1428: lload 8
    //   1430: invokeinterface 410 4 0
    //   1435: invokeinterface 374 1 0
    //   1440: pop
    //   1441: iload 6
    //   1443: istore 5
    //   1445: aload 15
    //   1447: astore_0
    //   1448: goto +415 -> 1863
    //   1451: astore 14
    //   1453: aload 24
    //   1455: invokestatic 406	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1458: lstore 8
    //   1460: aload 26
    //   1462: aload 25
    //   1464: ldc2_w 443
    //   1467: invokeinterface 448 4 0
    //   1472: lstore 10
    //   1474: lload 8
    //   1476: ldc2_w 443
    //   1479: lcmp
    //   1480: ifeq +120 -> 1600
    //   1483: lload 8
    //   1485: lload 10
    //   1487: lcmp
    //   1488: ifeq +112 -> 1600
    //   1491: aload 24
    //   1493: invokevirtual 129	java/io/File:delete	()Z
    //   1496: pop
    //   1497: new 63	java/lang/StringBuilder
    //   1500: dup
    //   1501: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1504: aload_0
    //   1505: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: ldc_w 450
    //   1511: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: lload 8
    //   1516: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1519: ldc_w 452
    //   1522: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: lload 10
    //   1527: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1530: ldc_w 454
    //   1533: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: aload 24
    //   1538: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1541: ldc_w 456
    //   1544: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: aload 14
    //   1549: invokestatic 325	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1552: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1558: astore 14
    //   1560: iload_2
    //   1561: sipush 128
    //   1564: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1567: istore 5
    //   1569: iload 5
    //   1571: istore_2
    //   1572: aload 14
    //   1574: astore_0
    //   1575: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1578: ifeq +291 -> 1869
    //   1581: ldc 119
    //   1583: iconst_2
    //   1584: aload 14
    //   1586: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1589: iconst_0
    //   1590: istore_3
    //   1591: aload 14
    //   1593: astore_0
    //   1594: iload 5
    //   1596: istore_2
    //   1597: goto -919 -> 678
    //   1600: new 63	java/lang/StringBuilder
    //   1603: dup
    //   1604: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1607: aload_0
    //   1608: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: ldc_w 458
    //   1614: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: aload 24
    //   1619: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1622: ldc_w 456
    //   1625: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: aload 14
    //   1630: invokestatic 325	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1633: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1636: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1639: astore 14
    //   1641: iload_2
    //   1642: bipush 32
    //   1644: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1647: istore 5
    //   1649: iload 5
    //   1651: istore_2
    //   1652: aload 14
    //   1654: astore_0
    //   1655: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1658: ifeq +211 -> 1869
    //   1661: ldc 119
    //   1663: iconst_2
    //   1664: aload 14
    //   1666: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1669: iload 5
    //   1671: istore_2
    //   1672: aload 14
    //   1674: astore_0
    //   1675: goto +194 -> 1869
    //   1678: astore 14
    //   1680: new 63	java/lang/StringBuilder
    //   1683: dup
    //   1684: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1687: aload_0
    //   1688: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: ldc_w 460
    //   1694: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: aload 14
    //   1699: invokestatic 325	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1702: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: astore_0
    //   1709: iload_2
    //   1710: bipush 64
    //   1712: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1715: istore_2
    //   1716: iload_2
    //   1717: istore 5
    //   1719: aload_0
    //   1720: astore 14
    //   1722: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1725: ifeq +16 -> 1741
    //   1728: ldc 119
    //   1730: iconst_2
    //   1731: aload_0
    //   1732: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1735: aload_0
    //   1736: astore 14
    //   1738: iload_2
    //   1739: istore 5
    //   1741: iload 5
    //   1743: istore_2
    //   1744: aload 14
    //   1746: astore_0
    //   1747: goto -1038 -> 709
    //   1750: astore 15
    //   1752: goto -684 -> 1068
    //   1755: astore_0
    //   1756: iload_2
    //   1757: istore 6
    //   1759: aload 14
    //   1761: astore 15
    //   1763: lload 10
    //   1765: lstore 8
    //   1767: goto -669 -> 1098
    //   1770: astore 15
    //   1772: goto -417 -> 1355
    //   1775: astore 14
    //   1777: goto -375 -> 1402
    //   1780: astore_0
    //   1781: goto -371 -> 1410
    //   1784: astore_1
    //   1785: aload 18
    //   1787: astore 16
    //   1789: goto -397 -> 1392
    //   1792: astore 17
    //   1794: goto -530 -> 1264
    //   1797: astore_0
    //   1798: iconst_1
    //   1799: istore_3
    //   1800: goto -1589 -> 211
    //   1803: goto -1125 -> 678
    //   1806: ldc2_w 443
    //   1809: lstore 8
    //   1811: aload 14
    //   1813: astore 15
    //   1815: goto -717 -> 1098
    //   1818: aconst_null
    //   1819: astore 18
    //   1821: aconst_null
    //   1822: astore_0
    //   1823: ldc2_w 443
    //   1826: lstore 10
    //   1828: goto -770 -> 1058
    //   1831: iconst_0
    //   1832: istore_2
    //   1833: iconst_0
    //   1834: istore_3
    //   1835: ldc 181
    //   1837: astore 14
    //   1839: goto -1575 -> 264
    //   1842: goto -1578 -> 264
    //   1845: aload 14
    //   1847: astore_0
    //   1848: goto -1207 -> 641
    //   1851: iconst_0
    //   1852: istore_3
    //   1853: goto -1589 -> 264
    //   1856: astore_0
    //   1857: iconst_0
    //   1858: istore 5
    //   1860: goto -1554 -> 306
    //   1863: iload 5
    //   1865: istore_2
    //   1866: goto -1225 -> 641
    //   1869: iconst_0
    //   1870: istore_3
    //   1871: goto -1193 -> 678
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1874	0	paramContext	Context
    //   0	1874	1	paramString	String
    //   0	1874	2	paramInt	int
    //   0	1874	3	paramBoolean1	boolean
    //   0	1874	4	paramBoolean2	boolean
    //   304	1560	5	i	int
    //   369	1389	6	j	int
    //   47	162	7	bool	boolean
    //   715	1095	8	l1	long
    //   1056	771	10	l2	long
    //   38	675	12	l3	long
    //   239	1143	14	localObject1	Object
    //   1451	97	14	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   1558	115	14	str1	String
    //   1678	20	14	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   1720	40	14	localContext1	Context
    //   1775	37	14	localIOException1	java.io.IOException
    //   1837	9	14	str2	String
    //   902	251	15	localObject2	Object
    //   1202	1	15	localException	java.lang.Exception
    //   1209	1	15	localObject3	Object
    //   1251	10	15	localIOException2	java.io.IOException
    //   1265	181	15	localObject4	Object
    //   1750	1	15	localIOException3	java.io.IOException
    //   1761	1	15	localContext2	Context
    //   1770	1	15	localIOException4	java.io.IOException
    //   1813	1	15	localIOException5	java.io.IOException
    //   906	882	16	localObject5	Object
    //   898	392	17	localObject6	Object
    //   1792	1	17	localIOException6	java.io.IOException
    //   50	1770	18	localObject7	Object
    //   890	364	19	localObject8	Object
    //   887	325	20	localObject9	Object
    //   893	315	21	localObject10	Object
    //   917	90	22	localObject11	Object
    //   44	674	23	localHashMap	HashMap
    //   293	1325	24	localFile	File
    //   347	1116	25	str3	String
    //   358	1103	26	localSharedPreferences	android.content.SharedPreferences
    //   88	943	27	str4	String
    // Exception table:
    //   from	to	target	type
    //   175	182	207	java/lang/UnsatisfiedLinkError
    //   3	35	778	finally
    //   35	46	778	finally
    //   56	61	778	finally
    //   61	133	778	finally
    //   137	171	778	finally
    //   175	182	778	finally
    //   184	198	778	finally
    //   211	261	778	finally
    //   264	295	778	finally
    //   295	306	778	finally
    //   306	425	778	finally
    //   432	446	778	finally
    //   451	471	778	finally
    //   471	504	778	finally
    //   510	518	778	finally
    //   523	572	778	finally
    //   577	613	778	finally
    //   619	632	778	finally
    //   641	656	778	finally
    //   656	663	778	finally
    //   668	676	778	finally
    //   688	703	778	finally
    //   703	707	778	finally
    //   709	726	778	finally
    //   729	772	778	finally
    //   784	827	778	finally
    //   830	851	778	finally
    //   854	883	778	finally
    //   1063	1068	778	finally
    //   1083	1087	778	finally
    //   1098	1113	778	finally
    //   1120	1176	778	finally
    //   1182	1196	778	finally
    //   1350	1355	778	finally
    //   1359	1363	778	finally
    //   1397	1402	778	finally
    //   1406	1410	778	finally
    //   1410	1412	778	finally
    //   1412	1441	778	finally
    //   1453	1474	778	finally
    //   1491	1569	778	finally
    //   1575	1589	778	finally
    //   1600	1649	778	finally
    //   1655	1669	778	finally
    //   1680	1716	778	finally
    //   1722	1735	778	finally
    //   972	1006	1202	java/lang/Exception
    //   908	919	1251	java/io/IOException
    //   930	938	1251	java/io/IOException
    //   949	956	1251	java/io/IOException
    //   972	1006	1251	java/io/IOException
    //   1019	1050	1251	java/io/IOException
    //   1215	1248	1251	java/io/IOException
    //   1359	1363	1375	java/io/IOException
    //   908	919	1388	finally
    //   930	938	1388	finally
    //   949	956	1388	finally
    //   972	1006	1388	finally
    //   1019	1050	1388	finally
    //   1215	1248	1388	finally
    //   1271	1302	1388	finally
    //   1309	1317	1388	finally
    //   1324	1330	1388	finally
    //   1337	1345	1388	finally
    //   668	676	1451	java/lang/UnsatisfiedLinkError
    //   703	707	1678	java/lang/UnsatisfiedLinkError
    //   1063	1068	1750	java/io/IOException
    //   1083	1087	1755	java/io/IOException
    //   1350	1355	1770	java/io/IOException
    //   1397	1402	1775	java/io/IOException
    //   1406	1410	1780	java/io/IOException
    //   1050	1058	1784	finally
    //   1050	1058	1792	java/io/IOException
    //   184	198	1797	java/lang/UnsatisfiedLinkError
    //   295	306	1856	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */