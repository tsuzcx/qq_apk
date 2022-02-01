package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.view.SearchResultEntranceView;

public class EntranceResultPresenter
  implements IPresenter<SearchResultModelForEntrance, SearchResultEntranceView>
{
  public void a(SearchResultModelForEntrance paramSearchResultModelForEntrance, SearchResultEntranceView paramSearchResultEntranceView)
  {
    paramSearchResultEntranceView.a(paramSearchResultModelForEntrance);
    paramSearchResultEntranceView.a().setOnClickListener(new EntranceResultPresenter.1(this, paramSearchResultModelForEntrance));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.EntranceResultPresenter
 * JD-Core Version:    0.7.0.1
 */