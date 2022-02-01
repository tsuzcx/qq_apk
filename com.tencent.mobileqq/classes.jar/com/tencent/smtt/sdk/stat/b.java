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
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class b
{
  public static byte[] a;
  
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
    try
    {
      localJSONObject = new JSONObject();
    }
    catch (Throwable paramContext)
    {
      label96:
      label98:
      break label96;
    }
    try
    {
      if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (q.b(paramContext)))
      {
        localJSONObject.put("stableCore32", TbsShareManager.getTbsStableCoreVersion(paramContext, 32));
        localJSONObject.put("stableCore64", TbsShareManager.getTbsStableCoreVersion(paramContext, 64));
      }
      if ((TbsShareManager.isThirdPartyApp(paramContext)) && (q.c(paramContext)))
      {
        paramContext = q.b().replace(",", "-");
        if (!TextUtils.isEmpty(paramContext)) {
          localJSONObject.put("coreUpdate", paramContext);
        }
      }
      q.c();
      paramContext = localJSONObject;
    }
    catch (Throwable paramContext)
    {
      paramContext = localJSONObject;
      break label98;
    }
    paramContext = null;
    if (paramContext == null) {
      return "";
    }
    return paramContext.toString();
  }
  
  public static void a(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    new b.1("HttpUtils", paramContext, paramThirdAppInfoNew).start();
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (("reset".equals(paramString1)) && ("true".equals(paramString2)))
    {
      QbSdk.reset(paramContext);
      return;
    }
    if (paramString1.startsWith("rmfile")) {
      try
      {
        paramContext = paramContext.getSharedPreferences("tbs_status", 0);
        if (paramContext.getBoolean(paramString1, false)) {
          return;
        }
        File localFile = new File(paramString2);
        if ((paramString2 != null) && (localFile.exists()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("received command,delete");
          localStringBuilder.append(paramString2);
          TbsLog.i("HttpUtils", localStringBuilder.toString());
          FileUtil.b(localFile);
        }
        paramContext.edit().putBoolean(paramString1, true).apply();
        return;
      }
      catch (Exception paramContext)
      {
        TbsLog.i(paramContext);
        return;
      }
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if ((QbSdk.getSettings() != null) && (QbSdk.getSettings().containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (QbSdk.getSettings().get("SET_SENDREQUEST_AND_UPLOAD").equals("false")))
    {
      TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    Object localObject1;
    try
    {
      localObject1 = paramContext.getApplicationInfo();
      if ("com.tencent.mobileqq".equals(((ApplicationInfo)localObject1).packageName))
      {
        Object localObject2 = paramContext.getPackageManager().getPackageInfo(((ApplicationInfo)localObject1).packageName, 0).versionName;
        localObject1 = localObject2;
        try
        {
          if (TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
            break label170;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(".");
          ((StringBuilder)localObject1).append(QbSdk.getQQBuildNumber());
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        catch (Exception localException2)
        {
          localObject1 = localObject2;
          localObject2 = localException2;
          break label165;
        }
      }
      else
      {
        localObject1 = "";
      }
    }
    catch (Exception localException1)
    {
      localObject1 = "";
      label165:
      TbsLog.i(localException1);
    }
    for (;;)
    {
      try
      {
        label170:
        ThirdAppInfoNew localThirdAppInfoNew = new ThirdAppInfoNew();
        localThirdAppInfoNew.sAppName = paramContext.getApplicationContext().getApplicationInfo().packageName;
        n.a(paramContext);
        Object localObject3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+08"));
        localThirdAppInfoNew.sTime = ((SimpleDateFormat)localObject3).format(Calendar.getInstance().getTime());
        localThirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.e(paramContext);
        localObject3 = com.tencent.smtt.utils.b.a(paramContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localThirdAppInfoNew.sMetaData = ((String)localObject3);
        }
        localThirdAppInfoNew.sGuid = paramString1;
        if (paramBoolean1)
        {
          localThirdAppInfoNew.sQua2 = paramString2;
          localThirdAppInfoNew.bIsSandboxMode = paramBoolean2;
        }
        else
        {
          localThirdAppInfoNew.sQua2 = k.a(paramContext);
        }
        localThirdAppInfoNew.sLc = paramString3;
        paramString1 = com.tencent.smtt.utils.b.j(paramContext);
        paramString2 = com.tencent.smtt.utils.b.h(paramContext);
        paramString3 = new StringBuilder();
        paramString3.append("HttpUtils.doReport(): getImeiEnable = ");
        paramString3.append(com.tencent.smtt.utils.b.g(paramContext));
        paramString3.append(" imei is ");
        paramString3.append(paramString2);
        TbsLog.i("sdkreport", paramString3.toString());
        paramString3 = com.tencent.smtt.utils.b.i(paramContext);
        localObject3 = com.tencent.smtt.utils.b.k(paramContext);
        if ((paramString2 != null) && (!"".equals(paramString2))) {
          localThirdAppInfoNew.sImei = paramString2;
        }
        if ((paramString3 != null) && (!"".equals(paramString3))) {
          localThirdAppInfoNew.sImsi = paramString3;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localThirdAppInfoNew.sAndroidID = ((String)localObject3);
        }
        if ((paramString1 != null) && (!"".equals(paramString1))) {
          localThirdAppInfoNew.sMac = paramString1;
        }
        localThirdAppInfoNew.iPv = paramInt;
        boolean bool = TbsShareManager.isThirdPartyApp(paramContext);
        paramInt = 1;
        if (!bool) {
          break label604;
        }
        if (paramBoolean1)
        {
          if (TbsShareManager.getCoreFormOwn())
          {
            localThirdAppInfoNew.iCoreType = 2;
            break label596;
          }
          localThirdAppInfoNew.iCoreType = 1;
          break label596;
          localThirdAppInfoNew.iCoreType = 3;
        }
        else
        {
          localThirdAppInfoNew.iCoreType = 0;
          continue;
          localThirdAppInfoNew.iCoreType = paramInt;
          if ((paramBoolean1) && (paramBoolean2)) {
            continue;
          }
        }
        localThirdAppInfoNew.sAppVersionName = ((String)localObject1);
        localThirdAppInfoNew.sAppSignature = b(paramContext);
        if (!paramBoolean1)
        {
          localThirdAppInfoNew.sWifiConnectedTime = paramLong;
          localThirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(paramContext);
        }
        a(localThirdAppInfoNew, paramContext.getApplicationContext());
        return;
      }
      catch (Throwable paramContext)
      {
        TbsLog.i(paramContext);
        return;
      }
      label596:
      if (paramBoolean2)
      {
        continue;
        label604:
        if (!paramBoolean1) {
          paramInt = 0;
        }
      }
    }
  }
  
  private static String b(Context paramContext)
  {
    for (;;)
    {
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
              if (paramContext.length > 0) {
                break label143;
              }
              return null;
              if (i < paramContext.length)
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
                continue;
              }
              paramContext = ((StringBuilder)localObject).toString();
              return paramContext;
            }
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.i(paramContext);
      }
      return null;
      label143:
      int i = 0;
    }
  }
  
  /* Error */
  private static String b(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: invokevirtual 448	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 451	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnull +26 -> 47
    //   24: aload_0
    //   25: ldc_w 453
    //   28: invokevirtual 456	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   31: ifeq +16 -> 47
    //   34: new 458	java/util/zip/GZIPInputStream
    //   37: dup
    //   38: aload 6
    //   40: invokespecial 461	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: goto +41 -> 85
    //   47: aload_0
    //   48: ifnull +34 -> 82
    //   51: aload_0
    //   52: ldc_w 463
    //   55: invokevirtual 456	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   58: ifeq +24 -> 82
    //   61: new 465	java/util/zip/InflaterInputStream
    //   64: dup
    //   65: aload 6
    //   67: new 467	java/util/zip/Inflater
    //   70: dup
    //   71: iconst_1
    //   72: invokespecial 470	java/util/zip/Inflater:<init>	(Z)V
    //   75: invokespecial 473	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   78: astore_0
    //   79: goto +6 -> 85
    //   82: aload 6
    //   84: astore_0
    //   85: aload 5
    //   87: astore 4
    //   89: aload_0
    //   90: astore 5
    //   92: new 475	java/io/ByteArrayOutputStream
    //   95: dup
    //   96: invokespecial 476	java/io/ByteArrayOutputStream:<init>	()V
    //   99: astore 6
    //   101: sipush 128
    //   104: newarray byte
    //   106: astore 4
    //   108: aload_0
    //   109: aload 4
    //   111: invokevirtual 482	java/io/InputStream:read	([B)I
    //   114: istore_3
    //   115: iload_3
    //   116: iconst_m1
    //   117: if_icmpeq +15 -> 132
    //   120: aload 6
    //   122: aload 4
    //   124: iconst_0
    //   125: iload_3
    //   126: invokevirtual 486	java/io/ByteArrayOutputStream:write	([BII)V
    //   129: goto -21 -> 108
    //   132: iload_2
    //   133: ifeq +25 -> 158
    //   136: new 16	java/lang/String
    //   139: dup
    //   140: invokestatic 491	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   143: aload 6
    //   145: invokevirtual 492	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   148: invokevirtual 495	com/tencent/smtt/utils/g:c	([B)[B
    //   151: invokespecial 497	java/lang/String:<init>	([B)V
    //   154: astore_1
    //   155: goto +20 -> 175
    //   158: new 16	java/lang/String
    //   161: dup
    //   162: aload 6
    //   164: invokevirtual 492	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   167: aload_1
    //   168: invokestatic 500	com/tencent/smtt/utils/g:b	([BLjava/lang/String;)[B
    //   171: invokespecial 497	java/lang/String:<init>	([B)V
    //   174: astore_1
    //   175: aload 6
    //   177: invokevirtual 503	java/io/ByteArrayOutputStream:close	()V
    //   180: goto +10 -> 190
    //   183: astore 4
    //   185: aload 4
    //   187: invokestatic 185	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   190: aload_1
    //   191: astore 4
    //   193: aload_0
    //   194: ifnull +112 -> 306
    //   197: aload_0
    //   198: invokevirtual 504	java/io/InputStream:close	()V
    //   201: aload_1
    //   202: astore 4
    //   204: goto +102 -> 306
    //   207: astore_0
    //   208: aload_0
    //   209: invokestatic 185	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   212: aload_1
    //   213: astore 4
    //   215: goto +91 -> 306
    //   218: astore_1
    //   219: aload 6
    //   221: astore 4
    //   223: goto +136 -> 359
    //   226: astore 4
    //   228: aload 6
    //   230: astore_1
    //   231: aload 4
    //   233: astore 6
    //   235: goto +24 -> 259
    //   238: astore 6
    //   240: aload 7
    //   242: astore_1
    //   243: goto +16 -> 259
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_0
    //   249: goto +110 -> 359
    //   252: astore 6
    //   254: aconst_null
    //   255: astore_0
    //   256: aload 7
    //   258: astore_1
    //   259: aload_1
    //   260: astore 4
    //   262: aload_0
    //   263: astore 5
    //   265: aload 6
    //   267: invokestatic 185	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   270: aload_1
    //   271: ifnull +15 -> 286
    //   274: aload_1
    //   275: invokevirtual 503	java/io/ByteArrayOutputStream:close	()V
    //   278: goto +8 -> 286
    //   281: astore_1
    //   282: aload_1
    //   283: invokestatic 185	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   286: aload_0
    //   287: ifnull +15 -> 302
    //   290: aload_0
    //   291: invokevirtual 504	java/io/InputStream:close	()V
    //   294: goto +8 -> 302
    //   297: astore_0
    //   298: aload_0
    //   299: invokestatic 185	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   302: ldc 83
    //   304: astore 4
    //   306: new 150	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   313: astore_0
    //   314: aload_0
    //   315: ldc_w 506
    //   318: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_0
    //   323: aload 4
    //   325: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_0
    //   330: ldc_w 508
    //   333: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_0
    //   338: iload_2
    //   339: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: ldc 94
    //   345: aload_0
    //   346: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 164	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload 4
    //   354: areturn
    //   355: astore_1
    //   356: aload 5
    //   358: astore_0
    //   359: aload 4
    //   361: ifnull +18 -> 379
    //   364: aload 4
    //   366: invokevirtual 503	java/io/ByteArrayOutputStream:close	()V
    //   369: goto +10 -> 379
    //   372: astore 4
    //   374: aload 4
    //   376: invokestatic 185	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   379: aload_0
    //   380: ifnull +15 -> 395
    //   383: aload_0
    //   384: invokevirtual 504	java/io/InputStream:close	()V
    //   387: goto +8 -> 395
    //   390: astore_0
    //   391: aload_0
    //   392: invokestatic 185	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   395: goto +5 -> 400
    //   398: aload_1
    //   399: athrow
    //   400: goto -2 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	403	1	paramString	String
    //   0	403	2	paramBoolean	boolean
    //   114	12	3	i	int
    //   4	119	4	localObject1	Object
    //   183	3	4	localIOException1	java.io.IOException
    //   191	31	4	localObject2	Object
    //   226	6	4	localException1	Exception
    //   260	105	4	str	String
    //   372	3	4	localIOException2	java.io.IOException
    //   1	356	5	localHttpURLConnection	java.net.HttpURLConnection
    //   13	221	6	localObject3	Object
    //   238	1	6	localException2	Exception
    //   252	14	6	localException3	Exception
    //   7	250	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   175	180	183	java/io/IOException
    //   197	201	207	java/io/IOException
    //   101	108	218	finally
    //   108	115	218	finally
    //   120	129	218	finally
    //   136	155	218	finally
    //   158	175	218	finally
    //   101	108	226	java/lang/Exception
    //   108	115	226	java/lang/Exception
    //   120	129	226	java/lang/Exception
    //   136	155	226	java/lang/Exception
    //   158	175	226	java/lang/Exception
    //   92	101	238	java/lang/Exception
    //   9	20	246	finally
    //   24	44	246	finally
    //   51	79	246	finally
    //   9	20	252	java/lang/Exception
    //   24	44	252	java/lang/Exception
    //   51	79	252	java/lang/Exception
    //   274	278	281	java/io/IOException
    //   290	294	297	java/io/IOException
    //   92	101	355	finally
    //   265	270	355	finally
    //   364	369	372	java/io/IOException
    //   383	387	390	java/io/IOException
  }
  
  private static void b(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        TbsPVConfig.releaseInstance();
        TbsPVConfig.getInstance(paramContext).clear();
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        paramString = paramString.split("\\|");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString = paramString[i];
          try
          {
            arrayOfString = arrayOfString.split("=");
            if (arrayOfString.length != 2) {
              break label97;
            }
            a(paramContext, arrayOfString[0], arrayOfString[1]);
          }
          catch (Exception localException)
          {
            TbsLog.i(localException);
          }
        }
        else
        {
          TbsPVConfig.getInstance(paramContext).commit();
          return;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.i(paramContext);
        return;
      }
      label97:
      i += 1;
    }
  }
  
  private static JSONObject c(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("APPNAME", paramThirdAppInfoNew.sAppName);
      localJSONObject.put("TIME", paramThirdAppInfoNew.sTime);
      localJSONObject.put("QUA2", paramThirdAppInfoNew.sQua2);
      localJSONObject.put("LC", paramThirdAppInfoNew.sLc);
      localJSONObject.put("GUID", paramThirdAppInfoNew.sGuid);
      localJSONObject.put("IMEI", paramThirdAppInfoNew.sImei);
      localJSONObject.put("IMSI", paramThirdAppInfoNew.sImsi);
      localJSONObject.put("MAC", paramThirdAppInfoNew.sMac);
      localJSONObject.put("PV", paramThirdAppInfoNew.iPv);
      localJSONObject.put("CORETYPE", paramThirdAppInfoNew.iCoreType);
      localJSONObject.put("APPVN", paramThirdAppInfoNew.sAppVersionName);
      localJSONObject.put("APPMETADATA", paramThirdAppInfoNew.sMetaData);
      localJSONObject.put("VERSION_CODE", paramThirdAppInfoNew.sVersionCode);
      localJSONObject.put("CPU", paramThirdAppInfoNew.sCpu);
      bool = "com.tencent.mm".equals(paramThirdAppInfoNew.sAppName);
      if ((!bool) && (!"com.tencent.mobileqq".equals(paramThirdAppInfoNew.sAppName)) && (!"com.tencent.tbs".equals(paramThirdAppInfoNew.sAppName))) {
        if (paramThirdAppInfoNew.sAppSignature == null) {
          localObject = "0";
        }
      }
      for (;;)
      {
        localJSONObject.put("SIGNATURE", localObject);
        break;
        localObject = paramThirdAppInfoNew.sAppSignature;
        continue;
        localObject = new TbsDownloadUpload(paramContext);
        ((TbsDownloadUpload)localObject).readTbsDownloadInfo(paramContext);
        i = ((TbsDownloadUpload)localObject).getNeedDownloadCode();
        j = ((TbsDownloadUpload)localObject).getStartDownloadCode();
        int k = ((TbsDownloadUpload)localObject).getNeedDownloadReturn();
        int m = ((TbsDownloadUpload)localObject).getLocalCoreVersion();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(m);
        localObject = ((StringBuilder)localObject).toString();
      }
      Object localObject = a(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addInfo is ");
      localStringBuilder.append((String)localObject);
      TbsLog.i("sdkreport", localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("EXT_INFO", localObject);
      }
      localJSONObject.put("PROTOCOL_VERSION", 3);
      localJSONObject.put("ANDROID_ID", paramThirdAppInfoNew.sAndroidID);
      bool = TbsShareManager.isThirdPartyApp(paramContext);
      if (bool)
      {
        if (!"com.xunmeng.pinduoduo".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)) {
          localJSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(paramContext));
        }
      }
      else
      {
        localJSONObject.put("HOST_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(paramContext));
        localJSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(paramContext));
      }
      localJSONObject.put("WIFICONNECTEDTIME", paramThirdAppInfoNew.sWifiConnectedTime);
      localJSONObject.put("CORE_EXIST", paramThirdAppInfoNew.localCoreVersion);
      int i = TbsCoreLoadStat.mLoadErrorCode;
      int j = paramThirdAppInfoNew.localCoreVersion;
      if (j <= 0) {
        localJSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(paramContext).getDownloadInterruptCode());
      } else {
        localJSONObject.put("TBS_ERROR_CODE", i);
      }
      if (i == -1) {
        TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
      }
      TbsDownloadConfig.getInstance(paramContext).uploadDownloadInterruptCodeIfNeeded(paramContext);
    }
    catch (Exception paramThirdAppInfoNew)
    {
      boolean bool;
      label714:
      break label714;
    }
    try
    {
      if (QbSdk.getTID() != null)
      {
        bool = paramThirdAppInfoNew.sAppName.equals("com.tencent.mobileqq");
        if (bool) {}
        for (paramThirdAppInfoNew = QbSdk.getTID();; paramThirdAppInfoNew = QbSdk.getTID())
        {
          localJSONObject.put("TID", paramThirdAppInfoNew);
          localJSONObject.put("TIDTYPE", 0);
          return localJSONObject;
          if (!paramThirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
            break;
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramThirdAppInfoNew) {}
    TbsLog.e("sdkreport", "getPostData exception!");
    return null;
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.b
 * JD-Core Version:    0.7.0.1
 */