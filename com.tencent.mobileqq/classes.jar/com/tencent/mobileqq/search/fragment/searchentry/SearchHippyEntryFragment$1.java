package com.tencent.mobileqq.search.fragment.searchentry;

import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;

class SearchHippyEntryFragment$1
  implements Runnable
{
  SearchHippyEntryFragment$1(SearchHippyEntryFragment paramSearchHippyEntryFragment, boolean paramBoolean) {}
  
  public void run()
  {
    SearchHippyEntryFragment.access$000(this.this$0).setHotwordVisibility(this.val$isHotwordVisible);
    if ((this.this$0.getQBaseActivity() instanceof UniteSearchActivity)) {
      ((UniteSearchActivity)this.this$0.getQBaseActivity()).a(this.val$isHotwordVisible);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchHippyEntryFragment.1
 * JD-Core Version:    0.7.0.1
 */