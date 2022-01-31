package com.tencent.mobileqq.search.fragment;

import android.text.TextUtils;

class BaseSearchFragment$2$1
  implements Runnable
{
  BaseSearchFragment$2$1(BaseSearchFragment.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.isDetached()) {}
    do
    {
      return;
      this.a.this$0.c();
    } while ((TextUtils.isEmpty(this.a.this$0.c)) && (!this.a.a));
    this.a.this$0.a(this.a.this$0.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.BaseSearchFragment.2.1
 * JD-Core Version:    0.7.0.1
 */