package com.tencent.mobileqq.unifiedebug;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class UnifiedDebugManager
{
  public Map<String, String> a;
  public Handler b;
  ResultReceiver c;
  final Queue<UnifiedDebugManager.Command> d = new LinkedList();
  
  public UnifiedDebugManager(SnapshotResultReceiver paramSnapshotResultReceiver)
  {
    this.c = paramSnapshotResultReceiver;
    paramSnapshotResultReceiver = ThreadManager.newFreeHandlerThread("UnifiedDebugMonitor", 0);
    paramSnapshotResultReceiver.start();
    this.b = new Handler(paramSnapshotResultReceiver.getLooper());
    this.a = new HashMap();
    this.a.put("offline_pkg", OfflineEnvHelper.b());
  }
  
  public static void a(Application paramApplication)
  {
    SharedPreferences localSharedPreferences = paramApplication.getSharedPreferences("x5_proxy_setting", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.remove("http_proxy_address");
    localEditor.putBoolean("post_encription", true);
    localEditor.remove("qproxy_address");
    localEditor.putInt("connect_status", 0);
    localEditor.remove("qproxy_address_lists");
    localEditor.putBoolean("is_in_proxy", false);
    localEditor.putBoolean("need_set_proxy", true);
    localEditor.commit();
    f(paramApplication);
    ThreadManager.getFileThreadHandler().postDelayed(new UnifiedDebugManager.6(paramApplication), 2000L);
    if (QLog.isColorLevel())
    {
      QLog.d("UnifiedDebugManager", 2, "unset x5 proxy");
      paramApplication = new StringBuilder();
      paramApplication.append("http_proxy_address: ");
      paramApplication.append(localSharedPreferences.getString("http_proxy_address", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, paramApplication.toString());
      paramApplication = new StringBuilder();
      paramApplication.append("qproxy_address_lists: ");
      paramApplication.append(localSharedPreferences.getString("qproxy_address_lists", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, paramApplication.toString());
    }
  }
  
  public static void a(Application paramApplication, String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramApplication.getSharedPreferences("x5_proxy_setting", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localEditor.putString("http_proxy_address", localStringBuilder.toString());
    localEditor.putBoolean("post_encription", false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localEditor.putString("qproxy_address", localStringBuilder.toString());
    localEditor.putInt("connect_status", 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localEditor.putString("qproxy_address_lists", localStringBuilder.toString());
    localEditor.putBoolean("is_in_proxy", true);
    localEditor.putBoolean("need_set_proxy", true);
    localEditor.commit();
    Utils.a(paramApplication, "com.tencent.mobileqq:tool");
    if (QLog.isColorLevel())
    {
      paramApplication = new StringBuilder();
      paramApplication.append("set x5 proxy: ");
      paramApplication.append(paramString);
      paramApplication.append(":");
      paramApplication.append(paramInt);
      QLog.d("UnifiedDebugManager", 2, paramApplication.toString());
      paramApplication = new StringBuilder();
      paramApplication.append("http_proxy_address: ");
      paramApplication.append(localSharedPreferences.getString("http_proxy_address", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, paramApplication.toString());
      paramApplication = new StringBuilder();
      paramApplication.append("qproxy_address_lists: ");
      paramApplication.append(localSharedPreferences.getString("qproxy_address_lists", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, paramApplication.toString());
      paramApplication = new StringBuilder();
      paramApplication.append("sQQBrowserActivityCounter =  ");
      paramApplication.append(QQBrowserActivity.sQQBrowserActivityCounter);
      QLog.d("UnifiedDebugManager", 2, paramApplication.toString());
    }
  }
  
  static boolean b(Application paramApplication)
  {
    Object localObject = ((ActivityManager)paramApplication.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        String str = localRunningAppProcessInfo.processName;
        if ((str.startsWith("com.tencent.mobileqq")) && (str.indexOf(':') != -1) && (str.endsWith(":tool"))) {
          if ((localRunningAppProcessInfo.importance != 100) && ((localRunningAppProcessInfo.importance != 200) || ((localRunningAppProcessInfo.importance == 200) && (localRunningAppProcessInfo.importanceReasonCode != 0))))
          {
            Utils.a(paramApplication, "com.tencent.mobileqq:tool");
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static void f(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.ultimatesnapshot");
    localIntent.putExtra("action", 1);
    localIntent.putExtra("id", 0L);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "send broadcast to finish all alive webview");
    }
  }
  
  public static boolean g(Context paramContext)
  {
    return paramContext.getSharedPreferences("x5_proxy_setting", 4).contains("http_proxy_address");
  }
  
  public Handler a()
  {
    return this.b;
  }
  
  public UnifiedDebugManager.TerminalInfo a(Context paramContext)
  {
    UnifiedDebugManager.TerminalInfo localTerminalInfo = new UnifiedDebugManager.TerminalInfo(this);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(DeviceInfoUtil.t());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(DeviceInfoUtil.f());
    localTerminalInfo.a = ((StringBuilder)localObject).toString();
    localTerminalInfo.b = Build.VERSION.RELEASE;
    localTerminalInfo.c = "8.8.17.5770";
    localObject = DeviceInfoUtil.f(paramContext);
    localTerminalInfo.d = ((DeviceInfoUtil.NetInfo)localObject).a;
    localTerminalInfo.e = ((DeviceInfoUtil.NetInfo)localObject).c;
    localTerminalInfo.f = DeviceInfoUtil.h();
    localTerminalInfo.g = DeviceInfoUtil.k();
    localTerminalInfo.h = DeviceInfoUtil.a();
    localTerminalInfo.i = DeviceInfoUtil.m();
    localTerminalInfo.j = g(paramContext);
    localTerminalInfo.l = QbSdk.getTbsVersion(paramContext);
    boolean bool;
    if (localTerminalInfo.l == 0) {
      bool = false;
    } else {
      bool = true;
    }
    localTerminalInfo.k = bool;
    return localTerminalInfo;
  }
  
  /* Error */
  public String a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 378	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   3: astore 19
    //   5: aload 19
    //   7: lload_1
    //   8: invokevirtual 382	java/util/Calendar:setTimeInMillis	(J)V
    //   11: invokestatic 378	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   14: astore 20
    //   16: aload 20
    //   18: lload_3
    //   19: invokevirtual 382	java/util/Calendar:setTimeInMillis	(J)V
    //   22: invokestatic 387	java/lang/System:currentTimeMillis	()J
    //   25: lstore 16
    //   27: lload_3
    //   28: lload 16
    //   30: lcmp
    //   31: iflt +10 -> 41
    //   34: aload 20
    //   36: lload 16
    //   38: invokevirtual 382	java/util/Calendar:setTimeInMillis	(J)V
    //   41: aload 19
    //   43: iconst_1
    //   44: invokevirtual 390	java/util/Calendar:get	(I)I
    //   47: istore 9
    //   49: aload 19
    //   51: iconst_2
    //   52: invokevirtual 390	java/util/Calendar:get	(I)I
    //   55: istore 10
    //   57: aload 19
    //   59: iconst_5
    //   60: invokevirtual 390	java/util/Calendar:get	(I)I
    //   63: istore 11
    //   65: aload 19
    //   67: bipush 10
    //   69: invokevirtual 390	java/util/Calendar:get	(I)I
    //   72: istore 12
    //   74: aload 20
    //   76: iconst_1
    //   77: invokevirtual 390	java/util/Calendar:get	(I)I
    //   80: istore 13
    //   82: aload 20
    //   84: iconst_2
    //   85: invokevirtual 390	java/util/Calendar:get	(I)I
    //   88: istore 14
    //   90: aload 20
    //   92: iconst_5
    //   93: invokevirtual 390	java/util/Calendar:get	(I)I
    //   96: istore 15
    //   98: aload 20
    //   100: bipush 10
    //   102: invokevirtual 390	java/util/Calendar:get	(I)I
    //   105: istore 5
    //   107: new 392	java/util/HashSet
    //   110: dup
    //   111: invokespecial 393	java/util/HashSet:<init>	()V
    //   114: astore 23
    //   116: iconst_0
    //   117: istore 7
    //   119: invokestatic 397	com/tencent/qphone/base/util/QLog:getLogFileFormatter	()Ljava/text/SimpleDateFormat;
    //   122: lload_1
    //   123: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: invokevirtual 409	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore 19
    //   131: aload 23
    //   133: aload 19
    //   135: invokevirtual 413	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: iload 7
    //   141: istore 6
    //   143: iload 7
    //   145: ifne +10 -> 155
    //   148: aload 19
    //   150: invokevirtual 416	java/lang/String:length	()I
    //   153: istore 6
    //   155: lload_1
    //   156: ldc2_w 417
    //   159: ladd
    //   160: lstore_1
    //   161: lload_1
    //   162: lload_3
    //   163: lcmp
    //   164: ifle +774 -> 938
    //   167: new 420	java/util/ArrayList
    //   170: dup
    //   171: invokespecial 421	java/util/ArrayList:<init>	()V
    //   174: astore 24
    //   176: new 423	java/io/File
    //   179: dup
    //   180: invokestatic 426	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   183: invokespecial 427	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: astore 25
    //   188: aload 25
    //   190: invokevirtual 430	java/io/File:exists	()Z
    //   193: istore 18
    //   195: ldc_w 432
    //   198: astore 19
    //   200: iload 18
    //   202: ifeq +199 -> 401
    //   205: aload 25
    //   207: invokevirtual 436	java/io/File:listFiles	()[Ljava/io/File;
    //   210: astore 21
    //   212: aload 19
    //   214: astore 20
    //   216: aload 21
    //   218: ifnull +176 -> 394
    //   221: aload 21
    //   223: arraylength
    //   224: istore 7
    //   226: iconst_0
    //   227: istore 8
    //   229: aload 19
    //   231: astore 20
    //   233: iload 8
    //   235: iload 7
    //   237: if_icmpge +157 -> 394
    //   240: aload 21
    //   242: iload 8
    //   244: aaload
    //   245: astore 26
    //   247: aload 26
    //   249: invokevirtual 439	java/io/File:getName	()Ljava/lang/String;
    //   252: astore 22
    //   254: aload 22
    //   256: aload 19
    //   258: invokevirtual 248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   261: ifeq +6 -> 267
    //   264: goto +121 -> 385
    //   267: aload 22
    //   269: ldc_w 441
    //   272: invokevirtual 248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   275: ifeq +21 -> 296
    //   278: aload 22
    //   280: iconst_0
    //   281: aload 22
    //   283: invokevirtual 416	java/lang/String:length	()I
    //   286: iconst_4
    //   287: isub
    //   288: invokevirtual 445	java/lang/String:substring	(II)Ljava/lang/String;
    //   291: astore 20
    //   293: goto +36 -> 329
    //   296: aload 22
    //   298: astore 20
    //   300: aload 22
    //   302: ldc_w 447
    //   305: invokevirtual 248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   308: ifeq +21 -> 329
    //   311: aload 22
    //   313: iconst_0
    //   314: aload 22
    //   316: invokevirtual 416	java/lang/String:length	()I
    //   319: iconst_5
    //   320: isub
    //   321: invokevirtual 445	java/lang/String:substring	(II)Ljava/lang/String;
    //   324: astore 20
    //   326: goto +3 -> 329
    //   329: aload 20
    //   331: ldc 233
    //   333: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   336: ifeq +49 -> 385
    //   339: aload 20
    //   341: aload 20
    //   343: invokevirtual 416	java/lang/String:length	()I
    //   346: iload 6
    //   348: isub
    //   349: invokevirtual 450	java/lang/String:substring	(I)Ljava/lang/String;
    //   352: astore 20
    //   354: aload 20
    //   356: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   359: ifne +26 -> 385
    //   362: aload 23
    //   364: aload 20
    //   366: invokevirtual 458	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   369: ifeq +16 -> 385
    //   372: aload 24
    //   374: aload 26
    //   376: invokevirtual 461	java/io/File:getPath	()Ljava/lang/String;
    //   379: invokeinterface 462 2 0
    //   384: pop
    //   385: iload 8
    //   387: iconst_1
    //   388: iadd
    //   389: istore 8
    //   391: goto -162 -> 229
    //   394: aload 20
    //   396: astore 21
    //   398: goto +14 -> 412
    //   401: ldc_w 432
    //   404: astore 21
    //   406: aload 25
    //   408: invokevirtual 465	java/io/File:mkdirs	()Z
    //   411: pop
    //   412: aload 25
    //   414: invokevirtual 430	java/io/File:exists	()Z
    //   417: istore 18
    //   419: aconst_null
    //   420: astore 22
    //   422: aconst_null
    //   423: astore 19
    //   425: iload 18
    //   427: ifeq +283 -> 710
    //   430: new 423	java/io/File
    //   433: dup
    //   434: aload 25
    //   436: ldc_w 467
    //   439: invokespecial 470	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   442: astore 23
    //   444: new 472	java/io/BufferedWriter
    //   447: dup
    //   448: new 474	java/io/OutputStreamWriter
    //   451: dup
    //   452: new 476	java/io/FileOutputStream
    //   455: dup
    //   456: aload 23
    //   458: invokespecial 479	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   461: invokespecial 482	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   464: invokespecial 485	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   467: astore 20
    //   469: aload 25
    //   471: invokevirtual 436	java/io/File:listFiles	()[Ljava/io/File;
    //   474: astore 19
    //   476: aload 19
    //   478: ifnull +73 -> 551
    //   481: aload 19
    //   483: arraylength
    //   484: istore 7
    //   486: iconst_0
    //   487: istore 6
    //   489: iload 6
    //   491: iload 7
    //   493: if_icmpge +58 -> 551
    //   496: aload 19
    //   498: iload 6
    //   500: aaload
    //   501: astore 22
    //   503: new 150	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   510: astore 25
    //   512: aload 25
    //   514: aload 22
    //   516: invokevirtual 439	java/io/File:getName	()Ljava/lang/String;
    //   519: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 25
    //   525: ldc_w 487
    //   528: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 20
    //   534: aload 25
    //   536: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokevirtual 490	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   542: iload 6
    //   544: iconst_1
    //   545: iadd
    //   546: istore 6
    //   548: goto -59 -> 489
    //   551: aload 20
    //   553: invokevirtual 493	java/io/BufferedWriter:flush	()V
    //   556: aload 20
    //   558: invokevirtual 496	java/io/BufferedWriter:close	()V
    //   561: aload 23
    //   563: astore 19
    //   565: goto +148 -> 713
    //   568: astore 19
    //   570: ldc 143
    //   572: iconst_1
    //   573: ldc_w 498
    //   576: aload 19
    //   578: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   581: aload 23
    //   583: astore 19
    //   585: goto +128 -> 713
    //   588: astore 19
    //   590: goto +91 -> 681
    //   593: astore 22
    //   595: goto +30 -> 625
    //   598: astore 20
    //   600: aload 19
    //   602: astore 21
    //   604: aload 20
    //   606: astore 19
    //   608: aload 21
    //   610: astore 20
    //   612: goto +69 -> 681
    //   615: astore 19
    //   617: aload 22
    //   619: astore 20
    //   621: aload 19
    //   623: astore 22
    //   625: aload 20
    //   627: astore 19
    //   629: ldc 143
    //   631: iconst_1
    //   632: ldc_w 503
    //   635: aload 22
    //   637: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   640: aload 23
    //   642: astore 19
    //   644: aload 20
    //   646: ifnull +67 -> 713
    //   649: aload 20
    //   651: invokevirtual 496	java/io/BufferedWriter:close	()V
    //   654: aload 23
    //   656: astore 19
    //   658: goto +55 -> 713
    //   661: astore 19
    //   663: ldc 143
    //   665: iconst_1
    //   666: ldc_w 498
    //   669: aload 19
    //   671: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   674: aload 23
    //   676: astore 19
    //   678: goto +35 -> 713
    //   681: aload 20
    //   683: ifnull +24 -> 707
    //   686: aload 20
    //   688: invokevirtual 496	java/io/BufferedWriter:close	()V
    //   691: goto +16 -> 707
    //   694: astore 20
    //   696: ldc 143
    //   698: iconst_1
    //   699: ldc_w 498
    //   702: aload 20
    //   704: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   707: aload 19
    //   709: athrow
    //   710: aconst_null
    //   711: astore 19
    //   713: aload 19
    //   715: ifnull +16 -> 731
    //   718: aload 24
    //   720: aload 19
    //   722: invokevirtual 461	java/io/File:getPath	()Ljava/lang/String;
    //   725: invokeinterface 462 2 0
    //   730: pop
    //   731: new 423	java/io/File
    //   734: dup
    //   735: ldc_w 505
    //   738: invokespecial 427	java/io/File:<init>	(Ljava/lang/String;)V
    //   741: astore 19
    //   743: aload 19
    //   745: invokevirtual 430	java/io/File:exists	()Z
    //   748: ifeq +16 -> 764
    //   751: aload 24
    //   753: aload 19
    //   755: invokevirtual 461	java/io/File:getPath	()Ljava/lang/String;
    //   758: invokeinterface 462 2 0
    //   763: pop
    //   764: new 150	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   771: astore 19
    //   773: aload 19
    //   775: invokestatic 426	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   778: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload 19
    //   784: iload 9
    //   786: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 19
    //   792: ldc_w 507
    //   795: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 19
    //   801: iload 10
    //   803: iconst_1
    //   804: iadd
    //   805: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload 19
    //   811: ldc_w 507
    //   814: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 19
    //   820: iload 11
    //   822: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload 19
    //   828: ldc_w 507
    //   831: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload 19
    //   837: iload 12
    //   839: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 19
    //   845: ldc_w 509
    //   848: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 19
    //   854: iload 13
    //   856: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload 19
    //   862: ldc_w 507
    //   865: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload 19
    //   871: iload 14
    //   873: iconst_1
    //   874: iadd
    //   875: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 19
    //   881: ldc_w 507
    //   884: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 19
    //   890: iload 15
    //   892: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 19
    //   898: ldc_w 507
    //   901: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload 19
    //   907: iload 5
    //   909: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload 19
    //   915: aload 21
    //   917: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 19
    //   923: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: astore 19
    //   928: aload 24
    //   930: aload 19
    //   932: invokestatic 514	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;Ljava/lang/String;)V
    //   935: aload 19
    //   937: areturn
    //   938: iload 6
    //   940: istore 7
    //   942: goto -823 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	this	UnifiedDebugManager
    //   0	945	1	paramLong1	long
    //   0	945	3	paramLong2	long
    //   105	803	5	i	int
    //   141	798	6	j	int
    //   117	824	7	k	int
    //   227	163	8	m	int
    //   47	738	9	n	int
    //   55	750	10	i1	int
    //   63	758	11	i2	int
    //   72	766	12	i3	int
    //   80	775	13	i4	int
    //   88	787	14	i5	int
    //   96	795	15	i6	int
    //   25	12	16	l	long
    //   193	233	18	bool	boolean
    //   3	561	19	localObject1	Object
    //   568	9	19	localIOException1	IOException
    //   583	1	19	localObject2	Object
    //   588	13	19	localObject3	Object
    //   606	1	19	localObject4	Object
    //   615	7	19	localException1	java.lang.Exception
    //   627	30	19	localObject5	Object
    //   661	9	19	localIOException2	IOException
    //   676	260	19	localObject6	Object
    //   14	543	20	localObject7	Object
    //   598	7	20	localObject8	Object
    //   610	77	20	localObject9	Object
    //   694	9	20	localIOException3	IOException
    //   210	706	21	localObject10	Object
    //   252	263	22	str	String
    //   593	25	22	localException2	java.lang.Exception
    //   623	13	22	localException3	java.lang.Exception
    //   114	561	23	localObject11	Object
    //   174	755	24	localArrayList	ArrayList
    //   186	349	25	localObject12	Object
    //   245	130	26	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   556	561	568	java/io/IOException
    //   469	476	588	finally
    //   481	486	588	finally
    //   503	542	588	finally
    //   551	556	588	finally
    //   469	476	593	java/lang/Exception
    //   481	486	593	java/lang/Exception
    //   503	542	593	java/lang/Exception
    //   551	556	593	java/lang/Exception
    //   444	469	598	finally
    //   629	640	598	finally
    //   444	469	615	java/lang/Exception
    //   649	654	661	java/io/IOException
    //   686	691	694	java/io/IOException
  }
  
  String a(Context paramContext, int paramInt)
  {
    if (paramInt < 30000) {
      return paramContext.getDatabasePath("webview_x5.db").getPath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getApplicationContext().getDir("webview", 0).getPath());
    localStringBuilder.append("/Cookies");
    return localStringBuilder.toString();
  }
  
  public String a(Context paramContext, List<String> paramList)
  {
    int i = QbSdk.getTbsVersion(paramContext);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (i < 30000)
    {
      localObject1 = paramContext.getDatabasePath("webviewCache_x5.db").getPath();
      paramContext = new File(paramContext.getCacheDir(), "webviewCache");
      localObject1 = SQLiteDatabase.openDatabase((String)localObject1, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        localObject2 = ((SQLiteDatabase)localObject1).query("cache", new String[] { "url", "filepath" }, "url=?", new String[] { localObject2 }, null, null, null);
        while (((Cursor)localObject2).moveToNext()) {
          localArrayList.add(new File(paramContext, ((Cursor)localObject2).getString(1)).getPath());
        }
        ((Cursor)localObject2).close();
      }
      ((SQLiteDatabase)localObject1).close();
      paramList = new StringBuilder();
      paramList.append(paramContext.getPath());
      paramList.append("/html_cache.zip");
      paramContext = paramList.toString();
      UnifiedFileUtil.a(localArrayList, paramContext);
      return paramContext;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getApplicationContext().getDir("webview", 0).getPath());
    ((StringBuilder)localObject1).append("/Cache/");
    paramContext = ((StringBuilder)localObject1).toString();
    localObject1 = new File(paramContext);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = ((File)localObject1).list(new UnifiedDebugManager.1(this, c((String)paramList.next()).substring(0, 16)));
        if (localObject2 != null)
        {
          int j = localObject2.length;
          i = 0;
          while (i < j)
          {
            String str = localObject2[i];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramContext);
            localStringBuilder.append(str);
            localArrayList.add(localStringBuilder.toString());
            i += 1;
          }
        }
      }
      if (!localArrayList.isEmpty())
      {
        paramList = new StringBuilder();
        paramList.append(paramContext);
        paramList.append("html_cache.zip");
        paramContext = paramList.toString();
        UnifiedFileUtil.a(localArrayList, paramContext);
        return paramContext;
      }
      throw new FileNotFoundException("no cache file was found");
    }
    paramContext = new FileNotFoundException("no cache directory found");
    for (;;)
    {
      throw paramContext;
    }
  }
  
  /* Error */
  public String a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    // Byte code:
    //   0: new 604	android/os/Bundle
    //   3: dup
    //   4: invokespecial 605	android/os/Bundle:<init>	()V
    //   7: astore 8
    //   9: aload 8
    //   11: ldc_w 607
    //   14: ldc_w 609
    //   17: invokestatic 612	com/tencent/mobileqq/webview/swift/utils/SwiftWebViewUtils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 615	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: invokestatic 620	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   26: astore_1
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 624	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   32: aload_1
    //   33: aload 4
    //   35: invokevirtual 627	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +85 -> 125
    //   43: aload 8
    //   45: ldc_w 629
    //   48: aload_1
    //   49: invokevirtual 615	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +70 -> 125
    //   58: new 150	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   65: astore 6
    //   67: aload 6
    //   69: ldc_w 631
    //   72: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 6
    //   78: aload_1
    //   79: iconst_0
    //   80: anewarray 235	java/lang/String
    //   83: invokestatic 636	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   86: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: ldc_w 638
    //   95: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: aload 4
    //   103: iconst_0
    //   104: anewarray 235	java/lang/String
    //   107: invokestatic 640	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   110: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 143
    //   116: iconst_2
    //   117: aload 6
    //   119: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: new 150	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 645	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   137: invokevirtual 648	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ldc_w 650
    //   145: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore_1
    //   154: new 423	java/io/File
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 427	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 6
    //   164: aload 6
    //   166: invokevirtual 430	java/io/File:exists	()Z
    //   169: ifne +9 -> 178
    //   172: aload 6
    //   174: invokevirtual 465	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: lload_2
    //   179: invokestatic 653	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   182: astore 9
    //   184: new 150	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   191: astore 6
    //   193: aload 6
    //   195: aload_1
    //   196: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 6
    //   202: ldc_w 655
    //   205: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: aload 9
    //   213: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 6
    //   219: ldc_w 657
    //   222: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 6
    //   228: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 10
    //   233: new 423	java/io/File
    //   236: dup
    //   237: aload 10
    //   239: invokespecial 427	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 6
    //   244: aconst_null
    //   245: astore 7
    //   247: new 476	java/io/FileOutputStream
    //   250: dup
    //   251: aload 6
    //   253: invokespecial 479	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   256: astore 6
    //   258: new 659	java/net/URL
    //   261: dup
    //   262: aload 4
    //   264: invokespecial 660	java/net/URL:<init>	(Ljava/lang/String;)V
    //   267: invokevirtual 664	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   270: checkcast 666	java/net/HttpURLConnection
    //   273: astore 7
    //   275: aload 7
    //   277: ldc_w 668
    //   280: invokevirtual 671	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   283: aload 7
    //   285: sipush 6000
    //   288: invokevirtual 675	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   291: aload 7
    //   293: sipush 6000
    //   296: invokevirtual 678	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   299: aload 8
    //   301: invokevirtual 682	android/os/Bundle:keySet	()Ljava/util/Set;
    //   304: invokeinterface 685 1 0
    //   309: astore 4
    //   311: aload 4
    //   313: invokeinterface 221 1 0
    //   318: ifeq +47 -> 365
    //   321: aload 4
    //   323: invokeinterface 225 1 0
    //   328: checkcast 235	java/lang/String
    //   331: astore 11
    //   333: aload 8
    //   335: aload 11
    //   337: invokevirtual 687	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   340: astore 12
    //   342: aload 12
    //   344: instanceof 235
    //   347: ifeq -36 -> 311
    //   350: aload 7
    //   352: aload 11
    //   354: aload 12
    //   356: checkcast 235	java/lang/String
    //   359: invokevirtual 690	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -51 -> 311
    //   365: aload 7
    //   367: invokevirtual 693	java/net/HttpURLConnection:connect	()V
    //   370: sipush 200
    //   373: aload 7
    //   375: invokevirtual 696	java/net/HttpURLConnection:getResponseCode	()I
    //   378: if_icmpne +57 -> 435
    //   381: sipush 1024
    //   384: newarray byte
    //   386: astore 4
    //   388: new 698	java/io/BufferedInputStream
    //   391: dup
    //   392: aload 7
    //   394: invokevirtual 702	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   397: invokespecial 705	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   400: astore 8
    //   402: aload 8
    //   404: aload 4
    //   406: invokevirtual 711	java/io/InputStream:read	([B)I
    //   409: istore 5
    //   411: iconst_m1
    //   412: iload 5
    //   414: if_icmpeq +16 -> 430
    //   417: aload 6
    //   419: aload 4
    //   421: iconst_0
    //   422: iload 5
    //   424: invokevirtual 716	java/io/OutputStream:write	([BII)V
    //   427: goto -25 -> 402
    //   430: aload 6
    //   432: invokevirtual 717	java/io/OutputStream:flush	()V
    //   435: aload 6
    //   437: invokevirtual 718	java/io/OutputStream:close	()V
    //   440: goto +16 -> 456
    //   443: astore 4
    //   445: ldc 143
    //   447: iconst_1
    //   448: ldc_w 720
    //   451: aload 4
    //   453: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: aload 7
    //   458: ifnull +8 -> 466
    //   461: aload 7
    //   463: invokevirtual 723	java/net/HttpURLConnection:disconnect	()V
    //   466: new 420	java/util/ArrayList
    //   469: dup
    //   470: invokespecial 421	java/util/ArrayList:<init>	()V
    //   473: astore 4
    //   475: aload 4
    //   477: aload 10
    //   479: invokeinterface 462 2 0
    //   484: pop
    //   485: new 150	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   492: astore 6
    //   494: aload 6
    //   496: aload_1
    //   497: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 6
    //   503: ldc_w 655
    //   506: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 6
    //   512: aload 9
    //   514: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 6
    //   520: ldc_w 432
    //   523: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 6
    //   529: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: astore_1
    //   533: aload 4
    //   535: aload_1
    //   536: invokestatic 514	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;Ljava/lang/String;)V
    //   539: aload_1
    //   540: areturn
    //   541: astore_1
    //   542: aload 7
    //   544: astore 4
    //   546: goto +66 -> 612
    //   549: astore 4
    //   551: aload 7
    //   553: astore_1
    //   554: goto +14 -> 568
    //   557: astore_1
    //   558: aconst_null
    //   559: astore 4
    //   561: goto +51 -> 612
    //   564: astore 4
    //   566: aconst_null
    //   567: astore_1
    //   568: goto +22 -> 590
    //   571: astore_1
    //   572: aconst_null
    //   573: astore 4
    //   575: aload 4
    //   577: astore 6
    //   579: goto +33 -> 612
    //   582: astore 4
    //   584: aconst_null
    //   585: astore_1
    //   586: aload 7
    //   588: astore 6
    //   590: ldc 143
    //   592: iconst_1
    //   593: ldc_w 720
    //   596: aload 4
    //   598: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   601: aload 4
    //   603: athrow
    //   604: astore 7
    //   606: aload_1
    //   607: astore 4
    //   609: aload 7
    //   611: astore_1
    //   612: aload 6
    //   614: ifnull +24 -> 638
    //   617: aload 6
    //   619: invokevirtual 718	java/io/OutputStream:close	()V
    //   622: goto +16 -> 638
    //   625: astore 6
    //   627: ldc 143
    //   629: iconst_1
    //   630: ldc_w 720
    //   633: aload 6
    //   635: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   638: aload 4
    //   640: ifnull +8 -> 648
    //   643: aload 4
    //   645: invokevirtual 723	java/net/HttpURLConnection:disconnect	()V
    //   648: goto +5 -> 653
    //   651: aload_1
    //   652: athrow
    //   653: goto -2 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	this	UnifiedDebugManager
    //   0	656	1	paramQQAppInterface	QQAppInterface
    //   0	656	2	paramLong	long
    //   0	656	4	paramString	String
    //   409	14	5	i	int
    //   65	553	6	localObject1	Object
    //   625	9	6	localException	java.lang.Exception
    //   245	342	7	localHttpURLConnection	java.net.HttpURLConnection
    //   604	6	7	localObject2	Object
    //   7	396	8	localObject3	Object
    //   182	331	9	str1	String
    //   231	247	10	str2	String
    //   331	22	11	str3	String
    //   340	15	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   435	440	443	java/lang/Exception
    //   275	311	541	finally
    //   311	362	541	finally
    //   365	402	541	finally
    //   402	411	541	finally
    //   417	427	541	finally
    //   430	435	541	finally
    //   275	311	549	java/lang/Exception
    //   311	362	549	java/lang/Exception
    //   365	402	549	java/lang/Exception
    //   402	411	549	java/lang/Exception
    //   417	427	549	java/lang/Exception
    //   430	435	549	java/lang/Exception
    //   258	275	557	finally
    //   258	275	564	java/lang/Exception
    //   247	258	571	finally
    //   247	258	582	java/lang/Exception
    //   590	604	604	finally
    //   617	622	625	java/lang/Exception
  }
  
  public String a(File paramFile, List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("files-");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".zip");
    localObject = new File(paramFile, ((StringBuilder)localObject).toString()).getAbsolutePath();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile);
      localStringBuilder.append("/");
      localStringBuilder.append((String)paramList.get(i));
      localLinkedList.add(localStringBuilder.toString());
      i += 1;
    }
    UnifiedFileUtil.a(paramFile, paramList, (String)localObject);
    return localObject;
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (this.a.containsKey(paramString)) {
      str = (String)this.a.get(paramString);
    }
    return str;
  }
  
  public String a(List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject).append("/tencent/MobileQQ/unifiedebug/snapshots.zip");
    localObject = ((StringBuilder)localObject).toString();
    UnifiedFileUtil.a(paramList, (String)localObject);
    return localObject;
  }
  
  public List<Map<String, Object>> a(Context paramContext, String paramString)
  {
    Object localObject1 = paramString;
    int i = QbSdk.getTbsVersion(paramContext);
    paramString = (String)localObject1;
    if (!((String)localObject1).startsWith("."))
    {
      paramString = new StringBuilder();
      paramString.append(".");
      paramString.append((String)localObject1);
      paramString = paramString.toString();
    }
    if (i < 30000)
    {
      localObject1 = new String[6];
      localObject1[0] = "domain";
      localObject1[1] = "name";
      localObject1[2] = "value";
      localObject1[3] = "path";
      localObject1[4] = "expires";
      localObject1[5] = "secure";
    }
    else
    {
      localObject1 = new String[10];
      localObject1[0] = "host_key";
      localObject1[1] = "name";
      localObject1[2] = "value";
      localObject1[3] = "path";
      localObject1[4] = "expires_utc";
      localObject1[5] = "secure";
      localObject1[6] = "httponly";
      localObject1[7] = "has_expires";
      localObject1[8] = "persistent";
      localObject1[9] = "priority";
    }
    SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openDatabase(a(paramContext, i), null, 1);
    Cursor localCursor = localSQLiteDatabase.query("cookies", (String[])localObject1, null, null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      paramContext = localCursor.getString(0);
      if ((paramString.endsWith(paramContext)) || (paramString.equals(paramContext)))
      {
        HashMap localHashMap = new HashMap();
        i = 0;
        while (i < localObject1.length)
        {
          Object localObject2 = localObject1[i];
          if (i <= 3) {
            paramContext = localCursor.getString(i);
          } else {
            paramContext = Integer.valueOf(localCursor.getInt(i));
          }
          localHashMap.put(localObject2, paramContext);
          i += 1;
        }
        localArrayList.add(localHashMap);
      }
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return localArrayList;
  }
  
  public JSONObject a(File paramFile, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramFile == null) {
      return localJSONObject;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      paramFile = paramFile.listFiles();
    } else {
      paramFile = null;
    }
    if (paramFile != null)
    {
      localJSONObject.put("module_dir", paramString);
      paramString = new JSONArray();
      JSONArray localJSONArray1 = new JSONArray();
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        JSONArray localJSONArray2 = new JSONArray();
        localJSONArray2.put(localObject.getName());
        if (localObject.isFile())
        {
          double d1 = localObject.length();
          Double.isNaN(d1);
          localJSONArray2.put(d1 / 1000.0D);
          localJSONArray2.put(0);
          localJSONArray2.put(localObject.lastModified());
          paramString.put(localJSONArray2);
        }
        else
        {
          localJSONArray2.put(0);
          localJSONArray2.put(0);
          localJSONArray2.put(localObject.lastModified());
          localJSONArray1.put(localJSONArray2);
        }
        i += 1;
      }
      localJSONObject.put("sub_dir", localJSONArray1);
      localJSONObject.put("files", paramString);
    }
    return localJSONObject;
  }
  
  public void a(Context paramContext, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("id", paramLong1);
    localIntent.putExtra("action", 0);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.c);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("start alive snapshot to webview(");
      paramContext.append(paramLong1);
      paramContext.append(")");
      QLog.d("UnifiedDebugManager", 2, paramContext.toString());
    }
  }
  
  public void a(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    synchronized (this.d)
    {
      if (this.d.isEmpty())
      {
        b(paramContext, paramString1, paramInt, paramLong1, paramLong2, paramString2);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("start debug(queue is empty): seq=");
          paramContext.append(paramLong2);
          QLog.d("UnifiedDebugManager", 2, paramContext.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("start debug(only enqueue one cmd): seq=");
        paramContext.append(paramLong2);
        QLog.d("UnifiedDebugManager", 2, paramContext.toString());
      }
      this.d.offer(new UnifiedDebugManager.Command(this, paramString1, paramInt, paramLong1, paramLong2, paramString2));
      return;
    }
  }
  
  public void a(Context paramContext, String paramString, List<String> paramList)
  {
    int i = QbSdk.getTbsVersion(paramContext);
    Object localObject = a(paramContext, i);
    if (i < 30000) {
      paramContext = "domain=? and name=?";
    } else {
      paramContext = "host_key=? and name=?";
    }
    localObject = SQLiteDatabase.openDatabase((String)localObject, null, 0);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((SQLiteDatabase)localObject).delete("cookies", paramContext, new String[] { paramString, (String)paramList.next() });
    }
    ((SQLiteDatabase)localObject).close();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, Handler paramHandler)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = e(paramString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("traceRoute getHost = ");
        ((StringBuilder)localObject).append(str);
        QLog.d("UnifiedDebugManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = d(str);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("traceRoute getIp = ");
        localStringBuilder.append((String)localObject);
        QLog.d("UnifiedDebugManager", 2, localStringBuilder.toString());
      }
      paramString = f(paramString);
      new UnifiedTraceRouter(paramQQAppInterface, paramHandler).a(paramLong, str, paramString);
      return;
    }
    throw new IOException("url is empty");
  }
  
  public boolean a(Context paramContext, long paramLong)
  {
    synchronized (this.d)
    {
      UnifiedDebugManager.Command localCommand = (UnifiedDebugManager.Command)this.d.poll();
      if ((localCommand != null) && (localCommand.c == paramLong))
      {
        localCommand = (UnifiedDebugManager.Command)this.d.peek();
        if (localCommand != null)
        {
          b(paramContext, localCommand.a, localCommand.e, localCommand.b, localCommand.c, localCommand.d);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("finish once webview debug, start new debug(dequeue one cmd): seq=");
            paramContext.append(localCommand.c);
            QLog.d("UnifiedDebugManager", 2, paramContext.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("finish once webview debug: seq=");
          paramContext.append(paramLong);
          QLog.d("UnifiedDebugManager", 2, paramContext.toString());
        }
        return true;
      }
      return false;
    }
  }
  
  public String b()
  {
    UnifiedCommandUtil.ExecResult localExecResult = UnifiedCommandUtil.a("getprop net.dns1");
    if (localExecResult.a)
    {
      if (!localExecResult.b.isEmpty()) {
        return (String)localExecResult.b.get(0);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, localExecResult.c);
    }
    return "";
  }
  
  /* Error */
  public String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 235	java/lang/String
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 4
    //   9: aload 8
    //   11: iconst_0
    //   12: ldc_w 959
    //   15: aastore
    //   16: aload 8
    //   18: iconst_1
    //   19: ldc_w 761
    //   22: aastore
    //   23: new 659	java/net/URL
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 660	java/net/URL:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 962	java/net/URL:getProtocol	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload 5
    //   41: invokevirtual 965	java/net/URL:getHost	()Ljava/lang/String;
    //   44: astore 15
    //   46: new 150	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: aload_2
    //   58: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 5
    //   64: ldc_w 507
    //   67: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: aload 15
    //   75: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: ldc_w 507
    //   84: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_2
    //   94: new 423	java/io/File
    //   97: dup
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 968	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:d	(Landroid/content/Context;)Ljava/lang/String;
    //   103: invokespecial 427	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: aload 5
    //   110: invokevirtual 430	java/io/File:exists	()Z
    //   113: ifeq +552 -> 665
    //   116: aload 5
    //   118: invokevirtual 576	java/io/File:isDirectory	()Z
    //   121: ifeq +544 -> 665
    //   124: aload 5
    //   126: new 970	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager$3
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 971	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager$3:<init>	(Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;Ljava/lang/String;)V
    //   135: invokevirtual 588	java/io/File:list	(Ljava/io/FilenameFilter;)[Ljava/lang/String;
    //   138: astore 10
    //   140: new 420	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 421	java/util/ArrayList:<init>	()V
    //   147: astore_1
    //   148: new 798	org/json/JSONObject
    //   151: dup
    //   152: invokespecial 799	org/json/JSONObject:<init>	()V
    //   155: astore_2
    //   156: aload_2
    //   157: ldc_w 973
    //   160: aload 15
    //   162: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: new 806	org/json/JSONArray
    //   169: dup
    //   170: invokespecial 807	org/json/JSONArray:<init>	()V
    //   173: astore 7
    //   175: ldc 143
    //   177: astore 6
    //   179: aload 6
    //   181: astore 9
    //   183: aload 7
    //   185: astore 14
    //   187: aload_2
    //   188: astore 13
    //   190: aload_1
    //   191: astore 11
    //   193: aload 5
    //   195: astore 12
    //   197: aload 10
    //   199: ifnull +280 -> 479
    //   202: aload 6
    //   204: astore 9
    //   206: aload 7
    //   208: astore 14
    //   210: aload_2
    //   211: astore 13
    //   213: aload_1
    //   214: astore 11
    //   216: aload 5
    //   218: astore 12
    //   220: aload 10
    //   222: arraylength
    //   223: ifle +256 -> 479
    //   226: aload 10
    //   228: arraylength
    //   229: istore_3
    //   230: aload 6
    //   232: astore 9
    //   234: aload 7
    //   236: astore 14
    //   238: aload_2
    //   239: astore 13
    //   241: aload_1
    //   242: astore 11
    //   244: aload 5
    //   246: astore 12
    //   248: iload 4
    //   250: iload_3
    //   251: if_icmpge +228 -> 479
    //   254: aload 10
    //   256: iload 4
    //   258: aaload
    //   259: astore 9
    //   261: new 150	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   268: astore 11
    //   270: aload 11
    //   272: aload 5
    //   274: invokevirtual 461	java/io/File:getPath	()Ljava/lang/String;
    //   277: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 11
    //   283: ldc_w 655
    //   286: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 11
    //   292: aload 9
    //   294: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 11
    //   300: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: aconst_null
    //   304: iconst_1
    //   305: invokestatic 548	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   308: astore 9
    //   310: aload 9
    //   312: ldc_w 975
    //   315: aload 8
    //   317: aconst_null
    //   318: aconst_null
    //   319: aconst_null
    //   320: aconst_null
    //   321: aconst_null
    //   322: invokevirtual 560	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   325: astore 11
    //   327: aload 11
    //   329: invokeinterface 565 1 0
    //   334: ifeq +75 -> 409
    //   337: aload 11
    //   339: iconst_0
    //   340: invokeinterface 567 2 0
    //   345: astore 12
    //   347: new 235	java/lang/String
    //   350: dup
    //   351: aload 11
    //   353: iconst_1
    //   354: invokeinterface 979 2 0
    //   359: ldc_w 981
    //   362: invokespecial 984	java/lang/String:<init>	([BLjava/lang/String;)V
    //   365: astore 13
    //   367: new 798	org/json/JSONObject
    //   370: dup
    //   371: invokespecial 799	org/json/JSONObject:<init>	()V
    //   374: astore 14
    //   376: aload 14
    //   378: ldc_w 959
    //   381: aload 12
    //   383: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload 14
    //   389: ldc_w 761
    //   392: aload 13
    //   394: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload 7
    //   400: aload 14
    //   402: invokevirtual 810	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   405: pop
    //   406: goto -79 -> 327
    //   409: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +46 -> 458
    //   415: new 150	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   422: astore 12
    //   424: aload 12
    //   426: ldc_w 986
    //   429: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 12
    //   435: aload 7
    //   437: invokevirtual 987	org/json/JSONArray:toString	()Ljava/lang/String;
    //   440: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 6
    //   446: iconst_2
    //   447: aload 12
    //   449: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto +3 -> 458
    //   458: aload 11
    //   460: invokeinterface 568 1 0
    //   465: aload 9
    //   467: invokevirtual 569	android/database/sqlite/SQLiteDatabase:close	()V
    //   470: iload 4
    //   472: iconst_1
    //   473: iadd
    //   474: istore 4
    //   476: goto -246 -> 230
    //   479: aload 13
    //   481: ldc_w 989
    //   484: aload 14
    //   486: invokevirtual 804	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   489: pop
    //   490: new 423	java/io/File
    //   493: dup
    //   494: aload 12
    //   496: ldc_w 991
    //   499: invokespecial 470	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   502: astore_1
    //   503: new 993	java/io/BufferedOutputStream
    //   506: dup
    //   507: new 476	java/io/FileOutputStream
    //   510: dup
    //   511: aload_1
    //   512: invokespecial 479	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   515: invokespecial 994	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   518: astore_2
    //   519: aload_2
    //   520: aload 13
    //   522: invokevirtual 995	org/json/JSONObject:toString	()Ljava/lang/String;
    //   525: invokevirtual 999	java/lang/String:getBytes	()[B
    //   528: invokevirtual 1002	java/io/BufferedOutputStream:write	([B)V
    //   531: aload_2
    //   532: invokevirtual 1003	java/io/BufferedOutputStream:flush	()V
    //   535: aload 11
    //   537: aload_1
    //   538: invokevirtual 461	java/io/File:getPath	()Ljava/lang/String;
    //   541: invokeinterface 462 2 0
    //   546: pop
    //   547: aload_2
    //   548: invokevirtual 1004	java/io/BufferedOutputStream:close	()V
    //   551: goto +14 -> 565
    //   554: astore_1
    //   555: aload 9
    //   557: iconst_1
    //   558: ldc_w 1006
    //   561: aload_1
    //   562: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aload 11
    //   567: invokeinterface 590 1 0
    //   572: ifne +93 -> 665
    //   575: new 150	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   582: astore_1
    //   583: aload_1
    //   584: aload 12
    //   586: invokevirtual 461	java/io/File:getPath	()Ljava/lang/String;
    //   589: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_1
    //   594: ldc_w 1008
    //   597: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload_1
    //   602: aload 15
    //   604: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_1
    //   609: ldc_w 432
    //   612: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload_1
    //   617: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: astore_1
    //   621: aload 11
    //   623: aload_1
    //   624: invokestatic 514	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;Ljava/lang/String;)V
    //   627: aload 11
    //   629: invokestatic 1011	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;)V
    //   632: aload_1
    //   633: areturn
    //   634: astore_1
    //   635: goto +6 -> 641
    //   638: astore_1
    //   639: aconst_null
    //   640: astore_2
    //   641: aload_2
    //   642: ifnull +21 -> 663
    //   645: aload_2
    //   646: invokevirtual 1004	java/io/BufferedOutputStream:close	()V
    //   649: goto +14 -> 663
    //   652: astore_2
    //   653: aload 9
    //   655: iconst_1
    //   656: ldc_w 1006
    //   659: aload_2
    //   660: invokestatic 501	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   663: aload_1
    //   664: athrow
    //   665: aconst_null
    //   666: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	UnifiedDebugManager
    //   0	667	1	paramContext	Context
    //   0	667	2	paramString	String
    //   229	23	3	i	int
    //   7	468	4	j	int
    //   31	242	5	localObject1	Object
    //   177	268	6	str1	String
    //   173	263	7	localJSONArray	JSONArray
    //   4	312	8	arrayOfString1	String[]
    //   181	473	9	localObject2	Object
    //   138	117	10	arrayOfString2	String[]
    //   191	437	11	localObject3	Object
    //   195	390	12	localObject4	Object
    //   188	333	13	str2	String
    //   185	300	14	localObject5	Object
    //   44	559	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   547	551	554	java/io/IOException
    //   519	547	634	finally
    //   503	519	638	finally
    //   645	649	652	java/io/IOException
  }
  
  public String b(String paramString)
  {
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/tencent/tbs_live_log/com.tencent.mobileqq/");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("com.tencent.mobileqq_tool_livelog_");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".livelog");
    paramString = new File(localFile, ((StringBuilder)localObject).toString());
    if (paramString.exists())
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramString.getName());
      return a(localFile, (List)localObject);
    }
    return "";
  }
  
  @Deprecated
  public List<String> b(Context paramContext)
  {
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getDatabasePath("webviewCache_x5.db").getPath(), null, 1);
      Cursor localCursor = paramContext.query("cache", new String[] { "url" }, null, null, null, null, null);
      ArrayList localArrayList = new ArrayList();
      while (localCursor.moveToNext()) {
        localArrayList.add(localCursor.getString(0));
      }
      localCursor.close();
      paramContext.close();
      return localArrayList;
    }
    return new ArrayList();
  }
  
  void b(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("debugUrl", paramString1);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString2);
    localIntent.putExtra("delay", paramLong1);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.c);
    paramContext.startActivity(localIntent);
    this.b.postDelayed(new UnifiedDebugManager.5(this, paramLong2, paramContext, paramString1, paramInt, paramLong1, paramString2), 120000L + paramLong1);
  }
  
  public void b(Context paramContext, String paramString, List<String> paramList)
  {
    Object localObject1 = new URL(paramString);
    paramString = ((URL)localObject1).getProtocol();
    localObject1 = ((URL)localObject1).getHost();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_");
    paramString = ((StringBuilder)localObject2).toString();
    paramContext = new File(d(paramContext));
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      paramString = paramContext.list(new UnifiedDebugManager.4(this, paramString));
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localObject1 = paramString[i];
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.getPath());
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = SQLiteDatabase.openDatabase(((StringBuilder)localObject2).toString(), null, 0);
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((SQLiteDatabase)localObject1).delete("ItemTable", "key=?", new String[] { (String)((Iterator)localObject2).next() });
          }
          ((SQLiteDatabase)localObject1).close();
          i += 1;
        }
      }
    }
  }
  
  public void b(Context paramContext, List<String> paramList)
  {
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      localObject1 = paramContext.getDatabasePath("webviewCache_x5.db").getPath();
      paramContext = new File(paramContext.getCacheDir(), "webviewCache");
      localObject1 = SQLiteDatabase.openDatabase((String)localObject1, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (String)paramList.next();
        localObject2 = ((SQLiteDatabase)localObject1).query("cache", new String[] { "url", "filepath" }, "url=?", new String[] { localObject2 }, null, null, null);
        while (((Cursor)localObject2).moveToNext())
        {
          String str1 = ((Cursor)localObject2).getString(0);
          String str2 = ((Cursor)localObject2).getString(1);
          File localFile = new File(paramContext, str2);
          if ((localFile.exists()) && (localFile.delete())) {
            ((SQLiteDatabase)localObject1).delete("cache", "url=? and filepath=?", new String[] { str1, str2 });
          }
        }
        ((Cursor)localObject2).close();
      }
      ((SQLiteDatabase)localObject1).close();
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getApplicationContext().getDir("webview", 0).getPath());
    ((StringBuilder)localObject1).append("/Cache");
    paramContext = new File(((StringBuilder)localObject1).toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = paramContext.listFiles(new UnifiedDebugManager.2(this, c((String)paramList.next()).substring(0, 16)));
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject1[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public boolean b(File paramFile, List<String> paramList)
  {
    if ((paramFile != null) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        File localFile = new File(paramFile, (String)paramList.next());
        if (localFile.exists())
        {
          if (localFile.isDirectory()) {
            return VasUpdateUtil.a(localFile);
          }
          return localFile.delete();
        }
      }
    }
    return false;
  }
  
  String c(String paramString)
  {
    Object localObject = MessageDigest.getInstance("SHA-1");
    ((MessageDigest)localObject).update(paramString.getBytes());
    paramString = ((MessageDigest)localObject).digest();
    localObject = new StringBuffer();
    int i = 0;
    while (i < paramString.length)
    {
      String str = Integer.toHexString(paramString[i] & 0xFF);
      if (str.length() < 2) {
        ((StringBuffer)localObject).append(0);
      }
      ((StringBuffer)localObject).append(str);
      i += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  public Set<String> c(Context paramContext)
  {
    int i = QbSdk.getTbsVersion(paramContext);
    if (i < 30000)
    {
      localObject = new String[1];
      localObject[0] = "domain";
    }
    else
    {
      localObject = new String[1];
      localObject[0] = "host_key";
    }
    paramContext = SQLiteDatabase.openDatabase(a(paramContext, i), null, 1);
    Object localObject = paramContext.query("cookies", (String[])localObject, null, null, null, null, null);
    HashSet localHashSet = new HashSet();
    while (((Cursor)localObject).moveToNext()) {
      localHashSet.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    paramContext.close();
    return localHashSet;
  }
  
  public void c(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("id", paramLong2);
    localIntent.putExtra("action", 2);
    localIntent.putExtra("debugUrl", paramString1);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString2);
    localIntent.putExtra("delay", paramLong1);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.c);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("start alive snapshot, seq=");
      paramContext.append(paramLong2);
      QLog.d("UnifiedDebugManager", 2, paramContext.toString());
    }
  }
  
  String d(Context paramContext)
  {
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Local StoragePath = ");
        localStringBuilder.append(paramContext.getApplicationContext().getDir("database_web", 0).getPath());
        QLog.d("UnifiedDebugManager", 2, localStringBuilder.toString());
      }
      return paramContext.getApplicationContext().getDir("database_web", 0).getPath();
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Local StoragePath = ");
      localStringBuilder.append(paramContext.getApplicationContext().getDir("webview", 0).getPath());
      localStringBuilder.append("/Local Storage/");
      QLog.d("UnifiedDebugManager", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getApplicationContext().getDir("webview", 0).getPath());
    localStringBuilder.append("/Local Storage/");
    return localStringBuilder.toString();
  }
  
  public String d(String paramString)
  {
    return InetAddress.getByName(paramString).getHostAddress();
  }
  
  String e(String paramString)
  {
    return new URL(paramString).getHost();
  }
  
  public Set<String> e(Context paramContext)
  {
    paramContext = UnifiedFileUtil.a(d(paramContext));
    HashSet localHashSet = new HashSet();
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramContext[i].split("_");
        if (arrayOfString.length == 3) {
          localHashSet.add(arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localHashSet;
  }
  
  Map<String, Object> f(String paramString)
  {
    Object localObject = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 10000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, 10000);
    localObject = new DefaultHttpClient((HttpParams)localObject);
    paramString = new HttpGet(paramString);
    long l1 = System.currentTimeMillis();
    paramString = ((HttpClient)localObject).execute(paramString);
    long l2 = System.currentTimeMillis();
    int i = paramString.getStatusLine().getStatusCode();
    localObject = new HashMap();
    ((Map)localObject).put("status", Integer.valueOf(i));
    ((Map)localObject).put("downloadTime", Long.valueOf(l2 - l1));
    if (i / 100 == 2) {
      ((Map)localObject).put("size", Integer.valueOf(EntityUtils.toByteArray(paramString.getEntity()).length));
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager
 * JD-Core Version:    0.7.0.1
 */