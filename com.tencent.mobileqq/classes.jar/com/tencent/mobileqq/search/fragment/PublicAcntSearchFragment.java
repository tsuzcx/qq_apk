package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.adapter.SubBusinessSearchAdapter;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PublicAcntSearchFragment
  extends BaseSearchFragment
  implements AbsListView.OnScrollListener
{
  private static int b = -1;
  protected int a;
  private long a;
  protected UniteSearchObserver a;
  protected String a;
  public boolean a;
  public byte[] a;
  protected boolean g;
  
  public PublicAcntSearchFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new PublicAcntSearchFragment.2(this);
  }
  
  public static PublicAcntSearchFragment a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    return new PublicAcntSearchFragment();
  }
  
  protected int a()
  {
    return 50;
  }
  
  protected BaseMvpAdapter a()
  {
    return new SubBusinessSearchAdapter(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this, 0);
  }
  
  protected ISearchEngine a()
  {
    return new PublicAccountSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, jdField_b_of_type_Int);
  }
  
  protected String a()
  {
    if (jdField_b_of_type_Int == 12) {
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, BaseApplicationImpl.getContext());
    }
    return HardCodeUtil.a(2131708781);
  }
  
  public void a(List paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    if ((SearchUtils.a(jdField_b_of_type_Int)) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      if (paramList == null)
      {
        paramList = "0";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramList.size());
        paramList = localStringBuilder.toString();
      }
      SearchUtils.a("all_result", "exp_public_uin_page", new String[] { localObject, paramList });
    }
    if ((this.jdField_c_of_type_JavaUtilList != null) && (!this.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      paramInt = 0;
      while (paramInt < this.jdField_c_of_type_JavaUtilList.size())
      {
        SearchViewUtils.a((ISearchResultModel)this.jdField_c_of_type_JavaUtilList.get(paramInt), this.jdField_c_of_type_JavaUtilList.size(), paramInt);
        paramInt += 1;
      }
      this.jdField_c_of_type_JavaUtilList.add(0, new GroupSearchModeTitle(HardCodeUtil.a(2131708731), "", ""));
    }
    this.jdField_a_of_type_ArrayOfByte = null;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onFinish, search net result ,keyword = ");
        paramList.append(this.jdField_c_of_type_JavaLangString);
        QLog.i("PublicAcntSearchFragment", 2, paramList.toString());
      }
      e(this.jdField_c_of_type_JavaUtilList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "keyword is empty ");
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.jdField_c_of_type_JavaLangString))
    {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAcntSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected String b()
  {
    return HardCodeUtil.a(2131701277);
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected void d(List paramList)
  {
    super.d(paramList);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    c_(false);
    j_(false);
  }
  
  protected void e(List paramList)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendNetPublicAcntRequest ,keyword=");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      QLog.i("PublicAcntSearchFragment", 2, ((StringBuilder)localObject1).toString());
    }
    ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.1(this));
    Object localObject2 = ((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
    Object localObject1 = new ArrayList();
    int i;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        i = 0;
      }
    }
    else {
      while (i < paramList.size())
      {
        localObject3 = (IModel)paramList.get(i);
        if ((localObject3 instanceof PublicAccountSearchResultModel))
        {
          localObject3 = (PublicAccountSearchResultModel)localObject3;
          int j = 0;
          while (j < ((List)localObject2).size())
          {
            PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((List)localObject2).get(j);
            if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(((PublicAccountSearchResultModel)localObject3).a.uin))) {
              ((List)localObject1).add(Long.valueOf(localPublicAccountInfo.uin));
            }
            j += 1;
          }
        }
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAcntSearchFragment", 2, "all publicAccountInfoList is null or empty");
        }
      }
    }
    paramList = (UniteSearchHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("isLoadMore", true);
    ((Bundle)localObject2).putInt("fromType", jdField_b_of_type_Int);
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(Long.valueOf(1003L));
    paramList.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 20, (List)localObject3, (List)localObject1, this.jdField_a_of_type_ArrayOfByte, 0.0D, 0.0D, (Bundle)localObject2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine instanceof PublicAccountSearchEngine)) {
      ((PublicAccountSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine).e();
    }
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
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
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.getCount() != 0))
    {
      if (this.jdField_a_of_type_Int == 0) {
        return;
      }
      if ((paramInt3 - paramInt1 - paramInt2 < 10) && (!this.jdField_a_of_type_Boolean) && (!this.g)) {
        e(this.jdField_c_of_type_JavaUtilList);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment
 * JD-Core Version:    0.7.0.1
 */