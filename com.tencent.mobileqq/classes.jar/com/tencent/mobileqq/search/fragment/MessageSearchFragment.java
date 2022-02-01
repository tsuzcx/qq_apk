package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  public void a(String paramString)
  {
    super.a(paramString, 2);
  }
  
  protected BaseMvpAdapter b()
  {
    return new MessageSearchFragment.1(this, this.l, this.n);
  }
  
  protected ISearchEngine c()
  {
    return new MessageSearchEngine((QQAppInterface)this.p);
  }
  
  protected String d()
  {
    return getString(2131916109);
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899285);
  }
  
  protected int l()
  {
    return 40;
  }
  
  public void onPause()
  {
    super.onPause();
    this.o.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.o.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */