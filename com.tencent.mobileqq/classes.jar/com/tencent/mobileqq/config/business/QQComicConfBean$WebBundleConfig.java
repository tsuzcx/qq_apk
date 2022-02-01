package com.tencent.mobileqq.config.business;

import android.text.TextUtils;

public class QQComicConfBean$WebBundleConfig
{
  public String a;
  public boolean a;
  
  public QQComicConfBean$WebBundleConfig(QQComicConfBean paramQQComicConfBean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
  }
  
  public String toString()
  {
    return "WebBundleConfig{enable=" + this.jdField_a_of_type_Boolean + ", preloadUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQComicConfBean.WebBundleConfig
 * JD-Core Version:    0.7.0.1
 */