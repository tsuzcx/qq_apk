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
  private static Set<String> a = new HashSet();
  private static SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  
  static
  {
    a.add("libamrnb.so");
    a.add("libcodecsilk.so");
  }
  
  private static native int Decode(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = paramContext;
    if (paramContext == null) {}
    try
    {
      localObject = BaseApplication.getContext();
      paramContext = new File(paramString1);
      if (!paramContext.exists()) {
        paramContext.mkdir();
      }
      paramContext = new StringBuilder(paramString1);
      paramContext.append("tmp_");
      paramContext.append(MobileQQ.sProcessId);
      paramContext.append("_");
      paramContext.append(Thread.currentThread());
      paramContext.append("/");
      String str1 = paramContext.toString();
      paramContext = new File(str1);
      paramContext.mkdirs();
      String str2 = d();
      AssetManager localAssetManager = ((Context)localObject).getAssets();
      int k = 2;
      int j = 0;
      int i;
      try
      {
        a((Context)localObject, "DecodeSo", 0, false, false);
        i = 0;
        while (j <= 1)
        {
          i = Decode(localAssetManager, paramString2, str1, str2, paramString3);
          if (i == 0) {
            break;
          }
          j += 1;
        }
      }
      catch (UnsatisfiedLinkError paramString2)
      {
        i = k;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unsatisfied Link error: ");
          ((StringBuilder)localObject).append(paramString2.toString());
          ((StringBuilder)localObject).append("abi:");
          ((StringBuilder)localObject).append(d());
          QLog.d("SoLoadUtil", 2, ((StringBuilder)localObject).toString());
          i = k;
        }
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("unCompress7zSo fail, res[");
          paramString1.append(i);
          paramString1.append("], tempDirFile[");
          paramString1.append(paramContext.getAbsolutePath());
          paramString1.append("], exists[");
          paramString1.append(paramContext.exists());
          paramString1.append("]");
          QLog.w("SoLoadUtil", 1, paramString1.toString());
        }
        paramContext.delete();
        return i;
      }
      paramString2 = new StringBuilder();
      paramString2.append(str1);
      paramString2.append(paramString3);
      paramString2 = new File(paramString2.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramString3);
      paramString1 = new File(((StringBuilder)localObject).toString());
      if (!paramString1.exists())
      {
        if (!paramString2.renameTo(paramString1)) {
          i = 256;
        }
      }
      else {
        paramContext.delete();
      }
      return i;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("lib/");
      localStringBuilder.append(f());
      localStringBuilder.append("/");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib/");
    localStringBuilder.append(d());
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  private static final HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MODEL);
    localHashMap.put("deviceName", localStringBuilder.toString());
    localHashMap.put("time", b.format(new Date(System.currentTimeMillis())));
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
    paramString = new StringBuilder();
    paramString.append(paramLong);
    paramString.append("");
    paramHashMap.put("costTime", paramString.toString());
    StatisticCollector.fillFailCode(paramHashMap, paramInt);
    a(paramHashMap);
  }
  
  public static boolean a()
  {
    return ((!TextUtils.isEmpty(Build.CPU_ABI)) && (Build.CPU_ABI.contains("x86"))) || ((!TextUtils.isEmpty(Build.CPU_ABI2)) && (Build.CPU_ABI2.contains("x86"))) || (b());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppSetting.i());
    ((StringBuilder)localObject).append(c());
    String str1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_so_version_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    paramContext = paramContext.getSharedPreferences("so_sp", 4);
    String str2 = paramContext.getString((String)localObject, "");
    boolean bool = TextUtils.equals(str1, str2) ^ true;
    if (AudioHelperUtil.b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadNativeLibrary, libName[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], nowVersion[");
      localStringBuilder.append(str2);
      localStringBuilder.append("], revision[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], needUpdate[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("SoLoadUtil", 1, localStringBuilder.toString());
    }
    if (bool)
    {
      paramString = new StringBuilder();
      paramString.append("0");
      paramString.append(c());
      if (TextUtils.equals(paramString.toString(), str1))
      {
        paramContext = paramContext.edit();
        paramString = new StringBuilder();
        paramString.append("-1");
        paramString.append(c());
        paramContext.putString((String)localObject, paramString.toString()).apply();
        return bool;
      }
      paramContext.edit().putString((String)localObject, str1).apply();
    }
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
    //   3: getstatic 328	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 18
    //   8: if_icmpge +40 -> 48
    //   11: aload_1
    //   12: ldc_w 330
    //   15: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +30 -> 48
    //   21: aload_0
    //   22: ldc_w 334
    //   25: iconst_0
    //   26: iconst_0
    //   27: iconst_1
    //   28: invokestatic 113	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZZ)Z
    //   31: ifne +17 -> 48
    //   34: ldc 128
    //   36: iconst_1
    //   37: ldc_w 336
    //   40: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: iconst_0
    //   47: ireturn
    //   48: invokestatic 341	com/tencent/util/AudioHelperUtil:a	()J
    //   51: lstore 7
    //   53: new 63	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   60: astore 15
    //   62: aload 15
    //   64: ldc_w 343
    //   67: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 15
    //   73: aload_1
    //   74: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 15
    //   80: ldc_w 345
    //   83: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 15
    //   89: iload_3
    //   90: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 15
    //   96: ldc_w 347
    //   99: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 15
    //   105: iload 4
    //   107: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 15
    //   113: ldc_w 349
    //   116: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 15
    //   122: lload 7
    //   124: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 15
    //   130: ldc 145
    //   132: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: ldc 128
    //   138: iconst_1
    //   139: aload 15
    //   141: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: invokestatic 354	android/os/SystemClock:uptimeMillis	()J
    //   150: lstore 13
    //   152: aload_1
    //   153: invokestatic 356	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   156: astore 18
    //   158: ldc 173
    //   160: astore 15
    //   162: aload_0
    //   163: astore 16
    //   165: aload_0
    //   166: ifnonnull +8 -> 174
    //   169: invokestatic 51	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   172: astore 16
    //   174: new 63	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   181: astore_0
    //   182: aload_0
    //   183: aload 16
    //   185: invokevirtual 360	android/content/Context:getFilesDir	()Ljava/io/File;
    //   188: invokevirtual 363	java/io/File:getParent	()Ljava/lang/String;
    //   191: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_0
    //   196: ldc_w 365
    //   199: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_0
    //   204: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore 17
    //   209: new 63	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   216: astore_0
    //   217: aload_0
    //   218: aload 16
    //   220: invokevirtual 360	android/content/Context:getFilesDir	()Ljava/io/File;
    //   223: invokevirtual 363	java/io/File:getParent	()Ljava/lang/String;
    //   226: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_0
    //   231: ldc_w 367
    //   234: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_0
    //   239: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_0
    //   243: iload_3
    //   244: ifeq +1949 -> 2193
    //   247: new 63	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   254: astore 15
    //   256: aload 15
    //   258: aload_0
    //   259: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 15
    //   265: aload_1
    //   266: invokestatic 370	com/tencent/mobileqq/utils/SoLoadUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   269: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: new 53	java/io/File
    //   276: dup
    //   277: aload 15
    //   279: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   285: astore_0
    //   286: aload_0
    //   287: invokevirtual 58	java/io/File:exists	()Z
    //   290: istore_3
    //   291: iload_3
    //   292: ifeq +160 -> 452
    //   295: aload_0
    //   296: invokevirtual 138	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   299: invokestatic 373	java/lang/System:load	(Ljava/lang/String;)V
    //   302: invokestatic 354	android/os/SystemClock:uptimeMillis	()J
    //   305: lstore 9
    //   307: aload 18
    //   309: iconst_0
    //   310: ldc 173
    //   312: lload 9
    //   314: lload 13
    //   316: lsub
    //   317: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   320: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +51 -> 374
    //   326: new 63	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   333: astore 15
    //   335: aload 15
    //   337: ldc_w 377
    //   340: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 15
    //   346: aload_0
    //   347: invokevirtual 138	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   350: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 15
    //   356: ldc_w 379
    //   359: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: ldc 128
    //   365: iconst_2
    //   366: aload 15
    //   368: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: ldc 2
    //   376: monitorexit
    //   377: iconst_1
    //   378: ireturn
    //   379: astore_0
    //   380: goto +4 -> 384
    //   383: astore_0
    //   384: iconst_1
    //   385: istore_3
    //   386: goto +6 -> 392
    //   389: astore_0
    //   390: iconst_0
    //   391: istore_3
    //   392: new 63	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   399: astore 15
    //   401: aload 15
    //   403: ldc 173
    //   405: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 15
    //   411: ldc_w 381
    //   414: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 15
    //   420: aload_0
    //   421: invokestatic 385	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   424: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 15
    //   430: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: astore 15
    //   435: iconst_0
    //   436: iconst_2
    //   437: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   440: istore_2
    //   441: ldc 128
    //   443: iconst_1
    //   444: aload 15
    //   446: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: goto +49 -> 498
    //   452: new 63	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   459: astore_0
    //   460: aload_0
    //   461: ldc 173
    //   463: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload_0
    //   468: ldc_w 389
    //   471: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_0
    //   476: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: astore 15
    //   481: iconst_0
    //   482: iconst_4
    //   483: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   486: istore_2
    //   487: ldc 128
    //   489: iconst_1
    //   490: aload 15
    //   492: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto +1700 -> 2195
    //   498: new 63	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   505: astore_0
    //   506: aload_0
    //   507: aload 17
    //   509: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_0
    //   514: aload_1
    //   515: invokestatic 370	com/tencent/mobileqq/utils/SoLoadUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: new 53	java/io/File
    //   525: dup
    //   526: aload_0
    //   527: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   533: astore 19
    //   535: new 63	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   542: astore_0
    //   543: aload_0
    //   544: ldc_w 391
    //   547: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_0
    //   552: aload_1
    //   553: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload_0
    //   558: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: astore 20
    //   563: aload 16
    //   565: ldc_w 278
    //   568: iconst_4
    //   569: invokevirtual 282	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   572: astore 21
    //   574: aload 16
    //   576: aload_1
    //   577: invokestatic 393	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   580: ifeq +1620 -> 2200
    //   583: aload 19
    //   585: invokevirtual 58	java/io/File:exists	()Z
    //   588: ifeq +1612 -> 2200
    //   591: aload 19
    //   593: invokevirtual 151	java/io/File:delete	()Z
    //   596: istore 6
    //   598: iload 6
    //   600: ifeq +9 -> 609
    //   603: invokestatic 295	com/tencent/util/AudioHelperUtil:b	()Z
    //   606: ifeq +1594 -> 2200
    //   609: new 63	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   616: astore_0
    //   617: aload_0
    //   618: ldc_w 395
    //   621: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload_0
    //   626: iload 6
    //   628: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload_0
    //   633: ldc_w 349
    //   636: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload_0
    //   641: lload 7
    //   643: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload_0
    //   648: ldc 145
    //   650: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: ldc 128
    //   656: iconst_1
    //   657: aload_0
    //   658: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: goto +3 -> 667
    //   667: lload 7
    //   669: lstore 11
    //   671: iload_2
    //   672: istore 5
    //   674: aload 15
    //   676: astore_0
    //   677: aload 19
    //   679: invokevirtual 58	java/io/File:exists	()Z
    //   682: ifne +1521 -> 2203
    //   685: iload 4
    //   687: ifeq +178 -> 865
    //   690: aload 16
    //   692: aload 17
    //   694: ldc_w 397
    //   697: aload_1
    //   698: invokestatic 370	com/tencent/mobileqq/utils/SoLoadUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   701: invokestatic 399	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   704: istore 5
    //   706: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +58 -> 767
    //   712: new 63	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   719: astore_0
    //   720: aload_0
    //   721: ldc_w 401
    //   724: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload_0
    //   729: iload 5
    //   731: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_0
    //   736: ldc_w 349
    //   739: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload_0
    //   744: lload 11
    //   746: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload_0
    //   751: ldc 145
    //   753: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: ldc 128
    //   759: iconst_1
    //   760: aload_0
    //   761: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: iload 5
    //   769: ifeq +61 -> 830
    //   772: aload 19
    //   774: invokevirtual 151	java/io/File:delete	()Z
    //   777: pop
    //   778: new 63	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   785: astore_0
    //   786: aload_0
    //   787: aload 15
    //   789: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload_0
    //   794: ldc_w 403
    //   797: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload_0
    //   802: aload_1
    //   803: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload_0
    //   808: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: astore_0
    //   812: iload_2
    //   813: bipush 8
    //   815: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   818: istore 5
    //   820: ldc 128
    //   822: iconst_1
    //   823: aload_0
    //   824: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   827: goto +1376 -> 2203
    //   830: aload 19
    //   832: invokestatic 409	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   835: lstore 7
    //   837: aload 21
    //   839: invokeinterface 309 1 0
    //   844: aload 20
    //   846: lload 7
    //   848: invokeinterface 413 4 0
    //   853: invokeinterface 416 1 0
    //   858: pop
    //   859: aload 15
    //   861: astore_0
    //   862: goto +1344 -> 2206
    //   865: new 53	java/io/File
    //   868: dup
    //   869: aload 17
    //   871: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   874: astore_0
    //   875: aload_0
    //   876: invokevirtual 58	java/io/File:exists	()Z
    //   879: istore 4
    //   881: iload 4
    //   883: ifne +40 -> 923
    //   886: aload_0
    //   887: invokevirtual 61	java/io/File:mkdir	()Z
    //   890: istore 4
    //   892: iload 4
    //   894: ifeq +6 -> 900
    //   897: goto +26 -> 923
    //   900: aconst_null
    //   901: astore_0
    //   902: ldc2_w 417
    //   905: lstore 7
    //   907: aconst_null
    //   908: astore 16
    //   910: goto +158 -> 1068
    //   913: astore 17
    //   915: aconst_null
    //   916: astore_0
    //   917: aconst_null
    //   918: astore 16
    //   920: goto +245 -> 1165
    //   923: aload 16
    //   925: invokevirtual 108	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   928: astore_0
    //   929: new 63	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   936: astore 22
    //   938: aload 22
    //   940: iconst_0
    //   941: invokestatic 420	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   944: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: aload 22
    //   950: aload_1
    //   951: invokestatic 370	com/tencent/mobileqq/utils/SoLoadUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   954: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload_0
    //   959: aload 22
    //   961: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokevirtual 426	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   967: astore_0
    //   968: goto +51 -> 1019
    //   971: aload 16
    //   973: invokevirtual 108	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   976: astore_0
    //   977: new 63	java/lang/StringBuilder
    //   980: dup
    //   981: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   984: astore 16
    //   986: aload 16
    //   988: iconst_1
    //   989: invokestatic 420	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   992: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload 16
    //   998: aload_1
    //   999: invokestatic 370	com/tencent/mobileqq/utils/SoLoadUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1002: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload_0
    //   1007: aload 16
    //   1009: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: invokevirtual 426	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1015: astore_0
    //   1016: goto -48 -> 968
    //   1019: new 63	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1026: astore 16
    //   1028: aload 16
    //   1030: aload 17
    //   1032: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload 16
    //   1038: aload_1
    //   1039: invokestatic 370	com/tencent/mobileqq/utils/SoLoadUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1042: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: new 428	java/io/FileOutputStream
    //   1049: dup
    //   1050: aload 16
    //   1052: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1055: invokespecial 429	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1058: astore 16
    //   1060: aload_0
    //   1061: aload 16
    //   1063: invokestatic 435	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   1066: lstore 7
    //   1068: aload 16
    //   1070: ifnull +11 -> 1081
    //   1073: aload 16
    //   1075: invokevirtual 440	java/io/OutputStream:close	()V
    //   1078: goto +3 -> 1081
    //   1081: iload_2
    //   1082: istore 5
    //   1084: lload 7
    //   1086: lstore 9
    //   1088: aload 15
    //   1090: astore 16
    //   1092: aload_0
    //   1093: ifnull +164 -> 1257
    //   1096: aload_0
    //   1097: invokevirtual 443	java/io/InputStream:close	()V
    //   1100: iload_2
    //   1101: istore 5
    //   1103: lload 7
    //   1105: lstore 9
    //   1107: aload 15
    //   1109: astore 16
    //   1111: goto +146 -> 1257
    //   1114: astore 15
    //   1116: aload_0
    //   1117: astore_1
    //   1118: aload 15
    //   1120: astore_0
    //   1121: goto +273 -> 1394
    //   1124: astore 17
    //   1126: goto +39 -> 1165
    //   1129: astore 15
    //   1131: aload_0
    //   1132: astore_1
    //   1133: aload 15
    //   1135: astore_0
    //   1136: goto +16 -> 1152
    //   1139: astore 17
    //   1141: goto +21 -> 1162
    //   1144: astore 17
    //   1146: goto +14 -> 1160
    //   1149: astore_0
    //   1150: aconst_null
    //   1151: astore_1
    //   1152: aconst_null
    //   1153: astore 16
    //   1155: goto +239 -> 1394
    //   1158: astore 17
    //   1160: aconst_null
    //   1161: astore_0
    //   1162: aconst_null
    //   1163: astore 16
    //   1165: new 63	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1172: astore 22
    //   1174: aload 22
    //   1176: aload 15
    //   1178: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: pop
    //   1182: aload 22
    //   1184: ldc_w 445
    //   1187: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: pop
    //   1191: aload 22
    //   1193: aload 17
    //   1195: invokestatic 385	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1198: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: pop
    //   1202: aload 22
    //   1204: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: astore 15
    //   1209: iload_2
    //   1210: bipush 16
    //   1212: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1215: istore 5
    //   1217: ldc 128
    //   1219: iconst_1
    //   1220: aload 15
    //   1222: aload 17
    //   1224: invokestatic 448	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1227: aload 16
    //   1229: ifnull +11 -> 1240
    //   1232: aload 16
    //   1234: invokevirtual 440	java/io/OutputStream:close	()V
    //   1237: goto +3 -> 1240
    //   1240: aload_0
    //   1241: ifnull +7 -> 1248
    //   1244: aload_0
    //   1245: invokevirtual 443	java/io/InputStream:close	()V
    //   1248: ldc2_w 417
    //   1251: lstore 9
    //   1253: aload 15
    //   1255: astore 16
    //   1257: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1260: ifeq +12 -> 1272
    //   1263: ldc 128
    //   1265: iconst_2
    //   1266: ldc_w 450
    //   1269: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: iload 5
    //   1274: istore_2
    //   1275: aload 16
    //   1277: astore_0
    //   1278: aload 19
    //   1280: invokevirtual 58	java/io/File:exists	()Z
    //   1283: ifeq +134 -> 1417
    //   1286: lload 9
    //   1288: aload 19
    //   1290: invokevirtual 453	java/io/File:length	()J
    //   1293: lcmp
    //   1294: ifeq +55 -> 1349
    //   1297: aload 19
    //   1299: invokevirtual 151	java/io/File:delete	()Z
    //   1302: pop
    //   1303: new 63	java/lang/StringBuilder
    //   1306: dup
    //   1307: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1310: astore_0
    //   1311: aload_0
    //   1312: aload 16
    //   1314: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: aload_0
    //   1319: ldc_w 455
    //   1322: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload_0
    //   1327: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1330: astore_0
    //   1331: iload 5
    //   1333: bipush 8
    //   1335: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1338: istore_2
    //   1339: ldc 128
    //   1341: iconst_1
    //   1342: aload_0
    //   1343: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1346: goto +71 -> 1417
    //   1349: aload 19
    //   1351: invokestatic 409	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1354: lstore 7
    //   1356: aload 21
    //   1358: invokeinterface 309 1 0
    //   1363: aload 20
    //   1365: lload 7
    //   1367: invokeinterface 413 4 0
    //   1372: invokeinterface 416 1 0
    //   1377: pop
    //   1378: iload 5
    //   1380: istore_2
    //   1381: aload 16
    //   1383: astore_0
    //   1384: goto +33 -> 1417
    //   1387: astore 15
    //   1389: aload_0
    //   1390: astore_1
    //   1391: aload 15
    //   1393: astore_0
    //   1394: aload 16
    //   1396: ifnull +11 -> 1407
    //   1399: aload 16
    //   1401: invokevirtual 440	java/io/OutputStream:close	()V
    //   1404: goto +3 -> 1407
    //   1407: aload_1
    //   1408: ifnull +7 -> 1415
    //   1411: aload_1
    //   1412: invokevirtual 443	java/io/InputStream:close	()V
    //   1415: aload_0
    //   1416: athrow
    //   1417: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1420: ifeq +84 -> 1504
    //   1423: new 63	java/lang/StringBuilder
    //   1426: dup
    //   1427: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1430: astore 15
    //   1432: aload 15
    //   1434: ldc_w 297
    //   1437: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: pop
    //   1441: aload 15
    //   1443: aload_1
    //   1444: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: pop
    //   1448: aload 15
    //   1450: ldc_w 457
    //   1453: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: aload 15
    //   1459: aload 19
    //   1461: invokevirtual 58	java/io/File:exists	()Z
    //   1464: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1467: pop
    //   1468: aload 15
    //   1470: ldc_w 349
    //   1473: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: pop
    //   1477: aload 15
    //   1479: lload 11
    //   1481: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1484: pop
    //   1485: aload 15
    //   1487: ldc 145
    //   1489: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: pop
    //   1493: ldc 128
    //   1495: iconst_1
    //   1496: aload 15
    //   1498: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1504: aload 19
    //   1506: invokevirtual 58	java/io/File:exists	()Z
    //   1509: istore 4
    //   1511: iload 4
    //   1513: ifeq +701 -> 2214
    //   1516: aload 19
    //   1518: invokevirtual 138	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1521: invokestatic 373	java/lang/System:load	(Ljava/lang/String;)V
    //   1524: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1527: ifeq +52 -> 1579
    //   1530: new 63	java/lang/StringBuilder
    //   1533: dup
    //   1534: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1537: astore 15
    //   1539: aload 15
    //   1541: ldc_w 377
    //   1544: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload 15
    //   1550: aload 19
    //   1552: invokevirtual 138	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1555: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: pop
    //   1559: aload 15
    //   1561: ldc_w 379
    //   1564: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: ldc 128
    //   1570: iconst_2
    //   1571: aload 15
    //   1573: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1579: iconst_1
    //   1580: istore_3
    //   1581: goto +236 -> 1817
    //   1584: astore 15
    //   1586: aload 19
    //   1588: invokestatic 409	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1591: lstore 7
    //   1593: aload 21
    //   1595: aload 20
    //   1597: ldc2_w 417
    //   1600: invokeinterface 461 4 0
    //   1605: lstore 9
    //   1607: lload 7
    //   1609: ldc2_w 417
    //   1612: lcmp
    //   1613: ifeq +128 -> 1741
    //   1616: lload 7
    //   1618: lload 9
    //   1620: lcmp
    //   1621: ifeq +120 -> 1741
    //   1624: aload 19
    //   1626: invokevirtual 151	java/io/File:delete	()Z
    //   1629: pop
    //   1630: new 63	java/lang/StringBuilder
    //   1633: dup
    //   1634: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1637: astore 16
    //   1639: aload 16
    //   1641: aload_0
    //   1642: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload 16
    //   1648: ldc_w 463
    //   1651: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: pop
    //   1655: aload 16
    //   1657: lload 7
    //   1659: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1662: pop
    //   1663: aload 16
    //   1665: ldc_w 465
    //   1668: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: pop
    //   1672: aload 16
    //   1674: lload 9
    //   1676: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1679: pop
    //   1680: aload 16
    //   1682: ldc_w 467
    //   1685: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: pop
    //   1689: aload 16
    //   1691: aload 19
    //   1693: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1696: pop
    //   1697: aload 16
    //   1699: ldc_w 469
    //   1702: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: pop
    //   1706: aload 16
    //   1708: aload 15
    //   1710: invokestatic 385	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1713: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: pop
    //   1717: aload 16
    //   1719: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1722: astore_0
    //   1723: iload_2
    //   1724: sipush 128
    //   1727: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1730: istore_2
    //   1731: ldc 128
    //   1733: iconst_1
    //   1734: aload_0
    //   1735: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1738: goto +471 -> 2209
    //   1741: new 63	java/lang/StringBuilder
    //   1744: dup
    //   1745: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1748: astore 16
    //   1750: aload 16
    //   1752: aload_0
    //   1753: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: pop
    //   1757: aload 16
    //   1759: ldc_w 471
    //   1762: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: pop
    //   1766: aload 16
    //   1768: aload 19
    //   1770: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1773: pop
    //   1774: aload 16
    //   1776: ldc_w 469
    //   1779: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1782: pop
    //   1783: aload 16
    //   1785: aload 15
    //   1787: invokestatic 385	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1790: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: pop
    //   1794: aload 16
    //   1796: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1799: astore_0
    //   1800: iload_2
    //   1801: bipush 32
    //   1803: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1806: istore_2
    //   1807: ldc 128
    //   1809: iconst_1
    //   1810: aload_0
    //   1811: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1814: goto +395 -> 2209
    //   1817: iload_2
    //   1818: istore 5
    //   1820: iload_3
    //   1821: istore 4
    //   1823: aload_0
    //   1824: astore 15
    //   1826: iload_3
    //   1827: ifne +195 -> 2022
    //   1830: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1833: ifeq +48 -> 1881
    //   1836: new 63	java/lang/StringBuilder
    //   1839: dup
    //   1840: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1843: astore 15
    //   1845: aload 15
    //   1847: ldc_w 473
    //   1850: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: pop
    //   1854: aload 15
    //   1856: lload 11
    //   1858: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: aload 15
    //   1864: ldc 145
    //   1866: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: pop
    //   1870: ldc 128
    //   1872: iconst_1
    //   1873: aload 15
    //   1875: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1878: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1881: aload_1
    //   1882: invokestatic 476	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   1885: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1888: ifeq +48 -> 1936
    //   1891: new 63	java/lang/StringBuilder
    //   1894: dup
    //   1895: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1898: astore 15
    //   1900: aload 15
    //   1902: ldc_w 478
    //   1905: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: pop
    //   1909: aload 15
    //   1911: aload_1
    //   1912: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: pop
    //   1916: aload 15
    //   1918: ldc_w 379
    //   1921: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: pop
    //   1925: ldc 128
    //   1927: iconst_2
    //   1928: aload 15
    //   1930: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1933: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1936: iconst_1
    //   1937: istore 4
    //   1939: iload_2
    //   1940: istore 5
    //   1942: aload_0
    //   1943: astore 15
    //   1945: goto +77 -> 2022
    //   1948: astore 15
    //   1950: iconst_1
    //   1951: istore_3
    //   1952: goto +5 -> 1957
    //   1955: astore 15
    //   1957: new 63	java/lang/StringBuilder
    //   1960: dup
    //   1961: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1964: astore 16
    //   1966: aload 16
    //   1968: aload_0
    //   1969: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: pop
    //   1973: aload 16
    //   1975: ldc_w 480
    //   1978: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: pop
    //   1982: aload 16
    //   1984: aload 15
    //   1986: invokestatic 385	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1989: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: pop
    //   1993: aload 16
    //   1995: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1998: astore_0
    //   1999: iload_2
    //   2000: bipush 64
    //   2002: invokestatic 387	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   2005: istore 5
    //   2007: ldc 128
    //   2009: iconst_1
    //   2010: aload_0
    //   2011: aload 15
    //   2013: invokestatic 448	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2016: aload_0
    //   2017: astore 15
    //   2019: iload_3
    //   2020: istore 4
    //   2022: invokestatic 354	android/os/SystemClock:uptimeMillis	()J
    //   2025: lload 13
    //   2027: lsub
    //   2028: lstore 7
    //   2030: aload 18
    //   2032: iload 5
    //   2034: aload 15
    //   2036: lload 7
    //   2038: invokestatic 375	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   2041: new 63	java/lang/StringBuilder
    //   2044: dup
    //   2045: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2048: astore_0
    //   2049: aload_0
    //   2050: ldc_w 297
    //   2053: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: pop
    //   2057: aload_0
    //   2058: aload_1
    //   2059: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: pop
    //   2063: aload_0
    //   2064: ldc_w 482
    //   2067: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2070: pop
    //   2071: aload_0
    //   2072: lload 7
    //   2074: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2077: pop
    //   2078: aload_0
    //   2079: ldc_w 484
    //   2082: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2085: pop
    //   2086: aload_0
    //   2087: iload 4
    //   2089: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2092: pop
    //   2093: aload_0
    //   2094: ldc_w 349
    //   2097: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2100: pop
    //   2101: aload_0
    //   2102: lload 11
    //   2104: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2107: pop
    //   2108: aload_0
    //   2109: ldc 145
    //   2111: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: pop
    //   2115: ldc 128
    //   2117: iconst_1
    //   2118: aload_0
    //   2119: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2122: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2125: ldc 2
    //   2127: monitorexit
    //   2128: iload 4
    //   2130: ireturn
    //   2131: astore_0
    //   2132: goto +4 -> 2136
    //   2135: astore_0
    //   2136: ldc 2
    //   2138: monitorexit
    //   2139: goto +5 -> 2144
    //   2142: aload_0
    //   2143: athrow
    //   2144: goto -2 -> 2142
    //   2147: astore_0
    //   2148: goto -1177 -> 971
    //   2151: astore_0
    //   2152: goto -1181 -> 971
    //   2155: astore 16
    //   2157: goto -1076 -> 1081
    //   2160: astore_0
    //   2161: iload_2
    //   2162: istore 5
    //   2164: lload 7
    //   2166: lstore 9
    //   2168: aload 15
    //   2170: astore 16
    //   2172: goto -915 -> 1257
    //   2175: astore 16
    //   2177: goto -937 -> 1240
    //   2180: astore_0
    //   2181: goto -933 -> 1248
    //   2184: astore 15
    //   2186: goto -779 -> 1407
    //   2189: astore_1
    //   2190: goto -775 -> 1415
    //   2193: iconst_0
    //   2194: istore_2
    //   2195: iconst_0
    //   2196: istore_3
    //   2197: goto -1699 -> 498
    //   2200: goto -1533 -> 667
    //   2203: iload 5
    //   2205: istore_2
    //   2206: goto -789 -> 1417
    //   2209: iconst_0
    //   2210: istore_3
    //   2211: goto -394 -> 1817
    //   2214: goto -397 -> 1817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2217	0	paramContext	Context
    //   0	2217	1	paramString	String
    //   0	2217	2	paramInt	int
    //   0	2217	3	paramBoolean1	boolean
    //   0	2217	4	paramBoolean2	boolean
    //   672	1532	5	i	int
    //   596	31	6	bool	boolean
    //   51	2114	7	l1	long
    //   305	1862	9	l2	long
    //   669	1434	11	l3	long
    //   150	1876	13	l4	long
    //   60	1048	15	localObject1	Object
    //   1114	5	15	localObject2	Object
    //   1129	48	15	str1	String
    //   1207	47	15	str2	String
    //   1387	5	15	localObject3	Object
    //   1430	142	15	localStringBuilder1	StringBuilder
    //   1584	202	15	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   1824	120	15	localObject4	Object
    //   1948	1	15	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   1955	57	15	localUnsatisfiedLinkError3	UnsatisfiedLinkError
    //   2017	152	15	localContext1	Context
    //   2184	1	15	localIOException1	java.io.IOException
    //   163	1831	16	localObject5	Object
    //   2155	1	16	localIOException2	java.io.IOException
    //   2170	1	16	localContext2	Context
    //   2175	1	16	localIOException3	java.io.IOException
    //   207	663	17	str3	String
    //   913	118	17	localIOException4	java.io.IOException
    //   1124	1	17	localIOException5	java.io.IOException
    //   1139	1	17	localIOException6	java.io.IOException
    //   1144	1	17	localIOException7	java.io.IOException
    //   1158	65	17	localIOException8	java.io.IOException
    //   156	1875	18	localHashMap	HashMap
    //   533	1236	19	localFile	File
    //   561	1035	20	str4	String
    //   572	1022	21	localSharedPreferences	SharedPreferences
    //   936	267	22	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   307	374	379	java/lang/UnsatisfiedLinkError
    //   302	307	383	java/lang/UnsatisfiedLinkError
    //   295	302	389	java/lang/UnsatisfiedLinkError
    //   886	892	913	java/io/IOException
    //   1060	1068	1114	finally
    //   1060	1068	1124	java/io/IOException
    //   1019	1060	1129	finally
    //   1019	1060	1139	java/io/IOException
    //   938	968	1144	java/io/IOException
    //   971	1016	1144	java/io/IOException
    //   865	881	1149	finally
    //   886	892	1149	finally
    //   923	938	1149	finally
    //   938	968	1149	finally
    //   971	1016	1149	finally
    //   865	881	1158	java/io/IOException
    //   923	938	1158	java/io/IOException
    //   1165	1227	1387	finally
    //   1516	1579	1584	java/lang/UnsatisfiedLinkError
    //   1885	1936	1948	java/lang/UnsatisfiedLinkError
    //   1881	1885	1955	java/lang/UnsatisfiedLinkError
    //   1593	1607	2131	finally
    //   1624	1738	2131	finally
    //   1741	1814	2131	finally
    //   1830	1881	2131	finally
    //   1881	1885	2131	finally
    //   1885	1936	2131	finally
    //   1957	2016	2131	finally
    //   2022	2125	2131	finally
    //   3	43	2135	finally
    //   48	158	2135	finally
    //   169	174	2135	finally
    //   174	243	2135	finally
    //   247	291	2135	finally
    //   295	302	2135	finally
    //   302	307	2135	finally
    //   307	374	2135	finally
    //   392	449	2135	finally
    //   452	495	2135	finally
    //   498	598	2135	finally
    //   603	609	2135	finally
    //   609	664	2135	finally
    //   677	685	2135	finally
    //   690	767	2135	finally
    //   772	827	2135	finally
    //   830	859	2135	finally
    //   1073	1078	2135	finally
    //   1096	1100	2135	finally
    //   1232	1237	2135	finally
    //   1244	1248	2135	finally
    //   1257	1272	2135	finally
    //   1278	1346	2135	finally
    //   1349	1378	2135	finally
    //   1399	1404	2135	finally
    //   1411	1415	2135	finally
    //   1415	1417	2135	finally
    //   1417	1504	2135	finally
    //   1504	1511	2135	finally
    //   1516	1579	2135	finally
    //   1586	1593	2135	finally
    //   923	938	2147	java/lang/Exception
    //   938	968	2151	java/lang/Exception
    //   1073	1078	2155	java/io/IOException
    //   1096	1100	2160	java/io/IOException
    //   1232	1237	2175	java/io/IOException
    //   1244	1248	2180	java/io/IOException
    //   1399	1404	2184	java/io/IOException
    //   1411	1415	2189	java/io/IOException
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  public static boolean b()
  {
    String str = System.getProperty("os.arch");
    return (Build.BRAND.equals("asus")) && ((Build.CPU_ABI2.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("i386")) || (str.toLowerCase(Locale.US).contains("i686")) || (str.toLowerCase(Locale.US).contains("i586")) || (str.toLowerCase(Locale.US).contains("i486")));
  }
  
  public static String c()
  {
    return "_32";
  }
  
  private static String d()
  {
    try
    {
      String str = e();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String e()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("x86"))) {
        return "x86";
      }
      if ((str != null) && (str.contains("mip"))) {
        return "mips";
      }
      if (b()) {
        return "x86";
      }
      return "armeabi";
    }
    finally {}
  }
  
  private static String f()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("64"))) {
        return "arm64-v8a";
      }
      return "armeabi";
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */