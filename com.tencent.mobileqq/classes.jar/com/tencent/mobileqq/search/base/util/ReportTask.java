package com.tencent.mobileqq.search.base.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportTask
{
  protected AppInterface a;
  protected String b = "";
  protected String c = "";
  protected String d = "";
  protected String e = "";
  protected String f = "";
  protected int g;
  protected int h = 1;
  protected int i;
  protected List<String> j;
  
  public ReportTask(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public ReportTask a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public ReportTask a(String... paramVarArgs)
  {
    if (this.j == null) {
      this.j = new ArrayList(4);
    }
    if (paramVarArgs != null) {
      Collections.addAll(this.j, paramVarArgs);
    }
    return this;
  }
  
  public void a()
  {
    List localList = this.j;
    if ((localList != null) && (localList.size() != 0))
    {
      while (this.j.size() < 4) {
        this.j.add("");
      }
      ReportController.b(this.a, this.b, this.c, this.f, this.d, this.e, this.i, this.h, this.g, (String)this.j.get(0), (String)this.j.get(1), (String)this.j.get(2), (String)this.j.get(3));
      return;
    }
    ReportController.b(this.a, this.b, this.c, this.f, this.d, this.e, this.i, this.h, this.g, "", "", "", "");
  }
  
  public ReportTask b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public ReportTask c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public ReportTask d(String paramString)
  {
    this.e = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.ReportTask
 * JD-Core Version:    0.7.0.1
 */