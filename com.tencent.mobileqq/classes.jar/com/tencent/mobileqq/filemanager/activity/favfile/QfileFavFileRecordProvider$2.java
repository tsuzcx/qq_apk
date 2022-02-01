package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
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
    long l = ((IQQFileEngine)QfileFavFileRecordProvider.g(this.this$0).getRuntimeService(IQQFileEngine.class)).favProxyGetGettedPartList(QfileFavFileRecordProvider.d(this.this$0), localArrayList);
    Object localObject = QfileFavFileRecordProvider.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QfileFavFileRecordProvider.b);
    localStringBuilder.append("get favList timeout!!! gettedsize:");
    localStringBuilder.append(localArrayList.size());
    localStringBuilder.append(" nextTimestamp:");
    localStringBuilder.append(l);
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    if (localArrayList.size() > 0)
    {
      localObject = new QfileFavFileRecordProvider.FileRecordGroup();
      this.this$0.a(localArrayList, (QfileFavFileRecordProvider.FileRecordGroup)localObject);
      this.this$0.a((QfileFavFileRecordProvider.FileRecordGroup)localObject);
    }
    ((IQQFileEngine)QfileFavFileRecordProvider.g(this.this$0).getRuntimeService(IQQFileEngine.class)).favProxyCancelGetFileList(QfileFavFileRecordProvider.d(this.this$0));
    QfileFavFileRecordProvider.a(this.this$0, l);
    QfileFavFileRecordProvider.b(this.this$0);
    QfileFavFileRecordProvider.h(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(65535) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2
 * JD-Core Version:    0.7.0.1
 */