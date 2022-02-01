package com.tencent.mobileqq.search.fragment;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.widget.ListView;

class MessageSearchFragment$1
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  MessageSearchFragment$1(MessageSearchFragment paramMessageSearchFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    super(paramListView, paramIFaceDecoder);
  }
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new SearchResultPresenter(this.a.a);
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2131562976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */