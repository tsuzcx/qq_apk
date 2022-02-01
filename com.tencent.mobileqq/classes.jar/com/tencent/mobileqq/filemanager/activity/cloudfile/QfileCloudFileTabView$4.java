package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class QfileCloudFileTabView$4
  implements Runnable
{
  QfileCloudFileTabView$4(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void run()
  {
    this.this$0.b.clear();
    Iterator localIterator = this.this$0.i.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      String str = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(localWeiYunFileInfo.e);
      if (!this.this$0.b.containsKey(str)) {
        this.this$0.b.put(str, new ArrayList());
      }
      ((List)this.this$0.b.get(str)).add(localWeiYunFileInfo);
    }
    this.this$0.i();
    this.this$0.setSelect(0);
    this.this$0.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.4
 * JD-Core Version:    0.7.0.1
 */