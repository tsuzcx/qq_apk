package com.tencent.mobileqq.search.fragment;

import bcbi;
import bccu;
import bcmc;
import bcme;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int a()
  {
    return 40;
  }
  
  protected bcbi a()
  {
    return new bccu(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Aoof);
  }
  
  protected bcmc a()
  {
    return new bcme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return getString(2131717751);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Bcmc.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bcmc.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */