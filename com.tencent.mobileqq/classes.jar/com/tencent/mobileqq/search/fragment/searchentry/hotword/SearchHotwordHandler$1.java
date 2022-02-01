package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SearchHotwordHandler$1
  implements Runnable
{
  SearchHotwordHandler$1(SearchHotwordHandler paramSearchHotwordHandler, SearchHotwordHandler.OnGetHotwordItemResultListener paramOnGetHotwordItemResultListener) {}
  
  public void run()
  {
    SearchHotwordHandler.access$000(this.this$0).a();
    Object localObject = SearchHotwordHandler.access$000(this.this$0).a();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject).next();
        localArrayList.add(SearchHotwordHandler.access$100(this.this$0, localHotSearchItem));
      }
    }
    this.val$listener.onResult(new SearchFEHotwordItems(localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler.1
 * JD-Core Version:    0.7.0.1
 */