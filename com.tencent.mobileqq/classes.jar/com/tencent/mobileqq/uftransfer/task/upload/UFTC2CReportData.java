package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTC2CReportData
{
  protected final AppRuntime a;
  protected final long b;
  protected final String c;
  protected final long d;
  protected final int e;
  public String f;
  public String g;
  public String h;
  public long i = 1L;
  public long j = 0L;
  public int k = 0;
  public String l;
  public long m = 0L;
  public long n = 0L;
  public long o = 0L;
  public int p = 0;
  public int q = 0;
  public boolean r = false;
  public long s = 0L;
  public String t;
  public String u;
  public String v;
  public String w;
  
  public UFTC2CReportData(AppRuntime paramAppRuntime, long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    this.a = paramAppRuntime;
    this.b = paramLong1;
    this.c = paramString;
    this.d = paramLong2;
    this.e = paramInt;
  }
  
  private void a(String paramString)
  {
    if (this.m == 0L) {
      this.m = System.currentTimeMillis();
    }
    long l1;
    if (System.currentTimeMillis() > this.m) {
      l1 = System.currentTimeMillis() - this.m;
    } else {
      l1 = 10L;
    }
    try
    {
      if ((this.h != null) && (this.h.length() > 0)) {
        localObject1 = this.h.substring(this.h.indexOf("://") + 3, this.h.lastIndexOf(":"));
      } else {
        localObject1 = "";
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label101:
      Object localObject2;
      int i1;
      int i2;
      break label101;
    }
    localObject1 = this.h;
    localObject2 = this.u;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      if (this.u.indexOf("Network is unreachable") > 0) {}
      while ((this.u.indexOf("No route to host") > 0) || (this.u.indexOf("MalformedURLException") > 0))
      {
        i1 = 1;
        break;
      }
    }
    i1 = 0;
    if ((!UFTDependFeatureApi.c()) || (i1 != 0))
    {
      this.s = 9004L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("NotNetWork_");
      ((StringBuilder)localObject2).append(this.u);
      this.u = ((StringBuilder)localObject2).toString();
    }
    if (!this.a.isLogin())
    {
      this.s = 9004L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("NotLogin_");
      ((StringBuilder)localObject2).append(this.u);
      this.u = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("serverip", localObject1);
    ((HashMap)localObject2).put("param_Server", localObject1);
    ((HashMap)localObject2).put("param_ftnIP", localObject1);
    ((HashMap)localObject2).put("param_PeerUin", String.valueOf(this.c));
    ((HashMap)localObject2).put("param_uuid", String.valueOf(this.f));
    ((HashMap)localObject2).put("param_MD5", this.g);
    ((HashMap)localObject2).put("param_FailCode", Long.toString(this.s));
    ((HashMap)localObject2).put("param_errorDesc", String.valueOf(this.t));
    ((HashMap)localObject2).put("param_fsized", String.valueOf(this.j));
    ((HashMap)localObject2).put("param_fsizeo", String.valueOf(this.d));
    ((HashMap)localObject2).put("param_url", String.valueOf(this.w));
    ((HashMap)localObject2).put("param_rspHeader", String.valueOf(this.v));
    ((HashMap)localObject2).put("param_retry", String.valueOf(this.k));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.u);
    ((StringBuilder)localObject1).append("uin[");
    ((StringBuilder)localObject1).append(this.a.getCurrentAccountUin());
    ((StringBuilder)localObject1).append("]");
    ((HashMap)localObject2).put("param_errMsg", ((StringBuilder)localObject1).toString());
    ((HashMap)localObject2).put("param_nSessionId", String.valueOf(this.b));
    ((HashMap)localObject2).put("param_ipStackType", String.valueOf(UFTDependFeatureApi.g()));
    ((HashMap)localObject2).put("param_realTransferType", String.valueOf(0));
    ((HashMap)localObject2).put("param_transferdsize", String.valueOf(this.i));
    ((HashMap)localObject2).put("param_transferTime", String.valueOf(this.n));
    ((HashMap)localObject2).put("param_speed", String.valueOf(this.o));
    i1 = UFTDependFeatureApi.h();
    i2 = UFTDependFeatureApi.i();
    ((HashMap)localObject2).put("param_fromType", String.valueOf(this.e));
    ((HashMap)localObject2).put("param_V6SelectType", String.valueOf(this.p));
    ((HashMap)localObject2).put("param_ipAddrType", String.valueOf(this.q));
    ((HashMap)localObject2).put("param_stackType", String.valueOf(i1));
    ((HashMap)localObject2).put("param_loginType", String.valueOf(i2));
    ((HashMap)localObject2).put("param_ishttps", String.valueOf(this.r));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Id[");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append("] >>> C2C_Fail_DR:actType[");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("] ");
    ((StringBuilder)localObject1).append(((HashMap)localObject2).toString());
    UFTLog.d("[UFTTransfer] UFTC2CReportData", 1, ((StringBuilder)localObject1).toString());
    UFTDependFeatureApi.a(this.a.getCurrentAccountUin(), paramString, false, l1, this.i, (HashMap)localObject2, this.l);
  }
  
  private void b(String paramString)
  {
    if (this.m == 0L) {
      this.m = System.currentTimeMillis();
    }
    long l1;
    if (System.currentTimeMillis() > this.m) {
      l1 = System.currentTimeMillis() - this.m;
    } else {
      l1 = 10L;
    }
    try
    {
      if ((this.h != null) && (this.h.length() > 0)) {
        localObject = this.h.substring(this.h.indexOf("://") + 3, this.h.lastIndexOf(":"));
      } else {
        localObject = "";
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label101:
      HashMap localHashMap;
      int i1;
      int i2;
      break label101;
    }
    localObject = this.h;
    localHashMap = new HashMap();
    localHashMap.put("serverip", localObject);
    localHashMap.put("param_Server", localObject);
    localHashMap.put("param_ftnIP", localObject);
    localHashMap.put("param_PeerUin", this.c);
    localHashMap.put("param_uuid", this.f);
    localHashMap.put("param_MD5", this.g);
    localHashMap.put("param_fsized", String.valueOf(this.j));
    localHashMap.put("param_fsizeo", String.valueOf(this.d));
    localHashMap.put("param_retry", String.valueOf(this.k));
    localHashMap.put("param_nSessionId", String.valueOf(this.b));
    localHashMap.put("param_errMsg", String.valueOf(this.l));
    localHashMap.put("param_ipStackType", String.valueOf(UFTDependFeatureApi.g()));
    localHashMap.put("param_realTransferType", String.valueOf(0));
    localHashMap.put("param_transferdsize", String.valueOf(this.i));
    localHashMap.put("param_httpTime", String.valueOf(this.n));
    localHashMap.put("param_speed", String.valueOf(this.o));
    i1 = UFTDependFeatureApi.h();
    i2 = UFTDependFeatureApi.i();
    localHashMap.put("param_fromType", String.valueOf(this.e));
    localHashMap.put("param_V6SelectType", String.valueOf(this.p));
    localHashMap.put("param_ipAddrType", String.valueOf(this.q));
    localHashMap.put("param_stackType", String.valueOf(i1));
    localHashMap.put("param_loginType", String.valueOf(i2));
    localHashMap.put("param_ishttps", String.valueOf(this.r));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] >>> C2C_Suc_DR:actType[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    ((StringBuilder)localObject).append(localHashMap.toString());
    UFTLog.b("[UFTTransfer] UFTC2CReportData", 1, ((StringBuilder)localObject).toString());
    UFTDependFeatureApi.a(this.a.getCurrentAccountUin(), paramString, true, l1, this.i, localHashMap, this.l);
  }
  
  public void a()
  {
    a("actFileUp");
  }
  
  public void b()
  {
    a("actFileUpDetail");
  }
  
  public void c()
  {
    b("actFileUp");
  }
  
  public void d()
  {
    b("actFileUpDetail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CReportData
 * JD-Core Version:    0.7.0.1
 */