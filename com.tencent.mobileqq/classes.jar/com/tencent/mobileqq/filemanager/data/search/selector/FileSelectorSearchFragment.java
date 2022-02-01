package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class FileSelectorSearchFragment
  extends BaseSearchFragment<ISearchResultModel>
  implements ISearchViewBinder
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private FileSelectorSearchEngine jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine;
  private FileSelectorSearchFragment.FileSelectorSearchAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$FileSelectorSearchAdapter;
  private QFileCustomBottomBarManager jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager;
  
  public BaseMvpAdapter a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$FileSelectorSearchAdapter = new FileSelectorSearchFragment.FileSelectorSearchAdapter(this);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$FileSelectorSearchAdapter;
  }
  
  public ISearchEngine a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine = new FileSelectorSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine.a(this.jdField_a_of_type_AndroidOsBundle);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine;
  }
  
  public String a()
  {
    String str = "";
    if (this.jdField_a_of_type_Int == 16) {
      str = getActivity().getString(2131692378);
    }
    do
    {
      return str;
      if (this.jdField_a_of_type_Int == 17) {
        return getActivity().getString(2131692361);
      }
      if (this.jdField_a_of_type_Int == 18) {
        return getActivity().getString(2131692336);
      }
    } while (this.jdField_a_of_type_Int != 19);
    return getActivity().getString(2131692438);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131368336).setVisibility(8);
    paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376997);
    paramBundle = new QFileSendBottomView(paramLayoutInflater.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramViewGroup.addView(paramBundle, localLayoutParams);
    paramBundle.a(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager = QFileCustomBottomBarManager.a(getActivity().app, getActivity(), paramBundle, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.b();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment
 * JD-Core Version:    0.7.0.1
 */