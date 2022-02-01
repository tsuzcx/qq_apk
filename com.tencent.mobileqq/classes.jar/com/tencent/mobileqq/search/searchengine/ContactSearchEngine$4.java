package com.tencent.mobileqq.search.searchengine;

import java.util.List;

class ContactSearchEngine$4
  implements Runnable
{
  ContactSearchEngine$4(ContactSearchEngine paramContactSearchEngine, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    List localList1 = ContactSearchEngine.a(this.this$0, this.a);
    ISearchListener localISearchListener = ContactSearchEngine.a(this.this$0);
    SearchRespData localSearchRespData;
    if ((localISearchListener != null) && (localList1 != null))
    {
      localSearchRespData = new SearchRespData(this.a.a, 1);
      if (ContactSearchEngine.a(this.this$0) == null) {
        localISearchListener.a(localList1, localSearchRespData);
      }
    }
    else
    {
      return;
    }
    localISearchListener.a(localList1);
    List localList2 = ContactSearchEngine.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localISearchListener.a(localList1, localSearchRespData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */