package com.tencent.mobileqq.microapp.app;

import com.tencent.mobileqq.microapp.apkg.f;

public final class b$a
{
  public int a;
  public f b;
  public String c;
  public int d;
  
  public b$a(int paramInt1, String paramString, int paramInt2, f paramf)
  {
    this.a = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
    this.b = paramf;
  }
  
  public String toString()
  {
    return "MiniAppStateMsg{state=" + this.a + ", apkgInfo=" + this.b + ", appId='" + this.c + '\'' + ", versionType='" + this.d + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.app.b.a
 * JD-Core Version:    0.7.0.1
 */