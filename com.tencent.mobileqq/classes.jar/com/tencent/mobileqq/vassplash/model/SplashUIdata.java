package com.tencent.mobileqq.vassplash.model;

public class SplashUIdata
{
  public int a = -1;
  public String b = "";
  public int c = 0;
  public String d = "";
  public int e = 0;
  public String f = "";
  public boolean g = false;
  public boolean h = true;
  public int i = 0;
  public String j = "";
  public String k;
  public String l;
  public String m;
  public int n;
  public String o;
  public String p;
  
  public SplashUIdata(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, String paramString4)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramString2;
    this.e = paramInt3;
    this.f = paramString3;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramInt4;
    this.j = paramString4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mContentType =");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mResPath = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mSplashType = ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.model.SplashUIdata
 * JD-Core Version:    0.7.0.1
 */