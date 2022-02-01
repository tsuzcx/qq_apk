package com.tencent.mobileqq.filemanager.activity.favfile;

import asvi;
import asvo;
import aszd;
import atbt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QfileFavFileRecordProvider$2
  implements Runnable
{
  public QfileFavFileRecordProvider$2(asvi paramasvi) {}
  
  public void run()
  {
    if (!asvi.a(this.this$0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = asvi.a(this.this$0).a().a().a(asvi.a(this.this$0), localArrayList);
    QLog.e(asvi.a, 1, asvi.b + "get favList timeout!!! gettedsize:" + localArrayList.size() + " nextTimestamp:" + l);
    if (localArrayList.size() > 0)
    {
      asvo localasvo = new asvo(this.this$0);
      this.this$0.a(localArrayList, localasvo);
      this.this$0.a(localasvo);
    }
    asvi.a(this.this$0).a().a().a(asvi.a(this.this$0));
    asvi.a(this.this$0, l);
    asvi.a(this.this$0);
    asvi.d(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(65535) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2
 * JD-Core Version:    0.7.0.1
 */