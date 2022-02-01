package com.tencent.mobileqq.kandian.biz.ugc.selectmember.search;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.presenter.SelectMemberContactSearchResultPresenter;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.widget.ListView;

class HybridSearchFragment$1
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  HybridSearchFragment$1(HybridSearchFragment paramHybridSearchFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    super(paramListView, paramIFaceDecoder);
  }
  
  protected IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    if (((ISearchResultModel)c(paramInt) instanceof ContactSearchModelFriend))
    {
      localIFaceDecoder = this.b;
      localHybridSearchFragment = this.a;
      return new SelectMemberContactSearchResultPresenter(localIFaceDecoder, localHybridSearchFragment, HybridSearchFragment.a(localHybridSearchFragment), null);
    }
    IFaceDecoder localIFaceDecoder = this.b;
    HybridSearchFragment localHybridSearchFragment = this.a;
    return new FollowSearchResultPresenter(localIFaceDecoder, localHybridSearchFragment, HybridSearchFragment.a(localHybridSearchFragment));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ContactSearchResultView(paramViewGroup, 2131629235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.HybridSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */