package com.tencent.mobileqq.msf.core.auth;

import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class a
{
  public static final String a = "MSF.C.Account";
  private long A = 0L;
  private long B = 0L;
  int b;
  private String c;
  private byte[] d = new byte[0];
  private byte[] e = new byte[0];
  private byte[] f = new byte[0];
  private byte[] g = new byte[0];
  private byte[] h = new byte[0];
  private byte[] i = new byte[0];
  private byte[] j = new byte[0];
  private byte[] k = new byte[0];
  private byte[] l = new byte[0];
  private byte[] m = new byte[0];
  private byte[] n = new byte[0];
  private byte[] o = new byte[0];
  private int p = 0;
  private int q = 0;
  private int r = 0;
  private byte[] s = new byte[0];
  private byte[] t = new byte[0];
  private long u;
  private boolean v;
  private int w = -1;
  private String x = "";
  private long y = 0L;
  private long z = 0L;
  
  public a(String paramString)
  {
    this.c = paramString;
  }
  
  public static a b(String paramString)
  {
    if (paramString != null)
    {
      try
      {
        if (paramString.length() <= 0) {
          break label796;
        }
        String[] arrayOfString = paramString.split(",");
        int i2 = arrayOfString.length;
        paramString = null;
        int i1 = 0;
        for (;;)
        {
          Object localObject1 = paramString;
          if (i1 >= i2) {
            return localObject1;
          }
          Object localObject2 = arrayOfString[i1];
          localObject1 = paramString;
          try
          {
            if (((String)localObject2).length() > 0)
            {
              localObject2 = ((String)localObject2).split("=");
              localObject1 = paramString;
              if (localObject2.length == 2) {
                if ("uin".equals(localObject2[0]))
                {
                  localObject1 = new a(localObject2[1]);
                }
                else if ("loginTime".equals(localObject2[0]))
                {
                  paramString.a(Long.parseLong(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("active".equals(localObject2[0]))
                {
                  paramString.a(Boolean.parseBoolean(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("A1".equals(localObject2[0]))
                {
                  paramString.d(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("A2".equals(localObject2[0]))
                {
                  paramString.e(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("A3".equals(localObject2[0]))
                {
                  paramString.f(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("D1".equals(localObject2[0]))
                {
                  paramString.g(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("D2".equals(localObject2[0]))
                {
                  paramString.h(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("S2".equals(localObject2[0]))
                {
                  paramString.i(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("key".equals(localObject2[0]))
                {
                  paramString.j(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("sid".equals(localObject2[0]))
                {
                  localObject1 = paramString;
                }
                else if ("MiniA2".equals(localObject2[0]))
                {
                  paramString.l(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("MainAccount".equals(localObject2[0]))
                {
                  paramString.m(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("FaceId".equalsIgnoreCase(localObject2[0]))
                {
                  paramString.a(Integer.parseInt(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("Age".equalsIgnoreCase(localObject2[0]))
                {
                  paramString.b(Integer.parseInt(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("Gender".equalsIgnoreCase(localObject2[0]))
                {
                  paramString.c(Integer.parseInt(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("NickName".equals(localObject2[0]))
                {
                  paramString.n(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("sid".equals(localObject2[0]))
                {
                  localObject1 = paramString;
                }
                else if ("renewA2D2Time".equals(localObject2[0]))
                {
                  paramString.b(Long.parseLong(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("renewSidTime".equals(localObject2[0]))
                {
                  paramString.c(Long.parseLong(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("loginedProcess".equals(localObject2[0]))
                {
                  paramString.c(localObject2[1]);
                  localObject1 = paramString;
                }
                else if ("vkey".equals(localObject2[0]))
                {
                  paramString.a(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("skey".equals(localObject2[0]))
                {
                  paramString.b(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("stweb".equals(localObject2[0]))
                {
                  paramString.c(HexUtil.hexStr2Bytes(localObject2[1]));
                  localObject1 = paramString;
                }
                else if ("renewSkeyTime".equals(localObject2[0]))
                {
                  paramString.d(Long.parseLong(localObject2[1]));
                  localObject1 = paramString;
                }
                else
                {
                  localObject1 = paramString;
                  if ("renewWebviewKeyTime".equals(localObject2[0]))
                  {
                    paramString.e(Long.parseLong(localObject2[1]));
                    localObject1 = paramString;
                  }
                }
              }
            }
            i1 += 1;
            paramString = (String)localObject1;
          }
          catch (Exception localException1) {}
        }
        QLog.e("MSF.C.Account", 2, "parse account error", localException2);
      }
      catch (Exception localException2)
      {
        paramString = null;
      }
      return paramString;
    }
    label796:
    a locala = null;
    return locala;
  }
  
  public long A()
  {
    long l2 = this.z;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.u;
    }
    return l1;
  }
  
  public long B()
  {
    long l2 = this.A;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.u;
    }
    return l1;
  }
  
  public long C()
  {
    long l2 = this.B;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.u;
    }
    return l1;
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.u = paramLong;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.k = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.k;
  }
  
  public void b(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.y = paramLong;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.l = paramArrayOfByte;
  }
  
  public byte[] b()
  {
    return this.l;
  }
  
  public void c(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.z = paramLong;
  }
  
  public void c(String paramString)
  {
    this.x = paramString;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.m = paramArrayOfByte;
  }
  
  public byte[] c()
  {
    return this.m;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.A = paramLong;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public void e(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void e(long paramLong)
  {
    this.B = paramLong;
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public byte[] e()
  {
    return this.d;
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    this.f = paramArrayOfByte;
  }
  
  public byte[] f()
  {
    return this.e;
  }
  
  public void g(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
  }
  
  public byte[] g()
  {
    return this.f;
  }
  
  public void h(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
  }
  
  public byte[] h()
  {
    return this.g;
  }
  
  public void i(byte[] paramArrayOfByte)
  {
    this.i = paramArrayOfByte;
  }
  
  public byte[] i()
  {
    return this.h;
  }
  
  public void j(byte[] paramArrayOfByte)
  {
    this.j = paramArrayOfByte;
  }
  
  public byte[] j()
  {
    return this.i;
  }
  
  public void k(byte[] paramArrayOfByte)
  {
    this.t = paramArrayOfByte;
  }
  
  public byte[] k()
  {
    return this.j;
  }
  
  public void l(byte[] paramArrayOfByte)
  {
    this.n = paramArrayOfByte;
  }
  
  public byte[] l()
  {
    return this.t;
  }
  
  public long m()
  {
    return this.u;
  }
  
  public void m(byte[] paramArrayOfByte)
  {
    this.o = paramArrayOfByte;
  }
  
  public void n(byte[] paramArrayOfByte)
  {
    this.s = paramArrayOfByte;
  }
  
  public boolean n()
  {
    return this.v;
  }
  
  public SimpleAccount o()
  {
    SimpleAccount localSimpleAccount = new SimpleAccount();
    localSimpleAccount.setUin(this.c);
    localSimpleAccount.setAttribute("_isLogined", String.valueOf(this.v));
    localSimpleAccount.setAttribute("_loginTime", String.valueOf(this.u));
    localSimpleAccount.setAttribute("_loginedProcess", this.x);
    return localSimpleAccount;
  }
  
  public String p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(",uin=");
    localStringBuilder.append(this.c);
    if (m() > 0L)
    {
      localStringBuilder.append(",loginTime=");
      localStringBuilder.append(m());
    }
    localStringBuilder.append(",active=");
    localStringBuilder.append(this.v);
    if ((e() != null) && (e().length > 0))
    {
      localStringBuilder.append(",A1=");
      localStringBuilder.append(HexUtil.bytes2HexStr(e()));
    }
    if ((f() != null) && (f().length > 0))
    {
      localStringBuilder.append(",A2=");
      localStringBuilder.append(HexUtil.bytes2HexStr(f()));
    }
    if ((g() != null) && (g().length > 0))
    {
      localStringBuilder.append(",A3=");
      localStringBuilder.append(HexUtil.bytes2HexStr(g()));
    }
    if ((h() != null) && (h().length > 0))
    {
      localStringBuilder.append(",D1=");
      localStringBuilder.append(HexUtil.bytes2HexStr(h()));
    }
    if ((i() != null) && (i().length > 0))
    {
      localStringBuilder.append(",D2=");
      localStringBuilder.append(HexUtil.bytes2HexStr(i()));
    }
    if ((j() != null) && (j().length > 0))
    {
      localStringBuilder.append(",S2=");
      localStringBuilder.append(HexUtil.bytes2HexStr(j()));
    }
    if ((k() != null) && (k().length > 0))
    {
      localStringBuilder.append(",key=");
      localStringBuilder.append(HexUtil.bytes2HexStr(k()));
    }
    if ((q() != null) && (q().length > 0))
    {
      localStringBuilder.append(",MiniA2=");
      localStringBuilder.append(HexUtil.bytes2HexStr(q()));
    }
    if ((r() != null) && (r().length > 0))
    {
      localStringBuilder.append(",MainAccount=");
      localStringBuilder.append(HexUtil.bytes2HexStr(r()));
    }
    if ((a() != null) && (a().length > 0))
    {
      localStringBuilder.append(",vkey=");
      localStringBuilder.append(HexUtil.bytes2HexStr(a()));
    }
    if ((b() != null) && (b().length > 0))
    {
      localStringBuilder.append(",skey=");
      localStringBuilder.append(HexUtil.bytes2HexStr(b()));
    }
    if ((c() != null) && (c().length > 0))
    {
      localStringBuilder.append(",stweb=");
      localStringBuilder.append(HexUtil.bytes2HexStr(c()));
    }
    localStringBuilder.append(",FaceId=");
    localStringBuilder.append(s());
    localStringBuilder.append(",Age=");
    localStringBuilder.append(t());
    localStringBuilder.append(",Gender=");
    localStringBuilder.append(u());
    if ((v() != null) && (v().length > 0))
    {
      localStringBuilder.append(",NickName=");
      localStringBuilder.append(HexUtil.bytes2HexStr(v()));
    }
    localStringBuilder.append(",renewA2D2Time=");
    localStringBuilder.append(z());
    localStringBuilder.append(",renewSidTime=");
    localStringBuilder.append(A());
    localStringBuilder.append(",renewSkeyTime=");
    localStringBuilder.append(B());
    localStringBuilder.append(",renewWebviewKeyTime=");
    localStringBuilder.append(C());
    localStringBuilder.append(",loginedProcess=");
    localStringBuilder.append(this.x);
    return localStringBuilder.toString();
  }
  
  public byte[] q()
  {
    return this.n;
  }
  
  public byte[] r()
  {
    return this.o;
  }
  
  public int s()
  {
    return this.p;
  }
  
  public int t()
  {
    return this.q;
  }
  
  public int u()
  {
    return this.r;
  }
  
  public byte[] v()
  {
    return this.s;
  }
  
  public int w()
  {
    return this.b;
  }
  
  public int x()
  {
    return this.w;
  }
  
  public String y()
  {
    return this.x;
  }
  
  public long z()
  {
    long l2 = this.y;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.u;
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.a
 * JD-Core Version:    0.7.0.1
 */