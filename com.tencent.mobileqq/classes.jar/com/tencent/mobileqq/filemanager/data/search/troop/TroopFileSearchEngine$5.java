package com.tencent.mobileqq.filemanager.data.search.troop;

import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import java.util.List;

class TroopFileSearchEngine$5
  implements Runnable
{
  TroopFileSearchEngine$5(TroopFileSearchEngine paramTroopFileSearchEngine, int paramInt, List paramList) {}
  
  public void run()
  {
    if (this.a == 1)
    {
      this.this$0.a = TroopFileSearchManager.a(this.b);
      TroopFileSearchEngine localTroopFileSearchEngine = this.this$0;
      TroopFileSearchEngine.a(localTroopFileSearchEngine, TroopFileSearchEngine.f(localTroopFileSearchEngine), TroopFileSearchEngine.m(this.this$0), this.this$0.a, TroopFileSearchEngine.d(this.this$0), TroopFileSearchEngine.k(this.this$0));
      this.b.clear();
      return;
    }
    TroopFileSearchEngine.a(this.this$0, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5
 * JD-Core Version:    0.7.0.1
 */