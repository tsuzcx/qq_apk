package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import benq;
import bjng;
import bkxu;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<benq> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, benq parambenq)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambenq);
  }
  
  public void run()
  {
    benq localbenq = (benq)this.b.get();
    if (localbenq != null)
    {
      localbenq.d = bkxu.a(localbenq.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbenq;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */