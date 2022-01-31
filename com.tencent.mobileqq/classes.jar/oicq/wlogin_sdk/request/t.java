package oicq.wlogin_sdk.request;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;
import oicq.wlogin_sdk.tools.util.a;

public class t
{
  public static byte[] A;
  static byte[] B;
  public static byte[] C;
  public static int D;
  public static byte[] E;
  public static byte[] F;
  public static byte[] G;
  public static byte[] H;
  public static byte[] I;
  public static byte[] J;
  public static byte[] K;
  static byte[] L;
  @Deprecated
  static byte[] M;
  static byte[] N;
  static byte[] O;
  static byte[] P;
  static byte[] Q;
  static byte[] R;
  static byte[] S;
  static byte[] T;
  static int U;
  static int V;
  static int W;
  static int X;
  static int Y;
  public static int Z;
  public static SecureRandom a = ;
  public static int aA;
  public static String aB;
  private static boolean aC;
  private static Object aD = new Object();
  public static int aa;
  static boolean ab;
  static byte[] ac;
  static long ad;
  public static long ae;
  static byte[] af;
  static int ag;
  static int ah;
  public static boolean ai;
  public static int aj;
  public static byte[] ak;
  static byte[] al;
  public static c ao;
  protected static String ap;
  public static Reporter aq;
  public static long ar;
  public static TreeMap<Long, async_context> as;
  public static boolean au = false;
  public static boolean av = true;
  public static String aw;
  public static int ax = 0;
  public static String ay;
  public static String az;
  static Boolean e = Boolean.valueOf(false);
  public static Context t;
  public static int u;
  public static String v;
  static int w;
  static int x;
  static int y;
  static int z;
  Socket am = null;
  Socket an = null;
  public int at;
  public byte[] b = null;
  public byte[] c = new byte[16];
  public tlv_t150 d = null;
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  public int i = 0;
  public WFastLoginInfo j;
  public int k = 0;
  public int l = 5000;
  public int m = 0;
  public byte[] n = new byte[16];
  public byte[] o = new byte[16];
  public byte[] p = new byte[16];
  public byte[] q = new byte[0];
  public byte[] r = new byte[0];
  public int s = 0;
  
  static
  {
    aC = true;
    t = null;
    u = 2052;
    v = "";
    w = 0;
    x = 1;
    y = 0;
    z = 0;
    A = new byte[0];
    B = new byte[0];
    C = new byte[0];
    D = 0;
    E = new byte[0];
    F = new byte[0];
    G = new byte[0];
    H = new byte[0];
    I = new byte[0];
    J = new byte[0];
    K = "android".getBytes();
    L = new byte[0];
    M = new byte[0];
    N = new byte[0];
    O = new byte[0];
    P = new byte[0];
    Q = new byte[0];
    R = new byte[0];
    S = new byte[0];
    T = new byte[0];
    U = 0;
    V = 0;
    W = 0;
    X = 0;
    Y = 0;
    Z = 0;
    aa = 0;
    ab = false;
    ac = new byte[0];
    ad = 0L;
    ae = 0L;
    af = new byte[4];
    ag = 0;
    ah = 0;
    ai = false;
    aj = 1;
    al = new byte[0];
    ao = null;
    ap = "";
    aq = new Reporter();
    ar = 0L;
    as = new TreeMap();
  }
  
  public t(Context paramContext) {}
  
  public static long a()
  {
    try
    {
      if (ar > 200L) {
        ar = 0L;
      }
      long l1 = ar + 1L;
      ar = l1;
      return l1;
    }
    finally {}
  }
  
