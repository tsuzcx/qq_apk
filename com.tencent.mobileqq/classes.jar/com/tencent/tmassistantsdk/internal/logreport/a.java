package com.tencent.tmassistantsdk.internal.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.a.b;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter:");
      localStringBuilder.append(paramJceStruct);
      ab.c("BaseReportManager", localStringBuilder.toString());
      if (paramJceStruct != null)
      {
        paramJceStruct = ProtocolPackage.jceStructToUTF8Byte(paramJceStruct);
        d().a(paramJceStruct);
      }
      ab.c("BaseReportManager", "exit");
      return;
    }
    finally {}
  }
  
  public void a(d paramd, boolean paramBoolean)
  {
    ab.c("BaseReportManager", "enter");
    paramd = new StringBuilder();
    paramd.append("result:");
    paramd.append(paramBoolean);
    ab.c("BaseReportManager", paramd.toString());
    if (!paramBoolean)
    {
      paramd = this.c;
      if ((paramd != null) && (paramd.size() > 0))
      {
        ab.c("BaseReportManager", "reback DB!");
        d().a(this.c);
      }
    }
    this.a = null;
    this.c.clear();
    if ((paramBoolean) && (f()) && (this.b < 5))
    {
      paramd = new StringBuilder();
      paramd.append("reportlog go on,result:");
      paramd.append(paramBoolean);
      paramd.append(" count:");
      paramd.append(this.b);
      ab.c("BaseReportManager", paramd.toString());
      b();
      this.b += 1;
    }
    ab.c("BaseReportManager", "exit");
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        ab.c("BaseReportManager", "enter");
        if (!GlobalUtil.getInstance().canReportValue())
        {
          ab.c("BaseReportManager", "Not WiFi");
          ab.c("BaseReportManager", "exit");
          return;
        }
        if (this.a != null)
        {
          ab.c("BaseReportManager", "reportRequst is sending out");
          ab.c("BaseReportManager", "exit");
          return;
        }
        this.a = new d();
        this.a.a(this);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" request:");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(" reportManager:");
        ((StringBuilder)localObject1).append(getClass().getName());
        ab.c("BaseReportManager", ((StringBuilder)localObject1).toString());
        localObject1 = d().a(1000);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readLogDataAndSendToServer,wrappterCount:");
        localStringBuilder.append(((b)localObject1).b.size());
        ab.c("BaseReportManager", localStringBuilder.toString());
        if ((localObject1 != null) && (((b)localObject1).b.size() > 0))
        {
          this.c.addAll(((b)localObject1).b);
          bool = this.a.a(e(), (b)localObject1);
          d().b(((b)localObject1).a);
          if (!bool) {
            this.a = null;
          }
          ab.c("BaseReportManager", "exit");
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void c()
  {
    this.b = 0;
  }
  
  protected abstract com.tencent.tmassistant.common.a.a d();
  
  protected abstract byte e();
  
  protected abstract boolean f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.a
 * JD-Core Version:    0.7.0.1
 */