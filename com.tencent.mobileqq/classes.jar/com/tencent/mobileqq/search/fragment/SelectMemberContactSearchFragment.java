package com.tencent.mobileqq.search.fragment;

import alpo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import ayfe;
import aygq;
import aygr;
import ayox;
import aypx;
import ayrd;
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
  
  protected ayfe a()
  {
    return new aygr(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bcws);
  }
  
  protected aypx a()
  {
    return new ayox(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, this.jdField_a_of_type_Int, null);
  }
  
  protected String a()
  {
    return alpo.a(2131714112);
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if ((!ayrd.a(this.b)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165409);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838591);
  }
  
  protected boolean a()
  {
    return ayrd.a(this.b);
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
    if (!ayrd.a(this.b))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165409);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new aygq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */