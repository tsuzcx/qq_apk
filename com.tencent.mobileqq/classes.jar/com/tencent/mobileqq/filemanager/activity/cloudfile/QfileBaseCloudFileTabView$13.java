package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class QfileBaseCloudFileTabView$13
  implements FMDialogUtil.FMDialogInterface
{
  QfileBaseCloudFileTabView$13(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    ((IQQFileEngine)QfileBaseCloudFileTabView.n(this.b).getRuntimeService(IQQFileEngine.class)).resume(this.a.nSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.13
 * JD-Core Version:    0.7.0.1
 */