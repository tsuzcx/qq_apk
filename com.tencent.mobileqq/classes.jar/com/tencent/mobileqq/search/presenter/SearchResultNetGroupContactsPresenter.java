package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.search.model.GroupNetSearchModelPeople;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupView;

public class SearchResultNetGroupContactsPresenter
  implements IPresenter
{
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramISearchResultGroupModel = (GroupNetSearchModelPeople)paramISearchResultGroupModel;
    ((SearchResultGroupView)paramISearchResultGroupView).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultNetGroupContactsPresenter
 * JD-Core Version:    0.7.0.1
 */