package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.SysCoreQUA2Utils;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;

public class HttpUtils
{
  public static final String DEFAULT_ENCODE_NAME = "utf-8";
  private static final int DEFAULT_TIME_OUT = 20000;
  private static final String DemoPackageName = "com.tencent.tbs";
  private static final String LOGTAG = "HttpUtils";
  public static byte[] POST_DATA_KEY = null;
  private static final int PROTOCOL_VERSION = 3;
  private static final int TIDTYPE_MM = 0;
  private static final int TIDTYPE_QQ = 1;
  private static final String mmPackageName = "com.tencent.mm";
  private static final String qqPackageName = "com.tencent.mobileqq";
  
  static
  {
    try
    {
      POST_DATA_KEY = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  public static void doReport(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
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
        ((ThirdAppInfoNew)localObject2).sQua2 = SysCoreQUA2Utils.getQUA2_V3(paramContext);
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
        TbsCommonConfig.getInstance(paramContext);
        localObject3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+08"));
        ((ThirdAppInfoNew)localObject2).sTime = ((SimpleDateFormat)localObject3).format(Calendar.getInstance().getTime());
        ((ThirdAppInfoNew)localObject2).sVersionCode = AppUtil.getAppVersionCode(paramContext);
        localObject3 = AppUtil.getAppMetadata(paramContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((ThirdAppInfoNew)localObject2).sMetaData = ((String)localObject3);
        }
        ((ThirdAppInfoNew)localObject2).sGuid = paramString1;
        if (paramBoolean1)
        {
          ((ThirdAppInfoNew)localObject2).sQua2 = paramString2;
          ((ThirdAppInfoNew)localObject2).bIsSandboxMode = paramBoolean2;
          ((ThirdAppInfoNew)localObject2).sLc = paramString3;
          paramString1 = AppUtil.getMacAddress(paramContext);
          paramString2 = AppUtil.getImei(paramContext);
          paramString3 = AppUtil.getImsi(paramContext);
          localObject3 = AppUtil.getAndroidID(paramContext);
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
            break label546;
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
          ((ThirdAppInfoNew)localObject2).sAppSignature = getSHA1(paramContext);
          if (!paramBoolean1)
          {
            ((ThirdAppInfoNew)localObject2).sWifiConnectedTime = paramLong;
            ((ThirdAppInfoNew)localObject2).localCoreVersion = QbSdk.getTbsVersion(paramContext);
          }
          post((ThirdAppInfoNew)localObject2, paramContext.getApplicationContext());
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
      label546:
      do
      {
        paramInt = 0;
        break;
      } while (!paramBoolean1);
      paramInt = 1;
    }
  }
  
  /* Error */
  private static org.json.JSONObject getPostData(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: new 312	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 313	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 315
    //   14: aload_0
    //   15: getfield 165	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   18: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload 6
    //   24: ldc_w 321
    //   27: aload_0
    //   28: getfield 206	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   31: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   34: pop
    //   35: aload 6
    //   37: ldc_w 323
    //   40: aload_0
    //   41: getfield 230	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   44: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload 6
    //   50: ldc_w 325
    //   53: aload_0
    //   54: getfield 237	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   57: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload 6
    //   63: ldc_w 327
    //   66: aload_0
    //   67: getfield 227	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   70: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload 6
    //   76: ldc_w 329
    //   79: aload_0
    //   80: getfield 253	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   83: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 6
    //   89: ldc_w 331
    //   92: aload_0
    //   93: getfield 256	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   96: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload 6
    //   102: ldc_w 333
    //   105: aload_0
    //   106: getfield 262	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   109: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload 6
    //   115: ldc_w 335
    //   118: aload_0
    //   119: getfield 266	MTT/ThirdAppInfoNew:iPv	J
    //   122: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload 6
    //   128: ldc_w 340
    //   131: aload_0
    //   132: getfield 279	MTT/ThirdAppInfoNew:iCoreType	I
    //   135: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 6
    //   141: ldc_w 345
    //   144: aload_0
    //   145: getfield 282	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   148: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 6
    //   154: ldc_w 347
    //   157: aload_0
    //   158: getfield 224	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   161: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload 6
    //   167: ldc_w 349
    //   170: aload_0
    //   171: getfield 215	MTT/ThirdAppInfoNew:sVersionCode	I
    //   174: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 6
    //   180: ldc_w 351
    //   183: aload_0
    //   184: getfield 354	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   187: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: ldc 28
    //   193: aload_0
    //   194: getfield 165	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   197: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifne +27 -> 227
    //   203: ldc 31
    //   205: aload_0
    //   206: getfield 165	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   209: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   212: ifne +15 -> 227
    //   215: ldc 14
    //   217: aload_0
    //   218: getfield 165	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   221: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +278 -> 502
    //   227: new 356	com/tencent/smtt/sdk/TbsDownloadUpload
    //   230: dup
    //   231: aload_1
    //   232: invokespecial 359	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   235: astore 7
    //   237: aload 7
    //   239: aload_1
    //   240: invokevirtual 362	com/tencent/smtt/sdk/TbsDownloadUpload:readTbsDownloadInfo	(Landroid/content/Context;)V
    //   243: aload 7
    //   245: invokevirtual 366	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadCode	()I
    //   248: istore_2
    //   249: aload 7
    //   251: invokevirtual 369	com/tencent/smtt/sdk/TbsDownloadUpload:getStartDownloadCode	()I
    //   254: istore_3
    //   255: aload 7
    //   257: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadReturn	()I
    //   260: istore 4
    //   262: aload 7
    //   264: invokevirtual 375	com/tencent/smtt/sdk/TbsDownloadUpload:getLocalCoreVersion	()I
    //   267: istore 5
    //   269: aload 6
    //   271: ldc_w 377
    //   274: new 145	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   281: ldc 106
    //   283: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_2
    //   287: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc_w 382
    //   293: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: iload_3
    //   297: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 382
    //   303: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 4
    //   308: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: ldc_w 382
    //   314: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload 5
    //   319: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload 6
    //   331: ldc_w 383
    //   334: iconst_3
    //   335: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   338: pop
    //   339: aload 6
    //   341: ldc_w 385
    //   344: aload_0
    //   345: getfield 259	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   348: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_1
    //   353: invokestatic 272	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   356: ifeq +195 -> 551
    //   359: aload 6
    //   361: ldc_w 387
    //   364: aload_1
    //   365: invokestatic 391	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   368: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   371: pop
    //   372: aload_0
    //   373: getfield 279	MTT/ThirdAppInfoNew:iCoreType	I
    //   376: ifne +69 -> 445
    //   379: aload 6
    //   381: ldc_w 393
    //   384: aload_0
    //   385: getfield 291	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   388: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload 6
    //   394: ldc_w 395
    //   397: aload_0
    //   398: getfield 297	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   401: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   404: pop
    //   405: getstatic 400	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   408: istore_2
    //   409: aload_0
    //   410: getfield 297	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   413: ifgt +167 -> 580
    //   416: aload 6
    //   418: ldc_w 402
    //   421: aload_1
    //   422: invokestatic 407	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   425: invokevirtual 410	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   428: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   431: pop
    //   432: iload_2
    //   433: iconst_m1
    //   434: if_icmpne +11 -> 445
    //   437: ldc 96
    //   439: ldc_w 412
    //   442: invokestatic 415	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload_1
    //   446: invokestatic 407	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   449: aload_1
    //   450: invokevirtual 418	com/tencent/smtt/sdk/TbsDownloadConfig:uploadDownloadInterruptCodeIfNeeded	(Landroid/content/Context;)V
    //   453: invokestatic 421	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   456: ifnull +43 -> 499
    //   459: aload_0
    //   460: getfield 165	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   463: ldc 31
    //   465: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +125 -> 593
    //   471: aload 6
    //   473: ldc_w 423
    //   476: invokestatic 428	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   479: invokestatic 421	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   482: invokevirtual 432	com/tencent/smtt/utils/PostEncryption:RSAEncode	(Ljava/lang/String;)Ljava/lang/String;
    //   485: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   488: pop
    //   489: aload 6
    //   491: ldc_w 434
    //   494: iconst_1
    //   495: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   498: pop
    //   499: aload 6
    //   501: areturn
    //   502: aload_0
    //   503: getfield 288	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   506: ifnonnull +29 -> 535
    //   509: aload 6
    //   511: ldc_w 377
    //   514: ldc_w 436
    //   517: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   520: pop
    //   521: goto -192 -> 329
    //   524: astore_0
    //   525: ldc 96
    //   527: ldc_w 438
    //   530: invokestatic 415	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aconst_null
    //   534: areturn
    //   535: aload 6
    //   537: ldc_w 377
    //   540: aload_0
    //   541: getfield 288	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   544: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   547: pop
    //   548: goto -219 -> 329
    //   551: aload 6
    //   553: ldc_w 387
    //   556: aload_1
    //   557: invokestatic 443	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   560: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   563: pop
    //   564: aload 6
    //   566: ldc_w 445
    //   569: aload_1
    //   570: invokestatic 443	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   573: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   576: pop
    //   577: goto -205 -> 372
    //   580: aload 6
    //   582: ldc_w 402
    //   585: iload_2
    //   586: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   589: pop
    //   590: goto -158 -> 432
    //   593: aload_0
    //   594: getfield 165	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   597: ldc 28
    //   599: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   602: ifeq -103 -> 499
    //   605: aload 6
    //   607: ldc_w 423
    //   610: invokestatic 421	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   613: invokevirtual 319	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   616: pop
    //   617: aload 6
    //   619: ldc_w 434
    //   622: iconst_0
    //   623: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   626: pop
    //   627: aload 6
    //   629: areturn
    //   630: astore_0
    //   631: aload 6
    //   633: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	634	1	paramContext	Context
    //   248	338	2	i	int
    //   254	43	3	j	int
    //   260	47	4	k	int
    //   267	51	5	m	int
    //   7	625	6	localJSONObject	org.json.JSONObject
    //   235	28	7	localTbsDownloadUpload	com.tencent.smtt.sdk.TbsDownloadUpload
    // Exception table:
    //   from	to	target	type
    //   0	227	524	java/lang/Exception
    //   227	329	524	java/lang/Exception
    //   329	372	524	java/lang/Exception
    //   372	432	524	java/lang/Exception
    //   437	445	524	java/lang/Exception
    //   445	453	524	java/lang/Exception
    //   502	521	524	java/lang/Exception
    //   535	548	524	java/lang/Exception
    //   551	577	524	java/lang/Exception
    //   580	590	524	java/lang/Exception
    //   453	499	630	java/lang/Exception
    //   593	627	630	java/lang/Exception
  }
  
  /* Error */
  private static String getResponseFromConnection(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 106
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 453	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 456	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +133 -> 155
    //   25: aload_0
    //   26: ldc_w 458
    //   29: invokevirtual 462	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifeq +123 -> 155
    //   35: new 464	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 467	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: new 469	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 470	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 4
    //   54: sipush 128
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 476	java/io/InputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +136 -> 206
    //   73: aload 4
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 480	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -21 -> 61
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   100: aload 5
    //   102: astore 4
    //   104: aload_0
    //   105: ifnull +11 -> 116
    //   108: aload_0
    //   109: invokevirtual 484	java/io/InputStream:close	()V
    //   112: aload 5
    //   114: astore 4
    //   116: ldc 17
    //   118: new 145	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 486
    //   128: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 4
    //   133: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 488
    //   139: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_2
    //   143: invokevirtual 491	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 104	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 4
    //   154: areturn
    //   155: aload_0
    //   156: ifnull +44 -> 200
    //   159: aload_0
    //   160: ldc_w 493
    //   163: invokevirtual 462	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   166: ifeq +34 -> 200
    //   169: new 495	java/util/zip/InflaterInputStream
    //   172: dup
    //   173: aload 4
    //   175: new 497	java/util/zip/Inflater
    //   178: dup
    //   179: iconst_1
    //   180: invokespecial 500	java/util/zip/Inflater:<init>	(Z)V
    //   183: invokespecial 503	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
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
    //   210: new 41	java/lang/String
    //   213: dup
    //   214: invokestatic 508	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   217: aload 4
    //   219: invokevirtual 512	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: invokevirtual 516	com/tencent/smtt/utils/Post3DESEncryption:DesDecrypt	([B)[B
    //   225: invokespecial 519	java/lang/String:<init>	([B)V
    //   228: astore_1
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   239: aload_1
    //   240: astore 4
    //   242: aload_0
    //   243: ifnull -127 -> 116
    //   246: aload_0
    //   247: invokevirtual 484	java/io/InputStream:close	()V
    //   250: aload_1
    //   251: astore 4
    //   253: goto -137 -> 116
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 520	java/io/IOException:printStackTrace	()V
    //   261: aload_1
    //   262: astore 4
    //   264: goto -148 -> 116
    //   267: new 41	java/lang/String
    //   270: dup
    //   271: aload 4
    //   273: invokevirtual 512	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   276: aload_1
    //   277: invokestatic 524	com/tencent/smtt/utils/Post3DESEncryption:DESDecrypt	([BLjava/lang/String;)[B
    //   280: invokespecial 519	java/lang/String:<init>	([B)V
    //   283: astore_1
    //   284: goto -55 -> 229
    //   287: astore 4
    //   289: aload 4
    //   291: invokevirtual 520	java/io/IOException:printStackTrace	()V
    //   294: goto -55 -> 239
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 520	java/io/IOException:printStackTrace	()V
    //   302: goto -202 -> 100
    //   305: astore_0
    //   306: aload_0
    //   307: invokevirtual 520	java/io/IOException:printStackTrace	()V
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
    //   331: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 484	java/io/InputStream:close	()V
    //   342: aload_1
    //   343: athrow
    //   344: astore 4
    //   346: aload 4
    //   348: invokevirtual 520	java/io/IOException:printStackTrace	()V
    //   351: goto -17 -> 334
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 520	java/io/IOException:printStackTrace	()V
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
  
  private static String getSHA1(Context paramContext)
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
  
  public static void post(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    new HttpUtils.1("HttpUtils", paramContext, paramThirdAppInfoNew).start();
  }
  
  private static void processSwitchKeyValue(Context paramContext, String paramString1, String paramString2)
  {
    if (("reset".equals(paramString1)) && ("true".equals(paramString2)))
    {
      QbSdk.reset(paramContext);
      return;
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
  }
  
  private static void readResponse(Context paramContext, String paramString)
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
              processSwitchKeyValue(paramContext, arrayOfString[0], arrayOfString[1]);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.HttpUtils
 * JD-Core Version:    0.7.0.1
 */