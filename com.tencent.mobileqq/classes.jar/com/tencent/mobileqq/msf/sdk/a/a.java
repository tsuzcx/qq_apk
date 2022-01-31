package com.tencent.mobileqq.msf.sdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.core.net.i;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  private static String a = "MSF.D.NetworkProvider";
  private static final Uri h = Uri.parse("content://telephony/carriers/preferapn");
  private static final byte q = 0;
  private static final byte r = 1;
  private static final byte s = 2;
  private volatile String b = "";
  private volatile String c = "";
  private volatile String d = "";
  private volatile String e = "";
  private volatile String f = "";
  private boolean g;
  private Handler i;
  private int j = -1;
  private volatile int k = 0;
  private volatile int l = 0;
  private volatile int m;
  private AtomicBoolean n = new AtomicBoolean(false);
  private NetworkInfo o;
  private int p;
  private INetInfoHandler t;
  private INetEventHandler u;
  private b v;
  private a w;
  private c x;
  
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        int i1;
        if (paramContext != null)
        {
          i1 = 1;
          if (paramContext.getBSSID() == null) {
            break label57;
          }
        }
        label57:
        for (int i2 = 1;; i2 = 0)
        {
          if ((i2 & i1) == 0) {
            break label69;
          }
          i1 = WifiManager.calculateSignalLevel(paramContext.getRssi(), 32);
          return i1;
          i1 = 0;
          break;
        }
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return -1;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "MOBILE";
    case 2: 
      return "WiFi";
    }
    return "WiFi";
  }
  
  private void a(Context paramContext, NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    if (this.v != null) {
      this.v.b();
    }
    this.o = paramNetworkInfo1;
    a(this.o, paramNetworkInfo2);
    int i1 = this.j;
    this.j = -1;
    if (this.i != null) {
      if (i1 != -1) {
        this.i.post(new b(this, i1));
      }
    }
    for (;;)
    {
      if (this.v != null) {
        this.v.c();
      }
      return;
      c(i1);
    }
  }
  
  private void a(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    String str;
    if (paramNetworkInfo1 != null) {
      str = paramNetworkInfo1.getTypeName();
    }
    do
    {
      do
      {
        try
        {
          this.d = paramNetworkInfo1.getSubtypeName();
          if (str.toLowerCase().contains("mobile_mms"))
          {
            QLog.d(a, 1, "checkConnInfo current typeName: mobile_mms ignore.");
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              QLog.d(a, 1, "get subtypeName error " + localException);
            }
            QLog.i(a, 1, "refresh currentAPN:" + this.b + ". received networkInfo: " + paramNetworkInfo1.getDetailedState() + " :" + paramNetworkInfo1 + ". ExtraNetInfo: " + paramNetworkInfo2);
            if (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.CONNECTED)
            {
              if (1 == paramNetworkInfo1.getType())
              {
                s();
                o();
                return;
              }
              if (a(paramNetworkInfo1))
              {
                s();
                q();
                n();
                return;
              }
              r();
              QLog.d(a, 1, "Unexcepted activeNetInfo type:" + paramNetworkInfo1.getType());
              return;
            }
          } while ((paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
          if (1 == paramNetworkInfo1.getType())
          {
            q();
            return;
          }
          if (a(paramNetworkInfo1))
          {
            p();
            return;
          }
          s();
          return;
        }
      } while (paramNetworkInfo2 == null);
      QLog.d(a, 1, "currentAPN:" + this.b + ". ActiveNetInfo: " + paramNetworkInfo1 + ". ExtraNetInfo: " + paramNetworkInfo2);
    } while ((paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
    if (1 == paramNetworkInfo2.getType())
    {
      p();
      q();
      return;
    }
    if (a(paramNetworkInfo2))
    {
      p();
      return;
    }
    p();
    q();
    s();
  }
  
  private void a(boolean paramBoolean)
  {
    this.n.set(paramBoolean);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    if (paramString2 != null) {
      return paramString2.equals(paramString1);
    }
    return (paramString1 == null) && (paramString2 == null);
  }
  
  private void b(int paramInt)
  {
    if (this.m == paramInt) {
      return;
    }
    if (paramInt > 0)
    {
      a(true);
      QLog.d(a, 1, "netchange " + a(this.m) + " to " + a(paramInt));
      this.j = -1;
      if (paramInt != 1) {
        break label151;
      }
      if ((this.m != 0) && (this.m != -2)) {
        break label109;
      }
      this.j = 0;
    }
    label151:
    for (;;)
    {
      this.m = paramInt;
      return;
      a(false);
      break;
      label109:
      if ((this.m == 2) || (this.m == 3))
      {
        this.j = 1;
      }
      else if (this.m <= 7)
      {
        this.j = 6;
        continue;
        if ((paramInt == 2) || (paramInt == 3))
        {
          if ((this.m == 0) || (this.m == -2)) {
            this.j = 2;
          } else if (this.m == 1) {
            this.j = 3;
          } else if (this.m <= 7) {
            this.j = 7;
          }
        }
        else if ((paramInt > 3) && (paramInt <= 7))
        {
          if ((this.m == 0) || (this.m == -2)) {
            this.j = 8;
          } else if (this.m == 1) {
            this.j = 9;
          } else if ((this.m == 2) || (this.m == 3)) {
            this.j = 10;
          }
        }
        else if (this.m == 1) {
          this.j = 4;
        } else if ((this.m == 2) || (this.m == 3)) {
          this.j = 5;
        } else if (this.m <= 7) {
          this.j = 11;
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (!a()) {
            continue;
          }
          v();
          if ((!a(this.e, this.f)) && (this.v != null)) {
            this.v.a(this.e, this.f);
          }
          w();
          if (this.v != null) {
            this.v.d();
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.w(a, 1, localThrowable.getMessage(), localThrowable);
          localThrowable.printStackTrace();
          continue;
          if (this.v == null) {
            continue;
          }
          this.v.h();
          continue;
        }
        try
        {
          if (this.t != null)
          {
            if ((paramInt != 0) && (paramInt != 6)) {
              break label268;
            }
            this.t.onNetNone2Mobile(this.b);
          }
          if (this.u == null) {
            break;
          }
          if ((paramInt != 4) && (paramInt != 5) && (paramInt != 11)) {
            break label360;
          }
          this.u.onNetChangeEvent(false);
          return;
        }
        catch (Exception localException)
        {
          QLog.w(a, 1, localException.getMessage(), localException);
          localException.printStackTrace();
          return;
        }
      }
      if (b())
      {
        t();
        u();
        if ((!a(this.c, this.b)) && (this.v != null)) {
          this.v.b(this.c, this.b);
        }
        if (this.v != null) {
          this.v.f();
        }
      }
      else
      {
        label268:
        if (paramInt != 1) {
          break label371;
        }
        this.t.onNetWifi2Mobile(this.b);
      }
    }
    for (;;)
    {
      label289:
      this.t.onNetNone2Wifi(this.f);
      break;
      label360:
      label371:
      do
      {
        if (paramInt == 3)
        {
          this.t.onNetMobile2Wifi(this.f);
          break;
        }
        if (paramInt == 4)
        {
          this.t.onNetMobile2None();
          break;
        }
        if (paramInt != 5) {
          break;
        }
        this.t.onNetWifi2None();
        break;
        this.u.onNetChangeEvent(true);
        return;
        if (paramInt == 2) {
          break label289;
        }
      } while (paramInt != 7);
    }
  }
  
  private void n()
  {
    if (this.o != null) {
      this.l = this.o.getSubtype();
    }
    for (;;)
    {
      b(this.m | 0x1);
      return;
      try
      {
        this.l = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void o()
  {
    b(this.m | 0x2);
  }
  
  private void p()
  {
    b(this.m & 0xFFFFFFFE);
  }
  
  private void q()
  {
    b(this.m & 0xFFFFFFFD);
  }
  
  private void r()
  {
    b(this.m | 0x4);
  }
  
  private void s()
  {
    b(this.m & 0xFFFFFFFB);
  }
  
  private void t()
  {
    this.k = i.a(this.o);
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 76	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   5: putfield 78	com/tencent/mobileqq/msf/sdk/a/a:c	Ljava/lang/String;
    //   8: invokestatic 363	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc_w 378
    //   14: invokevirtual 366	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 380	android/net/ConnectivityManager
    //   20: astore_2
    //   21: aload_2
    //   22: iconst_0
    //   23: invokevirtual 384	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +162 -> 190
    //   31: aload_2
    //   32: bipush 50
    //   34: invokevirtual 384	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +12 -> 51
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 387	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   47: putfield 76	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   50: return
    //   51: invokestatic 363	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   54: invokevirtual 391	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   57: getstatic 68	com/tencent/mobileqq/msf/sdk/a/a:h	Landroid/net/Uri;
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 397	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull +100 -> 169
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: invokeinterface 402 1 0
    //   80: ifeq +89 -> 169
    //   83: aload_2
    //   84: astore_1
    //   85: aload_0
    //   86: aload_2
    //   87: aload_2
    //   88: ldc_w 404
    //   91: invokeinterface 408 2 0
    //   96: invokeinterface 411 2 0
    //   101: putfield 76	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   104: goto -36 -> 68
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: invokevirtual 335	java/lang/Throwable:printStackTrace	()V
    //   114: aload_2
    //   115: ifnull -65 -> 50
    //   118: aload_2
    //   119: invokeinterface 414 1 0
    //   124: return
    //   125: astore_1
    //   126: getstatic 58	com/tencent/mobileqq/msf/sdk/a/a:a	Ljava/lang/String;
    //   129: iconst_1
    //   130: new 196	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 416
    //   140: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: return
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +9 -> 167
    //   161: aload_1
    //   162: invokeinterface 414 1 0
    //   167: aload_2
    //   168: athrow
    //   169: aload_2
    //   170: ifnull -120 -> 50
    //   173: aload_2
    //   174: invokeinterface 414 1 0
    //   179: return
    //   180: astore_2
    //   181: goto -24 -> 157
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -79 -> 108
    //   190: goto -152 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	a
    //   26	84	1	localObject1	Object
    //   125	19	1	localException	Exception
    //   156	6	1	localObject2	Object
    //   20	99	2	localObject3	Object
    //   154	20	2	localObject4	Object
    //   180	1	2	localObject5	Object
    //   186	1	2	localObject6	Object
    //   107	4	3	localThrowable1	Throwable
    //   184	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   74	83	107	java/lang/Throwable
    //   85	104	107	java/lang/Throwable
    //   31	38	125	java/lang/Exception
    //   42	50	125	java/lang/Exception
    //   118	124	125	java/lang/Exception
    //   161	167	125	java/lang/Exception
    //   167	169	125	java/lang/Exception
    //   173	179	125	java/lang/Exception
    //   51	68	154	finally
    //   74	83	180	finally
    //   85	104	180	finally
    //   110	114	180	finally
    //   51	68	184	java/lang/Throwable
  }
  
  private void v()
  {
    this.e = this.f;
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "checknetinfo get wifi ssid " + localWifiInfo.getSSID());
        }
        this.f = localWifiInfo.getSSID();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to get wifi ssid");
    }
  }
  
  private void w()
  {
    if (this.x != null)
    {
      int i1 = a(BaseApplication.getContext());
      if (this.p != i1) {
        this.x.a(this.p, i1);
      }
      this.p = i1;
    }
  }
  
  public void a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      a(paramContext, localNetworkInfo, paramNetworkInfo);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w(a, 1, localException.getMessage(), localException.getCause());
        Object localObject = null;
      }
    }
    finally {}
  }
  
  public void a(Handler paramHandler)
  {
    this.i = paramHandler;
  }
  
  public void a(a parama)
  {
    this.w = parama;
  }
  
  public void a(b paramb)
  {
    this.v = paramb;
  }
  
  public void a(INetEventHandler paramINetEventHandler)
  {
    this.u = paramINetEventHandler;
  }
  
  public void a(INetInfoHandler paramINetInfoHandler)
  {
    this.t = paramINetInfoHandler;
  }
  
  public boolean a()
  {
    return (this.m == 2) || (this.m == 3);
  }
  
  public boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public boolean b()
  {
    return this.m == 1;
  }
  
  public int c()
  {
    return this.k;
  }
  
  public int d()
  {
    if (a())
    {
      if (this.g) {
        return 3;
      }
      return 2;
    }
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public boolean e()
  {
    return this.n.get();
  }
  
  public NetworkInfo f()
  {
    return this.o;
  }
  
  public int g()
  {
    return this.l;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public int i()
  {
    return this.m;
  }
  
  public String j()
  {
    return this.f;
  }
  
  public String k()
  {
    return this.e;
  }
  
  public String l()
  {
    return this.b;
  }
  
  public String m()
  {
    return this.c;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2);
    
    public abstract void b();
    
    public abstract void b(String paramString1, String paramString2);
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
    
    public abstract void f();
    
    public abstract void g();
    
    public abstract void h();
    
    public abstract void i();
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
  
  public static class d
    implements a.b
  {
    public void a(String paramString1, String paramString2) {}
    
    public void b() {}
    
    public void b(String paramString1, String paramString2) {}
    
    public void c() {}
    
    public void d() {}
    
    public void e() {}
    
    public void f() {}
    
    public void g() {}
    
    public void h() {}
    
    public void i() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */