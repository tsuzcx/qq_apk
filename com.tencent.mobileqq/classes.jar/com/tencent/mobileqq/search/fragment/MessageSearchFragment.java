package com.tencent.mobileqq.search.fragment;

import ayjn;
import aykx;
import ayug;
import ayui;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int a()
  {
    return 40;
  }
  
  protected ayjn a()
  {
    return new aykx(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bdbb);
  }
  
  protected ayug a()
  {
    return new ayui(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return getString(2131719582);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Ayug.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Ayug.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */