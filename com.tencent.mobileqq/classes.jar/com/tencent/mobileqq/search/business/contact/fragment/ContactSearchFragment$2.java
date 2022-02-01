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
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) == -1) {
      return new SelectMemberContactSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment), ContactSearchFragment.b(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) == 17) {
      return new ContactSearchResultMobilePresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) == 19) {
      return new ContactSearchResultMobileMultiPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) == 23) {
      return new TroopAddFrdsSrchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, null);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) == 24) {
      return new TroopAddFrdsSrchResultMultiPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment));
    }
    return new ContactSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((!SearchUtils.a(ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment))) && (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) != 5) && (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) != 8))
    {
      if ((ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) != -1) && (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) != 19) && (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) != 24))
      {
        if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) == 17) {
          return new ContactSearchResultMobileView(paramViewGroup, 2131561031);
        }
        if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment) == 23) {
          return new TroopAddFrdsSrchResultView(paramViewGroup, 2131561031);
        }
        return new ContactSearchResultView(paramViewGroup, 2131562790);
      }
      return new ContactSearchResultView(paramViewGroup, 2131562791);
    }
    return new ContactSearchResultView(paramViewGroup, 2131562792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */