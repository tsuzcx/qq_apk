package com.tencent.mobileqq.search.fragment;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.adapter.BaseMvpMessageAdapter;
import com.tencent.mobileqq.search.model.MessageSearchResultDetailModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.widget.ListView;

class MessageSearchDetailFragment$1
  extends BaseMvpMessageAdapter<MessageSearchResultDetailModel, SearchResultView>
{
  MessageSearchDetailFragment$1(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramIFaceDecoder, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  public IPresenter a(int paramInt)
  {
    return new SearchResultPresenter(MessageSearchDetailFragment.a(this.a));
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2131562979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */