package com.tencent.mobileqq.filemanager.data.search.troop;

import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
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
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new ArrayList();
      localObject2 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        if (TroopFileSearchEngine.a(this.this$0) == null) {
          TroopFileSearchEngine.b(this.this$0, new ArrayList());
        }
        TroopFileSearchEngine.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        localObject2 = TroopFileSearchEngine.a(this.this$0).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)((Iterator)localObject2).next();
          ((List)localObject1).add(new TroopFileSearchResultModel(TroopFileSearchEngine.a(this.this$0), TroopFileSearchEngine.a(this.this$0), TroopFileSearchEngine.a(this.this$0), localTroopFileSearchItemData));
        }
      }
      TroopFileSearchEngine.a(this.this$0).a((List)localObject1, 1);
    }
    else
    {
      TroopFileSearchEngine.a(this.this$0).a(new ArrayList(), 6);
    }
    long l = System.currentTimeMillis() - TroopFileSearchEngine.a(this.this$0);
    Object localObject1 = TroopFileSearchEngine.a(this.this$0).c();
    if ((!((String)localObject1).equals(TroopFileSearchEngine.a(this.this$0))) && (l >= 800L))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyFileSearchFinish currentKeyword[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] mLastKeyWord[");
      ((StringBuilder)localObject2).append(TroopFileSearchEngine.a(this.this$0));
      ((StringBuilder)localObject2).append("] timeInterval[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.e("TroopFileSearchEngine<QFile>", 2, ((StringBuilder)localObject2).toString());
      TroopFileSearchEngine.a(this.this$0);
      TroopFileSearchEngine.a(this.this$0, (String)localObject1);
      localObject1 = this.this$0;
      TroopFileSearchEngine.a((TroopFileSearchEngine)localObject1, TroopFileSearchEngine.a((TroopFileSearchEngine)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */