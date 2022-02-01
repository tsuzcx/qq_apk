package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.Base64;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.q;
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
    Object localObject3 = d().getString("tbs_download_upload", null);
    Object localObject1 = localObject3;
    Object localObject2;
    if (localObject3 != null) {
      try
      {
        localObject1 = new String(Base64.a((String)localObject3, 2));
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        localObject2 = localObject3;
      }
    }
    if (localObject2 == null) {
      return new JSONArray();
    }
    try
    {
      localObject2 = new JSONArray((String)localObject2);
      if (((JSONArray)localObject2).length() > 5)
      {
        localObject3 = new JSONArray();
        int i = ((JSONArray)localObject2).length() - 1;
        if (i > ((JSONArray)localObject2).length() - 5)
        {
          ((JSONArray)localObject3).put(((JSONArray)localObject2).get(i));
          return localObject3;
        }
      }
      return localObject2;
    }
    catch (Exception localException)
    {
      label110:
      break label110;
    }
    return new JSONArray();
  }
  
  private void a(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    if ((QbSdk.n != null) && (QbSdk.n.containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (QbSdk.n.get("SET_SENDREQUEST_AND_UPLOAD").equals("false")))
    {
      TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt));
    if (b.g(this.c)) {
      localStringBuilder.append(a(b.h(this.c)));
    }
    localStringBuilder.append(a(k.a(this.c)));
    localStringBuilder.append(a(p.a().j(this.c)));
    Object localObject1 = q.d(this.c);
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label160:
      SharedPreferences localSharedPreferences;
      int i;
      break label160;
    }
    localStringBuilder.append(a((String)localObject1));
    localObject1 = this.c.getPackageName();
    localStringBuilder.append(a((String)localObject1));
    if ("com.tencent.mm".equals(localObject1)) {
      localObject1 = a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
    } else {
      localObject1 = a(b.e(this.c));
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
    localStringBuilder.append(a(b.k(this.c)));
    localStringBuilder.append(a("4.3.0.169_44069"));
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
          label611:
          break label611;
        }
        TbsLog.e("upload", "JSONArray transform error!");
        i -= 1;
      }
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject2;
    }
    else
    {
      paramTbsLogInfo.put(localStringBuilder.toString());
      localObject2 = localSharedPreferences.edit();
      paramTbsLogInfo = paramTbsLogInfo.toString();
      try
      {
        localObject1 = Base64.encodeToString(paramTbsLogInfo.getBytes(), 2);
        paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      ((SharedPreferences.Editor)localObject2).putString("tbs_download_upload", paramTbsLogInfo);
      ((SharedPreferences.Editor)localObject2).commit();
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
          localObject1 = f.a(n.a(this.c).c(), ((JSONArray)localObject2).toString().getBytes("utf-8"), new TbsLogReport.3(this), true);
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
    //   0: getstatic 144	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   3: ifnull +43 -> 46
    //   6: getstatic 144	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   9: ldc 146
    //   11: invokeinterface 152 2 0
    //   16: ifeq +30 -> 46
    //   19: getstatic 144	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   22: ldc 146
    //   24: invokeinterface 155 2 0
    //   29: ldc 157
    //   31: invokevirtual 160	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +12 -> 46
    //   37: ldc 162
    //   39: ldc_w 465
    //   42: invokestatic 170	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: return
    //   46: aload_0
    //   47: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   50: invokestatic 470	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   53: iconst_3
    //   54: if_icmpeq +4 -> 58
    //   57: return
    //   58: invokestatic 473	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   61: astore 6
    //   63: aload 6
    //   65: ifnonnull +4 -> 69
    //   68: return
    //   69: invokestatic 478	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   72: invokevirtual 480	com/tencent/smtt/utils/g:b	()Ljava/lang/String;
    //   75: astore 12
    //   77: aload_0
    //   78: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   81: invokestatic 178	com/tencent/smtt/utils/b:g	(Landroid/content/Context;)Z
    //   84: ifeq +14 -> 98
    //   87: aload_0
    //   88: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   91: invokestatic 182	com/tencent/smtt/utils/b:h	(Landroid/content/Context;)Ljava/lang/String;
    //   94: astore_2
    //   95: goto +6 -> 101
    //   98: ldc 94
    //   100: astore_2
    //   101: aload_0
    //   102: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   105: invokestatic 294	com/tencent/smtt/utils/b:k	(Landroid/content/Context;)Ljava/lang/String;
    //   108: astore 4
    //   110: aload_2
    //   111: invokevirtual 313	java/lang/String:getBytes	()[B
    //   114: astore_3
    //   115: aload 4
    //   117: invokevirtual 313	java/lang/String:getBytes	()[B
    //   120: astore 4
    //   122: aload_3
    //   123: astore_2
    //   124: invokestatic 478	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   127: aload_3
    //   128: invokevirtual 483	com/tencent/smtt/utils/g:a	([B)[B
    //   131: astore_3
    //   132: aload_3
    //   133: astore_2
    //   134: invokestatic 478	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   137: aload 4
    //   139: invokevirtual 483	com/tencent/smtt/utils/g:a	([B)[B
    //   142: astore 5
    //   144: aload 5
    //   146: astore_2
    //   147: aload_3
    //   148: invokestatic 486	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   151: astore_3
    //   152: aload_2
    //   153: invokestatic 486	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   156: astore_2
    //   157: new 52	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   164: astore 4
    //   166: aload 4
    //   168: aload_0
    //   169: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   172: invokestatic 383	com/tencent/smtt/utils/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/n;
    //   175: invokevirtual 488	com/tencent/smtt/utils/n:h	()Ljava/lang/String;
    //   178: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: aload_3
    //   185: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 4
    //   191: ldc_w 490
    //   194: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: aload_2
    //   201: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 4
    //   207: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 13
    //   212: new 492	java/util/HashMap
    //   215: dup
    //   216: invokespecial 493	java/util/HashMap:<init>	()V
    //   219: astore 14
    //   221: aload 14
    //   223: ldc_w 495
    //   226: ldc_w 497
    //   229: invokeinterface 500 3 0
    //   234: pop
    //   235: aload 14
    //   237: ldc_w 502
    //   240: ldc 203
    //   242: invokeinterface 500 3 0
    //   247: pop
    //   248: aload 14
    //   250: ldc_w 504
    //   253: aload_0
    //   254: getfield 29	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   257: invokestatic 188	com/tencent/smtt/utils/k:a	(Landroid/content/Context;)Ljava/lang/String;
    //   260: invokeinterface 500 3 0
    //   265: pop
    //   266: aconst_null
    //   267: astore 11
    //   269: aconst_null
    //   270: astore 4
    //   272: aconst_null
    //   273: astore 10
    //   275: new 506	java/io/File
    //   278: dup
    //   279: getstatic 511	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   282: invokespecial 512	java/io/File:<init>	(Ljava/lang/String;)V
    //   285: pop
    //   286: new 52	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   293: astore_2
    //   294: aload_2
    //   295: getstatic 511	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   298: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_2
    //   303: ldc_w 514
    //   306: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: new 516	com/tencent/smtt/sdk/TbsLogReport$a
    //   313: dup
    //   314: aload 6
    //   316: aload_2
    //   317: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokespecial 518	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: invokevirtual 520	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   326: new 506	java/io/File
    //   329: dup
    //   330: getstatic 511	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   333: ldc_w 522
    //   336: invokespecial 523	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: astore_2
    //   340: new 525	java/io/FileInputStream
    //   343: dup
    //   344: aload_2
    //   345: invokespecial 528	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   348: astore_3
    //   349: sipush 8192
    //   352: newarray byte
    //   354: astore 7
    //   356: new 530	java/io/ByteArrayOutputStream
    //   359: dup
    //   360: invokespecial 531	java/io/ByteArrayOutputStream:<init>	()V
    //   363: astore 9
    //   365: aload_2
    //   366: astore 4
    //   368: aload_3
    //   369: astore 5
    //   371: aload 9
    //   373: astore 6
    //   375: aload_3
    //   376: aload 7
    //   378: invokevirtual 535	java/io/FileInputStream:read	([B)I
    //   381: istore_1
    //   382: iload_1
    //   383: iconst_m1
    //   384: if_icmpeq +25 -> 409
    //   387: aload_2
    //   388: astore 4
    //   390: aload_3
    //   391: astore 5
    //   393: aload 9
    //   395: astore 6
    //   397: aload 9
    //   399: aload 7
    //   401: iconst_0
    //   402: iload_1
    //   403: invokevirtual 539	java/io/ByteArrayOutputStream:write	([BII)V
    //   406: goto -41 -> 365
    //   409: aload_2
    //   410: astore 4
    //   412: aload_3
    //   413: astore 5
    //   415: aload 9
    //   417: astore 6
    //   419: aload 9
    //   421: invokevirtual 542	java/io/ByteArrayOutputStream:flush	()V
    //   424: aload_2
    //   425: astore 4
    //   427: aload_3
    //   428: astore 5
    //   430: aload 9
    //   432: astore 6
    //   434: invokestatic 478	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   437: aload 9
    //   439: invokevirtual 545	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   442: invokevirtual 483	com/tencent/smtt/utils/g:a	([B)[B
    //   445: astore 7
    //   447: aload_3
    //   448: invokevirtual 548	java/io/FileInputStream:close	()V
    //   451: aload 9
    //   453: invokevirtual 549	java/io/ByteArrayOutputStream:close	()V
    //   456: aload 7
    //   458: astore_3
    //   459: aload_2
    //   460: invokevirtual 552	java/io/File:delete	()Z
    //   463: pop
    //   464: goto +120 -> 584
    //   467: astore 8
    //   469: aload_3
    //   470: astore 7
    //   472: aload 9
    //   474: astore_3
    //   475: goto +63 -> 538
    //   478: astore 5
    //   480: aconst_null
    //   481: astore 6
    //   483: goto +162 -> 645
    //   486: astore 8
    //   488: aconst_null
    //   489: astore 4
    //   491: aload_3
    //   492: astore 7
    //   494: aload 4
    //   496: astore_3
    //   497: goto +41 -> 538
    //   500: astore 5
    //   502: aconst_null
    //   503: astore 6
    //   505: aload 4
    //   507: astore_3
    //   508: goto +137 -> 645
    //   511: astore 8
    //   513: goto +20 -> 533
    //   516: astore 5
    //   518: aconst_null
    //   519: astore_2
    //   520: aload_2
    //   521: astore 6
    //   523: aload 4
    //   525: astore_3
    //   526: goto +119 -> 645
    //   529: astore 8
    //   531: aconst_null
    //   532: astore_2
    //   533: aconst_null
    //   534: astore 7
    //   536: aconst_null
    //   537: astore_3
    //   538: aload_2
    //   539: astore 4
    //   541: aload 7
    //   543: astore 5
    //   545: aload_3
    //   546: astore 6
    //   548: aload 8
    //   550: invokevirtual 553	java/lang/Exception:printStackTrace	()V
    //   553: aload 7
    //   555: ifnull +8 -> 563
    //   558: aload 7
    //   560: invokevirtual 548	java/io/FileInputStream:close	()V
    //   563: aload_3
    //   564: ifnull +7 -> 571
    //   567: aload_3
    //   568: invokevirtual 549	java/io/ByteArrayOutputStream:close	()V
    //   571: aload 11
    //   573: astore_3
    //   574: aload_2
    //   575: ifnull +9 -> 584
    //   578: aload 10
    //   580: astore_3
    //   581: goto -122 -> 459
    //   584: new 52	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   591: astore_2
    //   592: aload_2
    //   593: aload 13
    //   595: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload_2
    //   600: ldc_w 555
    //   603: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_2
    //   608: aload 12
    //   610: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_2
    //   615: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: aload 14
    //   620: aload_3
    //   621: new 557	com/tencent/smtt/sdk/TbsLogReport$2
    //   624: dup
    //   625: aload_0
    //   626: invokespecial 558	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   629: iconst_0
    //   630: invokestatic 561	com/tencent/smtt/utils/f:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/f$a;Z)Ljava/lang/String;
    //   633: pop
    //   634: return
    //   635: astore_2
    //   636: aload 5
    //   638: astore_3
    //   639: aload_2
    //   640: astore 5
    //   642: aload 4
    //   644: astore_2
    //   645: aload_3
    //   646: ifnull +7 -> 653
    //   649: aload_3
    //   650: invokevirtual 548	java/io/FileInputStream:close	()V
    //   653: aload 6
    //   655: ifnull +8 -> 663
    //   658: aload 6
    //   660: invokevirtual 549	java/io/ByteArrayOutputStream:close	()V
    //   663: aload_2
    //   664: ifnull +8 -> 672
    //   667: aload_2
    //   668: invokevirtual 552	java/io/File:delete	()Z
    //   671: pop
    //   672: goto +6 -> 678
    //   675: aload 5
    //   677: athrow
    //   678: goto -3 -> 675
    //   681: astore_3
    //   682: aload_2
    //   683: astore_3
    //   684: aload 4
    //   686: astore_2
    //   687: goto -540 -> 147
    //   690: astore_3
    //   691: goto -240 -> 451
    //   694: astore_3
    //   695: aload 7
    //   697: astore_3
    //   698: goto -239 -> 459
    //   701: astore 4
    //   703: goto -140 -> 563
    //   706: astore_3
    //   707: goto -136 -> 571
    //   710: astore_3
    //   711: goto -58 -> 653
    //   714: astore_3
    //   715: goto -52 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	TbsLogReport
    //   381	22	1	i	int
    //   94	521	2	localObject1	Object
    //   635	5	2	localObject2	Object
    //   644	43	2	localObject3	Object
    //   114	536	3	localObject4	Object
    //   681	1	3	localException1	Exception
    //   683	1	3	localObject5	Object
    //   690	1	3	localException2	Exception
    //   694	1	3	localException3	Exception
    //   697	1	3	localObject6	Object
    //   706	1	3	localException4	Exception
    //   710	1	3	localException5	Exception
    //   714	1	3	localException6	Exception
    //   108	577	4	localObject7	Object
    //   701	1	4	localException7	Exception
    //   142	287	5	localObject8	Object
    //   478	1	5	localObject9	Object
    //   500	1	5	localObject10	Object
    //   516	1	5	localObject11	Object
    //   543	133	5	localObject12	Object
    //   61	598	6	localObject13	Object
    //   354	342	7	localObject14	Object
    //   467	1	8	localException8	Exception
    //   486	1	8	localException9	Exception
    //   511	1	8	localException10	Exception
    //   529	20	8	localException11	Exception
    //   363	110	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   273	306	10	localObject15	Object
    //   267	305	11	localObject16	Object
    //   75	534	12	str1	String
    //   210	384	13	str2	String
    //   219	400	14	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   375	382	467	java/lang/Exception
    //   397	406	467	java/lang/Exception
    //   419	424	467	java/lang/Exception
    //   434	447	467	java/lang/Exception
    //   349	365	478	finally
    //   349	365	486	java/lang/Exception
    //   340	349	500	finally
    //   340	349	511	java/lang/Exception
    //   275	340	516	finally
    //   275	340	529	java/lang/Exception
    //   375	382	635	finally
    //   397	406	635	finally
    //   419	424	635	finally
    //   434	447	635	finally
    //   548	553	635	finally
    //   124	132	681	java/lang/Exception
    //   134	144	681	java/lang/Exception
    //   447	451	690	java/lang/Exception
    //   451	456	694	java/lang/Exception
    //   558	563	701	java/lang/Exception
    //   567	571	706	java/lang/Exception
    //   649	653	710	java/lang/Exception
    //   658	663	714	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */