package com.tencent.mobileqq.search.base.fragment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import mqq.os.MqqHandler;

class BaseSearchFragment$2
  implements Runnable
{
  BaseSearchFragment$2(BaseSearchFragment paramBaseSearchFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.this$0.u)
    {
      this.this$0.o.a();
      this.this$0.u = true;
    }
    ThreadManager.getUIHandler().post(new BaseSearchFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.fragment.BaseSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */