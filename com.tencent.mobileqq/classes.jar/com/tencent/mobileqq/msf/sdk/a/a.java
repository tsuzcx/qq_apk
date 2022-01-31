package com.tencent.mobileqq.msf.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ag;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.c.k.c;
import com.tencent.mobileqq.msf.core.net.j;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  private static String a = "MSF.D.NetworkProvider";
  private static final Uri h = Uri.parse("content://telephony/carriers/preferapn");
  private static final byte r = 0;
  private static final byte s = 1;
  private static final byte t = 2;
  private AtomicBoolean A;
  private volatile String b = "";
  private volatile String c = "";
  private volatile String d = "";
  private volatile String e = "";
  private volatile String f = "";
  private boolean g;
  private Handler i = null;
  private int j = -1;
  private volatile int k = 0;
  private volatile int l = 0;
  private volatile int m = 0;
  private volatile int n = 0;
  private AtomicBoolean o = new AtomicBoolean(false);
  private NetworkInfo p = null;
  private int q = 0;
  private INetInfoHandler u = null;
  private INetEventHandler v = null;
  private a.b w = null;
  private a.a x = null;
  private a.c y = null;
  private final String[] z = { "80000967", "23066699", "9948938", "56928460" };
  
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
  
  private int a(InetAddress paramInetAddress)
  {
    if ((paramInetAddress != null) && (!paramInetAddress.isLoopbackAddress()) && (!paramInetAddress.isLinkLocalAddress()) && (!paramInetAddress.isAnyLocalAddress()))
    {
      if ((paramInetAddress instanceof Inet6Address)) {
        return 2;
      }
      if ((paramInetAddress instanceof Inet4Address)) {
        return 1;
      }
    }
    return 0;
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
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1) {
      return;
    }
    for (;;)
    {
      try
      {
        if (a())
        {
          v();
          if ((!a(this.e, this.f)) && (this.w != null)) {
            this.w.a(this.e, this.f);
          }
          w();
          if (this.w != null) {
            this.w.a(paramInt2);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.w(a, 1, localThrowable.getMessage(), localThrowable);
        localThrowable.printStackTrace();
        continue;
        if (this.w == null) {
          continue;
        }
        this.w.g();
        continue;
        if (paramInt1 == 1)
        {
          this.u.onNetWifi2Mobile(this.b);
          continue;
        }
      }
      try
      {
        if (this.u != null)
        {
          if ((paramInt1 != 0) && (paramInt1 != 6)) {
            continue;
          }
          this.u.onNetNone2Mobile(this.b);
        }
      }
      catch (Exception localException)
      {
        QLog.w(a, 1, localException.getMessage(), localException);
        localException.printStackTrace();
        continue;
        if ((paramInt1 != 2) && (paramInt1 != 7)) {
          break label323;
        }
        this.u.onNetNone2Wifi(this.f);
        continue;
        if (paramInt1 != 3) {
          break label344;
        }
        this.u.onNetMobile2Wifi(this.f);
        continue;
        if (paramInt1 != 4) {
          break label361;
        }
        this.u.onNetMobile2None();
        continue;
        if (paramInt1 != 5) {
          continue;
        }
        this.u.onNetWifi2None();
        continue;
        this.v.onNetChangeEvent(true);
        continue;
      }
      if (this.v != null)
      {
        if ((paramInt1 != 4) && (paramInt1 != 5) && (paramInt1 != 11)) {
          break label378;
        }
        this.v.onNetChangeEvent(false);
      }
      x();
      return;
      if (!b()) {
        continue;
      }
      t();
      u();
      if ((!a(this.c, this.b)) && (this.w != null)) {
        this.w.b(this.c, this.b);
      }
      if (this.w != null) {
        this.w.e();
      }
    }
  }
  
  private void a(Context paramContext, NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    if (this.w != null) {
      this.w.b();
    }
    this.p = paramNetworkInfo1;
    int i1 = this.m;
    a(this.p, paramNetworkInfo2);
    int i2 = this.j;
    this.j = -1;
    if (this.i != null) {
      if (i2 != -1) {
        this.i.post(new b(this, i2, i1));
      }
    }
    for (;;)
    {
      if (this.w != null) {
        this.w.c();
      }
      return;
      a(i2, i1);
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
            QLog.i(a, 1, "refresh currentAPN:" + this.b + ". received networkInfo: " + paramNetworkInfo1.getDetailedState() + " :" + b(paramNetworkInfo1) + ". ExtraNetInfo: " + b(paramNetworkInfo2));
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
            if ((paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) || (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.FAILED) || (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.IDLE) || (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED))
            {
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
          } while ((paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) || (MsfCore.sCore == null) || (MsfCore.sCore.statReporter == null) || (MsfCore.sCore.statReporter.X == null) || (MsfCore.sCore.statReporter.X.g != 0L));
          MsfCore.sCore.statReporter.X.g = System.currentTimeMillis();
          QLog.d(a, 1, new Object[] { "MSF_Alive_Log on netWork refresh netWorkFailTime =", Long.valueOf(System.currentTimeMillis()) });
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
  
  private String b(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder("NetworkInfo: ");
        StringBuilder localStringBuilder2 = localStringBuilder1.append("type: ").append(paramNetworkInfo.getTypeName()).append("[").append(paramNetworkInfo.getSubtypeName()).append("], state: ").append(paramNetworkInfo.getState()).append("/").append(paramNetworkInfo.getDetailedState()).append(", reason: ");
        if (paramNetworkInfo.getReason() == null)
        {
          str = "(unspecified)";
          localStringBuilder2 = localStringBuilder2.append(str).append(", extra: ");
          if (paramNetworkInfo.getExtraInfo() != null) {
            break label190;
          }
        }
        label190:
        for (String str = "(none)";; str = paramNetworkInfo.getExtraInfo().substring(0, paramNetworkInfo.getExtraInfo().length() / 2))
        {
          localStringBuilder2.append(str).append(", roaming: ").append(paramNetworkInfo.isRoaming()).append(", failover: ").append(paramNetworkInfo.isFailover()).append(", isAvailable: ").append(paramNetworkInfo.isAvailable()).append(", isConnectedToProvisioningNetwork: ").append(paramNetworkInfo.isConnectedOrConnecting());
          str = localStringBuilder1.toString();
          return str;
          str = paramNetworkInfo.getReason();
          break;
        }
        return null;
      }
      finally {}
    }
  }
  
  private void b(int paramInt)
  {
    if (this.m == paramInt) {
      return;
    }
    if (paramInt > 0)
    {
      d(true);
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
      d(false);
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
  
  private void d(boolean paramBoolean)
  {
    this.o.set(paramBoolean);
  }
  
  private void n()
  {
    if (this.p != null) {
      this.l = this.p.getSubtype();
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
    this.k = j.a(this.p);
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 72	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   5: putfield 74	com/tencent/mobileqq/msf/sdk/a/a:c	Ljava/lang/String;
    //   8: invokestatic 502	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc_w 517
    //   14: invokevirtual 505	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 519	android/net/ConnectivityManager
    //   20: astore_2
    //   21: aload_2
    //   22: iconst_0
    //   23: invokevirtual 523	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +162 -> 190
    //   31: aload_2
    //   32: bipush 50
    //   34: invokevirtual 523	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +12 -> 51
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 448	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   47: putfield 72	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   50: return
    //   51: invokestatic 502	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   54: invokevirtual 527	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   57: getstatic 64	com/tencent/mobileqq/msf/sdk/a/a:h	Landroid/net/Uri;
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 533	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull +100 -> 169
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: invokeinterface 538 1 0
    //   80: ifeq +89 -> 169
    //   83: aload_2
    //   84: astore_1
    //   85: aload_0
    //   86: aload_2
    //   87: aload_2
    //   88: ldc_w 540
    //   91: invokeinterface 544 2 0
    //   96: invokeinterface 547 2 0
    //   101: putfield 72	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   104: goto -36 -> 68
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: invokevirtual 237	java/lang/Throwable:printStackTrace	()V
    //   114: aload_2
    //   115: ifnull -65 -> 50
    //   118: aload_2
    //   119: invokeinterface 550 1 0
    //   124: return
    //   125: astore_1
    //   126: getstatic 54	com/tencent/mobileqq/msf/sdk/a/a:a	Ljava/lang/String;
    //   129: iconst_1
    //   130: new 300	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 552
    //   140: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: return
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +9 -> 167
    //   161: aload_1
    //   162: invokeinterface 550 1 0
    //   167: aload_2
    //   168: athrow
    //   169: aload_2
    //   170: ifnull -120 -> 50
    //   173: aload_2
    //   174: invokeinterface 550 1 0
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
    Object localObject5 = null;
    this.e = this.f;
    if (Build.VERSION.SDK_INT == 27) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
        if (localObject1 == null) {
          break label226;
        }
        localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        if ((localObject1 == null) || (((NetworkInfo)localObject1).getExtraInfo() == null)) {
          break label226;
        }
        localObject1 = ((NetworkInfo)localObject1).getExtraInfo().replace("\"", "");
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "checknetinfo wifi get ssid=" + (String)localObject1 + ", current ssid=" + this.f);
        }
        if (localObject1 != null) {
          this.f = ((String)localObject1);
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, localThrowable1, new Object[0]);
        }
        localObject2 = null;
        continue;
      }
      try
      {
        localObject4 = (WifiManager)BaseApplication.getContext().getApplicationContext().getSystemService("wifi");
        localObject2 = localObject5;
        if (localObject4 == null) {
          continue;
        }
        localObject4 = ((WifiManager)localObject4).getConnectionInfo();
        localObject2 = localObject5;
        if (localObject4 == null) {
          continue;
        }
        localObject2 = localObject5;
        if (((WifiInfo)localObject4).getSSID() == null) {
          continue;
        }
        localObject2 = ((WifiInfo)localObject4).getSSID().replace("\"", "");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, localThrowable2, new Object[0]);
          }
          Object localObject4 = null;
        }
      }
      label226:
      Object localObject3 = null;
    }
  }
  
  private void w()
  {
    if (this.y != null)
    {
      int i1 = a(BaseApplication.getContext());
      if (this.q != i1) {
        this.y.a(this.q, i1);
      }
      this.q = i1;
    }
  }
  
  private void x()
  {
    int i2 = 0;
    int i4 = 0;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "updateNetIpFamily cur activeNetIpFamily=" + this.n);
    }
    for (;;)
    {
      try
      {
        localObject1 = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 21) {
          if (Build.VERSION.SDK_INT >= 23)
          {
            localObject1 = ((ConnectivityManager)localObject1).getLinkProperties(((ConnectivityManager)localObject1).getActiveNetwork());
            if (localObject1 == null) {
              break label668;
            }
            localObject3 = ((LinkProperties)localObject1).getLinkAddresses().iterator();
            i1 = 0;
            i3 = i1;
            i2 = i1;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Object localObject1;
          if (((Iterator)localObject3).hasNext())
          {
            i2 = i1;
            localObject1 = (LinkAddress)((Iterator)localObject3).next();
            if (localObject1 == null) {
              break label686;
            }
            i2 = i1;
            localObject1 = ((LinkAddress)localObject1).getAddress();
            i2 = i1;
            i3 = a((InetAddress)localObject1);
            i1 |= i3;
            continue;
            localObject3 = ((ConnectivityManager)localObject1).getAllNetworks();
            i3 = localObject3.length;
            i1 = 0;
            if (i1 >= i3) {
              break label673;
            }
            Object localObject4 = localObject3[i1];
            NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject1).getNetworkInfo((Network)localObject4);
            if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()) || (!localNetworkInfo.isConnected())) {
              break label679;
            }
            localObject1 = ((ConnectivityManager)localObject1).getLinkProperties((Network)localObject4);
            continue;
            localObject3 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
            if (localObject3 != null)
            {
              i1 = ((NetworkInfo)localObject3).getType();
              localObject1 = ConnectivityManager.class.getDeclaredMethod("getLinkProperties", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(i1) });
              localObject3 = localObject1.getClass().getDeclaredField("mLinkAddresses");
              ((Field)localObject3).setAccessible(true);
              localObject1 = (ArrayList)((Field)localObject3).get(localObject1);
              if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
                break label668;
              }
              localObject3 = Class.forName("android.net.LinkAddress").getDeclaredMethod("getAddress", new Class[0]);
              localObject4 = ((ArrayList)localObject1).iterator();
              i1 = 0;
              i3 = i1;
              i2 = i1;
              if (!((Iterator)localObject4).hasNext()) {
                continue;
              }
              i2 = i1;
              localObject1 = ((Iterator)localObject4).next();
              if (localObject1 != null)
              {
                i2 = i1;
                localObject1 = (InetAddress)((Method)localObject3).invoke(localObject1, new Object[0]);
                i2 = i1;
                i3 = a((InetAddress)localObject1);
                i1 |= i3;
                continue;
              }
            }
            else
            {
              i1 = -1;
              continue;
            }
            localObject1 = null;
            continue;
          }
          i1 = i3;
          i2 = i4;
          if (i2 != 0) {
            continue;
          }
          if (this.n != i1)
          {
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "updateNetIpFamily new1 activeNetIpFamily=" + i1);
            }
            this.n = i1;
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject3;
          int i3;
          i1 = i2;
          continue;
        }
        localThrowable1 = localThrowable1;
        i1 = i2;
        i2 = 1;
        continue;
        i2 = i1;
        try
        {
          Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
          i3 = i1;
          if (localEnumeration != null)
          {
            i2 = i1;
            i3 = i1;
            if (localEnumeration.hasMoreElements())
            {
              i2 = i1;
              localObject3 = (NetworkInterface)localEnumeration.nextElement();
              i3 = i1;
              if (localObject3 != null)
              {
                i2 = i1;
                if (!((NetworkInterface)localObject3).isUp()) {
                  continue;
                }
                i2 = i1;
                localObject3 = ((NetworkInterface)localObject3).getInetAddresses();
                i3 = i1;
                if (localObject3 != null)
                {
                  i3 = i1;
                  i2 = i1;
                  if (((Enumeration)localObject3).hasMoreElements())
                  {
                    i2 = i1;
                    i3 = a((InetAddress)((Enumeration)localObject3).nextElement());
                    i1 |= i3;
                    continue;
                  }
                }
              }
              i1 = i3;
              continue;
            }
          }
          if (this.n == i3) {
            continue;
          }
        }
        catch (SocketException localSocketException)
        {
          i3 = i2;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "updateNetIpFamily new2 activeNetIpFamily=" + i3);
        }
        this.n = i3;
        return;
      }
      label668:
      int i1 = 0;
      continue;
      label673:
      Object localObject2 = null;
      continue;
      label679:
      i1 += 1;
      continue;
      label686:
      localObject2 = null;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    boolean bool1 = false;
    if (paramBoolean) {
      x();
    }
    if (this.A == null) {
      this.A = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences("sso_list", 4).getBoolean("sso_list_enable_ipv6", false));
    }
    paramBoolean = this.A.get();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getActiveNetIpFamily " + paramBoolean);
    }
    for (;;)
    {
      try
      {
        if ((w.b == null) || (w.b.sender == null)) {
          continue;
        }
        String str = w.b.sender.j();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        String[] arrayOfString = this.z;
        int i2 = arrayOfString.length;
        i1 = 0;
        if (i1 >= i2) {
          continue;
        }
        boolean bool2 = str.equals(arrayOfString[i1]);
        if (!bool2) {
          continue;
        }
        paramBoolean = bool1;
      }
      catch (RuntimeException localRuntimeException)
      {
        int i1;
        QLog.d(a, 2, "getActiveNetIpFamily " + localRuntimeException);
        continue;
      }
      if (!paramBoolean) {
        break label208;
      }
      return this.n;
      i1 += 1;
    }
    label208:
    return 1;
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
  
  public void a(a.a parama)
  {
    this.x = parama;
  }
  
  public void a(a.b paramb)
  {
    this.w = paramb;
  }
  
  public void a(INetEventHandler paramINetEventHandler)
  {
    this.v = paramINetEventHandler;
  }
  
  public void a(INetInfoHandler paramINetInfoHandler)
  {
    this.u = paramINetInfoHandler;
  }
  
  public boolean a()
  {
    return (this.m == 2) || (this.m == 3);
  }
  
  public boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      v();
    }
    return this.f;
  }
  
  public boolean b()
  {
    return this.m == 1;
  }
  
  public int c()
  {
    return this.k;
  }
  
  public String c(boolean paramBoolean)
  {
    if (paramBoolean) {
      u();
    }
    return this.b;
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
    return this.o.get();
  }
  
  public NetworkInfo f()
  {
    return this.p;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */