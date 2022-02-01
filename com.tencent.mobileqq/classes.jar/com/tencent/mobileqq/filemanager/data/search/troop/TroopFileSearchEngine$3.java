package com.tencent.mobileqq.filemanager.data.search.troop;

import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopFileSearchEngine$3
  implements Runnable
{
  TroopFileSearchEngine$3(TroopFileSearchEngine paramTroopFileSearchEngine, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (TroopFileSearchEngine.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (TroopFileSearchEngine.a(this.this$0) == null) {
          TroopFileSearchEngine.b(this.this$0, new ArrayList());
        }
        TroopFileSearchEngine.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = TroopFileSearchEngine.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)localIterator.next();
          ((List)localObject).add(new TroopFileSearchResultModel(TroopFileSearchEngine.a(this.this$0), TroopFileSearchEngine.a(this.this$0), TroopFileSearchEngine.a(this.this$0), localTroopFileSearchItemData));
        }
      }
      TroopFileSearchEngine.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - TroopFileSearchEngine.a(this.this$0);
      localObject = TroopFileSearchEngine.a(this.this$0).b();
      if ((!((String)localObject).equals(TroopFileSearchEngine.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + TroopFileSearchEngine.a(this.this$0) + "] timeInterval[" + l + "]");
        TroopFileSearchEngine.a(this.this$0);
        TroopFileSearchEngine.a(this.this$0, (String)localObject);
        TroopFileSearchEngine.a(this.this$0, TroopFileSearchEngine.a(this.this$0));
      }
      return;
      TroopFileSearchEngine.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */