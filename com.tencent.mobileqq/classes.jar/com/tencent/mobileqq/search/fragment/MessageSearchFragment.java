package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int a()
  {
    return 40;
  }
  
  protected BaseMvpAdapter a()
  {
    return new MessageSearchFragment.1(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    return new MessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return getString(2131718893);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */