package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTDiscReportData
{
  public long a;
  public String b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public String i;
  public String j;
  public int k;
  public String l;
  public long m;
  public long n;
  public long o;
  public int p;
  public String q;
  public String r;
  private final AppRuntime s;
  private final String t;
  private final String u;
  private final String v;
  
  public UFTDiscReportData(AppRuntime paramAppRuntime, String paramString)
  {
    this.s = paramAppRuntime;
    this.v = paramString;
    this.t = "actDiscussFileUp";
    this.u = "actDiscussFileUpDetail";
  }
  
  private HashMap<String, String> c()
  {
    try
    {
      if ((this.i != null) && (this.i.length() > 0)) {
        str = this.i.substring(this.i.indexOf("://") + 3, this.i.lastIndexOf(":"));
      } else {
        str = null;
      }
    }
    catch (Exception localException)
    {
      String str;
      label53:
      boolean bool;
      int i1;
      Object localObject;
      break label53;
    }
    str = this.i;
    if (this.a != 0L)
    {
      bool = TextUtils.isEmpty(this.b);
      i1 = 1;
      if ((!bool) || ((this.b.indexOf("Network is unreachable") <= 0) && (this.b.indexOf("No route to host") <= 0) && (this.b.indexOf("MalformedURLException") <= 0))) {
        i1 = 0;
      }
      if ((!UFTDependFeatureApi.c()) || (i1 != 0))
      {
        this.a = 9004L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NotNetWork_");
        ((StringBuilder)localObject).append(this.b);
        this.b = ((StringBuilder)localObject).toString();
      }
      localObject = this.s;
      if ((localObject != null) && (!((AppRuntime)localObject).isLogin()))
      {
        this.a = 9004L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NotLogin_");
        ((StringBuilder)localObject).append(this.b);
        this.b = ((StringBuilder)localObject).toString();
      }
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_serverip", String.valueOf(str));
    ((HashMap)localObject).put("param_Server", String.valueOf(str));
    ((HashMap)localObject).put("param_PeerUin", String.valueOf(this.j));
    ((HashMap)localObject).put("param_PeerType", String.valueOf(this.k));
    ((HashMap)localObject).put("param_uuid", String.valueOf(this.l));
    ((HashMap)localObject).put("param_FailCode", Long.toString(this.a));
    ((HashMap)localObject).put("param_fsized", String.valueOf(this.m));
    ((HashMap)localObject).put("param_fsizeo", String.valueOf(this.o));
    ((HashMap)localObject).put("param_url", String.valueOf(this.i));
    ((HashMap)localObject).put("param_rspHeader", String.valueOf(this.q));
    ((HashMap)localObject).put("param_retry", String.valueOf(this.p));
    ((HashMap)localObject).put("param_errMsg", String.valueOf(this.b));
    ((HashMap)localObject).put("param_nSessionId", String.valueOf(this.c));
    ((HashMap)localObject).put("param_CSDuration", String.valueOf(this.e - this.d));
    ((HashMap)localObject).put("param_HttpDuration", String.valueOf(this.g - this.f));
    ((HashMap)localObject).put("param_AllDuration", String.valueOf(this.h - this.d));
    return localObject;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis() - this.g;
    if (l1 < 0L) {
      l1 = 0L;
    }
    this.h = System.currentTimeMillis();
    HashMap localHashMap = c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] >>> Disc_Fail_DR:actType[");
    ((StringBuilder)localObject).append(this.u);
    ((StringBuilder)localObject).append("]");
    if (localHashMap != null) {
      str = localHashMap.toString();
    } else {
      str = "null";
    }
    ((StringBuilder)localObject).append(str);
    UFTLog.d("[UFTTransfer] UFTDiscReportData", 1, ((StringBuilder)localObject).toString());
    String str = this.v;
    localObject = this.u;
    boolean bool;
    if (this.a == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    UFTDependFeatureApi.a(str, (String)localObject, bool, l1, this.n, localHashMap, this.r);
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis() - this.g;
    if (l1 < 0L) {
      l1 = 0L;
    }
    this.h = System.currentTimeMillis();
    HashMap localHashMap = c();
    long l2 = this.a;
    String str = "null";
    if (l2 == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] >>> Disc_Suc_DR:actType[");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append("]");
      if (localHashMap != null) {
        str = localHashMap.toString();
      }
      ((StringBuilder)localObject).append(str);
      UFTLog.b("[UFTTransfer] UFTDiscReportData", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] >>> Disc_Fail_DR:actType[");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append("]");
      if (localHashMap != null) {
        str = localHashMap.toString();
      }
      ((StringBuilder)localObject).append(str);
      UFTLog.d("[UFTTransfer] UFTDiscReportData", 1, ((StringBuilder)localObject).toString());
    }
    str = this.v;
    Object localObject = this.t;
    boolean bool;
    if (this.a == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    UFTDependFeatureApi.a(str, (String)localObject, bool, l1, this.n, localHashMap, this.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscReportData
 * JD-Core Version:    0.7.0.1
 */