package com.tencent.mobileqq.filemanager.data.search;

import adav;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileManagerSearchEngine
  implements ISearchEngine
{
  private adav jdField_a_of_type_Adav = new adav(this, null);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public FileManagerSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSearchRequest.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      FileEntitySearchResultModel localFileEntitySearchResultModel = new FileEntitySearchResultModel();
      localFileEntitySearchResultModel.jdField_a_of_type_JavaUtilList.addAll((Collection)localMap.get(str));
      localFileEntitySearchResultModel.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
      localArrayList.add(localFileEntitySearchResultModel);
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    if ((paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramSearchRequest.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_Adav)
    {
      this.jdField_a_of_type_Adav.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
      this.jdField_a_of_type_Adav.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
      ThreadManager.remove(this.jdField_a_of_type_Adav);
      ThreadManager.postImmediately(this.jdField_a_of_type_Adav, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_Adav)
    {
      this.jdField_a_of_type_Adav.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = null;
      this.jdField_a_of_type_Adav.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
      ThreadManager.remove(this.jdField_a_of_type_Adav);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */