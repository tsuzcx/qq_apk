package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;

public class WebSoCgiService$WebSoCgiState
{
  public int a;
  public long a;
  public Handler a;
  public HybridWebReporter.HybridWebReportInfo a;
  public Object a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public volatile String d = null;
  public String e;
  public String f = "";
  
  public WebSoCgiService$WebSoCgiState()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unikey=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",url=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" ,header=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",htmlbody len=");
    int i;
    if (TextUtils.isEmpty(this.d)) {
      i = 0;
    } else {
      i = this.d.length();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",reqState=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",httpStatusCode=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",needBase64Rsp=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",jsCallback=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",resultCode=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",errorMsg=");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState
 * JD-Core Version:    0.7.0.1
 */