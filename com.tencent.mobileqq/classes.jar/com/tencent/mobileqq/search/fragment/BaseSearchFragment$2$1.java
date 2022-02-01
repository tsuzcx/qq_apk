package com.tencent.mobileqq.search.fragment;

import android.text.TextUtils;
import android.view.View;

class BaseSearchFragment$2$1
  implements Runnable
{
  BaseSearchFragment$2$1(BaseSearchFragment.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.isDetached()) {
      return;
    }
    this.a.this$0.c();
    if ((!TextUtils.isEmpty(this.a.this$0.c)) || (this.a.a))
    {
      this.a.this$0.a(this.a.this$0.c);
      return;
    }
    this.a.this$0.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.BaseSearchFragment.2.1
 * JD-Core Version:    0.7.0.1
 */