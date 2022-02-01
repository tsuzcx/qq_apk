package com.tencent.mobileqq.search.fragment.searchentry;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchFEHotwordItems;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler.OnGetHotwordItemResultListener;

class SearchHippyEntryFragment$2
  implements SearchHotwordHandler.OnGetHotwordItemResultListener
{
  SearchHippyEntryFragment$2(SearchHippyEntryFragment paramSearchHippyEntryFragment) {}
  
  public void onResult(@NonNull SearchFEHotwordItems paramSearchFEHotwordItems)
  {
    if (SearchHippyEntryFragment.access$100(this.this$0) == null) {
      return;
    }
    SearchHippyEntryFragment.access$000(this.this$0);
    paramSearchFEHotwordItems = SearchHotwordHandler.getHotwordDataMap(SearchHippyEntryFragment.access$000(this.this$0), paramSearchFEHotwordItems.getJsonArrayStr());
    SearchHippyEntryFragment.access$100(this.this$0).sendActiveEvent(false, SearchHippyEntryFragment.access$200(this.this$0), paramSearchFEHotwordItems);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchHippyEntryFragment.2
 * JD-Core Version:    0.7.0.1
 */