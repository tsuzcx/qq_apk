package com.tencent.mobileqq.webview.webso;

public class WebSoCgiService$CgiReqInfo
{
  public int a;
  public Object a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ,method=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ,jsonHeader=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ,body=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ,");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ,rspBase64=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ,timeout=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ,userInfo=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoCgiService.CgiReqInfo
 * JD-Core Version:    0.7.0.1
 */