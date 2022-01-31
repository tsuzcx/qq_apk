package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqyj;
import aqyn;
import ayfe;
import ayjl;
import aypx;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.List;

public class FileSearchFragment
  extends BaseSearchFragment<ayjl>
{
  protected boolean a;
  public String b;
  public List<ayjl> b;
  int c = -1;
  
  public FileSearchFragment()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public ayfe a()
  {
    return new aqyj(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bcws, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public aypx a()
  {
    return new FileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
  }
  
  public String a()
  {
    return aqyn.jdField_b_of_type_JavaLangString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367555);
    if (!this.jdField_a_of_type_Boolean)
    {
      paramViewGroup.setVisibility(8);
      return paramLayoutInflater;
    }
    paramViewGroup.setVisibility(0);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchFragment
 * JD-Core Version:    0.7.0.1
 */