  public static byte[] a(Context paramContext)
  {
    try
    {
      String str = (String)Class.forName("com.tencent.mobileqq.utils.KidInfoUtil").getMethod("getGuid", new Class[0]).invoke(null, new Object[0]);
      if (str == null)
      {
        util.LOGI("get watch guid null", "");
        return null;
      }
      util.saveGuidToFile(paramContext, util.string_to_buf(str));
      ak = util.string_to_buf(str);
      util.LOGI("get watch guid " + str, "");
      paramContext = ak;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static async_context b(long paramLong)
  {
    for (;;)
    {
      synchronized (aD)
      {
        async_context localasync_context2 = (async_context)as.get(Long.valueOf(paramLong));
        if (localasync_context2 == null)
        {
          for (;;)
          {
            try
            {
              localasync_context1 = new async_context();
            }
            catch (Exception localException3)
            {
              async_context localasync_context1;
              Exception localException1 = localException2;
              Object localObject2 = localException3;
              continue;
            }
            try
            {
              as.put(Long.valueOf(paramLong), localasync_context1);
              return localasync_context1;
            }
            catch (Exception localException2) {}
          }
          util.printException(localasync_context2, "");
        }
      }
      localException1 = localException2;
    }
  }
  
  public static void b()
  {
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if (str.compareTo(v) != 0)
    {
      v = str;
      new g(t).start();
    }
  }
  
  public static void c()
  {
    Object localObject2 = util.get_mac_addr(t);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > 0) {
        localObject1 = MD5.toMD5Byte((byte[])localObject2);
      }
    }
    Object localObject3 = util.get_android_id(t);
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (localObject3.length > 0) {
        localObject2 = MD5.toMD5Byte((byte[])localObject3);
      }
    }
    byte[] arrayOfByte1 = util.generateGuid(t);
    localObject3 = arrayOfByte1;
    if (arrayOfByte1 != null)
    {
      localObject3 = arrayOfByte1;
      if (arrayOfByte1.length > 0) {
        localObject3 = MD5.toMD5Byte(arrayOfByte1);
      }
    }
    if (util.get_last_flag(t) != 0)
    {
      arrayOfByte1 = util.get_last_mac(t);
      byte[] arrayOfByte2 = util.get_last_android_id(t);
      byte[] arrayOfByte3 = util.get_last_guid(t);
      if (!Arrays.equals((byte[])localObject1, arrayOfByte1)) {
        Y |= 0x1;
      }
      if (!Arrays.equals((byte[])localObject2, arrayOfByte2)) {
        Y |= 0x2;
      }
      if (!Arrays.equals((byte[])localObject3, arrayOfByte3)) {
        Y |= 0x4;
      }
    }
    util.save_cur_flag(t, 1);
    util.save_cur_mac(t, (byte[])localObject1);
    util.save_cur_android_id(t, (byte[])localObject2);
    util.save_cur_guid(t, (byte[])localObject3);
  }
  
  public static void c(long paramLong)
  {
    synchronized (aD)
    {
      try
      {
        as.remove(Long.valueOf(paramLong));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          util.printException(localException, "");
        }
      }
    }
  }
  
  public static void d()
  {
    util.LOGI("init start", "");
    Z = 0;
    a(t);
    Object localObject2 = util.getGuidFromFile(t);
    util.LOGI("get saved guid " + util.buf_to_string((byte[])localObject2), "");
    localObject1 = util.generateGuid(t);
    util.LOGI("get current guid " + util.buf_to_string((byte[])localObject1), "");
    localObject3 = new String("%4;7t>;28<fc.5*6").getBytes();
    if ((localObject2 == null) || (localObject2.length <= 0))
    {
      if ((localObject1 == null) || (localObject1.length <= 0))
      {
        V = 0;
        X = 20;
        localObject1 = localObject3;
      }
      for (;;)
      {
        util.saveGuidToFile(t, (byte[])localObject1);
        W = 0;
        U = 1;
        c();
        Z |= X << 24 & 0xFF000000;
        Z |= Y << 8 & 0xFF00;
        A = (byte[])((byte[])localObject1).clone();
        B = (byte[])((byte[])localObject1).clone();
        util.LOGI("guid src " + X, "");
        ag = Build.VERSION.SDK_INT;
        N = util.get_mac_addr(t);
        if ((N != null) && (N.length > 0)) {
          N = MD5.toMD5Byte(N);
        }
        R = util.get_bssid_addr(t);
        if ((R != null) && (R.length > 0)) {
          R = MD5.toMD5Byte(R);
        }
        S = util.get_ssid_addr(t);
        O = util.get_android_id(t);
        if ((O != null) && (O.length > 0)) {
          O = MD5.toMD5Byte(O);
        }
        T = util.get_qimei(t);
        L = util.get_IMSI(t);
        if ((L != null) && (L.length > 0)) {
          L = MD5.toMD5Byte(L);
        }
        C = util.get_sim_operator_name(t);
        D = util.get_network_type(t);
        if (util.get_saved_network_type(t) != D)
        {
          util.set_net_retry_type(t, 0);
          util.save_network_type(t, D);
        }
        F = util.get_apn_string(t).getBytes();
        ac = util.get_ksid(t);
        E = util.get_apk_id(t);
        G = util.get_apk_v(t, new String(E));
        H = util.getPkgSigFromApkName(t, t.getPackageName());
        Q = util.getAppName(t);
        localObject2 = Build.VERSION.RELEASE;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (16 < ((String)localObject1).length()) {
          localObject2 = ((String)localObject1).substring(0, 16);
        }
        J = ((String)localObject2).getBytes();
        localObject1 = Build.MODEL;
        try
        {
          localObject2 = util.a.a(t, "ro.vivo.market.name");
          boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
          if (bool) {
            break label950;
          }
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            continue;
            I = ((String)localObject1).getBytes();
            continue;
            P = ((String)localObject1).getBytes();
            continue;
            int i1 = 0;
            continue;
            i1 = 0;
            continue;
            continue;
            localObject3 = localObject1;
            localObject1 = localThrowable;
          }
        }
        if (localObject1 != null) {
          break label920;
        }
        I = new byte[0];
        localObject1 = Build.BRAND;
        if (localObject1 != null) {
          break label930;
        }
        P = new byte[0];
        if ((!util.isFileExist("/system/bin/su")) && (!util.isFileExist("/system/xbin/su")) && (!util.isFileExist("/sbin/su"))) {
          break label940;
        }
        i1 = 1;
        if (i1 != 1) {
          break label945;
        }
        i1 = 1;
        aa = i1;
        ao = new c(t);
        aq = report_t.read_fromfile(t);
        if (aq == null) {
          aq = new Reporter();
        }
        util.LOGI("init ok os ver:" + new String(J) + " cur_guid:" + util.buf_to_string(A) + " svn " + 2425L + " at " + m(), "");
        return;
        V = 1;
        X = 17;
      }
    }
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      localObject1 = localObject2;
      label763:
      aC = false;
      if (!Arrays.equals((byte[])localObject3, (byte[])localObject1)) {
        break label909;
      }
    }
    label909:
    for (W = 0;; W = 1)
    {
      V = 1;
      U = 0;
      X = 1;
      break;
      if ((!Arrays.equals((byte[])localObject3, (byte[])localObject2)) || (!aC)) {
        break label953;
      }
      localObject3 = m();
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).endsWith(":MSF")) || (!util.needChangeGuid(t))) {
        break label953;
      }
      util.LOGI("reset guid :" + util.buf_to_string((byte[])localObject2) + "|" + util.buf_to_string((byte[])localObject1), "");
      c.a(t, (byte[])localObject2, (byte[])localObject1);
      util.saveGuidToFile(t, (byte[])localObject1);
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject1 = localObject2;
      break label763;
    }
  }
  
  public static long f()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long g()
  {
    return System.currentTimeMillis() / 1000L + ae;
  }
  
  @SuppressLint({"NewApi"})
  public static String m()
  {
    if ((ap != null) && (ap.length() > 0)) {
      return ap;
    }
    try
    {
      int i1 = Process.myPid();
      Object localObject = ((ActivityManager)t.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
        {
          ap = localRunningAppProcessInfo.processName;
          localObject = ap;
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "");
    }
    return "";
  }
  
  private static SecureRandom n()
  {
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      return localSecureRandom;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      int i1 = ao.a(paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
      return i1;
    }
    finally
    {
      paramArrayOfByte1 = finally;
      throw paramArrayOfByte1;
    }
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    try
    {
      ao.d = this.at;
      paramInt = ao.a(paramLong1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramWloginSimpleInfo, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
      return paramInt;
    }
    finally
    {
      paramArrayOfByte1 = finally;
      throw paramArrayOfByte1;
    }
  }
  
  public t a(long paramLong)
  {
    t localt = new t(null);
    localt.k = this.k;
    localt.l = this.l;
    if (this.c != null) {
      localt.c = ((byte[])this.c.clone());
    }
    if ((this.n != null) && (this.p != null))
    {
      localt.n = ((byte[])this.n.clone());
      localt.p = ((byte[])this.p.clone());
    }
    if (paramLong <= 0L) {}
    for (localt.h = a();; localt.h = paramLong)
    {
      localt.c(t);
      return localt;
    }
  }
  
  public WloginSigInfo a(long paramLong1, long paramLong2)
  {
    try
    {
      WloginSigInfo localWloginSigInfo = ao.d(paramLong1, paramLong2);
      if (localWloginSigInfo != null) {}
      return localWloginSigInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    try
    {
      ao.a(paramLong1, paramLong2, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      ao.a(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, Long paramLong)
  {
    try
    {
      ao.a(paramString, paramLong, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    try
    {
      ao.a(paramString, paramLong, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ad = (util.buf_to_int32(paramArrayOfByte1, 0) & 0xFFFFFFFF) - System.currentTimeMillis() / 1000L;
    ae = ad;
    af = paramArrayOfByte2;
  }
  
  public int b(long paramLong1, long paramLong2)
  {
    try
    {
      int i1 = ao.a(paramLong1, paramLong2);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long b(String paramString)
  {
    long l2 = 0L;
    try
    {
      paramString = ao.a(paramString, true);
      long l1 = l2;
      if (paramString != null)
      {
        l1 = l2;
        if (paramString._uin.longValue() != 0L) {
          l1 = paramString._uin.longValue();
        }
      }
      return l1;
    }
    finally {}
  }
  
  public void b(Context paramContext)
  {
    t = paramContext;
    paramContext = util.get_rand_16byte(a);
    System.arraycopy(paramContext, 0, this.c, 0, paramContext.length);
  }
  
  public UinInfo c(String paramString)
  {
    try
    {
      paramString = ao.a(paramString, false);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    try
    {
      ao.b(paramLong1, paramLong2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(Context paramContext)
  {
    t = paramContext;
  }
  
  public WloginSimpleInfo d(long paramLong)
  {
    try
    {
      WloginSimpleInfo localWloginSimpleInfo = ao.b(paramLong);
      if (localWloginSimpleInfo != null) {}
      return localWloginSimpleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(long paramLong1, long paramLong2)
  {
    ao.c(paramLong1, paramLong2);
  }
  
  public void d(String paramString)
  {
    try
    {
      ao.b(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String e(long paramLong)
  {
    try
    {
      String str = ao.b(Long.valueOf(paramLong));
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(long paramLong1, long paramLong2)
  {
    try
    {
      ao.a(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    return this.k != 0;
  }
  
  public Context h()
  {
    return t;
  }
  
  public void i()
  {
    util.LOGD("close_connect", "close_connect");
    if (this.am != null) {}
    try
    {
      util.LOGD("close_connect", this.am.toString());
      this.am.close();
      this.am = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        util.printException(localException, "");
      }
    }
  }
  
  public void j()
  {
    if (this.an != null) {}
    try
    {
      util.LOGD("close_transport_connect", this.an.toString());
      this.an.close();
      this.an = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        util.printException(localException, "");
      }
    }
  }
  
  public void k()
  {
    try
    {
      ao.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<WloginLoginInfo> l()
  {
    try
    {
      List localList = ao.a(true);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.t
 * JD-Core Version:    0.7.0.1
 */