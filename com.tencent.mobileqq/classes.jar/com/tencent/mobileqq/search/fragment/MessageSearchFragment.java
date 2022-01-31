package com.tencent.mobileqq.search.fragment;

import awke;
import awlo;
import awuu;
import awuw;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int a()
  {
    return 40;
  }
  
  protected awke a()
  {
    return new awlo(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxy);
  }
  
  protected awuu a()
  {
    return new awuw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return getString(2131719090);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Awuu.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Awuu.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */