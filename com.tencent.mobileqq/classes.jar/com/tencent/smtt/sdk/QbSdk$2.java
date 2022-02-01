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
    int i = p.a().a(true, this.a);
    TbsDownloader.setAppContext(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QbSdk preinit ver is ");
    ((StringBuilder)localObject).append(i);
    TbsLog.i("QbSdk", ((StringBuilder)localObject).toString());
    localObject = p.a();
    Context localContext = this.a;
    if (f.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((p)localObject).b(localContext, bool);
    TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
    f.a(true).a(this.a, false, false, null);
    localObject = x.a();
    ((x)localObject).a(this.a, null);
    boolean bool = ((x)localObject).b();
    this.b.sendEmptyMessage(3);
    if (!bool)
    {
      this.b.sendEmptyMessage(2);
      return;
    }
    this.b.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.2
 * JD-Core Version:    0.7.0.1
 */