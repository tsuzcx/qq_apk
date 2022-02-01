package com.tencent.mobileqq.filemanager.data.search.troop;

import android.view.ViewGroup;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.model.ISearchResultModel;

class TroopFileSearchFragment$TroopFileSearchAdapter
  extends BaseMvpAdapter<ISearchResultModel, ISearchResultView>
{
  public TroopFileSearchFragment$TroopFileSearchAdapter(TroopFileSearchFragment paramTroopFileSearchFragment) {}
  
  protected IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new TroopFileSearchResultPresenter();
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new TroopFileSearchResultView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment.TroopFileSearchAdapter
 * JD-Core Version:    0.7.0.1
 */