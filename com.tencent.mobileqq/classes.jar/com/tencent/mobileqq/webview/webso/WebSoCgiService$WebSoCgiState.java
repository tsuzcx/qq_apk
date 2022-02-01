package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;

public class WebSoCgiService$WebSoCgiState
{
  public String a = null;
  public String b = null;
  public String c = null;
  public volatile String d = null;
  public int e = 0;
  public int f = -1;
  public boolean g = false;
  public String h;
  public int i = 0;
  public String j = "";
  public Object k;
  public Handler l;
  public HybridWebReporter.HybridWebReportInfo m;
  public long n = 0L;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unikey=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",url=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ,header=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",htmlbody len=");
    int i1;
    if (TextUtils.isEmpty(this.d)) {
      i1 = 0;
    } else {
      i1 = this.d.length();
    }
    localStringBuilder.append(i1);
    localStringBuilder.append(",reqState=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",httpStatusCode=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",needBase64Rsp=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",jsCallback=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",resultCode=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",errorMsg=");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState
 * JD-Core Version:    0.7.0.1
 */