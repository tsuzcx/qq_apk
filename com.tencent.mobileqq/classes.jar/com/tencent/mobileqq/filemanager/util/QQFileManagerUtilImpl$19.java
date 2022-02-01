package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

final class QQFileManagerUtilImpl$19
  implements Runnable
{
  QQFileManagerUtilImpl$19(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, QQFileManagerUtil.CheckResult paramCheckResult) {}
  
  public void run()
  {
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).queryFileManagerEntityByNameAndSize(this.a, this.b.fileName, this.b.fileSize);
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("find file size[");
      localStringBuilder1.append(((List)localObject).size());
      localStringBuilder1.append("]");
      QLog.i("CHECK_FILE_EXISTED", 1, localStringBuilder1.toString());
    }
    StringBuilder localStringBuilder1 = null;
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      StringBuilder localStringBuilder2;
      for (;;)
      {
        localObject = localStringBuilder1;
        if (!localIterator.hasNext()) {
          break label329;
        }
        localObject = (FileManagerEntity)localIterator.next();
        if (localObject != this.b)
        {
          long l = new VFSFile(((FileManagerEntity)localObject).getFilePath()).lastModified();
          if (((FileManagerEntity)localObject).localModifyTime == l) {
            break;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("find exsited file, but local modified,localModifyTime[");
          localStringBuilder2.append(((FileManagerEntity)localObject).localModifyTime);
          localStringBuilder2.append("], fileModified[");
          localStringBuilder2.append(l);
          localStringBuilder2.append("]");
          QLog.i("CHECK_FILE_EXISTED", 1, localStringBuilder2.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((FileManagerEntity)localObject).fileName);
        localStringBuilder2.append(" findFile 10md5[");
        localStringBuilder2.append(((FileManagerEntity)localObject).str10Md5);
        localStringBuilder2.append("], sha3[");
        localStringBuilder2.append(((FileManagerEntity)localObject).strFileSha3);
        localStringBuilder2.append("], md5[");
        localStringBuilder2.append(((FileManagerEntity)localObject).strFileMd5);
        localStringBuilder2.append("]");
        QLog.i("CHECK_FILE_EXISTED", 1, localStringBuilder2.toString());
      }
    } while (!QQFileManagerUtilImpl.a((FileManagerEntity)localObject, this.b));
    label329:
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cann't find exsited file,entity[");
        ((StringBuilder)localObject).append(this.b.fileName);
        ((StringBuilder)localObject).append("]");
        QLog.i("CHECK_FILE_EXISTED", 1, ((StringBuilder)localObject).toString());
      }
      localObject = this.c;
      if (localObject != null) {
        ((QQFileManagerUtil.CheckResult)localObject).a(false);
      }
      return;
    }
    QQFileManagerUtil.FileExecutor.a().execute(new QQFileManagerUtilImpl.19.1(this, (FileManagerEntity)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.19
 * JD-Core Version:    0.7.0.1
 */