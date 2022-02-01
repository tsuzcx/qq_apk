package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

final class FileViewerFacade$1
  implements FMDialogUtil.FMDialogInterface
{
  FileViewerFacade$1(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, IFileBrowser paramIFileBrowser) {}
  
  public void a()
  {
    Object localObject1 = FileManagerUtil.b(this.a);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("file maybe resoved ,recreateFilePath[");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("]");
      QLog.i("<FileAssistant>FileViewerFacade", 2, ((StringBuilder)localObject2).toString());
    }
    FileUtils.rename(this.b, (String)localObject1);
    this.c.fileName = FileManagerUtil.a((String)localObject1);
    this.c.setFilePath((String)localObject1);
    Object localObject2 = this.c;
    ((FileManagerEntity)localObject2).nFileType = FileManagerUtil.c(((FileManagerEntity)localObject2).getFilePath());
    this.d.getFileManagerDataCenter().c(this.c);
    localObject2 = this.d.getFileManagerDataCenter().a(this.b);
    if (localObject2 != null)
    {
      ((FileManagerEntity)localObject2).setFilePath((String)localObject1);
      ((FileManagerEntity)localObject2).fileName = this.c.fileName;
      this.d.getFileManagerDataCenter().c((FileManagerEntity)localObject2);
      localObject1 = TroopFileTransferManager.a(this.d, ((FileManagerEntity)localObject2).TroopUin);
      if (localObject1 != null) {
        ((TroopFileTransferManager)localObject1).a(((FileManagerEntity)localObject2).strTroopFileID, this.c.fileName);
      }
    }
    FileManagerUtil.b(this.e, this.c.getFilePath());
    localObject1 = this.f;
    if (localObject1 != null) {
      ((IFileBrowser)localObject1).b();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade.1
 * JD-Core Version:    0.7.0.1
 */