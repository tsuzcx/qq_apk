package com.tencent.mobileqq.qwallet.impl;

import Wallet.ReportHBGameReq;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.zip.QZipIOException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QWalletTools
{
  public static final Pattern a = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">", 2);
  
  public static int a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    if ((paramMap != null) && (paramMap.containsKey(paramString))) {
      return QwUtils.a(paramMap.get(paramString), paramInt);
    }
    return paramInt;
  }
  
  public static long a(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public static long a(String paramString, long paramLong)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if (TextUtils.isEmpty(paramString)) {
      return paramLong;
    }
    try
    {
      long l = ((SimpleDateFormat)localObject).parse(paramString).getTime();
      return l;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFormatTime exception|");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QWalletTools", 2, ((StringBuilder)localObject).toString());
    }
    return paramLong;
  }
  
  public static View.OnTouchListener a(float paramFloat)
  {
    return new QWalletTools.5(paramFloat);
  }
  
  public static BaseQQAppInterface a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      return (BaseQQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static CharSequence a(String paramString, Context paramContext, QWalletTools.TextUrlClickListener paramTextUrlClickListener)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (paramContext != null)
      {
        if (paramTextUrlClickListener == null) {
          return paramString;
        }
        try
        {
          localObject = new SpannableStringBuilder("");
          Matcher localMatcher = a.matcher(paramString);
          int m = 0;
          int j = 0;
          int k;
          for (int i = 0; localMatcher.find(); i = k)
          {
            m = localMatcher.start(0);
            j = localMatcher.end(0);
            String str1 = paramString.substring(localMatcher.start(1), localMatcher.end(1));
            String str2 = paramString.substring(localMatcher.start(2), localMatcher.end(2));
            k = i;
            if (i != m)
            {
              ((SpannableStringBuilder)localObject).append(paramString.substring(i, m));
              k = j;
            }
            SpannableString localSpannableString = new SpannableString(str1);
            localSpannableString.setSpan(new QWalletTools.2(paramTextUrlClickListener, str2), 0, str1.length(), 33);
            localSpannableString.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(R.color.a)), 0, str1.length(), 33);
            ((SpannableStringBuilder)localObject).append(localSpannableString);
            m = 1;
          }
          if (m != 0)
          {
            ((SpannableStringBuilder)localObject).append(paramString.substring(j));
            return localObject;
          }
          return paramString;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          localObject = null;
        }
      }
    }
    return localObject;
  }
  
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: new 200	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 204	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 206	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 209	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_0
    //   33: new 211	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: invokespecial 212	java/io/ByteArrayOutputStream:<init>	()V
    //   40: astore 4
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore_2
    //   48: aload_0
    //   49: aload_2
    //   50: invokevirtual 216	java/io/FileInputStream:read	([B)I
    //   53: istore_1
    //   54: iload_1
    //   55: iconst_m1
    //   56: if_icmpeq +14 -> 70
    //   59: aload 4
    //   61: aload_2
    //   62: iconst_0
    //   63: iload_1
    //   64: invokevirtual 220	java/io/ByteArrayOutputStream:write	([BII)V
    //   67: goto -19 -> 48
    //   70: new 222	java/io/ByteArrayInputStream
    //   73: dup
    //   74: aload 4
    //   76: invokevirtual 226	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   79: invokespecial 229	java/io/ByteArrayInputStream:<init>	([B)V
    //   82: astore_2
    //   83: new 231	java/io/ObjectInputStream
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 234	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   91: astore_3
    //   92: aload_3
    //   93: invokevirtual 238	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   96: astore 5
    //   98: aload_3
    //   99: invokevirtual 241	java/io/ObjectInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 242	java/io/ByteArrayInputStream:close	()V
    //   106: aload 4
    //   108: invokevirtual 243	java/io/ByteArrayOutputStream:close	()V
    //   111: aload_0
    //   112: invokevirtual 244	java/io/FileInputStream:close	()V
    //   115: aload 5
    //   117: areturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   123: aload 5
    //   125: areturn
    //   126: astore 5
    //   128: aload_0
    //   129: astore 6
    //   131: aload_2
    //   132: astore 7
    //   134: aload 5
    //   136: astore_0
    //   137: aload_3
    //   138: astore 5
    //   140: aload 6
    //   142: astore_2
    //   143: aload 7
    //   145: astore_3
    //   146: goto +329 -> 475
    //   149: astore 6
    //   151: aload_0
    //   152: astore 5
    //   154: aload_2
    //   155: astore 7
    //   157: aload 6
    //   159: astore_0
    //   160: aload 4
    //   162: astore 6
    //   164: aload_0
    //   165: astore 4
    //   167: aload_3
    //   168: astore_0
    //   169: aload 5
    //   171: astore_2
    //   172: aload 7
    //   174: astore_3
    //   175: goto +219 -> 394
    //   178: astore 5
    //   180: aload_0
    //   181: astore 6
    //   183: aload_2
    //   184: astore 7
    //   186: aload 5
    //   188: astore_0
    //   189: aload_3
    //   190: astore 5
    //   192: aload 6
    //   194: astore_2
    //   195: aload 7
    //   197: astore_3
    //   198: goto +270 -> 468
    //   201: astore 5
    //   203: aload_0
    //   204: astore_3
    //   205: aload_2
    //   206: astore 6
    //   208: aload 5
    //   210: astore_0
    //   211: aload 7
    //   213: astore 5
    //   215: aload_3
    //   216: astore_2
    //   217: aload 6
    //   219: astore_3
    //   220: goto +255 -> 475
    //   223: astore 6
    //   225: aload_0
    //   226: astore_3
    //   227: aload_2
    //   228: astore 5
    //   230: aload 6
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_2
    //   235: aload 4
    //   237: astore 6
    //   239: aload_0
    //   240: astore 4
    //   242: aload_2
    //   243: astore_0
    //   244: aload_3
    //   245: astore_2
    //   246: aload 5
    //   248: astore_3
    //   249: goto +145 -> 394
    //   252: astore 7
    //   254: aload_0
    //   255: astore_3
    //   256: aload_2
    //   257: astore 6
    //   259: aload 7
    //   261: astore_0
    //   262: aload_3
    //   263: astore_2
    //   264: aload 6
    //   266: astore_3
    //   267: goto +201 -> 468
    //   270: astore 6
    //   272: aload_0
    //   273: astore_2
    //   274: aconst_null
    //   275: astore_3
    //   276: aload 7
    //   278: astore 5
    //   280: aload 6
    //   282: astore_0
    //   283: goto +192 -> 475
    //   286: astore 5
    //   288: aload_0
    //   289: astore_2
    //   290: aconst_null
    //   291: astore_3
    //   292: aload_3
    //   293: astore_0
    //   294: aload 4
    //   296: astore 6
    //   298: aload 5
    //   300: astore 4
    //   302: goto +92 -> 394
    //   305: astore 6
    //   307: aload_0
    //   308: astore_2
    //   309: aconst_null
    //   310: astore_3
    //   311: aload 6
    //   313: astore_0
    //   314: goto +154 -> 468
    //   317: astore 6
    //   319: aload_0
    //   320: astore_2
    //   321: aconst_null
    //   322: astore_3
    //   323: aload_3
    //   324: astore 4
    //   326: aload 7
    //   328: astore 5
    //   330: aload 6
    //   332: astore_0
    //   333: goto +142 -> 475
    //   336: astore 4
    //   338: aload_0
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_3
    //   342: aload_3
    //   343: astore 6
    //   345: aload 6
    //   347: astore_0
    //   348: goto +46 -> 394
    //   351: astore 6
    //   353: aload_0
    //   354: astore_2
    //   355: aconst_null
    //   356: astore_3
    //   357: aload_3
    //   358: astore 4
    //   360: aload 6
    //   362: astore_0
    //   363: goto +105 -> 468
    //   366: astore_0
    //   367: aconst_null
    //   368: astore_3
    //   369: aload_3
    //   370: astore 4
    //   372: aload 4
    //   374: astore_2
    //   375: aload 7
    //   377: astore 5
    //   379: goto +96 -> 475
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_3
    //   386: aload_3
    //   387: astore 6
    //   389: aload 6
    //   391: astore_0
    //   392: aload_0
    //   393: astore_2
    //   394: aload 4
    //   396: invokevirtual 246	java/lang/OutOfMemoryError:printStackTrace	()V
    //   399: aload_0
    //   400: ifnull +10 -> 410
    //   403: aload_0
    //   404: invokevirtual 241	java/io/ObjectInputStream:close	()V
    //   407: goto +3 -> 410
    //   410: aload_3
    //   411: ifnull +7 -> 418
    //   414: aload_3
    //   415: invokevirtual 242	java/io/ByteArrayInputStream:close	()V
    //   418: aload 6
    //   420: ifnull +8 -> 428
    //   423: aload 6
    //   425: invokevirtual 243	java/io/ByteArrayOutputStream:close	()V
    //   428: aload_2
    //   429: ifnull +13 -> 442
    //   432: aload_2
    //   433: invokevirtual 244	java/io/FileInputStream:close	()V
    //   436: aconst_null
    //   437: areturn
    //   438: aload_0
    //   439: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   442: aconst_null
    //   443: areturn
    //   444: astore 7
    //   446: aload_0
    //   447: astore 5
    //   449: aload 6
    //   451: astore 4
    //   453: aload 7
    //   455: astore_0
    //   456: goto +19 -> 475
    //   459: astore_0
    //   460: aconst_null
    //   461: astore_3
    //   462: aload_3
    //   463: astore 4
    //   465: aload 4
    //   467: astore_2
    //   468: aload_0
    //   469: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   472: aload_0
    //   473: athrow
    //   474: astore_0
    //   475: aload 5
    //   477: ifnull +11 -> 488
    //   480: aload 5
    //   482: invokevirtual 241	java/io/ObjectInputStream:close	()V
    //   485: goto +3 -> 488
    //   488: aload_3
    //   489: ifnull +7 -> 496
    //   492: aload_3
    //   493: invokevirtual 242	java/io/ByteArrayInputStream:close	()V
    //   496: aload 4
    //   498: ifnull +8 -> 506
    //   501: aload 4
    //   503: invokevirtual 243	java/io/ByteArrayOutputStream:close	()V
    //   506: aload_2
    //   507: ifnull +14 -> 521
    //   510: aload_2
    //   511: invokevirtual 244	java/io/FileInputStream:close	()V
    //   514: goto +7 -> 521
    //   517: aload_2
    //   518: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   521: goto +5 -> 526
    //   524: aload_0
    //   525: athrow
    //   526: goto -2 -> 524
    //   529: astore_0
    //   530: goto -92 -> 438
    //   533: astore_2
    //   534: goto -17 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	paramString	String
    //   53	11	1	i	int
    //   47	471	2	localObject1	Object
    //   533	1	2	localIOException	java.io.IOException
    //   91	402	3	localObject2	Object
    //   40	285	4	localObject3	Object
    //   336	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   358	15	4	localObject4	Object
    //   382	13	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   451	51	4	localObject5	Object
    //   4	120	5	localObject6	Object
    //   126	9	5	localObject7	Object
    //   138	32	5	localObject8	Object
    //   178	9	5	localException1	Exception
    //   190	1	5	localObject9	Object
    //   201	8	5	localObject10	Object
    //   213	66	5	localObject11	Object
    //   286	13	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   328	153	5	localObject12	Object
    //   129	12	6	str	String
    //   149	9	6	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   162	56	6	localObject13	Object
    //   223	8	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   237	28	6	localObject14	Object
    //   270	11	6	localObject15	Object
    //   296	1	6	localObject16	Object
    //   305	7	6	localException2	Exception
    //   317	14	6	localObject17	Object
    //   343	3	6	localObject18	Object
    //   351	10	6	localException3	Exception
    //   387	63	6	localObject19	Object
    //   1	211	7	localObject20	Object
    //   252	124	7	localException4	Exception
    //   444	10	7	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   98	115	118	java/io/IOException
    //   92	98	126	finally
    //   92	98	149	java/lang/OutOfMemoryError
    //   92	98	178	java/lang/Exception
    //   83	92	201	finally
    //   83	92	223	java/lang/OutOfMemoryError
    //   83	92	252	java/lang/Exception
    //   42	48	270	finally
    //   48	54	270	finally
    //   59	67	270	finally
    //   70	83	270	finally
    //   42	48	286	java/lang/OutOfMemoryError
    //   48	54	286	java/lang/OutOfMemoryError
    //   59	67	286	java/lang/OutOfMemoryError
    //   70	83	286	java/lang/OutOfMemoryError
    //   42	48	305	java/lang/Exception
    //   48	54	305	java/lang/Exception
    //   59	67	305	java/lang/Exception
    //   70	83	305	java/lang/Exception
    //   33	42	317	finally
    //   33	42	336	java/lang/OutOfMemoryError
    //   33	42	351	java/lang/Exception
    //   6	22	366	finally
    //   24	33	366	finally
    //   6	22	382	java/lang/OutOfMemoryError
    //   24	33	382	java/lang/OutOfMemoryError
    //   394	399	444	finally
    //   6	22	459	java/lang/Exception
    //   24	33	459	java/lang/Exception
    //   468	474	474	finally
    //   403	407	529	java/io/IOException
    //   414	418	529	java/io/IOException
    //   423	428	529	java/io/IOException
    //   432	436	529	java/io/IOException
    //   480	485	533	java/io/IOException
    //   492	496	533	java/io/IOException
    //   501	506	533	java/io/IOException
    //   510	514	533	java/io/IOException
  }
  
  public static String a()
  {
    String str = QWalletValues.b;
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String a(Context paramContext, String paramString, float paramFloat, TextPaint paramTextPaint)
  {
    if (paramFloat == 0.0F) {
      return paramString;
    }
    int i = DisplayUtil.a(paramContext, paramFloat);
    paramFloat = paramTextPaint.measureText(paramString);
    float f = i;
    if (paramFloat <= f) {
      return paramString;
    }
    i = paramString.length();
    while (i > 0)
    {
      paramContext = paramString.substring(0, i - 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("...");
      if (paramTextPaint.measureText(localStringBuilder.toString()) <= f)
      {
        paramString = new StringBuilder();
        paramString.append(paramContext);
        paramString.append("...");
        return paramString.toString();
      }
      i -= 1;
    }
    return paramString;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Utils.a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(paramThrowable.toString());
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int i = 0;
        while ((i < paramThrowable.length) && (i < 16))
        {
          localStringBuilder.append("\n ");
          localStringBuilder.append(paramThrowable[i].toString());
          i += 1;
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (paramMap.containsKey(paramString1))) {
      return (String)paramMap.get(paramString1);
    }
    return paramString2;
  }
  
  public static String a(ZipEntry paramZipEntry)
  {
    if (!QZipIOException.isInvalidEntry(paramZipEntry)) {
      return paramZipEntry.getName();
    }
    throw new QZipIOException();
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static HashMap<String, String> a(JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, paramJSONObject.get(str).toString());
      }
      return localHashMap;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static void a(int paramInt, String paramString)
  {
    BaseQQAppInterface localBaseQQAppInterface = a();
    if (localBaseQQAppInterface == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(localBaseQQAppInterface.getLongAccountUin());
    localStringBuilder.append("||");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(MobileQQ.getContext().getPackageManager().getPackageInfo(MobileQQ.getContext().getPackageName(), 0).versionName);
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    localStringBuilder.append("|");
    localStringBuilder.append(CommonUtil.a());
    localStringBuilder.append("|");
    localStringBuilder.append("|");
    localStringBuilder.append("|");
    StatisticCollector.getInstance(MobileQQ.getContext()).reportToPCliOper(localBaseQQAppInterface, localStringBuilder.toString());
  }
  
  public static void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    try
    {
      paramDrawable.setCallback(null);
      if ((paramDrawable instanceof BitmapDrawable))
      {
        paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
        if ((paramDrawable != null) && (!paramDrawable.isRecycled()))
        {
          paramDrawable.recycle();
          return;
        }
      }
    }
    catch (Exception paramDrawable)
    {
      if (QLog.isDevelopLevel()) {
        paramDrawable.printStackTrace();
      }
    }
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(a(paramFloat));
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    ReportController.b(paramAppInterface, "P_CliOper", "Vip_pay_mywallet", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, ResultReceiver paramResultReceiver)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GrapHbWithParam params:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",gameid:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",score:");
      localStringBuilder.append(paramString3);
      QLog.d("QWalletTools", 2, localStringBuilder.toString());
    }
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("gameid=");
      paramAppInterface.append(paramString2);
      paramAppInterface.append("&point=");
      paramAppInterface.append(paramString3);
      paramAppInterface = paramAppInterface.toString();
      paramString1 = new JSONObject(paramString1);
      paramString1.put("feedsid", paramAppInterface);
      paramAppInterface = new Bundle();
      paramAppInterface.putString("extra_data", paramString1.toString());
      paramAppInterface.putString("callbackSn", "0");
      paramString1 = new Bundle();
      paramString1.putInt("PayInvokerId", 22);
      paramString2 = Parcel.obtain();
      paramResultReceiver.writeToParcel(paramString2, 0);
      paramString2.setDataPosition(0);
      paramString3 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString2);
      paramString2.recycle();
      paramString1.putParcelable("_qwallet_payresult_receiver", paramString3);
      paramString1.putBundle("_qwallet_payparams_data", paramAppInterface);
      paramString1.putString("_qwallet_payparams_tag", "graphb");
      QWalletPayBridge.launchBackground(MobileQQ.getContext(), paramString1);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  private static void a(File paramFile)
  {
    if (paramFile.exists()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Creating dir ");
      localStringBuilder.append(paramFile.getName());
      QLog.i("QWallet.unzip", 2, localStringBuilder.toString());
    }
    if (paramFile.mkdirs()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can not create dir ");
    localStringBuilder.append(paramFile);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  /* Error */
  public static void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 7
    //   8: new 200	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 204	java/io/File:exists	()Z
    //   21: ifne +26 -> 47
    //   24: aload_1
    //   25: invokevirtual 564	java/io/File:getParentFile	()Ljava/io/File;
    //   28: invokevirtual 204	java/io/File:exists	()Z
    //   31: ifne +11 -> 42
    //   34: aload_1
    //   35: invokevirtual 564	java/io/File:getParentFile	()Ljava/io/File;
    //   38: invokevirtual 256	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: aload_1
    //   43: invokevirtual 567	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 569	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 570	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_2
    //   56: new 211	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 212	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore_1
    //   64: aload 4
    //   66: astore_3
    //   67: aload_1
    //   68: astore 4
    //   70: aload_2
    //   71: astore 6
    //   73: new 572	java/io/ObjectOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 575	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   81: astore 5
    //   83: aload 5
    //   85: aload_0
    //   86: invokevirtual 579	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   89: aload 5
    //   91: invokevirtual 582	java/io/ObjectOutputStream:flush	()V
    //   94: aload_1
    //   95: aload_2
    //   96: invokevirtual 585	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   99: aload 5
    //   101: invokevirtual 586	java/io/ObjectOutputStream:close	()V
    //   104: aload_1
    //   105: invokevirtual 243	java/io/ByteArrayOutputStream:close	()V
    //   108: aload_2
    //   109: invokevirtual 587	java/io/FileOutputStream:close	()V
    //   112: return
    //   113: astore 4
    //   115: aload 5
    //   117: astore_3
    //   118: aload_1
    //   119: astore_0
    //   120: aload 4
    //   122: astore_1
    //   123: goto +111 -> 234
    //   126: astore_3
    //   127: aload_1
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: goto +48 -> 179
    //   134: astore_3
    //   135: aload 7
    //   137: astore 5
    //   139: aload_1
    //   140: astore_0
    //   141: aload_3
    //   142: astore_1
    //   143: goto +36 -> 179
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: goto +85 -> 234
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 7
    //   157: astore 5
    //   159: goto +20 -> 179
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_0
    //   167: goto +67 -> 234
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: astore_0
    //   175: aload 7
    //   177: astore 5
    //   179: aload 5
    //   181: astore_3
    //   182: aload_0
    //   183: astore 4
    //   185: aload_2
    //   186: astore 6
    //   188: aload_1
    //   189: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   192: aload 5
    //   194: ifnull +11 -> 205
    //   197: aload 5
    //   199: invokevirtual 586	java/io/ObjectOutputStream:close	()V
    //   202: goto +3 -> 205
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 243	java/io/ByteArrayOutputStream:close	()V
    //   213: aload_2
    //   214: ifnull +12 -> 226
    //   217: aload_2
    //   218: invokevirtual 587	java/io/FileOutputStream:close	()V
    //   221: return
    //   222: aload_0
    //   223: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   226: return
    //   227: astore_1
    //   228: aload 6
    //   230: astore_2
    //   231: aload 4
    //   233: astore_0
    //   234: aload_3
    //   235: ifnull +10 -> 245
    //   238: aload_3
    //   239: invokevirtual 586	java/io/ObjectOutputStream:close	()V
    //   242: goto +3 -> 245
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 243	java/io/ByteArrayOutputStream:close	()V
    //   253: aload_2
    //   254: ifnull +14 -> 268
    //   257: aload_2
    //   258: invokevirtual 587	java/io/FileOutputStream:close	()V
    //   261: goto +7 -> 268
    //   264: aload_0
    //   265: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_0
    //   271: goto -49 -> 222
    //   274: astore_0
    //   275: goto -11 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramObject	Object
    //   0	278	1	paramString	String
    //   55	203	2	localObject1	Object
    //   4	114	3	localObject2	Object
    //   126	4	3	localThrowable1	Throwable
    //   134	8	3	localThrowable2	Throwable
    //   181	58	3	localObject3	Object
    //   1	68	4	str	String
    //   113	8	4	localObject4	Object
    //   183	49	4	localObject5	Object
    //   81	117	5	localObject6	Object
    //   71	158	6	localObject7	Object
    //   6	170	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   83	99	113	finally
    //   83	99	126	java/lang/Throwable
    //   73	83	134	java/lang/Throwable
    //   56	64	146	finally
    //   56	64	152	java/lang/Throwable
    //   8	42	162	finally
    //   42	47	162	finally
    //   47	56	162	finally
    //   8	42	170	java/lang/Throwable
    //   42	47	170	java/lang/Throwable
    //   47	56	170	java/lang/Throwable
    //   73	83	227	finally
    //   188	192	227	finally
    //   99	112	270	java/io/IOException
    //   197	202	270	java/io/IOException
    //   209	213	270	java/io/IOException
    //   217	221	270	java/io/IOException
    //   238	242	274	java/io/IOException
    //   249	253	274	java/io/IOException
    //   257	261	274	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        FileUtils.delete(paramString, false);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, long paramLong, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    ReportHBGameReq localReportHBGameReq = new ReportHBGameReq();
    localReportHBGameReq.sHBId = paramString1;
    localReportHBGameReq.lUin = paramLong;
    localReportHBGameReq.sPoint = paramString2;
    localReportHBGameReq.iAmount = paramInt1;
    localReportHBGameReq.bSucc = paramBoolean1;
    localReportHBGameReq.bStart = paramBoolean2;
    localReportHBGameReq.iGameId = paramInt2;
    QWalletCommonServlet.a(localReportHBGameReq, new QWalletTools.4());
  }
  
  public static void a(String paramString, boolean paramBoolean, File paramFile)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("1.0 delete ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(paramFile);
    ((StringBuilder)localObject1).append(paramFile.exists());
    QLog.d("QWalletTools", 2, ((StringBuilder)localObject1).toString());
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("1.0 delete tag0");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(paramString.exists());
    QLog.d("QWalletTools", 2, ((StringBuilder)localObject1).toString());
    if (!paramString.exists())
    {
      paramString = new StringBuilder();
      paramString.append("1.0 delete tag1");
      paramString.append(paramFile.exists());
      QLog.d("QWalletTools", 2, paramString.toString());
      return;
    }
    if (paramString.isFile())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("1.0 delete tag2");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(paramString.exists());
      ((StringBuilder)localObject1).append(paramFile.exists());
      QLog.d("QWalletTools", 2, ((StringBuilder)localObject1).toString());
      paramString.delete();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("1.0 delete tag3");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(paramString.exists());
      ((StringBuilder)localObject1).append(paramFile.exists());
      QLog.d("QWalletTools", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject1 = paramString.listFiles();
    if (localObject1 == null)
    {
      paramString = new StringBuilder();
      paramString.append("1.0 delete tag4");
      paramString.append(paramFile.exists());
      QLog.d("QWalletTools", 2, paramString.toString());
      return;
    }
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("1.0 delete tag5");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(paramFile.exists());
      QLog.d("QWalletTools", 2, localStringBuilder.toString());
      a(localObject2.getAbsolutePath(), paramBoolean, paramFile);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("1.0 delete tag6");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(paramFile.exists());
      QLog.d("QWalletTools", 2, localStringBuilder.toString());
      i += 1;
    }
    if (!paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("1.0 delete tag7");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(paramFile.exists());
      QLog.d("QWalletTools", 2, ((StringBuilder)localObject1).toString());
      paramString.delete();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("1.0 delete tag8");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(paramFile.exists());
      QLog.d("QWalletTools", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, String paramString, boolean paramBoolean)
  {
    String str = a(paramZipEntry);
    if (paramZipEntry.isDirectory())
    {
      a(new File(paramString, str));
      return;
    }
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("tmp");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = str;
    }
    Object localObject1 = new File(paramString, (String)localObject1);
    if (!((File)localObject1).getParentFile().exists()) {
      a(((File)localObject1).getParentFile());
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Extracting: ");
      ((StringBuilder)localObject2).append(paramZipEntry);
      QLog.i("QWallet.unzip", 2, ((StringBuilder)localObject2).toString());
    }
    paramZipFile = new BufferedInputStream(paramZipFile.getInputStream(paramZipEntry));
    paramZipEntry = new BufferedOutputStream(new FileOutputStream((File)localObject1));
    try
    {
      localObject2 = new byte[8192];
      for (;;)
      {
        int i = paramZipFile.read((byte[])localObject2, 0, 8192);
        if (i == -1) {
          break;
        }
        paramZipEntry.write((byte[])localObject2, 0, i);
      }
      paramZipEntry.close();
      paramZipFile.close();
      if (paramBoolean) {
        FileUtils.renameFile((File)localObject1, new File(paramString, str));
      }
      return;
    }
    finally
    {
      paramZipEntry.close();
      paramZipFile.close();
      if (paramBoolean) {
        FileUtils.renameFile((File)localObject1, new File(paramString, str));
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if (paramAppRuntime != null) {
      ThreadManager.excute(new QWalletTools.6(paramMessageRecord), 32, null, false);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ThreadManager.post(new QWalletTools.3(paramString1, paramInt2, paramString3, paramAppRuntime, paramString4, paramString5, paramInt1, paramString2, paramLong), 2, null, true);
  }
  
  public static void a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, new QWalletTools.1());
  }
  
  public static boolean a(Context paramContext)
  {
    return (paramContext != null) && ((AudioDeviceHelper.b(paramContext)) || (AudioDeviceHelper.a(paramContext)));
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = arrayOfInt[1];
    int k = paramView.getHeight();
    int m = arrayOfInt[0];
    int n = arrayOfInt[0];
    int i1 = paramView.getWidth();
    return (paramFloat2 >= i) && (paramFloat2 < j + k) && (paramFloat1 > m) && (paramFloat1 < n + i1);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists()) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("Tmp");
    String str = ((StringBuilder)localObject).toString();
    localObject = new File(str);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unzipAtomically1");
      localStringBuilder.append(localFile);
      localStringBuilder.append(localFile.exists());
      localStringBuilder.append(localObject);
      localStringBuilder.append(((File)localObject).exists());
      QLog.d("QWalletTools", 2, localStringBuilder.toString());
    }
    FileUtils.delete(str, false);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unzipAtomically2");
      localStringBuilder.append(localFile);
      localStringBuilder.append(localFile.exists());
      localStringBuilder.append(localObject);
      localStringBuilder.append(((File)localObject).exists());
      QLog.d("QWalletTools", 2, localStringBuilder.toString());
    }
    if ((QLog.isColorLevel()) && (!localFile.exists())) {
      try
      {
        FileUtils.writeFile(new byte[] { 0, 0 }, paramString1);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("3.");
        localStringBuilder.append(localFile);
        localStringBuilder.append(localFile.exists());
        QLog.d("QWalletTools", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("intern");
        a(localStringBuilder.toString(), false, localFile);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("4.");
        localStringBuilder.append(localFile);
        localStringBuilder.append(localFile.exists());
        QLog.d("QWalletTools", 2, localStringBuilder.toString());
        FileUtils.writeFile(new byte[] { 0, 0 }, paramString1);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0.");
        localStringBuilder.append(localFile);
        localStringBuilder.append(localFile.exists());
        QLog.d("QWalletTools", 2, localStringBuilder.toString());
        a(str, false, localFile);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("2.");
        localStringBuilder.append(localFile);
        localStringBuilder.append(localFile.exists());
        QLog.d("QWalletTools", 2, localStringBuilder.toString());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (!b(paramString1, str)) {
      return false;
    }
    if (!((File)localObject).exists()) {
      return false;
    }
    paramString1 = new File(paramString2);
    FileUtils.delete(paramString2, false);
    if (!FileUtils.renameFile((File)localObject, paramString1)) {
      return false;
    }
    return paramString1.exists();
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 200	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 777	com/tencent/commonsdk/zip/QZipFile
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 778	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_0
    //   22: aload_3
    //   23: invokevirtual 782	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   26: astore 5
    //   28: aload_3
    //   29: astore_0
    //   30: aload 5
    //   32: invokeinterface 787 1 0
    //   37: ifeq +24 -> 61
    //   40: aload_3
    //   41: astore_0
    //   42: aload_3
    //   43: aload 5
    //   45: invokeinterface 790 1 0
    //   50: checkcast 317	java/util/zip/ZipEntry
    //   53: aload_1
    //   54: iload_2
    //   55: invokestatic 792	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/lang/String;Z)V
    //   58: goto -30 -> 28
    //   61: aload_3
    //   62: invokevirtual 793	java/util/zip/ZipFile:close	()V
    //   65: goto +8 -> 73
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   73: iconst_1
    //   74: ireturn
    //   75: astore_0
    //   76: aload_3
    //   77: astore_1
    //   78: aload_0
    //   79: astore_3
    //   80: goto +12 -> 92
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: goto +87 -> 173
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +58 -> 155
    //   100: aload_1
    //   101: astore_0
    //   102: new 79	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   109: astore 5
    //   111: aload_1
    //   112: astore_0
    //   113: aload 5
    //   115: ldc_w 795
    //   118: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: astore_0
    //   124: aload 5
    //   126: aload 4
    //   128: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_1
    //   133: astore_0
    //   134: aload 5
    //   136: aload_3
    //   137: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: astore_0
    //   143: ldc_w 548
    //   146: iconst_2
    //   147: aload 5
    //   149: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_1
    //   156: ifnull +14 -> 170
    //   159: aload_1
    //   160: invokevirtual 793	java/util/zip/ZipFile:close	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_1
    //   173: aload_0
    //   174: ifnull +15 -> 189
    //   177: aload_0
    //   178: invokevirtual 793	java/util/zip/ZipFile:close	()V
    //   181: goto +8 -> 189
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   189: goto +5 -> 194
    //   192: aload_1
    //   193: athrow
    //   194: goto -2 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramString1	String
    //   0	197	1	paramString2	String
    //   0	197	2	paramBoolean	boolean
    //   19	61	3	localObject1	Object
    //   89	48	3	localThrowable	Throwable
    //   8	119	4	localFile	File
    //   26	122	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	68	java/lang/Throwable
    //   22	28	75	java/lang/Throwable
    //   30	40	75	java/lang/Throwable
    //   42	58	75	java/lang/Throwable
    //   10	20	83	finally
    //   10	20	89	java/lang/Throwable
    //   159	163	165	java/lang/Throwable
    //   22	28	172	finally
    //   30	40	172	finally
    //   42	58	172	finally
    //   94	100	172	finally
    //   102	111	172	finally
    //   113	122	172	finally
    //   124	132	172	finally
    //   134	141	172	finally
    //   143	155	172	finally
    //   177	181	184	java/lang/Throwable
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    int m = 0;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramInt != 0))
    {
      if ((paramArrayOfByte2.length >= paramInt) && (paramArrayOfByte3.length >= paramInt))
      {
        System.currentTimeMillis();
        int n = paramInt / 2;
        short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { 2, n });
        paramInt = 0;
        int j;
        while (paramInt < n)
        {
          short[] arrayOfShort1 = arrayOfShort[0];
          i = paramInt * 2;
          j = paramArrayOfByte2[i];
          arrayOfShort1[paramInt] = ((short)((paramArrayOfByte2[(i + 1)] & 0xFF) << 8 | j & 0xFF));
          paramInt += 1;
        }
        paramInt = 0;
        while (paramInt < n)
        {
          paramArrayOfByte2 = arrayOfShort[1];
          i = paramInt * 2;
          j = paramArrayOfByte3[i];
          paramArrayOfByte2[paramInt] = ((short)((paramArrayOfByte3[(i + 1)] & 0xFF) << 8 | j & 0xFF));
          paramInt += 1;
        }
        paramArrayOfByte2 = new short[n];
        int i = 0;
        for (;;)
        {
          paramInt = m;
          if (i >= n) {
            break;
          }
          j = 0;
          int k;
          for (paramInt = 0; j < 2; paramInt = k)
          {
            k = paramInt;
            if (arrayOfShort[j].length > i)
            {
              double d2 = paramInt;
              double d1;
              if (j == 0) {
                d1 = 1.5D;
              } else {
                d1 = 0.5D;
              }
              double d3 = arrayOfShort[j][i];
              Double.isNaN(d3);
              Double.isNaN(d2);
              k = (int)(d2 + d1 * d3);
            }
            j += 1;
          }
          j = -32767;
          if (paramInt > 32767) {
            paramInt = 32767;
          } else if (paramInt < -32767) {
            paramInt = j;
          }
          paramArrayOfByte2[i] = ((short)paramInt);
          i += 1;
        }
        while (paramInt < n)
        {
          i = paramInt * 2;
          paramArrayOfByte1[i] = ((byte)(paramArrayOfByte2[paramInt] & 0xFF));
          paramArrayOfByte1[(i + 1)] = ((byte)((paramArrayOfByte2[paramInt] & 0xFF00) >> 8));
          paramInt += 1;
        }
        System.currentTimeMillis();
        return true;
      }
      QLog.e("QWalletTools", 1, "mix, inputA.length < size || inputB.length < size");
      return false;
    }
    QLog.e("QWalletTools", 1, "mix, dst == null || inputA == null || inputB == null || size == 0");
    return false;
  }
  
  /* Error */
  public static Drawable[] a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +40 -> 43
    //   6: new 79	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc_w 836
    //   20: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 6
    //   26: aload_0
    //   27: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc_w 838
    //   34: iconst_2
    //   35: aload 6
    //   37: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: new 200	java/io/File
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 204	java/io/File:exists	()Z
    //   56: ifne +21 -> 77
    //   59: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +13 -> 75
    //   65: ldc_w 838
    //   68: iconst_2
    //   69: ldc_w 840
    //   72: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aconst_null
    //   76: areturn
    //   77: aload_0
    //   78: invokevirtual 651	java/io/File:listFiles	()[Ljava/io/File;
    //   81: astore 8
    //   83: aload 8
    //   85: ifnull +524 -> 609
    //   88: aload 8
    //   90: arraylength
    //   91: ifgt +6 -> 97
    //   94: goto +515 -> 609
    //   97: aload 8
    //   99: invokestatic 842	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	([Ljava/io/File;)V
    //   102: aload 8
    //   104: arraylength
    //   105: anewarray 415	android/graphics/drawable/Drawable
    //   108: astore 9
    //   110: iconst_0
    //   111: istore 4
    //   113: iconst_0
    //   114: istore_1
    //   115: iconst_0
    //   116: istore_2
    //   117: aload 8
    //   119: arraylength
    //   120: istore_3
    //   121: iconst_1
    //   122: istore 5
    //   124: iload_1
    //   125: iload_3
    //   126: if_icmpge +419 -> 545
    //   129: iload_2
    //   130: istore_3
    //   131: aload 8
    //   133: iload_1
    //   134: aaload
    //   135: ifnull +401 -> 536
    //   138: iload_2
    //   139: istore_3
    //   140: aload 8
    //   142: iload_1
    //   143: aaload
    //   144: invokevirtual 641	java/io/File:isFile	()Z
    //   147: ifeq +389 -> 536
    //   150: iload_2
    //   151: istore_3
    //   152: aload 8
    //   154: iload_1
    //   155: aaload
    //   156: invokevirtual 658	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: invokestatic 846	com/tencent/mobileqq/utils/FileUtils:isPicFile	(Ljava/lang/String;)Z
    //   162: ifeq +374 -> 536
    //   165: new 682	java/io/BufferedInputStream
    //   168: dup
    //   169: new 206	java/io/FileInputStream
    //   172: dup
    //   173: aload 8
    //   175: iload_1
    //   176: aaload
    //   177: invokevirtual 658	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokespecial 847	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   183: invokespecial 689	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   186: astore 6
    //   188: aload 6
    //   190: astore_0
    //   191: aload 9
    //   193: iload_1
    //   194: new 421	android/graphics/drawable/BitmapDrawable
    //   197: dup
    //   198: aload 6
    //   200: invokespecial 848	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   203: aastore
    //   204: aload 6
    //   206: invokevirtual 698	java/io/BufferedInputStream:close	()V
    //   209: goto +173 -> 382
    //   212: astore_0
    //   213: iload 5
    //   215: istore_2
    //   216: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +163 -> 382
    //   222: new 79	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   229: astore 6
    //   231: aload 6
    //   233: ldc_w 850
    //   236: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: aload_0
    //   243: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc_w 838
    //   250: iconst_2
    //   251: aload 6
    //   253: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: iload 5
    //   261: istore_2
    //   262: goto +120 -> 382
    //   265: astore 7
    //   267: goto +15 -> 282
    //   270: astore 6
    //   272: aconst_null
    //   273: astore_0
    //   274: goto +204 -> 478
    //   277: astore 7
    //   279: aconst_null
    //   280: astore 6
    //   282: aload 6
    //   284: astore_0
    //   285: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +53 -> 341
    //   291: aload 6
    //   293: astore_0
    //   294: new 79	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   301: astore 10
    //   303: aload 6
    //   305: astore_0
    //   306: aload 10
    //   308: ldc_w 852
    //   311: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 6
    //   317: astore_0
    //   318: aload 10
    //   320: aload 7
    //   322: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 6
    //   328: astore_0
    //   329: ldc_w 838
    //   332: iconst_2
    //   333: aload 10
    //   335: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: iload 5
    //   343: istore_2
    //   344: aload 6
    //   346: ifnull +36 -> 382
    //   349: aload 6
    //   351: invokevirtual 698	java/io/BufferedInputStream:close	()V
    //   354: iload 5
    //   356: istore_2
    //   357: goto +25 -> 382
    //   360: astore_0
    //   361: iload 5
    //   363: istore_2
    //   364: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +15 -> 382
    //   370: new 79	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   377: astore 6
    //   379: goto -148 -> 231
    //   382: iload_2
    //   383: ifne +24 -> 407
    //   386: aload 9
    //   388: iload_1
    //   389: aaload
    //   390: checkcast 421	android/graphics/drawable/BitmapDrawable
    //   393: invokevirtual 425	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   396: ifnonnull +6 -> 402
    //   399: goto +8 -> 407
    //   402: iload_2
    //   403: istore_3
    //   404: goto +132 -> 536
    //   407: iload_1
    //   408: istore_2
    //   409: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +44 -> 456
    //   415: new 79	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   422: astore_0
    //   423: aload_0
    //   424: ldc_w 854
    //   427: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_0
    //   432: aload 8
    //   434: iload_1
    //   435: aaload
    //   436: invokevirtual 658	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   439: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc_w 838
    //   446: iconst_2
    //   447: aload_0
    //   448: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: iload_1
    //   455: istore_2
    //   456: iload_2
    //   457: iflt +17 -> 474
    //   460: aload 9
    //   462: iload_2
    //   463: aaload
    //   464: invokestatic 856	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	(Landroid/graphics/drawable/Drawable;)V
    //   467: iload_2
    //   468: iconst_1
    //   469: isub
    //   470: istore_2
    //   471: goto -15 -> 456
    //   474: aconst_null
    //   475: areturn
    //   476: astore 6
    //   478: aload_0
    //   479: ifnull +54 -> 533
    //   482: aload_0
    //   483: invokevirtual 698	java/io/BufferedInputStream:close	()V
    //   486: goto +47 -> 533
    //   489: astore_0
    //   490: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +40 -> 533
    //   496: new 79	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   503: astore 7
    //   505: aload 7
    //   507: ldc_w 850
    //   510: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 7
    //   516: aload_0
    //   517: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: ldc_w 838
    //   524: iconst_2
    //   525: aload 7
    //   527: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload 6
    //   535: athrow
    //   536: iload_1
    //   537: iconst_1
    //   538: iadd
    //   539: istore_1
    //   540: iload_3
    //   541: istore_2
    //   542: goto -425 -> 117
    //   545: aload 9
    //   547: arraylength
    //   548: istore 5
    //   550: iconst_0
    //   551: istore_2
    //   552: iload 4
    //   554: istore_1
    //   555: iload_1
    //   556: iload 5
    //   558: if_icmpge +25 -> 583
    //   561: iload_2
    //   562: istore_3
    //   563: aload 9
    //   565: iload_1
    //   566: aaload
    //   567: ifnull +7 -> 574
    //   570: iload_2
    //   571: iconst_1
    //   572: iadd
    //   573: istore_3
    //   574: iload_1
    //   575: iconst_1
    //   576: iadd
    //   577: istore_1
    //   578: iload_3
    //   579: istore_2
    //   580: goto -25 -> 555
    //   583: iload_2
    //   584: iconst_1
    //   585: if_icmpge +21 -> 606
    //   588: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +13 -> 604
    //   594: ldc_w 838
    //   597: iconst_2
    //   598: ldc_w 858
    //   601: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aconst_null
    //   605: areturn
    //   606: aload 9
    //   608: areturn
    //   609: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +13 -> 625
    //   615: ldc_w 838
    //   618: iconst_2
    //   619: ldc_w 860
    //   622: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: aconst_null
    //   626: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	paramString	String
    //   114	464	1	i	int
    //   116	470	2	j	int
    //   120	459	3	k	int
    //   111	442	4	m	int
    //   122	437	5	n	int
    //   13	239	6	localObject1	Object
    //   270	1	6	localObject2	Object
    //   280	98	6	localStringBuilder1	StringBuilder
    //   476	58	6	localObject3	Object
    //   265	1	7	localThrowable1	Throwable
    //   277	44	7	localThrowable2	Throwable
    //   503	23	7	localStringBuilder2	StringBuilder
    //   81	352	8	arrayOfFile	File[]
    //   108	499	9	arrayOfDrawable	Drawable[]
    //   301	33	10	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   204	209	212	java/io/IOException
    //   191	204	265	java/lang/Throwable
    //   165	188	270	finally
    //   165	188	277	java/lang/Throwable
    //   349	354	360	java/io/IOException
    //   191	204	476	finally
    //   285	291	476	finally
    //   294	303	476	finally
    //   306	315	476	finally
    //   318	326	476	finally
    //   329	341	476	finally
    //   482	486	489	java/io/IOException
  }
  
  public static long b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1L;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      if (paramString != null)
      {
        long l = paramString.getTime();
        return l;
      }
      return -1L;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 862	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 863	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 5
    //   16: new 865	java/io/FileReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 866	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: astore_2
    //   27: new 868	java/io/BufferedReader
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 871	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 874	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +22 -> 64
    //   45: aload 6
    //   47: aload_1
    //   48: invokevirtual 877	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload 6
    //   54: ldc_w 879
    //   57: invokevirtual 877	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   60: pop
    //   61: goto -25 -> 36
    //   64: aload_3
    //   65: invokestatic 881	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	(Ljava/io/Closeable;)V
    //   68: goto +48 -> 116
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: goto +59 -> 133
    //   77: astore 4
    //   79: goto +24 -> 103
    //   82: astore 4
    //   84: aload 5
    //   86: astore_3
    //   87: goto +16 -> 103
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_0
    //   93: goto +40 -> 133
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_0
    //   100: aload 5
    //   102: astore_3
    //   103: aload_3
    //   104: astore_1
    //   105: aload_0
    //   106: astore_2
    //   107: aload 4
    //   109: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   112: aload_3
    //   113: invokestatic 881	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	(Ljava/io/Closeable;)V
    //   116: aload_0
    //   117: invokestatic 881	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	(Ljava/io/Closeable;)V
    //   120: aload 6
    //   122: invokevirtual 882	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   125: areturn
    //   126: astore_3
    //   127: aload_2
    //   128: astore_0
    //   129: aload_1
    //   130: astore_2
    //   131: aload_3
    //   132: astore_1
    //   133: aload_2
    //   134: invokestatic 881	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	(Ljava/io/Closeable;)V
    //   137: aload_0
    //   138: invokestatic 881	com/tencent/mobileqq/qwallet/impl/QWalletTools:a	(Ljava/io/Closeable;)V
    //   141: goto +5 -> 146
    //   144: aload_1
    //   145: athrow
    //   146: goto -2 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString	String
    //   10	38	1	str	String
    //   71	1	1	localObject1	Object
    //   90	1	1	localObject2	Object
    //   104	41	1	localObject3	Object
    //   12	122	2	localObject4	Object
    //   35	78	3	localObject5	Object
    //   126	6	3	localObject6	Object
    //   77	1	4	localThrowable1	Throwable
    //   82	1	4	localThrowable2	Throwable
    //   96	12	4	localThrowable3	Throwable
    //   14	87	5	localObject7	Object
    //   7	114	6	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   36	41	71	finally
    //   45	61	71	finally
    //   36	41	77	java/lang/Throwable
    //   45	61	77	java/lang/Throwable
    //   27	36	82	java/lang/Throwable
    //   16	25	90	finally
    //   16	25	96	java/lang/Throwable
    //   27	36	126	finally
    //   107	112	126	finally
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, false);
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 == null)) {
      return false;
    }
    if ((paramString1 == null) && (paramString2 != null)) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletTools
 * JD-Core Version:    0.7.0.1
 */