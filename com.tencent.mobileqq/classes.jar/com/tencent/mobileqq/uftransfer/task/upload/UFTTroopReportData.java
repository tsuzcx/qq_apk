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
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
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
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
    {
      if (this.jdField_c_of_type_JavaLangString.indexOf("Network is unreachable") > 0) {}
      while ((this.jdField_c_of_type_JavaLangString.indexOf("No route to host") > 0) || (this.jdField_c_of_type_JavaLangString.indexOf("MalformedURLException") > 0))
      {
        i = 1;
        break;
      }
    }
    int i = 0;
    if ((!UFTDependFeatureApi.a()) || (i != 0))
    {
      this.jdField_c_of_type_Int = 9;
      this.jdField_d_of_type_Int = 901;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("NotNetWork_");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    }
    if (!this.jdField_a_of_type_MqqAppAppRuntime.isLogin())
    {
      this.jdField_c_of_type_Int = 9;
      this.jdField_d_of_type_Int = 901;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("NotLogin_");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = UFTDependFeatureApi.a();
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_group_code", this.jdField_e_of_type_JavaLangString);
    ((HashMap)localObject1).put("param_self_uin", this.jdField_f_of_type_JavaLangString);
    ((HashMap)localObject1).put("param_file_name", this.jdField_g_of_type_JavaLangString);
    ((HashMap)localObject1).put("param_suffix", UFTDependFeatureApi.b(this.jdField_g_of_type_JavaLangString));
    ((HashMap)localObject1).put("param_file_size", String.valueOf(this.jdField_i_of_type_Long));
    ((HashMap)localObject1).put("param_uuid", this.jdField_h_of_type_JavaLangString);
    ((HashMap)localObject1).put("param_store_type", String.valueOf(this.l));
    ((HashMap)localObject1).put("param_result", String.valueOf(this.jdField_c_of_type_Int));
    ((HashMap)localObject1).put("param_sub_reason", String.valueOf(this.jdField_d_of_type_Int));
    ((HashMap)localObject1).put("param_http_status_code", String.valueOf(this.jdField_e_of_type_Int));
    ((HashMap)localObject1).put("param_server_return_code", String.valueOf(this.jdField_f_of_type_Int));
    ((HashMap)localObject1).put("param_err_msg", this.jdField_c_of_type_JavaLangString);
    ((HashMap)localObject1).put("param_retry_count", String.valueOf(this.k));
    ((HashMap)localObject1).put("param_proxy_type", String.valueOf(this.jdField_b_of_type_Int));
    ((HashMap)localObject1).put("param_net_type", localObject2);
    ((HashMap)localObject1).put("param_security_time", String.valueOf(this.jdField_f_of_type_Long));
    ((HashMap)localObject1).put("param_check_time", String.valueOf(this.jdField_g_of_type_Long));
    ((HashMap)localObject1).put("param_server_ip", String.valueOf(this.jdField_b_of_type_JavaLangString));
    ((HashMap)localObject1).put("param_server_port", String.valueOf(this.jdField_a_of_type_Int));
    ((HashMap)localObject1).put("param_file_url", this.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject1).put("param_start_size", String.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject1).put("param_transfer_size", String.valueOf(this.jdField_b_of_type_Long));
    ((HashMap)localObject1).put("param_transfer_time", String.valueOf(this.jdField_c_of_type_Long));
    ((HashMap)localObject1).put("param_transfer_speed", String.valueOf(this.jdField_e_of_type_Long));
    ((HashMap)localObject1).put("param_fromType", String.valueOf(this.jdField_g_of_type_Int));
    ((HashMap)localObject1).put("param_V6SelectType", String.valueOf(this.jdField_h_of_type_Int));
    ((HashMap)localObject1).put("param_ipAddrType", String.valueOf(this.jdField_i_of_type_Int));
    ((HashMap)localObject1).put("param_stackType", String.valueOf(UFTDependFeatureApi.d()));
    ((HashMap)localObject1).put("param_loginType", String.valueOf(UFTDependFeatureApi.e()));
    ((HashMap)localObject1).put("param_ishttps", String.valueOf(this.j));
    long l3 = this.jdField_d_of_type_Long;
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
    UFTDependFeatureApi.a(this.jdField_f_of_type_JavaLangString, paramString, false, l1, 1, (HashMap)localObject1, "");
  }
  
  private void b(String paramString)
  {
    Object localObject = UFTDependFeatureApi.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", this.jdField_e_of_type_JavaLangString);
    localHashMap.put("param_self_uin", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("param_file_name", this.jdField_g_of_type_JavaLangString);
    localHashMap.put("param_suffix", UFTDependFeatureApi.b(this.jdField_g_of_type_JavaLangString));
    localHashMap.put("param_file_size", String.valueOf(this.jdField_i_of_type_Long));
    localHashMap.put("param_uuid", this.jdField_h_of_type_JavaLangString);
    localHashMap.put("param_store_type", String.valueOf(this.l));
    localHashMap.put("param_result", String.valueOf(0));
    localHashMap.put("param_sub_reason", String.valueOf(0));
    localHashMap.put("param_http_status_code", String.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("param_err_msg", "");
    localHashMap.put("param_flash_transfer", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("param_retry_count", String.valueOf(this.k));
    localHashMap.put("param_proxy_type", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_net_type", localObject);
    localHashMap.put("param_security_time", String.valueOf(this.jdField_f_of_type_Long));
    localHashMap.put("param_check_time", String.valueOf(this.jdField_g_of_type_Long));
    localHashMap.put("param_server_ip", String.valueOf(this.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_server_port", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_file_url", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_start_size", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_transfer_size", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_transfer_time", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_transfer_speed", String.valueOf(this.jdField_e_of_type_Long));
    localHashMap.put("param_fromType", String.valueOf(this.jdField_g_of_type_Int));
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_h_of_type_Int));
    localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_i_of_type_Int));
    localHashMap.put("param_stackType", String.valueOf(UFTDependFeatureApi.d()));
    localHashMap.put("param_loginType", String.valueOf(UFTDependFeatureApi.e()));
    localHashMap.put("param_ishttps", String.valueOf(this.j));
    long l4 = this.jdField_d_of_type_Long;
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
    UFTDependFeatureApi.a(this.jdField_f_of_type_JavaLangString, paramString, true, l1, 1, localHashMap, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopReportData
 * JD-Core Version:    0.7.0.1
 */