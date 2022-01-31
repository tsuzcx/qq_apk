package com.tencent.mobileqq.filemanager.data.search;

import apfe;
import awut;
import awvg;
import java.util.ArrayList;
import java.util.List;

class FileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  awut<apfe> jdField_a_of_type_Awut;
  awvg jdField_a_of_type_Awvg;
  
  private FileManagerSearchEngine$SearchRunnable(FileManagerSearchEngine paramFileManagerSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Awvg == null)
      {
        this.jdField_a_of_type_Awut.a(new ArrayList(), 6);
        return;
      }
      awvg localawvg = this.jdField_a_of_type_Awvg;
      String str = this.jdField_a_of_type_Awvg.a;
      List localList = this.this$0.a(localawvg);
      try
      {
        if ((this.jdField_a_of_type_Awut != null) && (localawvg == this.jdField_a_of_type_Awvg) && (str.equals(this.jdField_a_of_type_Awvg.a))) {
          this.jdField_a_of_type_Awut.a(localList, 1);
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