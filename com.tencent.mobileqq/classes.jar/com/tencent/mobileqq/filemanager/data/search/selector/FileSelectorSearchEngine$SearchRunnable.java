package com.tencent.mobileqq.filemanager.data.search.selector;

import aqyy;
import aypy;
import ayql;
import java.util.ArrayList;
import java.util.List;

class FileSelectorSearchEngine$SearchRunnable
  implements Runnable
{
  aypy<aqyy> jdField_a_of_type_Aypy;
  ayql jdField_a_of_type_Ayql;
  
  private FileSelectorSearchEngine$SearchRunnable(FileSelectorSearchEngine paramFileSelectorSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Ayql == null)
      {
        this.jdField_a_of_type_Aypy.a(new ArrayList(), 6);
        return;
      }
      ayql localayql = this.jdField_a_of_type_Ayql;
      String str = this.jdField_a_of_type_Ayql.a;
      List localList = this.this$0.a(localayql);
      try
      {
        if ((this.jdField_a_of_type_Aypy != null) && (localayql == this.jdField_a_of_type_Ayql) && (str.equals(this.jdField_a_of_type_Ayql.a))) {
          this.jdField_a_of_type_Aypy.a(localList, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */