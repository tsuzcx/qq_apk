package com.tencent.mobileqq.search.fragment;

import awkc;
import awlm;
import awus;
import awuu;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int a()
  {
    return 40;
  }
  
  protected awkc a()
  {
    return new awlm(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxk);
  }
  
  protected awus a()
  {
    return new awuu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return getString(2131719079);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Awus.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Awus.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */