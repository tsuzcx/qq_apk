package com.tencent.mobileqq.search.fragment;

import ayfe;
import aygo;
import aypx;
import aypz;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int a()
  {
    return 40;
  }
  
  protected ayfe a()
  {
    return new aygo(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bcws);
  }
  
  protected aypx a()
  {
    return new aypz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return getString(2131719570);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Aypx.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Aypx.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */