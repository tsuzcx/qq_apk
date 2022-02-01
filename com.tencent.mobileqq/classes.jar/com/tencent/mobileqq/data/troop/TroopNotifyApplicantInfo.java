package com.tencent.mobileqq.data.troop;

public class TroopNotifyApplicantInfo
{
  private long a;
  private int b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private boolean h;
  private boolean i;
  private boolean j = false;
  
  public TroopNotifyApplicantInfo(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramBoolean3;
  }
  
  public TroopNotifyApplicantInfo(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramInt2;
    this.j = paramBoolean1;
    this.h = paramBoolean2;
  }
  
  public TroopNotifyApplicantInfo(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.a = paramLong;
    this.g = paramInt;
    this.i = paramBoolean;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public boolean i()
  {
    return this.i;
  }
  
  public boolean j()
  {
    return this.j;
  }
  
  public TroopNotifyApplicantInfo k()
  {
    return new TroopNotifyApplicantInfo(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopNotifyApplicantInfo
 * JD-Core Version:    0.7.0.1
 */