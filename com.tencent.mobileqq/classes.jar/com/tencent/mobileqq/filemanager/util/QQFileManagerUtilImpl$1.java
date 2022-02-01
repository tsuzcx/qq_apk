package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;

final class QQFileManagerUtilImpl$1
  implements Runnable
{
  QQFileManagerUtilImpl$1(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).createThumbWithOrig(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */