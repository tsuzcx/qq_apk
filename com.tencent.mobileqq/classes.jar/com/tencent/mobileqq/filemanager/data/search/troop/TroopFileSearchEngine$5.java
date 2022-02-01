package com.tencent.mobileqq.filemanager.data.search.troop;

import atrj;
import bfmp;
import java.util.List;

public class TroopFileSearchEngine$5
  implements Runnable
{
  public TroopFileSearchEngine$5(atrj paramatrj, int paramInt, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.this$0.jdField_a_of_type_JavaUtilList = bfmp.a(this.jdField_a_of_type_JavaUtilList);
      atrj.a(this.this$0, atrj.a(this.this$0), atrj.b(this.this$0), this.this$0.jdField_a_of_type_JavaUtilList, atrj.a(this.this$0), atrj.b(this.this$0));
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    atrj.a(this.this$0, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5
 * JD-Core Version:    0.7.0.1
 */