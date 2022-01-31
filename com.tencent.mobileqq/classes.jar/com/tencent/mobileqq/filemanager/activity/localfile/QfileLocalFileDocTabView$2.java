package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFileDocTabView$2
  implements Runnable
{
  QfileLocalFileDocTabView$2(QfileLocalFileDocTabView paramQfileLocalFileDocTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = QfileLocalFileDocTabView.a(this.this$0, this.a.d());
    if (!this.this$0.c.containsKey(localObject)) {
      this.this$0.c.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.c.get(localObject);
    if (((List)localObject).contains(this.a) == true) {}
    do
    {
      return;
      ((List)localObject).add(this.a);
      this.this$0.i();
    } while (this.this$0.a.size() != 1);
    this.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.2
 * JD-Core Version:    0.7.0.1
 */