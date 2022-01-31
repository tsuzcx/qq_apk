package com.tencent.mobileqq.msf.core.net;

import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.b.k;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class m
{
  public static String H = "";
  private static String I;
  public static final String a = "MSF.C.NetConnTag";
  public static final int b = -10008;
  public static final int c = 300000;
  public static final int e = 302;
  static CopyOnWriteArraySet f = new CopyOnWriteArraySet();
  public static byte s = -1;
  public static long t = -1L;
  Thread A = null;
  long B = 0L;
  AtomicBoolean C = new AtomicBoolean(false);
  int D = 0;
  boolean E = false;
  boolean F = false;
  long G = 0L;
  Runnable d = null;
  MsfCore g;
  public com.tencent.mobileqq.msf.core.net.b.o h;
  protected l i;
  String j = "";
  String[] k = null;
  String[] l = null;
  long m = 0L;
  ArrayList n = new ArrayList();
  long o = 0L;
  long p = 0L;
  public long q;
  long r = 0L;
  public int u = 2;
  ArrayList v = new ArrayList();
  ArrayList w = new ArrayList();
  Thread x = null;
  long y = 0L;
  boolean z = false;
  
  static
  {
    I = "UTF-8";
  }
  
  public m(MsfCore paramMsfCore)
  {
    this.g = paramMsfCore;
    this.i = new l(paramMsfCore, true);
    this.h = new k(paramMsfCore);
  }
  
  private a a(ArrayList paramArrayList, boolean paramBoolean, com.tencent.mobileqq.msf.core.d paramd)
  {
    a locala = new a();
    locala.i = System.currentTimeMillis();
    locala.b = paramd.a();
    locala.g = NetConnInfoCenter.getSystemNetworkType();
    locala.j = 0;
    locala.k = 0;
    locala.l = 0;
    locala.m = 0;
    a(paramd, paramBoolean, locala);
    paramArrayList.add(locala);
    return locala;
  }
  
  static void a()
  {
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.nativeSetUseSimpleHead((String)localIterator.next(), false);
    }
    f.clear();
  }
  
  private void a(com.tencent.mobileqq.msf.core.d paramd, boolean paramBoolean, a parama)
  {
    if (paramd.b().equalsIgnoreCase("http")) {
      this.i.a(paramd, 2048, 10000, new c(this.g), paramBoolean, parama);
    }
    for (;;)
    {
      H = parama.f;
      return;
      this.i.a(paramd, 2048, 10000, new u(this.g), paramBoolean, parama);
    }
  }
  
  static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      f.add(paramString);
    }
    for (;;)
    {
      CodecWarpper.nativeSetUseSimpleHead(paramString, paramBoolean);
      return;
      f.remove(paramString);
    }
  }
  
  private boolean a(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "NetChanged selectAndConnect...");
    }
    NetConnInfoCenter.checkConnInfo();
    int i1 = 1;
    int i6;
    int i5;
    int i3;
    int i2;
    label67:
    long l1;
    label325:
    int i4;
    label504:
    label892:
    Object localObject2;
    for (;;)
    {
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "NetChanged start connect...");
        }
        i6 = 0;
        int i7 = 0;
        i5 = 0;
        i3 = i6;
        for (;;)
        {
          try
          {
            if (x())
            {
              i1 = 0;
              i2 = 0;
              i3 = i6;
              if (i2 >= paramCopyOnWriteArrayList1.size()) {
                break label1601;
              }
              i3 = i6;
              localObject1 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList1.get(i2);
              if (i2 == 0)
              {
                i3 = i6;
                l1 = SystemClock.elapsedRealtime();
                i3 = i6;
                s = j.a(false, t, l1);
              }
              i3 = i6;
              NetConnInfoCenter.checkConnInfo();
              i3 = i6;
              if (i.a((com.tencent.mobileqq.msf.core.d)localObject1))
              {
                i1 = 1;
                break label1604;
              }
              i3 = i6;
              localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject1);
              i3 = i6;
              if (((a)localObject1).e == v.c)
              {
                i3 = i6;
                if (!this.C.get()) {
                  break label1607;
                }
                i3 = i6;
                this.C.set(false);
                break label1607;
              }
              i3 = i6;
              if (((a)localObject1).e == v.m)
              {
                i2 -= 1;
                i3 = i1 + 1;
                i1 = i3;
                if (i3 > 3)
                {
                  i3 = i6;
                  this.C.set(false);
                  return false;
                }
              }
              else
              {
                i3 = i6;
                if (((a)localObject1).e != v.t)
                {
                  i3 = i6;
                  if (((a)localObject1).e != v.q) {
                    break label1609;
                  }
                }
                if (i2 != 0) {
                  break label1609;
                }
                i3 = i6;
                if (this.C.get()) {
                  break label1609;
                }
                i3 = i6;
                b(((a)localObject1).b);
                break label1609;
              }
              i3 = i6;
              if (((a)localObject1).h <= 0) {
                break label1618;
              }
              i3 = i6;
              Thread.sleep(((a)localObject1).h);
              i3 = i6;
              if (x()) {
                break label1618;
              }
              i3 = i6;
              if (!QLog.isColorLevel()) {
                break label1612;
              }
              i3 = i6;
              QLog.d("MSF.C.NetConnTag", 2, "NetChanged from wifi to mobile connect again");
              break label1612;
            }
            i3 = i6;
            if (w() == null) {
              break label1666;
            }
            i1 = 0;
            i4 = 0;
            i3 = i6;
            i2 = i7;
            if (i4 >= paramCopyOnWriteArrayList2.size()) {
              break label1627;
            }
            i3 = i6;
            Object localObject1 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4);
            if (i4 == 0)
            {
              i3 = i6;
              l1 = SystemClock.elapsedRealtime();
              i3 = i6;
              s = j.a(false, t, l1);
            }
            i3 = i6;
            if (((com.tencent.mobileqq.msf.core.d)localObject1).h != 1) {
              break label888;
            }
            i3 = i6;
            NetConnInfoCenter.checkConnInfo();
            i3 = i6;
            if (i.a((com.tencent.mobileqq.msf.core.d)localObject1))
            {
              i2 = 1;
              break label1627;
              i1 = i2;
              i3 = i2;
              if (i4 >= paramCopyOnWriteArrayList2.size()) {
                break;
              }
              i3 = i2;
              localObject1 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4);
              i3 = i2;
              NetConnInfoCenter.checkConnInfo();
              i3 = i2;
              if (!i.a((com.tencent.mobileqq.msf.core.d)localObject1)) {
                break label901;
              }
              i1 = 1;
              break;
            }
            i3 = i6;
            localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject1);
            i3 = i6;
            if (((a)localObject1).e == v.c)
            {
              i3 = i6;
              if (!this.C.get()) {
                break label1636;
              }
              i3 = i6;
              this.C.set(false);
              break label1636;
            }
            i3 = i6;
            if (((a)localObject1).e == v.m)
            {
              i5 = i4 - 1;
              i1 += 1;
              i2 = i7;
              if (i1 > 3) {
                break label1627;
              }
              i2 = i1;
              i4 = i2;
              i3 = i6;
              i2 = i5;
              i1 = i4;
              if (((a)localObject1).h <= 0) {
                break label892;
              }
              i3 = i6;
              Thread.sleep(((a)localObject1).h);
              i3 = i6;
              i2 = i5;
              i1 = i4;
              if (!x()) {
                break label892;
              }
              i3 = i6;
              if (!QLog.isColorLevel()) {
                break label1638;
              }
              i3 = i6;
              QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
              break label1638;
            }
            i3 = i6;
            if (((a)localObject1).e != v.t)
            {
              i5 = i4;
              i2 = i1;
              i3 = i6;
              if (((a)localObject1).e != v.q) {
                continue;
              }
            }
            i5 = i4;
            i2 = i1;
            if (i4 != 0) {
              continue;
            }
            i5 = i4;
            i2 = i1;
            i3 = i6;
            if (this.C.get()) {
              continue;
            }
            i3 = i6;
            b(((a)localObject1).b);
            i5 = i4;
            i2 = i1;
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException)
          {
            i1 = i3;
          }
          QLog.d("MSF.C.NetConnTag", 2, "selectAndConnect error " + localException, localException);
          i1 = i3;
          break;
          label888:
          i2 = i4;
          i4 = i2 + 1;
        }
        label901:
        i3 = i2;
        localObject2 = a(paramArrayList, paramBoolean, localException);
        i3 = i2;
        if (((a)localObject2).e == v.c)
        {
          i3 = i2;
          if (!this.C.get()) {
            break label1644;
          }
          i3 = i2;
          this.C.set(false);
          break label1644;
        }
        i3 = i2;
        if (((a)localObject2).e == v.m)
        {
          i4 -= 1;
          i3 = i5 + 1;
          i1 = i3;
          if (i3 > 3)
          {
            i3 = i2;
            this.C.set(false);
            return false;
          }
        }
        else
        {
          i3 = i2;
          if (((a)localObject2).e != v.t)
          {
            i3 = i2;
            if (((a)localObject2).e != v.q) {
              break label1646;
            }
          }
          if (i4 != 0) {
            break label1646;
          }
          i3 = i2;
          if (this.C.get()) {
            break label1646;
          }
          i3 = i2;
          b(((a)localObject2).b);
          break label1646;
        }
        label1076:
        i3 = i2;
        if (((a)localObject2).h <= 0) {
          break label1653;
        }
        i3 = i2;
        Thread.sleep(((a)localObject2).h);
        i3 = i2;
        if (!x()) {
          break label1653;
        }
        i4 = 1;
        i2 = 1;
        i1 = i2;
        i3 = i4;
        if (QLog.isColorLevel())
        {
          i3 = i4;
          QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
          i1 = i2;
          continue;
          label1152:
          i1 = i5;
          i3 = i6;
          if (i2 < paramCopyOnWriteArrayList2.size())
          {
            i3 = i6;
            localObject2 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i2);
            if (i2 == 0)
            {
              i3 = i6;
              l1 = SystemClock.elapsedRealtime();
              i3 = i6;
              s = j.a(false, t, l1);
            }
            i3 = i6;
            NetConnInfoCenter.checkConnInfo();
            i3 = i6;
            if (i.a((com.tencent.mobileqq.msf.core.d)localObject2))
            {
              i1 = 1;
            }
            else
            {
              i3 = i6;
              localObject2 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject2);
              i3 = i6;
              if (((a)localObject2).e == v.c)
              {
                i3 = i6;
                if (!this.C.get()) {
                  break label1675;
                }
                i3 = i6;
                this.C.set(false);
                break label1675;
              }
              i3 = i6;
              if (((a)localObject2).e == v.m)
              {
                i2 -= 1;
                i3 = i4 + 1;
                i1 = i3;
                if (i3 > 3)
                {
                  i3 = i6;
                  this.C.set(false);
                  return false;
                }
              }
              else
              {
                i3 = i6;
                if (((a)localObject2).e != v.t)
                {
                  i3 = i6;
                  if (((a)localObject2).e != v.q) {
                    break label1677;
                  }
                }
                if (i2 != 0) {
                  break label1677;
                }
                i3 = i6;
                if (this.C.get()) {
                  break label1677;
                }
                i3 = i6;
                b(((a)localObject2).b);
                break label1677;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i3 = i6;
      if (((a)localObject2).h > 0)
      {
        i3 = i6;
        Thread.sleep(((a)localObject2).h);
        i3 = i6;
        if (x())
        {
          i3 = i6;
          if (QLog.isColorLevel())
          {
            i3 = i6;
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
          }
          i1 = 1;
          break;
        }
      }
      i2 += 1;
      i4 = i1;
      break label1152;
      if ((this.C.get()) && (this.E) && (!this.F) && (this.w.size() > 0))
      {
        this.C.set(false);
        this.E = false;
        this.F = false;
        l1 = System.currentTimeMillis();
        long l2 = this.G;
        if (this.g.getStatReporter() != null) {
          this.g.getStatReporter().a(b(), this.D, l1 - l2, this.w);
        }
        this.w.clear();
      }
      return false;
      label1601:
      label1604:
      label1607:
      label1609:
      label1612:
      for (i1 = 0;; i1 = 1)
      {
        break;
        return true;
        break label325;
      }
      label1618:
      i2 += 1;
      break label67;
      for (;;)
      {
        label1627:
        i5 = 0;
        i4 = 0;
        break;
        label1636:
        return true;
        label1638:
        i2 = 1;
      }
      label1644:
      return true;
      label1646:
      i1 = i5;
      break label1076;
      label1653:
      i4 += 1;
      i5 = i1;
      break label504;
      label1666:
      i4 = 0;
      i2 = 0;
      break label1152;
      label1675:
      return true;
      label1677:
      i1 = i4;
    }
  }
  
  /* Error */
  private static void b(android.content.Context paramContext)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 12
    //   12: iconst_2
    //   13: ldc_w 363
    //   16: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 369	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 371
    //   26: invokevirtual 377	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_2
    //   34: new 379	java/io/FileOutputStream
    //   37: dup
    //   38: new 332	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 383	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: invokevirtual 388	java/io/File:getParent	()Ljava/lang/String;
    //   52: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 390
    //   58: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 392	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: astore_0
    //   68: sipush 1024
    //   71: newarray byte
    //   73: astore_3
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual 398	java/io/InputStream:read	([B)I
    //   79: istore_1
    //   80: iload_1
    //   81: ifle +64 -> 145
    //   84: aload_0
    //   85: aload_3
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 404	java/io/OutputStream:write	([BII)V
    //   91: goto -17 -> 74
    //   94: astore_3
    //   95: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +30 -> 128
    //   101: ldc 12
    //   103: iconst_2
    //   104: new 332	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 406
    //   114: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_3
    //   125: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 409	java/io/InputStream:close	()V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 410	java/io/OutputStream:close	()V
    //   144: return
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 409	java/io/InputStream:close	()V
    //   153: aload_0
    //   154: ifnull -10 -> 144
    //   157: aload_0
    //   158: invokevirtual 410	java/io/OutputStream:close	()V
    //   161: return
    //   162: astore_0
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 409	java/io/InputStream:close	()V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 410	java/io/OutputStream:close	()V
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
  
  private void b(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    StringBuffer localStringBuffer;
    if ((this.m == 0L) || (l1 - this.m > Long.parseLong(com.tencent.mobileqq.msf.core.a.a.i())))
    {
      this.m = l1;
      localStringBuffer = new StringBuffer();
      com.tencent.mobileqq.msf.core.d locald;
      if (NetConnInfoCenter.isWifiConn())
      {
        localIterator = this.g.getSsoListManager().h().iterator();
        while (localIterator.hasNext())
        {
          locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
          localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
        }
      }
      Iterator localIterator = this.g.getSsoListManager().i().iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
        localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
      }
    }
    try
    {
      this.g.configManager.a(this.g.sender.j(), this.g.sender.i(), 60000L, NetConnInfoCenter.isWifiConn(), localStringBuffer.toString(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.NetConnTag", 2, localException.toString(), localException);
    }
  }
  
  public static boolean i()
  {
    return j() != null;
  }
  
  public static String j()
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
  
  public static void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump begin");
    }
    try
    {
      Object localObject = j();
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
  
  private String w()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getDefaultHost();
  }
  
  private boolean x()
  {
    return (NetConnInfoCenter.isWifiConn()) || ((!NetConnInfoCenter.isWifiOrMobileConn()) && (NetConnInfoCenter.getCurrentAPN() == null));
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.i.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    long l2;
    if (this.o != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "firstResponseGetted getted Report now");
      }
      l2 = -1L;
      if (this.p >= this.o) {
        l2 = this.p - this.o;
      }
      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "from msg TIMESTAMP_NET2MSF not find return");
        }
        d();
        this.q = 0L;
      }
    }
    else
    {
      return;
    }
    long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue();
    long l5 = this.p;
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
      if (this.n.size() > 0)
      {
        paramFromServiceMsg = (a)this.n.get(this.n.size() - 1);
        paramFromServiceMsg.m = 1;
        paramFromServiceMsg.l = 1;
        if (this.g.getStatReporter() != null) {
          this.g.getStatReporter().a(true, l2, l4 - l5, l1, this.q, bool, this.n, this.u);
        }
      }
      d();
      this.q = 0L;
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
          QLog.d("MSF.C.NetConnTag", 2, "nFirstPacketTimeElapse:" + l3 + " reset 0 now TIMESTAMP_NET2MSF:" + this.g.timeFormatter.format(paramFromServiceMsg.getAttribute("__timestamp_net2msf")) + " TIMESTAMP_MSF2NET:" + this.g.timeFormatter.format(paramToServiceMsg.getAttribute("__timestamp_msf2net")));
        }
        l1 = 0L;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.j = paramString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = true;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new n(this, paramString, paramInt);
    paramString.setName("checkNetConnectBySocketThread");
    paramString.start();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.t.set(paramBoolean);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.k = paramArrayOfString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = false;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, MsfCommand paramMsfCommand, String paramString3, int paramInt3, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
    throws Exception
  {
    byte[] arrayOfByte;
    if (!this.i.s.get())
    {
      t = SystemClock.elapsedRealtime();
      g();
      arrayOfByte = this.g.sender.e(paramToServiceMsg);
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
        i1 = this.i.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte);
        if (i1 != -100) {
          break label309;
        }
        g();
        arrayOfByte = this.g.sender.e(paramToServiceMsg);
        QLog.d("MSF.C.NetConnTag", 1, "p ok re2: " + paramToServiceMsg.getRequestSsoSeq());
        if (this.i.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte) != -100) {
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
      if ((this.r == 0L) && (this.o != 0L) && (this.p != 0L)) {
        this.r = System.currentTimeMillis();
      }
      return true;
      label309:
      if (i1 == -200) {
        return true;
      }
      if ((this.r == 0L) && (this.o != 0L) && (this.p != 0L)) {
        this.r = System.currentTimeMillis();
      }
      return true;
      arrayOfByte = paramArrayOfByte;
    }
  }
  
  public void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.y > 180000L)
    {
      this.y = l1;
      n();
      a("3gimg.qq.com", 80);
      a("120.33.50.146", 80);
      h();
      c(paramString.split(":")[0].trim());
    }
  }
  
  public void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.l = paramArrayOfString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = false;
    }
  }
  
  public boolean b()
  {
    return this.i.s.get();
  }
  
  public void c(String paramString)
  {
    paramString = new s(this, paramString);
    paramString.setName("pingServerThread");
    paramString.start();
  }
  
  public boolean c()
  {
    return this.i.t.get();
  }
  
  public void d()
  {
    this.r = 0L;
    this.o = 0L;
    this.p = 0L;
    this.n.clear();
    this.u = 2;
    if (this.d != null)
    {
      this.g.getMsfAlarmer().a(this.d);
      this.d = null;
    }
  }
  
  public void e()
  {
    if (this.o != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut Report now");
      }
      long l1 = -1L;
      if (this.p >= this.o)
      {
        if (this.r == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut. m_firstPacketSendTimeAfterConnect == 0");
          }
          d();
          this.q = 0L;
          return;
        }
        l1 = this.p - this.o;
        this.g.sender.a.h.c();
      }
      if (this.g.getStatReporter() != null) {
        this.g.getStatReporter().a(false, l1, -1L, -1L, this.q, false, this.n, this.u);
      }
      d();
      this.q = 0L;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut m_startConnectTime : " + this.o + "no need Report");
    }
    d();
    this.q = 0L;
  }
  
  public void f()
  {
    if (this.n.size() > 0)
    {
      a locala = (a)this.n.get(this.n.size() - 1);
      if (locala != null)
      {
        locala.e = v.y;
        locala.d = false;
        locala.l = 0;
        locala.m = 1;
      }
    }
  }
  
  public boolean g()
    throws Exception
  {
    if (((this.k != null) && (this.k.length > 0)) || ((this.l != null) && (this.l.length > 0))) {}
    Object localObject3;
    long l1;
    boolean bool1;
    label554:
    label697:
    do
    {
      do
      {
        int i2;
        int i1;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "start to connect lmassigned server " + Arrays.toString(this.k) + " " + Arrays.toString(this.l));
          }
          this.o = System.currentTimeMillis();
          this.p = this.o;
          CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
          localObject2 = new CopyOnWriteArrayList();
          if (this.k != null)
          {
            localObject3 = this.k;
            i2 = localObject3.length;
            i1 = 0;
            while (i1 < i2)
            {
              ((CopyOnWriteArrayList)localObject2).add(com.tencent.mobileqq.msf.core.d.a(localObject3[i1]));
              i1 += 1;
            }
          }
          if (this.l != null)
          {
            localObject3 = this.l;
            i2 = localObject3.length;
            i1 = 0;
            while (i1 < i2)
            {
              localCopyOnWriteArrayList.add(com.tencent.mobileqq.msf.core.d.a(localObject3[i1]));
              i1 += 1;
            }
          }
          bool2 = a(localCopyOnWriteArrayList, (CopyOnWriteArrayList)localObject2, new ArrayList(), false);
          if (bool2) {
            return bool2;
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + Arrays.toString(this.k) + " " + Arrays.toString(this.l) + " error " + localException1, localException1);
          }
        }
        if (this.j.length() > 0) {
          try
          {
            this.o = System.currentTimeMillis();
            this.p = this.o;
            a locala = new a();
            locala.b = this.j;
            locala.g = NetConnInfoCenter.getSystemNetworkType();
            locala.j = 0;
            locala.k = 0;
            locala.l = 0;
            locala.m = 0;
            a(com.tencent.mobileqq.msf.core.d.a(this.j), true, locala);
            return true;
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + this.j + " error " + localException2, localException2);
            }
            return false;
          }
        }
        long l2 = SystemClock.elapsedRealtime();
        l1 = 0L;
        localObject1 = new ArrayList();
        this.o = System.currentTimeMillis();
        this.p = this.o;
        if ((this.g.getSsoListManager().h().size() > 0) || (this.g.getSsoListManager().i().size() > 0))
        {
          bool1 = a(this.g.getSsoListManager().h(), this.g.getSsoListManager().i(), (ArrayList)localObject1, false);
          l1 = SystemClock.elapsedRealtime() - l2;
          i2 = 1;
          localObject2 = ((ArrayList)localObject1).iterator();
          i1 = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label780;
          }
          localObject3 = (a)((Iterator)localObject2).next();
          if ((((a)localObject3).e != v.m) && (((a)localObject3).e != v.s) && (((a)localObject3).e != v.i) && (((a)localObject3).e != v.o) && (((a)localObject3).e != v.p) && (((a)localObject3).e != v.q) && (((a)localObject3).e != v.y)) {
            break label697;
          }
          this.q = (this.p - this.o);
          i1 = 1;
          d();
        }
        for (;;)
        {
          break label554;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "sso list is null.");
          }
          bool1 = false;
          i2 = 0;
          break;
          if (this.o == 0L)
          {
            this.o = ((a)localObject3).i;
            this.p = this.o;
          }
          if (i1 == 0) {
            this.q = (this.p - this.o);
          }
          if (this.d == null) {
            this.d = this.g.getMsfAlarmer().a(this, 300000L);
          }
          this.n.add(localObject3);
          i1 = 0;
        }
        if (bool1) {
          break label1144;
        }
        l1 = SystemClock.elapsedRealtime();
        if ((NetConnInfoCenter.isWifiOrMobileConn()) && (i2 != 0))
        {
          b(true);
          if (this.g.getStatReporter() != null) {
            this.g.getStatReporter().a(false, false, false, l1 - l2, (ArrayList)localObject1);
          }
        }
        NetConnInfoCenter.onOepnConnAllFailed();
        l1 = System.currentTimeMillis();
        if ((!NetConnInfoCenter.isWifiConn()) && ((NetConnInfoCenter.isWifiOrMobileConn()) || (NetConnInfoCenter.getCurrentAPN() != null))) {
          break;
        }
        bool2 = bool1;
      } while (l1 - com.tencent.mobileqq.msf.core.a.a.H >= 60000L);
      localObject1 = new StringBuffer();
      localObject2 = this.g.getSsoListManager().h().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
        }
      }
      localObject1 = ((StringBuffer)localObject1).toString();
      if (this.g.getStatReporter() != null) {
        this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.H, (String)localObject1);
      }
      com.tencent.mobileqq.msf.core.a.a.H = 0L;
      return bool1;
      boolean bool2 = bool1;
    } while (l1 - com.tencent.mobileqq.msf.core.a.a.I >= 60000L);
    label780:
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.g.getSsoListManager().i().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
      if (localObject3 != null) {
        ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
      }
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    if (this.g.getStatReporter() != null) {
      this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.I, (String)localObject1);
    }
    com.tencent.mobileqq.msf.core.a.a.I = 0L;
    return bool1;
    label1144:
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    if (!NetConnInfoCenter.isWifiOrMobileConn()) {
      NetConnInfoCenter.setLastConnSuccWithoutNet();
    }
    if ((NetConnInfoCenter.isWifiOrMobileConn()) && (this.g.getStatReporter() != null)) {
      this.g.getStatReporter().a(false, false, bool1, l1, (ArrayList)localObject1);
    }
    return true;
  }
  
  public void h()
  {
    if (this.x != null) {}
    do
    {
      do
      {
        return;
      } while (com.tencent.mobileqq.msf.core.a.a.S() == 0);
      localObject1 = com.tencent.mobileqq.msf.core.a.a.R();
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.NetConnTag", 2, "TcpdumpSSOVip is empty");
    return;
    this.v.clear();
    Object localObject1 = ((String)localObject1).split(";");
    int i2 = localObject1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = localObject1[i1];
      a locala = new a();
      locala.a = localObject2;
      locala.b = 1;
      locala.c = "";
      this.v.add(locala);
      i1 += 1;
    }
    this.x = new o(this);
    this.x.setName("checkNetConnectByConnectSSOThread");
    this.x.start();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report begin");
    }
    if (this.A != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump tcpDumpReportThread started return");
      }
      return;
    }
    this.A = new p(this);
    this.A.setName("tcpDumpReportThread");
    this.A.start();
  }
  
  public void m()
  {
    if (i())
    {
      if (System.currentTimeMillis() - this.B > com.tencent.mobileqq.msf.core.a.a.aB()) {
        k();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump is running return");
      }
      return;
    }
    r localr = new r(this);
    localr.setName("tcpDumpThread");
    localr.start();
  }
  
  public void n()
  {
    t localt = new t(this);
    localt.setName("checkNetConnectByHttpThread");
    localt.start();
    this.C.set(true);
  }
  
  public l o()
  {
    return this.i;
  }
  
  public String p()
  {
    return this.j;
  }
  
  public String[] q()
  {
    return this.k;
  }
  
  public String[] r()
  {
    return this.l;
  }
  
  public InetSocketAddress s()
  {
    return this.i.c;
  }
  
  public boolean t()
  {
    return (b()) && (this.o == 0L);
  }
  
  public OutputStream u()
  {
    return this.i.h;
  }
  
  public class a
  {
    public String a = "";
    public byte b = 1;
    public String c = "";
    
    public a() {}
    
    public void a()
    {
      this.b = 1;
      this.c = "";
      Object localObject = this.a;
      if (localObject == null) {}
      for (;;)
      {
        return;
        String str = localObject.split(":")[0].trim();
        int i = Integer.parseInt(localObject.split(":")[1].trim());
        this.b = 2;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "start send checkNetConnectByConnectSSO server:" + str + " port:" + i);
          }
          localObject = new Socket();
          InetSocketAddress localInetSocketAddress = new InetSocketAddress(str, i);
          ((Socket)localObject).setSoTimeout(10000);
          ((Socket)localObject).setTcpNoDelay(true);
          ((Socket)localObject).setKeepAlive(true);
          ((Socket)localObject).connect(localInetSocketAddress, 10000);
          this.b = 3;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO connect server:" + str + " port:" + i + " success");
          }
          ((Socket)localObject).close();
          return;
        }
        catch (Throwable localThrowable)
        {
          if (localThrowable != null) {
            this.c = localThrowable.toString().toLowerCase();
          }
          if (this.c.indexOf("timeoutexception") > -1) {
            break label235;
          }
        }
        if (this.c.indexOf(") after") > -1) {}
        label235:
        for (this.b = 5; QLog.isColorLevel(); this.b = 4)
        {
          QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO Throwable connect server:" + str + " port:" + i + " failed" + localThrowable, localThrowable);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m
 * JD-Core Version:    0.7.0.1
 */