package com.tencent.mobileqq.search.base.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchResultPresenter$1
  implements View.OnClickListener
{
  SearchResultPresenter$1(SearchResultPresenter paramSearchResultPresenter, ISearchResultModel paramISearchResultModel) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    ISearchResultModel localISearchResultModel = this.a;
    if ((localISearchResultModel instanceof ISearchResultPositionModel)) {
      SearchReportUtil.a((ISearchResultPositionModel)localISearchResultModel);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.SearchResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */