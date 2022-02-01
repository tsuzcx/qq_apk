package com.tencent.vas.update.entity;

import androidx.annotation.NonNull;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

public class ReportItemParams
{
  public int a;
  public long b;
  public String c;
  public String d;
  public boolean e;
  public int f;
  public int g;
  public int h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public ReportItemParams(@NonNull DownloadResultParams paramDownloadResultParams, long paramLong, String paramString)
  {
    this.a = paramDownloadResultParams.a;
    this.b = paramLong;
    this.c = paramString;
    this.f = paramDownloadResultParams.b;
    this.g = paramDownloadResultParams.c;
    this.i = paramDownloadResultParams.d;
    this.j = "2";
    this.k = VasUpdateWrapper.getCommonManager().e();
    paramDownloadResultParams = new StringBuilder();
    paramDownloadResultParams.append(VasUpdateWrapper.getCommonManager().f());
    paramDownloadResultParams.append("");
    this.l = paramDownloadResultParams.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.entity.ReportItemParams
 * JD-Core Version:    0.7.0.1
 */