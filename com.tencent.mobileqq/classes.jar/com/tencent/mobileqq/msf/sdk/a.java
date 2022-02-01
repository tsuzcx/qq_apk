package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  private static final int A = 10;
  private static final int B = 11;
  private static final int C = 12;
  private static final int D = 14;
  private static final int E = 15;
  private static int F = 0;
  private static boolean G = false;
  private static long H = 0L;
  private static Uri I = Uri.parse("content://telephony/carriers/preferapn");
  private static final byte J = 0;
  private static final byte K = 1;
  private static final byte L = 2;
  static List a;
  static List b;
  static volatile boolean c = false;
  static a.a d;
  static Handler e;
  static NetworkInfo f;
  public static final int g = 20;
  public static boolean h = false;
  public static int i = 0;
  public static String j;
  public static String k;
  public static String l;
  static BroadcastReceiver m = new b();
  private static String n = "MSF.D.AppNetInfoImpl";
  private static final String o = "https://3gimg.qq.com/ping.html";
  private static int p = 0;
  private static AtomicBoolean q = new AtomicBoolean(false);
  private static final int r = 1;
  private static final int s = 2;
  private static final int t = 3;
  private static final int u = 4;
  private static final int v = 5;
  private static final int w = 16;
  private static final int x = 17;
  private static final int y = 18;
  private static final int z = 19;
  
  static
  {
    a = new LinkedList();
    b = new LinkedList();
    c = false;
    d = new a.a("nethandlerthread");
    e = null;
    f = null;
    F = -1;
    G = true;
    H = 0L;
    i = 0;
    j = "";
    k = "";
    l = "";
  }
  
  private static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3)) {
          return "UNKNOWN";
        }
        return "WiFi";
      }
      return "MOBILE";
    }
    return "NONE";
  }
  
  public static void a()
  {
    Object localObject1 = (HttpURLConnection)new URL("https://3gimg.qq.com/ping.html").openConnection();
    ((HttpURLConnection)localObject1).setDoOutput(true);
    ((HttpURLConnection)localObject1).setDoInput(true);
    ((HttpURLConnection)localObject1).setRequestMethod("GET");
    ((HttpURLConnection)localObject1).setUseCaches(false);
    ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
    ((HttpURLConnection)localObject1).setReadTimeout(60000);
    ((HttpURLConnection)localObject1).connect();
    Object localObject2 = new byte[8];
    ((HttpURLConnection)localObject1).getInputStream().read((byte[])localObject2);
    ((HttpURLConnection)localObject1).getInputStream().close();
    ((HttpURLConnection)localObject1).disconnect();
    localObject1 = new String((byte[])localObject2);
    if ("Poduct3G".equals(localObject1))
    {
      b(true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wifi ping resp content is ");
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    h = true;
  }
  
  public static void a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(0);
    if (localNetworkInfo != null) {
      try
      {
        j = localNetworkInfo.getExtraInfo();
      }
      catch (Exception localException)
      {
        String str = n;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get currentAPN error ");
        localStringBuilder.append(localException);
        QLog.d(str, 1, localStringBuilder.toString());
      }
    }
    f = paramContext.getActiveNetworkInfo();
    a(f, paramNetworkInfo);
  }
  
  public static void a(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    if (paramINetEventHandler == null)
    {
      paramContext = n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" registerNetChangeReceiver null");
      QLog.w(paramContext, 1, localStringBuilder.toString());
    }
    h();
    if (c)
    {
      paramContext = e;
      if (paramContext == null) {
        return;
      }
      paramContext = paramContext.obtainMessage();
      paramContext.what = 2;
      paramContext.obj = paramINetEventHandler;
      e.sendMessage(paramContext);
    }
  }
  
  public static void a(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    if (paramINetInfoHandler == null)
    {
      paramContext = n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" registerConnectionChangeReceiver null");
      QLog.w(paramContext, 1, localStringBuilder.toString());
    }
    h();
    if (c)
    {
      paramContext = e;
      if (paramContext == null) {
        return;
      }
      paramContext = paramContext.obtainMessage();
      paramContext.what = 1;
      paramContext.obj = paramINetInfoHandler;
      e.sendMessage(paramContext);
    }
  }
  
  public static void a(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    Object localObject;
    StringBuilder localStringBuilder1;
    if (paramNetworkInfo1 != null)
    {
      localObject = paramNetworkInfo1.getTypeName();
      try
      {
        k = paramNetworkInfo1.getSubtypeName();
      }
      catch (Exception localException)
      {
        String str = n;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("get subtypeName error ");
        localStringBuilder2.append(localException);
        QLog.d(str, 1, localStringBuilder2.toString());
      }
      if (((String)localObject).toLowerCase().contains("mobile_mms"))
      {
        QLog.d(n, 1, "checkConnInfo current typeName: mobile_mms ignore.");
        return;
      }
      localObject = n;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("currentAPN:");
      localStringBuilder1.append(j);
      localStringBuilder1.append(". received networkInfo: ");
      localStringBuilder1.append(paramNetworkInfo1.getDetailedState());
      localStringBuilder1.append(" :");
      localStringBuilder1.append(paramNetworkInfo1);
      localStringBuilder1.append(". ExtraNetInfo: ");
      localStringBuilder1.append(paramNetworkInfo2);
      QLog.d((String)localObject, 1, localStringBuilder1.toString());
      if (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.CONNECTED)
      {
        if (1 == paramNetworkInfo1.getType())
        {
          u();
          q();
          return;
        }
        if (a(paramNetworkInfo1))
        {
          u();
          t();
          p();
          return;
        }
        r();
        paramNetworkInfo2 = n;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unexcepted activeNetInfo type:");
        ((StringBuilder)localObject).append(paramNetworkInfo1.getType());
        QLog.d(paramNetworkInfo2, 1, ((StringBuilder)localObject).toString());
        return;
      }
      if ((paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) || (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.FAILED) || (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.IDLE) || (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED))
      {
        if (1 == paramNetworkInfo1.getType())
        {
          t();
          return;
        }
        if (a(paramNetworkInfo1))
        {
          s();
          return;
        }
        u();
      }
    }
    else if (paramNetworkInfo2 != null)
    {
      localObject = n;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("currentAPN:");
      localStringBuilder1.append(j);
      localStringBuilder1.append(". ActiveNetInfo: ");
      localStringBuilder1.append(paramNetworkInfo1);
      localStringBuilder1.append(". ExtraNetInfo: ");
      localStringBuilder1.append(paramNetworkInfo2);
      QLog.d((String)localObject, 1, localStringBuilder1.toString());
      if ((paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) || (paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.FAILED) || (paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.IDLE) || (paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED))
      {
        if (1 == paramNetworkInfo2.getType())
        {
          s();
          t();
          return;
        }
        if (a(paramNetworkInfo2))
        {
          s();
          return;
        }
        s();
        t();
        u();
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      f = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      a(f, null);
      if ((e != null) && ((!c) || (f != null))) {
        e.sendEmptyMessage(3);
      }
      if ((paramBoolean) && (f != null) && (f.getDetailedState() == NetworkInfo.DetailedState.CONNECTED))
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("processName", MsfServiceSdk.get().processName);
        ((HashMap)localObject).put("netType", String.valueOf(f.getType()));
        RdmReq localRdmReq = new RdmReq();
        localRdmReq.eventName = "CheckNetIsValid";
        localRdmReq.elapse = (System.currentTimeMillis() - l1);
        localRdmReq.isSucceed = true;
        localRdmReq.isRealTime = true;
        localRdmReq.params = ((Map)localObject);
        try
        {
          localObject = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), localRdmReq);
          MsfServiceSdk.get().sendMsg((ToServiceMsg)localObject);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(n, 2, localException2.toString(), localException2);
      }
    }
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static boolean a(INetEventHandler paramINetEventHandler)
  {
    Object localObject;
    if (paramINetEventHandler == null)
    {
      paramINetEventHandler = n;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      ((StringBuilder)localObject).append(" unregisterNetEventHandler null");
      QLog.w(paramINetEventHandler, 1, ((StringBuilder)localObject).toString());
      return false;
    }
    h();
    if (c)
    {
      localObject = e;
      if (localObject == null) {
        return false;
      }
      localObject = ((Handler)localObject).obtainMessage();
      ((Message)localObject).what = 5;
      ((Message)localObject).obj = paramINetEventHandler;
      e.sendMessage((Message)localObject);
      return true;
    }
    return false;
  }
  
  public static boolean a(INetInfoHandler paramINetInfoHandler)
  {
    if (paramINetInfoHandler == null)
    {
      paramINetInfoHandler = n;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      ((StringBuilder)localObject).append(" unregisterNetInfoHandler null");
      QLog.w(paramINetInfoHandler, 1, ((StringBuilder)localObject).toString());
      return false;
    }
    h();
    if (c)
    {
      localObject = e;
      if (localObject != null)
      {
        localObject = ((Handler)localObject).obtainMessage();
        ((Message)localObject).what = 4;
        ((Message)localObject).obj = paramINetInfoHandler;
        e.sendMessage((Message)localObject);
        return true;
      }
    }
    paramINetInfoHandler = n;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    ((StringBuilder)localObject).append(" unregisterNetInfoHandler initHandler=");
    ((StringBuilder)localObject).append(c);
    ((StringBuilder)localObject).append(" handler=");
    ((StringBuilder)localObject).append(e);
    QLog.w(paramINetInfoHandler, 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    v();
    return e.post(paramRunnable);
  }
  
  private static void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (p == paramInt)
        {
          if (QLog.isColorLevel())
          {
            str = n;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("found repeat net event , now is ");
            localStringBuilder.append(b());
            localStringBuilder.append(" now:");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" last:");
            localStringBuilder.append(p);
            QLog.d(str, 2, localStringBuilder.toString());
          }
          return;
        }
        if (paramInt > 0) {
          b(true);
        } else {
          b(false);
        }
        String str = n;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("netchange ");
        localStringBuilder.append(a(p));
        localStringBuilder.append(" to ");
        localStringBuilder.append(a(paramInt));
        QLog.d(str, 1, localStringBuilder.toString());
        F = -1;
        if (paramInt == 1)
        {
          if ((p != 0) && (p != -2))
          {
            if ((p != 2) && (p != 3))
            {
              if (p <= 7) {
                F = 6;
              }
            }
            else {
              F = 1;
            }
          }
          else
          {
            F = 0;
            continue;
            if ((paramInt > 3) && (paramInt <= 7))
            {
              if ((p != 0) && (p != -2))
              {
                if (p == 1) {
                  F = 9;
                } else if ((p == 2) || (paramInt == 3)) {
                  F = 10;
                }
              }
              else {
                F = 8;
              }
            }
            else if (p == 1)
            {
              F = 4;
            }
            else if ((p != 2) && (p != 3))
            {
              if (p <= 7) {
                F = 11;
              }
            }
            else
            {
              F = 5;
              continue;
              if ((p != 0) && (p != -2))
              {
                if (p == 1) {
                  F = 3;
                } else if (p <= 7) {
                  F = 7;
                }
              }
              else {
                F = 2;
              }
            }
          }
          p = paramInt;
          return;
        }
      }
      finally {}
      if (paramInt != 2) {
        if (paramInt != 3) {}
      }
    }
  }
  
  private static void b(boolean paramBoolean)
  {
    q.set(paramBoolean);
  }
  
  public static boolean b()
  {
    return q.get();
  }
  
  public static int c()
  {
    if (e())
    {
      if (h) {
        return 3;
      }
      return 2;
    }
    if (f()) {
      return 1;
    }
    return 0;
  }
  
  public static int d()
  {
    return i;
  }
  
  public static boolean e()
  {
    int i1 = p;
    return (i1 == 2) || (i1 == 3);
  }
  
  public static boolean f()
  {
    return p == 1;
  }
  
  public static NetworkInfo g()
  {
    return f;
  }
  
  public static void h()
  {
    try
    {
      
      synchronized (d)
      {
        if ((!c) && (BaseApplication.getContext() != null))
        {
          IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
          BaseApplication.getContext().registerReceiver(m, localIntentFilter);
          a(false);
          c = true;
        }
        else if ((c) && (!b()))
        {
          long l1 = System.currentTimeMillis();
          if (l1 - H >= 5000L)
          {
            H = l1;
            a(true);
          }
        }
        return;
      }
      String str;
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      str = n;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to check init ops ");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  /* Error */
  private static void n()
  {
    // Byte code:
    //   0: invokestatic 396	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc 242
    //   5: invokevirtual 397	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   8: checkcast 250	android/net/ConnectivityManager
    //   11: iconst_0
    //   12: invokevirtual 254	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull +15 -> 32
    //   20: aload_0
    //   21: invokevirtual 259	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   24: putstatic 118	com/tencent/mobileqq/msf/sdk/a:j	Ljava/lang/String;
    //   27: return
    //   28: astore_0
    //   29: goto +109 -> 138
    //   32: aconst_null
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_1
    //   36: invokestatic 396	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   39: invokevirtual 533	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   42: getstatic 132	com/tencent/mobileqq/msf/sdk/a:I	Landroid/net/Uri;
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 539	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +41 -> 95
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: astore_0
    //   61: aload_2
    //   62: invokeinterface 544 1 0
    //   67: ifeq +28 -> 95
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: astore_0
    //   74: aload_2
    //   75: aload_2
    //   76: ldc_w 546
    //   79: invokeinterface 550 2 0
    //   84: invokeinterface 553 2 0
    //   89: putstatic 118	com/tencent/mobileqq/msf/sdk/a:j	Ljava/lang/String;
    //   92: goto -39 -> 53
    //   95: aload_2
    //   96: ifnull +77 -> 173
    //   99: aload_2
    //   100: astore_0
    //   101: aload_0
    //   102: invokeinterface 554 1 0
    //   107: return
    //   108: astore_0
    //   109: goto +17 -> 126
    //   112: astore_2
    //   113: aload_0
    //   114: astore_1
    //   115: aload_2
    //   116: invokevirtual 555	java/lang/Throwable:printStackTrace	()V
    //   119: aload_0
    //   120: ifnull +53 -> 173
    //   123: goto -22 -> 101
    //   126: aload_1
    //   127: ifnull +9 -> 136
    //   130: aload_1
    //   131: invokeinterface 554 1 0
    //   136: aload_0
    //   137: athrow
    //   138: getstatic 219	com/tencent/mobileqq/msf/sdk/a:n	Ljava/lang/String;
    //   141: astore_1
    //   142: new 221	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: ldc_w 261
    //   154: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: aload_0
    //   160: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: iconst_1
    //   166: aload_2
    //   167: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	6	0	localNetworkInfo	NetworkInfo
    //   28	1	0	localException	Exception
    //   33	69	0	localObject1	Object
    //   108	52	0	localObject2	Object
    //   35	130	1	localObject3	Object
    //   52	48	2	localCursor	android.database.Cursor
    //   112	4	2	localThrowable	java.lang.Throwable
    //   149	18	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	27	28	java/lang/Exception
    //   101	107	28	java/lang/Exception
    //   130	136	28	java/lang/Exception
    //   136	138	28	java/lang/Exception
    //   36	53	108	finally
    //   61	70	108	finally
    //   74	92	108	finally
    //   115	119	108	finally
    //   36	53	112	java/lang/Throwable
    //   61	70	112	java/lang/Throwable
    //   74	92	112	java/lang/Throwable
  }
  
  private static void o()
  {
    try
    {
      WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)BaseApplication.getContext().getSystemService("wifi"));
      if (localWifiInfo == null) {
        break label76;
      }
      String str = n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checknetinfo get wifi ssid ");
      localStringBuilder.append(localWifiInfo.getSSID());
      QLog.d(str, 1, localStringBuilder.toString());
      l = localWifiInfo.getSSID();
      return;
    }
    catch (Exception localException)
    {
      label66:
      label76:
      break label66;
    }
    QLog.d(n, 1, "failed to get wifi ssid");
  }
  
  private static void p()
  {
    b(p | 0x1);
  }
  
  private static void q()
  {
    b(p | 0x2);
  }
  
  private static void r()
  {
    b(p | 0x4);
  }
  
  private static void s()
  {
    b(p & 0xFFFFFFFE);
  }
  
  private static void t()
  {
    b(p & 0xFFFFFFFD);
  }
  
  private static void u()
  {
    b(p & 0xFFFFFFFB);
  }
  
  private static void v()
  {
    try
    {
      StringBuilder localStringBuilder;
      if (e == null) {
        synchronized (d)
        {
          if (e == null)
          {
            if (!d.isAlive())
            {
              String str1 = n;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("PID=");
              localStringBuilder.append(Process.myPid());
              localStringBuilder.append(" tid=");
              localStringBuilder.append(Thread.currentThread().getId());
              localStringBuilder.append(" AppNetInfoImpl checkInitHandler. looper=");
              localStringBuilder.append(Looper.myLooper());
              QLog.d(str1, 1, localStringBuilder.toString());
              d.start();
            }
            e = new Handler(d.getLooper(), d);
          }
          return;
        }
      }
      String str2;
      return;
    }
    catch (Exception localException)
    {
      str2 = n;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initHandler exception ");
      localStringBuilder.append(localException.toString());
      QLog.d(str2, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a
 * JD-Core Version:    0.7.0.1
 */