package com.tencent.mobileqq.filemanager.data.search;

import aooj;
import avva;
import avvn;
import java.util.ArrayList;
import java.util.List;

class FileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  avva<aooj> jdField_a_of_type_Avva;
  avvn jdField_a_of_type_Avvn;
  
  private FileManagerSearchEngine$SearchRunnable(FileManagerSearchEngine paramFileManagerSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Avvn == null)
      {
        this.jdField_a_of_type_Avva.a(new ArrayList(), 6);
        return;
      }
      avvn localavvn = this.jdField_a_of_type_Avvn;
      String str = this.jdField_a_of_type_Avvn.a;
      List localList = this.this$0.a(localavvn);
      try
      {
        if ((this.jdField_a_of_type_Avva != null) && (localavvn == this.jdField_a_of_type_Avvn) && (str.equals(this.jdField_a_of_type_Avvn.a))) {
          this.jdField_a_of_type_Avva.a(localList, 1);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */