package com.tencent.mobileqq.search.fragment.searchentry;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchFEHotwordItems;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler.OnGetHotwordItemResultListener;

class SearchHippyEntryFragment$3
  implements SearchHotwordHandler.OnGetHotwordItemResultListener
{
  SearchHippyEntryFragment$3(SearchHippyEntryFragment paramSearchHippyEntryFragment) {}
  
  public void onResult(@NonNull SearchFEHotwordItems paramSearchFEHotwordItems)
  {
    if (SearchHippyEntryFragment.access$100(this.this$0) == null) {
      return;
    }
    SearchHippyEntryFragment.access$000(this.this$0);
    paramSearchFEHotwordItems = SearchHotwordHandler.getHotwordDataMap(SearchHippyEntryFragment.access$000(this.this$0), paramSearchFEHotwordItems.getJsonArrayStr());
    SearchHippyEntryFragment.access$100(this.this$0).sendActiveEvent(true, SearchHippyEntryFragment.access$200(this.this$0), paramSearchFEHotwordItems);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchHippyEntryFragment.3
 * JD-Core Version:    0.7.0.1
 */