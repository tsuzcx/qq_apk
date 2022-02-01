package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class FileSelectorSearchFragment
  extends BaseSearchFragment<ISearchResultModel>
  implements ISearchViewBinder
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private FileSelectorSearchEngine jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine;
  private FileSelectorSearchFragment.FileSelectorSearchAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$FileSelectorSearchAdapter;
  private QFileCustomBottomBarManager jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager;
  
  protected BaseMvpAdapter a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$FileSelectorSearchAdapter = new FileSelectorSearchFragment.FileSelectorSearchAdapter(this);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$FileSelectorSearchAdapter;
  }
  
  protected ISearchEngine a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine = new FileSelectorSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, getQBaseActivity(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine.a(this.jdField_a_of_type_AndroidOsBundle);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine;
  }
  
  protected String a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 16) {
      return getQBaseActivity().getString(2131692305);
    }
    if (i == 17) {
      return getQBaseActivity().getString(2131692291);
    }
    if (i == 18) {
      return getQBaseActivity().getString(2131692264);
    }
    if (i == 19) {
      return getQBaseActivity().getString(2131692374);
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  protected String b()
  {
    return HardCodeUtil.a(2131701272);
  }
  
  public String c()
  {
    return this.c;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131368087).setVisibility(8);
    paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376483);
    paramBundle = new QFileSendBottomView(paramLayoutInflater.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramViewGroup.addView(paramBundle, localLayoutParams);
    paramBundle.a(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager = QFileCustomBottomBarManager.a((QQAppInterface)getQBaseActivity().getAppRuntime(), getQBaseActivity(), paramBundle, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.b();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    QFileCustomBottomBarManager localQFileCustomBottomBarManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager;
    if (localQFileCustomBottomBarManager != null) {
      localQFileCustomBottomBarManager.a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment
 * JD-Core Version:    0.7.0.1
 */