package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFileOtherTabView$2
  implements Runnable
{
  QfileLocalFileOtherTabView$2(QfileLocalFileOtherTabView paramQfileLocalFileOtherTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a.d());
    if (!this.this$0.c.containsKey(localObject)) {
      this.this$0.c.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.c.get(localObject);
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    ((List)localObject).add(0, this.a);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.2
 * JD-Core Version:    0.7.0.1
 */