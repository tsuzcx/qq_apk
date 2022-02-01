package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.List;

public class TroopFileSearchFragment
  extends BaseSearchFragment<ISearchResultModel>
  implements ISearchViewBinder, AbsListView.OnScrollListener
{
  public int a;
  public long a;
  protected BizTroopObserver a;
  private TroopFileSearchEngine jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine;
  private TroopFileSearchFragment.TroopFileSearchAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchFragment$TroopFileSearchAdapter;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private int b = 0;
  private int c;
  
  public TroopFileSearchFragment()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFileSearchFragment.1(this);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839401);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.a();
  }
  
  protected BaseMvpAdapter a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchFragment$TroopFileSearchAdapter = new TroopFileSearchFragment.TroopFileSearchAdapter(this);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchFragment$TroopFileSearchAdapter;
  }
  
  protected ISearchEngine a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine = new TroopFileSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, getQBaseActivity(), this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine.a(1);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine;
  }
  
  protected String b()
  {
    return HardCodeUtil.a(2131701272);
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void c_(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine.a(this.jdField_c_of_type_JavaLangString)) && (paramBoolean))
    {
      d(true);
      return;
    }
    d(false);
    super.c_(paramBoolean);
  }
  
  protected void j_(boolean paramBoolean)
  {
    d(false);
    super.j_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131368087).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(getQBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131167056));
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TroopFileSearchEngine localTroopFileSearchEngine = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine;
    if (localTroopFileSearchEngine != null) {
      localTroopFileSearchEngine.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    TroopFileSearchEngine localTroopFileSearchEngine = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine;
    if (localTroopFileSearchEngine != null) {
      localTroopFileSearchEngine.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    TroopFileSearchEngine localTroopFileSearchEngine = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine;
    if (localTroopFileSearchEngine != null) {
      localTroopFileSearchEngine.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt3;
    this.b = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_c_of_type_JavaUtilList != null) && (!this.jdField_c_of_type_JavaUtilList.isEmpty()) && (this.b == this.jdField_c_of_type_Int - 2))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine.a(this.jdField_c_of_type_JavaLangString)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchEngine.a(this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */