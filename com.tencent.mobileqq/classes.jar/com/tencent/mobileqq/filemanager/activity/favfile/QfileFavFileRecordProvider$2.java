package com.tencent.mobileqq.filemanager.activity.favfile;

import arxv;
import aryb;
import asdg;
import asfy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QfileFavFileRecordProvider$2
  implements Runnable
{
  public QfileFavFileRecordProvider$2(arxv paramarxv) {}
  
  public void run()
  {
    if (!arxv.a(this.this$0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = arxv.a(this.this$0).getFileManagerEngine().a().a(arxv.a(this.this$0), localArrayList);
    QLog.e(arxv.a, 1, arxv.b + "get favList timeout!!! gettedsize:" + localArrayList.size() + " nextTimestamp:" + l);
    if (localArrayList.size() > 0)
    {
      aryb localaryb = new aryb(this.this$0);
      this.this$0.a(localArrayList, localaryb);
      this.this$0.a(localaryb);
    }
    arxv.a(this.this$0).getFileManagerEngine().a().a(arxv.a(this.this$0));
    arxv.a(this.this$0, l);
    arxv.a(this.this$0);
    arxv.d(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(65535) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2
 * JD-Core Version:    0.7.0.1
 */