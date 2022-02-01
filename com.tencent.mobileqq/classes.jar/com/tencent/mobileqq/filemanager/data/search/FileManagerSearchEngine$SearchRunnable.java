package com.tencent.mobileqq.filemanager.data.search;

import athz;
import bbtk;
import bbtx;
import java.util.ArrayList;
import java.util.List;

class FileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  bbtk<athz> jdField_a_of_type_Bbtk;
  bbtx jdField_a_of_type_Bbtx;
  
  private FileManagerSearchEngine$SearchRunnable(FileManagerSearchEngine paramFileManagerSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Bbtx == null)
      {
        this.jdField_a_of_type_Bbtk.a(new ArrayList(), 6);
        return;
      }
      bbtx localbbtx = this.jdField_a_of_type_Bbtx;
      String str = this.jdField_a_of_type_Bbtx.a;
      List localList = this.this$0.a(localbbtx);
      try
      {
        if ((this.jdField_a_of_type_Bbtk != null) && (localbbtx == this.jdField_a_of_type_Bbtx) && (str.equals(this.jdField_a_of_type_Bbtx.a))) {
          this.jdField_a_of_type_Bbtk.a(localList, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */