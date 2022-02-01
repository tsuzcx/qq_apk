package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.m;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;

public class b
{
  public static byte[] a = null;
  
  static
  {
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  private static String a(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      if (paramContext != null)
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext != null)
        {
          localObject = new StringBuilder("");
          if (paramContext != null)
          {
            if (paramContext.length <= 0) {
              return null;
            }
            while (i < paramContext.length)
            {
              String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
              if (i > 0) {
                ((StringBuilder)localObject).append(":");
              }
              if (str.length() < 2) {
                ((StringBuilder)localObject).append(0);
              }
              ((StringBuilder)localObject).append(str);
              i += 1;
            }
            paramContext = ((StringBuilder)localObject).toString();
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    new b.1("HttpUtils", paramContext, paramThirdAppInfoNew).start();
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (("reset".equals(paramString1)) && ("true".equals(paramString2))) {
      QbSdk.reset(paramContext);
    }
    for (;;)
    {
      return;
      if (paramString1.startsWith("rmfile")) {
        try
        {
          paramContext = paramContext.getSharedPreferences("tbs_status", 0);
          if (!paramContext.getBoolean(paramString1, false))
          {
            File localFile = new File(paramString2);
            if ((paramString2 != null) && (localFile.exists()))
            {
              TbsLog.i("HttpUtils", "received command,delete" + paramString2);
              FileUtil.b(localFile);
            }
            paramContext.edit().putBoolean(paramString1, true).apply();
            return;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if ((QbSdk.getSettings() != null) && (QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    Object localObject3 = "";
    Object localObject2 = localObject3;
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        localObject1 = localObject3;
        localObject2 = localObject3;
        if ("com.tencent.mobileqq".equals(localApplicationInfo.packageName))
        {
          localObject2 = localObject3;
          localObject3 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0).versionName;
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber()))
          {
            localObject2 = localObject3;
            localObject1 = (String)localObject3 + "." + QbSdk.getQQBuildNumber();
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1 = localObject2;
        localException.printStackTrace();
        continue;
        ((ThirdAppInfoNew)localObject2).sQua2 = j.a(paramContext);
        continue;
        ((ThirdAppInfoNew)localObject2).iCoreType = 1;
        continue;
        ((ThirdAppInfoNew)localObject2).iCoreType = 0;
        continue;
      }
      try
      {
        localObject2 = new ThirdAppInfoNew();
        ((ThirdAppInfoNew)localObject2).sAppName = paramContext.getApplicationContext().getApplicationInfo().packageName;
        m.a(paramContext);
        localObject3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+08"));
        ((ThirdAppInfoNew)localObject2).sTime = ((SimpleDateFormat)localObject3).format(Calendar.getInstance().getTime());
        ((ThirdAppInfoNew)localObject2).sVersionCode = com.tencent.smtt.utils.b.d(paramContext);
        localObject3 = com.tencent.smtt.utils.b.a(paramContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((ThirdAppInfoNew)localObject2).sMetaData = ((String)localObject3);
        }
        ((ThirdAppInfoNew)localObject2).sGuid = paramString1;
        if (paramBoolean1)
        {
          ((ThirdAppInfoNew)localObject2).sQua2 = paramString2;
          ((ThirdAppInfoNew)localObject2).bIsSandboxMode = paramBoolean2;
          ((ThirdAppInfoNew)localObject2).sLc = paramString3;
          paramString1 = com.tencent.smtt.utils.b.h(paramContext);
          paramString2 = com.tencent.smtt.utils.b.f(paramContext);
          paramString3 = com.tencent.smtt.utils.b.g(paramContext);
          localObject3 = com.tencent.smtt.utils.b.i(paramContext);
          if ((paramString2 != null) && (!"".equals(paramString2))) {
            ((ThirdAppInfoNew)localObject2).sImei = paramString2;
          }
          if ((paramString3 != null) && (!"".equals(paramString3))) {
            ((ThirdAppInfoNew)localObject2).sImsi = paramString3;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ThirdAppInfoNew)localObject2).sAndroidID = ((String)localObject3);
          }
          if ((paramString1 != null) && (!"".equals(paramString1))) {
            ((ThirdAppInfoNew)localObject2).sMac = paramString1;
          }
          ((ThirdAppInfoNew)localObject2).iPv = paramInt;
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break label549;
          }
          if (!paramBoolean1) {
            continue;
          }
          if (!TbsShareManager.getCoreFormOwn()) {
            continue;
          }
          ((ThirdAppInfoNew)localObject2).iCoreType = 2;
          if (paramBoolean2) {
            ((ThirdAppInfoNew)localObject2).iCoreType = 3;
          }
          ((ThirdAppInfoNew)localObject2).sAppVersionName = ((String)localObject1);
          ((ThirdAppInfoNew)localObject2).sAppSignature = a(paramContext);
          if (!paramBoolean1)
          {
            ((ThirdAppInfoNew)localObject2).sWifiConnectedTime = paramLong;
            ((ThirdAppInfoNew)localObject2).localCoreVersion = QbSdk.getTbsVersion(paramContext);
          }
          a((ThirdAppInfoNew)localObject2, paramContext.getApplicationContext());
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    for (;;)
    {
      ((ThirdAppInfoNew)localObject2).iCoreType = paramInt;
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      ((ThirdAppInfoNew)localObject2).iCoreType = 3;
      break;
      label549:
      do
      {
        paramInt = 0;
        break;
      } while (!paramBoolean1);
      paramInt = 1;
    }
  }
  
  /* Error */
  private static String b(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 73
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 399	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 402	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +133 -> 155
    //   25: aload_0
    //   26: ldc_w 404
    //   29: invokevirtual 407	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifeq +123 -> 155
    //   35: new 409	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 412	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: new 414	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 415	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 4
    //   54: sipush 128
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 421	java/io/InputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +136 -> 206
    //   73: aload 4
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 425	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -21 -> 61
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   100: aload 5
    //   102: astore 4
    //   104: aload_0
    //   105: ifnull +11 -> 116
    //   108: aload_0
    //   109: invokevirtual 429	java/io/InputStream:close	()V
    //   112: aload 5
    //   114: astore 4
    //   116: ldc 114
    //   118: new 71	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 431
    //   128: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 4
    //   133: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 433
    //   139: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_2
    //   143: invokevirtual 436	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 172	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 4
    //   154: areturn
    //   155: aload_0
    //   156: ifnull +44 -> 200
    //   159: aload_0
    //   160: ldc_w 438
    //   163: invokevirtual 407	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   166: ifeq +34 -> 200
    //   169: new 440	java/util/zip/InflaterInputStream
    //   172: dup
    //   173: aload 4
    //   175: new 442	java/util/zip/Inflater
    //   178: dup
    //   179: iconst_1
    //   180: invokespecial 445	java/util/zip/Inflater:<init>	(Z)V
    //   183: invokespecial 448	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   186: astore_0
    //   187: goto -142 -> 45
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_0
    //   193: aload 6
    //   195: astore 4
    //   197: goto -111 -> 86
    //   200: aload 4
    //   202: astore_0
    //   203: goto -158 -> 45
    //   206: iload_2
    //   207: ifeq +60 -> 267
    //   210: new 18	java/lang/String
    //   213: dup
    //   214: invokestatic 453	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   217: aload 4
    //   219: invokevirtual 454	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: invokevirtual 458	com/tencent/smtt/utils/g:c	([B)[B
    //   225: invokespecial 460	java/lang/String:<init>	([B)V
    //   228: astore_1
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   239: aload_1
    //   240: astore 4
    //   242: aload_0
    //   243: ifnull -127 -> 116
    //   246: aload_0
    //   247: invokevirtual 429	java/io/InputStream:close	()V
    //   250: aload_1
    //   251: astore 4
    //   253: goto -137 -> 116
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   261: aload_1
    //   262: astore 4
    //   264: goto -148 -> 116
    //   267: new 18	java/lang/String
    //   270: dup
    //   271: aload 4
    //   273: invokevirtual 454	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   276: aload_1
    //   277: invokestatic 464	com/tencent/smtt/utils/g:b	([BLjava/lang/String;)[B
    //   280: invokespecial 460	java/lang/String:<init>	([B)V
    //   283: astore_1
    //   284: goto -55 -> 229
    //   287: astore 4
    //   289: aload 4
    //   291: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   294: goto -55 -> 239
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   302: goto -202 -> 100
    //   305: astore_0
    //   306: aload_0
    //   307: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   310: aload 5
    //   312: astore 4
    //   314: goto -198 -> 116
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_0
    //   320: aload 7
    //   322: astore 4
    //   324: aload 4
    //   326: ifnull +8 -> 334
    //   329: aload 4
    //   331: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 429	java/io/InputStream:close	()V
    //   342: aload_1
    //   343: athrow
    //   344: astore 4
    //   346: aload 4
    //   348: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   351: goto -17 -> 334
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   359: goto -17 -> 342
    //   362: astore_1
    //   363: aload 7
    //   365: astore 4
    //   367: goto -43 -> 324
    //   370: astore_1
    //   371: goto -47 -> 324
    //   374: astore_1
    //   375: goto -51 -> 324
    //   378: astore_1
    //   379: aload 6
    //   381: astore 4
    //   383: goto -297 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	386	1	paramString	String
    //   0	386	2	paramBoolean	boolean
    //   67	12	3	i	int
    //   14	258	4	localObject1	Object
    //   287	3	4	localIOException1	java.io.IOException
    //   312	18	4	localObject2	Object
    //   344	3	4	localIOException2	java.io.IOException
    //   365	17	4	localObject3	Object
    //   8	303	5	str	String
    //   4	376	6	arrayOfByte	byte[]
    //   1	363	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	61	85	java/lang/Exception
    //   61	68	85	java/lang/Exception
    //   73	82	85	java/lang/Exception
    //   210	229	85	java/lang/Exception
    //   267	284	85	java/lang/Exception
    //   10	21	190	java/lang/Exception
    //   25	45	190	java/lang/Exception
    //   159	187	190	java/lang/Exception
    //   246	250	256	java/io/IOException
    //   234	239	287	java/io/IOException
    //   95	100	297	java/io/IOException
    //   108	112	305	java/io/IOException
    //   10	21	317	finally
    //   25	45	317	finally
    //   159	187	317	finally
    //   329	334	344	java/io/IOException
    //   338	342	354	java/io/IOException
    //   45	54	362	finally
    //   54	61	370	finally
    //   61	68	370	finally
    //   73	82	370	finally
    //   210	229	370	finally
    //   267	284	370	finally
    //   86	90	374	finally
    //   45	54	378	java/lang/Exception
  }
  
  private static void b(Context paramContext, String paramString)
  {
    try
    {
      TbsPVConfig.releaseInstance();
      TbsPVConfig.getInstance(paramContext).clear();
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = paramString.split("\\|");
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          String[] arrayOfString = paramString[i];
          try
          {
            arrayOfString = arrayOfString.split("=");
            if (arrayOfString.length == 2) {
              a(paramContext, arrayOfString[0], arrayOfString[1]);
            }
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      TbsPVConfig.getInstance(paramContext).commit();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
  }
  
  /* Error */
  private static org.json.JSONObject c(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: new 488	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 489	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 491
    //   14: aload_0
    //   15: getfield 260	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   18: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload 6
    //   24: ldc_w 497
    //   27: aload_0
    //   28: getfield 298	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   31: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   34: pop
    //   35: aload 6
    //   37: ldc_w 499
    //   40: aload_0
    //   41: getfield 322	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   44: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload 6
    //   50: ldc_w 501
    //   53: aload_0
    //   54: getfield 329	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   57: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload 6
    //   63: ldc_w 503
    //   66: aload_0
    //   67: getfield 319	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   70: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload 6
    //   76: ldc_w 505
    //   79: aload_0
    //   80: getfield 343	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   83: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 6
    //   89: ldc_w 507
    //   92: aload_0
    //   93: getfield 346	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   96: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload 6
    //   102: ldc_w 509
    //   105: aload_0
    //   106: getfield 352	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   109: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload 6
    //   115: ldc_w 511
    //   118: aload_0
    //   119: getfield 356	MTT/ThirdAppInfoNew:iPv	J
    //   122: invokevirtual 514	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload 6
    //   128: ldc_w 516
    //   131: aload_0
    //   132: getfield 368	MTT/ThirdAppInfoNew:iCoreType	I
    //   135: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 6
    //   141: ldc_w 521
    //   144: aload_0
    //   145: getfield 371	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   148: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 6
    //   154: ldc_w 523
    //   157: aload_0
    //   158: getfield 316	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   161: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload 6
    //   167: ldc_w 525
    //   170: aload_0
    //   171: getfield 308	MTT/ThirdAppInfoNew:sVersionCode	I
    //   174: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 6
    //   180: ldc_w 527
    //   183: aload_0
    //   184: getfield 530	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   187: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: ldc_w 532
    //   194: aload_0
    //   195: getfield 260	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   198: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +28 -> 229
    //   204: ldc 231
    //   206: aload_0
    //   207: getfield 260	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   210: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifne +16 -> 229
    //   216: ldc_w 534
    //   219: aload_0
    //   220: getfield 260	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   223: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: ifeq +262 -> 488
    //   229: new 536	com/tencent/smtt/sdk/TbsDownloadUpload
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 538	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   237: astore 7
    //   239: aload 7
    //   241: aload_1
    //   242: invokevirtual 541	com/tencent/smtt/sdk/TbsDownloadUpload:readTbsDownloadInfo	(Landroid/content/Context;)V
    //   245: aload 7
    //   247: invokevirtual 544	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadCode	()I
    //   250: istore_2
    //   251: aload 7
    //   253: invokevirtual 547	com/tencent/smtt/sdk/TbsDownloadUpload:getStartDownloadCode	()I
    //   256: istore_3
    //   257: aload 7
    //   259: invokevirtual 550	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadReturn	()I
    //   262: istore 4
    //   264: aload 7
    //   266: invokevirtual 553	com/tencent/smtt/sdk/TbsDownloadUpload:getLocalCoreVersion	()I
    //   269: istore 5
    //   271: aload 6
    //   273: ldc_w 555
    //   276: new 71	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   283: ldc 73
    //   285: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload_2
    //   289: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc 88
    //   294: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: iload_3
    //   298: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: ldc 88
    //   303: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 4
    //   308: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: ldc 88
    //   313: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: iload 5
    //   318: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   327: pop
    //   328: aload 6
    //   330: ldc_w 557
    //   333: iconst_3
    //   334: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   337: pop
    //   338: aload 6
    //   340: ldc_w 559
    //   343: aload_0
    //   344: getfield 349	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   347: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   350: pop
    //   351: aload_1
    //   352: invokestatic 362	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   355: ifeq +182 -> 537
    //   358: aload 6
    //   360: ldc_w 561
    //   363: aload_1
    //   364: invokestatic 565	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   367: invokevirtual 514	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   370: pop
    //   371: aload 6
    //   373: ldc_w 567
    //   376: aload_0
    //   377: getfield 379	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   380: invokevirtual 514	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   383: pop
    //   384: aload 6
    //   386: ldc_w 569
    //   389: aload_0
    //   390: getfield 385	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   393: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   396: pop
    //   397: getstatic 574	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   400: istore_2
    //   401: aload_0
    //   402: getfield 385	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   405: ifgt +161 -> 566
    //   408: aload 6
    //   410: ldc_w 576
    //   413: aload_1
    //   414: invokestatic 581	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   417: invokevirtual 584	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   420: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   423: pop
    //   424: iload_2
    //   425: iconst_m1
    //   426: if_icmpne +11 -> 437
    //   429: ldc 223
    //   431: ldc_w 586
    //   434: invokestatic 589	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload_1
    //   438: invokestatic 581	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   441: aload_1
    //   442: invokevirtual 592	com/tencent/smtt/sdk/TbsDownloadConfig:uploadDownloadInterruptCodeIfNeeded	(Landroid/content/Context;)V
    //   445: invokestatic 595	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   448: ifnull +37 -> 485
    //   451: aload_0
    //   452: getfield 260	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   455: ldc 231
    //   457: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   460: ifeq +119 -> 579
    //   463: aload 6
    //   465: ldc_w 597
    //   468: invokestatic 595	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   471: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   474: pop
    //   475: aload 6
    //   477: ldc_w 599
    //   480: iconst_0
    //   481: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   484: pop
    //   485: aload 6
    //   487: areturn
    //   488: aload_0
    //   489: getfield 376	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   492: ifnonnull +29 -> 521
    //   495: aload 6
    //   497: ldc_w 555
    //   500: ldc_w 601
    //   503: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: goto -179 -> 328
    //   510: astore_0
    //   511: ldc 223
    //   513: ldc_w 603
    //   516: invokestatic 589	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: aconst_null
    //   520: areturn
    //   521: aload 6
    //   523: ldc_w 555
    //   526: aload_0
    //   527: getfield 376	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   530: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   533: pop
    //   534: goto -206 -> 328
    //   537: aload 6
    //   539: ldc_w 561
    //   542: aload_1
    //   543: invokestatic 608	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   546: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   549: pop
    //   550: aload 6
    //   552: ldc_w 610
    //   555: aload_1
    //   556: invokestatic 608	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   559: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   562: pop
    //   563: goto -192 -> 371
    //   566: aload 6
    //   568: ldc_w 576
    //   571: iload_2
    //   572: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   575: pop
    //   576: goto -152 -> 424
    //   579: aload_0
    //   580: getfield 260	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   583: ldc_w 532
    //   586: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   589: ifeq -104 -> 485
    //   592: aload 6
    //   594: ldc_w 597
    //   597: invokestatic 595	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   600: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   603: pop
    //   604: aload 6
    //   606: ldc_w 599
    //   609: iconst_0
    //   610: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   613: pop
    //   614: aload 6
    //   616: areturn
    //   617: astore_0
    //   618: aload 6
    //   620: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	621	1	paramContext	Context
    //   250	322	2	i	int
    //   256	42	3	j	int
    //   262	45	4	k	int
    //   269	48	5	m	int
    //   7	612	6	localJSONObject	org.json.JSONObject
    //   237	28	7	localTbsDownloadUpload	com.tencent.smtt.sdk.TbsDownloadUpload
    // Exception table:
    //   from	to	target	type
    //   0	229	510	java/lang/Exception
    //   229	328	510	java/lang/Exception
    //   328	371	510	java/lang/Exception
    //   371	424	510	java/lang/Exception
    //   429	437	510	java/lang/Exception
    //   437	445	510	java/lang/Exception
    //   488	507	510	java/lang/Exception
    //   521	534	510	java/lang/Exception
    //   537	563	510	java/lang/Exception
    //   566	576	510	java/lang/Exception
    //   445	485	617	java/lang/Exception
    //   579	614	617	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.b
 * JD-Core Version:    0.7.0.1
 */