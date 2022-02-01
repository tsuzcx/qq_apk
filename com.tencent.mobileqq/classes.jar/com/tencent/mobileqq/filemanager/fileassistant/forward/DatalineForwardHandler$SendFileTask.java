package com.tencent.mobileqq.filemanager.fileassistant.forward;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import java.util.Iterator;
import java.util.List;

class DatalineForwardHandler$SendFileTask
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  DatalineForwardHandler$SendFileTask(List<String> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  DatalineForwardHandler$SendFileTask(List<String> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramInt;
    int i;
    this.jdField_a_of_type_Int = i;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = DatalineForwardHandler.a(this.this$0, str);
      if (this.jdField_a_of_type_Int != -1) {
        this.this$0.a.getFileManagerEngine().a(str, "", DatalineForwardHandler.a(this.this$0), 0, true, 0L, this.jdField_a_of_type_Int);
      } else {
        this.this$0.a.getFileManagerEngine().a(str, "", DatalineForwardHandler.a(this.this$0), 0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineForwardHandler.SendFileTask
 * JD-Core Version:    0.7.0.1
 */