package com.tencent.mobileqq.search.ftsentity;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
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
  
  protected BaseMvpAdapter a()
  {
    return new FTSEntitySearchFragment.1(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getQBaseActivity();
    return FTSEntitySearchUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localBaseSearchActivity.b);
  }
  
  protected String a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getQBaseActivity();
    return FTSEntitySearchUtils.a(localBaseSearchActivity, localBaseSearchActivity.b);
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 1);
  }
  
  public void a(List paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    if (!this.b)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.c);
      localObject = ((StringBuilder)localObject).toString();
      paramInt = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (paramList != null) {
        paramInt = paramList.size();
      }
      localStringBuilder.append(paramInt);
      SearchUtils.a("talk", "exp_page", new String[] { localObject, localStringBuilder.toString() });
      this.b = true;
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.c))
    {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.c });
    }
  }
  
  protected String b()
  {
    return HardCodeUtil.a(2131701275);
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
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.d();
  }
  
  public void onStart()
  {
    super.onStart();
    ((FTSMessageSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((FTSMessageSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */