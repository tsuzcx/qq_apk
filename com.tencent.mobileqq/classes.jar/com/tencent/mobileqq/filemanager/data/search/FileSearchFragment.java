package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
  
  protected BaseMvpAdapter a()
  {
    return new FileSearchFragment.FileSearchAdapter(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  protected ISearchEngine a()
  {
    return new FileManagerSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.c);
  }
  
  protected String a()
  {
    return GroupSearchModelFileEntity.jdField_b_of_type_JavaLangString;
  }
  
  protected String b()
  {
    return HardCodeUtil.a(2131701272);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368087);
    if (!this.jdField_a_of_type_Boolean) {
      paramViewGroup.setVisibility(8);
    } else {
      paramViewGroup.setVisibility(0);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchFragment
 * JD-Core Version:    0.7.0.1
 */