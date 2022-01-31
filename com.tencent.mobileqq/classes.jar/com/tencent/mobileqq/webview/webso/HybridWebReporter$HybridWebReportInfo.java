package com.tencent.mobileqq.webview.webso;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class HybridWebReporter$HybridWebReportInfo
{
  public int a;
  public long a;
  public String a;
  private AtomicInteger a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = NetworkState.getAPN();
  public String k = "QQ";
  public String l = QUA.a();
  public String m = "Android";
  
  public HybridWebReporter$HybridWebReportInfo()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public JSONObject a()
  {
    label387:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", this.jdField_a_of_type_Long);
        String str = this.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          int i1 = this.jdField_a_of_type_JavaLangString.indexOf('?');
          n = i1;
          if (i1 < 0) {
            n = this.jdField_a_of_type_JavaLangString.length();
          }
          str = this.jdField_a_of_type_JavaLangString.substring(0, n);
        }
        localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("path", str);
        localJSONObject.put("errordomain", this.jdField_b_of_type_JavaLangString);
        localJSONObject.put("errorcode", this.jdField_c_of_type_JavaLangString);
        localJSONObject.put("httpstatus", this.jdField_d_of_type_JavaLangString);
        localJSONObject.put("userip", this.jdField_e_of_type_JavaLangString);
        localJSONObject.put("serverip", this.f);
        localJSONObject.put("port", this.g);
        localJSONObject.put("dnsresult", this.h);
        localJSONObject.put("apn", this.j);
        localJSONObject.put("timecost", this.jdField_a_of_type_Int / 1000.0F);
        localJSONObject.put("app", this.k);
        localJSONObject.put("appversion", this.l);
        localJSONObject.put("platform", this.m);
        localJSONObject.put("sampling", this.jdField_e_of_type_Int);
        localJSONObject.put("usewns", this.jdField_a_of_type_Boolean);
        int n = this.jdField_b_of_type_Int;
        if (n != 1000) {
          if (n == 0)
          {
            break label387;
            localJSONObject.put("wnscode", n);
            localJSONObject.put("detail", this.i);
            localJSONObject.put("usecache", this.jdField_b_of_type_Boolean);
            localJSONObject.put("cachehasdata", this.jdField_c_of_type_Boolean);
            localJSONObject.put("cacheupdatepolicy", this.jdField_c_of_type_Int);
            localJSONObject.put("cacheupdatetimecost", this.jdField_d_of_type_Int / 1000.0F);
            return localJSONObject;
          }
          else
          {
            n = this.jdField_b_of_type_Int;
            n += 300000;
            continue;
          }
        }
        n = 0;
      }
      catch (Exception localException)
      {
        QLog.e("HybridWebReporter", 1, localException, new Object[0]);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter.HybridWebReportInfo
 * JD-Core Version:    0.7.0.1
 */