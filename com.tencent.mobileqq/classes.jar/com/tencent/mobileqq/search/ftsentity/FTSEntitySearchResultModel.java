package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import java.util.ArrayList;
import java.util.List;

public abstract class FTSEntitySearchResultModel
  extends ISearchResultPositionModel
{
  public int a;
  public QQAppInterface a;
  public CharSequence a;
  public String a;
  public ArrayList a;
  public List a;
  public int b;
  public CharSequence b;
  public String b;
  public int c = -1;
  public CharSequence c;
  public int d = -1;
  public CharSequence d;
  
  public FTSEntitySearchResultModel(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList paramArrayList, List paramList)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public abstract CharSequence e();
  
  public abstract CharSequence f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel
 * JD-Core Version:    0.7.0.1
 */