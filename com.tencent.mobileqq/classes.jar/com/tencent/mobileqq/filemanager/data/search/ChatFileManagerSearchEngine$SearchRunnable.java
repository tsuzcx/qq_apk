package com.tencent.mobileqq.filemanager.data.search;

import atzp;
import bcmd;
import bcmq;
import java.util.ArrayList;
import java.util.List;

class ChatFileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  bcmd<atzp> jdField_a_of_type_Bcmd;
  bcmq jdField_a_of_type_Bcmq;
  
  private ChatFileManagerSearchEngine$SearchRunnable(ChatFileManagerSearchEngine paramChatFileManagerSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Bcmq == null)
      {
        this.jdField_a_of_type_Bcmd.a(new ArrayList(), 6);
        return;
      }
      bcmq localbcmq = this.jdField_a_of_type_Bcmq;
      String str = this.jdField_a_of_type_Bcmq.a;
      List localList = this.this$0.a(localbcmq);
      try
      {
        if ((this.jdField_a_of_type_Bcmd != null) && (localbcmq == this.jdField_a_of_type_Bcmq) && (str.equals(this.jdField_a_of_type_Bcmq.a))) {
          this.jdField_a_of_type_Bcmd.a(localList, 1);
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