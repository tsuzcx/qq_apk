package com.tencent.mobileqq.search.searchengine;

import ahhy;
import ahia;
import ahib;
import ahic;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.model.MessageSearchResultModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MessageSearchEngine
  implements ISearchEngine
{
  public QQAppInterface a;
  public FullMessageSearchManager a;
  public String a;
  
  public MessageSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchManager = ((FullMessageSearchManager)paramQQAppInterface.getManager(104));
  }
  
  private List a(String paramString, FullMessageSearchResult paramFullMessageSearchResult)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFullMessageSearchResult != null) && (paramFullMessageSearchResult.a != null))
    {
      int i = 0;
      while (i < paramFullMessageSearchResult.a.size())
      {
        localArrayList.add(new MessageSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (FullMessageSearchResult.SearchResultItem)paramFullMessageSearchResult.a.get(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageSearchEngine", 2, "========== search message use MessageSearchEngine");
    }
    this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
    if ((paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) && (paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", false))) {}
    for (paramSearchRequest = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchManager.a(this.jdField_a_of_type_JavaLangString);; paramSearchRequest = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchManager.b(this.jdField_a_of_type_JavaLangString)) {
      return a(this.jdField_a_of_type_JavaLangString, paramSearchRequest);
    }
  }
  
  public void a() {}
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    ThreadManager.post(new ahhy(this, paramISearchListener, paramSearchRequest), 8, null, true);
  }
  
  public void b()
  {
    ThreadManager.post(new ahia(this), 8, null, true);
  }
  
  public void c()
  {
    ThreadManager.post(new ahib(this, this.jdField_a_of_type_JavaLangString), 8, null, true);
  }
  
  public void d()
  {
    ThreadManager.post(new ahic(this, this.jdField_a_of_type_JavaLangString), 8, null, true);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MessageSearchEngine
 * JD-Core Version:    0.7.0.1
 */