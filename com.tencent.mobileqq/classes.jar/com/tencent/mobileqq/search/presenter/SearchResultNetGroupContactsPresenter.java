package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.SearchResultGroupView;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPeople;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;

public class SearchResultNetGroupContactsPresenter
  implements IPresenter<ISearchResultGroupModel, ISearchResultGroupView>
{
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramISearchResultGroupModel = (GroupNetSearchModelPeople)paramISearchResultGroupModel;
    ((SearchResultGroupView)paramISearchResultGroupView).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultNetGroupContactsPresenter
 * JD-Core Version:    0.7.0.1
 */