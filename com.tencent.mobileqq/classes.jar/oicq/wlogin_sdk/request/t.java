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
import oicq.wlogin_sdk.pow.b;
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
  static int A;
  public static byte[] B;
  static byte[] C;
  public static byte[] D;
  public static int E;
  public static byte[] F;
  public static byte[] G;
  public static byte[] H;
  public static byte[] I;
  public static byte[] J;
  public static byte[] K;
  public static byte[] L;
  static byte[] M;
  @Deprecated
  static byte[] N;
  static byte[] O;
  static byte[] P;
  static byte[] Q;
  static byte[] R;
  static byte[] S;
  static byte[] T;
  static byte[] U;
  static int V;
  static int W;
  static int X;
  static int Y;
  static int Z;
  public static SecureRandom a = ;
  public static int aA = 0;
  public static String aB;
  public static String aC;
  public static int aD;
  public static String aE;
  private static boolean aF;
  private static Object aG;
  public static int aa;
  public static int ab;
  static boolean ac;
  static byte[] ad;
  static long ae;
  public static long af;
  static byte[] ag;
  static int ah;
  static int ai;
  public static boolean aj;
  public static int ak;
  public static byte[] al;
  static byte[] am;
  public static byte[] an;
  public static byte[] ao;
  public static c ar;
  protected static String as;
  public static Reporter at;
  public static long au;
  public static TreeMap<Long, async_context> av;
  public static boolean ax;
  public static boolean ay;
  public static String az;
  static Boolean e = Boolean.valueOf(false);
  public static Context u;
  public static int v;
  public static String w;
  static int x;
  static int y;
  static int z;
  Socket ap = null;
  Socket aq = null;
  public int aw;
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
  public int r = 1;
  public byte[] s = new byte[0];
  public int t = 0;
  
  static
  {
    aF = true;
    u = null;
    v = 2052;
    w = "";
    x = 0;
    y = 1;
    z = 0;
    A = 0;
    B = new byte[0];
    C = new byte[0];
    D = new byte[0];
    E = 0;
    F = new byte[0];
    G = new byte[0];
    H = new byte[0];
    I = new byte[0];
    J = new byte[0];
    K = new byte[0];
    L = "android".getBytes();
    M = new byte[0];
    N = new byte[0];
    O = new byte[0];
    P = new byte[0];
    Q = new byte[0];
    R = new byte[0];
    S = new byte[0];
    T = new byte[0];
    U = new byte[0];
    V = 0;
    W = 0;
    X = 0;
    Y = 0;
    Z = 0;
    aa = 0;
    ab = 0;
    ac = false;
    ad = new byte[0];
    ae = 0L;
    af = 0L;
    ag = new byte[4];
    ah = 0;
    ai = 0;
    aj = false;
    ak = 1;
    am = new byte[0];
    an = new byte[0];
    ao = new byte[0];
    ar = null;
    as = "";
    at = new Reporter();
    au = 0L;
    av = new TreeMap();
    aG = new Object();
    ax = false;
    ay = true;
  }
  
  public t(Context paramContext) {}
  
  public static long a()
  {
    try
    {
      if (au > 200L) {
        au = 0L;
      }
      long l1 = au + 1L;
      au = l1;
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
      al = util.string_to_buf(str);
      util.LOGI("get watch guid " + str, "");
      paramContext = al;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static async_context b(long paramLong)
  {
    for (;;)
    {
      synchronized (aG)
      {
        async_context localasync_context2 = (async_context)av.get(Long.valueOf(paramLong));
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
              av.put(Long.valueOf(paramLong), localasync_context1);
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
    if (str.compareTo(w) != 0)
    {
      w = str;
      new g(u).start();
    }
  }
  
  public static void c()
  {
    Object localObject2 = util.get_mac_addr(u);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > 0) {
        localObject1 = MD5.toMD5Byte((byte[])localObject2);
      }
    }
    Object localObject3 = util.get_android_id(u);
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (localObject3.length > 0) {
        localObject2 = MD5.toMD5Byte((byte[])localObject3);
      }
    }
    byte[] arrayOfByte1 = util.generateGuid(u);
    localObject3 = arrayOfByte1;
    if (arrayOfByte1 != null)
    {
      localObject3 = arrayOfByte1;
      if (arrayOfByte1.length > 0) {
        localObject3 = MD5.toMD5Byte(arrayOfByte1);
      }
    }
    if (util.get_last_flag(u) != 0)
    {
      arrayOfByte1 = util.get_last_mac(u);
      byte[] arrayOfByte2 = util.get_last_android_id(u);
      byte[] arrayOfByte3 = util.get_last_guid(u);
      if (!Arrays.equals((byte[])localObject1, arrayOfByte1)) {
        Z |= 0x1;
      }
      if (!Arrays.equals((byte[])localObject2, arrayOfByte2)) {
        Z |= 0x2;
      }
      if (!Arrays.equals((byte[])localObject3, arrayOfByte3)) {
        Z |= 0x4;
      }
    }
    util.save_cur_flag(u, 1);
    util.save_cur_mac(u, (byte[])localObject1);
    util.save_cur_android_id(u, (byte[])localObject2);
    util.save_cur_guid(u, (byte[])localObject3);
  }
  
  public static void c(long paramLong)
  {
    synchronized (aG)
    {
      try
      {
        av.remove(Long.valueOf(paramLong));
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
    aa = 0;
    a(u);
    Object localObject2 = util.getGuidFromFile(u);
    util.LOGI("get saved guid " + util.buf_to_string((byte[])localObject2), "");
    localObject1 = util.generateGuid(u);
    util.LOGI("get current guid " + util.buf_to_string((byte[])localObject1), "");
    localObject3 = new String("%4;7t>;28<fc.5*6").getBytes();
    if ((localObject2 == null) || (localObject2.length <= 0))
    {
      if ((localObject1 == null) || (localObject1.length <= 0))
      {
        W = 0;
        Y = 20;
        localObject1 = localObject3;
      }
      for (;;)
      {
        util.saveGuidToFile(u, (byte[])localObject1);
        X = 0;
        V = 1;
        c();
        aa |= Y << 24 & 0xFF000000;
        aa |= Z << 8 & 0xFF00;
        B = (byte[])((byte[])localObject1).clone();
        C = (byte[])((byte[])localObject1).clone();
        util.LOGI("guid src " + Y, "");
        ah = Build.VERSION.SDK_INT;
        O = util.get_mac_addr(u);
        if ((O != null) && (O.length > 0)) {
          O = MD5.toMD5Byte(O);
        }
        S = util.get_bssid_addr(u);
        if ((S != null) && (S.length > 0)) {
          S = MD5.toMD5Byte(S);
        }
        T = util.get_ssid_addr(u);
        P = util.get_android_id(u);
        if ((P != null) && (P.length > 0)) {
          P = MD5.toMD5Byte(P);
        }
        U = util.get_qimei(u);
        M = util.get_IMSI(u);
        if ((M != null) && (M.length > 0)) {
          M = MD5.toMD5Byte(M);
        }
        D = util.get_sim_operator_name(u);
        E = util.get_network_type(u);
        if (util.get_saved_network_type(u) != E)
        {
          util.set_net_retry_type(u, 0);
          util.save_network_type(u, E);
        }
        G = util.get_apn_string(u).getBytes();
        ad = util.get_ksid(u);
        F = util.get_apk_id(u);
        H = util.get_apk_v(u, new String(F));
        I = util.getPkgSigFromApkName(u, u.getPackageName());
        R = util.getAppName(u);
        localObject2 = Build.VERSION.RELEASE;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (16 < ((String)localObject1).length()) {
          localObject2 = ((String)localObject1).substring(0, 16);
        }
        K = ((String)localObject2).getBytes();
        localObject1 = Build.MODEL;
        try
        {
          localObject2 = util.a.a(u, "ro.vivo.market.name");
          boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
          if (bool) {
            break label973;
          }
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            continue;
            J = ((String)localObject1).getBytes();
            continue;
            Q = ((String)localObject1).getBytes();
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
          break label943;
        }
        J = new byte[0];
        localObject1 = Build.BRAND;
        if (localObject1 != null) {
          break label953;
        }
        Q = new byte[0];
        if ((!util.isFileExist("/system/bin/su")) && (!util.isFileExist("/system/xbin/su")) && (!util.isFileExist("/sbin/su"))) {
          break label963;
        }
        i1 = 1;
        if (i1 != 1) {
          break label968;
        }
        i1 = 1;
        ab = i1;
        ar = new c(u);
        at = report_t.read_fromfile(u);
        if (at == null) {
          at = new Reporter();
        }
        if (util.need_pow_test(ao)) {
          b.a();
        }
        util.LOGI("init ok os ver:" + new String(K) + " cur_guid:" + util.buf_to_string(B) + " svn " + 2463L + " at " + m(), "");
        return;
        W = 1;
        Y = 17;
      }
    }
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      localObject1 = localObject2;
      aF = false;
      if (!Arrays.equals((byte[])localObject3, (byte[])localObject1)) {
        break label932;
      }
    }
    label932:
    for (X = 0;; X = 1)
    {
      W = 1;
      V = 0;
      Y = 1;
      break;
      if ((!Arrays.equals((byte[])localObject3, (byte[])localObject2)) || (!aF)) {
        break label976;
      }
      localObject3 = m();
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).endsWith(":MSF"))) {}
      for (i1 = 1;; i1 = 0)
      {
        if ((i1 == 0) || (!util.needChangeGuid(u))) {
          break label976;
        }
        util.LOGI("reset guid :" + util.buf_to_string((byte[])localObject2) + "|" + util.buf_to_string((byte[])localObject1), "");
        c.a(u, (byte[])localObject2, (byte[])localObject1);
        util.saveGuidToFile(u, (byte[])localObject1);
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      }
    }
  }
  
  public static long f()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long g()
  {
    return System.currentTimeMillis() / 1000L + af;
  }
  
  @SuppressLint({"NewApi"})
  public static String m()
  {
    if ((as != null) && (as.length() > 0)) {
      return as;
    }
    try
    {
      int i1 = Process.myPid();
      Object localObject = ((ActivityManager)u.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
        {
          as = localRunningAppProcessInfo.processName;
          localObject = as;
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
      int i1 = ar.a(paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
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
      ar.d = this.aw;
      paramInt = ar.a(paramLong1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramWloginSimpleInfo, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
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
      localt.r = this.r;
    }
    if (paramLong <= 0L) {}
    for (localt.h = a();; localt.h = paramLong)
    {
      localt.c(u);
      return localt;
    }
  }
  
  public WloginSigInfo a(long paramLong1, long paramLong2)
  {
    try
    {
      WloginSigInfo localWloginSigInfo = ar.d(paramLong1, paramLong2);
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
      ar.a(paramLong1, paramLong2, paramArrayOfByte);
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
      ar.a(paramString);
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
      ar.a(paramString, paramLong, true);
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
      ar.a(paramString, paramLong, paramBoolean);
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
    ae = (util.buf_to_int32(paramArrayOfByte1, 0) & 0xFFFFFFFF) - System.currentTimeMillis() / 1000L;
    af = ae;
    ag = paramArrayOfByte2;
  }
  
  public int b(long paramLong1, long paramLong2)
  {
    try
    {
      int i1 = ar.a(paramLong1, paramLong2);
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
      paramString = ar.a(paramString, true);
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
    u = paramContext;
    paramContext = util.get_rand_16byte(a);
    System.arraycopy(paramContext, 0, this.c, 0, paramContext.length);
  }
  
  public UinInfo c(String paramString)
  {
    try
    {
      paramString = ar.a(paramString, false);
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
      ar.b(paramLong1, paramLong2);
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
    u = paramContext;
  }
  
  public WloginSimpleInfo d(long paramLong)
  {
    try
    {
      WloginSimpleInfo localWloginSimpleInfo = ar.b(paramLong);
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
    ar.c(paramLong1, paramLong2);
  }
  
  public void d(String paramString)
  {
    try
    {
      ar.b(paramString);
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
      String str = ar.b(Long.valueOf(paramLong));
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
      ar.a(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
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
    return u;
  }
  
  public void i()
  {
    util.LOGD("close_connect", "close_connect");
    if (this.ap != null) {}
    try
    {
      util.LOGD("close_connect", this.ap.toString());
      this.ap.close();
      this.ap = null;
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
    if (this.aq != null) {}
    try
    {
      util.LOGD("close_transport_connect", this.aq.toString());
      this.aq.close();
      this.aq = null;
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
      ar.a();
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
      List localList = ar.a(true);
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