package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;

public class FileSearchFragment
  extends BaseSearchFragment<ISearchResultModel>
{
  protected boolean a;
  public String b;
  public List<ISearchResultModel> b;
  int c = -1;
  
  public FileSearchFragment()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public BaseMvpAdapter a()
  {
    return new FileSearchFragment.FileSearchAdapter(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public ISearchEngine a()
  {
    return new FileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
  }
  
  public String a()
  {
    return GroupSearchModelFileEntity.jdField_b_of_type_JavaLangString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368336);
    if (!this.jdField_a_of_type_Boolean) {
      paramViewGroup.setVisibility(8);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramViewGroup.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchFragment
 * JD-Core Version:    0.7.0.1
 */