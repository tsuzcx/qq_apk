package com.tencent.mobileqq.search.fragment;

import aher;
import ahes;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.widget.XListView;
import java.util.List;

public class AssociateSearchWordsFragment
  extends Fragment
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aher(this);
  public View.OnTouchListener a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public AssociateSearchWordsFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ahes(this);
  }
  
  public void a(List paramList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      return;
    }
    b(paramList);
  }
  
  public void b(List paramList)
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
    paramLayoutInflater = paramLayoutInflater.inflate(2130969377, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramLayoutInflater.findViewById(2131366303));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList = null;
    }
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment
 * JD-Core Version:    0.7.0.1
 */