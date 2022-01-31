package com.tencent.mobileqq.webview.webso;

import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class WebSoCgiService$WebSoCgiState
{
  public int a;
  public long a;
  public HybridWebReporter.HybridWebReportInfo a;
  public Object a;
  public String a;
  public WeakReference a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public volatile String d;
  public String e;
  public String f = "";
  
  public WebSoCgiService$WebSoCgiState()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("unikey=").append(this.jdField_a_of_type_JavaLangString).append(",url=").append(this.jdField_b_of_type_JavaLangString).append(" ,header=").append(this.jdField_c_of_type_JavaLangString).append(",htmlbody len=");
    if (TextUtils.isEmpty(this.d)) {}
    for (int i = 0;; i = this.d.length()) {
      return i + ",reqState=" + this.jdField_a_of_type_Int + ",httpStatusCode=" + this.jdField_b_of_type_Int + ",needBase64Rsp=" + this.jdField_a_of_type_Boolean + ",jsCallback=" + this.e + ",resultCode=" + this.jdField_c_of_type_Int + ",errorMsg=" + this.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState
 * JD-Core Version:    0.7.0.1
 */