package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.HttpUtil;
import com.tencent.smtt.utils.SysCoreQUA2Utils;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

public class TbsLogReport
{
  private static final String KEY_TBSDOWNLOAD_UPLOAD = "tbs_download_upload";
  protected static final String LOGTAG = "upload";
  static final int MAX_CALLSTACK_LENGTH = 1024;
  private static final int MAX_UPLOAD_NUM = 5;
  private static final int MSG_DAILY_REPORT = 601;
  private static final int MSG_EVENT_REPORT = 600;
  private static final String TBSAPK_DOWNLOAD_STAT_FILENAME = "tbs_download_stat";
  private static final String THREAD_NAME = "TbsLogReportThread";
  private static TbsLogReport mInstance;
  private Context mContext;
  private Handler mReportHandler = null;
  private boolean shouldUploadEventReport = false;
  
  private TbsLogReport(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    paramContext = new HandlerThread("TbsLogReportThread");
    paramContext.start();
    this.mReportHandler = new TbsLogReport.1(this, paramContext.getLooper());
  }
  
  private String addData(int paramInt)
  {
    return paramInt + "|";
  }
  
  private String addData(long paramLong)
  {
    return paramLong + "|";
  }
  
  private String addData(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private void clearUploadData()
  {
    SharedPreferences.Editor localEditor = sharedPreferences().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private void eventReportInThread(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(addData(paramInt));
    localStringBuilder.append(addData(AppUtil.getImei(this.mContext)));
    localStringBuilder.append(addData(SysCoreQUA2Utils.getQUA2_V3(this.mContext)));
    localStringBuilder.append(addData(TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(this.mContext)));
    Object localObject1 = Build.MODEL;
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      SharedPreferences localSharedPreferences;
      try
      {
        for (;;)
        {
          Object localObject2;
          int i;
          ((JSONArray)localObject2).put(((JSONArray)localObject1).get(((JSONArray)localObject2).length() - i));
          i -= 1;
          continue;
          localException = localException;
        }
        localStringBuilder.append(addData(AppUtil.getAppVersionCode(this.mContext)));
      }
      catch (Exception paramTbsLogInfo)
      {
        for (;;)
        {
          TbsLog.e("upload", "JSONArray transform error!");
        }
      }
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject1;
      paramTbsLogInfo.put(localStringBuilder.toString());
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putString("tbs_download_upload", paramTbsLogInfo.toString());
      ((SharedPreferences.Editor)localObject1).commit();
      if ((!this.shouldUploadEventReport) && (paramInt == TbsLogReport.EventType.TYPE_LOAD.value)) {
        return;
      }
      sendLogReportRequest();
    }
    localStringBuilder.append(addData((String)localObject1));
    localObject1 = this.mContext.getPackageName();
    localStringBuilder.append(addData((String)localObject1));
    if ("com.tencent.mm".equals(localObject1))
    {
      localStringBuilder.append(addData(AppUtil.getAppMetadata(this.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(addData(formatTime(TbsLogReport.TbsLogInfo.access$300(paramTbsLogInfo))));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$400(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$500(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$600(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$700(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$800(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$900(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1000(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1100(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1200(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1300(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1400(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1500(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1600(paramTbsLogInfo)));
      localStringBuilder.append(addData(paramTbsLogInfo.mErrorCode));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1700(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsLogReport.TbsLogInfo.access$1800(paramTbsLogInfo)));
      localStringBuilder.append(addData(TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0)));
      localStringBuilder.append(addData(AppUtil.getAndroidID(this.mContext)));
      localStringBuilder.append(addData("4.3.0.1190_43739"));
      localStringBuilder.append(false);
      localSharedPreferences = sharedPreferences();
      localObject1 = getUploadData();
      localObject2 = new JSONArray();
      if (((JSONArray)localObject2).length() < 5) {
        break label573;
      }
      i = 4;
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject2;
      if (i < 1) {
        break label576;
      }
    }
    label573:
    label576:
    return;
  }
  
  private String formatTime(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static TbsLogReport getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new TbsLogReport(paramContext);
      }
      return mInstance;
    }
    finally {}
  }
  
  private JSONArray getUploadData()
  {
    Object localObject = sharedPreferences().getString("tbs_download_upload", null);
    if (localObject == null) {
      localObject = new JSONArray();
    }
    for (;;)
    {
      return localObject;
      try
      {
        JSONArray localJSONArray1 = new JSONArray((String)localObject);
        localObject = localJSONArray1;
        if (localJSONArray1.length() > 5)
        {
          JSONArray localJSONArray2 = new JSONArray();
          int i = localJSONArray1.length() - 1;
          localObject = localJSONArray1;
          if (i > localJSONArray1.length() - 5)
          {
            localJSONArray2.put(localJSONArray1.get(i));
            return localJSONArray2;
          }
        }
      }
      catch (Exception localException) {}
    }
    return new JSONArray();
  }
  
  private void installEventReport(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo, TbsLogReport.EventType paramEventType)
  {
    paramTbsLogInfo.setErrorCode(paramInt);
    paramTbsLogInfo.setEventTime(System.currentTimeMillis());
    QbSdk.mTbsListenerWrapper.onInstallFinish(paramInt);
    eventReport(paramEventType, paramTbsLogInfo);
  }
  
  private void sendLogReportRequest()
  {
    if ((QbSdk.mSettings != null) && (QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
    Object localObject = getUploadData();
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      localObject = HttpUtil.postData(TbsCommonConfig.getInstance(this.mContext).getTbsDownloadStatPostUrl(), ((JSONArray)localObject).toString().getBytes("utf-8"), new TbsLogReport.3(this), true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject + " testcase: " + -1);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private SharedPreferences sharedPreferences()
  {
    return this.mContext.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public void clear()
  {
    try
    {
      SharedPreferences.Editor localEditor = sharedPreferences().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dailyReport()
  {
    this.mReportHandler.sendEmptyMessage(601);
  }
  
  public void eventReport(TbsLogReport.EventType paramEventType, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    try
    {
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)paramTbsLogInfo.clone();
      Message localMessage = this.mReportHandler.obtainMessage();
      localMessage.what = 600;
      localMessage.arg1 = paramEventType.value;
      localMessage.obj = paramTbsLogInfo;
      this.mReportHandler.sendMessage(localMessage);
      return;
    }
    catch (Throwable paramEventType)
    {
      TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + paramEventType.getMessage());
    }
  }
  
  public boolean getShouldUploadEventReport()
  {
    return this.shouldUploadEventReport;
  }
  
  /* Error */
  public void reportTbsLog()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: getstatic 385	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   6: ifnull +46 -> 52
    //   9: getstatic 385	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   12: getstatic 388	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   15: invokeinterface 393 2 0
    //   20: ifeq +32 -> 52
    //   23: getstatic 385	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   26: getstatic 388	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   29: invokeinterface 396 2 0
    //   34: ldc_w 398
    //   37: invokevirtual 399	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +12 -> 52
    //   43: ldc 11
    //   45: ldc_w 492
    //   48: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: return
    //   52: aload_0
    //   53: getfield 51	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   56: invokestatic 497	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   59: iconst_3
    //   60: if_icmpne -9 -> 51
    //   63: invokestatic 500	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: ifnull -19 -> 51
    //   73: invokestatic 505	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   76: invokevirtual 508	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
    //   79: astore 9
    //   81: aload_0
    //   82: getfield 51	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   85: invokestatic 139	com/tencent/smtt/utils/AppUtil:getImei	(Landroid/content/Context;)Ljava/lang/String;
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 51	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   93: invokestatic 268	com/tencent/smtt/utils/AppUtil:getAndroidID	(Landroid/content/Context;)Ljava/lang/String;
    //   96: astore_2
    //   97: aload_3
    //   98: invokevirtual 511	java/lang/String:getBytes	()[B
    //   101: astore_3
    //   102: aload_2
    //   103: invokevirtual 511	java/lang/String:getBytes	()[B
    //   106: astore 4
    //   108: aload_3
    //   109: astore_2
    //   110: invokestatic 505	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   113: aload_3
    //   114: invokevirtual 515	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   117: astore_3
    //   118: aload_3
    //   119: astore_2
    //   120: invokestatic 505	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   123: aload 4
    //   125: invokevirtual 515	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   128: astore 5
    //   130: aload 5
    //   132: astore_2
    //   133: aload_3
    //   134: astore 4
    //   136: aload_2
    //   137: astore_3
    //   138: aload 4
    //   140: invokestatic 519	com/tencent/smtt/utils/Post3DESEncryption:bytesToHex	([B)Ljava/lang/String;
    //   143: astore_2
    //   144: aload_3
    //   145: invokestatic 519	com/tencent/smtt/utils/Post3DESEncryption:bytesToHex	([B)Ljava/lang/String;
    //   148: astore_3
    //   149: new 88	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   156: aload_0
    //   157: getfield 51	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   160: invokestatic 420	com/tencent/smtt/utils/TbsCommonConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/utils/TbsCommonConfig;
    //   163: invokevirtual 522	com/tencent/smtt/utils/TbsCommonConfig:getTbsLogPostUrl	()Ljava/lang/String;
    //   166: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 524
    //   176: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_3
    //   180: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 10
    //   188: new 526	java/util/HashMap
    //   191: dup
    //   192: invokespecial 527	java/util/HashMap:<init>	()V
    //   195: astore 11
    //   197: aload 11
    //   199: ldc_w 529
    //   202: ldc_w 531
    //   205: invokeinterface 534 3 0
    //   210: pop
    //   211: aload 11
    //   213: ldc_w 536
    //   216: ldc 165
    //   218: invokeinterface 534 3 0
    //   223: pop
    //   224: aload 11
    //   226: ldc_w 538
    //   229: aload_0
    //   230: getfield 51	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   233: invokestatic 146	com/tencent/smtt/utils/SysCoreQUA2Utils:getQUA2_V3	(Landroid/content/Context;)Ljava/lang/String;
    //   236: invokeinterface 534 3 0
    //   241: pop
    //   242: new 540	java/io/File
    //   245: dup
    //   246: getstatic 545	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   249: invokespecial 546	java/io/File:<init>	(Ljava/lang/String;)V
    //   252: pop
    //   253: new 548	com/tencent/smtt/sdk/TbsLogReport$ZipHelper
    //   256: dup
    //   257: aload 6
    //   259: new 88	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   266: getstatic 545	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   269: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 550
    //   275: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokespecial 552	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: invokevirtual 555	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:Zip	()V
    //   287: new 540	java/io/File
    //   290: dup
    //   291: getstatic 545	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   294: ldc_w 557
    //   297: invokespecial 558	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: astore 5
    //   302: new 560	java/io/FileInputStream
    //   305: dup
    //   306: aload 5
    //   308: invokespecial 563	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   311: astore 4
    //   313: sipush 8192
    //   316: newarray byte
    //   318: astore_3
    //   319: new 565	java/io/ByteArrayOutputStream
    //   322: dup
    //   323: invokespecial 566	java/io/ByteArrayOutputStream:<init>	()V
    //   326: astore_2
    //   327: aload_2
    //   328: astore 8
    //   330: aload 5
    //   332: astore 7
    //   334: aload 4
    //   336: astore 6
    //   338: aload 4
    //   340: aload_3
    //   341: invokevirtual 570	java/io/FileInputStream:read	([B)I
    //   344: istore_1
    //   345: iload_1
    //   346: iconst_m1
    //   347: if_icmpeq +114 -> 461
    //   350: aload_2
    //   351: astore 8
    //   353: aload 5
    //   355: astore 7
    //   357: aload 4
    //   359: astore 6
    //   361: aload_2
    //   362: aload_3
    //   363: iconst_0
    //   364: iload_1
    //   365: invokevirtual 574	java/io/ByteArrayOutputStream:write	([BII)V
    //   368: goto -41 -> 327
    //   371: astore_3
    //   372: aload_2
    //   373: astore 8
    //   375: aload 5
    //   377: astore 7
    //   379: aload 4
    //   381: astore 6
    //   383: aload_3
    //   384: invokevirtual 575	java/lang/Exception:printStackTrace	()V
    //   387: aload 4
    //   389: ifnull +8 -> 397
    //   392: aload 4
    //   394: invokevirtual 578	java/io/FileInputStream:close	()V
    //   397: aload_2
    //   398: ifnull +7 -> 405
    //   401: aload_2
    //   402: invokevirtual 579	java/io/ByteArrayOutputStream:close	()V
    //   405: aload 5
    //   407: ifnull +250 -> 657
    //   410: aload 5
    //   412: invokevirtual 582	java/io/File:delete	()Z
    //   415: pop
    //   416: aconst_null
    //   417: astore_2
    //   418: new 88	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   425: aload 10
    //   427: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 584
    //   433: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 9
    //   438: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: aload 11
    //   446: aload_2
    //   447: new 586	com/tencent/smtt/sdk/TbsLogReport$2
    //   450: dup
    //   451: aload_0
    //   452: invokespecial 587	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   455: iconst_0
    //   456: invokestatic 590	com/tencent/smtt/utils/HttpUtil:postData	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/HttpUtil$HttpResponseListener;Z)Ljava/lang/String;
    //   459: pop
    //   460: return
    //   461: aload_2
    //   462: astore 8
    //   464: aload 5
    //   466: astore 7
    //   468: aload 4
    //   470: astore 6
    //   472: aload_2
    //   473: invokevirtual 593	java/io/ByteArrayOutputStream:flush	()V
    //   476: aload_2
    //   477: astore 8
    //   479: aload 5
    //   481: astore 7
    //   483: aload 4
    //   485: astore 6
    //   487: invokestatic 505	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   490: aload_2
    //   491: invokevirtual 596	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   494: invokevirtual 515	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   497: astore_3
    //   498: aload 4
    //   500: ifnull +8 -> 508
    //   503: aload 4
    //   505: invokevirtual 578	java/io/FileInputStream:close	()V
    //   508: aload_2
    //   509: ifnull +7 -> 516
    //   512: aload_2
    //   513: invokevirtual 579	java/io/ByteArrayOutputStream:close	()V
    //   516: aload_3
    //   517: astore_2
    //   518: aload 5
    //   520: ifnull -102 -> 418
    //   523: aload 5
    //   525: invokevirtual 582	java/io/File:delete	()Z
    //   528: pop
    //   529: aload_3
    //   530: astore_2
    //   531: goto -113 -> 418
    //   534: astore_2
    //   535: aconst_null
    //   536: astore 5
    //   538: aconst_null
    //   539: astore_3
    //   540: aload_3
    //   541: ifnull +7 -> 548
    //   544: aload_3
    //   545: invokevirtual 578	java/io/FileInputStream:close	()V
    //   548: aload 8
    //   550: ifnull +8 -> 558
    //   553: aload 8
    //   555: invokevirtual 579	java/io/ByteArrayOutputStream:close	()V
    //   558: aload 5
    //   560: ifnull +9 -> 569
    //   563: aload 5
    //   565: invokevirtual 582	java/io/File:delete	()Z
    //   568: pop
    //   569: aload_2
    //   570: athrow
    //   571: astore 4
    //   573: goto -65 -> 508
    //   576: astore_2
    //   577: goto -61 -> 516
    //   580: astore_3
    //   581: goto -184 -> 397
    //   584: astore_2
    //   585: goto -180 -> 405
    //   588: astore_3
    //   589: goto -41 -> 548
    //   592: astore_3
    //   593: goto -35 -> 558
    //   596: astore_2
    //   597: aconst_null
    //   598: astore_3
    //   599: goto -59 -> 540
    //   602: astore_2
    //   603: aload 4
    //   605: astore_3
    //   606: goto -66 -> 540
    //   609: astore_2
    //   610: aload 7
    //   612: astore 5
    //   614: aload 6
    //   616: astore_3
    //   617: goto -77 -> 540
    //   620: astore_3
    //   621: aconst_null
    //   622: astore_2
    //   623: aconst_null
    //   624: astore 5
    //   626: aconst_null
    //   627: astore 4
    //   629: goto -257 -> 372
    //   632: astore_3
    //   633: aconst_null
    //   634: astore_2
    //   635: aconst_null
    //   636: astore 4
    //   638: goto -266 -> 372
    //   641: astore_3
    //   642: aconst_null
    //   643: astore_2
    //   644: goto -272 -> 372
    //   647: astore_3
    //   648: aload 4
    //   650: astore_3
    //   651: aload_2
    //   652: astore 4
    //   654: goto -516 -> 138
    //   657: aconst_null
    //   658: astore_2
    //   659: goto -241 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	TbsLogReport
    //   344	21	1	i	int
    //   96	435	2	localObject1	Object
    //   534	36	2	localObject2	Object
    //   576	1	2	localException1	Exception
    //   584	1	2	localException2	Exception
    //   596	1	2	localObject3	Object
    //   602	1	2	localObject4	Object
    //   609	1	2	localObject5	Object
    //   622	37	2	localObject6	Object
    //   88	275	3	localObject7	Object
    //   371	13	3	localException3	Exception
    //   497	48	3	arrayOfByte	byte[]
    //   580	1	3	localException4	Exception
    //   588	1	3	localException5	Exception
    //   592	1	3	localException6	Exception
    //   598	19	3	localObject8	Object
    //   620	1	3	localException7	Exception
    //   632	1	3	localException8	Exception
    //   641	1	3	localException9	Exception
    //   647	1	3	localException10	Exception
    //   650	1	3	localObject9	Object
    //   106	398	4	localObject10	Object
    //   571	33	4	localException11	Exception
    //   627	26	4	localObject11	Object
    //   128	497	5	localObject12	Object
    //   66	549	6	localObject13	Object
    //   332	279	7	localObject14	Object
    //   1	553	8	localObject15	Object
    //   79	358	9	str1	String
    //   186	240	10	str2	String
    //   195	250	11	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   338	345	371	java/lang/Exception
    //   361	368	371	java/lang/Exception
    //   472	476	371	java/lang/Exception
    //   487	498	371	java/lang/Exception
    //   242	302	534	finally
    //   503	508	571	java/lang/Exception
    //   512	516	576	java/lang/Exception
    //   392	397	580	java/lang/Exception
    //   401	405	584	java/lang/Exception
    //   544	548	588	java/lang/Exception
    //   553	558	592	java/lang/Exception
    //   302	313	596	finally
    //   313	327	602	finally
    //   338	345	609	finally
    //   361	368	609	finally
    //   383	387	609	finally
    //   472	476	609	finally
    //   487	498	609	finally
    //   242	302	620	java/lang/Exception
    //   302	313	632	java/lang/Exception
    //   313	327	641	java/lang/Exception
    //   110	118	647	java/lang/Exception
    //   120	130	647	java/lang/Exception
  }
  
  public void setInstallErrorCode(int paramInt, String paramString)
  {
    setInstallErrorCode(paramInt, paramString, TbsLogReport.EventType.TYPE_INSTALL);
  }
  
  public void setInstallErrorCode(int paramInt, String paramString, TbsLogReport.EventType paramEventType)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + paramInt, true);
    }
    TbsLogReport.TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramString);
    installEventReport(paramInt, localTbsLogInfo, paramEventType);
  }
  
  public void setInstallErrorCode(int paramInt, Throwable paramThrowable)
  {
    TbsLogReport.TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramThrowable);
    installEventReport(paramInt, localTbsLogInfo, TbsLogReport.EventType.TYPE_INSTALL);
  }
  
  public void setLoadErrorCode(int paramInt, String paramString)
  {
    TbsLogReport.TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setErrorCode(paramInt);
    localTbsLogInfo.setEventTime(System.currentTimeMillis());
    localTbsLogInfo.setFailDetail(paramString);
    eventReport(TbsLogReport.EventType.TYPE_LOAD, localTbsLogInfo);
  }
  
  public void setLoadErrorCode(int paramInt, Throwable paramThrowable)
  {
    Object localObject = "NULL";
    if (paramThrowable != null)
    {
      paramThrowable = "msg: " + paramThrowable.getMessage() + "; err: " + paramThrowable + "; cause: " + Log.getStackTraceString(paramThrowable.getCause());
      localObject = paramThrowable;
      if (paramThrowable.length() > 1024) {
        localObject = paramThrowable.substring(0, 1024);
      }
    }
    setLoadErrorCode(paramInt, (String)localObject);
  }
  
  public void setShouldUploadEventReport(boolean paramBoolean)
  {
    this.shouldUploadEventReport = paramBoolean;
  }
  
  public TbsLogReport.TbsLogInfo tbsLogInfo()
  {
    return new TbsLogReport.TbsLogInfo(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */