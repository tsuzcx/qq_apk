package com.tencent.open.appstore.report;

import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;

public class ReportDataBuilder
{
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected int h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("|", "");
  }
  
  public static ReportDataBuilder c()
  {
    return new ReportDataBuilder();
  }
  
  public final ReportDataBuilder a(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public final ReportDataBuilder b(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String b()
  {
    return "";
  }
  
  public final ReportDataBuilder c(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public final ReportDataBuilder d(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public final String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(this.a));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.b));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.c));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.d));
    localStringBuilder.append("|");
    localStringBuilder.append(CommonDataAdapter.a().c());
    localStringBuilder.append("|");
    localStringBuilder.append(CommonDataAdapter.a().g());
    localStringBuilder.append("|");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.e));
    return localStringBuilder.toString();
  }
  
  public final ReportDataBuilder e(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public final String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(this.f));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.g));
    localStringBuilder.append("|");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.i));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.j));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.k));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.l));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.m));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.n));
    return localStringBuilder.toString();
  }
  
  public final ReportDataBuilder f(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public final String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  public final ReportDataBuilder g(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public final ReportDataBuilder h(String paramString)
  {
    this.m = paramString;
    return this;
  }
  
  public final ReportDataBuilder i(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public final ReportDataBuilder j(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public final ReportDataBuilder k(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public final ReportDataBuilder l(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public final ReportDataBuilder m(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public final ReportDataBuilder n(String paramString)
  {
    this.d = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.ReportDataBuilder
 * JD-Core Version:    0.7.0.1
 */