package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import awrn;
import com.tencent.common.app.BaseApplicationImpl;
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
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
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
              QLog.w("SoLoadUtil", 1, "unCompress7zSo fail, res[" + i + "], tempDirFile[" + paramContext.getAbsolutePath() + "], exists[" + paramContext.exists() + "]");
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
            break label364;
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
        label364:
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
    //   3: getstatic 162	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc 164
    //   14: invokevirtual 170	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc 164
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: ldc 172
    //   35: invokevirtual 170	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +9 -> 47
    //   41: ldc 174
    //   43: astore_0
    //   44: goto -21 -> 23
    //   47: invokestatic 177	com/tencent/mobileqq/utils/SoLoadUtil:b	()Z
    //   50: ifeq +9 -> 59
    //   53: ldc 164
    //   55: astore_0
    //   56: goto -33 -> 23
    //   59: ldc 111
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
  
  private static final HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    return localHashMap;
  }
  
  private static final void a(HashMap<String, String> paramHashMap)
  {
    awrn.a(BaseApplication.getContext()).a("", "loadSo", false, 0L, 0L, paramHashMap, "");
  }
  
  private static final void a(HashMap<String, String> paramHashMap, int paramInt, String paramString, long paramLong)
  {
    paramHashMap.put("message", paramString);
    paramHashMap.put("costTime", paramLong + "");
    awrn.a(paramHashMap, paramInt);
    a(paramHashMap);
  }
  
  public static boolean a()
  {
    return ((!TextUtils.isEmpty(Build.CPU_ABI)) && (Build.CPU_ABI.contains("x86"))) || ((!TextUtils.isEmpty(Build.CPU_ABI2)) && (Build.CPU_ABI2.contains("x86"))) || (b());
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
    //   3: getstatic 283	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 18
    //   8: if_icmpge +42 -> 50
    //   11: aload_1
    //   12: ldc_w 285
    //   15: invokevirtual 288	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +32 -> 50
    //   21: aload_0
    //   22: ldc_w 290
    //   25: iconst_0
    //   26: iconst_0
    //   27: iconst_1
    //   28: invokestatic 109	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZZ)Z
    //   31: ifne +19 -> 50
    //   34: ldc 120
    //   36: iconst_1
    //   37: ldc_w 292
    //   40: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: iconst_0
    //   44: istore_3
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_3
    //   49: ireturn
    //   50: invokestatic 299	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   53: lstore 9
    //   55: ldc 120
    //   57: iconst_1
    //   58: new 64	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 301
    //   68: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 303
    //   78: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_3
    //   82: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc_w 305
    //   88: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload 4
    //   93: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc_w 307
    //   99: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: lload 9
    //   104: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: ldc 135
    //   109: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   121: lstore 11
    //   123: aload_1
    //   124: invokestatic 314	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   127: astore 24
    //   129: iconst_0
    //   130: istore 6
    //   132: aload_0
    //   133: astore 19
    //   135: aload_0
    //   136: ifnonnull +8 -> 144
    //   139: invokestatic 52	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   142: astore 19
    //   144: new 64	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   151: aload 19
    //   153: invokevirtual 318	android/content/Context:getFilesDir	()Ljava/io/File;
    //   156: invokevirtual 321	java/io/File:getParent	()Ljava/lang/String;
    //   159: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 323
    //   165: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 28
    //   173: new 64	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   180: aload 19
    //   182: invokevirtual 318	android/content/Context:getFilesDir	()Ljava/io/File;
    //   185: invokevirtual 321	java/io/File:getParent	()Ljava/lang/String;
    //   188: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 325
    //   194: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore_0
    //   201: iload_3
    //   202: ifeq +1711 -> 1913
    //   205: new 54	java/io/File
    //   208: dup
    //   209: new 64	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   216: aload_0
    //   217: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 59	java/io/File:exists	()Z
    //   238: istore_3
    //   239: iload_3
    //   240: ifeq +740 -> 980
    //   243: aload_0
    //   244: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   247: invokestatic 330	java/lang/System:load	(Ljava/lang/String;)V
    //   250: iconst_1
    //   251: istore_3
    //   252: aload 24
    //   254: iconst_0
    //   255: ldc 198
    //   257: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   260: lload 11
    //   262: lsub
    //   263: invokestatic 332	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   266: goto -221 -> 45
    //   269: astore_0
    //   270: iconst_1
    //   271: istore_3
    //   272: new 64	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   279: ldc 198
    //   281: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 334
    //   287: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_0
    //   291: invokestatic 338	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   294: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore_0
    //   301: iconst_0
    //   302: iconst_2
    //   303: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   306: istore_2
    //   307: ldc 120
    //   309: iconst_1
    //   310: aload_0
    //   311: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: new 54	java/io/File
    //   317: dup
    //   318: new 64	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   325: aload 28
    //   327: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_1
    //   331: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   334: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: astore 25
    //   345: ldc 198
    //   347: astore 15
    //   349: new 64	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 342
    //   359: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_1
    //   363: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: astore 17
    //   371: new 64	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 344
    //   381: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: astore 26
    //   393: aload 19
    //   395: ldc_w 346
    //   398: iconst_4
    //   399: invokevirtual 350	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   402: astore 27
    //   404: aload 27
    //   406: aload 17
    //   408: ldc 198
    //   410: invokeinterface 356 3 0
    //   415: astore 18
    //   417: invokestatic 361	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   420: astore 16
    //   422: aload 16
    //   424: astore 15
    //   426: aload 15
    //   428: aload 18
    //   430: invokevirtual 288	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: istore 6
    //   435: iload 6
    //   437: ifne +1492 -> 1929
    //   440: iconst_1
    //   441: istore 6
    //   443: invokestatic 363	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   446: ifeq +78 -> 524
    //   449: ldc 120
    //   451: iconst_1
    //   452: new 64	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 365
    //   462: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc_w 367
    //   472: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 18
    //   477: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc_w 369
    //   483: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 15
    //   488: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w 371
    //   494: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: iload 6
    //   499: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   502: ldc_w 307
    //   505: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: lload 9
    //   510: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   513: ldc 135
    //   515: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: iload 6
    //   526: ifeq +93 -> 619
    //   529: aload 25
    //   531: invokevirtual 59	java/io/File:exists	()Z
    //   534: ifeq +64 -> 598
    //   537: aload 25
    //   539: invokevirtual 142	java/io/File:delete	()Z
    //   542: istore 6
    //   544: iload 6
    //   546: ifeq +9 -> 555
    //   549: invokestatic 363	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   552: ifeq +46 -> 598
    //   555: ldc 120
    //   557: iconst_1
    //   558: new 64	java/lang/StringBuilder
    //   561: dup
    //   562: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   565: ldc_w 373
    //   568: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: iload 6
    //   573: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   576: ldc_w 307
    //   579: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: lload 9
    //   584: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   587: ldc 135
    //   589: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: aload 27
    //   600: invokeinterface 377 1 0
    //   605: aload 17
    //   607: aload 15
    //   609: invokeinterface 383 3 0
    //   614: invokeinterface 386 1 0
    //   619: aload 25
    //   621: invokevirtual 59	java/io/File:exists	()Z
    //   624: ifne +1283 -> 1907
    //   627: iload 4
    //   629: ifeq +423 -> 1052
    //   632: aload 19
    //   634: aload 28
    //   636: ldc_w 388
    //   639: aload_1
    //   640: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   643: invokestatic 390	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   646: istore 5
    //   648: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   651: ifeq +46 -> 697
    //   654: ldc 120
    //   656: iconst_1
    //   657: new 64	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 392
    //   667: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: iload 5
    //   672: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   675: ldc_w 307
    //   678: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: lload 9
    //   683: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   686: ldc 135
    //   688: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   697: iload 5
    //   699: ifeq +321 -> 1020
    //   702: aload 25
    //   704: invokevirtual 142	java/io/File:delete	()Z
    //   707: pop
    //   708: new 64	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   715: aload_0
    //   716: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: ldc_w 394
    //   722: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_1
    //   726: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: astore_0
    //   733: iload_2
    //   734: bipush 8
    //   736: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   739: istore_2
    //   740: ldc 120
    //   742: iconst_1
    //   743: aload_0
    //   744: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: goto +1176 -> 1923
    //   750: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   753: ifeq +59 -> 812
    //   756: ldc 120
    //   758: iconst_1
    //   759: new 64	java/lang/StringBuilder
    //   762: dup
    //   763: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   766: ldc_w 365
    //   769: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: aload_1
    //   773: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: ldc_w 396
    //   779: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload 25
    //   784: invokevirtual 59	java/io/File:exists	()Z
    //   787: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   790: ldc_w 307
    //   793: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: lload 9
    //   798: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   801: ldc 135
    //   803: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: aload 25
    //   814: invokevirtual 59	java/io/File:exists	()Z
    //   817: istore 4
    //   819: iload 4
    //   821: ifeq +1055 -> 1876
    //   824: aload 25
    //   826: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   829: invokestatic 330	java/lang/System:load	(Ljava/lang/String;)V
    //   832: aload 15
    //   834: astore_0
    //   835: iconst_1
    //   836: istore_3
    //   837: iload_2
    //   838: istore 5
    //   840: aload_0
    //   841: astore 15
    //   843: iload_3
    //   844: ifne +980 -> 1824
    //   847: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   850: ifeq +35 -> 885
    //   853: ldc 120
    //   855: iconst_1
    //   856: new 64	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   863: ldc_w 398
    //   866: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: lload 9
    //   871: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   874: ldc 135
    //   876: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: aload_1
    //   886: invokestatic 401	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   889: iconst_1
    //   890: istore_3
    //   891: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   894: lload 11
    //   896: lsub
    //   897: lstore 7
    //   899: aload 24
    //   901: iload_2
    //   902: aload_0
    //   903: lload 7
    //   905: invokestatic 332	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   908: ldc 120
    //   910: iconst_1
    //   911: new 64	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   918: ldc_w 365
    //   921: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload_1
    //   925: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: ldc_w 403
    //   931: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: lload 7
    //   936: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   939: ldc_w 405
    //   942: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: iload_3
    //   946: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   949: ldc_w 307
    //   952: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: lload 9
    //   957: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   960: ldc 135
    //   962: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   971: goto -926 -> 45
    //   974: astore_0
    //   975: ldc 2
    //   977: monitorexit
    //   978: aload_0
    //   979: athrow
    //   980: new 64	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   987: ldc 198
    //   989: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: ldc_w 407
    //   995: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: astore_0
    //   1002: iconst_0
    //   1003: iconst_4
    //   1004: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1007: istore_2
    //   1008: ldc 120
    //   1010: iconst_1
    //   1011: aload_0
    //   1012: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1015: iconst_0
    //   1016: istore_3
    //   1017: goto -703 -> 314
    //   1020: aload 25
    //   1022: invokestatic 413	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1025: lstore 7
    //   1027: aload 27
    //   1029: invokeinterface 377 1 0
    //   1034: aload 26
    //   1036: lload 7
    //   1038: invokeinterface 417 4 0
    //   1043: invokeinterface 420 1 0
    //   1048: pop
    //   1049: goto +874 -> 1923
    //   1052: aconst_null
    //   1053: astore 21
    //   1055: aconst_null
    //   1056: astore 20
    //   1058: aconst_null
    //   1059: astore 22
    //   1061: aconst_null
    //   1062: astore 23
    //   1064: aconst_null
    //   1065: astore 15
    //   1067: aload 22
    //   1069: astore 18
    //   1071: aload 23
    //   1073: astore 16
    //   1075: aload 21
    //   1077: astore 17
    //   1079: new 54	java/io/File
    //   1082: dup
    //   1083: aload 28
    //   1085: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   1088: astore 29
    //   1090: aload 22
    //   1092: astore 18
    //   1094: aload 23
    //   1096: astore 16
    //   1098: aload 21
    //   1100: astore 17
    //   1102: aload 29
    //   1104: invokevirtual 59	java/io/File:exists	()Z
    //   1107: ifne +27 -> 1134
    //   1110: aload 22
    //   1112: astore 18
    //   1114: aload 23
    //   1116: astore 16
    //   1118: aload 21
    //   1120: astore 17
    //   1122: aload 29
    //   1124: invokevirtual 62	java/io/File:mkdir	()Z
    //   1127: istore 4
    //   1129: iload 4
    //   1131: ifeq +765 -> 1896
    //   1134: aload 22
    //   1136: astore 18
    //   1138: aload 23
    //   1140: astore 16
    //   1142: aload 21
    //   1144: astore 17
    //   1146: aload 19
    //   1148: invokevirtual 104	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1151: new 64	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1158: iconst_0
    //   1159: invokestatic 422	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1162: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: aload_1
    //   1166: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1169: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokevirtual 428	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1178: astore 15
    //   1180: aload 15
    //   1182: astore 18
    //   1184: aload 15
    //   1186: astore 16
    //   1188: aload 21
    //   1190: astore 17
    //   1192: new 430	java/io/FileOutputStream
    //   1195: dup
    //   1196: new 64	java/lang/StringBuilder
    //   1199: dup
    //   1200: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1203: aload 28
    //   1205: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: aload_1
    //   1209: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1212: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1218: invokespecial 431	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1221: astore 19
    //   1223: aload 15
    //   1225: aload 19
    //   1227: invokestatic 437	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   1230: lstore 7
    //   1232: aload 19
    //   1234: ifnull +8 -> 1242
    //   1237: aload 19
    //   1239: invokevirtual 442	java/io/OutputStream:close	()V
    //   1242: aload 15
    //   1244: ifnull +646 -> 1890
    //   1247: aload 15
    //   1249: invokevirtual 445	java/io/InputStream:close	()V
    //   1252: iload_2
    //   1253: istore 5
    //   1255: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1258: ifeq +12 -> 1270
    //   1261: ldc 120
    //   1263: iconst_2
    //   1264: ldc_w 447
    //   1267: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1270: iload 5
    //   1272: istore_2
    //   1273: aload_0
    //   1274: astore 15
    //   1276: aload 25
    //   1278: invokevirtual 59	java/io/File:exists	()Z
    //   1281: ifeq -531 -> 750
    //   1284: lload 7
    //   1286: aload 25
    //   1288: invokevirtual 450	java/io/File:length	()J
    //   1291: lcmp
    //   1292: ifeq +258 -> 1550
    //   1295: aload 25
    //   1297: invokevirtual 142	java/io/File:delete	()Z
    //   1300: pop
    //   1301: new 64	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1308: aload_0
    //   1309: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: ldc_w 452
    //   1315: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: astore 15
    //   1323: iload 5
    //   1325: bipush 8
    //   1327: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1330: istore_2
    //   1331: ldc 120
    //   1333: iconst_1
    //   1334: aload 15
    //   1336: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1339: goto -589 -> 750
    //   1342: astore 15
    //   1344: aload 22
    //   1346: astore 18
    //   1348: aload 23
    //   1350: astore 16
    //   1352: aload 21
    //   1354: astore 17
    //   1356: aload 19
    //   1358: invokevirtual 104	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1361: new 64	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1368: iconst_1
    //   1369: invokestatic 422	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1372: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: aload_1
    //   1376: invokestatic 327	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1379: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1385: invokevirtual 428	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1388: astore 15
    //   1390: goto -210 -> 1180
    //   1393: astore 15
    //   1395: iload_2
    //   1396: istore 5
    //   1398: goto -143 -> 1255
    //   1401: astore 16
    //   1403: aload 20
    //   1405: astore 19
    //   1407: aload 18
    //   1409: astore 15
    //   1411: aload 16
    //   1413: astore 18
    //   1415: aload 15
    //   1417: astore 16
    //   1419: aload 19
    //   1421: astore 17
    //   1423: new 64	java/lang/StringBuilder
    //   1426: dup
    //   1427: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1430: aload_0
    //   1431: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: ldc_w 454
    //   1437: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: aload 18
    //   1442: invokestatic 338	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1445: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: astore_0
    //   1452: aload 15
    //   1454: astore 16
    //   1456: aload 19
    //   1458: astore 17
    //   1460: iload_2
    //   1461: bipush 16
    //   1463: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1466: istore 5
    //   1468: aload 15
    //   1470: astore 16
    //   1472: aload 19
    //   1474: astore 17
    //   1476: ldc 120
    //   1478: iconst_1
    //   1479: aload_0
    //   1480: aload 18
    //   1482: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1485: aload 19
    //   1487: ifnull +8 -> 1495
    //   1490: aload 19
    //   1492: invokevirtual 442	java/io/OutputStream:close	()V
    //   1495: aload 15
    //   1497: ifnull +385 -> 1882
    //   1500: aload 15
    //   1502: invokevirtual 445	java/io/InputStream:close	()V
    //   1505: ldc2_w 458
    //   1508: lstore 7
    //   1510: goto -255 -> 1255
    //   1513: astore 15
    //   1515: ldc2_w 458
    //   1518: lstore 7
    //   1520: goto -265 -> 1255
    //   1523: astore_0
    //   1524: aload 16
    //   1526: astore 15
    //   1528: aload 17
    //   1530: ifnull +8 -> 1538
    //   1533: aload 17
    //   1535: invokevirtual 442	java/io/OutputStream:close	()V
    //   1538: aload 15
    //   1540: ifnull +8 -> 1548
    //   1543: aload 15
    //   1545: invokevirtual 445	java/io/InputStream:close	()V
    //   1548: aload_0
    //   1549: athrow
    //   1550: aload 25
    //   1552: invokestatic 413	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1555: lstore 7
    //   1557: aload 27
    //   1559: invokeinterface 377 1 0
    //   1564: aload 26
    //   1566: lload 7
    //   1568: invokeinterface 417 4 0
    //   1573: invokeinterface 420 1 0
    //   1578: pop
    //   1579: iload 5
    //   1581: istore_2
    //   1582: aload_0
    //   1583: astore 15
    //   1585: goto -835 -> 750
    //   1588: astore_0
    //   1589: aload 25
    //   1591: invokestatic 413	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1594: lstore 7
    //   1596: aload 27
    //   1598: aload 26
    //   1600: ldc2_w 458
    //   1603: invokeinterface 463 4 0
    //   1608: lstore 13
    //   1610: lload 7
    //   1612: ldc2_w 458
    //   1615: lcmp
    //   1616: ifeq +99 -> 1715
    //   1619: lload 7
    //   1621: lload 13
    //   1623: lcmp
    //   1624: ifeq +91 -> 1715
    //   1627: aload 25
    //   1629: invokevirtual 142	java/io/File:delete	()Z
    //   1632: pop
    //   1633: new 64	java/lang/StringBuilder
    //   1636: dup
    //   1637: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1640: aload 15
    //   1642: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: ldc_w 465
    //   1648: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: lload 7
    //   1653: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1656: ldc_w 467
    //   1659: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: lload 13
    //   1664: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1667: ldc_w 469
    //   1670: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: aload 25
    //   1675: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1678: ldc_w 471
    //   1681: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: aload_0
    //   1685: invokestatic 338	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1688: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1694: astore_0
    //   1695: iload_2
    //   1696: sipush 128
    //   1699: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1702: istore_2
    //   1703: ldc 120
    //   1705: iconst_1
    //   1706: aload_0
    //   1707: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1710: iconst_0
    //   1711: istore_3
    //   1712: goto -875 -> 837
    //   1715: new 64	java/lang/StringBuilder
    //   1718: dup
    //   1719: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1722: aload 15
    //   1724: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: ldc_w 473
    //   1730: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: aload 25
    //   1735: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1738: ldc_w 471
    //   1741: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: aload_0
    //   1745: invokestatic 338	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1748: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1754: astore_0
    //   1755: iload_2
    //   1756: bipush 32
    //   1758: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1761: istore_2
    //   1762: ldc 120
    //   1764: iconst_1
    //   1765: aload_0
    //   1766: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1769: iconst_0
    //   1770: istore_3
    //   1771: goto -934 -> 837
    //   1774: astore 16
    //   1776: new 64	java/lang/StringBuilder
    //   1779: dup
    //   1780: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1783: aload_0
    //   1784: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: ldc_w 475
    //   1790: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: aload 16
    //   1795: invokestatic 338	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1798: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1804: astore 15
    //   1806: iload_2
    //   1807: bipush 64
    //   1809: invokestatic 340	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1812: istore 5
    //   1814: ldc 120
    //   1816: iconst_1
    //   1817: aload 15
    //   1819: aload 16
    //   1821: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1824: iload 5
    //   1826: istore_2
    //   1827: aload 15
    //   1829: astore_0
    //   1830: goto -939 -> 891
    //   1833: astore 16
    //   1835: goto -593 -> 1242
    //   1838: astore 16
    //   1840: goto -345 -> 1495
    //   1843: astore_1
    //   1844: goto -306 -> 1538
    //   1847: astore_1
    //   1848: goto -300 -> 1548
    //   1851: astore_0
    //   1852: aload 19
    //   1854: astore 17
    //   1856: goto -328 -> 1528
    //   1859: astore 18
    //   1861: goto -446 -> 1415
    //   1864: astore 16
    //   1866: goto +71 -> 1937
    //   1869: astore_0
    //   1870: iload 6
    //   1872: istore_3
    //   1873: goto -1601 -> 272
    //   1876: aload 15
    //   1878: astore_0
    //   1879: goto -1042 -> 837
    //   1882: ldc2_w 458
    //   1885: lstore 7
    //   1887: goto -632 -> 1255
    //   1890: iload_2
    //   1891: istore 5
    //   1893: goto -638 -> 1255
    //   1896: aconst_null
    //   1897: astore 19
    //   1899: ldc2_w 458
    //   1902: lstore 7
    //   1904: goto -672 -> 1232
    //   1907: aload_0
    //   1908: astore 15
    //   1910: goto -1160 -> 750
    //   1913: iconst_0
    //   1914: istore_3
    //   1915: iconst_0
    //   1916: istore_2
    //   1917: ldc 198
    //   1919: astore_0
    //   1920: goto -1606 -> 314
    //   1923: aload_0
    //   1924: astore 15
    //   1926: goto -1176 -> 750
    //   1929: iconst_0
    //   1930: istore 6
    //   1932: goto -1489 -> 443
    //   1935: astore 16
    //   1937: iconst_0
    //   1938: istore 6
    //   1940: goto -1497 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1943	0	paramContext	Context
    //   0	1943	1	paramString	String
    //   0	1943	2	paramInt	int
    //   0	1943	3	paramBoolean1	boolean
    //   0	1943	4	paramBoolean2	boolean
    //   646	1246	5	i	int
    //   130	1809	6	bool	boolean
    //   897	1006	7	l1	long
    //   53	903	9	l2	long
    //   121	774	11	l3	long
    //   1608	55	13	l4	long
    //   347	988	15	localObject1	Object
    //   1342	1	15	localException1	java.lang.Exception
    //   1388	1	15	localInputStream	java.io.InputStream
    //   1393	1	15	localIOException1	java.io.IOException
    //   1409	92	15	localObject2	Object
    //   1513	1	15	localIOException2	java.io.IOException
    //   1526	399	15	localObject3	Object
    //   420	931	16	localObject4	Object
    //   1401	11	16	localIOException3	java.io.IOException
    //   1417	108	16	localObject5	Object
    //   1774	46	16	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   1833	1	16	localIOException4	java.io.IOException
    //   1838	1	16	localIOException5	java.io.IOException
    //   1864	1	16	localException2	java.lang.Exception
    //   1935	1	16	localException3	java.lang.Exception
    //   369	1486	17	localObject6	Object
    //   415	1066	18	localObject7	Object
    //   1859	1	18	localIOException6	java.io.IOException
    //   133	1765	19	localObject8	Object
    //   1056	348	20	localObject9	Object
    //   1053	300	21	localObject10	Object
    //   1059	286	22	localObject11	Object
    //   1062	287	23	localObject12	Object
    //   127	773	24	localHashMap	HashMap
    //   343	1391	25	localFile1	File
    //   391	1208	26	str1	String
    //   402	1195	27	localSharedPreferences	android.content.SharedPreferences
    //   171	1033	28	str2	String
    //   1088	35	29	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   252	266	269	java/lang/UnsatisfiedLinkError
    //   3	43	974	finally
    //   50	129	974	finally
    //   139	144	974	finally
    //   144	201	974	finally
    //   205	239	974	finally
    //   243	250	974	finally
    //   252	266	974	finally
    //   272	314	974	finally
    //   314	345	974	finally
    //   349	417	974	finally
    //   417	422	974	finally
    //   426	435	974	finally
    //   443	524	974	finally
    //   529	544	974	finally
    //   549	555	974	finally
    //   555	598	974	finally
    //   598	619	974	finally
    //   619	627	974	finally
    //   632	697	974	finally
    //   702	747	974	finally
    //   750	812	974	finally
    //   812	819	974	finally
    //   824	832	974	finally
    //   847	885	974	finally
    //   885	889	974	finally
    //   891	971	974	finally
    //   980	1015	974	finally
    //   1020	1049	974	finally
    //   1237	1242	974	finally
    //   1247	1252	974	finally
    //   1255	1270	974	finally
    //   1276	1339	974	finally
    //   1490	1495	974	finally
    //   1500	1505	974	finally
    //   1533	1538	974	finally
    //   1543	1548	974	finally
    //   1548	1550	974	finally
    //   1550	1579	974	finally
    //   1589	1610	974	finally
    //   1627	1710	974	finally
    //   1715	1769	974	finally
    //   1776	1824	974	finally
    //   1146	1180	1342	java/lang/Exception
    //   1247	1252	1393	java/io/IOException
    //   1079	1090	1401	java/io/IOException
    //   1102	1110	1401	java/io/IOException
    //   1122	1129	1401	java/io/IOException
    //   1146	1180	1401	java/io/IOException
    //   1192	1223	1401	java/io/IOException
    //   1356	1390	1401	java/io/IOException
    //   1500	1505	1513	java/io/IOException
    //   1079	1090	1523	finally
    //   1102	1110	1523	finally
    //   1122	1129	1523	finally
    //   1146	1180	1523	finally
    //   1192	1223	1523	finally
    //   1356	1390	1523	finally
    //   1423	1452	1523	finally
    //   1460	1468	1523	finally
    //   1476	1485	1523	finally
    //   824	832	1588	java/lang/UnsatisfiedLinkError
    //   885	889	1774	java/lang/UnsatisfiedLinkError
    //   1237	1242	1833	java/io/IOException
    //   1490	1495	1838	java/io/IOException
    //   1533	1538	1843	java/io/IOException
    //   1543	1548	1847	java/io/IOException
    //   1223	1232	1851	finally
    //   1223	1232	1859	java/io/IOException
    //   426	435	1864	java/lang/Exception
    //   243	250	1869	java/lang/UnsatisfiedLinkError
    //   417	422	1935	java/lang/Exception
  }
  
  public static boolean b()
  {
    String str = System.getProperty("os.arch");
    return (Build.BRAND.equals("asus")) && ((Build.CPU_ABI2.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("i386")) || (str.toLowerCase(Locale.US).contains("i686")) || (str.toLowerCase(Locale.US).contains("i586")) || (str.toLowerCase(Locale.US).contains("i486")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */