package com.tencent.mobileqq.search.fragment;

import alud;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import ayjn;
import aykz;
import ayla;
import aytg;
import ayug;
import ayvm;
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
  
  protected ayjn a()
  {
    return new ayla(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bdbb);
  }
  
  protected ayug a()
  {
    return new aytg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, this.jdField_a_of_type_Int, null);
  }
  
  protected String a()
  {
    return alud.a(2131714124);
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if ((!ayvm.a(this.b)) && (this.jdField_a_of_type_AndroidViewView != null))
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838592);
  }
  
  protected boolean a()
  {
    return ayvm.a(this.b);
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
    if (!ayvm.a(this.b))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165409);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new aykz(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */