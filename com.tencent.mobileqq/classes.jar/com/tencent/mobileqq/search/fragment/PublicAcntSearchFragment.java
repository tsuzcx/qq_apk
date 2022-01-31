package com.tencent.mobileqq.search.fragment;

import ahfk;
import ahfl;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.adapter.SubBusinessSearchAdapter;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PublicAcntSearchFragment
  extends BaseSearchFragment
  implements AbsListView.OnScrollListener
{
  private static int b;
  private long a;
  protected UniteSearchObserver a;
  public String a;
  public byte[] a;
  public boolean e;
  public boolean f;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public PublicAcntSearchFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ahfl(this);
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
    return new SubBusinessSearchAdapter(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this, 0);
  }
  
  protected ISearchEngine a()
  {
    return new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_b_of_type_Int);
  }
  
  protected String a()
  {
    if (jdField_b_of_type_Int == 12) {
      return PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    }
    return "关注的公众号";
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.e) || (this.f)) {
      return;
    }
    e(this.jdField_b_of_type_JavaUtilList);
  }
  
  public void a(List paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    String str;
    if ((SearchUtils.a(jdField_b_of_type_Int)) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      str = "" + this.jdField_b_of_type_JavaLangString;
      if (paramList != null) {
        break label143;
      }
    }
    label143:
    for (paramList = "0";; paramList = "" + paramList.size())
    {
      SearchUtils.a("all_result", "exp_public_uin_page", new String[] { str, paramList });
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break label194;
      }
      paramInt = 0;
      while (paramInt < this.jdField_b_of_type_JavaUtilList.size())
      {
        SearchViewUtils.a((ISearchResultModel)this.jdField_b_of_type_JavaUtilList.get(paramInt), this.jdField_b_of_type_JavaUtilList.size(), paramInt);
        paramInt += 1;
      }
    }
    this.jdField_b_of_type_JavaUtilList.add(0, new GroupSearchModeTitle("关注的公众号", "", ""));
    label194:
    this.jdField_a_of_type_ArrayOfByte = null;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAcntSearchFragment", 2, "onFinish, search net result ,keyword = " + this.jdField_b_of_type_JavaLangString);
      }
      e(this.jdField_b_of_type_JavaUtilList);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PublicAcntSearchFragment", 2, "keyword is empty ");
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void e(List paramList)
  {
    this.e = true;
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "sendNetPublicAcntRequest ,keyword=" + this.jdField_b_of_type_JavaLangString);
    }
    ThreadManager.getUIHandler().post(new ahfk(this));
    Object localObject1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a();
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAcntSearchFragment", 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      paramList = (UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isLoadMore", true);
      ((Bundle)localObject1).putInt("fromType", jdField_b_of_type_Int);
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Long.valueOf(1003L));
      paramList.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 20, (List)localObject2, localArrayList, this.jdField_a_of_type_ArrayOfByte, 0.0D, 0.0D, (Bundle)localObject1);
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i = 0;
        while (i < paramList.size())
        {
          localObject2 = (IModel)paramList.get(i);
          if ((localObject2 instanceof PublicAccountSearchResultModel))
          {
            localObject2 = (PublicAccountSearchResultModel)localObject2;
            int j = 0;
            while (j < ((List)localObject1).size())
            {
              PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((List)localObject1).get(j);
              if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(((PublicAccountSearchResultModel)localObject2).a.uin))) {
                localArrayList.add(Long.valueOf(localPublicAccountInfo.uin));
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = (System.currentTimeMillis() + "");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof PublicAccountSearchEngine)) {
      ((PublicAccountSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).e();
    }
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment
 * JD-Core Version:    0.7.0.1
 */