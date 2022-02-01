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
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.j.c;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msf.sdk.y;
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
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo();
          i2 = 1;
          if (paramContext == null) {
            break label67;
          }
          i1 = 1;
          if (paramContext.getBSSID() == null) {
            break label72;
          }
          if ((i2 & i1) != 0)
          {
            i1 = WifiManager.calculateSignalLevel(paramContext.getRssi(), 32);
            return i1;
          }
        }
        return 0;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return -1;
      }
      label67:
      int i1 = 0;
      continue;
      label72:
      int i2 = 0;
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
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1) {
      return;
    }
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
      else if (b())
      {
        t();
        u();
        if ((!a(this.c, this.b)) && (this.w != null)) {
          this.w.b(this.c, this.b);
        }
        if (this.w != null) {
          this.w.e();
        }
      }
      else if (this.w != null)
      {
        this.w.g();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.w(a, 1, localThrowable.getMessage(), localThrowable);
      localThrowable.printStackTrace();
    }
    for (;;)
    {
      try
      {
        if (this.u != null) {
          if ((paramInt1 != 0) && (paramInt1 != 6))
          {
            if (paramInt1 != 1) {
              break label386;
            }
            this.u.onNetWifi2Mobile(this.b);
            continue;
            if (paramInt1 == 3)
            {
              this.u.onNetMobile2Wifi(this.f);
            }
            else if (paramInt1 == 4)
            {
              this.u.onNetMobile2None();
            }
            else if (paramInt1 == 5)
            {
              this.u.onNetWifi2None();
              continue;
              this.u.onNetNone2Wifi(this.f);
            }
          }
          else
          {
            this.u.onNetNone2Mobile(this.b);
          }
        }
        if (this.v != null) {
          if ((paramInt1 != 4) && (paramInt1 != 5) && (paramInt1 != 11)) {
            this.v.onNetChangeEvent(true);
          } else {
            this.v.onNetChangeEvent(false);
          }
        }
      }
      catch (Exception localException)
      {
        QLog.w(a, 1, localException.getMessage(), localException);
        localException.printStackTrace();
      }
      x();
      return;
      label386:
      if (paramInt1 != 2) {
        if (paramInt1 != 7) {}
      }
    }
  }
  
  private void a(Context paramContext, NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    paramContext = this.w;
    if (paramContext != null) {
      paramContext.b();
    }
    this.p = paramNetworkInfo1;
    int i1 = this.m;
    a(this.p, paramNetworkInfo2);
    int i2 = this.j;
    this.j = -1;
    paramContext = this.i;
    if (paramContext != null)
    {
      if (i2 != -1) {
        paramContext.post(new b(this, i2, i1));
      }
    }
    else {
      a(i2, i1);
    }
    paramContext = this.w;
    if (paramContext != null) {
      paramContext.c();
    }
  }
  
  private void a(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    Object localObject;
    StringBuilder localStringBuilder1;
    if (paramNetworkInfo1 != null)
    {
      localObject = paramNetworkInfo1.getTypeName();
      try
      {
        this.d = paramNetworkInfo1.getSubtypeName();
      }
      catch (Exception localException)
      {
        String str = a;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("get subtypeName error ");
        localStringBuilder2.append(localException);
        QLog.d(str, 1, localStringBuilder2.toString());
      }
      if (localObject == null)
      {
        QLog.d(a, 1, "subtype name is null, igonre");
        return;
      }
      if (((String)localObject).toLowerCase().contains("mobile_mms"))
      {
        QLog.d(a, 1, "checkConnInfo current typeName: mobile_mms ignore.");
        return;
      }
      localObject = a;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("refresh currentAPN:");
      localStringBuilder1.append(this.b);
      localStringBuilder1.append(". received networkInfo: ");
      localStringBuilder1.append(paramNetworkInfo1.getDetailedState());
      localStringBuilder1.append(" :");
      localStringBuilder1.append(b(paramNetworkInfo1));
      localStringBuilder1.append(". ExtraNetInfo: ");
      localStringBuilder1.append(b(paramNetworkInfo2));
      QLog.i((String)localObject, 1, localStringBuilder1.toString());
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
        paramNetworkInfo2 = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unexcepted activeNetInfo type:");
        ((StringBuilder)localObject).append(paramNetworkInfo1.getType());
        QLog.d(paramNetworkInfo2, 1, ((StringBuilder)localObject).toString());
        return;
      }
      if ((paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED))
      {
        if ((paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) && (MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null) && (MsfCore.sCore.statReporter.Y != null) && (MsfCore.sCore.statReporter.Y.g == 0L))
        {
          MsfCore.sCore.statReporter.Y.g = System.currentTimeMillis();
          QLog.d(a, 1, new Object[] { "MSF_Alive_Log on netWork refresh netWorkFailTime =", Long.valueOf(System.currentTimeMillis()) });
        }
      }
      else
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
      }
    }
    else if (paramNetworkInfo2 != null)
    {
      localObject = a;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("currentAPN:");
      localStringBuilder1.append(this.b);
      localStringBuilder1.append(". ActiveNetInfo: ");
      localStringBuilder1.append(paramNetworkInfo1);
      localStringBuilder1.append(". ExtraNetInfo: ");
      localStringBuilder1.append(paramNetworkInfo2);
      QLog.d((String)localObject, 1, localStringBuilder1.toString());
      if ((paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) || (paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.FAILED) || (paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.IDLE) || (paramNetworkInfo2.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED))
      {
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
    }
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
        StringBuilder localStringBuilder = new StringBuilder("NetworkInfo: ");
        localStringBuilder.append("type: ");
        localStringBuilder.append(paramNetworkInfo.getTypeName());
        localStringBuilder.append("[");
        localStringBuilder.append(paramNetworkInfo.getSubtypeName());
        localStringBuilder.append("], state: ");
        localStringBuilder.append(paramNetworkInfo.getState());
        localStringBuilder.append("/");
        localStringBuilder.append(paramNetworkInfo.getDetailedState());
        localStringBuilder.append(", reason: ");
        if (paramNetworkInfo.getReason() == null) {
          str = "(unspecified)";
        } else {
          str = paramNetworkInfo.getReason();
        }
        localStringBuilder.append(str);
        localStringBuilder.append(", extra: ");
        if (paramNetworkInfo.getExtraInfo() == null) {
          str = "(none)";
        } else {
          str = paramNetworkInfo.getExtraInfo().substring(0, paramNetworkInfo.getExtraInfo().length() / 2);
        }
        localStringBuilder.append(str);
        localStringBuilder.append(", roaming: ");
        localStringBuilder.append(paramNetworkInfo.isRoaming());
        localStringBuilder.append(", failover: ");
        localStringBuilder.append(paramNetworkInfo.isFailover());
        localStringBuilder.append(", isAvailable: ");
        localStringBuilder.append(paramNetworkInfo.isAvailable());
        localStringBuilder.append(", isConnectedToProvisioningNetwork: ");
        localStringBuilder.append(paramNetworkInfo.isConnectedOrConnecting());
        String str = localStringBuilder.toString();
        return str;
      }
      finally {}
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if (this.m == paramInt) {
      return;
    }
    if (paramInt > 0) {
      d(true);
    } else {
      d(false);
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("netchange ");
    localStringBuilder.append(a(this.m));
    localStringBuilder.append(" to ");
    localStringBuilder.append(a(paramInt));
    QLog.d(str, 1, localStringBuilder.toString());
    this.j = -1;
    if (paramInt == 1)
    {
      if ((this.m != 0) && (this.m != -2))
      {
        if ((this.m != 2) && (this.m != 3))
        {
          if (this.m <= 7) {
            this.j = 6;
          }
        }
        else {
          this.j = 1;
        }
      }
      else {
        this.j = 0;
      }
    }
    else if ((paramInt != 2) && (paramInt != 3))
    {
      if ((paramInt > 3) && (paramInt <= 7))
      {
        if ((this.m != 0) && (this.m != -2))
        {
          if (this.m == 1) {
            this.j = 9;
          } else if ((this.m == 2) || (this.m == 3)) {
            this.j = 10;
          }
        }
        else {
          this.j = 8;
        }
      }
      else if (this.m == 1) {
        this.j = 4;
      } else if ((this.m != 2) && (this.m != 3))
      {
        if (this.m <= 7) {
          this.j = 11;
        }
      }
      else {
        this.j = 5;
      }
    }
    else if ((this.m != 0) && (this.m != -2))
    {
      if (this.m == 1) {
        this.j = 3;
      } else if (this.m <= 7) {
        this.j = 7;
      }
    }
    else {
      this.j = 2;
    }
    this.m = paramInt;
  }
  
  private void d(boolean paramBoolean)
  {
    this.o.set(paramBoolean);
  }
  
  private void n()
  {
    int i1 = this.l;
    NetworkInfo localNetworkInfo = this.p;
    if (localNetworkInfo != null) {
      i1 = localNetworkInfo.getSubtype();
    } else {
      try
      {
        int i2 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType();
        i1 = i2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.l = y.a(i1);
    b(this.m | 0x1);
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
    this.k = com.tencent.mobileqq.msf.core.net.j.a(this.p);
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 70	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   5: putfield 72	com/tencent/mobileqq/msf/sdk/a/a:c	Ljava/lang/String;
    //   8: invokestatic 502	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc_w 524
    //   14: invokevirtual 505	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 526	android/net/ConnectivityManager
    //   20: astore_3
    //   21: aload_3
    //   22: iconst_0
    //   23: invokevirtual 530	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: ifnonnull +13 -> 43
    //   33: aload_3
    //   34: bipush 50
    //   36: invokevirtual 530	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   39: astore_1
    //   40: goto +3 -> 43
    //   43: aload_1
    //   44: ifnull +12 -> 56
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 450	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   52: putfield 70	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   55: return
    //   56: aconst_null
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_2
    //   60: invokestatic 502	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   63: invokevirtual 534	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   66: getstatic 62	com/tencent/mobileqq/msf/sdk/a/a:h	Landroid/net/Uri;
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 540	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +42 -> 120
    //   81: aload_3
    //   82: astore_2
    //   83: aload_3
    //   84: astore_1
    //   85: aload_3
    //   86: invokeinterface 545 1 0
    //   91: ifeq +29 -> 120
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: astore_1
    //   98: aload_0
    //   99: aload_3
    //   100: aload_3
    //   101: ldc_w 547
    //   104: invokeinterface 551 2 0
    //   109: invokeinterface 554 2 0
    //   114: putfield 70	com/tencent/mobileqq/msf/sdk/a/a:b	Ljava/lang/String;
    //   117: goto -40 -> 77
    //   120: aload_3
    //   121: ifnull +77 -> 198
    //   124: aload_3
    //   125: astore_1
    //   126: aload_1
    //   127: invokeinterface 557 1 0
    //   132: return
    //   133: astore_1
    //   134: goto +17 -> 151
    //   137: astore_3
    //   138: aload_1
    //   139: astore_2
    //   140: aload_3
    //   141: invokevirtual 226	java/lang/Throwable:printStackTrace	()V
    //   144: aload_1
    //   145: ifnull +53 -> 198
    //   148: goto -22 -> 126
    //   151: aload_2
    //   152: ifnull +9 -> 161
    //   155: aload_2
    //   156: invokeinterface 557 1 0
    //   161: aload_1
    //   162: athrow
    //   163: getstatic 217	com/tencent/mobileqq/msf/sdk/a/a:a	Ljava/lang/String;
    //   166: astore_1
    //   167: new 286	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   174: astore_2
    //   175: aload_2
    //   176: ldc_w 559
    //   179: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_2
    //   184: aload_3
    //   185: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_1
    //   190: iconst_1
    //   191: aload_2
    //   192: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: return
    //   199: astore_3
    //   200: goto -37 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	a
    //   28	99	1	localObject1	Object
    //   133	29	1	localObject2	Object
    //   166	24	1	str	String
    //   26	166	2	localObject3	Object
    //   20	105	3	localObject4	Object
    //   137	48	3	localThrowable	Throwable
    //   199	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   60	77	133	finally
    //   85	94	133	finally
    //   98	117	133	finally
    //   140	144	133	finally
    //   60	77	137	java/lang/Throwable
    //   85	94	137	java/lang/Throwable
    //   98	117	137	java/lang/Throwable
    //   33	40	199	java/lang/Exception
    //   47	55	199	java/lang/Exception
    //   126	132	199	java/lang/Exception
    //   155	161	199	java/lang/Exception
    //   161	163	199	java/lang/Exception
  }
  
  private void v()
  {
    this.e = this.f;
    int i1 = Build.VERSION.SDK_INT;
    StringBuilder localStringBuilder = null;
    Object localObject3;
    Object localObject2;
    if (i1 == 27)
    {
      try
      {
        localObject3 = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
      }
      catch (Throwable localThrowable1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, localThrowable1, new Object[0]);
        }
        localObject3 = null;
      }
      Object localObject1 = localStringBuilder;
      if (localObject3 != null)
      {
        localObject3 = ((ConnectivityManager)localObject3).getNetworkInfo(1);
        localObject1 = localStringBuilder;
        if (localObject3 != null)
        {
          localObject1 = localStringBuilder;
          if (((NetworkInfo)localObject3).getExtraInfo() != null) {
            localObject1 = ((NetworkInfo)localObject3).getExtraInfo().replace("\"", "");
          }
        }
      }
    }
    else
    {
      try
      {
        localObject3 = (WifiManager)BaseApplication.getContext().getApplicationContext().getSystemService("wifi");
      }
      catch (Throwable localThrowable2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, localThrowable2, new Object[0]);
        }
        localObject3 = null;
      }
      localObject2 = localStringBuilder;
      if (localObject3 != null)
      {
        localObject3 = ((WifiManager)localObject3).getConnectionInfo();
        localObject2 = localStringBuilder;
        if (localObject3 != null)
        {
          localObject2 = localStringBuilder;
          if (((WifiInfo)localObject3).getSSID() != null) {
            localObject2 = ((WifiInfo)localObject3).getSSID().replace("\"", "");
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checknetinfo wifi get ssid=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", current ssid=");
      localStringBuilder.append(this.f);
      QLog.d((String)localObject3, 2, localStringBuilder.toString());
    }
    if (localObject2 != null) {
      this.f = ((String)localObject2);
    }
  }
  
  private void w()
  {
    if (this.y != null)
    {
      int i1 = a(BaseApplication.getContext());
      int i2 = this.q;
      if (i2 != i1) {
        this.y.a(i2, i1);
      }
      this.q = i1;
    }
  }
  
  private void x()
  {
    Object localObject1;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("updateNetIpFamily cur activeNetIpFamily=");
      ((StringBuilder)localObject3).append(this.n);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
    }
    i3 = 1;
    try
    {
      localObject1 = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
      if (Build.VERSION.SDK_INT < 21) {
        break label235;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = ((ConnectivityManager)localObject1).getLinkProperties(((ConnectivityManager)localObject1).getActiveNetwork());
        break label163;
      }
      localObject3 = ((ConnectivityManager)localObject1).getAllNetworks();
      i2 = localObject3.length;
      i1 = 0;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        int i2;
        Object localObject4;
        NetworkInfo localNetworkInfo;
        label163:
        label235:
        continue;
        label440:
        i1 += 1;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        int i1 = -1;
        continue;
        localObject2 = null;
      }
    }
    if (i1 < i2)
    {
      localObject4 = localObject3[i1];
      localNetworkInfo = ((ConnectivityManager)localObject1).getNetworkInfo((Network)localObject4);
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected()))
      {
        localObject1 = ((ConnectivityManager)localObject1).getLinkProperties((Network)localObject4);
        if (localObject1 != null)
        {
          localObject3 = ((LinkProperties)localObject1).getLinkAddresses().iterator();
          i1 = 0;
          i2 = i1;
        }
        for (;;)
        {
          try
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = (LinkAddress)((Iterator)localObject3).next();
              if (localObject1 == null) {
                break label717;
              }
              localObject1 = ((LinkAddress)localObject1).getAddress();
              i2 = a((InetAddress)localObject1);
              i1 |= i2;
              break;
              localObject3 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
              if (localObject3 == null) {
                break label723;
              }
              i1 = ((NetworkInfo)localObject3).getType();
              localObject1 = ConnectivityManager.class.getDeclaredMethod("getLinkProperties", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(i1) });
              localObject3 = localObject1.getClass().getDeclaredField("mLinkAddresses");
              ((Field)localObject3).setAccessible(true);
              localObject1 = (ArrayList)((Field)localObject3).get(localObject1);
              if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
              {
                localObject3 = Class.forName("android.net.LinkAddress").getDeclaredMethod("getAddress", new Class[0]);
                localObject4 = ((ArrayList)localObject1).iterator();
                i1 = 0;
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            continue;
          }
          try
          {
            if (((Iterator)localObject4).hasNext())
            {
              localObject1 = ((Iterator)localObject4).next();
              if (localObject1 == null) {
                break label728;
              }
              localObject1 = (InetAddress)((Method)localObject3).invoke(localObject1, new Object[0]);
              i2 = a((InetAddress)localObject1);
              i1 |= i2;
            }
            else
            {
              i2 = i1;
            }
          }
          catch (Throwable localThrowable3) {}
        }
        break label440;
        i2 = 0;
        i3 = 0;
        i1 = i2;
        break label440;
        i1 = 0;
        if (i3 == 0)
        {
          if (this.n != i1)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = a;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("updateNetIpFamily new1 activeNetIpFamily=");
              ((StringBuilder)localObject3).append(i1);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
            }
            this.n = i1;
          }
          return;
        }
        i2 = i1;
        try
        {
          localObject1 = NetworkInterface.getNetworkInterfaces();
          do
          {
            do
            {
              i3 = i1;
              if (localObject1 == null) {
                break;
              }
              i3 = i1;
              i2 = i1;
              if (!((Enumeration)localObject1).hasMoreElements()) {
                break;
              }
              i2 = i1;
              localObject3 = (NetworkInterface)((Enumeration)localObject1).nextElement();
            } while (localObject3 == null);
            i2 = i1;
          } while (!((NetworkInterface)localObject3).isUp());
          i2 = i1;
          localObject3 = ((NetworkInterface)localObject3).getInetAddresses();
          i3 = i1;
          for (;;)
          {
            i1 = i3;
            if (localObject3 == null) {
              break;
            }
            i1 = i3;
            i2 = i3;
            if (!((Enumeration)localObject3).hasMoreElements()) {
              break;
            }
            i2 = i3;
            i1 = a((InetAddress)((Enumeration)localObject3).nextElement());
            i3 |= i1;
          }
        }
        catch (SocketException localSocketException)
        {
          for (;;)
          {
            i3 = i2;
          }
        }
        if (this.n != i3)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = a;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateNetIpFamily new2 activeNetIpFamily=");
            ((StringBuilder)localObject3).append(i3);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
          this.n = i3;
        }
        return;
      }
    }
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      x();
    }
    Object localObject1 = this.A;
    int i2 = 1;
    if (localObject1 == null) {
      this.A = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences("sso_list", 4).getBoolean("sso_list_enable_ipv6", true));
    }
    boolean bool = this.A.get();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getActiveNetIpFamily ");
      ((StringBuilder)localObject2).append(bool);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    paramBoolean = bool;
    try
    {
      int i1;
      if (s.b != null)
      {
        paramBoolean = bool;
        if (s.b.sender != null)
        {
          localObject1 = s.b.sender.l();
          paramBoolean = bool;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = this.z;
            int i3 = localObject2.length;
            i1 = 0;
            for (;;)
            {
              paramBoolean = bool;
              if (i1 >= i3) {
                break;
              }
              paramBoolean = ((String)localObject1).equals(localObject2[i1]);
              if (paramBoolean)
              {
                paramBoolean = false;
                break;
              }
              i1 += 1;
            }
          }
        }
      }
      StringBuilder localStringBuilder;
      return i1;
    }
    catch (RuntimeException localRuntimeException)
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getActiveNetIpFamily ");
      localStringBuilder.append(localRuntimeException);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
      paramBoolean = bool;
      i1 = i2;
      if (paramBoolean) {
        i1 = this.n;
      }
    }
  }
  
  /* Error */
  public void a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: ldc_w 524
    //   8: invokevirtual 134	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11: checkcast 526	android/net/ConnectivityManager
    //   14: invokevirtual 647	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: goto +26 -> 48
    //   25: astore_1
    //   26: goto +32 -> 58
    //   29: astore 4
    //   31: getstatic 217	com/tencent/mobileqq/msf/sdk/a/a:a	Ljava/lang/String;
    //   34: iconst_1
    //   35: aload 4
    //   37: invokevirtual 253	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   40: aload 4
    //   42: invokevirtual 770	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   45: invokestatic 225	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload_0
    //   49: aload_1
    //   50: aload_3
    //   51: aload_2
    //   52: invokespecial 772	com/tencent/mobileqq/msf/sdk/a/a:a	(Landroid/content/Context;Landroid/net/NetworkInfo;Landroid/net/NetworkInfo;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	a
    //   0	62	1	paramContext	Context
    //   0	62	2	paramNetworkInfo	NetworkInfo
    //   3	48	3	localObject	Object
    //   17	3	4	localNetworkInfo	NetworkInfo
    //   29	12	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	19	25	finally
    //   31	48	25	finally
    //   48	55	25	finally
    //   4	19	29	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */