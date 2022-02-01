package com.tencent.mobileqq.filemanager.data.search.selector;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import java.util.List;

class FileSelectorSearchGroupFragment$FileSelectorSearchAdapter
  extends BaseMvpAdapter<ISearchResultModel, ISearchResultView>
{
  public FileSelectorSearchGroupFragment$FileSelectorSearchAdapter(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, FileSelectorSearchResultModel paramFileSelectorSearchResultModel)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramFileSelectorSearchResultModel.a(paramFileSelectorSearchGroupFragment.getActivity().app, paramFileSelectorSearchGroupFragment.getActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    FileSelectorSearchResultPresenter localFileSelectorSearchResultPresenter = new FileSelectorSearchResultPresenter();
    localFileSelectorSearchResultPresenter.a(new FileSelectorSearchGroupFragment.FileSelectorSearchAdapter.1(this));
    return localFileSelectorSearchResultPresenter;
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FileSelectorSearchResultView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment.FileSelectorSearchAdapter
 * JD-Core Version:    0.7.0.1
 */