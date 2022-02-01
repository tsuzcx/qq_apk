package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileCloudFileTabView$5
  implements Runnable
{
  public void run()
  {
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(this.a.e);
    if (!this.this$0.b.containsKey(localObject)) {
      this.this$0.b.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.b.get(localObject);
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    ((List)localObject).add(0, this.a);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.5
 * JD-Core Version:    0.7.0.1
 */