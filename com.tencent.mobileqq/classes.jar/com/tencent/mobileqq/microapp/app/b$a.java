package com.tencent.mobileqq.microapp.app;

import com.tencent.mobileqq.microapp.a.c;

public final class b$a
{
  public int a;
  public c b;
  public String c;
  public int d;
  
  public b$a(int paramInt1, String paramString, int paramInt2, c paramc)
  {
    this.a = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
    this.b = paramc;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppStateMsg{state=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", apkgInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", versionType='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.app.b.a
 * JD-Core Version:    0.7.0.1
 */