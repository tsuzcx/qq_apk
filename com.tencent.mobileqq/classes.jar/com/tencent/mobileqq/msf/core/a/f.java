package com.tencent.mobileqq.msf.core.a;

public class f
{
  private static final String b = "WeakNetworkConfig";
  
  static
  {
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static boolean a()
  {
    return a.bs() != 0;
  }
  
  public static a b()
  {
    a locala;
    switch ()
    {
    default: 
      locala = c();
    }
    while ((!a) && (locala == null))
    {
      throw new AssertionError();
      locala = c();
      continue;
      locala = new a(2, false, 2000, 2000, 2, 1, 2000, 20, 1000, 2000, 1000);
    }
    return locala;
  }
  
  public static a c()
  {
    return new a(1, true, 3000, 3000, 2, 2, 2000, 20, 2000, 3000, 500);
  }
  
  public static class a
  {
    public int a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    
    public a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      this.a = paramInt1;
      this.b = paramBoolean;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
      this.g = paramInt6;
      this.h = paramInt7;
      this.i = paramInt8;
      this.j = paramInt9;
      this.k = paramInt10;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("WeaknetNew ConfigParam: [").append(this.a).append(",").append(this.b).append(",").append(this.c).append(",").append(this.d).append(",").append(this.e).append(",").append(this.f).append(",").append(this.h).append(",").append(this.i).append(",").append(this.k).append(",").append(this.j).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.f
 * JD-Core Version:    0.7.0.1
 */