package com.tencent.xweb;

import java.io.InputStream;
import java.util.Map;

public class WebResourceResponse
{
  private String a;
  private String b;
  private int c = 200;
  private String d;
  private Map<String, String> e;
  private InputStream f;
  private boolean g = false;
  
  public WebResourceResponse(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, InputStream paramInputStream)
  {
    this(paramString1, paramString2, paramInputStream);
    a(paramInt, paramString3);
    a(paramMap);
    this.g = true;
  }
  
  public WebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream)
  {
    this.a = paramString1;
    this.b = paramString2;
    a(paramInputStream);
    this.g = false;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c = paramInt;
    this.d = paramString;
  }
  
  public void a(InputStream paramInputStream)
  {
    this.f = paramInputStream;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public Map<String, String> f()
  {
    return this.e;
  }
  
  public InputStream g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.WebResourceResponse
 * JD-Core Version:    0.7.0.1
 */