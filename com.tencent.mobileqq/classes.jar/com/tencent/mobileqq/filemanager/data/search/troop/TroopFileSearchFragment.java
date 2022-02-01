package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anrc;
import atqr;
import atrj;
import atrl;
import atrm;
import bcbc;
import bcfj;
import bclw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.List;

public class TroopFileSearchFragment
  extends BaseSearchFragment<bcfj>
  implements atqr, AbsListView.OnScrollListener
{
  public int a;
  public long a;
  protected anrc a;
  private atrj jdField_a_of_type_Atrj;
  private atrm jdField_a_of_type_Atrm;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private int b;
  private int c;
  
  public TroopFileSearchFragment()
  {
    this.jdField_a_of_type_Anrc = new atrl(this);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839466);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.a();
  }
  
  public bcbc a()
  {
    this.jdField_a_of_type_Atrm = new atrm(this);
    return this.jdField_a_of_type_Atrm;
  }
  
  public bclw a()
  {
    this.jdField_a_of_type_Atrj = new atrj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this);
    this.jdField_a_of_type_Atrj.a(1);
    return this.jdField_a_of_type_Atrj;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void f_(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Atrj.a(this.jdField_c_of_type_JavaLangString)) && (paramBoolean))
    {
      d(true);
      return;
    }
    d(false);
    super.f_(paramBoolean);
  }
  
  public void g_(boolean paramBoolean)
  {
    d(false);
    super.g_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131368115).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838911);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131167026));
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Atrj != null) {
      this.jdField_a_of_type_Atrj.e();
    }
    if (this.jdField_a_of_type_Anrc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anrc);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Atrj != null) {
      this.jdField_a_of_type_Atrj.c();
    }
    if (this.jdField_a_of_type_Anrc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anrc);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Atrj != null) {
      this.jdField_a_of_type_Atrj.d();
    }
    if (this.jdField_a_of_type_Anrc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anrc);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt3;
    this.b = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) || (this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty()) || (this.b != this.jdField_c_of_type_Int - 2) || (this.jdField_a_of_type_Atrj.a(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_Atrj.a(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */