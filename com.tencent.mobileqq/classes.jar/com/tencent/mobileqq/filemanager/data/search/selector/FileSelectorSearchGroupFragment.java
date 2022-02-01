package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;

public class FileSelectorSearchGroupFragment
  extends IphoneTitleBarFragment
{
  private static FileSelectorSearchResultModel jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private FileSelectorSearchGroupFragment.FileSelectorSearchAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchGroupFragment$FileSelectorSearchAdapter;
  private QFileCustomBottomBarManager jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  private String a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel != null) {
      return String.format(getString(2131692510), new Object[] { Integer.valueOf(jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel.d()), jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel.a() });
    }
    return "";
  }
  
  public static void a(FileSelectorSearchResultModel paramFileSelectorSearchResultModel)
  {
    jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel = paramFileSelectorSearchResultModel;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RelativeLayout)this.mContentView;
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370452));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new FileSelectorSearchGroupFragment.1(this));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131368370);
    paramViewGroup = new QFileSendBottomView(paramLayoutInflater.getContext());
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    paramLayoutInflater.addView(paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getArguments().getBundle("qfile_search_param_ex_params");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager = QFileCustomBottomBarManager.a(getActivity().app, getActivity(), paramViewGroup, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a(this.jdField_a_of_type_AndroidOsBundle);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public int getContentLayoutId()
  {
    return 2131560948;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    setTitle(jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel.d());
    super.onViewCreated(paramView, paramBundle);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368336)).setText(a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchGroupFragment$FileSelectorSearchAdapter = new FileSelectorSearchGroupFragment.FileSelectorSearchAdapter(this, jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultModel);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchGroupFragment$FileSelectorSearchAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileCustomBottomBarManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment
 * JD-Core Version:    0.7.0.1
 */