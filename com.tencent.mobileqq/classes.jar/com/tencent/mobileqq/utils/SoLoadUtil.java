package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import mqq.app.MobileQQ;

public class SoLoadUtil
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add("libamrnb.so");
    jdField_a_of_type_JavaUtilSet.add("libcodecsilk.so");
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
      String str1;
      try
      {
        localObject = BaseApplication.getContext();
        paramContext = new File(paramString1);
        if (!paramContext.exists()) {
          paramContext.mkdir();
        }
        str1 = paramString1 + "tmp_" + MobileQQ.sProcessId + "_" + Thread.currentThread() + "/";
        paramContext = new File(str1);
        paramContext.mkdirs();
        String str2 = b();
        AssetManager localAssetManager = ((Context)localObject).getAssets();
        try
        {
          a((Context)localObject, "DecodeSo", 0, false, false);
          int j = 0;
          if (j <= 1)
          {
            i = Decode(localAssetManager, paramString2, str1, str2, paramString3);
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
          QLog.d("SoLoadUtil", 2, "Unsatisfied Link error: " + paramString2.toString() + "abi:" + b());
        }
        catch (UnsatisfiedLinkError paramString2)
        {
          if (!QLog.isColorLevel()) {
            break label369;
          }
        }
      }
      finally {}
      paramString2 = new File(str1 + paramString3);
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
        label369:
        i = 2;
      }
    }
  }
  
  public static String a()
  {
    return "_32";
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "lib/" + d() + "/";
    }
    return "lib/" + b() + "/";
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
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "loadSo", false, 0L, 0L, paramHashMap, "");
  }
  
  private static final void a(HashMap<String, String> paramHashMap, int paramInt, String paramString, long paramLong)
  {
    paramHashMap.put("message", paramString);
    paramHashMap.put("costTime", paramLong + "");
    StatisticCollector.fillFailCode(paramHashMap, paramInt);
    a(paramHashMap);
  }
  
  public static boolean a()
  {
    return ((!TextUtils.isEmpty(Build.CPU_ABI)) && (Build.CPU_ABI.contains("x86"))) || ((!TextUtils.isEmpty(Build.CPU_ABI2)) && (Build.CPU_ABI2.contains("x86"))) || (b());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    String str1 = AppSetting.g() + a();
    String str2 = "key_so_version_" + paramString;
    paramContext = paramContext.getSharedPreferences("so_sp", 4);
    String str3 = paramContext.getString(str2, "");
    if (!TextUtils.equals(str1, str3)) {}
    for (boolean bool = true;; bool = false)
    {
      if (AudioHelperUtil.a()) {
        QLog.w("SoLoadUtil", 1, "loadNativeLibrary, libName[" + paramString + "], nowVersion[" + str3 + "], revision[" + str1 + "], needUpdate[" + bool + "]");
      }
      if (bool)
      {
        if (!TextUtils.equals("0" + a(), str1)) {
          break;
        }
        paramContext.edit().putString(str2, "-1" + a()).apply();
      }
      return bool;
    }
    paramContext.edit().putString(str2, str1).apply();
    return bool;
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
    //   3: getstatic 334	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 18
    //   8: if_icmpge +42 -> 50
    //   11: aload_1
    //   12: ldc_w 336
    //   15: invokevirtual 338	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +32 -> 50
    //   21: aload_0
    //   22: ldc_w 340
    //   25: iconst_0
    //   26: iconst_0
    //   27: iconst_1
    //   28: invokestatic 112	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZZ)Z
    //   31: ifne +19 -> 50
    //   34: ldc 121
    //   36: iconst_1
    //   37: ldc_w 342
    //   40: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: iconst_0
    //   44: istore_3
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_3
    //   49: ireturn
    //   50: invokestatic 347	com/tencent/util/AudioHelperUtil:a	()J
    //   53: lstore 12
    //   55: ldc 121
    //   57: iconst_1
    //   58: new 62	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 349
    //   68: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 351
    //   78: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_3
    //   82: invokevirtual 134	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc_w 353
    //   88: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload 4
    //   93: invokevirtual 134	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc_w 355
    //   99: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: lload 12
    //   104: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: ldc 136
    //   109: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 140	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: invokestatic 360	android/os/SystemClock:uptimeMillis	()J
    //   121: lstore 14
    //   123: aload_1
    //   124: invokestatic 362	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   127: astore 25
    //   129: iconst_0
    //   130: istore 7
    //   132: aload_0
    //   133: astore 20
    //   135: aload_0
    //   136: ifnonnull +8 -> 144
    //   139: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   142: astore 20
    //   144: new 62	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   151: aload 20
    //   153: invokevirtual 366	android/content/Context:getFilesDir	()Ljava/io/File;
    //   156: invokevirtual 369	java/io/File:getParent	()Ljava/lang/String;
    //   159: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 371
    //   165: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 29
    //   173: new 62	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   180: aload 20
    //   182: invokevirtual 366	android/content/Context:getFilesDir	()Ljava/io/File;
    //   185: invokevirtual 369	java/io/File:getParent	()Ljava/lang/String;
    //   188: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 373
    //   194: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore_0
    //   201: iload_3
    //   202: ifeq +1735 -> 1937
    //   205: new 52	java/io/File
    //   208: dup
    //   209: new 62	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   216: aload_0
    //   217: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 57	java/io/File:exists	()Z
    //   238: istore_3
    //   239: iload_3
    //   240: ifeq +744 -> 984
    //   243: aload_0
    //   244: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   247: invokestatic 378	java/lang/System:load	(Ljava/lang/String;)V
    //   250: iconst_1
    //   251: istore 7
    //   253: aload 25
    //   255: iconst_0
    //   256: ldc 179
    //   258: invokestatic 360	android/os/SystemClock:uptimeMillis	()J
    //   261: lload 14
    //   263: lsub
    //   264: invokestatic 380	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   267: iload 7
    //   269: istore_3
    //   270: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq -228 -> 45
    //   276: ldc 121
    //   278: iconst_2
    //   279: new 62	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 382
    //   289: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   296: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 384
    //   302: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: iload 7
    //   313: istore_3
    //   314: goto -269 -> 45
    //   317: astore_0
    //   318: iconst_1
    //   319: istore_3
    //   320: new 62	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   327: ldc 179
    //   329: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 386
    //   335: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_0
    //   339: invokestatic 390	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   342: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: astore 16
    //   350: iconst_0
    //   351: iconst_2
    //   352: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   355: istore_2
    //   356: ldc 121
    //   358: iconst_1
    //   359: aload 16
    //   361: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: new 52	java/io/File
    //   367: dup
    //   368: new 62	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   375: aload 29
    //   377: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   384: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   393: astore 26
    //   395: new 62	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 394
    //   405: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_1
    //   409: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: astore 27
    //   417: aload 20
    //   419: ldc_w 283
    //   422: iconst_4
    //   423: invokevirtual 287	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   426: astore 28
    //   428: aload 20
    //   430: aload_1
    //   431: invokestatic 396	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   434: ifeq +72 -> 506
    //   437: aload 26
    //   439: invokevirtual 57	java/io/File:exists	()Z
    //   442: ifeq +64 -> 506
    //   445: aload 26
    //   447: invokevirtual 143	java/io/File:delete	()Z
    //   450: istore 7
    //   452: iload 7
    //   454: ifeq +9 -> 463
    //   457: invokestatic 301	com/tencent/util/AudioHelperUtil:a	()Z
    //   460: ifeq +46 -> 506
    //   463: ldc 121
    //   465: iconst_1
    //   466: new 62	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 398
    //   476: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iload 7
    //   481: invokevirtual 134	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   484: ldc_w 355
    //   487: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: lload 12
    //   492: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   495: ldc 136
    //   497: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 140	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: iload_2
    //   507: istore 6
    //   509: aload 16
    //   511: astore_0
    //   512: aload 26
    //   514: invokevirtual 57	java/io/File:exists	()Z
    //   517: ifne +1437 -> 1954
    //   520: iload 4
    //   522: ifeq +536 -> 1058
    //   525: aload 20
    //   527: aload 29
    //   529: ldc_w 400
    //   532: aload_1
    //   533: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   536: invokestatic 402	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   539: istore 5
    //   541: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +46 -> 590
    //   547: ldc 121
    //   549: iconst_1
    //   550: new 62	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 404
    //   560: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: iload 5
    //   565: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: ldc_w 355
    //   571: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: lload 12
    //   576: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   579: ldc 136
    //   581: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 140	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: iload 5
    //   592: ifeq +434 -> 1026
    //   595: aload 26
    //   597: invokevirtual 143	java/io/File:delete	()Z
    //   600: pop
    //   601: new 62	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   608: aload 16
    //   610: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 406
    //   616: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_1
    //   620: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: astore 16
    //   628: iload_2
    //   629: bipush 8
    //   631: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   634: istore_2
    //   635: ldc 121
    //   637: iconst_1
    //   638: aload 16
    //   640: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: goto +1305 -> 1948
    //   646: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq +59 -> 708
    //   652: ldc 121
    //   654: iconst_1
    //   655: new 62	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 303
    //   665: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_1
    //   669: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: ldc_w 408
    //   675: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 26
    //   680: invokevirtual 57	java/io/File:exists	()Z
    //   683: invokevirtual 134	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   686: ldc_w 355
    //   689: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: lload 12
    //   694: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   697: ldc 136
    //   699: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 140	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: aload 26
    //   710: invokevirtual 57	java/io/File:exists	()Z
    //   713: istore 4
    //   715: iload 4
    //   717: ifeq +1186 -> 1903
    //   720: aload 26
    //   722: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   725: invokestatic 378	java/lang/System:load	(Ljava/lang/String;)V
    //   728: iconst_1
    //   729: istore 4
    //   731: iload 4
    //   733: istore_3
    //   734: iload 5
    //   736: istore_2
    //   737: aload 16
    //   739: astore_0
    //   740: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   743: ifeq +48 -> 791
    //   746: ldc 121
    //   748: iconst_2
    //   749: new 62	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   756: ldc_w 382
    //   759: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload 26
    //   764: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   767: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: ldc_w 384
    //   773: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: aload 16
    //   784: astore_0
    //   785: iload 5
    //   787: istore_2
    //   788: iload 4
    //   790: istore_3
    //   791: iload_3
    //   792: istore 4
    //   794: iload_2
    //   795: istore 5
    //   797: aload_0
    //   798: astore 16
    //   800: iload_3
    //   801: ifne +1036 -> 1837
    //   804: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   807: ifeq +35 -> 842
    //   810: ldc 121
    //   812: iconst_1
    //   813: new 62	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 410
    //   823: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: lload 12
    //   828: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   831: ldc 136
    //   833: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: invokestatic 140	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: aload_1
    //   843: invokestatic 413	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   846: iconst_1
    //   847: istore 4
    //   849: iload 4
    //   851: istore_3
    //   852: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq +38 -> 893
    //   858: iload 4
    //   860: istore_3
    //   861: ldc 121
    //   863: iconst_2
    //   864: new 62	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   871: ldc_w 415
    //   874: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: aload_1
    //   878: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: ldc_w 384
    //   884: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: iconst_1
    //   894: istore_3
    //   895: invokestatic 360	android/os/SystemClock:uptimeMillis	()J
    //   898: lload 14
    //   900: lsub
    //   901: lstore 8
    //   903: aload 25
    //   905: iload_2
    //   906: aload_0
    //   907: lload 8
    //   909: invokestatic 380	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   912: ldc 121
    //   914: iconst_1
    //   915: new 62	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   922: ldc_w 303
    //   925: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: aload_1
    //   929: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: ldc_w 417
    //   935: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: lload 8
    //   940: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   943: ldc_w 419
    //   946: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: iload_3
    //   950: invokevirtual 134	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   953: ldc_w 355
    //   956: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: lload 12
    //   961: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   964: ldc 136
    //   966: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 140	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: goto -930 -> 45
    //   978: astore_0
    //   979: ldc 2
    //   981: monitorexit
    //   982: aload_0
    //   983: athrow
    //   984: new 62	java/lang/StringBuilder
    //   987: dup
    //   988: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   991: ldc 179
    //   993: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: ldc_w 421
    //   999: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: astore 16
    //   1007: iconst_0
    //   1008: iconst_4
    //   1009: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1012: istore_2
    //   1013: ldc 121
    //   1015: iconst_1
    //   1016: aload 16
    //   1018: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: iconst_0
    //   1022: istore_3
    //   1023: goto -659 -> 364
    //   1026: aload 26
    //   1028: invokestatic 427	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1031: lstore 8
    //   1033: aload 28
    //   1035: invokeinterface 315 1 0
    //   1040: aload 27
    //   1042: lload 8
    //   1044: invokeinterface 431 4 0
    //   1049: invokeinterface 434 1 0
    //   1054: pop
    //   1055: goto +893 -> 1948
    //   1058: aconst_null
    //   1059: astore 22
    //   1061: aconst_null
    //   1062: astore 21
    //   1064: aconst_null
    //   1065: astore 23
    //   1067: aconst_null
    //   1068: astore_0
    //   1069: aload_0
    //   1070: astore 19
    //   1072: aload 23
    //   1074: astore 17
    //   1076: aload 22
    //   1078: astore 18
    //   1080: new 52	java/io/File
    //   1083: dup
    //   1084: aload 29
    //   1086: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   1089: astore 24
    //   1091: aload_0
    //   1092: astore 19
    //   1094: aload 23
    //   1096: astore 17
    //   1098: aload 22
    //   1100: astore 18
    //   1102: aload 24
    //   1104: invokevirtual 57	java/io/File:exists	()Z
    //   1107: ifne +26 -> 1133
    //   1110: aload_0
    //   1111: astore 19
    //   1113: aload 23
    //   1115: astore 17
    //   1117: aload 22
    //   1119: astore 18
    //   1121: aload 24
    //   1123: invokevirtual 60	java/io/File:mkdir	()Z
    //   1126: istore 4
    //   1128: iload 4
    //   1130: ifeq +794 -> 1924
    //   1133: aload_0
    //   1134: astore 19
    //   1136: aload 23
    //   1138: astore 17
    //   1140: aload 22
    //   1142: astore 18
    //   1144: aload 20
    //   1146: invokevirtual 107	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1149: new 62	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1156: iconst_0
    //   1157: invokestatic 436	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1160: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: aload_1
    //   1164: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1167: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokevirtual 442	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1176: astore 24
    //   1178: aload 24
    //   1180: astore_0
    //   1181: aload_0
    //   1182: astore 19
    //   1184: aload_0
    //   1185: astore 17
    //   1187: aload 22
    //   1189: astore 18
    //   1191: new 444	java/io/FileOutputStream
    //   1194: dup
    //   1195: new 62	java/lang/StringBuilder
    //   1198: dup
    //   1199: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1202: aload 29
    //   1204: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: aload_1
    //   1208: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1211: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokespecial 445	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1220: astore 20
    //   1222: aload_0
    //   1223: aload 20
    //   1225: invokestatic 451	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   1228: lstore 10
    //   1230: aload 20
    //   1232: ifnull +8 -> 1240
    //   1235: aload 20
    //   1237: invokevirtual 456	java/io/OutputStream:close	()V
    //   1240: iload_2
    //   1241: istore 5
    //   1243: aload 16
    //   1245: astore 17
    //   1247: lload 10
    //   1249: lstore 8
    //   1251: aload_0
    //   1252: ifnull +18 -> 1270
    //   1255: aload_0
    //   1256: invokevirtual 459	java/io/InputStream:close	()V
    //   1259: lload 10
    //   1261: lstore 8
    //   1263: aload 16
    //   1265: astore 17
    //   1267: iload_2
    //   1268: istore 5
    //   1270: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1273: ifeq +12 -> 1285
    //   1276: ldc 121
    //   1278: iconst_2
    //   1279: ldc_w 461
    //   1282: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1285: iload 5
    //   1287: istore 6
    //   1289: aload 17
    //   1291: astore_0
    //   1292: aload 26
    //   1294: invokevirtual 57	java/io/File:exists	()Z
    //   1297: ifeq +657 -> 1954
    //   1300: lload 8
    //   1302: aload 26
    //   1304: invokevirtual 464	java/io/File:length	()J
    //   1307: lcmp
    //   1308: ifeq +251 -> 1559
    //   1311: aload 26
    //   1313: invokevirtual 143	java/io/File:delete	()Z
    //   1316: pop
    //   1317: new 62	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1324: aload 17
    //   1326: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: ldc_w 466
    //   1332: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1338: astore 16
    //   1340: iload 5
    //   1342: bipush 8
    //   1344: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1347: istore 5
    //   1349: ldc 121
    //   1351: iconst_1
    //   1352: aload 16
    //   1354: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1357: goto -711 -> 646
    //   1360: astore 17
    //   1362: aload_0
    //   1363: astore 19
    //   1365: aload 23
    //   1367: astore 17
    //   1369: aload 22
    //   1371: astore 18
    //   1373: aload 20
    //   1375: invokevirtual 107	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1378: new 62	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1385: iconst_1
    //   1386: invokestatic 436	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1389: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: aload_1
    //   1393: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1396: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1402: invokevirtual 442	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1405: astore_0
    //   1406: goto -225 -> 1181
    //   1409: astore 17
    //   1411: aload 21
    //   1413: astore 20
    //   1415: aload 19
    //   1417: astore_0
    //   1418: aload 17
    //   1420: astore 19
    //   1422: aload_0
    //   1423: astore 17
    //   1425: aload 20
    //   1427: astore 18
    //   1429: new 62	java/lang/StringBuilder
    //   1432: dup
    //   1433: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1436: aload 16
    //   1438: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: ldc_w 468
    //   1444: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: aload 19
    //   1449: invokestatic 390	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1452: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: astore 16
    //   1460: aload_0
    //   1461: astore 17
    //   1463: aload 20
    //   1465: astore 18
    //   1467: iload_2
    //   1468: bipush 16
    //   1470: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1473: istore 5
    //   1475: aload_0
    //   1476: astore 17
    //   1478: aload 20
    //   1480: astore 18
    //   1482: ldc 121
    //   1484: iconst_1
    //   1485: aload 16
    //   1487: aload 19
    //   1489: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1492: aload 20
    //   1494: ifnull +8 -> 1502
    //   1497: aload 20
    //   1499: invokevirtual 456	java/io/OutputStream:close	()V
    //   1502: aload_0
    //   1503: ifnull +409 -> 1912
    //   1506: aload_0
    //   1507: invokevirtual 459	java/io/InputStream:close	()V
    //   1510: ldc2_w 472
    //   1513: lstore 8
    //   1515: aload 16
    //   1517: astore 17
    //   1519: goto -249 -> 1270
    //   1522: astore_0
    //   1523: ldc2_w 472
    //   1526: lstore 8
    //   1528: aload 16
    //   1530: astore 17
    //   1532: goto -262 -> 1270
    //   1535: astore_1
    //   1536: aload 17
    //   1538: astore_0
    //   1539: aload 18
    //   1541: ifnull +8 -> 1549
    //   1544: aload 18
    //   1546: invokevirtual 456	java/io/OutputStream:close	()V
    //   1549: aload_0
    //   1550: ifnull +7 -> 1557
    //   1553: aload_0
    //   1554: invokevirtual 459	java/io/InputStream:close	()V
    //   1557: aload_1
    //   1558: athrow
    //   1559: aload 26
    //   1561: invokestatic 427	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1564: lstore 8
    //   1566: aload 28
    //   1568: invokeinterface 315 1 0
    //   1573: aload 27
    //   1575: lload 8
    //   1577: invokeinterface 431 4 0
    //   1582: invokeinterface 434 1 0
    //   1587: pop
    //   1588: iload 5
    //   1590: istore 6
    //   1592: aload 17
    //   1594: astore_0
    //   1595: goto +359 -> 1954
    //   1598: astore_0
    //   1599: iconst_0
    //   1600: istore_3
    //   1601: aload 26
    //   1603: invokestatic 427	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1606: lstore 8
    //   1608: aload 28
    //   1610: aload 27
    //   1612: ldc2_w 472
    //   1615: invokeinterface 477 4 0
    //   1620: lstore 10
    //   1622: lload 8
    //   1624: ldc2_w 472
    //   1627: lcmp
    //   1628: ifeq +98 -> 1726
    //   1631: lload 8
    //   1633: lload 10
    //   1635: lcmp
    //   1636: ifeq +90 -> 1726
    //   1639: aload 26
    //   1641: invokevirtual 143	java/io/File:delete	()Z
    //   1644: pop
    //   1645: new 62	java/lang/StringBuilder
    //   1648: dup
    //   1649: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1652: aload 16
    //   1654: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1657: ldc_w 479
    //   1660: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: lload 8
    //   1665: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1668: ldc_w 481
    //   1671: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: lload 10
    //   1676: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1679: ldc_w 483
    //   1682: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: aload 26
    //   1687: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1690: ldc_w 485
    //   1693: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: aload_0
    //   1697: invokestatic 390	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1700: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1706: astore_0
    //   1707: iload 5
    //   1709: sipush 128
    //   1712: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1715: istore_2
    //   1716: ldc 121
    //   1718: iconst_1
    //   1719: aload_0
    //   1720: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1723: goto -932 -> 791
    //   1726: new 62	java/lang/StringBuilder
    //   1729: dup
    //   1730: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1733: aload 16
    //   1735: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: ldc_w 487
    //   1741: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: aload 26
    //   1746: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1749: ldc_w 485
    //   1752: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: aload_0
    //   1756: invokestatic 390	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1759: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1765: astore_0
    //   1766: iload 5
    //   1768: bipush 32
    //   1770: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1773: istore_2
    //   1774: ldc 121
    //   1776: iconst_1
    //   1777: aload_0
    //   1778: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: goto -990 -> 791
    //   1784: astore 17
    //   1786: new 62	java/lang/StringBuilder
    //   1789: dup
    //   1790: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1793: aload_0
    //   1794: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: ldc_w 489
    //   1800: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: aload 17
    //   1805: invokestatic 390	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1808: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1814: astore 16
    //   1816: iload_2
    //   1817: bipush 64
    //   1819: invokestatic 392	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1822: istore 5
    //   1824: ldc 121
    //   1826: iconst_1
    //   1827: aload 16
    //   1829: aload 17
    //   1831: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1834: iload_3
    //   1835: istore 4
    //   1837: iload 4
    //   1839: istore_3
    //   1840: iload 5
    //   1842: istore_2
    //   1843: aload 16
    //   1845: astore_0
    //   1846: goto -951 -> 895
    //   1849: astore 17
    //   1851: goto -611 -> 1240
    //   1854: astore_0
    //   1855: iload_2
    //   1856: istore 5
    //   1858: aload 16
    //   1860: astore 17
    //   1862: lload 10
    //   1864: lstore 8
    //   1866: goto -596 -> 1270
    //   1869: astore 17
    //   1871: goto -369 -> 1502
    //   1874: astore 16
    //   1876: goto -327 -> 1549
    //   1879: astore_0
    //   1880: goto -323 -> 1557
    //   1883: astore_1
    //   1884: aload 20
    //   1886: astore 18
    //   1888: goto -349 -> 1539
    //   1891: astore 19
    //   1893: goto -471 -> 1422
    //   1896: astore_0
    //   1897: iload 7
    //   1899: istore_3
    //   1900: goto -1580 -> 320
    //   1903: iload 5
    //   1905: istore_2
    //   1906: aload 16
    //   1908: astore_0
    //   1909: goto -1118 -> 791
    //   1912: ldc2_w 472
    //   1915: lstore 8
    //   1917: aload 16
    //   1919: astore 17
    //   1921: goto -651 -> 1270
    //   1924: aconst_null
    //   1925: astore 20
    //   1927: aconst_null
    //   1928: astore_0
    //   1929: ldc2_w 472
    //   1932: lstore 10
    //   1934: goto -704 -> 1230
    //   1937: iconst_0
    //   1938: istore_2
    //   1939: iconst_0
    //   1940: istore_3
    //   1941: ldc 179
    //   1943: astore 16
    //   1945: goto -1581 -> 364
    //   1948: iload_2
    //   1949: istore 5
    //   1951: goto -1305 -> 646
    //   1954: iload 6
    //   1956: istore 5
    //   1958: aload_0
    //   1959: astore 16
    //   1961: goto -1315 -> 646
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1964	0	paramContext	Context
    //   0	1964	1	paramString	String
    //   0	1964	2	paramInt	int
    //   0	1964	3	paramBoolean1	boolean
    //   0	1964	4	paramBoolean2	boolean
    //   539	1418	5	i	int
    //   507	1448	6	j	int
    //   130	1768	7	bool	boolean
    //   901	1015	8	l1	long
    //   1228	705	10	l2	long
    //   53	907	12	l3	long
    //   121	778	14	l4	long
    //   348	1511	16	localObject1	Object
    //   1874	44	16	localIOException1	java.io.IOException
    //   1943	17	16	localObject2	Object
    //   1074	251	17	localObject3	Object
    //   1360	1	17	localException	java.lang.Exception
    //   1367	1	17	localObject4	Object
    //   1409	10	17	localIOException2	java.io.IOException
    //   1423	170	17	localObject5	Object
    //   1784	46	17	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   1849	1	17	localIOException3	java.io.IOException
    //   1860	1	17	localObject6	Object
    //   1869	1	17	localIOException4	java.io.IOException
    //   1919	1	17	localIOException5	java.io.IOException
    //   1078	809	18	localObject7	Object
    //   1070	418	19	localObject8	Object
    //   1891	1	19	localIOException6	java.io.IOException
    //   133	1793	20	localObject9	Object
    //   1062	350	21	localObject10	Object
    //   1059	311	22	localObject11	Object
    //   1065	301	23	localObject12	Object
    //   1089	90	24	localObject13	Object
    //   127	777	25	localHashMap	HashMap
    //   393	1352	26	localFile	File
    //   415	1196	27	str1	String
    //   426	1183	28	localSharedPreferences	SharedPreferences
    //   171	1032	29	str2	String
    // Exception table:
    //   from	to	target	type
    //   253	267	317	java/lang/UnsatisfiedLinkError
    //   270	311	317	java/lang/UnsatisfiedLinkError
    //   3	43	978	finally
    //   50	129	978	finally
    //   139	144	978	finally
    //   144	201	978	finally
    //   205	239	978	finally
    //   243	250	978	finally
    //   253	267	978	finally
    //   270	311	978	finally
    //   320	364	978	finally
    //   364	452	978	finally
    //   457	463	978	finally
    //   463	506	978	finally
    //   512	520	978	finally
    //   525	590	978	finally
    //   595	643	978	finally
    //   646	708	978	finally
    //   708	715	978	finally
    //   720	728	978	finally
    //   740	782	978	finally
    //   804	842	978	finally
    //   842	846	978	finally
    //   852	858	978	finally
    //   861	893	978	finally
    //   895	975	978	finally
    //   984	1021	978	finally
    //   1026	1055	978	finally
    //   1235	1240	978	finally
    //   1255	1259	978	finally
    //   1270	1285	978	finally
    //   1292	1357	978	finally
    //   1497	1502	978	finally
    //   1506	1510	978	finally
    //   1544	1549	978	finally
    //   1553	1557	978	finally
    //   1557	1559	978	finally
    //   1559	1588	978	finally
    //   1601	1622	978	finally
    //   1639	1723	978	finally
    //   1726	1781	978	finally
    //   1786	1834	978	finally
    //   1144	1178	1360	java/lang/Exception
    //   1080	1091	1409	java/io/IOException
    //   1102	1110	1409	java/io/IOException
    //   1121	1128	1409	java/io/IOException
    //   1144	1178	1409	java/io/IOException
    //   1191	1222	1409	java/io/IOException
    //   1373	1406	1409	java/io/IOException
    //   1506	1510	1522	java/io/IOException
    //   1080	1091	1535	finally
    //   1102	1110	1535	finally
    //   1121	1128	1535	finally
    //   1144	1178	1535	finally
    //   1191	1222	1535	finally
    //   1373	1406	1535	finally
    //   1429	1460	1535	finally
    //   1467	1475	1535	finally
    //   1482	1492	1535	finally
    //   720	728	1598	java/lang/UnsatisfiedLinkError
    //   740	782	1598	java/lang/UnsatisfiedLinkError
    //   842	846	1784	java/lang/UnsatisfiedLinkError
    //   852	858	1784	java/lang/UnsatisfiedLinkError
    //   861	893	1784	java/lang/UnsatisfiedLinkError
    //   1235	1240	1849	java/io/IOException
    //   1255	1259	1854	java/io/IOException
    //   1497	1502	1869	java/io/IOException
    //   1544	1549	1874	java/io/IOException
    //   1553	1557	1879	java/io/IOException
    //   1222	1230	1883	finally
    //   1222	1230	1891	java/io/IOException
    //   243	250	1896	java/lang/UnsatisfiedLinkError
  }
  
  private static String b()
  {
    try
    {
      String str = c();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    String str = System.getProperty("os.arch");
    return (Build.BRAND.equals("asus")) && ((Build.CPU_ABI2.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("i386")) || (str.toLowerCase(Locale.US).contains("i686")) || (str.toLowerCase(Locale.US).contains("i586")) || (str.toLowerCase(Locale.US).contains("i486")));
  }
  
  /* Error */
  private static String c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 253	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 261
    //   15: invokevirtual 266	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 261
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 522
    //   38: invokevirtual 266	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 524
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: invokestatic 271	com/tencent/mobileqq/utils/SoLoadUtil:b	()Z
    //   54: ifeq +10 -> 64
    //   57: ldc_w 261
    //   60: astore_0
    //   61: goto -36 -> 25
    //   64: ldc_w 526
    //   67: astore_0
    //   68: goto -43 -> 25
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	62	0	str	String
    //   71	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	71	finally
    //   11	21	71	finally
    //   34	44	71	finally
    //   51	57	71	finally
  }
  
  /* Error */
  private static String d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 253	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 528
    //   15: invokevirtual 266	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 530
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: ldc_w 526
    //   33: astore_0
    //   34: goto -9 -> 25
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	28	0	str	String
    //   37	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	37	finally
    //   11	21	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */