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
  public Handler a;
  ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  public Map<String, String> a;
  final Queue<UnifiedDebugManager.Command> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public UnifiedDebugManager(SnapshotResultReceiver paramSnapshotResultReceiver)
  {
    this.jdField_a_of_type_AndroidOsResultReceiver = paramSnapshotResultReceiver;
    paramSnapshotResultReceiver = ThreadManager.newFreeHandlerThread("UnifiedDebugMonitor", 0);
    paramSnapshotResultReceiver.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramSnapshotResultReceiver.getLooper());
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put("offline_pkg", OfflineEnvHelper.b());
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
    a(paramApplication);
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
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.ultimatesnapshot");
    localIntent.putExtra("action", 1);
    localIntent.putExtra("id", 0L);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "send broadcast to finish all alive webview");
    }
  }
  
  static boolean a(Application paramApplication)
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
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("x5_proxy_setting", 4).contains("http_proxy_address");
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public UnifiedDebugManager.TerminalInfo a(Context paramContext)
  {
    UnifiedDebugManager.TerminalInfo localTerminalInfo = new UnifiedDebugManager.TerminalInfo(this);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(DeviceInfoUtil.h());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(DeviceInfoUtil.d());
    localTerminalInfo.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localTerminalInfo.jdField_b_of_type_JavaLangString = Build.VERSION.RELEASE;
    localTerminalInfo.c = "8.7.0.5295";
    localObject = DeviceInfoUtil.a(paramContext);
    localTerminalInfo.d = ((DeviceInfoUtil.NetInfo)localObject).jdField_a_of_type_JavaLangString;
    localTerminalInfo.e = ((DeviceInfoUtil.NetInfo)localObject).c;
    localTerminalInfo.jdField_a_of_type_Int = DeviceInfoUtil.b();
    localTerminalInfo.jdField_a_of_type_Long = DeviceInfoUtil.b();
    localTerminalInfo.jdField_b_of_type_Long = DeviceInfoUtil.a();
    localTerminalInfo.f = DeviceInfoUtil.g();
    localTerminalInfo.jdField_a_of_type_Boolean = a(paramContext);
    localTerminalInfo.jdField_b_of_type_Int = QbSdk.getTbsVersion(paramContext);
    boolean bool;
    if (localTerminalInfo.jdField_b_of_type_Int == 0) {
      bool = false;
    } else {
      bool = true;
    }
    localTerminalInfo.jdField_b_of_type_Boolean = bool;
    return localTerminalInfo;
  }
  
  public String a()
  {
    UnifiedCommandUtil.ExecResult localExecResult = UnifiedCommandUtil.a("getprop net.dns1");
    if (localExecResult.jdField_a_of_type_Boolean)
    {
      if (!localExecResult.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return (String)localExecResult.jdField_a_of_type_JavaUtilList.get(0);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, localExecResult.jdField_a_of_type_JavaLangString);
    }
    return "";
  }
  
  /* Error */
  public String a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 395	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   3: astore 19
    //   5: aload 19
    //   7: lload_1
    //   8: invokevirtual 399	java/util/Calendar:setTimeInMillis	(J)V
    //   11: invokestatic 395	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   14: astore 20
    //   16: aload 20
    //   18: lload_3
    //   19: invokevirtual 399	java/util/Calendar:setTimeInMillis	(J)V
    //   22: invokestatic 404	java/lang/System:currentTimeMillis	()J
    //   25: lstore 16
    //   27: lload_3
    //   28: lload 16
    //   30: lcmp
    //   31: iflt +10 -> 41
    //   34: aload 20
    //   36: lload 16
    //   38: invokevirtual 399	java/util/Calendar:setTimeInMillis	(J)V
    //   41: aload 19
    //   43: iconst_1
    //   44: invokevirtual 406	java/util/Calendar:get	(I)I
    //   47: istore 9
    //   49: aload 19
    //   51: iconst_2
    //   52: invokevirtual 406	java/util/Calendar:get	(I)I
    //   55: istore 10
    //   57: aload 19
    //   59: iconst_5
    //   60: invokevirtual 406	java/util/Calendar:get	(I)I
    //   63: istore 11
    //   65: aload 19
    //   67: bipush 10
    //   69: invokevirtual 406	java/util/Calendar:get	(I)I
    //   72: istore 12
    //   74: aload 20
    //   76: iconst_1
    //   77: invokevirtual 406	java/util/Calendar:get	(I)I
    //   80: istore 13
    //   82: aload 20
    //   84: iconst_2
    //   85: invokevirtual 406	java/util/Calendar:get	(I)I
    //   88: istore 14
    //   90: aload 20
    //   92: iconst_5
    //   93: invokevirtual 406	java/util/Calendar:get	(I)I
    //   96: istore 15
    //   98: aload 20
    //   100: bipush 10
    //   102: invokevirtual 406	java/util/Calendar:get	(I)I
    //   105: istore 5
    //   107: new 408	java/util/HashSet
    //   110: dup
    //   111: invokespecial 409	java/util/HashSet:<init>	()V
    //   114: astore 23
    //   116: iconst_0
    //   117: istore 7
    //   119: invokestatic 413	com/tencent/qphone/base/util/QLog:getLogFileFormatter	()Ljava/text/SimpleDateFormat;
    //   122: lload_1
    //   123: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: invokevirtual 425	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore 19
    //   131: aload 23
    //   133: aload 19
    //   135: invokevirtual 429	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: iload 7
    //   141: istore 6
    //   143: iload 7
    //   145: ifne +10 -> 155
    //   148: aload 19
    //   150: invokevirtual 432	java/lang/String:length	()I
    //   153: istore 6
    //   155: lload_1
    //   156: ldc2_w 433
    //   159: ladd
    //   160: lstore_1
    //   161: lload_1
    //   162: lload_3
    //   163: lcmp
    //   164: ifle +775 -> 939
    //   167: new 436	java/util/ArrayList
    //   170: dup
    //   171: invokespecial 437	java/util/ArrayList:<init>	()V
    //   174: astore 24
    //   176: new 439	java/io/File
    //   179: dup
    //   180: invokestatic 442	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   183: invokespecial 443	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: astore 25
    //   188: aload 25
    //   190: invokevirtual 446	java/io/File:exists	()Z
    //   193: istore 18
    //   195: ldc_w 448
    //   198: astore 19
    //   200: iload 18
    //   202: ifeq +200 -> 402
    //   205: aload 25
    //   207: invokevirtual 452	java/io/File:listFiles	()[Ljava/io/File;
    //   210: astore 21
    //   212: aload 19
    //   214: astore 20
    //   216: aload 21
    //   218: ifnull +177 -> 395
    //   221: aload 21
    //   223: arraylength
    //   224: istore 7
    //   226: iconst_0
    //   227: istore 8
    //   229: aload 19
    //   231: astore 20
    //   233: iload 8
    //   235: iload 7
    //   237: if_icmpge +158 -> 395
    //   240: aload 21
    //   242: iload 8
    //   244: aaload
    //   245: astore 26
    //   247: aload 26
    //   249: invokevirtual 455	java/io/File:getName	()Ljava/lang/String;
    //   252: astore 22
    //   254: aload 22
    //   256: aload 19
    //   258: invokevirtual 272	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   261: ifeq +6 -> 267
    //   264: goto +122 -> 386
    //   267: aload 22
    //   269: ldc_w 457
    //   272: invokevirtual 272	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   275: ifeq +21 -> 296
    //   278: aload 22
    //   280: iconst_0
    //   281: aload 22
    //   283: invokevirtual 432	java/lang/String:length	()I
    //   286: iconst_4
    //   287: isub
    //   288: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   291: astore 20
    //   293: goto +36 -> 329
    //   296: aload 22
    //   298: astore 20
    //   300: aload 22
    //   302: ldc_w 463
    //   305: invokevirtual 272	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   308: ifeq +21 -> 329
    //   311: aload 22
    //   313: iconst_0
    //   314: aload 22
    //   316: invokevirtual 432	java/lang/String:length	()I
    //   319: iconst_5
    //   320: isub
    //   321: invokevirtual 461	java/lang/String:substring	(II)Ljava/lang/String;
    //   324: astore 20
    //   326: goto +3 -> 329
    //   329: aload 20
    //   331: ldc_w 257
    //   334: invokevirtual 263	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   337: ifeq +49 -> 386
    //   340: aload 20
    //   342: aload 20
    //   344: invokevirtual 432	java/lang/String:length	()I
    //   347: iload 6
    //   349: isub
    //   350: invokevirtual 466	java/lang/String:substring	(I)Ljava/lang/String;
    //   353: astore 20
    //   355: aload 20
    //   357: invokestatic 471	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +26 -> 386
    //   363: aload 23
    //   365: aload 20
    //   367: invokevirtual 473	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   370: ifeq +16 -> 386
    //   373: aload 24
    //   375: aload 26
    //   377: invokevirtual 476	java/io/File:getPath	()Ljava/lang/String;
    //   380: invokeinterface 477 2 0
    //   385: pop
    //   386: iload 8
    //   388: iconst_1
    //   389: iadd
    //   390: istore 8
    //   392: goto -163 -> 229
    //   395: aload 20
    //   397: astore 21
    //   399: goto +14 -> 413
    //   402: ldc_w 448
    //   405: astore 21
    //   407: aload 25
    //   409: invokevirtual 480	java/io/File:mkdirs	()Z
    //   412: pop
    //   413: aload 25
    //   415: invokevirtual 446	java/io/File:exists	()Z
    //   418: istore 18
    //   420: aconst_null
    //   421: astore 22
    //   423: aconst_null
    //   424: astore 19
    //   426: iload 18
    //   428: ifeq +283 -> 711
    //   431: new 439	java/io/File
    //   434: dup
    //   435: aload 25
    //   437: ldc_w 482
    //   440: invokespecial 485	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   443: astore 23
    //   445: new 487	java/io/BufferedWriter
    //   448: dup
    //   449: new 489	java/io/OutputStreamWriter
    //   452: dup
    //   453: new 491	java/io/FileOutputStream
    //   456: dup
    //   457: aload 23
    //   459: invokespecial 494	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   462: invokespecial 497	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   465: invokespecial 500	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   468: astore 20
    //   470: aload 25
    //   472: invokevirtual 452	java/io/File:listFiles	()[Ljava/io/File;
    //   475: astore 19
    //   477: aload 19
    //   479: ifnull +73 -> 552
    //   482: aload 19
    //   484: arraylength
    //   485: istore 7
    //   487: iconst_0
    //   488: istore 6
    //   490: iload 6
    //   492: iload 7
    //   494: if_icmpge +58 -> 552
    //   497: aload 19
    //   499: iload 6
    //   501: aaload
    //   502: astore 22
    //   504: new 148	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   511: astore 25
    //   513: aload 25
    //   515: aload 22
    //   517: invokevirtual 455	java/io/File:getName	()Ljava/lang/String;
    //   520: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 25
    //   526: ldc_w 502
    //   529: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 20
    //   535: aload 25
    //   537: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokevirtual 505	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   543: iload 6
    //   545: iconst_1
    //   546: iadd
    //   547: istore 6
    //   549: goto -59 -> 490
    //   552: aload 20
    //   554: invokevirtual 508	java/io/BufferedWriter:flush	()V
    //   557: aload 20
    //   559: invokevirtual 511	java/io/BufferedWriter:close	()V
    //   562: aload 23
    //   564: astore 19
    //   566: goto +148 -> 714
    //   569: astore 19
    //   571: ldc 140
    //   573: iconst_1
    //   574: ldc_w 513
    //   577: aload 19
    //   579: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   582: aload 23
    //   584: astore 19
    //   586: goto +128 -> 714
    //   589: astore 19
    //   591: goto +91 -> 682
    //   594: astore 22
    //   596: goto +30 -> 626
    //   599: astore 20
    //   601: aload 19
    //   603: astore 21
    //   605: aload 20
    //   607: astore 19
    //   609: aload 21
    //   611: astore 20
    //   613: goto +69 -> 682
    //   616: astore 19
    //   618: aload 22
    //   620: astore 20
    //   622: aload 19
    //   624: astore 22
    //   626: aload 20
    //   628: astore 19
    //   630: ldc 140
    //   632: iconst_1
    //   633: ldc_w 518
    //   636: aload 22
    //   638: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   641: aload 23
    //   643: astore 19
    //   645: aload 20
    //   647: ifnull +67 -> 714
    //   650: aload 20
    //   652: invokevirtual 511	java/io/BufferedWriter:close	()V
    //   655: aload 23
    //   657: astore 19
    //   659: goto +55 -> 714
    //   662: astore 19
    //   664: ldc 140
    //   666: iconst_1
    //   667: ldc_w 513
    //   670: aload 19
    //   672: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   675: aload 23
    //   677: astore 19
    //   679: goto +35 -> 714
    //   682: aload 20
    //   684: ifnull +24 -> 708
    //   687: aload 20
    //   689: invokevirtual 511	java/io/BufferedWriter:close	()V
    //   692: goto +16 -> 708
    //   695: astore 20
    //   697: ldc 140
    //   699: iconst_1
    //   700: ldc_w 513
    //   703: aload 20
    //   705: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   708: aload 19
    //   710: athrow
    //   711: aconst_null
    //   712: astore 19
    //   714: aload 19
    //   716: ifnull +16 -> 732
    //   719: aload 24
    //   721: aload 19
    //   723: invokevirtual 476	java/io/File:getPath	()Ljava/lang/String;
    //   726: invokeinterface 477 2 0
    //   731: pop
    //   732: new 439	java/io/File
    //   735: dup
    //   736: ldc_w 520
    //   739: invokespecial 443	java/io/File:<init>	(Ljava/lang/String;)V
    //   742: astore 19
    //   744: aload 19
    //   746: invokevirtual 446	java/io/File:exists	()Z
    //   749: ifeq +16 -> 765
    //   752: aload 24
    //   754: aload 19
    //   756: invokevirtual 476	java/io/File:getPath	()Ljava/lang/String;
    //   759: invokeinterface 477 2 0
    //   764: pop
    //   765: new 148	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   772: astore 19
    //   774: aload 19
    //   776: invokestatic 442	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   779: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload 19
    //   785: iload 9
    //   787: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 19
    //   793: ldc_w 522
    //   796: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 19
    //   802: iload 10
    //   804: iconst_1
    //   805: iadd
    //   806: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 19
    //   812: ldc_w 522
    //   815: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 19
    //   821: iload 11
    //   823: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload 19
    //   829: ldc_w 522
    //   832: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 19
    //   838: iload 12
    //   840: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 19
    //   846: ldc_w 524
    //   849: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 19
    //   855: iload 13
    //   857: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 19
    //   863: ldc_w 522
    //   866: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload 19
    //   872: iload 14
    //   874: iconst_1
    //   875: iadd
    //   876: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload 19
    //   882: ldc_w 522
    //   885: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload 19
    //   891: iload 15
    //   893: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 19
    //   899: ldc_w 522
    //   902: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload 19
    //   908: iload 5
    //   910: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload 19
    //   916: aload 21
    //   918: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 19
    //   924: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: astore 19
    //   929: aload 24
    //   931: aload 19
    //   933: invokestatic 529	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;Ljava/lang/String;)V
    //   936: aload 19
    //   938: areturn
    //   939: iload 6
    //   941: istore 7
    //   943: goto -824 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	946	0	this	UnifiedDebugManager
    //   0	946	1	paramLong1	long
    //   0	946	3	paramLong2	long
    //   105	804	5	i	int
    //   141	799	6	j	int
    //   117	825	7	k	int
    //   227	164	8	m	int
    //   47	739	9	n	int
    //   55	751	10	i1	int
    //   63	759	11	i2	int
    //   72	767	12	i3	int
    //   80	776	13	i4	int
    //   88	788	14	i5	int
    //   96	796	15	i6	int
    //   25	12	16	l	long
    //   193	234	18	bool	boolean
    //   3	562	19	localObject1	Object
    //   569	9	19	localIOException1	IOException
    //   584	1	19	localObject2	Object
    //   589	13	19	localObject3	Object
    //   607	1	19	localObject4	Object
    //   616	7	19	localException1	java.lang.Exception
    //   628	30	19	localObject5	Object
    //   662	9	19	localIOException2	IOException
    //   677	260	19	localObject6	Object
    //   14	544	20	localObject7	Object
    //   599	7	20	localObject8	Object
    //   611	77	20	localObject9	Object
    //   695	9	20	localIOException3	IOException
    //   210	707	21	localObject10	Object
    //   252	264	22	str	String
    //   594	25	22	localException2	java.lang.Exception
    //   624	13	22	localException3	java.lang.Exception
    //   114	562	23	localObject11	Object
    //   174	756	24	localArrayList	ArrayList
    //   186	350	25	localObject12	Object
    //   245	131	26	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   557	562	569	java/io/IOException
    //   470	477	589	finally
    //   482	487	589	finally
    //   504	543	589	finally
    //   552	557	589	finally
    //   470	477	594	java/lang/Exception
    //   482	487	594	java/lang/Exception
    //   504	543	594	java/lang/Exception
    //   552	557	594	java/lang/Exception
    //   445	470	599	finally
    //   630	641	599	finally
    //   445	470	616	java/lang/Exception
    //   650	655	662	java/io/IOException
    //   687	692	695	java/io/IOException
  }
  
  String a(Context paramContext)
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
  
  /* Error */
  public String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 259	java/lang/String
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 4
    //   9: aload 8
    //   11: iconst_0
    //   12: ldc_w 558
    //   15: aastore
    //   16: aload 8
    //   18: iconst_1
    //   19: ldc_w 560
    //   22: aastore
    //   23: new 562	java/net/URL
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 563	java/net/URL:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 566	java/net/URL:getProtocol	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload 5
    //   41: invokevirtual 569	java/net/URL:getHost	()Ljava/lang/String;
    //   44: astore 15
    //   46: new 148	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: aload_2
    //   58: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 5
    //   64: ldc_w 522
    //   67: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: aload 15
    //   75: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: ldc_w 522
    //   84: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 5
    //   90: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_2
    //   94: new 439	java/io/File
    //   97: dup
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 571	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;)Ljava/lang/String;
    //   103: invokespecial 443	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: aload 5
    //   110: invokevirtual 446	java/io/File:exists	()Z
    //   113: ifeq +552 -> 665
    //   116: aload 5
    //   118: invokevirtual 574	java/io/File:isDirectory	()Z
    //   121: ifeq +544 -> 665
    //   124: aload 5
    //   126: new 576	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager$3
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 579	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager$3:<init>	(Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;Ljava/lang/String;)V
    //   135: invokevirtual 583	java/io/File:list	(Ljava/io/FilenameFilter;)[Ljava/lang/String;
    //   138: astore 10
    //   140: new 436	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 437	java/util/ArrayList:<init>	()V
    //   147: astore_1
    //   148: new 585	org/json/JSONObject
    //   151: dup
    //   152: invokespecial 586	org/json/JSONObject:<init>	()V
    //   155: astore_2
    //   156: aload_2
    //   157: ldc_w 588
    //   160: aload 15
    //   162: invokevirtual 591	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: new 593	org/json/JSONArray
    //   169: dup
    //   170: invokespecial 594	org/json/JSONArray:<init>	()V
    //   173: astore 7
    //   175: ldc 140
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
    //   261: new 148	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   268: astore 11
    //   270: aload 11
    //   272: aload 5
    //   274: invokevirtual 476	java/io/File:getPath	()Ljava/lang/String;
    //   277: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 11
    //   283: ldc_w 596
    //   286: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 11
    //   292: aload 9
    //   294: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 11
    //   300: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: aconst_null
    //   304: iconst_1
    //   305: invokestatic 602	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   308: astore 9
    //   310: aload 9
    //   312: ldc_w 604
    //   315: aload 8
    //   317: aconst_null
    //   318: aconst_null
    //   319: aconst_null
    //   320: aconst_null
    //   321: aconst_null
    //   322: invokevirtual 608	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   325: astore 11
    //   327: aload 11
    //   329: invokeinterface 613 1 0
    //   334: ifeq +75 -> 409
    //   337: aload 11
    //   339: iconst_0
    //   340: invokeinterface 615 2 0
    //   345: astore 12
    //   347: new 259	java/lang/String
    //   350: dup
    //   351: aload 11
    //   353: iconst_1
    //   354: invokeinterface 619 2 0
    //   359: ldc_w 621
    //   362: invokespecial 624	java/lang/String:<init>	([BLjava/lang/String;)V
    //   365: astore 13
    //   367: new 585	org/json/JSONObject
    //   370: dup
    //   371: invokespecial 586	org/json/JSONObject:<init>	()V
    //   374: astore 14
    //   376: aload 14
    //   378: ldc_w 558
    //   381: aload 12
    //   383: invokevirtual 591	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload 14
    //   389: ldc_w 560
    //   392: aload 13
    //   394: invokevirtual 591	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload 7
    //   400: aload 14
    //   402: invokevirtual 627	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   405: pop
    //   406: goto -79 -> 327
    //   409: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +46 -> 458
    //   415: new 148	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   422: astore 12
    //   424: aload 12
    //   426: ldc_w 629
    //   429: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 12
    //   435: aload 7
    //   437: invokevirtual 630	org/json/JSONArray:toString	()Ljava/lang/String;
    //   440: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 6
    //   446: iconst_2
    //   447: aload 12
    //   449: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto +3 -> 458
    //   458: aload 11
    //   460: invokeinterface 631 1 0
    //   465: aload 9
    //   467: invokevirtual 632	android/database/sqlite/SQLiteDatabase:close	()V
    //   470: iload 4
    //   472: iconst_1
    //   473: iadd
    //   474: istore 4
    //   476: goto -246 -> 230
    //   479: aload 13
    //   481: ldc_w 634
    //   484: aload 14
    //   486: invokevirtual 591	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   489: pop
    //   490: new 439	java/io/File
    //   493: dup
    //   494: aload 12
    //   496: ldc_w 636
    //   499: invokespecial 485	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   502: astore_1
    //   503: new 638	java/io/BufferedOutputStream
    //   506: dup
    //   507: new 491	java/io/FileOutputStream
    //   510: dup
    //   511: aload_1
    //   512: invokespecial 494	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   515: invokespecial 639	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   518: astore_2
    //   519: aload_2
    //   520: aload 13
    //   522: invokevirtual 640	org/json/JSONObject:toString	()Ljava/lang/String;
    //   525: invokevirtual 644	java/lang/String:getBytes	()[B
    //   528: invokevirtual 647	java/io/BufferedOutputStream:write	([B)V
    //   531: aload_2
    //   532: invokevirtual 648	java/io/BufferedOutputStream:flush	()V
    //   535: aload 11
    //   537: aload_1
    //   538: invokevirtual 476	java/io/File:getPath	()Ljava/lang/String;
    //   541: invokeinterface 477 2 0
    //   546: pop
    //   547: aload_2
    //   548: invokevirtual 649	java/io/BufferedOutputStream:close	()V
    //   551: goto +14 -> 565
    //   554: astore_1
    //   555: aload 9
    //   557: iconst_1
    //   558: ldc_w 651
    //   561: aload_1
    //   562: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aload 11
    //   567: invokeinterface 377 1 0
    //   572: ifne +93 -> 665
    //   575: new 148	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   582: astore_1
    //   583: aload_1
    //   584: aload 12
    //   586: invokevirtual 476	java/io/File:getPath	()Ljava/lang/String;
    //   589: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_1
    //   594: ldc_w 653
    //   597: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload_1
    //   602: aload 15
    //   604: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_1
    //   609: ldc_w 448
    //   612: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload_1
    //   617: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: astore_1
    //   621: aload 11
    //   623: aload_1
    //   624: invokestatic 529	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;Ljava/lang/String;)V
    //   627: aload 11
    //   629: invokestatic 656	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;)V
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
    //   646: invokevirtual 649	java/io/BufferedOutputStream:close	()V
    //   649: goto +14 -> 663
    //   652: astore_2
    //   653: aload 9
    //   655: iconst_1
    //   656: ldc_w 651
    //   659: aload_2
    //   660: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   0: new 697	android/os/Bundle
    //   3: dup
    //   4: invokespecial 698	android/os/Bundle:<init>	()V
    //   7: astore 8
    //   9: aload 8
    //   11: ldc_w 700
    //   14: ldc_w 384
    //   17: invokestatic 703	com/tencent/mobileqq/webview/swift/utils/SwiftWebViewUtils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 706	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: invokestatic 711	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   26: astore_1
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 715	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   32: aload_1
    //   33: aload 4
    //   35: invokevirtual 718	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +85 -> 125
    //   43: aload 8
    //   45: ldc_w 720
    //   48: aload_1
    //   49: invokevirtual 706	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +70 -> 125
    //   58: new 148	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   65: astore 6
    //   67: aload 6
    //   69: ldc_w 722
    //   72: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 6
    //   78: aload_1
    //   79: iconst_0
    //   80: anewarray 259	java/lang/String
    //   83: invokestatic 727	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   86: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: ldc_w 729
    //   95: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: aload 4
    //   103: iconst_0
    //   104: anewarray 259	java/lang/String
    //   107: invokestatic 731	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   110: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 140
    //   116: iconst_2
    //   117: aload 6
    //   119: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: new 148	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 736	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   137: invokevirtual 739	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ldc_w 741
    //   145: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore_1
    //   154: new 439	java/io/File
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 443	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 6
    //   164: aload 6
    //   166: invokevirtual 446	java/io/File:exists	()Z
    //   169: ifne +9 -> 178
    //   172: aload 6
    //   174: invokevirtual 480	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: lload_2
    //   179: invokestatic 744	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   182: astore 9
    //   184: new 148	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   191: astore 6
    //   193: aload 6
    //   195: aload_1
    //   196: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 6
    //   202: ldc_w 596
    //   205: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: aload 9
    //   213: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 6
    //   219: ldc_w 746
    //   222: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 6
    //   228: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 10
    //   233: new 439	java/io/File
    //   236: dup
    //   237: aload 10
    //   239: invokespecial 443	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 6
    //   244: aconst_null
    //   245: astore 7
    //   247: new 491	java/io/FileOutputStream
    //   250: dup
    //   251: aload 6
    //   253: invokespecial 494	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   256: astore 6
    //   258: new 562	java/net/URL
    //   261: dup
    //   262: aload 4
    //   264: invokespecial 563	java/net/URL:<init>	(Ljava/lang/String;)V
    //   267: invokevirtual 750	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   270: checkcast 752	java/net/HttpURLConnection
    //   273: astore 7
    //   275: aload 7
    //   277: ldc_w 754
    //   280: invokevirtual 757	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   283: aload 7
    //   285: sipush 6000
    //   288: invokevirtual 761	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   291: aload 7
    //   293: sipush 6000
    //   296: invokevirtual 764	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   299: aload 8
    //   301: invokevirtual 768	android/os/Bundle:keySet	()Ljava/util/Set;
    //   304: invokeinterface 771 1 0
    //   309: astore 4
    //   311: aload 4
    //   313: invokeinterface 245 1 0
    //   318: ifeq +47 -> 365
    //   321: aload 4
    //   323: invokeinterface 249 1 0
    //   328: checkcast 259	java/lang/String
    //   331: astore 11
    //   333: aload 8
    //   335: aload 11
    //   337: invokevirtual 773	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   340: astore 12
    //   342: aload 12
    //   344: instanceof 259
    //   347: ifeq -36 -> 311
    //   350: aload 7
    //   352: aload 11
    //   354: aload 12
    //   356: checkcast 259	java/lang/String
    //   359: invokevirtual 776	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -51 -> 311
    //   365: aload 7
    //   367: invokevirtual 779	java/net/HttpURLConnection:connect	()V
    //   370: sipush 200
    //   373: aload 7
    //   375: invokevirtual 782	java/net/HttpURLConnection:getResponseCode	()I
    //   378: if_icmpne +57 -> 435
    //   381: sipush 1024
    //   384: newarray byte
    //   386: astore 4
    //   388: new 784	java/io/BufferedInputStream
    //   391: dup
    //   392: aload 7
    //   394: invokevirtual 788	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   397: invokespecial 791	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   400: astore 8
    //   402: aload 8
    //   404: aload 4
    //   406: invokevirtual 797	java/io/InputStream:read	([B)I
    //   409: istore 5
    //   411: iconst_m1
    //   412: iload 5
    //   414: if_icmpeq +16 -> 430
    //   417: aload 6
    //   419: aload 4
    //   421: iconst_0
    //   422: iload 5
    //   424: invokevirtual 802	java/io/OutputStream:write	([BII)V
    //   427: goto -25 -> 402
    //   430: aload 6
    //   432: invokevirtual 803	java/io/OutputStream:flush	()V
    //   435: aload 6
    //   437: invokevirtual 804	java/io/OutputStream:close	()V
    //   440: goto +16 -> 456
    //   443: astore 4
    //   445: ldc 140
    //   447: iconst_1
    //   448: ldc_w 806
    //   451: aload 4
    //   453: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: aload 7
    //   458: ifnull +8 -> 466
    //   461: aload 7
    //   463: invokevirtual 809	java/net/HttpURLConnection:disconnect	()V
    //   466: new 436	java/util/ArrayList
    //   469: dup
    //   470: invokespecial 437	java/util/ArrayList:<init>	()V
    //   473: astore 4
    //   475: aload 4
    //   477: aload 10
    //   479: invokeinterface 477 2 0
    //   484: pop
    //   485: new 148	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   492: astore 6
    //   494: aload 6
    //   496: aload_1
    //   497: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 6
    //   503: ldc_w 596
    //   506: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 6
    //   512: aload 9
    //   514: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 6
    //   520: ldc_w 448
    //   523: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 6
    //   529: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: astore_1
    //   533: aload 4
    //   535: aload_1
    //   536: invokestatic 529	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;Ljava/lang/String;)V
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
    //   590: ldc 140
    //   592: iconst_1
    //   593: ldc_w 806
    //   596: aload 4
    //   598: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   619: invokevirtual 804	java/io/OutputStream:close	()V
    //   622: goto +16 -> 638
    //   625: astore 6
    //   627: ldc 140
    //   629: iconst_1
    //   630: ldc_w 806
    //   633: aload 6
    //   635: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   638: aload 4
    //   640: ifnull +8 -> 648
    //   643: aload 4
    //   645: invokevirtual 809	java/net/HttpURLConnection:disconnect	()V
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
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      str = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
  
  @Deprecated
  public List<String> a(Context paramContext)
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
  
  Map<String, Object> a(String paramString)
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
  
  public Set<String> a(Context paramContext)
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
          double d = localObject.length();
          Double.isNaN(d);
          localJSONArray2.put(d / 1000.0D);
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
    localIntent.putExtra("callback", this.jdField_a_of_type_AndroidOsResultReceiver);
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
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
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
      this.jdField_a_of_type_JavaUtilQueue.offer(new UnifiedDebugManager.Command(this, paramString1, paramInt, paramLong1, paramLong2, paramString2));
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
  
  public void a(Context paramContext, List<String> paramList)
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
      paramString = a(paramString);
      new UnifiedTraceRouter(paramQQAppInterface, paramHandler).a(paramLong, str, paramString);
      return;
    }
    throw new IOException("url is empty");
  }
  
  public boolean a(Context paramContext, long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      UnifiedDebugManager.Command localCommand = (UnifiedDebugManager.Command)this.jdField_a_of_type_JavaUtilQueue.poll();
      if ((localCommand != null) && (localCommand.jdField_b_of_type_Long == paramLong))
      {
        localCommand = (UnifiedDebugManager.Command)this.jdField_a_of_type_JavaUtilQueue.peek();
        if (localCommand != null)
        {
          b(paramContext, localCommand.jdField_a_of_type_JavaLangString, localCommand.jdField_a_of_type_Int, localCommand.jdField_a_of_type_Long, localCommand.jdField_b_of_type_Long, localCommand.jdField_b_of_type_JavaLangString);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("finish once webview debug, start new debug(dequeue one cmd): seq=");
            paramContext.append(localCommand.jdField_b_of_type_Long);
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
  
  public boolean a(File paramFile, List<String> paramList)
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
  
  public Set<String> b(Context paramContext)
  {
    paramContext = UnifiedFileUtil.a(a(paramContext));
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
  
  void b(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("debugUrl", paramString1);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString2);
    localIntent.putExtra("delay", paramLong1);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.jdField_a_of_type_AndroidOsResultReceiver);
    paramContext.startActivity(localIntent);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new UnifiedDebugManager.5(this, paramLong2, paramContext, paramString1, paramInt, paramLong1, paramString2), 120000L + paramLong1);
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
    paramContext = new File(a(paramContext));
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
    localIntent.putExtra("callback", this.jdField_a_of_type_AndroidOsResultReceiver);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("start alive snapshot, seq=");
      paramContext.append(paramLong2);
      QLog.d("UnifiedDebugManager", 2, paramContext.toString());
    }
  }
  
  public String d(String paramString)
  {
    return InetAddress.getByName(paramString).getHostAddress();
  }
  
  String e(String paramString)
  {
    return new URL(paramString).getHost();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager
 * JD-Core Version:    0.7.0.1
 */