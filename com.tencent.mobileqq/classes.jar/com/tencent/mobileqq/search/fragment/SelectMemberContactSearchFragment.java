package com.tencent.mobileqq.search.fragment;

import ahtq;
import ahtr;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.widget.ListView;

public class SelectMemberContactSearchFragment
  extends BaseSearchFragment
{
  private int b;
  private int c;
  private boolean e;
  
  protected int a()
  {
    return 20;
  }
  
  protected BaseMvpAdapter a()
  {
    return new ahtr(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    return new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.b, null);
  }
  
  protected String a()
  {
    return "联系人";
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if ((!SearchUtils.a(this.c)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.e = false;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493241);
      }
    }
    else {
      return;
    }
    this.e = true;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838214);
  }
  
  protected boolean b()
  {
    return SearchUtils.a(this.c);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.b = localBundle.getInt("contactSearchSource", 197437);
      this.c = localBundle.getInt("fromType", -1);
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!SearchUtils.a(this.c))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131493241);
      this.e = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new ahtq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */