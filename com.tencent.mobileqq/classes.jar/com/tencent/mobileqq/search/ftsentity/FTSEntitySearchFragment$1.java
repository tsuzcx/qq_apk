package com.tencent.mobileqq.search.ftsentity;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.FTSMessageSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.widget.ListView;

class FTSEntitySearchFragment$1
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  FTSEntitySearchFragment$1(FTSEntitySearchFragment paramFTSEntitySearchFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    super(paramListView, paramIFaceDecoder);
  }
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new FTSMessageSearchResultPresenter(FTSEntitySearchFragment.a(this.a));
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FTSMessageSearchResultView(paramViewGroup, 2131562977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment.1
 * JD-Core Version:    0.7.0.1
 */