package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.utils.UFTTroopReportItem;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTTroopReportData
  extends UFTTroopReportItem
{
  protected final AppRuntime a;
  
  public UFTTroopReportData(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.a = paramAppRuntime;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 404) {
      return 303;
    }
    int i = paramInt2 - 400;
    if ((i >= 0) && (i < 100)) {
      return 304;
    }
    paramInt2 -= 500;
    if ((paramInt2 >= 0) && (paramInt2 < 100)) {
      return 305;
    }
    if (paramInt1 == 9024) {
      return 303;
    }
    if (paramInt1 == 9060) {
      return 304;
    }
    if (paramInt1 == 9061) {
      return 305;
    }
    if ((paramInt1 != 9052) && (paramInt1 != 9055) && (paramInt1 != 9053) && (paramInt1 != 9054)) {
      return paramInt1;
    }
    return 307;
  }
  
  private void a(String paramString)
  {
    if ((this.r != null) && (this.r.length() > 0))
    {
      if (this.r.indexOf("Network is unreachable") > 0) {}
      while ((this.r.indexOf("No route to host") > 0) || (this.r.indexOf("MalformedURLException") > 0))
      {
        i = 1;
        break;
      }
    }
    int i = 0;
    if ((!UFTDependFeatureApi.c()) || (i != 0))
    {
      this.l = 9;
      this.m = 901;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("NotNetWork_");
      ((StringBuilder)localObject1).append(this.r);
      this.r = ((StringBuilder)localObject1).toString();
    }
    if (!this.a.isLogin())
    {
      this.l = 9;
      this.m = 901;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("NotLogin_");
      ((StringBuilder)localObject1).append(this.r);
      this.r = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = UFTDependFeatureApi.b();
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_group_code", this.z);
    ((HashMap)localObject1).put("param_self_uin", this.A);
    ((HashMap)localObject1).put("param_file_name", this.B);
    ((HashMap)localObject1).put("param_suffix", UFTDependFeatureApi.f(this.B));
    ((HashMap)localObject1).put("param_file_size", String.valueOf(this.C));
    ((HashMap)localObject1).put("param_uuid", this.E);
    ((HashMap)localObject1).put("param_store_type", String.valueOf(this.D));
    ((HashMap)localObject1).put("param_result", String.valueOf(this.l));
    ((HashMap)localObject1).put("param_sub_reason", String.valueOf(this.m));
    ((HashMap)localObject1).put("param_http_status_code", String.valueOf(this.n));
    ((HashMap)localObject1).put("param_server_return_code", String.valueOf(this.o));
    ((HashMap)localObject1).put("param_err_msg", this.r);
    ((HashMap)localObject1).put("param_retry_count", String.valueOf(this.y));
    ((HashMap)localObject1).put("param_proxy_type", String.valueOf(this.e));
    ((HashMap)localObject1).put("param_net_type", localObject2);
    ((HashMap)localObject1).put("param_security_time", String.valueOf(this.p));
    ((HashMap)localObject1).put("param_check_time", String.valueOf(this.q));
    ((HashMap)localObject1).put("param_server_ip", String.valueOf(this.c));
    ((HashMap)localObject1).put("param_server_port", String.valueOf(this.d));
    ((HashMap)localObject1).put("param_file_url", this.b);
    ((HashMap)localObject1).put("param_start_size", String.valueOf(this.f));
    ((HashMap)localObject1).put("param_transfer_size", String.valueOf(this.g));
    ((HashMap)localObject1).put("param_transfer_time", String.valueOf(this.h));
    ((HashMap)localObject1).put("param_transfer_speed", String.valueOf(this.j));
    ((HashMap)localObject1).put("param_fromType", String.valueOf(this.u));
    ((HashMap)localObject1).put("param_V6SelectType", String.valueOf(this.v));
    ((HashMap)localObject1).put("param_ipAddrType", String.valueOf(this.w));
    ((HashMap)localObject1).put("param_stackType", String.valueOf(UFTDependFeatureApi.h()));
    ((HashMap)localObject1).put("param_loginType", String.valueOf(UFTDependFeatureApi.i()));
    ((HashMap)localObject1).put("param_ishttps", String.valueOf(this.x));
    long l3 = this.i;
    long l2 = System.currentTimeMillis();
    long l1 = l3;
    if (l3 == 0L) {
      l1 = l2;
    }
    if (l1 < 1L) {
      l1 = 0L;
    } else {
      l1 = l2 - l1;
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">>> Troop_Fail_DR:actType[");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("] ");
    ((StringBuilder)localObject2).append(((HashMap)localObject1).toString());
    UFTLog.d("[UFTTransfer] UFTToopReportData", 1, ((StringBuilder)localObject2).toString());
    UFTDependFeatureApi.a(this.A, paramString, false, l1, 1, (HashMap)localObject1, "");
  }
  
  private void b(String paramString)
  {
    Object localObject = UFTDependFeatureApi.b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", this.z);
    localHashMap.put("param_self_uin", this.A);
    localHashMap.put("param_file_name", this.B);
    localHashMap.put("param_suffix", UFTDependFeatureApi.f(this.B));
    localHashMap.put("param_file_size", String.valueOf(this.C));
    localHashMap.put("param_uuid", this.E);
    localHashMap.put("param_store_type", String.valueOf(this.D));
    localHashMap.put("param_result", String.valueOf(0));
    localHashMap.put("param_sub_reason", String.valueOf(0));
    localHashMap.put("param_http_status_code", String.valueOf(this.n));
    localHashMap.put("param_err_msg", "");
    localHashMap.put("param_flash_transfer", String.valueOf(this.k));
    localHashMap.put("param_retry_count", String.valueOf(this.y));
    localHashMap.put("param_proxy_type", String.valueOf(this.e));
    localHashMap.put("param_net_type", localObject);
    localHashMap.put("param_security_time", String.valueOf(this.p));
    localHashMap.put("param_check_time", String.valueOf(this.q));
    localHashMap.put("param_server_ip", String.valueOf(this.c));
    localHashMap.put("param_server_port", String.valueOf(this.d));
    localHashMap.put("param_file_url", this.b);
    localHashMap.put("param_start_size", String.valueOf(this.f));
    localHashMap.put("param_transfer_size", String.valueOf(this.g));
    localHashMap.put("param_transfer_time", String.valueOf(this.h));
    localHashMap.put("param_transfer_speed", String.valueOf(this.j));
    localHashMap.put("param_fromType", String.valueOf(this.u));
    localHashMap.put("param_V6SelectType", String.valueOf(this.v));
    localHashMap.put("param_ipAddrType", String.valueOf(this.w));
    localHashMap.put("param_stackType", String.valueOf(UFTDependFeatureApi.h()));
    localHashMap.put("param_loginType", String.valueOf(UFTDependFeatureApi.i()));
    localHashMap.put("param_ishttps", String.valueOf(this.x));
    long l4 = this.i;
    long l3 = System.currentTimeMillis();
    long l2 = 0L;
    long l1 = l4;
    if (l4 == 0L) {
      l1 = l3;
    }
    if (l1 < 1L) {
      l1 = 0L;
    } else {
      l1 = l3 - l1;
    }
    if (l1 < 0L) {
      l1 = l2;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">>> Troop_Suc_DR:actType[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("] ");
    ((StringBuilder)localObject).append(localHashMap.toString());
    UFTLog.b("[UFTTransfer] UFTToopReportData", 1, ((StringBuilder)localObject).toString());
    UFTDependFeatureApi.a(this.A, paramString, true, l1, 1, localHashMap, "");
  }
  
  public void a()
  {
    a("actGroupFileUp");
  }
  
  public void b()
  {
    a("actGroupFileUpDetail");
  }
  
  public void c()
  {
    b("actGroupFileUp");
  }
  
  public void d()
  {
    b("actGroupFileUpDetail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopReportData
 * JD-Core Version:    0.7.0.1
 */