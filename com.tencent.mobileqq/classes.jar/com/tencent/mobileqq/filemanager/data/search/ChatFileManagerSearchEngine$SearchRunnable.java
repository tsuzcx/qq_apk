package com.tencent.mobileqq.filemanager.data.search;

import atqf;
import bclx;
import bcmk;
import java.util.ArrayList;
import java.util.List;

class ChatFileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  bclx<atqf> jdField_a_of_type_Bclx;
  bcmk jdField_a_of_type_Bcmk;
  
  private ChatFileManagerSearchEngine$SearchRunnable(ChatFileManagerSearchEngine paramChatFileManagerSearchEngine) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */