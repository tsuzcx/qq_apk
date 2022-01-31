package com.tencent.mobileqq.filemanager.data.search;

import adax;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import java.util.List;

public class FileSearchFragment
  extends BaseSearchFragment
{
  public String a;
  public List a;
  
  protected BaseMvpAdapter a()
  {
    return new adax(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected ISearchEngine a()
  {
    return new FileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return "我的文件";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchFragment
 * JD-Core Version:    0.7.0.1
 */