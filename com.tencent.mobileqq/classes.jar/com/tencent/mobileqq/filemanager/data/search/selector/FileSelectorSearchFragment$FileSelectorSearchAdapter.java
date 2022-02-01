package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import java.util.List;

class FileSelectorSearchFragment$FileSelectorSearchAdapter
  extends BaseMvpAdapter<ISearchResultModel, ISearchResultView>
{
  public FileSelectorSearchFragment$FileSelectorSearchAdapter(FileSelectorSearchFragment paramFileSelectorSearchFragment) {}
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    FileSelectorSearchResultPresenter localFileSelectorSearchResultPresenter = new FileSelectorSearchResultPresenter();
    localFileSelectorSearchResultPresenter.a(new FileSelectorSearchFragment.FileSelectorSearchAdapter.1(this));
    return localFileSelectorSearchResultPresenter;
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FileSelectorSearchResultView(paramViewGroup);
  }
  
  public void a(List<ISearchResultModel> paramList)
  {
    super.a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.2(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.3(this));
  }
  
  public void a(List<ISearchResultModel> paramList, boolean paramBoolean)
  {
    super.a(paramList, paramBoolean);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.4(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter
 * JD-Core Version:    0.7.0.1
 */