package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MiniProgramSearchEngine
  implements ISearchEngine<MiniProgramSearchResultModel>, Runnable
{
  protected int a;
  protected QQAppInterface a;
  
  public MiniProgramSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<MiniProgramSearchResultModel> a(SearchRequest paramSearchRequest)
  {
    Object localObject = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getLocalSearchData();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ArrayList localArrayList1 = new ArrayList(((List)localObject).size() + 1);
      ArrayList localArrayList2 = new ArrayList(((List)localObject).size() + 1);
      localObject = ((List)localObject).iterator();
      int i;
      for (;;)
      {
        boolean bool = ((Iterator)localObject).hasNext();
        i = 0;
        if (!bool) {
          break;
        }
        MiniAppLocalSearchEntity localMiniAppLocalSearchEntity = (MiniAppLocalSearchEntity)((Iterator)localObject).next();
        int[] arrayOfInt = SearchUtils.a(paramSearchRequest.a, localMiniAppLocalSearchEntity.appName, false);
        if ((arrayOfInt != null) && (arrayOfInt.length >= 3) && (arrayOfInt[0] > -1))
        {
          MiniProgramSearchResultModel localMiniProgramSearchResultModel = new MiniProgramSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localMiniAppLocalSearchEntity, paramSearchRequest.a);
          localMiniProgramSearchResultModel.a = arrayOfInt;
          if (localMiniAppLocalSearchEntity.appName.equals(paramSearchRequest.a)) {
            localArrayList2.add(0, localMiniProgramSearchResultModel);
          } else {
            localArrayList2.add(localMiniProgramSearchResultModel);
          }
        }
      }
      localArrayList1.addAll(localArrayList2);
      Collections.sort(localArrayList2, new MiniProgramSearchEngine.1(this));
      int j = localArrayList1.size();
      while (i < j)
      {
        SearchViewUtils.a((ISearchResultModel)localArrayList1.get(i), j, i);
        i += 1;
      }
      return localArrayList1;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<MiniProgramSearchResultModel> paramISearchListener) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine
 * JD-Core Version:    0.7.0.1
 */