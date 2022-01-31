package com.tencent.mobileqq.filemanager.data.search;

import apfe;
import awuv;
import awvi;
import java.util.ArrayList;
import java.util.List;

class ChatFileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  awuv<apfe> jdField_a_of_type_Awuv;
  awvi jdField_a_of_type_Awvi;
  
  private ChatFileManagerSearchEngine$SearchRunnable(ChatFileManagerSearchEngine paramChatFileManagerSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Awvi == null)
      {
        this.jdField_a_of_type_Awuv.a(new ArrayList(), 6);
        return;
      }
      awvi localawvi = this.jdField_a_of_type_Awvi;
      String str = this.jdField_a_of_type_Awvi.a;
      List localList = this.this$0.a(localawvi);
      try
      {
        if ((this.jdField_a_of_type_Awuv != null) && (localawvi == this.jdField_a_of_type_Awvi) && (str.equals(this.jdField_a_of_type_Awvi.a))) {
          this.jdField_a_of_type_Awuv.a(localList, 1);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */