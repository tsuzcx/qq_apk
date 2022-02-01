package com.tencent.mobileqq.filemanager.data.search.troop;

import android.view.ViewGroup;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;

class TroopFileSearchFragment$TroopFileSearchAdapter
  extends BaseMvpAdapter<ISearchResultModel, ISearchResultView>
{
  public TroopFileSearchFragment$TroopFileSearchAdapter(TroopFileSearchFragment paramTroopFileSearchFragment) {}
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new TroopFileSearchResultPresenter();
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new TroopFileSearchResultView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment.TroopFileSearchAdapter
 * JD-Core Version:    0.7.0.1
 */