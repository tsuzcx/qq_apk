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
import com.tencent.smtt.utils.m;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  private String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  private JSONArray a()
  {
    Object localObject = d().getString("tbs_download_upload", null);
    if (localObject == null) {
      return new JSONArray();
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      if (((JSONArray)localObject).length() > 5)
      {
        JSONArray localJSONArray = new JSONArray();
        int i = ((JSONArray)localObject).length() - 1;
        if (i > ((JSONArray)localObject).length() - 5)
        {
          localJSONArray.put(((JSONArray)localObject).get(i));
          return localJSONArray;
        }
      }
      return localObject;
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    return new JSONArray();
  }
  
  private void a(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt));
    localStringBuilder.append(a(b.f(this.c)));
    localStringBuilder.append(a(j.a(this.c)));
    localStringBuilder.append(a(p.a().i(this.c)));
    Object localObject1 = Build.MODEL;
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label101:
      SharedPreferences localSharedPreferences;
      int i;
      break label101;
    }
    localStringBuilder.append(a((String)localObject1));
    localObject1 = this.c.getPackageName();
    localStringBuilder.append(a((String)localObject1));
    if ("com.tencent.mm".equals(localObject1)) {
      localObject1 = a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
    } else {
      localObject1 = a(b.d(this.c));
    }
    localStringBuilder.append((String)localObject1);
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
    localStringBuilder.append(a(b.i(this.c)));
    localStringBuilder.append(a("4.3.0.73_43973"));
    localStringBuilder.append(false);
    localSharedPreferences = d();
    localObject1 = a();
    localObject2 = new JSONArray();
    paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject1;
    if (((JSONArray)localObject2).length() >= 5)
    {
      i = 4;
      while (i >= 1)
      {
        try
        {
          ((JSONArray)localObject2).put(((JSONArray)localObject1).get(((JSONArray)localObject2).length() - i));
        }
        catch (Exception paramTbsLogInfo)
        {
          label550:
          break label550;
        }
        TbsLog.e("upload", "JSONArray transform error!");
        i -= 1;
      }
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject2;
    }
    else
    {
      paramTbsLogInfo.put(localStringBuilder.toString());
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putString("tbs_download_upload", paramTbsLogInfo.toString());
      ((SharedPreferences.Editor)localObject1).commit();
      if ((this.d) || (paramInt != TbsLogReport.EventType.TYPE_LOAD.a)) {
        b();
      }
      return;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    Object localObject1;
    if ((QbSdk.n != null) && (QbSdk.n.containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (QbSdk.n.get("SET_SENDREQUEST_AND_UPLOAD").equals("false"))) {
      localObject1 = "upload";
    }
    for (Object localObject2 = "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";; localObject2 = "[TbsApkDownloadStat.reportDownloadStat] no data")
    {
      TbsLog.i((String)localObject1, (String)localObject2);
      return;
      localObject1 = "TbsDownload";
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
      localObject2 = a();
      if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[TbsApkDownloadStat.reportDownloadStat] jsonArray:");
        ((StringBuilder)localObject1).append(localObject2);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        try
        {
          localObject1 = f.a(m.a(this.c).c(), ((JSONArray)localObject2).toString().getBytes("utf-8"), new TbsLogReport.3(this), true);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[TbsApkDownloadStat.reportDownloadStat] response:");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" testcase: ");
          ((StringBuilder)localObject2).append(-1);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
      }
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
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TbsLogReport(paramContext);
        }
      }
      finally {}
    }
    return a;
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
      paramTbsLogInfo = new StringBuilder();
      paramTbsLogInfo.append("[TbsLogReport.eventReport] error, message=");
      paramTbsLogInfo.append(paramEventType.getMessage());
      TbsLog.w("upload", paramTbsLogInfo.toString());
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
    //   0: getstatic 333	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   3: ifnull +47 -> 50
    //   6: getstatic 333	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   9: ldc_w 335
    //   12: invokeinterface 340 2 0
    //   17: ifeq +33 -> 50
    //   20: getstatic 333	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   23: ldc_w 335
    //   26: invokeinterface 343 2 0
    //   31: ldc_w 345
    //   34: invokevirtual 346	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +13 -> 50
    //   40: ldc_w 262
    //   43: ldc_w 449
    //   46: invokestatic 350	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: return
    //   50: aload_0
    //   51: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   54: invokestatic 454	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   57: iconst_3
    //   58: if_icmpeq +4 -> 62
    //   61: return
    //   62: invokestatic 457	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   65: astore 6
    //   67: aload 6
    //   69: ifnonnull +4 -> 73
    //   72: return
    //   73: invokestatic 462	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   76: invokevirtual 464	com/tencent/smtt/utils/g:b	()Ljava/lang/String;
    //   79: astore 12
    //   81: aload_0
    //   82: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   85: invokestatic 131	com/tencent/smtt/utils/b:f	(Landroid/content/Context;)Ljava/lang/String;
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   93: invokestatic 253	com/tencent/smtt/utils/b:i	(Landroid/content/Context;)Ljava/lang/String;
    //   96: astore_2
    //   97: aload_3
    //   98: invokevirtual 467	java/lang/String:getBytes	()[B
    //   101: astore_3
    //   102: aload_2
    //   103: invokevirtual 467	java/lang/String:getBytes	()[B
    //   106: astore 4
    //   108: aload_3
    //   109: astore_2
    //   110: invokestatic 462	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   113: aload_3
    //   114: invokevirtual 470	com/tencent/smtt/utils/g:a	([B)[B
    //   117: astore_3
    //   118: aload_3
    //   119: astore_2
    //   120: invokestatic 462	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   123: aload 4
    //   125: invokevirtual 470	com/tencent/smtt/utils/g:a	([B)[B
    //   128: astore 5
    //   130: aload 5
    //   132: astore_2
    //   133: aload_3
    //   134: invokestatic 473	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   137: astore_3
    //   138: aload_2
    //   139: invokestatic 473	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   142: astore_2
    //   143: new 52	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   150: astore 4
    //   152: aload 4
    //   154: aload_0
    //   155: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   158: invokestatic 364	com/tencent/smtt/utils/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/m;
    //   161: invokevirtual 475	com/tencent/smtt/utils/m:e	()Ljava/lang/String;
    //   164: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 4
    //   170: aload_3
    //   171: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 4
    //   177: ldc_w 477
    //   180: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: aload_2
    //   187: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 4
    //   193: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: astore 13
    //   198: new 479	java/util/HashMap
    //   201: dup
    //   202: invokespecial 480	java/util/HashMap:<init>	()V
    //   205: astore 14
    //   207: aload 14
    //   209: ldc_w 482
    //   212: ldc_w 484
    //   215: invokeinterface 487 3 0
    //   220: pop
    //   221: aload 14
    //   223: ldc_w 489
    //   226: ldc 156
    //   228: invokeinterface 487 3 0
    //   233: pop
    //   234: aload 14
    //   236: ldc_w 491
    //   239: aload_0
    //   240: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   243: invokestatic 137	com/tencent/smtt/utils/j:a	(Landroid/content/Context;)Ljava/lang/String;
    //   246: invokeinterface 487 3 0
    //   251: pop
    //   252: aconst_null
    //   253: astore 11
    //   255: aconst_null
    //   256: astore 4
    //   258: aconst_null
    //   259: astore 10
    //   261: new 493	java/io/File
    //   264: dup
    //   265: getstatic 497	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   268: invokespecial 498	java/io/File:<init>	(Ljava/lang/String;)V
    //   271: pop
    //   272: new 52	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   279: astore_2
    //   280: aload_2
    //   281: getstatic 497	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   284: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_2
    //   289: ldc_w 500
    //   292: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: new 502	com/tencent/smtt/sdk/TbsLogReport$a
    //   299: dup
    //   300: aload 6
    //   302: aload_2
    //   303: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokespecial 504	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: invokevirtual 506	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   312: new 493	java/io/File
    //   315: dup
    //   316: getstatic 497	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   319: ldc_w 508
    //   322: invokespecial 509	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: astore_2
    //   326: new 511	java/io/FileInputStream
    //   329: dup
    //   330: aload_2
    //   331: invokespecial 514	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   334: astore_3
    //   335: sipush 8192
    //   338: newarray byte
    //   340: astore 7
    //   342: new 516	java/io/ByteArrayOutputStream
    //   345: dup
    //   346: invokespecial 517	java/io/ByteArrayOutputStream:<init>	()V
    //   349: astore 9
    //   351: aload_2
    //   352: astore 4
    //   354: aload_3
    //   355: astore 5
    //   357: aload 9
    //   359: astore 6
    //   361: aload_3
    //   362: aload 7
    //   364: invokevirtual 521	java/io/FileInputStream:read	([B)I
    //   367: istore_1
    //   368: iload_1
    //   369: iconst_m1
    //   370: if_icmpeq +25 -> 395
    //   373: aload_2
    //   374: astore 4
    //   376: aload_3
    //   377: astore 5
    //   379: aload 9
    //   381: astore 6
    //   383: aload 9
    //   385: aload 7
    //   387: iconst_0
    //   388: iload_1
    //   389: invokevirtual 525	java/io/ByteArrayOutputStream:write	([BII)V
    //   392: goto -41 -> 351
    //   395: aload_2
    //   396: astore 4
    //   398: aload_3
    //   399: astore 5
    //   401: aload 9
    //   403: astore 6
    //   405: aload 9
    //   407: invokevirtual 528	java/io/ByteArrayOutputStream:flush	()V
    //   410: aload_2
    //   411: astore 4
    //   413: aload_3
    //   414: astore 5
    //   416: aload 9
    //   418: astore 6
    //   420: invokestatic 462	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   423: aload 9
    //   425: invokevirtual 531	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   428: invokevirtual 470	com/tencent/smtt/utils/g:a	([B)[B
    //   431: astore 7
    //   433: aload_3
    //   434: invokevirtual 534	java/io/FileInputStream:close	()V
    //   437: aload 9
    //   439: invokevirtual 535	java/io/ByteArrayOutputStream:close	()V
    //   442: aload 7
    //   444: astore_3
    //   445: aload_2
    //   446: invokevirtual 538	java/io/File:delete	()Z
    //   449: pop
    //   450: goto +120 -> 570
    //   453: astore 8
    //   455: aload_3
    //   456: astore 7
    //   458: aload 9
    //   460: astore_3
    //   461: goto +63 -> 524
    //   464: astore 5
    //   466: aconst_null
    //   467: astore 6
    //   469: goto +162 -> 631
    //   472: astore 8
    //   474: aconst_null
    //   475: astore 4
    //   477: aload_3
    //   478: astore 7
    //   480: aload 4
    //   482: astore_3
    //   483: goto +41 -> 524
    //   486: astore 5
    //   488: aconst_null
    //   489: astore 6
    //   491: aload 4
    //   493: astore_3
    //   494: goto +137 -> 631
    //   497: astore 8
    //   499: goto +20 -> 519
    //   502: astore 5
    //   504: aconst_null
    //   505: astore_2
    //   506: aload_2
    //   507: astore 6
    //   509: aload 4
    //   511: astore_3
    //   512: goto +119 -> 631
    //   515: astore 8
    //   517: aconst_null
    //   518: astore_2
    //   519: aconst_null
    //   520: astore 7
    //   522: aconst_null
    //   523: astore_3
    //   524: aload_2
    //   525: astore 4
    //   527: aload 7
    //   529: astore 5
    //   531: aload_3
    //   532: astore 6
    //   534: aload 8
    //   536: invokevirtual 539	java/lang/Exception:printStackTrace	()V
    //   539: aload 7
    //   541: ifnull +8 -> 549
    //   544: aload 7
    //   546: invokevirtual 534	java/io/FileInputStream:close	()V
    //   549: aload_3
    //   550: ifnull +7 -> 557
    //   553: aload_3
    //   554: invokevirtual 535	java/io/ByteArrayOutputStream:close	()V
    //   557: aload 11
    //   559: astore_3
    //   560: aload_2
    //   561: ifnull +9 -> 570
    //   564: aload 10
    //   566: astore_3
    //   567: goto -122 -> 445
    //   570: new 52	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   577: astore_2
    //   578: aload_2
    //   579: aload 13
    //   581: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload_2
    //   586: ldc_w 541
    //   589: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_2
    //   594: aload 12
    //   596: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload_2
    //   601: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: aload 14
    //   606: aload_3
    //   607: new 543	com/tencent/smtt/sdk/TbsLogReport$2
    //   610: dup
    //   611: aload_0
    //   612: invokespecial 544	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   615: iconst_0
    //   616: invokestatic 547	com/tencent/smtt/utils/f:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/f$a;Z)Ljava/lang/String;
    //   619: pop
    //   620: return
    //   621: astore_2
    //   622: aload 5
    //   624: astore_3
    //   625: aload_2
    //   626: astore 5
    //   628: aload 4
    //   630: astore_2
    //   631: aload_3
    //   632: ifnull +7 -> 639
    //   635: aload_3
    //   636: invokevirtual 534	java/io/FileInputStream:close	()V
    //   639: aload 6
    //   641: ifnull +8 -> 649
    //   644: aload 6
    //   646: invokevirtual 535	java/io/ByteArrayOutputStream:close	()V
    //   649: aload_2
    //   650: ifnull +8 -> 658
    //   653: aload_2
    //   654: invokevirtual 538	java/io/File:delete	()Z
    //   657: pop
    //   658: goto +6 -> 664
    //   661: aload 5
    //   663: athrow
    //   664: goto -3 -> 661
    //   667: astore_3
    //   668: aload_2
    //   669: astore_3
    //   670: aload 4
    //   672: astore_2
    //   673: goto -540 -> 133
    //   676: astore_3
    //   677: goto -240 -> 437
    //   680: astore_3
    //   681: aload 7
    //   683: astore_3
    //   684: goto -239 -> 445
    //   687: astore 4
    //   689: goto -140 -> 549
    //   692: astore_3
    //   693: goto -136 -> 557
    //   696: astore_3
    //   697: goto -58 -> 639
    //   700: astore_3
    //   701: goto -52 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	TbsLogReport
    //   367	22	1	i	int
    //   96	505	2	localObject1	Object
    //   621	5	2	localObject2	Object
    //   630	43	2	localObject3	Object
    //   88	548	3	localObject4	Object
    //   667	1	3	localException1	Exception
    //   669	1	3	localObject5	Object
    //   676	1	3	localException2	Exception
    //   680	1	3	localException3	Exception
    //   683	1	3	localObject6	Object
    //   692	1	3	localException4	Exception
    //   696	1	3	localException5	Exception
    //   700	1	3	localException6	Exception
    //   106	565	4	localObject7	Object
    //   687	1	4	localException7	Exception
    //   128	287	5	localObject8	Object
    //   464	1	5	localObject9	Object
    //   486	1	5	localObject10	Object
    //   502	1	5	localObject11	Object
    //   529	133	5	localObject12	Object
    //   65	580	6	localObject13	Object
    //   340	342	7	localObject14	Object
    //   453	1	8	localException8	Exception
    //   472	1	8	localException9	Exception
    //   497	1	8	localException10	Exception
    //   515	20	8	localException11	Exception
    //   349	110	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   259	306	10	localObject15	Object
    //   253	305	11	localObject16	Object
    //   79	516	12	str1	String
    //   196	384	13	str2	String
    //   205	400	14	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   361	368	453	java/lang/Exception
    //   383	392	453	java/lang/Exception
    //   405	410	453	java/lang/Exception
    //   420	433	453	java/lang/Exception
    //   335	351	464	finally
    //   335	351	472	java/lang/Exception
    //   326	335	486	finally
    //   326	335	497	java/lang/Exception
    //   261	326	502	finally
    //   261	326	515	java/lang/Exception
    //   361	368	621	finally
    //   383	392	621	finally
    //   405	410	621	finally
    //   420	433	621	finally
    //   534	539	621	finally
    //   110	118	667	java/lang/Exception
    //   120	130	667	java/lang/Exception
    //   433	437	676	java/lang/Exception
    //   437	442	680	java/lang/Exception
    //   544	549	687	java/lang/Exception
    //   553	557	692	java/lang/Exception
    //   635	639	696	java/lang/Exception
    //   644	649	700	java/lang/Exception
  }
  
  public void setInstallErrorCode(int paramInt, String paramString)
  {
    setInstallErrorCode(paramInt, paramString, TbsLogReport.EventType.TYPE_INSTALL);
  }
  
  public void setInstallErrorCode(int paramInt, String paramString, TbsLogReport.EventType paramEventType)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error occured in installation, errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString(), true);
    }
    Object localObject = tbsLogInfo();
    ((TbsLogReport.TbsLogInfo)localObject).setFailDetail(paramString);
    a(paramInt, (TbsLogReport.TbsLogInfo)localObject, paramEventType);
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
    if (paramThrowable != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg: ");
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      ((StringBuilder)localObject).append("; err: ");
      ((StringBuilder)localObject).append(paramThrowable);
      ((StringBuilder)localObject).append("; cause: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramThrowable.getCause()));
      localObject = ((StringBuilder)localObject).toString();
      paramThrowable = (Throwable)localObject;
      if (((String)localObject).length() > 1024) {
        paramThrowable = ((String)localObject).substring(0, 1024);
      }
    }
    else
    {
      paramThrowable = "NULL";
    }
    setLoadErrorCode(paramInt, paramThrowable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */