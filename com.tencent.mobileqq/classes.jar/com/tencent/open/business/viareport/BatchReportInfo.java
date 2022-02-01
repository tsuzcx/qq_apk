package com.tencent.open.business.viareport;

import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;

public class BatchReportInfo
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  
  public String a()
  {
    if (TextUtils.isEmpty(this.f)) {
      return APNUtil.a(CommonDataAdapter.a().a());
    }
    return this.f;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("_");
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    localStringBuilder.append("_");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.viareport.BatchReportInfo
 * JD-Core Version:    0.7.0.1
 */