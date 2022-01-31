package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import aviu;
import avlb;
import avlc;
import avld;
import avlf;
import avwf;
import com.tencent.widget.XListView;
import java.util.List;

public class AssociateSearchWordsFragment
  extends Fragment
{
  public View.OnClickListener a;
  public View.OnTouchListener a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private List<avld> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  
  public AssociateSearchWordsFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new avlb(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new avlc(this);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<avld> paramList)
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
  
  public void b(List<avld> paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == null)
    {
      avlf localavlf = new avlf(this, paramList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(localavlf);
      localavlf.a(paramList);
    }
    for (;;)
    {
      paramList = getActivity();
      if ((paramList instanceof aviu)) {
        avwf.a("sub_result", "exp_auto", new String[] { ((aviu)paramList).a(), "", "", "" });
      }
      return;
      ((avlf)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).a(paramList);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131494036, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramLayoutInflater.findViewById(2131309958));
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