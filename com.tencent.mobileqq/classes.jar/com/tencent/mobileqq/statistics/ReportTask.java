package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportTask
{
  protected int a;
  protected QQAppInterface a;
  protected String a;
  protected List<String> a;
  protected int b;
  protected String b;
  protected int c;
  protected String c;
  protected String d = "";
  protected String e = "";
  
  public ReportTask(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public ReportTask a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public ReportTask a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ReportTask a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    }
    if (paramVarArgs != null) {
      Collections.addAll(this.jdField_a_of_type_JavaUtilList, paramVarArgs);
    }
    return this;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.e, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, "", "", "", "");
      return;
    }
    while (this.jdField_a_of_type_JavaUtilList.size() < 4) {
      this.jdField_a_of_type_JavaUtilList.add("");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.e, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, (String)this.jdField_a_of_type_JavaUtilList.get(0), (String)this.jdField_a_of_type_JavaUtilList.get(1), (String)this.jdField_a_of_type_JavaUtilList.get(2), (String)this.jdField_a_of_type_JavaUtilList.get(3));
  }
  
  public ReportTask b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ReportTask b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ReportTask c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ReportTask d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public ReportTask e(String paramString)
  {
    this.e = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportTask
 * JD-Core Version:    0.7.0.1
 */