package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.qroute.QRoute;

class QfileBaseRecentFileTabView$6$1
  implements FMDialogUtil.FMDialogInterface
{
  QfileBaseRecentFileTabView$6$1(QfileBaseRecentFileTabView.6 param6, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    this.b.a.C.A().aa();
    if (this.a.getCloudType() == 0)
    {
      ((IQQFileEngine)QfileBaseRecentFileTabView.m(this.b.a).getRuntimeService(IQQFileEngine.class)).recvOnLineFile(this.a.nSessionId);
      return;
    }
    if (this.a.getCloudType() == 6)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).downloadDatalineFile(this.a);
      return;
    }
    ((IQQFileEngine)QfileBaseRecentFileTabView.n(this.b.a).getRuntimeService(IQQFileEngine.class)).reviceFile(this.a);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.6.1
 * JD-Core Version:    0.7.0.1
 */