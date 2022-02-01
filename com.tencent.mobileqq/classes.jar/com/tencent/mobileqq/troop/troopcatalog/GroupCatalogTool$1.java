package com.tencent.mobileqq.troop.troopcatalog;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class GroupCatalogTool$1
  extends DownloadListener
{
  GroupCatalogTool$1(GroupCatalogTool paramGroupCatalogTool, File paramFile, GroupCatalogTool.GetChoiceListCallback paramGetChoiceListCallback) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    int i;
    if ((paramDownloadTask.c == 0) && (this.a.exists()) && (this.c.b(MobileQQ.getContext())) && (this.c.d(MobileQQ.getContext())))
    {
      this.c.a(MobileQQ.getContext(), System.currentTimeMillis());
      paramDownloadTask = this.b;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(true);
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((i == 0) && (this.b != null))
    {
      QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
      this.b.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool.1
 * JD-Core Version:    0.7.0.1
 */