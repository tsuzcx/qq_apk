package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import aydp;
import ayfw;
import ayfx;
import ayfz;
import ayga;
import ayrd;
import com.tencent.widget.XListView;
import java.util.List;

public class AssociateSearchWordsFragment
  extends Fragment
{
  public View.OnClickListener a;
  public View.OnTouchListener a;
  private ayfz jdField_a_of_type_Ayfz;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private List<AssociateSearchWordsFragment.AssociateItem> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  
  public AssociateSearchWordsFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ayfw(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ayfx(this);
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
      ayga localayga = new ayga(this, paramList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(localayga);
      localayga.a(paramList);
    }
    for (;;)
    {
      paramList = getActivity();
      if ((paramList instanceof aydp)) {
        ayrd.a("sub_result", "exp_auto", new String[] { ((aydp)paramList).a(), "", "", "" });
      }
      return;
      ((ayga)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).a(paramList);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559660, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramLayoutInflater.findViewById(2131376215));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment
 * JD-Core Version:    0.7.0.1
 */