package com.tencent.mobileqq.search.business.contact.fragment;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultMobileMultiPresenter;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultMobilePresenter;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.business.contact.presenter.SelectMemberContactSearchResultPresenter;
import com.tencent.mobileqq.search.business.contact.presenter.TroopAddFrdsSrchResultMultiPresenter;
import com.tencent.mobileqq.search.business.contact.presenter.TroopAddFrdsSrchResultPresenter;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultMobileView;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import com.tencent.mobileqq.search.business.troop.view.TroopAddFrdsSrchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.widget.ListView;

class ContactSearchFragment$2
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  ContactSearchFragment$2(ContactSearchFragment paramContactSearchFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    super(paramListView, paramIFaceDecoder);
  }
  
  protected IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    if (ContactSearchFragment.a(this.a) == -1) {
      return new SelectMemberContactSearchResultPresenter(this.b, ContactSearchFragment.b(this.a), ContactSearchFragment.c(this.a), ContactSearchFragment.d(this.a));
    }
    if (ContactSearchFragment.a(this.a) == 17) {
      return new ContactSearchResultMobilePresenter(this.b, ContactSearchFragment.b(this.a));
    }
    if (ContactSearchFragment.a(this.a) == 19) {
      return new ContactSearchResultMobileMultiPresenter(this.b, ContactSearchFragment.b(this.a), ContactSearchFragment.e(this.a));
    }
    if (ContactSearchFragment.a(this.a) == 23) {
      return new TroopAddFrdsSrchResultPresenter(this.b, null);
    }
    if (ContactSearchFragment.a(this.a) == 24) {
      return new TroopAddFrdsSrchResultMultiPresenter(this.b, ContactSearchFragment.b(this.a), ContactSearchFragment.c(this.a));
    }
    return new ContactSearchResultPresenter(this.b, ContactSearchFragment.b(this.a), ContactSearchFragment.c(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((!SearchUtils.b(ContactSearchFragment.a(this.a))) && (ContactSearchFragment.a(this.a) != 5) && (ContactSearchFragment.a(this.a) != 8))
    {
      if ((ContactSearchFragment.a(this.a) != -1) && (ContactSearchFragment.a(this.a) != 19) && (ContactSearchFragment.a(this.a) != 24))
      {
        if (ContactSearchFragment.a(this.a) == 17) {
          return new ContactSearchResultMobileView(paramViewGroup, 2131627372);
        }
        if (ContactSearchFragment.a(this.a) == 23) {
          return new TroopAddFrdsSrchResultView(paramViewGroup, 2131627372);
        }
        return new ContactSearchResultView(paramViewGroup, 2131629235);
      }
      return new ContactSearchResultView(paramViewGroup, 2131629236);
    }
    return new ContactSearchResultView(paramViewGroup, 2131629237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */