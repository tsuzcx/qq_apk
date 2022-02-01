package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter.CommonEvent;

class SearchHotwordHandler$2
  implements SearchHotwordHandler.OnGetHotwordItemResultListener
{
  SearchHotwordHandler$2(SearchHotwordHandler paramSearchHotwordHandler) {}
  
  public void onResult(@NonNull SearchFEHotwordItems paramSearchFEHotwordItems)
  {
    if (SearchHotwordHandler.access$200(this.this$0) == null) {
      return;
    }
    paramSearchFEHotwordItems = SearchHotwordHandler.getHotwordDataMap(this.this$0, paramSearchFEHotwordItems.getJsonArrayStr());
    SearchHotwordHandler.access$200(this.this$0).sendCommonEvent(SearchHippyEventEmitter.CommonEvent.HotwordChanged, paramSearchFEHotwordItems);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler.2
 * JD-Core Version:    0.7.0.1
 */