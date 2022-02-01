package com.tencent.mobileqq.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;

public class ReportTask
{
  protected int a;
  protected String a;
  protected List<String> a;
  protected AppRuntime a;
  protected int b;
  protected String b;
  protected int c;
  protected String c;
  protected String d = "";
  protected String e = "";
  
  public ReportTask(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0))
    {
      while (this.jdField_a_of_type_JavaUtilList.size() < 4) {
        this.jdField_a_of_type_JavaUtilList.add("");
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.e, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, (String)this.jdField_a_of_type_JavaUtilList.get(0), (String)this.jdField_a_of_type_JavaUtilList.get(1), (String)this.jdField_a_of_type_JavaUtilList.get(2), (String)this.jdField_a_of_type_JavaUtilList.get(3));
      return;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.e, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportTask
 * JD-Core Version:    0.7.0.1
 */