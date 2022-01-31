package com.tencent.tmassistantsdk.internal.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.a.b;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements c
{
  protected d a = null;
  protected int b = 0;
  protected final List<byte[]> c = new ArrayList();
  
  public void a()
  {
    this.a = null;
    this.c.clear();
  }
  
  public void a(JceStruct paramJceStruct)
  {
    try
    {
      r.c("BaseReportManager", "enter:" + paramJceStruct);
      if (paramJceStruct != null)
      {
        paramJceStruct = ProtocolPackage.jceStructToUTF8Byte(paramJceStruct);
        e().a(paramJceStruct);
      }
      r.c("BaseReportManager", "exit");
      return;
    }
    finally {}
  }
  
  public void a(d paramd, boolean paramBoolean)
  {
    r.c("BaseReportManager", "enter");
    r.c("BaseReportManager", "result:" + paramBoolean);
    if ((!paramBoolean) && (this.c != null) && (this.c.size() > 0))
    {
      r.c("BaseReportManager", "reback DB!");
      e().a(this.c);
    }
    this.a = null;
    this.c.clear();
    if ((paramBoolean) && (g()) && (this.b < 5))
    {
      r.c("BaseReportManager", "reportlog go on,result:" + paramBoolean + " count:" + this.b);
      c();
      this.b += 1;
    }
    r.c("BaseReportManager", "exit");
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.cancleRequest();
      this.a = null;
    }
  }
  
  public void c()
  {
    try
    {
      r.c("BaseReportManager", "enter");
      if (!GlobalUtil.getInstance().canReportValue())
      {
        r.c("BaseReportManager", "Not WiFi");
        r.c("BaseReportManager", "exit");
      }
      for (;;)
      {
        return;
        if (this.a == null) {
          break;
        }
        r.c("BaseReportManager", "reportRequst is sending out");
        r.c("BaseReportManager", "exit");
      }
      this.a = new d();
    }
    finally {}
    this.a.a(this);
    r.c("BaseReportManager", " request:" + this.a + " reportManager:" + getClass().getName());
    b localb = e().a(1000);
    r.c("BaseReportManager", "readLogDataAndSendToServer,wrappterCount:" + localb.b.size());
    if (localb != null) {
      if (localb.b.size() <= 0) {
        break label248;
      }
    }
    for (;;)
    {
      if (!bool) {
        this.a = null;
      }
      r.c("BaseReportManager", "exit");
      break;
      this.c.addAll(localb.b);
      boolean bool = this.a.a(f(), localb);
      e().b(localb.a);
      continue;
      label248:
      bool = false;
    }
  }
  
  public void d()
  {
    this.b = 0;
  }
  
  protected abstract com.tencent.tmassistant.common.a.a e();
  
  protected abstract byte f();
  
  protected abstract boolean g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.a
 * JD-Core Version:    0.7.0.1
 */