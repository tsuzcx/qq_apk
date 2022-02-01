package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;

final class QQFileManagerUtilImpl$2
  implements FMDialogUtil.FMDialogInterface
{
  QQFileManagerUtilImpl$2(FileManagerEntity paramFileManagerEntity, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void a()
  {
    QQFileManagerUtilImpl.c(this.a.nSessionId);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).resumeByFileManagerEngine(this.b, this.a.nSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.2
 * JD-Core Version:    0.7.0.1
 */