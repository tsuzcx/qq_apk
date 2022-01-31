package com.tencent.mobileqq.search.ftsentity;

import ahtt;
import android.os.Bundle;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class FTSEntitySearchFragment
  extends BaseSearchFragment
{
  public static FTSEntitySearchFragment a(String paramString)
  {
    FTSEntitySearchFragment localFTSEntitySearchFragment = new FTSEntitySearchFragment();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("keyword", paramString);
    localFTSEntitySearchFragment.setArguments(localBundle);
    return localFTSEntitySearchFragment;
  }
  
  protected BaseMvpAdapter a()
  {
    return new ahtt(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseSearchActivity.a);
  }
  
  protected String a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return FTSEntitySearchUtils.a(localBaseSearchActivity, localBaseSearchActivity.a);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 1);
  }
  
  public void a(List paramList, int paramInt)
  {
    int i = 0;
    super.a(paramList, paramInt);
    String str;
    StringBuilder localStringBuilder;
    if (!this.jdField_a_of_type_Boolean)
    {
      str = "" + this.b;
      localStringBuilder = new StringBuilder().append("");
      if (paramList != null) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = paramList.size())
    {
      SearchUtils.a("talk", "exp_page", new String[] { str, paramInt });
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.b = getArguments().getString("keyword");
    }
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
  
  public void onStart()
  {
    super.onStart();
    ((FTSMessageSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((FTSMessageSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */