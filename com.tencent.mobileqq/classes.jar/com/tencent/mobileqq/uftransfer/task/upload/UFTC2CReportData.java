package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTC2CReportData
{
  protected final int a;
  protected final long a;
  protected final String a;
  protected final AppRuntime a;
  public boolean a;
  public int b;
  protected final long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g;
  public long h;
  public String h;
  public String i;
  
  public UFTC2CReportData(AppRuntime paramAppRuntime, long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    this.jdField_c_of_type_Long = 1L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_e_of_type_Long == 0L) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    long l;
    if (System.currentTimeMillis() > this.jdField_e_of_type_Long) {
      l = System.currentTimeMillis() - this.jdField_e_of_type_Long;
    } else {
      l = 10L;
    }
    try
    {
      if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0)) {
        localObject1 = this.jdField_d_of_type_JavaLangString.substring(this.jdField_d_of_type_JavaLangString.indexOf("://") + 3, this.jdField_d_of_type_JavaLangString.lastIndexOf(":"));
      } else {
        localObject1 = "";
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label101:
      Object localObject2;
      int j;
      int k;
      break label101;
    }
    localObject1 = this.jdField_d_of_type_JavaLangString;
    localObject2 = this.jdField_g_of_type_JavaLangString;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      if (this.jdField_g_of_type_JavaLangString.indexOf("Network is unreachable") > 0) {}
      while ((this.jdField_g_of_type_JavaLangString.indexOf("No route to host") > 0) || (this.jdField_g_of_type_JavaLangString.indexOf("MalformedURLException") > 0))
      {
        j = 1;
        break;
      }
    }
    j = 0;
    if ((!UFTDependFeatureApi.a()) || (j != 0))
    {
      this.jdField_h_of_type_Long = 9004L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("NotNetWork_");
      ((StringBuilder)localObject2).append(this.jdField_g_of_type_JavaLangString);
      this.jdField_g_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    if (!this.jdField_a_of_type_MqqAppAppRuntime.isLogin())
    {
      this.jdField_h_of_type_Long = 9004L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("NotLogin_");
      ((StringBuilder)localObject2).append(this.jdField_g_of_type_JavaLangString);
      this.jdField_g_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("serverip", localObject1);
    ((HashMap)localObject2).put("param_Server", localObject1);
    ((HashMap)localObject2).put("param_ftnIP", localObject1);
    ((HashMap)localObject2).put("param_PeerUin", String.valueOf(this.jdField_a_of_type_JavaLangString));
    ((HashMap)localObject2).put("param_uuid", String.valueOf(this.jdField_b_of_type_JavaLangString));
    ((HashMap)localObject2).put("param_MD5", this.jdField_c_of_type_JavaLangString);
    ((HashMap)localObject2).put("param_FailCode", Long.toString(this.jdField_h_of_type_Long));
    ((HashMap)localObject2).put("param_errorDesc", String.valueOf(this.jdField_f_of_type_JavaLangString));
    ((HashMap)localObject2).put("param_fsized", String.valueOf(this.jdField_d_of_type_Long));
    ((HashMap)localObject2).put("param_fsizeo", String.valueOf(this.jdField_b_of_type_Long));
    ((HashMap)localObject2).put("param_url", String.valueOf(this.i));
    ((HashMap)localObject2).put("param_rspHeader", String.valueOf(this.jdField_h_of_type_JavaLangString));
    ((HashMap)localObject2).put("param_retry", String.valueOf(this.jdField_b_of_type_Int));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_g_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("uin[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    ((StringBuilder)localObject1).append("]");
    ((HashMap)localObject2).put("param_errMsg", ((StringBuilder)localObject1).toString());
    ((HashMap)localObject2).put("param_nSessionId", String.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject2).put("param_ipStackType", String.valueOf(UFTDependFeatureApi.c()));
    ((HashMap)localObject2).put("param_realTransferType", String.valueOf(0));
    ((HashMap)localObject2).put("param_transferdsize", String.valueOf(this.jdField_c_of_type_Long));
    ((HashMap)localObject2).put("param_transferTime", String.valueOf(this.jdField_f_of_type_Long));
    ((HashMap)localObject2).put("param_speed", String.valueOf(this.jdField_g_of_type_Long));
    j = UFTDependFeatureApi.d();
    k = UFTDependFeatureApi.e();
    ((HashMap)localObject2).put("param_fromType", String.valueOf(this.jdField_a_of_type_Int));
    ((HashMap)localObject2).put("param_V6SelectType", String.valueOf(this.jdField_c_of_type_Int));
    ((HashMap)localObject2).put("param_ipAddrType", String.valueOf(this.jdField_d_of_type_Int));
    ((HashMap)localObject2).put("param_stackType", String.valueOf(j));
    ((HashMap)localObject2).put("param_loginType", String.valueOf(k));
    ((HashMap)localObject2).put("param_ishttps", String.valueOf(this.jdField_a_of_type_Boolean));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Id[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject1).append("] >>> C2C_Fail_DR:actType[");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("] ");
    ((StringBuilder)localObject1).append(((HashMap)localObject2).toString());
    UFTLog.d("[UFTTransfer] UFTC2CReportData", 1, ((StringBuilder)localObject1).toString());
    UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), paramString, false, l, this.jdField_c_of_type_Long, (HashMap)localObject2, this.jdField_e_of_type_JavaLangString);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_e_of_type_Long == 0L) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    long l;
    if (System.currentTimeMillis() > this.jdField_e_of_type_Long) {
      l = System.currentTimeMillis() - this.jdField_e_of_type_Long;
    } else {
      l = 10L;
    }
    try
    {
      if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0)) {
        localObject = this.jdField_d_of_type_JavaLangString.substring(this.jdField_d_of_type_JavaLangString.indexOf("://") + 3, this.jdField_d_of_type_JavaLangString.lastIndexOf(":"));
      } else {
        localObject = "";
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label101:
      HashMap localHashMap;
      int j;
      int k;
      break label101;
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    localHashMap = new HashMap();
    localHashMap.put("serverip", localObject);
    localHashMap.put("param_Server", localObject);
    localHashMap.put("param_ftnIP", localObject);
    localHashMap.put("param_PeerUin", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_uuid", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_MD5", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("param_fsized", String.valueOf(this.jdField_d_of_type_Long));
    localHashMap.put("param_fsizeo", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_retry", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_nSessionId", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_errMsg", String.valueOf(this.jdField_e_of_type_JavaLangString));
    localHashMap.put("param_ipStackType", String.valueOf(UFTDependFeatureApi.c()));
    localHashMap.put("param_realTransferType", String.valueOf(0));
    localHashMap.put("param_transferdsize", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_httpTime", String.valueOf(this.jdField_f_of_type_Long));
    localHashMap.put("param_speed", String.valueOf(this.jdField_g_of_type_Long));
    j = UFTDependFeatureApi.d();
    k = UFTDependFeatureApi.e();
    localHashMap.put("param_fromType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("param_stackType", String.valueOf(j));
    localHashMap.put("param_loginType", String.valueOf(k));
    localHashMap.put("param_ishttps", String.valueOf(this.jdField_a_of_type_Boolean));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] >>> C2C_Suc_DR:actType[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    ((StringBuilder)localObject).append(localHashMap.toString());
    UFTLog.b("[UFTTransfer] UFTC2CReportData", 1, ((StringBuilder)localObject).toString());
    UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), paramString, true, l, this.jdField_c_of_type_Long, localHashMap, this.jdField_e_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CReportData
 * JD-Core Version:    0.7.0.1
 */