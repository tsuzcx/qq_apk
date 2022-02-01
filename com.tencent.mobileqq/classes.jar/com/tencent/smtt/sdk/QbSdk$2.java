package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.smtt.utils.TbsLog;

final class QbSdk$2
  extends Thread
{
  QbSdk$2(Context paramContext, Handler paramHandler) {}
  
  public void run()
  {
    int i = n.a().a(true, this.a);
    TbsDownloader.setAppContext(this.a);
    TbsLog.i("QbSdk", "QbSdk preinit ver is " + i);
    if (i == 0) {
      n.a().b(this.a, true);
    }
    TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
    d.a(true).a(this.a, false, false, null);
    v localv = v.a();
    localv.a(this.a, null);
    boolean bool = localv.b();
    this.b.sendEmptyMessage(3);
    if (!bool)
    {
      this.b.sendEmptyMessage(2);
      return;
    }
    this.b.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.2
 * JD-Core Version:    0.7.0.1
 */