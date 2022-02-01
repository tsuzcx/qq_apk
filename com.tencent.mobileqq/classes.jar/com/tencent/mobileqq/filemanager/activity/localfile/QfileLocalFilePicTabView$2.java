package com.tencent.mobileqq.filemanager.activity.localfile;

import aunj;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFilePicTabView$2
  implements Runnable
{
  QfileLocalFilePicTabView$2(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    if (!this.this$0.c.containsKey(localObject)) {
      this.this$0.c.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.c.get(this.a.a());
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    int j = aunj.a((List)localObject, this.a.b());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, this.a);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.2
 * JD-Core Version:    0.7.0.1
 */