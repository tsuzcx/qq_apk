package com.tencent.mobileqq.filemanager.data.search.troop;

import apgi;
import aztd;
import java.util.List;

public class TroopFileSearchEngine$5
  implements Runnable
{
  public TroopFileSearchEngine$5(apgi paramapgi, int paramInt, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.this$0.jdField_a_of_type_JavaUtilList = aztd.a(this.jdField_a_of_type_JavaUtilList);
      apgi.a(this.this$0, apgi.a(this.this$0), apgi.b(this.this$0), this.this$0.jdField_a_of_type_JavaUtilList, apgi.a(this.this$0), apgi.b(this.this$0));
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    apgi.a(this.this$0, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5
 * JD-Core Version:    0.7.0.1
 */