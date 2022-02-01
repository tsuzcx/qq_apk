package com.vivo.push.model;

import android.text.TextUtils;

public final class b
{
  private String a;
  private long b = -1L;
  private int c = -1;
  private String d;
  private boolean e = false;
  private boolean f = false;
  
  public b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a = paramString;
      return;
    }
    throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.d = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final boolean c()
  {
    return this.e;
  }
  
  public final boolean d()
  {
    return this.f;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PushPackageInfo{mPackageName=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPushVersion=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mPackageVersion=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mInBlackList=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mPushEnable=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.model.b
 * JD-Core Version:    0.7.0.1
 */