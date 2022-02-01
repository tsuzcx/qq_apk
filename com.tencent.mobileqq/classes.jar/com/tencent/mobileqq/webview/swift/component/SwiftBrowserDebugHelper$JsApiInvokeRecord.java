package com.tencent.mobileqq.webview.swift.component;

import java.text.SimpleDateFormat;
import java.util.Date;

class SwiftBrowserDebugHelper$JsApiInvokeRecord
{
  public long a;
  public String a;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Date localDate = new Date(this.jdField_a_of_type_Long);
    localStringBuilder.append(new SimpleDateFormat("HH:mm:ss").format(localDate));
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".");
    localStringBuilder.append(this.b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserDebugHelper.JsApiInvokeRecord
 * JD-Core Version:    0.7.0.1
 */