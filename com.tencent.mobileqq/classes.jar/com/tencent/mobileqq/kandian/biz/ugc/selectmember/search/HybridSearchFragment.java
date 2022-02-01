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
  private HybridSearchFragment.OnSearchResultClickListener a;
  private Set<String> b = new HashSet();
  
  public static HybridSearchFragment f()
  {
    return new HybridSearchFragment();
  }
  
  public void a(HybridSearchFragment.OnSearchResultClickListener paramOnSearchResultClickListener)
  {
    this.a = paramOnSearchResultClickListener;
  }
  
  protected BaseMvpAdapter b()
  {
    return new HybridSearchFragment.1(this, this.l, this.n);
  }
  
  public void b_(List<String> paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
  }
  
  protected ISearchEngine c()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(AppConstants.BABY_Q_UIN);
    localArrayList.add(new ContactSearchEngine((QQAppInterface)this.p, -1, 1, null, localHashSet));
    localArrayList.add(new FollowingSearchEngine());
    return new SelectMemberHybridSearchEngine(localArrayList);
  }
  
  protected boolean cj_()
  {
    return false;
  }
  
  public void onAction(View paramView)
  {
    paramView = (ISearchResultModel)paramView.getTag(2131449867);
    HybridSearchFragment.OnSearchResultClickListener localOnSearchResultClickListener = this.a;
    if (localOnSearchResultClickListener != null) {
      localOnSearchResultClickListener.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */