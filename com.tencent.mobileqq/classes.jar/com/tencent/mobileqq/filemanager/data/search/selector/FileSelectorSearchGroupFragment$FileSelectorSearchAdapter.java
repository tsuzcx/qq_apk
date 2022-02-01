package com.tencent.mobileqq.filemanager.data.search.selector;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

class FileSelectorSearchGroupFragment$FileSelectorSearchAdapter
  extends BaseMvpAdapter<ISearchResultModel, ISearchResultView>
{
  public FileSelectorSearchGroupFragment$FileSelectorSearchAdapter(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment, FileSelectorSearchResultModel paramFileSelectorSearchResultModel)
  {
    try
    {
      paramFileSelectorSearchGroupFragment = paramFileSelectorSearchResultModel.a(paramFileSelectorSearchGroupFragment.getBaseActivity().app, paramFileSelectorSearchGroupFragment.getBaseActivity());
      if ((paramFileSelectorSearchGroupFragment != null) && (!paramFileSelectorSearchGroupFragment.isEmpty())) {
        a(paramFileSelectorSearchGroupFragment);
      }
      return;
    }
    catch (Exception paramFileSelectorSearchGroupFragment) {}
  }
  
  protected IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    FileSelectorSearchResultPresenter localFileSelectorSearchResultPresenter = new FileSelectorSearchResultPresenter();
    localFileSelectorSearchResultPresenter.a(new FileSelectorSearchGroupFragment.FileSelectorSearchAdapter.1(this));
    return localFileSelectorSearchResultPresenter;
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FileSelectorSearchResultView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment.FileSelectorSearchAdapter
 * JD-Core Version:    0.7.0.1
 */