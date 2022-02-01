package com.tencent.mobileqq.filemanager.data.search;

import asmd;
import bbff;
import bbfs;
import java.util.ArrayList;
import java.util.List;

class FileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  bbff<asmd> jdField_a_of_type_Bbff;
  bbfs jdField_a_of_type_Bbfs;
  
  private FileManagerSearchEngine$SearchRunnable(FileManagerSearchEngine paramFileManagerSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Bbfs == null)
      {
        this.jdField_a_of_type_Bbff.a(new ArrayList(), 6);
        return;
      }
      bbfs localbbfs = this.jdField_a_of_type_Bbfs;
      String str = this.jdField_a_of_type_Bbfs.a;
      List localList = this.this$0.a(localbbfs);
      try
      {
        if ((this.jdField_a_of_type_Bbff != null) && (localbbfs == this.jdField_a_of_type_Bbfs) && (str.equals(this.jdField_a_of_type_Bbfs.a))) {
          this.jdField_a_of_type_Bbff.a(localList, 1);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */