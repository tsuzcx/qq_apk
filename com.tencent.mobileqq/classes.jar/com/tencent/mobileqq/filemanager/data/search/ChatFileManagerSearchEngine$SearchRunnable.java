package com.tencent.mobileqq.filemanager.data.search;

import arcl;
import ayuh;
import ayuu;
import java.util.ArrayList;
import java.util.List;

class ChatFileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  ayuh<arcl> jdField_a_of_type_Ayuh;
  ayuu jdField_a_of_type_Ayuu;
  
  private ChatFileManagerSearchEngine$SearchRunnable(ChatFileManagerSearchEngine paramChatFileManagerSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Ayuu == null)
      {
        this.jdField_a_of_type_Ayuh.a(new ArrayList(), 6);
        return;
      }
      ayuu localayuu = this.jdField_a_of_type_Ayuu;
      String str = this.jdField_a_of_type_Ayuu.a;
      List localList = this.this$0.a(localayuu);
      try
      {
        if ((this.jdField_a_of_type_Ayuh != null) && (localayuu == this.jdField_a_of_type_Ayuu) && (str.equals(this.jdField_a_of_type_Ayuu.a))) {
          this.jdField_a_of_type_Ayuh.a(localList, 1);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */