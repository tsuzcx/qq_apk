package com.tencent.tgpa.vendorpd.a;

import com.tencent.tgpa.vendorpd.GameCallback;

public final class b$b
{
  private String a;
  private String b = "default";
  private String c = "https://version.tgpa.qq.com";
  private String d = null;
  private String e = null;
  private String f;
  private GameCallback g = null;
  
  public b a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public b a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "https://testversion.tgpa.qq.com";
    } else {
      str = "https://version.tgpa.qq.com";
    }
    this.c = str;
    return this;
  }
  
  public b a()
  {
    return new b(this);
  }
  
  public b b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public b c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public b d(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public b e(String paramString)
  {
    this.f = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.b.b
 * JD-Core Version:    0.7.0.1
 */