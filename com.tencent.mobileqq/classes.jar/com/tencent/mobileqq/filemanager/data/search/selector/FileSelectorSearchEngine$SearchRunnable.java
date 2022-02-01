package com.tencent.mobileqq.filemanager.data.search.selector;

import atrb;
import bclx;
import bcmk;
import java.util.ArrayList;
import java.util.List;

class FileSelectorSearchEngine$SearchRunnable
  implements Runnable
{
  bclx<atrb> jdField_a_of_type_Bclx;
  bcmk jdField_a_of_type_Bcmk;
  
  private FileSelectorSearchEngine$SearchRunnable(FileSelectorSearchEngine paramFileSelectorSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Bcmk == null)
      {
        this.jdField_a_of_type_Bclx.a(new ArrayList(), 6);
        return;
      }
      bcmk localbcmk = this.jdField_a_of_type_Bcmk;
      String str = this.jdField_a_of_type_Bcmk.a;
      List localList = this.this$0.a(localbcmk);
      try
      {
        if ((this.jdField_a_of_type_Bclx != null) && (localbcmk == this.jdField_a_of_type_Bcmk) && (str.equals(this.jdField_a_of_type_Bcmk.a))) {
          this.jdField_a_of_type_Bclx.a(localList, 1);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */