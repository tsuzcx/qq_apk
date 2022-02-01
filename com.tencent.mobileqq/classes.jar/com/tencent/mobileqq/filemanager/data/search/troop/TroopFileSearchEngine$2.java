package com.tencent.mobileqq.filemanager.data.search.troop;

import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.qphone.base.util.QLog;

class TroopFileSearchEngine$2
  implements Runnable
{
  TroopFileSearchEngine$2(TroopFileSearchEngine paramTroopFileSearchEngine) {}
  
  public void run()
  {
    Object localObject = TroopFileSearchManager.a();
    TroopFileSearchEngine localTroopFileSearchEngine = this.this$0;
    TroopFileSearchEngine.a(localTroopFileSearchEngine, ((TroopFileSearchManager)localObject).a(TroopFileSearchEngine.a(localTroopFileSearchEngine), TroopFileSearchEngine.a(this.this$0), 0));
    if (TroopFileSearchEngine.b(this.this$0))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "collectContactInfos. need do search. execSearch.");
      TroopFileSearchEngine.a(this.this$0);
      localObject = this.this$0;
      TroopFileSearchEngine.a((TroopFileSearchEngine)localObject, TroopFileSearchEngine.a((TroopFileSearchEngine)localObject).c());
      localObject = this.this$0;
      TroopFileSearchEngine.a((TroopFileSearchEngine)localObject, TroopFileSearchEngine.a((TroopFileSearchEngine)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */