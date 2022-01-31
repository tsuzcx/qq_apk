package com.tencent.mobileqq.filemanager.activity.localfile;

import arni;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFileMediaTabView$3
  implements Runnable
{
  QfileLocalFileMediaTabView$3(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = arni.a(this.a.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.3
 * JD-Core Version:    0.7.0.1
 */