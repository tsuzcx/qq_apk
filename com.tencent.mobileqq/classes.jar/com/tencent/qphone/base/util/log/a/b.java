package com.tencent.qphone.base.util.log.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.QLog.LogFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtloginHelper;

public class b
{
  public static final int a = 16;
  public static final String b = "private-";
  public static long c = 20971520L;
  public static int d = 10;
  public static int e = 3;
  static String f = "MSF.C.LogManager";
  public static boolean g = true;
  static int h = 0;
  static boolean i = false;
  static long j = 0L;
  static String k = "log_manager_sp";
  static boolean l = false;
  static String m = "https://qqlog.qq.com/log/passive/upload.jsp";
  static String n = "https://qqlog.qq.com/log/active/creport.jsp";
  static String o = "https://qqlog.qq.com/log/passive/report.jsp";
  public static final String p = "/tencent/msflogs/corruptInfo";
  public static int q = 1;
  public static int r = 2;
  public static int s = 3;
  private static final int t = 10000;
  private static final String u = "/data/anr/traces.txt";
  private static long v = 0L;
  private static Handler w = new c(Looper.getMainLooper());
  private static final BroadcastReceiver x = new d();
  private static final String y = "/tencent/wtlogin/com.tencent.mobileqq/";
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString, b.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i(f, 2, "zip file start");
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, 0, 0);
    long l3 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt5, paramInt6 - 1, paramInt7, paramInt8, 0, 0);
    long l1 = ((Calendar)localObject1).getTimeInMillis();
    long l2 = System.currentTimeMillis();
    if (l1 >= l2)
    {
      ((Calendar)localObject1).setTimeInMillis(l2);
      l1 = l2;
    }
    Object localObject7 = new HashSet();
    l2 = l3;
    int i2 = 0;
    int i1;
    long l4;
    do
    {
      localObject1 = QLog.getLogFileFormatter().format(Long.valueOf(l2));
      ((HashSet)localObject7).add(localObject1);
      i1 = i2;
      if (i2 == 0) {
        i1 = ((String)localObject1).length();
      }
      l4 = l2 + 3600000L;
      l2 = l4;
      i2 = i1;
    } while (l4 <= l1);
    Object localObject3 = new ArrayList();
    Object localObject6 = new File(QLog.getLogPath());
    Object localObject8;
    if (((File)localObject6).exists())
    {
      localObject8 = ((File)localObject6).listFiles();
      localObject1 = localObject3;
      if (localObject8 != null)
      {
        int i3 = localObject8.length;
        i2 = 0;
        for (;;)
        {
          localObject1 = localObject3;
          if (i2 >= i3) {
            break;
          }
          Object localObject9 = localObject8[i2];
          localObject5 = localObject9.getName();
          if (((String)localObject5).endsWith(".log"))
          {
            localObject1 = ((String)localObject5).substring(0, ((String)localObject5).length() - 4);
          }
          else if (((String)localObject5).endsWith(".log.zip"))
          {
            localObject1 = ((String)localObject5).substring(0, ((String)localObject5).length() - 8);
          }
          else
          {
            localObject1 = localObject5;
            if (((String)localObject5).endsWith(".qlog")) {
              localObject1 = ((String)localObject5).substring(0, ((String)localObject5).length() - 5);
            }
          }
          if ((((String)localObject1).startsWith(QLog.getPackageName())) && (((HashSet)localObject7).contains(((String)localObject1).substring(((String)localObject1).length() - i1))))
          {
            localObject1 = new QLog.LogFile(localObject9.getPath());
            ((ArrayList)localObject3).add(localObject1);
            parama.c += ((QLog.LogFile)localObject1).length();
            parama.e = 0L;
          }
          i2 += 1;
        }
      }
    }
    else
    {
      localObject1 = localObject3;
      ((File)localObject6).mkdirs();
    }
    localObject3 = new QLog.LogFile("/data/anr/traces.txt");
    if (((QLog.LogFile)localObject3).exists()) {
      if (((QLog.LogFile)localObject3).length() > 0L) {
        ((ArrayList)localObject1).add(localObject3);
      } else {}
    }
    Object localObject5 = localObject1;
    boolean bool;
    try
    {
      bool = ((File)localObject6).exists();
      if (bool)
      {
        localObject1 = new QLog.LogFile((File)localObject6, "FileList.log");
        try
        {
          localObject3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
          localObject6 = ((File)localObject6).listFiles();
          if (localObject6 != null)
          {
            i2 = localObject6.length;
            i1 = 0;
            while (i1 < i2)
            {
              localObject7 = localObject6[i1];
              localObject8 = new StringBuilder();
              ((StringBuilder)localObject8).append(((File)localObject7).getName());
              ((StringBuilder)localObject8).append("\n");
              ((BufferedWriter)localObject3).write(((StringBuilder)localObject8).toString());
              i1 += 1;
            }
          }
          ((BufferedWriter)localObject3).flush();
          ((BufferedWriter)localObject3).close();
        }
        catch (Exception localException1)
        {
          break label710;
        }
      }
      else
      {
        ((File)localObject6).mkdir();
        localObject1 = new QLog.LogFile((File)localObject6, "FileList.log");
        try
        {
          BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
          localBufferedWriter.write("no log file in old and new path.");
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException2) {}
      }
      localObject6 = f;
    }
    catch (Exception localException3)
    {
      localObject1 = null;
    }
    label710:
    localObject7 = new StringBuilder();
    ((StringBuilder)localObject7).append("read Log file list error. ");
    ((StringBuilder)localObject7).append(localException3);
    QLog.d((String)localObject6, 1, ((StringBuilder)localObject7).toString(), localException3);
    if (localObject1 != null) {
      ((ArrayList)localObject5).add(localObject1);
    }
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l3);
    ((Calendar)localObject1).set(11, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    ((Calendar)localObject1).set(14, 0);
    l1 = ((Calendar)localObject1).getTimeInMillis();
    if ((i) && (j == l1))
    {
      localObject1 = null;
    }
    else
    {
      localObject4 = com.tencent.mobileqq.msf.core.c.d.a(l1, 86400000L + l1);
      localObject1 = localObject4;
      if (QLog.isColorLevel())
      {
        localObject1 = f;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("get user 24h netflow ");
        if (localObject4 == null) {
          bool = false;
        } else {
          bool = true;
        }
        ((StringBuilder)localObject6).append(bool);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject6).toString());
        localObject1 = localObject4;
      }
    }
    if (localObject1 != null)
    {
      i = true;
      j = l1;
      ((ArrayList)localObject5).add(localObject1);
    }
    a((ArrayList)localObject5);
    a((ArrayList)localObject5, paramInt1, paramInt2, paramInt3, paramInt5, paramInt6, paramInt7);
    try
    {
      a((ArrayList)localObject5, parama, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e(f, 1, "zipLog: failed. ", localThrowable);
    }
    if (parama.c == 0L) {
      parama.e = 1L;
    }
    a.a(a.j, paramString, 20, parama);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(QLog.getLogPath());
    ((StringBuilder)localObject2).append(String.format("%d_%d_%d_%d--%d_%d_%d_%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8) }));
    Object localObject4 = ((StringBuilder)localObject2).toString();
    paramInt1 = -1;
    do
    {
      paramInt1 += 1;
      if (paramInt1 != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject4);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(".zip");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject4);
        ((StringBuilder)localObject2).append(".zip");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    } while (new File((String)localObject2).exists());
    a((ArrayList)localObject5, (String)localObject2);
    b((ArrayList)localObject5);
    parama.d = new File((String)localObject2).length();
    a.a(a.j, paramString, 30, parama);
    return localObject2;
  }
  
  public static void a()
  {
    try
    {
      if (!l)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        BaseApplication.getContext().registerReceiver(x, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d(f, 2, "LogManager inited.");
        }
        l = true;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: iconst_1
    //   2: if_icmplt +217 -> 219
    //   5: iload_0
    //   6: iconst_4
    //   7: if_icmple +4 -> 11
    //   10: return
    //   11: iload_0
    //   12: invokestatic 394	com/tencent/qphone/base/util/QLog:setManualLogLevel	(I)V
    //   15: invokestatic 397	com/tencent/qphone/base/util/QLog:isExistSDCard	()Z
    //   18: ifeq +189 -> 207
    //   21: aconst_null
    //   22: astore 5
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore_3
    //   29: aload 5
    //   31: astore_1
    //   32: new 181	java/io/File
    //   35: dup
    //   36: invokestatic 400	com/tencent/qphone/base/util/QLog:getManualLogLevelPath	()Ljava/lang/String;
    //   39: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: aload 5
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 191	java/io/File:exists	()Z
    //   52: ifne +12 -> 64
    //   55: aload 5
    //   57: astore_1
    //   58: aload 6
    //   60: invokevirtual 403	java/io/File:createNewFile	()Z
    //   63: pop
    //   64: aload_3
    //   65: astore_2
    //   66: aload 5
    //   68: astore_1
    //   69: aload 6
    //   71: invokevirtual 191	java/io/File:exists	()Z
    //   74: ifeq +64 -> 138
    //   77: aload_3
    //   78: astore_2
    //   79: aload 5
    //   81: astore_1
    //   82: aload 6
    //   84: invokevirtual 406	java/io/File:isFile	()Z
    //   87: ifeq +51 -> 138
    //   90: aload 5
    //   92: astore_1
    //   93: new 250	java/io/BufferedWriter
    //   96: dup
    //   97: new 408	java/io/FileWriter
    //   100: dup
    //   101: invokestatic 400	com/tencent/qphone/base/util/QLog:getManualLogLevelPath	()Ljava/lang/String;
    //   104: invokespecial 409	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   107: invokespecial 263	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   110: astore_2
    //   111: aload_2
    //   112: iload_0
    //   113: invokestatic 411	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   116: invokevirtual 278	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   119: aload_2
    //   120: invokevirtual 281	java/io/BufferedWriter:flush	()V
    //   123: goto +15 -> 138
    //   126: astore_3
    //   127: aload_2
    //   128: astore_1
    //   129: aload_3
    //   130: astore_2
    //   131: goto +58 -> 189
    //   134: astore_3
    //   135: goto +22 -> 157
    //   138: aload_2
    //   139: ifnull +68 -> 207
    //   142: aload_2
    //   143: invokevirtual 284	java/io/BufferedWriter:close	()V
    //   146: goto +61 -> 207
    //   149: astore_2
    //   150: goto +39 -> 189
    //   153: astore_3
    //   154: aload 4
    //   156: astore_2
    //   157: aload_2
    //   158: astore_1
    //   159: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   162: iconst_1
    //   163: ldc_w 413
    //   166: aload_3
    //   167: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_2
    //   171: ifnull +36 -> 207
    //   174: aload_2
    //   175: invokevirtual 284	java/io/BufferedWriter:close	()V
    //   178: goto +29 -> 207
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   186: goto +21 -> 207
    //   189: aload_1
    //   190: ifnull +15 -> 205
    //   193: aload_1
    //   194: invokevirtual 284	java/io/BufferedWriter:close	()V
    //   197: goto +8 -> 205
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   205: aload_2
    //   206: athrow
    //   207: ldc_w 416
    //   210: getstatic 422	com/tencent/mobileqq/msf/service/MsfService:core	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   213: invokevirtual 427	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   216: invokestatic 431	com/tencent/mobileqq/msf/core/MsfCore:initAppProMsg	(Ljava/lang/String;I)V
    //   219: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramInt	int
    //   31	128	1	localObject1	Object
    //   181	13	1	localIOException1	java.io.IOException
    //   200	2	1	localIOException2	java.io.IOException
    //   65	78	2	localObject2	Object
    //   149	1	2	localObject3	Object
    //   156	50	2	localObject4	Object
    //   28	50	3	localObject5	Object
    //   126	4	3	localObject6	Object
    //   134	1	3	localThrowable1	Throwable
    //   153	14	3	localThrowable2	Throwable
    //   25	130	4	localObject7	Object
    //   22	69	5	localObject8	Object
    //   42	41	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   111	123	126	finally
    //   111	123	134	java/lang/Throwable
    //   32	44	149	finally
    //   47	55	149	finally
    //   58	64	149	finally
    //   69	77	149	finally
    //   82	90	149	finally
    //   93	111	149	finally
    //   159	170	149	finally
    //   32	44	153	java/lang/Throwable
    //   47	55	153	java/lang/Throwable
    //   58	64	153	java/lang/Throwable
    //   69	77	153	java/lang/Throwable
    //   82	90	153	java/lang/Throwable
    //   93	111	153	java/lang/Throwable
    //   142	146	181	java/io/IOException
    //   174	178	181	java/io/IOException
    //   193	197	200	java/io/IOException
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QLog.d(f, 1, new Object[] { "checkManualLogLevel, opType: ", Integer.valueOf(paramInt1), " logLevel: ", Integer.valueOf(paramInt2) });
    if (paramInt1 == q)
    {
      a(paramInt2);
      return;
    }
    if (paramInt1 == s)
    {
      QLog.setUIN_REPORTLOG_LEVEL(paramInt2);
      MsfStore.getNativeConfigStore().setConfig("LOGLEVEL_", String.valueOf(paramInt2));
      MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
      MsfCore.initAppProMsg("*", MsfService.core.getMsfAppid());
      return;
    }
    if (paramInt1 == r)
    {
      File localFile = new File(QLog.getManualLogLevelPath());
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.setUIN_REPORTLOG_LEVEL(paramInt2);
      MsfStore.getNativeConfigStore().setConfig("LOGLEVEL_", String.valueOf(paramInt2));
      MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
      MsfCore.initAppProMsg("*", MsfService.core.getMsfAppid());
    }
  }
  
  public static void a(int paramInt, File paramFile, String paramString, b.a parama)
  {
    if (c < 1024L) {
      c = 1024L;
    }
    int i2 = 1;
    long l5 = paramFile.length();
    parama.f = true;
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, new Object[] { "want send size ", Long.valueOf(l5) });
    }
    long l1 = c;
    long l2 = 0L;
    if (l5 % l1 > 0L) {
      l1 = l5 / l1 + 1L;
    } else {
      l1 = l5 / l1;
    }
    int i3 = (int)l1;
    int i1;
    if (NetConnInfoCenter.isWifiConn()) {
      i1 = d;
    } else {
      i1 = e;
    }
    l1 = l2;
    if (i3 > i1)
    {
      paramFile = o();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report size is too big ");
      localStringBuilder.append(l5);
      a(paramInt, paramFile, localStringBuilder.toString(), MsfSdkUtils.insertMtype("reportLog", m), 1, i3, parama, null, null);
      a.a(a.j, paramString, 41, parama);
      return;
    }
    while (l1 < l5)
    {
      long l3 = l5 - l1;
      long l4 = c;
      l2 = l3;
      if (l3 > l4) {
        l2 = l4;
      }
      a(paramInt, o(), paramFile, MsfSdkUtils.insertMtype("reportLog", m), i2, i3, l1, l2, false, "", "", parama.b, null, null);
      l1 += l2;
      i2 += 1;
    }
    j.a(parama.b);
    a.a(a.j, paramString, 40, parama);
  }
  
  /* Error */
  private static void a(int paramInt1, String paramString1, File paramFile, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean, String paramString3, String paramString4, long paramLong3, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: new 513	java/net/URL
    //   3: dup
    //   4: aload_3
    //   5: invokespecial 514	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 518	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 520	java/net/HttpURLConnection
    //   14: astore_3
    //   15: aload_3
    //   16: iconst_1
    //   17: invokevirtual 524	java/net/HttpURLConnection:setDoInput	(Z)V
    //   20: aload_3
    //   21: iconst_1
    //   22: invokevirtual 527	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 530	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   30: aload_3
    //   31: ldc_w 532
    //   34: invokevirtual 535	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   37: aload_3
    //   38: ldc_w 537
    //   41: ldc_w 539
    //   44: invokevirtual 543	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: new 265	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   54: astore 19
    //   56: aload 19
    //   58: ldc_w 545
    //   61: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 19
    //   67: ldc_w 547
    //   70: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 19
    //   76: aload_1
    //   77: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: ldc_w 549
    //   85: aload 19
    //   87: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokevirtual 543	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_3
    //   94: lload 13
    //   96: aload 15
    //   98: aload 16
    //   100: invokestatic 552	com/tencent/qphone/base/util/log/a/b:a	(Ljava/net/HttpURLConnection;JLjava/lang/String;Ljava/lang/String;)V
    //   103: new 554	java/io/DataOutputStream
    //   106: dup
    //   107: aload_3
    //   108: invokevirtual 558	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   111: invokespecial 559	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   114: astore 15
    //   116: new 265	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   123: astore 16
    //   125: aload 16
    //   127: aload_1
    //   128: iload_0
    //   129: iload 4
    //   131: iload 5
    //   133: invokestatic 562	com/tencent/qphone/base/util/log/a/b:a	(Ljava/lang/StringBuilder;Ljava/lang/String;III)V
    //   136: aload 16
    //   138: ldc_w 564
    //   141: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 16
    //   147: aload_1
    //   148: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 16
    //   154: ldc_w 566
    //   157: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 16
    //   163: ldc_w 568
    //   166: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 16
    //   172: aload_2
    //   173: invokevirtual 198	java/io/File:getName	()Ljava/lang/String;
    //   176: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 16
    //   182: ldc_w 566
    //   185: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 16
    //   191: ldc_w 564
    //   194: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 16
    //   200: aload_1
    //   201: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 16
    //   207: ldc_w 566
    //   210: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 16
    //   216: ldc_w 570
    //   219: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 16
    //   225: ldc_w 572
    //   228: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 16
    //   234: ldc_w 566
    //   237: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 16
    //   243: ldc_w 564
    //   246: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 16
    //   252: aload_1
    //   253: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 16
    //   259: ldc_w 566
    //   262: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 16
    //   268: ldc_w 574
    //   271: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 16
    //   277: lload 13
    //   279: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 16
    //   285: ldc_w 566
    //   288: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: iload 10
    //   294: ifeq +105 -> 399
    //   297: aload 16
    //   299: ldc_w 564
    //   302: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 16
    //   308: aload_1
    //   309: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 16
    //   315: ldc_w 566
    //   318: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 16
    //   324: ldc_w 576
    //   327: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 16
    //   333: aload 11
    //   335: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 16
    //   341: ldc_w 566
    //   344: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 16
    //   350: ldc_w 564
    //   353: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 16
    //   359: aload_1
    //   360: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 16
    //   366: ldc_w 566
    //   369: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 16
    //   375: ldc_w 578
    //   378: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 16
    //   384: aload 12
    //   386: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 16
    //   392: ldc_w 566
    //   395: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 16
    //   401: ldc_w 564
    //   404: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 16
    //   410: aload_1
    //   411: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 16
    //   417: ldc_w 566
    //   420: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: new 265	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   431: astore 11
    //   433: aload 11
    //   435: ldc_w 580
    //   438: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 11
    //   444: aload_2
    //   445: invokevirtual 198	java/io/File:getName	()Ljava/lang/String;
    //   448: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 11
    //   454: ldc_w 582
    //   457: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 16
    //   463: aload 11
    //   465: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 16
    //   474: ldc_w 584
    //   477: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 15
    //   483: aload 16
    //   485: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: ldc_w 539
    //   491: invokevirtual 588	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   494: invokevirtual 591	java/io/DataOutputStream:write	([B)V
    //   497: new 593	java/io/FileInputStream
    //   500: dup
    //   501: aload_2
    //   502: invokespecial 594	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   505: astore_2
    //   506: sipush 20480
    //   509: newarray byte
    //   511: astore 11
    //   513: lconst_0
    //   514: lstore 17
    //   516: lload 17
    //   518: lstore 13
    //   520: lload 6
    //   522: lconst_0
    //   523: lcmp
    //   524: ifle +14 -> 538
    //   527: aload_2
    //   528: lload 6
    //   530: invokevirtual 597	java/io/FileInputStream:skip	(J)J
    //   533: pop2
    //   534: lload 17
    //   536: lstore 13
    //   538: aload_2
    //   539: aload 11
    //   541: iconst_0
    //   542: sipush 20480
    //   545: invokevirtual 601	java/io/FileInputStream:read	([BII)I
    //   548: istore_0
    //   549: iload_0
    //   550: iconst_m1
    //   551: if_icmpeq +156 -> 707
    //   554: iload_0
    //   555: i2l
    //   556: lload 13
    //   558: ladd
    //   559: lstore 6
    //   561: lload 6
    //   563: lload 8
    //   565: lcmp
    //   566: ifle +77 -> 643
    //   569: lload 8
    //   571: lload 13
    //   573: lsub
    //   574: lstore 6
    //   576: lload 6
    //   578: l2i
    //   579: istore_0
    //   580: aload 15
    //   582: aload 11
    //   584: iconst_0
    //   585: iload_0
    //   586: invokevirtual 604	java/io/DataOutputStream:write	([BII)V
    //   589: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq +115 -> 707
    //   595: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   598: astore 11
    //   600: new 265	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   607: astore 12
    //   609: aload 12
    //   611: ldc_w 606
    //   614: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 12
    //   620: lload 13
    //   622: lload 6
    //   624: ladd
    //   625: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 11
    //   631: iconst_2
    //   632: aload 12
    //   634: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   640: goto +67 -> 707
    //   643: aload 15
    //   645: aload 11
    //   647: iconst_0
    //   648: iload_0
    //   649: invokevirtual 604	java/io/DataOutputStream:write	([BII)V
    //   652: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   655: ifeq +45 -> 700
    //   658: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   661: astore 12
    //   663: new 265	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   670: astore 16
    //   672: aload 16
    //   674: ldc_w 606
    //   677: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload 16
    //   683: lload 6
    //   685: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 12
    //   691: iconst_2
    //   692: aload 16
    //   694: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: lload 6
    //   702: lstore 13
    //   704: goto -166 -> 538
    //   707: aload_2
    //   708: invokevirtual 607	java/io/FileInputStream:close	()V
    //   711: aload 15
    //   713: ldc_w 566
    //   716: invokevirtual 610	java/lang/String:getBytes	()[B
    //   719: invokevirtual 591	java/io/DataOutputStream:write	([B)V
    //   722: new 265	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   729: astore_2
    //   730: aload_2
    //   731: ldc_w 564
    //   734: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_2
    //   739: aload_1
    //   740: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload_2
    //   745: ldc_w 612
    //   748: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload 15
    //   754: aload_2
    //   755: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokevirtual 610	java/lang/String:getBytes	()[B
    //   761: invokevirtual 591	java/io/DataOutputStream:write	([B)V
    //   764: aload 15
    //   766: invokevirtual 613	java/io/DataOutputStream:flush	()V
    //   769: aload 15
    //   771: invokevirtual 614	java/io/DataOutputStream:close	()V
    //   774: aload_3
    //   775: invokestatic 617	com/tencent/qphone/base/util/log/a/b:a	(Ljava/net/HttpURLConnection;)V
    //   778: aload_3
    //   779: ifnull +7 -> 786
    //   782: aload_3
    //   783: invokevirtual 620	java/net/HttpURLConnection:disconnect	()V
    //   786: invokestatic 625	android/net/TrafficStats:clearThreadStatsTag	()V
    //   789: return
    //   790: astore_1
    //   791: aload_2
    //   792: invokevirtual 607	java/io/FileInputStream:close	()V
    //   795: aload_1
    //   796: athrow
    //   797: astore_1
    //   798: aload_3
    //   799: astore_2
    //   800: goto +6 -> 806
    //   803: astore_1
    //   804: aconst_null
    //   805: astore_2
    //   806: aload_2
    //   807: ifnull +7 -> 814
    //   810: aload_2
    //   811: invokevirtual 620	java/net/HttpURLConnection:disconnect	()V
    //   814: invokestatic 625	android/net/TrafficStats:clearThreadStatsTag	()V
    //   817: goto +5 -> 822
    //   820: aload_1
    //   821: athrow
    //   822: goto -2 -> 820
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	825	0	paramInt1	int
    //   0	825	1	paramString1	String
    //   0	825	2	paramFile	File
    //   0	825	3	paramString2	String
    //   0	825	4	paramInt2	int
    //   0	825	5	paramInt3	int
    //   0	825	6	paramLong1	long
    //   0	825	8	paramLong2	long
    //   0	825	10	paramBoolean	boolean
    //   0	825	11	paramString3	String
    //   0	825	12	paramString4	String
    //   0	825	13	paramLong3	long
    //   0	825	15	paramString5	String
    //   0	825	16	paramString6	String
    //   514	21	17	l1	long
    //   54	32	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   506	513	790	finally
    //   527	534	790	finally
    //   538	549	790	finally
    //   580	640	790	finally
    //   643	700	790	finally
    //   15	292	797	finally
    //   297	399	797	finally
    //   399	506	797	finally
    //   707	778	797	finally
    //   791	797	797	finally
    //   0	15	803	finally
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DataOutputStream paramDataOutputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, paramString1, paramInt1, paramInt2, paramInt3);
    localStringBuilder.append("--");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=errormsg\r\n\r\n");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("--");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
    localStringBuilder.append("");
    localStringBuilder.append("\r\n");
    paramString2 = new StringBuilder();
    paramString2.append("--");
    paramString2.append(paramString1);
    paramString2.append("--\r\n");
    localStringBuilder.append(paramString2.toString());
    paramDataOutputStream.write(localStringBuilder.toString().getBytes("UTF-8"));
    paramDataOutputStream.flush();
    paramDataOutputStream.close();
  }
  
  /* Error */
  private static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, b.a parama, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: new 513	java/net/URL
    //   3: dup
    //   4: aload_3
    //   5: invokespecial 514	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 518	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 520	java/net/HttpURLConnection
    //   14: astore_3
    //   15: aload_3
    //   16: iconst_1
    //   17: invokevirtual 524	java/net/HttpURLConnection:setDoInput	(Z)V
    //   20: aload_3
    //   21: iconst_1
    //   22: invokevirtual 527	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 530	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   30: aload_3
    //   31: ldc_w 532
    //   34: invokevirtual 535	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   37: aload_3
    //   38: ldc_w 537
    //   41: ldc_w 539
    //   44: invokevirtual 543	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: new 265	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   54: astore 11
    //   56: aload 11
    //   58: ldc_w 545
    //   61: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 11
    //   67: ldc_w 547
    //   70: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 11
    //   76: aload_1
    //   77: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: ldc_w 549
    //   85: aload 11
    //   87: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokevirtual 543	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 6
    //   95: ifnull +82 -> 177
    //   98: aload 6
    //   100: getfield 504	com/tencent/qphone/base/util/log/a/b$a:b	J
    //   103: lstore 9
    //   105: goto +3 -> 108
    //   108: aload_3
    //   109: lload 9
    //   111: aload 7
    //   113: aload 8
    //   115: invokestatic 552	com/tencent/qphone/base/util/log/a/b:a	(Ljava/net/HttpURLConnection;JLjava/lang/String;Ljava/lang/String;)V
    //   118: iload_0
    //   119: aload_1
    //   120: aload_2
    //   121: iload 4
    //   123: iload 5
    //   125: new 554	java/io/DataOutputStream
    //   128: dup
    //   129: aload_3
    //   130: invokevirtual 558	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   133: invokespecial 559	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   136: invokestatic 630	com/tencent/qphone/base/util/log/a/b:a	(ILjava/lang/String;Ljava/lang/String;IILjava/io/DataOutputStream;)V
    //   139: aload_3
    //   140: invokestatic 617	com/tencent/qphone/base/util/log/a/b:a	(Ljava/net/HttpURLConnection;)V
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 620	java/net/HttpURLConnection:disconnect	()V
    //   151: invokestatic 625	android/net/TrafficStats:clearThreadStatsTag	()V
    //   154: return
    //   155: astore_1
    //   156: aload_3
    //   157: astore_2
    //   158: goto +6 -> 164
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 620	java/net/HttpURLConnection:disconnect	()V
    //   172: invokestatic 625	android/net/TrafficStats:clearThreadStatsTag	()V
    //   175: aload_1
    //   176: athrow
    //   177: lconst_0
    //   178: lstore 9
    //   180: goto -72 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramInt1	int
    //   0	183	1	paramString1	String
    //   0	183	2	paramString2	String
    //   0	183	3	paramString3	String
    //   0	183	4	paramInt2	int
    //   0	183	5	paramInt3	int
    //   0	183	6	parama	b.a
    //   0	183	7	paramString4	String
    //   0	183	8	paramString5	String
    //   103	76	9	l1	long
    //   54	32	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	93	155	finally
    //   98	105	155	finally
    //   108	143	155	finally
    //   0	15	161	finally
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    long l1;
    int i1;
    int i2;
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return;
      }
      paramString1 = new File(paramString1);
      if (paramString1.exists())
      {
        try
        {
          if (c < 1024L) {
            c = 1024L;
          }
          if (QLog.isColorLevel())
          {
            String str = f;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("want send size ");
            localStringBuilder.append(paramString1.length());
            QLog.d(str, 2, localStringBuilder.toString());
          }
          if (paramString1.length() % c > 0L) {
            l1 = paramString1.length() / c + 1L;
          } else {
            l1 = paramString1.length() / c;
          }
        }
        catch (Exception paramString1)
        {
          if (!QLog.isColorLevel()) {
            break label357;
          }
        }
        if (NetConnInfoCenter.isWifiConn()) {
          i1 = d;
        } else {
          i1 = e;
        }
        if (i2 <= i1) {
          break label366;
        }
        paramString2 = o();
        paramString3 = new StringBuilder();
        paramString3.append("report size is too big ");
        paramString3.append(paramString1.length());
        a(paramInt, paramString2, paramString3.toString(), MsfSdkUtils.insertMtype("reportLog", n), 1, i2, null, paramString4, paramString5);
      }
    }
    for (;;)
    {
      if (l1 < paramString1.length())
      {
        long l3 = paramString1.length() - l1;
        long l2 = l3;
        if (l3 > c) {
          l2 = c;
        }
        a(paramInt, o(), paramString1, n, i1, i2, l1, l2, true, paramString2, paramString3, 0L, paramString4, paramString5);
        l1 += l2;
        i1 += 1;
        continue;
        paramString2 = f;
        paramString3 = new StringBuilder();
        paramString3.append("report log error ");
        paramString3.append(paramString1);
        QLog.d(paramString2, 2, paramString3.toString(), paramString1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(f, 2, "logName is not existed.");
        }
      }
      label357:
      return;
      i2 = (int)l1;
      break;
      label366:
      l1 = 0L;
      i1 = 1;
    }
  }
  
  /* Error */
  public static void a(b.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 638	com/tencent/qphone/base/util/log/a/b$a:a	I
    //   4: invokestatic 640	com/tencent/qphone/base/util/log/a/a:a	(I)Ljava/lang/String;
    //   7: astore 6
    //   9: getstatic 642	com/tencent/qphone/base/util/log/a/a:a	Ljava/lang/String;
    //   12: iconst_1
    //   13: aload_0
    //   14: invokevirtual 643	com/tencent/qphone/base/util/log/a/b$a:toString	()Ljava/lang/String;
    //   17: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: getstatic 646	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   23: getfield 650	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   26: invokevirtual 654	com/tencent/mobileqq/msf/core/ac:m	()I
    //   29: istore_1
    //   30: invokestatic 484	com/tencent/qphone/base/util/log/a/b:o	()Ljava/lang/String;
    //   33: astore 5
    //   35: aconst_null
    //   36: astore 4
    //   38: aconst_null
    //   39: astore_2
    //   40: new 513	java/net/URL
    //   43: dup
    //   44: getstatic 93	com/tencent/qphone/base/util/log/a/b:o	Ljava/lang/String;
    //   47: invokespecial 514	java/net/URL:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 518	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: checkcast 520	java/net/HttpURLConnection
    //   56: astore_3
    //   57: aload_3
    //   58: iconst_1
    //   59: invokevirtual 524	java/net/HttpURLConnection:setDoInput	(Z)V
    //   62: aload_3
    //   63: iconst_1
    //   64: invokevirtual 527	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual 530	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   72: aload_3
    //   73: ldc_w 532
    //   76: invokevirtual 535	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   79: aload_3
    //   80: ldc_w 537
    //   83: ldc_w 539
    //   86: invokevirtual 543	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: new 265	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   96: astore_2
    //   97: aload_2
    //   98: ldc_w 545
    //   101: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: ldc_w 547
    //   109: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: aload 5
    //   116: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_3
    //   121: ldc_w 549
    //   124: aload_2
    //   125: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 543	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_3
    //   132: aload_0
    //   133: getfield 504	com/tencent/qphone/base/util/log/a/b$a:b	J
    //   136: aconst_null
    //   137: aconst_null
    //   138: invokestatic 552	com/tencent/qphone/base/util/log/a/b:a	(Ljava/net/HttpURLConnection;JLjava/lang/String;Ljava/lang/String;)V
    //   141: new 554	java/io/DataOutputStream
    //   144: dup
    //   145: aload_3
    //   146: invokevirtual 558	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   149: invokespecial 559	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   152: astore_2
    //   153: new 265	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   160: astore 4
    //   162: aload 4
    //   164: aload 5
    //   166: iload_1
    //   167: iconst_0
    //   168: iconst_0
    //   169: invokestatic 562	com/tencent/qphone/base/util/log/a/b:a	(Ljava/lang/StringBuilder;Ljava/lang/String;III)V
    //   172: aload 4
    //   174: ldc_w 564
    //   177: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: aload 5
    //   185: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 4
    //   191: ldc_w 566
    //   194: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: ldc_w 656
    //   203: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 4
    //   209: invokestatic 659	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getAppVersion	()Ljava/lang/String;
    //   212: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: ldc_w 566
    //   221: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: ldc_w 564
    //   230: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: aload 5
    //   238: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 4
    //   244: ldc_w 566
    //   247: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: ldc_w 661
    //   256: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 4
    //   262: invokestatic 664	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetStateString	()Ljava/lang/String;
    //   265: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 4
    //   271: ldc_w 566
    //   274: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 4
    //   280: ldc_w 564
    //   283: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 4
    //   289: aload 5
    //   291: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 4
    //   297: ldc_w 566
    //   300: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 4
    //   306: ldc_w 574
    //   309: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 4
    //   315: aload_0
    //   316: getfield 504	com/tencent/qphone/base/util/log/a/b$a:b	J
    //   319: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 4
    //   325: ldc_w 566
    //   328: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 4
    //   334: ldc_w 564
    //   337: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 4
    //   343: aload 5
    //   345: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 4
    //   351: ldc_w 566
    //   354: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 4
    //   360: ldc_w 666
    //   363: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 4
    //   369: aload 6
    //   371: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 4
    //   377: ldc_w 566
    //   380: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 4
    //   386: ldc_w 564
    //   389: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 4
    //   395: aload 5
    //   397: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 4
    //   403: ldc_w 566
    //   406: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 4
    //   412: ldc_w 668
    //   415: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 4
    //   421: aload_0
    //   422: getfield 235	com/tencent/qphone/base/util/log/a/b$a:c	J
    //   425: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 4
    //   431: ldc_w 566
    //   434: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 4
    //   440: ldc_w 564
    //   443: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 4
    //   449: aload 5
    //   451: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 4
    //   457: ldc_w 566
    //   460: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 4
    //   466: ldc_w 670
    //   469: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 4
    //   475: aload_0
    //   476: getfield 366	com/tencent/qphone/base/util/log/a/b$a:d	J
    //   479: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 4
    //   485: ldc_w 566
    //   488: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 4
    //   494: ldc_w 564
    //   497: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 4
    //   503: aload 5
    //   505: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 4
    //   511: ldc_w 566
    //   514: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 4
    //   520: ldc_w 672
    //   523: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 4
    //   529: aload_0
    //   530: getfield 239	com/tencent/qphone/base/util/log/a/b$a:e	J
    //   533: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 4
    //   539: ldc_w 566
    //   542: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 4
    //   548: ldc_w 564
    //   551: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 4
    //   557: aload 5
    //   559: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 4
    //   565: ldc_w 566
    //   568: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 4
    //   574: ldc_w 674
    //   577: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 4
    //   583: iconst_m1
    //   584: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 4
    //   590: ldc_w 566
    //   593: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: new 265	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   604: astore_0
    //   605: aload_0
    //   606: ldc_w 564
    //   609: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_0
    //   614: aload 5
    //   616: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_0
    //   621: ldc_w 612
    //   624: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 4
    //   630: aload_0
    //   631: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload_2
    //   639: aload 4
    //   641: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: ldc_w 539
    //   647: invokevirtual 588	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   650: invokevirtual 591	java/io/DataOutputStream:write	([B)V
    //   653: aload_2
    //   654: invokevirtual 613	java/io/DataOutputStream:flush	()V
    //   657: aload_2
    //   658: invokevirtual 614	java/io/DataOutputStream:close	()V
    //   661: aload_3
    //   662: invokestatic 617	com/tencent/qphone/base/util/log/a/b:a	(Ljava/net/HttpURLConnection;)V
    //   665: aload_3
    //   666: ifnull +53 -> 719
    //   669: aload_3
    //   670: invokevirtual 620	java/net/HttpURLConnection:disconnect	()V
    //   673: goto +46 -> 719
    //   676: astore_0
    //   677: goto +46 -> 723
    //   680: astore_2
    //   681: aload_3
    //   682: astore_0
    //   683: aload_2
    //   684: astore_3
    //   685: goto +13 -> 698
    //   688: astore_0
    //   689: aload_2
    //   690: astore_3
    //   691: goto +32 -> 723
    //   694: astore_3
    //   695: aload 4
    //   697: astore_0
    //   698: aload_0
    //   699: astore_2
    //   700: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   703: iconst_1
    //   704: ldc_w 676
    //   707: aload_3
    //   708: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   711: aload_0
    //   712: ifnull +7 -> 719
    //   715: aload_0
    //   716: invokevirtual 620	java/net/HttpURLConnection:disconnect	()V
    //   719: invokestatic 625	android/net/TrafficStats:clearThreadStatsTag	()V
    //   722: return
    //   723: aload_3
    //   724: ifnull +7 -> 731
    //   727: aload_3
    //   728: invokevirtual 620	java/net/HttpURLConnection:disconnect	()V
    //   731: invokestatic 625	android/net/TrafficStats:clearThreadStatsTag	()V
    //   734: aload_0
    //   735: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	parama	b.a
    //   29	138	1	i1	int
    //   39	619	2	localObject1	Object
    //   680	10	2	localException1	Exception
    //   699	1	2	locala	b.a
    //   56	635	3	localObject2	Object
    //   694	34	3	localException2	Exception
    //   36	660	4	localStringBuilder	StringBuilder
    //   33	582	5	str1	String
    //   7	363	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   57	665	676	finally
    //   57	665	680	java/lang/Exception
    //   40	57	688	finally
    //   700	711	688	finally
    //   40	57	694	java/lang/Exception
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    o.c();
    Object localObject = MsfSdkUtils.getLoginedAccountList().iterator();
    StringBuilder localStringBuilder;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = localStringBuilder.toString())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localSimpleAccount.getUin());
      localStringBuilder.append(",");
    }
    paramStringBuilder.append("--");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=appid\r\n\r\n");
    paramStringBuilder.append(paramInt1);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=os\r\n\r\n");
    paramStringBuilder.append("Android");
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=model\r\n\r\n");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=imei\r\n\r\n");
    paramStringBuilder.append(o.d());
    paramStringBuilder.append("\r\n");
    if (paramInt2 != 0)
    {
      paramStringBuilder.append("--");
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("\r\n");
      paramStringBuilder.append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
      paramStringBuilder.append(paramInt2);
      paramStringBuilder.append("\r\n");
    }
    if (paramInt3 != 0)
    {
      paramStringBuilder.append("--");
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("\r\n");
      paramStringBuilder.append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
      paramStringBuilder.append(paramInt3);
      paramStringBuilder.append("\r\n");
    }
    paramStringBuilder.append("--");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
    paramStringBuilder.append(str);
    paramStringBuilder.append("\r\n");
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i1 = paramHttpURLConnection.read(arrayOfByte, 0, 1024);
        if (i1 == -1) {
          break;
        }
        if (QLog.isColorLevel())
        {
          String str = f;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("read ");
          localStringBuilder.append(new String(arrayOfByte, 0, i1));
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, long paramLong, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {}
    for (;;)
    {
      try
      {
        str = MsfService.getCore().getAccountCenter().i();
        paramString1 = new StringBuilder();
        paramString1.append("uin=o");
        paramString1.append(str);
        Object localObject1 = paramString1.toString();
        paramString1 = (String)localObject1;
        if (paramLong != 0L)
        {
          paramString1 = new StringBuilder();
          paramString1.append("; seq=");
          paramString1.append(paramLong);
          paramString1 = ((String)localObject1).concat(paramString1.toString());
        }
        if (paramString2 == null)
        {
          Object localObject2 = l.e.GetLocalTicket(str, 16L, 4096);
          localObject1 = paramString1;
          if (localObject2 != null)
          {
            localObject1 = ((Ticket)localObject2)._sig;
            if (localObject1 != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("; skey=");
              ((StringBuilder)localObject2).append(new String((byte[])localObject1));
              localObject1 = paramString1.concat(((StringBuilder)localObject2).toString());
            }
            else
            {
              QLog.i(f, 1, "setUrlConnCookie skey is null");
              localObject1 = paramString1;
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("; skey=");
          ((StringBuilder)localObject1).append(new String(paramString2));
          localObject1 = paramString1.concat(((StringBuilder)localObject1).toString());
        }
        paramHttpURLConnection.setRequestProperty("Cookie", (String)localObject1);
        paramHttpURLConnection = f;
        boolean bool2 = false;
        if (str == null)
        {
          bool1 = true;
          if (paramString2 == null) {
            bool2 = true;
          }
          QLog.d(paramHttpURLConnection, 1, new Object[] { "setUrlConnCookie, uinIsNull", Boolean.valueOf(bool1), " skeyIsNull", Boolean.valueOf(bool2) });
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        QLog.e(f, 1, "setUrlConnCookie error, ", paramHttpURLConnection);
        return;
      }
      boolean bool1 = false;
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if ((c()) && (com.tencent.mobileqq.msf.core.a.a.ak()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject).append("/tencent/msflogs/corruptInfo");
      localObject = ((StringBuilder)localObject).toString();
      File localFile = new File((String)localObject);
      if ((localFile.exists()) && (localFile.length() < 8388608L)) {
        paramArrayList.add(new QLog.LogFile((String)localObject));
      }
    }
  }
  
  public static void a(ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, 0, 0, 0);
    long l4 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt4, paramInt5 - 1, paramInt6, 23, 59, 59);
    long l2 = ((Calendar)localObject1).getTimeInMillis();
    long l3 = System.currentTimeMillis();
    long l1 = l2;
    if (l2 >= l3)
    {
      ((Calendar)localObject1).setTimeInMillis(l3);
      l1 = l3;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(BaseApplication.getContext().getExternalCacheDir().getAbsolutePath());
    ((StringBuilder)localObject1).append("/tencent/wtlogin/com.tencent.mobileqq/");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        paramInt2 = localObject1.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          Object localObject2 = localObject1[paramInt1];
          l2 = localObject2.lastModified();
          if ((l2 >= l4) && (l2 <= l1)) {
            paramArrayList.add(new QLog.LogFile(localObject2.getPath()));
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  private static void a(ArrayList paramArrayList, b.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!QLog.isHasStoragePermission(BaseApplication.context))
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, new Object[] { "addPivateDirLog: invoked. 如果无权限，旧有逻辑会读取私有目录上传，公有目录本身也没有权限访问，也不用上传 ", " targetLogFiles: ", paramArrayList });
      }
      return;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, 0, 0);
    long l2 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt5, paramInt6 - 1, paramInt7, paramInt8, 0, 0);
    long l3 = ((Calendar)localObject1).getTimeInMillis();
    long l4 = System.currentTimeMillis();
    long l1 = l3;
    if (l3 >= l4)
    {
      ((Calendar)localObject1).setTimeInMillis(l4);
      l1 = l4;
    }
    HashSet localHashSet = new HashSet();
    paramInt2 = 0;
    do
    {
      localObject1 = QLog.getLogFileFormatter().format(Long.valueOf(l2));
      localHashSet.add(localObject1);
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = ((String)localObject1).length();
      }
      l3 = l2 + 3600000L;
      paramInt2 = paramInt1;
      l2 = l3;
    } while (l3 <= l1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(BaseApplication.context.getExternalFilesDir(null));
    ((StringBuilder)localObject1).append("/tencent/msflogs/com/tencent/mobileqq/");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (((File)localObject1).exists())
    {
      File[] arrayOfFile = ((File)localObject1).listFiles();
      if (arrayOfFile != null)
      {
        paramInt3 = arrayOfFile.length;
        paramInt2 = 0;
        while (paramInt2 < paramInt3)
        {
          File localFile = arrayOfFile[paramInt2];
          Object localObject2 = localFile.getName();
          if (((String)localObject2).endsWith(".log"))
          {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 4);
          }
          else if (((String)localObject2).endsWith(".log.zip"))
          {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 8);
          }
          else
          {
            localObject1 = localObject2;
            if (((String)localObject2).endsWith(".qlog")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
            }
          }
          if ((((String)localObject1).startsWith(QLog.getPackageName())) && (localHashSet.contains(((String)localObject1).substring(((String)localObject1).length() - paramInt1))))
          {
            localObject1 = localFile.getParent();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("private-");
            ((StringBuilder)localObject2).append(localFile.getName());
            localObject1 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
            localFile.renameTo((File)localObject1);
            localObject1 = new QLog.LogFile(((File)localObject1).getPath());
            paramArrayList.add(localObject1);
            parama.c += ((QLog.LogFile)localObject1).length();
            parama.e = 0L;
          }
          paramInt2 += 1;
        }
      }
    }
    else
    {
      ((File)localObject1).mkdirs();
    }
  }
  
  /* Error */
  public static void a(ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 860	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 254	java/io/FileOutputStream
    //   7: dup
    //   8: new 181	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 861	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 863	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 864	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 12
    //   33: aload_0
    //   34: invokevirtual 688	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_0
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 693 1 0
    //   46: ifeq +196 -> 242
    //   49: aload_0
    //   50: invokeinterface 697 1 0
    //   55: checkcast 226	com/tencent/qphone/base/util/QLog$LogFile
    //   58: astore 13
    //   60: aload 13
    //   62: invokevirtual 243	com/tencent/qphone/base/util/QLog$LogFile:exists	()Z
    //   65: ifeq -25 -> 40
    //   68: new 265	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   75: astore 14
    //   77: aload 14
    //   79: aload 13
    //   81: invokevirtual 865	com/tencent/qphone/base/util/QLog$LogFile:getName	()Ljava/lang/String;
    //   84: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 14
    //   90: aload 13
    //   92: getfield 868	com/tencent/qphone/base/util/QLog$LogFile:stuffix	Ljava/lang/String;
    //   95: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 12
    //   101: new 870	java/util/zip/ZipEntry
    //   104: dup
    //   105: aload 14
    //   107: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 871	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 875	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   116: aload 12
    //   118: bipush 9
    //   120: invokevirtual 878	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   123: aload 13
    //   125: invokevirtual 237	com/tencent/qphone/base/util/QLog$LogFile:length	()J
    //   128: lstore 9
    //   130: new 593	java/io/FileInputStream
    //   133: dup
    //   134: aload 13
    //   136: invokespecial 594	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 13
    //   141: sipush 20480
    //   144: newarray byte
    //   146: astore 14
    //   148: lconst_0
    //   149: lstore 5
    //   151: aload 13
    //   153: aload 14
    //   155: iconst_0
    //   156: sipush 20480
    //   159: invokevirtual 601	java/io/FileInputStream:read	([BII)I
    //   162: istore 4
    //   164: iload 4
    //   166: iconst_m1
    //   167: if_icmpeq +39 -> 206
    //   170: aload 12
    //   172: aload 14
    //   174: iconst_0
    //   175: iload 4
    //   177: invokevirtual 879	java/util/zip/ZipOutputStream:write	([BII)V
    //   180: iconst_1
    //   181: istore_3
    //   182: iconst_1
    //   183: istore_2
    //   184: lload 5
    //   186: iload 4
    //   188: i2l
    //   189: ladd
    //   190: lstore 7
    //   192: lload 7
    //   194: lstore 5
    //   196: lload 7
    //   198: lload 9
    //   200: lcmp
    //   201: iflt -50 -> 151
    //   204: iload_3
    //   205: istore_2
    //   206: aload 13
    //   208: invokevirtual 607	java/io/FileInputStream:close	()V
    //   211: aload 12
    //   213: invokevirtual 880	java/util/zip/ZipOutputStream:flush	()V
    //   216: aload 12
    //   218: invokevirtual 883	java/util/zip/ZipOutputStream:closeEntry	()V
    //   221: goto -181 -> 40
    //   224: astore_0
    //   225: aload 13
    //   227: invokevirtual 607	java/io/FileInputStream:close	()V
    //   230: aload 12
    //   232: invokevirtual 880	java/util/zip/ZipOutputStream:flush	()V
    //   235: aload 12
    //   237: invokevirtual 883	java/util/zip/ZipOutputStream:closeEntry	()V
    //   240: aload_0
    //   241: athrow
    //   242: iload_2
    //   243: ifeq +8 -> 251
    //   246: aload 12
    //   248: invokevirtual 884	java/util/zip/ZipOutputStream:close	()V
    //   251: new 181	java/io/File
    //   254: dup
    //   255: invokestatic 185	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   258: ldc_w 886
    //   261: invokespecial 854	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: astore_0
    //   265: aload_0
    //   266: invokevirtual 191	java/io/File:exists	()Z
    //   269: ifeq +55 -> 324
    //   272: aload_0
    //   273: invokevirtual 465	java/io/File:delete	()Z
    //   276: istore 11
    //   278: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +43 -> 324
    //   284: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   287: astore_0
    //   288: new 265	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   295: astore 12
    //   297: aload 12
    //   299: ldc_w 888
    //   302: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 12
    //   308: iload 11
    //   310: invokevirtual 316	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_0
    //   315: iconst_2
    //   316: aload 12
    //   318: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +13 -> 340
    //   330: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   333: iconst_2
    //   334: ldc_w 890
    //   337: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_1
    //   341: invokevirtual 891	java/io/BufferedOutputStream:close	()V
    //   344: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +119 -> 466
    //   350: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   353: astore_0
    //   354: aload_0
    //   355: iconst_2
    //   356: ldc_w 893
    //   359: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: goto +104 -> 466
    //   365: astore_0
    //   366: goto +73 -> 439
    //   369: astore_0
    //   370: aload_0
    //   371: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   374: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +45 -> 422
    //   380: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   383: astore 12
    //   385: new 265	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   392: astore 13
    //   394: aload 13
    //   396: ldc_w 895
    //   399: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 13
    //   405: aload_0
    //   406: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 12
    //   412: iconst_2
    //   413: aload 13
    //   415: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: aload_0
    //   419: invokestatic 897	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: aload_1
    //   423: invokevirtual 891	java/io/BufferedOutputStream:close	()V
    //   426: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +37 -> 466
    //   432: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   435: astore_0
    //   436: goto -82 -> 354
    //   439: aload_1
    //   440: invokevirtual 891	java/io/BufferedOutputStream:close	()V
    //   443: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +13 -> 459
    //   449: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   452: iconst_2
    //   453: ldc_w 893
    //   456: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: aload_0
    //   460: athrow
    //   461: astore_0
    //   462: aload_0
    //   463: invokevirtual 414	java/io/IOException:printStackTrace	()V
    //   466: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +13 -> 482
    //   472: getstatic 117	com/tencent/qphone/base/util/log/a/b:f	Ljava/lang/String;
    //   475: iconst_2
    //   476: ldc_w 899
    //   479: invokestatic 122	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramArrayList	ArrayList
    //   0	483	1	paramString	String
    //   39	204	2	i1	int
    //   181	24	3	i2	int
    //   162	25	4	i3	int
    //   149	46	5	l1	long
    //   190	7	7	l2	long
    //   128	71	9	l3	long
    //   276	33	11	bool	boolean
    //   31	380	12	localObject1	Object
    //   58	356	13	localObject2	Object
    //   75	98	14	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   141	148	224	finally
    //   151	164	224	finally
    //   170	180	224	finally
    //   33	38	365	finally
    //   40	141	365	finally
    //   206	221	365	finally
    //   225	242	365	finally
    //   246	251	365	finally
    //   251	324	365	finally
    //   324	340	365	finally
    //   370	422	365	finally
    //   33	38	369	java/io/IOException
    //   40	141	369	java/io/IOException
    //   206	221	369	java/io/IOException
    //   225	242	369	java/io/IOException
    //   246	251	369	java/io/IOException
    //   251	324	369	java/io/IOException
    //   324	340	369	java/io/IOException
    //   0	33	461	java/io/IOException
    //   340	354	461	java/io/IOException
    //   354	362	461	java/io/IOException
    //   422	436	461	java/io/IOException
    //   439	459	461	java/io/IOException
    //   459	461	461	java/io/IOException
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (MsfStore.getNativeConfigStore() == null)
      {
        localObject = new MsfStore();
        try
        {
          if (!((MsfStore)localObject).init(paramContext))
          {
            QLog.e(f, 1, "initLogLevel, MsfStore init fail");
            return false;
          }
        }
        catch (Exception paramContext)
        {
          localObject = f;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initLogLevel, MsfStore init error ");
          localStringBuilder.append(paramContext);
          QLog.e((String)localObject, 1, localStringBuilder.toString());
          return false;
        }
      }
      paramContext = MsfStore.getNativeConfigStore().getConfig("LOGLEVEL_");
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        localObject = MsfStore.getNativeConfigStore().getConfig("LOGLEVELTIME");
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          long l1 = Long.parseLong((String)localObject);
          if ((System.currentTimeMillis() - l1 > 259200000L) && (paramBoolean))
          {
            localObject = new i();
            ((Thread)localObject).setName("resetLogLevelThread");
            ((Thread)localObject).start();
          }
          else
          {
            QLog.setUIN_REPORTLOG_LEVEL(Integer.parseInt(paramContext));
          }
        }
        else
        {
          if (paramBoolean) {
            MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
          }
          QLog.setUIN_REPORTLOG_LEVEL(Integer.parseInt(paramContext));
        }
      }
      QLog.d(f, 1, new Object[] { "initLogLevel succ ,value =", paramContext });
      return true;
    }
    catch (Exception paramContext)
    {
      Object localObject = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initLogLevel error ");
      localStringBuilder.append(paramContext);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public static void b()
  {
    for (;;)
    {
      int i3;
      int i4;
      String str;
      try
      {
        Object localObject1 = BaseApplication.getContext();
        localObject2 = k;
        i3 = 0;
        localObject1 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject2, 0);
        l3 = 0L;
        l1 = ((SharedPreferences)localObject1).getLong("lastReportTime", 0L);
        bool1 = ((SharedPreferences)localObject1).getBoolean("opened", false);
        long l2 = System.currentTimeMillis();
        if ((l1 == 0L) || (l2 - l1 > 86400000L))
        {
          ((SharedPreferences)localObject1).edit().putLong("lastReportTime", l2).commit();
          localObject1 = new File(QLog.getLogPath());
          if (((File)localObject1).exists())
          {
            File[] arrayOfFile = ((File)localObject1).listFiles();
            if ((arrayOfFile != null) && (arrayOfFile.length > 0))
            {
              int i2 = arrayOfFile.length;
              l1 = 0L;
              l2 = l1;
              localObject2 = "";
              localObject1 = localObject2;
              Object localObject5 = localObject1;
              i4 = 0;
              if (i3 < i2)
              {
                localObject6 = arrayOfFile[i3];
                Object localObject3 = ((File)localObject6).getName();
                boolean bool2 = ((String)localObject3).endsWith(".log");
                if ((!bool2) && (!((String)localObject3).endsWith(".qlog"))) {
                  if (!((String)localObject3).endsWith(".log.zip")) {
                    break label1188;
                  }
                }
                long l5 = ((File)localObject6).length();
                l4 = l1 + ((File)localObject6).length();
                l1 = l3;
                if (l3 < l5)
                {
                  localObject5 = ((File)localObject6).getName();
                  l1 = l5;
                }
                bool2 = ((String)localObject3).startsWith(QLog.getPackageName());
                if (!bool2) {
                  break label1216;
                }
                try
                {
                  int i1 = ((String)localObject3).length();
                  if (((String)localObject3).endsWith(".log")) {
                    i1 = ((String)localObject3).indexOf(".log");
                  } else if (((String)localObject3).endsWith(".qlog")) {
                    i1 = ((String)localObject3).indexOf(".qlog");
                  } else if (((String)localObject3).endsWith(".log.zip")) {
                    i1 = ((String)localObject3).indexOf(".log.zip");
                  }
                  int i5 = ((String)localObject3).indexOf(".", ((String)localObject3).indexOf("mobileqq"));
                  Object localObject7 = localObject2;
                  localObject6 = localObject1;
                  try
                  {
                    str = ((String)localObject3).substring(i5 + 1, i1);
                    localObject7 = localObject2;
                    localObject6 = localObject1;
                    if (((String)localObject2).equals("")) {
                      break label1195;
                    }
                    localObject3 = localObject2;
                    localObject7 = localObject2;
                    localObject6 = localObject1;
                    if (str.compareTo((String)localObject2) < 0) {
                      break label1195;
                    }
                    localObject7 = localObject3;
                    localObject6 = localObject1;
                    if (((String)localObject1).equals("")) {
                      break label1202;
                    }
                    localObject2 = localObject1;
                    localObject7 = localObject3;
                    localObject6 = localObject1;
                    if (str.compareTo((String)localObject1) > 0) {
                      break label1202;
                    }
                    localObject7 = localObject3;
                    localObject6 = localObject2;
                    localObject1 = new SimpleDateFormat("yy.MM.dd.HH");
                    localObject7 = localObject3;
                    localObject6 = localObject2;
                    l2 = (((SimpleDateFormat)localObject1).parse((String)localObject2).getTime() - ((SimpleDateFormat)localObject1).parse((String)localObject3).getTime()) / 3600000L;
                    l2 += 1L;
                    localObject1 = localObject2;
                  }
                  catch (ParseException localParseException1)
                  {
                    localObject2 = localObject7;
                    localObject1 = localObject6;
                  }
                  localParseException2.printStackTrace();
                }
                catch (ParseException localParseException2) {}
                l2 = -1L;
                localObject4 = localObject2;
                break label1209;
              }
              localObject4 = new HashMap();
              Object localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("");
              ((StringBuilder)localObject6).append(i4);
              ((HashMap)localObject4).put("fileCount", ((StringBuilder)localObject6).toString());
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("");
              ((StringBuilder)localObject6).append(l1);
              ((HashMap)localObject4).put("sizeTotal", ((StringBuilder)localObject6).toString());
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("");
              ((StringBuilder)localObject6).append(l3);
              ((HashMap)localObject4).put("sizeMax", ((StringBuilder)localObject6).toString());
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("");
              ((StringBuilder)localObject6).append((String)localObject5);
              ((HashMap)localObject4).put("maxSizeName", ((StringBuilder)localObject6).toString());
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("");
              ((StringBuilder)localObject5).append((String)localObject2);
              ((HashMap)localObject4).put("startLogTime", ((StringBuilder)localObject5).toString());
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((HashMap)localObject4).put("endLogTime", ((StringBuilder)localObject2).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(l2);
              ((HashMap)localObject4).put("logHours", ((StringBuilder)localObject1).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(p());
              ((HashMap)localObject4).put("sdcardsize", ((StringBuilder)localObject1).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(q());
              ((HashMap)localObject4).put("freesize", ((StringBuilder)localObject1).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(com.tencent.mobileqq.msf.core.a.a.r());
              ((HashMap)localObject4).put("compressed", ((StringBuilder)localObject1).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(QLog.getUIN_REPORTLOG_LEVEL());
              ((HashMap)localObject4).put("logLevel", ((StringBuilder)localObject1).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(MsfService.getCore().getAccountCenter().i());
              ((HashMap)localObject4).put("account", ((StringBuilder)localObject1).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(bool1);
              ((HashMap)localObject4).put("logTestOpened", ((StringBuilder)localObject1).toString());
              if (MsfService.getCore().getStatReporter() == null) {
                break label1235;
              }
              MsfService.getCore().getStatReporter().a("msflogInfo2", bool1, l2, l1, (Map)localObject4, false, false);
              return;
            }
          }
          if (MsfService.getCore().getStatReporter() != null)
          {
            localObject1 = MsfService.getCore().getStatReporter();
            if (QLog.isColorLevel()) {
              break label1236;
            }
            bool1 = true;
            ((com.tencent.mobileqq.msf.core.c.j)localObject1).a("msflogInfoEmpty", bool1, 0L, 0L, null, false, false);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label1188:
      long l4 = l1;
      break label1224;
      label1195:
      Object localObject4 = str;
      continue;
      label1202:
      Object localObject2 = str;
      continue;
      label1209:
      localObject2 = localObject4;
      label1216:
      i4 += 1;
      long l3 = l1;
      label1224:
      i3 += 1;
      long l1 = l4;
      continue;
      label1235:
      return;
      label1236:
      boolean bool1 = false;
    }
  }
  
  private static void b(ArrayList paramArrayList)
  {
    if (!QLog.isHasStoragePermission(BaseApplication.context))
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "revertFileNameAfterZip: invoked. 如果无权限，就没有私有目录更名的逻辑，也不用回退 ");
      }
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QLog.LogFile localLogFile = (QLog.LogFile)paramArrayList.next();
      if ((localLogFile != null) && (localLogFile.getName().startsWith("private-"))) {
        localLogFile.renameTo(new File(localLogFile.getParent(), localLogFile.getName().substring(8)));
      }
    }
  }
  
  private static String c(File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QLog.getLogPath());
    ((StringBuilder)localObject).append(paramFile.getName());
    localObject = ((StringBuilder)localObject).toString();
    paramFile = (File)localObject;
    if (((String)localObject).endsWith(".log")) {
      paramFile = ((String)localObject).substring(0, ((String)localObject).indexOf(".log"));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(".qlog");
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean c()
  {
    if (NetConnInfoCenter.isWifiConn()) {
      return true;
    }
    return (NetConnInfoCenter.isMobileConn()) && (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType() == 13);
  }
  
  private static boolean d(File paramFile)
  {
    try
    {
      ZipOutputStream localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File(c(paramFile)))));
      localZipOutputStream.setLevel(com.tencent.mobileqq.msf.core.a.a.bj());
      byte[] arrayOfByte = new byte[8192];
      ZipEntry localZipEntry = new ZipEntry(paramFile.getName());
      localZipEntry.setSize(paramFile.length());
      localZipEntry.setTime(paramFile.lastModified());
      localZipOutputStream.putNextEntry(localZipEntry);
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      for (;;)
      {
        int i1 = paramFile.read(arrayOfByte, 0, 8192);
        if (i1 == -1) {
          break;
        }
        localZipOutputStream.write(arrayOfByte, 0, i1);
      }
      paramFile.close();
      localZipOutputStream.close();
      return true;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  private static boolean e(File paramFile)
  {
    if (paramFile.exists())
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        if (paramFile.length == 0) {
          return true;
        }
        Arrays.sort(paramFile, new h());
        Calendar localCalendar = Calendar.getInstance();
        int i3 = 3;
        try
        {
          String str1 = com.tencent.mobileqq.msf.core.a.a.h();
          if ((str1 != null) && (str1.length() > 0)) {
            i1 = Integer.parseInt(str1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i1 = 3;
        }
        int i2 = i3;
        if (i1 >= 1) {
          if (i1 > 14) {
            i2 = i3;
          } else {
            i2 = i1;
          }
        }
        localCalendar.add(6, i2 - i2 * 2);
        long l1 = localCalendar.getTimeInMillis();
        i2 = paramFile.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localCalendar = paramFile[i1];
          String str2;
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            str2 = f;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("found log file ");
            localStringBuilder.append(localCalendar.getName());
            QLog.d(str2, 2, localStringBuilder.toString());
          }
          if (l1 > localCalendar.lastModified())
          {
            localCalendar.delete();
            if (QLog.isColorLevel())
            {
              str2 = f;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("del expires log ");
              localStringBuilder.append(localCalendar.getName());
              QLog.d(str2, 2, localStringBuilder.toString());
            }
          }
          i1 += 1;
        }
      }
      return true;
    }
    return false;
  }
  
  private static boolean j()
  {
    try
    {
      if (com.tencent.mobileqq.msf.core.a.a.t()) {
        return false;
      }
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(k, 0);
      if (localSharedPreferences.getBoolean("opened", false)) {
        return true;
      }
      long l1 = Long.parseLong(MsfService.getCore().getAccountCenter().i());
      if ((com.tencent.mobileqq.msf.core.a.a.s()) && (l1 % 2L == 0L))
      {
        localSharedPreferences.edit().putBoolean("opened", true).commit();
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  private static void k()
  {
    e locale = new e();
    locale.setName("delLogThread");
    locale.start();
  }
  
  private static String l()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis() - 3600000L);
    return new SimpleDateFormat("yy.MM.dd.HH").format(localCalendar.getTime());
  }
  
  private static void m()
  {
    g localg = new g();
    localg.setName("delLogThread");
    localg.start();
  }
  
  private static void n()
  {
    if (QLog.isHasStoragePermission(BaseApplication.context))
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "delPrivateExpiresLogIfNeed: invoked. ");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplication.context.getExternalFilesDir(null));
      localStringBuilder.append("/tencent/msflogs/com/tencent/mobileqq/");
      e(new File(localStringBuilder.toString()));
    }
  }
  
  private static String o()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i1 = 0;
    while (i1 < 12)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.valueOf(localRandom.nextInt(10)));
      str = localStringBuilder.toString();
      i1 += 1;
    }
    return str;
  }
  
  private static long p()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      int i1 = localStatFs.getBlockCount();
      return i1 * l1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  private static long q()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      int i1 = localStatFs.getAvailableBlocks();
      return i1 * l1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.b
 * JD-Core Version:    0.7.0.1
 */