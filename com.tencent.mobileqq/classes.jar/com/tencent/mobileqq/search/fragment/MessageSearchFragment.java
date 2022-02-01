package com.tencent.mobileqq.search.fragment;

import bcbc;
import bccm;
import bclw;
import bcly;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int a()
  {
    return 40;
  }
  
  protected bcbc a()
  {
    return new bccm(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
  }
  
  protected bclw a()
  {
    return new bcly(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return getString(2131718374);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Bclw.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bclw.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */