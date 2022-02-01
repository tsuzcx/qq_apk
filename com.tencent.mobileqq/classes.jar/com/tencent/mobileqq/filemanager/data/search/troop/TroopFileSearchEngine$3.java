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
    if (TroopFileSearchEngine.h(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject2;
    if (this.a)
    {
      localObject1 = new ArrayList();
      localObject2 = this.b;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        if (TroopFileSearchEngine.i(this.this$0) == null) {
          TroopFileSearchEngine.b(this.this$0, new ArrayList());
        }
        TroopFileSearchEngine.i(this.this$0).addAll(this.b);
        localObject2 = TroopFileSearchEngine.i(this.this$0).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)((Iterator)localObject2).next();
          ((List)localObject1).add(new TroopFileSearchResultModel(TroopFileSearchEngine.f(this.this$0), TroopFileSearchEngine.e(this.this$0), TroopFileSearchEngine.d(this.this$0), localTroopFileSearchItemData));
        }
      }
      TroopFileSearchEngine.h(this.this$0).a((List)localObject1, 1);
    }
    else
    {
      TroopFileSearchEngine.h(this.this$0).a(new ArrayList(), 6);
    }
    long l = System.currentTimeMillis() - TroopFileSearchEngine.j(this.this$0);
    Object localObject1 = TroopFileSearchEngine.c(this.this$0).a();
    if ((!((String)localObject1).equals(TroopFileSearchEngine.d(this.this$0))) && (l >= 800L))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyFileSearchFinish currentKeyword[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] mLastKeyWord[");
      ((StringBuilder)localObject2).append(TroopFileSearchEngine.d(this.this$0));
      ((StringBuilder)localObject2).append("] timeInterval[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.e("TroopFileSearchEngine<QFile>", 2, ((StringBuilder)localObject2).toString());
      TroopFileSearchEngine.b(this.this$0);
      TroopFileSearchEngine.a(this.this$0, (String)localObject1);
      localObject1 = this.this$0;
      TroopFileSearchEngine.b((TroopFileSearchEngine)localObject1, TroopFileSearchEngine.d((TroopFileSearchEngine)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */