package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import java.util.List;

class ContactSearchEngine$4
  implements Runnable
{
  ContactSearchEngine$4(ContactSearchEngine paramContactSearchEngine, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    List localList1 = ContactSearchEngine.a(this.this$0, this.a);
    ISearchListener localISearchListener = ContactSearchEngine.a(this.this$0);
    if ((localISearchListener != null) && (localList1 != null))
    {
      SearchRespData localSearchRespData = new SearchRespData(this.a.a, 1);
      if (ContactSearchEngine.a(this.this$0) == null)
      {
        localISearchListener.a(localList1, localSearchRespData);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */