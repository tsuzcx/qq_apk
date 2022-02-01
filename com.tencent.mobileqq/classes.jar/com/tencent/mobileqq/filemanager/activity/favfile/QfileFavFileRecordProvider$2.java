package com.tencent.mobileqq.filemanager.activity.favfile;

import atcb;
import atch;
import athn;
import atke;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QfileFavFileRecordProvider$2
  implements Runnable
{
  public QfileFavFileRecordProvider$2(atcb paramatcb) {}
  
  public void run()
  {
    if (!atcb.a(this.this$0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = atcb.a(this.this$0).getFileManagerEngine().a().a(atcb.a(this.this$0), localArrayList);
    QLog.e(atcb.a, 1, atcb.b + "get favList timeout!!! gettedsize:" + localArrayList.size() + " nextTimestamp:" + l);
    if (localArrayList.size() > 0)
    {
      atch localatch = new atch(this.this$0);
      this.this$0.a(localArrayList, localatch);
      this.this$0.a(localatch);
    }
    atcb.a(this.this$0).getFileManagerEngine().a().a(atcb.a(this.this$0));
    atcb.a(this.this$0, l);
    atcb.a(this.this$0);
    atcb.d(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(65535) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2
 * JD-Core Version:    0.7.0.1
 */