package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.View;
import awil;
import awkc;
import awle;
import awlf;
import awus;
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
  
  protected awkc a()
  {
    return new awlf(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxk);
  }
  
  protected awus a()
  {
    return new FunctionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1);
  }
  
  protected String a()
  {
    return awil.a();
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new awle(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.FunctionSearchFragment
 * JD-Core Version:    0.7.0.1
 */