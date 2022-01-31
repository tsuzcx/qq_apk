package com.tencent.mobileqq.filemanager.data.search.troop;

import ajsy;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import apfq;
import apgi;
import apgk;
import apgl;
import awke;
import awoi;
import awuu;
import bfos;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class TroopFileSearchFragment
  extends BaseSearchFragment<awoi>
  implements apfq, bfos
{
  public int a;
  public long a;
  protected ajsy a;
  private apgi jdField_a_of_type_Apgi;
  private apgl jdField_a_of_type_Apgl;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private int b;
  private int c;
  
  public TroopFileSearchFragment()
  {
    this.jdField_a_of_type_Ajsy = new apgk(this);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839140);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.a();
  }
  
  public awke a()
  {
    this.jdField_a_of_type_Apgl = new apgl(this);
    return this.jdField_a_of_type_Apgl;
  }
  
  public awuu a()
  {
    this.jdField_a_of_type_Apgi = new apgi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this);
    this.jdField_a_of_type_Apgi.a(1);
    return this.jdField_a_of_type_Apgi;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void g_(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Apgi.a(this.jdField_c_of_type_JavaLangString)) && (paramBoolean))
    {
      d(true);
      return;
    }
    d(false);
    super.g_(paramBoolean);
  }
  
  public void h_(boolean paramBoolean)
  {
    d(false);
    super.h_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131367427).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838514);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131166854));
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Apgi != null) {
      this.jdField_a_of_type_Apgi.e();
    }
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Apgi != null) {
      this.jdField_a_of_type_Apgi.c();
    }
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Apgi != null) {
      this.jdField_a_of_type_Apgi.d();
    }
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt3;
    this.b = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) || (this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty()) || (this.b != this.jdField_c_of_type_Int - 2) || (this.jdField_a_of_type_Apgi.a(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_Apgi.a(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */