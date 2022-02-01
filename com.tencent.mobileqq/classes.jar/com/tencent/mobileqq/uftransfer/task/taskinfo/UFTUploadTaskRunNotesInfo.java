package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility.UrlHostInfo;

public class UFTUploadTaskRunNotesInfo
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private boolean i;
  private long j;
  private long k;
  private int l;
  private String m;
  private int n;
  private String o;
  private int p = 0;
  private int q = 0;
  private String r;
  private Object s;
  private long t;
  private long u;
  
  public UFTUploadTaskRunNotesInfo()
  {
    v();
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(Object paramObject)
  {
    this.s = paramObject;
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
    paramString = UFTTransferUtility.f(paramString);
    this.o = paramString.a;
    this.p = paramString.b;
    this.q = paramString.c;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void b(String paramString)
  {
    this.r = paramString;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public void c(long paramLong)
  {
    this.c = paramLong;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public void d(long paramLong)
  {
    this.d = paramLong;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public void e(long paramLong)
  {
    this.e = paramLong;
  }
  
  public long f()
  {
    return this.f;
  }
  
  public void f(long paramLong)
  {
    this.f = paramLong;
  }
  
  public long g()
  {
    return this.g;
  }
  
  public void g(long paramLong)
  {
    this.g = paramLong;
  }
  
  public long h()
  {
    return this.h;
  }
  
  public void h(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void i(long paramLong)
  {
    this.k = paramLong;
  }
  
  public boolean i()
  {
    return this.i;
  }
  
  public long j()
  {
    return this.k;
  }
  
  public void j(long paramLong)
  {
    this.j = paramLong;
  }
  
  public long k()
  {
    return this.j;
  }
  
  public void k(long paramLong)
  {
    this.t = paramLong;
  }
  
  public int l()
  {
    return this.l;
  }
  
  public void l(long paramLong)
  {
    this.u = paramLong;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public int n()
  {
    return this.n;
  }
  
  public String o()
  {
    return this.o;
  }
  
  public int p()
  {
    return this.p;
  }
  
  public String q()
  {
    return this.r;
  }
  
  public Object r()
  {
    return this.s;
  }
  
  public ExcitingTransferUploadResultRp s()
  {
    Object localObject = this.s;
    if ((localObject != null) && ((localObject instanceof ExcitingTransferUploadResultRp))) {
      return (ExcitingTransferUploadResultRp)localObject;
    }
    return null;
  }
  
  public long t()
  {
    return this.t;
  }
  
  public long u()
  {
    return this.u;
  }
  
  public void v()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = false;
    this.k = 0L;
    this.l = 0;
    this.m = "";
    this.n = 0;
    this.o = "";
    this.p = 0;
    this.q = 0;
    this.r = "";
    this.s = null;
    this.t = 0L;
    this.u = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo
 * JD-Core Version:    0.7.0.1
 */