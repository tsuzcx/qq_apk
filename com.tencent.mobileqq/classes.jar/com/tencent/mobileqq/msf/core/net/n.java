package com.tencent.mobileqq.msf.core.net;

import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.c.a;
import com.tencent.mobileqq.msf.core.ac;
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
    int i3 = -1;
    int i2 = 0;
    int i1 = 0;
    try
    {
      while (i2 < paramCopyOnWriteArrayList.size())
      {
        Object localObject = (d)paramCopyOnWriteArrayList.get(i2);
        NetConnInfoCenter.checkConnInfo();
        if (j.a((d)localObject))
        {
          paramInt = 0;
          break label306;
        }
        localObject = a(paramArrayList, (d)localObject, paramInt);
        if (((a)localObject).e == x.c)
        {
          if (!this.S.get()) {
            break label308;
          }
          this.S.set(false);
          break label308;
        }
        if (((a)localObject).e == x.m)
        {
          int i4 = i2 - 1;
          int i5 = i1 + 1;
          if (i5 > 3)
          {
            this.S.set(false);
            paramInt = 2;
            break label306;
          }
          i2 = i4;
          i1 = i5;
          if (((a)localObject).h > 0)
          {
            Thread.sleep(((a)localObject).h);
            if ((!paramBoolean) || (k()))
            {
              i2 = i4;
              i1 = i5;
              if (!paramBoolean)
              {
                i2 = i4;
                i1 = i5;
                if (!k()) {}
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label313;
              }
              QLog.d("MSF.C.NetConnTag", 2, "NetChanged from wifi to mobile connect again");
              break label313;
            }
          }
        }
        else if (((((a)localObject).e == x.t) || (((a)localObject).e == x.q)) && (i2 == 0) && (!this.S.get()))
        {
          b(((a)localObject).b);
        }
        i2 += 1;
      }
      return paramInt;
    }
    catch (Exception paramCopyOnWriteArrayList)
    {
      paramInt = i3;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, "selectAndConnect error " + paramCopyOnWriteArrayList, paramCopyOnWriteArrayList);
        return -1;
        paramInt = -1;
      }
    }
    for (;;)
    {
      label306:
      label308:
      paramInt = 1;
      continue;
      label313:
      paramInt = 0;
    }
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
    }
    for (;;)
    {
      p = parama.f;
      return;
      this.B[paramInt].a(paramd, new w(this.f), parama);
    }
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
    StringBuffer localStringBuffer;
    if ((this.G == 0L) || (l1 - this.G > Long.parseLong(com.tencent.mobileqq.msf.core.a.a.i())))
    {
      this.G = l1;
      localStringBuffer = new StringBuffer();
      d locald;
      if (NetConnInfoCenter.isWifiConn())
      {
        localIterator = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv4"), true).iterator();
        while (localIterator.hasNext())
        {
          locald = (d)localIterator.next();
          localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.f() + ",");
        }
      }
      Iterator localIterator = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv4"), true).iterator();
      while (localIterator.hasNext())
      {
        locald = (d)localIterator.next();
        localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.f() + ",");
      }
    }
    try
    {
      this.f.getSsoListManager().a(this.f.sender.m(), this.f.sender.l(), 60000L, NetConnInfoCenter.isWifiConn(), localStringBuffer.toString(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.NetConnTag", 2, localException.toString(), localException);
    }
  }
  
  /* Error */
  private static void b(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 19
    //   12: iconst_2
    //   13: ldc_w 481
    //   16: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 487	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 489
    //   26: invokevirtual 495	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_2
    //   34: new 497	java/io/FileOutputStream
    //   37: dup
    //   38: new 273	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 501	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: invokevirtual 506	java/io/File:getParent	()Ljava/lang/String;
    //   52: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 508
    //   58: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 510	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: astore_0
    //   68: sipush 1024
    //   71: newarray byte
    //   73: astore_3
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual 516	java/io/InputStream:read	([B)I
    //   79: istore_1
    //   80: iload_1
    //   81: ifle +64 -> 145
    //   84: aload_0
    //   85: aload_3
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 522	java/io/OutputStream:write	([BII)V
    //   91: goto -17 -> 74
    //   94: astore_3
    //   95: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +30 -> 128
    //   101: ldc 19
    //   103: iconst_2
    //   104: new 273	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 524
    //   114: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_3
    //   125: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 527	java/io/InputStream:close	()V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 528	java/io/OutputStream:close	()V
    //   144: return
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 527	java/io/InputStream:close	()V
    //   153: aload_0
    //   154: ifnull -10 -> 144
    //   157: aload_0
    //   158: invokevirtual 528	java/io/OutputStream:close	()V
    //   161: return
    //   162: astore_0
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 527	java/io/InputStream:close	()V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 528	java/io/OutputStream:close	()V
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: goto -19 -> 165
    //   187: astore 4
    //   189: aload_0
    //   190: astore_3
    //   191: aload 4
    //   193: astore_0
    //   194: goto -29 -> 165
    //   197: astore 4
    //   199: aload_0
    //   200: astore_3
    //   201: aload 4
    //   203: astore_0
    //   204: goto -39 -> 165
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_0
    //   210: goto -115 -> 95
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_0
    //   216: goto -121 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	android.content.Context
    //   79	9	1	i1	int
    //   3	167	2	localObject1	Object
    //   1	85	3	arrayOfByte	byte[]
    //   94	84	3	localException1	Exception
    //   190	11	3	localContext	android.content.Context
    //   207	1	3	localException2	Exception
    //   213	1	3	localException3	Exception
    //   29	3	4	localInputStream	java.io.InputStream
    //   187	5	4	localObject2	Object
    //   197	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   68	74	94	java/lang/Exception
    //   74	80	94	java/lang/Exception
    //   84	91	94	java/lang/Exception
    //   19	31	162	finally
    //   34	68	183	finally
    //   68	74	187	finally
    //   74	80	187	finally
    //   84	91	187	finally
    //   95	128	197	finally
    //   19	31	207	java/lang/Exception
    //   34	68	213	java/lang/Exception
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
      if (paramBoolean) {
        this.f.getStatReporter().k();
      }
    }
    else
    {
      return;
    }
    this.A.postDelayed(this.ab, 120000L);
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
    boolean bool1 = false;
    int i1 = 1;
    int i2;
    boolean bool2;
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
          n = com.tencent.mobileqq.msf.core.c.j.a(false, K, l1);
          i2 = a(paramCopyOnWriteArrayList1, paramArrayList, paramInt, true);
          if (i2 != 0) {
            break label560;
          }
          i1 = 1;
          break label548;
        }
        if ((paramCopyOnWriteArrayList2 == null) || (paramCopyOnWriteArrayList2.size() <= 0)) {
          break label542;
        }
        l1 = SystemClock.elapsedRealtime();
        n = com.tencent.mobileqq.msf.core.c.j.a(false, K, l1);
        if (r() != null)
        {
          localObject1 = new CopyOnWriteArrayList();
          localObject2 = paramCopyOnWriteArrayList2.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            d locald = (d)((Iterator)localObject2).next();
            if (locald.f == 1)
            {
              ((CopyOnWriteArrayList)localObject1).add(locald);
              continue;
              i1 = i2;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        i2 = 0;
        bool2 = bool1;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MSF.C.NetConnTag", 2, "selectAndConnect error " + localException1, localException1);
      i1 = i2;
      bool1 = bool2;
      break;
      int i3 = a(localException1, paramArrayList, paramInt, false);
      if (i3 == 0) {
        i2 = 1;
      }
      for (;;)
      {
        if (i3 == 1)
        {
          bool2 = true;
          label315:
          bool1 = bool2;
          i1 = i2;
          if (i3 != -1) {
            break label557;
          }
        }
        label378:
        long l2;
        try
        {
          i3 = a(paramCopyOnWriteArrayList2, paramArrayList, paramInt, false);
          if (i3 == 0) {}
          for (i1 = 1;; i1 = 0)
          {
            if (i3 != 1) {
              break label378;
            }
            bool1 = true;
            break label557;
            i2 = 0;
            break;
            bool2 = false;
            break label315;
          }
          bool1 = false;
        }
        catch (Exception localException2) {}
      }
      i2 = a(paramCopyOnWriteArrayList2, paramArrayList, paramInt, false);
      if (i2 == 0) {}
      for (i1 = 1; i2 == 1; i1 = 0)
      {
        bool1 = true;
        break label557;
      }
      bool1 = false;
      break label557;
      if ((this.S.get()) && (this.U) && (!this.V) && (this.M.size() > 0))
      {
        this.S.set(false);
        this.U = false;
        this.V = false;
        l1 = System.currentTimeMillis();
        l2 = this.W;
        if (this.f.getStatReporter() != null) {
          this.f.getStatReporter().a(b(), this.T, l1 - l2, this.M);
        }
        this.M.clear();
      }
      return bool1;
    }
    label542:
    i1 = 0;
    break label557;
    label548:
    if (i2 == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      label557:
      break;
      label560:
      i1 = 0;
      break label548;
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
    boolean bool2;
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
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + this.F);
        }
        a(d.a(this.F), locala, 0);
        bool2 = true;
        return bool2;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + this.F + " error " + localException, localException);
        }
        return false;
      }
    }
    this.E = false;
    long l2 = SystemClock.elapsedRealtime();
    long l1 = 0L;
    boolean bool1 = this.D;
    ArrayList localArrayList = new ArrayList();
    this.I = System.currentTimeMillis();
    this.l = this.I;
    NetConnInfoCenter.checkConnInfo();
    int i3 = NetConnInfoCenter.getActiveNetIpFamily(true);
    QLog.d("MSF.C.NetConnTag", 1, "mainSocketEngineOpenConn start...activeIpFamily=" + i3);
    CopyOnWriteArrayList localCopyOnWriteArrayList1 = null;
    CopyOnWriteArrayList localCopyOnWriteArrayList2 = null;
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject3;
    Object localObject1;
    int i2;
    int i1;
    label501:
    Object localObject4;
    if ((3 == i3) && (!bool1))
    {
      localObject3 = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv4"), true);
      localObject1 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv4"), true);
      localCopyOnWriteArrayList1 = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv6"), false);
      localCopyOnWriteArrayList2 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv6"), false);
      if (((NetConnInfoCenter.isWifiConn()) && (localObject3 != null) && (((CopyOnWriteArrayList)localObject3).size() > 0) && (localCopyOnWriteArrayList1 != null) && (localCopyOnWriteArrayList1.size() > 0)) || ((!NetConnInfoCenter.isWifiConn()) && (localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0) && (localCopyOnWriteArrayList2 != null) && (localCopyOnWriteArrayList2.size() > 0)))
      {
        i2 = 1;
        if (((localObject3 != null) && (((CopyOnWriteArrayList)localObject3).size() > 0)) || ((localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0)) || ((localCopyOnWriteArrayList1 != null) && (localCopyOnWriteArrayList1.size() > 0)) || ((localCopyOnWriteArrayList2 != null) && (localCopyOnWriteArrayList2.size() > 0))) {
          break label787;
        }
        i1 = 1;
        if ((i2 != 0) || (i1 != 0)) {
          break label1795;
        }
        localObject4 = localObject2;
        if (localCopyOnWriteArrayList1 != null)
        {
          localObject4 = localObject2;
          if (localCopyOnWriteArrayList1.size() > 0) {
            localObject4 = localCopyOnWriteArrayList1;
          }
        }
        localObject2 = localObject4;
        if (localObject3 != null)
        {
          localObject2 = localObject4;
          if (((CopyOnWriteArrayList)localObject3).size() > 0) {
            localObject2 = localObject3;
          }
        }
        localObject4 = localObject5;
        if (localCopyOnWriteArrayList2 != null)
        {
          localObject4 = localObject5;
          if (localCopyOnWriteArrayList2.size() > 0) {
            localObject4 = localCopyOnWriteArrayList2;
          }
        }
        if ((localObject1 == null) || (((CopyOnWriteArrayList)localObject1).size() <= 0)) {
          break label1772;
        }
        localObject5 = localObject3;
        localObject3 = localObject1;
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject5;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        QLog.d("MSF.C.NetConnTag", 1, "sso list is empty for ip family=" + i3);
        i1 = 0;
        bool1 = false;
        localObject1 = localArrayList.iterator();
        i2 = 0;
        label661:
        if (!((Iterator)localObject1).hasNext()) {
          break label1312;
        }
        localObject2 = (a)((Iterator)localObject1).next();
        if ((((a)localObject2).e != x.m) && (((a)localObject2).e != x.s) && (((a)localObject2).e != x.i) && (((a)localObject2).e != x.o) && (((a)localObject2).e != x.p) && (((a)localObject2).e != x.q) && (((a)localObject2).e != x.y)) {
          break label1229;
        }
        this.m = (this.l - this.I);
        i2 = 1;
        g();
      }
      for (;;)
      {
        break label661;
        i2 = 0;
        break;
        label787:
        i1 = 0;
        break label501;
        if (2 == i3) {}
        for (localObject1 = "Ipv6";; localObject1 = "Ipv4")
        {
          localObject4 = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", (String)localObject1), true);
          localObject3 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", (String)localObject1), true);
          if (((localObject4 != null) && (((CopyOnWriteArrayList)localObject4).size() > 0)) || ((localObject3 != null) && (((CopyOnWriteArrayList)localObject3).size() > 0))) {
            break label1759;
          }
          i2 = 0;
          localObject1 = null;
          i1 = 1;
          localObject2 = null;
          break;
        }
        if (i2 != 0)
        {
          localObject4 = new StringBuilder().append("mainSocketEngineOpenConn try dual conn wifiIpv4SsoList=");
          if (localObject1 == null)
          {
            localObject3 = "null";
            label926:
            localObject4 = ((StringBuilder)localObject4).append(localObject3).append(", mobileIpv4SsoList=");
            if (localObject2 != null) {
              break label1062;
            }
            localObject3 = "null";
            label951:
            localObject4 = ((StringBuilder)localObject4).append(localObject3).append(", wifiIpv6SsoList=");
            if (localCopyOnWriteArrayList1 != null) {
              break label1075;
            }
            localObject3 = "null";
            label976:
            localObject4 = ((StringBuilder)localObject4).append(localObject3).append(", mobileIpv6SsoList=");
            if (localCopyOnWriteArrayList2 != null) {
              break label1088;
            }
          }
          label1062:
          label1075:
          label1088:
          for (localObject3 = "null";; localObject3 = Integer.valueOf(localCopyOnWriteArrayList2.size()))
          {
            QLog.d("MSF.C.NetConnTag", 1, localObject3);
            bool1 = this.i.a((CopyOnWriteArrayList)localObject1, (CopyOnWriteArrayList)localObject2, localCopyOnWriteArrayList1, localCopyOnWriteArrayList2, localArrayList);
            l1 = SystemClock.elapsedRealtime() - l2;
            i1 = 1;
            break;
            localObject3 = Integer.valueOf(((CopyOnWriteArrayList)localObject1).size());
            break label926;
            localObject3 = Integer.valueOf(((CopyOnWriteArrayList)localObject2).size());
            break label951;
            localObject3 = Integer.valueOf(localCopyOnWriteArrayList1.size());
            break label976;
          }
        }
        localObject2 = new StringBuilder().append("mainSocketEngineOpenConn try single conn wifiSsoList=");
        if (localObject4 == null)
        {
          localObject1 = "null";
          label1126:
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", mobileSsoList=");
          if (localObject3 != null) {
            break label1216;
          }
        }
        label1216:
        for (localObject1 = "null";; localObject1 = Integer.valueOf(((CopyOnWriteArrayList)localObject3).size()))
        {
          QLog.d("MSF.C.NetConnTag", 1, localObject1);
          a(0);
          bool1 = b((CopyOnWriteArrayList)localObject4, (CopyOnWriteArrayList)localObject3, localArrayList, 0);
          l1 = SystemClock.elapsedRealtime() - l2;
          b(false);
          i1 = 1;
          break;
          localObject1 = Integer.valueOf(((CopyOnWriteArrayList)localObject4).size());
          break label1126;
        }
        label1229:
        if (this.I == 0L)
        {
          this.I = ((a)localObject2).i;
          this.l = this.I;
        }
        if (i2 == 0) {
          this.m = (this.l - this.I);
        }
        if (this.h == null) {
          this.h = this.f.getMsfAlarmer().a(this, 300000L);
        }
        this.H.add(localObject2);
        i2 = 0;
      }
      label1312:
      if (!bool1)
      {
        l1 = SystemClock.elapsedRealtime();
        if ((NetConnInfoCenter.isWifiOrMobileConn()) && (i1 != 0))
        {
          a(true);
          if (this.f.getStatReporter() != null) {
            this.f.getStatReporter().a(false, false, false, l1 - l2, localArrayList);
          }
        }
        NetConnInfoCenter.onOepnConnAllFailed();
        l1 = System.currentTimeMillis();
        if ((NetConnInfoCenter.isWifiConn()) || ((!NetConnInfoCenter.isWifiOrMobileConn()) && (NetConnInfoCenter.getCurrentAPN() == null)))
        {
          bool2 = bool1;
          if (l1 - com.tencent.mobileqq.msf.core.a.c.l >= 60000L) {
            break;
          }
          localObject1 = new StringBuffer();
          localObject2 = this.f.getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv4"), true).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (d)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((StringBuffer)localObject1).append(((d)localObject3).toString() + ";");
            }
          }
          localObject1 = ((StringBuffer)localObject1).toString();
          if (this.f.getStatReporter() != null) {
            this.f.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.c.l, (String)localObject1);
          }
          com.tencent.mobileqq.msf.core.a.c.l = 0L;
          return bool1;
        }
        bool2 = bool1;
        if (l1 - com.tencent.mobileqq.msf.core.a.c.m >= 60000L) {
          break;
        }
        localObject1 = new StringBuffer();
        localObject2 = this.f.getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv4"), true).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (d)((Iterator)localObject2).next();
          if (localObject3 != null) {
            ((StringBuffer)localObject1).append(((d)localObject3).toString() + ";");
          }
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        if (this.f.getStatReporter() != null) {
          this.f.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.c.m, (String)localObject1);
        }
        com.tencent.mobileqq.msf.core.a.c.m = 0L;
        return bool1;
      }
      NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
      if (!NetConnInfoCenter.isWifiOrMobileConn()) {
        NetConnInfoCenter.setLastConnSuccWithoutNet();
      }
      if ((NetConnInfoCenter.isWifiOrMobileConn()) && (this.f.getStatReporter() != null)) {
        this.f.getStatReporter().a(false, false, bool1, l1, localArrayList);
      }
      return true;
      label1759:
      localObject2 = null;
      i1 = 0;
      i2 = 0;
      localObject1 = null;
      continue;
      label1772:
      localObject5 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
      continue;
      label1795:
      localObject5 = null;
      localObject4 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject5;
    }
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
    for (;;)
    {
      try
      {
        Object localObject1 = this.N;
        if (localObject1 != null) {
          return;
        }
        if (com.tencent.mobileqq.msf.core.a.a.T() == 0) {
          continue;
        }
        localObject1 = com.tencent.mobileqq.msf.core.a.a.S();
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.C.NetConnTag", 2, "TcpdumpSSOVip is empty");
          continue;
        }
        this.L.clear();
      }
      finally {}
      String[] arrayOfString = localObject2.split(";");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        n.a locala = new n.a(this);
        locala.a = str;
        locala.b = 1;
        locala.c = "";
        this.L.add(locala);
        i1 += 1;
      }
      this.N = new q(this);
      this.N.setName("checkNetConnectByConnectSSOThread");
      this.N.start();
    }
  }
  
  private static boolean t()
  {
    return u() != null;
  }
  
  private static String u()
  {
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
      localObject = localBufferedReader.readLine().split("\\s+");
      i4 = localObject.length;
      i2 = 0;
      i3 = 1;
      i1 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        BufferedReader localBufferedReader;
        Object localObject;
        int i4;
        int i2;
        int i3;
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, "Error killing tcpdump, msg=" + localIOException.getMessage());
          continue;
          i2 += 1;
          i1 += 1;
        }
      }
    }
    if (i2 < i4)
    {
      if (localObject[i2].equalsIgnoreCase("PID")) {
        i3 = i1;
      }
    }
    else
    {
      do
      {
        localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
      } while ((!((String)localObject).contains(BaseApplication.getContext().getFilesDir().getParent() + "/txlib/tcpdump")) || (((String)localObject).contains("sh -c")));
      localObject = ((String)localObject).split("\\s+");
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump uid:" + localObject[i3]);
      }
      localBufferedReader.close();
      return localObject[i3];
      localBufferedReader.close();
      return null;
    }
  }
  
  private static void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump begin");
    }
    try
    {
      Object localObject = u();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump pid not find");
        }
      }
      else
      {
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "su", "-c", "kill " + (String)localObject }).getErrorStream()));
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "tcpdump kill error=" + str);
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Error killing tcpdump, msg=" + localIOException.getMessage());
        return;
        localIOException.close();
      }
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
    long l2;
    if (this.I != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "firstResponseGetted getted Report now");
      }
      l2 = -1L;
      if (this.l >= this.I) {
        l2 = this.l - this.I;
      }
      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "from msg TIMESTAMP_NET2MSF not find return");
        }
        g();
        this.m = 0L;
      }
    }
    else
    {
      return;
    }
    long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue();
    long l5 = this.l;
    long l1;
    if (paramToServiceMsg.getAttribute("__timestamp_msf2net") == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "to msg TIMESTAMP_MSF2NET not find set nFirstPacketTimeElapse to 0");
      }
      l1 = 0L;
    }
    for (;;)
    {
      boolean bool = false;
      if (paramFromServiceMsg.getServiceCmd().equals("login.auth")) {
        bool = true;
      }
      if (this.H.size() > 0)
      {
        paramFromServiceMsg = (a)this.H.get(this.H.size() - 1);
        paramFromServiceMsg.m = 1;
        paramFromServiceMsg.l = 1;
        if (this.f.getStatReporter() != null) {
          this.f.getStatReporter().a(true, l2, l4 - l5, l1, this.m, bool, this.H, this.o);
        }
      }
      g();
      this.m = 0L;
      NetConnInfoCenter.onRecvFirstResp();
      return;
      long l6 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
      long l3 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - l6;
      if (l3 >= 0L)
      {
        l1 = l3;
        if (l6 != 0L) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "nFirstPacketTimeElapse:" + l3 + " reset 0 now TIMESTAMP_NET2MSF:" + this.f.timeFormatter.format(paramFromServiceMsg.getAttribute("__timestamp_net2msf")) + " TIMESTAMP_MSF2NET:" + this.f.timeFormatter.format(paramToServiceMsg.getAttribute("__timestamp_msf2net")));
        }
        l1 = 0L;
      }
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
      QLog.d("MSF.C.NetConnTag", 1, "p ok re1: " + paramToServiceMsg.getRequestSsoSeq());
    }
    for (;;)
    {
      paramArrayOfByte = null;
      if (paramToServiceMsg.getAttributes().containsKey("infoLoginMsg")) {
        paramArrayOfByte = (ToServiceMsg)paramToServiceMsg.getAttributes().get("infoLoginMsg");
      }
      int i1;
      for (;;)
      {
        i1 = this.B[this.C.get()].a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte);
        if (i1 != -100) {
          break label337;
        }
        q();
        arrayOfByte = this.f.sender.e(paramToServiceMsg);
        QLog.d("MSF.C.NetConnTag", 1, "p ok re2: " + paramToServiceMsg.getRequestSsoSeq());
        if (this.B[this.C.get()].a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte) != -100) {
          break;
        }
        return false;
        if ("RegPrxySvc.infoLogin".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        } else if ("RegPrxySvc.getOffMsg".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        } else if ("RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        }
      }
      if ((this.J == 0L) && (this.I != 0L) && (this.l != 0L)) {
        this.J = System.currentTimeMillis();
      }
      return true;
      label337:
      if (i1 == -200) {
        return true;
      }
      if ((this.J == 0L) && (this.I != 0L) && (this.l != 0L)) {
        this.J = System.currentTimeMillis();
      }
      return true;
      arrayOfByte = paramArrayOfByte;
    }
  }
  
  public long b(int paramInt)
  {
    return this.k[paramInt] - this.j[paramInt];
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (o())
    {
      QLog.d("DualConnContext", 1, "onDualConnConnected: connId: " + paramInt + ", success: " + paramBoolean);
      if (paramBoolean) {
        this.i.a(2, paramInt, 10000L);
      }
    }
    else
    {
      return;
    }
    this.i.a(-1, paramInt);
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
    if ((paramInt >= 0) && (paramInt < this.B.length)) {
      return this.B[paramInt];
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
    a(paramInt, true);
    this.k[paramInt] = SystemClock.elapsedRealtime();
    if (this.i.a() != 1) {
      QLog.d("DualConnContext", 1, "onSingleConnPing");
    }
    long l1;
    long l2;
    long l3;
    label219:
    label224:
    label255:
    do
    {
      int i2;
      do
      {
        return;
        int i1;
        int i3;
        if (paramInt == 0)
        {
          i1 = 1;
          i3 = d(paramInt).j();
          if (i3 != 1) {
            break label219;
          }
          i2 = paramInt;
          paramInt = i1;
        }
        for (;;)
        {
          l1 = b(i2);
          l2 = b(paramInt);
          l3 = this.f.delayIpRace.get();
          QLog.d("DualConnContext", 1, "checkDualConnPing: delayIpRace: " + l3 + ", curIpFamily: " + i3 + ", v4ConnId = " + i2 + ", v6ConnId" + paramInt);
          if ((l1 <= 0L) || (l2 <= 0L)) {
            break label255;
          }
          QLog.d("DualConnContext", 1, "checkDualConnPing: all ok");
          if (l1 + l3 > l2) {
            break label224;
          }
          QLog.d("DualConnContext", 1, "checkDualConnPing: choose v4");
          this.i.a(-1, paramInt);
          this.i.a(3, i2);
          return;
          i1 = 0;
          break;
          i2 = i1;
        }
        QLog.d("DualConnContext", 1, "checkDualConnPing: choose v6");
        this.i.a(-1, i2);
        this.i.a(3, paramInt);
        return;
        if (l3 <= 0L) {
          break;
        }
        if ((l1 > 0L) && (l2 <= 0L))
        {
          QLog.d("DualConnContext", 1, "checkDualConnPing: v4 ok, wait v6..");
          this.i.a(3, i2, l3);
          return;
        }
      } while ((l2 <= 0L) || (l1 > 0L));
      QLog.d("DualConnContext", 1, "checkDualConnPing: v6 ok, close v4");
      this.i.a(-1, i2);
      this.i.a(3, paramInt);
      return;
      if ((l1 > 0L) && (l2 <= 0L))
      {
        QLog.d("DualConnContext", 1, "checkDualConnPing: v4 ok, close v6");
        this.i.a(-1, paramInt);
        this.i.a(3, i2);
        return;
      }
    } while ((l2 <= 0L) || (l1 > 0L));
    QLog.d("DualConnContext", 1, "checkDualConnPing: v6 ok, wait v4..");
    this.i.a(3, paramInt, -l3);
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
      if (this.l >= this.I)
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
        l1 = this.l - this.I;
        this.f.sender.b.g.c();
      }
      if (this.f.getStatReporter() != null) {
        this.f.getStatReporter().a(false, l1, -1L, -1L, this.m, false, this.H, this.o);
      }
      g();
      this.m = 0L;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut m_startConnectTime : " + this.I + "no need Report");
    }
    g();
    this.m = 0L;
  }
  
  public void i()
  {
    if (this.H.size() > 0)
    {
      a locala = (a)this.H.get(this.H.size() - 1);
      if (locala != null)
      {
        locala.e = x.y;
        locala.d = false;
        locala.l = 0;
        locala.m = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n
 * JD-Core Version:    0.7.0.1
 */