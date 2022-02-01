package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.List;

public class TroopFileSearchFragment
  extends BaseSearchFragment<ISearchResultModel>
  implements ISearchViewBinder, AbsListView.OnScrollListener
{
  public int a;
  public long b;
  protected BizTroopObserver c = new TroopFileSearchFragment.1(this);
  private TroopFileSearchEngine d;
  private TroopFileSearchFragment.TroopFileSearchAdapter e;
  private int f = 0;
  private int g = 0;
  private QFileListPullMoreLayout h;
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.setVisibility(0);
      this.h.setTextLeftDrawable(2130839585);
      return;
    }
    this.h.setVisibility(8);
    this.h.a();
  }
  
  public String a()
  {
    return this.q;
  }
  
  protected BaseMvpAdapter b()
  {
    this.e = new TroopFileSearchFragment.TroopFileSearchAdapter(this);
    return this.e;
  }
  
  protected ISearchEngine c()
  {
    this.d = new TroopFileSearchEngine((QQAppInterface)this.p, getQBaseActivity(), this.b, this.a, this);
    this.d.a(1);
    return this.d;
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899282);
  }
  
  protected void h_(boolean paramBoolean)
  {
    if ((!this.d.b(this.q)) && (paramBoolean))
    {
      d(true);
      return;
    }
    d(false);
    super.h_(paramBoolean);
  }
  
  protected void o_(boolean paramBoolean)
  {
    d(false);
    super.o_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.k.findViewById(2131434940).setVisibility(8);
    this.l.setOnScrollListener(this);
    this.h = new QFileListPullMoreLayout(getQBaseActivity());
    this.h.setBackgroundResource(2130838958);
    this.h.setTextColor(getResources().getColor(2131167993));
    this.l.addFooterView(this.h);
    this.h.setVisibility(8);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TroopFileSearchEngine localTroopFileSearchEngine = this.d;
    if (localTroopFileSearchEngine != null) {
      localTroopFileSearchEngine.e();
    }
    if (this.c != null) {
      this.p.removeObserver(this.c);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    TroopFileSearchEngine localTroopFileSearchEngine = this.d;
    if (localTroopFileSearchEngine != null) {
      localTroopFileSearchEngine.c();
    }
    if (this.c != null) {
      this.p.removeObserver(this.c);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    TroopFileSearchEngine localTroopFileSearchEngine = this.d;
    if (localTroopFileSearchEngine != null) {
      localTroopFileSearchEngine.d();
    }
    if (this.c != null) {
      this.p.addObserver(this.c);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = paramInt3;
    this.f = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.r != null) && (!this.r.isEmpty()) && (this.f == this.g - 2))
    {
      if (this.d.b(this.q)) {
        return;
      }
      this.d.a(this.q);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */