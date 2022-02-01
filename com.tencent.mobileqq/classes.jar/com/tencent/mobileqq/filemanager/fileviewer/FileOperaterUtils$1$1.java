package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class FileOperaterUtils$1$1
  implements FMDialogUtil.FMDialogInterface
{
  FileOperaterUtils$1$1(FileOperaterUtils.1 param1) {}
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.getFileManagerEngine().a(this.a.a, null, localQQAppInterface.getAccount(), 0, false);
    FileManagerUtil.a(this.a.a);
    FMToastUtil.d(QBaseActivity.sTopActivity.getString(2131889761));
    if ((this.a.b != null) && (this.a.b.g())) {
      FileManagerUtil.a(localQQAppInterface, this.a.c);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.1.1
 * JD-Core Version:    0.7.0.1
 */