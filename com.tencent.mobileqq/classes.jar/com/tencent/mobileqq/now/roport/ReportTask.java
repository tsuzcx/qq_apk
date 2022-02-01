package com.tencent.mobileqq.now.roport;

import android.os.Bundle;

public class ReportTask
{
  private final Bundle a = ReportCenter.a.a();
  
  public ReportTask()
  {
    this.a.putString("tid", "personal_live_base");
    this.a.putString("bid", "b_sng_im_personal_live");
    this.a.putString("KEY_START_SRC", "default");
  }
  
  public ReportTask a(int paramInt)
  {
    return a("obj1", paramInt);
  }
  
  public ReportTask a(String paramString)
  {
    this.a.putString("module", paramString);
    return this;
  }
  
  public ReportTask a(String paramString, int paramInt)
  {
    this.a.putString(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ReportTask a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "null";
    }
    this.a.putString(paramString1, str.replace("&", "_"));
    return this;
  }
  
  public void a()
  {
    ReportCenter.a.a(this.a);
  }
  
  public ReportTask b(String paramString)
  {
    this.a.putString("action", paramString);
    return this;
  }
  
  public ReportTask c(String paramString)
  {
    this.a.putString("source", paramString);
    return this;
  }
  
  public ReportTask d(String paramString)
  {
    return a("obj2", paramString);
  }
  
  public ReportTask e(String paramString)
  {
    return a("obj3", paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportTask{map=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.roport.ReportTask
 * JD-Core Version:    0.7.0.1
 */