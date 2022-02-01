package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.MessageSearchResultModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MessageSearchEngine
  implements ISearchEngine<MessageSearchResultModel>
{
  public QQAppInterface a;
  public FullMessageSearchManager b;
  public String c;
  
  public MessageSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = ((FullMessageSearchManager)paramQQAppInterface.getManager(QQManagerFactory.FULL_MESSAGE_SEARCH_MANAGER));
  }
  
  private List<MessageSearchResultModel> a(String paramString, FullMessageSearchResult paramFullMessageSearchResult)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFullMessageSearchResult != null) && (paramFullMessageSearchResult.a != null))
    {
      int i = 0;
      while (i < paramFullMessageSearchResult.a.size())
      {
        localArrayList.add(new MessageSearchResultModel(this.a, paramString, (FullMessageSearchResult.SearchResultItem)paramFullMessageSearchResult.a.get(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List<MessageSearchResultModel> a(SearchRequest paramSearchRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageSearchEngine", 2, "========== search message use MessageSearchEngine");
    }
    this.c = paramSearchRequest.a;
    if ((paramSearchRequest.b != null) && (paramSearchRequest.b.getBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", false))) {
      paramSearchRequest = this.b.b(this.c);
    } else {
      paramSearchRequest = this.b.c(this.c);
    }
    return a(this.c, paramSearchRequest);
  }
  
  public void a() {}
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<MessageSearchResultModel> paramISearchListener)
  {
    ThreadManager.post(new MessageSearchEngine.1(this, paramISearchListener, paramSearchRequest), 8, null, true);
  }
  
  public void b()
  {
    ThreadManager.post(new MessageSearchEngine.2(this), 8, null, true);
  }
  
  public void c()
  {
    ThreadManager.post(new MessageSearchEngine.3(this, this.c), 8, null, true);
  }
  
  public void d()
  {
    ThreadManager.post(new MessageSearchEngine.4(this, this.c), 8, null, true);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MessageSearchEngine
 * JD-Core Version:    0.7.0.1
 */