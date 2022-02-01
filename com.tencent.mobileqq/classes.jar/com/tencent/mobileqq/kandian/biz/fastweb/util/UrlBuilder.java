package com.tencent.mobileqq.kandian.biz.fastweb.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlBuilder
{
  private String a = "";
  private String b = "utf-8";
  private StringBuilder c;
  private boolean d = true;
  
  public UrlBuilder(String paramString)
  {
    this(paramString, "utf-8");
  }
  
  public UrlBuilder(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    b();
    this.c = new StringBuilder(this.a);
    this.d = true;
  }
  
  private void b()
  {
    if (!this.a.endsWith("?"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("?");
      this.a = localStringBuilder.toString();
    }
  }
  
  public UrlBuilder a(String paramString1, String paramString2)
  {
    try
    {
      if (!this.d) {
        this.c.append("&");
      }
      this.d = false;
      this.c.append(paramString1);
      this.c.append("=");
      this.c.append(URLEncoder.encode(paramString2, this.b));
      return this;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return this;
  }
  
  public String a()
  {
    return this.c.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.UrlBuilder
 * JD-Core Version:    0.7.0.1
 */