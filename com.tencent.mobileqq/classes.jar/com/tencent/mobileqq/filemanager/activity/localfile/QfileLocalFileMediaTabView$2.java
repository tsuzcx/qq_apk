package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFileMediaTabView$2
  implements Runnable
{
  QfileLocalFileMediaTabView$2(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = QQFileManagerUtil.b(this.a.l());
    if (!this.this$0.l.containsKey(localObject)) {
      this.this$0.l.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.l.get(localObject);
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    ((List)localObject).add(0, this.a);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.2
 * JD-Core Version:    0.7.0.1
 */