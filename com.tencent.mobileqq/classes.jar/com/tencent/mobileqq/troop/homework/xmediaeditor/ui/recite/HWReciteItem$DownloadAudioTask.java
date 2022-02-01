package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import bgei;
import blhq;
import bnsn;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<bgei> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, bgei parambgei)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambgei);
  }
  
  public void run()
  {
    bgei localbgei = (bgei)this.b.get();
    if (localbgei != null)
    {
      localbgei.d = bnsn.a(localbgei.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbgei;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */