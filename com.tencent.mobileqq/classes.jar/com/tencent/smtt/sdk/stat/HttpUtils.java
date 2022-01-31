package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
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
  private static final String LOGTAG = "HttpUtils";
  public static byte[] POST_DATA_KEY = null;
  private static final int PROTOCOL_VERSION = 3;
  private static final int TIDTYPE_MM = 0;
  private static final int TIDTYPE_QQ = 1;
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
  
  public static void doReport(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, long paramLong)
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
        ((ThirdAppInfoNew)localObject2).sGuid = paramString1;
        if (paramBoolean)
        {
          ((ThirdAppInfoNew)localObject2).sQua2 = paramString2;
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
            break label480;
          }
          if (!paramBoolean) {
            continue;
          }
          if (!TbsShareManager.getCoreFormOwn()) {
            continue;
          }
          ((ThirdAppInfoNew)localObject2).iCoreType = 2;
          ((ThirdAppInfoNew)localObject2).sAppVersionName = ((String)localObject1);
          ((ThirdAppInfoNew)localObject2).sAppSignature = getSHA1(paramContext);
          if (!paramBoolean)
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
      break;
      label480:
      do
      {
        paramInt = 0;
        break;
      } while (!paramBoolean);
      paramInt = 1;
    }
  }
  
  /* Error */
  private static org.json.JSONObject getPostData(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: new 279	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 280	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 282
    //   12: aload_0
    //   13: getfield 151	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   16: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   19: pop
    //   20: aload_3
    //   21: ldc_w 288
    //   24: aload_0
    //   25: getfield 192	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   28: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_3
    //   33: ldc_w 290
    //   36: aload_0
    //   37: getfield 198	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   40: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_3
    //   45: ldc_w 292
    //   48: aload_0
    //   49: getfield 201	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   52: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_3
    //   57: ldc_w 294
    //   60: aload_0
    //   61: getfield 195	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   64: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_3
    //   69: ldc_w 296
    //   72: aload_0
    //   73: getfield 219	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   76: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_3
    //   81: ldc_w 298
    //   84: aload_0
    //   85: getfield 222	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   88: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload_3
    //   93: ldc_w 300
    //   96: aload_0
    //   97: getfield 228	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   100: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload_3
    //   105: ldc_w 302
    //   108: aload_0
    //   109: getfield 232	MTT/ThirdAppInfoNew:iPv	J
    //   112: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_3
    //   117: ldc_w 307
    //   120: aload_0
    //   121: getfield 245	MTT/ThirdAppInfoNew:iCoreType	I
    //   124: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   127: pop
    //   128: aload_3
    //   129: ldc_w 312
    //   132: aload_0
    //   133: getfield 248	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   136: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_0
    //   141: getfield 254	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   144: ifnonnull +170 -> 314
    //   147: aload_3
    //   148: ldc_w 314
    //   151: ldc_w 316
    //   154: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload_3
    //   159: ldc_w 317
    //   162: iconst_3
    //   163: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_3
    //   168: ldc_w 319
    //   171: aload_0
    //   172: getfield 225	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   175: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload_1
    //   180: invokestatic 238	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   183: ifeq +157 -> 340
    //   186: aload_3
    //   187: ldc_w 321
    //   190: aload_1
    //   191: invokestatic 325	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   194: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   197: pop
    //   198: aload_0
    //   199: getfield 245	MTT/ThirdAppInfoNew:iCoreType	I
    //   202: ifne +66 -> 268
    //   205: aload_3
    //   206: ldc_w 327
    //   209: aload_0
    //   210: getfield 257	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   213: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload_3
    //   218: ldc_w 329
    //   221: aload_0
    //   222: getfield 264	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   225: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   228: pop
    //   229: getstatic 334	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   232: istore_2
    //   233: aload_0
    //   234: getfield 264	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   237: ifgt +130 -> 367
    //   240: aload_3
    //   241: ldc_w 336
    //   244: aload_1
    //   245: invokestatic 341	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   248: invokevirtual 345	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   251: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   254: pop
    //   255: iload_2
    //   256: iconst_m1
    //   257: if_icmpne +11 -> 268
    //   260: ldc 82
    //   262: ldc_w 347
    //   265: invokestatic 350	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: invokestatic 353	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   271: ifnull +41 -> 312
    //   274: aload_0
    //   275: getfield 151	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   278: ldc 27
    //   280: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifeq +96 -> 379
    //   286: aload_3
    //   287: ldc_w 355
    //   290: invokestatic 360	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   293: invokestatic 353	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   296: invokevirtual 364	com/tencent/smtt/utils/PostEncryption:RSAEncode	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload_3
    //   304: ldc_w 366
    //   307: iconst_1
    //   308: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   311: pop
    //   312: aload_3
    //   313: areturn
    //   314: aload_3
    //   315: ldc_w 314
    //   318: aload_0
    //   319: getfield 254	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   322: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: goto -168 -> 158
    //   329: astore_0
    //   330: ldc 82
    //   332: ldc_w 368
    //   335: invokestatic 350	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aconst_null
    //   339: areturn
    //   340: aload_3
    //   341: ldc_w 321
    //   344: aload_1
    //   345: invokestatic 373	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   348: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_3
    //   353: ldc_w 375
    //   356: aload_1
    //   357: invokestatic 373	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   360: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   363: pop
    //   364: goto -166 -> 198
    //   367: aload_3
    //   368: ldc_w 336
    //   371: iload_2
    //   372: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   375: pop
    //   376: goto -121 -> 255
    //   379: aload_0
    //   380: getfield 151	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   383: ldc_w 377
    //   386: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   389: ifeq -77 -> 312
    //   392: aload_3
    //   393: ldc_w 355
    //   396: invokestatic 353	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   399: invokevirtual 286	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   402: pop
    //   403: aload_3
    //   404: ldc_w 366
    //   407: iconst_0
    //   408: invokevirtual 310	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload_3
    //   413: areturn
    //   414: astore_0
    //   415: aload_3
    //   416: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	417	1	paramContext	Context
    //   232	140	2	i	int
    //   7	409	3	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	158	329	java/lang/Exception
    //   158	198	329	java/lang/Exception
    //   198	255	329	java/lang/Exception
    //   260	268	329	java/lang/Exception
    //   314	326	329	java/lang/Exception
    //   340	364	329	java/lang/Exception
    //   367	376	329	java/lang/Exception
    //   268	312	414	java/lang/Exception
    //   379	412	414	java/lang/Exception
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
  
  public static void post(final ThirdAppInfoNew paramThirdAppInfoNew, final Context paramContext)
  {
    new Thread("HttpUtils")
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: getstatic 43	android/os/Build$VERSION:SDK_INT	I
        //   3: bipush 8
        //   5: if_icmpge +4 -> 9
        //   8: return
        //   9: getstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   12: ifnonnull +13 -> 25
        //   15: ldc 49
        //   17: ldc 51
        //   19: invokevirtual 57	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   22: putstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   25: getstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   28: ifnonnull +26 -> 54
        //   31: ldc 59
        //   33: ldc 61
        //   35: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   38: return
        //   39: astore_2
        //   40: aconst_null
        //   41: putstatic 47	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   44: ldc 59
        //   46: ldc 69
        //   48: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   51: goto -26 -> 25
        //   54: aload_0
        //   55: getfield 17	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
        //   58: invokestatic 75	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
        //   61: getfield 79	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
        //   64: ldc 81
        //   66: ldc 83
        //   68: invokeinterface 89 3 0
        //   73: astore_2
        //   74: aload_2
        //   75: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   78: ifne +429 -> 507
        //   81: aload_2
        //   82: iconst_0
        //   83: aload_2
        //   84: ldc 97
        //   86: invokevirtual 101	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   89: invokevirtual 105	java/lang/String:substring	(II)Ljava/lang/String;
        //   92: astore_3
        //   93: aload_2
        //   94: aload_2
        //   95: ldc 97
        //   97: invokevirtual 101	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   100: iconst_1
        //   101: iadd
        //   102: aload_2
        //   103: invokevirtual 109	java/lang/String:length	()I
        //   106: invokevirtual 105	java/lang/String:substring	(II)Ljava/lang/String;
        //   109: astore_2
        //   110: aload_3
        //   111: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   114: ifne +28 -> 142
        //   117: aload_3
        //   118: invokevirtual 109	java/lang/String:length	()I
        //   121: bipush 96
        //   123: if_icmpne +19 -> 142
        //   126: aload_2
        //   127: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   130: ifne +12 -> 142
        //   133: aload_2
        //   134: invokevirtual 109	java/lang/String:length	()I
        //   137: bipush 24
        //   139: if_icmpeq +132 -> 271
        //   142: iconst_1
        //   143: istore_1
        //   144: invokestatic 114	com/tencent/smtt/utils/TbsCommonConfig:getInstance	()Lcom/tencent/smtt/utils/TbsCommonConfig;
        //   147: astore 4
        //   149: iload_1
        //   150: ifeq +126 -> 276
        //   153: new 116	java/lang/StringBuilder
        //   156: dup
        //   157: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   160: aload 4
        //   162: invokevirtual 122	com/tencent/smtt/utils/TbsCommonConfig:getPvUploadPostUrl	()Ljava/lang/String;
        //   165: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: invokestatic 131	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
        //   171: invokevirtual 134	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
        //   174: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   177: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   180: astore_3
        //   181: new 139	java/net/URL
        //   184: dup
        //   185: aload_3
        //   186: invokespecial 140	java/net/URL:<init>	(Ljava/lang/String;)V
        //   189: invokevirtual 144	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   192: checkcast 146	java/net/HttpURLConnection
        //   195: astore 4
        //   197: aload 4
        //   199: ldc 148
        //   201: invokevirtual 151	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   204: aload 4
        //   206: iconst_1
        //   207: invokevirtual 155	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   210: aload 4
        //   212: iconst_1
        //   213: invokevirtual 158	java/net/HttpURLConnection:setDoInput	(Z)V
        //   216: aload 4
        //   218: iconst_0
        //   219: invokevirtual 161	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   222: aload 4
        //   224: sipush 20000
        //   227: invokevirtual 165	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   230: getstatic 43	android/os/Build$VERSION:SDK_INT	I
        //   233: bipush 13
        //   235: if_icmple +12 -> 247
        //   238: aload 4
        //   240: ldc 167
        //   242: ldc 169
        //   244: invokevirtual 172	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   247: aload_0
        //   248: getfield 19	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
        //   251: aload_0
        //   252: getfield 17	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
        //   255: invokestatic 176	com/tencent/smtt/sdk/stat/HttpUtils:access$000	(LMTT/ThirdAppInfoNew;Landroid/content/Context;)Lorg/json/JSONObject;
        //   258: astore_3
        //   259: aload_3
        //   260: ifnonnull +130 -> 390
        //   263: ldc 59
        //   265: ldc 178
        //   267: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   270: return
        //   271: iconst_0
        //   272: istore_1
        //   273: goto -129 -> 144
        //   276: new 116	java/lang/StringBuilder
        //   279: dup
        //   280: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   283: aload 4
        //   285: invokevirtual 181	com/tencent/smtt/utils/TbsCommonConfig:getPvUploadPostUrlWithToken	()Ljava/lang/String;
        //   288: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   291: aload_3
        //   292: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   295: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   298: astore_3
        //   299: goto -118 -> 181
        //   302: astore_2
        //   303: ldc 59
        //   305: new 116	java/lang/StringBuilder
        //   308: dup
        //   309: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   312: ldc 183
        //   314: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: aload_2
        //   318: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   321: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   324: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   327: return
        //   328: astore_2
        //   329: ldc 59
        //   331: new 116	java/lang/StringBuilder
        //   334: dup
        //   335: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   338: ldc 188
        //   340: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   343: aload_2
        //   344: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   347: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   350: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   353: return
        //   354: astore_2
        //   355: ldc 59
        //   357: new 116	java/lang/StringBuilder
        //   360: dup
        //   361: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   364: ldc 190
        //   366: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: aload_2
        //   370: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   373: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   376: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   379: return
        //   380: astore_3
        //   381: aload_3
        //   382: invokevirtual 193	java/lang/Exception:printStackTrace	()V
        //   385: aconst_null
        //   386: astore_3
        //   387: goto -128 -> 259
        //   390: aload_3
        //   391: invokevirtual 196	org/json/JSONObject:toString	()Ljava/lang/String;
        //   394: ldc 51
        //   396: invokevirtual 57	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   399: astore_3
        //   400: iload_1
        //   401: ifeq +95 -> 496
        //   404: invokestatic 131	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
        //   407: aload_3
        //   408: invokevirtual 200	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
        //   411: astore_2
        //   412: aload 4
        //   414: ldc 202
        //   416: ldc 204
        //   418: invokevirtual 172	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   421: aload 4
        //   423: ldc 206
        //   425: aload_2
        //   426: arraylength
        //   427: invokestatic 210	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   430: invokevirtual 172	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   433: aload 4
        //   435: invokevirtual 214	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   438: astore_3
        //   439: aload_3
        //   440: aload_2
        //   441: invokevirtual 220	java/io/OutputStream:write	([B)V
        //   444: aload_3
        //   445: invokevirtual 223	java/io/OutputStream:flush	()V
        //   448: aload 4
        //   450: invokevirtual 226	java/net/HttpURLConnection:getResponseCode	()I
        //   453: sipush 200
        //   456: if_icmpeq -448 -> 8
        //   459: ldc 59
        //   461: ldc 228
        //   463: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   466: return
        //   467: astore_2
        //   468: ldc 59
        //   470: new 116	java/lang/StringBuilder
        //   473: dup
        //   474: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   477: ldc 230
        //   479: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   482: aload_2
        //   483: invokevirtual 233	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   486: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   489: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   492: invokestatic 67	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   495: return
        //   496: aload_3
        //   497: aload_2
        //   498: invokestatic 236	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([BLjava/lang/String;)[B
        //   501: astore_2
        //   502: goto -90 -> 412
        //   505: astore_2
        //   506: return
        //   507: ldc 83
        //   509: astore_3
        //   510: ldc 83
        //   512: astore_2
        //   513: goto -403 -> 110
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	516	0	this	1
        //   143	258	1	i	int
        //   39	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
        //   73	61	2	str1	String
        //   302	16	2	localIOException	java.io.IOException
        //   328	16	2	localAssertionError	java.lang.AssertionError
        //   354	16	2	localNoClassDefFoundError	java.lang.NoClassDefFoundError
        //   411	30	2	arrayOfByte1	byte[]
        //   467	31	2	localThrowable1	Throwable
        //   501	1	2	arrayOfByte2	byte[]
        //   505	1	2	localThrowable2	Throwable
        //   512	1	2	str2	String
        //   92	207	3	localObject1	Object
        //   380	2	3	localException	Exception
        //   386	124	3	localObject2	Object
        //   147	302	4	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   15	25	39	java/io/UnsupportedEncodingException
        //   144	149	302	java/io/IOException
        //   153	181	302	java/io/IOException
        //   181	204	302	java/io/IOException
        //   276	299	302	java/io/IOException
        //   144	149	328	java/lang/AssertionError
        //   153	181	328	java/lang/AssertionError
        //   181	204	328	java/lang/AssertionError
        //   276	299	328	java/lang/AssertionError
        //   144	149	354	java/lang/NoClassDefFoundError
        //   153	181	354	java/lang/NoClassDefFoundError
        //   181	204	354	java/lang/NoClassDefFoundError
        //   276	299	354	java/lang/NoClassDefFoundError
        //   247	259	380	java/lang/Exception
        //   433	466	467	java/lang/Throwable
        //   390	400	505	java/lang/Throwable
        //   404	412	505	java/lang/Throwable
        //   496	502	505	java/lang/Throwable
      }
    }.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.HttpUtils
 * JD-Core Version:    0.7.0.1
 */