package com.tencent.mobileqq.kandian.biz.ugc.selectmember.search;

import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements ContactSearchResultPresenter.OnActionListener
{
  private HybridSearchFragment.OnSearchResultClickListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment$OnSearchResultClickListener;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  protected BaseMvpAdapter a()
  {
    return new HybridSearchFragment.1(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(AppConstants.BABY_Q_UIN);
    localArrayList.add(new ContactSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new FollowingSearchEngine());
    return new SelectMemberHybridSearchEngine(localArrayList);
  }
  
  public void a(HybridSearchFragment.OnSearchResultClickListener paramOnSearchResultClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment$OnSearchResultClickListener = paramOnSearchResultClickListener;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b_(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilSet.addAll(paramList);
    }
  }
  
  public void onAction(View paramView)
  {
    paramView = (ISearchResultModel)paramView.getTag(2131380884);
    HybridSearchFragment.OnSearchResultClickListener localOnSearchResultClickListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment$OnSearchResultClickListener;
    if (localOnSearchResultClickListener != null) {
      localOnSearchResultClickListener.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */