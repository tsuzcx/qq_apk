package com.tencent.mobileqq.msf.core.net;

import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.c.a;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.b.k;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class n
{
  private static long K = -1L;
  private static final int X = -1;
  private static final int Y = 0;
  private static final int Z = 1;
  public static final String a = "MSF.C.NetConnTag";
  private static final int aa = 2;
  public static final int b = 2;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 300000;
  public static byte n = -1;
  public static String p = "";
  public static final int q = -1;
  public static final int r = 0;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = -1;
  public static final int v = 0;
  public static final int w = 1;
  public static final int x = 2;
  public static final int y = 3;
  private Handler A;
  private m[] B = new m[2];
  private AtomicInteger C;
  private boolean D = false;
  private boolean E = false;
  private String F = "";
  private long G = 0L;
  private ArrayList H = new ArrayList();
  private long I = 0L;
  private long J = 0L;
  private ArrayList L = new ArrayList();
  private ArrayList M = new ArrayList();
  private Thread N = null;
  private long O = 0L;
  private boolean P = false;
  private Thread Q = null;
  private long R = 0L;
  private AtomicBoolean S = new AtomicBoolean(false);
  private int T = 0;
  private boolean U = false;
  private boolean V = false;
  private long W = 0L;
  private n.c ab = new n.c(this);
  MsfCore f;
  public com.tencent.mobileqq.msf.core.net.b.o g;
  Runnable h = null;
  public final n.b i = new n.b(this);
  public volatile long[] j = new long[2];
  public volatile long[] k = new long[2];
  long l = 0L;
  public long m = 0L;
  public int o = 2;
  private ExecutorService z = null;
  
  public n(MsfCore paramMsfCore, Handler paramHandler)
  {
    this.f = paramMsfCore;
    int i1 = 0;
    while (i1 < 2)
    {
      this.B[i1] = new m(paramMsfCore, i1);
      i1 += 1;
    }
    this.C = new AtomicInteger(0);
    this.g = new k(paramMsfCore);
    this.A = paramHandler;
  }
  
  private int a(CopyOnWriteArrayList paramCopyOnWriteArrayList, ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    int i3 = 0;
    try
    {
      while (i1 < paramCopyOnWriteArrayList.size())
      {
        Object localObject = (d)paramCopyOnWriteArrayList.get(i1);
        NetConnInfoCenter.checkConnInfo();
        if (j.a((d)localObject)) {
          break label334;
        }
        localObject = a(paramArrayList, (d)localObject, paramInt);
        if (((a)localObject).e == x.c)
        {
          if (!this.S.get()) {
            break label336;
          }
          this.S.set(false);
          break label336;
        }
        int i4;
        int i2;
        if (((a)localObject).e == x.m)
        {
          i1 -= 1;
          i3 += 1;
          if (i3 > 3)
          {
            this.S.set(false);
            return 2;
          }
          i4 = i1;
          i2 = i3;
          if (((a)localObject).h > 0)
          {
            Thread.sleep(((a)localObject).h);
            if ((!paramBoolean) || (k()))
            {
              i4 = i1;
              i2 = i3;
              if (!paramBoolean)
              {
                i4 = i1;
                i2 = i3;
                if (!k()) {}
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label334;
              }
              QLog.d("MSF.C.NetConnTag", 2, "NetChanged from wifi to mobile connect again");
              break label334;
            }
          }
        }
        else if (((a)localObject).e != x.t)
        {
          i4 = i1;
          i2 = i3;
          if (((a)localObject).e != x.q) {}
        }
        else
        {
          i4 = i1;
          i2 = i3;
          if (i1 == 0)
          {
            i4 = i1;
            i2 = i3;
            if (!this.S.get())
            {
              b(((a)localObject).b);
              i2 = i3;
              i4 = i1;
            }
          }
        }
        i1 = i4 + 1;
        i3 = i2;
      }
      return -1;
    }
    catch (Exception paramCopyOnWriteArrayList)
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("selectAndConnect error ");
        paramArrayList.append(paramCopyOnWriteArrayList);
        QLog.d("MSF.C.NetConnTag", 2, paramArrayList.toString(), paramCopyOnWriteArrayList);
      }
    }
    label334:
    return 0;
    label336:
    return 1;
  }
  
  private a a(ArrayList paramArrayList, d paramd, int paramInt)
  {
    a locala = new a();
    locala.i = System.currentTimeMillis();
    locala.b = paramd.a();
    locala.g = NetConnInfoCenter.getSystemNetworkType();
    locala.j = 0;
    locala.k = 0;
    locala.l = 0;
    locala.m = 0;
    a(paramd, locala, paramInt);
    paramArrayList.add(locala);
    return locala;
  }
  
  private void a(d paramd, a parama, int paramInt)
  {
    if (paramd.b().equalsIgnoreCase("http")) {
      this.B[paramInt].a(paramd, new c(this.f), parama);
    } else {
      this.B[paramInt].a(paramd, new w(this.f), parama);
    }
    p = parama.f;
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = new p(this, paramString, paramInt);
    paramString.setName("checkNetConnectBySocketThread");
    paramString.start();
  }
  
  private void a(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, ArrayList paramArrayList, int paramInt)
  {
    if (this.z == null) {
      this.z = Executors.newFixedThreadPool(2);
    }
    this.i.a(1, paramInt);
    this.z.submit(new o(this, paramInt, paramCopyOnWriteArrayList1, paramCopyOnWriteArrayList2, paramArrayList));
  }
  
  private void a(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.G;
    if ((l2 == 0L) || (l1 - l2 > Long.parseLong(com.tencent.mobileqq.msf.core.a.a.i())))
    {
      this.G = l1;
      StringBuffer localStringBuffer = new StringBuffer();
      d locald;
      StringBuilder localStringBuilder;
      if (NetConnInfoCenter.isWifiConn())
      {
        localIterator = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv4"), true).iterator();
        while (localIterator.hasNext())
        {
          locald = (d)localIterator.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(locald.b());
          localStringBuilder.append("//");
          localStringBuilder.append(locald.c());
          localStringBuilder.append(":");
          localStringBuilder.append(locald.f());
          localStringBuilder.append(",");
          localStringBuffer.append(localStringBuilder.toString());
        }
      }
      Iterator localIterator = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv4"), true).iterator();
      while (localIterator.hasNext())
      {
        locald = (d)localIterator.next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(locald.b());
        localStringBuilder.append("//");
        localStringBuilder.append(locald.c());
        localStringBuilder.append(":");
        localStringBuilder.append(locald.f());
        localStringBuilder.append(",");
        localStringBuffer.append(localStringBuilder.toString());
      }
      try
      {
        this.f.getSsoListManager().a(this.f.sender.m(), this.f.sender.l(), 60000L, NetConnInfoCenter.isWifiConn(), localStringBuffer.toString(), paramBoolean);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, localException.toString(), localException);
        }
      }
    }
  }
  
  /* Error */
  private static void b(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 19
    //   8: iconst_2
    //   9: ldc_w 475
    //   12: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: aload_0
    //   21: invokevirtual 481	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: ldc_w 483
    //   27: invokevirtual 489	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore_2
    //   31: new 265	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   38: astore 4
    //   40: aload 4
    //   42: aload_0
    //   43: invokevirtual 493	android/content/Context:getFilesDir	()Ljava/io/File;
    //   46: invokevirtual 498	java/io/File:getParent	()Ljava/lang/String;
    //   49: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 4
    //   55: ldc_w 500
    //   58: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: new 502	java/io/FileOutputStream
    //   65: dup
    //   66: aload 4
    //   68: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 504	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   74: astore_0
    //   75: sipush 1024
    //   78: newarray byte
    //   80: astore_3
    //   81: aload_2
    //   82: aload_3
    //   83: invokevirtual 510	java/io/InputStream:read	([B)I
    //   86: istore_1
    //   87: iload_1
    //   88: ifle +13 -> 101
    //   91: aload_0
    //   92: aload_3
    //   93: iconst_0
    //   94: iload_1
    //   95: invokevirtual 516	java/io/OutputStream:write	([BII)V
    //   98: goto -17 -> 81
    //   101: aload_0
    //   102: astore_3
    //   103: aload_2
    //   104: ifnull +111 -> 215
    //   107: aload_2
    //   108: invokevirtual 519	java/io/InputStream:close	()V
    //   111: aload_0
    //   112: astore_3
    //   113: goto +102 -> 215
    //   116: astore_3
    //   117: goto +104 -> 221
    //   120: astore_3
    //   121: goto +16 -> 137
    //   124: astore 4
    //   126: aload_3
    //   127: astore_0
    //   128: aload 4
    //   130: astore_3
    //   131: goto +90 -> 221
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_0
    //   137: goto +21 -> 158
    //   140: astore 4
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_3
    //   145: astore_0
    //   146: aload 4
    //   148: astore_3
    //   149: goto +72 -> 221
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 4
    //   157: astore_2
    //   158: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +40 -> 201
    //   164: new 265	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   171: astore 4
    //   173: aload 4
    //   175: ldc_w 521
    //   178: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: aload_3
    //   185: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 19
    //   191: iconst_2
    //   192: aload 4
    //   194: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload_3
    //   198: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 519	java/io/InputStream:close	()V
    //   209: aload_0
    //   210: ifnull +9 -> 219
    //   213: aload_0
    //   214: astore_3
    //   215: aload_3
    //   216: invokevirtual 522	java/io/OutputStream:close	()V
    //   219: return
    //   220: astore_3
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 519	java/io/InputStream:close	()V
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 522	java/io/OutputStream:close	()V
    //   237: goto +5 -> 242
    //   240: aload_3
    //   241: athrow
    //   242: goto -2 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	android.content.Context
    //   86	9	1	i1	int
    //   30	196	2	localObject1	Object
    //   16	97	3	localObject2	Object
    //   116	1	3	localObject3	Object
    //   120	7	3	localException1	Exception
    //   130	1	3	localObject4	Object
    //   134	11	3	localException2	Exception
    //   148	1	3	localObject5	Object
    //   152	46	3	localException3	Exception
    //   214	2	3	localContext	android.content.Context
    //   220	21	3	localObject6	Object
    //   18	49	4	localStringBuilder1	StringBuilder
    //   124	5	4	localObject7	Object
    //   140	16	4	localObject8	Object
    //   171	22	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   75	81	116	finally
    //   81	87	116	finally
    //   91	98	116	finally
    //   75	81	120	java/lang/Exception
    //   81	87	120	java/lang/Exception
    //   91	98	120	java/lang/Exception
    //   31	75	124	finally
    //   31	75	134	java/lang/Exception
    //   20	31	140	finally
    //   20	31	152	java/lang/Exception
    //   158	201	220	finally
  }
  
  private void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.O > 180000L)
    {
      this.O = l1;
      x();
      a("3gimg.qq.com", 80);
      a("120.33.50.146", 80);
      s();
      c(paramString.split(":")[0].trim());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (!this.E)
    {
      this.E = true;
      this.A.removeCallbacks(this.ab);
      if (paramBoolean)
      {
        this.f.getStatReporter().k();
        return;
      }
      this.A.postDelayed(this.ab, 120000L);
    }
  }
  
  private boolean b(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "NetChanged selectAndConnect...");
    }
    Object localObject1 = this.j;
    Object localObject2 = this.k;
    long l1 = SystemClock.elapsedRealtime();
    localObject2[paramInt] = l1;
    localObject1[paramInt] = l1;
    NetConnInfoCenter.checkConnInfo();
    int i1 = 1;
    boolean bool1 = false;
    for (;;)
    {
      int i3;
      int i2;
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "NetChanged start connect...");
        }
        try
        {
          if ((k()) && (paramCopyOnWriteArrayList1 != null) && (paramCopyOnWriteArrayList1.size() > 0))
          {
            l1 = SystemClock.elapsedRealtime();
            n = com.tencent.mobileqq.msf.core.d.j.a(false, K, l1);
            i3 = a(paramCopyOnWriteArrayList1, paramArrayList, paramInt, true);
            if (i3 != 0) {
              break label557;
            }
            i1 = 1;
            break label560;
          }
          if ((paramCopyOnWriteArrayList2 != null) && (paramCopyOnWriteArrayList2.size() > 0))
          {
            l1 = SystemClock.elapsedRealtime();
            n = com.tencent.mobileqq.msf.core.d.j.a(false, K, l1);
            if (r() != null)
            {
              localObject1 = new CopyOnWriteArrayList();
              localObject2 = paramCopyOnWriteArrayList2.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                d locald = (d)((Iterator)localObject2).next();
                if (locald.f == 1) {
                  ((CopyOnWriteArrayList)localObject1).add(locald);
                }
              }
              i3 = a((CopyOnWriteArrayList)localObject1, paramArrayList, paramInt, false);
              if (i3 == 0) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (i3 == 1) {
                bool2 = true;
              } else {
                bool2 = false;
              }
              i2 = i1;
              bool1 = bool2;
              if (i3 != -1) {
                break label440;
              }
              try
              {
                i3 = a(paramCopyOnWriteArrayList2, paramArrayList, paramInt, false);
                if (i3 == 0) {
                  i2 = 1;
                } else {
                  i2 = 0;
                }
                if (i3 == 1) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
              catch (Exception localException1)
              {
                break label379;
              }
            }
            else
            {
              i3 = a(paramCopyOnWriteArrayList2, paramArrayList, paramInt, false);
              if (i3 == 0) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              i2 = i1;
              if (i3 != 1) {
                break label576;
              }
              break label570;
            }
          }
          else
          {
            i1 = 0;
          }
        }
        catch (Exception localException2)
        {
          i1 = 0;
          boolean bool2 = bool1;
          label379:
          i2 = i1;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("selectAndConnect error ");
            ((StringBuilder)localObject2).append(localException2);
            QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString(), localException2);
            bool1 = bool2;
            i2 = i1;
          }
          label440:
          i1 = i2;
        }
      }
      else
      {
        if ((this.S.get()) && (this.U) && (!this.V) && (this.M.size() > 0))
        {
          this.S.set(false);
          this.U = false;
          this.V = false;
          l1 = System.currentTimeMillis();
          long l2 = this.W;
          if (this.f.getStatReporter() != null) {
            this.f.getStatReporter().a(b(), this.T, l1 - l2, this.M);
          }
          this.M.clear();
        }
        return bool1;
        label557:
        i1 = 0;
        label560:
        i2 = i1;
        if (i3 == 1)
        {
          label570:
          bool1 = true;
        }
        else
        {
          label576:
          bool1 = false;
          i1 = i2;
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    paramString = new u(this, paramString);
    paramString.setName("pingServerThread");
    paramString.start();
  }
  
  public static boolean k()
  {
    return (NetConnInfoCenter.isWifiConn()) || ((!NetConnInfoCenter.isWifiOrMobileConn()) && (NetConnInfoCenter.getCurrentAPN() == null));
  }
  
  private boolean q()
  {
    Object localObject2;
    if (this.F.length() > 0) {
      try
      {
        this.I = System.currentTimeMillis();
        this.l = this.I;
        a locala = new a();
        locala.b = this.F;
        locala.g = NetConnInfoCenter.getSystemNetworkType();
        locala.j = 0;
        locala.k = 0;
        locala.l = 0;
        locala.m = 0;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("conn assigned server ");
          ((StringBuilder)localObject2).append(this.F);
          QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
        }
        a(d.a(this.F), locala, 0);
        return true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("conn assigned server ");
          ((StringBuilder)localObject2).append(this.F);
          ((StringBuilder)localObject2).append(" error ");
          ((StringBuilder)localObject2).append(localException);
          QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString(), localException);
        }
        return false;
      }
    }
    this.E = false;
    long l2 = SystemClock.elapsedRealtime();
    boolean bool = this.D;
    ArrayList localArrayList = new ArrayList();
    this.I = System.currentTimeMillis();
    this.l = this.I;
    NetConnInfoCenter.checkConnInfo();
    int i4 = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mainSocketEngineOpenConn start...activeIpFamily=");
    ((StringBuilder)localObject1).append(i4);
    QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject1).toString());
    localObject1 = "Ipv6";
    CopyOnWriteArrayList localCopyOnWriteArrayList;
    Object localObject4;
    Object localObject3;
    int i2;
    Object localObject5;
    Object localObject6;
    int i3;
    if ((3 == i4) && (!bool))
    {
      localCopyOnWriteArrayList = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv4"), true);
      localObject4 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv4"), true);
      localObject1 = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv6"), false);
      localObject3 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv6"), false);
      if (((NetConnInfoCenter.isWifiConn()) && (localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0) && (localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0)) || ((!NetConnInfoCenter.isWifiConn()) && (localObject4 != null) && (((CopyOnWriteArrayList)localObject4).size() > 0) && (localObject3 != null) && (((CopyOnWriteArrayList)localObject3).size() > 0))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0)) || ((localObject4 != null) && (((CopyOnWriteArrayList)localObject4).size() > 0)) || ((localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0)) || ((localObject3 != null) && (((CopyOnWriteArrayList)localObject3).size() > 0))) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      if ((i1 == 0) && (i2 == 0))
      {
        if ((localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0)) {
          localObject5 = localObject1;
        } else {
          localObject5 = null;
        }
        localObject2 = localObject5;
        if (localCopyOnWriteArrayList != null)
        {
          localObject2 = localObject5;
          if (localCopyOnWriteArrayList.size() > 0) {
            localObject2 = localCopyOnWriteArrayList;
          }
        }
        if ((localObject3 != null) && (((CopyOnWriteArrayList)localObject3).size() > 0)) {
          localObject5 = localObject3;
        } else {
          localObject5 = null;
        }
        if ((localObject4 != null) && (((CopyOnWriteArrayList)localObject4).size() > 0))
        {
          localObject5 = localObject3;
          localObject6 = localObject1;
          localObject1 = localObject4;
          i3 = i1;
          localObject3 = localObject2;
          i1 = i2;
          localObject2 = localObject4;
          localObject4 = localObject6;
        }
        else
        {
          localObject6 = localObject3;
          Object localObject7 = localObject1;
          localObject1 = localObject5;
          i3 = i1;
          localObject3 = localObject2;
          i1 = i2;
          localObject2 = localObject4;
          localObject4 = localObject7;
          localObject5 = localObject6;
        }
      }
      else
      {
        localObject5 = localObject1;
        localObject6 = localObject3;
        localObject2 = localObject4;
        localObject1 = null;
        localObject3 = null;
        i3 = i1;
        i1 = i2;
        localObject4 = localObject5;
        localObject5 = localObject6;
      }
    }
    else
    {
      if (2 != i4) {
        localObject1 = "Ipv4";
      }
      localObject3 = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", (String)localObject1), true);
      localObject1 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", (String)localObject1), true);
      if (((localObject3 != null) && (((CopyOnWriteArrayList)localObject3).size() > 0)) || ((localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0))) {}
      for (i1 = 0;; i1 = 1)
      {
        i3 = 0;
        localCopyOnWriteArrayList = null;
        localObject2 = null;
        localObject4 = null;
        localObject5 = null;
        break;
      }
    }
    long l1;
    if (i1 != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sso list is empty for ip family=");
      ((StringBuilder)localObject1).append(i4);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject1).toString());
      l1 = 0L;
      bool = false;
      i2 = 0;
    }
    else
    {
      localObject6 = "null";
      if (i3 != 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mainSocketEngineOpenConn try dual conn wifiIpv4SsoList=");
        if (localCopyOnWriteArrayList == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(localCopyOnWriteArrayList.size());
        }
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(", mobileIpv4SsoList=");
        if (localObject2 == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(((CopyOnWriteArrayList)localObject2).size());
        }
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(", wifiIpv6SsoList=");
        if (localObject4 == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(((CopyOnWriteArrayList)localObject4).size());
        }
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(", mobileIpv6SsoList=");
        if (localObject5 != null) {
          localObject6 = Integer.valueOf(localObject5.size());
        }
        ((StringBuilder)localObject3).append(localObject6);
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject3).toString());
        bool = this.i.a(localCopyOnWriteArrayList, (CopyOnWriteArrayList)localObject2, (CopyOnWriteArrayList)localObject4, localObject5, localArrayList);
        l1 = SystemClock.elapsedRealtime();
        l1 -= l2;
      }
      else
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("mainSocketEngineOpenConn try single conn wifiSsoList=");
        if (localObject3 == null) {
          localObject2 = "null";
        } else {
          localObject2 = Integer.valueOf(((CopyOnWriteArrayList)localObject3).size());
        }
        ((StringBuilder)localObject4).append(localObject2);
        ((StringBuilder)localObject4).append(", mobileSsoList=");
        if (localObject1 != null) {
          localObject6 = Integer.valueOf(((CopyOnWriteArrayList)localObject1).size());
        }
        ((StringBuilder)localObject4).append(localObject6);
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject4).toString());
        a(0);
        bool = b((CopyOnWriteArrayList)localObject3, (CopyOnWriteArrayList)localObject1, localArrayList, 0);
        l1 = SystemClock.elapsedRealtime();
        b(false);
        l1 -= l2;
      }
      i2 = 1;
    }
    localObject1 = localArrayList.iterator();
    int i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      if ((((a)localObject2).e != x.m) && (((a)localObject2).e != x.s) && (((a)localObject2).e != x.i) && (((a)localObject2).e != x.o) && (((a)localObject2).e != x.p) && (((a)localObject2).e != x.q) && (((a)localObject2).e != x.y))
      {
        if (this.I == 0L)
        {
          this.I = ((a)localObject2).i;
          this.l = this.I;
        }
        if (i1 == 0) {
          this.m = (this.l - this.I);
        }
        if (this.h == null) {
          this.h = this.f.getMsfAlarmer().a(this, 300000L);
        }
        this.H.add(localObject2);
        i1 = 0;
      }
      else
      {
        this.m = (this.l - this.I);
        g();
        i1 = 1;
      }
    }
    if (!bool)
    {
      l1 = SystemClock.elapsedRealtime();
      if ((NetConnInfoCenter.isWifiOrMobileConn()) && (i2 != 0))
      {
        a(true);
        if (this.f.getStatReporter() != null) {
          this.f.getStatReporter().a(false, false, false, l1 - l2, localArrayList);
        }
      }
      NetConnInfoCenter.onOepnConnAllFailed();
      l1 = System.currentTimeMillis();
      if ((!NetConnInfoCenter.isWifiConn()) && ((NetConnInfoCenter.isWifiOrMobileConn()) || (NetConnInfoCenter.getCurrentAPN() != null)))
      {
        if (l1 - com.tencent.mobileqq.msf.core.a.c.m < 60000L)
        {
          localObject1 = new StringBuffer();
          localObject2 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv4"), true).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (d)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(((d)localObject3).toString());
              ((StringBuilder)localObject4).append(";");
              ((StringBuffer)localObject1).append(((StringBuilder)localObject4).toString());
            }
          }
          localObject1 = ((StringBuffer)localObject1).toString();
          if (this.f.getStatReporter() != null) {
            this.f.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.c.m, (String)localObject1);
          }
          com.tencent.mobileqq.msf.core.a.c.m = 0L;
          return bool;
        }
      }
      else if (l1 - com.tencent.mobileqq.msf.core.a.c.l < 60000L)
      {
        localObject1 = new StringBuffer();
        localObject2 = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv4"), true).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (d)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((d)localObject3).toString());
            ((StringBuilder)localObject4).append(";");
            ((StringBuffer)localObject1).append(((StringBuilder)localObject4).toString());
          }
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        if (this.f.getStatReporter() != null) {
          this.f.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.c.l, (String)localObject1);
        }
        com.tencent.mobileqq.msf.core.a.c.l = 0L;
      }
      return bool;
    }
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    if (!NetConnInfoCenter.isWifiOrMobileConn()) {
      NetConnInfoCenter.setLastConnSuccWithoutNet();
    }
    if ((NetConnInfoCenter.isWifiOrMobileConn()) && (this.f.getStatReporter() != null)) {
      this.f.getStatReporter().a(false, false, bool, l1, localArrayList);
    }
    return true;
  }
  
  private String r()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getDefaultHost();
  }
  
  private void s()
  {
    try
    {
      Object localObject1 = this.N;
      if (localObject1 != null) {
        return;
      }
      int i1 = com.tencent.mobileqq.msf.core.a.a.T();
      if (i1 == 0) {
        return;
      }
      localObject1 = com.tencent.mobileqq.msf.core.a.a.S();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "TcpdumpSSOVip is empty");
        }
        return;
      }
      this.L.clear();
      localObject1 = ((String)localObject1).split(";");
      int i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        Object localObject3 = localObject1[i1];
        n.a locala = new n.a(this);
        locala.a = localObject3;
        locala.b = 1;
        locala.c = "";
        this.L.add(locala);
        i1 += 1;
      }
      this.N = new q(this);
      this.N.setName("checkNetConnectByConnectSSOThread");
      this.N.start();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private static boolean t()
  {
    return u() != null;
  }
  
  private static String u()
  {
    for (;;)
    {
      int i2;
      int i1;
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
        localObject = localBufferedReader.readLine().split("\\s+");
        int i4 = localObject.length;
        i2 = 0;
        i1 = 0;
        int i3 = 1;
        if (i2 < i4)
        {
          if (!localObject[i2].equalsIgnoreCase("PID")) {
            break label266;
          }
          i3 = i1;
          break label266;
        }
        localObject = localBufferedReader.readLine();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(BaseApplication.getContext().getFilesDir().getParent());
          localStringBuilder.append("/txlib/tcpdump");
          if ((!((String)localObject).contains(localStringBuilder.toString())) || (((String)localObject).contains("sh -c"))) {
            continue;
          }
          localObject = ((String)localObject).split("\\s+");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("tcpdump uid:");
            localStringBuilder.append(localObject[i3]);
            QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
          }
          localBufferedReader.close();
          return localObject[i3];
        }
        localBufferedReader.close();
      }
      catch (IOException localIOException)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Error killing tcpdump, msg=");
          ((StringBuilder)localObject).append(localIOException.getMessage());
          QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject).toString());
        }
      }
      return null;
      label266:
      i1 += 1;
      i2 += 1;
    }
  }
  
  private static void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump begin");
    }
    try
    {
      Object localObject1 = u();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump pid not find");
        }
      }
      else
      {
        localObject2 = Runtime.getRuntime();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("kill ");
        localStringBuilder.append((String)localObject1);
        localObject1 = new BufferedReader(new InputStreamReader(((Runtime)localObject2).exec(new String[] { "su", "-c", localStringBuilder.toString() }).getErrorStream()));
        for (;;)
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 == null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("tcpdump kill error=");
            localStringBuilder.append((String)localObject2);
            QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
          }
        }
        ((BufferedReader)localObject1).close();
        return;
      }
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("tcpdump Error killing tcpdump, msg=");
        ((StringBuilder)localObject2).append(localIOException.getMessage());
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report begin");
    }
    if (this.Q != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump tcpDumpReportThread started return");
      }
      return;
    }
    this.Q = new r(this);
    this.Q.setName("tcpDumpReportThread");
    this.Q.start();
  }
  
  private void x()
  {
    v localv = new v(this);
    localv.setName("checkNetConnectByHttpThread");
    localv.start();
    this.S.set(true);
  }
  
  public int a()
  {
    return this.C.get();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 2)) {
      this.C.set(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < 2)) {
      this.B[paramInt].a(paramBoolean);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    b(true);
    if ((parama == com.tencent.qphone.base.a.B) && (l().j() == 2)) {
      this.D = true;
    }
    int i1 = 0;
    while (i1 < 2)
    {
      this.B[i1].b(parama);
      i1 += 1;
    }
    this.i.a(true);
  }
  
  public void a(com.tencent.qphone.base.a parama, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 2)) {
      this.B[paramInt].b(parama);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (this.I != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "firstResponseGetted getted Report now");
      }
      long l2 = -1L;
      long l1 = this.l;
      long l3 = this.I;
      if (l1 >= l3) {
        l2 = l1 - l3;
      }
      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "from msg TIMESTAMP_NET2MSF not find return");
        }
        g();
        this.m = 0L;
        return;
      }
      l3 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - this.l;
      if (paramToServiceMsg.getAttribute("__timestamp_msf2net") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "to msg TIMESTAMP_MSF2NET not find set nFirstPacketTimeElapse to 0");
        }
        l1 = 0L;
      }
      else
      {
        long l4 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        l1 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - l4;
        if ((l1 >= 0L) && (l4 != 0L)) {
          break label300;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("nFirstPacketTimeElapse:");
          localStringBuilder.append(l1);
          localStringBuilder.append(" reset 0 now TIMESTAMP_NET2MSF:");
          localStringBuilder.append(this.f.timeFormatter.format(paramFromServiceMsg.getAttribute("__timestamp_net2msf")));
          localStringBuilder.append(" TIMESTAMP_MSF2NET:");
          localStringBuilder.append(this.f.timeFormatter.format(paramToServiceMsg.getAttribute("__timestamp_msf2net")));
          QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
        }
        l1 = 0L;
      }
      label300:
      boolean bool = paramFromServiceMsg.getServiceCmd().equals("login.auth");
      if (this.H.size() > 0)
      {
        paramFromServiceMsg = this.H;
        paramFromServiceMsg = (a)paramFromServiceMsg.get(paramFromServiceMsg.size() - 1);
        paramFromServiceMsg.m = 1;
        paramFromServiceMsg.l = 1;
        if (this.f.getStatReporter() != null) {
          this.f.getStatReporter().a(true, l2, l3, l1, this.m, bool, this.H, this.o);
        }
      }
      g();
      this.m = 0L;
      NetConnInfoCenter.onRecvFirstResp();
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.F = paramString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = true;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, MsfCommand paramMsfCommand, String paramString3, int paramInt3, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    this.i.b();
    byte[] arrayOfByte;
    if (!this.B[this.C.get()].c())
    {
      K = SystemClock.elapsedRealtime();
      q();
      arrayOfByte = this.f.sender.e(paramToServiceMsg);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("p ok re1: ");
      paramArrayOfByte.append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("MSF.C.NetConnTag", 1, paramArrayOfByte.toString());
    }
    else
    {
      arrayOfByte = paramArrayOfByte;
    }
    paramArrayOfByte = null;
    if (paramToServiceMsg.getAttributes().containsKey("infoLoginMsg")) {}
    for (paramArrayOfByte = (ToServiceMsg)paramToServiceMsg.getAttributes().get("infoLoginMsg");; paramArrayOfByte = paramToServiceMsg) {
      do
      {
        break;
      } while ((!"RegPrxySvc.infoLogin".equals(paramToServiceMsg.getServiceCmd())) && (!"RegPrxySvc.getOffMsg".equals(paramToServiceMsg.getServiceCmd())) && (!"RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd())));
    }
    int i1 = this.B[this.C.get()].a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte);
    if (i1 == -100)
    {
      q();
      arrayOfByte = this.f.sender.e(paramToServiceMsg);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("p ok re2: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
      if (this.B[this.C.get()].a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte) == -100) {
        return false;
      }
      if ((this.J == 0L) && (this.I != 0L) && (this.l != 0L)) {
        this.J = System.currentTimeMillis();
      }
      return true;
    }
    if (i1 == -200) {
      return true;
    }
    if ((this.J == 0L) && (this.I != 0L) && (this.l != 0L)) {
      this.J = System.currentTimeMillis();
    }
    return true;
  }
  
  public long b(int paramInt)
  {
    return this.k[paramInt] - this.j[paramInt];
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (o())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDualConnConnected: connId: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", success: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("DualConnContext", 1, localStringBuilder.toString());
      if (paramBoolean)
      {
        this.i.a(2, paramInt, 10000L);
        return;
      }
      this.i.a(-1, paramInt);
    }
  }
  
  public boolean b()
  {
    return this.B[this.C.get()].c();
  }
  
  public boolean c()
  {
    return this.B[this.C.get()].d();
  }
  
  public boolean c(int paramInt)
  {
    return this.B[paramInt].c();
  }
  
  public m d(int paramInt)
  {
    if (paramInt >= 0)
    {
      m[] arrayOfm = this.B;
      if (paramInt < arrayOfm.length) {
        return arrayOfm[paramInt];
      }
    }
    return null;
  }
  
  public String d()
  {
    return this.F;
  }
  
  public int e()
  {
    return this.B[a()].n;
  }
  
  public void e(int paramInt)
  {
    int i2 = paramInt;
    a(i2, true);
    this.k[i2] = SystemClock.elapsedRealtime();
    if (this.i.a() != 1)
    {
      QLog.d("DualConnContext", 1, "onSingleConnPing");
      return;
    }
    int i1;
    if (i2 == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i3 = d(paramInt).j();
    if (i3 == 1)
    {
      paramInt = i1;
    }
    else
    {
      paramInt = i2;
      i2 = i1;
    }
    long l1 = b(i2);
    long l2 = b(paramInt);
    long l3 = this.f.delayIpRace.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkDualConnPing: delayIpRace: ");
    localStringBuilder.append(l3);
    localStringBuilder.append(", curIpFamily: ");
    localStringBuilder.append(i3);
    localStringBuilder.append(", v4ConnId = ");
    localStringBuilder.append(i2);
    localStringBuilder.append(", v6ConnId");
    localStringBuilder.append(paramInt);
    QLog.d("DualConnContext", 1, localStringBuilder.toString());
    if ((l1 > 0L) && (l2 > 0L))
    {
      QLog.d("DualConnContext", 1, "checkDualConnPing: all ok");
      if (l1 + l3 <= l2)
      {
        QLog.d("DualConnContext", 1, "checkDualConnPing: choose v4");
        this.i.a(-1, paramInt);
        this.i.a(3, i2);
        return;
      }
      QLog.d("DualConnContext", 1, "checkDualConnPing: choose v6");
      this.i.a(-1, i2);
      this.i.a(3, paramInt);
      return;
    }
    if (l3 > 0L)
    {
      if ((l1 > 0L) && (l2 <= 0L))
      {
        QLog.d("DualConnContext", 1, "checkDualConnPing: v4 ok, wait v6..");
        this.i.a(3, i2, l3);
        return;
      }
      if ((l2 > 0L) && (l1 <= 0L))
      {
        QLog.d("DualConnContext", 1, "checkDualConnPing: v6 ok, close v4");
        this.i.a(-1, i2);
        this.i.a(3, paramInt);
      }
    }
    else
    {
      if ((l1 > 0L) && (l2 <= 0L))
      {
        QLog.d("DualConnContext", 1, "checkDualConnPing: v4 ok, close v6");
        this.i.a(-1, paramInt);
        this.i.a(3, i2);
        return;
      }
      if ((l2 > 0L) && (l1 <= 0L))
      {
        QLog.d("DualConnContext", 1, "checkDualConnPing: v6 ok, wait v4..");
        this.i.a(3, paramInt, -l3);
      }
    }
  }
  
  public int f()
  {
    return this.B[a()].o;
  }
  
  public void g()
  {
    this.J = 0L;
    this.I = 0L;
    this.l = 0L;
    this.m = 0L;
    this.H.clear();
    this.o = 2;
    if (this.h != null)
    {
      this.f.getMsfAlarmer().a(this.h);
      this.h = null;
    }
  }
  
  public void h()
  {
    if (this.I != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut Report now");
      }
      long l1 = -1L;
      long l2 = this.l;
      long l3 = this.I;
      if (l2 >= l3)
      {
        if (this.J == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut. m_firstPacketSendTimeAfterConnect == 0");
          }
          g();
          this.m = 0L;
          return;
        }
        l1 = l2 - l3;
        this.f.sender.b.g.c();
      }
      if (this.f.getStatReporter() != null) {
        this.f.getStatReporter().a(false, l1, -1L, -1L, this.m, false, this.H, this.o);
      }
      g();
      this.m = 0L;
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loginConnectTimeOut m_startConnectTime : ");
      localStringBuilder.append(this.I);
      localStringBuilder.append("no need Report");
      QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
    }
    g();
    this.m = 0L;
  }
  
  public void i()
  {
    if (this.H.size() > 0)
    {
      Object localObject = this.H;
      localObject = (a)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (localObject != null)
      {
        ((a)localObject).e = x.y;
        ((a)localObject).d = false;
        ((a)localObject).l = 0;
        ((a)localObject).m = 1;
      }
    }
  }
  
  public void j()
  {
    if (t())
    {
      if (System.currentTimeMillis() - this.R > com.tencent.mobileqq.msf.core.a.a.aC()) {
        v();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump is running return");
      }
      return;
    }
    t localt = new t(this);
    localt.setName("tcpDumpThread");
    localt.start();
  }
  
  public m l()
  {
    return this.B[this.C.get()];
  }
  
  public InetSocketAddress m()
  {
    return this.B[this.C.get()].a();
  }
  
  public boolean n()
  {
    return (b()) && (this.I == 0L);
  }
  
  public boolean o()
  {
    return this.i.a() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n
 * JD-Core Version:    0.7.0.1
 */