package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQFileManagerUtilImpl$19$1
  implements Runnable
{
  QQFileManagerUtilImpl$19$1(QQFileManagerUtilImpl.19 param19, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    String str = this.a.getFilePath();
    this.this$0.b.strFileSha3 = QQFileManagerUtilImpl.a(QQFileManagerUtilImpl.a(str));
    QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, set file download sucessed!");
    this.this$0.b.status = 1;
    this.this$0.b.cloudType = 3;
    this.this$0.b.setFilePath(this.a.getFilePath());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).updateFileEntity(this.this$0.a, this.this$0.b);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).notifyItemStatus(this.this$0.a, this.this$0.b.uniseq, this.this$0.b.nSessionId, this.this$0.b.peerUin, this.this$0.b.peerType, 11, new Object[] { this.this$0.b.getFilePath(), Long.valueOf(this.this$0.b.fileSize), Boolean.valueOf(true), "" }, 0, null);
    if (this.this$0.c != null) {
      this.this$0.c.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.19.1
 * JD-Core Version:    0.7.0.1
 */