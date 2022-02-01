package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

public class TbsLogReport
{
  private static TbsLogReport a;
  private Handler b = null;
  private Context c;
  private boolean d = false;
  
  private TbsLogReport(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    paramContext = new HandlerThread("TbsLogReportThread");
    paramContext.start();
    this.b = new TbsLogReport.1(this, paramContext.getLooper());
  }
  
  private String a(int paramInt)
  {
    return paramInt + "|";
  }
  
  private String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private JSONArray a()
  {
    Object localObject = d().getString("tbs_download_upload", null);
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
  
  private void a(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt));
    localStringBuilder.append(a(b.d(this.c)));
    localStringBuilder.append(a(j.a(this.c)));
    localStringBuilder.append(a(n.a().i(this.c)));
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
        localStringBuilder.append(a(b.b(this.c)));
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
      if ((!this.d) && (paramInt == TbsLogReport.EventType.TYPE_LOAD.a)) {
        return;
      }
      b();
    }
    localStringBuilder.append(a((String)localObject1));
    localObject1 = this.c.getPackageName();
    localStringBuilder.append(a((String)localObject1));
    if ("com.tencent.mm".equals(localObject1))
    {
      localStringBuilder.append(a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(a(a(TbsLogReport.TbsLogInfo.a(paramTbsLogInfo))));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.b(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.c(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.d(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.e(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.f(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.g(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.h(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.i(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.j(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogReport.TbsLogInfo.k(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogReport.TbsLogInfo.l(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogReport.TbsLogInfo.m(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.n(paramTbsLogInfo)));
      localStringBuilder.append(a(paramTbsLogInfo.a));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.o(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.p(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt("tbs_download_version", 0)));
      localStringBuilder.append(a(b.g(this.c)));
      localStringBuilder.append(a("4.3.0.36_43936"));
      localStringBuilder.append(false);
      localSharedPreferences = d();
      localObject1 = a();
      localObject2 = new JSONArray();
      if (((JSONArray)localObject2).length() < 5) {
        break label572;
      }
      i = 4;
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject2;
      if (i < 1) {
        break label575;
      }
    }
    label572:
    label575:
    return;
  }
  
  private void a(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo, TbsLogReport.EventType paramEventType)
  {
    paramTbsLogInfo.setErrorCode(paramInt);
    paramTbsLogInfo.setEventTime(System.currentTimeMillis());
    QbSdk.m.onInstallFinish(paramInt);
    eventReport(paramEventType, paramTbsLogInfo);
  }
  
  private String b(long paramLong)
  {
    return paramLong + "|";
  }
  
  private void b()
  {
    if ((QbSdk.n != null) && (QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
    Object localObject = a();
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      localObject = f.a(l.a(this.c).c(), ((JSONArray)localObject).toString().getBytes("utf-8"), new TbsLogReport.3(this), true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject + " testcase: " + -1);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = d().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private SharedPreferences d()
  {
    return this.c.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public static TbsLogReport getInstance(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new TbsLogReport(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      SharedPreferences.Editor localEditor = d().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dailyReport()
  {
    this.b.sendEmptyMessage(601);
  }
  
  public void eventReport(TbsLogReport.EventType paramEventType, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    try
    {
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)paramTbsLogInfo.clone();
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 600;
      localMessage.arg1 = paramEventType.a;
      localMessage.obj = paramTbsLogInfo;
      this.b.sendMessage(localMessage);
      return;
    }
    catch (Throwable paramEventType)
    {
      TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + paramEventType.getMessage());
    }
  }
  
  public boolean getShouldUploadEventReport()
  {
    return this.d;
  }
  
  /* Error */
  public void reportTbsLog()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: getstatic 333	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   6: ifnull +47 -> 53
    //   9: getstatic 333	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   12: getstatic 336	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   15: invokeinterface 341 2 0
    //   20: ifeq +33 -> 53
    //   23: getstatic 333	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   26: getstatic 336	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   29: invokeinterface 344 2 0
    //   34: ldc_w 346
    //   37: invokevirtual 347	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +13 -> 53
    //   43: ldc_w 262
    //   46: ldc_w 450
    //   49: invokestatic 351	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: return
    //   53: aload_0
    //   54: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   57: invokestatic 455	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   60: iconst_3
    //   61: if_icmpne -9 -> 52
    //   64: invokestatic 458	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   67: astore 6
    //   69: aload 6
    //   71: ifnull -19 -> 52
    //   74: invokestatic 463	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   77: invokevirtual 465	com/tencent/smtt/utils/g:b	()Ljava/lang/String;
    //   80: astore 9
    //   82: aload_0
    //   83: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   86: invokestatic 130	com/tencent/smtt/utils/b:d	(Landroid/content/Context;)Ljava/lang/String;
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   94: invokestatic 251	com/tencent/smtt/utils/b:g	(Landroid/content/Context;)Ljava/lang/String;
    //   97: astore_2
    //   98: aload_3
    //   99: invokevirtual 468	java/lang/String:getBytes	()[B
    //   102: astore_3
    //   103: aload_2
    //   104: invokevirtual 468	java/lang/String:getBytes	()[B
    //   107: astore 4
    //   109: aload_3
    //   110: astore_2
    //   111: invokestatic 463	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   114: aload_3
    //   115: invokevirtual 471	com/tencent/smtt/utils/g:a	([B)[B
    //   118: astore_3
    //   119: aload_3
    //   120: astore_2
    //   121: invokestatic 463	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   124: aload 4
    //   126: invokevirtual 471	com/tencent/smtt/utils/g:a	([B)[B
    //   129: astore 5
    //   131: aload 5
    //   133: astore_2
    //   134: aload_3
    //   135: astore 4
    //   137: aload_2
    //   138: astore_3
    //   139: aload 4
    //   141: invokestatic 474	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   144: astore_2
    //   145: aload_3
    //   146: invokestatic 474	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   149: astore_3
    //   150: new 52	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   157: aload_0
    //   158: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   161: invokestatic 367	com/tencent/smtt/utils/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/l;
    //   164: invokevirtual 476	com/tencent/smtt/utils/l:e	()Ljava/lang/String;
    //   167: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_2
    //   171: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 478
    //   177: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore 10
    //   189: new 480	java/util/HashMap
    //   192: dup
    //   193: invokespecial 481	java/util/HashMap:<init>	()V
    //   196: astore 11
    //   198: aload 11
    //   200: ldc_w 483
    //   203: ldc_w 485
    //   206: invokeinterface 488 3 0
    //   211: pop
    //   212: aload 11
    //   214: ldc_w 490
    //   217: ldc 155
    //   219: invokeinterface 488 3 0
    //   224: pop
    //   225: aload 11
    //   227: ldc_w 492
    //   230: aload_0
    //   231: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   234: invokestatic 136	com/tencent/smtt/utils/j:a	(Landroid/content/Context;)Ljava/lang/String;
    //   237: invokeinterface 488 3 0
    //   242: pop
    //   243: new 494	java/io/File
    //   246: dup
    //   247: getstatic 498	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   250: invokespecial 499	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: pop
    //   254: new 501	com/tencent/smtt/sdk/TbsLogReport$a
    //   257: dup
    //   258: aload 6
    //   260: new 52	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   267: getstatic 498	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   270: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 503
    //   276: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokespecial 505	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: invokevirtual 507	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   288: new 494	java/io/File
    //   291: dup
    //   292: getstatic 498	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   295: ldc_w 509
    //   298: invokespecial 510	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: astore 5
    //   303: new 512	java/io/FileInputStream
    //   306: dup
    //   307: aload 5
    //   309: invokespecial 515	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   312: astore 4
    //   314: sipush 8192
    //   317: newarray byte
    //   319: astore_3
    //   320: new 517	java/io/ByteArrayOutputStream
    //   323: dup
    //   324: invokespecial 518	java/io/ByteArrayOutputStream:<init>	()V
    //   327: astore_2
    //   328: aload_2
    //   329: astore 8
    //   331: aload 5
    //   333: astore 7
    //   335: aload 4
    //   337: astore 6
    //   339: aload 4
    //   341: aload_3
    //   342: invokevirtual 522	java/io/FileInputStream:read	([B)I
    //   345: istore_1
    //   346: iload_1
    //   347: iconst_m1
    //   348: if_icmpeq +114 -> 462
    //   351: aload_2
    //   352: astore 8
    //   354: aload 5
    //   356: astore 7
    //   358: aload 4
    //   360: astore 6
    //   362: aload_2
    //   363: aload_3
    //   364: iconst_0
    //   365: iload_1
    //   366: invokevirtual 526	java/io/ByteArrayOutputStream:write	([BII)V
    //   369: goto -41 -> 328
    //   372: astore_3
    //   373: aload_2
    //   374: astore 8
    //   376: aload 5
    //   378: astore 7
    //   380: aload 4
    //   382: astore 6
    //   384: aload_3
    //   385: invokevirtual 527	java/lang/Exception:printStackTrace	()V
    //   388: aload 4
    //   390: ifnull +8 -> 398
    //   393: aload 4
    //   395: invokevirtual 530	java/io/FileInputStream:close	()V
    //   398: aload_2
    //   399: ifnull +7 -> 406
    //   402: aload_2
    //   403: invokevirtual 531	java/io/ByteArrayOutputStream:close	()V
    //   406: aload 5
    //   408: ifnull +250 -> 658
    //   411: aload 5
    //   413: invokevirtual 534	java/io/File:delete	()Z
    //   416: pop
    //   417: aconst_null
    //   418: astore_2
    //   419: new 52	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   426: aload 10
    //   428: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w 536
    //   434: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 9
    //   439: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: aload 11
    //   447: aload_2
    //   448: new 538	com/tencent/smtt/sdk/TbsLogReport$2
    //   451: dup
    //   452: aload_0
    //   453: invokespecial 539	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   456: iconst_0
    //   457: invokestatic 542	com/tencent/smtt/utils/f:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/f$a;Z)Ljava/lang/String;
    //   460: pop
    //   461: return
    //   462: aload_2
    //   463: astore 8
    //   465: aload 5
    //   467: astore 7
    //   469: aload 4
    //   471: astore 6
    //   473: aload_2
    //   474: invokevirtual 545	java/io/ByteArrayOutputStream:flush	()V
    //   477: aload_2
    //   478: astore 8
    //   480: aload 5
    //   482: astore 7
    //   484: aload 4
    //   486: astore 6
    //   488: invokestatic 463	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   491: aload_2
    //   492: invokevirtual 548	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   495: invokevirtual 471	com/tencent/smtt/utils/g:a	([B)[B
    //   498: astore_3
    //   499: aload 4
    //   501: ifnull +8 -> 509
    //   504: aload 4
    //   506: invokevirtual 530	java/io/FileInputStream:close	()V
    //   509: aload_2
    //   510: ifnull +7 -> 517
    //   513: aload_2
    //   514: invokevirtual 531	java/io/ByteArrayOutputStream:close	()V
    //   517: aload_3
    //   518: astore_2
    //   519: aload 5
    //   521: ifnull -102 -> 419
    //   524: aload 5
    //   526: invokevirtual 534	java/io/File:delete	()Z
    //   529: pop
    //   530: aload_3
    //   531: astore_2
    //   532: goto -113 -> 419
    //   535: astore_2
    //   536: aconst_null
    //   537: astore 5
    //   539: aconst_null
    //   540: astore_3
    //   541: aload_3
    //   542: ifnull +7 -> 549
    //   545: aload_3
    //   546: invokevirtual 530	java/io/FileInputStream:close	()V
    //   549: aload 8
    //   551: ifnull +8 -> 559
    //   554: aload 8
    //   556: invokevirtual 531	java/io/ByteArrayOutputStream:close	()V
    //   559: aload 5
    //   561: ifnull +9 -> 570
    //   564: aload 5
    //   566: invokevirtual 534	java/io/File:delete	()Z
    //   569: pop
    //   570: aload_2
    //   571: athrow
    //   572: astore 4
    //   574: goto -65 -> 509
    //   577: astore_2
    //   578: goto -61 -> 517
    //   581: astore_3
    //   582: goto -184 -> 398
    //   585: astore_2
    //   586: goto -180 -> 406
    //   589: astore_3
    //   590: goto -41 -> 549
    //   593: astore_3
    //   594: goto -35 -> 559
    //   597: astore_2
    //   598: aconst_null
    //   599: astore_3
    //   600: goto -59 -> 541
    //   603: astore_2
    //   604: aload 4
    //   606: astore_3
    //   607: goto -66 -> 541
    //   610: astore_2
    //   611: aload 7
    //   613: astore 5
    //   615: aload 6
    //   617: astore_3
    //   618: goto -77 -> 541
    //   621: astore_3
    //   622: aconst_null
    //   623: astore_2
    //   624: aconst_null
    //   625: astore 5
    //   627: aconst_null
    //   628: astore 4
    //   630: goto -257 -> 373
    //   633: astore_3
    //   634: aconst_null
    //   635: astore_2
    //   636: aconst_null
    //   637: astore 4
    //   639: goto -266 -> 373
    //   642: astore_3
    //   643: aconst_null
    //   644: astore_2
    //   645: goto -272 -> 373
    //   648: astore_3
    //   649: aload 4
    //   651: astore_3
    //   652: aload_2
    //   653: astore 4
    //   655: goto -516 -> 139
    //   658: aconst_null
    //   659: astore_2
    //   660: goto -241 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	TbsLogReport
    //   345	21	1	i	int
    //   97	435	2	localObject1	Object
    //   535	36	2	localObject2	Object
    //   577	1	2	localException1	Exception
    //   585	1	2	localException2	Exception
    //   597	1	2	localObject3	Object
    //   603	1	2	localObject4	Object
    //   610	1	2	localObject5	Object
    //   623	37	2	localObject6	Object
    //   89	275	3	localObject7	Object
    //   372	13	3	localException3	Exception
    //   498	48	3	arrayOfByte	byte[]
    //   581	1	3	localException4	Exception
    //   589	1	3	localException5	Exception
    //   593	1	3	localException6	Exception
    //   599	19	3	localObject8	Object
    //   621	1	3	localException7	Exception
    //   633	1	3	localException8	Exception
    //   642	1	3	localException9	Exception
    //   648	1	3	localException10	Exception
    //   651	1	3	localObject9	Object
    //   107	398	4	localObject10	Object
    //   572	33	4	localException11	Exception
    //   628	26	4	localObject11	Object
    //   129	497	5	localObject12	Object
    //   67	549	6	localObject13	Object
    //   333	279	7	localObject14	Object
    //   1	554	8	localObject15	Object
    //   80	358	9	str1	String
    //   187	240	10	str2	String
    //   196	250	11	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   339	346	372	java/lang/Exception
    //   362	369	372	java/lang/Exception
    //   473	477	372	java/lang/Exception
    //   488	499	372	java/lang/Exception
    //   243	303	535	finally
    //   504	509	572	java/lang/Exception
    //   513	517	577	java/lang/Exception
    //   393	398	581	java/lang/Exception
    //   402	406	585	java/lang/Exception
    //   545	549	589	java/lang/Exception
    //   554	559	593	java/lang/Exception
    //   303	314	597	finally
    //   314	328	603	finally
    //   339	346	610	finally
    //   362	369	610	finally
    //   384	388	610	finally
    //   473	477	610	finally
    //   488	499	610	finally
    //   243	303	621	java/lang/Exception
    //   303	314	633	java/lang/Exception
    //   314	328	642	java/lang/Exception
    //   111	119	648	java/lang/Exception
    //   121	131	648	java/lang/Exception
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
    a(paramInt, localTbsLogInfo, paramEventType);
  }
  
  public void setInstallErrorCode(int paramInt, Throwable paramThrowable)
  {
    TbsLogReport.TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramThrowable);
    a(paramInt, localTbsLogInfo, TbsLogReport.EventType.TYPE_INSTALL);
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
    this.d = paramBoolean;
  }
  
  public TbsLogReport.TbsLogInfo tbsLogInfo()
  {
    return new TbsLogReport.TbsLogInfo(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */