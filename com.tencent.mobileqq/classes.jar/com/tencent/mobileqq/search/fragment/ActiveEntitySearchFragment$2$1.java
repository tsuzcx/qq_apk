package com.tencent.mobileqq.search.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActiveEntitySearchFragment$2$1
  implements View.OnClickListener
{
  ActiveEntitySearchFragment$2$1(ActiveEntitySearchFragment.2 param2, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment$2.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment$2.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment.2.1
 * JD-Core Version:    0.7.0.1
 */