package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FunctionSearchEngine;

public class FunctionSearchFragment
  extends BaseSearchFragment
{
  public static FunctionSearchFragment f()
  {
    return new FunctionSearchFragment();
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
  }
  
  protected BaseMvpAdapter b()
  {
    return new FunctionSearchFragment.2(this, this.l, this.n);
  }
  
  protected ISearchEngine c()
  {
    return new FunctionSearchEngine((QQAppInterface)this.p, -1);
  }
  
  protected String d()
  {
    return SearchEntryConfigManager.b();
  }
  
  protected String e()
  {
    return d();
  }
  
  protected int l()
  {
    return 120;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.l.setOnTouchListener(new FunctionSearchFragment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.FunctionSearchFragment
 * JD-Core Version:    0.7.0.1
 */