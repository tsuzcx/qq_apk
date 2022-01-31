package com.tencent.mobileqq.filemanager.data.search.troop;

import alkl;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqyo;
import aqzg;
import aqzi;
import aqzj;
import ayfe;
import ayjl;
import aypx;
import bhpo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class TroopFileSearchFragment
  extends BaseSearchFragment<ayjl>
  implements aqyo, bhpo
{
  public int a;
  public long a;
  protected alkl a;
  private aqzg jdField_a_of_type_Aqzg;
  private aqzj jdField_a_of_type_Aqzj;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private int b;
  private int c;
  
  public TroopFileSearchFragment()
  {
    this.jdField_a_of_type_Alkl = new aqzi(this);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839224);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.a();
  }
  
  public ayfe a()
  {
    this.jdField_a_of_type_Aqzj = new aqzj(this);
    return this.jdField_a_of_type_Aqzj;
  }
  
  public aypx a()
  {
    this.jdField_a_of_type_Aqzg = new aqzg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this);
    this.jdField_a_of_type_Aqzg.a(1);
    return this.jdField_a_of_type_Aqzg;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void g_(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Aqzg.a(this.jdField_c_of_type_JavaLangString)) && (paramBoolean))
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
    this.jdField_a_of_type_AndroidViewView.findViewById(2131367555).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838591);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131166901));
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aqzg != null) {
      this.jdField_a_of_type_Aqzg.e();
    }
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aqzg != null) {
      this.jdField_a_of_type_Aqzg.c();
    }
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aqzg != null) {
      this.jdField_a_of_type_Aqzg.d();
    }
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt3;
    this.b = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) || (this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty()) || (this.b != this.jdField_c_of_type_Int - 2) || (this.jdField_a_of_type_Aqzg.a(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_Aqzg.a(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */