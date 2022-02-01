package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileRecentAllFileTabView$2
  implements Runnable
{
  QfileRecentAllFileTabView$2(QfileRecentAllFileTabView paramQfileRecentAllFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(this.a.srvTime);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView.2
 * JD-Core Version:    0.7.0.1
 */