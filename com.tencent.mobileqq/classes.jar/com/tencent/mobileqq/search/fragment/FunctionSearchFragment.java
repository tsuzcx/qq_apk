package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.View;
import bbzo;
import bcbi;
import bccm;
import bccn;
import bcmc;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FunctionSearchEngine;

public class FunctionSearchFragment
  extends BaseSearchFragment
{
  public static FunctionSearchFragment a()
  {
    return new FunctionSearchFragment();
  }
  
  protected int a()
  {
    return 120;
  }
  
  protected bcbi a()
  {
    return new bccn(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Aoof);
  }
  
  protected bcmc a()
  {
    return new FunctionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1);
  }
  
  protected String a()
  {
    return bbzo.a();
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new bccm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.FunctionSearchFragment
 * JD-Core Version:    0.7.0.1
 */