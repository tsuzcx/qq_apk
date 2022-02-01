package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.b.d;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class h
{
  private String A;
  private int B;
  private int C = -1;
  private int D;
  private boolean E;
  private String F;
  private int G;
  private String H;
  private int I;
  private long J;
  private String K;
  public volatile boolean a = false;
  public ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  public HashMap<String, Object> c = new HashMap();
  private String d;
  private String e;
  private int f;
  private int g;
  private long h;
  private long i;
  private long j;
  private long k;
  private String l;
  private String m;
  private h.a n;
  private String o;
  private com.tencent.qapmsdk.impl.a.a.a p;
  private String q = null;
  private String r = null;
  private String s = null;
  private com.tencent.qapmsdk.impl.f.b t = new com.tencent.qapmsdk.impl.f.b();
  private String u = "";
  private boolean v = false;
  private d w;
  private com.tencent.qapmsdk.impl.b.b x;
  private int y;
  private String z;
  
  public h()
  {
    try
    {
      this.j = System.currentTimeMillis();
      this.B = -1;
      this.D = -1;
      this.m = "Other";
      this.n = h.a.a;
      this.g = com.tencent.qapmsdk.impl.f.a.a.a();
      this.w = d.a;
      this.x = com.tencent.qapmsdk.impl.b.b.a;
      this.y = 0;
      this.z = "";
      this.A = "";
      this.E = false;
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "QAPMTransactionState,", " ID:", String.valueOf(Thread.currentThread().getId()), " name : ", Thread.currentThread().getName() });
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "error init QAPMTransactionState e:", localException.getMessage() });
    }
  }
  
  public h(boolean paramBoolean)
  {
    try
    {
      this.j = System.currentTimeMillis();
      this.B = -1;
      this.D = -1;
      this.m = "Other";
      this.n = h.a.a;
      this.g = com.tencent.qapmsdk.impl.f.a.a.a();
      this.w = d.a;
      this.x = com.tencent.qapmsdk.impl.b.b.a;
      this.y = 0;
      this.z = "";
      this.A = "";
      this.E = false;
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "error init QAPMTransactionState e:", localException.getMessage() });
    }
  }
  
  private void a(com.tencent.qapmsdk.impl.a.a.a parama)
  {
    if (parama != null)
    {
      String str = this.d;
      if (str != null) {
        a(com.tencent.qapmsdk.impl.g.a.c(str), parama);
      }
    }
  }
  
  private void a(String paramString, com.tencent.qapmsdk.impl.a.a.a parama)
  {
    if (parama.e() > parama.j()) {
      parama.b(-1);
    }
    if (parama.d() > parama.j()) {
      parama.c(-1);
    }
    if (b(parama))
    {
      parama.b(-1);
      parama.c(-1);
      parama.a(-1);
      if (parama.j() < parama.f()) {
        parama.d(parama.j());
      }
    }
  }
  
  private boolean b(com.tencent.qapmsdk.impl.a.a.a parama)
  {
    boolean bool = false;
    if (parama == null) {
      return false;
    }
    if (parama.e() + parama.d() + parama.f() + parama.c() >= parama.j()) {
      bool = true;
    }
    return bool;
  }
  
  private com.tencent.qapmsdk.impl.a.a.a l()
  {
    if (!f()) {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "toTransactionData() called on incomplete TransactionState" });
    }
    String str1 = this.d;
    if (str1 == null)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "Attempted to convert a TransactionState instance with no URL into a TransactionData" });
      return null;
    }
    if (this.p == null)
    {
      String str2 = this.m;
      long l1 = this.j;
      this.p = new com.tencent.qapmsdk.impl.a.a.a(str1, str2, l1, (int)(this.k - l1), this.f, this.g, this.h, this.i, this.l, this.r, this.s, this.w, this.x, this.y, this.A, this.B, this.D, this.C, this.F, this.o, this.G, this.H, this.K, this.I);
    }
    a(this.p);
    return this.p;
  }
  
  public long a()
  {
    return this.J;
  }
  
  public void a(int paramInt)
  {
    this.I = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!f())
    {
      this.g = paramInt;
      this.q = paramString;
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "errorCode:", String.valueOf(this.g), ", errorInfo:", this.q });
      return;
    }
    paramString = this.p;
    if (paramString != null) {
      paramString.e(paramInt);
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setErrorCode(...) called on TransactionState in ", this.n.toString(), " state" });
  }
  
  public void a(long paramLong)
  {
    this.J = paramLong;
  }
  
  public void a(com.tencent.qapmsdk.impl.b.b paramb)
  {
    this.x = paramb;
  }
  
  public void a(d paramd)
  {
    this.w = paramd;
  }
  
  public void a(String paramString)
  {
    this.K = paramString;
  }
  
  public String b()
  {
    return this.s;
  }
  
  public void b(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void b(long paramLong)
  {
    if (!f())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", String.valueOf(paramLong), " bytes sent" });
      this.h = paramLong;
      this.n = h.a.b;
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setBytesSent(...) called on TransactionState in ", this.n.toString(), " state" });
  }
  
  public void b(String paramString)
  {
    this.s = paramString;
  }
  
  public long c()
  {
    return this.j;
  }
  
  public void c(int paramInt)
  {
    if (!f())
    {
      this.f = paramInt;
      if (paramInt == 200) {
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "set status code:", String.valueOf(paramInt) });
      }
    }
    else
    {
      this.f = paramInt;
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setStatusCode(...) called on TransactionState in ", this.n.toString(), " state" });
    }
  }
  
  public void c(long paramLong)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "After Complete ", String.valueOf(paramLong), " bytes sent." });
    this.h = paramLong;
    this.n = h.a.b;
  }
  
  public void c(String paramString)
  {
    if (!e())
    {
      this.m = paramString;
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setCarrier(...) called on TransactionState in ", this.n.toString(), " state" });
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(long paramLong)
  {
    if (!f())
    {
      this.i = paramLong;
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", String.valueOf(paramLong), "bytes received" });
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setBytesReceived(...) called on TransactionState in ", this.n.toString(), " state" });
  }
  
  public void d(String paramString)
  {
    if (!f())
    {
      this.l = paramString;
      if (!"".equals(paramString)) {}
    }
    else
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setAppData(...) called on TransactionState in ", this.n.toString(), " state" });
    }
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean e()
  {
    return this.n.ordinal() >= h.a.b.ordinal();
  }
  
  public void f(String paramString)
  {
    String str = com.tencent.qapmsdk.impl.g.a.b(paramString);
    if (str != null)
    {
      paramString = str;
      if (str != null)
      {
        paramString = str;
        if (str.length() > 1024) {
          paramString = str.substring(0, 1024);
        }
      }
      if (!e())
      {
        this.d = paramString;
        return;
      }
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setUrl(...) called on TransactionState in ", this.n.toString(), " state" });
    }
  }
  
  public boolean f()
  {
    return this.n.ordinal() >= h.a.c.ordinal();
  }
  
  public int g()
  {
    return this.f;
  }
  
  public void g(String paramString)
  {
    this.o = paramString;
  }
  
  public boolean h()
  {
    int i1 = this.f;
    return (i1 >= 400) || (i1 == -1);
  }
  
  public long i()
  {
    return this.i;
  }
  
  public com.tencent.qapmsdk.impl.a.a.a j()
  {
    if (!f())
    {
      this.n = h.a.c;
      this.k = System.currentTimeMillis();
    }
    return l();
  }
  
  public String k()
  {
    return this.q;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("url:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("statusCode:");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("errorCode:");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("bytesSent:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("bytesReceived:");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("startTime:");
    localStringBuilder2.append(this.j);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("endTime:");
    localStringBuilder2.append(this.k);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("appData:");
    localStringBuilder2.append(this.l);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("carrier:");
    localStringBuilder2.append(this.m);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("state:");
    localStringBuilder2.append(this.n.ordinal());
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("contentType:");
    localStringBuilder2.append(this.o);
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.p != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("trancastionData:");
      localStringBuilder2.append(this.p.toString());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.r != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("formattedUrlParams:");
      localStringBuilder2.append(this.r);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("Requestmethodtype:");
    localStringBuilder2.append(this.w);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("httplibType:");
    localStringBuilder2.append(this.x);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("urlBuilder:");
    localStringBuilder2.append(this.t);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.h
 * JD-Core Version:    0.7.0.1
 */