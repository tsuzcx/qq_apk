package com.tencent.mobileqq.search.base.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportTask
{
  protected int a;
  protected AppInterface a;
  protected String a;
  protected List<String> a;
  protected int b;
  protected String b;
  protected int c;
  protected String c;
  protected String d = "";
  protected String e = "";
  
  public ReportTask(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
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
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.e, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, (String)this.jdField_a_of_type_JavaUtilList.get(0), (String)this.jdField_a_of_type_JavaUtilList.get(1), (String)this.jdField_a_of_type_JavaUtilList.get(2), (String)this.jdField_a_of_type_JavaUtilList.get(3));
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.e, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, "", "", "", "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.ReportTask
 * JD-Core Version:    0.7.0.1
 */