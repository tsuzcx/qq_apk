package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QfileFavFileRecordProvider$2
  implements Runnable
{
  QfileFavFileRecordProvider$2(QfileFavFileRecordProvider paramQfileFavFileRecordProvider) {}
  
  public void run()
  {
    if (!QfileFavFileRecordProvider.a(this.this$0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = QfileFavFileRecordProvider.a(this.this$0).getFileManagerEngine().a().getGettedPartList(QfileFavFileRecordProvider.a(this.this$0), localArrayList);
    QLog.e(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "get favList timeout!!! gettedsize:" + localArrayList.size() + " nextTimestamp:" + l);
    if (localArrayList.size() > 0)
    {
      QfileFavFileRecordProvider.FileRecordGroup localFileRecordGroup = new QfileFavFileRecordProvider.FileRecordGroup(this.this$0);
      this.this$0.a(localArrayList, localFileRecordGroup);
      this.this$0.a(localFileRecordGroup);
    }
    QfileFavFileRecordProvider.a(this.this$0).getFileManagerEngine().a().cancelGetFileList(QfileFavFileRecordProvider.a(this.this$0));
    QfileFavFileRecordProvider.a(this.this$0, l);
    QfileFavFileRecordProvider.a(this.this$0);
    QfileFavFileRecordProvider.d(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(65535) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2
 * JD-Core Version:    0.7.0.1
 */