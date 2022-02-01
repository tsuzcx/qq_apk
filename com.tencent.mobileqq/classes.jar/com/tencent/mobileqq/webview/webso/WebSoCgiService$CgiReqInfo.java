package com.tencent.mobileqq.webview.webso;

public class WebSoCgiService$CgiReqInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public boolean g;
  public int h;
  public Object i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ,method=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ,jsonHeader=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ,body=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ,");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ,rspBase64=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ,timeout=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ,userInfo=");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoCgiService.CgiReqInfo
 * JD-Core Version:    0.7.0.1
 */