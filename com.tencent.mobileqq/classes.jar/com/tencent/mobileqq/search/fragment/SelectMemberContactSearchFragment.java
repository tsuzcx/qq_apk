package com.tencent.mobileqq.search.fragment;

import ajya;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import awke;
import awlq;
import awlr;
import awtu;
import awuu;
import awwa;
import com.tencent.widget.ListView;

public class SelectMemberContactSearchFragment
  extends BaseSearchFragment
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  protected int a()
  {
    return 20;
  }
  
  protected awke a()
  {
    return new awlr(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxy);
  }
  
  protected awuu a()
  {
    return new awtu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, this.jdField_a_of_type_Int, null);
  }
  
  protected String a()
  {
    return ajya.a(2131713740);
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if ((!awwa.a(this.b)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165374);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838514);
  }
  
  protected boolean a()
  {
    return awwa.a(this.b);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_Int = localBundle.getInt("contactSearchSource", 197437);
      this.b = localBundle.getInt("fromType", -1);
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!awwa.a(this.b))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165374);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new awlq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */