package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.List;

public abstract class FTSEntitySearchEngine
  implements ISearchEngine<FTSEntitySearchResultModel>
{
  protected QQAppInterface a;
  
  public FTSEntitySearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a() {}
  
  public abstract void a(String paramString, List<FTSEntity> paramList);
  
  public void b() {}
  
  public abstract void b(SearchRequest paramSearchRequest, ISearchListener<FTSEntitySearchResultDetailModel> paramISearchListener);
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchEngine
 * JD-Core Version:    0.7.0.1
 */