package com.tencent.mobileqq.search.ftsentity;

import android.os.Bundle;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRespData;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
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
  
  public BaseMvpAdapter a()
  {
    return new FTSEntitySearchFragment.1(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  public ISearchEngine a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseSearchActivity.jdField_a_of_type_Int);
  }
  
  public String a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return FTSEntitySearchUtils.a(localBaseSearchActivity, localBaseSearchActivity.jdField_a_of_type_Int);
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
    if (!this.b)
    {
      str = "" + this.c;
      localStringBuilder = new StringBuilder().append("");
      if (paramList != null) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = paramList.size())
    {
      SearchUtils.a("talk", "exp_page", new String[] { str, paramInt });
      this.b = true;
      return;
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.c)) {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.c });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.c = getArguments().getString("keyword");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */