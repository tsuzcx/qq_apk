package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTDiscReportData
{
  public int a;
  public long a;
  public String a;
  private final AppRuntime a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  private final String g;
  public long h;
  private final String h;
  public long i;
  private final String i;
  public long j;
  
  public UFTDiscReportData(AppRuntime paramAppRuntime, String paramString)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_i_of_type_JavaLangString = paramString;
    this.jdField_g_of_type_JavaLangString = "actDiscussFileUp";
    this.jdField_h_of_type_JavaLangString = "actDiscussFileUpDetail";
  }
  
  private HashMap<String, String> a()
  {
    try
    {
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
        str = this.jdField_b_of_type_JavaLangString.substring(this.jdField_b_of_type_JavaLangString.indexOf("://") + 3, this.jdField_b_of_type_JavaLangString.lastIndexOf(":"));
      } else {
        str = null;
      }
    }
    catch (Exception localException)
    {
      String str;
      label53:
      boolean bool;
      int k;
      Object localObject;
      break label53;
    }
    str = this.jdField_b_of_type_JavaLangString;
    if (this.jdField_a_of_type_Long != 0L)
    {
      bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
      k = 1;
      if ((!bool) || ((this.jdField_a_of_type_JavaLangString.indexOf("Network is unreachable") <= 0) && (this.jdField_a_of_type_JavaLangString.indexOf("No route to host") <= 0) && (this.jdField_a_of_type_JavaLangString.indexOf("MalformedURLException") <= 0))) {
        k = 0;
      }
      if ((!UFTDependFeatureApi.a()) || (k != 0))
      {
        this.jdField_a_of_type_Long = 9004L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NotNetWork_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      }
      localObject = this.jdField_a_of_type_MqqAppAppRuntime;
      if ((localObject != null) && (!((AppRuntime)localObject).isLogin()))
      {
        this.jdField_a_of_type_Long = 9004L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NotLogin_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      }
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_serverip", String.valueOf(str));
    ((HashMap)localObject).put("param_Server", String.valueOf(str));
    ((HashMap)localObject).put("param_PeerUin", String.valueOf(this.jdField_c_of_type_JavaLangString));
    ((HashMap)localObject).put("param_PeerType", String.valueOf(this.jdField_a_of_type_Int));
    ((HashMap)localObject).put("param_uuid", String.valueOf(this.jdField_d_of_type_JavaLangString));
    ((HashMap)localObject).put("param_FailCode", Long.toString(this.jdField_a_of_type_Long));
    ((HashMap)localObject).put("param_fsized", String.valueOf(this.jdField_h_of_type_Long));
    ((HashMap)localObject).put("param_fsizeo", String.valueOf(this.j));
    ((HashMap)localObject).put("param_url", String.valueOf(this.jdField_b_of_type_JavaLangString));
    ((HashMap)localObject).put("param_rspHeader", String.valueOf(this.jdField_e_of_type_JavaLangString));
    ((HashMap)localObject).put("param_retry", String.valueOf(this.jdField_b_of_type_Int));
    ((HashMap)localObject).put("param_errMsg", String.valueOf(this.jdField_a_of_type_JavaLangString));
    ((HashMap)localObject).put("param_nSessionId", String.valueOf(this.jdField_b_of_type_Long));
    ((HashMap)localObject).put("param_CSDuration", String.valueOf(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long));
    ((HashMap)localObject).put("param_HttpDuration", String.valueOf(this.jdField_f_of_type_Long - this.jdField_e_of_type_Long));
    ((HashMap)localObject).put("param_AllDuration", String.valueOf(this.jdField_g_of_type_Long - this.jdField_c_of_type_Long));
    return localObject;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis() - this.jdField_f_of_type_Long;
    if (l < 0L) {
      l = 0L;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject).append("] >>> Disc_Fail_DR:actType[");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_JavaLangString);
    ((StringBuilder)localObject).append("]");
    if (localHashMap != null) {
      str = localHashMap.toString();
    } else {
      str = "null";
    }
    ((StringBuilder)localObject).append(str);
    UFTLog.d("[UFTTransfer] UFTDiscReportData", 1, ((StringBuilder)localObject).toString());
    String str = this.jdField_i_of_type_JavaLangString;
    localObject = this.jdField_h_of_type_JavaLangString;
    boolean bool;
    if (this.jdField_a_of_type_Long == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    UFTDependFeatureApi.a(str, (String)localObject, bool, l, this.jdField_i_of_type_Long, localHashMap, this.jdField_f_of_type_JavaLangString);
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis() - this.jdField_f_of_type_Long;
    if (l1 < 0L) {
      l1 = 0L;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    long l2 = this.jdField_a_of_type_Long;
    String str = "null";
    if (l2 == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append("] >>> Disc_Suc_DR:actType[");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_JavaLangString);
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
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append("] >>> Disc_Fail_DR:actType[");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_JavaLangString);
      ((StringBuilder)localObject).append("]");
      if (localHashMap != null) {
        str = localHashMap.toString();
      }
      ((StringBuilder)localObject).append(str);
      UFTLog.d("[UFTTransfer] UFTDiscReportData", 1, ((StringBuilder)localObject).toString());
    }
    str = this.jdField_i_of_type_JavaLangString;
    Object localObject = this.jdField_g_of_type_JavaLangString;
    boolean bool;
    if (this.jdField_a_of_type_Long == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    UFTDependFeatureApi.a(str, (String)localObject, bool, l1, this.jdField_i_of_type_Long, localHashMap, this.jdField_f_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscReportData
 * JD-Core Version:    0.7.0.1
 */