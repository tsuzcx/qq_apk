package com.tencent.mobileqq.filemanager.fileassistant.forward;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import java.util.Iterator;
import java.util.List;

class DatalineForwardHandler$SendFileTask
  implements Runnable
{
  private List<String> a;
  private int b = -1;
  
  DatalineForwardHandler$SendFileTask(List<String> paramList)
  {
    Object localObject;
    this.a = localObject;
  }
  
  DatalineForwardHandler$SendFileTask(List<String> paramList, int paramInt)
  {
    this.a = paramInt;
    int i;
    this.b = i;
  }
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = DatalineForwardHandler.a(this.this$0, str);
      if (this.b != -1) {
        this.this$0.a.getFileManagerEngine().a(str, "", DatalineForwardHandler.a(this.this$0), 0, true, 0L, this.b);
      } else {
        this.this$0.a.getFileManagerEngine().a(str, "", DatalineForwardHandler.a(this.this$0), 0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineForwardHandler.SendFileTask
 * JD-Core Version:    0.7.0.1
 */