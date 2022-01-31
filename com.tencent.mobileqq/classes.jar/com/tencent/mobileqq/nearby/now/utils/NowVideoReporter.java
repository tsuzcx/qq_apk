package com.tencent.mobileqq.nearby.now.utils;

import android.content.SharedPreferences;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.statistics.ReportController;

public class NowVideoReporter
{
  public static int a;
  public static long a;
  public static String a;
  public static String b;
  public static String c;
  boolean a;
  protected int b;
  boolean b;
  protected int c;
  protected int d;
  protected String d;
  protected String e = "";
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  protected String l = "";
  protected String m = "";
  protected String n = "";
  protected String o = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
  }
  
  public NowVideoReporter()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public NowVideoReporter a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public NowVideoReporter a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.l = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
    }
    if (this.jdField_b_of_type_Boolean) {
      this.l = ("" + NearbySPUtil.a(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
    }
    long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
    if (l1 % 1000L > 500L) {}
    for (l1 = (int)l1 / 1000 + 1;; l1 = (int)l1 / 1000)
    {
      this.jdField_d_of_type_JavaLangString = (l1 + "");
      this.e = jdField_c_of_type_JavaLangString;
      this.f = jdField_b_of_type_JavaLangString;
      this.g = jdField_a_of_type_JavaLangString;
      this.h = (HttpUtil.a() + "");
      ReportController.b(paramQQAppInterface, "dc02676", "grp_lbs", this.k, this.i, this.j, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.l, this.m, this.n, this.o + "|" + this.jdField_d_of_type_JavaLangString + "|" + this.e + "|" + this.f + "|" + this.g + "|" + this.h);
      return;
    }
  }
  
  public NowVideoReporter b()
  {
    this.jdField_b_of_type_Boolean = true;
    return this;
  }
  
  public NowVideoReporter b(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramQQAppInterface != null)) {
      this.l = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
    }
    if ((this.jdField_b_of_type_Boolean) && (paramQQAppInterface != null))
    {
      this.jdField_b_of_type_Boolean = true;
      this.l = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("gender", 0));
    }
    this.h = (HttpUtil.a() + "");
    ReportController.b(paramQQAppInterface, "dc02676", "grp_lbs", this.k, this.i, this.j, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.l, this.m, this.n, this.o + "|" + this.jdField_d_of_type_JavaLangString + "|" + this.e + "|" + this.f + "|" + this.g + "|" + this.h);
  }
  
  public NowVideoReporter c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public NowVideoReporter d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public NowVideoReporter e(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public NowVideoReporter f(String paramString)
  {
    this.m = paramString;
    return this;
  }
  
  public NowVideoReporter g(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public NowVideoReporter h(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public NowVideoReporter i(String paramString)
  {
    this.j = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.NowVideoReporter
 * JD-Core Version:    0.7.0.1
 */