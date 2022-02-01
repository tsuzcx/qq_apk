package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileRecentPicFileTabView$3
  implements Runnable
{
  QfileRecentPicFileTabView$3(QfileRecentPicFileTabView paramQfileRecentPicFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    Object localObject = QfileTimeUtils.a(this.a.srvTime);
    if (!this.this$0.a.containsKey(localObject)) {
      this.this$0.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.a.get(localObject);
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    ((List)localObject).add(0, this.a);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView.3
 * JD-Core Version:    0.7.0.1
 */