package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XListView;
import java.util.List;

public class AssociateSearchWordsFragment
  extends ReportV4Fragment
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AssociateSearchWordsFragment.1(this);
  public View.OnTouchListener a;
  private AssociateSearchWordsFragment.AssociateWordClickCallback jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment$AssociateWordClickCallback;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  private List<AssociateSearchWordsFragment.AssociateItem> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b = false;
  
  public AssociateSearchWordsFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new AssociateSearchWordsFragment.2(this);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      return;
    }
    b(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == null)
    {
      AssociateSearchWordsFragment.SearchAssociatedWordAdapter localSearchAssociatedWordAdapter = new AssociateSearchWordsFragment.SearchAssociatedWordAdapter(this, paramList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(localSearchAssociatedWordAdapter);
      localSearchAssociatedWordAdapter.a(paramList);
    }
    for (;;)
    {
      paramList = getActivity();
      if ((paramList instanceof SearchInfoInterface)) {
        SearchUtils.a("sub_result", "exp_auto", new String[] { ((SearchInfoInterface)paramList).a(), "", "", "" });
      }
      return;
      ((AssociateSearchWordsFragment.SearchAssociatedWordAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).a(paramList);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559924, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramLayoutInflater.findViewById(2131377627));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList = null;
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment
 * JD-Core Version:    0.7.0.1
 */