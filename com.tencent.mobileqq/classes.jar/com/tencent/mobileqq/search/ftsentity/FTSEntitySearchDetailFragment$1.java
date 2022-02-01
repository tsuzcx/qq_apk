package com.tencent.mobileqq.search.ftsentity;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.search.business.fts.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.presenter.FTSMessageSearchResultPresenter;
import com.tencent.widget.ListView;
import java.util.List;

class FTSEntitySearchDetailFragment$1
  extends BaseMvpFTSEntityAdapter<FTSEntitySearchResultDetailModel, SearchResultView>
{
  FTSEntitySearchDetailFragment$1(FTSEntitySearchDetailFragment paramFTSEntitySearchDetailFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder, List paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramIFaceDecoder, paramList, paramString, paramFTSEntitySearchDetailActivity);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FTSMessageSearchResultPresenter(FTSEntitySearchDetailFragment.a(this.d));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FTSMessageSearchResultView(paramViewGroup, 2131629239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */