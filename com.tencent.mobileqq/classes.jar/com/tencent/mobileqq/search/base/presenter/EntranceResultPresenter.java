package com.tencent.mobileqq.search.base.presenter;

import android.view.View;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.base.view.SearchResultEntranceView;

public class EntranceResultPresenter
  implements IPresenter<SearchResultModelForEntrance, SearchResultEntranceView>
{
  public void a(SearchResultModelForEntrance paramSearchResultModelForEntrance, SearchResultEntranceView paramSearchResultEntranceView)
  {
    paramSearchResultEntranceView.a(paramSearchResultModelForEntrance);
    paramSearchResultEntranceView.h().setOnClickListener(new EntranceResultPresenter.1(this, paramSearchResultModelForEntrance));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.EntranceResultPresenter
 * JD-Core Version:    0.7.0.1
 */