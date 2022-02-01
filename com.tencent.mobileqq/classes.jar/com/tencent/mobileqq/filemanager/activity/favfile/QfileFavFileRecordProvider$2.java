package com.tencent.mobileqq.filemanager.activity.favfile;

import atlm;
import atls;
import atqx;
import atto;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QfileFavFileRecordProvider$2
  implements Runnable
{
  public QfileFavFileRecordProvider$2(atlm paramatlm) {}
  
  public void run()
  {
    if (!atlm.a(this.this$0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = atlm.a(this.this$0).a().a().a(atlm.a(this.this$0), localArrayList);
    QLog.e(atlm.a, 1, atlm.b + "get favList timeout!!! gettedsize:" + localArrayList.size() + " nextTimestamp:" + l);
    if (localArrayList.size() > 0)
    {
      atls localatls = new atls(this.this$0);
      this.this$0.a(localArrayList, localatls);
      this.this$0.a(localatls);
    }
    atlm.a(this.this$0).a().a().a(atlm.a(this.this$0));
    atlm.a(this.this$0, l);
    atlm.a(this.this$0);
    atlm.d(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(65535) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2
 * JD-Core Version:    0.7.0.1
 */