package com.tencent.mobileqq.search.fragment;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.widget.ListView;

class FunctionSearchFragment$2
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  FunctionSearchFragment$2(FunctionSearchFragment paramFunctionSearchFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    super(paramListView, paramIFaceDecoder);
  }
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new ActiveEntitySearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, 268435456);
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultFromNetView(paramViewGroup, 268435456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.FunctionSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */