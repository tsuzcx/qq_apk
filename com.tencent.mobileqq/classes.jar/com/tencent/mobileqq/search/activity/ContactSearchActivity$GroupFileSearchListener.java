package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.view.View;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;

public class ContactSearchActivity$GroupFileSearchListener
  implements ContactSearchResultPresenter.OnActionListener
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public ContactSearchActivity$GroupFileSearchListener(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(View paramView) {}
  
  public void a(String paramString1, String paramString2)
  {
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_AndroidAppActivity, AVUtil.a(paramString2), paramString1, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, 2020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchActivity.GroupFileSearchListener
 * JD-Core Version:    0.7.0.1
 */