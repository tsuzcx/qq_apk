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
    Object localObject = QfileLocalFileDocTabView.a(this.this$0, this.a.e());
    if (!this.this$0.l.containsKey(localObject)) {
      this.this$0.l.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.l.get(localObject);
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    ((List)localObject).add(this.a);
    this.this$0.i();
    if (this.this$0.v.size() == 1) {
      this.this$0.setSelect(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.2
 * JD-Core Version:    0.7.0.1
 */