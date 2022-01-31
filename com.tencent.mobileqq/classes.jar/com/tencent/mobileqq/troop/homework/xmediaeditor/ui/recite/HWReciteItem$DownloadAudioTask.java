package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import bbzr;
import bhow;
import bjyr;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<bbzr> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, bbzr parambbzr)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambbzr);
  }
  
  public void run()
  {
    bbzr localbbzr = (bbzr)this.b.get();
    if (localbbzr != null)
    {
      localbbzr.d = bjyr.a(localbbzr.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbbzr;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */