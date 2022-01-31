package com.tencent.mobileqq.filemanager.activity.recentfile;

import aroy;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileRecentTencentDocFileTabView$2
  implements Runnable
{
  QfileRecentTencentDocFileTabView$2(QfileRecentTencentDocFileTabView paramQfileRecentTencentDocFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    Object localObject = aroy.a(this.a.srvTime);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTencentDocFileTabView.2
 * JD-Core Version:    0.7.0.1
 */