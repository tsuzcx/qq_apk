package com.tencent.mobileqq.filemanager.data.search.troop;

import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import java.util.List;

class TroopFileSearchEngine$5
  implements Runnable
{
  TroopFileSearchEngine$5(TroopFileSearchEngine paramTroopFileSearchEngine, int paramInt, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.this$0.jdField_a_of_type_JavaUtilList = TroopFileSearchManager.a(this.jdField_a_of_type_JavaUtilList);
      TroopFileSearchEngine localTroopFileSearchEngine = this.this$0;
      TroopFileSearchEngine.a(localTroopFileSearchEngine, TroopFileSearchEngine.a(localTroopFileSearchEngine), TroopFileSearchEngine.b(this.this$0), this.this$0.jdField_a_of_type_JavaUtilList, TroopFileSearchEngine.a(this.this$0), TroopFileSearchEngine.b(this.this$0));
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    TroopFileSearchEngine.a(this.this$0, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5
 * JD-Core Version:    0.7.0.1
 */